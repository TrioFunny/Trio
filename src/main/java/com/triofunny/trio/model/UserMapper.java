package com.triofunny.trio.model;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User selectUserById(long id);
}
