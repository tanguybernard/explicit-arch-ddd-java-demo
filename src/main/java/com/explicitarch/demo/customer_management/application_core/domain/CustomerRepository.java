package com.explicitarch.demo.customer_management.application_core.domain;


import com.explicitarch.demo.shared_kernel.domain.value_object.CustomerId;

public interface CustomerRepository {

    Customer findById(CustomerId customerId);

    void delete(CustomerId customerId);

}