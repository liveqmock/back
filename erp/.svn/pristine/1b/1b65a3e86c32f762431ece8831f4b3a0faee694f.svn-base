package com.ihk.utils;
import com.opensymphony.xwork2.ActionContext;
import java.util.Map;
import java.util.HashMap;  
import java.util.LinkedHashMap;
import java.util.List;
import org.apache.log4j.Logger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.text.ParseException;
import java.math.BigDecimal;
import java.util.ArrayList;
import org.joda.time.DateTime;
import org.joda.time.Days;
import com.ihk.user.data.pojo.Company;
import com.ihk.user.data.pojo.CompanyProject;
import com.ihk.permission.PermissionUtils;

/**
 * 界面控件的公用类
 * @author dtc
 * 2012-9-29
 */
public class UIUtils {
	
	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(UIUtils.class);
	
	
	// 初始化用户的项目下拉框
	public static  LinkedHashMap<String, String> getListSelProjectWithAll() {
		LinkedHashMap<String, String> selProject = new LinkedHashMap<String, String>();
		selProject.put("", CommonUtils.ALL);
		List<CompanyProject> userProjects = PermissionUtils
				.getUserProjectListByUid(SessionUser.getUserId());
				
		for (CompanyProject pro : userProjects) {
			selProject.put(pro.getId() + "", pro.getProjectName());
		}
		
		return selProject;
	}
	
	// 初始化用户的公司下拉框
	public static  LinkedHashMap<String, String> getListSelCompanyWithAll() {
		LinkedHashMap<String, String> selCompany = new LinkedHashMap<String, String>();
		selCompany.put("", CommonUtils.ALL);			
		
		List<Company> userCompanys = PermissionUtils.getUserCompanyListByUid(SessionUser.getUserId());
		for (Company com : userCompanys) {
			selCompany.put(com.getId() + "", com.getCompanyName());
		}
		
		return selCompany;
	}
	
	
	// 初始化统计的周期下拉框
	public static  LinkedHashMap<String, String> getListSelCycel() {
		LinkedHashMap<String, String> listSelCycel = new LinkedHashMap<String, String>();
		listSelCycel.put("day","日");
		listSelCycel.put("week","周");
		listSelCycel.put("month","月");
		return listSelCycel;
	}
	
	
	
}