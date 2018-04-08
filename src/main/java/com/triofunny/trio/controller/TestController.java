package com.triofunny.trio.controller;

import com.triofunny.trio.dao.UserDao;
import com.triofunny.trio.model.User;
import com.triofunny.trio.model.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

//    @Autowired
//    private UserMapper userMapper;
    @Autowired
    private UserDao userDao;

    @RequestMapping("/")
    public String Home() {

        return "asdf";
    }
    @RequestMapping("/find/mybatis/id")
    public String findMailByToFromMybatis(Long id) {
        User userMo1 = userDao.selectUserById(id);
        return "userMapper: " + userMo1.toString();
    }

//    @RequestMapping(value = { "/book" }, produces="application/json;charset=UTF-8")
//    public Book Gs(){
//        var s = new Book();
//        s.name="asdf";
//        s.user="asdfas";
//        return s;
//    }
}
