package com.example.demo.dao.mapper;

import com.example.demo.dao.entity.User;
import com.example.demo.dao.provider.BaseUserProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapperDao {

    @SelectProvider(type = BaseUserProvider.class, method = "queryUserInfoAll")
    List<User> queryUserInfoAll() throws Exception;

    @SelectProvider(type = BaseUserProvider.class, method = "queryUserInfo")
    List<Map<String, Object>> queryUserInfo(Map<String, Object> paramMap) throws Exception;
}
