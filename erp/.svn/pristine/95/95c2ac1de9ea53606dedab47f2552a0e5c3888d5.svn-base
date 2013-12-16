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
 * Contract的实体类
 * @author 
 *
 */
public class Contract implements Serializable,SupperConfirm{
	
	private static final long serialVersionUID = 1280806978920263127L;
	//以下由代码生成器生成,如果手工添加代码，务必写在本代码页面最下方
    
	private int id;
	private int confirmId;
	private int customerId;
	private String phone;
	private int unitId;
	private String propertyType;
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
	private String isSecondLinkage;
	private String isRelation;
	
	private BigDecimal renovateMoney;
	private Date finishDate;
	private String contractNo;
	private BigDecimal shouldDeposit;
	private BigDecimal contractMoney;
	private Date signDate;
	private Date workDate;
	private Date deliveryDate;
	private Date realHouseDate;
	private Date delayDate;
	private String recordNo;
	private Date recordDate;
	private String recommendMan;
	private String salesId;
	private String mortgageBank;
	private BigDecimal mortgageMoney;
	private int mortgageYear;
	private String fundBank;
	private BigDecimal fundMoney;
	private int fundYear;
	private Date confirmDeliveryDate;
	private int refUnitId;
	
	private String remark;
	
	private int companyProjectId;
	private int propertyProjectId;
	
	private BigDecimal shouldAmount;
	private BigDecimal paymentAmount;
	
	private String isDeleted;
	private int createdId;
	private Date createdTime;
	private int modId;
	private Date modTime;
	
	private Date takeTime;
	private Date takeUnitTime;
	
	
	
	public Date getTakeTime() {
		return takeTime;
	}

	public void setTakeTime(Date takeTime) {
		this.takeTime = takeTime;
	}

	public Date getTakeUnitTime() {
		return takeUnitTime;
	}

	public void setTakeUnitTime(Date takeUnitTime) {
		this.takeUnitTime = takeUnitTime;
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
	 * 取得ConfirmId(认购id)
	 */
	public int getConfirmId() {
		return confirmId;
	}

	/**
	 * 设置confirmId(认购id)
	 * @param confirmId (认购id)
	 */
	public void setConfirmId(int confirmId) {
		this.confirmId = confirmId;
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
	 * 取得PropertyType(房产类型)
	 */
	public String getPropertyType() {
		return propertyType;
	}

	/**
	 * 设置propertyType(房产类型)
	 * @param propertyType (房产类型)
	 */
	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
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
	 * 取得FinishDate(个性装修交楼日期)
	 */
	public Date getFinishDate() {
		return finishDate;
	}

	/**
	 * 设置finishDate(个性装修交楼日期)
	 * @param finishDate (个性装修交楼日期)
	 */
	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}
    
	/**
	 * 取得ContractNo(合同编号)
	 */
	public String getContractNo() {
		return contractNo;
	}

	/**
	 * 设置contractNo(合同编号)
	 * @param contractNo (合同编号)
	 */
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
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
	 * 取得ContractMoney(合同总价)
	 */
	public BigDecimal getContractMoney() {
		return contractMoney;
	}

	/**
	 * 设置contractMoney(合同总价)
	 * @param contractMoney (合同总价)
	 */
	public void setContractMoney(BigDecimal contractMoney) {
		this.contractMoney = contractMoney;
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
		return workDate == null ? getSignDate() : workDate;
	}

	/**
	 * 设置workDate(业务归属日期)
	 * @param workDate (业务归属日期)
	 */
	public void setWorkDate(Date workDate) {
		this.workDate = workDate;
	}
    
	/**
	 * 取得DeliveryDate(约定交房日期)
	 */
	public Date getDeliveryDate() {
		return deliveryDate;
	}

	/**
	 * 设置deliveryDate(约定交房日期)
	 * @param deliveryDate (约定交房日期)
	 */
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
    
	/**
	 * 取得RealHouseDate(实际交房日期)
	 */
	public Date getRealHouseDate() {
		return realHouseDate;
	}

	/**
	 * 设置realHouseDate(实际交房日期)
	 * @param realHouseDate (实际交房日期)
	 */
	public void setRealHouseDate(Date realHouseDate) {
		this.realHouseDate = realHouseDate;
	}
    
	/**
	 * 取得DelayDate(延期交房日期)
	 */
	public Date getDelayDate() {
		return delayDate;
	}

	/**
	 * 设置delayDate(延期交房日期)
	 * @param delayDate (延期交房日期)
	 */
	public void setDelayDate(Date delayDate) {
		this.delayDate = delayDate;
	}
    
	/**
	 * 取得RecordNo(合同备案号)
	 */
	public String getRecordNo() {
		return recordNo;
	}

	/**
	 * 设置recordNo(合同备案号)
	 * @param recordNo (合同备案号)
	 */
	public void setRecordNo(String recordNo) {
		this.recordNo = recordNo;
	}
    
	/**
	 * 取得RecordDate(备案日期)
	 */
	public Date getRecordDate() {
		return recordDate;
	}

	/**
	 * 设置recordDate(备案日期)
	 * @param recordDate (备案日期)
	 */
	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
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
	 * 取得SalesId(业务员)
	 */
	public String getSalesId() {
		return salesId;
	}

	/**
	 * 设置salesId(业务员)
	 * @param salesId (业务员)
	 */
	public void setSalesId(String salesId) {
		this.salesId = salesId;
	}
    
	/**
	 * 取得MortgageBank(按揭银行)
	 */
	public String getMortgageBank() {
		return mortgageBank;
	}

	/**
	 * 设置mortgageBank(按揭银行)
	 * @param mortgageBank (按揭银行)
	 */
	public void setMortgageBank(String mortgageBank) {
		this.mortgageBank = mortgageBank;
	}
    
	/**
	 * 取得MortgageMoney(按揭贷款)
	 */
	public BigDecimal getMortgageMoney() {
		return mortgageMoney;
	}

	/**
	 * 设置mortgageMoney(按揭贷款)
	 * @param mortgageMoney (按揭贷款)
	 */
	public void setMortgageMoney(BigDecimal mortgageMoney) {
		this.mortgageMoney = mortgageMoney;
	}
    
	/**
	 * 取得MortgageYear(按揭年限)
	 */
	public int getMortgageYear() {
		return mortgageYear;
	}

	/**
	 * 设置mortgageYear(按揭年限)
	 * @param mortgageYear (按揭年限)
	 */
	public void setMortgageYear(int mortgageYear) {
		this.mortgageYear = mortgageYear;
	}
    
	/**
	 * 取得FundBank(公积金银行)
	 */
	public String getFundBank() {
		return fundBank;
	}

	/**
	 * 设置fundBank(公积金银行)
	 * @param fundBank (公积金银行)
	 */
	public void setFundBank(String fundBank) {
		this.fundBank = fundBank;
	}
    
	/**
	 * 取得FundMoney(公积金贷款)
	 */
	public BigDecimal getFundMoney() {
		return fundMoney;
	}

	/**
	 * 设置fundMoney(公积金贷款)
	 * @param fundMoney (公积金贷款)
	 */
	public void setFundMoney(BigDecimal fundMoney) {
		this.fundMoney = fundMoney;
	}
    
	/**
	 * 取得FundYear(公积金年限)
	 */
	public int getFundYear() {
		return fundYear;
	}

	/**
	 * 设置fundYear(公积金年限)
	 * @param fundYear (公积金年限)
	 */
	public void setFundYear(int fundYear) {
		this.fundYear = fundYear;
	}
    
	/**
	 * 取得ConfirmDeliveryDate(认购约定交楼日期)
	 */
	public Date getConfirmDeliveryDate() {
		return confirmDeliveryDate;
	}

	/**
	 * 设置confirmDeliveryDate(认购约定交楼日期)
	 * @param confirmDeliveryDate (认购约定交楼日期)
	 */
	public void setConfirmDeliveryDate(Date confirmDeliveryDate) {
		this.confirmDeliveryDate = confirmDeliveryDate;
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
	
	public String getRemark() {
		return remark;
	}
	
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
    
	
	public Contract(){};


	/**
	 * 
	 * @param id ()
	 * @param confirmId (认购id)
	 * @param customerId (客户id)
	 * @param phone (联系电话)
	 * @param unitId (房间)
	 * @param propertyType (房产类型)
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
	 * @param finishDate (个性装修交楼日期)
	 * @param contractNo (合同编号)
	 * @param shouldDeposit (应收定金)
	 * @param contractMoney (合同总价)
	 * @param signDate (签署日期)
	 * @param workDate (业务归属日期)
	 * @param deliveryDate (约定交房日期)
	 * @param realHouseDate (实际交房日期)
	 * @param delayDate (延期交房日期)
	 * @param recordNo (合同备案号)
	 * @param recordDate (备案日期)
	 * @param recommendMan (推荐人)
	 * @param salesId (业务员)
	 * @param mortgageBank (按揭银行)
	 * @param mortgageMoney (按揭贷款)
	 * @param mortgageYear (按揭年限)
	 * @param fundBank (公积金银行)
	 * @param fundMoney (公积金贷款)
	 * @param fundYear (公积金年限)
	 * @param confirmDeliveryDate (认购约定交楼日期)
	 * @param refUnitId (关联房间id)
	 * @param isDeleted (是否删除)
	 * @param createdId (创建人)
	 * @param createdTime (创建时间)
	 * @param modId (修改人)
	 * @param modTime (修改时间)
	 */
	public Contract(    
			int id,
	        		int confirmId,
	        		int customerId,
	        		String phone,
	        		int unitId,
	        		String propertyType,
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
	        		String isSecondLinkage,
	        		String isRelation,
	        		BigDecimal renovateMoney,
	        		Date finishDate,
	        		String contractNo,
	        		BigDecimal shouldDeposit,
	        		BigDecimal contractMoney,
	        		Date signDate,
	        		Date workDate,
	        		Date deliveryDate,
	        		Date realHouseDate,
	        		Date delayDate,
	        		String recordNo,
	        		Date recordDate,
	        		String recommendMan,
	        		String salesId,
	        		String mortgageBank,
	        		BigDecimal mortgageMoney,
	        		int mortgageYear,
	        		String fundBank,
	        		BigDecimal fundMoney,
	        		int fundYear,
	        		Date confirmDeliveryDate,
	        		int refUnitId,
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
			this.confirmId = confirmId;
			this.customerId = customerId;
			this.phone = phone;
			this.unitId = unitId;
			this.propertyType = propertyType;
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
			this.isSecondLinkage = isSecondLinkage;
			this.isRelation = isRelation;
			this.renovateMoney = renovateMoney;
			this.finishDate = finishDate;
			this.contractNo = contractNo;
			this.shouldDeposit = shouldDeposit;
			this.contractMoney = contractMoney;
			this.signDate = signDate;
			this.workDate = workDate;
			this.deliveryDate = deliveryDate;
			this.realHouseDate = realHouseDate;
			this.delayDate = delayDate;
			this.recordNo = recordNo;
			this.recordDate = recordDate;
			this.recommendMan = recommendMan;
			this.salesId = salesId;
			this.mortgageBank = mortgageBank;
			this.mortgageMoney = mortgageMoney;
			this.mortgageYear = mortgageYear;
			this.fundBank = fundBank;
			this.fundMoney = fundMoney;
			this.fundYear = fundYear;
			this.confirmDeliveryDate = confirmDeliveryDate;
			this.refUnitId = refUnitId;
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
	 * @param confirmId (认购id)
	 * @param customerId (客户id)
	 * @param phone (联系电话)
	 * @param unitId (房间)
	 * @param propertyType (房产类型)
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
	 * @param finishDate (个性装修交楼日期)
	 * @param contractNo (合同编号)
	 * @param shouldDeposit (应收定金)
	 * @param contractMoney (合同总价)
	 * @param signDate (签署日期)
	 * @param workDate (业务归属日期)
	 * @param deliveryDate (约定交房日期)
	 * @param realHouseDate (实际交房日期)
	 * @param delayDate (延期交房日期)
	 * @param recordNo (合同备案号)
	 * @param recordDate (备案日期)
	 * @param recommendMan (推荐人)
	 * @param salesId (业务员)
	 * @param mortgageBank (按揭银行)
	 * @param mortgageMoney (按揭贷款)
	 * @param mortgageYear (按揭年限)
	 * @param fundBank (公积金银行)
	 * @param fundMoney (公积金贷款)
	 * @param fundYear (公积金年限)
	 * @param confirmDeliveryDate (认购约定交楼日期)
	 * @param refUnitId (关联房间id)
	 * @param isDeleted (是否删除)
	 * @param createdId (创建人)
	 * @param createdTime (创建时间)
	 * @param modId (修改人)
	 * @param modTime (修改时间)
	 */
	public Contract(    
			int confirmId,
	        		int customerId,
	        		String phone,
	        		int unitId,
	        		String propertyType,
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
	        		String isSecondLinkage,
	        		String isRelation,
	        		BigDecimal renovateMoney,
	        		Date finishDate,
	        		String contractNo,
	        		BigDecimal shouldDeposit,
	        		BigDecimal contractMoney,
	        		Date signDate,
	        		Date workDate,
	        		Date deliveryDate,
	        		Date realHouseDate,
	        		Date delayDate,
	        		String recordNo,
	        		Date recordDate,
	        		String recommendMan,
	        		String salesId,
	        		String mortgageBank,
	        		BigDecimal mortgageMoney,
	        		int mortgageYear,
	        		String fundBank,
	        		BigDecimal fundMoney,
	        		int fundYear,
	        		Date confirmDeliveryDate,
	        		int refUnitId,
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
			this.confirmId = confirmId;
			this.customerId = customerId;
			this.phone = phone;
			this.unitId = unitId;
			this.propertyType = propertyType;
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
			this.isSecondLinkage = isSecondLinkage;
			this.isRelation = isRelation;
			this.renovateMoney = renovateMoney;
			this.finishDate = finishDate;
			this.contractNo = contractNo;
			this.shouldDeposit = shouldDeposit;
			this.contractMoney = contractMoney;
			this.signDate = signDate;
			this.workDate = workDate;
			this.deliveryDate = deliveryDate;
			this.realHouseDate = realHouseDate;
			this.delayDate = delayDate;
			this.recordNo = recordNo;
			this.recordDate = recordDate;
			this.recommendMan = recommendMan;
			this.salesId = salesId;
			this.mortgageBank = mortgageBank;
			this.mortgageMoney = mortgageMoney;
			this.mortgageYear = mortgageYear;
			this.fundBank = fundBank;
			this.fundMoney = fundMoney;
			this.fundYear = fundYear;
			this.confirmDeliveryDate = confirmDeliveryDate;
			this.refUnitId = refUnitId;
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
    
	
	/////////
	
	public BigDecimal getSalePrice() {//销售总价 报表用 合同签约有不同
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
	
	/**
	 * 以前根据customerId去获取是不正确的,改为ContractCustomer中的confirmType和mainId
	 */
	public String getCustomerName(){
		
		return ContractCustomerUtils.getCustomerNameByMainIdAndConfirmType(this.getId(), ContConfirmType.CONTRACT);
	}
	
	/**
	 * 获取业务员名称(兼容旧的代码,不删除)
	 * @return
	 */
	@Deprecated
	public String getSaleName(){
		
		String name = UserAccountUtils.getRealNameByIds(this.getSalesId());
		
		return name == null ? "" : name;
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
	
	/**
	 * 外键的UNIT
	 * @return
	 */
	public PropertyUnit getUnit(){
		return DescUtils.findPropertyUnitByUnitId(this.unitId);
	}
	
	public String getPayTypeStr(){
		
		return PayWayUtils.getPayWayNameById(this.getPayWayId());
	}
	
	public String getDiscountModifyHref(){
		
		return DiscountManagerUtils.getDiscountModifyHref(ContConfirmType.CONTRACT, this.getId(), this.getUnitId());
	}
	
	/**
	 * 根据折扣id获取其详细列表的百分比乘积格式,98.00*97.00
	 * @return
	 */
	public String getDiscountDetail(){
		
		try{
			
			UnitDiscount discount = DiscountManagerUtils.getUnitDiscountServices().findUnitDiscountByTypeAndMainId(ContConfirmType.CONTRACT, this.getId());
			
			return DiscountManagerUtils.getDiscountDetailShowByDiscountId(discount.getId());
			
		}catch(Exception e){
			
			return "";
		}
		
	}
	
	/**
	 * 对应的认购,可能不存在
	 */
	private Confirm confirm;
	public void setConfirm(Confirm confirm) {
		this.confirm = confirm;
	}
	public Confirm getConfirm() {
		
		if(this.getConfirmId() == 0){
			
			return new Confirm();
		}
		
		if(confirm == null){
			
			confirm = MyPropertyUtils.getConfirmServices().findConfirmById(this.getConfirmId());
		}
		
		return confirm;
	}
	
	/**
	 * 用来做批量注入
	 * */
	private PropertyUnit initUnit;

	public PropertyUnit getInitUnit() {
		return initUnit;
	}

	public void setInitUnit(PropertyUnit initUnit) {
		this.initUnit = initUnit;
	}
	
	/**
     * 获取合同单对应的客户id连接String(id1,id2...)
     * @return
     */
    public String getCustomerIds() {
    	
    	List<ContractCustomer> conCusList = MyPropertyUtils.getContractCustomerServices()
    		.findContractCustomerByMainIdAndConfirmType(this.getId(), ContConfirmType.CONTRACT);
    	
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
//    	Contract c = (Contract)obj;
//    	if(c!=null&&this.priceWay.equals(c.getPriceWay())&&this.insideUnitPrice.equals(c.getInsideUnitPrice())&&this.buildPrice.equals(c.getBuildPrice())&&this.sumMoney.equals(c.getSumMoney())&&this.payWayId==c.getPayWayId()&&this.contractNo.equals(c.getContractNo())&&this.workDate.equals(c.getWorkDate())&&this.shouldDeposit==c.getShouldDeposit()&&this.isRelation.equals(c.getIsRelation())&&this.isSecondLinkage.equals(c.getIsSecondLinkage())&&this.remark.equals(c.getRemark())&&this.confirmDeliveryDate.equals(c.getConfirmDeliveryDate())&&this.realHouseDate.equals(c.getRealHouseDate())&&this.delayDate.equals(c.getDelayDate())&&this.recommendMan.equals(c.getRecommendMan())&&this.recordNo.equals(c.getRecordNo())&&this.recordDate.equals(c.getRecordDate())&&this.salesId.equals(c.getSalesId())){
//    		return false;
//    	}
//    	return true;
//    }
	
	
}
