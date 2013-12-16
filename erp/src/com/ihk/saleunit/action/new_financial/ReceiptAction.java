package com.ihk.saleunit.action.new_financial;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.EnumTextTypeName;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.pojo.UnitPayBill;
import com.ihk.property.data.pojo.UnitPayBillCond;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.property.data.services.IUnitPayBillServices;
import com.ihk.saleunit.data.pojo.Receipt;
import com.ihk.saleunit.data.pojo.ReceiptDetail;
import com.ihk.saleunit.data.services.IReceiptDetailServices;
import com.ihk.saleunit.data.services.IReceiptServices;
import com.ihk.utils.ActionMethodModifyUtils;
import com.ihk.utils.CommonPojoUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.MyTransationTemplate;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;
import com.ihk.utils.projecttext.ProjectTextUtils;

/**
 * 收款内容
 * @author dtc
 * 2012-8-11
 */
@SuppressWarnings("unused")
public class ReceiptAction extends SupperAction{

	private static final long serialVersionUID = 1L;
	
	private static final String RECEIPT_DETAIL = "__receiptDetail__";

	@Autowired
	IReceiptServices receiptServices;
	@Autowired
	IReceiptDetailServices receiptDetailServices;
	@Autowired 
	IUnitPayBillServices unitPayBillServices;
	@Autowired
	IPropertyUnitServices unitServices;
	
	/**
	 * 收据主单列表
	 * @return
	 * @throws Exception
	 */
	public String receiptList() throws Exception{
		
		receiptList = receiptServices.findReceiptByUnitId(getUnitId());
		
		allReceiptMoney = initAllReceiptMoney(receiptList);
		
		return "receiptList";
	}
	
	/**
	 * 跳到增加页面
	 * @return
	 * @throws Exception
	 */
	public String forAddReceipt() throws Exception{
		
		initForReceipt(getUnitId(), false);
		
		removeSuggestion();
		
		return "forAddReceipt";
	}
	
	/**
	 * 根据收款类别(中文)获取对应的收款内容
	 * @return
	 * @throws Exception
	 */
	public String getFeeTypeByTypeNameForComboBox() throws Exception{
		
		String out = "";
		
		String unitId = request.getParameter("unitId");
		String typeName = request.getParameter("typeName");
		
		if(CommonUtils.isStrEmpty(typeName)){
			
			out = ProjectTextUtils.getComboBoxContextByProjectTextList(null, false);
			
			CustomerUtils.writeResponse(response, out);
			
			return null;
		}
		
		UnitPayBillCond cond = new UnitPayBillCond();
		cond.setUnitId(unitId);
		cond.setTypeName(typeName);
		
		List<UnitPayBill> billList = unitPayBillServices.findUnitPayBill(cond);
		if(!CommonUtils.isCollectionEmpty(billList)){
			
			List<String> stringList = new ArrayList<String>();
			for(UnitPayBill bill : billList){
				
				stringList.add(bill.getFeeType());
			}
			
			out = ProjectTextUtils.getComboBoxContextByStringList(stringList);
		}else{
			
			out = ProjectTextUtils.getComboBoxContextByProjectTextList(null, false);
		}
		
		CustomerUtils.writeResponse(response, out);
		
		return null;
	}
	
	/**
	 * 增加收据主单
	 * @return
	 * @throws Exception
	 */
	public String addReceipt() throws Exception{
		
		return new ActionMethodModifyUtils() {
			
			@Override
			protected void modifyMethod() throws Exception {
				
				CommonPojoUtils.initPojoCommonFiled(receipt);
				
				if(CommonUtils.isStrEmpty(receipt.getIsKeep())){
					receipt.setIsKeep(CommonUtils.FALSE_STR);
				}
				receiptServices.addReceipt(receipt); //增加主单
				
			}
		}.doModify(this);
		
		/*try{
			new MyTransationTemplate() {
				
				@Override
				protected void doExecuteCallback() throws Exception {
					
					CommonPojoUtils.initPojoCommonFiled(receipt);
					
					Map<Integer, BigDecimal> receiptDetailMap = initReceiptDetailMapForModifyReceipt();
					
					receipt.setFeeType(getFeeTypeFromReceiptDetailMap(receiptDetailMap));
					if(CommonUtils.isStrEmpty(receipt.getIsKeep())){
						receipt.setIsKeep(CommonUtils.FALSE_STR);
					}
					receiptServices.addReceipt(receipt); //增加主单
					
					addReceiptDetailByMapAndPayMan(receiptDetailMap, receipt.getPayMan(), receipt.getId()); //增加主单收款明细
					
					updateUnitPayBillHadAndNotPayForAddReceipt(receiptDetailMap); //修改应收款的已收,未收金额
					
					setSuggestion(CommonUtils.SUCCSUGG);
					setUpMarkToClose();
					
				}
			}.execute();
			
		}catch(Exception e){
			
			setSuggestion(CommonUtils.FAILSUGG);
			
		}
		
		initForReceipt(receipt.getUnitId());
		
		return "addReceipt";*/
	}
	
	/**
	 * 跳到修改页面
	 * @return
	 * @throws Exception
	 */
	public String forModifyReceipt() throws Exception{
		
		int receiptId = Integer.parseInt(request.getParameter("receiptId"));
		
		initModifyReceiptById(receiptId);
		
		removeSuggestion();
		
		return "forModifyReceipt";
	}
	
	/**
	 * 更新收据主单
	 * @return
	 * @throws Exception
	 */
	public String updateReceipt() throws Exception{
		
		return new ActionMethodModifyUtils(true) {
			
			@Override
			protected void modifyMethod() throws Exception {
				
				
				
			}
		}.doModify(this);
		
		/*
		try{
			
			new MyTransationTemplate() {
				
				@Override
				protected void doExecuteCallback() throws Exception {
					
					Receipt oldReceipt = receiptServices.findReceiptById(receipt.getId());
					CommonPojoUtils.initPojoForUpdate(oldReceipt, receipt);
					
					receiptServices.updateReceipt(receipt);
					
					Map<Integer, BigDecimal> receiptDetailMap = initReceiptDetailMapForModifyReceipt(false); //此时id为receipt_detail的id
					
					updateReceiptDetailByMap(receiptDetailMap, receipt.getPayMan()); //修改receipt_detail
					updateUnitPayBillHadAndNotPayForUpdateReceipt(receiptDetailMap); //修改unit_pay_bill
					
					setSuggestion(CommonUtils.SUCCSUGG);
					setUpMarkToClose();
					
				}
			}.execute();
			
		}catch(Exception e){
			
			setSuggestion(CommonUtils.FAILSUGG);
		}
		
		initModifyReceiptById(receipt.getId());
		
		return "updateReceipt";
		*/
	}
	
	/**
	 * 删除收据主单
	 * @return
	 * @throws Exception
	 */
	public String deleteReceipt() throws Exception{
		
		try{
			
			new MyTransationTemplate() {
				
				@Override
				protected void doExecuteCallback() throws Exception {
					
					int receiptId = Integer.parseInt(request.getParameter("receiptId"));

					Map<Integer, BigDecimal> receiptDetailMap = new HashMap<Integer, BigDecimal>();
					
					List<ReceiptDetail> detailList = receiptDetailServices.findReceiptDetailByReceiptId(receiptId);
					for(ReceiptDetail detail : detailList){
						
						Integer billId = detail.getBillId();
						BigDecimal thisPay = detail.getPayMoney();
						
						if(receiptDetailMap.containsKey(billId)){
							
							thisPay = thisPay.add(receiptDetailMap.get(billId));
							
						}
						
						receiptDetailMap.put(billId, thisPay);
					}
					
					updateUnitPayBillHadAndNotPayForDeleteReceipt(receiptDetailMap);
					
					receiptServices.deleteReceipt(receiptId);
					CustomerUtils.writeResponse(response, "true");
					
				}
			}.execute();
			
		}catch(Exception e){
			CustomerUtils.writeResponse(response, "false");
		}
		
		return null;
	}
	
	/**
	 * 跳到查看修改receipt页面的
	 * @param receiptId
	 */
	private void initModifyReceiptById(int receiptId){
		
		receipt = receiptServices.findReceiptById(receiptId);
		unit = receipt.getUnit();
		
		initForReceipt(unit.getId(), true);
		
		/**
		List<ReceiptDetail> receiptDetailList = receiptDetailServices.findReceiptDetailByReceiptId(receipt.getId());
		if(!CommonUtils.isCollectionEmpty(receiptDetailList)){
			
			unitPayBillList = new ArrayList<UnitPayBill>();
			
			for(ReceiptDetail detail : receiptDetailList){
				
				UnitPayBill bill = unitPayBillServices.findUnitPayBillById(detail.getBillId());
				bill.setThisPay(detail.getPayMoney()); //设置本次付款
				
				unitPayBillList.add(bill);
			}
			
			initOtherMoney(unitPayBillList);
		}
		
		selIsKeep = DescUtils.getInitSelEmptyAndTrueFalse(selIsKeep, false);
		
		initTypeName();
		*/
	}
	
	/**
	 * 初始化总计收款金额
	 * @param receiptList
	 * @return
	 */
	private BigDecimal initAllReceiptMoney(List<Receipt> receiptList){
		
		BigDecimal retMoney = new BigDecimal(0);
		
		for(Receipt receipt : receiptList){
			
			BigDecimal money = receipt.getReceiptMoney();
			if(money == null){
				money = new BigDecimal(0);
			}
			
			retMoney = retMoney.add(money);
		}
		
		
		return retMoney;
	}
	
	/**
	 * 获取receipt的收费项目
	 * @param receiptDetailMap
	 * @return
	 */
	private String getFeeTypeFromReceiptDetailMap(Map<Integer, BigDecimal> receiptDetailMap){
		
		StringBuffer sb = new StringBuffer();
		
		Set<Integer> keys = receiptDetailMap.keySet();
		for(Integer key : keys){
			
			UnitPayBill bill = unitPayBillServices.findUnitPayBillById(key);
			if(bill != null){
				sb.append(bill.getFeeType()).append(",");
			}
		}
		
		String ret = sb.toString();
		ret = CommonUtils.removeLastChar(ret);
		
		return ret;
	}
	
	/**
	 * 修改应收款的已收,未收金额(增加receipt的时候)
	 * @param receiptDetailMap,key为unit_pay_bill的id,value为receipt_detail中pay_money(本次付款)
	 */
	private void updateUnitPayBillHadAndNotPayForAddReceipt(Map<Integer, BigDecimal> receiptDetailMap){
		
		UnitPayBillCond cond = null;
		
		Set<Integer> keys = receiptDetailMap.keySet();
		for(Integer key : keys){
			
			cond = new UnitPayBillCond();
			
			cond.setBillId(key);
			cond.setThisPay(receiptDetailMap.get(key));
			cond.setModId(SessionUser.getUserId());
			cond.setModTime(new Date());
			
			unitPayBillServices.updateUnitPayBillHadAndNotPayForAddReceipt(cond);
			
		}
		
	}
	
	/**
	 * 修改应收款的已收,未收金额(删除receipt的时候)
	 * @param receiptDetailMap
	 */
	private void updateUnitPayBillHadAndNotPayForDeleteReceipt(Map<Integer, BigDecimal> receiptDetailMap){
		
		UnitPayBillCond cond = null;
		
		Set<Integer> keys = receiptDetailMap.keySet();
		for(Integer key : keys){
			
			cond = new UnitPayBillCond();
			
			cond.setBillId(key);
			cond.setThisPay(receiptDetailMap.get(key));
			cond.setModId(SessionUser.getUserId());
			cond.setModTime(new Date());
			
			unitPayBillServices.updateUnitPayBillHadAndNotPayForDeleteReceipt(cond);
			
		}
		
	}
	
	/**
	 * 修改应收款的已收,未收金额(修改receipt的时候)
	 * @param receiptDetailMap,key为receipt_detail的id, value 为修改后的本次收款
	 */
	private void updateUnitPayBillHadAndNotPayForUpdateReceipt(Map<Integer, BigDecimal> receiptDetailMap){
		
		ReceiptDetail detail = null;
		
		Set<Integer> keys = receiptDetailMap.keySet();
		for(Integer key : keys){
			
			detail = receiptDetailServices.findReceiptDetailById(key);
			
			int billId = detail.getBillId();
			UnitPayBill bill = unitPayBillServices.findUnitPayBillById(billId);
			BigDecimal hadPay = bill.getHadPay();
			
			BigDecimal modifyPay = receiptDetailMap.get(key); //页面传过来的本次收款
			
			//BigDecimal 不能直接用 <或>来判断大小
			if(hadPay.compareTo(modifyPay) == -1){
				//表示 hadPay<modifyPay
				
				BigDecimal thisPay = modifyPay.subtract(hadPay);
				
				UnitPayBillCond cond = new UnitPayBillCond();
				
				cond.setBillId(billId);
				cond.setThisPay(thisPay);
				cond.setModId(SessionUser.getUserId());
				cond.setModTime(new Date());
				
				unitPayBillServices.updateUnitPayBillHadAndNotPayForAddReceipt(cond);
				
			}else if(hadPay.compareTo(modifyPay) == 1){
				// 表示 hadPay>modifyPay
				BigDecimal thisPay = hadPay.subtract(modifyPay);
				
				UnitPayBillCond cond = new UnitPayBillCond();
				
				cond.setBillId(billId);
				cond.setThisPay(thisPay);
				cond.setModId(SessionUser.getUserId());
				cond.setModTime(new Date());
				
				unitPayBillServices.updateUnitPayBillHadAndNotPayForDeleteReceipt(cond);
				
			}
			
		}
		
	}
	
	/**
	 * 
	 * 当新增receipt时,key为unit_pay_bill的id,value为receipt_detail中pay_money(本次付款)
	 * 当更新receipt时,key为receipt_detail的id,value为receipt_detail中pay_money(本次付款)
	 * @param isFilterEmpty,默认过滤
	 * @return
	 */
	private Map<Integer, BigDecimal> initReceiptDetailMapForModifyReceipt(boolean isFilterEmpty){
		
		Map<Integer, BigDecimal> receiptDetailMap = new HashMap<Integer, BigDecimal>(); 
		
		Enumeration<?> enums = request.getParameterNames();
		while(enums.hasMoreElements()){
			
			Object ele = enums.nextElement();
			String key = ele.toString();
			if(key.startsWith(RECEIPT_DETAIL)){
				
				String value = request.getParameter(key);
				
				if(CommonUtils.isStrZeroEmpty(value)){
					
					if(isFilterEmpty){
						continue;
					}else{
						value = "0";
					}
					
				}
				
				//增加receipt的时候过滤掉该条数据,但是更新receipt的时候要用到
				int billId = Integer.parseInt(key.substring(RECEIPT_DETAIL.length(), key.length()));
				receiptDetailMap.put(billId, new BigDecimal(value));
				
			}
		}
		
		return receiptDetailMap;
	}
	
	private Map<Integer, BigDecimal> initReceiptDetailMapForModifyReceipt(){
		
		return initReceiptDetailMapForModifyReceipt(true);
	}
	
	/**
	 * 新增receipt时,对receipt_detail的操作
	 * @param receiptDetailMap
	 * @param payMan
	 * @param receiptId
	 * @throws Exception
	 */
	private void addReceiptDetailByMapAndPayMan(Map<Integer, BigDecimal> receiptDetailMap, String payMan, int receiptId) throws Exception{
		
		Set<Integer> keys = receiptDetailMap.keySet();
		for(Integer key : keys){
			
			ReceiptDetail detail = new ReceiptDetail();
			
			detail.setReceiptId(receiptId);
			detail.setBillId(key);
			detail.setPayMoney(receiptDetailMap.get(key));
			detail.setPayMan(payMan);
			detail.setPayDate(new Date());
			CommonPojoUtils.initPojoCommonFiled(detail);
			
			receiptDetailServices.addReceiptDetail(detail);
		}
	}
	
	/**
	 * 修改receipt时,对receipt_detail的操作
	 * @param receiptDetailMap
	 */
	private void updateReceiptDetailByMap(Map<Integer, BigDecimal> receiptDetailMap, String payMan){
		
		Set<Integer> keys = receiptDetailMap.keySet();
		for(Integer key : keys){
			
			ReceiptDetail detail = receiptDetailServices.findReceiptDetailById(key);
			
			Date date = new Date();
			
			detail.setPayMoney(receiptDetailMap.get(key));
			detail.setPayMan(payMan);
			detail.setPayDate(date);
			detail.setModId(SessionUser.getUserId());
			detail.setModTime(date);
			
			receiptDetailServices.updateReceiptDetail(detail);
			
		}
		
	}
	
	/**
	 * 获取对应的应收款类别及内容
	 * @param unitId
	 * @param isModify
	 */
	private void initForReceipt(int unitId, boolean isModify){
		
		unit = unitServices.findPropertyUnitById(unitId);
		
		unitPayBillList = unitPayBillServices.findUnitPayBillByUnitId(unitId);
		
		if(!CommonUtils.isCollectionEmpty(unitPayBillList)){
			
			selPayType = new LinkedHashMap<String, String>();
			
			for(UnitPayBill bill : unitPayBillList){
				
				String typeName = bill.getTypeName();
				if(!selPayType.containsKey(typeName)){
					selPayType.put(typeName, typeName);
				}
			}
		}
		
		selFeeType = new LinkedHashMap<String, String>();
		selFeeType.put("", CommonUtils.EMPTY);
		
		if(isModify){
			//为修改,设定对应的收款内容
			String typeName = receipt.getTypeName();
			
			if(!CommonUtils.isCollectionEmpty(unitPayBillList)){
				
				for(UnitPayBill bill : unitPayBillList){
					
					String billTypeName = bill.getTypeName();
					if(typeName.equals(billTypeName)){
						
						String billFeeType = bill.getFeeType();
						selFeeType.put(billFeeType, billFeeType);
					}
					
				}
			}
			
		}
		
		/*
		unitPayBillList = unitPayBillServices.findUnitPayBillByUnitId(unitId);
		selIsKeep = DescUtils.getInitSelEmptyAndTrueFalse(selIsKeep, false);
		initOtherMoney(unitPayBillList);
		initTypeName();*/
		
	}
	
	private void initTypeName(){
		
		receiptAddress = EnumTextTypeName.TEXT_RECEIPT_ADDRESS.toString();
		payType = EnumTextTypeName.TEXT_PAY_TYPE.toString();
		billType = EnumTextTypeName.TEXT_BILL_TYPE.toString();
		recordedBank = EnumTextTypeName.TEXT_RECORDED_BANK.toString();
	}
	
	private void initOtherMoney(List<UnitPayBill> unitPayBillList){
		
		allShouldPay = new BigDecimal(0);
		allHadPay = new BigDecimal(0);
		allNotPay = new BigDecimal(0);
		
		for(UnitPayBill bill : unitPayBillList){
			
			allShouldPay = allShouldPay.add(bill.getShouldPay());
			allHadPay = allHadPay.add(bill.getHadPay());
			allNotPay = allNotPay.add(bill.getNotPay());
		}
		
	}
	
	////
	
	private int unitId;
	private PropertyUnit unit; //用于单元信息显示
	
	private List<Receipt> receiptList;
	private Receipt receipt;
	
	private List<UnitPayBill> unitPayBillList;
	
	private BigDecimal allShouldPay; //总的应收金额
	private BigDecimal allHadPay; //总的已收金额
	private BigDecimal allNotPay; //总的未收金额
	
	private BigDecimal allReceiptMoney; //总计收款金额
	
	private LinkedHashMap<String, String> selIsKeep; //是否记账
	
	private LinkedHashMap<String, String> selPayType; //收费类别(为对应单元的应收款收费类别)
	private LinkedHashMap<String, String> selFeeType; //收费项目(为对应单元的应收款收费项目)
	
	private String receiptAddress; //收款地点
	private String payType; //付款类型
	private String billType; //单据类别
	private String recordedBank; //入账银行
	
	public LinkedHashMap<String, String> getSelPayType() {
		return selPayType;
	}

	public void setSelPayType(LinkedHashMap<String, String> selPayType) {
		this.selPayType = selPayType;
	}

	public LinkedHashMap<String, String> getSelFeeType() {
		return selFeeType;
	}

	public void setSelFeeType(LinkedHashMap<String, String> selFeeType) {
		this.selFeeType = selFeeType;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getBillType() {
		return billType;
	}

	public void setBillType(String billType) {
		this.billType = billType;
	}

	public String getRecordedBank() {
		return recordedBank;
	}

	public void setRecordedBank(String recordedBank) {
		this.recordedBank = recordedBank;
	}

	public void setReceiptAddress(String receiptAddress) {
		this.receiptAddress = receiptAddress;
	}
	
	public String getReceiptAddress() {
		return receiptAddress;
	}
	
	public void setAllReceiptMoney(BigDecimal allReceiptMoney) {
		this.allReceiptMoney = allReceiptMoney;
	}
	
	public BigDecimal getAllReceiptMoney() {
		return allReceiptMoney;
	}
	
	public void setSelIsKeep(LinkedHashMap<String, String> selIsKeep) {
		this.selIsKeep = selIsKeep;
	}
	
	public LinkedHashMap<String, String> getSelIsKeep() {
		return selIsKeep;
	}
	
	public void setUnit(PropertyUnit unit) {
		this.unit = unit;
	}
	
	public PropertyUnit getUnit() {
		return unit;
	}
	
	public List<UnitPayBill> getUnitPayBillList() {
		return unitPayBillList;
	}

	public void setUnitPayBillList(List<UnitPayBill> unitPayBillList) {
		this.unitPayBillList = unitPayBillList;
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

	public void setUnitId(int unitId) {
		this.unitId = unitId;
	}
	
	public int getUnitId() {
		return unitId;
	}
	
	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}
	
	public Receipt getReceipt() {
		return receipt;
	}
	
	public void setReceiptList(List<Receipt> receiptList) {
		this.receiptList = receiptList;
	}
	
	public List<Receipt> getReceiptList() {
		return receiptList;
	}

}
