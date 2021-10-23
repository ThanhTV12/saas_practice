package com.thanh.practice.saas.service.core;

import com.thanh.practice.saas.infrastructure.common.config.SystemConfig;
import com.thanh.practice.saas.infrastructure.common.logging.ServiceLogger;
import org.apache.camel.ProducerTemplate;

import java.io.Serializable;

public interface ServiceContext {
    <T> T getInstance(Class<T> clazz);

    SystemConfig getSystemConfig();

    ServiceLogger getServiceLogger(String tenantId, Class<?> clazz);

    ProducerTemplate getProducerTemplate();

    <T extends Serializable> void enqueue(String queuName, T message);

}
