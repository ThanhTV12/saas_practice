package com.thanh.practice.web.webtwo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = "com.thanh.practice.web.base.servlet")
@ComponentScan(basePackages = {"com.thanh.practice.web.base"})
public class WebTwoApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebTwoApplication.class, args);
    }
}
