package com.ihk.utils.base;

import java.io.Serializable;
import java.util.Date;

import com.ihk.utils.SessionUser;

/**
 * 主要兼容旧代码中只是标示删除,而没有记录mod_id,mod_time的bug
 * @author dtc
 * 2012-8-1
 */
public class PojoDeleteCond implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id; //标示删除的pojo的主键id

    private int unitId; //标示删除的unit_id

    private Date checkfeeDate; //标示删除的对数日期

    private int modId; //操作者的id

    private Date modTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    public void setModTime(Date modTime) {
        this.modTime = modTime;
    }

    public Date getCheckfeeDate() {
        return checkfeeDate;
    }

    public void setCheckfeeDate(Date checkfeeDate) {
        this.checkfeeDate = checkfeeDate;
    }

    public PojoDeleteCond(int id) {
        this.id = id;
        modId = SessionUser.getUserId();
        modTime = new Date();
    }

    public PojoDeleteCond() {}


}
