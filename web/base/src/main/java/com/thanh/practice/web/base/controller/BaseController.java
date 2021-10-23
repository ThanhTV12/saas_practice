package com.thanh.practice.web.base.controller;

import com.thanh.practice.web.base.model.ClientRequest;
import com.thanh.practice.web.base.model.KeyCloakCodeVerifyResponse;
import com.thanh.practice.web.base.model.KeyCloakIntrospectResponse;
import com.thanh.practice.web.base.service.AuthService;
import com.thanh.practice.web.base.servlet.AuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RestController
public class BaseController extends AbstractController{

    @Value("${web.auth.sso-url}")
    private String ssoUrl;

    @Value("${web.home}")
    private String homeUrl;

    @Value("${web.auth.logout-url}")
    private String logoutUrl;

    @Value("${web.auth.client-id}")
    private String clientId;

    @Autowired
    private AuthService authService;

    @GetMapping(path = "/api/auth/sso")
    public void goToSSO(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(clientId + "::BaseController::goToSSO");
        response.setHeader("Location", ssoUrl);
        response.setStatus(HttpStatus.FOUND.value());
    }

    @GetMapping(path = "/api/auth/verify")
    public void authVerifyCode(HttpServletRequest request, HttpServletResponse response, @RequestParam("code") String code) {
        System.out.println(clientId + "::BaseController::authVerifyCode");
        System.out.println(code);
        KeyCloakCodeVerifyResponse keyCloakCodeVerifyResponse = authService.verifyCode(request, code);
        System.out.println(clientId + "::keyCloakCodeVerifyResponse");
        response.setHeader("Location", homeUrl);
        response.setStatus(HttpStatus.FOUND.value());
    }

    @GetMapping(path = "/api/profile")
    public KeyCloakIntrospectResponse getProfile(HttpServletRequest request, HttpServletResponse response) {
        ClientRequest clientRequest = this.getClientRequest(request);
        if (clientRequest == null){
            return new KeyCloakIntrospectResponse();
        }
        System.out.println(clientId + "::getProfile------------");
        return authService.getProfile(clientRequest);
    }

    @GetMapping(path = "/api/auth/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(clientId + "::logout------------");
        request.getSession().setAttribute(AuthenticationFilter.ACCESS_TOKEN_INFO_KEY, null);
        response.setHeader("Location", logoutUrl);
        response.setStatus(HttpStatus.FOUND.value());
    }
}


