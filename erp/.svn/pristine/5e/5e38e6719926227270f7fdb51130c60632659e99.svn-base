package com.ihk.property.data.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.property.data.IPropertyBuildMapper;
import com.ihk.property.data.pojo.PropertyBuild;
import com.ihk.property.data.pojo.PropertyBuildCond;
import com.ihk.property.data.services.IPropertyBuildServices;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.saleunit.data.services.IQuestionServices;
import com.ihk.saleunit.data.services.IQuestionTopicServices;
import com.ihk.utils.DescUtils;
import com.ihk.utils.SessionUser;

/**
 * PropertyBuild的Services实现(业务实现)
 * @author 
 *
 */
@Service("propertyBuildServices")
public class PropertyBuildServices implements IPropertyBuildServices {
	/**
	 * propertyBuild数据访问接口
	 */
	@Autowired	 IPropertyBuildMapper propertyBuildMapper;
	@Autowired IPropertyUnitServices propertyUnitServices; 
	/**
	 * 删除一条PropertyBuild
	 * @param id
	 */
	public void deletePropertyBuild(int id) throws RuntimeException {
		propertyBuildMapper.deletePropertyBuild(id);
		//删除BUILD 就要删除其下面所有UNIT
		propertyUnitServices.deletePropertyUnitByBuildId(id);
	}

	@Autowired IQuestionServices questionServices;
	@Autowired IQuestionTopicServices questionTopicServices;
	/**
	 * 新增PropertyBuild
	 * @param propertyBuild
	 */
	public void addPropertyBuild(PropertyBuild propertyBuild) throws RuntimeException {
		
		propertyBuild.setCompanyProjectId(
				DescUtils.findPropertyProject(propertyBuild.getPropertyId()).getCompanyProjectId()
				);
		
		
		propertyBuildMapper.addPropertyBuild(propertyBuild);
		//TODO 初始化资料 为了新建的楼栋 ,基本的付款方式(2012-10-08) 
		
		//TODO 初始化资料 一套标准的售后问卷   2012-10-15 处理方法 直接新建一套基本问卷 需要新建     11-1
//		InitQuestion iq = new InitQuestion();
//		iq.addBaseBeforQuestion(propertyBuild.getId(),questionServices,questionTopicServices);
	}
	
	public void addKnPropertyBuild(PropertyBuild propertyBuild) throws RuntimeException {
		propertyBuildMapper.addPropertyBuild(propertyBuild);
	}

	/**
	 * 查找一条PropertyBuild
	 * @return PropertyBuild
	 * @param id 主键id
	 */
	@Override
	public PropertyBuild findPropertyBuildById(int id) throws RuntimeException {
		return propertyBuildMapper.findPropertyBuildById(id);
	}

	/**
	 * 修改PropertyBuild
	 * @param propertyBuild
	 */
	@Override
	public void updatePropertyBuild(PropertyBuild propertyBuild) throws RuntimeException {
		propertyBuildMapper.updatePropertyBuild(propertyBuild);		
	}

	/**
	 * 分页查找PropertyBuild
	 * @param cond 查询条件
	 * @return PropertyBuild列表
	 */
	public List<PropertyBuild> findPropertyBuildPage(PropertyBuildCond cond) throws RuntimeException {
		int recordCount = propertyBuildMapper.findPropertyBuildCount(cond);
		
		cond.recordCount = recordCount;
				
		return propertyBuildMapper.findPropertyBuildPage(cond);
	}

	/**
	 * 查找全部PropertyBuild
	 * @param cond 查询条件
	 * @return PropertyBuild列表
	 */
	public List<PropertyBuild> findPropertyBuild(PropertyBuildCond cond) throws RuntimeException {
    	return propertyBuildMapper.findPropertyBuild(cond);
	}

	/**
	 * 根据name模糊查找
	 */
	@Override
	public List<PropertyBuild> findPropertyBuildsLikeName(String name)
			throws RuntimeException {
		return propertyBuildMapper.findPropertyBuildsLikeName(name);
	}

	/**
	 * 根据name查找
	 */
	@Override
	public PropertyBuild findBuildIsExistsByBuildName(String name)
			throws RuntimeException {
		return propertyBuildMapper.findBuildIsExistsByBuildName(name);
	}

	/**
	 * 根据propertyId 查找
	 */
	@Override
	public List<PropertyBuild> findPropertyBuildByPropertyId(int propertyId)
			throws RuntimeException {
		
		return propertyBuildMapper.findPropertyBuildByPropertyId(propertyId);
	}

	/**
	 * 根据name,propertyProjectId 查找
	 */
	@Override
	public List<PropertyBuild> findPropertyBuildsLikeNameAndPropertyProjectId(
			String name, int propertyProjectId) throws RuntimeException {
		
		PropertyBuildCond cond = new PropertyBuildCond();
		cond.setSearchName(name);
		cond.setPropertyId(propertyProjectId + "");
		return propertyBuildMapper.findPropertyBuildsLikeNameAndPropertyProjectId(cond);
	}

	/**
	 * 符合条件的记录条数
	 */
	@Override
	public int findPropertyBuildCount(PropertyBuildCond cond)
			throws RuntimeException {
		return propertyBuildMapper.findPropertyBuildCount(cond);
	}

	/**
	 * 根据areaId查找
	 */
	@Override
	public List<PropertyBuild> findPropertyBuildByAreaId(int areaId)
			throws RuntimeException {
		
		return propertyBuildMapper.findPropertyBuildByAreaId(areaId);
	}

	/**
	 * 根据楼栋id获取楼栋全名
	 */
	@Override
	public String findPropertyBuildAllNameByBuildId(int buildId)
			throws RuntimeException {
		
		return propertyBuildMapper.findPropertyBuildAllNameByBuildId(buildId);
	}
    @Override
    public String findPropertyBuildAreaNameByBuildId(int buildId)
            throws RuntimeException {

        return propertyBuildMapper.findPropertyBuildAreaNameByBuildId(buildId);
    }

	@Override
	public List<Integer> findPropertyBuildByGroupId(int groupId)
			throws RuntimeException {
		
		return propertyBuildMapper.findPropertyBuildByGroupId(groupId);
	}

	@Override
	public void updatePropertyBuildOrderIndex(int buildId, int orderIndex)
			throws RuntimeException {
		
		PropertyBuild build = new PropertyBuild();
		build.setId(buildId);
		build.setOrderIndex(orderIndex);
		build.setModId(SessionUser.getUserId());
		build.setModTime(new Date());
		
		propertyBuildMapper.updatePropertyBuildOrderIndex(build);
	}
}
