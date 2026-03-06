package com.swSoftware.asientos.ticket_ms.infrastructure.adapter.output.persistence;

import com.swSoftware.asientos.ticket_ms.domain.model.TicketModel;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface TicketRepository extends JpaRepository<TicketModel, UUID> {
    @Query("SELECT u FROM TicketModel u WHERE (:lastId IS NULL OR u.id > :lastId) ORDER BY u.id ASC")
    List<TicketModel> findNextPage(@Param("lastId") UUID lastId, Pageable pageable);
}
