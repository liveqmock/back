package com.ihk.saleunit.data.pojo;

import java.io.Serializable;
import java.util.Date;

import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.saleunit.MyPropertyUtils;

/**
 * ExtensionContract的实体类
 * @author 
 *
 */
public class ExtensionContract implements Serializable{
	private static final long serialVersionUID = 1L;

	//以下由代码生成器生成,如果手工添加代码，务必写在本代码页面最下方
    
	private int id;
	private int uid;
	private int cid;
	private Date oldSignDate;
	private Date applyTime;
	private int extensionDay;
	private String extensionFirst;
	private String extensionReason;
	private String approvedMan;
	private Date approvedDay;
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
	 * 取得Uid(单元id)
	 */
	public int getUid() {
		return uid;
	}

	/**
	 * 设置uid(单元id)
	 * @param uid (单元id)
	 */
	public void setUid(int uid) {
		this.uid = uid;
	}
    
	/**
	 * 取得Cid(客户id)
	 */
	public int getCid() {
		return cid;
	}

	/**
	 * 设置cid(客户id)
	 * @param cid (客户id)
	 */
	public void setCid(int cid) {
		this.cid = cid;
	}
    
	/**
	 * 取得OldSignDate(原约定签约日期)
	 */
	public Date getOldSignDate() {
		return oldSignDate;
	}

	/**
	 * 设置oldSignDate(原约定签约日期)
	 * @param oldSignDate (原约定签约日期)
	 */
	public void setOldSignDate(Date oldSignDate) {
		this.oldSignDate = oldSignDate;
	}
    
	/**
	 * 取得ApplyTime(申请日期)
	 */
	public Date getApplyTime() {
		return applyTime;
	}

	/**
	 * 设置applyTime(申请日期)
	 * @param applyTime (申请日期)
	 */
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}
    
	/**
	 * 取得ExtensionDay(延期天数)
	 */
	public int getExtensionDay() {
		return extensionDay;
	}

	/**
	 * 设置extensionDay(延期天数)
	 * @param extensionDay (延期天数)
	 */
	public void setExtensionDay(int extensionDay) {
		this.extensionDay = extensionDay;
	}
    
	/**
	 * 取得ExtensionFirst(是否首次延期)
	 */
	public String getExtensionFirst() {
		return extensionFirst;
	}

	/**
	 * 设置extensionFirst(是否首次延期)
	 * @param extensionFirst (是否首次延期)
	 */
	public void setExtensionFirst(String extensionFirst) {
		this.extensionFirst = extensionFirst;
	}
    
	/**
	 * 取得ExtensionReason(延期原因)
	 */
	public String getExtensionReason() {
		return extensionReason;
	}

	/**
	 * 设置extensionReason(延期原因)
	 * @param extensionReason (延期原因)
	 */
	public void setExtensionReason(String extensionReason) {
		this.extensionReason = extensionReason;
	}
    
	/**
	 * 取得ApprovedMan(批准人)
	 */
	public String getApprovedMan() {
		return approvedMan;
	}

	/**
	 * 设置approvedMan(批准人)
	 * @param approvedMan (批准人)
	 */
	public void setApprovedMan(String approvedMan) {
		this.approvedMan = approvedMan;
	}
    
	/**
	 * 取得ApprovedDay(批准日期)
	 */
	public Date getApprovedDay() {
		return approvedDay;
	}

	/**
	 * 设置approvedDay(批准日期)
	 * @param approvedDay (批准日期)
	 */
	public void setApprovedDay(Date approvedDay) {
		this.approvedDay = approvedDay;
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
    
	
	public ExtensionContract(){};


	/**
	 * 
	 * @param id ()
	 * @param uid (单元id)
	 * @param cid (客户id)
	 * @param oldSignDate (原约定签约日期)
	 * @param applyTime (申请日期)
	 * @param extensionDay (延期天数)
	 * @param extensionFirst (是否首次延期)
	 * @param extensionReason (延期原因)
	 * @param approvedMan (批准人)
	 * @param approvedDay (批准日期)
	 * @param isDeleted (是否删除)
	 * @param createdId (创建人)
	 * @param createdTime (创建时间)
	 * @param modId (修改人)
	 * @param modTime (修改时间)
	 */
	public ExtensionContract(    
		int id,
        		int uid,
        		int cid,
        		Date oldSignDate,
        		Date applyTime,
        		int extensionDay,
        		String extensionFirst,
        		String extensionReason,
        		String approvedMan,
        		Date approvedDay,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime
        ) {
		super();  
		this.id = id;
		this.uid = uid;
		this.cid = cid;
		this.oldSignDate = oldSignDate;
		this.applyTime = applyTime;
		this.extensionDay = extensionDay;
		this.extensionFirst = extensionFirst;
		this.extensionReason = extensionReason;
		this.approvedMan = approvedMan;
		this.approvedDay = approvedDay;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
    
	/**
	 * 
	 * @param uid (单元id)
	 * @param cid (客户id)
	 * @param oldSignDate (原约定签约日期)
	 * @param applyTime (申请日期)
	 * @param extensionDay (延期天数)
	 * @param extensionFirst (是否首次延期)
	 * @param extensionReason (延期原因)
	 * @param approvedMan (批准人)
	 * @param approvedDay (批准日期)
	 * @param isDeleted (是否删除)
	 * @param createdId (创建人)
	 * @param createdTime (创建时间)
	 * @param modId (修改人)
	 * @param modTime (修改时间)
	 */
	public ExtensionContract(    
		int uid,
        		int cid,
        		Date oldSignDate,
        		Date applyTime,
        		int extensionDay,
        		String extensionFirst,
        		String extensionReason,
        		String approvedMan,
        		Date approvedDay,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime
        ) {
		super();		
		this.uid = uid;
		this.cid = cid;
		this.oldSignDate = oldSignDate;
		this.applyTime = applyTime;
		this.extensionDay = extensionDay;
		this.extensionFirst = extensionFirst;
		this.extensionReason = extensionReason;
		this.approvedMan = approvedMan;
		this.approvedDay = approvedDay;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
    

	//以上由代码生成器生成
	//以下非代码生成器生成,不可覆盖,以下是手工代码
    
	
	
	///
	//是否首次延期
	public String getExtensionFirstStr(){
		
		return DescUtils.getTrueOrFalseStr(this.getExtensionFirst());
	}
	
	//改为签约日期
	public String getNewApplyTime(){
		
		return CommonUtils.getAfterDate(this.getOldSignDate(), this.getExtensionDay());
	}
	
	/**
	 * 获取对应的单元
	 * @return
	 */
	public PropertyUnit getUnit(){
		
		PropertyUnit unit = MyPropertyUtils.getPropertyUnitServices().findPropertyUnitById(this.getUid());
		if(unit == null){
			return new PropertyUnit();
		}
		
		return unit;
	}
	
}
