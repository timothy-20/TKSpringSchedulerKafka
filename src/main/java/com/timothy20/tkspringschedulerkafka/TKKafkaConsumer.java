package com.timothy20.tkspringschedulerkafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.logging.log4j.LogManager;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.logging.Logger;

@Service
public class TKKafkaConsumer
{
    private final Logger logger;

    public TKKafkaConsumer()
    {
        this.logger = (Logger) LogManager.getLogger(TKKafkaProducer.class);
    }

    @KafkaListener(topics = "@{message.topic.name}", groupId = ConsumerConfig.GROUP_ID_CONFIG)
    public void consume(String message)
    {
        this.logger.info("Consumed message: " + message);
    }
}
