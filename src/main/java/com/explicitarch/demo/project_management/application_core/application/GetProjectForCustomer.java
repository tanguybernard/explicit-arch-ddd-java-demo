package com.explicitarch.demo.project_management.application_core.application;

import com.explicitarch.demo.project_management.application_core.domain.Project;
import com.explicitarch.demo.project_management.application_core.domain.ProjectDirectory;
import com.explicitarch.demo.shared_kernel.CustomerId;

import java.util.List;

public class GetProjectForCustomer { //call from presentation -> by  customer management BC with rest communication

    private ProjectDirectory projectDirectory;


    public GetProjectForCustomer(ProjectDirectory projectDirectory){
        this.projectDirectory = projectDirectory;
    }

    public List<Project> projectExistFor(CustomerId customerId) throws Exception {
        List<Project> projects = this.projectDirectory.findByCustomerId(customerId);
        if(projects.isEmpty()){
            throw new Exception("Project does not exist for this customer!");
        }

        return projects;
    }
}
