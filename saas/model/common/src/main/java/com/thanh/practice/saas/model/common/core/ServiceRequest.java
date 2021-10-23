package com.thanh.practice.saas.model.common.core;

import com.thanh.practice.saas.model.common.constant.LogLevelType;

import java.util.List;

public class ServiceRequest {
    private String requestId;
    private String tenantId;
    private String clientId;
    private String accessToken;
    private String userId;
    private String username;
    private List<String> roles;
    private LogLevelType logLevelType;
    private String userAgent;
    private Integer utcStartTime;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public LogLevelType getLogLevelType() {
        return logLevelType;
    }

    public void setLogLevelType(LogLevelType logLevelType) {
        this.logLevelType = logLevelType;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public Integer getUtcStartTime() {
        return utcStartTime;
    }

    public void setUtcStartTime(Integer utcStartTime) {
        this.utcStartTime = utcStartTime;
    }
}
