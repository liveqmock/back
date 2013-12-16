package com.ihk.indexReport.action;

import com.ihk.article.data.services.IArticleServices;
import com.ihk.customer.data.services.ICustomerServices;
import com.ihk.report.data.pojo.unitsale.ReportUnitSaleProject;
import com.ihk.report.data.pojo.unitsale.ReportUnitSaleProjectCond;
import com.ihk.report.data.services.IReportUnitSaleServices;
import com.ihk.saleunit.data.services.IConfirmServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.HighChartsUtils;
import com.ihk.utils.SupperAction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 多项目管理员
 * 按项目销量图.
 */
public class Report23Action extends SupperAction {
    @Autowired
    ICustomerServices customerServices;
    @Autowired
    IArticleServices iArticleServices;
    @Autowired
    IConfirmServices confirmServices;

    @Autowired
    IReportUnitSaleServices reportUnitSaleServices;



    //返回图形所需数据
    private String categories;
    private String data;
    private String data2;
    private String data3;
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

    public String getData2() {
        return data2;
    }

    public void setData2(String data2) {
        this.data2 = data2;
    }

    public String getData3() {
        return data3;
    }

    public void setData3(String data3) {
        this.data3 = data3;
    }

    /**
     * 项目销量图
     * @return
     */
    public String getReport() {
        this.endDate = CommonUtils.getNowForString();
        ReportUnitSaleProjectCond cond = new ReportUnitSaleProjectCond();
        cond.setReturnCount(5);
        cond.setEndDate(this.endDate);
        List<ReportUnitSaleProject> list = reportUnitSaleServices.groupByProject(cond);


        this.categories = HighChartsUtils.listToString(list, "projectName");
        this.data = HighChartsUtils.listToString(list, "sumMoney");
        this.data2 = HighChartsUtils.listToString(list, "sumArea");
        this.data3 = HighChartsUtils.listToString(list, "sumUnit");


        return "suc";
    }



}