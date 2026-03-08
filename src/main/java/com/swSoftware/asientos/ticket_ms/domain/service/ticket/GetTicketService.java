package com.swSoftware.asientos.ticket_ms.domain.service.ticket;

import com.swSoftware.asientos.ticket_ms.application.dto.ticket.DtoTicket;
import com.swSoftware.asientos.ticket_ms.application.usecase.GetTicketUseCase;
import com.swSoftware.asientos.ticket_ms.infrastructure.adapter.exception.ticket.ExceptionTicketNotFound;
import com.swSoftware.asientos.ticket_ms.infrastructure.adapter.mapper.TicketMapper;
import com.swSoftware.asientos.ticket_ms.infrastructure.adapter.output.persistence.TicketRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class GetTicketService implements GetTicketUseCase {

    private final TicketRepository ticketRepository;
    private final TicketMapper ticketMapper;

    @Override
    public DtoTicket execute(UUID id) {
        return ticketMapper.toDto(ticketRepository.findById(id).orElseThrow(ExceptionTicketNotFound::new));
    }
}
