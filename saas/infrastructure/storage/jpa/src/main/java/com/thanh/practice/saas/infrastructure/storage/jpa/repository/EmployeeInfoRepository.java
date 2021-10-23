package com.thanh.practice.saas.infrastructure.storage.jpa.repository;

import com.thanh.practice.saas.infrastructure.storage.jpa.entity.EmployeeInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeInfoRepository extends JpaRepository<EmployeeInfo, Integer> {

    Optional<EmployeeInfo> findFirstByEmployeeId(Integer employeeId);
}
