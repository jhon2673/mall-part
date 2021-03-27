package com.pzh.delay.module;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2021/3/13 14:51
 * @Version 1.0
 */
@Component
public class DelaySender {
    private static final Logger LOGGER = LoggerFactory.getLogger(DelaySender.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(String msg, long delay) {
        LOGGER.info("要发送的内容：" + msg);
        rabbitTemplate.convertAndSend("demo.exchange", "demo.routeKey", msg, new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                message.getMessageProperties().setExpiration(String.valueOf(delay));
                return message;
            }
        });
    }
}
