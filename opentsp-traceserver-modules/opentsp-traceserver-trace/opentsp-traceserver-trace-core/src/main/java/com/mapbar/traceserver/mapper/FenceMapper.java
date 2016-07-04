package com.mapbar.traceserver.mapper;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.mapbar.traceserver.mapper.provider.FenceMapperProvider;
import com.mapbar.traceserver.model.Fence;

public interface FenceMapper {

	@InsertProvider(method = "createFence", type = FenceMapperProvider.class)
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	void createFence(Fence fence);

	@DeleteProvider(method = "deleteFence", type = FenceMapperProvider.class)
	void deleteFence(Fence fence);

	@UpdateProvider(method = "updateFence", type = FenceMapperProvider.class)
	void updateFence(Fence fence);

	@SelectProvider(method = "listFence", type = FenceMapperProvider.class)
	@ResultMap(value = "com.mapbar.traceserver.entity.mapper.FenceMapper.fence")
	List<Fence> listFence(Fence fence);
	
}
