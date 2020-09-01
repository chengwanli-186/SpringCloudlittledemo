package com.kuang.springcloud.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {  //@Configuration注解的类相当于spring中的applicationContext.xml
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
