package com.thanh.practice.application.base.camel;

import com.thanh.practice.application.base.constant.SystemConstant;
import com.thanh.practice.saas.infrastructure.common.logging.ServiceLogger;
import com.thanh.practice.saas.service.core.ServiceContext;
import org.apache.camel.Processor;

public abstract class AbstractProcessor implements Processor {
    protected final ServiceContext serviceContext;
    protected final ServiceLogger logger;

    protected AbstractProcessor(ServiceContext serviceContext) {
        this.serviceContext = serviceContext;
        logger = serviceContext.getServiceLogger(SystemConstant.TENAT_NVN, this.getClass());
    }
}
