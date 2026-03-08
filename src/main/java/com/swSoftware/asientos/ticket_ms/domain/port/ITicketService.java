package com.swSoftware.asientos.ticket_ms.domain.port;

import com.app.events.ReservedSeatEvent;

public interface ITicketService {
    void createTicket(ReservedSeatEvent request);
}
