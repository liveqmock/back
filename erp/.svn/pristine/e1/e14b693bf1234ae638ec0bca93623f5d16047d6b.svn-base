package com.ihk.sale.action.guangzhou;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.customer.data.pojo.ProjectRange;
import com.ihk.customer.data.pojo.ProjectRangeCond;
import com.ihk.customer.data.services.IProjectRangeServices;

import com.ihk.utils.DescUtils;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;


/**
 * 意向面积 价格等的设定
 * 
 * 录入为数字
 * 
 * 查询为区间
 * 
 * 项目       那个下拉       vale   最小     最大
 * proId   selId   opName opMin opMax
 * 
 * 要先查询一个项目之后才能添加
 */
public class OptionSetAction extends SupperAction{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired IProjectRangeServices IProjectRangeServices;
	
	private ProjectRange proRan; //增加用
	private ProjectRange updateProRan;//修改用
	private String id;  //修改用ID
	private ProjectRangeCond cond; //搜索用
	private List<ProjectRange> proRanList; //显示用
	private String projectName; //搜索项目名称
	
	private LinkedHashMap selHouseType; //产品类型
	
	/**
	 * 进入页面 项目查询 
	 * */
	public String index(){
		return "suc";
	}
	
	/**
	 * 查询    proRanList
	 * */
	public String search(){
		if(cond == null){
			cond = new ProjectRangeCond();
		}
		this.proRanList = IProjectRangeServices.findProjectRange(cond);
		return "suc";
	}
	
	/**
	 * 新建下拉项
	 * */
	public String indexInput(){
		selHouseType = DescUtils.getInitSelForGuangZhou(selHouseType, EnumCodeTypeName.HOUSE_TYPE);
		return "suc";
	}
	
	/**
	 * 提交表单
	 * 新增
	 * */
	public String form(){
		selHouseType = DescUtils.getInitSelForGuangZhou(selHouseType, EnumCodeTypeName.HOUSE_TYPE);
		//验证
		if(proRan.getProjectId() == 0 || isEmpty(proRan.getRangeName()) || isEmpty(proRan.getRangeType()) || 
				proRan.getEndNum() <= 0 || proRan.getStartNum() < 0){
			addActionMessage("信息不完整不能保存");
			return "suc";
		}
		proRan.setCompanyId(DescUtils.getCompanyIdByProjectId(proRan.getProjectId()));
		proRan.setIsDeleted("0");
		proRan.setCreatedId(SessionUser.getUserId());
		proRan.setCreatedTime(new Date());
		proRan.setModId(SessionUser.getUserId());
		proRan.setModTime(new Date());
		IProjectRangeServices.addProjectRange(proRan);
		//刷新搜索
		if(this.cond == null){
			cond =  new ProjectRangeCond();
		}
		cond.setProjectId(proRan.getProjectId()+"");
		addActionMessage("添加成功");
		return "suc";
	}
	
	
	/**修改信息*/
	public String indexUpdate(){
		if(this.isEmpty(this.id)){
			return "err";
		}
		selHouseType = DescUtils.getInitSelForGuangZhou(selHouseType, EnumCodeTypeName.HOUSE_TYPE);
		this.updateProRan = this.IProjectRangeServices.findProjectRangeById(Integer.parseInt(this.id));
		this.projectName = DescUtils.getCompanyProjectRealName(updateProRan.getProjectId());
		this.request.getSession().setAttribute("oldProRan", updateProRan);
		return "suc";
	}
	
	
	/**
	 * 点击列表可以修改
	 * 弹出框
	 * */
	public String update(){
		selHouseType = DescUtils.getInitSelForGuangZhou(selHouseType, EnumCodeTypeName.HOUSE_TYPE);
		if(updateProRan == null){
			updateProRan = new ProjectRange();
			return "err";
		}
		if(isEmpty(this.id)){
			return "err";
		}
		ProjectRange temp = (ProjectRange)this.request.getSession().getAttribute("oldProRan");
		
		temp.setModTime(new Date());
		temp.setModId(SessionUser.getUserId());
		temp.setHouseType(updateProRan.getHouseType());
		temp.setStartNum(updateProRan.getStartNum());
		temp.setEndNum(updateProRan.getEndNum());
		temp.setProjectId(updateProRan.getProjectId());
		temp.setCompanyId(DescUtils.getCompanyIdByProjectId(updateProRan.getProjectId()));
		temp.setRangeName(updateProRan.getRangeName());
		temp.setRangeType(updateProRan.getRangeType());
		temp.setOrderIndex(updateProRan.getOrderIndex());
		updateProRan.setId(Integer.parseInt(this.id));
		updateProRan.setModId(SessionUser.getProjectId());
		updateProRan.setModTime(new Date());
		IProjectRangeServices.updateProjectRange(temp);
		addActionMessage("修改成功");
		return "suc";
	}
	
	
	private boolean isEmpty(String vi){
		if(vi == null || vi.trim().equals(""))return true;
		
		return false;
	}

	public ProjectRange getProRan() {
		return proRan;
	}

	public void setProRan(ProjectRange proRan) {
		this.proRan = proRan;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ProjectRangeCond getCond() {
		return cond;
	}

	public void setCond(ProjectRangeCond cond) {
		this.cond = cond;
	}

	public List<ProjectRange> getProRanList() {
		return proRanList;
	}

	public void setProRanList(List<ProjectRange> proRanList) {
		this.proRanList = proRanList;
	}

	public ProjectRange getUpdateProRan() {
		return updateProRan;
	}

	public void setUpdateProRan(ProjectRange updateProRan) {
		this.updateProRan = updateProRan;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public LinkedHashMap getSelHouseType() {
		return selHouseType;
	}

	public void setSelHouseType(LinkedHashMap selHouseType) {
		this.selHouseType = selHouseType;
	}
	
	
	
}
