package com.example.demo.connector;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {
    public static IMyPool  myPool = MyPoolFactory.getInstance();
    public static void main(String[] args) throws SQLException {
        for(int i=0;i<1000;i++){
            MyPooledConnection myPooledConnection = myPool.getMyPooledConnection();
            ResultSet query = myPooledConnection.query("select * from user");

            while(query.next()){
                System.out.println(query.getString("name")+" , "+ query.getString("text")+" 使用管道 "+myPooledConnection.getConnection());
            }
            myPooledConnection.close();
        }
    }
}
