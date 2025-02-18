package com.five.group.infraestructure.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;

import com.five.group.application.service.SendMessageImpl;
import com.five.group.domain.port.in.SendMessage;
import com.five.group.domain.port.out.EmitMessage;
import com.five.group.infraestructure.adapter.out.redis.RedisMessageProducer;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class BeansFactory {

    @Value("${broker.channel}")
    private String channel;

    private final StringRedisTemplate stringRedisTemplate;

    @Bean
    public EmitMessage emitMessage() {
        return new RedisMessageProducer(channel, stringRedisTemplate);
    }

    @Bean
    public SendMessage sendMessage() {
        return new SendMessageImpl(emitMessage());
    }
}
