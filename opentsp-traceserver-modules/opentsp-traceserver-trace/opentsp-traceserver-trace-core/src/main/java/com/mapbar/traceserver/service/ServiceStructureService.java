package com.mapbar.traceserver.service;

import java.util.List;
import java.util.Map;

import com.mapbar.traceserver.model.ServiceStructure;

/**
 * 服务表结构业务层
 * 
 * @author xubh
 *
 */
public interface ServiceStructureService {

	ServiceStructure addColumn(ServiceStructure serviceStructure);

	ServiceStructure deleteColumn(ServiceStructure serviceStructure);

	List<ServiceStructure> listColumn(ServiceStructure serviceStructure);

	List<Map<String, Object>> listColumnMap(ServiceStructure serviceStructure);

	ServiceStructure updateColumn(ServiceStructure serviceStructure);

	List<ServiceStructure> getServiceStructureBySId(String serviceId);

	boolean columnKeyExist(ServiceStructure serviceStructure);

}
