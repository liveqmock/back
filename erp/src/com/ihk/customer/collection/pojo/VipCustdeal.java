package com.ihk.customer.collection.pojo;

import java.util.Date;
import java.math.BigDecimal;
import java.io.Serializable;

/**
 * VipCustdeal的实体类
 * @author 
 *
 */
public class VipCustdeal implements Serializable{
	private static final long serialVersionUID = 1L;
    
	//以下由代码生成器生成,如果手工添加代码，务必写在本代码页面最下方
    
	private int id;
	private Date dealDate;
	private int projectId;
	private String projectName;
	private String area;  //组团
	private String building;  //楼栋
	private String floor;  //楼层
	private String room_no;  //房号
	private Double total;
	private Double areaSize;
	private int flag;
	private Date createdate;
	private int refId;
	private String paymethod;
	private Double construction_area; // 建筑面积
	private String adArea;
	private String businesscircle;
	private String constructtype;
	private int custImpId;


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
	 * 取得DealDate(日期)
	 */
	public Date getDealDate() {
		return dealDate;
	}

	/**
	 * 设置dealDate(日期)
	 * @param dealDate (日期)
	 */
	public void setDealDate(Date dealDate) {
		this.dealDate = dealDate;
	}
    
	/**
	 * 取得ProjectId(项目id)
	 */
	public int getProjectId() {
		return projectId;
	}

	/**
	 * 设置projectId(项目id)
	 * @param projectId (项目id)
	 */
	public void setProjectId(int projectId) {
		this.projectId = projectId;
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
	 * 取得Flag(标志)
	 */
	public int getFlag() {
		return flag;
	}

	/**
	 * 设置flag(标志)
	 * @param flag (标志)
	 */
	public void setFlag(int flag) {
		this.flag = flag;
	}
    
	/**
	 * 取得Createdate(导入日期)
	 */
	public Date getCreatedate() {
		return createdate;
	}

	/**
	 * 设置createdate(导入日期)
	 * @param createdate (导入日期)
	 */
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	
	/**
	 * 设置refId(关联客户信息id)
	 *
	 */
	public int getRefId(){
		return refId;
	}
	
	/**
	 * 设置refId(关联客户信息id)
	 * @param refId (关联客户信息id)
	 */
	public void setRefId(int refId){
		this.refId = refId;
	}
    
	
	public VipCustdeal(){};


	/**
	 * 
	 * @param id ()
	 * @param dealDate (日期)
	 * @param projectId (项目id)
	 * @param projectName (项目名)
	 * @param total (购买总价)
	 * @param areaSize (购买面积)
	 * @param flag (标志)
	 * @param createdate (导入日期)
	 */
	public VipCustdeal(    
		int id,
        		Date dealDate,
        		int projectId,
        		String projectName,
        		Double total,
        		Double areaSize,
        		int flag,
        		Date createdate
        ) {
		super();  
		this.id = id;
		this.dealDate = dealDate;
		this.projectId = projectId;
		this.projectName = projectName;
		this.total = total;
		this.areaSize = areaSize;
		this.flag = flag;
		this.createdate = createdate;
	}
    
	/**
	 * 
	 * @param dealDate (日期)
	 * @param projectId (项目id)
	 * @param projectName (项目名)
	 * @param total (购买总价)
	 * @param areaSize (购买面积)
	 * @param flag (标志)
	 * @param createdate (导入日期)
	 */
	public VipCustdeal(    
		Date dealDate,
        		int projectId,
        		String projectName,
        		Double total,
        		Double areaSize,
        		int flag,
        		Date createdate
        ) {
		super();		
		this.dealDate = dealDate;
		this.projectId = projectId;
		this.projectName = projectName;
		this.total = total;
		this.areaSize = areaSize;
		this.flag = flag;
		this.createdate = createdate;
	}
	
	/**
	 * 付款方式
	 * @return
	 */
	public String getPaymethod() {
		return paymethod;
	}

	public void setPaymethod(String paymethod) {
		this.paymethod = paymethod;
	}

	/**
	 * 行政区域
	 * @return
	 */
	public String getAdArea() {
		return adArea;
	}

	public void setAdArea(String adArea) {
		this.adArea = adArea;
	}

	/**
	 * 商圈
	 * @return
	 */
	public String getBusinesscircle() {
		return businesscircle;
	}

	public void setBusinesscircle(String businesscircle) {
		this.businesscircle = businesscircle;
	}

	/**
	 * 结构
	 * @return
	 */
	public String getConstructtype() {
		return constructtype;
	}

	public void setConstructtype(String constructtype) {
		this.constructtype = constructtype;
	}

	public int getCustImpId() {
		return custImpId;
	}

	public void setCustImpId(int custImpId) {
		this.custImpId = custImpId;
	}

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
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

//以上由代码生成器生成
	//以下非代码生成器生成,不可覆盖,以下是手工代码
    
}
