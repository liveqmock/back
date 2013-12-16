package com.ihk.user.data;

import java.util.List;

import com.ihk.user.data.pojo.Company;
import com.ihk.user.data.pojo.CompanyCond;

/**
 * Company数据访问接口Mapper
 * @author 
 *
 */
public interface ICompanyMapper {
	/**
	 * 新增Company
	 * @param company
	 */
	public void addCompany(Company company) ;

	/**
	 * 根据条件删除Company
	 * @param cond 删除条件
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
	public List<Company> findCompanyPage(CompanyCond cond) ;

	/**
	 * 查找全部Company
	 * @param cond 查询条件
	 * @return Company列表
	 */
	public List<Company> findCompany(CompanyCond cond) ;

	/**
	 * 查找符合条件的记录条数Company
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findCompanyCount(CompanyCond cond) ;
	
	/**
	 * 通过parent_id获取对应的公司,如果恒大公司的parent_id为16
	 * @param parentId
	 * @return
	 * @throws Exception
	 */
	public List<Company> findCompanyByParentId(int parentId) throws Exception; //通过parent_id获取对应的公司,如果恒大公司的parent_id为16
}
