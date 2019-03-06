package com.example.demo.dao;

import com.example.demo.entity.RegisterEvent;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author sxp
 * @create 2019-03-05 19:36
 **/
public interface RegisterEventDao extends MongoRepository<RegisterEvent,ObjectId> {
    @Override
    List<RegisterEvent> findAll();
}
