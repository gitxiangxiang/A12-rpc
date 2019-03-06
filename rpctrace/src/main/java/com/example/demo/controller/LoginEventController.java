package com.example.demo.controller;

import com.example.demo.entity.LoginEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author sxp
 * @create 2019-03-06 20:31
 **/
@Controller
public class LoginEventController {
    @Autowired
    MongoTemplate mongoTemplate;

    @RequestMapping("/loginEvent")
    public String loginEvent(@RequestBody LoginEvent loginEvent){
        mongoTemplate.save(loginEvent,"LoginEvent");
        return "";
    }
}
