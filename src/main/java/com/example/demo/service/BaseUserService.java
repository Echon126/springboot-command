package com.example.demo.service;

import com.example.demo.dao.entity.User;
import com.example.demo.dao.mapper.UserMapperDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BaseUserService {

    @Autowired
    private  UserMapperDao userMapperDao;


    public List<User>queryUserInfoAll() throws Exception {
       return this.userMapperDao.queryUserInfoAll();
    }

    public List<Map<String, Object>> queryUserInfo(Map<String, Object> paramMap) throws Exception {
        return this.userMapperDao.queryUserInfo(paramMap);
    }
}
