package com.thanh.practice.saas.infrastructure.common.config;


import lombok.Data;

@Data
public class SystemConfig {
    private DeployConfig deploy;
    private ActivemqConfig activemq;
    private DataBaseConfig dataBase;
}
