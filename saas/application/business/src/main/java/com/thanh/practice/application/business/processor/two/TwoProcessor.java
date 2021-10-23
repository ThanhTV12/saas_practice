package com.thanh.practice.application.business.processor.two;

import com.thanh.practice.application.base.camel.AbstractProcessor;
import com.thanh.practice.application.business.model.TestModel;
import com.thanh.practice.saas.model.common.constant.LogLevelType;
import com.thanh.practice.saas.service.core.ServiceContext;
import org.apache.camel.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class TwoProcessor extends AbstractProcessor {

    @Autowired
    public TwoProcessor(ServiceContext serviceContext) {
        super(serviceContext);
    }

    @Override
    public void process(Exchange exchange) throws Exception {
        TimeUnit.SECONDS.sleep(2);
        this.logger.log(LogLevelType.INFO, "process two" );
        TestModel testModel = exchange.getIn().getBody(TestModel.class);
        this.logger.log(LogLevelType.INFO, "process::data: {}", testModel.toString());
        testModel.setId(testModel.getId() + 1);
        exchange.getOut().setBody(testModel);
    }
}
