package com.thanh.practice.application.business.processor;

import com.thanh.practice.application.base.camel.AbstractProcessor;
import com.thanh.practice.saas.service.core.ServiceContext;
import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

@Component
public class TestErrorHandlerProcessor extends AbstractProcessor {

    public TestErrorHandlerProcessor(ServiceContext serviceContext) {
        super(serviceContext);
    }

    @Override
    public void process(Exchange exchange) throws Exception {
        System.out.println("TestErrorHandlerProcessor: --------");
        System.out.println(exchange);
    }
}
