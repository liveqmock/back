package com.ihk.saleunit.action.new_report;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.EnumPrivCode;
import com.ihk.customer.data.pojo.CustomerCond;
import com.ihk.permission.PermissionUtils;
import com.ihk.property.data.pojo.CheckcommissionCond;
import com.ihk.property.data.pojo.PropertyUnitCond;
import com.ihk.property.data.services.ICheckcommissionServices;
import com.ihk.property.data.services.ICheckfeeServices;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.saleunit.data.pojo.ConfirmCond;
import com.ihk.saleunit.data.services.IConfirmServices;
import com.ihk.saleunit.data.services.IContractServices;
import com.ihk.user.data.pojo.CompanyProjectCond;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.DateTimeUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.SupperAction;
import com.ihk.utils.financial.MultManagerCommissionPojo;

/**
 * Created with IntelliJ IDEA.
 * User: Lenovo
 * Date: 13-8-22
 * Time: 下午2:36
 * 结佣表.
 */
public class CommissionAction extends SupperAction {
    @Autowired
    IPropertyUnitServices propertyUnitServices;
    @Autowired
    IConfirmServices confirmServices;
    @Autowired
    IContractServices contractServices;
    @Autowired
    ICheckcommissionServices checkcommissionServices;
    @Autowired
    ICheckfeeServices checkfeeServices;

    protected ConfirmCond confirmCond;
    protected CustomerCond customerCond;
    protected String projectName;
    protected PropertyUnitCond propertyUnitCond;
    protected CompanyProjectCond companyProjectCond;
    protected String showTrs;

    public String getShowTrs() {
        return showTrs;
    }

    public void setShowTrs(String showTrs) {
        this.showTrs = showTrs;
    }

    public CompanyProjectCond getCompanyProjectCond() {
        return companyProjectCond;
    }

    public void setCompanyProjectCond(CompanyProjectCond companyProjectCond) {
        this.companyProjectCond = companyProjectCond;
    }

    public PropertyUnitCond getPropertyUnitCond() {
        return propertyUnitCond;
    }

    public void setPropertyUnitCond(PropertyUnitCond propertyUnitCond) {
        this.propertyUnitCond = propertyUnitCond;
    }

    public String getProjectName() {
        if (projectName == null && customerCond != null) {
            projectName = DescUtils.getCompanyProjectRealName(customerCond.getProjectId());
        }
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public CustomerCond getCustomerCond() {
        return customerCond;
    }

    public void setCustomerCond(CustomerCond customerCond) {
        this.customerCond = customerCond;
    }

    public void initSearchDate() {
        if (propertyUnitCond == null) {
            propertyUnitCond = new PropertyUnitCond();

            propertyUnitCond.addPermissionCompanyProjectIds(
                    PermissionUtils.getUserProjectIdList(EnumPrivCode.REPORT_SALEUNIT_STAT));
            propertyUnitCond.setSearchCompanyProjectIds(propertyUnitCond.getPrivCompanyProjectIds());

            propertyUnitCond.setDate2(CommonUtils.getMonthEndForString());
            propertyUnitCond.setDate1(CommonUtils.getMonthFirstForString());

        }
    }

    public void initListDate() {
        if (customerCond == null) {
            customerCond = new CustomerCond();
            customerCond.addPermissionChartProjectIds();
            customerCond.setSearchProjectIds(customerCond.getPrivProjectIds());
        }
        List<Integer> prlist = PermissionUtils.getUserProjectIdList(EnumPrivCode.REPORT_PRECUSTOMER_DOWNLOAD);

        if (prlist != null && prlist.size() == 1) {
            this.customerCond.setProjectId(prlist.get(0));
            this.projectName = DescUtils.getCompanyProjectRealName(prlist.get(0));
        }

        HttpSession session = request.getSession();
        session.setAttribute("customerCond", customerCond);

    }

    /**
     * 合计佣金计算方式
     * @param shouldAmount 应收金额（一手，跳bar）
     * @param shouldAmount2  一二手联动
     * @param relCommissionAmount 关系户佣金
     * @return
     */
    public BigDecimal sumShouldAmount (BigDecimal shouldAmount,BigDecimal shouldAmount2,BigDecimal relCommissionAmount){
        BigDecimal sumAmount = BigDecimal.ZERO;
        if(relCommissionAmount.compareTo(BigDecimal.ZERO)==0){
            //非关系户合计
            sumAmount = shouldAmount.add(shouldAmount2);
        } else {
            //关系户时合计
            sumAmount = relCommissionAmount.add(shouldAmount2);
        }
        return sumAmount;
    }
    /**
     * 判断是否一二手联动
     * @param mapobject
     * @return
     */
    public boolean isSecondLinkage( Map<String, Object> mapobject ){
        return !(mapobject.get("is_second_linkage") == null || mapobject.get("is_second_linkage").equals(
                "") || mapobject.get("is_second_linkage").equals("0"));
    }
    
    public boolean isRelation(Map<String,Object> mapobject){
    	return !(mapobject.get("is_relation") == null || mapobject.get("is_relation").equals(
                "") || mapobject.get("is_relation").equals("0"));
    }

    /**
     * 获取对应的佣金
     * @param list
     * @param work_date
     * @return
     */
    public BigDecimal getCommission(List<MultManagerCommissionPojo> list,String work_date) throws Exception {
        BigDecimal commission = new BigDecimal(0);
        if (list==null) return commission;
        try {
            for (int i=0;i<list.size();i++){
                MultManagerCommissionPojo m = (MultManagerCommissionPojo)list.get(i);

                if (!CommonUtils.isStrEmpty(work_date)){
                    Date workDate = CommonUtils.getDateFromString(work_date);
                    Date startDate = m.getStartDate();
                    Date endDate = m.getEndDate();
                    //如果合同截止日期不填，判断时默认一个日期（开始日期后10年）
                    if(endDate==null) endDate = CommonUtils.getAfterDateForDay(startDate,360*10);
                    if(DateTimeUtils.isDateBetween(startDate, endDate, workDate)){
                        commission = m.getCommission();
                    }
                }

            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        return commission;
    }

    /**
     * 有效范围内取关系户佣金
     * @param list
     * @param work_date
     * @param sumPrice
     * @return
     * @throws Exception
     */
    public BigDecimal getRelCommission(List<MultManagerCommissionPojo> list,String work_date,BigDecimal sumPrice) throws Exception {
        BigDecimal commission = new BigDecimal(0);
        BigDecimal relationCommission = new BigDecimal(0);
        BigDecimal relationMoney = new BigDecimal(0);

        if (list==null) return commission;
        try {
            for (int i=0;i<list.size();i++){
                MultManagerCommissionPojo m = list.get(i);

                if (!CommonUtils.isStrEmpty(work_date)){
                    Date workDate = CommonUtils.getDateFromString(work_date);
                    Date startDate = m.getStartDate();
                    Date endDate = m.getEndDate();
                    //如果合同截止日期不填，判断时默认一个日期（开始日期后10年），确保不到期
                    if(endDate==null) endDate = CommonUtils.getAfterDateForDay(startDate,360*10);
                    if(DateTimeUtils.isDateBetween(startDate,endDate,workDate)){
                        relationCommission = m.getRelationCommission();
                        relationMoney = m.getRelationMoney();
                        if(relationCommission!=null && relationCommission.compareTo(BigDecimal.ZERO)==1){
                            commission = relationCommission.multiply(sumPrice).divide(new BigDecimal(100)).setScale(2,BigDecimal.ROUND_HALF_UP);
                        }
                        if(relationMoney!=null && relationMoney.compareTo(BigDecimal.ZERO)==1){
                            commission = relationMoney;
                        }

                    }
                } else {
                    //处理没有日期的情况
                    relationCommission = m.getRelationCommission();
                    relationMoney = m.getRelationMoney();
                    if(relationCommission!=null && relationCommission.compareTo(BigDecimal.ZERO)==1){
                        commission = relationCommission.multiply(sumPrice).divide(new BigDecimal(100)).setScale(2,BigDecimal.ROUND_HALF_UP);
                    }
                    if(relationMoney!=null && relationMoney.compareTo(BigDecimal.ZERO)==1){
                        commission = relationMoney;
                    }
                }

            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        return commission;
    }

    /**
     * 通过单元获取 实收金额等
     * @param unitId
     * @return
     */
    public Map<String, Object> sumByUnitId(String unitId){

        Map<String, Object> mapsum = null;
        CheckcommissionCond cond = new CheckcommissionCond();
        cond.setUnitId(Integer.parseInt(unitId));

        List<Map<String, Object>> sumlist = checkcommissionServices.sumByUnitId(cond);

        if (sumlist!=null && sumlist.size()>0){
            mapsum = sumlist.get(0);
        }
        return mapsum;
    }
    
}
