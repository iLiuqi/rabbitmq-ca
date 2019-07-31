package com.qseven.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Direct模式配置
 */
@Configuration
public class DirectConfig {

    /**
     * Direct直连模式
     * 通过交换器下发的消息是严格发送到按照指定路由键绑定的队列上
     */

    @Bean
    public Queue directQueue() {
        // 构建一个非持久化队列
        return QueueBuilder.nonDurable("q.direct.queue").build();
    }

    @Bean
    public DirectExchange directExchange() {
        return (DirectExchange) ExchangeBuilder.directExchange("ex.direct.exchange").build();
    }

    @Bean
    public Binding directBinding() {
        return BindingBuilder.bind(directQueue()).to(directExchange()).withQueueName();
    }

}
