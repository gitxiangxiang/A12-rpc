package com.example.demo.controller;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author sxp
 * @create 2019-03-06 10:41
 **/
@Controller
public class ComponentController {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(PVController.class);

    @RequestMapping("/component")
    @ResponseBody
    public String component(@RequestBody String s){
        logger.info(s);
        return "";
    }
}
