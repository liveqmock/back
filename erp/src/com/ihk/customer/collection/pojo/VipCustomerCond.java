package com.ihk.customer.collection.pojo;

import java.util.Date;

import com.ihk.utils.SearchCond;

/**
 * VipCustomer的查询条件
 * @author 
 *
 */
public class VipCustomerCond extends SearchCond{

	private static final long serialVersionUID = 1L;
    
	private int id;					//id
	
	private String customerName; 	//客户姓名
	
	private String phone;  			//移动电话
	
	private String workArea;		//工作区域
	
	private String contactAddr;     //联系地址
	
	private String notFollowDay;	//未跟进天数
	
	private String customerNo;		//客户编号
			
	private String source;			//来源
	
	private String date1,date2;     //创建日期
	
	private String follow1,follow2; //跟进日期
	
	private String idcardNo;		//身份证号
	
	private String paymethod;		//付款方式
	
	private String adArea;			//行政区域
	
	private String businesscircle;	//商圈
	private String natives;	//户籍

    private String sort;  //排序字段
    private String order;  //asc or desc
    private int companyId;

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getNatives() {
        return natives;
    }

    public void setNatives(String natives) {
        this.natives = natives;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getPaymethod() {
		return paymethod;
	}

	public void setPaymethod(String paymethod) {
		this.paymethod = paymethod;
	}

	public String getAdArea() {
		return adArea;
	}

	public void setAdArea(String adArea) {
		this.adArea = adArea;
	}

	public String getBusinesscircle() {
		return businesscircle;
	}

	public void setBusinesscircle(String businesscircle) {
		this.businesscircle = businesscircle;
	}

	public String getIdcardNo() {
		return idcardNo;
	}

	public void setIdcardNo(String idcardNo) {
		this.idcardNo = idcardNo;
	}

	public int getId() {
		return id;
	}

	public String getDate1() {
		return date1;
	}

	public void setDate1(String date1) {
		this.date1 = date1;
	}

	public String getDate2() {
		return date2;
	}

	public void setDate2(String date2) {
		this.date2 = date2;
	}

	public String getFollow1() {
		return follow1;
	}

	public void setFollow1(String follow1) {
		this.follow1 = follow1;
	}

	public String getFollow2() {
		return follow2;
	}

	public void setFollow2(String follow2) {
		this.follow2 = follow2;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getWorkArea() {
		return workArea;
	}

	public void setWorkArea(String workArea) {
		this.workArea = workArea;
	}

	public String getContactAddr() {
		return contactAddr;
	}

	public void setContactAddr(String contactAddr) {
		this.contactAddr = contactAddr;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getNotFollowDay() {
		return notFollowDay;
	}

	public void setNotFollowDay(String notFollowDay) {
		this.notFollowDay = notFollowDay;
	}

	public String getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}
 
}
