package com.explicitarch.demo.customer_management.infrastructure.jpa;

import com.explicitarch.demo.customer_management.application_core.domain.Customer;
import com.explicitarch.demo.customer_management.application_core.domain.CustomerRepository;
import com.explicitarch.demo.shared_kernel.domain.value_object.CustomerId;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

public class CustomerJpaRepository implements CustomerRepository {

    private CustomerDao customerDao;
    private CustomerMapper customerMapper;

    public CustomerJpaRepository(CustomerDao customerDao, CustomerMapper customerMapper){
        this.customerDao = customerDao;
        this.customerMapper = customerMapper;
    }

    @Override
    public Customer findById(CustomerId customerId) {
        System.out.println("miam");

        Optional<CustomerEntity> customerEntity = this.customerDao.findById(customerId.value());
        System.out.println("custEntity");
        System.out.println(customerEntity);
        return customerEntity.map(customer -> this.customerMapper.toDomain(customer))
                .orElseThrow(() -> new EntityNotFoundException(customerId.toString()));

    }

    @Override
    public void delete(CustomerId customerId) {
        this.customerDao.deleteById(customerId.value());
    }
}

