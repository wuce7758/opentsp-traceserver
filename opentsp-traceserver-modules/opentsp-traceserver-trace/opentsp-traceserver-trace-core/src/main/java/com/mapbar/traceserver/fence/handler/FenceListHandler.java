package com.mapbar.traceserver.fence.handler;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mapbar.traceserver.command.result.CommonResult;
import com.mapbar.traceserver.fence.command.FenceListCommand;
import com.mapbar.traceserver.model.Fence;
import com.mapbar.traceserver.service.FenceService;
import com.navinfo.opentspcore.common.handler.AbstractCommandHandler;

/**
 * 查询围栏
 * 
 * @author xubh
 */
@Component
public class FenceListHandler extends AbstractCommandHandler<FenceListCommand, CommonResult> {

	protected static final Logger logger = LoggerFactory.getLogger(FenceListHandler.class);

	@Resource
	private FenceService fenceService;

	public FenceListHandler() {
		super(FenceListCommand.class, CommonResult.class);
	}

	protected FenceListHandler(Class<FenceListCommand> commandType, Class<CommonResult> resultType) {
		super(commandType, resultType);
	}

	@Override
	public CommonResult handle(FenceListCommand command) {
		Fence fence = new Fence();
		fence.setAk(command.getAk());
		fence.setServiceId(command.getService_id());
		fence.setCreator(command.getCreator());
		fence.setFenceIds(command.getFence_ids());
		CommonResult json = new CommonResult();
		try {
			JSONArray jarray = new JSONArray();
			JSONObject jobj = null;
			List<Fence> listFence = fenceService.listFence(fence);
			for (Fence f : listFence) {
				jobj = new JSONObject();
				jobj.put("fence_id", f.getId());
				jobj.put("name", f.getName());
				jobj.put("desc", f.getDesc());
				jobj.put("creator", f.getCreator());
				jobj.put("monitored_persons", f.getMonitoredPersons());
				jobj.put("valid_times", f.getValidTimes());
				jobj.put("valid_cycle", f.getValidCycle());
				jobj.put("valid_days", f.getValidDays());
				jobj.put("shape", f.getShape());
				jobj.put("center", f.getCenter());
				jobj.put("coord_type", f.getCoordType());
				jobj.put("radius", f.getRadius());
				jobj.put("alarm_condition", f.getAlarmCondition());
				jobj.put("create_time", f.getCreateTime());
				jobj.put("modify_time", f.getModifyTime());
				jobj.put("area_code", f.getAreaCode());
				jobj.put("poly_value", f.getPolyValue());
				jarray.add(jobj);
			}
			json.put("fences", jarray);
		} catch (Exception e) {
			logger.info("查询围栏失败", e);
			json.put("status", 1);
			json.put("msg", e.getMessage());
		}
		return json;
	}
}
