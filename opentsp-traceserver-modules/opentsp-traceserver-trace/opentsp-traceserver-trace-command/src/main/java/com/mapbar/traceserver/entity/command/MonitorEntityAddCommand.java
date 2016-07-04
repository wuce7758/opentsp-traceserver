package com.mapbar.traceserver.entity.command;

import javax.validation.constraints.NotNull;

import com.mapbar.traceserver.annotation.Trace;
import com.mapbar.traceserver.command.result.CommonResult;
import com.navinfo.opentsp.common.messaging.AbstractSecuredCommand;

/**
 * 添加监控对象命令对象
 * 
 * @author xubh
 */
@Trace
public class MonitorEntityAddCommand extends AbstractSecuredCommand<CommonResult> {

	@NotNull(message = "用户授权标识不能为空")
	private String ak;// 用户授权标识
	@NotNull(message = "服务标识不能为空")
	private String service_id;// 服务的唯一标识
	@NotNull(message = "监控对象名称不能为空")
	private String entity_name;// 监控对象名称,同一服务下允许重复

	private String column;// 自定义字段,json字符串

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

	public String getEntity_name() {
		return entity_name;
	}

	public void setEntity_name(String entity_name) {
		this.entity_name = entity_name;
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
}
