package com.ihk.setting.data.services;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.setting.data.pojo.CodeDtl;
import com.ihk.setting.data.pojo.ProjectCode;
import com.ihk.setting.data.pojo.ProjectCodeCond;

@Transactional 
public interface IProjectCodeServices {
	/**
	 * 查找全部ProjectCode
	 * @param cond 查询条件
	 * @return ProjectCode列表
	 */
	public List<CodeDtl> findCodeList(ProjectCodeCond cond) ;
	
	/**
	 * 根据CodeVal查找
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public ProjectCode findCodeDescByCodeVal(ProjectCodeCond cond) throws RuntimeException;
	
	/**
	 * 查找全部
	 * @return
	 */
	public List<ProjectCode> findAllProjectCode();
	
	/**
	 * 根据projectId和typeName获取ProjectCode
	 * @param projectId
	 * @param typeName
	 * @return
	 * @throws RuntimeException
	 */
	public List<ProjectCode> findProjectCodeByProjectIdAndTypeName(int projectId, String typeName) throws RuntimeException;
	
	public void saveProjectCode(ProjectCode projectCode) throws RuntimeException;

	void deleteAllProjectCode(Map map);

	ProjectCode findProjectCode(ProjectCodeCond cond) throws RuntimeException;
	
}