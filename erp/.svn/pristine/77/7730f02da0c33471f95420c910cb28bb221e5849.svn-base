package com.ihk.property.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.property.data.IPropertyPrivMapper;
import com.ihk.property.data.IPropertyProjectMapper;
import com.ihk.property.data.pojo.PropertyProject;
import com.ihk.property.data.pojo.PropertyProjectCond;
import com.ihk.property.data.services.IPropertyProjectServices;

/**
 * PropertyProject的Services实现(业务实现)
 * @author 
 *
 */
@Service("propertyProjectServices")
public class PropertyProjectServices implements IPropertyProjectServices {
	/**
	 * propertyProject数据访问接口
	 */
	@Autowired	 IPropertyProjectMapper propertyProjectMapper;
	@Autowired IPropertyPrivMapper propertyPrivMapper;

	/**
	 * 删除一条PropertyProject
	 * @param id
	 */
	public void deletePropertyProject(int id) throws RuntimeException {
		propertyProjectMapper.deletePropertyProject(id);
	}

	/**
	 * 新增PropertyProject
	 * @param propertyProject
	 */
	public void addPropertyProject(PropertyProject propertyProject) throws RuntimeException {		
		propertyProjectMapper.addPropertyProject(propertyProject);
	}

	/**
	 * 查找一条PropertyProject
	 * @return PropertyProject
	 * @param id 主键id
	 */
	@Override
	public PropertyProject findPropertyProjectById(int id) throws RuntimeException {
		return propertyProjectMapper.findPropertyProjectById(id);
	}

	/**
	 * 修改PropertyProject
	 * @param propertyProject
	 */
	@Override
	public void updatePropertyProject(PropertyProject propertyProject) throws RuntimeException {
		propertyProjectMapper.updatePropertyProject(propertyProject);		
	}

	/**
	 * 分页查找PropertyProject
	 * @param cond 查询条件
	 * @return PropertyProject列表
	 */
	public List<PropertyProject> findPropertyProjectPage(PropertyProjectCond cond) throws RuntimeException {
		int recordCount = propertyProjectMapper.findPropertyProjectCount(cond);
		
		cond.recordCount = recordCount;
				
		return propertyProjectMapper.findPropertyProjectPage(cond);
	}

	/**
	 * 查找全部PropertyProject
	 * @param cond 查询条件
	 * @return PropertyProject列表
	 */
	public List<PropertyProject> findPropertyProject(PropertyProjectCond cond) throws RuntimeException {
    	return propertyProjectMapper.findPropertyProject(cond);
	}

	/**
	 * 根据name 模糊查找
	 */
	@Override
	public List<PropertyProject> findPropertyProjectsLikeName(String name)
			throws Exception {
		return propertyProjectMapper.findPropertyProjectsLikeName(name);
	}

	/**
	 * 根据name查找
	 */
	@Override
	public PropertyProject findPropertyProjectIsExistsByProjectName(String name)
			throws Exception {
		return propertyProjectMapper.findPropertyProjectIsExistsByProjectName(name);
	}

	/**
	 * 符合条件的记录数
	 */
	@Override
	public int findPropertyProjectCount(PropertyProjectCond cond)
			throws Exception {
		return propertyProjectMapper.findPropertyProjectCount(cond);
	}

	/**
	 * 根据ids查找
	 */
	@Override
	public List<PropertyProject> findPropertyProjectByIds(
			PropertyProjectCond cond){
		return propertyProjectMapper.findPropertyProjectByIds(cond);
	}

	@Override
	public int findPropertyProjectIdByUnitId(int unitId)
			throws RuntimeException {
		return propertyProjectMapper.findPropertyProjectIdByUnitId(unitId);
	}

	/**
	 * 根据公司id获取对应的楼盘项目
	 * @param comId
	 * @return
	 * @throws RuntimeException
	 */
	@Override
	public List<PropertyProject> findPropertyProjectByCompanyId(int comId)
			throws RuntimeException {
		
		return propertyProjectMapper.findPropertyProjectByCompanyId(comId);
	}

	@Override
	public List<PropertyProject> findPropertyProjectByCompanyProjectId(
			int companyProjectId) throws RuntimeException {
		
		return propertyProjectMapper.findPropertyProjectByCompanyProjectId(companyProjectId);
	}

}
