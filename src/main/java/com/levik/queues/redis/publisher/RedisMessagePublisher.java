package com.levik.queues.redis.publisher;

import com.levik.queues.base.MessagePublisher;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Slf4j
@Component
public class RedisMessagePublisher implements MessagePublisher {
    private final RedisTemplate<String, Object> redisTemplate;
    private final ChannelTopic topic;

    @Override
    public void publish(String message) {
        log.info("Publish message: {}", message);
        redisTemplate.convertAndSend(topic.getTopic(), message);
    }
}
