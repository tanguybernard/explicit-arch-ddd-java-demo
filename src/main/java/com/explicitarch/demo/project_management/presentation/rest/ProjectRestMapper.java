package com.explicitarch.demo.project_management.presentation.rest;

import com.explicitarch.demo.project_management.application_core.domain.Project;

import java.util.HashMap;
import java.util.Map;

public class ProjectRestMapper {

    public Map<String, Object> fromDomain(Project project){
        Map<String, Object> map = new HashMap<>();
        map.put("projectId", project.id.value());
        map.put("projectName",project.name.value());
        map.put("customerId",project.customerId.value());
        return map;
    }
}
