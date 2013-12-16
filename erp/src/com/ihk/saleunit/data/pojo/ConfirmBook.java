package com.ihk.saleunit.data.pojo;

import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import java.io.Serializable;

import com.ihk.constanttype.ContConfirmType;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.contract.customer.ContractCustomerUtils;
import com.ihk.utils.saleunit.MyPropertyUtils;
import com.ihk.utils.useraccount.UserAccountUtils;

/**
 * ConfirmBook的实体类
 * 临定
 * @author 
 * 
 */
public class ConfirmBook implements Serializable{
	
    
	//以下由代码生成器生成,如果手工添加代码，务必写在本代码页面最下方
    
	private static final long serialVersionUID = 3178944353763903120L;
	
	private int id;
	private int customerId;
	private String salesId;
	private String phone;
	private int unitId;
	private int payWayId;
	private BigDecimal discountPercent;
	private String discountDesc;
	private BigDecimal sumMoney;
	private String renovateDesc;
	private BigDecimal bookMoney;
	private Date endDate;
	private int confirmId;
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
	 * 取得CustomerId(客户id(与contract_customer成1:n,用逗号连接多个客户id))
	 */
	public int getCustomerId() {
		return customerId;
	}

	/**
	 * 设置customerId(客户id(与contract_customer成1:n,用逗号连接多个客户id))
	 * @param customerId (客户id(与contract_customer成1:n,用逗号连接多个客户id))
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
    
	/**
	 * 取得SalesId(业务员(销售人员)id,用逗号连接)
	 */
	public String getSalesId() {
		return salesId;
	}

	/**
	 * 设置salesId(业务员(销售人员)id,用逗号连接)
	 * @param salesId (业务员(销售人员)id,用逗号连接)
	 */
	public void setSalesId(String salesId) {
		this.salesId = salesId;
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
	 * 取得BookMoney(应收订金)
	 */
	public BigDecimal getBookMoney() {
		return bookMoney;
	}

	/**
	 * 设置bookMoney(应收订金)
	 * @param bookMoney (应收订金)
	 */
	public void setBookMoney(BigDecimal bookMoney) {
		this.bookMoney = bookMoney;
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
	 * 取得ConfirmId(转认购id)
	 */
	public int getConfirmId() {
		return confirmId;
	}

	/**
	 * 设置confirmId(转认购id)
	 * @param confirmId (转认购id)
	 */
	public void setConfirmId(int confirmId) {
		this.confirmId = confirmId;
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
    
	
	public ConfirmBook(){};


	/**
	 * 
	 * @param id ()
	 * @param customerId (客户id(与contract_customer成1:n,用逗号连接多个客户id))
	 * @param salesId (业务员(销售人员)id,用逗号连接)
	 * @param phone (联系电话)
	 * @param unitId (房间id)
	 * @param payWayId (付款方式id)
	 * @param discountPercent (折扣百分比)
	 * @param discountDesc (折扣说明)
	 * @param sumMoney (房间总价)
	 * @param renovateDesc (装修标准)
	 * @param bookMoney (应收订金)
	 * @param endDate (失效日期)
	 * @param confirmId (转认购id)
	 * @param isDeleted (是否删除)
	 * @param createdId (创建人)
	 * @param createdTime (创建时间)
	 * @param modId (修改人)
	 * @param modTime (修改时间)
	 */
	public ConfirmBook(    
		int id,
        		int customerId,
        		String salesId,
        		String phone,
        		int unitId,
        		int payWayId,
        		BigDecimal discountPercent,
        		String discountDesc,
        		BigDecimal sumMoney,
        		String renovateDesc,
        		BigDecimal bookMoney,
        		Date endDate,
        		int confirmId,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime
        ) {
		super();  
		this.id = id;
		this.customerId = customerId;
		this.salesId = salesId;
		this.phone = phone;
		this.unitId = unitId;
		this.payWayId = payWayId;
		this.discountPercent = discountPercent;
		this.discountDesc = discountDesc;
		this.sumMoney = sumMoney;
		this.renovateDesc = renovateDesc;
		this.bookMoney = bookMoney;
		this.endDate = endDate;
		this.confirmId = confirmId;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
    
	/**
	 * 
	 * @param customerId (客户id(与contract_customer成1:n,用逗号连接多个客户id))
	 * @param salesId (业务员(销售人员)id,用逗号连接)
	 * @param phone (联系电话)
	 * @param unitId (房间id)
	 * @param payWayId (付款方式id)
	 * @param discountPercent (折扣百分比)
	 * @param discountDesc (折扣说明)
	 * @param sumMoney (房间总价)
	 * @param renovateDesc (装修标准)
	 * @param bookMoney (应收订金)
	 * @param endDate (失效日期)
	 * @param confirmId (转认购id)
	 * @param isDeleted (是否删除)
	 * @param createdId (创建人)
	 * @param createdTime (创建时间)
	 * @param modId (修改人)
	 * @param modTime (修改时间)
	 */
	public ConfirmBook(    
		int customerId,
        		String salesId,
        		String phone,
        		int unitId,
        		int payWayId,
        		BigDecimal discountPercent,
        		String discountDesc,
        		BigDecimal sumMoney,
        		String renovateDesc,
        		BigDecimal bookMoney,
        		Date endDate,
        		int confirmId,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime
        ) {
		super();		
		this.customerId = customerId;
		this.salesId = salesId;
		this.phone = phone;
		this.unitId = unitId;
		this.payWayId = payWayId;
		this.discountPercent = discountPercent;
		this.discountDesc = discountDesc;
		this.sumMoney = sumMoney;
		this.renovateDesc = renovateDesc;
		this.bookMoney = bookMoney;
		this.endDate = endDate;
		this.confirmId = confirmId;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
    

	//以上由代码生成器生成
	//以下非代码生成器生成,不可覆盖,以下是手工代码
	
	/**
	 * 获取业务员名称
	 * @return
	 */
	public String getSalesName(){
		
		String name = UserAccountUtils.getRealNameByIds(this.getSalesId());
		
		return name == null ? "" : name;
	}
	
	/**
     * 获取临订单对应的客户id连接String(id1,id2...)
     * @return
     */
    public String getCustomerIds() {
    	
    	List<ContractCustomer> conCusList = MyPropertyUtils.getContractCustomerServices()
    		.findContractCustomerByMainIdAndConfirmType(this.getId(), ContConfirmType.CONFIRM_BOOK);
    	
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
    
    public String getCustomerName(){
    	return ContractCustomerUtils.getCustomerNameByMainIdAndConfirmType(this.getId(), ContConfirmType.CONFIRM_BOOK);
    }
    
    public String getPropertyBuildName(){
		
		return DescUtils.getBuildById(DescUtils.findPropertyUnitByUnitId(this.getUnitId()).getBuildId()).getBuildName();
	}
    
    public PropertyUnit getUnit(){
		return DescUtils.findPropertyUnitByUnitId(this.unitId);
	}
}
