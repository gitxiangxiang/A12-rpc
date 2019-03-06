package com.example.demo.dao;

import com.example.demo.entity.PageView;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author sxp
 * @create 2019-03-05 20:10
 **/
public interface PageViewDao extends MongoRepository<PageView,ObjectId> {
    @Override
    List<PageView> findAll();
}
