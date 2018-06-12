package com.triofunny.trio.service.impl;

import com.triofunny.trio.dao.UserMapper;
import com.triofunny.trio.model.User;
import com.triofunny.trio.service.IUserService;
import com.triofunny.trio.util.mybatisUtil.SqlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserMapper userMapper;
	
	
	@Override
	public int deleteByPrimaryKey(String id) {
		return 0;
	}

	@Override
	public int insert(User record) {
		return 0;
	}

	@Override
	public int insertSelective(User record) {
		
		return userMapper.insertSelective(record);
	}

	@Override
	public User selectByPrimaryKey(String id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(User record) {
		return userMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(User record) {
		return 0;
	}

	@Override
	public User selectByUserName(String userName) {
		String sql=" ";
		sql=SqlUtil.spliceSpl(SqlUtil.SpliceType.EqualTo, "userName", userName);
		return userMapper.selectBySql(sql);
	}

	@Override
	public List<User> selectUser(String sql) {
		
		return userMapper.selectUser(sql);
	}

}
