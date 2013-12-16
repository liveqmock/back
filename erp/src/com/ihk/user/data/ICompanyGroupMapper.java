package com.ihk.user.data;

import java.util.List;
import java.util.Map;

import com.ihk.user.data.pojo.CompanyGroup;
import com.ihk.user.data.pojo.CompanyGroupCond;

/**
 * CompanyGroup数据访问接口Mapper
 * @author 
 *
 */ 
public interface ICompanyGroupMapper {

	/**
	 * 新增CompanyGroup
	 * @param companyGroup
	 */
	public void addCompanyGroup(CompanyGroup companyGroup) ;

	/**
	 * 根据条件删除CompanyGroup
	 * @param cond 删除条件
	 */
	public void deleteCompanyGroup(int id) throws RuntimeException;

	/**
	 * 修改CompanyGroup
	 * @param companyGroup
	 */
	public void updateCompanyGroup(CompanyGroup companyGroup) throws RuntimeException;

	/**
	 * 查找一条CompanyGroup
	 * @return CompanyGroup
	 * @param id 主键id
	 */
	public CompanyGroup findCompanyGroupById(int id) throws RuntimeException;

	/**
	 * 分页查找CompanyGroup
	 * @param cond 查询条件
	 * @return CompanyGroup列表
	 */
	public List<CompanyGroup> findCompanyGroupPage(CompanyGroupCond cond) ;

	/**
	 * 查找符合条件的记录条数CompanyGroup
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findCompanyGroupCount(CompanyGroupCond cond) ;
}
