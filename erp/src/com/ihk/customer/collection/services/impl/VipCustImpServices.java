package com.ihk.customer.collection.services.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.customer.collection.IVipCustImpMapper;
import com.ihk.customer.collection.pojo.VipCustImp;
import com.ihk.customer.collection.pojo.VipCustImpCond;
import com.ihk.customer.collection.services.IVipCustImpServices;

import com.ihk.utils.base.PojoDeleteCond;

@Service("vipCustImpServices")
@SuppressWarnings("unchecked")
public class VipCustImpServices implements IVipCustImpServices {
	@Autowired	 IVipCustImpMapper vipCustImpMapper;

	public void deleteVipCustImp(int id) throws RuntimeException {
		vipCustImpMapper.deleteVipCustImp(id);
	}

	public void addVipCustImp(VipCustImp vipCustImp) throws RuntimeException {		
		vipCustImpMapper.addVipCustImp(vipCustImp);
	}

	@Override
	public VipCustImp findVipCustImpById(VipCustImpCond cond) throws RuntimeException {
		return vipCustImpMapper.findVipCustImpById(cond);
	}

	@Override
	public void updateVipCustImp(VipCustImp vipCustImp) throws RuntimeException {
		vipCustImpMapper.updateVipCustImp(vipCustImp);		
	}
	
	public List<VipCustImp> findVipCustImpPage(VipCustImpCond cond) throws RuntimeException {
		int recordCount = vipCustImpMapper.findVipCustImpCount(cond);
		
		cond.recordCount = recordCount;
				
		return vipCustImpMapper.findVipCustImpPage(cond);
	}
    
	public List<VipCustImp> findVipCustImp(VipCustImpCond cond) throws RuntimeException {
    	return vipCustImpMapper.findVipCustImp(cond);
	}
}
