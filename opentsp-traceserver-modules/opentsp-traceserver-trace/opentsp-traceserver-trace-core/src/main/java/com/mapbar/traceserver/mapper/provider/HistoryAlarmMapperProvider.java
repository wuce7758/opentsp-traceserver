package com.mapbar.traceserver.mapper.provider;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SqlBuilder;

import com.mapbar.traceserver.model.HistoryAlarm;

public class HistoryAlarmMapperProvider {

	private final static String TABLE_NAME = "alarm_history";

	public String queryHistoryAlarm(final HistoryAlarm historyAlarm) {
		SqlBuilder.BEGIN();
		// SqlBuilder.SELECT("*");
		SqlBuilder.SELECT("monitored_person, alarm_action, alarm_time, alarm_pos");
		SqlBuilder.FROM(TABLE_NAME);
		SqlBuilder.WHERE("service_id = #{serviceId}");
		SqlBuilder.AND();
		SqlBuilder.WHERE("fence_id = #{id}");
		String monitoredPerson = historyAlarm.getMonitoredPerson();
		String str = "";
		if (StringUtils.isNotEmpty(monitoredPerson)) {
			String[] split = monitoredPerson.split(",");
			for (int i = 0; i < split.length; i++) {
				if (i > 0) {
					str += ",";
				}
				str += split[i];
			}
			str += ")";
			SqlBuilder.AND();
			SqlBuilder.WHERE("monitored_person in (" + str);
		}
		if (StringUtils.isNotEmpty(historyAlarm.getStartTime())) {
			SqlBuilder.AND();
			SqlBuilder.WHERE("alarm_time >= #{alarmTime}");
		}
		if (StringUtils.isNotEmpty(historyAlarm.getEndTime())) {
			SqlBuilder.AND();
			SqlBuilder.WHERE("alarm_time <= #{alarmTime}");
		}
		return SqlBuilder.SQL();
	}
}
