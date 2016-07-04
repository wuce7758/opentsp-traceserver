package com.mapbar.traceserver.fence.command;

import javax.validation.constraints.NotNull;

import com.mapbar.traceserver.annotation.Trace;
import com.mapbar.traceserver.command.result.CommonResult;
import com.navinfo.opentsp.common.messaging.AbstractSecuredCommand;

/**
 * 新增电子围栏命令对象
 * 
 * @author xubh
 */
@Trace
public class FenceCreateCommand extends AbstractSecuredCommand<CommonResult> {

	@NotNull
	private String ak;// 用户授权标识
	@NotNull
	private String service_id;// 服务的唯一标识
	@NotNull
	private String name;// 围栏名称
	private String desc;// 围栏描述
	@NotNull
	private String creator;// 围栏创建者 创建者的entity_name
	@NotNull
	private String monitored_persons;// 被监控者的entity_name，使用英文逗号”,”分割
	private String valid_times;// 围栏生效时间列表 一天中的几点几分到 几点几分生效。至少含有一段生效时间，多个时间段使用分号”;”分隔。比如：“0820,0930;1030,1130
	@NotNull
	private int valid_cycle;// 标识valid_times是否周期性生效，可以使用如下数值：
	// 1：不重复 2：工作日循环 3：周末循环 4：每天循环 5：自定义 当为5时，需要定义valid_days，标识在周几生效
	private String valid_date;// 围栏生效日期 当valid_cycle为1时必选，例如：20150908
	private String valid_days;// 围栏生效日期列表 1到7，分别表示周一到周日，当valid_cycle为5时必选
	@NotNull
	private int shape;// 1代表圆形和2代表多边形.3代表行政区标识
	@NotNull
	private int coord_type;// 坐标类型 1：84坐标 2：02坐标
	private String center;// 围栏圆心经纬度 shape为1时必选。格式为：经度,纬度。示例：116.4321,38.76623
	private double radius;// 围栏半径 当shape=1时必选。单位：米，取值范围(0,5000]
	private int alarm_condition = 3;// 围栏报警条件 1：进入时触发提醒 2：离开时触发提醒 3：进入离开均触发提醒。默认值为3
	private String area_code;// 围栏形状为行政区时必填
	private String poly_value;// 围栏形状为多边形时必填

	public String getAk() {
		return ak;
	}

	public void setAk(String ak) {
		this.ak = ak;
	}

	public String getService_id() {
		return service_id;
	}

	public void setService_id(String service_id) {
		this.service_id = service_id;
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

	public String getMonitored_persons() {
		return monitored_persons;
	}

	public void setMonitored_persons(String monitored_persons) {
		this.monitored_persons = monitored_persons;
	}

	public String getValid_times() {
		return valid_times;
	}

	public void setValid_times(String valid_times) {
		this.valid_times = valid_times;
	}

	public int getValid_cycle() {
		return valid_cycle;
	}

	public void setValid_cycle(int valid_cycle) {
		this.valid_cycle = valid_cycle;
	}

	public String getValid_date() {
		return valid_date;
	}

	public void setValid_date(String valid_date) {
		this.valid_date = valid_date;
	}

	public String getValid_days() {
		return valid_days;
	}

	public void setValid_days(String valid_days) {
		this.valid_days = valid_days;
	}

	public int getShape() {
		return shape;
	}

	public void setShape(int shape) {
		this.shape = shape;
	}

	public int getCoord_type() {
		return coord_type;
	}

	public void setCoord_type(int coord_type) {
		this.coord_type = coord_type;
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

	public int getAlarm_condition() {
		return alarm_condition;
	}

	public void setAlarm_condition(int alarm_condition) {
		this.alarm_condition = alarm_condition;
	}

	public String getArea_code() {
		return area_code;
	}

	public void setArea_code(String area_code) {
		this.area_code = area_code;
	}

	public String getPoly_value() {
		return poly_value;
	}

	public void setPoly_value(String poly_value) {
		this.poly_value = poly_value;
	}

	@Override
	public Class<? extends CommonResult> getResultType() {
		return CommonResult.class;
	}
}
