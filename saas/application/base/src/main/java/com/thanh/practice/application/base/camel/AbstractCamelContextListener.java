package com.thanh.practice.application.base.camel;

import org.apache.camel.management.event.CamelContextStartedEvent;
import org.apache.camel.management.event.CamelContextStoppingEvent;
import org.apache.camel.support.EventNotifierSupport;
import org.springframework.context.ApplicationContext;

import java.util.EventObject;

public abstract class AbstractCamelContextListener extends EventNotifierSupport {

    protected final ApplicationContext applicationContext;

    public AbstractCamelContextListener(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
//
//    private void onInitContext(CamelContext camelContext) {
////        startGrpcServer();
//    }
//
//    protected abstract AbstractGrpcRegister getGrpcRegister();

//    private void startGrpcServer() {
//        SaasConfig saasConfig = applicationContext.getBean(SaasConfig.class);
//        ServerBuilder<?> serverBuilder = ServerBuilder.forPort(saasConfig.getSystem().getDeploy().getPort());
//        for (BindableService bindableService : getGrpcRegister().serviceRegister()) {
//            serverBuilder.addService(bindableService);
//        }
//        for (ServerInterceptor serverInterceptor : getGrpcRegister().interceptorRegister()) {
//            serverBuilder.intercept(serverInterceptor);
//        }
//        GrpcServer grpcServer = new GrpcServer(serverBuilder.build());
//        grpcServer.start();
//
//        ((GenericApplicationContext) applicationContext).getBeanFactory().registerSingleton("grpcServer", grpcServer);
//    }
//
//    private void onDestroyContext(CamelContext camelContext) {
//        stopGrpcServer();
//        closeCassandraConnection();
//    }
//
//    private void closeCassandraConnection() {
//        ServiceContext serviceContext = applicationContext.getBean(ServiceContext.class);
//        serviceContext.getCassandraCQLClient().shutdown();
//    }
//
//    private void stopGrpcServer() {
//        GrpcServer grpcServer = (GrpcServer) applicationContext.getBean("grpcServer");
//        if (grpcServer != null) {
//            grpcServer.stopServer();
//        }
//
//    }

    @Override
    public void notify(EventObject event) throws Exception {
        System.out.println("AbstractCamelContextListener::notify____");
        if (event instanceof CamelContextStartedEvent) {
            CamelContextStartedEvent camelContextStartedEvent = (CamelContextStartedEvent) event;
//            onInitContext(camelContextStartedEvent.getContext());
        } else if (event instanceof CamelContextStoppingEvent) {
            CamelContextStoppingEvent camelContextStoppingEvent = (CamelContextStoppingEvent) event;
//            onDestroyContext(camelContextStoppingEvent.getContext());
        }
    }

    @Override
    public boolean isEnabled(EventObject event) {
        if (event instanceof CamelContextStartedEvent || event instanceof CamelContextStoppingEvent) {
            return true;
        }
        return false;
    }
}
