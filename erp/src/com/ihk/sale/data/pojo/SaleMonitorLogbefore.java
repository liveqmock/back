package com.ihk.sale.data.pojo;

import java.util.Date;
import java.math.BigDecimal;
import java.io.Serializable;

/**
 * SaleMonitorLogbefore的实体类
 * @author 
 *
 */
public class SaleMonitorLogbefore implements Serializable{
	private static final long serialVersionUID = 1L;

	//以下由代码生成器生成,如果手工添加代码，务必写在本代码页面最下方
    
	private int id;
	private int dataId;
	private Date modTime;
	private String isRunPlan;

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
	 * 取得DataId(原数据id)
	 */
	public int getDataId() {
		return dataId;
	}

	/**
	 * 设置dataId(原数据id)
	 * @param dataId (原数据id)
	 */
	public void setDataId(int dataId) {
		this.dataId = dataId;
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
    
	/**
	 * 取得IsRunPlan(是否已经运行计划)
	 */
	public String getIsRunPlan() {
		return isRunPlan;
	}

	/**
	 * 设置isRunPlan(是否已经运行计划)
	 * @param isRunPlan (是否已经运行计划)
	 */
	public void setIsRunPlan(String isRunPlan) {
		this.isRunPlan = isRunPlan;
	}
    
	
	public SaleMonitorLogbefore(){};


	/**
	 * 
	 * @param id ()
	 * @param dataId (原数据id)
	 * @param modTime (修改时间)
	 * @param isRunPlan (是否已经运行计划)
	 */
	public SaleMonitorLogbefore(    
		int id,
        		int dataId,
        		Date modTime,
        		String isRunPlan
        ) {
		super();  
		this.id = id;
		this.dataId = dataId;
		this.modTime = modTime;
		this.isRunPlan = isRunPlan;
	}
    
	/**
	 * 
	 * @param dataId (原数据id)
	 * @param modTime (修改时间)
	 * @param isRunPlan (是否已经运行计划)
	 */
	public SaleMonitorLogbefore(    
		int dataId,
        		Date modTime,
        		String isRunPlan
        ) {
		super();		
		this.dataId = dataId;
		this.modTime = modTime;
		this.isRunPlan = isRunPlan;
	}
    

	//以上由代码生成器生成
	//以下非代码生成器生成,不可覆盖,以下是手工代码
    
}
