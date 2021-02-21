package com.levik.queues.beanstalk;

import com.dinstone.beanstalkc.Job;
import com.dinstone.beanstalkc.JobConsumer;
import com.google.common.base.Stopwatch;
import com.levik.queues.statistic.StatisticService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Slf4j
@AllArgsConstructor
@Service
public class BeanstalkSubscriber {

    public static final int TIMEOUT = 100;

    private final StatisticService statisticService;
    private final JobConsumer jobConsumer;

    @Scheduled(fixedRate = 100)
    public void onMessage() {
        log.info("On Message...");

        while (true) {
            final Job job = jobConsumer.reserveJob(TIMEOUT);

            if (Objects.isNull(job)) {
                log.info("Job is empty");
                break;
            }

            readMessage(job);
        }
    }

    @SneakyThrows
    private void readMessage(Job job) {
        TimeUnit.MILLISECONDS.sleep(100);
        Stopwatch started = Stopwatch.createStarted();
        log.info("Receive message: {}", new String(job.getData()));
        jobConsumer.deleteJob(job.getId());
        statisticService.receiveMessage();
        statisticService.addReceiveTime(started.elapsed(TimeUnit.MILLISECONDS));
    }
}
