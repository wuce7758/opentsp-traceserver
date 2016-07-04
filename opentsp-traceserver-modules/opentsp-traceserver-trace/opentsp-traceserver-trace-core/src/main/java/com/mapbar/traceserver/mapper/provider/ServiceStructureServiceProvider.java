package com.mapbar.traceserver.mapper.provider;

import org.apache.ibatis.jdbc.SqlBuilder;

import com.mapbar.traceserver.model.ServiceStructure;
import com.mapbar.traceserver.util.DateUtil;

public class ServiceStructureServiceProvider {

	private final static String TABLE_NAME = "service_structure";

	public String addEntityColumn(final ServiceStructure serviceStructure) {
		SqlBuilder.BEGIN();
		SqlBuilder.INSERT_INTO(TABLE_NAME);
		SqlBuilder.VALUES("service_id", "#{serviceId}");
		SqlBuilder.VALUES("column_key", "#{columnKey}");
		SqlBuilder.VALUES("column_desc", "#{columnDesc}");
		SqlBuilder.VALUES("column_type", "#{columnType}");
		SqlBuilder.VALUES("create_time", "#{createTime}");
		SqlBuilder.VALUES("modify_time", "#{modifyTime}");
		SqlBuilder.VALUES("is_search", "#{isSearch}");
		return SqlBuilder.SQL();
	}

	public String addDbColumn(final ServiceStructure serviceStructure) {
		// 字段类型暂写死
		String sql = "ALTER TABLE " + serviceStructure.getTableName() + " ADD COLUMN " + serviceStructure.getColumnKey() + " VARCHAR(64)";
		System.out.println(sql);
		return sql;
	}

	public String addColumnIndex(final ServiceStructure serviceStructure) {
		String sql = "ALTER TABLE " + serviceStructure.getTableName() + " ADD INDEX " + serviceStructure.getColumnKey() + DateUtil.currentNumMill() + "_index (" + (serviceStructure.getColumnKey()) + ")";
		System.out.println(sql);
		return sql;
	}

	public String deleteEntityColumn(final ServiceStructure serviceStructure) {
		SqlBuilder.BEGIN();
		SqlBuilder.DELETE_FROM(TABLE_NAME);
		SqlBuilder.WHERE("service_id = #{serviceId}");
		SqlBuilder.AND();
		SqlBuilder.WHERE("column_key = #{columnKey}");
		return SqlBuilder.SQL();
	}

	public String deleteDbColumn(final ServiceStructure serviceStructure) {
		String sql = "ALTER TABLE " + serviceStructure.getTableName() + " DROP COLUMN " + serviceStructure.getColumnKey();
		return sql;
	}

	public String listEntityColumn(final ServiceStructure serviceStructure) {
		SqlBuilder.BEGIN();
		// SqlBuilder.SELECT("*");
		SqlBuilder.SELECT("column_key,column_desc,create_time,modify_time,is_search");
		SqlBuilder.FROM(TABLE_NAME);
		SqlBuilder.WHERE("service_id = #{serviceId}");
		return SqlBuilder.SQL();
	}

	public String listEntityColumnMap(final ServiceStructure serviceStructure) {
		SqlBuilder.BEGIN();
		SqlBuilder.SELECT("service_id,column_key,column_desc,create_time,modify_time,is_search");
		SqlBuilder.FROM(TABLE_NAME);
		SqlBuilder.WHERE("service_id = #{serviceId}");
		return SqlBuilder.SQL();
	}

	public String updateEntityColumn(final ServiceStructure serviceStructure) {
		SqlBuilder.BEGIN();
		SqlBuilder.UPDATE(TABLE_NAME);
		SqlBuilder.SET("column_key = #{columnKeyNew}");
		SqlBuilder.SET("column_desc = #{columnDesc}");
		SqlBuilder.SET("modify_time= #{modifyTime}");
		SqlBuilder.SET("is_search = #{isSearch}");
		SqlBuilder.WHERE("service_id = #{serviceId}");
		SqlBuilder.AND();
		SqlBuilder.WHERE("column_key = #{columnKey}");
		return SqlBuilder.SQL();
	}

	public String updateDbColumn(final ServiceStructure serviceStructure) {
		String sql = "ALTER TABLE " + serviceStructure.getTableName() + " CHANGE COLUMN " + serviceStructure.getColumnKey() + " " + serviceStructure.getColumnKeyNew() + " VARCHAR(64)";
		return sql;
	}

	public String getServeceStructureBySId() {
		SqlBuilder.BEGIN();
		SqlBuilder.SELECT("column_key");
		SqlBuilder.SELECT("column_desc");
		SqlBuilder.FROM(TABLE_NAME);
		SqlBuilder.WHERE("service_id=#{serviceId}");
		return SqlBuilder.SQL();
	}

}
