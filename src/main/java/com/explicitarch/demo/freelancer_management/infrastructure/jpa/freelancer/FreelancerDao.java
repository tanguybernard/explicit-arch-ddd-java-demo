package com.explicitarch.demo.freelancer_management.infrastructure.jpa.freelancer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface FreelancerDao extends JpaRepository<FreelancerEntity, Long> {
}
