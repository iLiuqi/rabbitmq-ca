package com.qseven.producer;

import com.qseven.model.Message;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.UUID;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProducerTest {

    @Resource
    private Producer producer;

    private Message<String> message;

    @Before
    public void buildMessage() {
        message = new Message<>();
        message.setId(UUID.randomUUID().toString());
        message.setContent("Hello rabbitmq-ca !");
    }

    @Test
    public void directProducer() {
        producer.directProducer(message);
    }

    @Test
    public void fanoutProducer() {
        producer.fanoutProducer(message);
    }

    @Test
    public void topicProducer() {
        producer.topicProducer(message);
    }

    @Test
    public void headersProducer() {
        producer.headersProducer(message);
    }

    @Test
    public void topicProducer2() {
        producer.topicProducer2(message);
    }

}