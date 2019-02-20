package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author sxp
 * @create 2019-02-10 23:56
 **/
@Configuration
public class ViewConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //registry.addViewController("/").setViewName("login");
        registry.addViewController("/toLogin").setViewName("login");
        registry.addViewController("/main").setViewName("main");
        registry.addViewController("/dash").setViewName("dashboard");
    }
}
