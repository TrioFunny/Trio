package com.triofunny.trio.dao;


import com.triofunny.trio.model.Friends;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FriendsMapper {
    int insert(Friends record);

    int insertSelective(Friends record);
}