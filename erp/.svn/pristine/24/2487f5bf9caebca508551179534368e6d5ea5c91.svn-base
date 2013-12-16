package com.ihk.saleunit.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.saleunit.data.IMidUnitConfirmMapper;
import com.ihk.saleunit.data.pojo.MidUnitConfirm;
import com.ihk.saleunit.data.pojo.MidUnitConfirmCond;
import com.ihk.saleunit.data.services.IMidUnitConfirmServices;

import com.ihk.utils.base.PojoDeleteCond;

@Service("midUnitConfirmServices")
public class MidUnitConfirmServices implements IMidUnitConfirmServices {
	@Autowired	 IMidUnitConfirmMapper midUnitConfirmMapper;

	public void deleteMidUnitConfirm(int id) throws RuntimeException {
		midUnitConfirmMapper.deleteMidUnitConfirm(new PojoDeleteCond(id));
	}

	public void addMidUnitConfirm(MidUnitConfirm midUnitConfirm) throws RuntimeException {		
		midUnitConfirmMapper.addMidUnitConfirm(midUnitConfirm);
	}

	@Override
	public MidUnitConfirm findMidUnitConfirmById(int id) throws RuntimeException {
		return midUnitConfirmMapper.findMidUnitConfirmById(id);
	}

	@Override
	public void updateMidUnitConfirm(MidUnitConfirm midUnitConfirm) throws RuntimeException {
		midUnitConfirmMapper.updateMidUnitConfirm(midUnitConfirm);		
	}
	
    @Override
	public List<MidUnitConfirm> findMidUnitConfirmPage(MidUnitConfirmCond cond) throws RuntimeException {
		int recordCount = midUnitConfirmMapper.findMidUnitConfirmCount(cond);
		
		cond.recordCount = recordCount;
				
		return midUnitConfirmMapper.findMidUnitConfirmPage(cond);
	}
    
    @Override
	public List<MidUnitConfirm> findMidUnitConfirm(MidUnitConfirmCond cond) throws RuntimeException {
    	return midUnitConfirmMapper.findMidUnitConfirm(cond);
	}
    
    @Override
	public List<MidUnitConfirm> findMidUnitConfirmForAjax(MidUnitConfirmCond cond) throws RuntimeException {
        return midUnitConfirmMapper.findMidUnitConfirmForAjax(cond);
	}
    
    @Override
    public int findMidUnitConfirmCountForAjax(MidUnitConfirmCond cond) throws RuntimeException {
        return midUnitConfirmMapper.findMidUnitConfirmCountForAjax(cond);
    }
}
