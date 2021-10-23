package com.thanh.practice.web.base.model;

import lombok.Data;

@Data
public class ClientRequest {
    private final String tenantId;
    private final String clientId;
    private final String accessToken;
    private final boolean internalRequest;


    public ClientRequest(String tenantId) {
        this.tenantId = tenantId;
        this.clientId = null;
        this.accessToken = null;
        this.internalRequest = true;
    }

    public ClientRequest(String tenantId, String clientId, String accessToken) {
        this.tenantId = tenantId;
        this.clientId = clientId;
        this.accessToken = accessToken;
        this.internalRequest = false;
    }
}
