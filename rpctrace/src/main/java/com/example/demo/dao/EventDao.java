package com.example.demo.dao;

import com.example.demo.entity.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.List;

/**
 * @author sxp
 * @create 2019-02-28 8:09
 **/
public interface EventDao extends MongoRepository<Event,Integer> {
    @Override
    List<Event> findAll();
//    @Query("db.sxpdb.find({\"time\":{$gt:?1}},{\"time\":{$lt:?2}})")
    //List<Event> findByTimeBetween(Date date1,Date date2);
}
