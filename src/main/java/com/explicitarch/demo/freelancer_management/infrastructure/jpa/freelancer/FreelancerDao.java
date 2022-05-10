package com.explicitarch.demo.freelancer_management.infrastructure.jpa.freelancer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FreelancerDao extends JpaRepository<FreelancerEntity, UUID> {
}
