package com.thanh.practice.saas.service.core;

import com.thanh.practice.saas.infrastructure.common.logging.ServiceLogger;

public class BaseService {

    protected final ServiceContext serviceContext;
    protected ServiceLogger log;

    public BaseService(ServiceContext serviceContext) {
        this.serviceContext = serviceContext;
        this.log = serviceContext.getServiceLogger("NVN", this.getClass());
    }
}
