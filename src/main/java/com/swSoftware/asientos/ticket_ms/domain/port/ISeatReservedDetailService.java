package com.swSoftware.asientos.ticket_ms.domain.port;

import com.swSoftware.asientos.ticket_ms.domain.model.SeatReservedDetailModel;

import java.util.List;

public interface ISeatReservedDetailService {
    List<SeatReservedDetailModel> saveSeatsDetail(List<SeatReservedDetailModel> request);
}
