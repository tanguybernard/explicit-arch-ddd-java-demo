package com.explicitarch.demo.customer_management.infrastructure.rest;

import com.explicitarch.demo.customer_management.application_core.domain.ProjectRepository;
import com.explicitarch.demo.shared_kernel.CustomerId;
import com.explicitarch.demo.shared_kernel.ProjectId;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProjectRestRepository implements ProjectRepository {

    private final RestTemplate restTemplate;

    public ProjectRestRepository(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }


    @Override
    public List<ProjectId> findAllProjectFor(CustomerId customerId) throws Exception {
        String url = "http://localhost:8080/projects?customerId=%s".formatted(customerId.value());
        //TODO move to DAO
        ResponseEntity<ProjectDto[]> response =
                restTemplate.getForEntity(
                        url,
                        ProjectDto[].class);
        ProjectDto[] projects = response.getBody();

        if(projects != null){
            return Arrays.stream(projects).toList().stream().map(projectDto -> new ProjectId(projectDto.projectId)).collect(Collectors.toList());
        }
        throw new Exception("Project not found !");
    }
}
