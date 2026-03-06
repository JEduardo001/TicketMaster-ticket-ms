package com.swSoftware.asientos.ticket_ms.domain.port;

public interface IOutboxEventService<T> {
    void saveEvent(T request,String nameTopic);
}
