package com.triofunny.trio.controller;

import com.triofunny.trio.dto.BaseDto;
import com.triofunny.trio.dto.UserInfoDto;
import com.triofunny.trio.model.User;
import com.triofunny.trio.service.IUserService;
import com.triofunny.trio.util.FileUploadUtil;
import com.triofunny.trio.util.contstant.ResultContant;
import com.triofunny.trio.util.msg.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.Console;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller()
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;

	/**
	 * 获取用户信息
	 * @param userId
	 * @return
	 */
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

	/**
	 * 获取头像
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getImage")
	@ResponseBody
	public ResultMsg getImage(String userId) {
		ResultMsg resultMsg = new ResultMsg();
		// 默认头像
		String imageUrl = "";
		User user=userService.selectByPrimaryKey(userId);
		if (user != null) {
			imageUrl = user.getHeadportrait();
		}
		resultMsg.success(imageUrl);
		return resultMsg;
	}
	@RequestMapping(value = "/postImage")
	@ResponseBody
	public ResultMsg postImage(HttpServletRequest request,String userId, MultipartFile photofile) {
		ResultMsg resultMsg = new ResultMsg();
		User user=userService.selectByPrimaryKey(userId);
		if (user == null) {
			System.out.println("用户未登录");
			resultMsg.error(ResultContant.RESULT_MSG_NOT_LOGIN_ERROR, ResultContant.RESULT_CODE_NOT_LOGIN_ERROR);
			return resultMsg;
		}
		if (photofile.isEmpty()) {
			System.out.println("上传失败");
			resultMsg.error(ResultContant.RESULT_MSG_FAIL, ResultContant.RESULT_CODE_FAIL);
			return resultMsg;
		}
		user.setHeadportrait(FileUploadUtil.getfilePath(photofile, request));
		resultMsg.success("success");
		System.out.println("成功！");
		return resultMsg;
	}

	/**
	 * 获取用户信息 
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

	@RequestMapping(value = "/changePassword")
	@ResponseBody
	public ResultMsg changePassword(BaseDto dto, String oldPass, String pass) {
		ResultMsg resultMsg = new ResultMsg();
		if (StringUtils.isEmpty(dto.getUserId())) {
			//System.out.println("空");
			resultMsg.error(ResultContant.RESULT_MSG_NOT_LOGIN_ERROR, ResultContant.RESULT_CODE_NOT_LOGIN_ERROR);
			return resultMsg;
		}
		if(StringUtils.isEmpty(oldPass)||StringUtils.isEmpty(pass)) {
			resultMsg.error(ResultContant.PARAMETER_IS_EMPTY_MSG, ResultContant.PARAMETER_IS_EMPTY_CODE);
		}
		User user=userService.selectByPrimaryKey(dto.getUserId());
		if(!user.getPassword().equals(oldPass)){
			resultMsg.error(ResultContant.RESULT_MSG_PASSWORD_ERROR, ResultContant.RESULT_CODE_PASSWORD_ERROR);
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
	
	@RequestMapping(value = "/test")
	@ResponseBody
	public ResultMsg test(String data) {
		ResultMsg resultMsg = new ResultMsg();
		resultMsg.success(null);
		
		return resultMsg;
	}
	
}
