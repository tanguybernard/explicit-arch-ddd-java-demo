package com.explicitarch.demo.customer_management.application_core.domain;

import com.explicitarch.demo.shared_kernel.CustomerId;
import com.explicitarch.demo.shared_kernel.ProjectId;

import java.util.List;

public interface ProjectRepository {

    List<ProjectId> findAllProjectFor(CustomerId customerId) throws Exception;

}
