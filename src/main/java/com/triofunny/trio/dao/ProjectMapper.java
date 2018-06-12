package com.triofunny.trio.dao;


import com.triofunny.trio.model.Project;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProjectMapper {
    int deleteByPrimaryKey(String id);

    int insert(Project record);

    int insertSelective(Project record);

    Project selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKey(Project record);
}