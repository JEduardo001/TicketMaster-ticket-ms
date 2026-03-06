package com.swSoftware.asientos.ticket_ms.application.usecase;

import com.swSoftware.asientos.ticket_ms.application.dto.ticket.DtoTicket;

import java.util.List;
import java.util.UUID;

public interface GetAllTicketsUseCase {
    List<DtoTicket> execute(UUID lastId, int limit);
}
