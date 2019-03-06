package com.example.demo.dao;

import com.example.demo.entity.ClientAppKey;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author sxp
 * @create 2019-03-05 19:26
 **/
public interface ClientAppKeyDao extends MongoRepository<ClientAppKey,ObjectId> {
    @Override
    List<ClientAppKey> findAll();
    ClientAppKey findByAppKey(String appKey);
}
