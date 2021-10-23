package com.thanh.practice.saas.infrastructure.storage.jpa.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "employee_info")
@Data
public class EmployeeInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "employee_id")
    private Integer employeeId;

    @Enumerated(EnumType.STRING)
    private SEX sex;

    @Column(name = "is_marred")
    private Boolean isMarred;

    private Integer salary;

    public enum SEX {
        MALE, FEMALE
    }

    public static EmployeeInfo empty() {
        return new EmployeeInfo();
    }
}


