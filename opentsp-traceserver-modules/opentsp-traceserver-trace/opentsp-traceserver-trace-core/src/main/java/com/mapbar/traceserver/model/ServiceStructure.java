package com.mapbar.traceserver.model;

import java.io.Serializable;

/**
 * 监控对象表结构对象
 * 
 * @author xubh
 *
 */
public class ServiceStructure implements Serializable {

	private static final long serialVersionUID = 5457237082460400617L;

	private Integer id;
	private String serviceId;
	private String columnKey;
	private String columnKeyNew;
	private String columnDesc;
	private String columnType;
	private String createTime;
	private String modifyTime;
	private int isSearch;
	
	private String tableName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getColumnKey() {
		return columnKey;
	}

	public void setColumnKey(String columnKey) {
		this.columnKey = columnKey;
	}

	public String getColumnDesc() {
		return columnDesc;
	}

	public void setColumnDesc(String columnDesc) {
		this.columnDesc = columnDesc;
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

	public int getIsSearch() {
		return isSearch;
	}

	public void setIsSearch(int isSearch) {
		this.isSearch = isSearch;
	}

	public String getColumnKeyNew() {
		return columnKeyNew;
	}

	public void setColumnKeyNew(String columnKeyNew) {
		this.columnKeyNew = columnKeyNew;
	}

	public String getColumnType() {
		return columnType;
	}

	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

}
