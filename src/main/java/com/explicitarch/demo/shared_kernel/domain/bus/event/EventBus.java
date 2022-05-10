package com.explicitarch.demo.shared_kernel.domain.bus.event;

import java.util.List;

public interface EventBus {

    void publish(List<DomainEvent> events);

}
