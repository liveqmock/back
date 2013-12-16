package com.ihk.property.data.pojo;

import java.util.Date;
import java.math.BigDecimal;
import java.io.Serializable;

/**
 * BuildDiscount的实体类
 * @author 
 *
 */
public class BuildDiscount implements Serializable{
	private static final long serialVersionUID = 1L;
    
		private int id;
		private String discountName;
		private int buildId;
		private String discountType;
		private String computeWay;
		private BigDecimal discountMoney;
		private BigDecimal discountPercent;
		private Date startDate;
		private Date endDate;
		private String discountDesc;
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
		 * 取得DiscountName(折扣名称)
		 */
		public String getDiscountName() {
			return discountName;
		}

		/**
		 * 设置discountName(折扣名称)
		 * @param discountName (折扣名称)
		 */
		public void setDiscountName(String discountName) {
			this.discountName = discountName;
		}
	    
		/**
		 * 取得BuildId(楼栋)
		 */
		public int getBuildId() {
			return buildId;
		}

		/**
		 * 设置buildId(楼栋)
		 * @param buildId (楼栋)
		 */
		public void setBuildId(int buildId) {
			this.buildId = buildId;
		}
	    
		/**
		 * 取得DiscountType(折扣类型)
		 */
		public String getDiscountType() {
			return discountType;
		}

		/**
		 * 设置discountType(折扣类型)
		 * @param discountType (折扣类型)
		 */
		public void setDiscountType(String discountType) {
			this.discountType = discountType;
		}
	    
		/**
		 * 取得ComputeWay(计算方式)
		 */
		public String getComputeWay() {
			return computeWay;
		}

		/**
		 * 设置computeWay(计算方式)
		 * @param computeWay (计算方式)
		 */
		public void setComputeWay(String computeWay) {
			this.computeWay = computeWay;
		}
	    
		/**
		 * 取得DiscountMoney(优惠金额)
		 */
		public BigDecimal getDiscountMoney() {
			return discountMoney;
		}

		/**
		 * 设置discountMoney(优惠金额)
		 * @param discountMoney (优惠金额)
		 */
		public void setDiscountMoney(BigDecimal discountMoney) {
			this.discountMoney = discountMoney;
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
		 * 取得StartDate(生效日期)
		 */
		public Date getStartDate() {
			return startDate;
		}

		/**
		 * 设置startDate(生效日期)
		 * @param startDate (生效日期)
		 */
		public void setStartDate(Date startDate) {
			this.startDate = startDate;
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
	    
		
		public BuildDiscount(){};


		/**
		 * 
		 * @param id ()
		 * @param discountName (折扣名称)
		 * @param buildId (楼栋)
		 * @param discountType (折扣类型)
		 * @param computeWay (计算方式)
		 * @param discountMoney (优惠金额)
		 * @param discountPercent (折扣百分比)
		 * @param startDate (生效日期)
		 * @param endDate (失效日期)
		 * @param discountDesc (折扣说明)
		 * @param isDeleted (是否删除)
		 * @param createdId (创建人)
		 * @param createdTime (创建时间)
		 * @param modId (修改人)
		 * @param modTime (修改时间)
		 */
		public BuildDiscount(    
			int id,
	        		String discountName,
	        		int buildId,
	        		String discountType,
	        		String computeWay,
	        		BigDecimal discountMoney,
	        		BigDecimal discountPercent,
	        		Date startDate,
	        		Date endDate,
	        		String discountDesc,
	        		String isDeleted,
	        		int createdId,
	        		Date createdTime,
	        		int modId,
	        		Date modTime
	        ) {
			super();  
			this.id = id;
			this.discountName = discountName;
			this.buildId = buildId;
			this.discountType = discountType;
			this.computeWay = computeWay;
			this.discountMoney = discountMoney;
			this.discountPercent = discountPercent;
			this.startDate = startDate;
			this.endDate = endDate;
			this.discountDesc = discountDesc;
			this.isDeleted = isDeleted;
			this.createdId = createdId;
			this.createdTime = createdTime;
			this.modId = modId;
			this.modTime = modTime;
		}
	    
		/**
		 * 
		 * @param discountName (折扣名称)
		 * @param buildId (楼栋)
		 * @param discountType (折扣类型)
		 * @param computeWay (计算方式)
		 * @param discountMoney (优惠金额)
		 * @param discountPercent (折扣百分比)
		 * @param startDate (生效日期)
		 * @param endDate (失效日期)
		 * @param discountDesc (折扣说明)
		 * @param isDeleted (是否删除)
		 * @param createdId (创建人)
		 * @param createdTime (创建时间)
		 * @param modId (修改人)
		 * @param modTime (修改时间)
		 */
		public BuildDiscount(    
			String discountName,
	        		int buildId,
	        		String discountType,
	        		String computeWay,
	        		BigDecimal discountMoney,
	        		BigDecimal discountPercent,
	        		Date startDate,
	        		Date endDate,
	        		String discountDesc,
	        		String isDeleted,
	        		int createdId,
	        		Date createdTime,
	        		int modId,
	        		Date modTime
	        ) {
			super();		
			this.discountName = discountName;
			this.buildId = buildId;
			this.discountType = discountType;
			this.computeWay = computeWay;
			this.discountMoney = discountMoney;
			this.discountPercent = discountPercent;
			this.startDate = startDate;
			this.endDate = endDate;
			this.discountDesc = discountDesc;
			this.isDeleted = isDeleted;
			this.createdId = createdId;
			this.createdTime = createdTime;
			this.modId = modId;
			this.modTime = modTime;
		}
	    

		//以上由代码生成器生成
		//以下非代码生成器生成,不可覆盖
}
