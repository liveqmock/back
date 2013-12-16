package com.ihk.property.data.pojo;

import com.ihk.utils.SearchCond;

import java.util.Date;

public class CheckcommissionListSecCond extends SearchCond{

    private static final long serialVersionUID = -3920723116193377413L;

    private int propertyProjectId; //项目id
    private Date checkfeeDate; //对佣日期
    private Date checkcommissionDate; //对佣日期
    private int checkcommissionType; //对佣状态

    public int getPropertyProjectId() {
        return propertyProjectId;
    }

    public void setPropertyProjectId(int propertyProjectId) {
        this.propertyProjectId = propertyProjectId;
    }

    public Date getCheckfeeDate() {
        return checkfeeDate;
    }

    public void setCheckfeeDate(Date checkfeeDate) {
        this.checkfeeDate = checkfeeDate;
    }

    public Date getCheckcommissionDate() {
        return checkcommissionDate;
    }

    public void setCheckcommissionDate(Date checkcommissionDate) {
        this.checkcommissionDate = checkcommissionDate;
    }

    public int getCheckcommissionType() {
        return checkcommissionType;
    }

    public void setCheckcommissionType(int checkcommissionType) {
        this.checkcommissionType = checkcommissionType;
    }
}
