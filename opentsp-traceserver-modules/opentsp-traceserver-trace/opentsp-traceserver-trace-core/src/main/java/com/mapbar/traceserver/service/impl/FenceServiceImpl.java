package com.mapbar.traceserver.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mapbar.traceserver.mapper.FenceMapper;
import com.mapbar.traceserver.model.Fence;
import com.mapbar.traceserver.service.FenceService;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class FenceServiceImpl implements FenceService {

	@Resource
	private FenceMapper fenceMapper;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
	public Fence createFence(Fence fence) {
		fenceMapper.createFence(fence);
		return fence;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
	public Fence deleteFence(Fence fence) {
		fenceMapper.deleteFence(fence);
		return fence;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
	public Fence updateFence(Fence fence) {
		fenceMapper.updateFence(fence);
		return null;
	}

	@Override
	public List<Fence> listFence(Fence fence) {
		List<Fence> list = fenceMapper.listFence(fence);
		return list;
	}

	@Override
	public void queryStatusFence(Fence fence) {
	}

}
