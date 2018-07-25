package com.example.demo.dao.entity;

public class SRole implements java.io.Serializable{
    private Integer id;
    private SUser SUser;
    private String name;

    public SRole() {
    }

    public SRole(SUser SUser) {
        this.SUser = SUser;
    }
    public SRole(SUser SUser, String name) {
        this.SUser = SUser;
        this.name = name;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public com.example.demo.dao.entity.SUser getSUser() {
        return SUser;
    }

    public void setSUser(com.example.demo.dao.entity.SUser SUser) {
        this.SUser = SUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
