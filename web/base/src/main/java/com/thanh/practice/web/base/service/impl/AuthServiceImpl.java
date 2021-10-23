package com.thanh.practice.web.base.service.impl;

import com.google.api.client.http.*;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.gson.Gson;
import com.thanh.practice.web.base.model.ClientRequest;
import com.thanh.practice.web.base.model.KeyCloakCodeVerifyResponse;
import com.thanh.practice.web.base.model.KeyCloakIntrospectResponse;
import com.thanh.practice.web.base.service.AuthService;
import com.thanh.practice.web.base.servlet.AuthenticationFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStreamReader;

@Service("authService")
public class AuthServiceImpl implements AuthService {


    @Value("${web.auth.client-id}")
    private String clientId;

    @Value("${web.auth.client-secret}")
    private String clientSecret;

    @Value("${web.auth.redirect-url}")
    private String redirectUri;

    @Value("${web.auth.token-verify-url}")
    private String tokenVerifyUrl;

    private static final String INTROSPECT_URI_FORMAT = "%s/auth/realms/%s/protocol/openid-connect/token/introspect";

    @Value("${web.auth.auth-server-url}")
    private String authServerUrl;

    @Value("${web.auth.realm}")
    private String realm;

    @Override
    public KeyCloakCodeVerifyResponse verifyCode(HttpServletRequest httpServletRequest, String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }

        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        headers.add("Content-Type", "application/x-www-form-urlencoded");
        requestBody.add("grant_type", "authorization_code");
        requestBody.add("code", code);
        requestBody.add("client_id", clientId);
        requestBody.add("client_secret", clientSecret);
        requestBody.add("redirect_uri", redirectUri);


        HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
        JsonFactory JSON_FACTORY = new JacksonFactory();
        HttpRequestFactory requestFactory = HTTP_TRANSPORT.createRequestFactory((HttpRequest request) -> {
            request.setParser(new JsonObjectParser(JSON_FACTORY));
        });

        try {
            HttpContent httpContent = new UrlEncodedContent(requestBody);
            HttpRequest request = requestFactory.buildPostRequest(new GenericUrl(tokenVerifyUrl), httpContent);
            request.getHeaders().putAll(headers);
            HttpResponse response = request.execute();
            Gson gson = new Gson();
            KeyCloakCodeVerifyResponse keyCloakCodeVerifyResponse = gson
                    .fromJson(new InputStreamReader(response.getContent(), "UTF-8"), KeyCloakCodeVerifyResponse.class);
            httpServletRequest.getSession().setAttribute(AuthenticationFilter.ACCESS_TOKEN_INFO_KEY,
                    keyCloakCodeVerifyResponse);
            return keyCloakCodeVerifyResponse;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public KeyCloakIntrospectResponse getProfile(ClientRequest clientRequest) {
        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        headers.add("Content-Type", "application/x-www-form-urlencoded");
        headers.add("Accept", "application/x-www-form-urlencoded");
        requestBody.add("client_id", clientId);
        requestBody.add("client_secret", clientSecret);
        requestBody.add("token", clientRequest.getAccessToken());
        String introspect = String.format(INTROSPECT_URI_FORMAT, authServerUrl, realm);
        try {
            HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
            JsonFactory JSON_FACTORY = new JacksonFactory();
            HttpRequestFactory requestFactory = HTTP_TRANSPORT.createRequestFactory((HttpRequest request) -> {
                request.setParser(new JsonObjectParser(JSON_FACTORY));
            });

            HttpContent httpContent = new UrlEncodedContent(requestBody);
            HttpRequest request = requestFactory.buildPostRequest(new GenericUrl(introspect), httpContent);
            request.getHeaders().putAll(headers);
            HttpResponse response = request.execute();
            Gson gson = new Gson();
            KeyCloakIntrospectResponse keyCloakIntrospectResponse = gson
                    .fromJson(new InputStreamReader(response.getContent(), "UTF-8"), KeyCloakIntrospectResponse.class);
            return keyCloakIntrospectResponse;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void logout(HttpServletRequest request) {
        //T.B.C
    }


}
