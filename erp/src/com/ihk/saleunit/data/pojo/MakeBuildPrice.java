package com.ihk.saleunit.data.pojo;

import java.util.Date;
import java.math.BigDecimal;
import java.io.Serializable;

import com.ihk.utils.DescUtils;

/**
 * MakeBuildPrice的实体类
 * @author 
 *
 */
public class MakeBuildPrice implements Serializable{
	private static final long serialVersionUID = 1L;

	//以下由代码生成器生成,如果手工添加代码，务必写在本代码页面最下方
    
	private int id;
	private int buildId;
	private String remark;
	private String fileSrc;
	private String isEffect;
	private int doUser;
	private String doRemark;
	private Date doTime;
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
	 * 取得BuildId(楼栋ID)
	 */
	public int getBuildId() {
		return buildId;
	}

	/**
	 * 设置buildId(楼栋ID)
	 * @param buildId (楼栋ID)
	 */
	public void setBuildId(int buildId) {
		this.buildId = buildId;
	}
    
	/**
	 * 取得Remark(说明)
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 设置remark(说明)
	 * @param remark (说明)
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
    
	/**
	 * 取得FileSrc(文档路径)
	 */
	public String getFileSrc() {
		return fileSrc;
	}

	/**
	 * 设置fileSrc(文档路径)
	 * @param fileSrc (文档路径)
	 */
	public void setFileSrc(String fileSrc) {
		this.fileSrc = fileSrc;
	}
    
	/**
	 * 取得IsEffect(是否生效)
	 */
	public String getIsEffect() {
		return isEffect;
	}

	/**
	 * 设置isEffect(是否生效)
	 * @param isEffect (是否生效)
	 */
	public void setIsEffect(String isEffect) {
		this.isEffect = isEffect;
	}
    
	/**
	 * 取得DoUser(启用人)
	 */
	public int getDoUser() {
		return doUser;
	}

	/**
	 * 设置doUser(启用人)
	 * @param doUser (启用人)
	 */
	public void setDoUser(int doUser) {
		this.doUser = doUser;
	}
    
	/**
	 * 取得DoRemark(启用说明)
	 */
	public String getDoRemark() {
		return doRemark;
	}

	/**
	 * 设置doRemark(启用说明)
	 * @param doRemark (启用说明)
	 */
	public void setDoRemark(String doRemark) {
		this.doRemark = doRemark;
	}
    
	/**
	 * 取得DoTime(启用时间)
	 */
	public Date getDoTime() {
		return doTime;
	}

	/**
	 * 设置doTime(启用时间)
	 * @param doTime (启用时间)
	 */
	public void setDoTime(Date doTime) {
		this.doTime = doTime;
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
    
	
	public MakeBuildPrice(){};


	/**
	 * 
	 * @param id ()
	 * @param buildId (楼栋ID)
	 * @param remark (说明)
	 * @param fileSrc (文档路径)
	 * @param isEffect (是否生效)
	 * @param doUser (启用人)
	 * @param doRemark (启用说明)
	 * @param doTime (启用时间)
	 * @param isDeleted (是否删除)
	 * @param createdId (创建人)
	 * @param createdTime (创建时间)
	 * @param modId (修改人)
	 * @param modTime (修改时间)
	 */
	public MakeBuildPrice(    
		int id,
        		int buildId,
        		String remark,
        		String fileSrc,
        		String isEffect,
        		int doUser,
        		String doRemark,
        		Date doTime,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime
        ) {
		super();  
		this.id = id;
		this.buildId = buildId;
		this.remark = remark;
		this.fileSrc = fileSrc;
		this.isEffect = isEffect;
		this.doUser = doUser;
		this.doRemark = doRemark;
		this.doTime = doTime;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
    
	/**
	 * 
	 * @param buildId (楼栋ID)
	 * @param remark (说明)
	 * @param fileSrc (文档路径)
	 * @param isEffect (是否生效)
	 * @param doUser (启用人)
	 * @param doRemark (启用说明)
	 * @param doTime (启用时间)
	 * @param isDeleted (是否删除)
	 * @param createdId (创建人)
	 * @param createdTime (创建时间)
	 * @param modId (修改人)
	 * @param modTime (修改时间)
	 */
	public MakeBuildPrice(    
		int buildId,
        		String remark,
        		String fileSrc,
        		String isEffect,
        		int doUser,
        		String doRemark,
        		Date doTime,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime
        ) {
		super();		
		this.buildId = buildId;
		this.remark = remark;
		this.fileSrc = fileSrc;
		this.isEffect = isEffect;
		this.doUser = doUser;
		this.doRemark = doRemark;
		this.doTime = doTime;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
    

	//以上由代码生成器生成
	//以下非代码生成器生成,不可覆盖,以下是手工代码
    
	
	public static final String IS_DEFFECT_YES = "1";
	public static final String IS_DEFFECT_NO = "0";
	
	
	
	public String getCreatedIdStr(){
		return createdId == 0 ? "" : DescUtils.getUserRealName(createdId);
	}
	public String getDoUserStr(){
		return doUser == 0 ? "":DescUtils.getUserRealName(doUser);
	}
	public String getIsEffectStr(){
		return isEffect.equals(MakeBuildPrice.IS_DEFFECT_NO) ? "未启用":"已启用";
	}
}
