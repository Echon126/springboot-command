package com.example.demo.thread.tools.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author admin
 * @date 2018-8-30 13:19
 */
public class MapData extends AbstractDataRunnable {
    public MapData(String name, CountDownLatch count) {
        super(name, count);
    }

    @Override
    public void handle() throws InterruptedException {
        //模拟加载时间，3秒
        Thread.sleep(3000);
    }
}
