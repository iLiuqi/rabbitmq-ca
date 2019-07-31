package com.qseven.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Fanout模式配置
 */
@Configuration
public class FanoutConfig {

    /**
     * Fanout分发(广播)模式
     * 不会根据路由键去区分消息到底该下发到哪儿一个队列
     * 绑定在该交换器上的队列都会收到下发致fanout交换器的消息
     */

    @Bean
    public Queue fanoutQueueOne() {
        return QueueBuilder.nonDurable("q.fanout.queue.one").build();
    }

    @Bean
    public Queue fanoutQueueTwo() {
        return QueueBuilder.nonDurable("q.fanout.queue.two").build();
    }

    @Bean
    public Queue fanoutQueueThree() {
        return QueueBuilder.nonDurable("q.fanout.queue.three").build();
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return (FanoutExchange) ExchangeBuilder.fanoutExchange("ex.fanout.exchange").build();
    }

    @Bean
    public Binding fanoutBindingOne() {
        return BindingBuilder.bind(fanoutQueueOne()).to(fanoutExchange());
    }

    @Bean
    public Binding fanoutBindingTwo() {
        return BindingBuilder.bind(fanoutQueueTwo()).to(fanoutExchange());
    }

    @Bean
    public Binding fanoutBindingThree() {
        return BindingBuilder.bind(fanoutQueueThree()).to(fanoutExchange());
    }

}
