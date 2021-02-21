package com.levik.queues.beanstalk;

import com.google.common.base.Stopwatch;
import com.levik.queues.statistic.StatisticService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
@Service
@Slf4j
public class BeanstalkService {

    private final BeanstalkPublisher beanstalkPublisher;
    private final StatisticService statisticService;

    public void publishMessage() {
        Stopwatch started = Stopwatch.createStarted();
        var message = "Some message " + UUID.randomUUID().toString();
        beanstalkPublisher.publish(message);
        log.info("Publish message: {}", message);
        statisticService.publishMessage();
        statisticService.addPublishTime(started.elapsed(TimeUnit.MILLISECONDS));
    }
}
