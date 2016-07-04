package com.mapbar.traceserver.fence.command;

import javax.validation.constraints.NotNull;

import com.mapbar.traceserver.annotation.Trace;
import com.mapbar.traceserver.command.result.CommonResult;
import com.navinfo.opentsp.common.messaging.AbstractSecuredCommand;

/**
 * 查询围栏内监控对象状态命令对象
 * 
 * @author xubh
 */
@Trace
public class FenceQueryStatusCommand extends AbstractSecuredCommand<CommonResult> {

	@NotNull
	private String ak;// 用户授权标识
	@NotNull
	private String service_id;// 服务的唯一标识
	@NotNull
	private Integer fence_id;// 围栏唯一标识
	private String monitored_persons;// 多个对象用逗号分隔。表示查询那些监控对象的状态。不填时，查询所有监控对象的状态

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

	public Integer getFence_id() {
		return fence_id;
	}

	public void setFence_id(Integer fence_id) {
		this.fence_id = fence_id;
	}

	public String getMonitored_persons() {
		return monitored_persons;
	}

	public void setMonitored_persons(String monitored_persons) {
		this.monitored_persons = monitored_persons;
	}

	@Override
	public Class<? extends CommonResult> getResultType() {
		return CommonResult.class;
	}
}
