package com.thanh.practice.web.base.service;

import com.thanh.practice.web.base.model.ClientRequest;
import com.thanh.practice.web.base.model.KeyCloakCodeVerifyResponse;
import com.thanh.practice.web.base.model.KeyCloakIntrospectResponse;

import javax.servlet.http.HttpServletRequest;

public interface AuthService {

    KeyCloakCodeVerifyResponse verifyCode(HttpServletRequest request, String code);

    KeyCloakIntrospectResponse getProfile(ClientRequest clientRequest);

    void logout(HttpServletRequest request);
}
