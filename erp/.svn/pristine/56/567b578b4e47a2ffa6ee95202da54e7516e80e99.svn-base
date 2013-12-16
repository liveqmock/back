package com.ihk.utils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ihk.constanttype.ContCacheAndCode;
import com.ihk.utils.code.UrlCodeUtils;
import com.opensymphony.xwork2.ActionContext;

/**
 * 分页公共类
 * @author dtc
 * 2012-9-29
 */
@SuppressWarnings("rawtypes")
public class Pager {
	
	private static List<String> exParams;
	static{
		exParams = new ArrayList<String>();
		exParams.add(ContCacheAndCode.PAGE_SIGN);
		exParams.add(ContCacheAndCode.DELETE_SESSION);
	}
	
	private ActionContext context;
	private int pageSize;
	private String nextPageActionName;
	private int currentPage;
	private int recordCount;
	//private Map<String,String> conditionMap;
	
	private SearchCond cond;
	
	
	public SearchCond getCond() {
		return cond;
	}

	public void setCond(SearchCond cond) {
		
		cond.startLine = this.getCurrentStartLine();
		cond.pageSize = pageSize;

		Map params = context.getParameters(); 
		if(params.containsKey("ob")){
			cond.setOrderByFiled(((String[])params.get("ob"))[0]);
		}
		
		this.cond = cond;
		
	}

	public Pager(ActionContext context, int pageSize,String nextPageActionName) {
		this.context = context;
		this.pageSize = pageSize;
		this.nextPageActionName = nextPageActionName;
		
		setCurrentPage();
		
//		conditionMap = new HashMap<String, String>();
//		conditionMap.put("startLine", String.valueOf(getCurrentStartLine()));
//		conditionMap.put("pageSize", String.valueOf(pageSize));
//		conditionMap.put("recordCount", "0");
//		conditionMap.put("isCount", "0");
	}	
	
	/**
	 * 取得页面显示的分页html
	 * <a onclick='try{showLoad();}catch(e){}return true;'...
	 * 分页显示加载条,并加上try...catch处理
	 * @return
	 */
	public String toHtmlString() {
		recordCount = cond.recordCount;//Integer.valueOf(conditionMap.get("recordCount"));
		
		int pageCount = recordCount / pageSize + (recordCount % pageSize == 0 ? 0 : 1);
		
		String urlPameters = getUrlPameters(context);
		if(urlPameters.length()>0){
			urlPameters = "&"+urlPameters;
		}
		
	    StringBuffer sb =new StringBuffer();
	    
					
	    if (currentPage <= 0){
	        currentPage = 1;
	    }
	    
	    if(currentPage >= pageCount){
	    	currentPage = pageCount;
	    }
	    
	    if (currentPage > 1){
	        sb.append("<a onclick='try{showLoad();}catch(e){}return true;' href=\""+nextPageActionName+"?p=1"+urlPameters+"\">首页</a> ");
	        sb.append("<a onclick='try{showLoad();}catch(e){}return true;' href=\""+nextPageActionName+"?p="+(currentPage-1)+urlPameters+"\">上页</a> ");
	    }
	    
	    if(pageCount > 5){
	    	if(currentPage <= 3){
	    		sb.append(setPageForFirstAndEnd(1, 5, urlPameters));
	    		
	    	}else{
	    		if(currentPage+2 > pageCount){
	    			sb.append(setPageForFirstAndEnd(currentPage-3, pageCount, urlPameters));
	    			
	    		}else{
	    			sb.append(setPageForFirstAndEnd(currentPage-2, currentPage+2, urlPameters));
	    	
	    		}
	    	}
	    }else{
	    	sb.append(setPageForFirstAndEnd(1, pageCount, urlPameters));
	    	
	    }
	    
	    if (currentPage < pageCount){
	    	sb.append("<a onclick='try{showLoad();}catch(e){}return true;' href=\""+nextPageActionName+"?p="+(currentPage+1)+urlPameters+"\">下页</a> ");
	    	sb.append("<a onclick='try{showLoad();}catch(e){}return true;' href=\""+nextPageActionName+"?p="+ pageCount + urlPameters+"\">末页</a>");
	    } 
	    
	    sb.append("总数目: " + recordCount + ",总页数: " + pageCount);
	    
	    return sb.toString();  
	}
	
	private String setPageForFirstAndEnd(int first, int end, String urlPameters){
		StringBuffer sb = new StringBuffer();
		for(int i=first; i<=end; i++){
	    	if(currentPage==i){
	    		sb.append("<a onclick='try{showLoad();}catch(e){}return true;' href=\""+nextPageActionName+"?p="
	    				+i+urlPameters+"\" style=\"color:red;\">"+i+"</a> ");
	    		
	    	}else{
	    		
	    		sb.append("<a onclick='try{showLoad();}catch(e){}return true;' href=\""+nextPageActionName+"?p="
	    				+i+urlPameters+"\">"+i+"</a> ");
	    	}
	    }
		
		return sb.toString();
	}
	
	
	
	//取得地址栏的参数,并且不要参数p
	public String getUrlPameters(ActionContext context){
		Map<String, Object> params = context.getParameters();
		
		return UrlCodeUtils.encode(params, exParams);
		
		/*
		StringBuffer sb = new StringBuffer();   
    
		for(String para : params.keySet()) {
			
			if("deleteSession".equals(para))
				continue;  //避免删除的时候总是显示提示
			
			if(!para.equals("p")){
				if(sb.length()>0){
					sb.append("&");
				}
				sb.append(para+"="+((String[])params.get(para))[0]); //这样写,不能正确处理有多个选择的情况,如:knownFrom=12&knownFrom=13
			}
		}
		
		String ret = sb.toString();
		return ret;
		*/
		
	}
	
	//设置当前页面
	public void setCurrentPage(){		  
		Map params = context.getParameters();
				
		String[] p=(String[])params.get("p");
		
		currentPage = 1;
		if(p!=null){								
			try{    
				currentPage = Integer.parseInt(p[0]);
			} catch (Exception e) {
				e.printStackTrace();				
			}
		}			
	}	
	
	//取得当前页面
	public int getCurrentStartLine(){	
		return (currentPage - 1) * pageSize;
	}
	
//	public Map<String,String> getConditionMap(){				
//		return conditionMap;
//	}
	
}