package com.ihk.utils.saleunitnew;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ihk.constanttype.EnumDevFlag;
import com.ihk.constanttype.EnumPrivCode;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.ihk.permission.PermissionUtils;
import com.ihk.property.data.pojo.PropertyArea;
import com.ihk.property.data.pojo.PropertyAreaCond;
import com.ihk.property.data.pojo.PropertyBuild;
import com.ihk.property.data.pojo.PropertyBuildCond;
import com.ihk.property.data.pojo.PropertyGroup;
import com.ihk.property.data.pojo.PropertyGroupCond;
import com.ihk.property.data.pojo.PropertyProject;
import com.ihk.property.data.pojo.PropertyProjectCond;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.SessionUser;
import com.ihk.utils.common.setup.RoleSetUpUtils;
import com.ihk.utils.saleunit.MyPropertyUtils;

/**
 * JSON工具类
 * 以前用手工拼接json的方法,不合适,以及一些实现有bug,放弃
 * 改用json包来实现
 * 另外有关左边导航tree的实现移到PropertyTreeUtils.java中
 * @author dtc
 * 2013-4-15,下午01:44:40
 */
public class JsonUtils {
	
	/**
	 * 销控中心楼盘权限控制
	 * 2012-10-16 修改 增加property_project 项目列 可以直接定位到 什么项目看到什么楼盘
	 * 直接修改SessionUser.getSessionUser().setProjectId(proid);这种方式不合适
	 * 该方法
	 * */
	public static List<PropertyProject> roleProlist(){
		PropertyProjectCond cond = new PropertyProjectCond();
		int proid = SessionUser.getProjectId();
		
		if(proid == 0 ){
			proid = PermissionUtils.getUserRoleListByUserIdAndRoleId(SessionUser.getUserId(),RoleSetUpUtils.getXkzxRoleId()).get(0).getProjectId();
			//SessionUser.getSessionUser().setProjectId(proid);
		}
		
		cond.setCompanyProjectId(proid);
		List<PropertyProject> proList = MyPropertyUtils.getPropertyProjectServices().findPropertyProject(cond);
		
		return proList;
	}
	
	public static List<PropertyProject> roleProlist(int proid){
		PropertyProjectCond cond = new PropertyProjectCond();
		
		if(proid == 0 ){
			proid = PermissionUtils.getUserRoleListByUserIdAndRoleId(SessionUser.getUserId(),RoleSetUpUtils.getXkzxRoleId()).get(0).getProjectId();
			//SessionUser.getSessionUser().setProjectId(proid);
		}
		
		cond.setCompanyProjectId(proid);
		List<PropertyProject> proList = MyPropertyUtils.getPropertyProjectServices().findPropertyProject(cond);
		
		return proList;
	}
	
	/**
	 * 获取所有的楼盘的json 名称格式
	 * @return
	 */
	public static String getJsonForAll(){
		
		List<PropertyProject> proList = roleProlist();
		List<PropertyArea> areaList = MyPropertyUtils.getPropertyAreaServices().findPropertyArea(new PropertyAreaCond());
		List<PropertyBuild> buildList = MyPropertyUtils.getPropertyBuildServices().findPropertyBuild(new PropertyBuildCond());
		
		return getJsonForAll(proList, areaList, buildList);
	}
	
	public static String getJsonForAll(String id,String type){//销控中心
		
		List<PropertyProject> proList =  roleProlist();
		List<PropertyArea> areaList = MyPropertyUtils.getPropertyAreaServices().findPropertyArea(new PropertyAreaCond());
		List<PropertyBuild> buildList = MyPropertyUtils.getPropertyBuildServices().findPropertyBuild(new PropertyBuildCond());
		List<PropertyGroup> gList = MyPropertyUtils.getPropertyGroupServices().findPropertyGroup(new PropertyGroupCond());
		
		return getJsonForAll(proList, areaList, buildList,gList,id,type);
	}
	
	/**
	 * 获取所有的楼盘的json 名称格式
	 * @return
	 */
	public static String getJsonForAll(String id){//楼盘建档
		
		List<PropertyProject> proList =  roleProlist();//
		//List<PropertyProject> proList = MyPropertyUtils.getPropertyProjectServices().findPropertyProject(new PropertyProjectCond());
		List<PropertyArea> areaList = MyPropertyUtils.getPropertyAreaServices().findPropertyArea(new PropertyAreaCond());
		List<PropertyBuild> buildList = MyPropertyUtils.getPropertyBuildServices().findPropertyBuild(new PropertyBuildCond());
		
		return getJsonForAll(proList, areaList, buildList,id);
	}
	
	/**
	 * 根据传进来的参数返回对应的json
	 * @param proList
	 * @param areaList
	 * @param buildList
	 * @return
	 */
	public static String getJsonForAll(List<PropertyProject> proList, List<PropertyArea> areaList, List<PropertyBuild> buildList){
		
		Map<Integer, Map<Integer, List<PropertyBuild>>> someMap = getMapForSome(proList, areaList, buildList);
		
		StringBuffer sb = new StringBuffer();
		
		Set<Integer> proKeys = someMap.keySet();
		StringBuffer proSb = null;
		
		for(Integer proKey : proKeys){
			
			proSb = new StringBuffer();
			proSb.append("{\"text\":\"").append((getProByListAndProId(proList, proKey)).getPropertyName())
				.append("\",\"state\":\"closed\",\"children\":["); //key转为项目名称
			
			Map<Integer, List<PropertyBuild>> proValMap = someMap.get(proKey);
			
			Set<Integer> areaKeys = proValMap.keySet();
			
			StringBuffer areaSb = new StringBuffer();
			for(Integer areaKey : areaKeys){
				
				areaSb.append("{\"text\":\"").append((getAreaByListAndAreaId(areaList, areaKey)).getAreaName())
					.append("\",\"state\":\"closed\",\"children\":["); //valKey转为分区名称
				
				StringBuffer buildSb = new StringBuffer();
				List<PropertyBuild> getBuildList = proValMap.get(areaKey);
				for(PropertyBuild build : getBuildList){
					
					buildSb.append("{\"id\":\"").append(build.getId()).append("\",")
						.append("\"text\":\"").append(build.getBuildName()).append("\",")
						.append("\"attributes\":{\"type\":\"endNode\"}")
						.append("},")
						;
					
				}
				
				String buildStr = buildSb.toString();
				buildStr = buildStr.substring(0, buildStr.length() - 1);
				
				areaSb.append(buildStr).append("]},");
				
			}
			
			String areaStr = areaSb.toString();
			areaStr = areaStr.substring(0, areaStr.length() - 1);
			
			proSb.append(areaStr).append("]},");
			
			sb.append(proSb);
		}
		
		String sbStr = sb.toString();
		sbStr = sbStr.substring(0, sbStr.length() - 1);
		
		return "[" + sbStr + "]";
		
	}
	
	/**
	 * 销控中心 
	 * 楼盘+组团
	 * */
	public static String getJsonForAll(List<PropertyProject> proList, List<PropertyArea> areaList, List<PropertyBuild> buildList,
			List<PropertyGroup> grlist,String id,String type){
		
		if(id == null) {
			return getGroupJsonByNullid(proList);//project 
		}
		
		if(type.equals("p"))return getGroupJsonByPid(Integer.parseInt(id),areaList,grlist);//area
		
		if(type.equals("a"))return getGroupJsonByAid(Integer.parseInt(id),buildList,grlist);//build
		
		return null;
	}
	
	
	/**
	 * 楼盘建档用 tree
	 * */
	@SuppressWarnings("unused")
	@Deprecated
	public static String getJsonForAll(List<PropertyProject> proList, List<PropertyArea> areaList, List<PropertyBuild> buildList,String id){
		//type暂时没有使用 只是作为区分
		if(id == null || id.equals("")) return getJsonByNullid(proList);//project 
		String ty = id.substring(0,1);
		String tyid=id.substring(1);
		
	//	if(ty.equals("p"))return getJosonByPid(Integer.parseInt(tyid),areaList);//area
		
	//	if(ty.equals("a"))return getJosonByAid(Integer.parseInt(tyid),buildList);//build
		
		return null;
		
	}
	
	
	public static String getIntJsonFromMap(Map<Integer, Map<Integer, List<PropertyBuild>>> map){
		
		StringBuffer sb = new StringBuffer();
		
		Set<Integer> keys = map.keySet();
		StringBuffer proSb = null;
		
		for(Integer key : keys){
			
			proSb = new StringBuffer();
			proSb.append("{\"text\":\"").append(key).append("\",\"state\":\"closed\",\"children\":["); //key转为项目名称
			
			Map<Integer, List<PropertyBuild>> valMap = map.get(key);
			
			Set<Integer> valKeys = valMap.keySet();
			
			for(Integer valKey : valKeys){
				
				StringBuffer areaSb = new StringBuffer();
				areaSb.append("{\"text\":\"").append(valKey).append("\",\"state\":\"closed\",\"children\":["); //valKey转为楼栋名称
				
				StringBuffer buildSb = new StringBuffer();
				List<PropertyBuild> buildList = valMap.get(valKey);
				for(PropertyBuild build : buildList){
					
					buildSb.append("{\"id\":\"").append(build.getId()).append("\",")
						.append("\"text\":\"").append(build.getBuildName()).append("\",")
						.append("\"attributes\":{\"type\":\"endNode\"}")
						.append("},")
						;
					
				}
				
				String buildStr = buildSb.toString();
				buildStr = buildStr.substring(0, buildStr.length() - 1);
				
				areaSb.append(buildStr).append("]},");
				
				String areaStr = areaSb.toString();
				areaStr = areaStr.substring(0, areaStr.length() - 1);
				
				proSb.append(areaStr);
				proSb.append("]");
				
			}
			
			proSb.append("},");
			
			sb.append(proSb);
		}
		
		String sbStr = sb.toString();
		sbStr = sbStr.substring(0, sbStr.length() - 1);
		
		return "[" + sbStr + "]";
	}
	
	public static Map<Integer, Map<Integer, List<PropertyBuild>>> 
		getMapForSome(List<PropertyProject> proList, List<PropertyArea> areaList, List<PropertyBuild> buildList){
		
		Map<Integer, Map<Integer, List<PropertyBuild>>> jsonMapInt = new HashMap<Integer, Map<Integer,List<PropertyBuild>>>();
		//Map<projectId, Map<areaId, List<PropertyBuild>>> 
		
		for(PropertyProject pro : proList){
			
			int proId = pro.getId();
			List<PropertyArea> getAreaList = getAreaByProId(areaList, proId); //一个项目对应的所有分区
			
			if(CommonUtils.isCollectionEmpty(getAreaList))
				continue; //如果项目对应的分区为空就不加进来
			
			Map<Integer, List<PropertyBuild>> areaForBuild = new HashMap<Integer, List<PropertyBuild>>();
			for(PropertyArea area : getAreaList){
				
				int areaId = area.getId();
				List<PropertyBuild> getBuildList = getBuildByAreaId(buildList, areaId); //一个分区对应的所有楼栋
				
				areaForBuild.put(areaId, getBuildList);
				
			}
			
			if(areaForBuild.size() >= 1){
				//对应的楼栋有值才加到map中
				jsonMapInt.put(proId, areaForBuild);
			}
			
		}
		
		return jsonMapInt;
		
	}
	
	public static Map<Integer, Map<Integer, List<PropertyBuild>>> getMapForAll(){
		
		List<PropertyProject> proList = MyPropertyUtils.getPropertyProjectServices().findPropertyProject(new PropertyProjectCond());
		List<PropertyArea> areaList = MyPropertyUtils.getPropertyAreaServices().findPropertyArea(new PropertyAreaCond());
		List<PropertyBuild> buildList = MyPropertyUtils.getPropertyBuildServices().findPropertyBuild(new PropertyBuildCond());
		
		return getMapForSome(proList, areaList, buildList);
	}
	
	private static PropertyProject getProByListAndProId(List<PropertyProject> proList, int proId){
		
		PropertyProject retPro = new PropertyProject();
		
		for(PropertyProject pro : proList){
			
			int getProId = pro.getId();
			if(proId == getProId){
				
				retPro = pro;
				break;
			}
		}
		
		return retPro;
		
	}
	
	private static PropertyArea getAreaByListAndAreaId(List<PropertyArea> areaList, int areaId){
		
		PropertyArea retArea = new PropertyArea();
		
		for(PropertyArea area : areaList){
			
			int getAreaId = area.getId();
			if(areaId == getAreaId){
				
				retArea = area;
				break;
				
			}
		}
		
		return retArea;
	}
	
	private static List<PropertyArea> getAreaByProId(List<PropertyArea> areaList, int proId){
		
		List<PropertyArea> retList = new ArrayList<PropertyArea>();
		
		for(PropertyArea area : areaList){
			
			int getProId = area.getPropertyId();
			if(getProId == proId){
				retList.add(area);
			}
		}
		
		return retList;
	}

	private static List<PropertyBuild> getBuildByAreaId(List<PropertyBuild> buildList, int areaId){
		
		List<PropertyBuild> retList = new ArrayList<PropertyBuild>();
		
		for(PropertyBuild build : buildList){
			
			int getAreaId = build.getAreaId();
			if(getAreaId == areaId){
				
				retList.add(build);
			}
		}
		
		return retList;
	}
	
	
	public static String getJsonByNullid(List<PropertyProject> pist){//建档页面TREE 根
		String sbStr = "";
		
		for(PropertyProject pr: pist){
			
			String bbb  = "{\"id\":\"p"+pr.getId()+"\",\"text\":\"" +
			"<span type=add_area   class='add_some tree-add-some'  sid="+pr.getId()+" title=新建分区 ></span>" +
			"<a type=rename_project   class='re_some tree-rename-some' sid="+pr.getId()+" title=修改楼盘名称></a>"+
					"<span class=text_title_cl>"+pr.getPropertyName()+"</span>\",\"state\":\"closed\"," +
							"\"attributes\":{\"type\":\"pro\",\"proId\":\""+pr.getId()+"\",\"valId\":\""+pr.getId()+"\"}},";
			sbStr += bbb;
		}
		if(!CommonUtils.isStrEmpty(sbStr)){
			sbStr = sbStr.substring(0, sbStr.length()-1);
		}
		return "[" + sbStr + "]";
	}
	
	/**
	 * 根据传入的PID areaList
	 * 返回joson
	 * */
    public static String getJsonByPid(List<PropertyArea> arealist){//建档页面 分区层
        String res = "";
        for(PropertyArea ar: arealist){
            String b = "{\"id\":\"a"+ar.getId()+"\",\"text\":\"";
            if (PermissionUtils.hasPermission(EnumPrivCode.SALEUNIT_INIT_UNITINFO, EnumDevFlag.GUANGZHOU)){
                b += "<span type=add_build   class='add_some tree-add-some'   sid="+ar.getId()+" title=新建楼栋></span>" ;
                b += "<span type=rename_area  class='re_some tree-rename-some'   sid="+ar.getId()+"  title=修改分区></span>";
            }
            b += "<span class=text_title_cl>"+ar.getAreaName()+"</span>\",\"state\":\"closed\"," ;
            b += "\"attributes\":{\"type\":\"area\",\"valId\":\""+ar.getId()+"\"}},";
            res += b;
        }
        if(!CommonUtils.isStrEmpty(res)){
            res = res.substring(0, res.length()-1);
        }
        return "["+res+"]";
    }

	/**
	 * 根据传入的Aid buildList
	 * 返回joson
	 * area点击事件
	 * */
	public static String getJsonByAid(List<PropertyBuild> bullist){//建档页面 楼栋层
		String sbStr = "";
		for(PropertyBuild ar: bullist){
			String b = "{\"id\":\"b"+ar.getId()+"\",\"text\":\""+
			"</span><span type=rename_build  class='re_some tree-rename-some'  sid="+ar.getId()+"  title=修改楼栋名称></span>"+
					"<span class=text_title_cl>"+ar.getBuildName()+"</span>\",\"state\":\"open\"," +
							"\"attributes\":{\"type\":\"endNode\",\"bid\":\""+ar.getId()+"\",\"valId\":\""+ar.getId()+"\"}},";
			sbStr += b;
		}
		
		if(!CommonUtils.isStrEmpty(sbStr)){
			sbStr = sbStr.substring(0, sbStr.length()-1);
		}
		return "[" + sbStr + "]";
	}
	
	private static String getGroupJsonByNullid(List<PropertyProject> pist){//销控页面 根 tree
		
		return PropertyTreeUtils.getJsonByProjectList(pist);
		
	}
	
	/**
	 * 根据传入的PID areaList groplist 返回json 分区和组团如何区分?
	 * 返回list
	 * */
	private static String getGroupJsonByPid(int Pid,List<PropertyArea> arelist,List<PropertyGroup> glist){//销控页面 area
		String res = "";
		for(PropertyArea ar: arelist){
			if(ar.getPropertyId() == Pid){
			String b = "{\"id\":\"a"+ar.getId()+"\",\"text\":\""+
					"<span class=text_title_cl>"+ar.getAreaName()+"</span>\",\"state\":\"closed\"," +
							"\"attributes\":{\"type\":\"area\",\"aid\":\""+ar.getId()+"\",\"valId\":\""+ar.getId()+"\"}},";
			res += b;
			}
		}
		for(PropertyGroup ar: glist){
			if(ar.getProjectId() == Pid && ar.getAreaId() ==0){
			String b = "{\"id\":\"a"+ar.getId()+"\",\"iconCls\":\"tree-group\",  \"text\":\""+
					"<span class=text_title_cl>"+ar.getGroupName()+"</span>\",\"state\":\"open\"," +
							"\"attributes\":{\"type\":\"endNodeGro\",\"gid\":\""+ar.getId()+"\",\"valId\":\""+ar.getId()+"\"}},";
			res += b;
			}
		}
		if(!CommonUtils.isStrEmpty(res)){
			res = res.substring(0, res.length()-1);
		}
		return "["+res+"]";
	}
	
	private static String getGroupJsonByAid(int aid,List<PropertyBuild> bullist,List<PropertyGroup> glist){//销控页面 bulid
		String sbStr = "";
		for(PropertyBuild ar: bullist){
			if(ar.getAreaId() == aid){
			String b = "{\"id\":\"b"+ar.getId()+"\",\"text\":\""+
					"<span class=text_title_cl>"+ar.getBuildName()+"</span>\",\"state\":\"open\"," +
							"\"attributes\":{\"type\":\"endNode\",\"bid\":\""+ar.getId()+"\",\"valId\":\""+ar.getId()+"\"}},";
			sbStr += b;
			}
		}
		for(PropertyGroup ar: glist){
			if(ar.getAreaId() == aid ){
			String b = "{\"id\":\"b"+ar.getId()+"\",\"text\":\""+
					"<span class=text_title_cl>"+ar.getId()+"</span>\",\"state\":\"open\"," +
							"\"attributes\":{\"type\":\"endNodeGro\",\"gid\":\""+ar.getId()+"\",\"valId\":\""+ar.getId()+"\"}},";
			sbStr += b;
			}
		}
		if(!CommonUtils.isStrEmpty(sbStr)){
			sbStr = sbStr.substring(0, sbStr.length()-1);
		}
		return "[" + sbStr + "]";
	}
	
	//下面的方法利用json包来实现

	/**
	 * 获取楼盘项目的json tree
	 * @param proList
	 * @return
	 */
	public static String getProjectListJson(List<PropertyProject> proList){
		
		if(CommonUtils.isCollectionEmpty(proList)){
			return "[]";
		}
		
		JSONArray arr = new JSONArray();
		JSONObject obj = null;
		
		for(PropertyProject pro : proList){
			
			obj = getOneTree("p", pro.getId()+"", pro.getPropertyName(), "", "closed", "p", "id");
			
			/*obj.put("id", "p" + pro.getId());
			obj.put("text", "<span class=text_title_cl>" + pro.getPropertyName() + "</span>");
			obj.put("state", "closed");
			
			JSONObject attr = new JSONObject();
			attr.put("type", "p");
			attr.put("id", pro.getId());
			attr.put("valId", pro.getId());
			obj.put("attributes", attr);*/
			
			arr.add(obj);
		}
		
		return arr.toString();
	}
	
	/**
	 * 获取分区及组团的json tree
	 * @param areaList
	 * @param groupList
	 * @return
	 */
	public static String getAreaAndGroupListJson(List<PropertyArea> areaList, List<PropertyGroup> groupList){
		
		JSONArray arr = new JSONArray();
		JSONObject obj = null;
		
		if(!CommonUtils.isCollectionEmpty(areaList)){
			
			for(PropertyArea area : areaList){
				
				obj = getOneTree("a", area.getId()+"", area.getAreaName(), "", "closed", "area", "aid");
				
				arr.add(obj);
			}
		}
		
		if(!CommonUtils.isCollectionEmpty(groupList)){
			
			for(PropertyGroup group : groupList){
				
				obj = getOneTree("a", group.getId()+"", group.getGroupName(), "tree-group", "open", "endNodeGro", "gid");
				
				arr.add(obj);
			}
		}
		
		return arr.toString();
	}
	
	/**
	 * 获取楼栋的json tree
	 * @param buildList
	 * @return
	 */
	public static String getBuildListJson(List<PropertyBuild> buildList){
		
		if(CommonUtils.isCollectionEmpty(buildList)){
			return "[]";
		}
		
		JSONArray arr = new JSONArray();
		JSONObject obj = null;
		
		for(PropertyBuild build : buildList){
			
			obj = getOneTree("b", build.getId()+"", build.getBuildName(), "", "open", "endNode", "bid");
			
			arr.add(obj);
		}
		
		return arr.toString();
	}
	
	/**
	 * 返回一个tree json
	 * @param idType, id类型
	 * @param id, id值
	 * @param text, 显示的text
	 * @param iconCls, 不为空就加上
	 * @param state, open或closed,默认为closed
	 * @param attrType, attributes对应的type值
	 * @param attrIdName, attributes要设置的id的key
	 * @return
	 */
	public static JSONObject getOneTree(String idType, String id, String text, String iconCls, 
			String state, String attrType, String attrIdName){
		
		JSONObject retObj = new JSONObject();
		
		retObj.put("id", idType + id);
		if(!CommonUtils.isStrEmpty(iconCls)){
			retObj.put("iconCls", iconCls);
		}
		retObj.put("text", "<span class=text_title_cl>" + text + "</span>");
		if(CommonUtils.isStrEmpty(state)){
			state = "closed";
		}
		retObj.put("state", state);
		
		JSONObject attr = new JSONObject();
		attr.put("type", attrType);
		attr.put(attrIdName, id);
		attr.put("valId", id);
		retObj.put("attributes", attr);
		
		return retObj;
		
	}
}

