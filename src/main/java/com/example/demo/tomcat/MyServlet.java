package com.example.demo.tomcat;

/**
 * @author admin
 * @date 2018-9-21 10:00
 */
public  abstract class MyServlet {
    public abstract void doGet(MyRequest myRequest,MyResponse myResponse);

    public abstract void doPost(MyRequest myRequest,MyResponse myResponse);

    public void service(MyRequest myRequest,MyResponse myResponse){
        if(myRequest.getMethod().equalsIgnoreCase("Post")){
            doPost(myRequest,myResponse);
        }else if(myRequest.getMethod().equalsIgnoreCase("GET")){
            doGet(myRequest,myResponse);
        }
    }
}
