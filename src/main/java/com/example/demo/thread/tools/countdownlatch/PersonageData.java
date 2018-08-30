package com.example.demo.thread.tools.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author admin
 * @date 2018-8-30 13:20
 */
public class PersonageData extends AbstractDataRunnable {
    public PersonageData(String name, CountDownLatch count) {
        super(name, count);
    }

    @Override
    public void handle() throws InterruptedException {
        //模拟加载时间，1秒
        Thread.sleep(1000);
    }
}
