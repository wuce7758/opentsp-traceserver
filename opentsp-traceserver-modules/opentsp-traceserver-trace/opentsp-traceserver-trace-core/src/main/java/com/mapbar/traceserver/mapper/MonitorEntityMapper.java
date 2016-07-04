package com.mapbar.traceserver.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.mapbar.traceserver.mapper.provider.MonitorEntityMapperProvider;
import com.mapbar.traceserver.model.MonitorEntity;

//@CacheNamespace(size = 100)
public interface MonitorEntityMapper {

	// @Insert(value = { "INSERT INTO monitor_entity (ak,${service_id},entity_name) VALUES(#{ak},#{service_id},#{entity_name})" })
	@InsertProvider(method = "addEntity", type = MonitorEntityMapperProvider.class)
	@Options(useGeneratedKeys = true, keyProperty = "id")
	void addEntity(MonitorEntity monitorEntity);

	@DeleteProvider(method = "deleteEntity", type = MonitorEntityMapperProvider.class)
	// @Options(useCache = true, flushCache = true, timeout = 10000)
	void deleteEntity(MonitorEntity monitorEntity);

	@SelectProvider(method = "listEntity", type = MonitorEntityMapperProvider.class)
	@ResultMap(value = "com.mapbar.traceserver.entity.mapper.MonitorEntityMapper.monitorEntity")
	List<MonitorEntity> listEntity(MonitorEntity monitorEntity);

	@SelectProvider(method = "listEntityMap", type = MonitorEntityMapperProvider.class)
	//@ResultType(value = java.util.Map.class)
	List<Map<String, Object>> listEntityMap(MonitorEntity monitorEntity);

	@Select(value = { "SELECT id FROM monitor_entity WHERE entity_name = #{entityName}" })
	MonitorEntity entityNameExist(MonitorEntity monitorEntity);

	@Select(value = { "SELECT * FROM student" })
	List<MonitorEntity> getEntity();
}
