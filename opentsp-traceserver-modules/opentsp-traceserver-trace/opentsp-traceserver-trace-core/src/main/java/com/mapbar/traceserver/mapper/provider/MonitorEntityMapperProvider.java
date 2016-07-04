package com.mapbar.traceserver.mapper.provider;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SqlBuilder;

import com.mapbar.traceserver.model.MonitorEntity;
import com.mapbar.traceserver.util.JsonTools;

public class MonitorEntityMapperProvider {

	public String addEntity(final MonitorEntity monitorEntity) {
		SqlBuilder.BEGIN();
		SqlBuilder.INSERT_INTO(monitorEntity.getTableName());
		SqlBuilder.VALUES("ak", "#{ak}");
		SqlBuilder.VALUES("service_id", "#{serviceId}");
		SqlBuilder.VALUES("entity_name", "#{entityName}");
		SqlBuilder.VALUES("create_time", "#{createTime}");
		SqlBuilder.VALUES("modify_time", "#{mofifyTime}");
		String column = monitorEntity.getColumn();
		Map<String, Object> map = JsonTools.parseJSON2Map(column);
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			SqlBuilder.VALUES(entry.getKey(), "'" + entry.getValue().toString() + "'");
		}
		return SqlBuilder.SQL();
	}

	public String deleteEntity(final MonitorEntity monitorEntity) {
		SqlBuilder.BEGIN();
		SqlBuilder.DELETE_FROM(monitorEntity.getTableName());
		SqlBuilder.WHERE("ak=#{ak}");
		SqlBuilder.AND();
		SqlBuilder.WHERE("service_id=#{serviceId}");
		SqlBuilder.AND();
		SqlBuilder.WHERE("entity_name=#{entityName}");
		return SqlBuilder.SQL();
	}

	public String listEntity(final MonitorEntity monitorEntity) {
		SqlBuilder.BEGIN();
		// SqlBuilder.SELECT("service_id,entity_name");
		SqlBuilder.SELECT("*");
		SqlBuilder.FROM(monitorEntity.getTableName());
		SqlBuilder.WHERE("service_id = #{serviceId}");
		String names = monitorEntity.getEntityName();
		String str = "";
		if (StringUtils.isNotEmpty(names)) {
			String[] split = names.split(",");
			for (int i = 0; i < split.length; i++) {
				if (i > 0) {
					str += ",";
				}
				str += "'" + split[i] + "'";
			}
			str += ")";
			SqlBuilder.AND();
			SqlBuilder.WHERE("entity_name in (" + str);
		}
		String column = monitorEntity.getColumn();
		if (StringUtils.isNotEmpty(column)) {
			Map<String, Object> map = JsonTools.parseJSON2Map(column);
			for (Map.Entry<String, Object> entry : map.entrySet()) {
				SqlBuilder.AND();
				SqlBuilder.WHERE(entry.getKey() + "='" + entry.getValue().toString() + "'");
			}
		}
		return SqlBuilder.SQL();
	}

	public String listEntityMap(final MonitorEntity monitorEntity) {
		SqlBuilder.BEGIN();
		// SqlBuilder.SELECT("service_id,entity_name");
		SqlBuilder.SELECT("*");
		SqlBuilder.FROM(monitorEntity.getTableName());
		SqlBuilder.WHERE("service_id = #{serviceId}");
		String names = monitorEntity.getEntityName();
		String str = "";
		if (StringUtils.isNotEmpty(names)) {
			String[] split = names.split(",");
			for (int i = 0; i < split.length; i++) {
				if (i > 0) {
					str += ",";
				}
				str += "'" + split[i] + "'";
			}
			str += ")";
			SqlBuilder.AND();
			SqlBuilder.WHERE("entity_name in (" + str);
		}
		String column = monitorEntity.getColumn();
		if (StringUtils.isNotEmpty(column)) {
			Map<String, Object> map = JsonTools.parseJSON2Map(column);
			for (Map.Entry<String, Object> entry : map.entrySet()) {
				SqlBuilder.AND();
				SqlBuilder.WHERE(entry.getKey() + "='" + entry.getValue().toString() + "'");
			}
		}
		return SqlBuilder.SQL();
	}
}
