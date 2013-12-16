package com.ihk.saleunit.data.pojo;

import java.util.Date;
import java.math.BigDecimal;
import java.io.Serializable;

import com.ihk.constanttype.EnumChangeType;
import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.utils.DescUtils;

/**
 * ApprovalChange的实体类
 * @author 
 *
 */
public class ApprovalChange implements Serializable{
	private static final long serialVersionUID = 1L;

	//以下由代码生成器生成,如果手工添加代码，务必写在本代码页面最下方
    
	private int id;
	private int applyId;
	private String applyType;
	private String approvalDesc;
	private int approvalMan;
	private Date approvalDate;
	private int doMan;
	private Date doDate;
	private String approvalState;
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
	 * 取得ApplyId(申请id)
	 */
	public int getApplyId() {
		return applyId;
	}

	/**
	 * 设置applyId(申请id)
	 * @param applyId (申请id)
	 */
	public void setApplyId(int applyId) {
		this.applyId = applyId;
	}
    
	/**
	 * 取得ApplyType(申请类型)
	 */
	public String getApplyType() {
		return applyType;
	}

	/**
	 * 设置applyType(申请类型)
	 * @param applyType (申请类型)
	 */
	public void setApplyType(String applyType) {
		this.applyType = applyType;
	}
    
	/**
	 * 取得ApprovalDesc(审批意见)
	 */
	public String getApprovalDesc() {
		return approvalDesc;
	}

	/**
	 * 设置approvalDesc(审批意见)
	 * @param approvalDesc (审批意见)
	 */
	public void setApprovalDesc(String approvalDesc) {
		this.approvalDesc = approvalDesc;
	}
    
	/**
	 * 取得ApprovalMan(批准人id)
	 */
	public int getApprovalMan() {
		return approvalMan;
	}

	/**
	 * 设置approvalMan(批准人id)
	 * @param approvalMan (批准人id)
	 */
	public void setApprovalMan(int approvalMan) {
		this.approvalMan = approvalMan;
	}
    
	/**
	 * 取得ApprovalDate(批准日期)
	 */
	public Date getApprovalDate() {
		return approvalDate;
	}

	/**
	 * 设置approvalDate(批准日期)
	 * @param approvalDate (批准日期)
	 */
	public void setApprovalDate(Date approvalDate) {
		this.approvalDate = approvalDate;
	}
    
	/**
	 * 取得DoMan(执行人id)
	 */
	public int getDoMan() {
		return doMan;
	}

	/**
	 * 设置doMan(执行人id)
	 * @param doMan (执行人id)
	 */
	public void setDoMan(int doMan) {
		this.doMan = doMan;
	}
    
	/**
	 * 取得DoDate(执行日期)
	 */
	public Date getDoDate() {
		return doDate;
	}

	/**
	 * 设置doDate(执行日期)
	 * @param doDate (执行日期)
	 */
	public void setDoDate(Date doDate) {
		this.doDate = doDate;
	}
    
	/**
	 * 取得ApprovalState(审批状态)
	 */
	public String getApprovalState() {
		return approvalState;
	}

	/**
	 * 设置approvalState(审批状态)
	 * @param approvalState (审批状态)
	 */
	public void setApprovalState(String approvalState) {
		this.approvalState = approvalState;
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
    
	
	public ApprovalChange(){};


	/**
	 * 
	 * @param id ()
	 * @param applyId (申请id)
	 * @param applyType (申请类型)
	 * @param approvalDesc (审批意见)
	 * @param approvalMan (批准人id)
	 * @param approvalDate (批准日期)
	 * @param doMan (执行人id)
	 * @param doDate (执行日期)
	 * @param approvalState (审批状态)
	 * @param isDeleted (是否删除)
	 * @param createdId (创建人)
	 * @param createdTime (创建时间)
	 * @param modId (修改人)
	 * @param modTime (修改时间)
	 */
	public ApprovalChange(    
		int id,
        		int applyId,
        		String applyType,
        		String approvalDesc,
        		int approvalMan,
        		Date approvalDate,
        		int doMan,
        		Date doDate,
        		String approvalState,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime
        ) {
		super();  
		this.id = id;
		this.applyId = applyId;
		this.applyType = applyType;
		this.approvalDesc = approvalDesc;
		this.approvalMan = approvalMan;
		this.approvalDate = approvalDate;
		this.doMan = doMan;
		this.doDate = doDate;
		this.approvalState = approvalState;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
    
	/**
	 * 
	 * @param applyId (申请id)
	 * @param applyType (申请类型)
	 * @param approvalDesc (审批意见)
	 * @param approvalMan (批准人id)
	 * @param approvalDate (批准日期)
	 * @param doMan (执行人id)
	 * @param doDate (执行日期)
	 * @param approvalState (审批状态)
	 * @param isDeleted (是否删除)
	 * @param createdId (创建人)
	 * @param createdTime (创建时间)
	 * @param modId (修改人)
	 * @param modTime (修改时间)
	 */
	public ApprovalChange(    
		int applyId,
        		String applyType,
        		String approvalDesc,
        		int approvalMan,
        		Date approvalDate,
        		int doMan,
        		Date doDate,
        		String approvalState,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime
        ) {
		super();		
		this.applyId = applyId;
		this.applyType = applyType;
		this.approvalDesc = approvalDesc;
		this.approvalMan = approvalMan;
		this.approvalDate = approvalDate;
		this.doMan = doMan;
		this.doDate = doDate;
		this.approvalState = approvalState;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
    

	//以上由代码生成器生成
	//以下非代码生成器生成,不可覆盖,以下是手工代码
    
	
	
	

	public String getDescApplyType(){
		if(applyType == null || applyType.equals(""))return "";
		if(applyType.equals( EnumChangeType.CHANGE_OUT.toString()))return "退房";
		if(applyType.equals( EnumChangeType.CHANGE_OWNER.toString()))return "变更权益人";
		if(applyType.equals( EnumChangeType.CHANGE_PRICE.toString()))return "变更价格";
		if(applyType.equals( EnumChangeType.CHANGE_UNIT.toString()))return "换房";
		return "";
	}
	

	public String getDescDoMan() {
		if(doMan == 0)return "";
		return DescUtils.getUserRealName(doMan);
	}

	public String getDescApprovalState(){
		if(approvalState == null || approvalState.equals(""))return "";
		String rt;
		switch (Integer.parseInt(approvalState)) {
		case 1:
			rt = "待审批";
			break;
		case 2:
			rt = "已审批";
			break;
		case 3:
			rt = "未通过";
			break;
		default:
			rt = "";
			break;
		}
		return rt;
	}
}
