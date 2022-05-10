package com.explicitarch.demo.customer_management.infrastructure.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<CustomerEntity, Integer> {
}
