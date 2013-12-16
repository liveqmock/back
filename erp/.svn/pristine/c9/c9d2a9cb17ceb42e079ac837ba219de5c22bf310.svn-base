package com.ihk.indexReport.action;

import com.ihk.article.data.services.IArticleServices;
import com.ihk.customer.data.services.ICustomerServices;
import com.ihk.saleunit.data.services.IConfirmServices;
import com.ihk.utils.SupperAction;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 * User: Lenovo
 * Date: 13-4-27
 * Time: 上午11:04
 * 应收佣金.
 */
public class Report14Action extends SupperAction {

    @Autowired
    ICustomerServices customerServices;
    @Autowired
    IArticleServices iArticleServices;
    @Autowired
    IConfirmServices confirmServices;


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
     * 应收佣金
     * @return 报表参数返回界面
     */
    public String getReport() {
        this.categories = "[ '广州',  '合盈',  '天津',  '北京',  '安徽']";
        this.data = "[49.9, 71.5, 106.4, 129.2, 144.0]";
        this.endDate = "2013-01-01";
        return "suc";
    }


}