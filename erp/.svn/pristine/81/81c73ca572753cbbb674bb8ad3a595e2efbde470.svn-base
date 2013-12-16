package com.ihk.utils.saleunitnew;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ihk.property.data.pojo.PropertyBuild;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.pojo.PropertyUnitCond;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.saleunit.BuildUnitUtils;
import com.ihk.utils.saleunit.MyPropertyUtils;

/**
 * 默认加载帮助类
 * @author dtc
 * 2012-8-22
 */
public class DefaultFromPropertyUtils {
	
	/**
	 * 多个管理界面默认加载的跳转,主要用于com.ihk.saleunit.action.new_financial.Layout的getDefaultFromProperty()
	 * @param request
	 * @return
	 */
	public static String getDefaultTo(HttpServletRequest request){
		
		String type = request.getParameter("type");
		
		if(CommonUtils.isStrEmpty(type)){
			
			return "getDefaultFromProperty";
		}
		
		return "getDefaultFromPropertyFor" + type; //type的首字母应该大写
	}
	
	/**
	 * 多个管理界面默认加载的tr初始化方法,主要用于com.ihk.saleunit.action.new_financial.Layout的getDefaultFromProperty()
	 * @param request
	 * @param unitList
	 * @param build
	 * @return
	 */
	public static List<String> getDefaultTrList(HttpServletRequest request, List<PropertyUnit> unitList, PropertyBuild build){
		
		String type = request.getParameter("type");
		
		if("Chip".equals(type)){
			
			return BuildUnitUtils.initUnitMapForChip(unitList, build);
		}
		
		if("Scene".equals(type)){
			
			return BuildUnitUtils.initUnitMapForScene(unitList, build);
			//return BuildUnitUtils.initUnitMap(unitList, build);
		}
		
		return BuildUnitUtils.initUnitMap(unitList, build);
	}
	
	
	
	/**
	 * 获取默认加载的楼栋
	 * @param propertyId
	 * @return
	 */
	public static PropertyBuild getDefaultBuild(int propertyId) throws Exception{
		
		List<PropertyBuild> buildList = MyPropertyUtils.getPropertyBuildServices().findPropertyBuildByPropertyId(propertyId);
		
		if(!CommonUtils.isCollectionEmpty(buildList)){
			
			return buildList.get(0);
		}
		
		return null;
	}
	
	/**
	 * 获取默认加载的楼栋
	 * 增加了TYPE 给有特殊需求的加载
	 * @param propertyId
	 * @return
	 */
	public static PropertyBuild getDefaultBuild(int propertyId, HttpServletRequest request) throws Exception{
		String type = request.getParameter("type");
		if(!"Chip".equals(type)){
			return getDefaultBuild(propertyId);
		}
		int proId = MyPropertyUtils.getPropertyProjectServices().findPropertyProjectById(propertyId).getCompanyProjectId();
		PropertyUnitCond  unitCond = new PropertyUnitCond();
		unitCond.setProjectId(proId);
		unitCond.setOrderByFiled("chip1");
		unitCond.topNum = 1;
		List<PropertyUnit> unitList = MyPropertyUtils.getPropertyUnitServices().findPropertyUnit(unitCond);
		if(unitList ==null||unitList.size()==0)return null;
		int bid = unitList.get(0).getBuildId();
		return MyPropertyUtils.getPropertyBuildServices().findPropertyBuildById(bid);
	}
	
	/**
	 * 获取选择楼栋,单元的显示名称
	 * <input type="hidden" id="hiddenBuildId" value="43"/>
	 * <span id="showContent">已选择==&gt;&nbsp;&nbsp;金域蓝湾,东区,1单元,
	 * <span id="unitValueId">A-5-1</span><input type="hidden" value="38" id="hiddenUnitId"/></span>
	 * @param unit
	 * @return
	 */
	public static String initShowContent(PropertyBuild build, PropertyUnit unit){
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("<input type=\"hidden\" id=\"hiddenBuildId\" ").append("value=\"").append(build.getId()).append("\"/>")
			.append("<span id=\"showContent\">已选择==&gt;&nbsp;&nbsp;")
			.append(build.getDescPropertyId()).append(",")
			.append(build.getAreaName()).append(",")
			.append(build.getBuildName());
		
		if(unit != null){
			sb.append(",<span id=\"unitValueId\">").append(unit.getUnitNo()).append("</span>")
				.append("<input type=\"hidden\" value=\"").append(unit.getId()).append("\" id=\"hiddenUnitId\"/>");
		}
			
		sb.append("</span>");
		
		return sb.toString();
	}

}
