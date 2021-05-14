package com.javamaster.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "customers")
public class CustomerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String email;

    private String name;
}
