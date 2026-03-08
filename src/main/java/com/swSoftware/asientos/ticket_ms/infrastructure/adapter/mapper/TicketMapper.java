package com.swSoftware.asientos.ticket_ms.infrastructure.adapter.mapper;



import com.swSoftware.asientos.ticket_ms.application.dto.ticket.DtoTicket;
import com.swSoftware.asientos.ticket_ms.domain.model.TicketModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {SeatReservedDetailMapper.class})
public interface TicketMapper {
    DtoTicket toDto(TicketModel request);
}
