package com.swSoftware.asientos.ticket_ms.application.dto.ticket;

import com.swSoftware.asientos.ticket_ms.application.dto.DtoSeatReservedDetail.DtoSeatReservedDetail;
import com.swSoftware.asientos.ticket_ms.domain.model.SeatReservedDetailModel;
import com.swSoftware.asientos.ticket_ms.domain.status.StatusTicket;
import jakarta.persistence.*;
import lombok.Builder;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Builder
public record DtoTicket(
        UUID id,
        List<DtoSeatReservedDetail> seatsReserved,
        StatusTicket status,
        Instant createAt,
        Instant deletedAt
) {
}