package com.swSoftware.asientos.ticket_ms.domain.service.ticket;

import com.app.events.CreateTicketEvent;
import com.app.events.ReservedSeatEvent;
import com.swSoftware.asientos.ticket_ms.domain.model.EventProcessedModel;
import com.swSoftware.asientos.ticket_ms.domain.model.SeatReservedDetailModel;
import com.swSoftware.asientos.ticket_ms.domain.model.TicketModel;
import com.swSoftware.asientos.ticket_ms.domain.port.IEventProcessedService;
import com.swSoftware.asientos.ticket_ms.domain.port.IOutboxEventService;
import com.swSoftware.asientos.ticket_ms.domain.port.ISeatReservedDetailService;
import com.swSoftware.asientos.ticket_ms.domain.port.ITicketService;
import com.swSoftware.asientos.ticket_ms.domain.status.StatusTicket;
import com.swSoftware.asientos.ticket_ms.infrastructure.adapter.output.persistence.TicketRepository;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.*;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import static com.swSoftware.asientos.ticket_ms.infrastructure.shared.LogMessages.MESSAGE_EVENT_ALREADY_PROCESSED;

@Service
@AllArgsConstructor
@Slf4j
public class GeneralTicketService implements ITicketService {

    private final TicketRepository ticketRepository;
    private final IEventProcessedService iEventProcessedService;
    private final IOutboxEventService iOutboxEventService;
    private final ISeatReservedDetailService iSeatReservedDetailService;
    private final String topic = "dev.ticket-ms.created-ticket.v1";

    private void saveOutboxEvent(CreateTicketEvent request, String topic){
        iOutboxEventService.saveEvent(request,topic);
    }

    private boolean saveEventProcessed(ReservedSeatEvent request){
       try{
           iEventProcessedService.saveEventProcessedAndFlush(EventProcessedModel.builder()
                   .id(request.getIdCorrelation())
                   .data(request.toString())
                   .createdAt(Instant.now())
                   .build());
           return true;
       }catch(DataIntegrityViolationException ex){
           log.warn(MESSAGE_EVENT_ALREADY_PROCESSED.toString());
            return false;
       }
    }

    @Transactional
    @Override
    public void createTicket(ReservedSeatEvent request){

        if (!saveEventProcessed(request)) {
            return;
        }

        List<SeatReservedDetailModel> seatsDetail = request.getSeats().stream().map(s ->
                    SeatReservedDetailModel.builder()
                            .idSeat(s.getIdSeat())
                            .section(s.getSection().toString())
                            .status(s.getStatus().toString())
                            .seatNumber(s.getSeatNumber())
                            .createAt(Instant.now())
                            .build()
                ).collect(Collectors.toList());

        iSeatReservedDetailService.saveSeatsDetail(seatsDetail);

        TicketModel ticket = ticketRepository.save(TicketModel.builder()
                        .status(StatusTicket.PAYMENT_PENDING_CONFIRMATION)
                        .createAt(Instant.now())
                        .seatsReserved(seatsDetail)
                .build());

        //create object event
        CreateTicketEvent createTicketEvent = CreateTicketEvent.newBuilder()
                .setIdCorrelation(request.getIdCorrelation())
                .setIdTicket(ticket.getId())
                .setIdUser(request.getIdUser())
                .setCreatedAt(Instant.now())
                .setStatus(ticket.getStatus().toString())
                .setSeats(request.getSeats())
                .build();

        saveOutboxEvent(createTicketEvent,topic);
    }
}