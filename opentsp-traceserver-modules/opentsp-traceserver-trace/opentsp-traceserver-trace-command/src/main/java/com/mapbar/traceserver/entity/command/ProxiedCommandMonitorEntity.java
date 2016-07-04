package com.mapbar.traceserver.entity.command;

import com.mapbar.traceserver.annotation.Trace;
import com.mapbar.traceserver.command.result.CommonResult;
import com.navinfo.opentsp.common.messaging.ProxiedCommand;

/**
 * 获取headers Command
 * 
 * @author xubh
 */
@Trace
public class ProxiedCommandMonitorEntity extends ProxiedCommand<CommonResult> {

	private String param;

	private String url;

	@Override
	public Class<? extends CommonResult> getResultType() {
		return CommonResult.class;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
