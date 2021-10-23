package com.thanh.practice.application.business.endpoint;

import com.thanh.practice.application.base.camel.AbstractRoute;
import com.thanh.practice.application.business.processor.one.OneProcessor;
import com.thanh.practice.application.business.processor.two.TwoProcessor;
import com.thanh.practice.saas.infrastructure.common.queue.EndpointProcessor;
import com.thanh.practice.saas.service.core.ServiceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BusinessEndpointDefinition extends AbstractRoute {

    private final OneProcessor oneProcessor;
    private final TwoProcessor twoProcessor;

    @Autowired
    public BusinessEndpointDefinition(ServiceContext serviceContext,
                                      OneProcessor oneProcessor, TwoProcessor twoProcessor) {
        super(serviceContext);
        this.oneProcessor = oneProcessor;
        this.twoProcessor = twoProcessor;
    }


    @Override
    public void configure() throws Exception {
        from(EndpointProcessor.TEST_ONE).doTry().process(oneProcessor);
        from(EndpointProcessor.TEST_TWO).doTry().process(twoProcessor);
    }
}
