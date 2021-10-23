package com.thanh.practice.saas.infrastructure.storage.jpa.repository;

import com.thanh.practice.saas.infrastructure.storage.jpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
