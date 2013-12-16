package com.ihk.saleunit.action.check_fee.pojo;

import com.ihk.utils.SearchCond;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Lenovo
 * Date: 13-6-8
 * Time: 下午6:35
 * 对数表用
 */
public class CheckFeeCond extends SearchCond implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id; //主键id

    private int unitId; //单元

    private Date checkfeeDate; //对数日期

    private int checkfeeType; //对数日期

    private int checkcommissionType; //对佣状态

    private int modId; //操作者的id

    private Date modTime;

    private BigDecimal repayMoney;

    public CheckFeeCond() {
    }

    public CheckFeeCond(int id, int unitId, Date checkfeeDate) {
        this.id = id;
        this.unitId = unitId;
        this.checkfeeDate = checkfeeDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCheckcommissionType() {
        return checkcommissionType;
    }

    public void setCheckcommissionType(int checkcommissionType) {
        this.checkcommissionType = checkcommissionType;
    }

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    public Date getCheckfeeDate() {
        return checkfeeDate;
    }

    public void setCheckfeeDate(Date checkfeeDate) {
        this.checkfeeDate = checkfeeDate;
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

    public int getCheckfeeType() {
        return checkfeeType;
    }

    public void setCheckfeeType(int checkfeeType) {
        this.checkfeeType = checkfeeType;
    }

    public BigDecimal getRepayMoney() {
        return repayMoney;
    }

    public void setRepayMoney(BigDecimal repayMoney) {
        this.repayMoney = repayMoney;
    }
}
