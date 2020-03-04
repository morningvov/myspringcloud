package com.momo.springcloud;

import com.momo.ribbon.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author momo
 * @create 2020-03-01 下午 18:27
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name="springcloud-provider-dept",configuration= MySelfRule.class)
public class DeptConsumer80_App {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer80_App.class, args);
    }
}
