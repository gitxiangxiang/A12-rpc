package com.example.demo.controller;

import com.example.demo.entity.LoginEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author sxp
 * @create 2019-03-06 20:35
 **/
@Controller
public class RegisterEventController {
    @Autowired
    MongoTemplate mongoTemplate;

    @RequestMapping("/RegisterEvent")
    public String loginEvent(@RequestBody LoginEvent loginEvent){
        mongoTemplate.save(loginEvent,"RegisterEvent");
        return "";
    }
}
