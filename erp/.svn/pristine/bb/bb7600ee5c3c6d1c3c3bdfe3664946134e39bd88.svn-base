package com.ihk.customer.collection.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.customer.collection.pojo.VipCustImp;
import com.ihk.customer.collection.pojo.VipCustImpCond;

@Transactional 
@SuppressWarnings("unchecked")
public interface IVipCustImpServices {
	public void addVipCustImp(VipCustImp vipCustImp) throws RuntimeException;

	public void deleteVipCustImp(int id) throws RuntimeException;

	public void updateVipCustImp(VipCustImp vipCustImp) throws RuntimeException;

	public VipCustImp findVipCustImpById(VipCustImpCond cond) throws RuntimeException;
    
	public List<VipCustImp> findVipCustImpPage(VipCustImpCond cond) throws RuntimeException;
    
	public List<VipCustImp> findVipCustImp(VipCustImpCond cond) throws RuntimeException;
}