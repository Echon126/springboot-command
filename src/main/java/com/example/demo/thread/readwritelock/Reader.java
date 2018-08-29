package com.example.demo.thread.readwritelock;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Reader extends Thread {
    public DataCache dataCache;

    public Reader(String name, DataCache dataCache) {
        super(name);
        this.dataCache = dataCache;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        long result = dataCache.readSize();
        System.out.println(name + " TIME "+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " read current cache size is:" + result);
    }
}
