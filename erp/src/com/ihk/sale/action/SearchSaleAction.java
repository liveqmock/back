package com.ihk.sale.action;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.sale.data.pojo.SaleMonitor;
import com.ihk.sale.data.pojo.SaleMonitorAmount;
import com.ihk.sale.data.pojo.SaleMonitorCond;
import com.ihk.sale.data.services.ISaleMonitorServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.HengDaUtils;
import com.ihk.utils.Pager;
import com.ihk.utils.SupperAction;
import com.opensymphony.xwork2.ActionContext;

/**
 *  查询销控数据
 */
public class SearchSaleAction extends SupperAction {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	ISaleMonitorServices saleMonitorServices;
	
	
	@SuppressWarnings("unchecked")
	public String searchSale() throws Exception{
		
		String ret = request.getParameter("ret"); //判断是否从汇总过来的
		String from = request.getParameter("from");  //按条件搜索时就为空
		boolean isGet = true;
		
		HttpSession session = request.getSession();
		Object obj = session.getAttribute(CommonUtils.USER_SESSION_KEY);
		if(obj == null){
			//如果没有数据就跳回登陆界面
			return "loginFail";
		}
		
		String action = CustomerUtils.getActionNameFromRequest(request);
		Pager page = new Pager(ActionContext.getContext(),pageSize,action);
		
		String date = CommonUtils.getNowForString();
		
		if("left".equals(from)){
			//点击左边或顶上的"查询客户"
			session.removeAttribute("saleCond"); //清空该session
			
			saleCond = new SaleMonitorCond(); 
			saleCond.setDate1(date);
			saleCond.setDate2(date);
			
			isGet = false;
			
		}else{
			
			Map<String, String[]> map = request.getParameterMap();
			if(map.containsKey("ob") || "return".equals(from)){
				//表示点击了排序, 返回
				Object getCond = session.getAttribute("saleCond");
				saleCond = (SaleMonitorCond) getCond;
				
			}
			
			if(saleCond == null){ //登陆
				saleCond = new SaleMonitorCond();
				saleCond.setDate1(date);
				saleCond.setDate2(date);
				
			}
			
		}
		
		String type = request.getParameter("type");
		
		if("week".equalsIgnoreCase(type)){
			
			saleCond.setDate1(CommonUtils.getWeekFirstForString());
			saleCond.setDate2(CommonUtils.getWeekEndForString());
		}else if("month".equalsIgnoreCase(type)){
			
			saleCond.setDate1(CommonUtils.getMonthFirstForString());
			saleCond.setDate2(CommonUtils.getMonthEndForString());
			
		}else if("lastWeek".equalsIgnoreCase(type)){
			saleCond.setDate1(CommonUtils.getLastWeekFirstForString());
			saleCond.setDate2(CommonUtils.getLastWeekEndForString());
			
		}else if("lastMonth".equalsIgnoreCase(type)){
			saleCond.setDate1(CommonUtils.getLastMonthFirstForString());
			saleCond.setDate2(CommonUtils.getLastMonthEndForString());
			
		}else if("listWeek".equalsIgnoreCase(type)){
			//汇总查询中跳转过来的
			
		}
		
		initSelCompany();
		initSelProject(isGet);
		initOther();
		
		page.setCond(saleCond);
		saleList = saleMonitorServices.findSaleMonitorPage(saleCond);
		
		List<SaleMonitor> allSaleList = saleMonitorServices.findSaleMonitor(saleCond);
		
		amount = initSaleMonitorAmount(amount, saleList);
		allAmount = initSaleMonitorAmount(allAmount, allSaleList);
		
		session.setAttribute("allSaleList", allSaleList); //下载使用
		
		session.setAttribute("saleCond", saleCond);   //供查找返回,排序及下载使用
		session.removeAttribute("suggestion");
		
		this.setShowPage(page.toHtmlString());
		
		if(!CustomerUtils.isStrEmpty(ret)){
			//表示从汇总过来的
			session.setAttribute("isRetShow", true);
		}else{
			
			session.removeAttribute("isRetShow");
		}
		
		//如果是从空白公司过来的,就要去掉retUrl中的emptyProject
		String fromEmptyCompany = request.getParameter("fromEmptyCompany");
		if(!CustomerUtils.isStrEmpty(fromEmptyCompany)){
			Object retUrlObj = session.getAttribute("retUrl");
			if(retUrlObj != null){
				String retUrl = retUrlObj.toString();
				retUrl = retUrl.replace("&emptyProject=emptyProject", "");
				session.setAttribute("retUrl", retUrl);
			}
			
		}
		
		
		return "searchSale";
	}
	
	@SuppressWarnings("unchecked")
	public String downLoadSale() throws Exception{
		
		HttpSession session = request.getSession();
		
		Object getObject = session.getAttribute("allSaleList");
		List<SaleMonitor> getList = new ArrayList<SaleMonitor>();
		if(getObject != null){
			getList = (List<SaleMonitor>) getObject;
		}
		
		try{
			HengDaUtils.downLoadTemplate("saleList", getList, "sale.xls", "download-" + CustomerUtils.getNowForString() + "-.xls", response);
		}catch(Exception e){
			System.out.println(e);
		}
		
		return null;
	}
	
	
	/////////////////////
	
	private SaleMonitorCond saleCond;
	private List<SaleMonitor> saleList;
	private SaleMonitorAmount amount;  //本页合计
	private SaleMonitorAmount allAmount; //总合计
	
	private LinkedHashMap<String, String> selCompany;
	private LinkedHashMap<String, String> selProject;
	
	private void initOther(){
		List<Integer> projectIds = HengDaUtils.getUserProjects(); //该用户所拥有的所有的项目,做为sql的查找条件使用
		//加上页面获取的公司及项目id的判断截取
		String getCompanyId = saleCond.getCompanyId(); //页面传过来的公司id
		String getProjectId = saleCond.getProjectId() + ""; //页面传过来的项目id
		if(!CustomerUtils.isStrEmpty(getCompanyId)){
			if(!CustomerUtils.isStrEmpty(getProjectId) && !"0".equals(getProjectId)){
				//只是查单个项目
				projectIds.clear();
				projectIds.add(saleCond.getProjectId());
				
			}else{
				//判断该公司下的项目id, 该用户有多少个
				projectIds = HengDaUtils.getUserProjectsByCompanyId(Integer.parseInt(getCompanyId), projectIds); //把该projectIds传过去,可以减少再查一次数据库
				
			}
		}
		
		saleCond.setProjectIds(projectIds);
		
		HttpSession session = request.getSession();
		session.setAttribute("companyId", getCompanyId);
		session.setAttribute("projectId", getProjectId);
		
		//判断是否公司及项目都是一个,如果都是一个,那么就让公司项目处于选择状态
		LinkedHashMap<String, String> getSelPro = HengDaUtils.setSessionIfCompanyAndProjectOne(request);
		if(getSelPro != null){
			selProject = getSelPro;
		}
		
		
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
		
		if(isGet){
			String getCompanyId = saleCond.getCompanyId();
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
	
	public SaleMonitorCond getSaleCond() {
		return saleCond;
	}

	public void setSaleCond(SaleMonitorCond saleCond) {
		this.saleCond = saleCond;
	}

	public List<SaleMonitor> getSaleList() {
		return saleList;
	}

	public void setSaleList(List<SaleMonitor> saleList) {
		this.saleList = saleList;
	}

	public SaleMonitorAmount getAmount() {
		return amount;
	}

	public void setAmount(SaleMonitorAmount amount) {
		this.amount = amount;
	}

	private SaleMonitorAmount initSaleMonitorAmount(SaleMonitorAmount saleMonitorAmount, List<SaleMonitor> saleList){
		if(saleMonitorAmount == null)
			saleMonitorAmount = new SaleMonitorAmount();
		
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
			
			saleMonitorAmount.setContractSumNum(saleMonitorAmount.getContractSumNum() + sale.getContractSumNum()); //签约数
			
			saleMonitorAmount.setRealSumMoney(saleMonitorAmount.getRealSumMoney().add((sale.getContractSumMoney().subtract(sale.getUndoSumMoney()))));
			
		}
		
		return saleMonitorAmount;
		
	}
	
	public SaleMonitorAmount getAllAmount() {
		return allAmount;
	}
	
	public void setAllAmount(SaleMonitorAmount allAmount) {
		this.allAmount = allAmount;
	}
	

}
