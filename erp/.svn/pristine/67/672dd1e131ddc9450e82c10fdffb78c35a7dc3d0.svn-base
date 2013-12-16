package com.ihk.setting.data.services;

import java.util.List;

import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.constanttype.EnumTextTypeName;
import com.ihk.setting.data.pojo.CodeDtl;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.setting.data.pojo.CodeType;
import java.util.LinkedHashMap;


/**
 * CodeType的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
@SuppressWarnings("rawtypes")
public interface ICodeTypeServices {
	/**
	 * 根据typeName查找
	 * @param typeName
	 * @return
	 * @throws RuntimeException
	 */
	public CodeType findCodeTypeByName(String typeName) throws RuntimeException;
    
	/**
	 * 查找
	 * @param typeName
	 * @param projectId
	 * @return
	 * @throws RuntimeException
	 */
	public List<CodeDtl> findCodeList(String typeName,int projectId) throws RuntimeException;
	
	/**
	 * 查找,用于下拉框
	 * @param typeName
	 * @param projectId
	 * @return
	 * @throws RuntimeException
	 */
	public LinkedHashMap findCodeListForSel(EnumCodeTypeName typeName,int projectId) throws RuntimeException;
	
	/**
	 * 查找,用于下拉框
	 * @param typeName
	 * @param projectId
	 * @param isPutEmpty
	 * @return
	 * @throws RuntimeException
	 */
	public LinkedHashMap findCodeListForSel(EnumCodeTypeName typeName,int projectId, boolean isPutEmpty) throws RuntimeException;
	
	/**
	 * 查找,用于下拉框
	 * @param typeName
	 * @param projectId
	 * @param isPutEmpty
	 * @return
	 * @throws RuntimeException
	 */
	public LinkedHashMap findTextListForSel(EnumTextTypeName typeName,int projectId, boolean isPutEmpty) throws RuntimeException;
	
	/**
	 * 查找,用于下拉框(带全部)的选项
	 * @param typeName
	 * @param projectId
	 * @return
	 * @throws RuntimeException
	 */
	public LinkedHashMap findCodeListForSelAll(EnumCodeTypeName typeName,int projectId) throws RuntimeException;
	
	/**
	 * 查找字典描述
	 * @param typeName
	 * @param codeVal
	 * @param projectId
	 * @return
	 * @throws RuntimeException
	 */
	public String findCodeDescByCodeVal(EnumCodeTypeName typeName,String codeVal,int projectId) throws RuntimeException;
	
}