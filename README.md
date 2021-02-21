```
siege -c10 -t1m 127.0.0.1:9901/redis
```

## Redis rdb

# Producer

| Metrics                            | 1             | 2     |
| ---------------------------------- |:-------------:| -----:|
| Throughput                         | 24501         | 19489 |
| Avg time Milliseconds              | 21.77         | 24.97 |
| Avg throughput messages per 1 sec  | 408           | 324   |

# Consumer 

| Metrics                            | 1             | 2          |
| ---------------------------------- |:-------------:| ----------:|
| Avg time Milliseconds              | 2.29          |0.09        |


## Redis aof

# Producer

| Metrics                            | 1             | 2     |
| ---------------------------------- |:-------------:| -----:|
| Throughput                         | 20755         | 20977 |
| Avg time Milliseconds              | 20.8          | 16.63 |
| Avg throughput messages per 1 sec  | 345           | 349   |

# Consumer 

| Metrics                            | 1             | 2          |
| ---------------------------------- |:-------------:| ----------:|
| Avg time Milliseconds              | 0.05          |0.06        |

## Beanstalkd

# Producer

| Metrics                            | 1             | 2     |
| ---------------------------------- |:-------------:| -----:|
| Throughput                         | 32694         | 32681 |
| Avg time Milliseconds              | 18.50         | 18.33 |
| Avg throughput messages per 1 sec  | 544           | 544   |

# Consumer 

| Metrics                            | 1             | 2          |
| ---------------------------------- |:-------------:| ----------:|
| Avg time Milliseconds              | 29.72         |25.62       |

```
siege -c50 -t1m 127.0.0.1:9901/redis
```

## Redis rdb

# Producer

| Metrics                            | 1             | 2      |
| ---------------------------------- |:-------------:| ------:|
| Throughput                         | 22135         | 22069  |
| Avg time Milliseconds              | 92.67         | 140.63 |
| Avg throughput messages per 1 sec  | 368           | 367    |

# Consumer 

| Metrics                            | 1             | 2          |
| ---------------------------------- |:-------------:| ----------:|
| Avg time Milliseconds              | 0.13          |0.39        |

## Redis aof

# Producer

| Metrics                            | 1             | 2      |
| ---------------------------------- |:-------------:| ------:|
| Throughput                         | 26582         | 21866  |
| Avg time Milliseconds              | 32.93         | 107.69 |
| Avg throughput messages per 1 sec  | 443           | 364    |

# Consumer 

| Metrics                            | 1             | 2          |
| ---------------------------------- |:-------------:| ----------:|
| Avg time Milliseconds              | 0.03          |0.14        |

## Beanstalkd

# Producer

| Metrics                            | 1             | 2     |
| ---------------------------------- |:-------------:| -----:|
| Throughput                         | 32753         | 32706 |
| Avg time Milliseconds              | 73.03         | 67.43 |
| Avg throughput messages per 1 sec  | 545           | 545   |

# Consumer 

| Metrics                            | 1             | 2          |
| ---------------------------------- |:-------------:| ----------:|
| Avg time Milliseconds              | 21.03         |37.07       |


Beanstalkd has more Throughput than Redis. 
Looks like we have some issue with disk due to more concurrent user produce not so big throughput.

# Beanstalkd

Pros:
 - Very lightweight
 - Very fast
 - Consumes very little CPU
 - Easy to configure and run
 - Lots of clients in lots of languages
 - Persistent
Cons:
 - Persistency model is a bit complex so for large queues you may end up with very large files that are already allocated but may never get cleared up
 - No security model (but from my experience in most rather simple web based systems its not really required)
 - Doesn't run on Windows (some would put this as a Pro :-) ).