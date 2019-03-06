package com.example.demo.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * @author sxp
 * @create 2019-03-05 19:23
 **/
@Document(collection = "ClientAppKey")
public class ClientAppKey implements Serializable {

    @Id
    private ObjectId id;
    private String appKey;

    public ObjectId getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ClientAppKey{" +
                "id=" + id +
                ", appKey='" + appKey + '\'' +
                '}';
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public ClientAppKey() {

    }
}
