package com.thanh.practice.application.business.controller;

import com.thanh.practice.application.base.client.ClientRequest;
import com.thanh.practice.application.base.controller.AbstractController;
import com.thanh.practice.application.business.aop.ServiceAop;
import com.thanh.practice.application.business.model.TestModel;
import com.thanh.practice.application.business.procedure.EndpointProcedure;
import com.thanh.practice.saas.infrastructure.storage.jpa.entity.Employee;
import com.thanh.practice.saas.infrastructure.storage.jpa.entity.EmployeeInfo;
import com.thanh.practice.saas.infrastructure.storage.jpa.entity.OrderDetail;
import com.thanh.practice.saas.infrastructure.storage.jpa.entity.User;
import com.thanh.practice.saas.model.common.constant.LogLevelType;
import com.thanh.practice.saas.service.core.ServiceContext;
import com.thanh.practice.saas.service.employee.EmployeeService;
import com.thanh.practice.saas.service.hibernate.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class TestController extends AbstractController {

    private final ServiceContext serviceContext;
    private final EmployeeService employeeService;
    private final UserService userService;



    private final String tenatId = "nvn";

    private final String env = "dev";
    private final String tennat = "nvn";

    @Autowired
    public TestController(ServiceContext serviceContext) {
        super(serviceContext);
        this.serviceContext = serviceContext;
        employeeService = serviceContext.getInstance(EmployeeService.class);
        userService = serviceContext.getInstance(UserService.class);
    }

    @GetMapping(path = "/api/test")
    public void test() {
        logger.log(LogLevelType.INFO, "test");
//        ServiceRequest serviceRequest = new ServiceRequest();
//        serviceRequest.setUsername("thanhtv3");
//        serviceRequest.setUserId("abcde");
//        serviceRequest.setUserAgent("TOPICA");
//        ServiceLogger serviceLogger = serviceContext.getServiceLogger(tenatId, this.getClass());
//        serviceLogger.log(LogLevelType.INFO, TestController.class, serviceRequest,"adapter/provision___");


//        ProducerTemplate producer = serviceContext.getProducerTemplate();
//
//        String test_queue = String.format(EndpointDefinition.TEST_QUEUE, env, tennat);
//        TestModel body = new TestModel(1, "test_____");
//
//        serviceLogger.log(LogLevelType.INFO, "before enqueue ---");
//        serviceContext.enqueue(test_queue, body);
//        serviceLogger.log(LogLevelType.INFO, "After enqueue ---");

//        Map<String, Object> headerMap = new HashMap<>();
//        headerMap.put("JMSCorrelationID", "abcfdfdf");
//
//        producer.sendBodyAndHeaders(test_queue, body, headerMap);

        return;
    }


    @PostMapping(path = "/test/exchange/data/camel")
    public void testExchangeDataCamel(HttpServletRequest request, HttpServletResponse response) {
        ClientRequest clientRequest = this.getClientRequest(request);
        String test_queue = String.format(EndpointProcedure.PROCEDURE_ONE, env, tennat);
        TestModel body = new TestModel(1, "test_____");

        serviceContext.enqueue(EndpointProcedure.PROCEDURE_ONE, body);
    }


    @PostMapping(path = "/test/transaction/onedatabase/employee")
    public void testTransactionOneDatabase(HttpServletRequest request, HttpServletResponse response) {
        Employee employee = new Employee();
        employee.setAge(27);
        employee.setAddress("Hanoi");
        employee.setName("Nam");

        EmployeeInfo employeeInfo = new EmployeeInfo();
        employeeInfo.setIsMarred(true);
        employeeInfo.setSalary(100);
        employeeInfo.setSex(EmployeeInfo.SEX.MALE);

        Employee employeeOut = employeeService.create(employee, employeeInfo);
        logger.log(LogLevelType.INFO, "output transaction onedatabase employee - employee: {} ", employee.toString());
    }


    @GetMapping(path = "/get/employee")
    public Employee getEmployee(HttpServletRequest request, HttpServletResponse response,
                                          @RequestParam(name = "employeeId") Integer employeeId) throws Exception {
        logger.log(LogLevelType.INFO, "getEmployee::employeeId: {}", employeeId);
        Employee employee = employeeService.getEmployee(employeeId);
        EmployeeInfo employeeInfo = employeeService.getEmployeeInfo(employeeId);
        employee.setEmployeeInfo(employeeInfo);
        return employee;
    }

    @GetMapping(path = "/get/users")
    public List<User> getUserService(HttpServletRequest request, HttpServletResponse response) {
        List<User> users = userService.loadAll();
        System.out.println("users");
        List<String> usernames = users.stream().map(user -> {
            return user.getName();
        }).collect(Collectors.toList());
        System.out.println("usernames: " + usernames.toString());

        System.out.println("print detail user 0");
        System.out.println(users.get(0).toString());
        System.out.println("print detail user 1s");
        System.out.println(users.get(1).toString());

        System.out.println("return subList");
        System.out.println(users.subList(0, 1).toString());
        return users;
    }


    @GetMapping(path = "/get/orders")
    public List<OrderDetail> getOrders(HttpServletRequest request, HttpServletResponse response) {
        List<OrderDetail> orderDetails = userService.findAllOrder();
        System.out.println("orderDetails");
        List<String> products = orderDetails.stream().map(orderDetail -> {
            return orderDetail.getProductId().toString();
        }).collect(Collectors.toList());
        System.out.println("products: " + products.toString());

        System.out.println("print detail orderDetails 0");

        System.out.println(orderDetails.get(0).toString());
        System.out.println("print detail orderDetails 1");
        System.out.println(orderDetails.get(1).toString());
        return orderDetails.subList(0, 2);
    }

    @PostMapping(path = "/user")
    public List<User> saveUser(HttpServletRequest request, HttpServletResponse response) {
        List<User> usersInput = new ArrayList<>();
        for(Integer i = 10; i < 20; i++) {
            User user = new User();
            user.setName("User " + i.toString());
            userService.saveOne(user);
//            usersInput.add(user);
        }
//        usersInput = userService.save(usersInput);
        return usersInput;
    }

    @Autowired
    private ServiceAop serviceAop;

    @PostMapping(path = "/test/aop")
    public void testAop() throws InterruptedException{
        System.out.println("testAop");
        serviceAop.serve();
    }

}
