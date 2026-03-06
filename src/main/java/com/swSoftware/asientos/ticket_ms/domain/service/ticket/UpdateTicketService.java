package com.swSoftware.asientos.ticket_ms.domain.service.ticket;

import com.swSoftware.asientos.ticket_ms.application.dto.ticket.DtoTicket;
import com.swSoftware.asientos.ticket_ms.application.dto.ticket.DtoUpdateTicket;
import com.swSoftware.asientos.ticket_ms.application.usecase.UpdateTicketUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class UpdateTicketService implements UpdateTicketUseCase {

    @Override
    public DtoTicket execute(UUID id, DtoUpdateTicket request) {
        return null;
    }
}
