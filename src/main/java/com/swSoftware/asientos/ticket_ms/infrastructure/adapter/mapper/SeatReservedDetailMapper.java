package com.swSoftware.asientos.ticket_ms.infrastructure.adapter.mapper;

import com.swSoftware.asientos.ticket_ms.application.dto.DtoSeatReservedDetail.DtoSeatReservedDetail;
import com.swSoftware.asientos.ticket_ms.domain.model.SeatReservedDetailModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SeatReservedDetailMapper {
    DtoSeatReservedDetail toDto(SeatReservedDetailModel request);
}
