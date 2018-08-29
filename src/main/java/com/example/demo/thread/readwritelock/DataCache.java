package com.example.demo.thread.readwritelock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * TODO 读写锁，在并发读数量远多于写数量情况下，可以使用ReentrantReadWriteLock，
 * 允许多个读的线程同时访问，但不允许写线程、写线程和写线程同时访问
 *
 * TODO 缺点：读锁会完全阻塞写锁，使用的依然是悲观锁的策略，如果有大量的读线程，则有可能引起写锁的饥渴
 * TODO StampedLock 提供了乐观锁的机制，这种乐观所的机制类似于无锁的操作，是的乐观锁完全不会阻塞写线程
 */
public class DataCache {
    private Map<String, String> cacheMap = new HashMap<String, String>();
    private ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();


    private void mockTimeConsumerOpt() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public long readSize() {
        try {
            readLock.lock();
            mockTimeConsumerOpt();
            return cacheMap.size();
        } finally {
            readLock.unlock();
        }
    }

    public long write(String key, String value) {
        try {
            writeLock.lock();
            mockTimeConsumerOpt();
            cacheMap.put(key, value);
            return cacheMap.size();
        } finally {
            writeLock.unlock();
        }
    }


    /**
     * TODO lock 接口的基本分析
     * 1.lock
     * 2.lockInterruptibly
     * 3.trylock
     * 4.trylock(long time,TimeUnit)
     * 5.unlock
     */
}
