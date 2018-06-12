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
import java.util.List;
import java.util.UUID;

@Controller()
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/login")
	@ResponseBody
	public ResultMsg login(HttpServletRequest request, String userName, String password) {
		ResultMsg resultMsg = new ResultMsg();
		if (userName.equals("") || password.equals("")) {
			resultMsg.error(ResultContant.RESULT_MSG_FAIL_NO_PARA, ResultContant.RESULT_CODE_FAIL_NO_PARA);
			return resultMsg;
		}
		User user = userService.selectByUserName(userName);
		if (user != null) {
			resultMsg.success(user);
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
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
	public ResultMsg register(HttpServletRequest request, String userName, String password) {
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
	public ResultMsg getUserInfo(HttpServletRequest request, String userName) {
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

	@RequestMapping(value = "/changePassword")
	@ResponseBody
	public ResultMsg changePassword(HttpServletRequest request, String oldPass, String pass) {
		ResultMsg resultMsg = new ResultMsg();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user == null) {
			//System.out.println("空");
			resultMsg.error(ResultContant.RESULT_MSG_NOT_LOGIN_ERROR, ResultContant.RESULT_CODE_NOT_LOGIN_ERROR);
			return resultMsg;
		}
		if (!user.getPassword().equals(oldPass)) {
			resultMsg.error(ResultContant.RESULT_MSG_PASSWORD_ERROR, ResultContant.RESULT_CODE_PASSWORD_ERROR);
			return resultMsg;
		}
		user.setPassword(pass);
		try {
			userService.updateByPrimaryKey(user);
		} catch (Exception e) {
			e.printStackTrace();
			resultMsg.error(ResultContant.RESULT_MSG_CHANGE_PASSWORD_ERROR,
					ResultContant.RESULT_CODE_CHANGE_PASSWORD_ERROR);
			return resultMsg;
		}
		String msg = "用户名使用成功";
		resultMsg.success(msg);
		return resultMsg;
	}
}
