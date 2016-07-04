package com.mapbar.traceserver.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.mapbar.traceserver.mapper.provider.ServiceStructureServiceProvider;
import com.mapbar.traceserver.model.ServiceStructure;

public interface ServiceStructureMapper {

	@InsertProvider(method = "addEntityColumn", type = ServiceStructureServiceProvider.class)
	void addEntityColumn(ServiceStructure serviceStructure);

	@UpdateProvider(method = "addDbColumn", type = ServiceStructureServiceProvider.class)
	void addDbColumn(ServiceStructure serviceStructure);

	@UpdateProvider(method = "addColumnIndex", type = ServiceStructureServiceProvider.class)
	void addColumnIndex(ServiceStructure serviceStructure);

	@DeleteProvider(method = "deleteEntityColumn", type = ServiceStructureServiceProvider.class)
	void deleteEntityColumn(ServiceStructure serviceStructure);

	@UpdateProvider(method = "deleteDbColumn", type = ServiceStructureServiceProvider.class)
	void deleteDbColumn(ServiceStructure serviceStructure);

	@SelectProvider(method = "listEntityColumn", type = ServiceStructureServiceProvider.class)
	@ResultMap(value = "com.mapbar.traceserver.entity.mapper.ServiceStructureMapper.serviceStructure")
	// 这里调用resultMap，这个是SQL配置文件中的,必须该SQL配置文件与本接口有相同的全限定名
	// 注意文件中的namespace路径必须是使用@resultMap的类路径
	List<ServiceStructure> listEntityColumn(ServiceStructure serviceStructure);

	@SelectProvider(method = "listEntityColumnMap", type = ServiceStructureServiceProvider.class)
	@ResultType(value = java.util.Map.class)
	List<Map<String, Object>> listEntityColumnMap(ServiceStructure serviceStructure);

	@UpdateProvider(method = "updateEntityColumn", type = ServiceStructureServiceProvider.class)
	void updateEntityColumn(ServiceStructure serviceStructure);

	@UpdateProvider(method = "updateDbColumn", type = ServiceStructureServiceProvider.class)
	void updateDbColumn(ServiceStructure serviceStructure);

	@SelectProvider(method = "getServeceStructureBySId", type = ServiceStructureServiceProvider.class)
	@ResultMap(value = { "com.mapbar.traceserver.entity.mapper.ServiceStructureMapper.serviceStructure" })
	List<ServiceStructure> getServiceStructureBySId(String serviceId);

	@Select(value = { "SELECT id FROM service_structure WHERE service_id = #{serviceId} AND	column_key = #{columnKey}" })
	ServiceStructure columnKeyExist(ServiceStructure serviceStructure);

}
