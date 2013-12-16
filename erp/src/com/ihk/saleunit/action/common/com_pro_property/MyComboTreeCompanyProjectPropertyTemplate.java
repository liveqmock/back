package com.ihk.saleunit.action.common.com_pro_property;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.beanutils.PropertyUtils;

import com.ihk.constanttype.ContComProAreaBuildKey;
import com.ihk.permission.PermissionUtils;
import com.ihk.property.data.pojo.PropertyProject;
import com.ihk.property.data.pojo.PropertyProjectCond;
import com.ihk.user.data.pojo.Company;
import com.ihk.user.data.pojo.CompanyProject;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.saleunit.MyPropertyUtils;

/**
 * 公司-->公司项目-->楼盘项目(单选,多选)
 * @author dtc
 * 2013-11-19,下午03:38:27
 */
public class MyComboTreeCompanyProjectPropertyTemplate {
	
	/**
	 * 加载comboTree
	 * @param request
	 * @return
	 */
	public static String initComboTree(HttpServletRequest request){
		
		JSONObject retJson = new JSONObject(); //返回的json
		
		String typeId = request.getParameter("id");
		
		if(CommonUtils.isStrEmpty(typeId)){
			//初始加载,获取权限公司
			
			String isMultiple = request.getParameter("isMultiple"); //多选或单选
			
			retJson.put("id", "");
			if("false".equals(isMultiple)){
				retJson.put("text", CommonUtils.EMPTY);
			}else{
				retJson.put("text", CommonUtils.ALL);
			}
			
			List<Company> comList = PermissionUtils.getUserCompanyList(); //权限所能看到的公司
			
			Collections.sort(comList, new MyComparatorObjectForString("companyName")); //排序
			
			if(!CommonUtils.isCollectionEmpty(comList)){
				
				JSONArray array = new JSONArray();
				
				JSONObject comJson = null;
				
				for(Company com : comList){
					
					comJson = new JSONObject();
					
					comJson.put("id", ContComProAreaBuildKey.COM + "_" + com.getId());
					comJson.put("text", com.getCompanyName());
					comJson.put("state", "closed"); //easyui默认为open
					
					array.add(comJson);
				}
				
				retJson.put("children", array.toString());
				
			}
			
		}else{
			//点击获取
			
			JSONArray retArr = new JSONArray(); //返回json数组
			
			String[] typeAndId = typeId.split("_");
			
			String type = typeAndId[0];
			String id = typeAndId[1];
			
			int valId = Integer.parseInt(id);
			
			if(ContComProAreaBuildKey.COM.equals(type)){
				//公司-->公司项目
				
				List<CompanyProject> proList = PermissionUtils.getUserCompanyProjectByCompanyId(valId);
				
				Collections.sort(proList, new MyComparatorObjectForString("pinyin")); //排序
				
				if(!CommonUtils.isCollectionEmpty(proList)){
					
					for(CompanyProject project : proList){
						
						JSONObject comJson = new JSONObject();
						comJson.put("id", ContComProAreaBuildKey.COMPRO + "_" + project.getId());
						comJson.put("text", project.getProjectName());
						comJson.put("state", "closed"); //easyui默认为open
						
						retArr.add(comJson);
						
					}
				}
				
				return retArr.toString();
				
			}else if(ContComProAreaBuildKey.COMPRO.equals(type)){
				//公司项目-->楼盘项目
				
				PropertyProjectCond cond = new PropertyProjectCond();
				cond.setCompanyProjectId(valId);
				
				List<PropertyProject> proList = MyPropertyUtils.getPropertyProjectServices().findPropertyProject(cond);
				
				Collections.sort(proList, new MyComparatorObjectForString("propertyName")); //排序
				
				if(!CommonUtils.isCollectionEmpty(proList)){
					
					for(PropertyProject project : proList){
						
						JSONObject comJson = new JSONObject();
						comJson.put("id", project.getId());
						comJson.put("text", project.getPropertyName());
						//comJson.put("state", "closed"); //easyui默认为open
						
						retArr.add(comJson);
					}
				}
				
				return retArr.toString();
			}
				
		}
		
		return "[" + retJson.toString() + "]";
	}
	
}

class MyComparatorObjectForString implements Comparator<Object>{
	
	/**
	 * 要比较的字段
	 */
	private String field;
	
	public void setField(String field) {
		this.field = field;
	}
	
	public String getField() {
		return field;
	}
	
	public MyComparatorObjectForString() {
	}
	
	public MyComparatorObjectForString(String field){
		this.field = field;
	}

	@Override
	public int compare(Object o1, Object o2) {
		
		if(CommonUtils.isStrEmpty(field)){
			
			return 0;
		}
		
		try {
			
			String val1 = PropertyUtils.getProperty(o1, field).toString();
			String val2 = PropertyUtils.getProperty(o2, field).toString();
			
			return val1.compareTo(val2);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return 0;
	}


	
}
