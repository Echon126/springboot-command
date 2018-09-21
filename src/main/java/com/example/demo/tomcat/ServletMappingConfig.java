package com.example.demo.tomcat;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO 类似于tomcat中的web.xml配置文件中通过和来进行指定那个URL交个那个servlet来进行处理
 * @author admin
 * @date 2018-9-21 10:10
 */
public class ServletMappingConfig {
    public static List<ServletMapping> servletMappingList = new ArrayList();

    //TODO 将具体的url和对应的servlet关联起来
    static{
        servletMappingList.add(new ServletMapping("findGirl","/girl","com.example.demo.tomcat.FindGirlServlet"));
        servletMappingList.add(new ServletMapping("helloworld","/world","com.example.demo.tomcat.HelloWorldServlet"));
    }

}
