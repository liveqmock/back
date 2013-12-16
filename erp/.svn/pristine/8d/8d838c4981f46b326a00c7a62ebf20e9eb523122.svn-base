package com.ihk.sale.action;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.sale.data.pojo.SaleMonitor;
import com.ihk.sale.data.pojo.SaleMonitorAmount;
import com.ihk.sale.data.pojo.SaleMonitorCond;
import com.ihk.sale.data.pojo.SaleMonitorMonth;
import com.ihk.sale.data.services.ISaleMonitorMonthServices;
import com.ihk.sale.data.services.ISaleMonitorServices;
import com.ihk.user.data.services.ICompanyProjectServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.HengDaUtils;
import com.ihk.utils.SupperAction;

/**
 *  分段汇总
 */
public class SearchTimeAction extends SupperAction{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	ISaleMonitorServices saleMonitorServices;
	@Autowired
	ISaleMonitorMonthServices saleMonitorMonthServices;
	@Autowired
	ICompanyProjectServices comProjectServices;
	
	
	public String searchTime() throws Exception{
		HttpSession session = request.getSession();
		
		if(saleTimeCond == null){
			saleTimeCond = new SaleMonitorCond();
		}
		if(CustomerUtils.isStrEmpty(saleTimeCond.getDate1())){
			saleTimeCond.setDate1(CommonUtils.getMonthFirstForString());  //为月初
		}
		if(CustomerUtils.isStrEmpty(saleTimeCond.getDate2())){
			saleTimeCond.setDate2(CommonUtils.getNowForString());
		}
		
		List<Integer> projectIds = new ArrayList<Integer>();
		
		String from = request.getParameter("from");
		if("left".equals(from)){
			//此时总是为该登陆用户的projectId
			
			projectIds = HengDaUtils.getUserProjects();
		}else{
			String getCompanyId = saleTimeCond.getCompanyId();
			int getProjectId = saleTimeCond.getProjectId();
			
			projectIds = HengDaUtils.getUserProjects();
			
			if(!CustomerUtils.isStrEmpty(getCompanyId)){
				
				if(getProjectId != 0){
					//选了单个项目
					
					projectIds.clear();
					projectIds.add(getProjectId);
				}else{
					//单个公司下的所有项目
					
					projectIds = HengDaUtils.getUserProjectsByCompanyId(Integer.parseInt(getCompanyId), projectIds);
					
				}
			}
			
		}
		
		initSelCompany();
		initSelProject(true);
		
		saleTimeCond.setProjectIds(projectIds);
		if(!projectIds.isEmpty()){
			//为空时表示该用户在该查询组合下没有符合的记录,不用再去查数据库
			saleTypeList = saleMonitorServices.findSaleMonitorList(saleTimeCond);
		}
		
		amount = initSaleMonitorMonthAmount(amount, saleTypeList);
		 
		session.setAttribute("saleTypeList", saleTypeList);  //下载使用 ,没有分页不用利用saleWeekCond再查询一次
		session.setAttribute("companyId", saleTimeCond.getCompanyId());
		session.setAttribute("projectId", saleTimeCond.getProjectId());
		
		//判断是否公司及项目都是一个,如果都是一个,那么就让公司项目处于选择状态
		LinkedHashMap<String, String> getSelPro = HengDaUtils.setSessionIfCompanyAndProjectOne(request);
		if(getSelPro != null){
			selProject = getSelPro;
		}
		
		
		return "searchTime";
	}
	
	@SuppressWarnings("unchecked")
	public String downLoadTime() throws Exception{
		HttpSession session = request.getSession();
		
		Object getObject = session.getAttribute("saleTypeList");
		List<SaleMonitorMonth> getList = new ArrayList<SaleMonitorMonth>();
		if(getObject != null){
			getList = (List<SaleMonitorMonth>) getObject;
		}
		
		try{
			HengDaUtils.downLoadTemplate("saleTypeList", getList, "saleType.xls", "download-" + CustomerUtils.getNowForString() + "-.xls", response);
		}catch(Exception e){
			System.out.println(e);
		}
		return null;
		
	}
	
	/////////////////
	
	private LinkedHashMap<String, String> selCompany;
	private LinkedHashMap<String, String> selProject;
	
	private SaleMonitorCond saleTimeCond;
	private List<SaleMonitor> saleTypeList;
	
	private SaleMonitorAmount amount;
	
	public void setSelProject(LinkedHashMap<String, String> selProject) {
		this.selProject = selProject;
	}
	
	public LinkedHashMap<String, String> getSelProject() {
		return selProject;
	}
	
	private void initSelProject(boolean isGet){
		selProject = new LinkedHashMap<String, String>();
		selProject.put("", CommonUtils.ALL);
		
		if(isGet){
			String getCompanyId = saleTimeCond.getCompanyId();
			if(!CustomerUtils.isStrEmpty(getCompanyId) && !"0".equals(getCompanyId)){
				selProject = HengDaUtils.getProjectsByCompanyId(Integer.parseInt(getCompanyId));
			}
			
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
	
	public void setAmount(SaleMonitorAmount amount) {
		this.amount = amount;
	}
	
	public SaleMonitorAmount getAmount() {
		return amount;
	}
	
	public void setSaleTypeList(List<SaleMonitor> saleTypeList) {
		this.saleTypeList = saleTypeList;
	}
	
	public List<SaleMonitor> getSaleTypeList() {
		return saleTypeList;
	}
	
	public void setSaleTimeCond(SaleMonitorCond saleTimeCond) {
		this.saleTimeCond = saleTimeCond;
	}
	
	public SaleMonitorCond getSaleTimeCond() {
		return saleTimeCond;
	}
	
	private SaleMonitorAmount initSaleMonitorMonthAmount(SaleMonitorAmount saleMonitorAmount, List<SaleMonitor> saleList){
		if(saleMonitorAmount == null)
			saleMonitorAmount = new SaleMonitorAmount();
		
		if(saleList != null){
			for(SaleMonitor sale : saleList){
				saleMonitorAmount.setPhoneNum(saleMonitorAmount.getPhoneNum() + sale.getPhoneNum());
				saleMonitorAmount.setVisitorNum(saleMonitorAmount.getVisitorNum() + sale.getVisitorNum());
				
				saleMonitorAmount.setSumNum(saleMonitorAmount.getSumNum() + sale.getSumNum());
				saleMonitorAmount.setSumArea(saleMonitorAmount.getSumArea().add(sale.getSumArea()));
				saleMonitorAmount.setSumMoney(saleMonitorAmount.getSumMoney().add(sale.getSumMoney()));
				
				saleMonitorAmount.setUndoSumNum(saleMonitorAmount.getUndoSumNum() + sale.getUndoSumNum());
				saleMonitorAmount.setUndoSumArea(saleMonitorAmount.getUndoSumArea().add(sale.getUndoSumArea()));
				saleMonitorAmount.setUndoSumMoney(saleMonitorAmount.getUndoSumMoney().add(sale.getUndoSumMoney()));
				
				saleMonitorAmount.setIntentionNum(saleMonitorAmount.getIntentionNum() + sale.getIntentionNum()); //认筹
				
			}
		}
		
		return saleMonitorAmount;
		
	}
	
}
