package com.pzh.delay.module;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2021/3/13 14:57
 * @Version 1.0
 */
@Component
@RabbitListener(queues = "dlk.queue")
public class DelayReceiver {
    private static final Logger LOGGER = LoggerFactory.getLogger(DelayReceiver.class);

    @RabbitHandler
    public void receive(String str) {
        LOGGER.info("DelayReceiver 10s后接收到的消息：" + str);
    }
}
