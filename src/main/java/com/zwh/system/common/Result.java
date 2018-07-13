package com.zwh.system.common;

public class Result {
	
	public static Result SUCCESS = new Result(MessageCode.SUCCESS);
	
	public static Result ERROR = new Result(MessageCode.ERROR);
	
	private int code;
	private String msg = "";
	private Object data;
	public Result(int code) {
		this.code = code;
	}
	public Result(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	public Result(int code, Object data) {
		this.code = code;
		this.data = data;
	}
	public Result(int code, String msg, Object data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
}
