package com.triofunny.trio.util.contstant;

public class ResultContant {

	/** 操作成功 **/
	public static final String RESULT_CODE_SUCCESS = "200";
	public static final String RESULT_MSG_SUCCESS = "成功";

	/** 操作失败 **/
	public static final String RESULT_CODE_FAIL = "500";// 默认
	public static final String RESULT_MSG_FAIL = "请求失败";

	/** 操作失败 **/
	public static final String RESULT_CODE_FAIL_NO_PARA = "501";
	public static final String RESULT_MSG_FAIL_NO_PARA = "参数错误，无效的请求";
	
	/**用户未登录，请先登录**/
	public static final String RESULT_CODE_NOT_LOGIN_ERROR = "400";
	public static final String RESULT_MSG_NOT_LOGIN_ERROR = "用户未登录，请先登录";


	/** 账号不存在 **/
	public static final String RESULT_CODE_USERNAME_ERROR = "220";
	public static final String RESULT_MSG_USERNAME_ERROR = "用户名或密码错误";

	/** 账号重复 **/
	public static final String RESULT_CODE_USERNAME_REPEAT = "221";
	public static final String RESULT_MSG_USERNAME_REPEAT = "账号已被注册";

	public static final String RESULT_CODE_REGISTER_FAIL = "222";
	public static final String RESULT_MSG_REGISTER_FAIL = "注册失败";
	/** 用户名不能为空 **/
	public static final String RESULT_CODE_USERNAME_NUll = "223";
	public static final String RESULT_MSG_USERNAME_NULL = "用户名不能为空";

	/**参数为空**/
	public static final String PARAMETER_IS_EMPTY_CODE = "224";
	public static final String PARAMETER_IS_EMPTY_MSG = "参数为空";
	
	/** 密码错误 **/
	public static final String RESULT_CODE_PASSWORD_ERROR = "230";
	public static final String RESULT_MSG_PASSWORD_ERROR = "密码错误";
	/** 密码修改失败 **/
	public static final String RESULT_CODE_CHANGE_PASSWORD_ERROR = "231";
	public static final String RESULT_MSG_CHANGE_PASSWORD_ERROR = "密码修改失败";

}
