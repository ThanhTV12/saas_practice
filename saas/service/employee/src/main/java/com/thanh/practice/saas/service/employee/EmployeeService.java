package com.thanh.practice.saas.service.employee;

import com.thanh.practice.saas.infrastructure.storage.jpa.entity.Employee;
import com.thanh.practice.saas.infrastructure.storage.jpa.entity.EmployeeInfo;

public interface EmployeeService {
    Employee create(Employee employee);
    Employee create(Employee employee, EmployeeInfo employeeInfo);


    Employee getEmployee(Integer employeeId) throws Exception;
    EmployeeInfo getEmployeeInfo(Integer employeeId);
}
