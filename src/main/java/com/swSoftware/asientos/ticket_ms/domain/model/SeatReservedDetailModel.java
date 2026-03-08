package com.swSoftware.asientos.ticket_ms.domain.model;

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
@Table(name = "seat_rserved_detail_table")
public class SeatReservedDetailModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private UUID idSeat;
    private String section;
    private String status;
    private Integer seatNumber;
    private Instant createAt;
}
