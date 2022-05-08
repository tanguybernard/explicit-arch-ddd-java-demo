package com.explicitarch.demo.customer_management.application_core.domain;

import com.explicitarch.demo.shared_kernel.CustomerId;

public class Customer {

    CustomerId id;
    CustomerName name;
    public Customer(CustomerId id, CustomerName name){
        this.id = id;
        this.name = name;
    }

}
