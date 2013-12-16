package com.ihk.saleunit.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.saleunit.data.ICustomerRenameMapper;
import com.ihk.saleunit.data.pojo.CustomerRename;
import com.ihk.saleunit.data.pojo.CustomerRenameCond;
import com.ihk.saleunit.data.services.ICustomerRenameServices;

import com.ihk.utils.base.PojoDeleteCond;

@Service("customerRenameServices")
public class CustomerRenameServices implements ICustomerRenameServices {
	@Autowired	 ICustomerRenameMapper customerRenameMapper;

	public void deleteCustomerRename(int id) throws RuntimeException {
		customerRenameMapper.deleteCustomerRename(new PojoDeleteCond(id));
	}

	public void addCustomerRename(CustomerRename customerRename) throws RuntimeException {		
		customerRenameMapper.addCustomerRename(customerRename);
	}

	@Override
	public CustomerRename findCustomerRenameById(int id) throws RuntimeException {
		return customerRenameMapper.findCustomerRenameById(id);
	}

	@Override
	public void updateCustomerRename(CustomerRename customerRename) throws RuntimeException {
		customerRenameMapper.updateCustomerRename(customerRename);		
	}
	
    @Override
	public List<CustomerRename> findCustomerRenamePage(CustomerRenameCond cond) throws RuntimeException {
		int recordCount = customerRenameMapper.findCustomerRenameCount(cond);
		
		cond.recordCount = recordCount;
				
		return customerRenameMapper.findCustomerRenamePage(cond);
	}
    
    @Override
	public List<CustomerRename> findCustomerRename(CustomerRenameCond cond) throws RuntimeException {
    	return customerRenameMapper.findCustomerRename(cond);
	}
    
    @Override
	public List<CustomerRename> findCustomerRenameForAjax(CustomerRenameCond cond) throws RuntimeException {
        return customerRenameMapper.findCustomerRenameForAjax(cond);
	}
    
    @Override
    public int findCustomerRenameCountForAjax(CustomerRenameCond cond) throws RuntimeException {
        return customerRenameMapper.findCustomerRenameCountForAjax(cond);
    }
}
