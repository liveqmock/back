package com.ihk.customer.action;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.ContCompanyId;
import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.setting.data.services.ICodeTypeServices;
import com.ihk.user.data.pojo.CompanyProject;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.SupperAction;

/**
 * 家庭收入
 */
@SuppressWarnings({"rawtypes","unchecked"})
public class SelFamilyIncome extends SupperAction {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	ICodeTypeServices codeTypeServices;
	
	public String getSelFamilyIncome() throws Exception{
		
		String projectName = request.getParameter("projectName");
		
		CompanyProject project = DescUtils.findCompanyProjectIsExistsByProjectNameAndCompanyId(projectName, ContCompanyId.GUANG_ZHOU);
		
		LinkedHashMap map = codeTypeServices.findCodeListForSel(EnumCodeTypeName.FAMILY_INCOME, project.getId());
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("<option value=\"\">")
			.append(CommonUtils.EMPTY)
			.append("</option>")
			;
		
		if(map.size() >= 1){
			
			for(Object key : map.keySet()){
				Object value = map.get(key);
				
				sb.append("<option value=\"")
					.append(key.toString())
					.append("\">")
					.append(value.toString())
					.append("</option>")
					;
				
			}
			
		}
		
		
		CustomerUtils.writeResponse(response, sb.toString());
		
		return null;
	}
	
	public String getSelFamilyIncomeByProjectId() throws Exception{
		
		int projectId = Integer.parseInt(request.getParameter("projectId"));
		
		LinkedHashMap map = codeTypeServices.findCodeListForSel(EnumCodeTypeName.FAMILY_INCOME, projectId, true);
		
		CustomerUtils.writeResponse(response, CommonUtils.getSelectContent(map));
		
		return null;
	}

}
