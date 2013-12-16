package com.ihk.property.data.pojo;

import java.util.Date;
import java.util.List;

import com.ihk.utils.CommonUtils;
import com.ihk.utils.SearchCond;
import com.ihk.utils.SessionUser;

/**
 * 单元对数cond
 * @author dtc
 * 2013-5-27,下午04:59:03
 */
public class PropertyUnitCheckFeeCond extends SearchCond{

	private static final long serialVersionUID = -3785052479861683907L;
	
	/**
	 * 单元id
	 */
	private List<Integer> ids;
	
	/**
	 * 对数日期
	 */
	private Date checkFeeDate;
	
	/**
	 * 对数类型,在EnumUnitCheckfeeType.java中
	 */
	private int checkfeeType;
	
	/**
	 * 修改者id
	 */
	private int modId;
	
	/**
	 * 修改时间
	 */
	private Date modTime;
	
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

	/**
	 * 避免把所有的数据都修改了,如果ids为空就抛出异常
	 * @return
	 */
	public List<Integer> getIds() {
		
		if(CommonUtils.isCollectionEmpty(ids))
			throw new RuntimeException("设置单元对数,ids不能为空");
		
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

	public Date getCheckFeeDate() {
		return checkFeeDate;
	}

	public void setCheckFeeDate(Date checkFeeDate) {
		this.checkFeeDate = checkFeeDate;
	}

	public int getCheckfeeType() {
		return checkfeeType;
	}

	public void setCheckfeeType(int checkfeeType) {
		this.checkfeeType = checkfeeType;
	}
	
	private PropertyUnitCheckFeeCond() {
	}

	public PropertyUnitCheckFeeCond(List<Integer> ids, Date checkFeeDate,
			int checkfeeType) {
		this();
		this.ids = ids;
		this.checkFeeDate = checkFeeDate;
		this.checkfeeType = checkfeeType;
		this.modId = SessionUser.getUserId();
		this.modTime = new Date();
	}
	
}
