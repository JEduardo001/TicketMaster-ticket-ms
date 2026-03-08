package com.swSoftware.asientos.ticket_ms.domain.model;

import com.swSoftware.asientos.ticket_ms.domain.status.StatusTicket;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;
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
    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "seatReserved_id")
    private List<SeatReservedDetailModel> seatsReserved;
    @Enumerated(EnumType.STRING)
    private StatusTicket status;
    private Instant createAt;
    private Instant deletedAt;

}
