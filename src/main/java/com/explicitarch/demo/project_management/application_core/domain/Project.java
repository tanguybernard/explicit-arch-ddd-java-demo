package com.explicitarch.demo.project_management.application_core.domain;

import com.explicitarch.demo.shared_kernel.CustomerId;
import com.explicitarch.demo.shared_kernel.ProjectId;

public class Project {

    public ProjectId id;
    public CustomerId  customerId;
    public ProjectName name;
    public Project(ProjectId id, CustomerId customerId, ProjectName name){
        this.id = id;
        this.customerId = customerId;
        this.name = name;
    }
}
