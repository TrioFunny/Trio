package com.triofunny.trio.service;

import com.triofunny.trio.model.User;

import java.util.List;

public interface IUserService {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    User selectByUserName(String userName);

    List<User> selectUser(String sql);
    
}
