package com.ihk.utils.common.unit;

import java.io.Serializable;

import org.apache.commons.beanutils.PropertyUtils;

import com.ihk.property.data.pojo.PropertyBuild;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.utils.saleunit.MyPropertyUtils;

/**
 * 根据pojo的unitId,设定对应的
 * companyProjectId(公司项目id),
 * propertyProjectId(楼盘项目id),
 * areaId(分区id),
 * buildId(楼栋id),
 * unitId(单元id)
 * @author dtc
 * 2013-4-25,上午09:50:52
 */
public class CommonUnitPojoUtils {
	
	/**
	 * 设定unitId,buildId,areaId,propertyProjectId,companyProjectId
	 * @param pojo
	 * @throws Exception
	 */
	public static void initPojoCommonFiled(Serializable pojo) throws Exception{
		
		int unitId = Integer.parseInt(PropertyUtils.getProperty(pojo, "unitId").toString());
		
		CommonUnitPojo unitPojo = getPojoByUnitId(unitId);
		
		PropertyUtils.setProperty(pojo, "buildId", unitPojo.getBuildId());
		
		PropertyUtils.setProperty(pojo, "areaId", unitPojo.getAreaId());
		
		PropertyUtils.setProperty(pojo, "propertyProjectId", unitPojo.getPropertyProjectId());
		
		PropertyUtils.setProperty(pojo, "companyProjectId", unitPojo.getCompanyProjectId());
		
	}
	
	/**
	 * 根据单元id获取对应的unitId,buildId,areaId,propertyProjectId,companyProjectId
	 * @param unitId
	 * @return
	 * @throws Exception
	 */
	public static CommonUnitPojo getPojoByUnitId(int unitId) throws Exception{
		
		CommonUnitPojo pojo = new CommonUnitPojo();
		
		PropertyUnit unit = MyPropertyUtils.getPropertyUnitServices().findPropertyUnitById(unitId);
		
		int buildId = unit.getBuildId();
		
		PropertyBuild build = MyPropertyUtils.getPropertyBuildServices().findPropertyBuildById(buildId);
		
		int areaId = build.getAreaId();
		
		int propertyProjectId = build.getPropertyId();
		
		int companyProjectId = build.getCompanyProjectId();
		
		pojo.setUnitId(unitId);
		pojo.setBuildId(buildId);
		pojo.setAreaId(areaId);
		pojo.setPropertyProjectId(propertyProjectId);
		pojo.setCompanyProjectId(companyProjectId);
		
		return pojo;
	}
	
}
