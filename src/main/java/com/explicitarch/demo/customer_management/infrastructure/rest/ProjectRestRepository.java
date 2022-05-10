package com.explicitarch.demo.customer_management.infrastructure.rest;

import com.explicitarch.demo.customer_management.application_core.domain.ProjectRepository;
import com.explicitarch.demo.shared_kernel.domain.value_object.CustomerId;
import com.explicitarch.demo.shared_kernel.domain.value_object.ProjectId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProjectRestRepository implements ProjectRepository {

    private final RestTemplate restTemplate;

    public ProjectRestRepository(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public List<ProjectId> findAllProjectFor(CustomerId customerId) {
        System.out.println("findAllProejctFor");

        String url = "http://localhost:8082/projects?customerId=%s".formatted(customerId.value());

        System.out.println(url);
        //TODO move to DAO
        ResponseEntity<ProjectDto[]> response =
                restTemplate.getForEntity(
                        url,
                        ProjectDto[].class);
        ProjectDto[] projects = response.getBody();

        //System.out.println(projects[0].projectName);
        if (projects.length > 0) {
            return Arrays.stream(projects).toList().stream().map(projectDto -> new ProjectId(projectDto.projectId)).collect(Collectors.toList());
        }

        return List.of();

    }
}
