package com.example.demo.controller;

import com.example.demo.entity.CustomEvent;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sxp
 * @create 2019-02-15 22:21
 **/
@Controller
public class CustomEventController {
    private static final Logger logger = LoggerFactory.getLogger(CustomEventController.class);

    @Autowired
    ObjectMapper mapper;

    @Autowired
    MongoTemplate mongoTemplate;

    @ResponseBody
    @PostMapping("/customEvent")
    public String customEvent(@RequestBody List<CustomEvent> customEvents) throws IOException {
        //CustomEvent customEvent = mapper.readValue(s,CustomEvent.class);
        logger.info(customEvents.toString());
        for (CustomEvent customEvent : customEvents) {
            mongoTemplate.save(customEvent, "CustomEvent");
//            Document doc = Document.parse(mapper.writeValueAsString(customEvent));
//            mongoTemplate.save(doc,"CustomEvent");
        }
        return "";
    }
}
