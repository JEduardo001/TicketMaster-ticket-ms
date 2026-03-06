package com.swSoftware.asientos.ticket_ms.infrastructure.adapter.output.persistence;

import com.swSoftware.asientos.seat_ms.domain.status.StatusEvent;
import com.swSoftware.asientos.ticket_ms.domain.model.OutboxEventModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface OutboxEventRepository extends JpaRepository<OutboxEventModel, UUID> {
    List<OutboxEventModel> findAllByStatus(StatusEvent status);
}