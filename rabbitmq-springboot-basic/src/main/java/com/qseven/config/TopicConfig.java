package com.qseven.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Topic模式配置
 */
@Configuration
public class TopicConfig {

    /**
     * Topic模式
     * 根据路由键的规则，灵活的将消息发送到想要发送的队列中去
     */

    @Bean
    public Queue topicQueueOne() {
        return QueueBuilder.durable("q.topic.queue.one").build();
    }

    @Bean
    public Queue topicQueueTwo() {
        return QueueBuilder.durable("q.topic.queue.two").build();
    }

    @Bean
    public TopicExchange topicExchange() {
        return (TopicExchange) ExchangeBuilder.topicExchange("ex.topic.exchange").build();
    }

    @Bean
    public Binding topicBindingOne() {
        return BindingBuilder.bind(topicQueueOne()).to(topicExchange()).with("rk-routing-key");
    }

    @Bean
    public Binding topicBindingTwo() {
        return BindingBuilder.bind(topicQueueTwo()).to(topicExchange()).with("#");
    }

}
