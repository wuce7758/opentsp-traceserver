package com.mapbar.traceserver.model;

import java.io.Serializable;

/**
 * 电子围栏对象
 * 
 * @author xubh
 *
 */
public class Fence implements Serializable {

	private static final long serialVersionUID = -1424872076245891919L;
	private Integer id;
	private String ak;// 用户的ak授权使用
	private String serviceId;// 服务唯一标识
	private String name;// 围栏名称
	private String desc;// '围栏描述
	private String creator;// 围栏创建者 创建者的entity_name
	private String monitoredPersons;// 被监控者的entity_name，使用英文逗号”,”分割
	private String validTimes;// 围栏生效时间列表 一天中的几点几分到 几点几分生效。至少含有一段生效时间，多个时间段使用分号”;”分隔。比如：“0820,0930;1030,1130'
	private int validCycle;// 围栏生效周期 标识valid_times是否周期性生效，可以使用如下数值：标识valid_times是否周期性生效，可以使用如下数值：
	// 1：不重复 2：工作日循环 3：周末循环 4：每天循环 5：自定义 当为5时，需要定义valid_days，标识在周几生效。
	private String validDate;// 围栏生效日期 当valid_cycle为1时必选，例如：20160408
	private String validDays;// 围栏生效日期列表 1到7，分别表示周一到周日，当valid_cycle为5时必选
	private int shape;// 围栏的形状 围栏有三种形状：1代表圆形和2代表多边形3代表行政区标识中
	private int coordType;// 坐标类型
	private String center;// '围栏圆心经纬度
	private double radius;// 当shape=1时必选。单位：米，取值范围(0,5000]
	private int alarmCondition = 3;// 围栏报警条件 1：进入时触发提醒 2：离开时触发提醒 3：进入离开均触发提醒。默认值为3
	private String areaCode;// 行政区标识码
	private String polyValue;// 多边形坐标值

	private String createTime;//
	private String modifyTime;//
	
	private String fenceIds;// 查询的地理围栏ID列表，最多10个
	private String startTime;// 开始时间
	private String endTime;// 结束时间

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getMonitoredPersons() {
		return monitoredPersons;
	}

	public void setMonitoredPersons(String monitoredPersons) {
		this.monitoredPersons = monitoredPersons;
	}

	public String getValidTimes() {
		return validTimes;
	}

	public void setValidTimes(String validTimes) {
		this.validTimes = validTimes;
	}

	public int getValidCycle() {
		return validCycle;
	}

	public void setValidCycle(int validCycle) {
		this.validCycle = validCycle;
	}

	public String getValidDate() {
		return validDate;
	}

	public void setValidDate(String validDate) {
		this.validDate = validDate;
	}

	public String getValidDays() {
		return validDays;
	}

	public void setValidDays(String validDays) {
		this.validDays = validDays;
	}

	public int getShape() {
		return shape;
	}

	public void setShape(int shape) {
		this.shape = shape;
	}

	public int getCoordType() {
		return coordType;
	}

	public void setCoordType(int coordType) {
		this.coordType = coordType;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getCenter() {
		return center;
	}

	public void setCenter(String center) {
		this.center = center;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public int getAlarmCondition() {
		return alarmCondition;
	}

	public void setAlarmCondition(int alarmCondition) {
		this.alarmCondition = alarmCondition;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getPolyValue() {
		return polyValue;
	}

	public void setPolyValue(String polyValue) {
		this.polyValue = polyValue;
	}

	public String getFenceIds() {
		return fenceIds;
	}

	public void setFenceIds(String fenceIds) {
		this.fenceIds = fenceIds;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

}
