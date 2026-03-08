package com.swSoftware.asientos.ticket_ms.application.usecase;

import com.swSoftware.asientos.ticket_ms.application.dto.page.DtoPage;

import java.util.UUID;

public interface GetAllTicketsUseCase {
    DtoPage execute(UUID lastId, int limit);
}
