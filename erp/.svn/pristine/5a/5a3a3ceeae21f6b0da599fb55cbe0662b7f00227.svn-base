package com.ihk.saleunit.action.common.proareabuild;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.ihk.permission.PermissionUtils;
import com.ihk.property.data.pojo.PropertyProject;
import com.ihk.user.data.pojo.Company;
import com.ihk.utils.CacheFrontName;
import com.ihk.utils.CacheUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.SessionUser;
import com.ihk.utils.cache.MyCacheTemplate;
import com.ihk.utils.cache.MyCacheTemplateCallback;
import com.ihk.utils.saleunit.MyPropertyUtils;

/**
 * 公司-->楼盘项目
 * @author dtc
 * 2013-1-7,上午11:03:49
 */
public class MyComboTreeCompanyPropertyProjectTemplate {
	
	/**
	 * 设置页面显示的ComboTree
	 * @param request
	 * @return
	 */
	public static String initComboTree(HttpServletRequest request){
		
		//如果返回false表示为单选,否则为多选
		String isMultiple = request.getParameter("isMultiple");
		
		JSONObject retJson = new JSONObject();
		retJson.put("id", "");
		if("false".equals(isMultiple)){
			retJson.put("text", CommonUtils.EMPTY);
		}else{
			retJson.put("text", CommonUtils.ALL);
		}
		
		//获取当前客户销控role对应的公司,公司项目map
		Map<Company, List<PropertyProject>> map = cacheCompanyAndPropertyProjectMapByXKZX();
		
		if(!CommonUtils.isMapEmpty(map)){
			
			String projectId = request.getParameter("projectId");
			
			JSONArray comArr = new JSONArray(); //公司json数组
			
			Set<Company> comSet = map.keySet();
			
			for(Company company : comSet){
				
				List<PropertyProject> proList = map.get(company);
				if(CommonUtils.isCollectionEmpty(proList))
					continue;
				
				JSONObject comJson = new JSONObject();
				comJson.put("id", "com_" + company.getId());
				comJson.put("text", company.getCompanyName());
				comJson.put("state", getNodeState(proList, projectId, request)); //easyui默认为open
				comJson.put("children", getProjectListJson(proList, projectId));
				
				comArr.add(comJson);
			}
			
			retJson.put("children", comArr.toString());
		}
		
		/**
		List<Company> comList = getCompanyList();
		
		if(!CommonUtils.isCollectionEmpty(comList)){
			
			String projectId = request.getParameter("projectId");
			
			JSONArray comArr = new JSONArray(); //公司json数组
			
			for(Company company : comList){
				
				List<PropertyProject> proList = getProjectListByCompanyId(company.getId());
				
				JSONObject comJson = new JSONObject();
				comJson.put("id", "com_" + company.getId());
				comJson.put("text", company.getCompanyName());
				comJson.put("state", getNodeState(proList, projectId, request)); //easyui默认为open
				comJson.put("children", getProjectListJson(proList, projectId));
				
				comArr.add(comJson);
			}
			
			retJson.put("children", comArr.toString());
		}
		*/
		
		return "[" + retJson.toString() + "]";
	}
	
	/**
	 * 获取公司的下拉树
	 * @param request
	 * @return
	 */
	public static String getCompanyComboTreeOnly(HttpServletRequest request){
		
		//如果返回false表示为单选,否则为多选
		String isMultiple = request.getParameter("isMultiple");
		
		JSONObject retJson = new JSONObject();
		retJson.put("id", "");
		if("false".equals(isMultiple)){
			retJson.put("text", CommonUtils.EMPTY);
		}else{
			retJson.put("text", CommonUtils.ALL);
		}

		JSONArray comArr = new JSONArray(); //公司json数组
		
		List<Company> comList = getCompanyList();
		
		if(!CommonUtils.isCollectionEmpty(comList)){
			
			for(Company company : comList){
				
				JSONObject comJson = new JSONObject();
				comJson.put("id", company.getId());
				comJson.put("text", company.getCompanyName());
				
				comArr.add(comJson);
			}
		}
		
		retJson.put("children", comArr);
		
		return "[" + retJson + "]";
	}
	
	/**
	 * 当前客户销控role对应的公司,楼盘项目map的cache
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private static Map<Company, List<PropertyProject>> cacheCompanyAndPropertyProjectMapByXKZX(){
		
		return (Map<Company, List<PropertyProject>>) MyCacheTemplate.cache(CacheFrontName.COMBOTREE_COMPANY_PROPERTY_PROJECT_CACHE, 
				SessionUser.getUserIdStr(), new MyCacheTemplateCallback() {
			
			@Override
			public Object doCache() throws Exception {
				return PermissionUtils.getCompanyAndPropertyProjectMapByXKZX();
			}
		});
		
	}
	
	/**
	 * 返回单选节点是否伸开(closed表示收缩,open表示伸开)
	 * @param projects
	 * @param projectId
	 * @param request
	 * @return
	 */
	private static String getNodeState(List<PropertyProject> projects, String projectId, HttpServletRequest request){
		
		String ret = "closed";
		
		String isMultiple = request.getParameter("isMultiple");
		
		if("false".equals(isMultiple)){
			//表示为单选
			if(!CommonUtils.isCollectionEmpty(projects)){
				
				for(PropertyProject pro : projects){
					
					if(projectId.equals(pro.getId() + "")){
						
						ret = "open";
						break;
					}
					
				}
			}
			
		}
		
		return ret;
	}
	
	/**
	 * 获取项目list的json
	 * @param projects
	 * @return
	 */
	private static String getProjectListJson(List<PropertyProject> projects, String projectId){
		
		JSONArray arr = new JSONArray();
		
		if(!CommonUtils.isCollectionEmpty(projects)){
			
			JSONObject json = null;
			for(PropertyProject pro : projects){
				
				json = new JSONObject();
				
				String id = pro.getId() + "";
				json.put("id", id);
				json.put("text", pro.getPropertyName());
				
				if(projectId.equals(id)){
					json.put("checked", true);
				}
				
				arr.add(json);
			}
		}
		
		return arr.toString();
	}
	
	/**
	 * 根据公司id,获取对应的楼盘项目list
	 * @param comId
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	private static List<PropertyProject> getProjectListByCompanyId(int comId){
		
		List<PropertyProject> projects = new ArrayList<PropertyProject>();
		
		Object value = CacheUtils.getValueByCacheNameAndKey(CacheFrontName.COMBOTREE_PROPERTY_CACHE, SessionUser.getUserIdStr() + comId);
		if(value == null){
			
			projects = MyPropertyUtils.getPropertyProjectServices().findPropertyProjectByCompanyId(comId);
			
			CacheUtils.add(CacheFrontName.COMBOTREE_PROPERTY_CACHE, SessionUser.getUserIdStr() + comId, projects);
			
		}else{
			
			projects = (List<PropertyProject>) value;
			
		}
		
		return projects;
	}
	
	/**
	 * 获取公司列表
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private static List<Company> getCompanyList(){
		
		List<Company> comList = new ArrayList<Company>();
		
		Object value = CacheUtils.getValueByCacheNameAndKey(CacheFrontName.COMBOTREE_COMPANY_CACHE, SessionUser.getUserIdStr());
		if(value == null){
			
			comList = PermissionUtils.getUserCompanyList();
			
			CacheUtils.add(CacheFrontName.COMBOTREE_COMPANY_CACHE, SessionUser.getUserIdStr(), comList);
			
		}else{
			
			comList = (List<Company>) value;
		}
		
		return comList;
		
	}

}
