package com.example.demo.dao;

import com.example.demo.entity.LoginEvent;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author sxp
 * @create 2019-03-05 19:35
 **/
public interface LoginEventDao extends MongoRepository<LoginEvent,ObjectId> {
    @Override
    List<LoginEvent> findAll();
}
