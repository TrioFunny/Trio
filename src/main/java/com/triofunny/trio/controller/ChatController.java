package com.triofunny.trio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.triofunny.trio.model.User;
import com.triofunny.trio.service.IUserService;
import com.triofunny.trio.util.msg.ResultMsg;

@Controller
@RequestMapping("/chat")
public class ChatController {
	@Autowired
	private IUserService userService;

	@RequestMapping("/friends")
	@ResponseBody
	public ResultMsg SearchFriends() {
		ResultMsg resultMsg = new ResultMsg();
		List<User> listUser=userService.selectUser("1=1");
		resultMsg.success(listUser);
		return resultMsg;
	}
}
