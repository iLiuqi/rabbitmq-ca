package com.qseven.consumer;

import com.qseven.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class FanoutConsumer {

    /**
     * 监听队列，接受消息
     */

    @RabbitListener(queues = {"q.fanout.queue.one"})
    public void fanoutQueueOneConsumer(Message message) {
        log.info("收到q.fanout.queue.one消息： -> {} ", message.toString());
    }

    @RabbitListener(queues = {"q.fanout.queue.two"})
    public void fanoutQueueTwoConsumer(Message message) {
        log.info("收到q.fanout.queue.two消息：-> {} ", message.toString());
    }

    @RabbitListener(queues = {"q.fanout.queue.three"})
    public void fanoutQueueThreeConsumer(Message message) {
        log.info("收到q.fanout.queue.three消息： -> {} ", message.toString());
    }

}
