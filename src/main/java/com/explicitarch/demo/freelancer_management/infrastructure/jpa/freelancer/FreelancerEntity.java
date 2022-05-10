package com.explicitarch.demo.freelancer_management.infrastructure.jpa.freelancer;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "freelancer", schema = "freelancer_management")
public class FreelancerEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    UUID id;

    @Column(name = "first_name", nullable = false)
    String firstName;

    @Column(name = "last_name", nullable = false)
    String lastName;

}
