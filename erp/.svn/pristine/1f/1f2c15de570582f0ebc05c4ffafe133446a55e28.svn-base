package com.ihk.saleunit.action.discount;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.ContUnitComputeWay;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.saleunit.data.pojo.ConfirmDiscount;
import com.ihk.saleunit.data.pojo.UnitDiscount;
import com.ihk.saleunit.data.services.IConfirmDiscountServices;
import com.ihk.saleunit.data.services.IUnitDiscountServices;
import com.ihk.utils.CommonPojoUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.MyTransationTemplate;
import com.ihk.utils.SupperAction;
import com.ihk.utils.saleunitnew.DiscountManagerUtils;

/**
 * 单元折扣(使用)
 * @author dtc
 * 2012-10-26,上午10:33:14
 */
public class UnitDiscountManager extends SupperAction{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	IPropertyUnitServices unitServices;
	@Autowired
	IUnitDiscountServices unitDiscountServices;
	@Autowired
	IConfirmDiscountServices confirmDiscountServices;

	/**
	 * 跳到新增单元折扣界面
	 * @return
	 * @throws Exception
	 */
	public String createUnitDiscountDialog() throws Exception{
		
		int unitId = Integer.parseInt(request.getParameter("unitId"));
		
		init(unitId);
		
		removeSuggestion();
		
		return "createUnitDiscountDialog";
	}
	
	/**
	 * 保存单元折扣
	 * @return
	 * @throws Exception
	 */
	@Deprecated
	public String createUnitDiscount() throws Exception{
		
		try{
			
			new MyTransationTemplate() {
				
				@Override
				protected void doExecuteCallback() throws Exception {
					
					String[] payWayDiscountIds = request.getParameterValues("payWayDiscount");
					
					unitDiscount.setDiscountName(DiscountManagerUtils.initUnitDiscountDiscountNameByPayWayDiscountIds(payWayDiscountIds));
					CommonPojoUtils.initPojoCommonFiled(unitDiscount);
					
					unitDiscountServices.addUnitDiscount(unitDiscount);
					
					for(String payWayDiscountId : payWayDiscountIds){
						
						ConfirmDiscount confirmDiscount = new ConfirmDiscount();
						confirmDiscount.setUnitDiscountId(unitDiscount.getId());
						//confirmDiscount.setPayWayDiscountId(Integer.parseInt(payWayDiscountId));
						
						CommonPojoUtils.initPojoCommonFiled(confirmDiscount);
						
						confirmDiscountServices.addConfirmDiscount(confirmDiscount);
					}
					
					setUpMarkToClose();
					setSuggestion_Success();
					
				}
			}.execute();
			
		}catch (Exception e) {
			unitDiscount.setId(0);
			setSuggestion_Fail();
		}
		
		init(unitDiscount.getUnitId());
		return "createUnitDiscount";
	}
	
	/**
	 * 关闭单元折扣,获取设置显示的值
	 * @return
	 * @throws Exception
	 */
	public String getUnitDiscountManagerCloseShowByDiscountId() throws Exception{
		
		Map<String, String> map = DiscountManagerUtils.getUnitDiscountManagerCloseShowAndMultiplyByDiscountId(request);
		
		CustomerUtils.writeResponse(response, CommonUtils.getMapJson(map));
		
		return null;
	}
	
	private void init(int unitId){
		
		//查看修改的时候unitId为0,
		if(unitId > 0){
			unit = unitServices.findPropertyUnitById(unitId);
		}
		
		selComputeWay = ContUnitComputeWay.getWayMap();
		
		mainId = request.getParameter("mainId");
		confirmType = request.getParameter("confirmType");
		
		if(!CommonUtils.isIntString(mainId)){
			mainId = "0";
		}
		
		if(!CommonUtils.isIntString(confirmType)){
			confirmType = "0";
		}
		
		selPayWayDiscount = DiscountManagerUtils.initSelPayWayDiscountByPayWayId(Integer.parseInt(payWayId));
		
	}
	
	
	////
	private PropertyUnit unit;
	
	private String mainId; //如果在查看认购或签约的时候,新建折扣,那该字段有用,默认为0
	
	private LinkedHashMap<String, String> selComputeWay; //折扣计算方式
	
	private String confirmType; //认购或合同
	
	private Map<String, String> selPayWayDiscount; //具体的折扣(百分比)
	
	private UnitDiscount unitDiscount;
	
	private String payWayId;
	
	public void setPayWayId(String payWayId) {
		this.payWayId = payWayId;
	}
	
	public String getPayWayId() {
		return payWayId;
	}
	
	public void setUnitDiscount(UnitDiscount unitDiscount) {
		this.unitDiscount = unitDiscount;
	}
	
	public UnitDiscount getUnitDiscount() {
		return unitDiscount;
	}
	
	public void setSelPayWayDiscount(Map<String, String> selPayWayDiscount) {
		this.selPayWayDiscount = selPayWayDiscount;
	}
	
	public Map<String, String> getSelPayWayDiscount() {
		return selPayWayDiscount;
	}

	public PropertyUnit getUnit() {
		return unit;
	}

	public void setUnit(PropertyUnit unit) {
		this.unit = unit;
	}

	public String getMainId() {
		return mainId;
	}

	public void setMainId(String mainId) {
		this.mainId = mainId;
	}

	public LinkedHashMap<String, String> getSelComputeWay() {
		return selComputeWay;
	}

	public void setSelComputeWay(LinkedHashMap<String, String> selComputeWay) {
		this.selComputeWay = selComputeWay;
	}

	public String getConfirmType() {
		return confirmType;
	}

	public void setConfirmType(String confirmType) {
		this.confirmType = confirmType;
	}
	
}
