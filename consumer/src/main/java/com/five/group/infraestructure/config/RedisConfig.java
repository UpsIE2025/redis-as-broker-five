package com.five.group.infraestructure.config;

import com.five.group.infraestructure.redis.RedisMessageLIstener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

@Configuration
public class RedisConfig {

    @Bean
    public RedisMessageListenerContainer redisContainer(RedisConnectionFactory connectionFactory,
                                                        MessageListenerAdapter listenerAdapter,
                                                        ChannelTopic topic) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(listenerAdapter, topic);
        return container;
    }

    /**
     * Este adaptador se encargará de delegar los mensajes de RedisMessageListener
     */
    @Bean
    public MessageListenerAdapter listenerAdapter(RedisMessageLIstener redisMessageListener) {
        return new MessageListenerAdapter(redisMessageListener);
    }

    /**
     * Este método define el canal en el que se suscribe el listener
     */
    @Bean
    public ChannelTopic topic() {
        return new ChannelTopic("my_channel");
    }
}