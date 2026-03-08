package com.swSoftware.asientos.ticket_ms.application.dto.ticket;

import com.swSoftware.asientos.ticket_ms.domain.status.StatusTicket;
import lombok.Builder;

import java.util.UUID;

@Builder
public record DtoUpdateTicket(
        UUID id,
        StatusTicket status
) {
}
