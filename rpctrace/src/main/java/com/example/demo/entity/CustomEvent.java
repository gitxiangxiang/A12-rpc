package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sxp
 * @create 2019-02-15 22:24
 **/
public class CustomEvent {
    private String eventName;
    private Map eventInfo = new HashMap();
    //@JsonFormat(timezone = "GMT+8")
    private Date time;

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
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

    @Override
    public String toString() {
        return "CustomEvent{" +
                "eventName='" + eventName + '\'' +
                ", eventInfo=" + eventInfo +
                ", time=" + time +
                '}';
    }

    public CustomEvent() {
    }
}
