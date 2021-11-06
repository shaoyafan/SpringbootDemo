package com.yafan.demo.service;

import com.yafan.demo.pojo.NUser;

import java.util.List;

public interface NUserService{

    List<NUser> getNUser(String id);

    boolean addUser(NUser nUser);


}
