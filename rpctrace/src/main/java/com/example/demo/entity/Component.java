package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author sxp
 * @create 2019-03-06 21:16
 **/
@Document(collection = "Component")
public class Component {

    @Id
    private ObjectId eventId;
    private String eventName;
    @JsonProperty("appKey")
    private String clientId;
    private int userId;
}
