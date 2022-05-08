package com.explicitarch.demo.customer_management;

import com.explicitarch.demo.customer_management.application_core.application.DeleteCustomer;
import com.explicitarch.demo.customer_management.infrastructure.rest.ProjectRestRepository;
import com.explicitarch.demo.freelancer_management.application_core.freelancer.application.ListAllFreelancer;
import com.explicitarch.demo.freelancer_management.infrastructure.jpa.freelancer.FreelancerDao;
import com.explicitarch.demo.freelancer_management.infrastructure.jpa.freelancer.FreelancerJpaRepository;
import com.explicitarch.demo.freelancer_management.infrastructure.jpa.freelancer.FreelancerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories
public class CustomerManagementConfiguration {


    @Bean
    public DeleteCustomer deleteCustomer(){
        return new DeleteCustomer(new ProjectRestRepository(new RestTemplateBuilder()));
    }
}
