package com.thanh.practice.saas.infrastructure.common.logging;

import com.thanh.practice.saas.model.common.constant.LogLevelType;
import com.thanh.practice.saas.model.common.core.ServiceRequest;

public interface ServiceLogger {
    void log(LogLevelType logLevel, String message, Object... args);

    void log(LogLevelType logLevel, Class<?> clazz, ServiceRequest serviceRequest, String message, Object... args);

    void logRequest(LogLevelType logLevel, ServiceRequest serviceRequest, String message, Object... args);

    void logRequest(LogLevelType logLevel, ServiceRequest serviceRequest, Class<?> clazz, String message, Object... args);

    void logException(Exception ex, String message, Object... args);

    void logException(Exception ex, Class<?> clazz, String message, Object... args);

    void logRequestException(ServiceRequest serviceRequest, Exception ex, String message, Object... args);

    void logRequestException(ServiceRequest serviceRequest, Exception ex, Class<?> clazz, String message, Object... args);
}
