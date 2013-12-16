package com.ihk.setting.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.customer.data.pojo.CustomerCond;
import com.ihk.setting.data.ICodeDtlMapper;
import com.ihk.setting.data.pojo.CodeDtl;
import com.ihk.setting.data.pojo.CodeDtlCond;
import com.ihk.setting.data.services.ICodeDtlServices;

@Service("codeDtlServices")
public class CodeDtlServices implements ICodeDtlServices{
	
	@Autowired	 
	ICodeDtlMapper codeDtlMapper;

	@Override
	public List<CodeDtl> findCodeList(CodeDtlCond cond) {
		return codeDtlMapper.findCodeList(cond);
	}

	@Override
	public CodeDtl findCodeDescByCodeVal(CodeDtlCond cond)
			throws RuntimeException {
		return codeDtlMapper.findCodeDescByCodeVal(cond);
	}

	@Override
	public List<CodeDtl> findAllCodeDtl() {
		return codeDtlMapper.findAllCodeDtl();
	}

	@Override
	public List<CodeDtl> findCodeDtlListForHomeWorkDistrict(CustomerCond cond)
			throws RuntimeException {
		return codeDtlMapper.findCodeDtlListForHomeWorkDistrict(cond);
	}

}
