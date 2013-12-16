package com.ihk.saleunit.data.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.ihk.constanttype.ContConfirmType;
import com.ihk.constanttype.ContProjectId;
import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.DescUtils;

/**
 * 客户交易明细(项目)对应的类
 * @author dtc
 * 2013-2-20,下午02:13:27
 */
public class ContractCustConfirm implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;
	
	private String confirmType;
	
	private String projectName;
	
	private String buildName;
	
	private String unitNo;
	
	private BigDecimal buildArea;
	
	private String agreeNo;
	
	private Date workDate;
	
	private BigDecimal sumMoney;
	
	private String customerName;
	
	private String gender;
	
	private String idcardType;
	
	private String idcardNo;
	
	private String address;
	
	private String phone;
	
	private int cid;
	
	private String area;
	
	private String floor;
	
	private String insideArea;
	
	private String payType;
	
	private String homePhone;
	
	private int householdProvince;
	
	private int householdCity;
	
	private int householdRegion;
	
	private int homeProvince;
	
	private int homeCity;
	
	private int homeRegion;
	
	private String home;
	
	private String household;
	
	private String areaName;
	
	
	
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getInsideArea() {
		return insideArea;
	}

	public void setInsideArea(String insideArea) {
		this.insideArea = insideArea;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setConfirmType(String confirmType) {
		this.confirmType = confirmType;
	}
	
	public String getConfirmType() {
		return confirmType;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getBuildName() {
		return buildName;
	}

	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}

	public String getUnitNo() {
		return unitNo;
	}

	public void setUnitNo(String unitNo) {
		this.unitNo = unitNo;
	}

	public BigDecimal getBuildArea() {
		return buildArea;
	}

	public void setBuildArea(BigDecimal buildArea) {
		this.buildArea = buildArea;
	}

	public String getAgreeNo() {
		return agreeNo;
	}

	public void setAgreeNo(String agreeNo) {
		this.agreeNo = agreeNo;
	}

	public Date getWorkDate() {
		return workDate;
	}

	public void setWorkDate(Date workDate) {
		this.workDate = workDate;
	}

	public BigDecimal getSumMoney() {
		return sumMoney;
	}
	
	public void setSumMoney(BigDecimal sumMoney) {
		this.sumMoney = sumMoney;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getIdcardType() {
		return idcardType;
	}

	public void setIdcardType(String idcardType) {
		this.idcardType = idcardType;
	}

	public String getIdcardNo() {
		return idcardNo;
	}

	public void setIdcardNo(String idcardNo) {
		this.idcardNo = idcardNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}




	public ContractCustConfirm(String projectName, String buildName,
			String unitNo, BigDecimal buildArea, String agreeNo, Date workDate,
			BigDecimal sumMoney, String customerName, String gender,
			String idcardType, String idcardNo, String address, String phone) {
		super();
		this.projectName = projectName;
		this.buildName = buildName;
		this.unitNo = unitNo;
		this.buildArea = buildArea;
		this.agreeNo = agreeNo;
		this.workDate = workDate;
		this.sumMoney = sumMoney;
		this.customerName = customerName;
		this.gender = gender;
		this.idcardType = idcardType;
		this.idcardNo = idcardNo;
		this.address = address;
		this.phone = phone;
	}

	public ContractCustConfirm() {
		super();
	}
	
	////
	public String getIdcardTypeStr(){
		if(this.getIdcardType()!=null&&this.getIdcardType().split(" ").length>1){
			String idcardTypeStr="";
			for(String s :this.getIdcardType().split(" ")){
				idcardTypeStr=idcardTypeStr+DescUtils.getCodeDesc(EnumCodeTypeName.SALEUNIT_IDCARD_TYPE, s, ContProjectId.GUANG_ZHOU)+" ";
			}
			return idcardTypeStr;
		}else{
			return DescUtils.getCodeDesc(EnumCodeTypeName.SALEUNIT_IDCARD_TYPE, this.getIdcardType().split(" ")[0], ContProjectId.GUANG_ZHOU);
		}
		
		
	}
	
	public String getGenderStr(){
		if(this.getGender()!=null&&this.getGender().split(" ").length>1){
			String genderStr="";
			for(String s :this.getGender().split(" ")){
				genderStr=genderStr+DescUtils.getCodeDesc(EnumCodeTypeName.GENDER, s, ContProjectId.GUANG_ZHOU)+" ";
			}
			return genderStr;
		}else{
			return DescUtils.getCodeDesc(EnumCodeTypeName.GENDER, this.getGender().split(" ")[0], ContProjectId.GUANG_ZHOU);
		}
		
	}
	
	public String getConfirmTypeStr(){
		
		if(ContConfirmType.CONTRACT.equals(this.getConfirmType())){
			
			return ContConfirmType.CONTRACT_STR_CN;
		}
		
		return ContConfirmType.CONFIRM_STR_CN;
	}
	
	public String getWorkDateStr(){
		
		if(this.getWorkDate() != null){
			
			return CommonUtils.getDateString(this.getWorkDate());
		}
		
		return "";
	}
	
	public String getHome(){
		String province = DescUtils.findProvinceById(homeProvince).getProvinceName()==null?"":DescUtils.findProvinceById(homeProvince).getProvinceName();
		String city	= DescUtils.findCityById(homeCity).getCityName()==null?"":DescUtils.findCityById(homeCity).getCityName();
		String region = DescUtils.findRegionById(homeRegion).getRegionName()==null?"":DescUtils.findRegionById(homeRegion).getRegionName();
		home = province + city + region ;
		return home;
	}
	
	public String getHousehold(){
		
		String province = DescUtils.findProvinceById(householdProvince).getProvinceName()==null?"":DescUtils.findProvinceById(householdProvince).getProvinceName();
		String city =  DescUtils.findCityById(householdCity).getCityName()==null?"":DescUtils.findCityById(householdCity).getCityName();
		String region =	DescUtils.findRegionById(householdRegion).getRegionName()==null?"":DescUtils.findRegionById(householdRegion).getRegionName();
		household = province + city + region;
		return household;
	}
	
}
