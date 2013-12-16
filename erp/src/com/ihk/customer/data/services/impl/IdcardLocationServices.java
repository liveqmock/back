package com.ihk.customer.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.customer.data.IIdcardLocationMapper;
import com.ihk.customer.data.pojo.IdcardLocation;
import com.ihk.customer.data.pojo.IdcardLocationCond;
import com.ihk.customer.data.services.IIdcardLocationServices;

import com.ihk.utils.base.PojoDeleteCond;

@Service("idcardLocationServices")
public class IdcardLocationServices implements IIdcardLocationServices {
	@Autowired	 IIdcardLocationMapper idcardLocationMapper;

	public void deleteIdcardLocation(int id) throws RuntimeException {
		idcardLocationMapper.deleteIdcardLocation(new PojoDeleteCond(id));
	}

	public void addIdcardLocation(IdcardLocation idcardLocation) throws RuntimeException {		
		idcardLocationMapper.addIdcardLocation(idcardLocation);
	}

	@Override
	public IdcardLocation findIdcardLocationById(int id) throws RuntimeException {
		return idcardLocationMapper.findIdcardLocationById(id);
	}

	@Override
	public void updateIdcardLocation(IdcardLocation idcardLocation) throws RuntimeException {
		idcardLocationMapper.updateIdcardLocation(idcardLocation);		
	}
	
    @Override
	public List<IdcardLocation> findIdcardLocationPage(IdcardLocationCond cond) throws RuntimeException {
		int recordCount = idcardLocationMapper.findIdcardLocationCount(cond);
		
		cond.recordCount = recordCount;
				
		return idcardLocationMapper.findIdcardLocationPage(cond);
	}
    
    @Override
	public List<IdcardLocation> findIdcardLocation(IdcardLocationCond cond) throws RuntimeException {
    	return idcardLocationMapper.findIdcardLocation(cond);
	}
    
    @Override
	public List<IdcardLocation> findIdcardLocationForAjax(IdcardLocationCond cond) throws RuntimeException {
        return idcardLocationMapper.findIdcardLocationForAjax(cond);
	}
    
    @Override
    public int findIdcardLocationCountForAjax(IdcardLocationCond cond) throws RuntimeException {
        return idcardLocationMapper.findIdcardLocationCountForAjax(cond);
    }

	@Override
	public int findIdcardLocationCount(IdcardLocationCond cond)
			throws RuntimeException {

		return idcardLocationMapper.findIdcardLocationCount(cond);
	}
}
