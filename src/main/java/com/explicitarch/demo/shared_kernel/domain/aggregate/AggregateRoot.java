package com.explicitarch.demo.shared_kernel.domain.aggregate;

import com.explicitarch.demo.shared_kernel.domain.bus.event.DomainEvent;

import java.util.List;

public abstract class AggregateRoot {
    private List<DomainEvent> domainEvents;

    final public List<DomainEvent> pullDomainEvents() {
        List<DomainEvent> domainEvents = this.domainEvents;
        this.domainEvents = List.of();

        return domainEvents;
    }

    final protected void record(DomainEvent domainEvent) {

        this.domainEvents.add(domainEvent);

    }
}