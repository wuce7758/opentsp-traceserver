package com.mapbar.traceserver.model;

import java.io.Serializable;

/**
 * 监控对象
 * 
 * @author xubh
 */
public class MonitorEntity implements Serializable {

	private static final long serialVersionUID = 1469480490736154102L;
	private Integer id;
	private String ak;// 用户授权
	private String serviceId;// 服务唯一标识
	private String entityName;// 同一服务下监控对象名称不允许重复
	private String createTime;// 创建时间
	private String modifyTime;// 修改时间
	private String column;// 自定义字段
	private String activeTime;// 指定该字段时,返回从该时间点之后仍有位置变动的监控对象
	private int pageIndex = 1;// 默认值为1。page_index与page_size一起计算从第几条结果返回，代表返回第几页
	private int pageSize = 100;// 默认值为100。page_size与page_index一起计算从第几条结果返回，代表返回结果中每页有几条记录
	private String tableName;// 表名

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

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public String getActiveTime() {
		return activeTime;
	}

	public void setActiveTime(String activeTime) {
		this.activeTime = activeTime;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
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

}
