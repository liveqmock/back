package com.ihk.indexReport.action;

import com.ihk.report.data.pojo.commission.ReportCommissionCond;
import com.ihk.report.data.pojo.precustomer.ReportPreCustomerCompanyCond;
import com.ihk.report.data.pojo.precustomer.ReportPreCustomerCond;
import com.ihk.report.data.pojo.unitamount.ReportUnitAmountCond;
import com.ihk.report.data.pojo.unitsale.ReportUnitSaleCond;
import com.ihk.report.data.services.IReportCommissionServices;
import com.ihk.report.data.services.IReportPreCustomerServices;
import com.ihk.report.data.services.IReportUnitAmountServices;
import com.ihk.report.data.services.IReportUnitSaleServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.SupperAction;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: Lenovo
 * Date: 13-5-2
 * Time: 下午2:06
 * 汇总.
 */
public class Report18Action  extends SupperAction {
    private final Logger logger = Logger.getLogger(Report18Action.class);

    @Autowired
    IReportPreCustomerServices reportPreCustomerServices;
    @Autowired
    IReportUnitAmountServices reportAllUnitServices;
    @Autowired
    IReportCommissionServices reportCommissionServices;

    @Autowired
    IReportUnitSaleServices reportUnitSaleServices;

    //返回图形所需数据
    private String categories;
    private String data;
    private String data2;
    private String data3;
    private String data4;
    private String data5;
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

    public String getData4() {
        return data4;
    }

    public void setData4(String data4) {
        this.data4 = data4;
    }

    public String getData5() {
        return data5;
    }

    public void setData5(String data5) {
        this.data5 = data5;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     * 获取报表数据
     * @return
     */
    public String getReport() {
        this.endDate = CommonUtils.getNowForString();
        ReportPreCustomerCompanyCond cond = new ReportPreCustomerCompanyCond();
        cond.setReturnCount(5);
        cond.setEndDate(this.endDate);


        //售前客户数
        ReportPreCustomerCompanyCond preCustomerCompanyCond = new ReportPreCustomerCompanyCond();
        logger.info("售前客户数groupby:"+reportPreCustomerServices.groupByCompany(preCustomerCompanyCond));
        //总货量
        ReportUnitAmountCond allUnitCond = new ReportUnitAmountCond();
        try{
            data = (reportAllUnitServices.getSumMoney(allUnitCond)).toString();
        } catch (NullPointerException npe){
            data = "0";
        }

        logger.info("总货量:" +data);
        //总销量
        ReportUnitSaleCond unitSaleCond = new ReportUnitSaleCond();
        try{
            data2 = reportUnitSaleServices.getSumMoney(unitSaleCond).toString();
        } catch (NullPointerException npe){
            data2 = "0";
        }
        logger.info("总销量:" + data2);
        //总应收佣金
        ReportCommissionCond commissionCond = new ReportCommissionCond();
        try{
            data3 = reportCommissionServices.getSumMoney(commissionCond).toString();
        } catch (NullPointerException npe){
            data3 = "0";
        }
        logger.info("总应收佣金:" + data3);
        //售前客户数
        ReportPreCustomerCond preCustomerCond = new ReportPreCustomerCond();
        data4 = reportPreCustomerServices.getSumNumber(preCustomerCond)+"";
        logger.info("售前客户数:" + data4);

        return "suc";
    }

}