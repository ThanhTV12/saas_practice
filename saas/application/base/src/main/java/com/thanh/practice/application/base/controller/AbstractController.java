package com.thanh.practice.application.base.controller;

import com.thanh.practice.application.base.client.ClientRequest;
import com.thanh.practice.saas.infrastructure.common.logging.ServiceLogger;
import com.thanh.practice.saas.service.core.ServiceContext;

import javax.servlet.http.HttpServletRequest;

public class AbstractController {

    protected final ServiceContext serviceContext;
    protected final ServiceLogger logger;

    public AbstractController(ServiceContext serviceContext) {
        this.serviceContext = serviceContext;
        this.logger = serviceContext.getServiceLogger("NVN", this.getClass());
    }

    protected ClientRequest getClientRequest(HttpServletRequest request) {
        String tenantId = request.getHeader("tenantId");
        String clientId = request.getHeader("clientId");
        String accessToken = request.getHeader("accessToken");
        return new ClientRequest(tenantId, clientId, accessToken);
    }
}
