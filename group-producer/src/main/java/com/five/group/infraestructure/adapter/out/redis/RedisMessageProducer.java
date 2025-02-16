package com.five.group.infraestructure.adapter.out.redis;

import com.five.group.application.port.out.MessagePublisher;
import com.five.group.domain.model.Message;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RedisMessageProducer  implements MessagePublisher {
    private StringRedisTemplate redisTemplate;
    private final String CHANNEL_NAME = "my_channel";


    @Override
    public void publish(Message message) {
        redisTemplate.convertAndSend(CHANNEL_NAME, message.getContent());
    }
}
