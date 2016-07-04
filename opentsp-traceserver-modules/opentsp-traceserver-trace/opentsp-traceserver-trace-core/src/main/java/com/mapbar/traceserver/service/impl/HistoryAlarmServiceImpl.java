package com.mapbar.traceserver.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mapbar.traceserver.mapper.HistoryAlarmMapper;
import com.mapbar.traceserver.model.HistoryAlarm;
import com.mapbar.traceserver.service.HistoryAlarmService;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class HistoryAlarmServiceImpl implements HistoryAlarmService	 {

	@Resource
	private HistoryAlarmMapper historyAlarmMapper;


	@Override
	public List<HistoryAlarm> queryHistoryAlarm(HistoryAlarm historyAlarm) {
		List<HistoryAlarm> list = historyAlarmMapper.queryHistoryAlarm(historyAlarm);
		return list;
	}
}
