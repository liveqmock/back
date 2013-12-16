package com.ihk.saleunit.data.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.ihk.constanttype.ContConfirmType;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.SupperConfirm;
import com.ihk.utils.contract.customer.ContractCustomerUtils;
import com.ihk.utils.saleunit.MyPropertyUtils;
import com.ihk.utils.saleunit.PayWayUtils;
import com.ihk.utils.saleunitnew.DiscountManagerUtils;
import com.ihk.utils.useraccount.UserAccountUtils;

/**
 * Confirm的实体类
 * @author 
 *
 */
public class Confirm implements Serializable ,SupperConfirm{
	private static final long serialVersionUID = 1L;

	//以下由代码生成器生成,如果手工添加代码，务必写在本代码页面最下方
    
	private int id;
    private int buildId;
	private int customerId;
	private String phone;
	private int unitId;
	private String priceWay;
	private int payWayId;
	private BigDecimal discountPercent;
	private BigDecimal buildPrice;
	private BigDecimal insideUnitPrice;
	private String discountDesc;
	private BigDecimal sumMoney;
	private String renovateDesc;
	private BigDecimal renovatePrice;
	private String isMerge;
	
	private String isSecondConfirm;
	private String isSecondLinkage;
	private String isRelation;
	
	private BigDecimal renovateMoney;
	private String agreeNo;
	private BigDecimal shouldDeposit;
	private BigDecimal agreeMoney;
	private Date signDate;
	private Date workDate;
	private Date endDate;
	private String auxiliaryProduct;
	private String recommendMan;
	private String salesId;
	private Date deliveryDate;
	private int refUnitId;
	private int contractId;
	
	private int companyProjectId;
	private int propertyProjectId;
	
	private BigDecimal shouldAmount;
	private BigDecimal paymentAmount;
	
	private String remark;
	private String isDeleted;
	private int createdId;
	private Date createdTime;
	private int modId;
	private Date modTime;

    private BigDecimal buildArea;
	
    private String payWay;
    

	public String getPayWay() {
		payWay=getPayTypeStr();
		return payWay;
	}

	public void setPayWay(String payWay) {
		this.payWay = payWay;
	}

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
     * 设置楼栋id
     * @return
     */
    public int getBuildId() {
        return buildId;
    }

    public void setBuildId(int buildId) {
        this.buildId = buildId;
    }

    /**
     * 获取楼栋名称
     * @return
     */
    public String getDescBuildId(){
        if(this.buildId == 0)return null;
        try {
            return DescUtils.getBuildById(this.buildId).getBuildName();
        } catch (Exception e) {
            return null;
        }
    }

    /**
	 * 取得CustomerId(客户id)
	 */
	public int getCustomerId() {
		return customerId;
	}

	/**
	 * 设置customerId(客户id)
	 * @param customerId (客户id)
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
    
	/**
	 * 取得Phone(联系电话)
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * 设置phone(联系电话)
	 * @param phone (联系电话)
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
    
	/**
	 * 取得UnitId(房间id)
	 */
	public int getUnitId() {
		return unitId;
	}

	/**
	 * 设置unitId(房间id)
	 * @param unitId (房间id)
	 */
	public void setUnitId(int unitId) {
		this.unitId = unitId;
	}
    
	/**
	 * 取得PriceWay(计价方式)
	 */
	public String getPriceWay() {
		return priceWay;
	}

	/**
	 * 设置priceWay(计价方式)
	 * @param priceWay (计价方式)
	 */
	public void setPriceWay(String priceWay) {
		this.priceWay = priceWay;
	}
    
	/**
	 * 取得PayWayId(付款方式id)
	 */
	public int getPayWayId() {
		return payWayId;
	}

	/**
	 * 设置payWayId(付款方式id)
	 * @param payWayId (付款方式id)
	 */
	public void setPayWayId(int payWayId) {
		this.payWayId = payWayId;
	}
    
	/**
	 * 取得DiscountPercent(折扣百分比)
	 */
	public BigDecimal getDiscountPercent() {
		return discountPercent;
	}

	/**
	 * 设置discountPercent(折扣百分比)
	 * @param discountPercent (折扣百分比)
	 */
	public void setDiscountPercent(BigDecimal discountPercent) {
		this.discountPercent = discountPercent;
	}
    
	/**
	 * 取得BuildPrice(建筑成交单价)
	 */
	public BigDecimal getBuildPrice() {
		return buildPrice;
	}

	/**
	 * 设置buildPrice(建筑成交单价)
	 * @param buildPrice (建筑成交单价)
	 */
	public void setBuildPrice(BigDecimal buildPrice) {
		this.buildPrice = buildPrice;
	}
    
	/**
	 * 取得InsideUnitPrice(套内成交单价)
	 */
	public BigDecimal getInsideUnitPrice() {
		return insideUnitPrice;
	}

	/**
	 * 设置insideUnitPrice(套内成交单价)
	 * @param insideUnitPrice (套内成交单价)
	 */
	public void setInsideUnitPrice(BigDecimal insideUnitPrice) {
		this.insideUnitPrice = insideUnitPrice;
	}
    
	/**
	 * 取得DiscountDesc(折扣说明)
	 */
	public String getDiscountDesc() {
		return discountDesc;
	}

	/**
	 * 设置discountDesc(折扣说明)
	 * @param discountDesc (折扣说明)
	 */
	public void setDiscountDesc(String discountDesc) {
		this.discountDesc = discountDesc;
	}
    
	/**
	 * 取得SumMoney(房间总价)
	 */
	public BigDecimal getSumMoney() {
		return sumMoney;
	}

	/**
	 * 设置sumMoney(房间总价)
	 * @param sumMoney (房间总价)
	 */
	public void setSumMoney(BigDecimal sumMoney) {
		this.sumMoney = sumMoney;
	}
    
	/**
	 * 取得RenovateDesc(装修标准)
	 */
	public String getRenovateDesc() {
		return renovateDesc;
	}

	/**
	 * 设置renovateDesc(装修标准)
	 * @param renovateDesc (装修标准)
	 */
	public void setRenovateDesc(String renovateDesc) {
		this.renovateDesc = renovateDesc;
	}
    
	/**
	 * 取得RenovatePrice(装修单价)
	 */
	public BigDecimal getRenovatePrice() {
		return renovatePrice;
	}

	/**
	 * 设置renovatePrice(装修单价)
	 * @param renovatePrice (装修单价)
	 */
	public void setRenovatePrice(BigDecimal renovatePrice) {
		this.renovatePrice = renovatePrice;
	}
    
	/**
	 * 取得IsMerge(是否并入合同)
	 */
	public String getIsMerge() {
		return isMerge;
	}

	/**
	 * 设置isMerge(是否并入合同)
	 * @param isMerge (是否并入合同)
	 */
	public void setIsMerge(String isMerge) {
		this.isMerge = isMerge;
	}
	
	/**
	 * 是否二手成交
	 * @return
	 */
	public String getIsSecondConfirm() {
		return isSecondConfirm;
	}

	public void setIsSecondConfirm(String isSecondConfirm) {
		this.isSecondConfirm = isSecondConfirm;
	}

	/**
	 * 是否一二手联动
	 * @return
	 */
	public String getIsSecondLinkage() {
		return isSecondLinkage;
	}

	public void setIsSecondLinkage(String isSecondLinkage) {
		this.isSecondLinkage = isSecondLinkage;
	}

	/**
	 * 是否关系户
	 * @return
	 */
	public String getIsRelation() {
		return isRelation;
	}

	public void setIsRelation(String isRelation) {
		this.isRelation = isRelation;
	}
    
	/**
	 * 取得RenovateMoney(装修总价)
	 */
	public BigDecimal getRenovateMoney() {
		return renovateMoney;
	}

	/**
	 * 设置renovateMoney(装修总价)
	 * @param renovateMoney (装修总价)
	 */
	public void setRenovateMoney(BigDecimal renovateMoney) {
		this.renovateMoney = renovateMoney;
	}
    
	/**
	 * 取得AgreeNo(协议编号)
	 */
	public String getAgreeNo() {
		return agreeNo;
	}

	/**
	 * 设置agreeNo(协议编号)
	 * @param agreeNo (协议编号)
	 */
	public void setAgreeNo(String agreeNo) {
		this.agreeNo = agreeNo;
	}
    
	/**
	 * 取得ShouldDeposit(应收定金)
	 */
	public BigDecimal getShouldDeposit() {
		return shouldDeposit;
	}

	/**
	 * 设置shouldDeposit(应收定金)
	 * @param shouldDeposit (应收定金)
	 */
	public void setShouldDeposit(BigDecimal shouldDeposit) {
		this.shouldDeposit = shouldDeposit;
	}
    
	/**
	 * 取得AgreeMoney(协议总价)
	 */
	public BigDecimal getAgreeMoney() {
		return agreeMoney;
	}

	/**
	 * 设置agreeMoney(协议总价)
	 * @param agreeMoney (协议总价)
	 */
	public void setAgreeMoney(BigDecimal agreeMoney) {
		this.agreeMoney = agreeMoney;
	}
    
	/**
	 * 取得SignDate(签署日期)
	 */
	public Date getSignDate() {
		return signDate == null ? getCreatedTime() : signDate;
	}

	/**
	 * 设置signDate(签署日期)
	 * @param signDate (签署日期)
	 */
	public void setSignDate(Date signDate) {
		this.signDate = signDate;
	}
    
	/**
	 * 取得WorkDate(业务归属日期)
	 */
	public Date getWorkDate() {
		return workDate;
	}

	/**
	 * 设置workDate(业务归属日期)
	 * @param workDate (业务归属日期)
	 */
	public void setWorkDate(Date workDate) {
		this.workDate = workDate;
	}
    
	/**
	 * 取得EndDate(失效日期)
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * 设置endDate(失效日期)
	 * @param endDate (失效日期)
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	/**
	 * 附属产品
	 * @return
	 */
	public String getAuxiliaryProduct() {
		return auxiliaryProduct;
	}
	
	/**
	 * 附属产品
	 * @param auxiliaryProduct
	 */
	public void setAuxiliaryProduct(String auxiliaryProduct) {
		this.auxiliaryProduct = auxiliaryProduct;
	}
    
	/**
	 * 取得RecommendMan(推荐人)
	 */
	public String getRecommendMan() {
		return recommendMan;
	}

	/**
	 * 设置recommendMan(推荐人)
	 * @param recommendMan (推荐人)
	 */
	public void setRecommendMan(String recommendMan) {
		this.recommendMan = recommendMan;
	}
    
	/**
	 * 取得SalesId(业务员(id1,id2))
	 */
	public String getSalesId() {
		return salesId;
	}

	/**
	 * 设置salesId(业务员(id1,id2))
	 * @param salesId (业务员(id1,id2))
	 */
	public void setSalesId(String salesId) {
		this.salesId = salesId;
	}
    
	/**
	 * 取得DeliveryDate(认购约定交楼日期)
	 */
	public Date getDeliveryDate() {
		return deliveryDate;
	}

	/**
	 * 设置deliveryDate(认购约定交楼日期)
	 * @param deliveryDate (认购约定交楼日期)
	 */
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
    
	/**
	 * 取得RefUnitId(关联房间id)
	 */
	public int getRefUnitId() {
		return refUnitId;
	}

	/**
	 * 设置refUnitId(关联房间id)
	 * @param refUnitId (关联房间id)
	 */
	public void setRefUnitId(int refUnitId) {
		this.refUnitId = refUnitId;
	}
    
	/**
	 * 取得ContractId(转合同id)
	 */
	public int getContractId() {
		return contractId;
	}

	/**
	 * 设置contractId(转合同id)
	 * @param contractId (转合同id)
	 */
	public void setContractId(int contractId) {
		this.contractId = contractId;
	}
    
	/**
	 * 备注
	 * @return
	 */
	public String getRemark() {
		return remark;
	}
	
	/**
	 * 备注
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public int getCompanyProjectId() {
		return companyProjectId;
	}

	public void setCompanyProjectId(int companyProjectId) {
		this.companyProjectId = companyProjectId;
	}
	
	public int getPropertyProjectId() {
		return propertyProjectId;
	}
	
	public void setPropertyProjectId(int propertyProjectId) {
		this.propertyProjectId = propertyProjectId;
	}
	
	public BigDecimal getShouldAmount() {
		return shouldAmount;
	}

	public void setShouldAmount(BigDecimal shouldAmount) {
		this.shouldAmount = shouldAmount;
	}
    
	public BigDecimal getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(BigDecimal paymentAmount) {
		this.paymentAmount = paymentAmount;
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
    
	
	public Confirm(){};


	/**
	 * 
	 * @param id ()
	 * @param customerId (客户id)
	 * @param phone (联系电话)
	 * @param unitId (房间id)
	 * @param priceWay (计价方式)
	 * @param payWayId (付款方式id)
	 * @param discountPercent (折扣百分比)
	 * @param buildPrice (建筑成交单价)
	 * @param insideUnitPrice (套内成交单价)
	 * @param discountDesc (折扣说明)
	 * @param sumMoney (房间总价)
	 * @param renovateDesc (装修标准)
	 * @param renovatePrice (装修单价)
	 * @param isMerge (是否并入合同)
	 * @param renovateMoney (装修总价)
	 * @param agreeNo (协议编号)
	 * @param shouldDeposit (应收定金)
	 * @param agreeMoney (协议总价)
	 * @param signDate (签署日期)
	 * @param workDate (业务归属日期)
	 * @param endDate (失效日期)
	 * @param recommendMan (推荐人)
	 * @param salesId (业务员(id1,id2))
	 * @param deliveryDate (认购约定交楼日期)
	 * @param refUnitId (关联房间id)
	 * @param contractId (转合同id)
	 * @param remark (备注)
	 * @param isDeleted (是否删除)
	 * @param createdId (创建人)
	 * @param createdTime (创建时间)
	 * @param modId (修改人)
	 * @param modTime (修改时间)
	 */
	public Confirm(    
			int id,
	        		int customerId,
	        		String phone,
	        		int unitId,
	        		String priceWay,
	        		int payWayId,
	        		BigDecimal discountPercent,
	        		BigDecimal buildPrice,
	        		BigDecimal insideUnitPrice,
	        		String discountDesc,
	        		BigDecimal sumMoney,
	        		String renovateDesc,
	        		BigDecimal renovatePrice,
	        		String isMerge,
	        		String isSecondConfirm,
	        		String isSecondLinkage,
	        		String isRelation,
	        		BigDecimal renovateMoney,
	        		String agreeNo,
	        		BigDecimal shouldDeposit,
	        		BigDecimal agreeMoney,
	        		Date signDate,
	        		Date workDate,
	        		Date endDate,
	        		String auxiliaryProduct,
	        		String recommendMan,
	        		String salesId,
	        		Date deliveryDate,
	        		int refUnitId,
	        		int contractId,
	        		String remark,
	        		int companyProjectId,
	        		int propertyProjectId,
	        		BigDecimal shouldAmount,
	        		BigDecimal paymentAmount,
	        		String isDeleted,
	        		int createdId,
	        		Date createdTime,
	        		int modId,
	        		Date modTime
	        ) {
			super();  
			this.id = id;
			this.customerId = customerId;
			this.phone = phone;
			this.unitId = unitId;
			this.priceWay = priceWay;
			this.payWayId = payWayId;
			this.discountPercent = discountPercent;
			this.buildPrice = buildPrice;
			this.insideUnitPrice = insideUnitPrice;
			this.discountDesc = discountDesc;
			this.sumMoney = sumMoney;
			this.renovateDesc = renovateDesc;
			this.renovatePrice = renovatePrice;
			this.isMerge = isMerge;
			this.isSecondConfirm = isSecondConfirm;
			this.isSecondLinkage = isSecondLinkage;
			this.isRelation = isRelation;
			this.renovateMoney = renovateMoney;
			this.agreeNo = agreeNo;
			this.shouldDeposit = shouldDeposit;
			this.agreeMoney = agreeMoney;
			this.signDate = signDate;
			this.workDate = workDate;
			this.endDate = endDate;
			this.auxiliaryProduct = auxiliaryProduct;
			this.recommendMan = recommendMan;
			this.salesId = salesId;
			this.deliveryDate = deliveryDate;
			this.refUnitId = refUnitId;
			this.contractId = contractId;
			this.remark = remark;
			this.companyProjectId = companyProjectId;
			this.propertyProjectId = propertyProjectId;
			this.shouldAmount = shouldAmount;
			this.paymentAmount = paymentAmount;
			this.isDeleted = isDeleted;
			this.createdId = createdId;
			this.createdTime = createdTime;
			this.modId = modId;
			this.modTime = modTime;
		}
    
	/**
	 * 
	 * @param customerId (客户id)
	 * @param phone (联系电话)
	 * @param unitId (房间id)
	 * @param priceWay (计价方式)
	 * @param payWayId (付款方式id)
	 * @param discountPercent (折扣百分比)
	 * @param buildPrice (建筑成交单价)
	 * @param insideUnitPrice (套内成交单价)
	 * @param discountDesc (折扣说明)
	 * @param sumMoney (房间总价)
	 * @param renovateDesc (装修标准)
	 * @param renovatePrice (装修单价)
	 * @param isMerge (是否并入合同)
	 * @param renovateMoney (装修总价)
	 * @param agreeNo (协议编号)
	 * @param shouldDeposit (应收定金)
	 * @param agreeMoney (协议总价)
	 * @param signDate (签署日期)
	 * @param workDate (业务归属日期)
	 * @param endDate (失效日期)
	 * @param recommendMan (推荐人)
	 * @param salesId (业务员(id1,id2))
	 * @param deliveryDate (认购约定交楼日期)
	 * @param refUnitId (关联房间id)
	 * @param contractId (转合同id)
	 * @param remark (备注)
	 * @param isDeleted (是否删除)
	 * @param createdId (创建人)
	 * @param createdTime (创建时间)
	 * @param modId (修改人)
	 * @param modTime (修改时间)
	 */
	public Confirm(    
			int customerId,
	        		String phone,
	        		int unitId,
	        		String priceWay,
	        		int payWayId,
	        		BigDecimal discountPercent,
	        		BigDecimal buildPrice,
	        		BigDecimal insideUnitPrice,
	        		String discountDesc,
	        		BigDecimal sumMoney,
	        		String renovateDesc,
	        		BigDecimal renovatePrice,
	        		String isMerge,
	        		String isSecondConfirm,
	        		String isSecondLinkage,
	        		String isRelation,
	        		BigDecimal renovateMoney,
	        		String agreeNo,
	        		BigDecimal shouldDeposit,
	        		BigDecimal agreeMoney,
	        		Date signDate,
	        		Date workDate,
	        		Date endDate,
	        		String auxiliaryProduct,
	        		String recommendMan,
	        		String salesId,
	        		Date deliveryDate,
	        		int refUnitId,
	        		int contractId,
	        		String remark,
	        		int companyProjectId,
	        		int propertyProjectId,
	        		BigDecimal shouldAmount,
	        		BigDecimal paymentAmount,
	        		String isDeleted,
	        		int createdId,
	        		Date createdTime,
	        		int modId,
	        		Date modTime
	        ) {
			super();		
			this.customerId = customerId;
			this.phone = phone;
			this.unitId = unitId;
			this.priceWay = priceWay;
			this.payWayId = payWayId;
			this.discountPercent = discountPercent;
			this.buildPrice = buildPrice;
			this.insideUnitPrice = insideUnitPrice;
			this.discountDesc = discountDesc;
			this.sumMoney = sumMoney;
			this.renovateDesc = renovateDesc;
			this.renovatePrice = renovatePrice;
			this.isMerge = isMerge;
			this.isSecondConfirm = isSecondConfirm;
			this.isSecondLinkage = isSecondLinkage;
			this.isRelation = isRelation;
			this.renovateMoney = renovateMoney;
			this.agreeNo = agreeNo;
			this.shouldDeposit = shouldDeposit;
			this.agreeMoney = agreeMoney;
			this.signDate = signDate;
			this.workDate = workDate;
			this.endDate = endDate;
			this.auxiliaryProduct = auxiliaryProduct;
			this.recommendMan = recommendMan;
			this.salesId = salesId;
			this.deliveryDate = deliveryDate;
			this.refUnitId = refUnitId;
			this.contractId = contractId;
			this.remark = remark;
			this.companyProjectId = companyProjectId;
			this.propertyProjectId = propertyProjectId;
			this.shouldAmount = shouldAmount;
			this.paymentAmount = paymentAmount;
			this.isDeleted = isDeleted;
			this.createdId = createdId;
			this.createdTime = createdTime;
			this.modId = modId;
			this.modTime = modTime;
		}
    

	//以上由代码生成器生成
	//以下非代码生成器生成,不可覆盖,以下是手工代码
    
	//////////
	
	@Override
	public BigDecimal getSalePrice() {//销售总价 合同签约等有不同
		return this.sumMoney;
	}
	
	public String getPropertyProjectName(){
		
		return DescUtils.findPropertyProjectByUnitId(this.getUnitId()).getPropertyName();
	}
	
	public String getPropertyBuildName(){
		
		return DescUtils.getBuildById(DescUtils.findPropertyUnitByUnitId(this.getUnitId()).getBuildId()).getBuildName();
	}
	
	public String getPropertyUnitNo(){
		
		return DescUtils.findPropertyUnitByUnitId(this.getUnitId()).getUnitNo();
	}
	
	public String getRefUnitName(){
		
		return DescUtils.findPropertyUnitByUnitId(this.getRefUnitId()).getUnitNo();
	}
	
	public String getCustomerName(){
		
		return ContractCustomerUtils.getCustomerNameByMainIdAndConfirmType(this.getId(), ContConfirmType.CONFIRM);
	}
	
	public String getCustomerNameUrl(String textStr){
		return getContUrl(textStr);
	}
	
	private String getContUrl(String textStr){
		return "<a href='javascript:void(0)' style='color:#1199FF; text-decoration:underline;padding: 0px 5px 0px' id='"+"customerName"+"'>"+textStr+"</a>";
	}
	
	/**
	 * 获取业务员名称
	 * @return
	 */
	public String getSalesName(){
		
		String name = UserAccountUtils.getRealNameByIds(this.getSalesId());
		
		return name == null ? "" : name;
		
	}
	
	/**
	 * 获取审核人名称
	 * @return
	 */
	public String getAuditName(){
		String name = DescUtils.getUserRealName(this.getModId());
		
		return name == null ? "" : name;
	}
	
	/**外键的UNIT*/
	public PropertyUnit getUnit(){
		return DescUtils.findPropertyUnitByUnitId(this.unitId);
	}
	
	/**
	 * 是否能转合同
	 * @return
	 */
	public boolean getCanChangeToContract(){
		
		if(this.getUnitId() > 0 && this.getContractId() <= 0){
			
			return true;
		}
		
		return false;
		
	}
	
	/**
	 * 付款方式对应的中文显示
	 */
	public String getPayTypeStr(){
		
		return PayWayUtils.getPayWayNameById(this.getPayWayId());
	}
	
	/**
	 * 根据type及mainId获取对应的折扣,如果有就返回查看的href,没有就返回新建的href
	 * @return
	 */
	public String getDiscountModifyHref(){
		
		return DiscountManagerUtils.getDiscountModifyHref(ContConfirmType.CONFIRM, this.getId(), this.getUnitId());
	}
	
	/**
	 * 单元为签约,新建合同时,要显示的折扣href
	 * @return
	 */
	public String getDiscountModifyHrefForContract(){
		
		return DiscountManagerUtils.getDiscountModifyHrefForContract(this.getId(), this.getUnitId(), this.getUnitDiscount());
	}
	
	/**
	 * 根据折扣id获取其详细列表的百分比乘积格式,98.00*97.00
	 * @return
	 */
	public String getDiscountDetail(){
		
		try{
			
			UnitDiscount discount = DiscountManagerUtils.getUnitDiscountServices().findUnitDiscountByTypeAndMainId(ContConfirmType.CONFIRM, this.getId());
			
			return DiscountManagerUtils.getDiscountDetailShowByDiscountId(discount.getId());
			
		}catch(Exception e){
			
			return "";
		}
		
	}
	
	/**
	 * 外键unit 初始化
	 * 主要用做批量注入
	 * */
	private PropertyUnit initUnit;

	public PropertyUnit getInitUnit() {
		return initUnit;
	}

	public void setInitUnit(PropertyUnit initUnit) {
		this.initUnit = initUnit;
	}

	/**
	 * 获取该签约对应的单元折扣,主要用于对应的单元为签约而新建合同的时候使用
	 * GuangZhouContractXiaoZhuAction.java
	 */
	private UnitDiscount unitDiscount;
	
	public void setUnitDiscount(UnitDiscount unitDiscount) {
		this.unitDiscount = unitDiscount;
	}
	
	public UnitDiscount getUnitDiscount() {
		return unitDiscount;
	}

    /**
     * 建筑面积
     * @return
     */
    public BigDecimal getBuildArea() {
        return buildArea;
    }

    public void setBuildArea(BigDecimal buildArea) {
        this.buildArea = buildArea;
    }
    
    public ContractCustomer getCustomerNo(){
    	ContractCustomer confirmCustomer = DescUtils.findContractCustomerById(this.getCustomerId());
    	return confirmCustomer;
    }
    
    /**
     * 获取成交单对应的客户id连接String(id1,id2...)
     * @return
     */
    public String getCustomerIds() {
    	
    	List<ContractCustomer> conCusList = MyPropertyUtils.getContractCustomerServices()
    		.findContractCustomerByMainIdAndConfirmType(this.getId(), ContConfirmType.CONFIRM);
    	
    	String ret = "";
    	
    	StringBuffer sb = new StringBuffer();
    	
    	if(!CommonUtils.isCollectionEmpty(conCusList)){
    		
    		for(ContractCustomer con : conCusList){
    			
    			sb.append(con.getId()).append(",");
    		}
    		
    		ret = CommonUtils.removeLastChar(sb.toString());
    	}
    	
    	return ret;
    }
    
//    @Override
//    public boolean equals(Object obj){
//    	Confirm c = (Confirm)obj;
//    	if(c!=null&&this.priceWay.equals(c.getPriceWay())&&this.insideUnitPrice.equals(c.getInsideUnitPrice())&&this.buildPrice.equals(c.getBuildPrice())&&this.sumMoney.equals(c.getSumMoney())&&this.payWayId==c.getPayWayId()&&this.agreeNo.equals(c.getAgreeNo())&&this.workDate.equals(c.getWorkDate())&&this.auxiliaryProduct.equals(c.getAuxiliaryProduct())&&this.shouldDeposit==c.getShouldDeposit()&&this.isRelation.equals(c.getIsRelation())&&this.isSecondLinkage.equals(c.getIsSecondLinkage())&&this.remark.equals(c.getRemark())&&this.salesId.equals(c.getSalesId())){
//    		return false;
//    	}
//    	return true;
//    }
}
