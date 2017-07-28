package cn.zpro.mybatis.mapper;

import cn.zpro.mybatis.model.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    @Select("select id,user_name from sys_user")
    List<User> findAll();
}
