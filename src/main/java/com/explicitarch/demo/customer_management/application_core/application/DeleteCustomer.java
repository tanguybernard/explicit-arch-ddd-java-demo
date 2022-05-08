package com.explicitarch.demo.customer_management.application_core.application;

import com.explicitarch.demo.customer_management.application_core.domain.ProjectRepository;
import com.explicitarch.demo.shared_kernel.CustomerId;
import com.explicitarch.demo.shared_kernel.ProjectId;

import java.util.List;

public class DeleteCustomer {

    private final ProjectRepository projectRepository;

    public DeleteCustomer(ProjectRepository projectRepository){
        this.projectRepository = projectRepository;
    }

    public void deleteCustomer(CustomerId customerId){
        try{
            List< ProjectId> projects =  this.projectRepository.findAllProjectFor(customerId);

            //add date for projects and check inside domain service if dateEndProject < Today
            // if all are in the paste, you can remove customer.




        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
