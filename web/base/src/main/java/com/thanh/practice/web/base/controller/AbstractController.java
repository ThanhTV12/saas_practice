package com.thanh.practice.web.base.controller;

import com.thanh.practice.web.base.model.ClientRequest;
import com.thanh.practice.web.base.model.KeyCloakCodeVerifyResponse;
import com.thanh.practice.web.base.servlet.AuthenticationFilter;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.http.HttpServletRequest;

public class AbstractController {

    @Value("${tenant-id}")
    private String tenantId;
    @Value("${web.auth.client-id}")
    private String clientId;

    protected ClientRequest getClientRequest(HttpServletRequest request) {
        KeyCloakCodeVerifyResponse accessTokenInfo = (KeyCloakCodeVerifyResponse) request.getSession()
                .getAttribute(AuthenticationFilter.ACCESS_TOKEN_INFO_KEY);
        if (accessTokenInfo == null) {
            return null;
        }
        return new ClientRequest(tenantId, clientId, accessTokenInfo.getAccessToken());
    }

}
