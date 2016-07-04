package com.mapbar.traceserver.track.command;

import javax.validation.constraints.NotNull;

import com.mapbar.traceserver.annotation.Trace;
import com.mapbar.traceserver.command.result.CommonResult;
import com.navinfo.opentsp.common.messaging.AbstractSecuredCommand;

/**
 * 查询监控对象历史轨迹命令对象
 * 
 * @author xubh
 */
@Trace
public class TrackGetHistoryCommand extends AbstractSecuredCommand<CommonResult> {

	@NotNull
	private String ak;// 用户授权标识
	@NotNull
	private String service_id;// 服务的唯一标识
	@NotNull
	private String entity_name;// 监控对象名称,同一服务下允许重复
	@NotNull
	private String start_time;// 起始时间
	@NotNull
	private String end_time;// 结束时间 结束时间不超过当前时间，不能早于起始时间，且与起始时间差在24小时之内
	private int is_processed;// 默认值是1。拟提供两种轨迹1、经过去噪和抽稀后轨迹；2经过绑路处理的轨迹暂时不提供原始轨迹
	private String page_size;// 与page_size一起计算从第几条结果返回，代表返回第几页
	private String page_index;// 返回结果最大个数与page_index一起计算从第几条结果返回，代表返回结果中每页有几条记录

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

	public int getIs_processed() {
		return is_processed;
	}

	public void setIs_processed(int is_processed) {
		this.is_processed = is_processed;
	}

	public String getPage_size() {
		return page_size;
	}

	public void setPage_size(String page_size) {
		this.page_size = page_size;
	}

	public String getPage_index() {
		return page_index;
	}

	public void setPage_index(String page_index) {
		this.page_index = page_index;
	}

	@Override
	public Class<? extends CommonResult> getResultType() {
		return CommonResult.class;
	}
}
