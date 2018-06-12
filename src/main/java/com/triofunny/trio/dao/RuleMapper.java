package com.triofunny.trio.dao;


import com.triofunny.trio.model.Rule;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RuleMapper {
    int deleteByPrimaryKey(String id);

    int insert(Rule record);

    int insertSelective(Rule record);

    Rule selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Rule record);

    int updateByPrimaryKey(Rule record);
}