package com.ihk.customer.collection;

import java.util.List;
import java.util.Map;

import com.ihk.customer.collection.pojo.VipCustImp;
import com.ihk.customer.collection.pojo.VipCustImpCond;

import com.ihk.utils.base.PojoDeleteCond;
 
public interface IVipCustImpMapper {

	public void addVipCustImp(VipCustImp vipCustImp) ;

	public void deleteVipCustImp(int id) throws RuntimeException;
	public void deleteVipCustImpByFlag() throws RuntimeException;

	public void deleteVipCustImpALL() throws RuntimeException;
	public void deleteVipCustALL() throws RuntimeException;
	public void deleteVipCustdealALL() throws RuntimeException;

	public void updateVipCustImp(VipCustImp vipCustImp) throws RuntimeException;
	
	public VipCustImp findVipCustImpById(VipCustImpCond cond) throws RuntimeException;
	
	public List<VipCustImp> findVipCustImpPage(VipCustImpCond cond) ;
    
	public List<VipCustImp> findVipCustImp(VipCustImpCond cond) ;
    
	public int findVipCustImpCount(VipCustImpCond cond) ;
	public int updateAllowsImp(VipCustImpCond cond)  throws RuntimeException;
}
