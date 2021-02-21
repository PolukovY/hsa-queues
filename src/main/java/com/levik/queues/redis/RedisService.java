package com.levik.queues.redis;

import com.google.common.base.Stopwatch;
import com.levik.queues.statistic.StatisticService;
import com.levik.queues.redis.publisher.RedisMessagePublisher;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
@AllArgsConstructor
@Slf4j
public class RedisService {

    private final RedisMessagePublisher redisMessagePublisher;
    private final StatisticService statisticService;

    public void publishMessage() {
        Stopwatch started = Stopwatch.createStarted();
        var message = "Some message " + UUID.randomUUID().toString();
        redisMessagePublisher.publish(message);
        statisticService.publishMessage();
        statisticService.addPublishTime(started.elapsed(TimeUnit.MILLISECONDS));
    }
}
