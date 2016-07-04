package com.mapbar.traceserver.trip.command;

import javax.validation.constraints.NotNull;

import com.mapbar.traceserver.annotation.Trace;
import com.mapbar.traceserver.command.result.CommonResult;
import com.navinfo.opentsp.common.messaging.AbstractSecuredCommand;

/**
 * 通过行程id获取指定行程的轨迹点命令对象
 * 
 * @author xubh
 */
@Trace
public class TripGetHistoryTripIdCommand extends AbstractSecuredCommand<CommonResult> {

	@NotNull
	private String ak;// 用户授权标识
	@NotNull
	private String service_id;// 服务的唯一标识
	@NotNull
	private String entity_name;// 监控对象名称,同一服务下允许重复
	@NotNull
	private String trip_id;// 行程id

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

	public String getTrip_id() {
		return trip_id;
	}

	public void setTrip_id(String trip_id) {
		this.trip_id = trip_id;
	}

	@Override
	public Class<? extends CommonResult> getResultType() {
		return CommonResult.class;
	}
}
