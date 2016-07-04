package com.mapbar.traceserver.handler;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mapbar.traceserver.command.result.CommonResult;
import com.mapbar.traceserver.entity.command.MonitorEntityListCommand;
import com.mapbar.traceserver.model.MonitorEntity;
import com.mapbar.traceserver.service.MonitorEntityService;
import com.navinfo.opentspcore.common.handler.AbstractCommandHandler;

/**
 * 查询监控对象的基本信息
 * 
 * @author xubh
 */
@Component
public class MonitorEntityListHandler extends AbstractCommandHandler<MonitorEntityListCommand, CommonResult> {

	protected static final Logger logger = LoggerFactory.getLogger(MonitorEntityListHandler.class);

	@Resource
	private MonitorEntityService monitorEntityService;

	public MonitorEntityListHandler() {
		super(MonitorEntityListCommand.class, CommonResult.class);
	}

	protected MonitorEntityListHandler(Class<MonitorEntityListCommand> commandType, Class<CommonResult> resultType) {
		super(commandType, resultType);
	}

	@Override
	public CommonResult handle(MonitorEntityListCommand command) {
		MonitorEntity monitorEntity = new MonitorEntity();
		monitorEntity.setAk(command.getAk());
		monitorEntity.setServiceId(command.getService_id());
		monitorEntity.setEntityName(command.getEntity_names());
		monitorEntity.setColumn(command.getColumn());
		monitorEntity.setActiveTime(command.getActive_time());
		monitorEntity.setPageIndex(command.getPage_index());
		monitorEntity.setPageSize(command.getPage_size());
		CommonResult json = new CommonResult();
		try {
			List<Map<String, Object>> listEntityMap = monitorEntityService.getEntityMap(monitorEntity);
			JSONArray jarray = new JSONArray();
			JSONObject jobj = null;
			for (int i = 0; i < listEntityMap.size() - 1; i++) {
				jobj = new JSONObject();
				for (Map.Entry<String, Object> entry : listEntityMap.get(i).entrySet()) {
					if (StringUtils.isNotEmpty(entry.getKey())) {
						if (entry.getKey().equals("id") || entry.getKey().equals("ak") || entry.getKey().equals("service_id")) {
							continue;
						}else{
							jobj.put(entry.getKey(), entry.getValue());
						}
					}
				}
				jarray.add(jobj);
			}
			Map<String, Object> page_info = listEntityMap.get(listEntityMap.size() - 1);
			json.put("size", page_info.get("size"));
			json.put("total", page_info.get("total"));
			json.put("entities", jarray);
			return json;
		} catch (Exception e) {
			logger.info("查询监控对象的基本信息失败", e);
			json.put("status", 1);
			json.put("msg", e.getMessage());
		}
		return json;
	}
}
