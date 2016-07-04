package com.mapbar.traceserver.model;

import java.io.Serializable;

public class HistoryAlarm implements Serializable {

	private static final long serialVersionUID = -1472763116767679426L;
	private Integer id;
	private String ak;// 用户的ak授权使用
	private String serviceId;// 服务唯一标识
	private String fenceId;// 围栏id 地理围栏的唯一标识
	private String monitoredPerson;// 监控对象 被监控对象的entity_name
	private String alarmAction;// 1：进入围栏 2：离开围栏
	private String alarmTime;// 触发报警时间
	private String alarmPos;// 报警坐标

	private String startTime;
	private String endTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAk() {
		return ak;
	}

	public void setAk(String ak) {
		this.ak = ak;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getFenceId() {
		return fenceId;
	}

	public void setFenceId(String fenceId) {
		this.fenceId = fenceId;
	}

	public String getMonitoredPerson() {
		return monitoredPerson;
	}

	public void setMonitoredPerson(String monitoredPerson) {
		this.monitoredPerson = monitoredPerson;
	}

	public String getAlarmAction() {
		return alarmAction;
	}

	public void setAlarmAction(String alarmAction) {
		this.alarmAction = alarmAction;
	}

	public String getAlarmTime() {
		return alarmTime;
	}

	public void setAlarmTime(String alarmTime) {
		this.alarmTime = alarmTime;
	}

	public String getAlarmPos() {
		return alarmPos;
	}

	public void setAlarmPos(String alarmPos) {
		this.alarmPos = alarmPos;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

}
