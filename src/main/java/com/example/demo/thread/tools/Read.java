package com.example.demo.thread.tools;

/**
 * @author admin
 * @date 2018-8-30 13:02
 */
public class Read {

    //TODO CountDownLatch java.util.concurrent 包下的工具类，可以协调多个线程之间的同步
    //TODO 或者线程之间的通信，他可以允许一个或者多个线程其他线程完成操作

    /**
     * TODO 使用场景
     *  1.某一线程在开始运行前等待n个线程执行完毕，将CountDownLatch的计数器初始化为n new CountDownLatch(n)，每当一个任务线程执行完毕，
     *  就将计算器减1 CountDownLatch.countDown(),当技术前的值变成0时，在CountDownLatch.await的线程就被唤醒，一个典型的场景就是启动一个服务时候，
     *  主线程需要等待多个组件加载完毕，之后再继续执行
     *  2.实现多个线程开始执行任务的最大并行性，注意是并行性，不是并发性，强调的是多个线程在某一时刻时开始执行，类似赛跑，将多个线程放在起点，等待发令抢，
     *  然后开始跑，做法是初始化一个共享的CountDownLatch(1),将其计数器初始化为1，多个线程在开始执行任务前首先countDownlacth.await(),当主线程调用countDown()
     *  时，计算器变为0，多个线程同时被唤醒。
     *
     *  TODO 的不足
     *  CountDownLatch是一次性的，计算器的值只能在构造器房中初始化一次，之后没有任何机制再次对其设置值，当CountDownLatch使用完毕后，他不能再次被使用
     *
     */














}
