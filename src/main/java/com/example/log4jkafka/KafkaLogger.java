package com.example.log4jkafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class KafkaLogger {
    private final Logger logger;
    ObjectMapper objectMapper = new ObjectMapper();

    public KafkaLogger( Class clazz ) {
        logger = LoggerFactory.getLogger(clazz);
    }

    public static KafkaLogger getLogger( Class clazz ) {
        return new KafkaLogger(clazz);
    }

    public void KDatainfo( Object o )  {
        Map<String, Object> logs = new HashMap<>();

        logs.put("logtype", "object");
        logs.put("data", o);
        logger.info(writeValueAsString(logs));
    }

    public void KEventinfo( String o )  {
        Map<String, Object> logs = new HashMap<>();
        logs.put("logtype", "event");
        logs.put("event", o);
        logger.info(writeValueAsString(logs));

    }

    private String writeValueAsString( Object value ) {
        String data = null;
        try {
            data = objectMapper.writeValueAsString(value);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return data;
    }

}
