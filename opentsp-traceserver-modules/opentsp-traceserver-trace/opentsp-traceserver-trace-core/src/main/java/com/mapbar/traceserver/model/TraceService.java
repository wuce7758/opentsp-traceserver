package com.mapbar.traceserver.model;

import java.io.Serializable;

public class TraceService implements Serializable {

	private static final long serialVersionUID = -9162433479664466394L;
	private String serviceId;// 服务唯一标识
	private String serviceName;// 服务名称
	private String createTime;// 创建时间
	private String serviceDesc;// 服务描述
	private String serviceTable;// 服务表名

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getServiceDesc() {
		return serviceDesc;
	}

	public void setServiceDesc(String serviceDesc) {
		this.serviceDesc = serviceDesc;
	}

	public String getServiceTable() {
		return serviceTable;
	}

	public void setServiceTable(String serviceTable) {
		this.serviceTable = serviceTable;
	}

}
