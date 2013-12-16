package com.ihk.utils.saleunitnew;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.ihk.property.data.pojo.PropertyBuild;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.MyTransationTemplate;
import com.ihk.utils.saleunit.MyPropertyUtils;

/**
 * 关于单元的一些帮助类
 * @author dtc
 * 2012-8-23
 */
public class PropertyUnitUtils {
	
	/**
	 * 获取单元的全名,包括项目,分区,楼栋,单元号
	 * @param unitId
	 * @return
	 */
	public static String getUnitAllNameByUnitId(final int unitId){
		
		//为了减少数据库连接次数,用事务来查找
		
		final StringBuffer sb = new StringBuffer();
		
		try {
			new MyTransationTemplate() {
				
				@Override
				protected void doExecuteCallback() throws Exception {
					
					PropertyUnit unit = MyPropertyUtils.getPropertyUnitServices().findPropertyUnitById(unitId);
					sb.append(unit.getAllName());
					
				}
			}.execute();
			
		} catch (Exception e) {
			
		}
		
		return sb.toString();
	}
	
	/**
	 * 楼栋list转成下拉框的map
	 * @param list
	 * @return
	 */
	public static Map<String, String> buildListToMap(List<PropertyBuild> list){
		
		Map<String, String> retMap = new LinkedHashMap<String, String>();
		
		retMap.put("", CommonUtils.EMPTY);
		
		if(!CommonUtils.isCollectionEmpty(list)){
			
			for(PropertyBuild build : list){
				
				retMap.put(build.getId() + "", build.getAllName());
			}
		}
		
		return retMap;
	
	}

}
