package com.qseven.consumer;

import com.qseven.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 第二种写法，利用注解的形式，免去单独的Config配置
 * 一次性完成队列，交换器，路由key的声明与绑定
 */
@Component
@Slf4j
public class TopicConsumer2 {

    /**
     * 监听队列，接受消息
     */

    @RabbitListener(
            bindings = {
                    @QueueBinding(
                            value = @Queue(name = "q.topic.annotation.queue.one"),
                            exchange = @Exchange(name = "ex.topic.annotation.exchange", type = ExchangeTypes.TOPIC),
                            key = {"rk-hi"}
                    )
            }
    )
    public void topicQueueOneConsumer(Message message) {
        log.info("收到q.topic.annotation.queue.one消息： -> {} ", message.toString());
    }

    @RabbitListener(
            bindings = {
                    @QueueBinding(
                            value = @Queue(name = "q.topic.annotation.queue.two"),
                            exchange = @Exchange(name = "ex.topic.annotation.exchange", type = ExchangeTypes.TOPIC),
                            key = {"#"}
                    )
            }
    )
    public void topicQueueTwoConsumer(Message message) {
        log.info("收到q.topic.annotation.queue.two消息： -> {} ", message.toString());
    }

}
