package com.ihk.indexReport.action;

import com.ihk.article.data.services.IArticleServices;
import com.ihk.customer.data.services.ICustomerServices;
import com.ihk.report.data.pojo.precustomer.ReportPreCustomerCompany;
import com.ihk.report.data.pojo.precustomer.ReportPreCustomerCompanyCond;
import com.ihk.report.data.services.IReportPreCustomerServices;
import com.ihk.saleunit.data.services.IConfirmServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.HighChartsUtils;
import com.ihk.utils.SupperAction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Lenovo
 * Date: 13-4-28
 * Time: 下午6:37
 * 售前客户数.
 */
public class Report15Action extends SupperAction {

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
        ReportPreCustomerCompanyCond cond = new ReportPreCustomerCompanyCond();
        cond.setReturnCount(5);
        cond.setEndDate(this.endDate);

        List<ReportPreCustomerCompany> list = iReportPreCustomerServices.groupByCompany(cond);

        this.categories = HighChartsUtils.listToString(list, "companyName");
        this.data = HighChartsUtils.listToString(list, "sumCount");

        return "suc";
    }


}