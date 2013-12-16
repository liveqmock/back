package com.ihk.utils.saleunitnew;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ihk.constanttype.EnumSelectTypeSessionKey;
import com.ihk.property.data.pojo.PropertyArea;
import com.ihk.property.data.pojo.PropertyAreaCond;
import com.ihk.property.data.pojo.PropertyBuild;
import com.ihk.property.data.pojo.PropertyGroup;
import com.ihk.property.data.pojo.PropertyProject;
import com.ihk.property.data.pojo.PropertyProjectCond;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.saleunit.MyPropertyUtils;

/**
 * 楼盘,分区,楼栋,左边导航树的帮助类
 * @author dtc
 * 2012-10-29,下午02:50:01
 */
public class PropertyTreeUtils {
	
	private static final Logger logger = Logger.getLogger(PropertyTreeUtils.class); 
	
	/**
	 * 默认只获取权限楼盘的json
	 * @return
	 */
	public static String getRoleProjectJson(){
		
		return getRoleProjectJson(false);
	}
	
	/**
	 * 是否只是获取权限楼盘的json
	 * @return
	 */
	public static String getRoleProjectJson(boolean isOnlyProject){
		
		List<PropertyProject> roleProjectList = JsonUtils.roleProlist();
		
		if(isOnlyProject){
			
			return getOnlyProjectJsonByProjectList(roleProjectList);
		}
		
		return getJsonByProjectList(roleProjectList);
		
	}
	
	/**
	 * 根据传进去的权限楼盘获取对应的json,可以获取分区,楼栋等
	 * @param roleProjectList
	 * @return
	 */
	public static String getJsonByProjectList(List<PropertyProject> projectList){
		
		if(CommonUtils.isCollectionEmpty(projectList)){
			
			return "[]";
		}
		
		StringBuffer sb = new StringBuffer();
		
		for(PropertyProject pro : projectList){
			
			sb.append("{\"id\":\"p").append(pro.getId()).append("\",\"text\":\"")
				.append("<span class=text_title_cl>").append(pro.getPropertyName()).append("</span>\"")
				.append(",\"state\":\"closed\",\"attributes\":{\"type\":\"p\",\"id\":\"")
				.append(pro.getId()).append("\",\"valId\":\"").append(pro.getId()).append("\"}},")
				;
		}
		
		String out = sb.toString();
		out = CommonUtils.removeLastChar(out);
		
		return "[" + out + "]";
	}
	
	/**
	 * 只获取楼盘项目
	 * @param projectList
	 * @return
	 */
	public static String getOnlyProjectJsonByProjectList(List<PropertyProject> projectList){
		
		if(CommonUtils.isCollectionEmpty(projectList)){
			
			return "[]";
		}
		
		StringBuffer sb = new StringBuffer();
		
		for(PropertyProject pro : projectList){
			
			sb.append("{\"id\":\"p").append(pro.getId()).append("\",\"text\":\"")
				.append("<span class=text_title_cl>").append(pro.getPropertyName()).append("</span>\"")
				.append(",\"state\":\"open\",\"attributes\":{\"type\":\"p\",\"id\":\"")
				.append(pro.getId()).append("\",\"valId\":\"").append(pro.getId()).append("\"}},")
				;
		}
		
		String out = sb.toString();
		out = CommonUtils.removeLastChar(out);
		
		return "[" + out + "]";
	}
	
	/**
	 * 项目,分区,楼栋,共用导航树
	 * @param type: p, a
	 * @param typeId
	 * @return
	 */
	public static String getLayoutLeftTree(String type, String typeId){
		
		if(CommonUtils.isStrEmpty(typeId)){
			//获取对应的楼盘项目
			
			List<PropertyProject> proList = JsonUtils.roleProlist();
			
			return JsonUtils.getProjectListJson(proList); 
			
		}
		
		if("p".equals(type)){
			//获取对应的分区及组团
			int projectId = Integer.parseInt(typeId);
			
			PropertyAreaCond cond = new PropertyAreaCond();
			cond.setPropertyId(projectId);
			
			List<PropertyArea> areaList = MyPropertyUtils.getPropertyAreaServices().findPropertyArea(cond);
			
			List<PropertyGroup> groupList = MyPropertyUtils.getPropertyGroupServices().findPropertyGroupByProjectId(projectId);
			
			return JsonUtils.getAreaAndGroupListJson(areaList, groupList);
			
		}
		
		if("a".equals(type)){
			//获取对应的楼栋
			int areaId = Integer.parseInt(typeId);
			
			List<PropertyBuild> buildList = MyPropertyUtils.getPropertyBuildServices().findPropertyBuildByAreaId(areaId);
			
			return JsonUtils.getBuildListJson(buildList);
			
		}
		
		return "[]";
	}
	
	/**
	 * 楼盘初始用
	 * */
	public static String getLayoutLeftTree1(String type, String typeId){
		
		if(CommonUtils.isStrEmpty(typeId)){
			//获取对应的楼盘项目
			
			List<PropertyProject> proList = JsonUtils.roleProlist();
			
			return JsonUtils.getJsonByNullid(proList); 
			
		}
		
		if("p".equals(type)){
			//获取对应的分区及组团
			int projectId = Integer.parseInt(typeId);
			
			PropertyAreaCond cond = new PropertyAreaCond();
			cond.setPropertyId(projectId);
			
			List<PropertyArea> areaList = MyPropertyUtils.getPropertyAreaServices().findPropertyArea(cond);
			
			return JsonUtils.getJsonByPid(areaList);
			
		}
		
		if("a".equals(type)){
			//获取对应的楼栋
			int areaId = Integer.parseInt(typeId);
			
			List<PropertyBuild> buildList = MyPropertyUtils.getPropertyBuildServices().findPropertyBuildByAreaId(areaId);
			
			return JsonUtils.getJsonByAid(buildList);
			
		}
		
		return "[]";
	}
	
	/**
	 * 根据类型,类型id及选中的公司项目id,获取对应的楼盘项目,分区,楼栋的导航树
	 * @param type
	 * @param typeId
	 * @param selectProId
	 * @return
	 */
	public static String getLayoutLeftTreeByTypeAndSelectProId(String type, String typeId, HttpServletRequest request){
		
		int selectProId = getLeftTreeProjectIdSession(request);
		
		if(selectProId == 0){
			
			return getLayoutLeftTree(type, typeId);
		}
		
		if(CommonUtils.isStrEmpty(typeId)){
			//获取对应的楼盘项目
			
			List<PropertyProject> proList = getRoleProlistBySelectProId(selectProId);
			
			return JsonUtils.getProjectListJson(proList); 
			
		}
		
		if("p".equals(type)){
			//获取对应的分区及组团
			int projectId = Integer.parseInt(typeId);
			
			PropertyAreaCond cond = new PropertyAreaCond();
			cond.setPropertyId(projectId);
			
			List<PropertyArea> areaList = MyPropertyUtils.getPropertyAreaServices().findPropertyArea(cond);
			
			List<PropertyGroup> groupList = MyPropertyUtils.getPropertyGroupServices().findPropertyGroupByProjectId(projectId);
			
			return JsonUtils.getAreaAndGroupListJson(areaList, groupList);
			
		}
		
		if("a".equals(type)){
			//获取对应的楼栋
			int areaId = Integer.parseInt(typeId);
			
			List<PropertyBuild> buildList = MyPropertyUtils.getPropertyBuildServices().findPropertyBuildByAreaId(areaId);
			
			return JsonUtils.getBuildListJson(buildList);
			
		}
		
		return "[]";
	}
	
	/**
	 * 根据类型,类型id及选中的公司项目id,获取对应的楼盘项目,分区,楼栋的导航树
	 * 没有组团
	 * @param type
	 * @param typeId
	 * @param request
	 * @return
	 */
	public static String getLayoutLeftTreeNoGroupByTypeAndSelectProId(String type, String typeId, HttpServletRequest request){
		
		int selectProId = getLeftTreeProjectIdSession(request);
		
		if(selectProId == 0){
			
			return getLayoutLeftTree1(type, typeId);
		}
		
		if(CommonUtils.isStrEmpty(typeId)){
			//获取对应的楼盘项目
			
			List<PropertyProject> proList = getRoleProlistBySelectProId(selectProId);
			
			return JsonUtils.getJsonByNullid(proList); 
			
		}
		
		if("p".equals(type)){
			//获取对应的分区及组团
			int projectId = Integer.parseInt(typeId);
			
			PropertyAreaCond cond = new PropertyAreaCond();
			cond.setPropertyId(projectId);
			
			List<PropertyArea> areaList = MyPropertyUtils.getPropertyAreaServices().findPropertyArea(cond);
			
			return JsonUtils.getJsonByPid(areaList);
			
		}
		
		if("a".equals(type)){
			//获取对应的楼栋
			int areaId = Integer.parseInt(typeId);
			
			List<PropertyBuild> buildList = MyPropertyUtils.getPropertyBuildServices().findPropertyBuildByAreaId(areaId);
			
			return JsonUtils.getJsonByAid(buildList);
			
		}
		
		return "[]";
	}
	
	/**
	 * 获取左边导航树,只是公司项目下对应的楼盘项目
	 * @param request
	 * @return
	 */
	public static String getLayoutLeftTreeOnlyPropertyProjectBySelectProId(HttpServletRequest request){
		
		List<PropertyProject> projectList = new ArrayList<PropertyProject>();
		
		int selectProId = getLeftTreeProjectIdSession(request);
		
		if(selectProId == 0){
			
			projectList = JsonUtils.roleProlist();
		}else{
			
			projectList = getRoleProlistBySelectProId(selectProId);
		}
		
		return getOnlyProjectJsonByProjectList(projectList);
	}
	
	/**
	 * 根据选中的公司项目id获取对应销控中心楼盘权限的楼盘项目
	 * @param selectProId
	 * @return
	 */
	private static List<PropertyProject> getRoleProlistBySelectProId(int selectProId){
		
		PropertyProjectCond cond = new PropertyProjectCond();
		
		cond.setCompanyProjectId(selectProId);
		
		List<PropertyProject> proList = MyPropertyUtils.getPropertyProjectServices().findPropertyProject(cond);
		
		return proList;
	}
	
	/**
	 * 根据selectType设置左边导航树对应的项目session id
	 * @param request
	 */
	public static void setLeftTreeProjectIdSession(HttpServletRequest request, int selectProId){
		
		HttpSession session = request.getSession();
		
		session.setAttribute(getSelectTypeSessionKey(request), selectProId);	
	}
	
	/**
	 * 根据selectType获取左边导航树对应的项目session id
	 * @param request
	 * @return
	 */
	public static int getLeftTreeProjectIdSession(HttpServletRequest request){
		
		Object obj = null;
		
		HttpSession session = request.getSession();
		
		obj = session.getAttribute(getSelectTypeSessionKey(request));
		
		if(obj != null){
			return (Integer) obj;
		}
		
		return 0;
	}
	
	/**
	 * 获取选中的公司项目的session key,也可以直接用请求参数selectType作为key
	 * 但避免跟别的地方相同,所以调用该方法
	 * 如果selectType不对就抛出异常
	 * @param request
	 * @return
	 */
	private static String getSelectTypeSessionKey(HttpServletRequest request){
		
		String selectType = request.getParameter("selectType");
		
		if(isSelectTypeSessionKey(selectType)){
			//楼盘初始,付款方式,组团管理,认筹管理,现场销控情况,销售中心
			
			return selectType;
		}
		
		logger.error("请求公司项目的session key类型不符合");
		
		throw new RuntimeException("请求公司项目的session key类型不符合");
	}
	
	/**
	 * 判断该key是否为合法的session key
	 * @param key
	 * @return
	 */
	public static boolean isSelectTypeSessionKey(String key){
		
		boolean isKey = false;
		
		EnumSelectTypeSessionKey[] values = EnumSelectTypeSessionKey.values();
		
		for(EnumSelectTypeSessionKey value : values){
			
			if(value.toString().equals(key)){
				
				isKey = true;
				break;
			}
		}
		
		return isKey;
	}
	
}
