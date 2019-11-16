package com.qch.thread;

/**
 * Created by chen_qian on 2019/11/9.
 */
public class Bank {
    private int account = 100;

    public int getAccount() {
        return account;
    }
    //同步方法
    public synchronized void save(int money) {
        account+=money;
    }

    public void save1(int money) {
        //同步代码块
        synchronized(this) {
            account+=money;
        }

    }

    public static void main (String[] args) {
        Bank bank = new Bank();

        MybanRunnable my1 = new MybanRunnable(bank);
        long startTime = System.currentTimeMillis();
        System.out.println("线程1");
        Thread th1 = new Thread(my1);
        th1.start();
        System.out.println("线程2");
        Thread th2 = new Thread(my1);
        th2.start();
        System.out.println("线程3");
        Thread th3 = new Thread(my1);
        th3.start();
        System.out.println("线程4");
        Thread th4 = new Thread(my1);
        th4.start();
        System.out.println("线程5");
        Thread th5 = new Thread(my1);
        th5.start();
        long endTime = System.currentTimeMillis();
        System.out.println("耗时"+(endTime-startTime)+"毫秒");

    }

}
