package com.qch.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * Created by BF100499 on 2018/11/14.
 */
@Slf4j
@Component
public class Task {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Async("taskExecutor")
    public void doTaskOne() throws Exception {
        synchronized (this) {
            log.info("开始做任务一");
            long start = System.currentTimeMillis();
            log.info(stringRedisTemplate.randomKey());
            long end = System.currentTimeMillis();
            log.info("完成任务一，耗时：" + (end - start) + "毫秒");
        }
    }

    @Async("taskExecutor")
    public synchronized void  doTaskTwo() throws Exception {
        log.info("开始做任务二");
        long start = System.currentTimeMillis();
        log.info(stringRedisTemplate.randomKey());
        long end = System.currentTimeMillis();
        log.info("完成任务二，耗时：" + (end - start) + "毫秒");
    }

    @Async("taskExecutor")
    public void doTaskThree() throws Exception {
        synchronized (Task.class) {
            log.info("开始做任务三");
            long start = System.currentTimeMillis();
            log.info(stringRedisTemplate.randomKey());
            long end = System.currentTimeMillis();
            log.info("完成任务三，耗时：" + (end - start) + "毫秒");
        }
    }

}
