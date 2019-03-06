package com.example.demo;

import com.example.demo.dao.ClientAppKeyDao;
import com.example.demo.dao.CustomEventDao;
import com.example.demo.dao.EventDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.CheckedOutputStream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    CustomEventDao customEventDao;
    @Autowired
    ClientAppKeyDao clientAppKeyDao;
    @Test
    public void contextLoads() throws ParseException {
        //System.out.println(customEventDao.findAll().toString());
//        String startStr = "2019.1.1 00:00:00";
//        String endStr = "2019.3.1 23:59:59";
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
//        Date start = sdf.parse(startStr);
//        Date end = sdf.parse(endStr);
//        System.out.println(customEventDao.findByTimeBetween(start,end));
        System.out.println(clientAppKeyDao.findByAppKey("123456789"));
    }

}

