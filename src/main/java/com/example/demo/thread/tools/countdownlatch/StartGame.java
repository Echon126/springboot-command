package com.example.demo.thread.tools.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author admin
 * @date 2018-8-30 13:15
 */
public class StartGame implements Runnable{
    private CountDownLatch count;

    public StartGame(CountDownLatch count) {
        this.count = count;
    }

    @Override
    public void run() {
        try {
            System.out.println("开始加载基础数据...");
            Long l1 = System.currentTimeMillis();
            count.await();
            Long l2 = System.currentTimeMillis();
            System.out.println("基础数据加载完毕，总共花费时长:"+(l2-l1)+".可以开始游戏...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
