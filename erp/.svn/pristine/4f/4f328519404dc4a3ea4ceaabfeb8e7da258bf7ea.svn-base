package com.ihk.saleunit.action.new_;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.saleunit.data.pojo.Confirm;
import com.ihk.saleunit.data.pojo.ConfirmCond;
import com.ihk.saleunit.data.pojo.Contract;
import com.ihk.saleunit.data.pojo.ContractCond;
import com.ihk.saleunit.data.pojo.ContractCustomer;
import com.ihk.saleunit.data.services.IConfirmServices;
import com.ihk.saleunit.data.services.IContractCustomerServices;
import com.ihk.saleunit.data.services.IContractServices;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;
import com.ihk.utils.SupperConfirm;

/**
 * 修改客户资料 
 * 根据unitId 以及它的状态 来找到他的 合同和签约信息
 * 然后新建一个客户 将他的ID修改过来
 * 然后记录到log
 */
public class GuangzhouAppointContractCustomerAction extends SupperAction{

	private static final long serialVersionUID = 1L;
	
	@Autowired IContractServices iContractServices;
	@Autowired IConfirmServices iConfirmServices;
	@Autowired IContractCustomerServices iContractCustomerServices;
	
	
	private int id;
	private int state;
	private int isempty = 0;
	
	private ContractCustomer showCus;//旧的客户信息
	private ContractCustomer addCus;//新的客户信息
	
	private String tips;
	/**
	 * 根据选择单元
	 * 找到合同信息
	 * 或者认购信息
	 * state =认购 找认购
	 * state >认购 找合同 
	 * 
	 * */
	public String showContract(){
		showCus = new ContractCustomer();
		int cuid = 0;
		if(id == 0){
			isempty =1;
			return "suc";
		}
			
		request.getSession().removeAttribute("hotSupperConfirm");
		try {
			ContractCond comd = new ContractCond();
			comd.setUnitId(id+"");
			SupperConfirm c = iContractServices.findContract(comd).get(0);
			cuid = c.getCustomerId();
		//	request.getSession().setAttribute("hotContract", c);
			if(id == 0){
				isempty =1;
				return "suc";
			}
			showCus = iContractCustomerServices.findContractCustomerById(cuid);
			return "suc";
		} catch (Exception e) {
			isempty =1;
		}
		
		try {
			ConfirmCond comd = new ConfirmCond();
			comd.setUnitId(id+"");
			SupperConfirm c = iConfirmServices.findConfirm(comd).get(0);
			cuid = c.getCustomerId();
		//	request.getSession().setAttribute("hotConfirm", c);
			if(id == 0){
				isempty =1;
				return "suc";
			}
			showCus = iContractCustomerServices.findContractCustomerById(cuid);
			isempty =0;
			return "suc";
		} catch (Exception e) {
			isempty =1;
		}
		
		return "suc";
	}
	
	/**
	 * 在已经找到 合同 或者认购信息的情况下 可以新建一个客户
	 * 一个弹出框来新建客户
	 * */  
	public String updateContract(){
		return "suc";
	}
	
	/**
	 * 提交新建的客户信息 然后把相关的认购 或者合同客户ID做出修改
	 * 做出log记录
	 * */
	public String updateContractForm(){
		addCus.setConfirmType("1");
		addCus.setIsDeleted("0");
		addCus.setCreatedId(SessionUser.getUserId());
		addCus.setCreatedTime(new Date());
		addCus.setModId(SessionUser.getUserId());
		addCus.setModTime(addCus.getCreatedTime());
		this.iContractCustomerServices.addContractCustomer(addCus);
		
		
		try {
			ContractCond comd = new ContractCond();
			comd.setUnitId(id+"");
			Contract c = iContractServices.findContract(comd).get(0);
			
			
			
				c.setCustomerId(addCus.getId());
				iContractServices.updateContract(c);
				return "suc";
			
			
		} catch (Exception e) {
			
		}
		
		try {
			ConfirmCond comd = new ConfirmCond();
			comd.setUnitId(id+"");
			Confirm c = iConfirmServices.findConfirm(comd).get(0);
			
		
				c.setCustomerId(addCus.getId());
				iConfirmServices.updateConfirm(c);
				return "suc";
		
		
		} catch (Exception e) {
			
		}
		
		return "suc";
	}

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public ContractCustomer getShowCus() {
		return showCus;
	}

	public void setShowCus(ContractCustomer showCus) {
		this.showCus = showCus;
	}

	public ContractCustomer getAddCus() {
		return addCus;
	}

	public void setAddCus(ContractCustomer addCus) {
		this.addCus = addCus;
	}

	public int getIsempty() {
		return isempty;
	}

	public void setIsempty(int isempty) {
		this.isempty = isempty;
	}

	public String getTips() {
		return tips;
	}

	public void setTips(String tips) {
		this.tips = tips;
	}
	
	
	
}
