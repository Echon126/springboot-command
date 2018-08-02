package com.example.demo.security;

import com.example.demo.configuration.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)//开启Security注解
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // http.csrf().disable();
        http.authorizeRequests()
                //.antMatchers("/", "/home").permitAll()
                //其他地址的访问均需要验证权限
                .anyRequest().authenticated()
                .and()
                .formLogin()
                //指定登录页是"/login"
                .loginPage("/login")
                .defaultSuccessUrl("/hello")//登录成功后跳转到"/hello"
                .permitAll()
                .and()
                .logout().logoutUrl("/home")
                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService())
                .passwordEncoder(passwordEncoder());

        auth.eraseCredentials(false);//允许记住密码
    }

    /**
     * 设置用户密码的加密方式为MD5加密
     *
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();

    }

    @Bean
    public CustomUserDetailsService customUserDetailsService() {
        return new CustomUserDetailsService();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //解决静态资源被拦截的问题
        web.ignoring().antMatchers("/**/*.js","/css/**");
    }

       /* public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String str = encoder.encode("123456");
        System.out.println(str);
        boolean corrent = encoder.matches("123456","$2a$04$9SajUrq2nsm5YNJ37yHpFObTLvfOr3Mfxa2yQ62E0MHV/hVxuiN2e");
        boolean corrent1 = encoder.matches("$2a$04$aYBUE69Kft5Po78eyKZWx.6lHvmk7PZVVVXW09eSdF9M/Mo2kCew.","$2a$04$9SajUrq2nsm5YNJ37yHpFObTLvfOr3Mfxa2yQ62E0MHV/hVxuiN2e");
        System.out.println(corrent);
        System.out.println(corrent1);
    }*/
}
