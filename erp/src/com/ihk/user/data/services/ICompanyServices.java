package com.ihk.user.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.user.data.pojo.Company;
import com.ihk.user.data.pojo.CompanyCond;


/**
 * Company的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
public interface ICompanyServices {	

	/**
	 * 新增Company
	 * @param company
	 */
	public void addCompany(Company company) throws RuntimeException;

	/**
	 * 删除一条Company
	 * @param id
	 */
	public void deleteCompany(int id) throws RuntimeException;

	/**
	 * 修改Company
	 * @param company
	 */
	public void updateCompany(Company company) throws RuntimeException;

	/**
	 * 查找一条Company
	 * @return Company
	 * @param id 主键id
	 */
	public Company findCompanyById(int id) throws RuntimeException;

	/**
	 * 分页查找Company
	 * @param cond 查询条件
	 * @return Company列表
	 */
	public List<Company> findCompanyPage(CompanyCond cond) throws RuntimeException;

	/**
	 * 查找全部Company
	 * @param cond 查询条件
	 * @return Company列表
	 */
	public List<Company> findCompany(CompanyCond cond) throws RuntimeException;
	
	/**
	 * 查找
	 * @param parentId
	 * @return
	 * @throws Exception
	 */
	public List<Company> findCompanyByParentId(int parentId) throws Exception; //通过parent_id获取对应的公司,如果恒大公司的parent_id为16

}

