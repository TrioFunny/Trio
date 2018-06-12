package com.triofunny.trio.util.basics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;


/**
 * 
 * wkf
 * 2018-2-8
 */
@Controller
@RequestMapping("/baseController")
public class BaseController {

	/**
	 * 初始化的时候执行一些操作
	 * wkf
	 * 2018-2-8
	 *@param binder
	 */
	@InitBinder
	public void initBinder(ServletRequestDataBinder binder, HttpServletResponse response){
		//防止XSS攻击
//		binder.registerCustomEditor(String.class, new DefenseXss(true, false));
		response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, accept, content-type, xxxx");
		response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
		response.setHeader("Access-Control-Allow-Origin", "*");
	}



}
