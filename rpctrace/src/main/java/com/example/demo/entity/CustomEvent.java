package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sxp
 * @create 2019-02-15 22:24
 **/
@Document(collection = "CustomEvent")
public class CustomEvent implements Serializable{

    private static final long serialVersionUID = -60781486773939584L;

    @Id
    private ObjectId eventId;
    private String eventName;
    @JsonProperty("appKey")
    private String clientId;
    private int userId;
    @JsonProperty("eventName")
    private String CustomEventName
            ;
    private Map eventInfo = new HashMap();
    //@JsonFormat(pattern = "yy-MM-dd HH-mm-ss",timezone = "GMT+8")
    //@JsonIgnore
    //@CreatedDate
    @DateTimeFormat(pattern = "yy-MM-dd HH-mm-ss E")
    private Date time;

    public ObjectId getEventId() {
         return eventId;
    }

    public void setEventId(ObjectId eventId) {
        this.eventId = eventId;
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



    @Override
    public String toString() {
        return "CustomEvent{" +
                "userId=" + userId +
                ", CustomEventName='" + CustomEventName + '\'' +
                ", eventInfo=" + eventInfo +
                ", time=" + time +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }



    public String getCustomEventName() {
        return CustomEventName;
    }

    public void setCustomEventName(String CustomEventName) {
        this.CustomEventName = CustomEventName;
    }

    public Map getEventInfo() {
        return eventInfo;
    }

    public void setEventInfo(Map eventInfo) {
        this.eventInfo = eventInfo;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public CustomEvent() {
    }
}
