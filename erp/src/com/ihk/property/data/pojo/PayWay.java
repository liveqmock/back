package com.ihk.property.data.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.ihk.property.data.services.IPayWayDetailServices;
import com.ihk.utils.saleunit.MyPropertyUtils;

/**
 * PayWay的实体类
 * @author 
 *
 */
public class PayWay implements Serializable{
	private static final long serialVersionUID = 1L;
    
		private int id;
		private int buildId;
		private int projectId;
		private String payType;
		private String payName;
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
	    
		public void setBuildId(int buildId) {
			this.buildId = buildId;
		}
		
		public int getBuildId() {
			return buildId;
		}
		
		public int getProjectId() {
			return projectId;
		}
		
		public void setProjectId(int projectId) {
			this.projectId = projectId;
		}
	    
		/**
		 * 取得PayType(付款方式)
		 */
		public String getPayType() {
			return payType;
		}

		/**
		 * 设置payType(付款方式)
		 * @param payType (付款方式)
		 */
		public void setPayType(String payType) {
			this.payType = payType;
		}
	    
		/**
		 * 取得PayName(付款方式名称)
		 */
		public String getPayName() {
			return payName;
		}

		/**
		 * 设置payName(付款方式名称)
		 * @param payName (付款方式名称)
		 */
		public void setPayName(String payName) {
			this.payName = payName;
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
	    
		
		public PayWay(){};


		/**
		 * 
		 * @param id ()
		 * @param projectId (楼盘项目)
		 * @param payType (付款方式)
		 * @param payName (付款方式名称)
		 * @param remark (备注)
		 * @param isDeleted (是否删除)
		 * @param createdId (创建人)
		 * @param createdTime (创建时间)
		 * @param modId (修改人)
		 * @param modTime (修改时间)
		 */
		public PayWay(    
			int id,
			int buildId,
	        		int projectId,
	        		String payType,
	        		String payName,
	        		String remark,
	        		String isDeleted,
	        		int createdId,
	        		Date createdTime,
	        		int modId,
	        		Date modTime
	        ) {
			super();  
			this.id = id;
			this.buildId = buildId;
			this.projectId = projectId;
			this.payType = payType;
			this.payName = payName;
			this.remark = remark;
			this.isDeleted = isDeleted;
			this.createdId = createdId;
			this.createdTime = createdTime;
			this.modId = modId;
			this.modTime = modTime;
		}
	    
		/**
		 * 
		 * @param projectId (楼盘项目)
		 * @param payType (付款方式)
		 * @param payName (付款方式名称)
		 * @param remark (备注)
		 * @param isDeleted (是否删除)
		 * @param createdId (创建人)
		 * @param createdTime (创建时间)
		 * @param modId (修改人)
		 * @param modTime (修改时间)
		 */
		public PayWay(    
				int buildId,
			int projectId,
	        		String payType,
	        		String payName,
	        		String remark,
	        		String isDeleted,
	        		int createdId,
	        		Date createdTime,
	        		int modId,
	        		Date modTime
	        ) {
			super();		
			this.buildId = buildId;
			this.projectId = projectId;
			this.payType = payType;
			this.payName = payName;
			this.remark = remark;
			this.isDeleted = isDeleted;
			this.createdId = createdId;
			this.createdTime = createdTime;
			this.modId = modId;
			this.modTime = modTime;
		}
	    

	//以上由代码生成器生成
	//以下非代码生成器生成,不可覆盖
	
	
	public void initPayDeil(IPayWayDetailServices payWayDetailServices){
		PayWayDetailCond cond = new PayWayDetailCond();
		cond.setWayId(this.getId()+"");
		payWayDetailServices.findPayWayDetail(cond);
	}
	
	public List<PayWayDetail> getPayWayDetailList(){
		
		PayWayDetailCond cond = new PayWayDetailCond();
		cond.setWayId(this.getId()+"");
		List<PayWayDetail> payWayDetailList = MyPropertyUtils.getPayWayDetailServices().findPayWayDetail(cond);
		
		return payWayDetailList;
		
	}
	
	
}
