package com.ihk.saleunit.action.contract_unit;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ihk.constanttype.ContContractManager;
import com.ihk.saleunit.action.new_report.CommissionAction;
import com.ihk.utils.DateTimeUtils;
import com.ihk.utils.financial.FinancialUtils;
import com.ihk.utils.financial.MultManagerCommissionPojo;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.ContUnitSaleState;
import com.ihk.property.data.pojo.PropertyProject;
import com.ihk.property.data.services.IPropertyProjectServices;
import com.ihk.saleunit.data.pojo.ConfirmContractGather;
import com.ihk.saleunit.data.pojo.OtherExpenses;
import com.ihk.saleunit.data.pojo.OtherExpensesCond;
import com.ihk.saleunit.data.services.IConfirmServices;
import com.ihk.saleunit.data.services.IOtherExpensesServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.SupperAction;
import com.ihk.utils.saleunit.MyPropertyUtils;

public class GatherManagerAction extends CommissionAction{

    private static final long serialVersionUID = 1L;

    @Autowired
    IPropertyProjectServices propertyProjectServices;
    @Autowired
    IConfirmServices confirmServices;
    @Autowired
    IOtherExpensesServices otherExpensesServices;

    //
    /**
     * 楼盘项目下拉框
     */
    private Map<String, String> projectMap;

    /**
     * 单元状态
     */
    private Map<String, String> saleMap;

    /**
     * 楼盘项目id
     */
    private String propertyProjectId;

    /**
     * 楼盘项目
     */
    private PropertyProject propertyProject;

    /**
     * 销售状态
     */
    private String saleId;

    public void setPropertyProject(PropertyProject propertyProject) {
        this.propertyProject = propertyProject;
    }

    public PropertyProject getPropertyProject() {
        return propertyProject;
    }

    public void setSaleId(String saleId) {
        this.saleId = saleId;
    }

    public String getSaleId() {
        return saleId;
    }

    public void setPropertyProjectId(String propertyProjectId) {
        this.propertyProjectId = propertyProjectId;
    }

    public String getPropertyProjectId() {
        return propertyProjectId;
    }
    public void setSaleMap(Map<String, String> saleMap) {
        this.saleMap = saleMap;
    }

    public Map<String, String> getSaleMap() {
        return saleMap;
    }

    public void setProjectMap(Map<String, String> projectMap) {
        this.projectMap = projectMap;
    }

    public Map<String, String> getProjectMap() {
        return projectMap;
    }

    /**
     * 跳到汇总tab页面
     * @return
     * @throws Exception
     */
    public String toGatherTabs() throws Exception{

        //projectMap = PropertyProjectMapUtils.getMap(Integer.parseInt(request.getParameter("companyProjectId")));

        saleMap = ContUnitSaleState.getContractStateAll(false);

        propertyProject = propertyProjectServices.findPropertyProjectById(Integer.parseInt(propertyProjectId));
        if(propertyProject == null){
            //默认进来是空的
            propertyProject = new PropertyProject();
        }

        return "toGatherTabs";
    }

    /**
     * 汇总查找
     * @return
     * @throws Exception
     */
    public String gatherAjaxCount() throws Exception{

        List<MultManagerCommissionPojo> commissionList;
        List<MultManagerCommissionPojo> secondcommissionList;
        BigDecimal commission, secondcommission;

        JSONObject json = new JSONObject();

        if(CommonUtils.isStrZeroEmpty(propertyProjectId) || CommonUtils.isStrZeroEmpty(saleId)){

            CustomerUtils.writeResponse(response, "");

            return null;
        }

        //实时获取佣金点
        commissionList = FinancialUtils.getMultCommission(Integer.parseInt(propertyProjectId), 0, 0,ContContractManager.MAIN_CONTRACT);
        secondcommissionList= FinancialUtils.getMultCommission(Integer.parseInt(propertyProjectId), 0, 0, ContContractManager.SECOND_LINKAGE);
        commission = getCommission(commissionList);
        secondcommission = getCommission(secondcommissionList);

        //获取汇总数据
        List<ConfirmContractGather> gatherList;

        if(saleId.equals(ContUnitSaleState.CONFIRM_CONTRACT)){
            gatherList = confirmServices.findGatherByConfirmContract(propertyProjectId, saleId);
        } else {
            gatherList = confirmServices.findGatherByPropertyProjectIdAndSaleState(propertyProjectId, saleId);
        }

        if(!CommonUtils.isCollectionEmpty(gatherList)){

            int count = 0;

            BigDecimal buildArea = new BigDecimal(0);
            BigDecimal buildPrice = new BigDecimal(0);

            BigDecimal sumMoney = new BigDecimal(0);

            BigDecimal shouldAmount = new BigDecimal(0);
            BigDecimal paymentAmount = new BigDecimal(0);

            BigDecimal baseprice = new BigDecimal(0);

            BigDecimal totalBaseprice = new BigDecimal(0);

            BigDecimal relationAmount = new BigDecimal(0);
            BigDecimal secondLinkageAmount = new BigDecimal(0);
            String isRelation = "";
            String isSecondLinkage ="";

            for(ConfirmContractGather gather : gatherList){
                isRelation = gather.getRelation();
                isSecondLinkage = gather.getSecondLinkage();

                count += gather.getCount();
                buildArea = buildArea.add(gather.getBuildArea() == null ? new BigDecimal(0) : gather.getBuildArea());
                sumMoney = sumMoney.add(gather.getSumMoney() == null ? new BigDecimal(0) : gather.getSumMoney());

                if("1".equalsIgnoreCase(isRelation)){
                    //关系户
                    relationAmount = relationAmount.add(gather.getPaymentAmount() == null ? new BigDecimal(0) : gather.getPaymentAmount());
                    if("1".equalsIgnoreCase(isSecondLinkage)){
                        //一二手联动
                        secondLinkageAmount = secondcommission.multiply(gather.getSumMoney() == null ? new BigDecimal(0) : gather.getSumMoney())
                                .divide(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP);

                    }
                } else {
                    if("1".equalsIgnoreCase(isSecondLinkage)){
                        //一二手联动
                        secondLinkageAmount = secondcommission.multiply(gather.getSumMoney() == null ? new BigDecimal(0) : gather.getSumMoney())
                                .divide(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP);
                    }

                    //应收金额
                    shouldAmount = commission.multiply(gather.getSumMoney() == null ? new BigDecimal(0) : gather.getSumMoney())
                            .divide(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP);
                    //导入的应收
                    // shouldAmount = shouldAmount.add(gather.getShouldAmount() == null ? new BigDecimal(0) : gather.getShouldAmount());
                    //实收金额
                    paymentAmount = paymentAmount.add(gather.getPaymentAmount() == null ? new BigDecimal(0) : gather.getPaymentAmount());
                    //单价(溢价)
                    baseprice = baseprice.add(gather.getBaseprice() == null ? new BigDecimal(0) : gather.getBaseprice());
                    //总价(溢价)
                    totalBaseprice = totalBaseprice.add(gather.getTotalBaseprice() == null ? new BigDecimal(0) : gather.getTotalBaseprice());


                }
            }

            json.put("countTd", count);

            json.put("buildAreaTd", CommonUtils.moneyString(buildArea, 4));

            //成交单价 = 成交总价/成交建筑面积
            if(!CommonUtils.isBigDecimalEmpty(buildArea)){

                buildPrice = sumMoney.divide(buildArea, 0);
            }

            json.put("buildPriceTd", CommonUtils.moneyString(buildPrice));
            json.put("sumMoneyTd", CommonUtils.moneyString(sumMoney));
            json.put("shouldAmountTd", CommonUtils.moneyString(shouldAmount));
            json.put("paymentAmountTd", CommonUtils.moneyString(paymentAmount));

            json.put("secondLinkageAmountTd", CommonUtils.moneyString(secondLinkageAmount));
            json.put("relAmountTd", CommonUtils.moneyString(relationAmount));

            if (baseprice.equals(BigDecimal.ZERO)){
                json.put("priceOutTd", "-");//无溢价
            } else {
                json.put("priceOutTd", CommonUtils.moneyString(sumMoney.subtract(baseprice)));
            }

            if (totalBaseprice.equals(BigDecimal.ZERO)){
                json.put("totalPriceOutTd", "-");//无溢价
            } else {
                json.put("totalPriceOutTd", CommonUtils.moneyString(sumMoney.subtract(totalBaseprice)));
            }


            //otherExpensesTd
            BigDecimal otherMoney = new BigDecimal(0);

            OtherExpensesCond otherCond = new OtherExpensesCond();
            otherCond.setProjectId(Integer.parseInt(propertyProjectId));
            List<OtherExpenses> otherList = otherExpensesServices.findOtherExpensesForAjax(otherCond);
            if(!CommonUtils.isCollectionEmpty(otherList)){

                for(OtherExpenses other : otherList){

                    BigDecimal money = other.getExpensesMoney() == null ? new BigDecimal(0) : other.getExpensesMoney();
                    otherMoney = otherMoney.add(money);

                }
            }

            json.put("otherExpensesTd", CommonUtils.moneyString(otherMoney));

            //未收 = 一二手金额+关系户金额+应收 - 实收 - 其他
            paymentAmount = paymentAmount.add(relationAmount);
            paymentAmount = paymentAmount.add(secondLinkageAmount);
            json.put("notMoneyTd", CommonUtils.moneyString(shouldAmount.subtract(paymentAmount).subtract(otherMoney)));

        }

        CustomerUtils.writeResponse(response, json.toString());

        return null;
    }

    /**
     * 汇总- 各楼栋成交情况
     * @return
     * @throws Exception
     */
    public String gatherAjaxTable() throws Exception{
        List<ConfirmContractGather> gatherList;
        List<MultManagerCommissionPojo> secondcommissionList;
        List<MultManagerCommissionPojo> commissionList;
        BigDecimal buildArea,sumMoney,buildPrice ,shouldAmount,paymentAmount,baseprice,totalBaseprice;
        //处理一二手联动
        BigDecimal oth_buildArea,oth_sumMoney,oth_buildPrice ,oth_shouldAmount,oth_paymentAmount,oth_baseprice,oth_totalBaseprice;
        BigDecimal commission ,secondcommission;
        int pcount ,dcount;
        BigDecimal relationAmount = new BigDecimal(0);
        BigDecimal secondLinkageAmount = new BigDecimal(0);
        String isRelation = "";
        String isSecondLinkage ="";

        if(CommonUtils.isStrZeroEmpty(propertyProjectId) || CommonUtils.isStrZeroEmpty(saleId)){

            CustomerUtils.writeResponse(response, "[]");

            return null;
        }

        commissionList = FinancialUtils.getMultCommission(Integer.parseInt(propertyProjectId), 0, 0,ContContractManager.MAIN_CONTRACT);
        secondcommissionList= FinancialUtils.getMultCommission(Integer.parseInt(propertyProjectId), 0, 0, ContContractManager.SECOND_LINKAGE);

        commission = getCommission(commissionList);
        secondcommission = getCommission(secondcommissionList);

        if(saleId.equals(ContUnitSaleState.CONFIRM_CONTRACT)){
            gatherList = confirmServices.findGatherByConfirmContract(propertyProjectId, saleId);
        } else {
            gatherList = confirmServices.findGatherByPropertyProjectIdAndSaleState(propertyProjectId, saleId);
        }

        if(!CommonUtils.isCollectionEmpty(gatherList)){

            JSONArray rowsArray = new JSONArray();

            JSONObject json = null;

            for(ConfirmContractGather gather : gatherList){
                isRelation = gather.getRelation();
                isSecondLinkage = gather.getSecondLinkage();

                json = new JSONObject();

                if("0".equalsIgnoreCase(isRelation) && "0".equalsIgnoreCase(isSecondLinkage)){
                    pcount = gather.getCount();
                    json.put("buildName", MyPropertyUtils.getPropertyBuildServices().findPropertyBuildAreaNameByBuildId(gather.getBuildId()));
                    //套数
                    json.put("count", pcount);

                    //成交建筑面积
                    buildArea = gather.getBuildArea() == null ? new BigDecimal(0) : gather.getBuildArea();
                    json.put("buildArea",  CommonUtils.moneyString(buildArea, 4));

                    //成交总价
                    sumMoney = gather.getSumMoney() == null ? new BigDecimal(0) : gather.getSumMoney();
                    json.put("sumMoney", CommonUtils.moneyString(sumMoney));

                    buildPrice = new BigDecimal(0);
                    //成交单价 = 成交总价/成交建筑面积
                    if(!CommonUtils.isBigDecimalEmpty(buildArea)){
                        buildPrice = sumMoney.divide(buildArea, 2);
                    }

                    json.put("buildPrice", CommonUtils.moneyString(buildPrice));

                    shouldAmount = commission.multiply(sumMoney).divide(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP);

                    //导入应收金额
                    //BigDecimal shouldAmount = gather.getShouldAmount() == null ? new BigDecimal(0) : gather.getShouldAmount();
                    paymentAmount = gather.getPaymentAmount() == null ? new BigDecimal(0) : gather.getPaymentAmount();

                    //应收
                    json.put("shouldAmount", CommonUtils.moneyString(shouldAmount));
                    //实收
                    json.put("paymentAmount", CommonUtils.moneyString(paymentAmount));
                    //未收
                    json.put("notMoney", CommonUtils.moneyString(shouldAmount.subtract(paymentAmount)));

                    //单价溢价金额 = 成交单元单价总和 - 成交单元单价（底价）总和
                    baseprice = gather.getBaseprice() == null ? new BigDecimal(0) : gather.getBaseprice();
                    if (baseprice.equals(BigDecimal.ZERO)){
                        json.put("priceOut", "-");//无溢价
                    } else {
                        json.put("priceOut", CommonUtils.moneyString(sumMoney.subtract(baseprice)));
                    }


                    //总价溢价金额 = 成交单元总价总和 - 成交单元总价（底价）总和
                    totalBaseprice = gather.getTotalBaseprice() == null ? new BigDecimal(0) : gather.getTotalBaseprice();
                    if (baseprice.equals(BigDecimal.ZERO)){
                        json.put("totalPriceOut", "-"); //无溢价
                    } else {
                        json.put("totalPriceOut", CommonUtils.moneyString(sumMoney.subtract(totalBaseprice)));
                    }

                    //处理一二手联动金额、关系户金额
                    for(ConfirmContractGather gatherlist : gatherList){
                        if(gather.getBuildId()==gatherlist.getBuildId() && ("1".equalsIgnoreCase(gatherlist.getRelation()) || "1".equalsIgnoreCase(gatherlist.getSecondLinkage()))){

                            dcount = gatherlist.getCount();

                            oth_buildArea = gather.getBuildArea() == null ? new BigDecimal(0) : gather.getBuildArea();
                            oth_sumMoney = gatherlist.getSumMoney() == null ? new BigDecimal(0) : gatherlist.getSumMoney();
                            oth_shouldAmount = secondcommission.multiply(sumMoney).divide(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP);
                            oth_paymentAmount = gatherlist.getPaymentAmount() == null ? new BigDecimal(0) : gatherlist.getPaymentAmount();
                            oth_baseprice = gatherlist.getBaseprice() == null ? new BigDecimal(0) : gatherlist.getBaseprice();

                            if("1".equalsIgnoreCase(gatherlist.getRelation())){
                                //关系户金额
                                BigDecimal relCommissionAmount = getRelCommission(commissionList,"",oth_sumMoney);
                                json.put("relAmount", CommonUtils.moneyString(relCommissionAmount));
                            }

                            if("1".equalsIgnoreCase(gatherlist.getSecondLinkage())){
                                //一二手联动金额
                                //取
                                json.put("secondLinkageAmount", CommonUtils.moneyString(oth_shouldAmount));
                            }

                            //将面积、套数、成交单价相加
                            oth_buildArea = oth_buildArea.add(buildArea);
                            oth_sumMoney = oth_sumMoney.add(sumMoney);
                            oth_paymentAmount = oth_paymentAmount.add(paymentAmount);
                            json.put("count", pcount + dcount);
                            json.put("buildArea",  CommonUtils.moneyString(buildArea, 4));
                        }
                    }

                    rowsArray.add(json);
                }
            }

            CustomerUtils.writeResponse(response, rowsArray.toString());

            /**
             * <th field="buildName" width="100">楼栋名称</th>

             <th field="buildArea" width="80">总建筑面积</th>

             <th field="buildPrice" width="80">成交单价</th>

             <th field="sumMoney" width="80">成交总价</th>

             <th field="shouldAmount" width="80">应收金额</th>

             <th field="paymentAmount" width="80">实收金额</th>

             <th field="notMoney" width="80">未收金额</th>

             <th field="priceOut" width="80">单价溢价</th>

             <th field="totalPriceOut" width="80">总价溢价</th>
             */

        }else{

            CustomerUtils.writeResponse(response, "[]");
        }

        return null;
    }

    /**
     * 获取佣金
     * @return
     */
    private BigDecimal getCommission(List<MultManagerCommissionPojo> commissionList){
        BigDecimal commission = BigDecimal.ZERO;
        if (commissionList!=null && commissionList.size()>0){
            MultManagerCommissionPojo m = commissionList.get(0);
            commission = m.getCommission();
        }
        return commission;
    }
}
