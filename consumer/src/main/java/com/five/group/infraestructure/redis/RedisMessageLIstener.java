package com.five.group.infraestructure.redis;

import com.five.group.application.MessageProcessingServiceImpl;
import com.five.group.domain.model.Message;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RedisMessageLIstener implements MessageListener {
    private final MessageProcessingServiceImpl messageProcessingService;

    @Override
    public void onMessage(org.springframework.data.redis.connection.Message redisMessage, byte[] pattern) {
        String content = new String(redisMessage.getBody());
        Message message = new Message(content);
        messageProcessingService.processMessage(message);
    }
}
