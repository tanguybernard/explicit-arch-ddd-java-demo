package com.explicitarch.demo.project_management.application_core.domain;

import com.explicitarch.demo.shared_kernel.CustomerId;

import java.util.List;

public interface ProjectDirectory {

    List<Project> findByCustomerId(CustomerId customerId);
}
