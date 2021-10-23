package com.thanh.practice.application.base.client;

import lombok.Getter;

@Getter
public class ClientRequest {

    private final String tenantId;
    private final String clientId;
    private final String accessToken;

    public ClientRequest(String tenantId, String clientId, String accessToken) {
        this.tenantId = tenantId;
        this.clientId = clientId;
        this.accessToken = accessToken;
    }
}
