package com.ihk.saleunit.action.new_financial;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.ContUnitSaleState;
import com.ihk.constanttype.EnumTextTypeName;
import com.ihk.constanttype.EnumUnitPayBillFormula;
import com.ihk.property.data.pojo.MyPayWay;
import com.ihk.property.data.pojo.PayWayDetail;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.pojo.UnitPayBill;
import com.ihk.property.data.services.IPayWayDetailServices;
import com.ihk.property.data.services.IPayWayServices;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.property.data.services.IUnitPayBillServices;
import com.ihk.saleunit.data.pojo.Confirm;
import com.ihk.saleunit.data.pojo.ConfirmBook;
import com.ihk.saleunit.data.pojo.Contract;
import com.ihk.setting.data.services.IProjectTextServices;
import com.ihk.utils.ActionTemplate;
import com.ihk.utils.CommonPojoUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.SupperAction;
import com.ihk.utils.common.setup.PayTypeUtils;
import com.ihk.utils.financial.FinancialUtils;
import com.ihk.utils.method.ActionAjaxMethodModifyCallback;
import com.ihk.utils.method.ActionAjaxMethodModifyNoThrowsExceptionCallback;
import com.ihk.utils.saleunit.PayWayUtils;

/**
 * 财务管理,单元付款 (暂用销控中心的,有待优化)--(调整为)-->销控中心,收款情况(2013.6.13)
 * @author dtc
 * 2012-7-27
 */
public class PayInfoAction extends SupperAction{

	private static final long serialVersionUID = 1L;
	
	@Autowired 
	IUnitPayBillServices unitPayBillServices;
	@Autowired
	IPayWayServices payWayServices;
	@Autowired
	IPayWayDetailServices payWayDetailServices;
	@Autowired
	IPropertyUnitServices unitServices;
	@Autowired
	IProjectTextServices projectTextServices; 
	
	/**
	 * 判断单元是否已经有对数
	 * @return
	 * @throws Exception
	 */
	public String isUnitHaveCheckfee() throws Exception{
		
		int unitIdInt = Integer.parseInt(unitId);
		
		PropertyUnit unit = unitServices.findPropertyUnitById(unitIdInt);
		
		boolean isHave = false;
		
		if(unit.getCheckfeeType() > 0){
			isHave = true;
		}
		
		CustomerUtils.writeResponse(response, "{\"type\":\"" + isHave + "\"}");
		
		return null;
	}
	
	/**
	 * 判断单元是否已经有实收或对数
	 * @return
	 * @throws Exception
	 */
	public String isUnitHaveReceiptOrCheckfee() throws Exception{
		
		int unitIdInt = Integer.parseInt(unitId);
		
		boolean isReceipt = FinancialUtils.isUnitPayBillListHaveReceiptByUnitId(unitIdInt);
		PropertyUnit unit = unitServices.findPropertyUnitById(unitIdInt);
		
		boolean isHave = false;
		
		if(isReceipt || unit.getCheckfeeType() > 0){
			isHave = true;
		}
		
		CustomerUtils.writeResponse(response, "{\"type\":\"" + isHave + "\"}");
		
		return null;
	}
	
	/**
	 * 判断单元是否已经有实收 
	 * @return
	 * @throws Exception
	 */
	public String isUnitHaveReceipt() throws Exception{
		
		boolean isReceipt = FinancialUtils.isUnitPayBillListHaveReceiptByUnitId(Integer.parseInt(unitId));
		
		CustomerUtils.writeResponse(response, "{\"type\":\"" + isReceipt + "\"}");
		
		return null;
	}
	
	/**
	 * 判断付款方式对应的付款明细中的fee_type是否包含按揭
	 * @return
	 * @throws Exception
	 */
	public String isPayWayDetailHaveMortgage() throws Exception{
		
		List<PayWayDetail> detailList = payWayDetailServices.findPayWayDetailByWayId(wayId);
		
		boolean isHave = PayWayUtils.isPayWayDetailHaveMortgage(detailList);
		
		CustomerUtils.writeResponse(response, "{\"type\":\"" + isHave + "\"}");
		
		return null;
	}
	
	/**
	 * 收款情况
	 * @return
	 * @throws Exception
	 */
	public String unitPayInfo() throws Exception{
		
		//应该加上单元状态的判断
		//销控中心
		int unitId = 0;
		try{
			unitId =Integer.parseInt(getUnitId());
		}catch (Exception e) {
		}
		if(unitId == 0){
			isSale = false;
			return "unitPayInfo";
		}
		PropertyUnit unit = unitServices.findPropertyUnitById(unitId);
		isSale = unit.isSale();
		if(!isSale){
			return "unitPayInfo";
		}
		unitPayBillList = unitPayBillServices.findUnitPayBillByUnitId(unitId);
		
		initOtherMoney(unitPayBillList);
		
		return "unitPayInfo";
	}
	
	/**
	 * 跳到使用公式的界面
	 * @return
	 * @throws Exception
	 */
	public String forUnitPayBillFormula() throws Exception{
		
		selPayWay = PayWayUtils.getSelPayWayHaveDetailByUnitId(Integer.parseInt(unitId));
		selFormula = EnumUnitPayBillFormula.getAllFormula();
		selProportion = PayWayUtils.getSelProportion();
		
		return "forUnitPayBillFormula";
	}
	
	/**
	 * 使用公式
	 * @return
	 * @throws Exception
	 */
	public String addUnitPayBillFormula() throws Exception{
		
		ActionTemplate.executeAjaxMethod(true, this, new ActionAjaxMethodModifyCallback() {
			
			@Override
			public void modifyMethod() throws Exception {
				
				int payWayId = myPayWay.getPayWayId(); //付款方式
				if(payWayId == 0){
					throw new Exception("付款方式不能为空");
				}
				
				//使用公式及单元id改变对应的应收,并修改对应成交或合同的付款方式
				FinancialUtils.addUnitPayBillFormulaByMyPayWayAndId(myPayWay);
				
			}

			@Override
			public void modifyMethodException(Exception e) {
				setUpEasyuiAjaxForFail(e.getMessage());
			}
		});
		
		return null;
	}
	
	/**
	 * 跳到增加应收款
	 * @return
	 * @throws Exception
	 */
	public String forAddUnitPayBill() throws Exception{
		
		initForAddUnitPayBill(Integer.parseInt(getUnitId()));
		
		removeSuggestion();
		
		return "forAddUnitPayBill";
	}
	
	/**
	 * 获取对应的收款类别及收款内容
	 * @return
	 * @throws Exception
	 */
	public String getFeeTypeByPayWayId() throws Exception{
		
		int payWayId = Integer.parseInt(request.getParameter("payWayId"));
		String payType = request.getParameter("payTypeId");
		
		List<PayWayDetail> feeTypeDetailList = payWayDetailServices.findPayWayDetailByWayIdAndPayType(payWayId, payType);
		
		Map<String, String> map = new HashMap<String, String>();
		
		if(!CommonUtils.isCollectionEmpty(feeTypeDetailList)){
			
			for(PayWayDetail feeTypeDetail : feeTypeDetailList){
				
				map.put(feeTypeDetail.getDetailName(), feeTypeDetail.getDetailName());
			}
			
		}
		
		String out = CommonUtils.getSelectContent(map, true);
		
		CustomerUtils.writeResponse(response, out);
		
		return null;
	}
	
	/**
	 * 添加应收款,因前台页面的需要,保存前要转换一下typeName,key-->value
	 * ==>改为easyui的模式
	 * @return
	 * @throws Exception
	 */
	@Deprecated
	public String addUnitPayBill_old() throws Exception{

		//如果为null,设置为0,避免空指针
		payBill.setShouldPay(payBill.getShouldPay()==null ? new BigDecimal(0) : payBill.getShouldPay());
		payBill.setNotPay(payBill.getShouldPay());
		payBill.setHadPay(new BigDecimal(0));
		
		CommonPojoUtils.initPojoCommonFiled(payBill);
		
		try{
			
			unitPayBillServices.addUnitPayBill(payBill);
			
			setSuggestion(CommonUtils.SUCCSUGG);
			setUpMarkToClose();
			
		}catch(Exception e){
			
			payBill.setTypeName("");
			setSuggestion(CommonUtils.FAILSUGG);
		}
		
		initForAddUnitPayBill(payBill.getUnitId());
		
		return "addUnitPayBill";
	}
	
	/**
	 * 添加应收款
	 * @return
	 * @throws Exception
	 */
	public String addUnitPayBill() throws Exception{
		
		ActionTemplate.executeAjaxMethod(this, new ActionAjaxMethodModifyNoThrowsExceptionCallback() {
			
			@Override
			public void modifyMethod() throws Exception {
				
				//如果为null,设置为0,避免空指针
				payBill.setShouldPay(payBill.getShouldPay()==null ? new BigDecimal(0) : payBill.getShouldPay());
				payBill.setNotPay(payBill.getShouldPay());
				payBill.setHadPay(new BigDecimal(0));
				
				CommonPojoUtils.initPojoCommonFiled(payBill);
				
				unitPayBillServices.addUnitPayBill(payBill);
				
			}
		});
		
		return null;
	}
	
	/**
	 * 跳到修改页面,因前台页面的需要,要转换一下typeName,value-->key
	 * @return
	 * @throws Exception
	 */
	public String forModifyUnitPayBill() throws Exception{
		
		int billId = Integer.parseInt(request.getParameter("billId"));
		
		payBill = unitPayBillServices.findUnitPayBillById(billId);
		
		initForModifyUnitPayBill(payBill);
		//转换typeName
		//payBill.setTypeName(PayTypeUtils.getPayTypeKeyByValue(payBill.getTypeName()));
		
		removeSuggestion();
		
		return "forModifyUnitPayBill";
	}
	
	/**
	 * 更新应收款,因前台页面的需要,要转换一下typeName,key-->value
	 * @return
	 * @throws Exception
	 */
	@Deprecated
	public String updateUnitPayBill_old() throws Exception{
		
		UnitPayBill oldPayBill = unitPayBillServices.findUnitPayBillById(payBill.getId());
		
		payBill.setHadPay(oldPayBill.getHadPay());
		payBill.setNotPay(payBill.getShouldPay().subtract(oldPayBill.getHadPay()));
		payBill.setIsVoid(oldPayBill.getIsVoid());
		
		//转换typeName
		//payBill.setTypeName(PayTypeUtils.getPayTypeValueByKey(payBill.getTypeName()));
		
		CommonPojoUtils.initPojoForUpdate(oldPayBill, payBill);
		
		try{
			
			unitPayBillServices.updateUnitPayBill(payBill);
			
			setSuggestion(CommonUtils.SUCCSUGG);
			setUpMarkToClose();
			
		}catch(Exception e){
			
			//转换typeName成对应的英文key
			//payBill.setTypeName(PayTypeUtils.getPayTypeKeyByValue(payBill.getTypeName()));
			setSuggestion(CommonUtils.FAILSUGG);
		}
		
		payBill = unitPayBillServices.findUnitPayBillById(payBill.getId());
		
		initForModifyUnitPayBill(payBill);
		
		return "updateUnitPayBill";
	}
	
	/**
	 * 更新应收款
	 * @return
	 * @throws Exception
	 */
	public String updateUnitPayBill() throws Exception{
		
		ActionTemplate.executeAjaxMethod(this, new ActionAjaxMethodModifyNoThrowsExceptionCallback() {
			
			@Override
			public void modifyMethod() throws Exception {
				
				UnitPayBill oldPayBill = unitPayBillServices.findUnitPayBillById(payBill.getId());
				
				payBill.setHadPay(oldPayBill.getHadPay());
				payBill.setNotPay(payBill.getShouldPay().subtract(oldPayBill.getHadPay()));
				payBill.setIsVoid(oldPayBill.getIsVoid());
				
				CommonPojoUtils.initPojoForUpdate(oldPayBill, payBill);
				
				unitPayBillServices.updateUnitPayBill(payBill);
				
			}
		});
		
		return null;
	}
	
	/**
	 * 删除应收款
	 * @return
	 * @throws Exception
	 */
	public String deleteUnitPayBill() throws Exception{
		
		int billId = Integer.parseInt(request.getParameter("billId"));
		
		try{
			
			unitPayBillServices.deleteUnitPayBill(billId);
			CustomerUtils.writeResponse(response, "true");
		}catch(Exception e){
			CustomerUtils.writeResponse(response, "false");
		}
		
		return null;
	}
	
	/**
	 * 启用
	 * @return
	 * @throws Exception
	 */
	public String enabledUnitPayBill() throws Exception{
		
		int billId = Integer.parseInt(request.getParameter("billId"));
		
		try{
			
			unitPayBillServices.enabledUnitPayBill(billId);
			CustomerUtils.writeResponse(response, "true");
		}catch(Exception e){
			CustomerUtils.writeResponse(response, "false");
		}
		
		return null;
	}
	
	/**
	 * 作废
	 * @return
	 * @throws Exception
	 */
	public String disabledUnitPayBill() throws Exception{
		
		int billId = Integer.parseInt(request.getParameter("billId"));
		
		try{
			
			unitPayBillServices.disabledUnitPayBill(billId);
			CustomerUtils.writeResponse(response, "true");
		}catch(Exception e){
			CustomerUtils.writeResponse(response, "false");
		}
		
		return null;
	}
	
	//////
	private void initForModifyUnitPayBill(UnitPayBill payBill){
		
		initForAddUnitPayBill(payBill.getUnitId());
		
	}
	
	private void initForAddUnitPayBill(int unitId){
		
		unit = unitServices.findPropertyUnitById(unitId);
		
		wayId = getPayWayIdByUnit(unit);
		selPayType = PayTypeUtils.getPayTypeValueMap();
		feeTypeName = EnumTextTypeName.TEXT_FEE_TYPE.toString();
		
	}
	
	@SuppressWarnings("unused")
	private LinkedHashMap<String, String> initSelPayType(List<PayWayDetail> payWayDetailList){
		
		LinkedHashMap<String, String> ret = new LinkedHashMap<String, String>();
		
		ret.put("", CommonUtils.EMPTY);
		
		if(!CommonUtils.isCollectionEmpty(payWayDetailList)){
			
			for(PayWayDetail detail : payWayDetailList){
				
				String payType = detail.getPayType();
				String payName = detail.getPayName();
				
				if(!ret.containsKey(payType)){
					
					ret.put(payType, payName);
				}
				
			}
			
		}
		
		return ret;
	}
	
	private int getPayWayIdByUnit(PropertyUnit unit){
		
		int payWayId = 0;
		
		if(ContUnitSaleState.CONFIRM_BOOK.equals(unit.getSaleState())){
			//临定
			
			ConfirmBook confirmBook = unit.getConfirmBook();
			payWayId = confirmBook.getPayWayId();
			
			
		}else if(ContUnitSaleState.CONFIRM.equals(unit.getSaleState())){
			//认购
			
			Confirm confirm = unit.getConfirm();
			payWayId = confirm.getPayWayId();
			
		}else if(ContUnitSaleState.CONTRACT.equals(unit.getSaleState())){
			//签约
			
			Contract contract = unit.getContract();
			payWayId = contract.getPayWayId();
			
		}
		
		return payWayId;
		
	}
	
	private void initOtherMoney(List<UnitPayBill> unitPayBillList){
		
		allShouldPay = new BigDecimal(0);
		allHadPay = new BigDecimal(0);
		allNotPay = new BigDecimal(0);
		
		for(UnitPayBill bill : unitPayBillList){
			
			allShouldPay = allShouldPay.add( bill.getShouldPay() == null ? new BigDecimal(0) : bill.getShouldPay());
			allHadPay = allHadPay.add(bill.getHadPay() == null ? new BigDecimal(0) : bill.getHadPay());
			allNotPay = allNotPay.add(bill.getNotPay() == null ? new BigDecimal(0) : bill.getNotPay());
		}
		
	}
	
	////
	
	private String unitId;
	
	private PropertyUnit unit;
	
	private UnitPayBill payBill;
	
	private List<UnitPayBill> unitPayBillList;
	
	private List<PayWayDetail> payWayDetailList;
	
	private BigDecimal allShouldPay; //总的应收金额
	private BigDecimal allHadPay; //总的已收金额
	private BigDecimal allNotPay; //总的未收金额
	
	private LinkedHashMap<String, String> selPayType; //类别
	private LinkedHashMap<String, String> selFeeType; //收费项目
	
	private String payTypeName; //类别对应表project_text的type_name
	
	/**
	 * 收款内容,对应表project_text的type_name,在EnumTextTypeName中定义
	 */
	private String feeTypeName;
	
	private String selPayTypeId; //用于修改的时候设置类别的选择状态
	
	private int wayId;
	
	private boolean isSale;
	
	/**
	 * 付款方式
	 */
	private Map<String, String> selPayWay;
	
	/**
	 * 设置方式
	 */
	private Map<Integer, String> selFormula;
	
	/**
	 * 按揭比例
	 */
	private Map<Integer, String> selProportion;
	
	/**
	 * 使用公式
	 */
	private MyPayWay myPayWay;
	
	public void setMyPayWay(MyPayWay myPayWay) {
		this.myPayWay = myPayWay;
	}
	
	public MyPayWay getMyPayWay() {
		return myPayWay;
	}
	
	public void setSelProportion(Map<Integer, String> selProportion) {
		this.selProportion = selProportion;
	}
	
	public Map<Integer, String> getSelProportion() {
		return selProportion;
	}
	
	public void setSelFormula(Map<Integer, String> selFormula) {
		this.selFormula = selFormula;
	}
	
	public Map<Integer, String> getSelFormula() {
		return selFormula;
	}
	
	public void setSelPayWay(Map<String, String> selPayWay) {
		this.selPayWay = selPayWay;
	}
	
	public Map<String, String> getSelPayWay() {
		return selPayWay;
	}
	
	public void setFeeTypeName(String feeTypeName) {
		this.feeTypeName = feeTypeName;
	}
	
	public String getFeeTypeName() {
		return feeTypeName;
	}
	
	public void setPayTypeName(String payTypeName) {
		this.payTypeName = payTypeName;
	}
	
	public String getPayTypeName() {
		return payTypeName;
	}
	
	public void setSelPayTypeId(String selPayTypeId) {
		this.selPayTypeId = selPayTypeId;
	}
	
	public String getSelPayTypeId() {
		return selPayTypeId;
	}
	
	public void setWayId(int wayId) {
		this.wayId = wayId;
	}
	
	public int getWayId() {
		return wayId;
	}
	
	public void setSelFeeType(LinkedHashMap<String, String> selFeeType) {
		this.selFeeType = selFeeType;
	}
	
	public LinkedHashMap<String, String> getSelFeeType() {
		return selFeeType;
	}
	
	public void setPayBill(UnitPayBill payBill) {
		this.payBill = payBill;
	}
	
	public UnitPayBill getPayBill() {
		return payBill;
	}
	
	public void setSelPayType(LinkedHashMap<String, String> selPayType) {
		this.selPayType = selPayType;
	}
	
	public LinkedHashMap<String, String> getSelPayType() {
		return selPayType;
	}
	
	public void setUnit(PropertyUnit unit) {
		this.unit = unit;
	}
	
	public PropertyUnit getUnit() {
		return unit;
	}
	
	public BigDecimal getAllShouldPay() {
		return allShouldPay;
	}

	public void setAllShouldPay(BigDecimal allShouldPay) {
		this.allShouldPay = allShouldPay;
	}

	public BigDecimal getAllHadPay() {
		return allHadPay;
	}

	public void setAllHadPay(BigDecimal allHadPay) {
		this.allHadPay = allHadPay;
	}

	public BigDecimal getAllNotPay() {
		return allNotPay;
	}

	public void setAllNotPay(BigDecimal allNotPay) {
		this.allNotPay = allNotPay;
	}

	public void setPayWayDetailList(List<PayWayDetail> payWayDetailList) {
		this.payWayDetailList = payWayDetailList;
	}
	
	public List<PayWayDetail> getPayWayDetailList() {
		return payWayDetailList;
	}

	public String getUnitId() {
		return unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	public List<UnitPayBill> getUnitPayBillList() {
		return unitPayBillList;
	}

	public void setUnitPayBillList(List<UnitPayBill> unitPayBillList) {
		this.unitPayBillList = unitPayBillList;
	}

	public boolean getIsSale() {
		return isSale;
	}

	public void setIsSale(boolean isSale) {
		this.isSale = isSale;
	}
	
}
