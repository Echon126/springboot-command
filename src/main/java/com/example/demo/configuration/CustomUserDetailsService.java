package com.example.demo.configuration;

import com.example.demo.dao.entity.SUser;
import com.example.demo.dao.entity.SecurityUser;
import com.example.demo.service.SUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomUserDetailsService implements UserDetailsService {
    @Autowired  //数据库服务类
    private SUserService suserService;//code7

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //SUser对应数据库中的用户表，是最终存储用户和密码的表，可自定义
        //本例使用SUser中的email作为用户名:
        SUser user = null; //code8
        try {
            user = suserService.findUserByEmail(userName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (user == null) {

            //throw new UsernameNotFoundException("UserName " + userName + " not found");
            // request.setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION, "用户名或者密码错误!");
            throw new AuthenticationServiceException("用户名或者密码错误!");
        }

        // SecurityUser实现UserDetails并将SUser的Email映射为username
        SecurityUser securityUser = new SecurityUser(user);
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        return securityUser; //code9

    }

    private Collection<GrantedAuthority> getAuthority() {
        List<GrantedAuthority> authorityList = new ArrayList<GrantedAuthority>();
        authorityList.add(new SimpleGrantedAuthority("ROLE_ADMINE"));
        return authorityList;
    }

    /**
     * UserDetailsService 接口作用分析
     * TODO 1.用于返回用户相关数据，声明了loadByUsername()方法，根据username查询用户实体，可以实现该接口覆盖该方法
     * TODO 实现自定义获取用户过程。
     * TODO 2.该接口实现类被DaoAuthenticationProvider类使用，用于认证过程中载入用户信息
     * TODO 3.验证身份就是加载响应的UserDetail,判断是否输入的用户账号、密码、权限信息匹配，此步骤有实现AuthenticationProvider的DaoAuthenticationProvider 处理
     * TODO 包含GrantedAuthority的UserDetails对象在构建Authentication对象是填入的数据。
     *
     */

    /**
     * 获取当前用户的信息
     * TODO SecurityContextHolder存储当前与应用程序交互的主体的详细信息
     */
    public String getContext() {
        //TODO 获取当前经过身份认证的用户的信息
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        return username;

    }

}























