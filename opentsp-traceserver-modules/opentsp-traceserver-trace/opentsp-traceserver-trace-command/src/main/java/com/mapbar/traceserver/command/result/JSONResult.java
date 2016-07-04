package com.mapbar.traceserver.command.result;

import com.navinfo.opentsp.common.messaging.Command;

/**
 * 通用的json返回封装
 * 
 * @author xubh
 *
 */
public class JSONResult implements Command.Result {

	private int status = 0;
	private String msg = "成功";
	private Object obj = null;

	private Integer size;// 返回多少条
	private Long total;// 总共查询到多少条

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

}
