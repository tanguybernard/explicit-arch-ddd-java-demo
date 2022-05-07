package com.explicitarch.demo.project_management.infrastructure.jpa;

import com.explicitarch.demo.freelancer_management.application_core.freelancer.domain.Freelancer;
import com.explicitarch.demo.project_management.application_core.domain.Project;
import com.explicitarch.demo.project_management.application_core.domain.ProjectName;
import com.explicitarch.demo.shared_kernel.CustomerId;
import com.explicitarch.demo.shared_kernel.ProjectId;

public class ProjectMapper {

    Project toDomain(ProjectEntity projectEntity){

        return new Project(
                new ProjectId(projectEntity.id),
                new CustomerId(projectEntity.customerId),
                new ProjectName(projectEntity.projectName)
        );

    }
}
