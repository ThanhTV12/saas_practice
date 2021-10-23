package com.thanh.practice.application.base.camel;

import com.thanh.practice.saas.infrastructure.common.logging.ServiceLogger;
import com.thanh.practice.saas.service.core.ServiceContext;
import org.apache.camel.builder.RouteBuilder;

public abstract class AbstractRoute extends RouteBuilder {

    protected final ServiceContext serviceContext;
    protected final ServiceLogger logger;

    public AbstractRoute(ServiceContext serviceContext) {
        this.serviceContext = serviceContext;
        this.logger = serviceContext.getServiceLogger("NVN", this.getClass());
    }
}
