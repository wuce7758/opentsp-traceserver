package com.mapbar.traceserver.fence.handler;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mapbar.traceserver.command.result.CommonResult;
import com.mapbar.traceserver.fence.command.FenceHistoryAlarmCommand;
import com.mapbar.traceserver.model.HistoryAlarm;
import com.mapbar.traceserver.service.HistoryAlarmService;
import com.navinfo.opentspcore.common.handler.AbstractCommandHandler;

/**
 * 查询围栏内监控对象历史报警信息
 * 
 * @author xubh
 */
@Component
public class FenceHistoryAlarmHandler extends AbstractCommandHandler<FenceHistoryAlarmCommand, CommonResult> {

	protected static final Logger logger = LoggerFactory.getLogger(FenceHistoryAlarmHandler.class);

	@Resource
	private HistoryAlarmService historyAlarmService;

	public FenceHistoryAlarmHandler() {
		super(FenceHistoryAlarmCommand.class, CommonResult.class);
	}

	protected FenceHistoryAlarmHandler(Class<FenceHistoryAlarmCommand> commandType, Class<CommonResult> resultType) {
		super(commandType, resultType);
	}

	@Override
	public CommonResult handle(FenceHistoryAlarmCommand command) {
		HistoryAlarm alarm = new HistoryAlarm();
		alarm.setId(command.getFence_id());
		alarm.setAk(command.getAk());
		alarm.setServiceId(command.getService_id());
		alarm.setMonitoredPerson(command.getMonitored_persons());
		alarm.setStartTime(command.getStart_time());
		alarm.setEndTime(command.getEnd_time());
		CommonResult json = new CommonResult();
		try {
			List<HistoryAlarm> list = historyAlarmService.queryHistoryAlarm(alarm);
			JSONArray jarray = new JSONArray();
			JSONObject jobj = null;
			for (HistoryAlarm historyAlarm : list) {
				jobj = new JSONObject();
				jobj.put("monitored_person", historyAlarm.getMonitoredPerson());
				jobj.put("action", historyAlarm.getAlarmAction());
				jobj.put("time", historyAlarm.getAlarmTime());
				jarray.add(jobj);
			}
			jarray = subArray(jarray);
			JSONArray monitored_person_alarms = new JSONArray();
			JSONArray j = null;
			JSONArray alarms = null;
			JSONObject al = null;
			for (int i = 0; i < jarray.size(); i++) {
				j = jarray.getJSONArray(i);
				alarms = new JSONArray();
				for (int k = 0; k < j.size(); k++) {
					JSONObject obj = j.getJSONObject(k);
					al = new JSONObject();
					al.put("action", obj.getString("action"));
					al.put("time", obj.getString("time"));
					alarms.add(al);
				}
				jobj = new JSONObject();
				jobj.put("alarm_size", j.size());
				jobj.put("monitored_person", j.getJSONObject(i).getString("monitored_person"));
				jobj.put("alarms", alarms);
				monitored_person_alarms.add(jobj);
			}
			json.put("size", jarray.size());
			json.put("monitored_person_alarms", monitored_person_alarms);
		} catch (Exception e) {
			logger.info("查询围栏内监控对象历史报警信息失败", e);
			json.put("status", 1);
			json.put("msg", e.getMessage());

		}
		return json;
	}

	/**
	 * 解析array根据组号分若干分小组
	 * 
	 * @param array
	 * @return
	 */
	public JSONArray subArray(JSONArray array) {
		JSONArray subArray = new JSONArray();
		JSONObject obj = null;
		JSONObject obj2 = null;
		JSONArray aArray = new JSONArray();
		for (int i = 0, size = array.size(); i < size; i++) {
			obj = array.getJSONObject(i);
			if (i + 1 < size) {
				if (i - 1 < 0) {
					subArray = new JSONArray();
					subArray.add(obj);
				} else {
					obj2 = array.getJSONObject(i - 1);
					if (obj.getString("monitored_person").equals(obj2.getString("monitored_person"))) {
						subArray.add(obj);
					} else {
						aArray.add(subArray);
						subArray = new JSONArray();
						subArray.add(obj);
					}
				}
			} else {
				if (size + 1 > 0) {
					obj2 = array.getJSONObject(i - 1);
					if (obj.getString("monitored_person").equals(obj2.getString("monitored_person"))) {
						subArray.add(obj);
						if (size - 1 == i) {
							aArray.add(subArray);
						}
					} else {
						aArray.add(subArray);
						subArray = new JSONArray();
						subArray.add(obj);
						if (i + 1 == size) {
							aArray.add(subArray);
						}
					}
				} else {
					subArray.add(obj);
					aArray.add(subArray);
				}
			}
		}
		return aArray;
	}
}
