package com.thanh.practice.application.business.processor.one;

import com.thanh.practice.application.base.camel.AbstractProcessor;
import com.thanh.practice.application.business.model.TestModel;
import com.thanh.practice.saas.model.common.constant.LogLevelType;
import com.thanh.practice.saas.service.core.ServiceContext;
import org.apache.camel.Attachment;
import org.apache.camel.Exchange;
import org.apache.camel.InvalidPayloadException;
import org.apache.camel.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.activation.DataHandler;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

@Component
public class OneProcessor extends AbstractProcessor {

    @Autowired
    public OneProcessor(ServiceContext serviceContext) {
        super(serviceContext);
    }

    @Override
    public void process(Exchange exchange) throws Exception {
        TimeUnit.SECONDS.sleep(2);
        this.logger.log(LogLevelType.INFO, "process one: " );
        TestModel testModel = exchange.getIn().getBody(TestModel.class);
        this.logger.log(LogLevelType.INFO, "process::data: {}", testModel.toString());

//        throw new Exception("Hello____");
        testModel.setId(testModel.getId() + 1);
//        exchange.getIn().setBody(testModel);
        exchange.getOut().setBody(testModel);

    }
}
