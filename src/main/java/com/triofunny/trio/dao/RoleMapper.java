package com.triofunny.trio.dao;


import com.triofunny.trio.model.Role;
import com.triofunny.trio.model.RoleRule;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleMapper {
    int deleteByPrimaryKey(String id);

    int insert(RoleRule record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}