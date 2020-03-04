package com.momo.springcloud.controller;

import com.momo.springcloud.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author momo
 * @create 2020-03-01 下午 18:18
 */
@RestController
public class DeptController_Consumer {

    /**
        使用使用restTemplate访问restful接口非常的简单粗暴无脑。
        (url, requestMap, ResponseBean.class)
        这三个参数分别代表 REST请求地址、请求参数、HTTP响应转换被转换成的对象类型。
     */
//    private static final String RESTFUL_URL_PREfIX="http://localhost:8001";
    private static final String RESTFUL_URL_PREfIX="http://springcloud-provider-dept";


    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping(value = "/consumer/dept/add")
    public boolean add(Dept dept) {
        return restTemplate.postForObject(RESTFUL_URL_PREfIX+"/dept/add",dept,Boolean.class);
    }

    @RequestMapping(value = "/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return restTemplate.getForObject(RESTFUL_URL_PREfIX+"/dept/get/"+id,Dept.class);
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/consumer/dept/list")
    public List<Dept> list() {
        return restTemplate.getForObject(RESTFUL_URL_PREfIX+"/dept/list",List.class);
    }

    // 测试@EnableDiscoveryClient,消费端可以调用服务发现
    @RequestMapping(value = "/consumer/dept/discovery")
    public Object discovery() {
        return restTemplate.getForObject(RESTFUL_URL_PREfIX + "/dept/discovery", Object.class);
    }
}
