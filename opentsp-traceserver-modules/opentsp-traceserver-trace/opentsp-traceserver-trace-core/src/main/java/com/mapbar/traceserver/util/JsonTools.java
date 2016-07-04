package com.mapbar.traceserver.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.map.ListOrderedMap;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 
 * 处理json的工具类. <br>
 * 本类为处理json的工具类
 * 
 * @author xubh
 */
public class JsonTools {

	/**
	 * 
	 * json转换list. <br>
	 * 详细说明
	 * 
	 * @param jsonStr
	 *            json字符串
	 * @return
	 * @return List<Map<String,Object>> list
	 * @throws @author
	 *             xubh
	 * @date 2013年12月24日 下午1:08:03
	 */
	public static List<Map<String, Object>> parseJSON2List(String jsonStr) {
		JSONArray jsonArr = JSONArray.parseArray(jsonStr);
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Iterator<Object> it = jsonArr.iterator();
		while (it.hasNext()) {
			JSONObject json2 = (JSONObject) it.next();
			list.add(parseJSON2Map(json2.toString()));
		}
		return list;
	}

	/**
	 * 
	 * json转换map. <br>
	 * 详细说明
	 * 
	 * @param jsonStr
	 *            json字符串
	 * @return
	 * @return Map<String,Object> 集合
	 * @throws @author
	 *             xubh
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> parseJSON2Map(String jsonStr) {
		ListOrderedMap map = new ListOrderedMap();
		// 最外层解析
		JSONObject json = JSONObject.parseObject(jsonStr);
		for (Object k : json.keySet()) {
			Object v = json.get(k);
			// 如果内层还是数组的话，继续解析
			if (v instanceof JSONArray) {
				List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
				Iterator<Object> it = ((JSONArray) v).iterator();
				while (it.hasNext()) {
					JSONObject json2 = (JSONObject) it.next();
					list.add(parseJSON2Map(json2.toString()));
				}
				map.put(k.toString(), list);
			} else {
				map.put(k.toString(), v);
			}
		}
		return map;
	}

	/**
	 * 
	 * 通过HTTP获取JSON数据. <br>
	 * 通过HTTP获取JSON数据返回list
	 * 
	 * @param url
	 *            链接
	 * @return
	 * @return List<Map<String,Object>> list
	 * @throws @author
	 *             xubh
	 */
	public static List<Map<String, Object>> getListByUrl(String url) {
		try {
			// 通过HTTP获取JSON数据
			InputStream in = new URL(url).openStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
			return parseJSON2List(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * 通过HTTP获取JSON数据. <br>
	 * 通过HTTP获取JSON数据返回map
	 * 
	 * @param url
	 *            链接
	 * @return
	 * @return Map<String,Object> 集合
	 * @throws @author
	 *             xubh
	 */
	public static Map<String, Object> getMapByUrl(String url) {
		try {
			// 通过HTTP获取JSON数据
			InputStream in = new URL(url).openStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
			return parseJSON2Map(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * map转换json. <br>
	 * 详细说明
	 * 
	 * @param map
	 *            集合
	 * @return
	 * @return String json字符串
	 * @throws @author
	 *             xubh
	 */
	public static String mapToJson(Map<String, String> map) {
		Set<String> keys = map.keySet();
		String key = "";
		String value = "";
		StringBuffer jsonBuffer = new StringBuffer();
		jsonBuffer.append("{");
		for (Iterator<String> it = keys.iterator(); it.hasNext();) {
			key = (String) it.next();
			value = map.get(key);
			jsonBuffer.append(key + ":" + "\"" + value + "\"");
			if (it.hasNext()) {
				jsonBuffer.append(",");
			}
		}
		jsonBuffer.append("}");
		return jsonBuffer.toString();
	}

}