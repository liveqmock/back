package com.ihk.sale.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.permission.PermissionUtils;
import com.ihk.sale.data.pojo.SaleMonitor;
import com.ihk.sale.data.pojo.SaleMonitorCond;
import com.ihk.sale.data.pojo.SaleMonitorSearchTimeAll;
import com.ihk.sale.data.services.ISaleMonitorMonthServices;
import com.ihk.sale.data.services.ISaleMonitorServices;
import com.ihk.sale.data.services.ISaleMonitorWeekServices;
import com.ihk.sale.data.services.ISaleMonitorYearServices;
import com.ihk.user.data.pojo.CompanyProject;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.HengDaUtils;
import com.ihk.utils.SupperAction;

/**
 *  汇总查询 action
 */
public class SearchAllAction extends SupperAction {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	ISaleMonitorServices saleMonitorServices;
	@Autowired
	ISaleMonitorWeekServices saleMonitorWeekServices;
	@Autowired
	ISaleMonitorMonthServices saleMonitorMonthServices;
	@Autowired
	ISaleMonitorYearServices saleMonitorYearServices;
	
	public String searchAll() throws Exception{
		HttpSession session = request.getSession();
		
		String from = request.getParameter("from");
		String monitorDate = CustomerUtils.getNowForString();
		boolean isGet = false;
		boolean isLeft = false;
		
		if(saleCond == null)
			saleCond = new SaleMonitorCond();
		
		if("left".equals(from)){
			saleCond.setMonitorDate(monitorDate);
			isLeft = true;
		}
		
		if(!CustomerUtils.isStrEmpty(saleCond.getCompanyId())){
			isGet = true;
		}
		
		initSelCompany();  //查找该用户所拥有的公司
		initSelProject(isGet);
		
		initOtherTimeAndCond(); //设置所拥有的project id和公司的下拉框默认值等,并设置要查找的project id的值,先设置公司项目的值sale不空再覆盖
		
		//selCompany的大小要大于2(因为总是有一个全部), saleCond的companyId为空
		
		String fromList = request.getParameter("fromList");
		int companySize = selCompany.size();
		
		sale = saleMonitorServices.findSaleMonitorForSearchTime(saleCond);
		// 上面的方法只是利用monitor_date去查找,可能为空,当为空时,其他数据也无意义了,所以直接跳出
		
		String retUrl = initRetUrl(isLeft, saleCond, sale);
		session.setAttribute("retUrl", retUrl);
		
		if(sale == null){
			//也要把公司或项目的名称显示出来,但是没有值
			if(companySize > 2 && CustomerUtils.isStrEmpty(saleCond.getCompanyId()) 
					&& CustomerUtils.isStrEmpty(fromList)){
				//显示公司及公司列表按钮
				session.setAttribute(HengDaUtils.IS_COMPANYBUTTOM_SHOW, true);
				session.setAttribute(HengDaUtils.IS_COMPANY_SHOW, true);
				
			}else{
				//不显示公司及公司列表按钮
				session.removeAttribute(HengDaUtils.IS_COMPANYBUTTOM_SHOW);
				session.removeAttribute(HengDaUtils.IS_COMPANY_SHOW);
				
			}
			
			String emptyPrjecct = request.getParameter("emptyProject");  //判断是否为空白的项目排序过来,如果有值就不显示公司列表,但显示公司列表按钮
			String comOrderId = request.getParameter("comOrderId"); //如果是空白的公司排序过来,comOrderId是以2开头,不移除
			if(!CustomerUtils.isStrEmpty(emptyPrjecct)){
				session.removeAttribute(HengDaUtils.IS_COMPANY_SHOW);
			}
			if(!CustomerUtils.isStrEmpty(comOrderId)){
				if(comOrderId.startsWith("2")){
					session.setAttribute(HengDaUtils.IS_COMPANY_SHOW, true);
				}
			}
		
			
			session.setAttribute(HengDaUtils.IS_COMPANY_LISTEMPTY_SHOW, true);  //公司显示空白值
			session.setAttribute(HengDaUtils.IS_PROJECT_LISTEMPTY_SHOW, true);  //项目显示空白值
			
			//return "searchAll";
		}
		
		session.removeAttribute(HengDaUtils.IS_COMPANY_LISTEMPTY_SHOW);
		session.removeAttribute(HengDaUtils.IS_PROJECT_LISTEMPTY_SHOW);
		
		weekSale = saleMonitorServices.findSaleMonitorForSearchTime(weekSaleCond);
		monthSale = saleMonitorServices.findSaleMonitorForSearchTime(monthSaleCond);
		yearSale = saleMonitorServices.findSaleMonitorForSearchTime(yearSaleCond);
		allSale = saleMonitorServices.findSaleMonitorForSearchTime(allSaleCond);
		
		if(sale == null)
			sale = new SaleMonitor();
		if(weekSale == null)
			weekSale = new SaleMonitor();
		if(monthSale == null)
			monthSale = new SaleMonitor();
		if(yearSale == null)
			yearSale = new SaleMonitor();
		if(allSale == null)
			allSale = new SaleMonitor();
		
		//销售金额 转成 万元
		sale.setSumMoney(divideByRadix(sale.getSumMoney(), CommonUtils.TENTHOUSAND));
		weekSale.setSumMoney(divideByRadix(weekSale.getSumMoney(), CommonUtils.TENTHOUSAND));
		monthSale.setSumMoney(divideByRadix(monthSale.getSumMoney(), CommonUtils.TENTHOUSAND));
		yearSale.setSumMoney(divideByRadix(yearSale.getSumMoney(), CommonUtils.TENTHOUSAND));
		allSale.setSumMoney(divideByRadix(allSale.getSumMoney(), CommonUtils.TENTHOUSAND));
		
		
		//项目销售列表
		List<SaleMonitor> tmpSaleList = saleMonitorServices.findSaleMonitor(saleCond);
		searchTimeList = initListForShow(tmpSaleList);
		
		//设置公司或项目显示
		if(companySize > 2 && CustomerUtils.isStrEmpty(saleCond.getCompanyId()) && CustomerUtils.isStrEmpty(fromList)){
			session.setAttribute(HengDaUtils.IS_COMPANY_SHOW, true);
			session.setAttribute(HengDaUtils.IS_COMPANYBUTTOM_SHOW, true);
			
			searchTimeCompanyList = initCompanyListForShow(searchTimeList);
			
		}else{
			session.removeAttribute(HengDaUtils.IS_COMPANY_SHOW);
			session.removeAttribute(HengDaUtils.IS_COMPANYBUTTOM_SHOW);
			
		}
		String comOrderId = request.getParameter("comOrderId");
		String orderId = request.getParameter("orderId");
		if(!CustomerUtils.isStrEmpty(comOrderId)){
			session.setAttribute(HengDaUtils.IS_COMPANY_SHOW, true);
		}
		if(!CustomerUtils.isStrEmpty(orderId)){
			session.removeAttribute(HengDaUtils.IS_COMPANY_SHOW);
		}
		
		return "searchAll";
	}
	
	private void initOtherTimeAndCond(){
		HttpSession session = request.getSession();
		
		String monitorDate = saleCond.getMonitorDate();
		String weekFirst = CommonUtils.getWeekFirstForString(monitorDate);
		String monthFirst = CommonUtils.getMonthFirstForString(monitorDate);
		String yearFirst = CommonUtils.getYearFirstForString(monitorDate);
		
		String weekEnd = CommonUtils.getWeekEndForString(monitorDate);
		
		if(weekSaleCond == null){
			weekSaleCond = new SaleMonitorCond();
		}
		if(monthSaleCond == null){
			monthSaleCond = new SaleMonitorCond();
		}
		if(yearSaleCond == null){
			yearSaleCond = new SaleMonitorCond();
		}
		if(allSaleCond == null){
			allSaleCond = new SaleMonitorCond();
		}
		
		weekSaleCond.setDate1(weekFirst);
		weekSaleCond.setDate2(monitorDate);
		
		monthSaleCond.setDate1(monthFirst);
		monthSaleCond.setDate2(monitorDate);
		
		yearSaleCond.setDate1(yearFirst);
		yearSaleCond.setDate2(monitorDate);
		
		allSaleCond.setDate2(monitorDate);
		
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
		weekSaleCond.setProjectIds(projectIds);
		monthSaleCond.setProjectIds(projectIds);
		yearSaleCond.setProjectIds(projectIds);
		allSaleCond.setProjectIds(projectIds);
		
		int saleCondProjectId = saleCond.getProjectId();
		weekSaleCond.setProjectId(saleCondProjectId);
		monthSaleCond.setProjectId(saleCondProjectId);
		yearSaleCond.setProjectId(saleCondProjectId);
		allSaleCond.setProjectId(saleCondProjectId);
		
		//判断是否从列表进来
		String fromList = request.getParameter("fromList");
		if(!CustomerUtils.isStrEmpty(fromList)){
			//表示从列表进来
			CompanyProject getComPro = HengDaUtils.findCompanyProjectByProjectId(saleCondProjectId);
			getCompanyId = getComPro.getCompanyId() + "";
			
			selProject = new LinkedHashMap<String, String>();
			LinkedHashMap<String, String> ownProjects = HengDaUtils.getProjectsByCompanyId(getComPro.getCompanyId());
			selProject.putAll(ownProjects);
			
			session.removeAttribute(HengDaUtils.IS_COMPANY_SHOW);
		}
		
		session.setAttribute("weekFirst", weekFirst);
		session.setAttribute("monthFirst", monthFirst);
		session.setAttribute("yearFirst", yearFirst);
		
		session.setAttribute("weekEnd", weekEnd);  //周明细中的跳转使用
		
		session.setAttribute("companyId", getCompanyId);
		session.setAttribute("monitorDate", monitorDate);
		session.setAttribute("projectId", getProjectId);
		
		//设置曲线的url  getCompanyId getProjectId
		String dayUrl = "";
		String weekUrl = "";
		String monthUrl = "";
		
		if(CustomerUtils.isStrEmpty(getCompanyId) && "0".equals(getProjectId)){
			//没有选公司,没有选项目
			dayUrl = "sale_hengda/chart/country.action?saleMonitorCond.date1=" + weekFirst + "&saleMonitorCond.date2=" + monitorDate + "&selCycel=";
			weekUrl = "sale_hengda/chart/country.action?saleMonitorCond.date1=" + monthFirst + "&saleMonitorCond.date2=" + monitorDate + "&selCycel=";
			monthUrl = "sale_hengda/chart/country.action?saleMonitorCond.date1=" + yearFirst + "&saleMonitorCond.date2=" + monitorDate + "&selCycel=";
			
			//sale_hengda/chart/country.action?saleMonitorCond.date1=2011-08-01&saleMonitorCond.date2=2011-08-14&selCycel=day
			
			searchTimeCompanyList = new ArrayList<SaleMonitorSearchTimeAll>();
			Set<String> companyIds = selCompany.keySet();
			for(String companyId : companyIds){
				if(!CustomerUtils.isStrEmpty(companyId)){
					SaleMonitorSearchTimeAll sale = new SaleMonitorSearchTimeAll();
					sale.setCompanyId(Integer.parseInt(companyId));
					sale.setMonitorDate(monitorDate);
					
					searchTimeCompanyList.add(sale);
				}
			}
			
			searchTimeList = new ArrayList<SaleMonitorSearchTimeAll>();
			List<CompanyProject> saleProjects = PermissionUtils.getUserProjectList();
			
			for(CompanyProject saleProject : saleProjects){
				SaleMonitorSearchTimeAll sale = new SaleMonitorSearchTimeAll();
				sale.setCompanyId(saleProject.getCompanyId());
				sale.setProjectId(saleProject.getId());
				sale.setMonitorDate(monitorDate);
				
				searchTimeList.add(sale);
				
			}
			
		}
		
		if(!CustomerUtils.isStrEmpty(getCompanyId) && "0".equals(getProjectId)){
			//选择了公司,没有选项目
			dayUrl = "sale_hengda/chart/company.action?saleMonitorCond.companyId=" + getCompanyId + "&saleMonitorCond.date1=" + weekFirst + "&saleMonitorCond.date2=" + monitorDate + "&selCycel=";
			weekUrl = "sale_hengda/chart/company.action?saleMonitorCond.companyId=" + getCompanyId + "&saleMonitorCond.date1=" + monthFirst + "&saleMonitorCond.date2=" + monitorDate + "&selCycel=";
			monthUrl = "sale_hengda/chart/company.action?saleMonitorCond.companyId=" + getCompanyId + "&saleMonitorCond.date1=" + yearFirst + "&saleMonitorCond.date2=" + monitorDate + "&selCycel=";
			
			//sale_hengda/chart/company.action?saleMonitorCond.date1=2011-08-01&saleMonitorCond.date2=2011-08-14&selCycel=day
			
			searchTimeList = new ArrayList<SaleMonitorSearchTimeAll>();
			Set<String> showProjectIds = selProject.keySet();
			for(String showProjectId : showProjectIds){
				if(!CustomerUtils.isStrEmpty(showProjectId)){
					SaleMonitorSearchTimeAll sale = new SaleMonitorSearchTimeAll();
					
					CompanyProject getComProject = HengDaUtils.findCompanyProjectByProjectId(Integer.parseInt(showProjectId));
					sale.setCompanyId(getComProject.getCompanyId());
					sale.setProjectId(getComProject.getId());
					sale.setMonitorDate(monitorDate);
					
					searchTimeList.add(sale);
				}
			}
			
			
		}
		
		if(!CustomerUtils.isStrEmpty(getCompanyId) && !"0".equals(getProjectId)){
			//选择了公司,选择了项目
			dayUrl = "sale_hengda/chart/project.action?saleMonitorCond.projectId=" + getProjectId + "&saleMonitorCond.date1=" + weekFirst + "&saleMonitorCond.date2=" + monitorDate + "&selCycel=";
			weekUrl = "sale_hengda/chart/project.action?saleMonitorCond.projectId=" + getProjectId + "&saleMonitorCond.date1=" + monthFirst + "&saleMonitorCond.date2=" + monitorDate + "&selCycel=";
			monthUrl = "sale_hengda/chart/project.action?saleMonitorCond.projectId=" + getProjectId + "&saleMonitorCond.date1=" + yearFirst + "&saleMonitorCond.date2=" + monitorDate + "&selCycel=";
			
			//sale_hengda/chart/project.action?saleMonitorCond.projectId=10&saleMonitorCond.date1=2011-08-01&saleMonitorCond.date2=2011-08-14&selCycel=day
			
			searchTimeList = new ArrayList<SaleMonitorSearchTimeAll>();
			
			CompanyProject getComProject = HengDaUtils.findCompanyProjectByProjectId(Integer.parseInt(getProjectId));
			
			SaleMonitorSearchTimeAll sale = new SaleMonitorSearchTimeAll();
			sale.setCompanyId(getComProject.getCompanyId());
			sale.setProjectId(getComProject.getId());
			sale.setMonitorDate(monitorDate);
			sale.setSumArea(null);
			
			searchTimeList.add(sale);
			
		}
		
		session.setAttribute("dayUrl", dayUrl);
		session.setAttribute("weekUrl", weekUrl);
		session.setAttribute("monthUrl", monthUrl);
		
		//判断是否公司及项目都是一个,如果都是一个,那么就让公司项目处于选择状态
		LinkedHashMap<String, String> getSelPro = HengDaUtils.setSessionIfCompanyAndProjectOne(request);
		if(getSelPro != null){
			selProject = getSelPro;
		}
		
		
	}
	
	private String initRetUrl(boolean isLeft, SaleMonitorCond cond, SaleMonitor sale){
		//sale用来判断空白是的排序
		String retUrl = "";
		
		if(isLeft){
			
			retUrl = "./sale_hengda/search/all.action?from=left";
		}else{
			
			String getCompanyId = cond.getCompanyId(); //页面传过来的公司id
			String getProjectId = cond.getProjectId() + ""; //页面传过来的项目id
			
			if(CustomerUtils.isStrEmpty(getCompanyId) && "0".equals(getProjectId)){
				//没有选公司,没有选项目
				retUrl = "./sale_hengda/search/all.action?saleCond.monitorDate=" 
					+ cond.getMonitorDate() + "&saleCond.companyId=&saleCond.projectId=";
			}
			
			if(!CustomerUtils.isStrEmpty(getCompanyId) && "0".equals(getProjectId)){
				//选择了公司,没有选项目
				retUrl = "./sale_hengda/search/all.action?saleCond.monitorDate=" 
					+ cond.getMonitorDate() + "&saleCond.companyId=" + getCompanyId + "&saleCond.projectId=";
			}
			
			if(!CustomerUtils.isStrEmpty(getCompanyId) && !"0".equals(getProjectId)){
				//选择了公司,选择了项目
				retUrl = "./sale_hengda/search/all.action?saleCond.monitorDate=" 
					+ cond.getMonitorDate() + "&saleCond.companyId=" + getCompanyId + "&saleCond.projectId=" + getProjectId;
			}
			
		}
		
		if(sale == null){
			retUrl += "&emptyProject=emptyProject";
		}
		
		return retUrl;
	}
	
	
	/**
	 * 
	 * 项目列表
	 * @param tmpSaleList
	 * @return
	 * @throws Exception
	 */
	private List<SaleMonitorSearchTimeAll> initListForShow(List<SaleMonitor> tmpSaleList) throws Exception{
		List<SaleMonitorSearchTimeAll> retList = new ArrayList<SaleMonitorSearchTimeAll>();
		
		String sumNum = "sumNum";  //Integer
		String sumArea = "sumArea"; //BigDecimal
		String sumMoney = "sumMoney"; //BigDecimal
		String intentionNum = "intentionNum"; //Integer
		
		Map<String, Number> nullMap = new HashMap<String, Number>();  //避免空指针
		nullMap.put(sumNum, new Integer(0));
		nullMap.put(sumArea, new BigDecimal(0.00));
		nullMap.put(sumMoney, new BigDecimal(0.00));
		nullMap.put(intentionNum, new Integer(0));
		
		for(SaleMonitor sale : tmpSaleList){
			SaleMonitorSearchTimeAll all = new SaleMonitorSearchTimeAll();
			
			SaleMonitorCond weekCond = new SaleMonitorCond();
			weekCond.setDate1(weekSaleCond.getDate1());
			weekCond.setDate2(weekSaleCond.getDate2());
			weekCond.setProjectId(sale.getProjectId());
			
			SaleMonitorCond monthCond = new SaleMonitorCond();
			monthCond.setDate1(monthSaleCond.getDate1());
			monthCond.setDate2(monthSaleCond.getDate2());
			monthCond.setProjectId(sale.getProjectId());
			
			SaleMonitorCond yearCond = new SaleMonitorCond();
			yearCond.setDate1(yearSaleCond.getDate1());
			yearCond.setDate2(yearSaleCond.getDate2());
			yearCond.setProjectId(sale.getProjectId());
			
			Map<String, Number> getWeek = saleMonitorServices.findOtherDataForSearchTime(weekCond);
			Map<String, Number> getMonth = saleMonitorServices.findOtherDataForSearchTime(monthCond);
			Map<String, Number> getYear = saleMonitorServices.findOtherDataForSearchTime(yearCond);
			
			if(getWeek == null){
				getWeek = nullMap;
			}
			if(getMonth == null){
				getMonth = nullMap;
			}
			if(getYear == null){
				getYear = nullMap;
			}
			
			all.setId(sale.getId());
			all.setMonitorDate(sale.getMonitorDateString());
			all.setProjectId(sale.getProjectId());
			all.setCompanyId(sale.getCompanyId());
			all.setPhoneNum(sale.getPhoneNum());
			all.setVisitorNum(sale.getVisitorNum());
			all.setSumNum(sale.getSumNum());
			all.setSumArea(sale.getSumArea());
			all.setSumMoney(divideByRadix(sale.getSumMoney(), CommonUtils.TENTHOUSAND)); //销售金额(万元)
			all.setIntentionNum(sale.getIntentionNum());
			
			all.setSumNum_w((Integer) getWeek.get(sumNum));
			all.setSumArea_w((BigDecimal) getWeek.get(sumArea));
			all.setSumMoney_w(divideByRadix((BigDecimal) getWeek.get(sumMoney), CommonUtils.TENTHOUSAND)); //销售金额(万元)
			all.setIntentionNum_w((Integer) getWeek.get(intentionNum));
			
			all.setSumNum_m((Integer) getMonth.get(sumNum));
			all.setSumArea_m((BigDecimal) getMonth.get(sumArea));
			all.setSumMoney_m(divideByRadix((BigDecimal) getMonth.get(sumMoney), CommonUtils.TENTHOUSAND)); //销售金额(万元)
			all.setIntentionNum_m((Integer) getMonth.get(intentionNum));
			
			all.setSumNum_y((Integer) getYear.get(sumNum));
			all.setSumArea_y((BigDecimal) getYear.get(sumArea));
			all.setSumMoney_y(divideByRadix((BigDecimal) getYear.get(sumMoney), CommonUtils.TENTHOUSAND)); //销售金额(万元)
			all.setIntentionNum_y((Integer) getYear.get(intentionNum));
			
			all.setLastModTime(sale.getModTime());
			
			retList.add(all);
			
		}
		
		String orderIdString = request.getParameter("orderId");
		if(!CustomerUtils.isStrEmpty(orderIdString)){
			int orderId = Integer.parseInt(orderIdString); //排序
			switch(orderId){
				case 11: 
					Collections.sort(retList, new ComparatorSumMoney());  //项目销售金额
					break;
				case 12:
					Collections.sort(retList, new ComparatorSumMoney2());  //项目销售金额
					break;
				case 13:
					Collections.sort(retList, new ComparatorSumMoneyW());
					break;
				case 14:
					Collections.sort(retList, new ComparatorSumMoneyW2());
					break;
				case 15:
					Collections.sort(retList, new ComparatorSumMoneyM());
					break;
				case 16:
					Collections.sort(retList, new ComparatorSumMoneyM2());
					break;
				case 17:
					Collections.sort(retList, new ComparatorSumMoneyY());
					break;
				case 18:
					Collections.sort(retList, new ComparatorSumMoneyY2());
					break;
					
				case 111: 
					Collections.sort(retList, new ComparatorSumNum());  //销售套数
					break;
				case 121:
					Collections.sort(retList, new ComparatorSumNum2());  
					break;
				case 131:
					Collections.sort(retList, new ComparatorSumNumW());
					break;
				case 141:
					Collections.sort(retList, new ComparatorSumNumW2());
					break;
				case 151:
					Collections.sort(retList, new ComparatorSumNumM());
					break;
				case 161:
					Collections.sort(retList, new ComparatorSumNumM2());
					break;
				case 171:
					Collections.sort(retList, new ComparatorSumNumY());
					break;
				case 181:
					Collections.sort(retList, new ComparatorSumNumY2());
					break;
					
			}
			
		}
		
		return retList;
	}
	
	private List<SaleMonitorSearchTimeAll> initCompanyListForShow(List<SaleMonitorSearchTimeAll> searchTimeList) {
		
		List<SaleMonitorSearchTimeAll> retList = new ArrayList<SaleMonitorSearchTimeAll>();
		
		Set<Integer> companyIdSet = new HashSet<Integer>(); //所有的公司id
		for(SaleMonitorSearchTimeAll searchTime : searchTimeList){
			int companyId = searchTime.getCompanyId();
			companyIdSet.add(companyId);
		}
		
		for(Integer companyId : companyIdSet){
			
			retList.add(getCompanySearchTimeByCompanyId(searchTimeList, companyId));
		}
		
		String orderIdString = request.getParameter("comOrderId");
		if(!CustomerUtils.isStrEmpty(orderIdString)){
			int orderId = Integer.parseInt(orderIdString); //排序
			switch(orderId){
				case 21: 
					Collections.sort(retList, new ComparatorSumMoney());  //公司销售金额
					break;
				case 22:
					Collections.sort(retList, new ComparatorSumMoney2());  //公司销售金额
					break;
				case 23:
					Collections.sort(retList, new ComparatorSumMoneyW());
					break;
				case 24:
					Collections.sort(retList, new ComparatorSumMoneyW2());
					break;
				case 25:
					Collections.sort(retList, new ComparatorSumMoneyM());
					break;
				case 26:
					Collections.sort(retList, new ComparatorSumMoneyM2());
					break;
				case 27:
					Collections.sort(retList, new ComparatorSumMoneyY());
					break;
				case 28:
					Collections.sort(retList, new ComparatorSumMoneyY2());
					break;
					
					
				case 211: 
					Collections.sort(retList, new ComparatorSumNum());  //销售套数
					break;
				case 221:
					Collections.sort(retList, new ComparatorSumNum2());  
					break;
				case 231:
					Collections.sort(retList, new ComparatorSumNumW());
					break;
				case 241:
					Collections.sort(retList, new ComparatorSumNumW2());
					break;
				case 251:
					Collections.sort(retList, new ComparatorSumNumM());
					break;
				case 261:
					Collections.sort(retList, new ComparatorSumNumM2());
					break;
				case 271:
					Collections.sort(retList, new ComparatorSumNumY());
					break;
				case 281:
					Collections.sort(retList, new ComparatorSumNumY2());
					break;
					
			}
			
		}
		
		return retList;
		
	}
	
	private SaleMonitorSearchTimeAll getCompanySearchTimeByCompanyId(List<SaleMonitorSearchTimeAll> searchTimeList, int companyId){
		
		SaleMonitorSearchTimeAll retSale = new SaleMonitorSearchTimeAll();
		retSale.setCompanyId(companyId);
		
		for(SaleMonitorSearchTimeAll searchTime : searchTimeList){
			int getCompanyId = searchTime.getCompanyId();
			if(getCompanyId == companyId){
				retSale.setPhoneNum(retSale.getPhoneNum() + searchTime.getPhoneNum());
				retSale.setVisitorNum(retSale.getVisitorNum() + searchTime.getVisitorNum());
				
				retSale.setSumNum(retSale.getSumNum() + searchTime.getSumNum());
				retSale.setSumArea(retSale.getSumArea().add(searchTime.getSumArea()));
				retSale.setSumMoney(retSale.getSumMoney().add(searchTime.getSumMoney()));
				retSale.setIntentionNum(retSale.getIntentionNum() + searchTime.getIntentionNum());
				
				retSale.setSumNum_w(retSale.getSumNum_w() + searchTime.getSumNum_w());
				retSale.setSumArea_w(retSale.getSumArea_w().add(searchTime.getSumArea_w()));
				retSale.setSumMoney_w(retSale.getSumMoney_w().add(searchTime.getSumMoney_w()));
				retSale.setIntentionNum_w(retSale.getIntentionNum_w() + searchTime.getIntentionNum_w());
				
				retSale.setSumNum_m(retSale.getSumNum_m() + searchTime.getSumNum_m());
				retSale.setSumArea_m(retSale.getSumArea_m().add(searchTime.getSumArea_m()));
				retSale.setSumMoney_m(retSale.getSumMoney_m().add(searchTime.getSumMoney_m()));
				retSale.setIntentionNum_m(retSale.getIntentionNum_m() + searchTime.getIntentionNum_m());
				
				retSale.setSumNum_y(retSale.getSumNum_y() + searchTime.getSumNum_y());
				retSale.setSumArea_y(retSale.getSumArea_y().add(searchTime.getSumArea_y()));
				retSale.setSumMoney_y(retSale.getSumMoney_y().add(searchTime.getSumMoney_y()));
				retSale.setIntentionNum_y(retSale.getIntentionNum_m() + searchTime.getIntentionNum_y());
				
				retSale.setMonitorDate(searchTime.getMonitorDate());
				
			}
			
		}
		
		return retSale;
		
	}
	
	private BigDecimal divideByRadix(BigDecimal value, int radix){
		if(value != null)
			return value.divide(new BigDecimal(radix));
		
		return new BigDecimal(0);
	}
	
	///////////////////---
	
	class ComparatorSumMoney implements Comparator<SaleMonitorSearchTimeAll>{

		@Override
		public int compare(SaleMonitorSearchTimeAll sale1,
				SaleMonitorSearchTimeAll sale2) {
			
			return sale1.getSumMoney().compareTo(sale2.getSumMoney());
		}
		
	}
	
	class ComparatorSumMoney2 implements Comparator<SaleMonitorSearchTimeAll>{

		@Override
		public int compare(SaleMonitorSearchTimeAll sale1,
				SaleMonitorSearchTimeAll sale2) {
			
			return -(sale1.getSumMoney().compareTo(sale2.getSumMoney()));
		}
		
	}
	
	class ComparatorSumMoneyW implements Comparator<SaleMonitorSearchTimeAll>{

		@Override
		public int compare(SaleMonitorSearchTimeAll sale1,
				SaleMonitorSearchTimeAll sale2) {
			
			return sale1.getSumMoney_w().compareTo(sale2.getSumMoney_w());
		}
		
	}
	
	class ComparatorSumMoneyW2 implements Comparator<SaleMonitorSearchTimeAll>{

		@Override
		public int compare(SaleMonitorSearchTimeAll sale1,
				SaleMonitorSearchTimeAll sale2) {
			
			return -(sale1.getSumMoney_w().compareTo(sale2.getSumMoney_w()));
		}
		
	}
	
	class ComparatorSumMoneyM implements Comparator<SaleMonitorSearchTimeAll>{

		@Override
		public int compare(SaleMonitorSearchTimeAll sale1,
				SaleMonitorSearchTimeAll sale2) {
			
			return sale1.getSumMoney_m().compareTo(sale2.getSumMoney_m());
		}
		
	}
	
	class ComparatorSumMoneyM2 implements Comparator<SaleMonitorSearchTimeAll>{

		@Override
		public int compare(SaleMonitorSearchTimeAll sale1,
				SaleMonitorSearchTimeAll sale2) {
			
			return -(sale1.getSumMoney_m().compareTo(sale2.getSumMoney_m()));
		}
		
	}
	
	class ComparatorSumMoneyY implements Comparator<SaleMonitorSearchTimeAll>{

		@Override
		public int compare(SaleMonitorSearchTimeAll sale1,
				SaleMonitorSearchTimeAll sale2) {
			
			return sale1.getSumMoney_y().compareTo(sale2.getSumMoney_y());
		}
		
	}
	
	class ComparatorSumMoneyY2 implements Comparator<SaleMonitorSearchTimeAll>{

		@Override
		public int compare(SaleMonitorSearchTimeAll sale1,
				SaleMonitorSearchTimeAll sale2) {
			
			return -(sale1.getSumMoney_y().compareTo(sale2.getSumMoney_y()));
		}
		
	}
	
	class ComparatorSumNum implements Comparator<SaleMonitorSearchTimeAll>{

		@Override
		public int compare(SaleMonitorSearchTimeAll sale1,
				SaleMonitorSearchTimeAll sale2) {
			
			return new Integer(sale1.getSumNum()).compareTo(new Integer(sale2.getSumNum()));
		}
		
	}
	
	class ComparatorSumNum2 implements Comparator<SaleMonitorSearchTimeAll>{

		@Override
		public int compare(SaleMonitorSearchTimeAll sale1,
				SaleMonitorSearchTimeAll sale2) {
			
			return -new Integer(sale1.getSumNum()).compareTo(new Integer(sale2.getSumNum()));
		}
		
	}
	
	class ComparatorSumNumW implements Comparator<SaleMonitorSearchTimeAll>{

		@Override
		public int compare(SaleMonitorSearchTimeAll sale1,
				SaleMonitorSearchTimeAll sale2) {
			
			return new Integer(sale1.getSumNum_w()).compareTo(new Integer(sale2.getSumNum_w()));
		}
		
	}
	
	class ComparatorSumNumW2 implements Comparator<SaleMonitorSearchTimeAll>{

		@Override
		public int compare(SaleMonitorSearchTimeAll sale1,
				SaleMonitorSearchTimeAll sale2) {
			
			return -new Integer(sale1.getSumNum_w()).compareTo(new Integer(sale2.getSumNum_w()));
		}
		
	}
	
	class ComparatorSumNumM implements Comparator<SaleMonitorSearchTimeAll>{

		@Override
		public int compare(SaleMonitorSearchTimeAll sale1,
				SaleMonitorSearchTimeAll sale2) {
			
			return new Integer(sale1.getSumNum_m()).compareTo(new Integer(sale2.getSumNum_m()));
		}
		
	}
	
	class ComparatorSumNumM2 implements Comparator<SaleMonitorSearchTimeAll>{

		@Override
		public int compare(SaleMonitorSearchTimeAll sale1,
				SaleMonitorSearchTimeAll sale2) {
			
			return -new Integer(sale1.getSumNum_m()).compareTo(new Integer(sale2.getSumNum_w()));
		}
		
	}
	
	class ComparatorSumNumY implements Comparator<SaleMonitorSearchTimeAll>{

		@Override
		public int compare(SaleMonitorSearchTimeAll sale1,
				SaleMonitorSearchTimeAll sale2) {
			
			return new Integer(sale1.getSumNum_y()).compareTo(new Integer(sale2.getSumNum_y()));
		}
		
	}
	
	class ComparatorSumNumY2 implements Comparator<SaleMonitorSearchTimeAll>{

		@Override
		public int compare(SaleMonitorSearchTimeAll sale1,
				SaleMonitorSearchTimeAll sale2) {
			
			return -new Integer(sale1.getSumNum_y()).compareTo(new Integer(sale2.getSumNum_y()));
		}
		
	}
	
	
	///////////////////---
	
	///////////
	
	private SaleMonitorCond saleCond;  //天
	private SaleMonitorCond weekSaleCond; //周
	private SaleMonitorCond monthSaleCond; //月
	private SaleMonitorCond yearSaleCond; //年
	private SaleMonitorCond allSaleCond; //累计
	
	private SaleMonitor sale;
	private SaleMonitor weekSale;
	private SaleMonitor monthSale;
	private SaleMonitor yearSale;
	private SaleMonitor allSale;
	
	private List<SaleMonitorSearchTimeAll> searchTimeList; //页面显示(项目)
	private List<SaleMonitorSearchTimeAll> searchTimeCompanyList; //页面显示(公司)
	private LinkedHashMap<String, String> selCompany;
	private LinkedHashMap<String, String> selProject;
	
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
			selProject = HengDaUtils.getProjectsByCompanyId(Integer.parseInt(saleCond.getCompanyId()));
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
	
	public void setSearchTimeList(List<SaleMonitorSearchTimeAll> searchTimeList) {
		this.searchTimeList = searchTimeList;
	}
	
	public List<SaleMonitorSearchTimeAll> getSearchTimeList() {
		return searchTimeList;
	}
	
	public List<SaleMonitorSearchTimeAll> getSearchTimeCompanyList() {
		return searchTimeCompanyList;
	}

	public void setSearchTimeCompanyList(
			List<SaleMonitorSearchTimeAll> searchTimeCompanyList) {
		this.searchTimeCompanyList = searchTimeCompanyList;
	}

	public void setAllSale(SaleMonitor allSale) {
		this.allSale = allSale;
	}
	
	public SaleMonitor getAllSale() {
		return allSale;
	}
	
	public void setAllSaleCond(SaleMonitorCond allSaleCond) {
		this.allSaleCond = allSaleCond;
	}
	
	public SaleMonitorCond getAllSaleCond() {
		return allSaleCond;
	}
	
	public SaleMonitor getSale() {
		return sale;
	}

	public void setSale(SaleMonitor sale) {
		this.sale = sale;
	}

	public SaleMonitor getWeekSale() {
		return weekSale;
	}

	public void setWeekSale(SaleMonitor weekSale) {
		this.weekSale = weekSale;
	}

	public SaleMonitor getMonthSale() {
		return monthSale;
	}

	public void setMonthSale(SaleMonitor monthSale) {
		this.monthSale = monthSale;
	}

	public SaleMonitor getYearSale() {
		return yearSale;
	}

	public void setYearSale(SaleMonitor yearSale) {
		this.yearSale = yearSale;
	}

	public void setSaleCond(SaleMonitorCond saleCond) {
		this.saleCond = saleCond;
	}
	
	public SaleMonitorCond getSaleCond() {
		return saleCond;
	}

	public SaleMonitorCond getWeekSaleCond() {
		return weekSaleCond;
	}

	public void setWeekSaleCond(SaleMonitorCond weekSaleCond) {
		this.weekSaleCond = weekSaleCond;
	}

	public SaleMonitorCond getMonthSaleCond() {
		return monthSaleCond;
	}

	public void setMonthSaleCond(SaleMonitorCond monthSaleCond) {
		this.monthSaleCond = monthSaleCond;
	}

	public SaleMonitorCond getYearSaleCond() {
		return yearSaleCond;
	}

	public void setYearSaleCond(SaleMonitorCond yearSaleCond) {
		this.yearSaleCond = yearSaleCond;
	}
	
}
