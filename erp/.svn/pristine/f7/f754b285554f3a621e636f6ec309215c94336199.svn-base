package com.ihk.indexReport.action;

import com.ihk.article.data.services.IArticleServices;
import com.ihk.customer.data.services.ICustomerServices;
import com.ihk.report.data.pojo.commission.ReportCommissionCond;
import com.ihk.report.data.pojo.precustomer.ReportPreCustomerCompanyCond;
import com.ihk.report.data.pojo.precustomer.ReportPreCustomerCond;
import com.ihk.report.data.pojo.unitamount.ReportUnitAmountCompany;
import com.ihk.report.data.pojo.unitamount.ReportUnitAmountCompanyCond;
import com.ihk.report.data.pojo.unitamount.ReportUnitAmountCond;
import com.ihk.report.data.pojo.unitsale.ReportUnitSaleCompany;
import com.ihk.report.data.pojo.unitsale.ReportUnitSaleCompanyCond;
import com.ihk.report.data.pojo.unitsale.ReportUnitSaleCond;
import com.ihk.report.data.services.IReportCommissionServices;
import com.ihk.report.data.services.IReportUnitAmountServices;
import com.ihk.report.data.services.IReportUnitSaleServices;
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
 * Date: 13-4-27
 * Time: 上午10:58
 * To change this template use File | Settings | File Templates.
 */
public class Report13Action extends SupperAction {

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
     * 月销量获取
     * @return
     */
    public String getReport() {
        this.endDate = CommonUtils.getNowForString();
        ReportUnitSaleCompanyCond cond = new ReportUnitSaleCompanyCond();
        cond.setReturnCount(5);
        cond.setEndDate(this.endDate);
        List<ReportUnitSaleCompany> list = reportUnitSaleServices.groupByCompany(cond);


        this.categories = HighChartsUtils.listToString(list, "companyName");
        this.data = HighChartsUtils.listToString(list, "sumMoney");
        this.data2 = HighChartsUtils.listToString(list, "sumArea");
        this.data3 = HighChartsUtils.listToString(list, "sumUnit");


        return "suc";
    }


}
