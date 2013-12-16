package com.ihk.saleunit.action.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.ihk.user.data.pojo.Company;
import com.ihk.user.data.pojo.CompanyProject;
import com.ihk.utils.CacheFrontName;
import com.ihk.utils.CacheUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.SessionUser;
import com.ihk.utils.company.project.CompanyProjectUtils;
import com.ihk.utils.saleunit.MyPropertyUtils;

/**
 * 公司项目的combotree模板
 * @author dtc
 * 2013-6-7,上午09:11:38
 */
public abstract class MyComboTreeCompanyProjectTemplate {
	
	/**
	 * 设置页面显示的ComboTree
	 * @param request
	 * @param cacheKey+userId做为缓存的key,
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String initComboTree(HttpServletRequest request, String cacheKey){
		
		//如果返回false表示为单选,否则为多选
		String isMultiple = request.getParameter("isMultiple");
		
		JSONObject retJson = new JSONObject();
		retJson.put("id", "");
		if("false".equals(isMultiple)){
			retJson.put("text", CommonUtils.EMPTY);
		}else{
			retJson.put("text", CommonUtils.ALL);
		}
		
		List<CompanyProject> projects = null;
		String key = SessionUser.getUserIdStr() + cacheKey;
		
		Object value = CacheUtils.getValueByCacheNameAndKey(CacheFrontName.COMBOTREE_CACHE, key);
		if(value == null){
			
			projects = doExecuteCallback();
			
			CacheUtils.add(CacheFrontName.COMBOTREE_CACHE, key, projects);
			
		}else{
			
			projects = (List<CompanyProject>) value;
			
		}
		
		//List<CompanyProject> projects = doExecuteCallback();
		
		if(!CommonUtils.isCollectionEmpty(projects)){
			
			List<String> idList = new ArrayList<String>();
			
			String projectId = request.getParameter("projectId");
			if(!CommonUtils.isStrZeroEmpty(projectId)){
				String[] ids = projectId.split(",");
				for(String id : ids){
					idList.add(id);
				}
			}
			
			JSONArray comArr = new JSONArray(); //公司json数组
			
			Set<Integer> comIdSet = new HashSet<Integer>(); //所有的公司
			
			for(CompanyProject pro : projects){
				
				int comId = pro.getCompanyId();
				if(!comIdSet.contains(comId)){
					comIdSet.add(comId);
				}
			}
			
			for(int comId : comIdSet){
				
				Company company = MyPropertyUtils.getCompanyServices().findCompanyById(comId);
				List<CompanyProject> proList = CompanyProjectUtils.getProjectListByCompanyId(projects, comId);
				
				JSONObject comJson = new JSONObject();
				comJson.put("id", "com_" + company.getId());
				comJson.put("text", company.getCompanyName());
				comJson.put("state", getNodeState(proList, projectId, request)); //easyui默认为open
				comJson.put("children", getProjectListJson(proList, idList));
				
				comArr.add(comJson);

			}
			
			retJson.put("children", comArr.toString());
			
		}
		
		return "[" + retJson.toString() + "]";
	}
	
	/**
	 * 实际返回的项目list(根据权限来获取),增加缓存,key为其user_account id
	 * @return
	 */
	public abstract List<CompanyProject> doExecuteCallback();
	
	/**
	 * 返回单选节点是否伸开(closed表示多选,open表示单选)
	 * @param projects
	 * @param projectId
	 * @param request
	 * @return
	 */
	private String getNodeState(List<CompanyProject> projects, String projectId, HttpServletRequest request){
		
		String ret = "closed";
		
		String isMultiple = request.getParameter("isMultiple");
		
		if("false".equals(isMultiple)){
			//表示为单选
			if(!CommonUtils.isCollectionEmpty(projects)){
				
				for(CompanyProject pro : projects){
					
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
	private String getProjectListJson(List<CompanyProject> projects, List<String> idList){
		
		JSONArray arr = new JSONArray();
		
		if(!CommonUtils.isCollectionEmpty(projects)){
			
			//先按拼音排序
			Collections.sort(projects, new CompanyProjectComparator());
			
			JSONObject json = null;
			for(CompanyProject pro : projects){
				
				json = new JSONObject();
				
				String id = pro.getId() + "";
				json.put("id", id);
				json.put("text", pro.getProjectName());
				
				json.put("attributes", "{'companyId':" + pro.getCompanyId() + "}");
				
				//"\"attributes\":{\"type\":\"endNode\"}")
				
				//if(idList.contains(id)){
					//json.put("checked", true);
				//}
				
				arr.add(json);
			}
		}
		
		return arr.toString();
	}
	
	class CompanyProjectComparator implements Comparator<CompanyProject>{

		@Override
		public int compare(CompanyProject o1, CompanyProject o2) {
			
			if(o1 == null || o2 == null){
				
				return 0;
			}
			
			if(o1.getPinyin() == null || o2.getPinyin() == null){
				
				return 0;
			}
			
			return o1.getPinyin().compareToIgnoreCase(o2.getPinyin());
		}
	}
	
}
