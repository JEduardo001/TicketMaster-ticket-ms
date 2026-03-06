package com.swSoftware.asientos.ticket_ms.domain.exception.handler;

import org.slf4j.MDC;

import static com.swSoftware.asientos.ticket_ms.domain.common.HeaderConstants.CORRELATION_KEY;

public abstract class DomainExceptionHandler {

    private String getIdCorrelation(){
        return MDC.get(CORRELATION_KEY.toString());
    }




}

