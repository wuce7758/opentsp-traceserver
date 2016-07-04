package com.mapbar.traceserver.mapper;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;

@SuppressWarnings("rawtypes")
public class TraceServiceResultHandler implements ResultHandler {

	Map<String, String> inMap = new HashMap<String, String>();

	public Map<String, String> getIdNameMap() {
		return inMap;
	}

	@Override
	public void handleResult(ResultContext rc) {
		@SuppressWarnings("unchecked")
		Map<String, Object> m = (Map<String, Object>) rc.getResultObject();
		inMap.put((String) getFromMap(m, "service_id"), (String) getFromMap(m, "service_table"));
	}

	private Object getFromMap(Map<String, Object> map, String key) {
		if (map.containsKey(key.toLowerCase())) {
			return map.get(key.toLowerCase());
		} else {
			return map.get(key.toUpperCase());
		}
	}
}
