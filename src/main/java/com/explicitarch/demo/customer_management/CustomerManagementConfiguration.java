package com.explicitarch.demo.customer_management;

import com.explicitarch.demo.customer_management.application_core.application.DeleteCustomer;
import com.explicitarch.demo.customer_management.infrastructure.jpa.CustomerDao;
import com.explicitarch.demo.customer_management.infrastructure.jpa.CustomerJpaRepository;
import com.explicitarch.demo.customer_management.infrastructure.jpa.CustomerMapper;
import com.explicitarch.demo.customer_management.infrastructure.rest.ProjectRestRepository;
import com.explicitarch.demo.freelancer_management.infrastructure.jpa.freelancer.FreelancerDao;
import com.explicitarch.demo.shared_kernel.infrastructure.bus.event.InMemoryOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories
public class CustomerManagementConfiguration {


    @Autowired
    CustomerDao customerDao;

    @Bean
    public DeleteCustomer deleteCustomer(){
        return new DeleteCustomer(
                new CustomerJpaRepository(customerDao, new CustomerMapper()),
                new ProjectRestRepository(new RestTemplateBuilder()),
                new InMemoryOutput()
        );
    }
}
