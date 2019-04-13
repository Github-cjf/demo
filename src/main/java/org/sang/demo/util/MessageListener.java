package org.sang.demo.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

/**
 * Created by CJF on 2019/3/1.
 */
@Slf4j
//@Component
public class MessageListener {
    @RabbitListener(queues = "test-queue")
    public void listen(String message) {
        System.out.println("message===="+message);
        log.info(message);
    }
}
