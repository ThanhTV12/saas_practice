package com.thanh.practice.application.business;

import com.thanh.practice.application.base.camel.AbstractCamelContextListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class SaasContextListener extends AbstractCamelContextListener {
    @Autowired
    public SaasContextListener(ApplicationContext applicationContext) {
        super(applicationContext);
    }
}
