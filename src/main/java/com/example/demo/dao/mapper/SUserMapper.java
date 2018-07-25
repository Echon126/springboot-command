package com.example.demo.dao.mapper;

import com.example.demo.dao.entity.SUser;
import com.example.demo.dao.provider.BaseUserProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@Mapper
public interface SUserMapper {

    List<SUser> findAll() throws Exception;

    int save(SUser sUser) throws Exception;

    SUser findOne(int id) throws Exception;

    SUser findByEmailAndPassword(String email, String password) throws Exception;

    int update(SUser sUser) throws Exception;

    void deleteUser(int id) throws Exception;

    @SelectProvider(type=BaseUserProvider.class,method = "findUserByEmail")
    SUser findUserByEmail(String name) throws Exception;
}
