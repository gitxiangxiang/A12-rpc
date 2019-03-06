package com.example.demo.dao;

import com.example.demo.entity.CustomEvent;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

/**
 * @author sxp
 * @create 2019-02-20 16:49
 **/

public interface CustomEventDao extends MongoRepository<CustomEvent,Integer> {
    @Override
    List<CustomEvent> findAll();
    List<CustomEvent> findByTimeBetween(Date date1,Date date2);

}
