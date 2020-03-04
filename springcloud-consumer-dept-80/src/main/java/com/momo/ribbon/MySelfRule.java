package com.momo.ribbon;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author momo
 * @create 2020-03-02 下午 18:55
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule(){
        //自定义轮询每台机器五次
        return new RandomRule_MO();
    }
}
