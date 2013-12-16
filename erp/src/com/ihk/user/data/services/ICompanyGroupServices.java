package com.ihk.user.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.user.data.pojo.CompanyGroup;
import com.ihk.user.data.pojo.CompanyGroupCond;

/**
 * CompanyGroup的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
@SuppressWarnings("unchecked")
public interface ICompanyGroupServices {
	/**
	 * 新增CompanyGroup
	 * @param companyGroup
	 */
	public void addCompanyGroup(CompanyGroup companyGroup) throws RuntimeException;

	/**
	 * 删除一条CompanyGroup
	 * @param id
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
	public List<CompanyGroup> findCompanyGroupPage(CompanyGroupCond cond) throws RuntimeException;
}