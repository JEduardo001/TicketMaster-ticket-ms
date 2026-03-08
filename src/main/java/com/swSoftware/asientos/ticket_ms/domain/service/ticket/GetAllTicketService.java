package com.swSoftware.asientos.ticket_ms.domain.service.ticket;

import com.swSoftware.asientos.ticket_ms.application.dto.page.DtoPage;
import com.swSoftware.asientos.ticket_ms.application.dto.ticket.DtoTicket;
import com.swSoftware.asientos.ticket_ms.application.usecase.GetAllTicketsUseCase;
import com.swSoftware.asientos.ticket_ms.domain.model.TicketModel;
import com.swSoftware.asientos.ticket_ms.infrastructure.adapter.mapper.TicketMapper;
import com.swSoftware.asientos.ticket_ms.infrastructure.adapter.output.persistence.TicketRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GetAllTicketService implements GetAllTicketsUseCase {

    private final TicketRepository ticketRepository;
    private final TicketMapper ticketMapper;

    @Override
    public DtoPage execute(UUID lastId, int limit) {
        Pageable limitProvider = PageRequest.of(0, limit);

        List<TicketModel> payments = ticketRepository.findNextPage(lastId, limitProvider);
        List<DtoTicket> paymentsDto = payments.stream().map(ticketMapper::toDto).collect(Collectors.toList());
        String nextCursor = payments.isEmpty() ? null : payments.get(payments.size() - 1).getId().toString();

        return new DtoPage(nextCursor,payments.size() == limit,paymentsDto);
    }
}
