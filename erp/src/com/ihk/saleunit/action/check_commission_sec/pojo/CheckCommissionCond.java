package com.ihk.saleunit.action.check_commission_sec.pojo;

import com.ihk.utils.SearchCond;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Lenovo
 * Date: 13-7-11
 * Time: 下午6:01
 * To change this template use File | Settings | File Templates.
 */
public class CheckCommissionCond extends SearchCond implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id; //主键id

    private int unitId; //单元

    private Date checkCommissionDate; //对佣日期

    private int checkCommissionType; //对佣日期

    private int modId; //操作者的id

    private Date modTime;

    private BigDecimal repayMoney;

    public CheckCommissionCond() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    public Date getCheckCommissionDate() {
        return checkCommissionDate;
    }

    public void setCheckCommissionDate(Date checkCommissionDate) {
        this.checkCommissionDate = checkCommissionDate;
    }

    public int getCheckCommissionType() {
        return checkCommissionType;
    }

    public void setCheckCommissionType(int checkCommissionType) {
        this.checkCommissionType = checkCommissionType;
    }

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

    public BigDecimal getRepayMoney() {
        return repayMoney;
    }

    public void setRepayMoney(BigDecimal repayMoney) {
        this.repayMoney = repayMoney;
    }
}