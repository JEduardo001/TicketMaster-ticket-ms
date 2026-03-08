package com.swSoftware.asientos.ticket_ms.infrastructure.adapter.input.kafka;

import com.app.events.ReservedSeatEvent;
import com.swSoftware.asientos.ticket_ms.domain.port.ITicketService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
@Slf4j
public class KafkaConsumer {

    private final ITicketService iTicketService;

    @KafkaListener(
            topics = "dev.seat-ms.reserved-seats.v1",
            groupId = "seat-ms.reserved-seat.v1"    )
    public void responseSeatsReservedToCreateTicket(ReservedSeatEvent request, @Header(value = "CORRELATION_HEADER",required = false) String correlationId)
           {

        iTicketService.createTicket(request);
    }

}
