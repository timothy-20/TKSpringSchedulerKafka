package com.timothy20.tkspringschedulerkafka;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class TKKafkaProducer
{
    @Value(value="${message.topic.name}")
    private String topicName;
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final Logger logger;

    @Autowired
    public TKKafkaProducer(KafkaTemplate<String, String> kafkaTemplate)
    {
        this.kafkaTemplate = kafkaTemplate;
        this.logger = (Logger) LogManager.getLogger(TKKafkaProducer.class);
    }

    public void sendMessage(String message)
    {
        this.logger.info("Message content: " + message);
        this.kafkaTemplate.send(topicName, message);
    }
}
