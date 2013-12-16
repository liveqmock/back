package com.ihk.customer.collection.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * VipCustomer的实体类
 * @author 
 *
 */
public class VipCustomer implements Serializable{
	private static final long serialVersionUID = 1L;
    
	//以下由代码生成器生成,如果手工添加代码，务必写在本代码页面最下方
    
	private int id;
	private String customerNo;
	private String customerName;
	private String source;
	private String idcardNo;
	private String tel;
	private String phone;
	private String contactAddr;
	private String resideArea;
	private String ad_area;
	private String workArea;
	private String natives;
	private Date createTime;
	private Date followDate;
	private Date deal_date;
	private int companyId;

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public Date getDeal_date() {
        return deal_date;
    }

    public void setDeal_date(Date deal_date) {
        this.deal_date = deal_date;
    }

    /**
	 * 取得最后一次跟进日期
	 * @return
	 */
	public Date getFollowDate() {
		return followDate;
	}

	/**
	 * 设置最后一次跟进日期
	 * @param followDate
	 */
	public void setFollowDate(Date followDate) {
		this.followDate = followDate;
	}

	/**
	 * 取得创建日期
	 * @return
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 设置创建日期
	 * @param createTime
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

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
	 * 取得CustomerNo(客户编号)
	 */
	public String getCustomerNo() {
		return customerNo;
	}

	/**
	 * 设置customerNo(客户编号)
	 * @param customerNo (客户编号)
	 */
	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}
    
	/**
	 * 取得CustomerName(客户姓名)
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * 设置customerName(客户姓名)
	 * @param customerName (客户姓名)
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
    
	/**
	 * 取得Source(来源)
	 */
	public String getSource() {
		return source;
	}

	/**
	 * 设置source(来源)
	 * @param source (来源)
	 */
	public void setSource(String source) {
		this.source = source;
	}
    
	/**
	 * 取得IdcardNo(身份证)
	 */
	public String getIdcardNo() {
		return idcardNo;
	}

	/**
	 * 设置idcardNo(身份证)
	 * @param idcardNo (身份证)
	 */
	public void setIdcardNo(String idcardNo) {
		this.idcardNo = idcardNo;
	}
    
	/**
	 * 取得Tel(固话)
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * 设置tel(固话)
	 * @param tel (固话)
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}
    
	/**
	 * 取得Phone(移动电话)
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * 设置phone(移动电话)
	 * @param phone (移动电话)
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
    
	/**
	 * 取得ContactAddr(联系地址)
	 */
	public String getContactAddr() {
		return contactAddr;
	}

	/**
	 * 设置contactAddr(联系地址)
	 * @param contactAddr (联系地址)
	 */
	public void setContactAddr(String contactAddr) {
		this.contactAddr = contactAddr;
	}
    
	/**
	 * 取得ResideArea(居住区域)
	 */
	public String getResideArea() {
		return resideArea;
	}

	/**
	 * 设置resideArea(居住区域)
	 * @param resideArea (居住区域)
	 */
	public void setResideArea(String resideArea) {
		this.resideArea = resideArea;
	}
    
	/**
	 * 取得WorkArea(工作区域)
	 */
	public String getWorkArea() {
		return workArea;
	}

	/**
	 * 设置workArea(工作区域)
	 * @param workArea (工作区域)
	 */
	public void setWorkArea(String workArea) {
		this.workArea = workArea;
	}
    
	/**
	 * 取得Natives(户籍)
	 */
	public String getNatives() {
		return natives;
	}

	/**
	 * 设置natives(户籍)
	 * @param natives (户籍)
	 */
	public void setNatives(String natives) {
		this.natives = natives;
	}

    public String getAd_area() {
        return ad_area;
    }

    public void setAd_area(String ad_area) {
        this.ad_area = ad_area;
    }

    public VipCustomer(){};


	/**
	 * 
	 * @param id ()
	 * @param customerNo (客户编号)
	 * @param custmoerName (客户姓名)
	 * @param source (来源)
	 * @param idcardNo (身份证)
	 * @param tel (固话)
	 * @param phone (移动电话)
	 * @param contactAddr (联系地址)
	 * @param resideArea (居住区域)
	 * @param workArea (工作区域)
	 * @param ad_area (行政区域)
	 * @param natives (户籍)
	 * @param deal_date (交易日期)
	 */
	public VipCustomer(    
		int id,
        		String customerNo,
        		String custmoerName,
        		String source,
        		String idcardNo,
        		String tel,
        		String phone,
        		String contactAddr,
        		String resideArea,
        		String workArea,
        		String ad_area,
        		String natives,
                Date deal_date
        ) {
		super();  
		this.id = id;
		this.customerNo = customerNo;
		this.customerName = custmoerName;
		this.source = source;
		this.idcardNo = idcardNo;
		this.tel = tel;
		this.phone = phone;
		this.contactAddr = contactAddr;
		this.resideArea = resideArea;
		this.workArea = workArea;
		this.ad_area = ad_area;
		this.natives = natives;
        this.deal_date = deal_date;
	}
    
	/**
	 * 
	 * @param customerNo (客户编号)
	 * @param custmoerName (客户姓名)
	 * @param source (来源)
	 * @param idcardNo (身份证)
	 * @param tel (固话)
	 * @param phone (移动电话)
	 * @param contactAddr (联系地址)
	 * @param resideArea (居住区域)
	 * @param workArea (工作区域)
	 * @param ad_area (行政区域)
	 * @param natives (户籍)
	 * @param deal_date (交易日期)
	 */
	public VipCustomer(    
		String customerNo,
        		String custmoerName,
        		String source,
        		String idcardNo,
        		String tel,
        		String phone,
        		String contactAddr,
        		String resideArea,
        		String workArea,
        		String ad_area,
        		String natives,
        		Date deal_date
        ) {
		super();		
		this.customerNo = customerNo;
		this.customerName = custmoerName;
		this.source = source;
		this.idcardNo = idcardNo;
		this.tel = tel;
		this.phone = phone;
		this.contactAddr = contactAddr;
		this.resideArea = resideArea;
		this.workArea = workArea;
		this.ad_area = ad_area;
		this.natives = natives;
		this.deal_date = deal_date;
	}
    

	//以上由代码生成器生成
	//以下非代码生成器生成,不可覆盖,以下是手工代码
    
}
