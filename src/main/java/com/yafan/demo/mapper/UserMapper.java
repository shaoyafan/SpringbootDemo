package com.yafan.demo.mapper;

import com.yafan.demo.pojo.NUser;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper extends BaseMapper<NUser> {
    boolean addUser(NUser nUser);
    boolean deleteUser(String id);
    List<NUser> getNUser(String id);
    boolean updateUser(NUser nUser);
}
