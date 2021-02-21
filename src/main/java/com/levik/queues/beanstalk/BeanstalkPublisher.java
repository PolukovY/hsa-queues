package com.levik.queues.beanstalk;

import com.dinstone.beanstalkc.JobProducer;
import com.levik.queues.base.MessagePublisher;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BeanstalkPublisher implements MessagePublisher {

    private final JobProducer jobProducer;

    @Override
    public void publish(String message) {
        jobProducer.putJob(0, 0, 10000, message.getBytes());
    }
}
