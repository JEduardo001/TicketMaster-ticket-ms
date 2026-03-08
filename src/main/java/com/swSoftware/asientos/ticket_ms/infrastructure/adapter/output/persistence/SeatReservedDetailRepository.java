package com.swSoftware.asientos.ticket_ms.infrastructure.adapter.output.persistence;

import com.swSoftware.asientos.ticket_ms.domain.model.SeatReservedDetailModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SeatReservedDetailRepository extends JpaRepository<SeatReservedDetailModel, UUID> {
}

