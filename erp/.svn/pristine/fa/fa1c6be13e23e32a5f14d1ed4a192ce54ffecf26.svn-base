package com.ihk.saleunit.action.new_;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.ContUnitSaleState;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.saleunit.data.pojo.ConfirmCond;
import com.ihk.saleunit.data.pojo.ContractCond;
import com.ihk.saleunit.data.pojo.UnitGift;
import com.ihk.saleunit.data.pojo.UnitGiftCond;
import com.ihk.saleunit.data.services.IConfirmServices;
import com.ihk.saleunit.data.services.IContractServices;
import com.ihk.saleunit.data.services.IUnitGiftServices;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;
import com.ihk.utils.SupperConfirm;

/**
 * 单元礼品管理
 */
public class GuangZhouAppointGiftManagerAction extends SupperAction{

	private static final long serialVersionUID = 1L;
	
	
	@Autowired IUnitGiftServices unitGiftServices;
	@Autowired IPropertyUnitServices propertyUnitServices;
	@Autowired IConfirmServices confirmServices;
	@Autowired IContractServices contractServices;
	
	private int id;
	private List<UnitGift> unitGiftList;
	private UnitGift addGift;
	
	private String tips;
	
	public String index(){
		UnitGiftCond cond = new UnitGiftCond();
		cond.setUnitId(id+"");
		unitGiftList = unitGiftServices.findUnitGift(cond);
		return "suc";
	}
	
	public String dialog(){
		
		return "suc";
	}
	
	public String form(){
		if(id ==0){
			tips = "请先选择单元.";
			return "suc";
		}
		PropertyUnit tmpUnit = this.propertyUnitServices.findPropertyUnitById(id);
		try {
			if(tmpUnit.getSaleState() == null){
				tips = "没有找到客户资料,不能新建赠品.";
				return "suc";
			}else if(tmpUnit.getSaleState().equals(ContUnitSaleState.CONFIRM )){
				//合同状态房间
				ConfirmCond cond = new ConfirmCond();
				cond.setUnitId(id+"");
				SupperConfirm tmc = confirmServices.findConfirm(cond).get(0);
				addGift.setCustomerId(tmc.getCustomerId());
			}else if( Integer.parseInt(tmpUnit.getSaleState()) >= Integer.parseInt(ContUnitSaleState.CONTRACT) ){
				//签约状态
				ContractCond cond = new ContractCond();
				cond.setUnitId(id+"");
				SupperConfirm tmc = contractServices.findContract(cond).get(0);
				addGift.setCustomerId(tmc.getCustomerId());
			}
		} catch (Exception e) {
			tips = "没有找到客户资料,不能新建赠品.";
			return "suc";
		}
		addGift.setIsDeleted("0");
		addGift.setCreatedId(SessionUser.getUserId());
		addGift.setCreatedTime(new Date());
		addGift.setModId(SessionUser.getUserId());
		addGift.setModTime(addGift.getCreatedTime());
		addGift.setUserId(SessionUser.getUserId());
		addGift.setUnitId(id);
		unitGiftServices.addUnitGift(addGift);
		tips = "新建赠品成功!";
		return "suc";
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public List<UnitGift> getUnitGiftList() {
		return unitGiftList;
	}


	public void setUnitGiftList(List<UnitGift> unitGiftList) {
		this.unitGiftList = unitGiftList;
	}


	public UnitGift getAddGift() {
		return addGift;
	}


	public void setAddGift(UnitGift addGift) {
		this.addGift = addGift;
	}

	public String getTips() {
		return tips;
	}

	public void setTips(String tips) {
		this.tips = tips;
	}
	
	
	
}
