package com.ihk.setting.data;

import java.util.List;

import com.ihk.setting.data.pojo.CodeDtl;
import com.ihk.setting.data.pojo.ProjectText;
import com.ihk.setting.data.pojo.ProjectTextCond;
import com.ihk.utils.base.PojoDeleteCond;

/**
 * ProjectText数据访问接口Mapper
 * @author 
 *
 */ 
public interface IProjectTextMapper {

	/**
	 * 新增ProjectText
	 * @param projectText
	 */
	public void addProjectText(ProjectText projectText) ;

	/**
	 * 根据条件删除ProjectText
	 * @param cond 删除条件
	 */
	public void deleteProjectText(PojoDeleteCond cond) throws RuntimeException;

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
	public List<ProjectText> findProjectTextPage(ProjectTextCond cond) ;

	/**
	 * 查找全部ProjectText
	 * @param cond 查询条件
	 * @return ProjectText列表
	 */
	public List<ProjectText> findProjectText(ProjectTextCond cond) ;

	/**
	 * 查找符合条件的记录条数ProjectText
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findProjectTextCount(ProjectTextCond cond) ;
	
	/**
	 * 
	 * @param cond
	 * @return
	 */
	public List<CodeDtl> findCodeList(ProjectTextCond cond) ;
	
	/**
	 * 查找最大的一个
	 * @param cond
	 * @return
	 */
	public ProjectText findMaxOrderProjectTextByProjectIdAndTypeName(ProjectTextCond cond);
	
	/**
	 * 删除,根据typeName
	 * @param cond
	 * @throws RuntimeException
	 */
	public void deleteProjectTextByTypeName(ProjectTextCond cond) throws RuntimeException;
	
	/**
	 * 修改CodeDesc
	 * @param cond
	 * @throws RuntimeException
	 */
	public void updateProjectTextCodeDesc(ProjectTextCond cond) throws RuntimeException;
}
