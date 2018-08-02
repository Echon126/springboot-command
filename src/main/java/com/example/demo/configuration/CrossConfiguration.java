package com.example.demo.configuration;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//TODO 使用@EnableWebMvc注解后，脱离springboot的mvc配置，完全控制springmvc,
//TODO 可以自己定义一些配置，比如视图的位置等等
@Configuration
public class CrossConfiguration implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //设置允许跨域的路径
        registry.addMapping("/**")
                //设置允许跨域请求的域名
                .allowedOrigins("*")
                //是否允许证书 不再默认开启
                .allowCredentials(true)
                //设置允许的方法
                .allowedMethods("*")
                //跨域允许时间
                .maxAge(3600);
    }

    /**
     * WebMvcConfigurer 接口分析
     * TODO 1.使用jdk1.8最新的语法 default 定义方法，该关键字定义的方法不需要子类去实现
     * TODO 2.基于java—based 方式的springmvc配置，需要创建一个配置类并实现webMvc接口
     * TODO 3.WebMvcConfigurerAdapter 在springboot2.0中已经废弃
     * TODO 4.拦截器配置 addInterceptors
     *       .视图跳转控制器 addViewControllers
     *       .静态资源处理器 addViewControllers
     *       .默认静态资源处理器 configureDefaultServletHandling
     *       .配置视图解析器 configureViewResolvers
     *       .配置内容截取 configureContentNegotiation
     * TODO 链接 https://blog.csdn.net/fmwind/article/details/81235401
     *
     */
}
