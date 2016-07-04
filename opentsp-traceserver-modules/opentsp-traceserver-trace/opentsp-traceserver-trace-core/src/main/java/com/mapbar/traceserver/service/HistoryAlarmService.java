package com.mapbar.traceserver.service;

import java.util.List;

import com.mapbar.traceserver.model.HistoryAlarm;

public interface HistoryAlarmService {

	List<HistoryAlarm> queryHistoryAlarm(HistoryAlarm historyAlarm);

}
