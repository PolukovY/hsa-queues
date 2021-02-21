package com.levik.queues.statistic;

import lombok.Value;

@Value
public class StatisticDto {
    long received;
    long published;
    double receivedTime;
    double publishedTime;
}
