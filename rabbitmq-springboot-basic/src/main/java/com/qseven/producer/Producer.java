package com.qseven.producer;

import com.qseven.model.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class Producer {

    @Resource
    private RabbitTemplate rabbitTemplate;

    public void directProducer(Message message) {
        rabbitTemplate.convertAndSend("ex.direct.exchange", "q.direct.queue.x", message);
    }

    public void fanoutProducer(Message message) {
        // 与routing key无关
        rabbitTemplate.convertAndSend("ex.fanout.exchange", "", message);
    }

    public void topicProducer(Message message) {
        rabbitTemplate.convertAndSend("ex.topic.exchange", "rk-routing-key123", message);
    }

    public void headersProducer(Message message) {
        rabbitTemplate.convertAndSend("ex.headers.exchange", "", message,
                m -> {
                    m.getMessageProperties().getHeaders().put("headers-key", null);
                    return m;
                });
    }

    public void topicProducer2(Message message) {
        rabbitTemplate.convertAndSend("ex.topic.annotation.exchange", "rk-hi", message);
    }

}
