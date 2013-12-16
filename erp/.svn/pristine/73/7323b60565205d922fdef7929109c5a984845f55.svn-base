package com.ihk.saleunit.data.pojo;

import java.util.Date;
import java.math.BigDecimal;
import java.io.Serializable;

import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.utils.saleunit.MyPropertyUtils;

/**
 * ArAmount的实体类
 * @author
 *
 */
public class ArAmount implements Serializable{
    private static final long serialVersionUID = 1L;

    //以下由代码生成器生成,如果手工添加代码，务必写在本代码页面最下方

    private int id;
    private int tranId;
    private int companyId;
    private int propertyId;
    private int areaId;
    private int buildId;
    private int unitId;
    private Date impdate;
    private Date arDate;
    private BigDecimal amount;
    private String remark;

    /**
     * 取得Id(自动生成)
     */
    public int getId() {
        return id;
    }

    /**
     * 设置id(自动生成)
     * @param id (自动生成)
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 取得CompanyId(公司)
     */
    public int getCompanyId() {
        return companyId;
    }

    /**
     * 成交或合同ID
     * @return int
     */
    public int getTranId() {
        return tranId;
    }

    public void setTranId(int tranId) {
        this.tranId = tranId;
    }

    /**
     * 设置companyId(公司)
     * @param companyId (公司)
     */
    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    /**
     * 取得PropertyId(项目)
     */
    public int getPropertyId() {
        return propertyId;
    }

    /**
     * 设置propertyId(项目)
     * @param propertyId (项目)
     */
    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    /**
     * 取得AreaId(区域)
     */
    public int getAreaId() {
        return areaId;
    }

    /**
     * 设置areaId(区域)
     * @param areaId (区域)
     */
    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    /**
     * 取得BuildId(楼栋)
     */
    public int getBuildId() {
        return buildId;
    }

    /**
     * 设置buildId(楼栋)
     * @param buildId (楼栋)
     */
    public void setBuildId(int buildId) {
        this.buildId = buildId;
    }

    /**
     * 取得UnitId(单元)
     */
    public int getUnitId() {
        return unitId;
    }

    /**
     * 设置unitId(单元)
     * @param unitId (单元)
     */
    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    /**
     * 取得Impdate(导入时间)
     */
    public Date getImpdate() {
        return impdate;
    }

    /**
     * 设置impdate(导入时间)
     * @param impdate (导入时间)
     */
    public void setImpdate(Date impdate) {
        this.impdate = impdate;
    }

    /**
     * 取得ArDate(应收日期)
     */
    public Date getArDate() {
        return arDate;
    }

    /**
     * 设置arDate(应收日期)
     * @param arDate (应收日期)
     */
    public void setArDate(Date arDate) {
        this.arDate = arDate;
    }

    /**
     * 取得Amount(金额)
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * 设置amount(金额)
     * @param amount (金额)
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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


    public ArAmount(){}


    /**
     *
     * @param id (自动生成)
     * @param companyId (公司)
     * @param propertyId (项目)
     * @param areaId (区域)
     * @param buildId (楼栋)
     * @param unitId (单元)
     * @param impdate (导入时间)
     * @param arDate (应收日期)
     * @param amount (金额)
     * @param remark (备注)
     * @param tranId (交易id 对应 认购合同id)
     */
    public ArAmount(
            int id,
            int companyId,
            int propertyId,
            int areaId,
            int buildId,
            int unitId,
            Date impdate,
            Date arDate,
            BigDecimal amount,
            String remark,
            int tranId
    ) {
        super();
        this.id = id;
        this.companyId = companyId;
        this.propertyId = propertyId;
        this.areaId = areaId;
        this.buildId = buildId;
        this.unitId = unitId;
        this.impdate = impdate;
        this.arDate = arDate;
        this.amount = amount;
        this.remark = remark;
        this.tranId = tranId;
    }




    //以上由代码生成器生成
    //以下非代码生成器生成,不可覆盖,以下是手工代码
    public PropertyUnit getPropertyUnit() {
        return MyPropertyUtils.getPropertyUnitServices().findPropertyUnitById(this.unitId);
    }
}
