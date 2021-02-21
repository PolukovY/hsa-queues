package com.levik.queues.statistic;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/statistic")
public class StatisticController {

    private final StatisticService statisticService;

    @GetMapping
    public StatisticDto getStatistic() {
        return statisticService.getStatistic();
    }
}
