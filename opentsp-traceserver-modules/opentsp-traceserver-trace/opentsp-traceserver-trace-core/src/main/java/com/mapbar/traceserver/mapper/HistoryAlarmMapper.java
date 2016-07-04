package com.mapbar.traceserver.mapper;

import java.util.List;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.SelectProvider;

import com.mapbar.traceserver.mapper.provider.HistoryAlarmMapperProvider;
import com.mapbar.traceserver.model.HistoryAlarm;

public interface HistoryAlarmMapper {

	@SelectProvider(method = "queryHistoryAlarm", type = HistoryAlarmMapperProvider.class)
	@ResultMap(value = "historyAlarm")
	List<HistoryAlarm> queryHistoryAlarm(HistoryAlarm historyAlarm);
}
