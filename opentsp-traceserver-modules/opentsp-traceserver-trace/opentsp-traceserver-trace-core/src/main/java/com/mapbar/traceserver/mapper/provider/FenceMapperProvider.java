package com.mapbar.traceserver.mapper.provider;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SqlBuilder;

import com.mapbar.traceserver.model.Fence;

public class FenceMapperProvider {

	private final static String TABLE_NAME = "fence_info";

	public String createFence(final Fence fence) {
		SqlBuilder.BEGIN();
		SqlBuilder.INSERT_INTO(TABLE_NAME);
		SqlBuilder.VALUES("ak", "#{ak}");
		SqlBuilder.VALUES("service_id", "#{serviceId}");
		SqlBuilder.VALUES("fence_name", "#{name}");
		SqlBuilder.VALUES("fence_desc", "#{desc}");
		SqlBuilder.VALUES("creator", "#{creator}");
		SqlBuilder.VALUES("monitored_persons", "#{monitoredPersons}");
		SqlBuilder.VALUES("valid_times", "#{validTimes}");
		SqlBuilder.VALUES("valid_cycle", "#{validCycle}");
		SqlBuilder.VALUES("valid_date", "#{validDate}");
		SqlBuilder.VALUES("valid_days", "#{validDays}");
		SqlBuilder.VALUES("shape", "#{shape}");
		SqlBuilder.VALUES("coord_type", "#{coordType}");
		SqlBuilder.VALUES("center", "#{center}");
		SqlBuilder.VALUES("radius", "#{radius}");
		SqlBuilder.VALUES("alarm_condition", "#{alarmCondition}");
		SqlBuilder.VALUES("area_code", "#{areaCode}");
		SqlBuilder.VALUES("poly_value", "#{polyValue}");
		SqlBuilder.VALUES("create_time", "#{createTime}");
		SqlBuilder.VALUES("modify_time", "#{modifyTime}");
		return SqlBuilder.SQL();
	}

	public String deleteFence(final Fence fence) {
		SqlBuilder.BEGIN();
		SqlBuilder.DELETE_FROM(TABLE_NAME);
		SqlBuilder.WHERE("ak=#{ak}");
		SqlBuilder.AND();
		SqlBuilder.WHERE("service_id=#{serviceId}");
		SqlBuilder.AND();
		SqlBuilder.WHERE("id = #{id}");
		return SqlBuilder.SQL();
	}

	public String updateFence(final Fence fence) {
		SqlBuilder.BEGIN();
		SqlBuilder.UPDATE(TABLE_NAME);
		SqlBuilder.SET("ak = #{ak}");
		SqlBuilder.SET("service_id = #{serviceId}");
		SqlBuilder.SET("fence_name = #{name}");
		SqlBuilder.SET("fence_desc = #{desc}");
		SqlBuilder.SET("creator = #{creator}");
		SqlBuilder.SET("monitored_persons = #{monitoredPersons}");
		SqlBuilder.SET("valid_times = #{validTimes}");
		SqlBuilder.SET("valid_cycle = #{validCycle}");
		SqlBuilder.SET("valid_date = #{validDate}");
		SqlBuilder.SET("valid_days = #{validDays}");
		SqlBuilder.SET("shape = #{shape}");
		SqlBuilder.SET("coord_type = #{coordType}");
		SqlBuilder.SET("center = #{center}");
		SqlBuilder.SET("radius = #{radius}");
		SqlBuilder.SET("alarm_condition = #{alarmCondition}");
		SqlBuilder.SET("area_code = #{areaCode}");
		SqlBuilder.SET("poly_value = #{polyValue}");
		SqlBuilder.SET("create_time = #{createTime}");
		SqlBuilder.SET("modify_time = #{modifyTime}");
		SqlBuilder.WHERE("id = #{id}");
		SqlBuilder.AND();
		SqlBuilder.WHERE("service_id = #{serviceId}");
		return SqlBuilder.SQL();
	}

	public String listFence(final Fence fence) {
		SqlBuilder.BEGIN();
		// SqlBuilder.SELECT("*");
		SqlBuilder.SELECT("id as fence_id, ak, service_id, fence_name, fence_desc, creator, monitored_persons, valid_times, valid_cycle, valid_date, valid_days, shape, coord_type, center, radius, alarm_condition, area_code, poly_value,create_time,modify_time");
		SqlBuilder.FROM(TABLE_NAME);
		SqlBuilder.WHERE("service_id = #{serviceId}");
		String creator = fence.getCreator();
		if (StringUtils.isNotEmpty(creator)) {
			SqlBuilder.AND();
			SqlBuilder.WHERE("creator = #{creator}");
		}
		String fenceIds = fence.getFenceIds();
		String str = "";
		if (StringUtils.isNotEmpty(fenceIds)) {
			String[] split = fenceIds.split(",");
			for (int i = 0; i < split.length; i++) {
				if (i > 0) {
					str += ",";
				}
				str += split[i];
			}
			str += ")";
			SqlBuilder.AND();
			SqlBuilder.WHERE("id in (" + str);
		}
		return SqlBuilder.SQL();
	}

}
