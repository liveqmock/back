package com.ihk.sale.action;

import java.util.LinkedHashMap;
import java.util.Set;

import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.HengDaUtils;
import com.ihk.utils.SupperAction;

/**
 *  公司,项目的下拉框aciton
 */
public class CompanyProjectAction extends SupperAction{

	private static final long serialVersionUID = 1L;
	
	public String getProjectByCompanyId() throws Exception{
		String content = "<option value=\"\">" + CommonUtils.ALL + "</option>"; //默认值
		
		String companyId = request.getParameter("companyId");
		try{
			
			LinkedHashMap<String, String> projectMap = HengDaUtils.getProjectsByCompanyId(Integer.parseInt(companyId));
			
			StringBuffer sb = new StringBuffer();
			
			if(projectMap.keySet().size() > 1){
				Set<String> keys = projectMap.keySet();
				for(String key : keys){
					String value = projectMap.get(key);
					sb.append("<option value=\"")
						.append(key)
						.append("\">")
						.append(value)
						.append("</option>")
						;
				}
				
			}
			
			String getContent = sb.toString();
			if(!CustomerUtils.isStrEmpty(getContent)){
				content = getContent;
			}
			
		}catch(Exception e){
			
		}
		
		CustomerUtils.writeResponse(response, content);
		
		return null;
	}
	
}
