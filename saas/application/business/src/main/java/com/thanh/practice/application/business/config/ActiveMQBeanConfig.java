package com.thanh.practice.application.business.config;

import com.thanh.practice.saas.infrastructure.common.config.ActivemqConfig;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ActiveMQBeanConfig {

    @Bean
    public ActiveMQConnectionFactory activeMQAutoConfiguration(SaasConfig saasConfig) {
        System.out.println("saasConfig::");
        System.out.println(saasConfig.toString());
        ActivemqConfig activemqConfig = saasConfig.getSystem().getActivemq();
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
        activeMQConnectionFactory.setBrokerURL(activemqConfig.getBrokerUrl());
        activeMQConnectionFactory.setUserName(activemqConfig.getUser());
        activeMQConnectionFactory.setPassword(activemqConfig.getPassword());
        activeMQConnectionFactory.setTrustAllPackages(activemqConfig.getTrustAll());
        return activeMQConnectionFactory;
    }
}
