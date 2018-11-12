package com.example.demo;

import com.example.demo.dao.entity.Scope;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    private Map<String,Object> map = new HashMap<>();

    @Test
    public void contextLoads() {
        map.put("name","zhangsan");
        map.put("name","zhaosi");

        System.out.println(map.toString());
    }


    @Test
    public void testSpringSingle(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/resources/Spring.xml");
        Scope scope = (Scope) ctx.getBean("scopeTest");
        Scope scopeDuplicate = (Scope) ctx.getBean("scopeTestDuplicate");
        System.out.println(scope == scopeDuplicate);
        System.out.println(scope + "::" + scopeDuplicate);

    }

    public void  testDruid(){
       //Map<String,DataSource> datasource  =
    }
}
