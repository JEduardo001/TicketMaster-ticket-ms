package com.swSoftware.asientos.ticket_ms.domain.model;

import com.swSoftware.asientos.ticket_ms.domain.status.StatusTicket;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
@Table(name = "ticket_table")
public class TicketModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Enumerated(EnumType.STRING)
    private StatusTicket status;
    private Instant createAt;
    private Instant deletedAt;

}
