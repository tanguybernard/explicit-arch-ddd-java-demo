package com.explicitarch.demo.customer_management.application_core.domain;

import com.explicitarch.demo.shared_kernel.domain.bus.event.DomainEvent;

import java.util.UUID;

public class CustomerCreatedDomainEvent implements DomainEvent {

    private UUID aggregateId;
    public CustomerCreatedDomainEvent(String aggregateId) {
        this.aggregateId = UUID.fromString(aggregateId);
    }


    //See
    // https://github.com/CodelyTV/php-ddd-example/blob/main/src/Mooc/Courses/Domain/CourseCreatedDomainEvent.php
    // https://github.com/ddd-by-examples/library/blob/master/src/main/java/io/pillopl/library/catalogue/BookInstanceAddedToCatalogue.java

    public static String eventName()
    {
        return "customer.created";
    }

    @Override
    public UUID getAggregateId() {
        return this.aggregateId;
    }
}
