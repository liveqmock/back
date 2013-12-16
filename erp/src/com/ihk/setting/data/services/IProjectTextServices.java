package com.ihk.setting.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.setting.data.pojo.CodeDtl;
import com.ihk.setting.data.pojo.ProjectText;
import com.ihk.setting.data.pojo.ProjectTextCond;

/**
 * ProjectText的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
public interface IProjectTextServices {
	/**
	 * 新增ProjectText
	 * @param projectText
	 */
	public void addProjectText(ProjectText projectText) throws RuntimeException;

	/**
	 * 删除一条ProjectText
	 * @param id
	 */
	public void deleteProjectText(int id) throws RuntimeException;

	/**
	 * 修改ProjectText
	 * @param projectText
	 */
	public void updateProjectText(ProjectText projectText) throws RuntimeException;

	/**
	 * 查找一条ProjectText
	 * @return ProjectText
	 * @param id 主键id
	 */
	public ProjectText findProjectTextById(int id) throws RuntimeException;

	/**
	 * 分页查找ProjectText
	 * @param cond 查询条件
	 * @return ProjectText列表
	 */
	public List<ProjectText> findProjectTextPage(ProjectTextCond cond) throws RuntimeException;

	/**
	 * 查找全部ProjectText
	 * @param cond 查询条件
	 * @return ProjectText列表
	 */
	public List<ProjectText> findProjectText(ProjectTextCond cond) throws RuntimeException;
	
	/**
	 * 查找
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public List<CodeDtl> findCodeList(ProjectTextCond cond) throws RuntimeException;
	
	/**
	 * 查找
	 * @param projectId
	 * @param typeName
	 * @return
	 * @throws RuntimeException
	 */
	public ProjectText findMaxOrderProjectTextByProjectIdAndTypeName(int projectId, String typeName) throws RuntimeException;
	
	/**
	 * 删除
	 * @param typeName
	 * @throws RuntimeException
	 */
	public void deleteProjectTextByTypeName(String typeName) throws RuntimeException;
	
	/**
	 * 修改
	 * @param text
	 * @throws RuntimeException
	 */
	public void updateProjectTextCodeDesc(ProjectText text) throws RuntimeException;
	
}