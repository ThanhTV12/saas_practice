package com.thanh.practice.application.business.di;

import com.thanh.practice.application.business.config.SaasConfig;
import com.thanh.practice.saas.service.core.ServiceContext;
import com.thanh.practice.saas.service.core.ServiceContextImpl;
import com.thanh.practice.saas.service.employee.EmployeeService;
import com.thanh.practice.saas.service.employee.impl.EmployeeServiceImpl;
import com.thanh.practice.saas.service.hibernate.UserService;
import com.thanh.practice.saas.service.hibernate.impl.UserServiceImpl;
import org.apache.camel.CamelContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoreModule {

    @Bean
    public ServiceContext serviceContext(ApplicationContext applicationContext, CamelContext camelContext, SaasConfig saasConfig) {
        return new ServiceContextImpl(applicationContext, camelContext, saasConfig.getSystem());
    }

    @Bean
    public EmployeeService employeeService(ServiceContext serviceContext) {
        return new EmployeeServiceImpl(serviceContext);
    }

    @Bean
    public UserService userService(ServiceContext serviceContext) {
        return new UserServiceImpl(serviceContext);
    }
}
