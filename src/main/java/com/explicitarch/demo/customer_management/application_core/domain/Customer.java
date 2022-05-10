package com.explicitarch.demo.customer_management.application_core.domain;

import com.explicitarch.demo.shared_kernel.domain.aggregate.AggregateRoot;
import com.explicitarch.demo.shared_kernel.domain.value_object.CustomerId;

public class Customer extends AggregateRoot {

    CustomerId id;
    CustomerName name;
    private Customer(CustomerId id, CustomerName name){
        this.id = id;
        this.name = name;
    }

    public static Customer create(CustomerId id, CustomerName name)
    {
        Customer customer = new Customer(id, name);
        // Method from the AggregateRoot parent class.
        customer.record(new CustomerCreatedDomainEvent(id.toString()));

        return customer;
    }

    public static Customer load(CustomerId id, CustomerName name){
        return new Customer(id, name);
    }

    public void delete(){
        System.out.println(id.value().toString());
        this.record(new CustomerDeletedDomainEvent(id.value().toString()));
    }

}
