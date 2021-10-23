package com.thanh.practice.application.business.processor.one;

import com.thanh.practice.application.base.camel.AbstractProcessor;
import com.thanh.practice.saas.service.core.ServiceContext;
import org.apache.camel.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OneErrorHandleProcessor extends AbstractProcessor {

    @Autowired
    protected OneErrorHandleProcessor(ServiceContext serviceContext) {
        super(serviceContext);
    }

    @Override
    public void process(Exchange exchange) throws Exception {
        System.out.println("OneErrorHandleProcessor::");
        System.out.println("exchange");
        System.out.println(exchange.getIn().toString());
    }
}
