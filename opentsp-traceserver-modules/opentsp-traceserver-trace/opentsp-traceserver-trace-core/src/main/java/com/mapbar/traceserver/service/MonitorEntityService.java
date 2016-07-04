package com.mapbar.traceserver.service;

import java.util.List;
import java.util.Map;

import com.mapbar.traceserver.model.MonitorEntity;

/**
 * 监控对象业务层
 * 
 * @author xubh
 *
 */
public interface MonitorEntityService {

	MonitorEntity addEntity(MonitorEntity monitorEntity) throws Exception;

	MonitorEntity deleteEntity(MonitorEntity monitorEntity);

	List<MonitorEntity> listEntity(MonitorEntity monitorEntity);

	List<Map<String, Object>> getEntityMap(MonitorEntity monitorEntity);

	boolean entityNameExist(MonitorEntity monitorEntity);

	List<MonitorEntity> getEntity();

}
