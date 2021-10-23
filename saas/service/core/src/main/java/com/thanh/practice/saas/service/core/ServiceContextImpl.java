package com.thanh.practice.saas.service.core;

import com.thanh.practice.saas.infrastructure.common.config.SystemConfig;
import com.thanh.practice.saas.infrastructure.common.logging.ServiceLogger;
import com.thanh.practice.saas.infrastructure.common.logging.SystemLogger;
import org.apache.camel.CamelContext;
import org.apache.camel.Endpoint;
import org.apache.camel.ProducerTemplate;
import org.springframework.context.ApplicationContext;

import java.io.Serializable;


public class ServiceContextImpl implements ServiceContext {

    private final ApplicationContext applicationContext;
    private final ProducerTemplate producerTemplate;
    private final SystemConfig systemConfig;

    public ServiceContextImpl(ApplicationContext applicationContext, CamelContext camelContext, SystemConfig systemConfig) {
        this.applicationContext = applicationContext;
        this.producerTemplate = camelContext.createProducerTemplate();
        this.systemConfig = systemConfig;
    }

    @Override
    public <T> T getInstance(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }

    @Override
    public SystemConfig getSystemConfig() {
        return null;
    }

    @Override
    public ServiceLogger getServiceLogger(String tenantId, Class<?> clazz) {
        return new SystemLogger(tenantId, clazz);
    }

    @Override
    public ProducerTemplate getProducerTemplate() {
        return this.producerTemplate;
    }

    @Override
    public <T extends Serializable> void enqueue(String queuName, T message) {
        producerTemplate.sendBody(queuName, message);
    }

}
