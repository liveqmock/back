package com.ihk.saleunit.data.pojo;

import java.util.Date;
import java.math.BigDecimal;
import java.io.Serializable;

/**
 * PropertyProjectPlan的实体类
 * @author 
 *
 */
public class PropertyProjectPlan implements Serializable{

	private static final long serialVersionUID = 1L;

	//以下由代码生成器生成,如果手工添加代码，务必写在本代码页面最下方
    
	private int id;
	private int propertyId;
	private BigDecimal planArea;
	private BigDecimal planMoney;
	private BigDecimal planPrice;
	private String planMonth;
	private String remark;
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
	 * 取得PropertyId(楼盘项目id)
	 */
	public int getPropertyId() {
		return propertyId;
	}

	/**
	 * 设置propertyId(楼盘项目id)
	 * @param propertyId (楼盘项目id)
	 */
	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}
    
	/**
	 * 取得PlanArea(任务面积)
	 */
	public BigDecimal getPlanArea() {
		return planArea;
	}

	/**
	 * 设置planArea(任务面积)
	 * @param planArea (任务面积)
	 */
	public void setPlanArea(BigDecimal planArea) {
		this.planArea = planArea;
	}
    
	/**
	 * 取得PlanMoney(任务金额)
	 */
	public BigDecimal getPlanMoney() {
		return planMoney;
	}

	/**
	 * 设置planMoney(任务金额)
	 * @param planMoney (任务金额)
	 */
	public void setPlanMoney(BigDecimal planMoney) {
		this.planMoney = planMoney;
	}
    
	/**
	 * 取得PlanPrice(任务均价)
	 */
	public BigDecimal getPlanPrice() {
		return planPrice;
	}

	/**
	 * 设置planPrice(任务均价)
	 * @param planPrice (任务均价)
	 */
	public void setPlanPrice(BigDecimal planPrice) {
		this.planPrice = planPrice;
	}
    
	/**
	 * 取得PlanMonth(计划年月)
	 */
	public String getPlanMonth() {
		return planMonth;
	}

	/**
	 * 设置planMonth(计划年月)
	 * @param planMonth (计划年月)
	 */
	public void setPlanMonth(String planMonth) {
		this.planMonth = planMonth;
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
    
	
	public PropertyProjectPlan(){};


	/**
	 * 
	 * @param id ()
	 * @param propertyId (楼盘项目id)
	 * @param planArea (任务面积)
	 * @param planMoney (任务金额)
	 * @param planPrice (任务均价)
	 * @param planMonth (计划年月)
	 * @param remark (备注)
	 * @param isDeleted (是否删除)
	 * @param createdId (创建人)
	 * @param createdTime (创建时间)
	 * @param modId (修改人)
	 * @param modTime (修改时间)
	 */
	public PropertyProjectPlan(    
		int id,
        		int propertyId,
        		BigDecimal planArea,
        		BigDecimal planMoney,
        		BigDecimal planPrice,
        		String planMonth,
        		String remark,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime
        ) {
		super();  
		this.id = id;
		this.propertyId = propertyId;
		this.planArea = planArea;
		this.planMoney = planMoney;
		this.planPrice = planPrice;
		this.planMonth = planMonth;
		this.remark = remark;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
    
	/**
	 * 
	 * @param propertyId (楼盘项目id)
	 * @param planArea (任务面积)
	 * @param planMoney (任务金额)
	 * @param planPrice (任务均价)
	 * @param planMonth (计划年月)
	 * @param remark (备注)
	 * @param isDeleted (是否删除)
	 * @param createdId (创建人)
	 * @param createdTime (创建时间)
	 * @param modId (修改人)
	 * @param modTime (修改时间)
	 */
	public PropertyProjectPlan(    
		int propertyId,
        		BigDecimal planArea,
        		BigDecimal planMoney,
        		BigDecimal planPrice,
        		String planMonth,
        		String remark,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime
        ) {
		super();		
		this.propertyId = propertyId;
		this.planArea = planArea;
		this.planMoney = planMoney;
		this.planPrice = planPrice;
		this.planMonth = planMonth;
		this.remark = remark;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
    

	//以上由代码生成器生成
	//以下非代码生成器生成,不可覆盖,以下是手工代码
    
}
