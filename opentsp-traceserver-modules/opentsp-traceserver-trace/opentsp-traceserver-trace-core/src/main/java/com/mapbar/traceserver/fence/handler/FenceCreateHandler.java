package com.mapbar.traceserver.fence.handler;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mapbar.traceserver.command.result.CommonResult;
import com.mapbar.traceserver.fence.command.FenceCreateCommand;
import com.mapbar.traceserver.model.Fence;
import com.mapbar.traceserver.service.FenceService;
import com.mapbar.traceserver.util.DateUtil;
import com.navinfo.opentspcore.common.handler.AbstractCommandHandler;

/**
 * 新增电子围栏
 * 
 * @author xubh
 */
@Component
public class FenceCreateHandler extends AbstractCommandHandler<FenceCreateCommand, CommonResult> {

	protected static final Logger logger = LoggerFactory.getLogger(FenceCreateHandler.class);

	@Resource
	private FenceService fenceService;

	public FenceCreateHandler() {
		super(FenceCreateCommand.class, CommonResult.class);
	}

	protected FenceCreateHandler(Class<FenceCreateCommand> commandType, Class<CommonResult> resultType) {
		super(commandType, resultType);
	}

	@Override
	public CommonResult handle(FenceCreateCommand command) {
		Fence fence = new Fence();
		fence.setAk(command.getAk());
		fence.setServiceId(command.getService_id());
		fence.setName(command.getName());
		fence.setDesc(command.getDesc());
		fence.setCreator(command.getCreator());
		fence.setMonitoredPersons(command.getMonitored_persons());
		fence.setValidTimes(command.getValid_times());
		fence.setValidCycle(command.getValid_cycle());
		fence.setValidDate(command.getValid_date());
		fence.setValidDays(command.getValid_days());
		fence.setShape(command.getShape());
		fence.setCoordType(command.getCoord_type());
		fence.setCenter(command.getCenter());
		fence.setRadius(command.getRadius());
		fence.setAlarmCondition(command.getAlarm_condition());
		fence.setAreaCode(command.getArea_code());
		fence.setPolyValue(command.getPoly_value());
		fence.setCreateTime(DateUtil.currentTime());
		fence.setModifyTime(DateUtil.currentTime());
		CommonResult json = new CommonResult();
		try {
			fenceService.createFence(fence);
			json.put("fence_id", fence.getId());
		} catch (Exception e) {
			logger.info("添加围栏失败", e);
			json.put("status", 1);
			json.put("msg", e.getMessage());

		}
		return json;
	}
}
