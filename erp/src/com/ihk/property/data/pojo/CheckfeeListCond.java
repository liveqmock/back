package com.ihk.property.data.pojo;


import com.ihk.utils.SearchCond;

import java.util.Date;

/**
 * CheckfeeList的查询条件
 * @author
 *
 */
public class CheckfeeListCond extends SearchCond{

    private static final long serialVersionUID = -5639878529299557934L;


    private int propertyProjectId; //项目id
    private Date checkfeeDate; //对数日期

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
}
