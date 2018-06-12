package com.triofunny.trio.dao;


import com.triofunny.trio.model.Sign;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SignMapper {
    int deleteByPrimaryKey(String id);

    int insert(Sign record);

    int insertSelective(Sign record);

    Sign selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Sign record);

    int updateByPrimaryKey(Sign record);
}