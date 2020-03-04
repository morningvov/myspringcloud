package com.momo.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author momo
 * @create 2020-03-01 下午 18:49
 */
@SpringBootApplication
@EnableEurekaServer   //EurekaServer服务器端启动类，接收其他微服务注册进来
public class Config_Git_EurekaServer7001_App {
    public static void main(String[] args) {
        SpringApplication.run(Config_Git_EurekaServer7001_App.class, args);
    }
}
