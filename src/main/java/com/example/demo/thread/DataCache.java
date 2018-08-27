package com.example.demo.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁，在并发读数量远多于写数量情况下，可以使用ReentrantReadWriteLock，
 * 允许多个读的线程同时访问，但不允许写线程、写线程和写线程同时访问
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
}
