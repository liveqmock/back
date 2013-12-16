package com.ihk.setting.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.customer.data.pojo.CustomerCond;
import com.ihk.setting.data.pojo.CodeDtl;
import com.ihk.setting.data.pojo.CodeDtlCond;

@Transactional 
public interface ICodeDtlServices {
	
	/**
	 * 查找全部CodeDtl
	 * @param cond 查询条件
	 * @return CodeDtl列表
	 */
	public List<CodeDtl> findCodeList(CodeDtlCond cond) ;
	
	/**
	 * 根据codeVal查找
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public CodeDtl findCodeDescByCodeVal(CodeDtlCond cond) throws RuntimeException;
	
	/**
	 * 查找全部CodeDtl
	 * @param cond 查询条件
	 * @return CodeDtl列表
	 */
	public List<CodeDtl> findAllCodeDtl();
	
	/**
	 * 获取对应的home_region或work_region,转成CodeDtl
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public List<CodeDtl> findCodeDtlListForHomeWorkDistrict(CustomerCond cond) throws RuntimeException;
	
}