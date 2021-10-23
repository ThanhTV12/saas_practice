package com.thanh.practice.saas.infrastructure.storage.jpa.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "employee")
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer age;
    private String address;

    @Transient
    private EmployeeInfo employeeInfo;
}
