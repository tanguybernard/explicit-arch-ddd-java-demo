package com.explicitarch.demo.customer_management.application_core.application;

import com.explicitarch.demo.customer_management.application_core.domain.Customer;
import com.explicitarch.demo.customer_management.application_core.domain.CustomerRepository;
import com.explicitarch.demo.customer_management.application_core.domain.ProjectRepository;
import com.explicitarch.demo.shared_kernel.domain.bus.event.EventBus;
import com.explicitarch.demo.shared_kernel.domain.value_object.CustomerId;
import com.explicitarch.demo.shared_kernel.domain.value_object.ProjectId;

import java.util.List;

public class DeleteCustomer {

    private final ProjectRepository projectRepository;
    private final CustomerRepository customerRepository;

    private final EventBus bus;

    public DeleteCustomer(
            CustomerRepository customerRepository,
            ProjectRepository projectRepository,
            EventBus bus
    ){

        this.projectRepository = projectRepository;
        this.customerRepository = customerRepository;
        this.bus = bus;
    }

    public void deleteCustomer(CustomerId customerId) throws Exception {//rename to execute and create interface ApplicationService ?

        System.out.println("deletZZZ");
        Customer customer = this.customerRepository.findById(customerId);
        System.out.println(customer);

        List< ProjectId> projects =  this.projectRepository.findAllProjectFor(customerId);
        //add date for projects and check inside domain service if dateEndProject < Today
        // if all are in the paste, you can remove customer.

        if(projects.isEmpty()){
            System.out.println("AProject empty");

            customer.delete();
            System.out.println("Repo delete"+customerId.value());

            this.customerRepository.delete(customerId);
            System.out.println("Publish event");

            this.bus.publish(customer.pullDomainEvents());

        }

    }
}
