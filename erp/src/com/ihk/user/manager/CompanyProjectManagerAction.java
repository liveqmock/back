package com.ihk.user.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.EnumPrivCode;
import com.ihk.permission.PermissionUtils;
import com.ihk.user.data.pojo.Company;
import com.ihk.user.data.pojo.CompanyCond;
import com.ihk.user.data.pojo.CompanyProject;
import com.ihk.user.data.pojo.CompanyProjectCond;
import com.ihk.user.data.pojo.UserRole;
import com.ihk.user.data.services.ICompanyProjectServices;
import com.ihk.user.data.services.ICompanyServices;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;

/**
 * 后台管理 - 项目管理
 * */
public class CompanyProjectManagerAction extends SupperAction{
	private static final long serialVersionUID = 1L;
	
	@Autowired ICompanyProjectServices companyProjectServices;
	@Autowired ICompanyServices companyServices;
	private List<CompanyProject> proList;//该分公司项目列表
	private CompanyProjectCond cond;
	private List<Company> comList;
	private int comId;
	/**
	 * 项目管理查询主页面
	 * */
	public String indexSearch(){
		init();
		return "suc";
	}

	private int rows;
	private int page;
	public String indexSearchJson(){
		if(cond == null){
			cond = new CompanyProjectCond();
		}
		if(comId!=0){
			cond.setCompanyId(comId);
		}
		List<Integer> projectIds = PermissionUtils.getUserProjectIdList(EnumPrivCode.SYSTEM_POWER_RETRIEVE);
		cond.setProjectIds(projectIds);
		
		int count = companyProjectServices.findCompanyProjectCount(cond);
		cond.setOrderByFiled("idDesc");
		cond.pageSize = rows;
		cond.startLine = (page - 1) * rows;
		this.proList = this.companyProjectServices.findCompanyProjectPage(cond);
		
		
		
        JSONArray proJsList = new JSONArray();
		JSONObject onePro = new JSONObject();
		
		for(CompanyProject cc : proList){
			onePro.put("name", cc.getProjectName());
			onePro.put("cname", cc.getDescCompanyId());
			onePro.put("cdate", cc.getCreatedTime().toLocaleString());
			onePro.put("id", cc.getId());
			onePro.put("cuser", cc.getDescCreatedId());
			proJsList.add(onePro);
		}
		Map<String, Object> json = new HashMap<String, Object>();
		json.put("total", count);// total键 存放总记录数，必须的
		json.put("rows", proJsList);// rows键 存放每页记录 list
		res = JSONObject.fromObject(json);// 格式化result一定要是JSONObject
		return "suc";
	}
	
	private void init(){		
		CompanyCond cond = new CompanyCond();
		cond.setCompanyIds(PermissionUtils.getUserCompanyIdList());
		comList = this.companyServices.findCompany(cond);
	}
	
	
	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	private JSONObject res;
	
	
	public JSONObject getRes() {
		return res;
	}

	public void setRes(JSONObject res) {
		this.res = res;
	}

	public List<CompanyProject> getProList() {
		return proList;
	}

	public void setProList(List<CompanyProject> proList) {
		this.proList = proList;
	}

	public CompanyProjectCond getCond() {
		return cond;
	}

	public void setCond(CompanyProjectCond cond) {
		this.cond = cond;
	}

	public List<Company> getComList() {
		return comList;
	}

	public void setComList(List<Company> comList) {
		this.comList = comList;
	}

	public int getComId() {
		return comId;
	}

	public void setComId(int comId) {
		this.comId = comId;
	}
	
	
	
}
