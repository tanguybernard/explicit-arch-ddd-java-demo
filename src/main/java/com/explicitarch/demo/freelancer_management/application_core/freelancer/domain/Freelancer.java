package com.explicitarch.demo.freelancer_management.application_core.freelancer.domain;

import com.explicitarch.demo.shared_kernel.domain.value_object.Address;

public class Freelancer{
    public FreelancerId freelancerId;
    public String firstName;
    public String lastName;
    Address address;
    public Freelancer(
            FreelancerId freelancerId,
    String firstName,
    String lastName,
    Address address){
        this.freelancerId = freelancerId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void movedTo(Address address) {
        this.address = address;
    }

}
