package com.ihk.user.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.constanttype.EnumDevFlag;
import com.ihk.constanttype.EnumPrivCode;
import com.ihk.user.data.IPrivMapper;
import com.ihk.user.data.pojo.Priv;
import com.ihk.user.data.pojo.PrivCond;
import com.ihk.user.data.services.IPrivServices;

@Service("privServices")
public class PrivServices implements IPrivServices {
	@Autowired	 IPrivMapper privMapper;

	public void deletePriv(int id) throws RuntimeException {
		privMapper.deletePriv(id);
	}

	public void addPriv(Priv priv) throws RuntimeException {		
		privMapper.addPriv(priv);
	}

	@Override
	public Priv findPrivById(int id) throws RuntimeException {
		return privMapper.findPrivById(id);
	}

	@Override
	public int findIdByCodeDevFlag(EnumPrivCode privCode,EnumDevFlag devFlag) throws RuntimeException {
		PrivCond cond = new PrivCond();
		cond.setPrivCode(privCode.toString());
		cond.setDevFlag(devFlag.toString());
		List<Priv> list = privMapper.findPrivPage(cond);
		if(list!=null && list.size()>0){
			return list.get(0).getId();
		}
		return -1;
	}

	@Override
	public void updatePriv(Priv priv) throws RuntimeException {
		privMapper.updatePriv(priv);		
	}
	
	public List findPrivPage(PrivCond cond) throws RuntimeException {
		int recordCount = privMapper.findPrivCount(cond);
		
		cond.recordCount = recordCount;
				
		return privMapper.findPrivPage(cond);
	}

	@Override
	public List<Priv> findAll() throws RuntimeException {
		
		return privMapper.findAll();
	}
	
	public List findUserPriv(int userId) throws RuntimeException {
		return privMapper.findUserPriv(userId);
	}
}
