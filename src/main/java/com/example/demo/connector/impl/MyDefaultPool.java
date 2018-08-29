package com.example.demo.connector.impl;

import com.example.demo.connector.DBConfigXML;
import com.example.demo.connector.IMyPool;
import com.example.demo.connector.MyPooledConnection;
import com.mysql.jdbc.jdbc2.optional.MysqlPooledConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

public class MyDefaultPool implements IMyPool {

    //TODO Vector线程安全
    private Vector<MyPooledConnection> mysqlPooledConnectionVector = new Vector<>();
    private static String jdbcURL;
    private static String jdbcUsername;
    private static String jdbcPassword;
    private static int initCount;
    private static int step;
    private static int maxCount;

    public MyDefaultPool() {

        //初始化数据库连接池配置
        init();

        //加载驱动
        try {
            Class.forName(DBConfigXML.jdbcDrivers);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //初始化数据库连接池管道
        createMyPooledConnection(initCount);
    }

    private void init() {
        jdbcURL = DBConfigXML.jdbcURL;
        jdbcUsername = DBConfigXML.jdbcUserName;
        jdbcPassword = DBConfigXML.jdbcPassword;
        initCount = DBConfigXML.initCount;
        step = DBConfigXML.step;
        maxCount = DBConfigXML.maxCount;
    }

    @Override
    public MyPooledConnection getMyPooledConnection() {
        if (mysqlPooledConnectionVector.size() < 1) {
            throw new RuntimeException("数据库初始化错误");
        }

        MyPooledConnection myPooledConnection = null;
        try {
            myPooledConnection = getRealConnectionFromPool();
            while (myPooledConnection == null) {
                createMyPooledConnection(step);
                myPooledConnection = getRealConnectionFromPool();
                return myPooledConnection;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return myPooledConnection;
    }

    @Override
    public void createMyPooledConnection(int count) {
        if (mysqlPooledConnectionVector.size() > maxCount || mysqlPooledConnectionVector.size() + count > maxCount) {
            throw new RuntimeException("连接池已满");
        }

        for (int i = 0; i < count; i++) {
            try {
                Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
                MyPooledConnection myPooledConnection = new MyPooledConnection(connection, false);
                mysqlPooledConnectionVector.add(myPooledConnection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized MyPooledConnection getRealConnectionFromPool() throws SQLException {
        for (MyPooledConnection myPooledConnection : mysqlPooledConnectionVector) {
            if (!myPooledConnection.isBusy()) {
                if (myPooledConnection.getConnection().isValid(3000)) {
                    myPooledConnection.setBusy(true);
                    return myPooledConnection;
                }
            } else {
                Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
                myPooledConnection.setConnection(connection);
                myPooledConnection.setBusy(true);
                return myPooledConnection;
            }
        }
        return null;
    }
}
