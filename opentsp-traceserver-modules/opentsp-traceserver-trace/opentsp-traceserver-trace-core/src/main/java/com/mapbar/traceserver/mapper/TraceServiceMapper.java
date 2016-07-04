package com.mapbar.traceserver.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.mapbar.traceserver.model.TraceService;

public interface TraceServiceMapper {

	@Select(value = { "SELECT service_id,service_table FROM trace_service" })
	@MapKey(value = "service_id")
	List<Map<String, String>> getAll();

	@Select(value = { "SELECT service_id,service_table FROM trace_service" })
	@MapKey(value = "serviceId")
	@ResultMap(value = { "traceService" })
	@Options(useCache = true)
	// @Options(useCache = true, flushCache = true, timeout = 1000 * 60 * 60)
	Map<String, TraceService> getAllToMap();
}
