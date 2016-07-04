package com.mapbar.traceserver.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mapbar.traceserver.exception.MonitorEntityException;
import com.mapbar.traceserver.mapper.ServiceStructureMapper;
import com.mapbar.traceserver.mapper.TraceServiceMapper;
import com.mapbar.traceserver.model.ServiceStructure;
import com.mapbar.traceserver.model.TraceService;
import com.mapbar.traceserver.service.ServiceStructureService;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ServiceStructureServiceImpl implements ServiceStructureService {

	@Resource
	private ServiceStructureMapper serviceStructureMapper;

	@Resource
	private TraceServiceMapper traceServiceMapper;

	private Map<String, TraceService> getTableMap() {
		return traceServiceMapper.getAllToMap();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
	public ServiceStructure addColumn(ServiceStructure serviceStructure) {
		// 同一个service下entity的column_key不能重复
		boolean exist = this.columnKeyExist(serviceStructure);
		if (exist) {
			serviceStructureMapper.addEntityColumn(serviceStructure);
			serviceStructure.setTableName(this.getTableMap().get(serviceStructure.getServiceId()).getServiceTable());
			serviceStructureMapper.addDbColumn(serviceStructure);
			if (serviceStructure.getIsSearch() == 1) {
				serviceStructureMapper.addColumnIndex(serviceStructure);
			}
		} else {
			throw new MonitorEntityException("添加监控对象列已存在！");
		}
		return serviceStructure;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
	public ServiceStructure deleteColumn(ServiceStructure serviceStructure) {
		boolean exist = this.columnKeyExist(serviceStructure);
		if (!exist) {
			serviceStructureMapper.deleteEntityColumn(serviceStructure);
			serviceStructure.setTableName(this.getTableMap().get(serviceStructure.getServiceId()).getServiceTable());
			serviceStructureMapper.deleteDbColumn(serviceStructure);
		} else {
			throw new MonitorEntityException("删除监控对象列不存在！");
		}
		return serviceStructure;
	}

	@Override
	public List<ServiceStructure> listColumn(ServiceStructure serviceStructure) {
		return serviceStructureMapper.listEntityColumn(serviceStructure);
	}

	@Override
	public List<Map<String, Object>> listColumnMap(ServiceStructure serviceStructure) {
		return serviceStructureMapper.listEntityColumnMap(serviceStructure);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
	public ServiceStructure updateColumn(ServiceStructure serviceStructure) {
		ServiceStructure svali = new ServiceStructure();
		BeanUtils.copyProperties(serviceStructure, svali);
		svali.setColumnKey(svali.getColumnKeyNew());
		boolean exist = this.columnKeyExist(svali);
		if (exist) {
			serviceStructureMapper.updateEntityColumn(serviceStructure);
			serviceStructure.setTableName(this.getTableMap().get(serviceStructure.getServiceId()).getServiceTable());
			serviceStructureMapper.updateDbColumn(serviceStructure);
			/*if (serviceStructure.getIsSearch() == 1) {
				svali.setTableName(this.getTableMap().get(serviceStructure.getServiceId()).getServiceTable());
				serviceStructureMapper.addColumnIndex(svali);
			}*/
		} else {
			throw new MonitorEntityException("更新监控对象列已存在！");
		}
		return serviceStructure;
	}

	@Override
	public List<ServiceStructure> getServiceStructureBySId(String serviceId) {
		return serviceStructureMapper.getServiceStructureBySId(serviceId);
	}

	@Override
	public boolean columnKeyExist(ServiceStructure serviceStructure) {
		ServiceStructure exist = serviceStructureMapper.columnKeyExist(serviceStructure);
		if (exist != null) {
			return false;
		}
		return true;
	}

}
