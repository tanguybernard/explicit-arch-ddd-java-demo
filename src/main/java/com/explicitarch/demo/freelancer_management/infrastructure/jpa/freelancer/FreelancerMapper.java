package com.explicitarch.demo.freelancer_management.infrastructure.jpa.freelancer;

import com.explicitarch.demo.freelancer_management.application_core.freelancer.domain.Freelancer;
import com.explicitarch.demo.freelancer_management.application_core.freelancer.domain.FreelancerId;
import com.explicitarch.demo.shared_kernel.Address;

public class FreelancerMapper {

    Freelancer toDomain(FreelancerEntity freelancer){

        return new Freelancer(
                new FreelancerId(freelancer.id.toString()),
                freelancer.firstName,
                freelancer.lastName,
                new Address("75000","Paris")
        );

    }
}
