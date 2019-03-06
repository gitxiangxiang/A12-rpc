package com.example.demo.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author sxp
 * @create 2019-03-05 16:48
 **/
@Document(collection = "RegisterEvent")
public class RegisterEvent implements Serializable {

    @Id
    private ObjectId id;
    private String eventName;
    private String clientId;
    private int userId;
    @DateTimeFormat(pattern = "yy-MM-dd HH-mm-ss E")
    private Date time;

    public RegisterEvent() {
    }

    @Override
    public String toString() {
        return "RegisterEvent{" +
                "id=" + id +
                ", eventName='" + eventName + '\'' +
                ", clientId='" + clientId + '\'' +
                ", userId=" + userId +
                ", time=" + time +
                '}';
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
