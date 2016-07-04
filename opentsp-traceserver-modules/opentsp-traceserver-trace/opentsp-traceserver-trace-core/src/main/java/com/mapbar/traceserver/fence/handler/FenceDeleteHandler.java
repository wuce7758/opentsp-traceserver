package com.mapbar.traceserver.fence.handler;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mapbar.traceserver.command.result.CommonResult;
import com.mapbar.traceserver.fence.command.FenceDeleteCommand;
import com.mapbar.traceserver.model.Fence;
import com.mapbar.traceserver.service.FenceService;
import com.navinfo.opentspcore.common.handler.AbstractCommandHandler;

/**
 * 删除围栏
 * 
 * @author xubh
 */
@Component
public class FenceDeleteHandler extends AbstractCommandHandler<FenceDeleteCommand, CommonResult> {

	protected static final Logger logger = LoggerFactory.getLogger(FenceDeleteHandler.class);

	@Resource
	private FenceService fenceService;

	public FenceDeleteHandler() {
		super(FenceDeleteCommand.class, CommonResult.class);
	}

	protected FenceDeleteHandler(Class<FenceDeleteCommand> commandType, Class<CommonResult> resultType) {
		super(commandType, resultType);
	}

	@Override
	public CommonResult handle(FenceDeleteCommand command) {
		Fence fence = new Fence();
		fence.setAk(command.getAk());
		fence.setServiceId(command.getService_id());
		fence.setId(command.getFence_id());
		CommonResult json = new CommonResult();
		try {
			fenceService.deleteFence(fence);
		} catch (Exception e) {
			logger.info("删除围栏失败", e);
			json.put("status", 1);
			json.put("msg", e.getMessage());

		}
		return json;
	}
}
