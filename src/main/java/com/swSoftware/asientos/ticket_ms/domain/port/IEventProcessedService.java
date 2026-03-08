package com.swSoftware.asientos.ticket_ms.domain.port;


import com.swSoftware.asientos.ticket_ms.domain.model.EventProcessedModel;

import java.util.UUID;

public interface IEventProcessedService {
    void saveEventProcessedAndFlush(EventProcessedModel request);
    boolean eventAlreadyProcessed(UUID id);
}

