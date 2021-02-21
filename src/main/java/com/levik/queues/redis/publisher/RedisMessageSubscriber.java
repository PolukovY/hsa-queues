package com.levik.queues.redis.publisher;

import com.google.common.base.Stopwatch;
import com.levik.queues.statistic.StatisticService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@AllArgsConstructor
@Slf4j
@Component
public class RedisMessageSubscriber implements MessageListener {

    private final StatisticService statisticService;

    @SneakyThrows
    @Override
    public void onMessage(Message message, byte[] bytes) {
        TimeUnit.MILLISECONDS.sleep(100);
        Stopwatch started = Stopwatch.createStarted();
        log.info("Receive message: {}", new String(message.getBody()));
        statisticService.receiveMessage();
        statisticService.addReceiveTime(started.elapsed(TimeUnit.MILLISECONDS));
    }
}
