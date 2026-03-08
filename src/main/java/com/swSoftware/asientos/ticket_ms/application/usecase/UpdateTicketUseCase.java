package com.swSoftware.asientos.ticket_ms.application.usecase;

import com.swSoftware.asientos.ticket_ms.application.dto.ticket.DtoTicket;
import com.swSoftware.asientos.ticket_ms.application.dto.ticket.DtoUpdateTicket;

import java.util.UUID;

public interface UpdateTicketUseCase {
    DtoTicket execute(DtoUpdateTicket request);
}
