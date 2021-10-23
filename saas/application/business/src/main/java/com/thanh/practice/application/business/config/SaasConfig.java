package com.thanh.practice.application.business.config;

import com.thanh.practice.saas.infrastructure.common.config.BaseConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "saas")
public class SaasConfig extends BaseConfig {

}
