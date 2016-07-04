package com.mapbar.traceserver.handler;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mapbar.traceserver.command.result.CommonResult;
import com.mapbar.traceserver.entity.command.MonitorEntityUpdateColumnCommand;
import com.mapbar.traceserver.model.ServiceStructure;
import com.mapbar.traceserver.service.ServiceStructureService;
import com.mapbar.traceserver.util.DateUtil;
import com.navinfo.opentspcore.common.handler.AbstractCommandHandler;

/**
 * 更新监控对象属性字段
 * 
 * @author xubh
 */
@Component
public class MonitorEntityUpdateColumnHandler extends AbstractCommandHandler<MonitorEntityUpdateColumnCommand, CommonResult> {

	protected static final Logger logger = LoggerFactory.getLogger(MonitorEntityUpdateColumnHandler.class);

	@Resource
	private ServiceStructureService serviceStructureService;

	public MonitorEntityUpdateColumnHandler() {
		super(MonitorEntityUpdateColumnCommand.class, CommonResult.class);
	}

	protected MonitorEntityUpdateColumnHandler(Class<MonitorEntityUpdateColumnCommand> commandType, Class<CommonResult> resultType) {
		super(commandType, resultType);
	}

	@Override
	public CommonResult handle(MonitorEntityUpdateColumnCommand command) {
		ServiceStructure serviceStructure = new ServiceStructure();
		serviceStructure.setServiceId(command.getService_id());
		serviceStructure.setColumnKey(command.getColumn_key());
		serviceStructure.setColumnKeyNew(command.getColumn_key_new());
		serviceStructure.setColumnDesc(command.getColumn_desc());
		serviceStructure.setColumnType(command.getColumn_type());
		serviceStructure.setModifyTime(DateUtil.currentTime());
		serviceStructure.setIsSearch(command.getIs_search());
		CommonResult json = new CommonResult();
		try {
			serviceStructureService.updateColumn(serviceStructure);
		} catch (Exception e) {
			logger.info("更新监控对象属性字段失败", e);
			json.put("status", 1);
			json.put("msg", e.getMessage());
		}
		return json;
	}
}
