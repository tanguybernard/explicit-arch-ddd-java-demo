package com.explicitarch.demo.project_management.presentation.rest;

import com.explicitarch.demo.project_management.application_core.domain.Project;

import java.util.HashMap;
import java.util.Map;

public class ProjectRestMapper {

    public Map<String, Object> fromDomain(Project project){
        Map<String, Object> map = new HashMap<>();
        map.put("project_id", project.id.value());
        map.put("project_name",project.name.value());
        map.put("customer_id",project.customerId.value());
        return map;
    }
}
