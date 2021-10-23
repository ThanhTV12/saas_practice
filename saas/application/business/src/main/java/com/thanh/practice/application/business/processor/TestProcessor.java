package com.thanh.practice.application.business.processor;

import com.thanh.practice.application.base.camel.AbstractProcessor;
import com.thanh.practice.application.business.model.TestModel;
import com.thanh.practice.saas.model.common.constant.LogLevelType;
import com.thanh.practice.saas.service.core.ServiceContext;
import org.apache.camel.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestProcessor extends AbstractProcessor {

    @Autowired
    public TestProcessor(ServiceContext serviceContext) {
        super(serviceContext);
    }

    @Override
    public void process(Exchange exchange) throws Exception {
        this.logger.log(LogLevelType.INFO, "process ---- starting ---- " );
        TestModel testModel = exchange.getIn().getBody(TestModel.class);
        this.logger.log(LogLevelType.INFO, "process testModel: {}", testModel.toString());
    }
}
