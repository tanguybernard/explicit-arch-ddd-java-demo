package com.explicitarch.demo.shared_kernel.domain.bus.event;

import java.util.Date;
import java.util.UUID;

/**
 * DomainEvent permet d'implemeter explicitement des effets secondaires sur plusieurs aggrégats.
 */
public interface DomainEvent {

    Date occurredOn = new Date();
    UUID getAggregateId();

}
