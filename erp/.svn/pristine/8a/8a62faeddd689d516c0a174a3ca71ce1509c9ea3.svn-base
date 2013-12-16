package com.ihk.sale.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.EnumDevFlag;
import com.ihk.constanttype.EnumPrivCode;
import com.ihk.permission.PermissionUtils;
import com.ihk.sale.data.pojo.SaleMonitor;
import com.ihk.sale.data.pojo.SaleMonitorLog;
import com.ihk.sale.data.services.ISaleMonitorAllServices;
import com.ihk.sale.data.services.ISaleMonitorLogServices;
import com.ihk.sale.data.services.ISaleMonitorMonthServices;
import com.ihk.sale.data.services.ISaleMonitorServices;
import com.ihk.sale.data.services.ISaleMonitorWeekServices;
import com.ihk.user.data.pojo.UserAccount;
import com.ihk.user.data.services.ICompanyProjectServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.SupperAction;

/**
 * 更新销控
 *
 */
public class UpdateSaleAction  extends SupperAction{

	private static final long serialVersionUID = 1L;
	@Autowired
	ISaleMonitorServices saleMonitorServices;
	@Autowired
	ISaleMonitorWeekServices saleMonitorWeekServices;
	@Autowired
	ISaleMonitorMonthServices saleMonitorMonthServices;
	@Autowired
	ISaleMonitorAllServices saleMonitorAllServices;
	@Autowired
	ICompanyProjectServices comProjectServices;
	@Autowired
	ISaleMonitorLogServices saleMonitorLogServices;
	String id;
	SaleMonitor saleMonitor;
	String suggestion;
	SaleMonitor oldsaleMonitor;
	List<SaleMonitorLog> logMonitorList;
	
	public String updateForSaleSubmit() throws Exception{
		boolean isUpdateSucc = true;
		int saleMonitorId = saleMonitor.getId();
		
		HttpSession session = request.getSession();
		
		session.setAttribute("saleMonitorId", saleMonitorId);
		final SaleMonitor oldSaleMonitor = saleMonitorServices.findSaleMonitorById(saleMonitorId);
		
		try{
			UserAccount user = (UserAccount) session.getAttribute(CommonUtils.USER_SESSION_KEY);
			
			saleMonitor = initSaleMonitorToUpdate(user, oldSaleMonitor, saleMonitor); //非界面的其他信息
			
			//合计计算
			saleMonitor.setSumArea(saleMonitor.getHouseArea().add(saleMonitor.getParkArea().add(saleMonitor.getShopArea())));
			saleMonitor.setSumMoney(saleMonitor.getShopMoney().add(saleMonitor.getParkMoney().add(saleMonitor.getHouseMoney())));
			saleMonitor.setSumNum(saleMonitor.getParkNum()+saleMonitor.getHouseNum()+saleMonitor.getShopNum());
			saleMonitor.setUndoSumArea(saleMonitor.getUndoShopArea().add(saleMonitor.getUndoParkArea().add(saleMonitor.getUndoHouseArea())));
			saleMonitor.setUndoSumMoney(saleMonitor.getUndoHouseMoney().add(saleMonitor.getUndoParkMoney().add(saleMonitor.getUndoShopMoney())));
			saleMonitor.setUndoSumNum(saleMonitor.getUndoShopNum()+saleMonitor.getUndoParkNum()+saleMonitor.getUndoHouseNum());
			
			saleMonitor.setContractSumArea(saleMonitor.getContractHouseArea().add(saleMonitor.getContractParkArea().add(saleMonitor.getContractShopArea())));
			saleMonitor.setContractSumMoney(saleMonitor.getContractShopMoney().add(saleMonitor.getContractParkMoney().add(saleMonitor.getContractHouseMoney())));
			saleMonitor.setContractSumNum(saleMonitor.getContractParkNum() + saleMonitor.getContractHouseNum() + saleMonitor.getContractShopNum());
			
			saleMonitorServices.updateSaleMonitor(oldSaleMonitor,saleMonitor);
			
		}catch(Exception e){
			isUpdateSucc = false;
			e.printStackTrace();
		}
		
		session.setAttribute("saleMonitor", saleMonitor);
		session.setAttribute("time", CustomerUtils.getNowTimeForString());
		
		if(isUpdateSucc){
			setSuggestion(CommonUtils.SUCCSUGG);
			
		}else{
			setSuggestion(CommonUtils.FAILSUGG);
			
		}
		logMonitorList = saleMonitorLogServices.findSaleMonitorLogByDateId(saleMonitor.getId());
		
		return updateForSale();
		//return "updateForSale";
	}
	
	
	public String updateForSale() throws Exception{
		//点击查看具体的数据,根据不同的情况跳到不同的页面
		
		String ret = "";
		
		HttpSession session = request.getSession();
		int id = 0;
		Object obj = session.getAttribute("saleMonitorId"); 
		if(obj != null){
			//表示从方法updateForSaleSubmit()过来,
			id = Integer.parseInt(obj.toString());
			
		}else{
			//表示从查看详情过来,要清空提示
			session.removeAttribute("suggestion");
			id = Integer.parseInt(request.getParameter("id"));
		}
		
		SaleMonitor saleMonitor = saleMonitorServices.findSaleMonitorById(id);
		session.setAttribute("saleMonitor", saleMonitor);
		session.removeAttribute("saleMonitorId");
		logMonitorList = saleMonitorLogServices.findSaleMonitorLogByDateId(saleMonitor.getId());
		
		//要进行相关的判断:
		//1.如果为管理员或非管理员但是还没有超过24h,那么可以修改所有的字段
		//2.否则就只能修改退挞定的字段
		
		boolean isCanModify = PermissionUtils.hasPermission( EnumPrivCode.LOCK_SALE,EnumDevFlag.HENGDA); //是否具有权限LOCK_SALE
		if(!isCanModify){
			//表示为普通录入人员
			Date createdDate = saleMonitor.getCreatedTime();
			Date now = new Date();
			
			boolean isOneDayLater = CommonUtils.isOneDayLater(createdDate, now); //判断是否超过24h
			
			if(isOneDayLater){
				//只能修改退挞定字段
				ret = "noAdminUpdateForSaleJsp";
				
			}else{
				//等同于管理员
				ret = "adminUpdateForSaleJsp";
			}
		}else{
			//表示为管理员
			ret = "adminUpdateForSaleJsp";
		}
		
		return ret;
		//return "updateForSaleJsp";
	}
	
	private SaleMonitor initSaleMonitorToUpdate(UserAccount user, SaleMonitor oldSaleMonitor, SaleMonitor newSaleMonitor){
		Date date = new Date();
		
		newSaleMonitor.setProjectId(oldSaleMonitor.getProjectId());
		newSaleMonitor.setCompanyId(oldSaleMonitor.getCompanyId());
		newSaleMonitor.setIsDeleted(oldSaleMonitor.getIsDeleted());
		newSaleMonitor.setCreatedId(oldSaleMonitor.getCreatedId());
		newSaleMonitor.setCreatedTime(oldSaleMonitor.getCreatedTime());
		newSaleMonitor.setModId(user.getId());
		newSaleMonitor.setModTime(date);
		
		return newSaleMonitor;
	}
	
	public List<SaleMonitorLog> getLogMonitorList() {
		return logMonitorList;
	}

	public void setLogMonitorList(List<SaleMonitorLog> logMonitorList) {
		this.logMonitorList = logMonitorList;
	}

	public SaleMonitor getOldsaleMonitor() {
		return oldsaleMonitor;
	}

	public void setOldsaleMonitor(SaleMonitor oldsaleMonitor) {
		this.oldsaleMonitor = oldsaleMonitor;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
