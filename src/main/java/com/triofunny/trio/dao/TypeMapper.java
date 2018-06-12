package com.triofunny.trio.dao;


import com.triofunny.trio.model.Type;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TypeMapper {
    int deleteByPrimaryKey(String id);

    int insert(Type record);

    int insertSelective(Type record);

    Type selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Type record);

    int updateByPrimaryKey(Type record);
}