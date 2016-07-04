package com.mapbar.traceserver.handler;

import org.springframework.stereotype.Component;

import com.mapbar.traceserver.command.result.JSONResult;
import com.mapbar.traceserver.entity.command.ProxiedCommandMonitorEntity;
import com.navinfo.opentspcore.common.handler.AbstractCommandHandler;

/**
 * 获取请求header Handler写法
 * 
 * @author xubh
 */
@Component
public class ProxiedEntityHandler extends AbstractCommandHandler<ProxiedCommandMonitorEntity, JSONResult> {

	protected ProxiedEntityHandler(Class<ProxiedCommandMonitorEntity> commandType, Class<JSONResult> resultType) {
		super(commandType, resultType);
	}

	public ProxiedEntityHandler() {
		super(ProxiedCommandMonitorEntity.class, JSONResult.class);
	}

	@Override
	public JSONResult handle(ProxiedCommandMonitorEntity proxiedCommandEntity) {
		// 获取请求headers
		//Map<String, Object> headersMap = proxiedCommandEntity.getHeaders();
		JSONResult result = new JSONResult();
		// result.setUrl((String) headersMap.get("url"));
		return result;
	}
}
