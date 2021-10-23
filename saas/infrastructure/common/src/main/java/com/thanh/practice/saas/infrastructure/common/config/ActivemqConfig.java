package com.thanh.practice.saas.infrastructure.common.config;

import lombok.Data;

@Data
public class ActivemqConfig {
    private String brokerUrl;
    private String user;
    private String password;
    private Boolean trustAll;

}
