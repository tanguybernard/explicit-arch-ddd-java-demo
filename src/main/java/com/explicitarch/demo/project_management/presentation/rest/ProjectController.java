package com.explicitarch.demo.project_management.presentation.rest;

import com.explicitarch.demo.project_management.application_core.application.GetProjectForCustomer;
import com.explicitarch.demo.project_management.application_core.domain.Project;
import com.explicitarch.demo.shared_kernel.CustomerId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("customers")
public class ProjectController {

    private GetProjectForCustomer getProjectForCustomer;

    @Autowired
    public void setInjectedBean(GetProjectForCustomer getProjectForCustomer) {
        this.getProjectForCustomer = getProjectForCustomer;
    }
    @Autowired
    private ProjectRestMapper projectRestMapper;

    @GetMapping(value= "/{customerId}/projects")//TODO change by projects?customerId=1
    public List<Map<String, Object>> exist(@PathVariable Integer customerId){
        try {
            List<Project> projects = this.getProjectForCustomer.projectExistFor(new CustomerId(customerId));
            return projects.stream().map(project -> this.projectRestMapper.fromDomain(project)).collect(Collectors.toList());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value= "/{customerId}/hello")
    public String hello(@PathVariable Integer customerId) {
        return "Hello ProjectController!"+customerId;
    }

}
