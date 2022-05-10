package com.explicitarch.demo.project_management.application_core.domain;

import com.explicitarch.demo.shared_kernel.domain.value_object.CustomerId;
import com.explicitarch.demo.shared_kernel.domain.value_object.ProjectId;
import org.springframework.beans.factory.annotation.Value;

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
