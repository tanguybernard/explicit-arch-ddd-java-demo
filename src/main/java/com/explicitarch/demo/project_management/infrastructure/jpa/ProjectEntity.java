package com.explicitarch.demo.project_management.infrastructure.jpa;

import javax.persistence.*;

//TODO separate new schema postgresql


@Entity
@Table(name = "project", schema = "project_management")
public class ProjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "customer_id", nullable = false)
    Integer customerId;

    @Column(name = "project_name", nullable = false)
    String projectName;

}
