package com.mapbar.traceserver.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mapbar.traceserver.exception.MonitorEntityException;
import com.mapbar.traceserver.mapper.MonitorEntityMapper;
import com.mapbar.traceserver.mapper.TraceServiceMapper;
import com.mapbar.traceserver.model.MonitorEntity;
import com.mapbar.traceserver.model.TraceService;
import com.mapbar.traceserver.service.MonitorEntityService;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class MonitroEntityServiceImpl implements MonitorEntityService {

	@Resource
	private MonitorEntityMapper monitorEntityMapper;

	@Resource
	private TraceServiceMapper traceServiceMapper;

	private Map<String, TraceService> getTableMap() {
		return traceServiceMapper.getAllToMap();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
	public MonitorEntity addEntity(MonitorEntity monitorEntity) throws Exception {
		boolean exist = this.entityNameExist(monitorEntity);
		if (exist) {
			monitorEntity.setTableName(this.getTableMap().get(monitorEntity.getServiceId()).getServiceTable());
			monitorEntityMapper.addEntity(monitorEntity);
		} else {
			throw new MonitorEntityException("监控对象名称已存在！");
		}
		// int a=10/0;//测试一下事务是否生效
		return monitorEntity;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
	public MonitorEntity deleteEntity(MonitorEntity monitorEntity) {
		monitorEntity.setTableName(this.getTableMap().get(monitorEntity.getServiceId()).getServiceTable());
		monitorEntityMapper.deleteEntity(monitorEntity);
		return monitorEntity;
	}

	@Override
	public List<MonitorEntity> listEntity(MonitorEntity monitorEntity) {
		monitorEntity.setTableName(this.getTableMap().get(monitorEntity.getServiceId()).getServiceTable());
		List<MonitorEntity> list = monitorEntityMapper.listEntity(monitorEntity);
		return list;
	}

	@Override
	public List<Map<String, Object>> getEntityMap(MonitorEntity monitorEntity) {
		monitorEntity.setTableName(this.getTableMap().get(monitorEntity.getServiceId()).getServiceTable());
		Page<Map<String, Object>> page = PageHelper.startPage(monitorEntity.getPageIndex(), monitorEntity.getPageSize()).doSelectPage(new ISelect() {
			@Override
			public void doSelect() {
				monitorEntityMapper.listEntityMap(monitorEntity);
			}
		});
		List<Map<String, Object>> list = page.getResult();
		Map<String, Object> pagemap = new HashMap<>();
		pagemap.put("size", list.size());
		pagemap.put("total", page.getTotal());
		list.add(pagemap);
		return list;
	}

	@Override
	public boolean entityNameExist(MonitorEntity monitorEntity) {
		MonitorEntity exist = monitorEntityMapper.entityNameExist(monitorEntity);
		if (exist != null) {
			return false;
		}
		return true;
	}

	@Override
	public List<MonitorEntity> getEntity() {
		Page<MonitorEntity> page = PageHelper.startPage(1, 2).doSelectPage(new ISelect() {
			@Override
			public void doSelect() {
				monitorEntityMapper.getEntity();
			}
		});
		return page.getResult();
	}

}
