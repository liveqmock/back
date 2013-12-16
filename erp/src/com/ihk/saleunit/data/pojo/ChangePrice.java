package com.ihk.saleunit.data.pojo;

import java.util.Date;
import java.math.BigDecimal;
import java.io.Serializable;

import com.ihk.utils.DescUtils;

/**
 * ChangePrice的实体类
 * @author 
 *
 */
public class ChangePrice implements Serializable{
	private static final long serialVersionUID = 1L;

	//以下由代码生成器生成,如果手工添加代码，务必写在本代码页面最下方
    
	private int id;
	private String confirmType;
	private int mainId;
	private String priceWay1;
	private String payType1;
	private BigDecimal discountPercent1;
	private BigDecimal buildPrice1;
	private BigDecimal insideUnitPrice1;
	private String discountDesc1;
	private BigDecimal sumMoney1;
	private String renovateDesc1;
	private BigDecimal renovatePrice1;
	private String isMerge1;
	private BigDecimal renovateMoney1;
	private String agreeNo1;
	private BigDecimal shouldDeposit1;
	private BigDecimal agreeMoney1;
	private String priceWay2;
	private String payType2;
	private BigDecimal discountPercent2;
	private BigDecimal buildPrice2;
	private BigDecimal insideUnitPrice2;
	private String discountDesc2;
	private BigDecimal sumMoney2;
	private String renovateDesc2;
	private BigDecimal renovatePrice2;
	private String isMerge2;
	private BigDecimal renovateMoney2;
	private String agreeNo2;
	private BigDecimal shouldDeposit2;
	private BigDecimal agreeMoney2;
	private String resonType;
	private BigDecimal handFee;
	private String resonDesc;
	private int applyUser;
	private Date applyDate;
	private String applyState;
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
	 * 取得ConfirmType(认购或合同)
	 */
	public String getConfirmType() {
		return confirmType;
	}

	/**
	 * 设置confirmType(认购或合同)
	 * @param confirmType (认购或合同)
	 */
	public void setConfirmType(String confirmType) {
		this.confirmType = confirmType;
	}
    
	/**
	 * 取得MainId(主单id)
	 */
	public int getMainId() {
		return mainId;
	}

	/**
	 * 设置mainId(主单id)
	 * @param mainId (主单id)
	 */
	public void setMainId(int mainId) {
		this.mainId = mainId;
	}
    
	/**
	 * 取得PriceWay1(计价方式)
	 */
	public String getPriceWay1() {
		return priceWay1;
	}

	/**
	 * 设置priceWay1(计价方式)
	 * @param priceWay1 (计价方式)
	 */
	public void setPriceWay1(String priceWay1) {
		this.priceWay1 = priceWay1;
	}
    
	/**
	 * 取得PayType1(付款方式)
	 */
	public String getPayType1() {
		return payType1;
	}

	/**
	 * 设置payType1(付款方式)
	 * @param payType1 (付款方式)
	 */
	public void setPayType1(String payType1) {
		this.payType1 = payType1;
	}
    
	/**
	 * 取得DiscountPercent1(折扣百分比)
	 */
	public BigDecimal getDiscountPercent1() {
		return discountPercent1;
	}

	/**
	 * 设置discountPercent1(折扣百分比)
	 * @param discountPercent1 (折扣百分比)
	 */
	public void setDiscountPercent1(BigDecimal discountPercent1) {
		this.discountPercent1 = discountPercent1;
	}
    
	/**
	 * 取得BuildPrice1(建筑成交单价)
	 */
	public BigDecimal getBuildPrice1() {
		return buildPrice1;
	}

	/**
	 * 设置buildPrice1(建筑成交单价)
	 * @param buildPrice1 (建筑成交单价)
	 */
	public void setBuildPrice1(BigDecimal buildPrice1) {
		this.buildPrice1 = buildPrice1;
	}
    
	/**
	 * 取得InsideUnitPrice1(套内成交单价)
	 */
	public BigDecimal getInsideUnitPrice1() {
		return insideUnitPrice1;
	}

	/**
	 * 设置insideUnitPrice1(套内成交单价)
	 * @param insideUnitPrice1 (套内成交单价)
	 */
	public void setInsideUnitPrice1(BigDecimal insideUnitPrice1) {
		this.insideUnitPrice1 = insideUnitPrice1;
	}
    
	/**
	 * 取得DiscountDesc1(折扣说明)
	 */
	public String getDiscountDesc1() {
		return discountDesc1;
	}

	/**
	 * 设置discountDesc1(折扣说明)
	 * @param discountDesc1 (折扣说明)
	 */
	public void setDiscountDesc1(String discountDesc1) {
		this.discountDesc1 = discountDesc1;
	}
    
	/**
	 * 取得SumMoney1(房间总价)
	 */
	public BigDecimal getSumMoney1() {
		return sumMoney1;
	}

	/**
	 * 设置sumMoney1(房间总价)
	 * @param sumMoney1 (房间总价)
	 */
	public void setSumMoney1(BigDecimal sumMoney1) {
		this.sumMoney1 = sumMoney1;
	}
    
	/**
	 * 取得RenovateDesc1(装修标准)
	 */
	public String getRenovateDesc1() {
		return renovateDesc1;
	}

	/**
	 * 设置renovateDesc1(装修标准)
	 * @param renovateDesc1 (装修标准)
	 */
	public void setRenovateDesc1(String renovateDesc1) {
		this.renovateDesc1 = renovateDesc1;
	}
    
	/**
	 * 取得RenovatePrice1(装修单价)
	 */
	public BigDecimal getRenovatePrice1() {
		return renovatePrice1;
	}

	/**
	 * 设置renovatePrice1(装修单价)
	 * @param renovatePrice1 (装修单价)
	 */
	public void setRenovatePrice1(BigDecimal renovatePrice1) {
		this.renovatePrice1 = renovatePrice1;
	}
    
	/**
	 * 取得IsMerge1(是否并入合同)
	 */
	public String getIsMerge1() {
		return isMerge1;
	}

	/**
	 * 设置isMerge1(是否并入合同)
	 * @param isMerge1 (是否并入合同)
	 */
	public void setIsMerge1(String isMerge1) {
		this.isMerge1 = isMerge1;
	}
    
	/**
	 * 取得RenovateMoney1(装修总价)
	 */
	public BigDecimal getRenovateMoney1() {
		return renovateMoney1;
	}

	/**
	 * 设置renovateMoney1(装修总价)
	 * @param renovateMoney1 (装修总价)
	 */
	public void setRenovateMoney1(BigDecimal renovateMoney1) {
		this.renovateMoney1 = renovateMoney1;
	}
    
	/**
	 * 取得AgreeNo1(协议编号)
	 */
	public String getAgreeNo1() {
		return agreeNo1;
	}

	/**
	 * 设置agreeNo1(协议编号)
	 * @param agreeNo1 (协议编号)
	 */
	public void setAgreeNo1(String agreeNo1) {
		this.agreeNo1 = agreeNo1;
	}
    
	/**
	 * 取得ShouldDeposit1(应收定金)
	 */
	public BigDecimal getShouldDeposit1() {
		return shouldDeposit1;
	}

	/**
	 * 设置shouldDeposit1(应收定金)
	 * @param shouldDeposit1 (应收定金)
	 */
	public void setShouldDeposit1(BigDecimal shouldDeposit1) {
		this.shouldDeposit1 = shouldDeposit1;
	}
    
	/**
	 * 取得AgreeMoney1(协议总价)
	 */
	public BigDecimal getAgreeMoney1() {
		return agreeMoney1;
	}

	/**
	 * 设置agreeMoney1(协议总价)
	 * @param agreeMoney1 (协议总价)
	 */
	public void setAgreeMoney1(BigDecimal agreeMoney1) {
		this.agreeMoney1 = agreeMoney1;
	}
    
	/**
	 * 取得PriceWay2(计价方式)
	 */
	public String getPriceWay2() {
		return priceWay2;
	}

	/**
	 * 设置priceWay2(计价方式)
	 * @param priceWay2 (计价方式)
	 */
	public void setPriceWay2(String priceWay2) {
		this.priceWay2 = priceWay2;
	}
    
	/**
	 * 取得PayType2(付款方式)
	 */
	public String getPayType2() {
		return payType2;
	}

	/**
	 * 设置payType2(付款方式)
	 * @param payType2 (付款方式)
	 */
	public void setPayType2(String payType2) {
		this.payType2 = payType2;
	}
    
	/**
	 * 取得DiscountPercent2(折扣百分比)
	 */
	public BigDecimal getDiscountPercent2() {
		return discountPercent2;
	}

	/**
	 * 设置discountPercent2(折扣百分比)
	 * @param discountPercent2 (折扣百分比)
	 */
	public void setDiscountPercent2(BigDecimal discountPercent2) {
		this.discountPercent2 = discountPercent2;
	}
    
	/**
	 * 取得BuildPrice2(建筑成交单价)
	 */
	public BigDecimal getBuildPrice2() {
		return buildPrice2;
	}

	/**
	 * 设置buildPrice2(建筑成交单价)
	 * @param buildPrice2 (建筑成交单价)
	 */
	public void setBuildPrice2(BigDecimal buildPrice2) {
		this.buildPrice2 = buildPrice2;
	}
    
	/**
	 * 取得InsideUnitPrice2(套内成交单价)
	 */
	public BigDecimal getInsideUnitPrice2() {
		return insideUnitPrice2;
	}

	/**
	 * 设置insideUnitPrice2(套内成交单价)
	 * @param insideUnitPrice2 (套内成交单价)
	 */
	public void setInsideUnitPrice2(BigDecimal insideUnitPrice2) {
		this.insideUnitPrice2 = insideUnitPrice2;
	}
    
	/**
	 * 取得DiscountDesc2(折扣说明)
	 */
	public String getDiscountDesc2() {
		return discountDesc2;
	}

	/**
	 * 设置discountDesc2(折扣说明)
	 * @param discountDesc2 (折扣说明)
	 */
	public void setDiscountDesc2(String discountDesc2) {
		this.discountDesc2 = discountDesc2;
	}
    
	/**
	 * 取得SumMoney2(房间总价)
	 */
	public BigDecimal getSumMoney2() {
		return sumMoney2;
	}

	/**
	 * 设置sumMoney2(房间总价)
	 * @param sumMoney2 (房间总价)
	 */
	public void setSumMoney2(BigDecimal sumMoney2) {
		this.sumMoney2 = sumMoney2;
	}
    
	/**
	 * 取得RenovateDesc2(装修标准)
	 */
	public String getRenovateDesc2() {
		return renovateDesc2;
	}

	/**
	 * 设置renovateDesc2(装修标准)
	 * @param renovateDesc2 (装修标准)
	 */
	public void setRenovateDesc2(String renovateDesc2) {
		this.renovateDesc2 = renovateDesc2;
	}
    
	/**
	 * 取得RenovatePrice2(装修单价)
	 */
	public BigDecimal getRenovatePrice2() {
		return renovatePrice2;
	}

	/**
	 * 设置renovatePrice2(装修单价)
	 * @param renovatePrice2 (装修单价)
	 */
	public void setRenovatePrice2(BigDecimal renovatePrice2) {
		this.renovatePrice2 = renovatePrice2;
	}
    
	/**
	 * 取得IsMerge2(是否并入合同)
	 */
	public String getIsMerge2() {
		return isMerge2;
	}

	/**
	 * 设置isMerge2(是否并入合同)
	 * @param isMerge2 (是否并入合同)
	 */
	public void setIsMerge2(String isMerge2) {
		this.isMerge2 = isMerge2;
	}
    
	/**
	 * 取得RenovateMoney2(装修总价)
	 */
	public BigDecimal getRenovateMoney2() {
		return renovateMoney2;
	}

	/**
	 * 设置renovateMoney2(装修总价)
	 * @param renovateMoney2 (装修总价)
	 */
	public void setRenovateMoney2(BigDecimal renovateMoney2) {
		this.renovateMoney2 = renovateMoney2;
	}
    
	/**
	 * 取得AgreeNo2(协议编号)
	 */
	public String getAgreeNo2() {
		return agreeNo2;
	}

	/**
	 * 设置agreeNo2(协议编号)
	 * @param agreeNo2 (协议编号)
	 */
	public void setAgreeNo2(String agreeNo2) {
		this.agreeNo2 = agreeNo2;
	}
    
	/**
	 * 取得ShouldDeposit2(应收定金)
	 */
	public BigDecimal getShouldDeposit2() {
		return shouldDeposit2;
	}

	/**
	 * 设置shouldDeposit2(应收定金)
	 * @param shouldDeposit2 (应收定金)
	 */
	public void setShouldDeposit2(BigDecimal shouldDeposit2) {
		this.shouldDeposit2 = shouldDeposit2;
	}
    
	/**
	 * 取得AgreeMoney2(协议总价)
	 */
	public BigDecimal getAgreeMoney2() {
		return agreeMoney2;
	}

	/**
	 * 设置agreeMoney2(协议总价)
	 * @param agreeMoney2 (协议总价)
	 */
	public void setAgreeMoney2(BigDecimal agreeMoney2) {
		this.agreeMoney2 = agreeMoney2;
	}
    
	/**
	 * 取得ResonType(变更原因)
	 */
	public String getResonType() {
		return resonType;
	}

	/**
	 * 设置resonType(变更原因)
	 * @param resonType (变更原因)
	 */
	public void setResonType(String resonType) {
		this.resonType = resonType;
	}
    
	/**
	 * 取得HandFee(手续费)
	 */
	public BigDecimal getHandFee() {
		return handFee;
	}

	/**
	 * 设置handFee(手续费)
	 * @param handFee (手续费)
	 */
	public void setHandFee(BigDecimal handFee) {
		this.handFee = handFee;
	}
    
	/**
	 * 取得ResonDesc(原因说明)
	 */
	public String getResonDesc() {
		return resonDesc;
	}

	/**
	 * 设置resonDesc(原因说明)
	 * @param resonDesc (原因说明)
	 */
	public void setResonDesc(String resonDesc) {
		this.resonDesc = resonDesc;
	}
    
	/**
	 * 取得ApplyUser(申请人id)
	 */
	public int getApplyUser() {
		return applyUser;
	}

	/**
	 * 设置applyUser(申请人id)
	 * @param applyUser (申请人id)
	 */
	public void setApplyUser(int applyUser) {
		this.applyUser = applyUser;
	}
    
	/**
	 * 取得ApplyDate(申请日期)
	 */
	public Date getApplyDate() {
		return applyDate;
	}

	/**
	 * 设置applyDate(申请日期)
	 * @param applyDate (申请日期)
	 */
	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}
    
	/**
	 * 取得ApplyState(申请状态)
	 */
	public String getApplyState() {
		return applyState;
	}

	/**
	 * 设置applyState(申请状态)
	 * @param applyState (申请状态)
	 */
	public void setApplyState(String applyState) {
		this.applyState = applyState;
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
    
	
	public ChangePrice(){};


	/**
	 * 
	 * @param id ()
	 * @param confirmType (认购或合同)
	 * @param mainId (主单id)
	 * @param priceWay1 (计价方式)
	 * @param payType1 (付款方式)
	 * @param discountPercent1 (折扣百分比)
	 * @param buildPrice1 (建筑成交单价)
	 * @param insideUnitPrice1 (套内成交单价)
	 * @param discountDesc1 (折扣说明)
	 * @param sumMoney1 (房间总价)
	 * @param renovateDesc1 (装修标准)
	 * @param renovatePrice1 (装修单价)
	 * @param isMerge1 (是否并入合同)
	 * @param renovateMoney1 (装修总价)
	 * @param agreeNo1 (协议编号)
	 * @param shouldDeposit1 (应收定金)
	 * @param agreeMoney1 (协议总价)
	 * @param priceWay2 (计价方式)
	 * @param payType2 (付款方式)
	 * @param discountPercent2 (折扣百分比)
	 * @param buildPrice2 (建筑成交单价)
	 * @param insideUnitPrice2 (套内成交单价)
	 * @param discountDesc2 (折扣说明)
	 * @param sumMoney2 (房间总价)
	 * @param renovateDesc2 (装修标准)
	 * @param renovatePrice2 (装修单价)
	 * @param isMerge2 (是否并入合同)
	 * @param renovateMoney2 (装修总价)
	 * @param agreeNo2 (协议编号)
	 * @param shouldDeposit2 (应收定金)
	 * @param agreeMoney2 (协议总价)
	 * @param resonType (变更原因)
	 * @param handFee (手续费)
	 * @param resonDesc (原因说明)
	 * @param applyUser (申请人id)
	 * @param applyDate (申请日期)
	 * @param applyState (申请状态)
	 * @param isDeleted (是否删除)
	 * @param createdId (创建人)
	 * @param createdTime (创建时间)
	 * @param modId (修改人)
	 * @param modTime (修改时间)
	 */
	public ChangePrice(    
		int id,
        		String confirmType,
        		int mainId,
        		String priceWay1,
        		String payType1,
        		BigDecimal discountPercent1,
        		BigDecimal buildPrice1,
        		BigDecimal insideUnitPrice1,
        		String discountDesc1,
        		BigDecimal sumMoney1,
        		String renovateDesc1,
        		BigDecimal renovatePrice1,
        		String isMerge1,
        		BigDecimal renovateMoney1,
        		String agreeNo1,
        		BigDecimal shouldDeposit1,
        		BigDecimal agreeMoney1,
        		String priceWay2,
        		String payType2,
        		BigDecimal discountPercent2,
        		BigDecimal buildPrice2,
        		BigDecimal insideUnitPrice2,
        		String discountDesc2,
        		BigDecimal sumMoney2,
        		String renovateDesc2,
        		BigDecimal renovatePrice2,
        		String isMerge2,
        		BigDecimal renovateMoney2,
        		String agreeNo2,
        		BigDecimal shouldDeposit2,
        		BigDecimal agreeMoney2,
        		String resonType,
        		BigDecimal handFee,
        		String resonDesc,
        		int applyUser,
        		Date applyDate,
        		String applyState,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime
        ) {
		super();  
		this.id = id;
		this.confirmType = confirmType;
		this.mainId = mainId;
		this.priceWay1 = priceWay1;
		this.payType1 = payType1;
		this.discountPercent1 = discountPercent1;
		this.buildPrice1 = buildPrice1;
		this.insideUnitPrice1 = insideUnitPrice1;
		this.discountDesc1 = discountDesc1;
		this.sumMoney1 = sumMoney1;
		this.renovateDesc1 = renovateDesc1;
		this.renovatePrice1 = renovatePrice1;
		this.isMerge1 = isMerge1;
		this.renovateMoney1 = renovateMoney1;
		this.agreeNo1 = agreeNo1;
		this.shouldDeposit1 = shouldDeposit1;
		this.agreeMoney1 = agreeMoney1;
		this.priceWay2 = priceWay2;
		this.payType2 = payType2;
		this.discountPercent2 = discountPercent2;
		this.buildPrice2 = buildPrice2;
		this.insideUnitPrice2 = insideUnitPrice2;
		this.discountDesc2 = discountDesc2;
		this.sumMoney2 = sumMoney2;
		this.renovateDesc2 = renovateDesc2;
		this.renovatePrice2 = renovatePrice2;
		this.isMerge2 = isMerge2;
		this.renovateMoney2 = renovateMoney2;
		this.agreeNo2 = agreeNo2;
		this.shouldDeposit2 = shouldDeposit2;
		this.agreeMoney2 = agreeMoney2;
		this.resonType = resonType;
		this.handFee = handFee;
		this.resonDesc = resonDesc;
		this.applyUser = applyUser;
		this.applyDate = applyDate;
		this.applyState = applyState;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
    
	/**
	 * 
	 * @param confirmType (认购或合同)
	 * @param mainId (主单id)
	 * @param priceWay1 (计价方式)
	 * @param payType1 (付款方式)
	 * @param discountPercent1 (折扣百分比)
	 * @param buildPrice1 (建筑成交单价)
	 * @param insideUnitPrice1 (套内成交单价)
	 * @param discountDesc1 (折扣说明)
	 * @param sumMoney1 (房间总价)
	 * @param renovateDesc1 (装修标准)
	 * @param renovatePrice1 (装修单价)
	 * @param isMerge1 (是否并入合同)
	 * @param renovateMoney1 (装修总价)
	 * @param agreeNo1 (协议编号)
	 * @param shouldDeposit1 (应收定金)
	 * @param agreeMoney1 (协议总价)
	 * @param priceWay2 (计价方式)
	 * @param payType2 (付款方式)
	 * @param discountPercent2 (折扣百分比)
	 * @param buildPrice2 (建筑成交单价)
	 * @param insideUnitPrice2 (套内成交单价)
	 * @param discountDesc2 (折扣说明)
	 * @param sumMoney2 (房间总价)
	 * @param renovateDesc2 (装修标准)
	 * @param renovatePrice2 (装修单价)
	 * @param isMerge2 (是否并入合同)
	 * @param renovateMoney2 (装修总价)
	 * @param agreeNo2 (协议编号)
	 * @param shouldDeposit2 (应收定金)
	 * @param agreeMoney2 (协议总价)
	 * @param resonType (变更原因)
	 * @param handFee (手续费)
	 * @param resonDesc (原因说明)
	 * @param applyUser (申请人id)
	 * @param applyDate (申请日期)
	 * @param applyState (申请状态)
	 * @param isDeleted (是否删除)
	 * @param createdId (创建人)
	 * @param createdTime (创建时间)
	 * @param modId (修改人)
	 * @param modTime (修改时间)
	 */
	public ChangePrice(    
		String confirmType,
        		int mainId,
        		String priceWay1,
        		String payType1,
        		BigDecimal discountPercent1,
        		BigDecimal buildPrice1,
        		BigDecimal insideUnitPrice1,
        		String discountDesc1,
        		BigDecimal sumMoney1,
        		String renovateDesc1,
        		BigDecimal renovatePrice1,
        		String isMerge1,
        		BigDecimal renovateMoney1,
        		String agreeNo1,
        		BigDecimal shouldDeposit1,
        		BigDecimal agreeMoney1,
        		String priceWay2,
        		String payType2,
        		BigDecimal discountPercent2,
        		BigDecimal buildPrice2,
        		BigDecimal insideUnitPrice2,
        		String discountDesc2,
        		BigDecimal sumMoney2,
        		String renovateDesc2,
        		BigDecimal renovatePrice2,
        		String isMerge2,
        		BigDecimal renovateMoney2,
        		String agreeNo2,
        		BigDecimal shouldDeposit2,
        		BigDecimal agreeMoney2,
        		String resonType,
        		BigDecimal handFee,
        		String resonDesc,
        		int applyUser,
        		Date applyDate,
        		String applyState,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime
        ) {
		super();		
		this.confirmType = confirmType;
		this.mainId = mainId;
		this.priceWay1 = priceWay1;
		this.payType1 = payType1;
		this.discountPercent1 = discountPercent1;
		this.buildPrice1 = buildPrice1;
		this.insideUnitPrice1 = insideUnitPrice1;
		this.discountDesc1 = discountDesc1;
		this.sumMoney1 = sumMoney1;
		this.renovateDesc1 = renovateDesc1;
		this.renovatePrice1 = renovatePrice1;
		this.isMerge1 = isMerge1;
		this.renovateMoney1 = renovateMoney1;
		this.agreeNo1 = agreeNo1;
		this.shouldDeposit1 = shouldDeposit1;
		this.agreeMoney1 = agreeMoney1;
		this.priceWay2 = priceWay2;
		this.payType2 = payType2;
		this.discountPercent2 = discountPercent2;
		this.buildPrice2 = buildPrice2;
		this.insideUnitPrice2 = insideUnitPrice2;
		this.discountDesc2 = discountDesc2;
		this.sumMoney2 = sumMoney2;
		this.renovateDesc2 = renovateDesc2;
		this.renovatePrice2 = renovatePrice2;
		this.isMerge2 = isMerge2;
		this.renovateMoney2 = renovateMoney2;
		this.agreeNo2 = agreeNo2;
		this.shouldDeposit2 = shouldDeposit2;
		this.agreeMoney2 = agreeMoney2;
		this.resonType = resonType;
		this.handFee = handFee;
		this.resonDesc = resonDesc;
		this.applyUser = applyUser;
		this.applyDate = applyDate;
		this.applyState = applyState;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
    

	//以上由代码生成器生成
	//以下非代码生成器生成,不可覆盖,以下是手工代码
    
	

	public String getDescApplyState(){
		if(applyState == null || applyState .equals(""))return "";
		String rt;
		switch (Integer.parseInt(applyState)) {
		case 1:
			rt = "待审批";
			break;
		case 2:
			rt =  "审批";
			break;
		default:
			rt =  "";
			break;
		}
		return rt;
	}
	public String getDescApplyUser(){
		if(this.applyUser == 0)return "";
		return DescUtils.getUserRealName(applyUser);
	}
}
