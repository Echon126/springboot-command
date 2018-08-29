package com.example.demo.connector;

/**
 * 数据库的基本配置 http://blog.51cto.com/zhangfengzhe/2069971
 */
public class DBConfigXML {
    public static final String jdbcDrivers = "com.mysql.jdbc.Driver";
    public static final String jdbcURL = "jdbc:mysql://127.0.0.1:3306/git-demo";
    public static final String jdbcUserName = "root";
    public static final String jdbcPassword = "newpassword";


    public static final int initCount = 10;
    public static final int step = 2;//连接池不足的时候的增长的步进数
    public static final int maxCount = 50;
}
