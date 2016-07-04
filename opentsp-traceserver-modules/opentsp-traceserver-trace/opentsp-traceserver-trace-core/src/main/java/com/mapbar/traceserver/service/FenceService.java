package com.mapbar.traceserver.service;

import java.util.List;

import com.mapbar.traceserver.model.Fence;

public interface FenceService {

	Fence createFence(Fence fence);

	Fence deleteFence(Fence fence);

	Fence updateFence(Fence fence);

	List<Fence> listFence(Fence fence);

	void queryStatusFence(Fence fence);

}
