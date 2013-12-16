package com.ihk.sale.action;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.customer.data.pojo.Customer;
import com.ihk.customer.data.pojo.CustomerCond;
import com.ihk.customer.data.services.ICustomerServices;
import com.ihk.permission.PermissionUtils;
import com.ihk.user.data.pojo.Company;
import com.ihk.user.data.pojo.CompanyProject;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.HengDaUtils;
import com.ihk.utils.SupperAction;

/**
 *  恒大客户汇总
 */
public class CustomerAllAction extends SupperAction{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	ICustomerServices customerServices;
	
	public String customerAll() throws Exception{
		
		HttpSession session = request.getSession();
		
		String from = request.getParameter("from");
		boolean isGet = false;
		boolean isLeft = false;
		
		String date1 = CustomerUtils.getNowForString();
		
		if(customerCond == null)
			customerCond = new CustomerCond();
		
		List<Integer> userProjectIds = HengDaUtils.getUserProjects();
		
		if("left".equals(from)){
			customerCond.setDate1(date1);
			customerCond.setDate2(date1);
			
			customerCond.setProjectIds(userProjectIds);
			
			isLeft = true;
			
			session.removeAttribute("companyId");
			session.removeAttribute("projectId");
			
		}else{
			//点击了搜索
			String getCompanyId = customerCond.getCompanyId();
			String getProjectId = customerCond.getProjectId() + "";
			
			customerCond.setDate1(customerCond.getDate2());
			
			if(CustomerUtils.isStrEmpty(getCompanyId) && "0".equals(getProjectId)){
				//没有选公司,没有选项目
				
				customerCond.setProjectIds(userProjectIds);
				isLeft = true;
			}
			
			if(!CustomerUtils.isStrEmpty(getCompanyId) && "0".equals(getProjectId)){
				//选择了公司,没有选项目
				
				customerCond.setProjectIds(HengDaUtils.getProjectsByCompanyIdForHengDa(Integer.parseInt(getCompanyId)));
			}
			
			if(!CustomerUtils.isStrEmpty(getCompanyId) && !"0".equals(getProjectId)){
				//选择了公司,选择了项目
				List<Integer> setList = new ArrayList<Integer>();
				setList.add(Integer.parseInt(getProjectId));
				
				customerCond.setProjectIds(setList);
			}
			
			session.setAttribute("companyId", getCompanyId);
			session.setAttribute("projectId", getProjectId);
			
		}
		
		//设置项目
		
		//isCompanyShow
		
		if(CustomerUtils.isStrEmpty(customerCond.getCompanyId())){
			isGet = true;
		}
		
		initSelCompany();  //查找该用户所拥有的公司
		initSelProject(isGet);
		initOther(customerCond, isLeft);  //设置统计个数
		
		return "customerAll";
	}
	
	
	////


	private void initOther(CustomerCond customerCond, boolean isLeft) throws Exception{
		
		HttpSession session = request.getSession();
		
		String date2 = customerCond.getDate2();
		List<Integer> projectIds = customerCond.getProjectIds(); //汇总及列表要用到
		
		String weekFirst = CommonUtils.getWeekFirstForString(date2);
		String monthFirst = CommonUtils.getMonthFirstForString(date2);
		String yearFirst = CommonUtils.getYearFirstForString(date2);
		
		session.setAttribute("weekFirst", weekFirst);
		session.setAttribute("monthFirst", monthFirst);
		session.setAttribute("yearFirst", yearFirst);
		
		if(selCompany.size() >= 3 && CustomerUtils.isStrEmpty(customerCond.getCompanyId())){
			
			session.setAttribute(HengDaUtils.IS_COMPANYBUTTOM_SHOW, true);
			session.setAttribute(HengDaUtils.IS_COMPANY_SHOW, true);
		}else{
			
			session.removeAttribute(HengDaUtils.IS_COMPANYBUTTOM_SHOW);
			session.removeAttribute(HengDaUtils.IS_COMPANY_SHOW);
		}
		
		CustomerCond weekCond = new CustomerCond();
		CustomerCond monthCond = new CustomerCond();
		CustomerCond yearCond = new CustomerCond();
		CustomerCond allCond = new CustomerCond();
		
		weekCond.setDate1(weekFirst);
		weekCond.setDate2(date2);
		weekCond.setProjectIds(projectIds);
		
		monthCond.setDate1(monthFirst);
		monthCond.setDate2(date2);
		monthCond.setProjectIds(projectIds);
		
		yearCond.setDate1(yearFirst);
		yearCond.setDate2(date2);
		yearCond.setProjectIds(projectIds);
		
		allCond.setDate2(date2);
		allCond.setProjectIds(projectIds);
		
		List<Customer> customerList = customerServices.findCustomerForHengDa(customerCond);
		List<Customer> weekList = customerServices.findCustomerForHengDa(weekCond);
		List<Customer> monthList = customerServices.findCustomerForHengDa(monthCond);
		List<Customer> yearList = customerServices.findCustomerForHengDa(yearCond);
		List<Customer> allList = customerServices.findCustomerForHengDa(allCond);
		
		//设置汇总统计
		session.setAttribute("weekListSize", weekList.size());
		session.setAttribute("monthListSize", monthList.size());
		session.setAttribute("yearListSize", yearList.size());
		session.setAttribute("allListSize", allList.size());
		session.setAttribute("customerListSize", customerList.size());
		
		//设置列表(没值就显示0)
		
		List<HengDaCustomer> comHengDaCustomerList = new ArrayList<HengDaCustomer>();
		List<HengDaCustomer> proHengDaCustomerList = new ArrayList<HengDaCustomer>();
		
		if(isLeft){
			//查找所有的公司及项目
			
			List<Company> userCompanys = PermissionUtils.getUserCompanyList(); //该用户所拥有的公司
			
			for(Company userCompany : userCompanys){
				
				HengDaCustomer comHengDaCustomer = new HengDaCustomer();
				comHengDaCustomer.setName(userCompany.getCompanyName());
				
				int companyId = userCompany.getId();
				List<Integer> comProjectIds = HengDaUtils.getProjectsByCompanyIdForHengDa(companyId);
				
				if(comProjectIds.size() <= 0){
					
					comHengDaCustomer.setDayCount(0);
					comHengDaCustomer.setWeekCount(0);
					comHengDaCustomer.setMonthCount(0);
					comHengDaCustomer.setYearCount(0);
					
				}else{
					
					customerCond.setProjectIds(comProjectIds);
					customerList = customerServices.findCustomerForHengDa(customerCond);
					comHengDaCustomer.setDayCount(customerList.size());
					
					weekCond.setProjectIds(comProjectIds);
					customerList = customerServices.findCustomerForHengDa(weekCond);
					comHengDaCustomer.setWeekCount(customerList.size());
					
					monthCond.setProjectIds(comProjectIds);
					customerList = customerServices.findCustomerForHengDa(monthCond);
					comHengDaCustomer.setMonthCount(customerList.size());
					
					yearCond.setProjectIds(comProjectIds);
					customerList = customerServices.findCustomerForHengDa(yearCond);
					comHengDaCustomer.setYearCount(customerList.size());
					
				}
				
				comHengDaCustomerList.add(comHengDaCustomer);

			}
			
			List<CompanyProject> userProjects = PermissionUtils.getUserProjectList();
			for(CompanyProject userProject : userProjects){
				
				HengDaCustomer proHengDaCustomer = new HengDaCustomer();
				proHengDaCustomer.setName(userProject.getProjectName());
				
				List<Integer> tmpUserProjectIds = new ArrayList<Integer>();
				tmpUserProjectIds.add(userProject.getId());
				
				customerCond.setProjectIds(tmpUserProjectIds);
				customerList = customerServices.findCustomerForHengDa(customerCond);
				proHengDaCustomer.setDayCount(customerList.size());
				
				weekCond.setProjectIds(tmpUserProjectIds);
				customerList = customerServices.findCustomerForHengDa(weekCond);
				proHengDaCustomer.setWeekCount(customerList.size());
				
				monthCond.setProjectIds(tmpUserProjectIds);
				customerList = customerServices.findCustomerForHengDa(monthCond);
				proHengDaCustomer.setMonthCount(customerList.size());
				
				yearCond.setProjectIds(tmpUserProjectIds);
				customerList = customerServices.findCustomerForHengDa(yearCond);
				proHengDaCustomer.setYearCount(customerList.size());
				
				proHengDaCustomerList.add(proHengDaCustomer);
				
			}
			
			
		}else{
			
			String getCompanyId = customerCond.getCompanyId();
			String getProjectId = customerCond.getProjectId() + "";
			
			if(!CustomerUtils.isStrEmpty(getCompanyId) && "0".equals(getProjectId)){
				//选择了公司,没有选项目
				
				int comId = Integer.parseInt(getCompanyId);
				Company userCompany = HengDaUtils.findCompanyByCompanyId(comId);
				
				HengDaCustomer comHengDaCustomer = new HengDaCustomer();
				comHengDaCustomer.setName(userCompany.getCompanyName());
				
				List<Integer> comProjectIds = HengDaUtils.getProjectsByCompanyIdForHengDa(comId); //该公司下的所有项目
				
				if(comProjectIds.size() <= 0){
					
					comHengDaCustomer.setDayCount(0);
					comHengDaCustomer.setWeekCount(0);
					comHengDaCustomer.setMonthCount(0);
					comHengDaCustomer.setYearCount(0);
					
				}else{
					
					customerCond.setProjectIds(comProjectIds);
					customerList = customerServices.findCustomerForHengDa(customerCond);
					comHengDaCustomer.setDayCount(customerList.size());
					
					weekCond.setProjectIds(comProjectIds);
					customerList = customerServices.findCustomerForHengDa(weekCond);
					comHengDaCustomer.setWeekCount(customerList.size());
					
					monthCond.setProjectIds(comProjectIds);
					customerList = customerServices.findCustomerForHengDa(monthCond);
					comHengDaCustomer.setMonthCount(customerList.size());
					
					yearCond.setProjectIds(comProjectIds);
					customerList = customerServices.findCustomerForHengDa(yearCond);
					comHengDaCustomer.setYearCount(customerList.size());
					
				}
				
				comHengDaCustomerList.add(comHengDaCustomer);
				
				/////
				
				for(int comProjectId : comProjectIds){
					
					CompanyProject userProject = HengDaUtils.findCompanyProjectByProjectId(comProjectId);
					
					HengDaCustomer proHengDaCustomer = new HengDaCustomer();
					proHengDaCustomer.setName(userProject.getProjectName());
					
					List<Integer> tmpUserProjectIds = new ArrayList<Integer>();
					tmpUserProjectIds.add(userProject.getId());
					
					customerCond.setProjectIds(tmpUserProjectIds);
					customerList = customerServices.findCustomerForHengDa(customerCond);
					proHengDaCustomer.setDayCount(customerList.size());
					
					weekCond.setProjectIds(tmpUserProjectIds);
					customerList = customerServices.findCustomerForHengDa(weekCond);
					proHengDaCustomer.setWeekCount(customerList.size());
					
					monthCond.setProjectIds(tmpUserProjectIds);
					customerList = customerServices.findCustomerForHengDa(monthCond);
					proHengDaCustomer.setMonthCount(customerList.size());
					
					yearCond.setProjectIds(tmpUserProjectIds);
					customerList = customerServices.findCustomerForHengDa(yearCond);
					proHengDaCustomer.setYearCount(customerList.size());
					
					proHengDaCustomerList.add(proHengDaCustomer);
					
				}
				
				
			}
			
			if(!CustomerUtils.isStrEmpty(getCompanyId) && !"0".equals(getProjectId)){
				//选择了公司,选择了项目
				List<Integer> setList = new ArrayList<Integer>();
				setList.add(Integer.parseInt(getProjectId));
				
				customerCond.setProjectIds(setList);
				
				CompanyProject userProject = HengDaUtils.findCompanyProjectByProjectId(Integer.parseInt(getProjectId));
				
				HengDaCustomer proHengDaCustomer = new HengDaCustomer();
				proHengDaCustomer.setName(userProject.getProjectName());
				
				List<Integer> tmpUserProjectIds = new ArrayList<Integer>();
				tmpUserProjectIds.add(userProject.getId());
				
				customerCond.setProjectIds(tmpUserProjectIds);
				customerList = customerServices.findCustomerForHengDa(customerCond);
				proHengDaCustomer.setDayCount(customerList.size());
				
				weekCond.setProjectIds(tmpUserProjectIds);
				customerList = customerServices.findCustomerForHengDa(weekCond);
				proHengDaCustomer.setWeekCount(customerList.size());
				
				monthCond.setProjectIds(tmpUserProjectIds);
				customerList = customerServices.findCustomerForHengDa(monthCond);
				proHengDaCustomer.setMonthCount(customerList.size());
				
				yearCond.setProjectIds(tmpUserProjectIds);
				customerList = customerServices.findCustomerForHengDa(yearCond);
				proHengDaCustomer.setYearCount(customerList.size());
				
				proHengDaCustomerList.add(proHengDaCustomer);
			}
			
			
		}
		
		session.setAttribute("proHengDaCustomerList", proHengDaCustomerList);
		session.setAttribute("comHengDaCustomerList", comHengDaCustomerList);
		
		
		
	}
	
	////
	
	class HengDaCustomer implements Serializable{

		/**
		 *  恒大列表bean
		 */
		private static final long serialVersionUID = 1L;
		
		private String name; //项目或公司名称
		private int dayCount;
		private int weekCount;
		private int monthCount;
		private int yearCount;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getDayCount() {
			return dayCount;
		}
		public void setDayCount(int dayCount) {
			this.dayCount = dayCount;
		}
		public int getWeekCount() {
			return weekCount;
		}
		public void setWeekCount(int weekCount) {
			this.weekCount = weekCount;
		}
		public int getMonthCount() {
			return monthCount;
		}
		public void setMonthCount(int monthCount) {
			this.monthCount = monthCount;
		}
		public int getYearCount() {
			return yearCount;
		}
		public void setYearCount(int yearCount) {
			this.yearCount = yearCount;
		}
		
		
	}
	
	////
	
	private CustomerCond customerCond;
	
	private LinkedHashMap<String, String> selCompany;
	private LinkedHashMap<String, String> selProject;
	
	public void setCustomerCond(CustomerCond customerCond) {
		this.customerCond = customerCond;
	}
	
	public CustomerCond getCustomerCond() {
		return customerCond;
	}
	
	public void setSelProject(LinkedHashMap<String, String> selProject) {
		this.selProject = selProject;
	}
	
	public LinkedHashMap<String, String> getSelProject() {
		return selProject;
	}
	
	private void initSelProject(boolean isGet){
		selProject = new LinkedHashMap<String, String>();
		
		selProject.put("", CommonUtils.ALL);
		
		if(!isGet){
			selProject = HengDaUtils.getProjectsByCompanyId(Integer.parseInt(customerCond.getCompanyId()));
		}
		
	}
	
	public void setSelCompany(LinkedHashMap<String, String> selCompany) {
		this.selCompany = selCompany;
	}
	
	public LinkedHashMap<String, String> getSelCompany() {
		return selCompany;
	}
	
	private void initSelCompany(){
		selCompany = HengDaUtils.getSelCompany();
	}
	

}
