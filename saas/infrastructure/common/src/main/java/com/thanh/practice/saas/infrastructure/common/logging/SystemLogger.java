package com.thanh.practice.saas.infrastructure.common.logging;


import com.thanh.practice.saas.model.common.constant.LogLevelType;
import com.thanh.practice.saas.model.common.core.ServiceRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

public class SystemLogger implements ServiceLogger {

    private static final String EXCEPTION_CLASS_FIELD = "exception";
    private static final String EXCEPTION_STACK_TRACE_FIELD = "exceptionStackTrace";
    private static final String CLASS_FIELD = "clazz";
    private static final String REQUEST_ID_FIELD = "requestid";
    private static final String SERVICE_REQUEST_FIELD = "servicerequest";
    private static final String PROTO_FIELD = "proto";
    private static final String TENANT_FIELD = "tenant";
    private static final String USER_FIELD = "user";
    protected final String tenantId;
    protected final Logger logger;
    protected final Class<?> clazz;

    public SystemLogger(String tenantId, Class<?> clazz) {
        this.tenantId = tenantId;
        logger = createLogger(tenantId);
        this.clazz = clazz;
    }

    private Logger createLogger(String tenantId) {
        if (tenantId == null || tenantId.isEmpty()) {
            throw new IllegalArgumentException("null tenantId");
        }
        return LoggerFactory.getLogger(tenantId);
    }

    @Override
    public void log(LogLevelType logLevel, String message, Object... args) {
        this.logRequest(logLevel, null, this.clazz, message, args);
    }

    @Override
    public void log(LogLevelType logLevel, Class<?> clazz, ServiceRequest serviceRequest, String message, Object... args) {
        this.logRequest(logLevel, serviceRequest, clazz, message, args);
    }

    @Override
    public void logRequest(LogLevelType logLevel, ServiceRequest serviceRequest, String message, Object... args) {
        this.logRequest(logLevel, serviceRequest, null, message, args);
    }

    @Override
    public void logRequest(LogLevelType logLevel, ServiceRequest serviceRequest, Class<?> clazz, String message, Object... args) {
        if (serviceRequest != null) {
            MDC.put(REQUEST_ID_FIELD, serviceRequest.getRequestId());
            serviceRequest.setAccessToken(null);
            MDC.put(SERVICE_REQUEST_FIELD, serviceRequest.toString());
            MDC.put(USER_FIELD, serviceRequest.getUsername());
        }
        if (clazz != null) {
            MDC.put(CLASS_FIELD, clazz.getSimpleName());
        }
        switch (logLevel) {
            case ERROR:
                logger.error(message, args);
                break;
            case WARN:
                logger.warn(message, args);
                break;
            case INFO:
                logger.info(message, args);
                break;
            case DEBUG:
                logger.debug(message, args);
                break;
            case TRACE:
                logger.trace(message, args);
                break;
            case ALL:
                logger.info(message, args);
                break;
            case OFF:
                break;
            case UNKNOWN_LOG_LEVEL_TYPE:
                break;
            default:
                break;
        }
        MDC.clear();
    }

    @Override
    public void logException(Exception ex, String message, Object... args) {
        this.logRequestException(null, ex, null, message, args);
    }

    @Override
    public void logException(Exception ex, Class<?> clazz, String message, Object... args) {
        this.logRequestException(null, ex, clazz, message, args);
    }

    @Override
    public void logRequestException(ServiceRequest serviceRequest, Exception ex, String message, Object... args) {
        this.logRequestException(serviceRequest, ex, null, message, args);
    }

    @Override
    public void logRequestException(ServiceRequest serviceRequest, Exception ex, Class<?> clazz, String message, Object... args) {
        MDC.put(TENANT_FIELD, tenantId);
        if (clazz != null) {
            MDC.put(CLASS_FIELD, clazz.getSimpleName());
        }
        if (serviceRequest != null) {
            MDC.put(REQUEST_ID_FIELD, serviceRequest.getRequestId());
            serviceRequest.setAccessToken(null);
            MDC.put(SERVICE_REQUEST_FIELD, serviceRequest.toString());
            MDC.put(USER_FIELD, serviceRequest.getUsername());
        }
        logger.error(message, args);
        MDC.clear();
    }
}
