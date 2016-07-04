package com.mapbar.traceserver.fence.command;

import javax.validation.constraints.NotNull;

import com.mapbar.traceserver.annotation.Trace;
import com.mapbar.traceserver.command.result.CommonResult;
import com.navinfo.opentsp.common.messaging.AbstractSecuredCommand;

/**
 * 列出电子围栏命令对象
 * 
 * @author xubh
 */
@Trace
public class FenceListCommand extends AbstractSecuredCommand<CommonResult> {

	@NotNull
	private String ak;// 用户授权标识
	@NotNull
	private String service_id;// 服务的唯一标识
	private String creator;// 围栏创建者的entity_name creator和fence_ids二者至少选一个
	private String fence_ids;// 查询的地理围栏ID列表，最多10个

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

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getFence_ids() {
		return fence_ids;
	}

	public void setFence_ids(String fence_ids) {
		this.fence_ids = fence_ids;
	}

	@Override
	public Class<? extends CommonResult> getResultType() {
		return CommonResult.class;
	}
}
