package com.thanh.practice.saas.service.employee.impl;

import com.thanh.practice.saas.infrastructure.storage.jpa.entity.Employee;
import com.thanh.practice.saas.infrastructure.storage.jpa.entity.EmployeeInfo;
import com.thanh.practice.saas.infrastructure.storage.jpa.repository.EmployeeInfoRepository;
import com.thanh.practice.saas.infrastructure.storage.jpa.repository.EmployeeRepository;
import com.thanh.practice.saas.model.common.constant.LogLevelType;
import com.thanh.practice.saas.service.core.BaseService;
import com.thanh.practice.saas.service.core.ServiceContext;
import com.thanh.practice.saas.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


public class EmployeeServiceImpl extends BaseService implements EmployeeService {


    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeInfoRepository employeeInfoRepository;

    public EmployeeServiceImpl(ServiceContext serviceContext) {
        super(serviceContext);
    }

    @Override
    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Transactional
    @Override
    public Employee create(Employee employee, EmployeeInfo employeeInfo) {
        employee = employeeRepository.save(employee);
        log.log(LogLevelType.INFO, "create::employee: {}:", employee.toString());
        employeeInfo.setEmployeeId(employee.getId());
        employeeInfoRepository.save(employeeInfo);
        return employee;
    }

    @Override
    public Employee getEmployee(Integer employeeId) throws Exception{
        Employee employee = employeeRepository.findOne(employeeId);
        if(employee == null) {
            throw new Exception("Not found");
        }
        return employee;
    }

    @Override
    public EmployeeInfo getEmployeeInfo(Integer employeeId) {
        Optional<EmployeeInfo> employeeInfo = employeeInfoRepository.findFirstByEmployeeId(employeeId);
        if(employeeInfo.isPresent()) {
            return employeeInfo.get();
        }
        return EmployeeInfo.empty();
    }
}
