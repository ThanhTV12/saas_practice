package com.thanh.practice.application.business;

import com.thanh.practice.application.business.aop.ServiceAop;
import com.thanh.practice.application.business.config.ActiveMQBeanConfig;
import com.thanh.practice.application.business.config.DataSourceConfig;
import com.thanh.practice.application.business.config.SaasConfig;
import com.thanh.practice.application.business.di.CoreModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;

@SpringBootApplication
@EnableConfigurationProperties(SaasConfig.class)
@Import({ActiveMQBeanConfig.class,
        CoreModule.class,
        DataSourceConfig.class
})
@ServletComponentScan(basePackages = "com.thanh.practice")
@Service
public class BusinessApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(BusinessApplication.class, args);
    }

    @Autowired
    private SaasConfig saasConfig;


    @Autowired
    private ServiceAop serviceAop;


//    @Override
//    public void run(ApplicationArguments applicationArguments) throws Exception {
////        System.out.println("hello hello");
////
////        System.out.println("instance_name: " + saasConfig.getSystem().getDeploy().getInstanceName());
////
////        CamelContext context = new DefaultCamelContext();
////
////        ProducerTemplate producer = context.createProducerTemplate();
////
////        String env = "dev";
////        String tennat = "nvn";
////        String test_queue = String.format(EndpointDefinition.TEST_QUEUE, env, tennat);
////        TestModel body = new TestModel();
////        body.setId(1);
////        body.setName("test123456789");
////        producer.sendBody(test_queue, body);
//
//    }


    @Override
    public void run(String... strings) throws Exception {
        serviceAop.serve();
    }
}
