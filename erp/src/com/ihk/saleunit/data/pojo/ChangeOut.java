package com.ihk.saleunit.data.pojo;

import java.util.Date;
import java.math.BigDecimal;
import java.io.Serializable;

import com.ihk.utils.DescUtils;

/**
 * ChangeOut的实体类
 * @author 
 *
 */
public class ChangeOut implements Serializable {
	private static final long serialVersionUID = 1L;

	//以下由代码生成器生成,如果手工添加代码，务必写在本代码页面最下方
    
	private int id;
	private String confirmType;
	private int mainId;
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
    
	
	public ChangeOut(){};


	/**
	 * 
	 * @param id ()
	 * @param confirmType (认购或合同)
	 * @param mainId (主单id)
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
	public ChangeOut(    
		int id,
        		String confirmType,
        		int mainId,
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
	public ChangeOut(    
		String confirmType,
        		int mainId,
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
    
	

	public String getDescApplyUser() {
		if (this.applyUser == 0)
			return "";
		return DescUtils.getUserRealName(applyUser);
	}
	
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
}
