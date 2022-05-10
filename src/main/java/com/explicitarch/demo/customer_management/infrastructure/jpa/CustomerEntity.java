package com.explicitarch.demo.customer_management.infrastructure.jpa;

import javax.persistence.*;

@Entity
@Table(name = "customer", schema = "customer_management")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "name", nullable = false)
    String name;

}
