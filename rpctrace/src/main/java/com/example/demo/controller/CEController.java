package com.example.demo.controller;

import com.example.demo.entity.CustomEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

/**
 * @author sxp
 * @create 2019-02-25 20:21
 **/
@Controller
public class CEController {
    private static final Logger logger = LoggerFactory.getLogger(CustomEventController.class);

    @Autowired
    ObjectMapper mapper;

    @Autowired
    MongoTemplate mongoTemplate;

    @ResponseBody
    @PostMapping("/leave")
    public String customEvent(@RequestBody String event) throws IOException {
        //CustomEvent customEvent = mapper.readValue(s,CustomEvent.class);
        logger.info(event);
        Document doc = Document.parse(event);
        //mongoTemplate.save(doc,"CustomEvent");

        return "";
    }
}
