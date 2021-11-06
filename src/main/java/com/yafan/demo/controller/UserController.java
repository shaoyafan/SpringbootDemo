package com.yafan.demo.controller;


import cn.hutool.core.util.IdUtil;
import com.yafan.demo.pojo.NUser;
import com.yafan.demo.service.NUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    private NUserService nUserService;

    @GetMapping(value = "/get/{id}")
    public List<NUser> getNUser(@PathVariable("id") String id){
        List<NUser> result = nUserService.getNUser(id);
        System.out.println("方法执行中。。。。。。。");
        return result;
    }
    
    @PostMapping(value = "/add/{name}")
    public boolean addUser(String name){
        // getSnowflake(x,y) 设备id 区域id
        NUser nUser = new NUser()
                .setId(IdUtil.getSnowflake(1,1).nextIdStr())
                .setAge(13)
                .setAddress("深圳")
                .setName(name);
        return nUserService.addUser(nUser);

    }


}
