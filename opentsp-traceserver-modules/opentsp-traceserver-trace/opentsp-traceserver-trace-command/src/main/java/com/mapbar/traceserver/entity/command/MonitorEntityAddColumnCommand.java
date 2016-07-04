package com.mapbar.traceserver.entity.command;

import javax.validation.constraints.NotNull;

import com.mapbar.traceserver.annotation.Trace;
import com.mapbar.traceserver.command.result.CommonResult;
import com.navinfo.opentsp.common.messaging.AbstractSecuredCommand;

/**
 * 添加监控对象属性命令对象
 * 
 * @author xubh
 */
@Trace
public class MonitorEntityAddColumnCommand extends AbstractSecuredCommand<CommonResult> {

	@NotNull
	private String ak;// 用户授权标识
	@NotNull
	private String service_id;// 服务的唯一标识
	@NotNull
	private String column_key;// 字段名称
	private String column_desc;// 字段描述
	private String column_type;// 字段类型
	private Integer is_search = 0;// 是否为检索字段，1代表检索字段，0代表非检索字段。默认为0

	@Override
	public Class<? extends CommonResult> getResultType() {
		return CommonResult.class;
	}

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

	public String getColumn_key() {
		return column_key;
	}

	public void setColumn_key(String column_key) {
		this.column_key = column_key;
	}

	public String getColumn_desc() {
		return column_desc;
	}

	public void setColumn_desc(String column_desc) {
		this.column_desc = column_desc;
	}

	public String getColumn_type() {
		return column_type;
	}

	public void setColumn_type(String column_type) {
		this.column_type = column_type;
	}

	public Integer getIs_search() {
		return is_search;
	}

	public void setIs_search(Integer is_search) {
		this.is_search = is_search;
	}

}
