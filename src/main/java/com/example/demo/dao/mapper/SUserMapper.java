package com.example.demo.dao.mapper;

import com.example.demo.dao.entity.SUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SUserMapper {

    List<SUser> findAll() throws Exception;

    int save(SUser sUser) throws Exception;

    SUser findOne(int id) throws Exception;

    SUser findByEmailAndPassword(String email, String password) throws Exception;

    int update(SUser sUser) throws Exception;

    void deleteUser(int id) throws Exception;

    SUser findUserByEmail(String email) throws Exception;
}
