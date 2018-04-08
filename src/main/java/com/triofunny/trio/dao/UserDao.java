package com.triofunny.trio.dao;

import com.triofunny.trio.model.User;
import com.triofunny.trio.model.UserMapper;
import org.springframework.stereotype.Component;
import org.apache.ibatis.session.SqlSession;
@Component
public class UserDao implements UserMapper {
    private final SqlSession sqlSession;

    public UserDao(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public User selectUserById(long id) {
        return this.sqlSession.selectOne("selectUserById", id);
    }

}
