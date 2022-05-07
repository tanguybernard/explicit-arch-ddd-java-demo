package com.explicitarch.demo.freelancer_management;

import com.explicitarch.demo.freelancer_management.application_core.freelancer.application.ListAllFreelancer;
import com.explicitarch.demo.freelancer_management.infrastructure.jpa.freelancer.FreelancerDao;
import com.explicitarch.demo.freelancer_management.infrastructure.jpa.freelancer.FreelancerJpaRepository;
import com.explicitarch.demo.freelancer_management.infrastructure.jpa.freelancer.FreelancerMapper;
import com.explicitarch.demo.project_management.application_core.application.GetProjectForCustomer;
import com.explicitarch.demo.project_management.infrastructure.jpa.ProjectJpaRepository;
import com.explicitarch.demo.project_management.infrastructure.jpa.ProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Configuration
@EnableJpaRepositories
public class FreelancerManagementConfiguration {

    @Autowired
    private FreelancerDao freelancerDao;

    @Bean
    public ListAllFreelancer listAllFreelancer(){
        return new ListAllFreelancer(new FreelancerJpaRepository(freelancerDao, new FreelancerMapper()));
    }
}
