package com.ihk.indexReport.action;

import com.ihk.report.data.pojo.precustomer.ReportPreCustomerDate;
import com.ihk.report.data.pojo.precustomer.ReportPreCustomerDateCond;
import com.ihk.report.data.services.IReportPreCustomerServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.HighChartsUtils;
import com.ihk.utils.SupperAction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 销售人员
 * 售前客户趋势.
 */
public class Report46Action  extends SupperAction {
    @Autowired
    IReportPreCustomerServices iReportPreCustomerServices;


    //返回图形所需数据
    private String categories;
    private String data;
    private String endDate;


    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     * 售前客户趋势
     * @return
     */
    public String getReport() {
        this.endDate = CommonUtils.getNowForString();
        ReportPreCustomerDateCond cond = new ReportPreCustomerDateCond();
        cond.setReturnCount(5);
        cond.setEndDate(this.endDate);

        List<ReportPreCustomerDate> list = iReportPreCustomerServices.groupByDate(cond);

        this.categories = HighChartsUtils.listToString(list, "reportDate");
        this.data = HighChartsUtils.listToString(list, "sumCount");

        return "suc";
    }

}
