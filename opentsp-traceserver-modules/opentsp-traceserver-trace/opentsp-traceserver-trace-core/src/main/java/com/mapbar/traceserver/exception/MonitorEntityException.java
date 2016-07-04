package com.mapbar.traceserver.exception;

public class MonitorEntityException extends RuntimeException {

	private static final long serialVersionUID = -9170208684596321277L;
	private String code; // 异常对应的返回码
	private String msg; // 异常对应的描述信息

	public MonitorEntityException() {
		super();
	}

	public MonitorEntityException(String msg) {
		super(msg);
		this.msg = msg;
	}

	public MonitorEntityException(String code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
}