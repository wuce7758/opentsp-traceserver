package com.mapbar.traceserver.fence.command;

import javax.validation.constraints.NotNull;

import com.mapbar.traceserver.annotation.Trace;
import com.mapbar.traceserver.command.result.CommonResult;
import com.navinfo.opentsp.common.messaging.AbstractSecuredCommand;

/**
 * 查询围栏内监控对象历史报警信息命令对象
 * 
 * @author xubh
 */
@Trace
public class FenceHistoryAlarmCommand extends AbstractSecuredCommand<CommonResult> {

	@NotNull
	private String ak;// 用户授权标识
	@NotNull
	private String service_id;// 服务的唯一标识
	@NotNull
	private Integer fence_id;// 围栏唯一标识
	private String monitored_persons;// 监控对象列表，表示查询哪些监控对象的历史动作，如果为空，则查询所有监控对象的历史动作。最多五个
	private String start_time;// 开始时间
	private String end_time;// 结束时间

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

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
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
