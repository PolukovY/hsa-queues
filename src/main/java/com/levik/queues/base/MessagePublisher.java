package com.levik.queues.base;

@FunctionalInterface
public interface MessagePublisher {
    void publish(final String message);
}
