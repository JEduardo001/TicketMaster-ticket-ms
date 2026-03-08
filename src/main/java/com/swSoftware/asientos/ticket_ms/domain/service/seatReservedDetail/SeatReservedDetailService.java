package com.swSoftware.asientos.ticket_ms.domain.service.seatReservedDetail;

import com.swSoftware.asientos.ticket_ms.domain.model.SeatReservedDetailModel;
import com.swSoftware.asientos.ticket_ms.domain.port.ISeatReservedDetailService;
import com.swSoftware.asientos.ticket_ms.infrastructure.adapter.output.persistence.SeatReservedDetailRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class SeatReservedDetailService implements ISeatReservedDetailService {

    private final SeatReservedDetailRepository seatReservedDetailRepository;

    @Override
    @Transactional
    public List<SeatReservedDetailModel> saveSeatsDetail(List<SeatReservedDetailModel> request){
        return seatReservedDetailRepository.saveAll(request);
    };


}
