package com.example.demo.tomcat;

import java.io.IOException;

/**
 * @author admin
 * @date 2018-9-21 10:06
 */
public class FindGirlServlet extends MyServlet {
    @Override
    public void doGet(MyRequest myRequest, MyResponse myResponse) {
        try{
            myResponse.write("get girl.....");
        }catch (IOException r){
            r.printStackTrace();
        }
    }

    @Override
    public void doPost(MyRequest myRequest, MyResponse myResponse) {
        try{
            myResponse.write("Post girl.....");
        }catch (IOException r){
            r.printStackTrace();
        }
    }
}
