package com.example.demo.thread.tools.countdownlatch;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @author admin
 * @date 2018-8-30 13:16
 */
public class Test {
    public static void main(String[] args) throws IOException {
        CountDownLatch countDownLatch = new CountDownLatch(4);

        Thread startGameThread =  new Thread(new StartGame(countDownLatch));
        startGameThread.start();

        Thread mapThread = new Thread(new MapData("地图",countDownLatch));
        Thread goodsThread = new Thread(new GoodsData("物品",countDownLatch));
        Thread personageThread = new Thread(new PersonageData("人物",countDownLatch));
        Thread backGroundThread = new Thread(new BackGroundData("背景",countDownLatch));

        mapThread.start();
        goodsThread.start();
        personageThread.start();
        backGroundThread.start();

        System.in.read();
    }
}
