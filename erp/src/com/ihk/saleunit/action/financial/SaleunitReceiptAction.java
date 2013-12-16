package com.ihk.saleunit.action.financial;

import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.pojo.UnitPayBill;
import com.ihk.property.data.pojo.UnitPayBillCond;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.property.data.services.IUnitPayBillServices;
import com.ihk.saleunit.data.pojo.SaleUnitReceipt;
import com.ihk.saleunit.data.services.ISaleUnitReceiptServices;
import com.ihk.utils.ActionMethodModifyUtils;
import com.ihk.utils.ActionTemplate;
import com.ihk.utils.CommonPojoUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;
import com.ihk.utils.common.setup.PayTypeUtils;
import com.ihk.utils.financial.FinancialUtils;
import com.ihk.utils.method.ActionAjaxMethodModifyNoThrowsExceptionCallback;

/**
 * 销售中心的收款明细
 * @author dtc
 * 2013-1-21,下午03:52:17
 */
public class SaleunitReceiptAction extends SupperAction{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	ISaleUnitReceiptServices saleUnitReceiptServices;
	@Autowired
	IPropertyUnitServices unitServices;
	@Autowired
	IUnitPayBillServices unitPayBillServices;
	
	/**
	 * 列表
	 * @return
	 * @throws Exception
	 */
	public String receiptList() throws Exception{
		
		receiptList = saleUnitReceiptServices.findReceiptListByUnitId(getUnitId());
		
		allReceiptMoney = new BigDecimal(0);
		
		if(!CommonUtils.isCollectionEmpty(receiptList)){
			
			for(SaleUnitReceipt receipt : receiptList){
				
				BigDecimal receiptMoney = receipt.getReceiptMoney();
				
				if(!CommonUtils.isBigDecimalEmpty(receiptMoney)){
					
					allReceiptMoney = allReceiptMoney.add(receiptMoney);
				}
				
			}
		}
		
		return "receiptList";
	}
	
	/**
	 * 跳到增加页面
	 * @return
	 * @throws Exception
	 */
	public String forAddReceipt() throws Exception{
		
		int billId = Integer.parseInt(request.getParameter("billId"));
		bill = unitPayBillServices.findUnitPayBillById(billId);
		
		initForReceipt(this.getUnitId(), false);
		
		return "forAddReceipt";
	}
	
	/**
	 * 增加
	 * @return
	 * @throws Exception
	 */
	public String addReceipt() throws Exception{
		
		ActionTemplate.executeAjaxMethod(true, this, new ActionAjaxMethodModifyNoThrowsExceptionCallback() {
			
			@Override
			public void modifyMethod() throws Exception {
				
				UnitPayBill bill = unitPayBillServices.findUnitPayBillById(receipt.getBillId());
				
				//设置应收的已收及未收
				bill.setHadPay(bill.getHadPay().add(receipt.getReceiptMoney()));
				bill.setNotPay(bill.getNotPay().subtract(receipt.getReceiptMoney()));
				
				bill.setModId(SessionUser.getUserId());
				bill.setModTime(new Date());
				
				unitPayBillServices.updateUnitPayBill(bill);
				
				//设置实收的收款类别及内容
				receipt.setTypeName(bill.getTypeName());
				receipt.setFeeType(bill.getFeeType());
				
				CommonPojoUtils.initPojoCommonFiled(receipt);
				
				saleUnitReceiptServices.addSaleUnitReceipt(receipt);
				
			}
		});
		
		return null;
	}
	
	/**
	 * 跳到修改页面
	 * @return
	 * @throws Exception
	 */
	public String forModifyReceipt() throws Exception{
		
		int receiptId = Integer.parseInt(request.getParameter("receiptId"));
		
		initModifyReceiptById(receiptId);
		
		return "forModifyReceipt";
	}
	
	/**
	 * 修改
	 * @return
	 * @throws Exception
	 */
	public String updateReceipt() throws Exception{
		
		return new ActionMethodModifyUtils(true) {

			@Override
			protected void modifyMethod() throws Exception {
				
				//判断"收款类别","收款内容","收款金额"有没有改变
				SaleUnitReceipt oldReceipt = saleUnitReceiptServices.findSaleUnitReceiptById(receipt.getId());
				
				String oldTypeName = oldReceipt.getTypeName();
				String oldFeeType = oldReceipt.getFeeType();
				BigDecimal oldReceiptMoney = oldReceipt.getReceiptMoney();
				
				String typeName = receipt.getTypeName();
				String feeType = receipt.getFeeType();
				BigDecimal receiptMoney = receipt.getReceiptMoney();
				
				/**
				 * 如果新的typeName或feeType改变,
				 * 1.判断bill是否包含对应的旧的typeName及feeType,包含就减少bill的已收,增加bill的未收;不包含就不用对bill进行操作
				 * 2.判断bill是否包含新的typeName及feeType,包含就增加bill的已收,减少bill的未收;不包含就不用对bill进行操作
				 * 3.修改receipt
				 */
				if(!oldTypeName.equals(receipt.getTypeName()) || !oldFeeType.equals(receipt.getFeeType())){
					
					//1.判断bill是否包含对应的旧的typeName及feeType,包含就减少bill的已收,增加bill的未收;不包含就不用对bill进行操作
					UnitPayBillCond cond = new UnitPayBillCond();
					cond.setTypeName(oldTypeName);
					cond.setFeeType(oldFeeType);
					cond.setUnitId(receipt.getUnitId() + "");
					
					List<UnitPayBill> billList = unitPayBillServices.findUnitPayBill(cond);
					if(!CommonUtils.isCollectionEmpty(billList)){
						//表示包含
						
						UnitPayBill bill = billList.get(0);
						
						bill.setHadPay(bill.getHadPay().subtract(oldReceiptMoney));
						bill.setNotPay(bill.getNotPay().add(oldReceiptMoney));
						
						bill.setModId(SessionUser.getUserId());
						bill.setModTime(new Date());
						
						unitPayBillServices.updateUnitPayBill(bill);
						
					}
					
					//2.判断bill是否包含新的typeName及feeType,包含就增加bill的已收,减少bill的未收;不包含就不用对bill进行操作
					cond = new UnitPayBillCond();
					cond.setTypeName(typeName);
					cond.setFeeType(feeType);
					cond.setUnitId(receipt.getUnitId() + "");
					
					billList = unitPayBillServices.findUnitPayBill(cond);
					if(!CommonUtils.isCollectionEmpty(billList)){
						//表示包含
						
						UnitPayBill bill = billList.get(0);
						
						bill.setHadPay(bill.getHadPay().add(receiptMoney));
						bill.setNotPay(bill.getNotPay().subtract(receiptMoney));
						
						bill.setModId(SessionUser.getUserId());
						bill.setModTime(new Date());
						
						unitPayBillServices.updateUnitPayBill(bill);
						
					}
					
					//3.修改receipt
					CommonPojoUtils.initPojoForUpdate(oldReceipt, receipt);
					saleUnitReceiptServices.updateSaleUnitReceipt(receipt);
					
				}else{
					/**
					 * 新的typeName及feeType都没有改变
					 * A:money改变,
					 * 1.判断bill是否包含对应的旧的typeName及feeType,
					 * 	包含就判断receipt金额增加还是减少:增加就增加bill已收(差额),减少bill未收(差额);减少就减少bill已收(差额),增加bill未收(差额)
					 * 	不包含就不用对bill进行操作
					 * 2.修改receipt
					 * B:money没有改变
					 * 1.只需修改receipt
					 */
					
					if(oldReceiptMoney.compareTo(receiptMoney) != 0){
						//A
						UnitPayBillCond cond = new UnitPayBillCond();
						cond.setTypeName(oldTypeName);
						cond.setFeeType(oldFeeType);
						cond.setUnitId(receipt.getUnitId() + "");
						
						List<UnitPayBill> billList = unitPayBillServices.findUnitPayBill(cond);
						//1.
						if(!CommonUtils.isCollectionEmpty(billList)){
							//表示包含
							
							UnitPayBill bill = billList.get(0);
							
							if(oldReceiptMoney.compareTo(receiptMoney) == -1){
								//表示receipt金额增加,增加bill已收(差额),减少bill未收(差额)
								BigDecimal changeMoney = receiptMoney.subtract(oldReceiptMoney);
								
								bill.setHadPay(bill.getHadPay().add(changeMoney));
								bill.setNotPay(bill.getNotPay().subtract(changeMoney));
								
							}else{
								//表示receipt金额减少,减少bill已收(差额),增加bill未收(差额)
								BigDecimal changeMoney = oldReceiptMoney.subtract(receiptMoney);
								
								bill.setHadPay(bill.getHadPay().subtract(changeMoney));
								bill.setNotPay(bill.getNotPay().add(changeMoney));
								
							}
							
							bill.setModId(SessionUser.getUserId());
							bill.setModTime(new Date());
							
							unitPayBillServices.updateUnitPayBill(bill);
							
						}
						
						//2.
						CommonPojoUtils.initPojoForUpdate(oldReceipt, receipt);
						saleUnitReceiptServices.updateSaleUnitReceipt(receipt);
						
					}else{
						//B
						//1.只需修改receipt
						CommonPojoUtils.initPojoForUpdate(oldReceipt, receipt);
						saleUnitReceiptServices.updateSaleUnitReceipt(receipt);
						
					}
					
				}
				
			}
		}.doModify(this);
	}
	
	/**
	 * 删除
	 * @return
	 * @throws Exception
	 */
	public String deleteReceipt() throws Exception{
		
		ActionTemplate.executeAjaxMethod(true, this, new ActionAjaxMethodModifyNoThrowsExceptionCallback() {
			
			@Override
			public void modifyMethod() throws Exception {
				
				//获取对应的实收
				int receiptId = Integer.parseInt(request.getParameter("receiptId"));
				receipt = saleUnitReceiptServices.findSaleUnitReceiptById(receiptId);
				
				//应收
				UnitPayBill bill = unitPayBillServices.findUnitPayBillById(receipt.getBillId());
				
				BigDecimal receiptMoney = receipt.getReceiptMoney();
				bill.setHadPay(bill.getHadPay().subtract(receiptMoney));
				bill.setNotPay(bill.getNotPay().add(receiptMoney));
				
				bill.setModId(SessionUser.getUserId());
				bill.setModTime(new Date());
				
				unitPayBillServices.updateUnitPayBill(bill);
				
				saleUnitReceiptServices.deleteSaleUnitReceipt(receiptId);
				
			}
		});
		
		return null;
	}
	
	/**
	 * 收款明细的弹出框(根据应收id)
	 * @return
	 * @throws Exception
	 */
	public String receiptListDialog() throws Exception{
		
		receiptList = saleUnitReceiptServices.findReceiptListByBillId(Integer.parseInt(request.getParameter("billId")));
		
		allReceiptMoney = new BigDecimal(0);
		
		if(!CommonUtils.isCollectionEmpty(receiptList)){
			
			for(SaleUnitReceipt receipt : receiptList){
				
				BigDecimal receiptMoney = receipt.getReceiptMoney();
				
				if(!CommonUtils.isBigDecimalEmpty(receiptMoney)){
					
					allReceiptMoney = allReceiptMoney.add(receiptMoney);
				}
				
			}
		}
		
		return "receiptListDialog";
	}
	
	/**
	 * 收款明细的弹出框(根据单元id)
	 * @return
	 * @throws Exception
	 */
	public String receiptListDialogByUnitId() throws Exception{
		
		receiptList = saleUnitReceiptServices.findReceiptListByUnitId(Integer.parseInt(request.getParameter("unitId")));
		
		allReceiptMoney = new BigDecimal(0);
		
		if(!CommonUtils.isCollectionEmpty(receiptList)){
			
			for(SaleUnitReceipt receipt : receiptList){
				
				BigDecimal receiptMoney = receipt.getReceiptMoney();
				
				if(!CommonUtils.isBigDecimalEmpty(receiptMoney)){
					
					allReceiptMoney = allReceiptMoney.add(receiptMoney);
				}
				
			}
		}
		
		return "receiptListDialogByUnitId";
	}
	
	/**
	 * 判断单元是否有实收
	 * @return
	 * @throws Exception
	 */
	public String isHaveReceiptByUnitId() throws Exception{
		
		boolean isHave = FinancialUtils.isUnitPayBillListHaveReceiptByUnitId(unitId);
		
		JSONObject json = new JSONObject();
		json.put("type", isHave);
		
		CustomerUtils.writeResponse(response, json.toString());
		
		return null;
	}
	
	////
	
	/**
	 * 跳到查看修改receipt页面的
	 * @param receiptId
	 */
	private void initModifyReceiptById(int receiptId){
		
		receipt = saleUnitReceiptServices.findSaleUnitReceiptById(receiptId);
		unit = receipt.getUnit();
		
		initForReceipt(unit.getId(), true);
	}
	
	/**
	 * 获取对应的应收款类别及内容
	 * @param unitId
	 * @param isModify
	 */
	private void initForReceipt(int unitId, boolean isModify){
		
		unit = unitServices.findPropertyUnitById(unitId);
		
		selPayType = PayTypeUtils.getPayTypeValueMap();
	}
	
	//
	
	private int unitId;
	/**
	 * 用于单元信息显示
	 */
	private PropertyUnit unit; //用于单元信息显示
	
	private List<SaleUnitReceipt> receiptList;
	
	private SaleUnitReceipt receipt;
	
	/**
	 * 收费类别(为对应单元的应收款收费类别)
	 */
	private LinkedHashMap<String, String> selPayType; //收费类别(为对应单元的应收款收费类别)
	
	/**
	 * 收费项目(为对应单元的应收款收费项目)
	 */
	private LinkedHashMap<String, String> selFeeType; //收费项目(为对应单元的应收款收费项目)
	
	/**
	 * 该单元对应的单元应收款
	 */
	private List<UnitPayBill> unitPayBillList;
	
	/**
	 * 合计金额
	 */
	private BigDecimal allReceiptMoney;
	
	/**
	 * 单元应收
	 */
	private UnitPayBill bill;
	
	public void setBill(UnitPayBill bill) {
		this.bill = bill;
	}
	
	public UnitPayBill getBill() {
		return bill;
	}
	
	public void setAllReceiptMoney(BigDecimal allReceiptMoney) {
		this.allReceiptMoney = allReceiptMoney;
	}
	
	public BigDecimal getAllReceiptMoney() {
		return allReceiptMoney;
	}
	
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

	public void setUnitPayBillList(List<UnitPayBill> unitPayBillList) {
		this.unitPayBillList = unitPayBillList;
	}
	
	public List<UnitPayBill> getUnitPayBillList() {
		return unitPayBillList;
	}
	
	public void setReceipt(SaleUnitReceipt receipt) {
		this.receipt = receipt;
	}
	
	public SaleUnitReceipt getReceipt() {
		return receipt;
	}
	
	public void setReceiptList(List<SaleUnitReceipt> receiptList) {
		this.receiptList = receiptList;
	}
	
	public List<SaleUnitReceipt> getReceiptList() {
		return receiptList;
	}

	public int getUnitId() {
		return unitId;
	}

	public void setUnitId(int unitId) {
		this.unitId = unitId;
	}

	public PropertyUnit getUnit() {
		return unit;
	}

	public void setUnit(PropertyUnit unit) {
		this.unit = unit;
	}
	
}
