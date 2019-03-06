package com.example.demo.dao;

import com.example.demo.entity.LeaveEvent;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author sxp
 * @create 2019-03-06 18:28
 **/

public interface LeaveEventDao extends MongoRepository<LeaveEvent,ObjectId> {
    @Override
    List<LeaveEvent> findAll();
}
