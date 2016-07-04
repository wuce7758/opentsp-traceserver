package com.mapbar.traceserver.handler;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mapbar.traceserver.command.result.CommonResult;
import com.mapbar.traceserver.entity.command.MonitorEntityDeleteColumnCommand;
import com.mapbar.traceserver.model.ServiceStructure;
import com.mapbar.traceserver.service.ServiceStructureService;
import com.navinfo.opentspcore.common.handler.AbstractCommandHandler;

/**
 * 删除监控对象属性字段
 * 
 * @author xubh
 */
@Component
public class MonitorEntityDeleteColumnHandler extends AbstractCommandHandler<MonitorEntityDeleteColumnCommand, CommonResult> {

	private static final Logger logger = LoggerFactory.getLogger(MonitorEntityDeleteColumnHandler.class);

	@Resource
	private ServiceStructureService serviceStructureService;

	public MonitorEntityDeleteColumnHandler() {
		super(MonitorEntityDeleteColumnCommand.class, CommonResult.class);
	}

	protected MonitorEntityDeleteColumnHandler(Class<MonitorEntityDeleteColumnCommand> commandType, Class<CommonResult> resultType) {
		super(commandType, resultType);
	}

	@Override
	public CommonResult handle(MonitorEntityDeleteColumnCommand command) {
		ServiceStructure serviceStructure = new ServiceStructure();
		serviceStructure.setServiceId(command.getService_id());
		serviceStructure.setColumnKey(command.getColumn_key());
		CommonResult json = new CommonResult();
		try {
			serviceStructureService.deleteColumn(serviceStructure);
		} catch (Exception e) {
			logger.info("删除监控对象属性字段失败", e);
			json.put("status", 1);
			json.put("msg", e.getMessage());
		}
		return json;
	}
}
