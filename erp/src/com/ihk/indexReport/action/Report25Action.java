package com.ihk.indexReport.action;

import com.ihk.report.data.pojo.precustomer.ReportPreCustomerProject;
import com.ihk.report.data.pojo.precustomer.ReportPreCustomerProjectCond;
import com.ihk.report.data.services.IReportPreCustomerServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.HighChartsUtils;
import com.ihk.utils.SupperAction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 多项目管理员
 * 售前客户数量.
 */
public class Report25Action  extends SupperAction {

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
     * 售前客户数
     * @return
     */
    public String getReport() {
        this.endDate = CommonUtils.getNowForString();
        ReportPreCustomerProjectCond cond = new ReportPreCustomerProjectCond();
        cond.setReturnCount(5);
        cond.setEndDate(this.endDate);

        List<ReportPreCustomerProject> list = iReportPreCustomerServices.groupByProject(cond);

        this.categories = HighChartsUtils.listToString(list, "projectName");
        this.data = HighChartsUtils.listToString(list, "sumCount");

        return "suc";
    }


}