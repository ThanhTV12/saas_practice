package com.thanh.practice.application.business.aop;

import org.springframework.stereotype.Component;

@Component
public class ServiceAop {
    @LogExecutionTime
    public void serve() throws InterruptedException {
        System.out.println("start::serve");
//        Thread.sleep(2000);
        System.out.println("end::serve");
    }
}
