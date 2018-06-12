package com.triofunny.trio.dao;


import com.triofunny.trio.model.Tag;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TagMapper {
    int deleteByPrimaryKey(String id);

    int insert(Tag record);

    int insertSelective(Tag record);

    Tag selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Tag record);

    int updateByPrimaryKey(Tag record);
}