package com.mapbar.traceserver.handler;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.mapbar.traceserver.command.result.CommonResult;
import com.mapbar.traceserver.entity.command.MonitorEntityAddCommand;
import com.mapbar.traceserver.model.MonitorEntity;
import com.mapbar.traceserver.service.MonitorEntityService;
import com.mapbar.traceserver.util.DateUtil;
import com.navinfo.opentspcore.common.handler.AbstractCommandHandler;

/**
 * 创建监控对象
 * 
 * @author xubh
 */
@Component
public class MonitorEntityAddHandler extends AbstractCommandHandler<MonitorEntityAddCommand, CommonResult> {

	protected static final Logger logger = LoggerFactory.getLogger(MonitorEntityAddHandler.class);

	@Resource
	private MonitorEntityService monitorEntityService;

	public MonitorEntityAddHandler() {
		super(MonitorEntityAddCommand.class, CommonResult.class);
	}

	protected MonitorEntityAddHandler(Class<MonitorEntityAddCommand> commandType, Class<CommonResult> resultType) {
		super(commandType, resultType);
	}

	@Override
	public CommonResult handle(MonitorEntityAddCommand command) {
		MonitorEntity monitorEntity = new MonitorEntity();
		monitorEntity.setAk(command.getAk());
		monitorEntity.setServiceId(command.getService_id());
		monitorEntity.setEntityName(command.getEntity_name());
		monitorEntity.setCreateTime(DateUtil.currentTime());
		monitorEntity.setModifyTime(DateUtil.currentTime());
		String column = command.getColumn();
		monitorEntity.setColumn(column);
		CommonResult json = new CommonResult();
		if (StringUtils.isNotEmpty(column)) {
			try {
				JSONObject.parseObject(column);
			} catch (Exception e) {
				logger.info("添加监控对象失败", e);
				json.put("status", 1);
				json.put("msg", "自定义列格式错误");
				return json;
			}
		}
		try {
			monitorEntityService.addEntity(monitorEntity);
		} catch (Exception e) {
			logger.info("添加监控对象失败", e);
			json.put("status", 1);
			json.put("msg", e.getMessage());
		}
		return json;
	}
}
