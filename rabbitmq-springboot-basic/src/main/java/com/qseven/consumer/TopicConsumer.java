package com.qseven.consumer;

import com.qseven.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TopicConsumer {

    /**
     * 监听队列，接受消息
     */

    @RabbitListener(queues = {"q.topic.queue.one"})
    public void topicQueueOneConsumer(Message message) {
        log.info("收到q.topic.queue.one消息： -> {} ", message.toString());
    }

    @RabbitListener(queues = {"q.topic.queue.two"})
    public void topicQueueTwoConsumer(Message message) {
        log.info("收到q.topic.queue.two消息： -> {} ", message.toString());
    }

}
