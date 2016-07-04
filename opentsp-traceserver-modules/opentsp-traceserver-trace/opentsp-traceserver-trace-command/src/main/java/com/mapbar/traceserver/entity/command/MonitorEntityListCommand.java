package com.mapbar.traceserver.entity.command;

import javax.validation.constraints.NotNull;

import com.mapbar.traceserver.annotation.Trace;
import com.mapbar.traceserver.command.result.CommonResult;
import com.navinfo.opentsp.common.messaging.AbstractSecuredCommand;

/**
 * 列出监控对象命令对象
 * 
 * @author xubh
 */
@Trace
public class MonitorEntityListCommand extends AbstractSecuredCommand<CommonResult> {

	@NotNull
	private String ak;// 用户授权标识
	@NotNull
	private String service_id;// 服务的唯一标识
	
	private String entity_names;// 支持输入多个entity_name，以英文 ’,’ 逗号分开，如： car01,car02,car03

	private String column;// 自定义字段,json字符串

	// 定义的查询字段
	private String active_time;// 指定该字段时,返回从该时间点之后仍有位置变动的监控对象
	private int page_index = 1;// 默认值为1。page_index与page_size一起计算从第几条结果返回，代表返回第几页
	private int page_size = 100;// 默认值为100。page_size与page_index一起计算从第几条结果返回，代表返回结果中每页有几条记录。

	public String getAk() {
		return ak;
	}

	public void setAk(String ak) {
		this.ak = ak;
	}

	public String getService_id() {
		return service_id;
	}

	public void setService_id(String service_id) {
		this.service_id = service_id;
	}

	public String getEntity_names() {
		return entity_names;
	}

	public void setEntity_names(String entity_names) {
		this.entity_names = entity_names;
	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	@Override
	public Class<? extends CommonResult> getResultType() {
		return CommonResult.class;
	}

	public String getActive_time() {
		return active_time;
	}

	public void setActive_time(String active_time) {
		this.active_time = active_time;
	}

	public int getPage_index() {
		return page_index;
	}

	public void setPage_index(int page_index) {
		this.page_index = page_index;
	}

	public int getPage_size() {
		return page_size;
	}

	public void setPage_size(int page_size) {
		this.page_size = page_size;
	}

}
