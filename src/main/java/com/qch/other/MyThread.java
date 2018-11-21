package com.qch.other;

/**
 * Created by BF100499 on 2018/11/14.
 */
public class MyThread extends Thread {
    public void run() {
        Sync sync = new Sync();
        sync.test();
    }
}
