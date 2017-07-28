package cn.zpro.mybatis.service;

import cn.zpro.mybatis.mapper.UserMapper;
import cn.zpro.mybatis.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> findAll(){
        return userMapper.findAll();
    }
}
