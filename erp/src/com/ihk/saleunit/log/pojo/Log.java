package com.ihk.saleunit.log.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 操作日志实体类
 * @author Administrator
 *
 */
public class Log implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1146492430193051849L;

	/**
	 * 记录的Id
	 */
	private int id;
	
	/**
	 * 操作的类型
	 */
	private String type;
	
	/**
	 * 操作的模块
	 */
	private String modul;
	
	/**
	 * 分区id
	 */
	private int areaId;
	
	
	/**
	 * 楼栋id
	 */
	private int buildId;
	
	/**
	 * 单元id
	 */
	private int unitId;
	
	
	/**
	 * 操作人员id
	 */
	private int createdId;
	
	/**
	 * 创建时间
	 */
	private Date createdTime;
	/**
	 * 修改用户
	 */
	private int modId;
	/**
	 * 修改时间
	 */
	private Date modTime;
	
	
	/**
	 * 操作内容
	 */
	private String operationProcedure;
	
	/**
	 * 用户计算机信息（包括IP、操作系统用户、操作系统名字）
	 */
	private String computerInformationl;
	
	/**
	 * 是否删除
	 */
	private String isDeleted;
	
	/**
	 * 用户名（表单数据）
	 */
	private String realName;
	/**
	 * 楼盘项目Id
	 */
	private int propertyId;

	/**
	 * 得到记录的Id
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * 设置记录的Id
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 得到操作的类型
	 * @return
	 */
	public String getType() {
		return type;
	}

	/**
	 * 设置操作的类型
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 得到操作的模块
	 * @return
	 */
	public String getModul() {
		return modul;
	}

	/**
	 * 设置操作的模块
	 * @param modul
	 */
	public void setModul(String modul) {
		this.modul = modul;
	}

	/**
	 * 得到分区id
	 * @return
	 */
	public int getAreaId() {
		return areaId;
	}

	/**
	 * 设置分区id
	 * @param areaId
	 */
	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}

	/**
	 * 得到楼栋id
	 * @return
	 */
	public int getBuildId() {
		return buildId;
	}

	/**
	 * 设置楼栋id
	 * @param buildId
	 */
	public void setBuildId(int buildId) {
		this.buildId = buildId;
	}

	/**
	 * 得到分区id
	 * @return
	 */
	public int getUnitId() {
		return unitId;
	}

	/**
	 * 设置分区id
	 * @param unitId
	 */
	public void setUnitId(int unitId) {
		this.unitId = unitId;
	}



	/**
	 * 得到操作内容
	 * @return
	 */
	public String getOperationProcedure() {
		return operationProcedure;
	}

	/**
	 * 设置操作内容
	 * @param operationOProcedure
	 */
	public void setOperationProcedure(String operationProcedure) {
		this.operationProcedure = operationProcedure;
	}

	/**
	 * 得到计算机信息
	 * @return
	 */
	public String getComputerInformationl() {
		return computerInformationl;
	}

	/**
	 * 设置计算机信息
	 * @param computerInformationl
	 */
	public void setComputerInformationl(String computerInformationl) {
		this.computerInformationl = computerInformationl;
	}

	/**
	 * 得到
	 * @return
	 */
	public int getCreatedId() {
		return createdId;
	}

	public void setCreatedId(int createdId) {
		this.createdId = createdId;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public int getModId() {
		return modId;
	}

	public void setModId(int modId) {
		this.modId = modId;
	}

	public Date getModTime() {
		return modTime;
	}

	public void setModTime(Date modTime) {
		this.modTime = modTime;
	}

	public String getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public int getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}
	
	
}
