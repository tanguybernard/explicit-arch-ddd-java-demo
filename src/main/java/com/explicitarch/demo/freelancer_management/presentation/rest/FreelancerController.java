package com.explicitarch.demo.freelancer_management.presentation.rest;

import com.explicitarch.demo.freelancer_management.application_core.freelancer.application.ListAllFreelancer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("freelancers")
public class FreelancerController {

    private final ListAllFreelancer listAllFreelancer;

    public FreelancerController(ListAllFreelancer listAllFreelancer) {
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

    /*@GetMapping("/{id}", produces = "application/json")
    public Book getFreelancer(@PathVariable int id) {
        return findFreelancerById(id);
    }*/

}
