package com.explicitarch.demo.project_management.infrastructure.jpa;


import com.explicitarch.demo.project_management.application_core.domain.ProjectDirectory;
import com.explicitarch.demo.shared_kernel.CustomerId;
import com.explicitarch.demo.project_management.application_core.domain.Project;

import java.util.List;
import java.util.stream.Collectors;


public class ProjectJpaRepository implements ProjectDirectory {

    private ProjectDao projectDao;
    private ProjectMapper projectMapper;

    public ProjectJpaRepository(ProjectDao projectDao, ProjectMapper projectMapper){
        this.projectDao = projectDao;
        this.projectMapper = projectMapper;
    }

    @Override
    public List<Project> findByCustomerId(CustomerId customerId) {
         List<ProjectEntity> projectEntities = this.projectDao.findByCustomerId(customerId.value());
         return projectEntities.stream().map(projectEntity -> this.projectMapper.toDomain(projectEntity)).collect(Collectors.toList());
    }
}
