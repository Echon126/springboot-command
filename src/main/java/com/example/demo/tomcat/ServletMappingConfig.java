package com.example.demo.tomcat;

import java.util.ArrayList;
import java.util.List;

/**
 * @author admin
 * @date 2018-9-21 10:10
 */
public class ServletMappingConfig {
    public static List<ServletMapping> servletMappingList = new ArrayList();

    static{
        servletMappingList.add(new ServletMapping("findGirl","/girl","com.example.demo.tomcat.FindGirlServlet"));
        servletMappingList.add(new ServletMapping("helloworld","/world","com.example.demo.tomcat.HelloWorldServlet"));
    }

}
