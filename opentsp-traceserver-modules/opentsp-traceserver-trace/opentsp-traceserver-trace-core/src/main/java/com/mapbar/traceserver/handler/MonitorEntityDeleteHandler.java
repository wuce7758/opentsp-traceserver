package com.mapbar.traceserver.handler;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mapbar.traceserver.command.result.CommonResult;
import com.mapbar.traceserver.entity.command.MonitorEntityDeleteCommand;
import com.mapbar.traceserver.model.MonitorEntity;
import com.mapbar.traceserver.service.MonitorEntityService;
import com.navinfo.opentspcore.common.handler.AbstractCommandHandler;

/**
 * 删除监控对象
 * 
 * @author xubh
 */
@Component
public class MonitorEntityDeleteHandler extends AbstractCommandHandler<MonitorEntityDeleteCommand, CommonResult> {

	private static final Logger logger = LoggerFactory.getLogger(MonitorEntityDeleteHandler.class);

	@Resource
	private MonitorEntityService monitorEntityService;

	public MonitorEntityDeleteHandler() {
		super(MonitorEntityDeleteCommand.class, CommonResult.class);
	}

	protected MonitorEntityDeleteHandler(Class<MonitorEntityDeleteCommand> commandType, Class<CommonResult> resultType) {
		super(commandType, resultType);
	}

	@Override
	public CommonResult handle(MonitorEntityDeleteCommand command) {
		MonitorEntity monitorEntity = new MonitorEntity();
		monitorEntity.setAk(command.getAk());
		monitorEntity.setServiceId(command.getService_id());
		monitorEntity.setEntityName(command.getEntity_name());
		CommonResult json = new CommonResult();
		try {
			monitorEntityService.deleteEntity(monitorEntity);
		} catch (Exception e) {
			logger.info("删除监控对象失败", e);
			json.put("status", 1);
			json.put("msg", e.getMessage());
		}
		return json;
	}
}
