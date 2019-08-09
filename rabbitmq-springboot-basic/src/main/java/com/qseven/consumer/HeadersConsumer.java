package com.qseven.consumer;

import com.qseven.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class HeadersConsumer {

    /**
     * 监听队列，接受消息
     */
    @RabbitListener(queues = {"q.headers.queue"})
    public void headersQueueConsumer(Message message) {
        log.info("收到q.headers.queue.one -> {} ", message.toString());
    }

}
