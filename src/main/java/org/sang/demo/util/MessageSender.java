package org.sang.demo.util;

import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by CJF on 2019/3/1.
 */
@Component
@AllArgsConstructor
public class MessageSender {
    private static final String EXCHANGE = "test-exchange";

    private static final String ROUTING_KEY_PREFIX = "test.queue.";

    private final RabbitTemplate rabbitTemplate;




    /**
     * 发送设置有优先级的消息
     *
     * @param priority 优先级
     */
    public void sendTestMessage(String content, Integer priority) {
        System.out.println(rabbitTemplate.getExchange()+"121");
        rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY_PREFIX + "test", content,
                message -> {
                    message.getMessageProperties().setPriority(priority);
                    return message;
                });
    }
}
