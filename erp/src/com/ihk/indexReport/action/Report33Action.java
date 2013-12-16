package com.ihk.indexReport.action;

import com.ihk.report.data.pojo.unitsale.ReportUnitSaleSalesman;
import com.ihk.report.data.pojo.unitsale.ReportUnitSaleSalesmanCond;
import com.ihk.report.data.services.IReportUnitSaleServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.HighChartsUtils;
import com.ihk.utils.SupperAction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Lenovo
 * Date: 13-5-10
 * Time: 下午4:52
 * 销售人员业绩排行榜.
 */
public class Report33Action extends SupperAction {

    @Autowired
    IReportUnitSaleServices iReportUnitSaleServices;


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
     * 销售人员业绩排行榜
     * @return
     */
    public String getReport() {
        this.endDate = CommonUtils.getNowForString();
        ReportUnitSaleSalesmanCond cond = new ReportUnitSaleSalesmanCond();
        cond.setReturnCount(5);
        cond.setEndDate(this.endDate);

        List<ReportUnitSaleSalesman> list = iReportUnitSaleServices.groupBySalesman(cond);

        this.categories = HighChartsUtils.listToString(list, "salesmanName");
        this.data = HighChartsUtils.listToString(list, "sumMoney");

        return "suc";
    }


}