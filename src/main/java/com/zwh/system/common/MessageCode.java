package com.zwh.system.common;

public interface MessageCode {
	/**
	 * 成功
	 */
	public static final int SUCCESS = 100;
	
	/**
	 * 失败
	 */
	public static final int ERROR = 101;
	
	/**
	 * 参数错误
	 */
	public static final int PARAM_ERROR = 201;
	
	/**
	 * token验证失败
	 */
	public static final int TOKEN_ERROR = 202;
	
	/**
	 * 登录失败
	 */
	public static final int UNDEFINED_USER = 203;
	
	/**
	 * 获取不到位置信息
	 */
	public static final int UNKNOWN_LOCATION = 204;
	
	/**
	 * 文件上传失败
	 */
	public static final int UPLOAD_ERROR = 205;
	
	/**
	 * 用户名已存在
	 */
	public static final int EXIST_USER = 206;
	
}
