package com.example.demo.service;

import com.example.demo.dao.entity.SUser;
import com.example.demo.dao.mapper.SUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SUserService {

    @Autowired
    SUserMapper sUserMapper;


    public List<SUser> findAll() throws Exception {
        return sUserMapper.findAll();
    }

    public int create(SUser user) throws Exception {
        return sUserMapper.save(user);
    }


    public SUser findUserById(int id) throws Exception {
        return sUserMapper.findOne(id);
    }

    public SUser login(String email, String password) throws Exception {
        return sUserMapper.findByEmailAndPassword(email, password);
    }


    public int update(SUser user) throws Exception {
        return sUserMapper.save(user);
    }

    public void deleteUser(int id) throws Exception {
        sUserMapper.deleteUser(id);
    }


    public SUser findUserByEmail(String email) throws Exception {
        return sUserMapper.findUserByEmail(email);
    }
}
