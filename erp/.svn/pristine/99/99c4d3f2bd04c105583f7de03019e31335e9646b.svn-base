package com.ihk.sale.action.guangzhou;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.EnumPrivCode;
import com.ihk.customer.data.ICustomerFollowMapper;
import com.ihk.customer.data.ICustomerMapper;
import com.ihk.customer.data.pojo.CustomerCond;
import com.ihk.customer.data.services.ICustomerFollowServices;
import com.ihk.permission.PermissionUtils;
import com.ihk.user.data.pojo.CompanyProject;
import com.ihk.utils.DescUtils;
import com.ihk.utils.SupperAction;

/**
 * 报表：用户录入情况图形
 * @author peter.kuang
 *
 */
public class ChartUserAccountCustomerNumAction extends SupperAction {

	@Autowired ICustomerFollowMapper iCustomerFollowMapper;
	@Autowired ICustomerMapper iCustomerMapper;
	private CustomerCond custcond;
	private String proId;
	private String projectName;
	
	private List<Map> custList;
	
	/**直接点进来 初始化cond*/
	public String index(){
		//初始化cond
		//初始化显示列表
		if(!vilProId(this.proId)){
			addActionMessage("错误的项目");
			return "success";
		}
	
		 this.projectName = DescUtils.getCompanyProjectRealName(Integer.parseInt(proId));
		initlist();
		return "success";
	}
	
	/**提交form 表单 初始化cond*/
	public String search(){
		initlist();
		this.projectName = DescUtils.getCompanyProjectRealName(this.custcond.getProjectId());
		return "success";	
	}
	
	//初始化显示列表
	@SuppressWarnings("unchecked")
	private void initlist(){
		//得到一个customer list 
		if(custcond == null){
			custcond =  new CustomerCond();
			
		}else{
			this.projectName = DescUtils.getCompanyProjectRealName(this.custcond.getProjectId());
		}
		custcond.setProjectId(Integer.parseInt(this.proId));
//		custList = custList.find...  
		List<Integer> prlist = PermissionUtils.getUserProjectIdList(EnumPrivCode.PRECUSTOMER__DOWNLOAD);
		if(prlist == null || prlist.size() == 0){
			addActionMessage("没有管理用户权限");
			return;
		}
		this.custcond.setProjectIds(prlist);
		boolean tips = true;
		for(Integer i : prlist){
			if(i.toString().equals(this.custcond.getProjectId()+""))tips = false;
		}
		if(tips){
			addActionMessage("没有管理用户权限");
			return ;
		}
		if(custcond.getProjectId() == 0){
			custcond.setProjectId(Integer.parseInt(this.proId));
		}else{
			 this.projectName = DescUtils.getCompanyProjectRealName(custcond.getProjectId());
			 this.proId = custcond.getProjectId()+"";
		}
		try {
			custList = iCustomerMapper.findCustomerForChartUserAccountCustomerNumAction(custcond);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(custList == null || custList.isEmpty()){
			custList = new ArrayList<Map>();
		}
		this.setChartSeriesData(custList);
		
		List<Map> temlist = new ArrayList<Map>() ;
		temlist.addAll(custList);
		
		for(Map p :custList){
			int t = iCustomerFollowMapper.findCountByFollowUser(Integer.parseInt( p.get("userId").toString()));
			p.put("fol", t);
		}//装跟进数
		
		int sum2 = 0;int sum = 0;
		for(Map p :custList){
			sum += Integer.parseInt((p.get("count").toString()));
			sum2 += Integer.parseInt((p.get("fol").toString()));
		}
		
		for(Map p :temlist){
			if(sum != 0 ){
				p.put("pei", Long.parseLong(p.get("count").toString()) * 100/sum+"%");
			}else{
				p.put("pei","0%");
			}
			if(sum2 != 0){
				p.put("peifol", Long.parseLong(p.get("fol").toString()) * 100/sum2+"%");
			}else{
				p.put("peifol","0%");
			}
			
		}//需要加上跟进信息
		
		
		Map e =  new HashMap();
		e.put("realName", "合计");
		e.put("count", sum);
		e.put("pei", "100%");
		e.put("fol", sum2);
		e.put("peifol", "100%");
		custList.add(e);
		
		
		
	}
	//proId必须有
	private boolean vilProId(String projectId){
		try {
			if(projectId == null)return false;
			int t = Integer.parseInt(projectId);
			if(t == 0)return false;
			//后面加 是否有权限项目
			
			
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return true;
		
	}
	private String chartSeriesData;
	
	private void setChartSeriesData(List<Map> custList){
		if(custList.size()==0){
			this.chartSeriesData = "['无数据',1]";
			return ;
		}
		String str = "";
		for(Map p :custList){
			str+= "['"+p.get("realName")+"',"+p.get("count")+"]"+",";
		}
		this.chartSeriesData=str;
	}
	public String getChartSeriesData(){	
		return this.chartSeriesData;
	}	

	public CustomerCond getCustcond() {
		return custcond;
	}

	public void setCustcond(CustomerCond custcond) {
		this.custcond = custcond;
	}

	public List<Map> getCustList() {
		return custList;
	}

	public String getProId() {
		return proId;
	}

	public void setProId(String proId) {
		this.proId = proId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
}
