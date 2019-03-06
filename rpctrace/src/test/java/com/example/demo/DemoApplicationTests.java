package com.example.demo;

import com.example.demo.dao.*;
import com.example.demo.entity.LoginEvent;
import com.example.demo.dao.OnlyUserId;
import com.example.demo.entity.RegisterEvent;
import com.sun.org.apache.bcel.internal.generic.LSTORE;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.zip.CheckedOutputStream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    CustomEventDao customEventDao;
    @Autowired
    ClientAppKeyDao clientAppKeyDao;
    @Autowired
    RegisterEventDao registerEventDao;
    @Autowired
    LoginEventDao loginEventDao;
    @Test
    public void contextLoads() throws ParseException {
        //System.out.println(customEventDao.findAll().toString());
        String startStr = "2018.1.1 00:00:00";
        String mse = "2019.1.1 00:00:11";
        String mid = "2019.1.1 00:00:22";
        String endStr = "2019.3.3 23:59:59";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        Date start = sdf.parse(startStr);
        Date ms = sdf.parse(mse);
        Date mi = sdf.parse(mid);
        Date end = sdf.parse(endStr);
        /*RegisterEvent registerEvent =new RegisterEvent();
        registerEvent.setTime(ms);
        //registerEventDao.save(registerEvent);
        int aa=registerEventDao.countRegisterEventByTimeBetween(start,end);
        System.out.println(aa);*/
        LoginEvent loginEvent =new LoginEvent();
        loginEvent.setUserId(2);
        loginEvent.setTime(mi);
        //loginEventDao.save(loginEvent);
        List<OnlyUserId> aa= loginEventDao.findByTimeIsBetween(start,end);
        //List<Integer> userIds = new ArrayList<Integer>();
        LinkedHashSet<Integer> userIds = new LinkedHashSet<>();
        for(OnlyUserId e:aa){
            userIds.add(e.getUserId());
        }
        System.out.println(userIds.size());
        
//
//        System.out.println(customEventDao.findByTimeBetween(start,end));
        System.out.println(clientAppKeyDao.findByAppKey("123456789"));
    }

}

