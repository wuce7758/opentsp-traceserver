package com.mapbar.traceserver.handler;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mapbar.traceserver.command.result.CommonResult;
import com.mapbar.traceserver.entity.command.MonitorEntityListColumnCommand;
import com.mapbar.traceserver.model.ServiceStructure;
import com.mapbar.traceserver.service.ServiceStructureService;
import com.navinfo.opentspcore.common.handler.AbstractCommandHandler;

/**
 * 列出监控对象属性字段
 * 
 * @author xubh
 */
@Component
public class MonitorEntityListColumnHandler extends AbstractCommandHandler<MonitorEntityListColumnCommand, CommonResult> {

	protected static final Logger logger = LoggerFactory.getLogger(MonitorEntityListColumnHandler.class);

	@Resource
	private ServiceStructureService serviceStructureService;

	public MonitorEntityListColumnHandler() {
		super(MonitorEntityListColumnCommand.class, CommonResult.class);
	}

	protected MonitorEntityListColumnHandler(Class<MonitorEntityListColumnCommand> commandType, Class<CommonResult> resultType) {
		super(commandType, resultType);
	}

	@Override
	public CommonResult handle(MonitorEntityListColumnCommand command) {
		ServiceStructure serviceStructure = new ServiceStructure();
		serviceStructure.setServiceId(command.getService_id());
		CommonResult json = new CommonResult();
		try {
			List<ServiceStructure> listColumn = serviceStructureService.listColumn(serviceStructure);
			JSONArray jarray = new JSONArray();
			JSONObject jobj = null;
			for (ServiceStructure s : listColumn) {
				jobj = new JSONObject();
				jobj.put("column_key", s.getColumnKey());
				jobj.put("column_desc", s.getColumnDesc());
				jobj.put("create_time", s.getCreateTime());
				jobj.put("modify_time", s.getModifyTime());
				jobj.put("is_search", s.getIsSearch());
				jarray.add(jobj);
			}

			json.put("columns", jarray);
		} catch (Exception e) {
			logger.info("列出监控对象属性字段失败", e);
			json.put("status", 1);
			json.put("msg", e.getMessage());
		}
		return json;
	}
}
