package com.ihk.saleunit.data;

import java.util.List;

import com.ihk.saleunit.data.pojo.CustomerRename;
import com.ihk.saleunit.data.pojo.CustomerRenameCond;

import com.ihk.utils.base.PojoDeleteCond;
 
public interface ICustomerRenameMapper {

	public void addCustomerRename(CustomerRename customerRename) ;

	public void deleteCustomerRename(PojoDeleteCond cond) throws RuntimeException;

	public void updateCustomerRename(CustomerRename customerRename) throws RuntimeException;
	
	public CustomerRename findCustomerRenameById(int id) throws RuntimeException;
	
	public List<CustomerRename> findCustomerRenamePage(CustomerRenameCond cond) ;
    
	public List<CustomerRename> findCustomerRename(CustomerRenameCond cond) ;
    
	public int findCustomerRenameCount(CustomerRenameCond cond) ;
    
    /**
	 * ajax分页list
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
    public List<CustomerRename> findCustomerRenameForAjax(CustomerRenameCond cond) ;
    
    /**
	 * ajax分页count
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
    public int findCustomerRenameCountForAjax(CustomerRenameCond cond) ;
}
