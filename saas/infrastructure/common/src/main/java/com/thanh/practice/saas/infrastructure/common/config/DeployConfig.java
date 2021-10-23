package com.thanh.practice.saas.infrastructure.common.config;

public class DeployConfig {
    private String instanceName;
    private String env;
    private String host;
    private Integer port;
    private String di;

    public String getInstanceName() {
        return instanceName;
    }

    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getDi() {
        return di;
    }

    public void setDi(String di) {
        this.di = di;
    }
}
