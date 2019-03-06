package com.example.demo.controller;

import com.example.demo.dao.PageViewDao;
import com.example.demo.entity.LeaveEvent;
import com.example.demo.entity.PageView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author sxp
 * @create 2019-03-06 17:59
 **/
@Controller
public class LeaveController {

    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    PageViewDao pageViewDao;

    @PostMapping("/leave")
    @ResponseBody
    public String leave(@RequestBody LeaveEvent leaveEvent){
        PageView pageView = pageViewDao.findFirstByTimeBeforeAndUserIdIsAndEndTimeIsNull(leaveEvent.getTime(),leaveEvent.getUserId());
        if(pageView != null){
            pageView.setEndTime(leaveEvent.getTime());
            pageViewDao.save(pageView);
        }
        return "";
    }
}
