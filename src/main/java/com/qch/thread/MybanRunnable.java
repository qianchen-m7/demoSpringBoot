package com.qch.thread;

/**
 * Created by chen_qian on 2019/11/9.
 */
public class MybanRunnable implements Runnable {
    private Bank bank;

    public MybanRunnable(Bank bank) {
        this.bank = bank;
    }
    @Override
    public void run() {
        for(int i=0;i<300;i++) {
            bank.save1(100);
            System.out.println("账户余额是---"+bank.getAccount());
        }

    }
}
