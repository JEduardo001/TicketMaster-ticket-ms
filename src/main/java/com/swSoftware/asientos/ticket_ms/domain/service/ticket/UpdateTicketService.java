package com.swSoftware.asientos.ticket_ms.domain.service.ticket;

import com.swSoftware.asientos.ticket_ms.application.dto.ticket.DtoTicket;
import com.swSoftware.asientos.ticket_ms.application.dto.ticket.DtoUpdateTicket;
import com.swSoftware.asientos.ticket_ms.application.usecase.UpdateTicketUseCase;
import com.swSoftware.asientos.ticket_ms.domain.model.TicketModel;
import com.swSoftware.asientos.ticket_ms.infrastructure.adapter.exception.ticket.ExceptionTicketNotFound;
import com.swSoftware.asientos.ticket_ms.infrastructure.adapter.mapper.TicketMapper;
import com.swSoftware.asientos.ticket_ms.infrastructure.adapter.output.persistence.TicketRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class UpdateTicketService implements UpdateTicketUseCase {

    private final TicketRepository ticketRepository;
    private final TicketMapper ticketMapper;

    @Override
    public DtoTicket execute(DtoUpdateTicket request) {
        TicketModel ticketModel = ticketRepository.findById(request.id()).orElseThrow(ExceptionTicketNotFound::new);
        ticketModel.setStatus(request.status());
        return ticketMapper.toDto(ticketRepository.save(ticketModel));
    }
}
