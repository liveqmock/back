package com.ihk.setting.data.pojo;

import java.io.Serializable;

/**
 * Province的实体类
 * @author 
 *
 */
public class Province implements Serializable{

	//以下由代码生成器生成,如果手工添加代码，务必写在本代码页面最下方
    
	private static final long serialVersionUID = 4613921775685792757L;
	private int provinceId;
	private String provinceName;
	private int orderIndex;
	private String isDeleted;

	/**
	 * 取得ProvinceId()
	 */
	public int getProvinceId() {
		return provinceId;
	}

	/**
	 * 设置provinceId()
	 * @param provinceId ()
	 */
	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}
    
	/**
	 * 取得ProvinceName()
	 */
	public String getProvinceName() {
		return provinceName;
	}

	/**
	 * 设置provinceName()
	 * @param provinceName ()
	 */
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
    
	/**
	 * 取得OrderIndex()
	 */
	public int getOrderIndex() {
		return orderIndex;
	}

	/**
	 * 设置orderIndex()
	 * @param orderIndex ()
	 */
	public void setOrderIndex(int orderIndex) {
		this.orderIndex = orderIndex;
	}
    
	/**
	 * 取得IsDeleted()
	 */
	public String getIsDeleted() {
		return isDeleted;
	}

	/**
	 * 设置isDeleted()
	 * @param isDeleted ()
	 */
	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}
    
	
	public Province(){};


	/**
	 * 
	 * @param provinceId ()
	 * @param provinceName ()
	 * @param orderIndex ()
	 * @param isDeleted ()
	 */
	public Province(    
		int provinceId,
        		String provinceName,
        		int orderIndex,
        		String isDeleted
        ) {
		super();  
		this.provinceId = provinceId;
		this.provinceName = provinceName;
		this.orderIndex = orderIndex;
		this.isDeleted = isDeleted;
	}
    
	/**
	 * 
	 * @param provinceName ()
	 * @param orderIndex ()
	 * @param isDeleted ()
	 */
	public Province(    
		String provinceName,
        		int orderIndex,
        		String isDeleted
        ) {
		super();		
		this.provinceName = provinceName;
		this.orderIndex = orderIndex;
		this.isDeleted = isDeleted;
	}
    

	//以上由代码生成器生成
	//以下非代码生成器生成,不可覆盖,以下是手工代码
    
}
