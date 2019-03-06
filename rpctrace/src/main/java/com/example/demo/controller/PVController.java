package com.example.demo.controller;

import com.example.demo.entity.PageView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * @author sxp
 * @create 2019-02-02 17:37
 **/
@RestController
public class PVController {
    private static final Logger logger = LoggerFactory.getLogger(PVController.class);
    @Autowired
    MongoTemplate mongoTemplate;
    @PostMapping("/pageview")
    public String pageView(@RequestBody PageView pageView){
        logger.info(pageView.toString());
        mongoTemplate.save(pageView);
        return "";
    }
}
