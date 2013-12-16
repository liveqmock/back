package com.ihk.utils;

import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.util.CollectionUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * aciton的基础类
 * @author dtc
 * 2011-10-8
 * Preparable
 */
public class SupperAction extends ActionSupport implements ServletResponseAware,ServletRequestAware,Serializable {

	private static final long serialVersionUID = -2501172997559037818L;

	private final String SUGGESTION = "suggestion";

	private String showPage; //分页链接
	
	private String suggestion; //操作提示
	
	private String nowDate; //当前日期yyyy-MM-dd
	
	protected String closeMark; //主要用于装有iframe的dialog的关闭
	
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected DataSource dataSource;
	protected int pageSize = 10;
	
	private Pager pager;
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		
		//Connection conn = (Connection) request.getSession().getServletContext().getAttribute("connection");
		
		//request = UrlCodeUtils.pageDecode(request);
		
		this.request = request;
		try {
			this.request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		nowDate = CommonUtils.getNowForString();
	}
	
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
		this.response.setCharacterEncoding("utf-8");
	}
	
	public HttpServletRequest getRequest() {
		return request;
	}
	
	public HttpServletResponse getResponse() {
		return response;
	}
	
	public void setCloseMark(String closeMark) {
		this.closeMark = closeMark;
	}
	
	public String getCloseMark() {
		return closeMark;
	}
	
	/**
	 * 设置关闭的标示
	 * jsp页面的调用:closeIframeDialog("myIframeDialog", "${closeMark}", "", "${suggestion}");
	 * 对应的js:saleunit_new_common_min.js
	 */
	protected void setUpMarkToClose(){
		closeMark = "true";
	}
	
	public String getNowDate() {
		return nowDate;
	}
	
	public void setNowDate(String nowDate) {
		this.nowDate = nowDate;
	}
	
	public String getShowPage() {
		return showPage;
	}

	public void setShowPage(String showPage) {
		this.showPage = showPage;
	}
	
	/**
	 * 操作成功提示
	 */
	public void setSuggestion_Success(){
		setSuggestion(CommonUtils.SUCCSUGG);
	}

	/**
	 * 操作失败提示
	 */
	public void setSuggestion_Fail(){
		setSuggestion(CommonUtils.FAILSUGG);
	}
	
	/**
	 * 增加提示语
	 * @param suggestion
	 */
	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
		request.getSession().setAttribute(SUGGESTION, suggestion);  
	}
	
	public String getSuggestion() {
		return suggestion;
	}
	
	/**
	 * 删除提示语
	 */
	protected void removeSuggestion(){
		request.getSession().removeAttribute(SUGGESTION);
	}
	
	 /**
	  *  初始化分页
	  * @param cond
	  */
	protected void initPager(SearchCond cond){
		String actionUrl = CustomerUtils.getActionNameFromRequest(this.request);
		
		pager = new Pager(ActionContext.getContext(), this.pageSize, actionUrl);
		pager.setCond(cond);
    }

	 /**
	  *  显示分页
	  * @param cond
	  */
	protected void showPager(SearchCond cond)  {
		this.setShowPage(pager.toHtmlString());		
		this.request.getSession().setAttribute(CommonUtils.COND, cond);  
	}
	
	/////上面的方法是在非easyui框架中使用,下面的方法是在easyui框架中使用
	
	/**
	 * 操作成功的自定义提示
	 */
	private String succTitle;
	
	/**
	 * 操作成功要返回的自定义值,作为提示框span的属性
	 */
	private Map<String, String> succMap;
	
	/**
	 * 操作失败的自定义提示
	 */
	private String failTitle;
	
	/**
	 * 操作失败要返回的自定义值,作为提示框span的属性
	 */
	private Map<String, String> failMap;
	
	/**
	 * 设置自定义成功的提示,使用easyui.utils.js中的$.currentIframeSuggSpan()来获取
	 * @param succTitle
	 */
	protected void setUpEasyuiAjaxForSucc(String succTitle){
		
		setUpEasyuiAjaxForSucc(succTitle, null);
	}
	
	/**
	 * 设置自定义成功的提示及返回值,使用easyui.utils.js中的$.currentIframeSuggSpan()来获取
	 * @param succTitle
	 * @param succMap
	 */
	protected void setUpEasyuiAjaxForSucc(String succTitle, Map<String, String> succMap){
		
		this.succTitle = succTitle;
		this.succMap = succMap;
		
	}
	
	/**
	 * 设置自定义失败的提示,使用easyui.utils.js中的$.currentIframeSuggSpan()来获取
	 * @param failTitle
	 */
	protected void setUpEasyuiAjaxForFail(String failTitle){
		
		setUpEasyuiAjaxForFail(failTitle, null);
	}
	
	/**
	 * 设置自定义失败的提示及返回值,使用easyui.utils.js中的$.currentIframeSuggSpan()来获取
	 * @param failTitle
	 * @param failMap
	 */
	protected void setUpEasyuiAjaxForFail(String failTitle, Map<String, String> failMap){
		
		this.failTitle = failTitle;
		this.failMap = failMap;
		
	}
	
	/**
	 * 输出正确或失败的提示信息,可以在页面获取,默认为成功
	 */
	public void setUpEasyuiAjaxForWriteOut(){
		
		setUpEasyuiAjaxForWriteOut(true);
	}

	/**
	 * 输出正确或失败的提示信息,可以在页面获取
	 * @param isSucc
	 */
	public void setUpEasyuiAjaxForWriteOut(boolean isSucc){
		
		Map<String, String> map = new HashMap<String, String>();
		
		if(isSucc){
			
			map.put("type", "true");
			
			if(!CommonUtils.isStrEmpty(succTitle)){
				
				map.put("title", succTitle);
			}
			
			if(!CollectionUtils.isEmpty(succMap)){
				
				map.putAll(succMap);
			}
			
		}else{
			
			map.put("type", "false");
			
			if(!CommonUtils.isStrEmpty(failTitle)){
				
				map.put("title", failTitle);
			}
			
			if(!CollectionUtils.isEmpty(failMap)){
				
				map.putAll(failMap);
			}
		}
		
		String content = CommonUtils.getMapJson(map);
		try {
			CustomerUtils.writeResponse(getResponse(), content);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据请求值，设置OrderSort排序
	 * @param cond
	 */
	protected void setCondOrderSortByRequest(SearchCond cond)  {
		if(request.getParameter("sort")!=null){
			cond.setSort(request.getParameter("sort").toString());			
		}
		if(request.getParameter("order")!=null){
			cond.setOrder(request.getParameter("order").toString());			
		}
	}
	
}
	
