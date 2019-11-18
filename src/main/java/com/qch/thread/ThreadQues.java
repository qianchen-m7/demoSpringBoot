package com.qch.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
@Slf4j
public class ThreadQues {
    private static int threadLocal=100;
    private static int clientTotal=5000;
    private static long count=0;

    public static void thread1()
    {
        ExecutorService exec=Executors.newCachedThreadPool();
        final Semaphore semaphore=new Semaphore(threadLocal);
        for (int i = 0; i <clientTotal ; i++) {
            exec.execute(()->{
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                }catch (Exception e){
                    log.error("exception",e);
                }
            });
        }
        exec.shutdown();
        log.info("count:{}",count);
    }

    public static void main(String[] args) {
        thread1();
    }
    public  static void add(){
        count++;
    }

}
