package com.thanh.practice.application.business.route;

import com.thanh.practice.application.base.camel.AbstractRoute;
import com.thanh.practice.application.business.procedure.EndpointProcedure;
import com.thanh.practice.application.business.processor.one.OneErrorHandleProcessor;
import com.thanh.practice.application.business.processor.one.OneProcessor;
import com.thanh.practice.application.business.processor.two.TwoProcessor;
import com.thanh.practice.saas.infrastructure.common.queue.EndpointProcessor;
import com.thanh.practice.saas.service.core.ServiceContext;
import org.springframework.stereotype.Component;

@Component
public class TestExchangeData extends AbstractRoute {

    private final OneProcessor oneProcessor;
    private final TwoProcessor twoProcessor;

    private final OneErrorHandleProcessor oneErrorHandleProcessor;

    public TestExchangeData(ServiceContext serviceContext,
                            OneProcessor oneProcessor, TwoProcessor twoProcessor,
                            OneErrorHandleProcessor oneErrorHandleProcessor) {
        super(serviceContext);
        this.oneProcessor = oneProcessor;
        this.twoProcessor = twoProcessor;
        this.oneErrorHandleProcessor = oneErrorHandleProcessor;
    }

    @Override
    public void configure() throws Exception {
        String env = "dev";
        String tennat = "nvn";
//        from(EndpointProcedure.PROCEDURE_ONE)
//                .inOut(EndpointDefinition.TEST_ONE)
//                .inOnly(EndpointDefinition.TEST_TWO);
////
//        from(EndpointProcedure.PROCEDURE_ONE)
//                .pipeline(EndpointDefinition.TEST_ONE, EndpointDefinition.TEST_TWO);

        from(EndpointProcedure.PROCEDURE_ONE).doTry().process(oneProcessor).doTry().process(twoProcessor);

        /* pipeline */
//        from(EndpointProcedure.PROCEDURE_ONE).to(EndpointProcessor.TEST_ONE);
//        from(EndpointProcessor.TEST_ONE).to(EndpointProcessor.TEST_TWO);
    }
}
