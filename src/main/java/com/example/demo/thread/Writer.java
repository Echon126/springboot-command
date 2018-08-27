package com.example.demo.thread;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Writer extends Thread{
    public DataCache dataCache;

    public Writer(String str, DataCache dataCache){
        super(str);
        this.dataCache = dataCache;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        String result = "" + dataCache.write(name, "DATA-"+name);
        System.out.println(name +" Time "+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) +" write to current cache!");
    }
}
