package com.momo.springboot.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author momo
 * @create 2020-03-04 下午 17:04
 */
@RestController
public class ConfigClientRest {

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${eureka.client.service-url.defaultZone}")
    private String eurekaServers;

    @Value("${server.port}")
    private String port;

    @RequestMapping("/config")
    public String getConfig(){
        String str = "applicationName: "+applicationName+"\t eurekaServers: "+eurekaServers+"\t port:"+port;
        System.out.println("******str: "+str);
        return str;
    }

}
