package com.example.demo.connector;

/**
 * 对数据池的一个基本管理的API接口
 * 要可以得到数据库操作的管道/可以创建数据库管道
 */
public interface IMyPool {

    public MyPooledConnection getMyPooledConnection();

    public void createMyPooledConnection(int count);
}
