package com.ihk.user.data.services.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.user.data.IPrivFuncMapper;
import com.ihk.user.data.pojo.Priv;
import com.ihk.user.data.pojo.PrivFunc;
import com.ihk.user.data.pojo.PrivFuncCond;
import com.ihk.user.data.pojo.PrivFuncName;
import com.ihk.user.data.services.IPrivFuncServices;

@Service("privFuncServices")
@SuppressWarnings("unchecked")
public class PrivFuncServices implements IPrivFuncServices {
	@Autowired	 IPrivFuncMapper privFuncMapper;

	public void deletePrivFunc(int id) throws RuntimeException {
		privFuncMapper.deletePrivFunc(id);
	}

	public void addPrivFunc(PrivFunc privFunc) throws RuntimeException {		
		privFuncMapper.addPrivFunc(privFunc);
	}

	@Override
	public PrivFunc findPrivFuncById(int id) throws RuntimeException {
		return privFuncMapper.findPrivFuncById(id);
	}

	@Override
	public void updatePrivFunc(PrivFunc privFunc) throws RuntimeException {
		privFuncMapper.updatePrivFunc(privFunc);		
	}
	
	public List findPrivFuncPage(PrivFuncCond cond) throws RuntimeException {
		int recordCount = privFuncMapper.findPrivFuncCount(cond);
		
		cond.recordCount = recordCount;
				
		return privFuncMapper.findPrivFuncPage(cond);
	}

//	@Override
//	public List<PrivFuncName> findAll() throws RuntimeException {
//		
//		return privFuncMapper.findAll();
//	}
	
	

//	@Override
//	public List<PrivFuncName> findListByName(PrivFuncName privFuncName) {
//		
//		return privFuncMapper.findListByName(privFuncName);
//	}

	@Override
	public List<LinkedHashMap<String, String>> findAll() {
		
		return privFuncMapper.findAll();
	}

	@Override
	public List<LinkedHashMap<String, String>> findListByName(Priv priv) {
		return privFuncMapper.findListByName(priv);
	}



	
}
