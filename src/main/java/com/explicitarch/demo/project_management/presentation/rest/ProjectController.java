package com.explicitarch.demo.project_management.presentation.rest;

import com.explicitarch.demo.project_management.application_core.application.GetProjectForCustomer;
import com.explicitarch.demo.project_management.application_core.domain.Project;
import com.explicitarch.demo.shared_kernel.domain.value_object.CustomerId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("projects")
public class ProjectController {

    private GetProjectForCustomer getProjectForCustomer;

    @Autowired
    public void setInjectedBean(GetProjectForCustomer getProjectForCustomer) {
        this.getProjectForCustomer = getProjectForCustomer;
    }
    @Autowired
    private ProjectRestMapper projectRestMapper;

    @GetMapping("")
    public List<Map<String, Object>> exist(@RequestParam Integer customerId){
            System.out.println("IAM here");

        List<Project> projects = null;
        try {
            projects = this.getProjectForCustomer.projectExistFor(new CustomerId(customerId));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return projects.stream().map(project -> this.projectRestMapper.fromDomain(project)).collect(Collectors.toList());

    }

    @GetMapping(value= "/hello")
    public String hello() {
        return "Hello ProjectController!";
    }

}
