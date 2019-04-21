package com.triofunny.trio.util;

import com.alibaba.fastjson.JSONObject;
import com.triofunny.trio.websocket.chat.SocketUid;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisServiceImplTest {
    private JSONObject json = new JSONObject();
    @Autowired
    private RedisServer redisService;
    /**
     * 插入字符串
     */
    @Test
    public void setString() {
        redisService.set("redis_string_test", "springboot redis test");
    }

    /**
     * 获取字符串
     */
    @Test
    public void getString() {
        String result = redisService.get("redis_string_test");
        System.out.println(result);
    }

    /**
     * 插入对象
     */
    @Test
    public void setObject() {
        SocketUid person = new SocketUid();
        person.setUid("uid");
        person.setUuid("uuid");
        redisService.set("redis_obj_test", json.toJSONString(person));
    }

    /**
     * 获取对象
     */
    @Test
    public void getObject() {
        String result = redisService.get("redis_obj_test");
        SocketUid person = json.parseObject(result, SocketUid.class);
        System.out.println(json.toJSONString(person));
    }

//    /**
//     * 插入对象List
//     */
//    @Test
//    public void setList() {
//        Person person1 = new Person("person1", "male");
//        Person person2 = new Person("person2", "female");
//        Person person3 = new Person("person3", "male");
//        List<Person> list = new ArrayList<>();
//        list.add(person1);
//        list.add(person2);
//        list.add(person3);
//        redisService.set("redis_list_test", json.toJSONString(list));
//    }
//
//    /**
//     * 获取list
//     */
//    @Test
//    public void getList() {
//        String result = redisService.get("redis_list_test");
//        List<String> list = json.parseArray(result, String.class);
//        System.out.println(list);
//    }

    @Test
    public void remove() {
        redisService.remove("redis_test");
    }
}