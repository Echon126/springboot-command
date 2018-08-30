package com.example.demo.thread.tools.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author admin
 * @date 2018-8-30 13:06
 */
public abstract class AbstractDataRunnable implements Runnable {
    private String name;
    private CountDownLatch count;

    public AbstractDataRunnable(String name, CountDownLatch count) {
        this.name = name;
        this.count = count;
    }

    public abstract void handle() throws InterruptedException;

    public String getName() {
        return name;
    }

    public void afterCountDown() {
        System.out.println(this.getName() + ":countDownLatch计数减一之后，继续加载前台数据");
    }

    @Override
    public void run() {
        try {
            System.out.println(this.getName() + " 开始加载...");
            Long l1 = System.currentTimeMillis();
            handle();
            Long l2 = System.currentTimeMillis();
            System.out.println(this.getName() + " 加载完成,花费时间:" + (l2 - l1));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            count.countDown();
        }
        afterCountDown();
    }
}
