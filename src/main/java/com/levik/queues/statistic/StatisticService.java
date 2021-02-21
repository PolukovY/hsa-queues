package com.levik.queues.statistic;

import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

@Service
public class StatisticService {

    private static final List<Long> STATISTIC_PUBLISH = new LinkedList<>();
    private static final List<Long> STATISTIC_RECEIVE = new LinkedList<>();

    private static final AtomicLong RECEIVE_MESSAGE_COUNT = new AtomicLong(0);
    private static final AtomicLong PUBLISH_MESSAGE_COUNT = new AtomicLong(0);

    public void addPublishTime(long time) {
        STATISTIC_PUBLISH.add(time);
    }

    public void addReceiveTime(long time) {
        STATISTIC_RECEIVE.add(time);
    }

    public void receiveMessage() {
        RECEIVE_MESSAGE_COUNT.incrementAndGet();
    }

    public  void publishMessage() {
        PUBLISH_MESSAGE_COUNT.incrementAndGet();
    }

    public StatisticDto getStatistic() {
        double averageReceiveTime = STATISTIC_RECEIVE.stream().mapToLong(it -> it).average().orElse(0);
        double averagePublishTime = STATISTIC_PUBLISH.stream().mapToLong(it -> it).average().orElse(0);
        return new StatisticDto(
                RECEIVE_MESSAGE_COUNT.get(), PUBLISH_MESSAGE_COUNT.get(),
                averageReceiveTime, averagePublishTime
        );
    }


}
