package com.explicitarch.demo.project_management.infrastructure.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProjectDao extends JpaRepository<ProjectEntity, Long> {

    List<ProjectEntity> findByCustomerId(Integer customerId);
}
