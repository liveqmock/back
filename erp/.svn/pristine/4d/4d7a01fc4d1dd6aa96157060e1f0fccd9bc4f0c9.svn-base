package com.ihk.setting.data.services.impl;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.constanttype.EnumTextTypeName;
import com.ihk.setting.data.ICodeDtlMapper;
import com.ihk.setting.data.ICodeTypeMapper;
import com.ihk.setting.data.IProjectCodeMapper;
import com.ihk.setting.data.IProjectTextMapper;
import com.ihk.setting.data.pojo.CodeDtl;
import com.ihk.setting.data.pojo.CodeDtlCond;
import com.ihk.setting.data.pojo.CodeType;
import com.ihk.setting.data.pojo.ProjectCode;
import com.ihk.setting.data.pojo.ProjectCodeCond;
import com.ihk.setting.data.pojo.ProjectTextCond;
import com.ihk.setting.data.services.ICodeTypeServices;
import com.ihk.utils.CacheFrontName;
import com.ihk.utils.CacheUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.cache.MyCacheTemplate;
import com.ihk.utils.cache.MyCacheTemplateCallback;

/**
 * CodeType的Services实现(业务实现)
 * @author 
 *
 */
@Service("codeTypeServices")
@SuppressWarnings("unchecked")
public class CodeTypeServices implements ICodeTypeServices {
	/**
	 * codeType数据访问接口
	 */
	@Autowired	 ICodeTypeMapper codeTypeMapper;
	@Autowired	 ICodeDtlMapper codeDtlMapper;
	@Autowired	 IProjectCodeMapper projectCodeMapper;
	@Autowired   IProjectTextMapper projectTextMapper;

	/**
	 * 查找
	 * @param typeName
	 * @return
	 * @throws RuntimeException
	 */
	public CodeType findCodeTypeByName2(String typeName) throws RuntimeException {
		return codeTypeMapper.findCodeTypeByName(typeName);
	}
	
	/**
	 * 查找
	 */
	@Override
	public CodeType findCodeTypeByName(String typeName) throws RuntimeException {
		
		Object obj = CacheUtils.getValueByCacheNameAndKey(CacheFrontName.CODE_TYPE_CACHE, typeName);
		if(obj == null){
			
			CodeType codeType = codeTypeMapper.findCodeTypeByName(typeName);
			CacheUtils.put(CacheFrontName.CODE_TYPE_CACHE, typeName, codeType);
			
			return codeType; 
		}else{
			return (CodeType) obj;
		}
		
	}
	
	/* (non-Javadoc)
	 * @see com.ihk.setting.data.services.ICodeTypeServices#findCodeList(java.lang.String, int)
	 */
	public List<CodeDtl> findCodeList(String typeName,int projectId) throws RuntimeException {
		//数字为自定义问卷
		if(typeName.matches("^[0-9]+$")){
			ProjectCodeCond cond = new ProjectCodeCond();
			cond.typeName = typeName;
			cond.projectId = projectId;
			return projectCodeMapper.findCodeList(cond);
		}else{
			CodeType codeType = findCodeTypeByName(typeName);
			int isSameInt = Integer.parseInt(codeType.getIsAllsame());
			if(isSameInt == 1){
				CodeDtlCond cond = new CodeDtlCond();
				cond.typeName = typeName;
				return codeDtlMapper.findCodeList(cond);
			}
			else if(isSameInt == 0){
				ProjectCodeCond cond = new ProjectCodeCond();
				cond.typeName = typeName;
				cond.projectId = projectId;
				return projectCodeMapper.findCodeList(cond);
			}else {
				ProjectTextCond cond = new ProjectTextCond();
				cond.setTypeName(typeName) ;
				cond.setProjectId(projectId+"") ;
				return projectTextMapper.findCodeList(cond);
			}
		}
		
	}
	
	/**
	 * 查找用于下拉框
	 */
	public LinkedHashMap findCodeListForSelAll(EnumCodeTypeName typeName,int projectId) throws RuntimeException {
		List<CodeDtl> list = findCodeList(typeName.toString(),projectId);
		LinkedHashMap sel = new java.util.LinkedHashMap();
		sel.put("0", CommonUtils.ALL);
		for(CodeDtl codeDtl : list)    { 
			 sel.put(codeDtl.getCodeVal(),codeDtl.getCodeDesc());
		} 
    
		return sel;
		
	}
	
	/**
	 * 查找用于下拉框
	 */
	public LinkedHashMap findCodeListForSel(EnumCodeTypeName typeName,int projectId) throws RuntimeException {
		List<CodeDtl> list = findCodeList(typeName.toString(),projectId);
		LinkedHashMap sel = new java.util.LinkedHashMap();
		for(CodeDtl codeDtl : list)    { 
			 sel.put(codeDtl.getCodeVal(),codeDtl.getCodeDesc());
		} 
    
		return sel;
	}
	
	/**
	 * 查找用于下拉框
	 */
	public LinkedHashMap findCodeListForSel(EnumCodeTypeName typeName,int projectId, boolean isPutEmpty) throws RuntimeException {
		LinkedHashMap sel = new java.util.LinkedHashMap();
		
		if(isPutEmpty){
			sel.put("", CommonUtils.EMPTY);
		}
		sel.putAll(findCodeListForSel(typeName, projectId));
    
		return sel;
	}
	
	//避免每一次都要重新new一个新的变量,
	private CodeDtlCond dtlCond;
	private ProjectCodeCond codeCond;
	
	/**
	 * 查找
	 * @param typeName
	 * @param codeVal
	 * @param projectId
	 * @return
	 * @throws RuntimeException
	 */
	public String findCodeDescByCodeVal(EnumCodeTypeName typeName,String codeVal,int projectId) throws RuntimeException {
		if(CommonUtils.isStrEmpty(codeVal)){
			return "";
		}
		
		CodeType codeType = findCodeTypeByName(typeName.toString());
				
		if(codeType.isAllsame()){
			
			if(dtlCond == null){
				dtlCond = new CodeDtlCond();
			}
			dtlCond.typeName = typeName.toString();
			dtlCond.codeVal = codeVal;
			
			String key = typeName.toString() +"_"+ codeVal;
			
			CodeDtl obj = (CodeDtl) MyCacheTemplate.cache(CacheFrontName.CODE_DTL_CACHE, key, new MyCacheTemplateCallback() {
				@Override
				public Object doCache() throws Exception {
					return codeDtlMapper.findCodeDescByCodeVal(dtlCond);
				}
			});
			
			return obj == null ? "" : obj.getCodeDesc();
			
		}else{
			
			if(codeCond == null){
				codeCond = new ProjectCodeCond();
			}
			codeCond.typeName = typeName.toString();
			codeCond.codeVal = codeVal;
			codeCond.projectId = projectId;
			
			String key = typeName.toString() +"_"+ codeVal +"_"+ projectId;
			
			ProjectCode pCode = (ProjectCode) MyCacheTemplate.cache(CacheFrontName.PROJECT_CODE_CACHE, key, new MyCacheTemplateCallback() {
				
				@Override
				public Object doCache() throws Exception {
					return projectCodeMapper.findCodeDescByCodeVal(codeCond);
				}
			});
			
			return pCode == null ? "" : pCode.getCodeDesc();
		}
		
	}

	/**
	 * 查找用于下拉框
	 */
	@Override
	public LinkedHashMap findTextListForSel(EnumTextTypeName typeName,
			int projectId, boolean isPutEmpty) throws RuntimeException {
		LinkedHashMap sel = new java.util.LinkedHashMap();
		if(isPutEmpty){
			sel.put("", CommonUtils.EMPTY);
		}
		sel.putAll(findTextListForSel(typeName, projectId));
		sel.put(CommonUtils.ADD_SELECT_VALUE, CommonUtils.ADD_SELECT_TEXT);
		return sel;
	}
	
	/**
	 * 查找用于下拉框
	 * @param typeName
	 * @param projectId
	 * @return
	 */
	public LinkedHashMap findTextListForSel(EnumTextTypeName typeName,int projectId){
		List<CodeDtl> list = findCodeList(typeName.toString(),projectId);
		LinkedHashMap sel = new java.util.LinkedHashMap();
		for(CodeDtl codeDtl : list)    { 
			 sel.put(codeDtl.getCodeVal(),codeDtl.getCodeDesc());
		} 
		return sel;
	}
	
}
