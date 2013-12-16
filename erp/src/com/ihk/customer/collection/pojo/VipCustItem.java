package com.ihk.customer.collection.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * VipCustItem的实体类
 * @author
 *
 */
public class VipCustItem implements Serializable{
    private static final long serialVersionUID = 1L;

    //以下由代码生成器生成,如果手工添加代码，务必写在本代码页面最下方

    private int id;
    private String projectName;
    private Double total;
    private Double areaSize;
    private String paymethod;
    private String adArea;
    private String businesscircle;
    private String constructtype;
    private String area;
    private String building;
    private String floor;
    private String room_no;
    private Double construction_area;
    private int refId;
    private String customerNo;

    //导入数据被拆分保存
    //在item 中记录原始资料的基本信息方便显示
    private String source;
    private String customer_name;
    private String idcard_no;
    private String tel;
    private String phone;
    private String attribute;
    private Date createdate;
    private Date deal_date;
    private String natives;
    private String reside_area;
    private String word_area;
    private int companyId;


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
     * 取得ProjectName(项目名)
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * 设置projectName(项目名)
     * @param projectName (项目名)
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
     * 取得Total(购买总价)
     */
    public Double getTotal() {
        return total;
    }

    /**
     * 设置total(购买总价)
     * @param total (购买总价)
     */
    public void setTotal(Double total) {
        this.total = total;
    }

    /**
     * 取得AreaSize(购买面积)
     */
    public Double getAreaSize() {
        return areaSize;
    }

    /**
     * 设置areaSize(购买面积)
     * @param areaSize (购买面积)
     */
    public void setAreaSize(Double areaSize) {
        this.areaSize = areaSize;
    }

    /**
     * 取得Paymethod(付款方式)
     */
    public String getPaymethod() {
        return paymethod;
    }

    /**
     * 设置paymethod(付款方式)
     * @param paymethod (付款方式)
     */
    public void setPaymethod(String paymethod) {
        this.paymethod = paymethod;
    }

    /**
     * 取得AdArea(行政区域)
     */
    public String getAdArea() {
        return adArea;
    }

    /**
     * 设置adArea(行政区域)
     * @param adArea (行政区域)
     */
    public void setAdArea(String adArea) {
        this.adArea = adArea;
    }

    /**
     * 取得Businesscircle(商圈)
     */
    public String getBusinesscircle() {
        return businesscircle;
    }

    /**
     * 设置businesscircle(商圈)
     * @param businesscircle (商圈)
     */
    public void setBusinesscircle(String businesscircle) {
        this.businesscircle = businesscircle;
    }

    /**
     * 取得Constructtype(类型)
     */
    public String getConstructtype() {
        return constructtype;
    }

    /**
     * 设置constructtype(类型)
     * @param constructtype (类型)
     */
    public void setConstructtype(String constructtype) {
        this.constructtype = constructtype;
    }

    /**
     * 取得RefId(关联id)
     */
    public int getRefId() {
        return refId;
    }

    /**
     * 设置refId(关联id)
     * @param refId (关联id)
     */
    public void setRefId(int refId) {
        this.refId = refId;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getRoom_no() {
        return room_no;
    }

    public void setRoom_no(String room_no) {
        this.room_no = room_no;
    }

    public Double getConstruction_area() {
        return construction_area;
    }

    public void setConstruction_area(Double construction_area) {
        this.construction_area = construction_area;
    }

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getIdcard_no() {
        return idcard_no;
    }

    public void setIdcard_no(String idcard_no) {
        this.idcard_no = idcard_no;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getDeal_date() {
        return deal_date;
    }

    public void setDeal_date(Date deal_date) {
        this.deal_date = deal_date;
    }

    public String getNatives() {
        return natives;
    }

    public void setNatives(String natives) {
        this.natives = natives;
    }

    public String getReside_area() {
        return reside_area;
    }

    public void setReside_area(String reside_area) {
        this.reside_area = reside_area;
    }

    public String getWord_area() {
        return word_area;
    }

    public void setWord_area(String word_area) {
        this.word_area = word_area;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public VipCustItem(){};


    /**
     *
     * @param id ()
     * @param projectName (项目名)
     * @param total (购买总价)
     * @param areaSize (购买面积)
     * @param paymethod (付款方式)
     * @param adArea (行政区域)
     * @param businesscircle (商圈)
     * @param constructtype (类型)
     * @param building (楼栋)
     * @param floor (楼层)
     * @param room_no (房号)
     * @param construction_area (建筑面积)
     * @param refId (关联id)
     * @param customerNo (关联imp id)
     */
    public VipCustItem(
            int id,
            String projectName,
            Double total,
            Double areaSize,
            String paymethod,
            String adArea,
            String businesscircle,
            String constructtype,
            String building,
            String floor,
            String room_no,
            Double construction_area,
            int refId,
            String customerNo
    ) {
        super();
        this.id = id;
        this.projectName = projectName;
        this.total = total;
        this.areaSize = areaSize;
        this.paymethod = paymethod;
        this.adArea = adArea;
        this.businesscircle = businesscircle;
        this.constructtype = constructtype;
        this.building = building;
        this.floor = floor;
        this.room_no = room_no;
        this.construction_area = construction_area;
        this.refId = refId;
        this.customerNo = customerNo;
    }

    /**
     *
     * @param projectName (项目名)
     * @param total (购买总价)
     * @param areaSize (购买面积)
     * @param paymethod (付款方式)
     * @param adArea (行政区域)
     * @param businesscircle (商圈)
     * @param constructtype (类型)
     * @param building (楼栋)
     * @param floor (楼层)
     * @param room_no (房号)
     * @param construction_area (建筑面积)
     * @param refId (关联id)
     * @param customerNo (关联 imp id)
     */
    public VipCustItem(
            String projectName,
            Double total,
            Double areaSize,
            String paymethod,
            String adArea,
            String businesscircle,
            String constructtype,
            String building,
            String floor,
            String room_no,
            Double construction_area,
            int refId,
            String customerNo
    ) {
        super();
        this.projectName = projectName;
        this.total = total;
        this.areaSize = areaSize;
        this.paymethod = paymethod;
        this.adArea = adArea;
        this.businesscircle = businesscircle;
        this.constructtype = constructtype;
        this.building = building;
        this.floor = floor;
        this.room_no = room_no;
        this.construction_area = construction_area;
        this.refId = refId;
        this.customerNo = customerNo;
    }


    //以上由代码生成器生成
    //以下非代码生成器生成,不可覆盖,以下是手工代码

}
