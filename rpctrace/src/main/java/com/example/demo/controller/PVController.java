package com.example.demo.controller;

import com.example.demo.entity.PageView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author sxp
 * @create 2019-02-02 17:37
 **/
@RestController
public class PVController {
    @RequestMapping("/pageview")
    public String pageView(@RequestBody PageView pageView){
        System.out.println(pageView);
        return "";
    }
}
