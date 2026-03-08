package com.swSoftware.asientos.ticket_ms.infrastructure.adapter.input.rest;


import com.swSoftware.asientos.ticket_ms.application.dto.responseApi.DtoResponseApi;
import com.swSoftware.asientos.ticket_ms.application.dto.ticket.DtoUpdateTicket;
import com.swSoftware.asientos.ticket_ms.application.usecase.GetAllTicketsUseCase;
import com.swSoftware.asientos.ticket_ms.application.usecase.GetTicketUseCase;
import com.swSoftware.asientos.ticket_ms.application.usecase.UpdateTicketUseCase;
import io.swagger.v3.oas.annotations.Parameter;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.UUID;

import static com.swSoftware.asientos.ticket_ms.domain.common.HeaderConstants.CORRELATION_KEY;


@RestController
@RequestMapping("/api/v1/ticket")
@AllArgsConstructor
public class TicketController {

    private final UpdateTicketUseCase updateTicketUseCase;
    private final GetTicketUseCase getTicketUseCase;
    private final GetAllTicketsUseCase getAllTicketsUseCase;

    @PutMapping()
    public ResponseEntity<DtoResponseApi> updateSeat(@Valid @RequestBody DtoUpdateTicket request){
        return ResponseEntity.status(HttpStatus.CREATED).body(DtoResponseApi.builder()
                .status(HttpStatus.CREATED.value())
                .message("Ticket updated")
                .idCorrelation(MDC.get(CORRELATION_KEY.toString()))
                .data(updateTicketUseCase.execute(request))
                .build()
        );
    }

    @GetMapping("/{idTicket}")
    public ResponseEntity<DtoResponseApi> getSeat(@Parameter(description = "UUID of the seat") @PathVariable UUID idTicket){
        return ResponseEntity.status(HttpStatus.OK).body(DtoResponseApi.builder()
                .status(HttpStatus.OK.value())
                .idCorrelation(MDC.get(CORRELATION_KEY.toString()))
                .message("Ticket obtained")
                .data(getTicketUseCase.execute(idTicket))
                .build()
        );
    }

    @GetMapping()
    public ResponseEntity<DtoResponseApi> getAllSeat(
            @Parameter(description = "UUID cursor for pagination") @RequestParam(required = false) UUID lastId,
            @Parameter(description = "Page size limit") @RequestParam(defaultValue = "160") int limit
    ) {
        return ResponseEntity.ok(DtoResponseApi.builder()
                .status(HttpStatus.OK.value())
                .idCorrelation(MDC.get(CORRELATION_KEY.toString()))
                .message("Tickets obtained")
                .data(getAllTicketsUseCase.execute(lastId, limit))
                .build());
    }
}
