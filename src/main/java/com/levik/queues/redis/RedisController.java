package com.levik.queues.redis;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/redis")
public class RedisController {

    private final RedisService redisService;

    @GetMapping
    public void publishMessage() {
        redisService.publishMessage();
    }
}
