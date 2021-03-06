package com.triofunny.trio.controller;

import com.triofunny.trio.model.User;
import com.triofunny.trio.service.IUserService;
import com.triofunny.trio.util.contstant.ResultContant;
import com.triofunny.trio.util.msg.ResultMsg;
import com.triofunny.trio.util.mybatisUtil.SqlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller()
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/login")
	@ResponseBody
	public ResultMsg login(String userName, String password) {
		ResultMsg resultMsg = new ResultMsg();
		if (StringUtils.isEmpty(userName)||StringUtils.isEmpty(password)) {
			resultMsg.error(ResultContant.RESULT_MSG_FAIL_NO_PARA, ResultContant.RESULT_CODE_FAIL_NO_PARA);
			return resultMsg;
		}
		User user = userService.selectByUserName(userName);
		if (user != null) {
			Map<String,Object> resultMap=new HashMap<>();
			resultMap.put("userId", user.getId());
			resultMsg.success(resultMap);
		} else {
			resultMsg.error(ResultContant.RESULT_MSG_USERNAME_ERROR, ResultContant.RESULT_CODE_USERNAME_ERROR);
		}
		return resultMsg;
	}

	@RequestMapping(value = "/checkUserName")
	@ResponseBody
	public ResultMsg regist(String userName) {
		ResultMsg resultMsg = new ResultMsg();
		if (StringUtils.isEmpty(userName)) {
			resultMsg.error(ResultContant.RESULT_MSG_USERNAME_NULL, ResultContant.RESULT_CODE_USERNAME_NUll);
			return resultMsg;
		} else {
			String sql = SqlUtil.spliceSpl(SqlUtil.SpliceType.EqualTo, "userName", userName);
			List<User> uesrList = userService.selectUser(sql);
			if (uesrList.size() != 0) {
				resultMsg.error(ResultContant.RESULT_MSG_USERNAME_REPEAT, ResultContant.RESULT_CODE_USERNAME_REPEAT);
				return resultMsg;
			} else {
				String msg = "用户名使用成功";
				resultMsg.success(msg);
				return resultMsg;
			}
		}
	}

	@RequestMapping(value = "/regist")
	@ResponseBody
	public ResultMsg register(String userName, String password) {
		ResultMsg resultMsg = new ResultMsg();
		if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)) {
			resultMsg.error(ResultContant.RESULT_MSG_FAIL_NO_PARA, ResultContant.RESULT_CODE_FAIL_NO_PARA);
			return resultMsg;
		}
		// // 用户名不重复
		// String sql = SqlUtil.spliceSpl(SpliceType.EqualTo, "userName",
		// userName);
		// List<User> uesrList = userService.selectUser(sql);
		// if (uesrList.size() == 0) {
		// 可以注册
		User user = new User();
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		user.setId(uuid);
		user.setUsername(userName);
		user.setPassword(password);
		if (userService.insertSelective(user) > 0) {
			resultMsg.success(null);
			return resultMsg;
		}
		resultMsg.error(ResultContant.RESULT_MSG_REGISTER_FAIL, ResultContant.RESULT_CODE_REGISTER_FAIL);

		// } else {
		// resultMsg.error(ResultContant.RESULT_MSG_USERNAME_REPEAT,
		// ResultContant.RESULT_CODE_USERNAME_REPEAT);
		// }

		return resultMsg;
	}

	@RequestMapping(value = "/userInfo")
	@ResponseBody
	public ResultMsg getUserInfo(String userId, String userName) {
		ResultMsg resultMsg = new ResultMsg();
		if (userName.equals("")) {
			resultMsg.error(ResultContant.RESULT_MSG_FAIL_NO_PARA, ResultContant.RESULT_CODE_FAIL_NO_PARA);
			return resultMsg;
		}
		// 用户名不重复
		String sql = SqlUtil.spliceSpl(SqlUtil.SpliceType.EqualTo, "userName", userName);
		List<User> user = userService.selectUser(sql);

		return resultMsg;
	}


}
