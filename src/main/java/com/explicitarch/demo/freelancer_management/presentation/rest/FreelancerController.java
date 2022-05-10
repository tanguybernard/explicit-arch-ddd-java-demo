package com.explicitarch.demo.freelancer_management.presentation.rest;

import com.explicitarch.demo.freelancer_management.application_core.freelancer.application.ListAllFreelancer;
import com.explicitarch.demo.project_management.application_core.application.GetProjectForCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("freelancers")
public class FreelancerController {

    private ListAllFreelancer listAllFreelancer;



    @Autowired
    public void setInjectedBean(ListAllFreelancer listAllFreelancer) {
        this.listAllFreelancer = listAllFreelancer;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    @GetMapping(produces = "application/json")
    public List<Map<String, ?>> all() {

        return listAllFreelancer.listFreelancers().stream()
                .map(freelancer -> Map.of(
                        "firstName", freelancer.firstName,
                        "lastName", freelancer.lastName))
                .collect(Collectors.toList());
    }

    /*@GetMapping("/{value}", produces = "application/json")
    public Book getFreelancer(@PathVariable int value) {
        return findFreelancerById(value);
    }*/

}
