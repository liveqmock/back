package com.ihk.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;

import com.ihk.utils.reflect.ReflectUtils;

/**
 * easyui的分页模板
 * @author dtc
 * 2013-5-9,下午06:13:19
 */
public class ActionAjaxPageTemplate {
	
	private static final Logger logger = Logger.getLogger(ActionAjaxPageTemplate.class);
	
	/**
	 * 默认每页条数
	 */
	private int DEFAULT_PAGESIZE = 10;
	
	private SupperAction action;
	
	private SearchCond cond;

	public SupperAction getAction() {
		return action;
	}

	public void setAction(SupperAction action) {
		this.action = action;
	}

	public SearchCond getCond() {
		return cond;
	}

	public void setCond(SearchCond cond) {
		this.cond = cond;
	}
	
	public ActionAjaxPageTemplate(SupperAction action, SearchCond cond){
		
		this.action = action;
		this.cond = cond;
	}
	
	/**
	 * 没有底部的ajax分页(处理对应的异常)
	 * @param callBack
	 */
	public void executeAjaxPage(ActionAjaxPageCallback callBack){
		
		initCond();
		
		int total = 0;
		List<Map<String, String>> rows = null;
		
		try {
			total = callBack.initTotal();
		} catch (Exception e) {
		}
		
		try {
			rows = callBack.initRows();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JSONArray rowsArray = new JSONArray();
		
		JSONObject json = null;
		
		if(!CommonUtils.isCollectionEmpty(rows)){
			
			for(Map<String, String> map : rows){
				
				json = new JSONObject();
				
				Set<String> keys = map.keySet();
				
				for(String key : keys){
					
					String value = map.get(key);
					try {
						json.put(key, (value == null ? "" : value.trim()));
					} catch (JSONException e) {
					}
				}
				
				rowsArray.add(json);
			}
		}
		
		initOutJson(total, rowsArray, null);
	}
	
	/**
	 * 有底部的ajax分页(处理对应的异常)
	 * @param callBack
	 */
	public void executeAjaxPage(ActionAjaxPageByFooterCallback callBack){
		
		initCond();
		
		int total = 0;
		List<Map<String, Object>> rows = null;
		JSONArray footer = new JSONArray();
		
		try {
			total = callBack.initTotal();
		} catch (Exception e) {
		}
		
		try {
			rows = callBack.initRows();
		} catch (Exception e) {
		}
		
		try{
			footer = callBack.initFootor(rows);
		}catch (Exception e) {
		}
		
		JSONArray rowsArray = new JSONArray();
		
		JSONObject json = null;
		
		if(!CommonUtils.isCollectionEmpty(rows)){
			
			for(Map<String, Object> map : rows){
				
				json = new JSONObject();
				
				Set<String> keys = map.keySet();
				
				for(String key : keys){
					
					Object value = map.get(key);
					try {
						json.put(key, (value == null ? "" : value.toString().trim()));
					} catch (JSONException e) {
					}
				}
				
				rowsArray.add(json);
			}
		}
		
		initOutJson(total, rowsArray, footer);
	}
	
	/**
	 * 根据字段反射,没有底部的分页
	 * @param callBack
	 * @param fields
	 */
	public void executeAjaxPage(ActionAjaxFieldPageCallback callBack, String ... fields){
		
		initCond();
		
		int total = 0;
		List<?> rows = null;
		
		try {
			total = callBack.initTotal();
		} catch (Exception e) {
		}
		
		try {
			rows = callBack.initRows();
		} catch (Exception e) {
		}
		
		JSONArray rowsArray = ReflectUtils.getBeanListJSONArrayByField(rows, fields);
		
		initOutJson(total, rowsArray, null);
	}
	
	/**
	 * 根据字段反射,有底部的分页
	 * @param callBack
	 * @param fields
	 */
	public void executeAjaxPage(ActionAjaxFieldPageByFooterCallback callBack, String ... fields){
		
		initCond();
		
		int total = 0;
		List<?> rows = null;
		JSONArray footer = new JSONArray();
		
		try {
			total = callBack.initTotal();
		} catch (Exception e) {
		}
		
		try {
			rows = callBack.initRows();
		} catch (Exception e) {
		}
		
		List<Map<String, String>> footerMapList = new ArrayList<Map<String,String>>();
		Map<String, String> footerMap = null;
		
		JSONArray rowsArray = new JSONArray();
		JSONObject json = null;
		
		if(!CommonUtils.isCollectionEmpty(rows) && fields.length > 0){
			
			for(Object bean : rows){
				
				json = new JSONObject();
				footerMap = new HashMap<String, String>();
				
				for(String field : fields){
					
					try {
						
						Object value = PropertyUtils.getProperty(bean, field); //这种发射效率较低,使用ReflectASM,可是系统又不支持ReflectASM,坑爹
						
						json.put(field, (value == null ? "" : value));
						footerMap.put(field, (value == null ? "" : value.toString().trim()));
						
					} catch (Exception e) {
					}
				}
				
				rowsArray.add(json);
				footerMapList.add(footerMap);
			}
		}
		
		try{
			footer = callBack.initFootor(footerMapList);
		}catch (Exception e) {
		}
		
		initOutJson(total, rowsArray, footer);
	}
	
	/**
	 * 初始化输出
	 * @param total
	 * @param rowsArray
	 * @param footer
	 */
	private void initOutJson(int total, JSONArray rowsArray, JSONArray footer){
		
		JSONObject endJson = new JSONObject();
		
		try {
			
			endJson.put("total", total); //total键 存放总记录数，必须的
			endJson.put("rows", rowsArray);// rows键 存放每页记录 list
			
			if(CommonUtils.isCollectionEmpty(footer)){
				endJson.put("footer", footer); //footer键 存放底部
			}
			
			CustomerUtils.writeResponse(action.response, endJson.toString());
			
		} catch (Exception e) {
			
			endJson.put("total", 0); //total键 存放总记录数，必须的
			endJson.put("rows", new JSONArray());// rows键 存放每页记录 list
			
			if(CommonUtils.isCollectionEmpty(footer)){
				endJson.put("footer", footer); //footer键 存放底部
			}
			
			try {
				CustomerUtils.writeResponse(action.response, endJson.toString());
			} catch (IOException e1) {
				logger.error("easyui datagrid分页出现异常", e1);
			}
		} 
	}
	
	/**
	 * 初始化cond
	 */
	private void initCond(){
		
		//如果为空
		if(cond == null){
			cond = new SearchCond();
		}
		
		//排序字段
		String getSort = action.request.getParameter("sort");
		if(!CommonUtils.isStrEmpty(getSort)){
			cond.setSort(getSort);
		}
		
		//升序或降序
		String getOrder = action.request.getParameter("order");
		if(!CommonUtils.isStrEmpty(getOrder)){
			cond.setOrder(getOrder);
		}
		
		//每页条数
		String getRows = action.request.getParameter("rows");
		if(CommonUtils.isStrEmpty(getRows)){
			//表示为不分页
			cond.startLine = -1;
			return ;
		}
		
		int pageSize = DEFAULT_PAGESIZE;
		if(CommonUtils.isIntString(getRows)){
			pageSize = Integer.parseInt(getRows);
		}
		cond.pageSize = pageSize;
		
		//当前页数
		int page = 1;
		String getPage = action.request.getParameter("page");
		if(CommonUtils.isIntString(getPage)){
			page = Integer.parseInt(getPage);
		}
		cond.startLine = (page - 1) * pageSize;
	}
}