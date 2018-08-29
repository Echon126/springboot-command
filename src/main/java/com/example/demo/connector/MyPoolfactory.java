package com.example.demo.connector;

import com.example.demo.connector.impl.MyDefaultPool;

/**
 * 单例模式
 * 数据连接池工厂
 */
class MyPoolFactory {

    public static class CreatePool {
        public static IMyPool myPool = new MyDefaultPool();
    }

    public static IMyPool getInstance() {
        return CreatePool.myPool;
    }
}
