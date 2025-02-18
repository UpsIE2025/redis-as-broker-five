package com.five.group.infraestructure.adapter.out.redis;

import com.five.group.domain.port.out.EmitMessage;

import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;

@AllArgsConstructor
public class RedisMessageProducer implements EmitMessage {

    private String channel;
    private StringRedisTemplate redisTemplate;

    @Override
    public void emit(String message) {
        redisTemplate.convertAndSend(channel, message);
    }
}
