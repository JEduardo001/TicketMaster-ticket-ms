package com.swSoftware.asientos.ticket_ms.domain.service.ticket;

import com.swSoftware.asientos.ticket_ms.application.dto.ticket.DtoTicket;
import com.swSoftware.asientos.ticket_ms.application.usecase.GetAllTicketsUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class GetAllTicketService implements GetAllTicketsUseCase {


    @Override
    public List<DtoTicket> execute(UUID lastId, int limit) {
        return List.of();
    }
}
