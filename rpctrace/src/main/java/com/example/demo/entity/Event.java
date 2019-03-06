package com.example.demo.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * @author sxp
 * @create 2019-02-25 16:40
 **/
//@Document(collection = "Event")
public class Event implements Serializable {

    private static final long serialVersionUID = -60781486773939584L;
    @Id
    private ObjectId eventId;
    private String eventName;
    private String clientId;
    private Object event;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventId=" + eventId +
                ", eventName='" + eventName + '\'' +
                ", clientId='" + clientId + '\'' +
                ", event=" + event +
                '}';
    }

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

    public Object getEvent() {
        return event;
    }

    public void setEvent(Object event) {
        this.event = event;
    }

    public Event() {

    }

    public Event(String eventName, String clientId, Object event) {
        this.eventName = eventName;
        this.clientId = clientId;
        this.event = event;
    }
}
