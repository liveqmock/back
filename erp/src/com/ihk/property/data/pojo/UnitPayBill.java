package com.ihk.property.data.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;

import com.ihk.saleunit.data.pojo.ReceiptDetail;
import com.ihk.utils.financial.FinancialUtils;
import com.ihk.utils.saleunit.MyPropertyUtils;

/**
 * UnitPayBill的实体类
 * 应收
 * @author 
 */
public class UnitPayBill implements Serializable{
	private static final long serialVersionUID = 1L;

	//以下由代码生成器生成,如果手工添加代码，务必写在本代码页面最下方
    
	private int id;
	private int unitId;
	private int wayDetailId;
	private BigDecimal shouldPay;
	private BigDecimal hadPay;
	private BigDecimal notPay;
	private String typeName;
	private String feeType;
	private int seqNum;
	private BigDecimal payPercent;
	private Date payDate;
	private String remark;
	private String isVoid;
	private String isDeleted;
	private int createdId;
	private Date createdTime;
	private int modId;
	private Date modTime;

	/**
	 * 取得Id()
	 */
	public int getId() {
		return id;
	}

	/**
	 * 设置id()
	 * @param id ()
	 */
	public void setId(int id) {
		this.id = id;
	}
    
	/**
	 * 取得UnitId(房间)
	 */
	public int getUnitId() {
		return unitId;
	}

	/**
	 * 设置unitId(房间)
	 * @param unitId (房间)
	 */
	public void setUnitId(int unitId) {
		this.unitId = unitId;
	}
    
	/**
	 * 取得WayDetailId(付款明细)
	 */
	public int getWayDetailId() {
		return wayDetailId;
	}

	/**
	 * 设置wayDetailId(付款明细)
	 * @param wayDetailId (付款明细)
	 */
	public void setWayDetailId(int wayDetailId) {
		this.wayDetailId = wayDetailId;
	}
    
	/**
	 * 取得ShouldPay(应收)
	 */
	public BigDecimal getShouldPay() {
		return shouldPay;
	}

	/**
	 * 设置shouldPay(应收)
	 * @param shouldPay (应收)
	 */
	public void setShouldPay(BigDecimal shouldPay) {
		this.shouldPay = shouldPay;
	}
    
	/**
	 * 取得HadPay(已收)
	 */
	public BigDecimal getHadPay() {
		return hadPay;
	}

	/**
	 * 设置hadPay(已收)
	 * @param hadPay (已收)
	 */
	public void setHadPay(BigDecimal hadPay) {
		this.hadPay = hadPay;
	}
    
	/**
	 * 取得NotPay(未收)
	 */
	public BigDecimal getNotPay() {
		return notPay;
	}

	/**
	 * 设置notPay(未收)
	 * @param notPay (未收)
	 */
	public void setNotPay(BigDecimal notPay) {
		this.notPay = notPay;
	}
    
	/**
	 * 取得TypeName(类别)
	 */
	public String getTypeName() {
		return typeName;
	}

	/**
	 * 设置typeName(类别)
	 * @param typeName (类别)
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
    
	/**
	 * 取得FeeType(收费项目)
	 */
	public String getFeeType() {
		return feeType;
	}

	/**
	 * 设置feeType(收费项目)
	 * @param feeType (收费项目)
	 */
	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}
    
	/**
	 * 取得SeqNum(期数)
	 */
	public int getSeqNum() {
		return seqNum;
	}

	/**
	 * 设置seqNum(期数)
	 * @param seqNum (期数)
	 */
	public void setSeqNum(int seqNum) {
		this.seqNum = seqNum;
	}
    
	/**
	 * 取得PayPercent(付款比例)
	 */
	public BigDecimal getPayPercent() {
		return payPercent;
	}

	/**
	 * 设置payPercent(付款比例)
	 * @param payPercent (付款比例)
	 */
	public void setPayPercent(BigDecimal payPercent) {
		this.payPercent = payPercent;
	}
    
	/**
	 * 取得PayDate(应收日期)
	 */
	public Date getPayDate() {
		return payDate;
	}

	/**
	 * 设置payDate(应收日期)
	 * @param payDate (应收日期)
	 */
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
    
	/**
	 * 取得Remark(备注)
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 设置remark(备注)
	 * @param remark (备注)
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
    
	/**
	 * 取得IsVoid(是否作废)
	 */
	public String getIsVoid() {
		return isVoid;
	}

	/**
	 * 设置isVoid(是否作废)
	 * @param isVoid (是否作废)
	 */
	public void setIsVoid(String isVoid) {
		this.isVoid = isVoid;
	}
    
	/**
	 * 取得IsDeleted(是否删除)
	 */
	public String getIsDeleted() {
		return isDeleted;
	}

	/**
	 * 设置isDeleted(是否删除)
	 * @param isDeleted (是否删除)
	 */
	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}
    
	/**
	 * 取得CreatedId(创建人)
	 */
	public int getCreatedId() {
		return createdId;
	}

	/**
	 * 设置createdId(创建人)
	 * @param createdId (创建人)
	 */
	public void setCreatedId(int createdId) {
		this.createdId = createdId;
	}
    
	/**
	 * 取得CreatedTime(创建时间)
	 */
	public Date getCreatedTime() {
		return createdTime;
	}

	/**
	 * 设置createdTime(创建时间)
	 * @param createdTime (创建时间)
	 */
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
    
	/**
	 * 取得ModId(修改人)
	 */
	public int getModId() {
		return modId;
	}

	/**
	 * 设置modId(修改人)
	 * @param modId (修改人)
	 */
	public void setModId(int modId) {
		this.modId = modId;
	}
    
	/**
	 * 取得ModTime(修改时间)
	 */
	public Date getModTime() {
		return modTime;
	}

	/**
	 * 设置modTime(修改时间)
	 * @param modTime (修改时间)
	 */
	public void setModTime(Date modTime) {
		this.modTime = modTime;
	}
    
	
	public UnitPayBill(){};


	/**
	 * 
	 * @param id ()
	 * @param unitId (房间)
	 * @param wayDetailId (付款明细)
	 * @param shouldPay (应收)
	 * @param hadPay (已收)
	 * @param notPay (未收)
	 * @param typeName (类别)
	 * @param feeType (收费项目)
	 * @param seqNum (期数)
	 * @param payPercent (付款比例)
	 * @param payDate (应收日期)
	 * @param remark (备注)
	 * @param isVoid (是否作废)
	 * @param isDeleted (是否删除)
	 * @param createdId (创建人)
	 * @param createdTime (创建时间)
	 * @param modId (修改人)
	 * @param modTime (修改时间)
	 */
	public UnitPayBill(    
		int id,
        		int unitId,
        		int wayDetailId,
        		BigDecimal shouldPay,
        		BigDecimal hadPay,
        		BigDecimal notPay,
        		String typeName,
        		String feeType,
        		int seqNum,
        		BigDecimal payPercent,
        		Date payDate,
        		String remark,
        		String isVoid,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime
        ) {
		super();  
		this.id = id;
		this.unitId = unitId;
		this.wayDetailId = wayDetailId;
		this.shouldPay = shouldPay;
		this.hadPay = hadPay;
		this.notPay = notPay;
		this.typeName = typeName;
		this.feeType = feeType;
		this.seqNum = seqNum;
		this.payPercent = payPercent;
		this.payDate = payDate;
		this.remark = remark;
		this.isVoid = isVoid;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
    
	/**
	 * 
	 * @param unitId (房间)
	 * @param wayDetailId (付款明细)
	 * @param shouldPay (应收)
	 * @param hadPay (已收)
	 * @param notPay (未收)
	 * @param typeName (类别)
	 * @param feeType (收费项目)
	 * @param seqNum (期数)
	 * @param payPercent (付款比例)
	 * @param payDate (应收日期)
	 * @param remark (备注)
	 * @param isVoid (是否作废)
	 * @param isDeleted (是否删除)
	 * @param createdId (创建人)
	 * @param createdTime (创建时间)
	 * @param modId (修改人)
	 * @param modTime (修改时间)
	 */
	public UnitPayBill(    
		int unitId,
        		int wayDetailId,
        		BigDecimal shouldPay,
        		BigDecimal hadPay,
        		BigDecimal notPay,
        		String typeName,
        		String feeType,
        		int seqNum,
        		BigDecimal payPercent,
        		Date payDate,
        		String remark,
        		String isVoid,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime
        ) {
		super();		
		this.unitId = unitId;
		this.wayDetailId = wayDetailId;
		this.shouldPay = shouldPay;
		this.hadPay = hadPay;
		this.notPay = notPay;
		this.typeName = typeName;
		this.feeType = feeType;
		this.seqNum = seqNum;
		this.payPercent = payPercent;
		this.payDate = payDate;
		this.remark = remark;
		this.isVoid = isVoid;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
    

	//以上由代码生成器生成
	//以下非代码生成器生成,不可覆盖,以下是手工代码
    
	
	
	
	//////

	private PayWayDetail payWayDetail;
	private PayWayDetail getPayWayDetail(){
		
		if(payWayDetail == null){
			payWayDetail = MyPropertyUtils.getPayWayDetailServices().findPayWayDetailById(this.wayDetailId);
		}
		return payWayDetail;
	}
	
	public String getPayType(){
		return getPayWayDetail().getPayType();
	}
	
	public String getPayName(){
		return getPayWayDetail().getPayName();
	}
	
	public String getDetailName(){
		return getPayWayDetail().getDetailName();
	}
	
	public Date getDayNum(){
		Calendar c  = Calendar.getInstance();
		c.setTime(this.createdTime);
		c.add(Calendar.DATE, getPayWayDetail().getDayNum());
		return c.getTime();
	}
	
	public String getMyPayPercent(){
		try{
			DecimalFormat df = new DecimalFormat("###,##0.00");
			return df.format(getPayWayDetail().getPayPercent().movePointRight(2))+"%";
		}catch (Exception e) {
			return "0";
		}
	}
	
	public String getShouldPayFormat() {
		try{
			DecimalFormat df = new DecimalFormat("###,##0.00");
			return df.format(shouldPay).toString();
		}catch (Exception e) {
			return "0";
		}
	}
	
	public String getHadPayFormat() {
		try{
			DecimalFormat df = new DecimalFormat("###,##0.00");
			return df.format(hadPay).toString();
		}catch (Exception e) {
			return "0";
		}
	}

	public String getNotPayFormat() {
		try{
			DecimalFormat df = new DecimalFormat("###,##0.00");
			return df.format(notPay).toString();
		}catch (Exception e) {
			return "0";
		}
	}
	
	private BigDecimal thisPay; //查看修改收款单据时的本次收款
	public void setThisPay(BigDecimal thisPay) {
		this.thisPay = thisPay;
	}
	public BigDecimal getThisPay() {
		return thisPay;
	}
	
	public ReceiptDetail getDetail(){//查看修改收款单据时的receipt_detail id
		
		return FinancialUtils.getReceiptDetailServices().findReceiptDetailByBillId(this.getId());
	}
	
	/**
	 * 获取最后一个对数
	 * @return
	 */
	public Checkfee getCheckfee(){
		
		Checkfee checkfee = MyPropertyUtils.getCheckfeeServices().findLastCheckfeeDateByBillId(this.getId());
		
		return checkfee == null ? new Checkfee() : checkfee;
	}
	
}
