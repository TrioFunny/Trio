package com.triofunny.trio.dao;


import com.triofunny.trio.model.WorkExperience;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WorkExperienceMapper {
    int deleteByPrimaryKey(String id);

    int insert(WorkExperience record);

    int insertSelective(WorkExperience record);

    WorkExperience selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(WorkExperience record);

    int updateByPrimaryKey(WorkExperience record);
}