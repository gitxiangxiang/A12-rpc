package com.example.demo.config;

import com.example.demo.entity.PageView;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author sxp
 * @create 2019-02-02 17:35
 **/
@Configuration
public class beanContainer {
    @Bean
    public PageView pageView(){
        return new PageView();
    }
}
