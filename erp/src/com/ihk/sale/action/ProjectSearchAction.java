package com.ihk.sale.action;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.user.data.pojo.Company;
import com.ihk.user.data.pojo.CompanyCond;
import com.ihk.user.data.pojo.CompanyProject;
import com.ihk.user.data.pojo.CompanyProjectCond;
import com.ihk.user.data.pojo.ProjectState;
import com.ihk.user.data.pojo.ProjectStateCond;
import com.ihk.user.data.services.ICompanyProjectServices;
import com.ihk.user.data.services.ICompanyServices;
import com.ihk.user.data.services.IProjectStateServices;
import com.ihk.utils.Pager;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;


/**
 * 项目查找
 */
public class ProjectSearchAction extends SupperAction{

	private static final long serialVersionUID = 1L;
	
	@Autowired ICompanyProjectServices iCompanyProjectServices;
	@Autowired IProjectStateServices iProjectStateServices;
	@Autowired ICompanyServices iCompanyServices;
	
	private int IS_HENGDA = 1;
	private String IS_SALE = "1";
	private String IS_DELETED_0 = "0";
	
	private List<CompanyProject> prolist;//显示用list
	private CompanyProject updatePro;//修改后的结果
	private CompanyProject selectPro;//选择的项目
	private List<ProjectState> statelist;//修改pro页面显示各种该项目的相关修改信息
	private CompanyProjectCond proCond;//project_search.jsp查询条件
	private String id;//选择的ID 最后修改的
	private List<Company> companylist;

	
	/**跳转project_search.jsp*/
	public String searchProject(){
		CompanyCond comcond = new CompanyCond();
		comcond.setParentId(this.IS_HENGDA);
		this.companylist = iCompanyServices.findCompanyPage(comcond);
//		init(new CompanyProjectCond());
		return "search";
	}
	
	/**删除pro */
	@Deprecated
	public String delProject(){//暂时不用 如果以后要用     需要和多表进行联动
		return "search";
	}
	
	/**
	 * project_search.jsp页面查询表单提交
	 * 按state查 按公司查 以及排序
	 * */
	public String searchProjectForm(){
		if(proCond == null)proCond = new CompanyProjectCond();
		init(proCond);
		return "search";
	}
	
	/**
	 * 修改pro的状态state 
	 * 跳转 project_update.jsp
	 * */
	public String updateProject(){
		if(!this.vilId()){//id不合法
			addActionMessage("选择的项目ID不合法");
			return searchProject();
		}
		selectPro = iCompanyProjectServices.findCompanyProjectById(Integer.parseInt(this.id));//页面显示
		ProjectStateCond cond = new ProjectStateCond();
		cond.setProjectId(id);
		statelist = iProjectStateServices.findProjectState(cond);//显示修改记录
		return "update";
	}
	
	/**
	 * 修改pro的状态  project_state .  1 = 活动 ,2 = 废止,
	 * 提交表单 如果修改成功 
	 * 在 project_state表 里要加
	 * 一条相应的数据
	 * */
	public String updateProjectForm(){
		if(!this.vilId() || updatePro == null){//id不合法
			addActionMessage("选择的项目ID不合法");
			return searchProject();
		}
		selectPro = iCompanyProjectServices.findCompanyProjectById(Integer.parseInt(this.id));//页面显示
		ProjectStateCond cond = new ProjectStateCond();
		cond.setProjectId(id);
		statelist = iProjectStateServices.findProjectState(cond);//显示修改记录
		
		if(updatePro.getProjectState().trim().equals(selectPro.getProjectState())){//这个页面只修改项目状态 如果提交的结果 state没有变则直接修改成功 ;
			return "update";
		}
		String tempstate = updatePro.getProjectState().trim();//修改的状态是否合适
		if(tempstate.equals("1") || tempstate.equals("2")){
//			CompanyProject tempPro = new CompanyProject();//执行修改的pro实现
//			tempPro.setProjectState(tempstate);
//			tempPro.setId(Integer.parseInt(id));
//			tempPro.setModId(SessionUser.getUserId());
//			tempPro.setModTime(new Date());
			selectPro.setModTime(new Date());
			selectPro.setModId(SessionUser.getUserId());
			selectPro.setProjectState(updatePro.getProjectState().trim());
			this.iCompanyProjectServices.updateCompanyProject(selectPro);
			this.updateProjectState(selectPro);//project _ state + 1
			addActionMessage("修改成功");
		}else {
			addActionMessage("选择的项目状态不合法");
			return "update";
		}
		return "update";
	}
	
	
	
	//如果修改了状态  则调添加一条记录 >  project _ state
	private void updateProjectState(CompanyProject tempPro){
		
		ProjectState state = new ProjectState(tempPro.getId(),
				tempPro.getProjectState(),
				tempPro.getModTime(),
				IS_DELETED_0,
				SessionUser.getUserId(),
				tempPro.getModTime(),
				SessionUser.getUserId(),
				tempPro.getModTime());
		
		iProjectStateServices.addProjectState(state);
	}
	
	//验证ID是否合法
	private boolean vilId(){
		System.out.println("id= " +id);
		boolean tip = false;
		try {//id是否能转数字
			int tempid = Integer.parseInt(id);
			if(tempid == 0)return false;
			CompanyProjectCond procond = new CompanyProjectCond() ;
			procond.setIsSale(IS_SALE);
			this.prolist = iCompanyProjectServices.findCompanyProjectPage(procond);
			for(CompanyProject p:prolist){//是否是有效的id
				if(p.getId() == tempid){
					tip = true;
					return tip;
				}
			}		
		} catch (Exception e) {
			return false;
		}
		return tip;
	}
	
	//显示用prolist companylist 
	private void init(CompanyProjectCond procond){
		
		procond.setIsSale(this.IS_SALE);
//		this.prolist = iCompanyProjectServices.findCompanyProject();
		this.prolist = iCompanyProjectServices.findCompanyProjectPage(procond);
		CompanyCond comcond = new CompanyCond();
		comcond.setParentId(this.IS_HENGDA);
		this.companylist = iCompanyServices.findCompanyPage(comcond);
	}
	
	////////////set and get
	public List<CompanyProject> getProlist() {
		return prolist;
	}
	
	public void setProlist(List<CompanyProject> prolist) {
		this.prolist = prolist;
	}

	public CompanyProject getUpdatePro() {
		return updatePro;
	}

	public void setUpdatePro(CompanyProject updatePro) {
		this.updatePro = updatePro;
	}

	public CompanyProject getSelectPro() {
		return selectPro;
	}

	public void setSelectPro(CompanyProject selectPro) {
		this.selectPro = selectPro;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<ProjectState> getStatelist() {
		return statelist;
	}

	public void setStatelist(List<ProjectState> statelist) {
		this.statelist = statelist;
	}

	public CompanyProjectCond getProCond() {
		return proCond;
	}

	public void setProCond(CompanyProjectCond proCond) {
		this.proCond = proCond;
	}

	public List<Company> getCompanylist() {
		return companylist;
	}

	public void setCompanylist(List<Company> companylist) {
		this.companylist = companylist;
	}
	
	
}
