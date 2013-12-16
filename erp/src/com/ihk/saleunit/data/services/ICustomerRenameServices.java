package com.ihk.saleunit.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.saleunit.data.pojo.CustomerRename;
import com.ihk.saleunit.data.pojo.CustomerRenameCond;

@Transactional 
public interface ICustomerRenameServices {
	public void addCustomerRename(CustomerRename customerRename) throws RuntimeException;

	public void deleteCustomerRename(int id) throws RuntimeException;

	public void updateCustomerRename(CustomerRename customerRename) throws RuntimeException;

	public CustomerRename findCustomerRenameById(int id) throws RuntimeException;
    
	public List<CustomerRename> findCustomerRenamePage(CustomerRenameCond cond) throws RuntimeException;
    
	public List<CustomerRename> findCustomerRename(CustomerRenameCond cond) throws RuntimeException;
    
    /**
	 * ajax分页list
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
    public List<CustomerRename> findCustomerRenameForAjax(CustomerRenameCond cond) throws RuntimeException;
    
    /**
	 * ajax分页count
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
    public int findCustomerRenameCountForAjax(CustomerRenameCond cond) throws RuntimeException;
    
}