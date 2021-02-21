package com.levik.queues.beanstalk;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("beanstalk")
public class BeanstalkController {

    private final BeanstalkService beanstalkService;

    @GetMapping
    public void publishMessage() {
        beanstalkService.publishMessage();
    }
}
