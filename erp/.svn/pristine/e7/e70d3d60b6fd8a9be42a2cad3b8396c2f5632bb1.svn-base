package com.ihk.utils.autocomplete;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.PropertyUtils;

import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.SupperAction;

/**
 * 智能提示框帮助类(可使用抽象方法,或静态接口)
 * @author dtc
 * 2012-8-10
 */
public abstract class AutoCompleteUtils {
	
	public final static String NAME = "q";
	public final static String OTHER = "otherData";
	
	private final static String LIMIT = "|";
	private final static String LINE = "\n";
	private final static String deleted = "1";
	private final static String is_void = "(已删除)";
	
	/**
	 * 查找的内容,做为complete()中的参数
	 */
	protected static String search; //查找的内容,做为complete()中的参数
	
	/**
	 * 智能提示框
	 * @param action
	 * @param textField bean显示的值
	 * @param idField bean的id
	 * @throws Exception
	 */
	public AutoCompleteUtils(SupperAction action, String textField, String idField) throws Exception{
		
		search = getSearch(action.getRequest());
		
		String out = initForList(complete(), textField, idField);
		
		CustomerUtils.writeResponse(action.getResponse(), out);
		
	}
	
	
	/**
	 * 智能提示框(查询是否is_deleted=0，查出作废客户)
	 * @param action
	 * @param textField bean显示的值
	 * @param idField bean的id
	 * @throws Exception
	 */
	public AutoCompleteUtils(SupperAction action, String textField, String idField, String isDeleted) throws Exception{
		
		search = getSearch(action.getRequest());
		
		String out = initForList(complete(), textField, idField , isDeleted);
		
		CustomerUtils.writeResponse(action.getResponse(), out);
		
	}
	
	
	/**
	 * 抽象方法,里面实现具体业务操作
	 * @return
	 * @throws Exception
	 */
	public abstract List<?> complete() throws Exception;
	
	/**
	 * 最后使用的方法
	 * 静态方法,利用接口的方式实现(与抽象方法一样的效果,但是参数名称可以自己定义,意思会更加明确)
	 * AutoCompleteUtils.doComplete(this, "realName", "id", new AutoCompleteCallback() {
			
			@Override
			public List<?> complete(String name) throws Exception {
				
				return userAccountServices.findUserAccountsLikeNameByCompanyId(name);
			}
		});
	 * @param action
	 * @param textField
	 * @param idField
	 * @param callBack
	 * @throws Exception
	 */
	public static void doComplete(SupperAction action, String textField, String idField, AutoCompleteCallback callBack) throws Exception{
		
		search = getSearch(action.getRequest());
		
		String out = initForList(callBack.complete(search), textField, idField);
		
		CustomerUtils.writeResponse(action.getResponse(), out);
		
	}
	
	/**
	 * 返回自定的要显示的map
	 * @param action
	 * @param callBack
	 * @throws Exception
	 */
	public static void doComplete(SupperAction action, AutoCompleteMapCallback callBack) throws Exception{
		
		search = getSearch(action.getRequest());
		
		String out = initForMap(callBack.complete(search));
		
		CustomerUtils.writeResponse(action.getResponse(), out);
	}
	
	/**
	 * 返回下拉框的格式(如:荔园香堤|65\n合富|66)text1|id1\ntext2|id2
	 * @param pojoList
	 * @param textField
	 * @param idField
	 * @return
	 */
	public static String initForList(List<?> pojoList, String textField, String idField){
		
		StringBuffer sb = new StringBuffer();
		
		if(!CommonUtils.isCollectionEmpty(pojoList)){
			for(Object pojo : pojoList){
				
				try{
					
					Object textObj = PropertyUtils.getProperty(pojo, textField);
					Object idObj = PropertyUtils.getProperty(pojo, idField);
					
					if(textObj == null || "".equals(textObj.toString().trim()) 
							|| idObj == null || "".equals(idObj.toString().trim()))
						continue;
					
					sb.append(textObj.toString()).append(LIMIT).append(idObj.toString()).append(LINE);
					
				}catch(Exception e){
				}
				
			}
		}
		
		return sb.toString();
	}
	
	
	
	/**
	 * 返回下拉框的格式(如:荔园香堤|65\n合富|66)text1|id1\ntext2|id2 ,返回包括作废的客户
	 * @param pojoList
	 * @param textField
	 * @param idField
	 * @return
	 */
	public static String initForList(List<?> pojoList, String textField, String idField , String isDeleted){
		
		StringBuffer sb = new StringBuffer();
		
		if(!CommonUtils.isCollectionEmpty(pojoList)){
			for(Object pojo : pojoList){
				
				try{
					Object isDeletedOrNot =  PropertyUtils.getProperty(pojo, isDeleted);
					Object textObj = PropertyUtils.getProperty(pojo, textField);
					Object idObj = PropertyUtils.getProperty(pojo, idField);
					
					if(textObj == null || "".equals(textObj.toString().trim()) 
							|| idObj == null || "".equals(idObj.toString().trim()))
						continue;
					if(deleted.equals(isDeletedOrNot)){
						sb.append(textObj.toString()).append(is_void).append(LIMIT).append(idObj.toString()).append(LINE);//标记已作废
					}else{
						sb.append(textObj.toString()).append(LIMIT).append(idObj.toString()).append(LINE);//正常未作废
					}
				}catch(Exception e){
				}
				
			}
		}
		
		return sb.toString();
	}
	
	
	
	
	
	
	/**
	 * 根据map返回提示框的格式,(如:荔园香堤|65\n合富|66)text1|id1\ntext2|id2
	 * @param map
	 * @return
	 */
	public static String initForMap(Map<String, String> map){
		
		StringBuffer sb = new StringBuffer();
		
		if(map != null && map.size() > 0){
		
			Set<String> idSet = map.keySet();
			
			for(String id : idSet){
				
				if(CommonUtils.isStrEmpty(id) || CommonUtils.isStrEmpty(map.get(id)))
					continue;
				
				sb.append(map.get(id)).append(LIMIT).append(id).append(LINE);
			}
		}
		
		return sb.toString();
	}
	
	/**
	 * 获取查找的name
	 * @param request
	 * @return
	 */
	public static String getSearch(HttpServletRequest request){
		
		String name = request.getParameter(NAME);
		
		if(name != null){
			name = name.trim();
		}
		
		return name;
	}
	
	/**
	 * 获取其他的参数值
	 * @param request
	 * @return
	 */
	public static String getOther(HttpServletRequest request){
		
		String other = request.getParameter(OTHER);
		
		if(other != null){
			other = other.trim();
		}
		
		return other;
		
	}

}
