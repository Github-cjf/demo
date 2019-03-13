package org.sang.demo.util;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by CJF on 2019/3/1.
 */
@Component
public class RabbitMQConfig {
    private static String EXCHANGE = "test-exchange";
    private static String QUEUE = "test-queue";
    private static String ROUNTING_KEY = "test.queue.#";

    @Bean
    TopicExchange exchange() {
        return new TopicExchange(EXCHANGE);
    }

    @Bean
    Queue queue() {
        Map<String, Object> arguments = new HashMap<>();
        arguments.put("x-max-test", 100);
        return new Queue(QUEUE, true, false, false, arguments);
    }

//    @Bean("queue2")
//    Queue queue2() {
//        Map<String, Object> arguments = new HashMap<>();
//        arguments.put("x-max-priority", 100);
//        return new Queue(QUEUE, true, false, false, arguments);
//    }

    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUNTING_KEY);
    }

}
