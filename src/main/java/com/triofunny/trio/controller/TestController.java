package com.triofunny.trio.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping("/")
    public String Home() {

        return "asdf";
    }

//    @RequestMapping(value = { "/book" }, produces="application/json;charset=UTF-8")
//    public Book Gs(){
//        var s = new Book();
//        s.name="asdf";
//        s.user="asdfas";
//        return s;
//    }
}
