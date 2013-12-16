package com.ihk.sale.action;

import java.util.Date;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.EnumDevFlag;
import com.ihk.constanttype.EnumPrivCode;
import com.ihk.permission.PermissionUtils;
import com.ihk.sale.data.pojo.SaleMonitor;
import com.ihk.sale.data.pojo.SaleMonitorAll;
import com.ihk.sale.data.pojo.SaleMonitorCond;
import com.ihk.sale.data.pojo.SaleMonitorMonth;
import com.ihk.sale.data.services.ISaleMonitorAllServices;
import com.ihk.sale.data.services.ISaleMonitorMonthServices;
import com.ihk.sale.data.services.ISaleMonitorServices;
import com.ihk.user.data.pojo.UserAccount;
import com.ihk.user.data.services.ICompanyProjectServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.HengDaUtils;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;

/**
 * 录入销控
 * @author peter.kuang
 *
 */
public class InputSaleAction  extends SupperAction{

	
	private static final long serialVersionUID = 8590822782352238506L;
	
	@Autowired
	ISaleMonitorServices saleMonitorServices;
	@Autowired
	ISaleMonitorMonthServices saleMonitorMonthServices;
	@Autowired
	ISaleMonitorAllServices saleMonitorAllServices;
	@Autowired
	ICompanyProjectServices comProServices;
	
	/**
	 * 增加之前
	 * @return
	 * @throws Exception
	 */
	public String inputForSale() throws Exception{
		HttpSession session = request.getSession();
		
		String now = CustomerUtils.getNowForString();
		session.setAttribute("now", now);
		session.setAttribute("time", CustomerUtils.getNowTimeForString());
		
		String from = request.getParameter("from");
		if("hengda".equals(from)){
			session.removeAttribute("suggestion");
		}
		
		if(PermissionUtils.hasPermission(EnumPrivCode.LOCK_SALE,EnumDevFlag.HENGDA)){
			
			initSelCompany();
			initSelProject();
			
			return "forinputadmin";  
			
		}else{
			//判断是否有数据
				
			SaleMonitorCond cond = new SaleMonitorCond();
			String monitorDate="";
			monitorDate = CustomerUtils.getDateString(new Date());
			
			cond.setMonitorDate(monitorDate);
			cond.setProjectId(SessionUser.getProjectId());
			saleMonitor = saleMonitorServices.findMonitorDateIsExists(cond); //该日期下的该项目是否有值
				
			if(saleMonitor != null){
					
				setSaleMonitorId(saleMonitor.getId());
				setSuggestion("该日期下的项目数据已经存在");
			}else{
				setSaleMonitorId(0);
			}
				
		}
		
		return "forInput";   //forInput  -- 
	}

	
	/**
	 * 增加保存(普通录入人员)
	 * @return
	 * @throws Exception
	 */
	public String inputSale() throws Exception{

		String ret = "";
	
		try{
			if(PermissionUtils.hasPermission(EnumPrivCode.LOCK_SALE,EnumDevFlag.HENGDA)){
				ret = "input_admin";
			}else{
				ret = "input";
			}
			
			Date date = saleMonitor.getMonitorDate();
			
			saleMonitor = initSaleMonitorToAdd(saleMonitor);
			
			String monitorDate = CustomerUtils.getDateString(date);
			
			//不能录入今天以后的数据
			boolean isAfterToday = CommonUtils.isAfterToday(monitorDate);
			if(isAfterToday){
				setSuggestion("不能录入超过今天的数据");
				return ret;
			}
			
			SaleMonitorCond cond = new SaleMonitorCond();
			cond.setMonitorDate(monitorDate);
			cond.setProjectId(SessionUser.getProjectId());
			boolean isExists = saleMonitorServices.findMonitorDateIsExistsByProject(cond); //该日期下的该项目是否有值
			
			saleMonitor.setSumArea(saleMonitor.getHouseArea().add(saleMonitor.getParkArea().add(saleMonitor.getShopArea())));
			saleMonitor.setSumMoney(saleMonitor.getShopMoney().add(saleMonitor.getParkMoney().add(saleMonitor.getHouseMoney())));
			saleMonitor.setSumNum(saleMonitor.getParkNum()+saleMonitor.getHouseNum()+saleMonitor.getShopNum());
			
			saleMonitor.setUndoSumArea(saleMonitor.getUndoShopArea().add(saleMonitor.getUndoParkArea().add(saleMonitor.getUndoHouseArea())));
			saleMonitor.setUndoSumMoney(saleMonitor.getUndoHouseMoney()
					.add(saleMonitor.getUndoParkMoney().add(saleMonitor.getUndoShopMoney()))); //退挞定合计金额
			saleMonitor.setUndoSumNum(saleMonitor.getUndoShopNum()+saleMonitor.getUndoParkNum()+saleMonitor.getUndoHouseNum());
			
			saleMonitor.setContractSumArea(saleMonitor.getContractHouseArea().add(saleMonitor.getContractParkArea().add(saleMonitor.getContractShopArea())));
			saleMonitor.setContractSumMoney(saleMonitor.getContractShopMoney()
					.add(saleMonitor.getContractParkMoney().add(saleMonitor.getContractHouseMoney()))); //签约合计金额
			saleMonitor.setContractSumNum(saleMonitor.getContractParkNum() + saleMonitor.getContractHouseNum() + saleMonitor.getContractShopNum());
			
			// 临时模拟数据 --
			//isExists = false;
			
			if(isExists){
				
				setSuggestion("该日期下的项目数据已经存在");
				return ret;
			}else{
				saleMonitorServices.addSaleMonitor(saleMonitor); //要一并把相关的数据增加到总表中
				setSuggestion(CommonUtils.SUCCSUGG);
				return ret;
			}
			
			
//		new MyTransationTemplate() {
//				
//				@Override
//				protected void doExecuteCallback() throws Exception {
//					
//					
//					saleMonitorMonth = initSaleMonitorMonthToAdd(saleMonitor, saleMonitorMonth);//
//					saleMonitorAll = initSaleMonitorAllToAdd(saleMonitor, saleMonitorAll);
//					
//					saleMonitorMonthServices.addSaleMonitorMonth(saleMonitorMonth);
//					saleMonitorAllServices.addSaleMonitorAll(saleMonitorAll);
//					
//					//修改该月该日期后的相关数据
//					saleMonitorMonthServices.updateMonthFromAddSaleMonitor(saleMonitor);
//					saleMonitorAllServices.updateAllFromAddSaleMonitor(saleMonitor);
//					
//					setSuggestion(CommonUtils.SUCCSUGG);
//					
//			}
//			}.execute();
			
		}catch(Exception e){
			e.printStackTrace();
			setSuggestion(CommonUtils.FAILSUGG);
		}
		
		return ret;
	}
	
	
	public String inputSaleForAdmin() throws Exception{

		String ret = "input_admin";
	
		try{
			
			initSelCompany();
			initSelProject();
			
			Date date = saleMonitor.getMonitorDate();
			
			saleMonitor = initSaleMonitorToAddForAdmin(saleMonitor);
			
			String monitorDate = CustomerUtils.getDateString(date);
			
			//不能录入今天以后的数据
			boolean isAfterToday = CommonUtils.isAfterToday(monitorDate);
			if(isAfterToday){
				setSuggestion("不能录入超过今天的数据");
				return ret;
			}
			
			SaleMonitorCond cond = new SaleMonitorCond();
			cond.setMonitorDate(monitorDate);
			cond.setProjectId(saleMonitor.getProjectId());
			boolean isExists = saleMonitorServices.findMonitorDateIsExistsByProject(cond); //该日期下的该项目是否有值
			
			saleMonitor.setSumArea(saleMonitor.getHouseArea().add(saleMonitor.getParkArea().add(saleMonitor.getShopArea())));
			saleMonitor.setSumMoney(saleMonitor.getShopMoney().add(saleMonitor.getParkMoney().add(saleMonitor.getHouseMoney())));
			saleMonitor.setSumNum(saleMonitor.getParkNum()+saleMonitor.getHouseNum()+saleMonitor.getShopNum());
			saleMonitor.setUndoSumArea(saleMonitor.getUndoShopArea().add(saleMonitor.getUndoParkArea().add(saleMonitor.getUndoHouseArea())));
			saleMonitor.setUndoSumMoney(saleMonitor.getUndoHouseMoney().add(saleMonitor.getUndoParkMoney().add(saleMonitor.getUndoShopMoney())));
			saleMonitor.setUndoSumNum(saleMonitor.getUndoShopNum()+saleMonitor.getUndoParkNum()+saleMonitor.getUndoHouseNum());
			
			saleMonitor.setContractSumArea(saleMonitor.getContractHouseArea().add(saleMonitor.getContractParkArea().add(saleMonitor.getContractShopArea())));
			saleMonitor.setContractSumMoney(saleMonitor.getContractShopMoney().add(saleMonitor.getContractParkMoney().add(saleMonitor.getContractHouseMoney())));
			saleMonitor.setContractSumNum(saleMonitor.getContractParkNum() + saleMonitor.getContractHouseNum() + saleMonitor.getContractShopNum());
			
			if(isExists){
				
				setSuggestion("该日期下的项目数据已经存在");
				return ret;
			}else{
				saleMonitorServices.addSaleMonitorForAdmin(saleMonitor); //要一并把相关的数据增加到总表中
				setSuggestion(CommonUtils.SUCCSUGG);
				return ret;
			}
			
		}catch(Exception e){
			e.printStackTrace();
			setSuggestion(CommonUtils.FAILSUGG);
		}
		
		return ret;
	}
	
	
	
	private SaleMonitor initSaleMonitorToAdd(SaleMonitor saleMonitor){
		
		HttpSession session = request.getSession();
		Object obj = session.getAttribute(CommonUtils.USER_SESSION_KEY);
		UserAccount user = (UserAccount) obj;
		
		Date date = new Date();
		
		saleMonitor.setIsDeleted(CommonUtils.NORMAL);
		saleMonitor.setCreatedId(user.getId());
		saleMonitor.setCreatedTime(date);
		saleMonitor.setModId(user.getId());
		saleMonitor.setModTime(date);
		saleMonitor.setProjectId(user.getProjectId());
		saleMonitor.setCompanyId(user.getCompanyId());
		
		return saleMonitor;
	}
	
	private SaleMonitor initSaleMonitorToAddForAdmin(SaleMonitor saleMonitor){
		
		HttpSession session = request.getSession();
		Object obj = session.getAttribute(CommonUtils.USER_SESSION_KEY);
		UserAccount user = (UserAccount) obj;
		
		Date date = new Date();
		
		saleMonitor.setIsDeleted(CommonUtils.NORMAL);
		saleMonitor.setCreatedId(user.getId());
		saleMonitor.setCreatedTime(date);
		saleMonitor.setModId(user.getId());
		saleMonitor.setModTime(date);
		
		return saleMonitor;
	}
	
	/////
	private SaleMonitorMonth saleMonitorMonth;
	private SaleMonitorAll saleMonitorAll;
	private SaleMonitor saleMonitor;
	private String suggestion; //操作提示
	private Integer saleMonitorId;
	
	
	private LinkedHashMap<String, String> selCompany;
	private LinkedHashMap<String, String> selProject;
	
	public void setSelProject(LinkedHashMap<String, String> selProject) {
		this.selProject = selProject;
	}
	
	public LinkedHashMap<String, String> getSelProject() {
		return selProject;
	}
	
	private void initSelProject(){
		selProject = new LinkedHashMap<String, String>();
		
		selProject.put("", CommonUtils.ALL);
		
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

	public Integer getSaleMonitorId() {
		return saleMonitorId;
	}

	public void setSaleMonitorId(Integer saleMonitorId) {
		this.saleMonitorId = saleMonitorId;
	}


	public ISaleMonitorServices getSaleMonitorServices() {
		return saleMonitorServices;
	}


	public void setSaleMonitorServices(ISaleMonitorServices saleMonitorServices) {
		this.saleMonitorServices = saleMonitorServices;
	}


	public ISaleMonitorMonthServices getSaleMonitorMonthServices() {
		return saleMonitorMonthServices;
	}


	public void setSaleMonitorMonthServices(
			ISaleMonitorMonthServices saleMonitorMonthServices) {
		this.saleMonitorMonthServices = saleMonitorMonthServices;
	}


	public ISaleMonitorAllServices getSaleMonitorAllServices() {
		return saleMonitorAllServices;
	}


	public void setSaleMonitorAllServices(
			ISaleMonitorAllServices saleMonitorAllServices) {
		this.saleMonitorAllServices = saleMonitorAllServices;
	}


	public SaleMonitorMonth getSaleMonitorMonth() {
		return saleMonitorMonth;
	}


	public void setSaleMonitorMonth(SaleMonitorMonth saleMonitorMonth) {
		this.saleMonitorMonth = saleMonitorMonth;
	}


	public SaleMonitorAll getSaleMonitorAll() {
		return saleMonitorAll;
	}


	public void setSaleMonitorAll(SaleMonitorAll saleMonitorAll) {
		this.saleMonitorAll = saleMonitorAll;
	}


	public SaleMonitor getSaleMonitor() {
		return saleMonitor;
	}


	public void setSaleMonitor(SaleMonitor saleMonitor) {
		this.saleMonitor = saleMonitor;
	}


	public String getSuggestion() {
		return suggestion;
	}


	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}
}
