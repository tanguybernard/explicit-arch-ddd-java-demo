package com.explicitarch.demo.project_management;

import com.explicitarch.demo.project_management.application_core.application.GetProjectForCustomer;
import com.explicitarch.demo.project_management.infrastructure.jpa.ProjectDao;
import com.explicitarch.demo.project_management.infrastructure.jpa.ProjectJpaRepository;
import com.explicitarch.demo.project_management.infrastructure.jpa.ProjectMapper;
import com.explicitarch.demo.project_management.presentation.rest.ProjectRestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories
public class ProjectManagementConfiguration {

    @Autowired
    private ProjectDao projectDao;

    @Bean
    public ProjectRestMapper projectRestMapper(){
        return new ProjectRestMapper();
    }

    @Bean
    public GetProjectForCustomer getProjectForCustomer(){
        return new GetProjectForCustomer(new ProjectJpaRepository(projectDao, new ProjectMapper()));
    }
}
