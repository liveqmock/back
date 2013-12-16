package com.ihk.user.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.user.data.ICompanyMapper;
import com.ihk.user.data.pojo.Company;
import com.ihk.user.data.pojo.CompanyCond;
import com.ihk.user.data.services.ICompanyServices;

@Service("companyServices")
public class CompanyServices implements ICompanyServices {
	@Autowired private ICompanyMapper companyMapper;

	public void deleteCompany(int id) throws RuntimeException {
		companyMapper.deleteCompany(id);
	}

	public void addCompany(Company company) throws RuntimeException {		
		companyMapper.addCompany(company);
	}

	@Override
	public Company findCompanyById(int id) throws RuntimeException {
		return companyMapper.findCompanyById(id);
	}

	@Override
	public void updateCompany(Company company) throws RuntimeException {
		companyMapper.updateCompany(company);		
	}
	
	public List<Company> findCompanyPage(CompanyCond cond) throws RuntimeException {
		int recordCount = companyMapper.findCompanyCount(cond);
		
		cond.recordCount = recordCount;
				
		return companyMapper.findCompanyPage(cond);
	}
    
	public List<Company> findCompany(CompanyCond cond) throws RuntimeException {
    	return companyMapper.findCompany(cond);
	}

	@Override
	public List<Company> findCompanyByParentId(int parentId) throws Exception {
		
		return companyMapper.findCompanyByParentId(parentId);
	}
	
}
