package com.swSoftware.asientos.ticket_ms.application.dto.DtoSeatReservedDetail;

import lombok.Builder;

import java.time.Instant;
import java.util.UUID;

@Builder
public record DtoSeatReservedDetail(
        UUID id,
        UUID idSeat,
        String section,
        String status,
        Integer seatNumber,
        Instant createAt

) {
}
