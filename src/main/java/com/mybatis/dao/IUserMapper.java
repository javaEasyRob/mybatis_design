package com.mybatis.dao;

import com.mybatis.domain.User;
import com.mybatis.mybatis.annotations.Select;

import java.util.List;

/**
 * Dao类接口
 */
public interface IUserMapper {
    @Select("select * from user")
    List<User> findAll();
}
