package com.levik.queues.beanstalk;

import com.dinstone.beanstalkc.BeanstalkClientFactory;
import com.dinstone.beanstalkc.JobConsumer;
import com.dinstone.beanstalkc.JobProducer;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
@AllArgsConstructor
public class BeanstalkConfiguration {

    @Bean
    com.dinstone.beanstalkc.Configuration configuration(){
        com.dinstone.beanstalkc.Configuration configuration = new com.dinstone.beanstalkc.Configuration();
        //TODO move to config, but ok for testing purpose
        configuration.setServiceHost("127.0.0.1");
        configuration.setServicePort(11300);
        configuration.setConnectTimeout(2000);
        configuration.setReadTimeout(3000);
        return configuration;
    }

    @Bean
    public BeanstalkClientFactory beanstalkClientFactory(com.dinstone.beanstalkc.Configuration configuration) {
        return new BeanstalkClientFactory(configuration);
    }

    @Bean
    public JobProducer jobProducer(BeanstalkClientFactory beanstalkClientFactory) {
        return beanstalkClientFactory.createJobProducer("test_jobs");
    }

    @Bean
    public JobConsumer jobConsumer(BeanstalkClientFactory beanstalkClientFactory) {
        return beanstalkClientFactory.createJobConsumer("test_jobs");
    }
}
