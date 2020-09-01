package com.kuang.springcloud.controller;


import com.kuang.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@RestController
public class DeptConsumerController {

    //理解：消费者按功能讲是不应该有service层的，因为service可以通过浏览器的URL去请求~
    //SpringBoot支持Reastful风格的请求
    //RestTemplate...供我们直接调用就可以了！注册到spring中~

    @Autowired
    private RestTemplate restTemplate;  //restTemplate其实就是提供多种便捷访问远程http服务的方法，是一种简单的Restful风格的服务模板

    private static final String REST_URL_PREFIX = "http://localhost:8001";

    @RequestMapping("/consumer/dept/add")
    public boolean add(Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add",dept,Boolean.class);
    }

    //按下面这样写，这个消费者类和service服务模块就没有关系了，已经完全解耦了，这里是通过URL直接访问的
    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") long id){
        //(url,实体:Map , class<T> responseType)
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id, Dept.class);
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> list(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list",List.class);
    }
}
