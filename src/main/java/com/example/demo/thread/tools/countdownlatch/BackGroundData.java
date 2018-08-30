package com.example.demo.thread.tools.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author admin
 * @date 2018-8-30 13:13
 */
public class BackGroundData extends AbstractDataRunnable {
    public BackGroundData(String name, CountDownLatch count) {
        super(name, count);
    }

    @Override
    public void handle() throws InterruptedException {
        Thread.sleep(3000);//模拟加载时间2秒
    }
}
