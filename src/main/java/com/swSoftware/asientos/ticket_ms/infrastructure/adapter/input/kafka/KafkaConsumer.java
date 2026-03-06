package com.swSoftware.asientos.ticket_ms.infrastructure.adapter.input.kafka;

import com.swSoftware.asientos.ticket_ms.domain.port.ITicketService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;
import com.app.events.ReserveEvent;


@Service
@AllArgsConstructor
@Slf4j
public class KafkaConsumer {



}

