package com.ihk.junit.import_cus.hubei.th;

import java.io.Serializable;

/**
 * 天鸿美庐来访客户bean
 * @author dtc
 * 2013-8-20,下午03:11:52
 */
public class ThLaiFanBean implements Serializable{

	private static final long serialVersionUID = 6257876267716849224L;
	
	/**
	 * 来访日期
	 */
	private String visitDate;
	
	/**
	 * 客户姓名
	 */
	private String customerName;
	
	/**
	 * 电话
	 */
	private String phone;
	
	/**
	 * 年龄
	 */
	private String age;
	
	/**
	 * 需求户型
	 */
	private String roomType;
	
	/**
	 * 居住区域输入框, homeContent
	 */
	private String homeContent;
	
	/**
	 * 工作区域输入框
	 */
	private String workContent;
	
	/**
	 * 单位性质,职业
	 */
	private String jobIndustry;
	
	/**
	 * 获知途径
	 */
	private String[] knownFroms;
	
	/**
	 * 需求面积
	 */
	private int areaNum;
	
	/**
	 * 商铺总价承受情况,意向总价
	 */
	private int priceNum;
	
	/**
	 * 家庭汽车,手填
	 */
	private String trafficDesc;
	
	/**
	 * 置业用途
	 */
	private String buyUse;
	
	/**
	 * 关注点
	 */
	private String[] customerFocus;
	
	/**
	 * 备注,对应 其他
	 */
	private String remark1;
	
	/**
	 * 家庭结构
	 */
	private String familyType;
	
	/**
	 * 置业次数
	 */
	private String buyCount;
	
	/**
	 * 客户评级
	 */
	private String rating;
	
	public void setRating(String rating) {
		this.rating = rating;
	}
	
	public String getRating() {
		return rating;
	}
	
	public void setBuyCount(String buyCount) {
		this.buyCount = buyCount;
	}
	
	public String getBuyCount() {
		return buyCount;
	}
	
	public void setFamilyType(String familyType) {
		this.familyType = familyType;
	}
	
	public String getFamilyType() {
		return familyType;
	}
	
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	
	public String getRoomType() {
		return roomType;
	}

	public String getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(String visitDate) {
		this.visitDate = visitDate;
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

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getHomeContent() {
		return homeContent;
	}

	public void setHomeContent(String homeContent) {
		this.homeContent = homeContent;
	}

	public String getWorkContent() {
		return workContent;
	}

	public void setWorkContent(String workContent) {
		this.workContent = workContent;
	}

	public String getJobIndustry() {
		return jobIndustry;
	}

	public void setJobIndustry(String jobIndustry) {
		this.jobIndustry = jobIndustry;
	}

	public String[] getKnownFroms() {
		return knownFroms;
	}

	public void setKnownFroms(String[] knownFroms) {
		this.knownFroms = knownFroms;
	}

	public int getAreaNum() {
		return areaNum;
	}

	public void setAreaNum(int areaNum) {
		this.areaNum = areaNum;
	}

	public int getPriceNum() {
		return priceNum;
	}

	public void setPriceNum(int priceNum) {
		this.priceNum = priceNum;
	}

	public String getTrafficDesc() {
		return trafficDesc;
	}

	public void setTrafficDesc(String trafficDesc) {
		this.trafficDesc = trafficDesc;
	}

	public String getBuyUse() {
		return buyUse;
	}

	public void setBuyUse(String buyUse) {
		this.buyUse = buyUse;
	}

	public String[] getCustomerFocus() {
		return customerFocus;
	}

	public void setCustomerFocus(String[] customerFocus) {
		this.customerFocus = customerFocus;
	}

	public String getRemark1() {
		return remark1;
	}

	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}

}
