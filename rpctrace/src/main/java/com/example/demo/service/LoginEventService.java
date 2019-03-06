package com.example.demo.service;

import com.example.demo.dao.LoginEventDao;
import com.example.demo.dao.OnlyUserId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;

@Service
public class LoginEventService {
    @Autowired
    LoginEventDao loginEventDao;
    public int getLoginCount(Date date1,Date date2){
        List<OnlyUserId> aa = loginEventDao.findByTimeIsBetween(date1,date2);
        LinkedHashSet<Integer> userIds = new LinkedHashSet<>();
        for(OnlyUserId e:aa){
            userIds.add(e.getUserId());
        }
        return userIds.size();
    }
}
