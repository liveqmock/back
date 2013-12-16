package com.ihk.property.data.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.ihk.constanttype.ContProjectId;
import com.ihk.constanttype.ContUnitChangeTypeFrom;
import com.ihk.constanttype.ContUnitSaleState;
import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.saleunit.data.pojo.Confirm;
import com.ihk.saleunit.data.pojo.ConfirmBook;
import com.ihk.saleunit.data.pojo.Contract;
import com.ihk.utils.DescUtils;
import com.ihk.utils.saleunit.MyPropertyUtils;
import com.ihk.utils.saleunit.UnitChangeUtils;
import com.ihk.utils.saleunitnew.UnitConfirmContractUtils;

/**
 * PropertyUnit的实体类
 * @author 
 *
 */
public class PropertyUnit implements Serializable ,Comparable<PropertyUnit>{
	
	private static final long serialVersionUID = 9137526937976126821L;

	//以下由代码生成器生成,如果手工添加代码，务必写在本代码页面最下方
    
	private int id;
	private int buildId;
	private String floorNum;
	private String roomNo;
	private String unitNo;
	private String aliasNo;
	private String houseType;
	private int roomNum;
	private int hallNum;
	private int toiletNum;
	private String roomType;
	private String saleState;
	private String saleType;
	private BigDecimal buildArea;
	private BigDecimal insideArea;
	private BigDecimal buildPrice;
	private BigDecimal insidePrice;
	private BigDecimal sumPrice;
	private String priceWay;
	private String areaState;
	private String scenery;
	private String orientation;
	private BigDecimal preBuildArea;
	private BigDecimal preInsideArea;
	private BigDecimal realBuildArea;
	private BigDecimal realInsideArea;
	private String productType;
	private BigDecimal renovateMoney;
	private String isSample;
	private String isSlave;
	private String mortgageState;
	private String houseDesc;
	private String renovateDesc;
	private BigDecimal renovatePrice;
	private String remark;
	private int chip1;
	private int chip2;
	private int chip3;
	private int chipA;
	private int chipB;
	private Date saleTime;
	private BigDecimal appointPublicArea;
	private BigDecimal realPublicArea;
	private BigDecimal publicArea;
	
	private int companyProjectId;
	private BigDecimal baseprice;
	private BigDecimal totalBaseprice;
	
	private String isDeleted;
	private int createdId;
	private Date createdTime;
	private int modId;
	private Date modTime;
	
	private BigDecimal addArea;
	private String floorShowName;
	
	/**
	 * 对数日期
	 */
    private Date checkfeeDate;
    
    /**
     * 对数类型,对应类EnumUnitCheckfeeType.java
     */
    private int checkfeeType;

    //v_property_unit 用,没有加在数据库中
    private int confirm_customer_id;
    private String confirmDate; //认购日期
    private int unitId;
    private String payName; //付款方式名称
    
    public void setCheckfeeType(int checkfeeType) {
    	this.checkfeeType = checkfeeType;
    }
    
    public int getCheckfeeType() {
		return checkfeeType;
	}
    
    public Date getCheckfeeDate() {
		return checkfeeDate;
	}
    
    public void setCheckfeeDate(Date checkfeeDate) {
		this.checkfeeDate = checkfeeDate;
	}

    public String getPayName() {
        return payName;
    }

    public void setPayName(String payName) {
        this.payName = payName;
    }

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    public String getConfirmDate() {
        return confirmDate;
    }

    public void setConfirmDate(String confirmDate) {
        this.confirmDate = confirmDate;
    }

    public int getConfirm_customer_id() {
        return confirm_customer_id;
    }

    public void setConfirm_customer_id(int confirm_customer_id) {
        this.confirm_customer_id = confirm_customer_id;
    }

    public BigDecimal getAddArea() {
		return addArea;
	}

	public void setAddArea(BigDecimal addArea) {
		this.addArea = addArea;
	}

	public String getFloorShowName() {
		return floorShowName;
	}

	public void setFloorShowName(String floorShowName) {
		this.floorShowName = floorShowName;
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
	 * 取得BuildId(栋苑id)
	 */
	public int getBuildId() {
		return buildId;
	}

	/**
	 * 设置buildId(栋苑id)
	 * @param buildId (栋苑id)
	 */
	public void setBuildId(int buildId) {
		this.buildId = buildId;
	}
    
	/**
	 * 取得FloorNum(楼层号)
	 */
	
	
	/**
	 * 设置floorNum(楼层号)
	 * @param floorNum (楼层号)
	 */
	
    
	/**
	 * 取得RoomNo(单元号)
	 */
	public String getRoomNo() {
		return roomNo;
	}

	public String getFloorNum() {
		return floorNum;
	}

	public void setFloorNum(String floorNum) {
		this.floorNum = floorNum;
	}

	/**
	 * 设置roomNo(单元号)
	 * @param roomNo (单元号)
	 */
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
    
	/**
	 * 取得UnitNo(房间号)
	 */
	public String getUnitNo() {
		return unitNo;
	}

	/**
	 * 设置unitNo(房间号)
	 * @param unitNo (房间号)
	 */
	public void setUnitNo(String unitNo) {
		this.unitNo = unitNo;
	}
    
	/**
	 * 取得AliasNo(房间别号)
	 */
	public String getAliasNo() {
		return aliasNo;
	}

	/**
	 * 设置aliasNo(房间别号)
	 * @param aliasNo (房间别号)
	 */
	public void setAliasNo(String aliasNo) {
		this.aliasNo = aliasNo;
	}
    
	/**
	 * 取得HouseType(户型)
	 */
	public String getHouseType() {
		return houseType;
	}

	/**
	 * 设置houseType(户型)
	 * @param houseType (户型)
	 */
	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}
    
	/**
	 * 取得RoomNum(房间数量)
	 */
	public int getRoomNum() {
		return roomNum;
	}

	/**
	 * 设置roomNum(房间数量)
	 * @param roomNum (房间数量)
	 */
	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}
    
	/**
	 * 取得HallNum(厅数量)
	 */
	public int getHallNum() {
		return hallNum;
	}

	/**
	 * 设置hallNum(厅数量)
	 * @param hallNum (厅数量)
	 */
	public void setHallNum(int hallNum) {
		this.hallNum = hallNum;
	}
    
	/**
	 * 取得ToiletNum(卫生间数量)
	 */
	public int getToiletNum() {
		return toiletNum;
	}

	/**
	 * 设置toiletNum(卫生间数量)
	 * @param toiletNum (卫生间数量)
	 */
	public void setToiletNum(int toiletNum) {
		this.toiletNum = toiletNum;
	}
    
	/**
	 * 取得RoomType(房间结构)
	 */
	public String getRoomType() {
		return roomType;
	}

	/**
	 * 设置roomType(房间结构)
	 * @param roomType (房间结构)
	 */
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
    
	/**
	 * 取得SaleState(销售状态)
	 */
	public String getSaleState() {
		return saleState;
	}

	/**
	 * 设置saleState(销售状态)
	 * @param saleState (销售状态)
	 */
	public void setSaleState(String saleState) {
		this.saleState = saleState;
	}
    
	/**
	 * 取得SaleType(租售类型)
	 */
	public String getSaleType() {
		return saleType;
	}

	/**
	 * 设置saleType(租售类型)
	 * @param saleType (租售类型)
	 */
	public void setSaleType(String saleType) {
		this.saleType = saleType;
	}
    
	/**
	 * 取得BuildArea(建筑面积)
	 */
	public BigDecimal getBuildArea() {
		return buildArea;
	}

	/**
	 * 设置buildArea(建筑面积)
	 * @param buildArea (建筑面积)
	 */
	public void setBuildArea(BigDecimal buildArea) {
		this.buildArea = buildArea;
	}
    
	/**
	 * 取得InsideArea(套内面积)
	 */
	public BigDecimal getInsideArea() {
		return insideArea;
	}

	/**
	 * 设置insideArea(套内面积)
	 * @param insideArea (套内面积)
	 */
	public void setInsideArea(BigDecimal insideArea) {
		this.insideArea = insideArea;
	}
    
	/**
	 * 取得BuildPrice(建筑单价)
	 */
	public BigDecimal getBuildPrice() {
		return buildPrice;
	}

	/**
	 * 设置buildPrice(建筑单价)
	 * @param buildPrice (建筑单价)
	 */
	public void setBuildPrice(BigDecimal buildPrice) {
		this.buildPrice = buildPrice;
	}
    
	/**
	 * 取得InsidePrice(套内单价)
	 */
	public BigDecimal getInsidePrice() {
		return insidePrice;
	}

	/**
	 * 设置insidePrice(套内单价)
	 * @param insidePrice (套内单价)
	 */
	public void setInsidePrice(BigDecimal insidePrice) {
		this.insidePrice = insidePrice;
	}
    
	/**
	 * 取得SumPrice(标准总价)
	 */
	public BigDecimal getSumPrice() {
		return sumPrice;
	}

	/**
	 * 设置sumPrice(标准总价)
	 * @param sumPrice (标准总价)
	 */
	public void setSumPrice(BigDecimal sumPrice) {
		this.sumPrice = sumPrice;
	}
    
	/**
	 * 取得PriceWay(计价方式)
	 */
	public String getPriceWay() {
		return priceWay;
	}

	/**
	 * 设置priceWay(计价方式)
	 * @param priceWay (计价方式)
	 */
	public void setPriceWay(String priceWay) {
		this.priceWay = priceWay;
	}
    
	/**
	 * 取得AreaState(面积状态)
	 */
	public String getAreaState() {
		return areaState;
	}

	/**
	 * 设置areaState(面积状态)
	 * @param areaState (面积状态)
	 */
	public void setAreaState(String areaState) {
		this.areaState = areaState;
	}
    
	/**
	 * 取得Scenery(景观)
	 */
	public String getScenery() {
		return scenery;
	}

	/**
	 * 设置scenery(景观)
	 * @param scenery (景观)
	 */
	public void setScenery(String scenery) {
		this.scenery = scenery;
	}
    
	/**
	 * 取得Orientation(朝向)
	 */
	public String getOrientation() {
		return orientation;
	}

	/**
	 * 设置orientation(朝向)
	 * @param orientation (朝向)
	 */
	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}
    
	/**
	 * 取得PreBuildArea(预售建筑面积)
	 */
	public BigDecimal getPreBuildArea() {
		return preBuildArea;
	}

	/**
	 * 设置preBuildArea(预售建筑面积)
	 * @param preBuildArea (预售建筑面积)
	 */
	public void setPreBuildArea(BigDecimal preBuildArea) {
		this.preBuildArea = preBuildArea;
	}
    
	/**
	 * 取得PreInsideArea(预售套内面积)
	 */
	public BigDecimal getPreInsideArea() {
		return preInsideArea;
	}

	/**
	 * 设置preInsideArea(预售套内面积)
	 * @param preInsideArea (预售套内面积)
	 */
	public void setPreInsideArea(BigDecimal preInsideArea) {
		this.preInsideArea = preInsideArea;
	}
    
	/**
	 * 取得RealBuildArea(实测建筑面积)
	 */
	public BigDecimal getRealBuildArea() {
		return realBuildArea;
	}

	/**
	 * 设置realBuildArea(实测建筑面积)
	 * @param realBuildArea (实测建筑面积)
	 */
	public void setRealBuildArea(BigDecimal realBuildArea) {
		this.realBuildArea = realBuildArea;
	}
    
	/**
	 * 取得RealInsideArea(实测套内面积)
	 */
	public BigDecimal getRealInsideArea() {
		return realInsideArea;
	}

	/**
	 * 设置realInsideArea(实测套内面积)
	 * @param realInsideArea (实测套内面积)
	 */
	public void setRealInsideArea(BigDecimal realInsideArea) {
		this.realInsideArea = realInsideArea;
	}
    
	/**
	 * 取得ProductType(产品类型)
	 */
	public String getProductType() {
		return productType;
	}

	/**
	 * 设置productType(产品类型)
	 * @param productType (产品类型)
	 */
	public void setProductType(String productType) {
		this.productType = productType;
	}
    
	/**
	 * 取得RenovateMoney(装修款)
	 */
	public BigDecimal getRenovateMoney() {
		return renovateMoney;
	}

	/**
	 * 设置renovateMoney(装修款)
	 * @param renovateMoney (装修款)
	 */
	public void setRenovateMoney(BigDecimal renovateMoney) {
		this.renovateMoney = renovateMoney;
	}
    
	/**
	 * 取得IsSample(是否样板房)
	 */
	public String getIsSample() {
		return isSample;
	}

	/**
	 * 设置isSample(是否样板房)
	 * @param isSample (是否样板房)
	 */
	public void setIsSample(String isSample) {
		this.isSample = isSample;
	}
    
	/**
	 * 取得IsSlave(是否附属房产)
	 */
	public String getIsSlave() {
		return isSlave;
	}

	/**
	 * 设置isSlave(是否附属房产)
	 * @param isSlave (是否附属房产)
	 */
	public void setIsSlave(String isSlave) {
		this.isSlave = isSlave;
	}
    
	/**
	 * 取得MortgageState(抵押状态)
	 */
	public String getMortgageState() {
		return mortgageState;
	}

	/**
	 * 设置mortgageState(抵押状态)
	 * @param mortgageState (抵押状态)
	 */
	public void setMortgageState(String mortgageState) {
		this.mortgageState = mortgageState;
	}
    
	/**
	 * 取得HouseDesc(户型点评)
	 */
	public String getHouseDesc() {
		return houseDesc;
	}

	/**
	 * 设置houseDesc(户型点评)
	 * @param houseDesc (户型点评)
	 */
	public void setHouseDesc(String houseDesc) {
		this.houseDesc = houseDesc;
	}
    
	/**
	 * 取得RenovateDesc(装修标准)
	 */
	public String getRenovateDesc() {
		return renovateDesc;
	}

	/**
	 * 设置renovateDesc(装修标准)
	 * @param renovateDesc (装修标准)
	 */
	public void setRenovateDesc(String renovateDesc) {
		this.renovateDesc = renovateDesc;
	}
    
	/**
	 * 取得RenovatePrice(装修单价)
	 */
	public BigDecimal getRenovatePrice() {
		return renovatePrice;
	}

	/**
	 * 设置renovatePrice(装修单价)
	 * @param renovatePrice (装修单价)
	 */
	public void setRenovatePrice(BigDecimal renovatePrice) {
		this.renovatePrice = renovatePrice;
	}
    
	/**
	 * 取得Remark(备注)
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 设置remark(备注)
	 * @param remark (备注)
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
    
	/**
	 * 取得Chip1(第一意向数量)
	 */
	public int getChip1() {
		return chip1;
	}

	/**
	 * 设置chip1(第一意向数量)
	 * @param chip1 (第一意向数量)
	 */
	public void setChip1(int chip1) {
		this.chip1 = chip1;
	}
    
	/**
	 * 取得Chip2(第二意向数量)
	 */
	public int getChip2() {
		return chip2;
	}

	/**
	 * 设置chip2(第二意向数量)
	 * @param chip2 (第二意向数量)
	 */
	public void setChip2(int chip2) {
		this.chip2 = chip2;
	}
    
	/**
	 * 取得Chip3(第三意向数量)
	 */
	public int getChip3() {
		return chip3;
	}

	/**
	 * 设置chip3(第三意向数量)
	 * @param chip3 (第三意向数量)
	 */
	public void setChip3(int chip3) {
		this.chip3 = chip3;
	}
    
	/**
	 * 取得ChipA(A筹数量)
	 */
	public int getChipA() {
		return chipA;
	}

	/**
	 * 设置chipA(A筹数量)
	 * @param chipA (A筹数量)
	 */
	public void setChipA(int chipA) {
		this.chipA = chipA;
	}
    
	/**
	 * 取得ChipB(B筹数量)
	 */
	public int getChipB() {
		return chipB;
	}

	/**
	 * 设置chipB(B筹数量)
	 * @param chipB (B筹数量)
	 */
	public void setChipB(int chipB) {
		this.chipB = chipB;
	}
    
	
	public int getCompanyProjectId() {
		return companyProjectId;
	}

	public void setCompanyProjectId(int companyProjectId) {
		this.companyProjectId = companyProjectId;
	}
    
	public BigDecimal getBaseprice() {
		return baseprice;
	}

	public void setBaseprice(BigDecimal baseprice) {
		this.baseprice = baseprice;
	}
    
	public BigDecimal getTotalBaseprice() {
		return totalBaseprice;
	}

	public void setTotalBaseprice(BigDecimal totalBaseprice) {
		this.totalBaseprice = totalBaseprice;
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
    
	/**
	 * 取得AppointPublicArea(预售公摊面积)
	 */
	public BigDecimal getAppointPublicArea() {
		return appointPublicArea;
	}

	/**
	 * 设置appointPublicArea(预售公摊面积)
	 * @param appointPublicArea (预售公摊面积)
	 */
	public void setAppointPublicArea(BigDecimal appointPublicArea) {
		this.appointPublicArea = appointPublicArea;
	}
    
	/**
	 * 取得RealPublicArea(实测公摊面积)
	 */
	public BigDecimal getRealPublicArea() {
		return realPublicArea;
	}

	/**
	 * 设置realPublicArea(实测公摊面积)
	 * @param realPublicArea (实测公摊面积)
	 */
	public void setRealPublicArea(BigDecimal realPublicArea) {
		this.realPublicArea = realPublicArea;
	}
    
	/**
	 * 取得PublicArea(公摊面积)
	 */
	public BigDecimal getPublicArea() {
		return publicArea;
	}

	/**
	 * 设置publicArea(公摊面积)
	 * @param publicArea (公摊面积)
	 */
	public void setPublicArea(BigDecimal publicArea) {
		this.publicArea = publicArea;
	}
    
	/**
	 * 取得SaleTime(推货日期)
	 */
	public Date getSaleTime() {
		return saleTime;
	}

	/**
	 * 设置saleTime(推货日期)
	 * @param saleTime (推货日期)
	 */
	public void setSaleTime(Date saleTime) {
		this.saleTime = saleTime;
	}
    
	
	public PropertyUnit(){};


	/**
	 * 
	 * @param id ()
	 * @param buildId (栋苑id)
	 * @param floorNum (楼层号)
	 * @param roomNo (单元号)
	 * @param unitNo (房间号)
	 * @param aliasNo (房间别号)
	 * @param houseType (户型)
	 * @param roomNum (房间数量)
	 * @param hallNum (厅数量)
	 * @param toiletNum (卫生间数量)
	 * @param roomType (房间结构)
	 * @param saleState (销售状态)
	 * @param saleType (租售类型)
	 * @param buildArea (建筑面积)
	 * @param insideArea (套内面积)
	 * @param buildPrice (建筑单价)
	 * @param insidePrice (套内单价)
	 * @param sumPrice (标准总价)
	 * @param priceWay (计价方式)
	 * @param areaState (面积状态)
	 * @param scenery (景观)
	 * @param orientation (朝向)
	 * @param preBuildArea (预售建筑面积)
	 * @param preInsideArea (预售套内面积)
	 * @param realBuildArea (实测建筑面积)
	 * @param realInsideArea (实测套内面积)
	 * @param productType (产品类型)
	 * @param renovateMoney (装修款)
	 * @param isSample (是否样板房)
	 * @param isSlave (是否附属房产)
	 * @param mortgageState (抵押状态)
	 * @param houseDesc (户型点评)
	 * @param renovateDesc (装修标准)
	 * @param renovatePrice (装修单价)
	 * @param remark (备注)
	 * @param chip1 (第一意向数量)
	 * @param chip2 (第二意向数量)
	 * @param chip3 (第三意向数量)
	 * @param chipA (A筹数量)
	 * @param chipB (B筹数量)
	 * @param isDeleted (是否删除)
	 * @param createdId (创建人)
	 * @param createdTime (创建时间)
	 * @param modId (修改人)
	 * @param modTime (修改时间)
	 * @param appointPublicArea (预售公摊面积)
	 * @param realPublicArea (实测公摊面积)
	 * @param publicArea (公摊面积)
	 * @param saleTime (推货日期)
	 * @param companyProjectId (公司项目)
	 */
	public PropertyUnit(    
			int id,
	        		int buildId,
	        		String floorNum,
	        		String roomNo,
	        		String unitNo,
	        		String aliasNo,
	        		String houseType,
	        		int roomNum,
	        		int hallNum,
	        		int toiletNum,
	        		String roomType,
	        		String saleState,
	        		String saleType,
	        		BigDecimal buildArea,
	        		BigDecimal insideArea,
	        		BigDecimal buildPrice,
	        		BigDecimal insidePrice,
	        		BigDecimal sumPrice,
	        		String priceWay,
	        		String areaState,
	        		String scenery,
	        		String orientation,
	        		BigDecimal preBuildArea,
	        		BigDecimal preInsideArea,
	        		BigDecimal realBuildArea,
	        		BigDecimal realInsideArea,
	        		String productType,
	        		BigDecimal renovateMoney,
	        		String isSample,
	        		String isSlave,
	        		String mortgageState,
	        		String houseDesc,
	        		String renovateDesc,
	        		BigDecimal renovatePrice,
	        		String remark,
	        		int chip1,
	        		int chip2,
	        		int chip3,
	        		int chipA,
	        		int chipB,
	        		Date saleTime,
	        		BigDecimal appointPublicArea,
	        		BigDecimal realPublicArea,
	        		BigDecimal publicArea,
	        		int companyProjectId,
	        		BigDecimal baseprice,
	        		BigDecimal totalBaseprice,
	        		String isDeleted,
	        		int createdId,
	        		Date createdTime,
	        		int modId,
	        		Date modTime
	        ) {
			super();  
			this.id = id;
			this.buildId = buildId;
			this.floorNum = floorNum;
			this.roomNo = roomNo;
			this.unitNo = unitNo;
			this.aliasNo = aliasNo;
			this.houseType = houseType;
			this.roomNum = roomNum;
			this.hallNum = hallNum;
			this.toiletNum = toiletNum;
			this.roomType = roomType;
			this.saleState = saleState;
			this.saleType = saleType;
			this.buildArea = buildArea;
			this.insideArea = insideArea;
			this.buildPrice = buildPrice;
			this.insidePrice = insidePrice;
			this.sumPrice = sumPrice;
			this.priceWay = priceWay;
			this.areaState = areaState;
			this.scenery = scenery;
			this.orientation = orientation;
			this.preBuildArea = preBuildArea;
			this.preInsideArea = preInsideArea;
			this.realBuildArea = realBuildArea;
			this.realInsideArea = realInsideArea;
			this.productType = productType;
			this.renovateMoney = renovateMoney;
			this.isSample = isSample;
			this.isSlave = isSlave;
			this.mortgageState = mortgageState;
			this.houseDesc = houseDesc;
			this.renovateDesc = renovateDesc;
			this.renovatePrice = renovatePrice;
			this.remark = remark;
			this.chip1 = chip1;
			this.chip2 = chip2;
			this.chip3 = chip3;
			this.chipA = chipA;
			this.chipB = chipB;
			this.saleTime = saleTime;
			this.appointPublicArea = appointPublicArea;
			this.realPublicArea = realPublicArea;
			this.publicArea = publicArea;
			this.companyProjectId = companyProjectId;
			this.baseprice = baseprice;
			this.totalBaseprice = totalBaseprice;
			this.isDeleted = isDeleted;
			this.createdId = createdId;
			this.createdTime = createdTime;
			this.modId = modId;
			this.modTime = modTime;
		}
    
	/**
	 * 
	 * @param buildId (栋苑id)
	 * @param floorNum (楼层号)
	 * @param roomNo (单元号)
	 * @param unitNo (房间号)
	 * @param aliasNo (房间别号)
	 * @param houseType (户型)
	 * @param roomNum (房间数量)
	 * @param hallNum (厅数量)
	 * @param toiletNum (卫生间数量)
	 * @param roomType (房间结构)
	 * @param saleState (销售状态)
	 * @param saleType (租售类型)
	 * @param buildArea (建筑面积)
	 * @param insideArea (套内面积)
	 * @param buildPrice (建筑单价)
	 * @param insidePrice (套内单价)
	 * @param sumPrice (标准总价)
	 * @param priceWay (计价方式)
	 * @param areaState (面积状态)
	 * @param scenery (景观)
	 * @param orientation (朝向)
	 * @param preBuildArea (预售建筑面积)
	 * @param preInsideArea (预售套内面积)
	 * @param realBuildArea (实测建筑面积)
	 * @param realInsideArea (实测套内面积)
	 * @param productType (产品类型)
	 * @param renovateMoney (装修款)
	 * @param isSample (是否样板房)
	 * @param isSlave (是否附属房产)
	 * @param mortgageState (抵押状态)
	 * @param houseDesc (户型点评)
	 * @param renovateDesc (装修标准)
	 * @param renovatePrice (装修单价)
	 * @param remark (备注)
	 * @param chip1 (第一意向数量)
	 * @param chip2 (第二意向数量)
	 * @param chip3 (第三意向数量)
	 * @param chipA (A筹数量)
	 * @param chipB (B筹数量)
	 * @param isDeleted (是否删除)
	 * @param createdId (创建人)
	 * @param createdTime (创建时间)
	 * @param modId (修改人)
	 * @param modTime (修改时间)
	 * @param appointPublicArea (预售公摊面积)
	 * @param realPublicArea (实测公摊面积)
	 * @param publicArea (公摊面积)
	 * @param saleTime (推货日期)
	 */
	public PropertyUnit(    
			int buildId,
			String floorNum,
	        		String roomNo,
	        		String unitNo,
	        		String aliasNo,
	        		String houseType,
	        		int roomNum,
	        		int hallNum,
	        		int toiletNum,
	        		String roomType,
	        		String saleState,
	        		String saleType,
	        		BigDecimal buildArea,
	        		BigDecimal insideArea,
	        		BigDecimal buildPrice,
	        		BigDecimal insidePrice,
	        		BigDecimal sumPrice,
	        		String priceWay,
	        		String areaState,
	        		String scenery,
	        		String orientation,
	        		BigDecimal preBuildArea,
	        		BigDecimal preInsideArea,
	        		BigDecimal realBuildArea,
	        		BigDecimal realInsideArea,
	        		String productType,
	        		BigDecimal renovateMoney,
	        		String isSample,
	        		String isSlave,
	        		String mortgageState,
	        		String houseDesc,
	        		String renovateDesc,
	        		BigDecimal renovatePrice,
	        		String remark,
	        		int chip1,
	        		int chip2,
	        		int chip3,
	        		int chipA,
	        		int chipB,
	        		Date saleTime,
	        		BigDecimal appointPublicArea,
	        		BigDecimal realPublicArea,
	        		BigDecimal publicArea,
	        		int companyProjectId,
	        		BigDecimal baseprice,
	        		BigDecimal totalBaseprice,
	        		String isDeleted,
	        		int createdId,
	        		Date createdTime,
	        		int modId,
	        		Date modTime
	        ) {
			super();		
			this.buildId = buildId;
			this.floorNum = floorNum;
			this.roomNo = roomNo;
			this.unitNo = unitNo;
			this.aliasNo = aliasNo;
			this.houseType = houseType;
			this.roomNum = roomNum;
			this.hallNum = hallNum;
			this.toiletNum = toiletNum;
			this.roomType = roomType;
			this.saleState = saleState;
			this.saleType = saleType;
			this.buildArea = buildArea;
			this.insideArea = insideArea;
			this.buildPrice = buildPrice;
			this.insidePrice = insidePrice;
			this.sumPrice = sumPrice;
			this.priceWay = priceWay;
			this.areaState = areaState;
			this.scenery = scenery;
			this.orientation = orientation;
			this.preBuildArea = preBuildArea;
			this.preInsideArea = preInsideArea;
			this.realBuildArea = realBuildArea;
			this.realInsideArea = realInsideArea;
			this.productType = productType;
			this.renovateMoney = renovateMoney;
			this.isSample = isSample;
			this.isSlave = isSlave;
			this.mortgageState = mortgageState;
			this.houseDesc = houseDesc;
			this.renovateDesc = renovateDesc;
			this.renovatePrice = renovatePrice;
			this.remark = remark;
			this.chip1 = chip1;
			this.chip2 = chip2;
			this.chip3 = chip3;
			this.chipA = chipA;
			this.chipB = chipB;
			this.saleTime = saleTime;
			this.appointPublicArea = appointPublicArea;
			this.realPublicArea = realPublicArea;
			this.publicArea = publicArea;
			this.companyProjectId = companyProjectId;
			this.baseprice = baseprice;
			this.totalBaseprice = totalBaseprice;
			this.isDeleted = isDeleted;
			this.createdId = createdId;
			this.createdTime = createdTime;
			this.modId = modId;
			this.modTime = modTime;
		}
    

	//以上由代码生成器生成
	//以下非代码生成器生成,不可覆盖,以下是手工代码
    
	
	////
		
	/**
	 * 获取楼栋名称
	 */
	public String getDescBuildId(){
		if(this.buildId == 0)return null;
		try {
			return DescUtils.getBuildById(this.buildId).getBuildName();
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 获取单元朝向中文
	 * @return
	 */
	public String getDescOrientation(){
		if(orientation == null || orientation.trim().equals(""))return null;
		return DescUtils.getCodeDesc(EnumCodeTypeName.PROPERTY_ORIENTATION, this.orientation,0);
	}
		

	private Confirm confirm;
	private Contract contract;
		
	public void setConfirm(Confirm confirm) {
		this.confirm = confirm;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	/**
	 * 认购物业及(已选择全文),(${build.descPropertyId},${build.areaName},${build.buildName},${unit.unitNo})
	 * @return
	 */
	public String getAllName(){
		
		try{
		    PropertyBuild build = MyPropertyUtils.getPropertyBuildServices().findPropertyBuildById(this.getBuildId());
			
			return build.getDescPropertyId() + "," + build.getAreaName() + "," + build.getBuildName() + "," + this.getUnitNo();
		}catch (Exception e) {
			
			return "";
		}
	}
	
	/**
	 * 分区,楼栋,单元编号
	 * @return
	 */
	public String getUnitTreeName(){
		
		try{
		    PropertyBuild build = MyPropertyUtils.getPropertyBuildServices().findPropertyBuildById(this.getBuildId());
			
			return build.getAreaName() + "," + build.getBuildName() + "," + this.getUnitNo();
		}catch (Exception e) {
			
			return "";
		}
	}
		
	/**
	 * 获取开发商名称
	 * @return
	 */
	public String getPropertyDeveloper(){
		
		try{
			
			int projectId = DescUtils.findPropertyProjectByUnitId(this.getId()).getId();
			PropertyProject project = MyPropertyUtils.getPropertyProjectServices().findPropertyProjectById(projectId);
			return MyPropertyUtils.getPropertyDeveloperServices().findPropertyDeveloperById(project.getDeveloperId()).getDeveloperName();
			
		}catch(Exception e){
			return "";
		}
		
	}
		
	/**
	 * 获取楼盘项目id
	 * @return
	 */
	public String getPropertyProjectId(){
		
		return DescUtils.findPropertyProjectByUnitId(this.getId()).getId() + "";
	}
	
	/**
	 * 获取楼盘项目名称
	 * @return
	 */
	public String getPropertyProjectName(){
		
		return DescUtils.findPropertyProjectByUnitId(this.getId()).getPropertyName();
	}
	
	/**
	 * 获取楼栋名称
	 * @return
	 */
	public String getPropertyBuildName(){
		
		return DescUtils.findPropertyBuildByUnitId(this.getId()).getBuildName();
	}
	
	/**
	 * 获取房间结构中文
	 * @return
	 */
	public String getRoomTypeStr(){
		return DescUtils.getCodeDesc(EnumCodeTypeName.PROPERTY_ROOM_TYPE, this.getRoomType(), ContProjectId.GUANG_ZHOU);
	}
	
	/**
	 * 面积状态中文
	 * @return
	 */
	public String getAreaStateStr(){
		return DescUtils.getCodeDesc(EnumCodeTypeName.PROPERTY_AREA_STATE, this.getAreaState(), ContProjectId.GUANG_ZHOU);
	}
	
	/**
	 * 计价方式中文
	 * @return
	 */
	public String getPriceWayStr(){
		return DescUtils.getCodeDesc(EnumCodeTypeName.PROPERTY_PRICE_WAY, this.getPriceWay(), ContProjectId.GUANG_ZHOU);
	}
	
	public String getProductTypeStr(){
		return DescUtils.getCodeDesc(EnumCodeTypeName.PROPERTY_PRODUCT_TYPE, this.getProductType(), ContProjectId.GUANG_ZHOU);
		//return this.productType;
	}
	
	/**
	 * 判断是否可以成交
	 * @return
	 */
	public boolean getCanConfirm(){
		
		return UnitChangeUtils.isCanChange(ContUnitChangeTypeFrom.CONFIRM, this);
	}
	
	/**
	 * 判断是否可以合同
	 * @return
	 */
	public boolean getCanContract(){
		
		return UnitChangeUtils.isCanChange(ContUnitChangeTypeFrom.CONTRACT, this);
	}
	
	/**
	 * 获取对应的成交
	 * @return
	 */
	public Confirm getConfirm(){
		if(this.confirm==null && isInitConfirmContractInfo()==false){
			this.confirm = MyPropertyUtils.getConfirmServices().findConfirmByUnitId(this.getId());			
		}
		
		return this.confirm;
	}
	
	/**
	 * 获取对应的合同
	 * @return
	 */
	public Contract getContract(){
		if(this.contract==null && isInitConfirmContractInfo()==false){		
			contract = MyPropertyUtils.getContractServices().findContractByUnitId(this.getId());			
		}
		
		return contract;
	}	
	
	/**
	 * 获取对应的临定
	 * @return
	 */
	public ConfirmBook getConfirmBook(){
		
		ConfirmBook ret = MyPropertyUtils.getConfirmBookServices().findConfirmBookByUnitId(this.getId());
		
		return ret == null ? new ConfirmBook() : ret;
	}
	
	/**
	 * 销售状态
	 * @return
	 */
	public String getSaleStateStr(){
		
		return ContUnitSaleState.getSaleState().get(this.getSaleState());
	}
	
	/**
	 * 认购合同的创建或查看href
	 * @return
	 */
	public String getConfirmContractCreateOrShowHref(){
		
		return UnitConfirmContractUtils.getConfirmContractCreateOrShowHref(this);
	}
	
	/** 
	 * 是否属于推出货量
	 * @return
	 */
	public boolean isTuiHuo(){
		if(!this.getSaleState().equals(ContUnitSaleState.FROZEN)){
			//属于冻结状态code_type;PROPERTY_SALE_STATE 1
			return true;
		}
		
		return false;
	}
	
	
	/** 
	 * 是否属于齐订
	 * @return
	 */
	public boolean isDownpayment(){
		
		return false;
	}

	/** 
	 * 是否属于剩余货量
	 * @return
	 */
	public boolean isShengYu(){
		//code_type;PROPERTY_SALE_STATE
		//认筹的单元不属于剩余货量单元
		if(this.getSaleState().equals(ContUnitSaleState.FROZEN)//冻结 1
				|| this.getSaleState().equals(ContUnitSaleState.SALE_ABLE)//可售 2
				){
			return true;
		}
		
		return false;
	}
	

	/**
	 * 是否已经设置了成交的信息(认购,合同等)
	 * 用于列表设置，提升性能,避免多次查询
	 */
	private boolean initConfirmContractInfo=false;

	/**
	 * 是否已经设置了成交的信息(认购,合同等)
	 * 用于列表设置，提升性能,避免多次查询
	 */
	public boolean isInitConfirmContractInfo() {
		return initConfirmContractInfo;
	}

	/**
	 * 判断是否属于已售  
	 * */
	public boolean isSale(){
		if(this.saleState.equals(ContUnitSaleState.CONFIRM) || this.saleState.equals(ContUnitSaleState.CONTRACT)){
			return true;
		}
		return false;
	}
	
	/**
	 * 是否已经设置了成交的信息(认购,合同等)
	 * 用于列表设置，提升性能,避免多次查询
	 */
	public void setInitConfirmContractInfo(boolean initConfirmContractInfo) {
		this.initConfirmContractInfo = initConfirmContractInfo;
	}
	
	/**
	 * 用于成交数据交叉
	 * @return
	 */
	public String getBuildIdLR(){
		
		return "[" + buildId + "]";
	}

	@Override
	public int compareTo(PropertyUnit o) {
		//return (int) Math.signum(this.getFloorNum() - o.getFloorNum());    待修改
		return 0;
	}
	
}
