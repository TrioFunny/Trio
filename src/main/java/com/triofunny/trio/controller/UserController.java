package com.triofunny.trio.controller;

import com.triofunny.trio.dto.UserInfoDto;
import com.triofunny.trio.model.User;
import com.triofunny.trio.service.IUserService;
import com.triofunny.trio.util.contstant.ResultContant;
import com.triofunny.trio.util.msg.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller()
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/getUser")
	@ResponseBody
	public ResultMsg getUser( String userId) {
		ResultMsg resultMsg = new ResultMsg();
		if (userId == null) {
			resultMsg.error(ResultContant.RESULT_MSG_FAIL_NO_PARA, ResultContant.RESULT_CODE_FAIL_NO_PARA);
			return resultMsg;
		}
		User uesr = userService.selectByPrimaryKey(userId);
		if (uesr != null) {
			resultMsg.success(uesr);
		}
		return resultMsg;
	}

	@RequestMapping(value = "getImage", method = RequestMethod.GET)
	@ResponseBody
	public ResultMsg getImage(HttpServletRequest request) {
		ResultMsg resultMsg = new ResultMsg();
		// 默认头像
		String imageUrl = "/static/img/headPortrait/1111.jpg";
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user != null) {
			imageUrl = user.getHeadportrait();
		}
		resultMsg.success(imageUrl);
		return resultMsg;
	}

	/**
	 * 获取用户信息 wkf
	 * 
	 * @param request
	 * @param response
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/getUserInfo")
	@ResponseBody
	public ResultMsg getUserInfo(String userId) {
		ResultMsg resultMsg = new ResultMsg();
		if (userId == null) {
			resultMsg.error(ResultContant.RESULT_MSG_FAIL_NO_PARA, ResultContant.RESULT_CODE_FAIL_NO_PARA);
			return resultMsg;
		}
		User uesr = userService.selectByPrimaryKey(userId);
		if (uesr != null) {
			resultMsg.success(uesr);
		}
		return resultMsg;
	}

	/**
	 * 修改用户信息
	 * 
	 * @param request
	 * @param response
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/alterUserInfo")
	@ResponseBody
	public ResultMsg alterUserInfo(UserInfoDto userDto) {
		ResultMsg resultMsg = new ResultMsg();

		if (userDto.getId() == null) {
			resultMsg.error(ResultContant.RESULT_MSG_FAIL_NO_PARA, ResultContant.RESULT_CODE_FAIL_NO_PARA);
			return resultMsg;
		}
		User user = userDto.toUser();
		int result = userService.updateByPrimaryKeySelective(user);
		if (result > 0) {
			resultMsg.success(null);
		}
		return resultMsg;
	}

}
