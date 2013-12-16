package com.ihk.utils.common.tag;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;

import com.ihk.user.data.pojo.CompanyProject;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.DescUtils;

/**
 * 关于自定义checkbox标签的帮助类
 * @author dtc
 * 2012-9-27
 */
public class CheckboxTagUtils {
	
	/**
	 * 根据参数返回List<CheckboxTagBean>
	 * @param idPar
	 * @param namePar
	 * @return
	 */
	public static List<CheckboxTagBean> parStringToCheckboxList(String idPar, String namePar){
		
		List<CheckboxTagBean> retList = new ArrayList<CheckboxTagBean>();
		
		if(CommonUtils.isStrZeroEmpty(idPar)){
			
			return retList;
		}
		
		String[] ids = idPar.split(",");
		String[] names = namePar.split(",");
		
		int length = ids.length;
		
		CheckboxTagBean bean = null;
		for(int i=0; i<length; i++){
			
			bean = new CheckboxTagBean();
			
			String id = ids[i];
			String name = names[i];
			
			bean.setId(id);
			bean.setName(name);
			
			retList.add(bean);
		}
		
		return retList;
	}
	
	/**
	 * 返回页面可以显示的List<CheckboxTagBean>数组
	 * @param pojoList
	 * @param idField, pojoList中的对象的id字段
	 * @param nameField, pojoList中的对象的name字段
	 * @param colSize, 页面显示每行的列总数
	 * @return
	 */
	public static List<CheckboxTagBean[]> initCheckboxTagTrListByPojoList(List<?> pojoList, String idField, String nameField, String comIdField, int colSize){
		
		return initCheckboxTagTrList(pojoListToCheckboxTagBeanList(pojoList, idField, nameField, comIdField), colSize);
	}
	
	/**
	 * 返回页面可以显示的List<CheckboxTagBean>数组
	 * @param pojoList
	 * @param idField
	 * @param nameField
	 * @param colSize
	 * @param changeList,已经选择的CheckboxTagBean list
	 * @return
	 */
	public static List<CheckboxTagBean[]> initCheckboxTagTrListByPojoList(List<?> pojoList, String idField, String nameField, String comIdField,
			int colSize, List<CheckboxTagBean> changeList){
		
		if(CommonUtils.isCollectionEmpty(changeList))
			return initCheckboxTagTrListByPojoList(pojoList, idField, nameField, comIdField, colSize);
		
		List<CheckboxTagBean> beanList = pojoListToCheckboxTagBeanList(pojoList, idField, nameField, comIdField); //没有设置check的bean list
		
		for(CheckboxTagBean bean : beanList){
			
			for(CheckboxTagBean changeBean : changeList){
				
				if(bean.getId().equals(changeBean.getId())){
					
					bean.setCheck("true");
					break;
				}
			}
		}
		
		return initCheckboxTagTrList(beanList, colSize);
	}
	
	
	/**
	 * 根据参数list转成List<CheckboxTagBean>
	 * @param pojoList
	 * @param idField
	 * @param nameField
	 * @return
	 */
	private static List<CheckboxTagBean> pojoListToCheckboxTagBeanList(List<?> pojoList, String idField, String nameField, String comIdField){
		
		List<CheckboxTagBean> beanList = new ArrayList<CheckboxTagBean>();
		
		if(CommonUtils.isCollectionEmpty(pojoList))
			return beanList;
		
		for(Object pojo : pojoList){
			
			try{
				
				CheckboxTagBean bean = new CheckboxTagBean();
				
				Object idObj = PropertyUtils.getProperty(pojo, idField);
				if(idObj == null){
					continue;
				}
				bean.setId(idObj.toString());
				
				Object nameObj = PropertyUtils.getProperty(pojo, nameField);
				if(nameObj == null){
					continue;
				}
				bean.setName(nameObj.toString());
				
				Object comIdObj = PropertyUtils.getProperty(pojo, comIdField);
				if(comIdObj == null){
					continue;
				}
				bean.setComId(comIdObj.toString());
				
				beanList.add(bean);
				
			}catch(Exception e){
			}
			
		}
		
		return beanList;
	}
	
	/**
	 * 根据List<CheckboxTagBean>及每行列数返回对应的list数组
	 * @param beanList
	 * @param colSize
	 * @return
	 */
	private static List<CheckboxTagBean[]> initCheckboxTagTrList(List<CheckboxTagBean> beanList, int colSize) {
		
		List<CheckboxTagBean[]> retList = new ArrayList<CheckboxTagBean[]>();
		
		if(CommonUtils.isCollectionEmpty(beanList))
			return retList;
		
		int listCount = beanList.size();
		int trCount = listCount/colSize + (listCount%colSize == 0 ? 0 : 1); //总行数
		
		if(trCount > 1){
		
			//1~倒数第二行,还要考虑只有一行的情况
			for(int i=1; i<trCount; i++){
				
				CheckboxTagBean[] tmp = new CheckboxTagBean[colSize]; //返回list的<>
				
				int start = (i-1) * colSize; //该行对应list的开始index
				
				for(int tmpIndex=0; tmpIndex<colSize; tmpIndex++){
					
					tmp[tmpIndex] = beanList.get(start + tmpIndex);
				}
				
				retList.add(tmp);
				
			}
			
			//最后一行
			int lastTrFirstIndex = (trCount-1) * colSize; //最后一行开始的index
			int lastTrCol = listCount - lastTrFirstIndex; //最后一行的个数
			
			CheckboxTagBean[] lastTrArr = new CheckboxTagBean[lastTrCol];
			
			for(int i=0; i<lastTrCol; i++){
				lastTrArr[i] = beanList.get(lastTrFirstIndex + i);
			}
			
			retList.add(lastTrArr);
			
		}else{
			
			CheckboxTagBean[] lastTrArr = new CheckboxTagBean[listCount];
			
			for(int i=0; i<listCount; i++){
				
				lastTrArr[i] = beanList.get(i);
			}
			
			retList.add(lastTrArr);
		}
		
		
		return retList;
	}
	
	/**
	 * 根据项目list返回公司的下拉框map
	 * @param proList
	 * @return
	 */
	public static Map<String, String> projectListToCompanyMap(List<CompanyProject> proList){
		
		Map<String, String> map = new LinkedHashMap<String, String>();
		
		map.put("", CommonUtils.ALL);
		
		if(CommonUtils.isCollectionEmpty(proList))
			return map;
		
		for(CompanyProject pro : proList){
			
			int companyId = pro.getCompanyId();
			
			if(map.containsKey(companyId + ""))
				continue;
			
			String companyName = DescUtils.getCompanyRealName(companyId);  //获取公司的名称
			
			map.put(companyId + "", companyName);
		}
		
		return map;
	}

}
