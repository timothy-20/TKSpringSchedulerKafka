package com.timothy20.tkspringschedulerkafka;

import org.springframework.beans.factory.annotation.Autowired;

public class TKController {
    private final TKKafkaProducer producer;

    @Autowired
    TKController(TKKafkaProducer producer)
    {
        this.producer = producer;
    }
}
