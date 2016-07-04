package com.mapbar.traceserver.fence.handler;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mapbar.traceserver.command.result.CommonResult;
import com.mapbar.traceserver.fence.command.FenceQueryStatusCommand;
import com.mapbar.traceserver.model.Fence;
import com.mapbar.traceserver.service.FenceService;
import com.navinfo.opentspcore.common.handler.AbstractCommandHandler;

/**
 * 查询围栏内监控对象的状态
 * 
 * @author xubh
 */
@Component
public class FenceStatusHandler extends AbstractCommandHandler<FenceQueryStatusCommand, CommonResult> {

	private static final Logger logger = LoggerFactory.getLogger(FenceStatusHandler.class);

	@Resource
	private FenceService fenceService;

	public FenceStatusHandler() {
		super(FenceQueryStatusCommand.class, CommonResult.class);
	}

	protected FenceStatusHandler(Class<FenceQueryStatusCommand> commandType, Class<CommonResult> resultType) {
		super(commandType, resultType);
	}

	@Override
	public CommonResult handle(FenceQueryStatusCommand command) {
		Fence fence = new Fence();
		fence.setId(command.getFence_id());
		fence.setAk(command.getAk());
		fence.setServiceId(command.getService_id());
		fence.setMonitoredPersons(command.getMonitored_persons());
		CommonResult json = new CommonResult();
		try {
			fenceService.queryStatusFence(fence);
		} catch (Exception e) {
			logger.info("查询围栏内监控对象的状态失败", e);
			json.put("status", 1);
			json.put("msg", e.getMessage());

		}
		return json;
	}
}
