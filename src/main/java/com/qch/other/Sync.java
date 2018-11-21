package com.qch.other;

/**
 * Created by BF100499 on 2018/11/14.
 */
public class Sync {
    public synchronized void test() {
        System.out.println("test开始..");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("test结束..");
    }
}
