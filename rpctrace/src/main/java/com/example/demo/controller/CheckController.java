package com.example.demo.controller;

import com.example.demo.dao.ClientAppKeyDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author sxp
 * @create 2019-03-05 20:31
 **/
@Controller
public class CheckController {

    private static final Logger logger = LoggerFactory.getLogger(PVController.class);

    @Autowired
    ClientAppKeyDao clientAppKeyDao;

    @RequestMapping("/check")
    @ResponseBody
    public String check(String appKey){
        if(clientAppKeyDao.findByAppKey(appKey) != null){
            return "true";
        }else return "false";
    }
}
