package com.explicitarch.demo.freelancer_management.infrastructure.jpa.freelancer;

import javax.persistence.*;

@Entity
@Table(name = "freelancer")
public class FreelancerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "first_name", nullable = false)
    String firstName;

    @Column(name = "last_name", nullable = false)
    String lastName;

}
