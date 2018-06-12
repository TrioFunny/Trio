package com.triofunny.trio.dao;


import com.triofunny.trio.model.Resume;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ResumeMapper {
    int deleteByPrimaryKey(String id);

    int insert(Resume record);

    int insertSelective(Resume record);

    Resume selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Resume record);

    int updateByPrimaryKey(Resume record);
}