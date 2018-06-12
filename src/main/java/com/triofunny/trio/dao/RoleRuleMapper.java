package com.triofunny.trio.dao;


import com.triofunny.trio.model.Role;
import com.triofunny.trio.model.RoleRule;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleRuleMapper {
    int insert(Role record);

    int insertSelective(RoleRule record);
}