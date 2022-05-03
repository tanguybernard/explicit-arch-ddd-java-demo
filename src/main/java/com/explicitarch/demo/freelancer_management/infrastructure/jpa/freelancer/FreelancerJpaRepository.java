package com.explicitarch.demo.freelancer_management.infrastructure.jpa.freelancer;

import com.explicitarch.demo.freelancer_management.application_core.freelancer.domain.Freelancer;
import com.explicitarch.demo.freelancer_management.application_core.freelancer.domain.FreelancerDirectory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FreelancerJpaRepository implements FreelancerDirectory {

    private FreelancerDao freelancerDao;
    private FreelancerMapper freelancerMapper;

    public FreelancerJpaRepository(FreelancerDao freelancerDao, FreelancerMapper freelancerMapper){
        this.freelancerDao = freelancerDao;
        this.freelancerMapper = freelancerMapper;
    }

    @Override
    public List<Freelancer> all() {

        List<FreelancerEntity> freelancerEntities = this.freelancerDao.findAll();
        return Arrays.stream(freelancerEntities.toArray())
                .map(freelancer -> this.freelancerMapper.toDomain((FreelancerEntity) freelancer))
                .collect(Collectors.toList());


    }
}
