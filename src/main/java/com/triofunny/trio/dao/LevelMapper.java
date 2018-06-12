package com.triofunny.trio.dao;


import com.triofunny.trio.model.Level;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LevelMapper {
    int deleteByPrimaryKey(String id);

    int insert(Level record);

    int insertSelective(Level record);

    Level selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Level record);

    int updateByPrimaryKey(Level record);
}