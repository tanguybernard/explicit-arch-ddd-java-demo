package com.explicitarch.demo.shared_kernel.infrastructure.bus.event;

import com.explicitarch.demo.shared_kernel.domain.bus.event.DomainEvent;
import com.explicitarch.demo.shared_kernel.domain.bus.event.EventBus;

import java.util.List;

public class InMemoryOutput implements EventBus {

    @Override
    public void publish(List<DomainEvent> events) {
        for (DomainEvent event: events) {
            //example: dispatch notification, email, message queue RabbitMq
            System.out.println(event.occurredOn);
        }
    }
}
