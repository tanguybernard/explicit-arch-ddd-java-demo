package com.explicitarch.demo.customer_management.infrastructure.jpa;

import com.explicitarch.demo.customer_management.application_core.domain.Customer;
import com.explicitarch.demo.customer_management.application_core.domain.CustomerName;
import com.explicitarch.demo.freelancer_management.application_core.freelancer.domain.Freelancer;
import com.explicitarch.demo.freelancer_management.application_core.freelancer.domain.FreelancerId;
import com.explicitarch.demo.freelancer_management.infrastructure.jpa.freelancer.FreelancerEntity;
import com.explicitarch.demo.shared_kernel.domain.value_object.Address;
import com.explicitarch.demo.shared_kernel.domain.value_object.CustomerId;

public class CustomerMapper {

    Customer toDomain(CustomerEntity customer){

        return Customer.load(
                new CustomerId(customer.id),
                new CustomerName(customer.name)
        );

    }
}
