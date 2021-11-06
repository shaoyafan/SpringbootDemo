package com.yafan.demo.service.Impl;

import com.yafan.demo.datasource.DataSourceSelector;
import com.yafan.demo.mapper.UserMapper;
import com.yafan.demo.meiju.DynamicDataSourceEnum;
import com.yafan.demo.pojo.NUser;
import com.yafan.demo.service.NUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NUserServiceImpl implements NUserService {

    @Autowired
    private UserMapper userMapper;
//    @Resource
//    private MongoTemplate mongoTemplate;

    @Override
    @DataSourceSelector(value = DynamicDataSourceEnum.SLAVE)
    @Transactional(propagation= Propagation.NOT_SUPPORTED) //如果存在事务可能还是强制走主库
    public List<NUser> getNUser(String id) {
        return userMapper.getNUser(id);
    }

    @Override
    public boolean addUser(NUser nUser) {
        return userMapper.addUser(nUser);
    }
}
