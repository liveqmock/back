package com.ihk.user.data.services.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.user.data.ICompanyGroupMapper;
import com.ihk.user.data.pojo.CompanyGroup;
import com.ihk.user.data.pojo.CompanyGroupCond;
import com.ihk.user.data.services.ICompanyGroupServices;

@Service("companyGroupServices")
@SuppressWarnings("unchecked")
public class CompanyGroupServices implements ICompanyGroupServices {
	@Autowired	 ICompanyGroupMapper companyGroupMapper;

	public void deleteCompanyGroup(int id) throws RuntimeException {
		companyGroupMapper.deleteCompanyGroup(id);
	}

	public void addCompanyGroup(CompanyGroup companyGroup) throws RuntimeException {		
		companyGroupMapper.addCompanyGroup(companyGroup);
	}

	@Override
	public CompanyGroup findCompanyGroupById(int id) throws RuntimeException {
		return companyGroupMapper.findCompanyGroupById(id);
	}

	@Override
	public void updateCompanyGroup(CompanyGroup companyGroup) throws RuntimeException {
		companyGroupMapper.updateCompanyGroup(companyGroup);		
	}
	
	public List findCompanyGroupPage(CompanyGroupCond cond) throws RuntimeException {
		int recordCount = companyGroupMapper.findCompanyGroupCount(cond);
		
		cond.recordCount = recordCount;
				
		return companyGroupMapper.findCompanyGroupPage(cond);
	}
}
