package com.explicitarch.demo.freelancer_management.application_core.freelancer.application;

import com.explicitarch.demo.freelancer_management.application_core.freelancer.domain.Freelancer;
import com.explicitarch.demo.freelancer_management.application_core.freelancer.domain.FreelancerDirectory;

import java.util.List;


public class ListAllFreelancer {

    private final FreelancerDirectory freelancerDirectory;

    public ListAllFreelancer(FreelancerDirectory freelancerDirectory){
        this.freelancerDirectory = freelancerDirectory;
    }

    public List<Freelancer> listFreelancers(){
        return this.freelancerDirectory.all();
    }

}
