package com.ihk.indexReport.action;

import com.ihk.article.data.services.IArticleServices;
import com.ihk.customer.data.services.ICustomerServices;
import com.ihk.report.data.pojo.unitamount.ReportUnitAmountProject;
import com.ihk.report.data.pojo.unitamount.ReportUnitAmountProjectCond;
import com.ihk.report.data.services.IReportUnitAmountServices;
import com.ihk.saleunit.data.services.IConfirmServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.HighChartsUtils;
import com.ihk.utils.SupperAction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 多项目管理员
 * 总货量
 */

public class Report22Action extends SupperAction {

    @Autowired
    ICustomerServices customerServices;
    @Autowired
    IArticleServices iArticleServices;
    @Autowired
    IConfirmServices confirmServices;

    @Autowired
    IReportUnitAmountServices allUnitServices;


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
     * 货量获取
     * @return
     */
    public String getReport() {
        this.endDate = CommonUtils.getNowForString();
        ReportUnitAmountProjectCond cond = new ReportUnitAmountProjectCond();
        cond.setReturnCount(5);
        cond.setEndDate(this.endDate);
        List<ReportUnitAmountProject> list = allUnitServices.groupByProject(cond);


        this.categories = HighChartsUtils.listToString(list, "projectName");
        this.data = HighChartsUtils.listToString(list, "sumMoney");

        return "suc";
    }

}
