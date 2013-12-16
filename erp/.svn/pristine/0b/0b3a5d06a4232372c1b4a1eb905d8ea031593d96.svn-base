package com.ihk.utils.projecttext;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.ihk.setting.data.pojo.ProjectText;
import com.ihk.setting.data.pojo.ProjectTextCond;
import com.ihk.setting.data.services.IProjectTextServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.SessionUser;

/**
 * 自定义下拉框的帮助类,对应表project_text
 * @author dtc
 * 2012-8-9
 */
public class ProjectTextUtils {
	
	/**
	 * 弹出新增框的标示值
	 */
	public static final String ADD_NEW_VALUE_LIMIT = "__limit__"; //弹出新增框的标示值
	/**
	 * 弹出新增框的标示文本
	 */
	public static final String ADD_NEW_TEXT_LIMIT = "(管理)"; //弹出新增框的标示文本
	
	/**
	 * 选择下拉框的value, valueField
	 */
	public static final String PROJECT_TEXT_VALUE = "projectTextValue"; //选择下拉框的value, valueField
	/**
	 * 选择下拉框的text, textField
	 */
	public static final String PROJECT_TEXT_TEXT = "projectTextText"; //选择下拉框的text, textField
	
	/**
	 * datagrid 的隐藏id
	 */
	public static final String DATA_GRID_FIELD_ID = "id"; //datagrid 的隐藏id
	/**
	 * datagrid 的值
	 */
	public static final String DATA_GRID_FIELD_CODE = "code"; //datagrid 的值
	
	private static IProjectTextServices projectTextServices;
	
	public void setProjectTextServices(IProjectTextServices projectTextServices) {
		ProjectTextUtils.projectTextServices = projectTextServices;
	}
	
	public static IProjectTextServices getProjectTextServices() {
		return projectTextServices;
	}
	
	/**
	 * 根据typeName获取对应的project_text
	 * @param typeName
	 * @return
	 */
	public static List<ProjectText> getProjectTextListByTypeName(String typeName){
		
		if(CommonUtils.isStrEmpty(typeName))
			return new ArrayList<ProjectText>();
		
		ProjectTextCond cond = new ProjectTextCond();
		int projectId = SessionUser.getProjectId(); //
		cond.setProjectId(projectId + "");
		cond.setTypeName(typeName);
		
		List<ProjectText> projectTextList = projectTextServices.findProjectText(cond);
		
		return projectTextList;
	}
	
	/**
	 * 根据request获取对应的project_text
	 * @param request
	 * @return
	 */
	public static List<ProjectText> getProjectTextListByRequest(HttpServletRequest request){
		
		String typeName = request.getParameter("typeName");
		String textType = request.getParameter("textType");
		String mainId = request.getParameter("mainId");
		
		List<ProjectText> projectTextList = null;
		
		if(CommonUtils.isStrZeroJsEmpty(textType) || CommonUtils.isStrZeroJsEmpty(mainId)){
			
			projectTextList = getProjectTextListByTypeName(typeName);
		}else{
			
			projectTextList = getProjectTextListByTypeNameAndTextTypeAndMainId(typeName, Integer.parseInt(textType), Integer.parseInt(mainId));
		}
		
		return projectTextList;
	}
	
	/**
	 * 根据typeName,textType,mainId获取对应的project_text
	 * @param typeName
	 * @param textType
	 * @param mainId
	 * @return
	 */
	public static List<ProjectText> getProjectTextListByTypeNameAndTextTypeAndMainId(String typeName, int textType, int mainId){
		
		if(CommonUtils.isStrEmpty(typeName))
			return new ArrayList<ProjectText>();
		
		ProjectTextCond cond = new ProjectTextCond();
		cond.setTypeName(typeName);
		cond.setTextType(textType);
		cond.setMainId(mainId);
		
		List<ProjectText> projectTextList = projectTextServices.findProjectText(cond);
		
		return projectTextList;
	}
	
	/**
	 * 根据typeName获取对应的project_text的map格式,(主要供自定义下拉框使用)
	 * @param typeName
	 * @return
	 */
	public static Map<String, String> getProjectTextForMapByTypeName(String typeName){
		
		List<ProjectText> textList = getProjectTextListByTypeName(typeName);
		
		if(!CommonUtils.isCollectionEmpty(textList)){
			
			Map<String, String> retMap = new LinkedHashMap<String, String>();
			
			retMap.put("", CommonUtils.EMPTY);
			for(ProjectText text : textList){
				
				retMap.put(text.getCodeDesc(), text.getCodeDesc());
			}
			
			return retMap;
		}
		
		return null;
	}
	
	/**
	 * 根据String list获取对应的下拉框,主要用于"收款类别","收款内容"
	 * @param stringList
	 * @return
	 */
	public static String getComboBoxContextByStringList(List<String> stringList){
		
		if(CommonUtils.isCollectionEmpty(stringList)){
			
			return getComboBoxContextByProjectTextList(null);
		}
		
		List<ProjectText> projectTextList = new ArrayList<ProjectText>();
		ProjectText text = null;
		
		for(String str : stringList){
			
			text = new ProjectText();
			text.setCodeDesc(str);
			
			projectTextList.add(text);
			
		}
		
		return getComboBoxContextByProjectTextList(projectTextList, false);
	}
	
	/**
	 * 获取下拉框的json,并判断是否加入"管理"的增加链接,默认为增加
	 * @param projectTextList
	 * @param isAddNew
	 * @return
	 */
	public static String getComboBoxContextByProjectTextList(List<ProjectText> projectTextList, boolean isAddNew){
		
		Map<String, String> map = new LinkedHashMap<String, String>();
		
		map.put("", CommonUtils.EMPTY);
		
		if(!CommonUtils.isCollectionEmpty(projectTextList)){
			
			for(ProjectText text : projectTextList){
				
				map.put(text.getCodeDesc(), text.getCodeDesc());
			}
		}
		
		if(isAddNew){
			map.put(ADD_NEW_VALUE_LIMIT, ADD_NEW_TEXT_LIMIT);
		}
		
		String ret = CommonUtils.getMapJsonSetUpKeyAndValueName(map, PROJECT_TEXT_VALUE, PROJECT_TEXT_TEXT);
		
		/**
		 * String out = "[{\"projectTextValue\":\"\",\"projectTextText\":\"请选择\",\"selected\":\"true\"}," +
			"{\"projectTextValue\":\"1\",\"projectTextText\":\"Java\"},{\"projectTextValue\":\"__limit__\",\"projectTextText\":\"(管理)\"}]";
		 */
		
		return ret;
		
	}
	
	/**
	 * 获取下拉框的json
	 * @param projectTextList
	 * @return
	 */
	public static String getComboBoxContextByProjectTextList(List<ProjectText> projectTextList){
		
		return getComboBoxContextByProjectTextList(projectTextList, true);
	}
	
	/**
	 * 设置defaultValue为默认选中的值
	 * @param projectTextList
	 * @param defaultValue
	 * @return
	 */
	public static String getComboBoxContextByProjectTextList(List<ProjectText> projectTextList, String defaultValue){
		
		if(CommonUtils.isStrEmpty(defaultValue))
			return getComboBoxContextByProjectTextList(projectTextList);
		
		JSONArray arr = new JSONArray();
		
		JSONObject obj = new JSONObject();
		obj.put(PROJECT_TEXT_VALUE, "");
		obj.put(PROJECT_TEXT_TEXT, CommonUtils.EMPTY);
		arr.add(obj);
		
		if(!CommonUtils.isCollectionEmpty(projectTextList)){
			
			for(ProjectText text : projectTextList){
				
				obj = new JSONObject();
				
				String codeDesc = text.getCodeDesc();
				
				obj.put(PROJECT_TEXT_VALUE, codeDesc);
				obj.put(PROJECT_TEXT_TEXT, codeDesc);
				
				if(defaultValue.equals(codeDesc)){
					
					obj.put("selected", "true");
				}
				
				arr.add(obj);
				
			}
			
		}
		
		obj = new JSONObject();
		obj.put(PROJECT_TEXT_VALUE, ADD_NEW_VALUE_LIMIT);
		obj.put(PROJECT_TEXT_TEXT, ADD_NEW_TEXT_LIMIT);
		arr.add(obj);
		
		return arr.toString();
		
		/**
		 * String out = "[{\"projectTextValue\":\"\",\"projectTextText\":\"请选择\",\"selected\":\"true\"}," +
			"{\"projectTextValue\":\"1\",\"projectTextText\":\"Java\"},{\"projectTextValue\":\"__limit__\",\"projectTextText\":\"(管理)\"}]";
		 */
		
		/*
		Map<String, String> map = new LinkedHashMap<String, String>();
		
		map.put("", CommonUtils.EMPTY);
		
		if(!CommonUtils.isCollectionEmpty(projectTextList)){
			
			for(ProjectText text : projectTextList){
				
				map.put(text.getCodeDesc(), text.getCodeDesc());
			}
		}
		
		map.put(ADD_NEW_VALUE_LIMIT, ADD_NEW_TEXT_LIMIT);
		
		String ret = CommonUtils.getMapJsonSetUpKeyAndValueName(map, PROJECT_TEXT_VALUE, PROJECT_TEXT_TEXT);
		*/
		
	}
	
	/**
	 * 获取datagrid的json
	 * @param projectTextList
	 * @return
	 */
	public static String getDataGridContextByProjectTextList(List<ProjectText> projectTextList){
		
		Map<String, String> map = new LinkedHashMap<String, String>();
		
		if(!CommonUtils.isCollectionEmpty(projectTextList)){
			
			for(ProjectText text : projectTextList){
				
				map.put(text.getId() + "", text.getCodeDesc());
			}
		}else{
			
			return "[]";
		}
		
		String ret = CommonUtils.getMapJsonSetUpKeyAndValueName(map, DATA_GRID_FIELD_ID, DATA_GRID_FIELD_CODE);
		
		return ret;
	}
	
	/**
	 * 判断list中是否包含对应的id
	 * @param textList
	 * @param projectTextId
	 * @return
	 */
	public static boolean isListHave(List<ProjectText> textList, int projectTextId){
		
		if(CommonUtils.isCollectionEmpty(textList))
			return false;
		
		boolean isHave = false;
		for(ProjectText text : textList){
			
			if(text.getId() == projectTextId){
				isHave = true;
				break;
			}
		}
		
		return isHave;
	}

}
