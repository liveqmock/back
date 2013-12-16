package com.ihk.sale.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.sale.data.pojo.SaleMonitorCond;
import com.ihk.sale.data.services.ISaleMonitorServices;
import com.ihk.user.data.pojo.CompanyProject;
import com.ihk.user.data.services.ICompanyProjectServices;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.HengDaUtils;
import com.ihk.utils.SupperAction;

/**
 * 录入次数查询
 */
public class SearchInCountAction extends SupperAction{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	ISaleMonitorServices saleMonitorServices; 
	@Autowired
	ICompanyProjectServices projectServices;
	
	public String searchInCount() throws Exception{
		
		if(inputCountCond == null){
			inputCountCond = new SaleMonitorCond();
			
			inputCountCond.setDate1(CustomerUtils.getNowForString());
			inputCountCond.setDate2(CustomerUtils.getNowForString());
		}
		
		beanList = setShowBeanFromCond(inputCountCond);
		 
		return "searchInCount";
	}
	
	public String searchInCountForm() throws Exception{
		
		beanList = setShowBeanFromCond(inputCountCond);
		
		return "searchInCountForm";
	}
	
	private List<ShowBean> setShowBeanFromCond(SaleMonitorCond cond){
		
		List<Integer> projectIds = HengDaUtils.getUserProjects();
		cond.setProjectIds(projectIds);
		 
		List<ShowBean> retBeanList = new ArrayList<ShowBean>();
		 
		//map--> projectId, companyId, cou
		List<Map<String, Integer>> getValues = saleMonitorServices.findSaleMonitorInCount(cond);
		 
		//有值的
		for(Map<String, Integer> value : getValues){
			 int projectId = value.get("projectId");
			 int companyId = value.get("companyId");
			 int cou = value.get("cou");
			 
			 ShowBean bean = new ShowBean();
			 bean.setProjectId(projectId);
			 bean.setCompanyId(companyId);
			 bean.setCou(cou);
			 
			 retBeanList.add(bean);
			 
			 projectIds.remove(new Integer(projectId)); //
			 
		}
		 
		 //没值的
		for(int projectId : projectIds){
			 ShowBean bean = new ShowBean();
			 bean.setProjectId(projectId);
			 bean.setCou(0);
			 
			 retBeanList.add(bean);
		}
		 
		Collections.sort(retBeanList, new ShowBeanComparator()); //按录入个数排序
		
		for(ShowBean bean : retBeanList){
			int projectId = bean.getProjectId();
			
			CompanyProject project = projectServices.findCompanyProjectById(projectId);
			bean.setCompanyId(project.getCompanyId());
			bean.setProjectName(project.getProjectName());
		}
		
		return retBeanList;
	}
	
	
	///
	
	private SaleMonitorCond inputCountCond;
	private List<ShowBean> beanList;
	
	public void setInputCountCond(SaleMonitorCond inputCountCond) {
		this.inputCountCond = inputCountCond;
	}
	
	public SaleMonitorCond getInputCountCond() {
		return inputCountCond;
	}
	
	public void setBeanList(List<ShowBean> beanList) {
		this.beanList = beanList;
	}
	
	public List<ShowBean> getBeanList() {
		return beanList;
	}
	
	class ShowBean implements java.io.Serializable{

		/**
		 * 用于显示的bean
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		private int projectId;
		private String projectName;
		private int companyId;
		private int cou;
		public int getProjectId() {
			return projectId;
		}
		public void setProjectId(int projectId) {
			this.projectId = projectId;
		}
		public int getCompanyId() {
			return companyId;
		}
		public void setCompanyId(int companyId) {
			this.companyId = companyId;
		}
		public int getCou() {
			return cou;
		}
		public void setCou(int cou) {
			this.cou = cou;
		}
		public String getProjectName() {
			return projectName;
		}
		public void setProjectName(String projectName) {
			this.projectName = projectName;
		}
		
	}
	
	class ShowBeanComparator implements Comparator<ShowBean>{

		@Override
		public int compare(ShowBean o1, ShowBean o2) {
			
			if(o1.getCou() >= o2.getCou()){
				
				return 1;
			}else{
				
				return -1;
			}
		}
		
	}

}
