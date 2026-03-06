package com.swSoftware.asientos.ticket_ms.application.usecase;

import com.swSoftware.asientos.ticket_ms.application.dto.ticket.DtoTicket;

import java.util.UUID;

public interface GetTicketUseCase {
    DtoTicket execute(UUID id);
}
