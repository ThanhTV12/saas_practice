package com.thanh.practice.application.business.route;

import com.thanh.practice.application.base.camel.AbstractRoute;
import com.thanh.practice.application.business.processor.TestErrorHandlerProcessor;
import com.thanh.practice.application.business.processor.TestProcessor;
import com.thanh.practice.saas.service.core.ServiceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestRoute extends AbstractRoute {

    private final TestProcessor testProcessor;
    private final TestErrorHandlerProcessor testErrorHandlerProcessor;

    @Autowired
    public TestRoute(ServiceContext serviceContext,
                     TestProcessor testProcessor, TestErrorHandlerProcessor testErrorHandlerProcessor) {
        super(serviceContext);
        this.testProcessor = testProcessor;
        this.testErrorHandlerProcessor = testErrorHandlerProcessor;
    }

    @Override
    public void configure() throws Exception {
//        String env = "dev";
//        String tennat = "nvn";
//        String test_queue = String.format(EndpointDefinition.TEST_QUEUE, env, tennat);
//        from(test_queue).doTry().process(testProcessor)
//                .doCatch(Exception.class).process(testErrorHandlerProcessor);
    }
}
