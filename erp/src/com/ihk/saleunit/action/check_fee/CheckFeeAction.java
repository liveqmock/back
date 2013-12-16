package com.ihk.saleunit.action.check_fee;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.ihk.constanttype.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.customer.data.pojo.CustomerCond;
import com.ihk.permission.PermissionUtils;
import com.ihk.property.data.pojo.CheckfeeList;
import com.ihk.property.data.pojo.CheckfeeListCond;
import com.ihk.property.data.pojo.PropertyBuild;
import com.ihk.property.data.pojo.PropertyUnitCond;
import com.ihk.property.data.services.ICheckfeeListServices;
import com.ihk.property.data.services.ICheckfeeServices;
import com.ihk.property.data.services.IContractManagerServices;
import com.ihk.property.data.services.IPropertyBuildServices;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.saleunit.data.pojo.ConfirmCond;
import com.ihk.saleunit.data.pojo.SaleUnitReceipt;
import com.ihk.saleunit.data.services.IConfirmServices;
import com.ihk.saleunit.data.services.IContractServices;
import com.ihk.saleunit.data.services.ISaleUnitReceiptServices;
import com.ihk.user.data.pojo.CompanyProjectCond;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;
import com.ihk.utils.contract.customer.ContractCustomerUtils;
import com.ihk.utils.useraccount.UserAccountUtils;
import com.opensymphony.xwork2.ActionContext;

/**
 * Created with IntelliJ IDEA.
 * User: Lenovo
 * Date: 13-5-31
 * Time: 上午10:56
 * 对数表管理
 */
public class CheckFeeAction extends SupperAction {
	
    private static final long serialVersionUID = -1703952876676879831L;
    
	@Autowired
    IPropertyUnitServices propertyUnitServices;
    @Autowired
    protected
    IConfirmServices confirmServices;
    @Autowired
    IContractServices contractServices;
    @Autowired
    protected
    IPropertyBuildServices iPropertyBuildServices;
    @Autowired
    protected
    ICheckfeeServices iCheckfeeServices;
    @Autowired
    ICheckfeeListServices iCheckfeeListServices;
    @Autowired
    protected
    ISaleUnitReceiptServices iSaleUnitReceiptServices;
    @Autowired
    IContractManagerServices contractManagerServices;

    protected String separator = ":";

    protected ConfirmCond confirmCond;
    protected CustomerCond customerCond;
    protected String projectName;
    protected PropertyUnitCond propertyUnitCond;
    protected CompanyProjectCond companyProjectCond;

    protected Map<String, String> saleMap;//单元状态
    protected Map<String, String> checkFeeTypeMap;//对数状态

    protected String ALL_REFUND = ContContractManager.ALL_REFUND; //全额回款
    protected String PART_REFUND = ContContractManager.PART_REFUND; //部分回款

    public ConfirmCond getConfirmCond() {
        return confirmCond;
    }

    public void setConfirmCond(ConfirmCond confirmCond) {
        this.confirmCond = confirmCond;
    }

    public CustomerCond getCustomerCond() {
        return customerCond;
    }

    public void setCustomerCond(CustomerCond customerCond) {
        this.customerCond = customerCond;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public PropertyUnitCond getPropertyUnitCond() {
        return propertyUnitCond;
    }

    public void setPropertyUnitCond(PropertyUnitCond propertyUnitCond) {
        this.propertyUnitCond = propertyUnitCond;
    }

    public CompanyProjectCond getCompanyProjectCond() {
        return companyProjectCond;
    }

    public void setCompanyProjectCond(CompanyProjectCond companyProjectCond) {
        this.companyProjectCond = companyProjectCond;
    }

    public Map<String, String> getSaleMap() {
        return saleMap;
    }

    public void setSaleMap(Map<String, String> saleMap) {
        this.saleMap = saleMap;
    }

    public Map<String, String> getCheckFeeTypeMap() {
        return checkFeeTypeMap;
    }

    public void setCheckFeeTypeMap(Map<String, String> checkFeeTypeMap) {
        this.checkFeeTypeMap = checkFeeTypeMap;
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

    public void initSearchDate() {
        if (propertyUnitCond == null) {
            propertyUnitCond = new PropertyUnitCond();

			propertyUnitCond.addPermissionCompanyProjectIds(PermissionUtils.getUserProjectIdList(EnumPrivCode.REPORT_SALEUNIT_STAT));
            propertyUnitCond.setSearchCompanyProjectIds(propertyUnitCond.getPrivCompanyProjectIds());

        }
    }

    /**
     * 获取销售名字
     * @param salesId
     * @return
     */
    public String getSalesName(String salesId){

        String name = UserAccountUtils.getRealNameByIds(salesId);

        return name == null ? "" : name;
    }

    public void setCond(){
        String projectId = request.getParameter("projectIds");
        String sBuildId = request.getParameter("buildId");
        String sAreaId = request.getParameter("areaId");
        String saleState = request.getParameter("saleState");
        String checkFeeDate = request.getParameter("checkFeeDate");
        String checkFeeType = request.getParameter("checkFeeType");

        List<Integer> projectIds = new ArrayList<Integer>();
        projectIds.add(Integer.parseInt(projectId));
        int projectid = projectId == null || projectId.length() == 0 ? 0 : Integer.parseInt(projectId);
        int buildId = sBuildId == null || sBuildId.length() == 0 ? 0 : Integer.parseInt(sBuildId);
        int areaId = sAreaId == null || sAreaId.length() == 0 ? 0 : Integer.parseInt(sAreaId);

        confirmCond = new ConfirmCond();
        confirmCond.setProjectIds(projectIds);
        confirmCond.setBuildId(sBuildId);
        confirmCond.setAreaId(sAreaId);
        confirmCond.setSaleState(saleState);
        confirmCond.setCheckFeeDate(checkFeeDate);
        confirmCond.setCheckFeeType(checkFeeType);

    }

    /**
     * 对数列表
     * @param confirmCond
     * @return  生成json返回
     */
    public String unitList(ConfirmCond confirmCond) {
        JSONArray checkFeeArray = new JSONArray(); //list
        JSONArray checkFeeFooterArray = new JSONArray(); //footer 合计
        JSONObject checkFeeMap = new JSONObject();
        JSONObject unitList;

        BigDecimal SUM_build_area = new BigDecimal(0); //建筑面积
        BigDecimal SUM_build_price = new BigDecimal(0);//成交单价
        BigDecimal SUM_sum_money = new BigDecimal(0); //成交金额

        BigDecimal SUM_repayMoney = new BigDecimal(0); //回款金额
        BigDecimal SUM_repayAmount = new BigDecimal(0); //回款总金额
        String repayMoney ,repayAmount;
        BigDecimal b_repayMoney = new BigDecimal(0) ,b_repayAmount = new BigDecimal(0);

        List<Map<String, Object>> listConfirmUnit = null;
        String strCheckFeeType = confirmCond.getCheckFeeType();
        int iCheckFeeType = 0;
        //根据条件进行查询（实现全额与部分回款查询）
        if(CommonUtils.isStrEmpty(strCheckFeeType)) {
            //没有回款类别时
            listConfirmUnit = confirmServices.checkFeeList(confirmCond);
        } else {
            iCheckFeeType = Integer.parseInt(strCheckFeeType);
            if(iCheckFeeType==EnumUnitCheckfeeType.CheckFeeIng.getValue() ||
                    iCheckFeeType==EnumUnitCheckfeeType.CheckFeeEd.getValue()){
                //状态：对数中和已对数时 查询，查询表checkfee
                listConfirmUnit = confirmServices.checkFeeListByType(confirmCond);
            } else {
                listConfirmUnit = confirmServices.checkFeeList(confirmCond);
            }
        }


        int recordCount = 0;
        if (listConfirmUnit != null) {
            recordCount = listConfirmUnit.size();
        }

        try {

            //循环房间，归类到项目中
            for (int i = 0; i < recordCount; i++) {

                Map<String, Object> mapobject = listConfirmUnit.get(i);
                int mainId; //合同客户表中
                String customerName,checkfeeId;

                //销售状态
                //String sale_state = mapobject.get("sale_state").toString();
                //单元成交或合同总金额
                String sum_money = mapobject.get("contract_sum_money") == null ? "0" : mapobject.get("contract_sum_money").toString();
                //实收金额
                String payment_amount = mapobject.get("payment_amount") == null ? "0" : mapobject.get("payment_amount").toString();
                //单价（建筑面积）
                String build_price = mapobject.get("build_price") == null ? "0" : mapobject.get("build_price").toString();


                if (confirmCond.getSaleState()!=null && confirmCond.getSaleState().equals(ContUnitSaleState.CONFIRM)) {
                    //获取成交价格和金额
                    sum_money = mapobject.get("confirm_sum_money") == null ? "0" : mapobject.get("confirm_sum_money").toString();
                    checkFeeMap.put("pay_name", mapobject.get("confirm_pay_name")==null?"": mapobject.get("confirm_pay_name").toString());
                    checkFeeMap.put("sales",mapobject.get("confirm_sales_id")==null?"": getSalesName(
                            mapobject.get("confirm_sales_id").toString()));

                    mainId =  Integer.parseInt(mapobject.get("confirm_id").toString());
                    customerName = ContractCustomerUtils.getCustomerNameByMainIdAndConfirmType(mainId,
                            ContConfirmType.CONFIRM);

                } else {
                    //查询条件没有销售状态
                    String saleState = mapobject.get("sale_state").toString();
                    if(saleState.equals(ContUnitSaleState.CONFIRM)) {
                       //成交
                        sum_money = mapobject.get("confirm_sum_money") == null ? "0" : mapobject.get("confirm_sum_money").toString();
                        checkFeeMap.put("pay_name", mapobject.get("confirm_pay_name")==null?"": mapobject.get("confirm_pay_name").toString());
                        checkFeeMap.put("sales",mapobject.get("confirm_sales_id")==null?"": getSalesName(
                                mapobject.get("confirm_sales_id").toString()));

                        mainId =  Integer.parseInt(mapobject.get("confirm_id").toString());
                        customerName = ContractCustomerUtils.getCustomerNameByMainIdAndConfirmType(mainId,
                                ContConfirmType.CONFIRM);
                    } else {
                        //合同
                        checkFeeMap.put("pay_name",mapobject.get("contract_pay_name")==null?"": mapobject.get("contract_pay_name").toString());
                        checkFeeMap.put("sales",mapobject.get("contract_sales_id")==null?"": getSalesName(mapobject.get("contract_sales_id").toString()));

                        mainId =  Integer.parseInt(mapobject.get("contract_id").toString());
                        customerName = ContractCustomerUtils.getCustomerNameByMainIdAndConfirmType(mainId,
                                ContConfirmType.CONTRACT);
                    }
                }

                //认购日期
                String work_date = mapobject.get("work_date")==null?"":mapobject.get("work_date").toString();
                //签约日期
                String sign_date = mapobject.get("sign_date")==null?"":mapobject.get("sign_date").toString();
                //对数日期
                String checkfee_date = mapobject.get("checkfee_date")==null?"":mapobject.get("checkfee_date").toString();

                work_date = CommonUtils.getDateString(CommonUtils.getDateFromString(work_date));
                sign_date = CommonUtils.getDateString(CommonUtils.getDateFromString(sign_date));
                checkfee_date = CommonUtils.getDateString(CommonUtils.getDateFromString(checkfee_date));

                //类型转换String 2 BigDecimal
                BigDecimal b_sum_money = CommonUtils.exceptionToZero(sum_money).setScale(2, BigDecimal.ROUND_HALF_UP);
                BigDecimal b_payment_amount = CommonUtils.exceptionToZero(payment_amount).setScale(2, BigDecimal.ROUND_HALF_UP);
                BigDecimal b_build_price = new BigDecimal(build_price).setScale(0, BigDecimal.ROUND_HALF_UP);
                SUM_build_area = SUM_build_area.add(new BigDecimal(mapobject.get("BUILD_AREA").toString()));
                SUM_build_price = SUM_build_price.add(b_build_price);
                SUM_sum_money = SUM_sum_money.add(b_sum_money);

                String unit_id = mapobject.get("unit_id")==null?"":mapobject.get("unit_id").toString();
                String build_id = mapobject.get("build_id")==null?"":mapobject.get("build_id").toString();
                PropertyBuild build = iPropertyBuildServices.findPropertyBuildById(Integer.parseInt(build_id));

                String checkcommission_type = mapobject.get("checkcommission_type")==null?"0": mapobject.get("checkcommission_type").toString();

                checkFeeMap.put("checkcommissionType",checkcommission_type);
                checkFeeMap.put("checkcommissionTypeName", EnumUnitCheckCommissionType.getTextByValue(Integer.parseInt(checkcommission_type)));
                checkFeeMap.put("unit_id",unit_id);
                checkFeeMap.put("work_date", work_date);
                checkFeeMap.put("sign_date", sign_date);
                checkFeeMap.put("checkfee_date",checkfee_date);
                checkFeeMap.put("checkfeeTypeName", mapobject.get("checkfee_type")==null?"": EnumUnitCheckfeeType.getTextByValue(
                        Integer.parseInt(mapobject.get("checkfee_type").toString())));
                checkFeeMap.put("area_name",build.getAreaName());
                checkFeeMap.put("build_name", mapobject.get("build_name")==null?"":mapobject.get("build_name").toString());
                checkFeeMap.put("unit_no", mapobject.get("unit_no")==null?"":mapobject.get("unit_no").toString());
                checkFeeMap.put("customer_name", customerName);
                checkFeeMap.put("contract_no",mapobject.get("contract_no") == null ? "" : mapobject.get("contract_no").toString());
                checkFeeMap.put("build_area", mapobject.get("BUILD_AREA"));
                checkFeeMap.put("build_price", CommonUtils.moneyString(b_build_price, 0, ""));
                checkFeeMap.put("sum_price", CommonUtils.moneyString(b_sum_money, 0, ""));
                checkFeeMap.put("payment_amount", CommonUtils.moneyString(b_payment_amount, 0, ""));

                //获取回款金额，记录回款数据，勾选加入对数表后更新回款表的日期和状态

                /*if(iCheckFeeType==EnumUnitCheckfeeType.CheckFeeIng.getValue() ||
                        iCheckFeeType==EnumUnitCheckfeeType.CheckFeeEd.getValue()) {
                    //对数中 和 已对数 直接读取 checkfee表
                    checkfeeId = mapobject.get("checkfeeID").toString();
                    repayMoney =  mapobject.get("repay_money") == null ? "0" : mapobject.get("repay_money").toString();
                    repayAmount =  mapobject.get("repay_amount") == null ? "0" : mapobject.get("repay_amount").toString();


                    checkFeeMap.put("repayMoney", repayMoney);
                    checkFeeMap.put("repayAmount", repayAmount);
                    if(!CommonUtils.isStrEmpty(checkfeeId)){
                        checkFeeMap.put("receiptId", getReceiptId(Integer.parseInt(unit_id),Integer.parseInt(checkfeeId)));
                    }
                } else {
                    //其余状态需读实收表，计算回款情况
                    Map<String, Object> map = getSaleUnitReceipt(Integer.parseInt(unit_id));

                    repayMoney =  map.get("repayMoney") == null ? "0" : map.get("repayMoney").toString();
                    repayAmount =  map.get("repayAmount") == null ? "0" : map.get("repayAmount").toString();

                    checkFeeMap.put("repayMoney", repayMoney);
                    checkFeeMap.put("repayAmount", repayAmount);
                    checkFeeMap.put("receiptId", map.get("receiptId"));
                }

                //实收汇总
                SUM_repayMoney = SUM_repayMoney.add(CommonUtils.exceptionToZero(repayMoney));
                SUM_repayAmount = SUM_repayMoney.add(CommonUtils.exceptionToZero(repayAmount));
                */


                checkFeeArray.add(checkFeeMap);

            }

            /*合计：*/
            checkFeeMap = new JSONObject();
            checkFeeMap.put("build_area", SUM_build_area);

            checkFeeMap.put("checkfeeTypeName", "总记录数:");
            checkFeeMap.put("checkfee_date", recordCount);
            checkFeeMap.put("customer_name", "合计:");
            checkFeeMap.put("sum_price", CommonUtils.moneyString(SUM_sum_money, 0, ""));
            checkFeeMap.put("repayMoney", CommonUtils.moneyString(SUM_repayMoney, 0, ""));
            checkFeeMap.put("repayAmount", CommonUtils.moneyString(SUM_repayAmount, 0, ""));

            checkFeeFooterArray.add(checkFeeMap);

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("total", recordCount);// total键 存放总记录数，必须的
            map.put("rows", checkFeeArray);// rows键 存放每页记录 list
            map.put("footer", checkFeeFooterArray);// footer 存放合计

            unitList = JSONObject.fromObject(map);// 格式化result一定要是JSONObject
            ActionContext.getContext().getValueStack().set("unitList", unitList);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return SUCCESS;
    }

    /**
     * 部分回款筛选列表
     * @param confirmCond
     * @return
     */
    public String unitReceiptList(ConfirmCond confirmCond) {
        JSONArray checkFeeArray = new JSONArray(); //list
        JSONArray checkFeeFooterArray = new JSONArray(); //footer 合计
        JSONObject checkFeeMap = new JSONObject();
        JSONObject unitList;

        BigDecimal SUM_build_area = new BigDecimal(0); //建筑面积
        BigDecimal SUM_build_price = new BigDecimal(0);//成交单价
        BigDecimal SUM_sum_money = new BigDecimal(0); //成交金额

        BigDecimal SUM_repayMoney = new BigDecimal(0); //回款金额
        BigDecimal SUM_repayAmount = new BigDecimal(0); //回款总金额
        String repayMoney ,repayAmount;
        BigDecimal b_repayMoney = new BigDecimal(0) ,b_repayAmount = new BigDecimal(0);

        List<Map<String, Object>> listConfirmUnit = null;

        int iCheckFeeType = 0;
        //跟进条件进行查询（部分回款查询）
        listConfirmUnit = confirmServices.checkFeeListByAdd (confirmCond);

        int recordCount = 0;
        if (listConfirmUnit != null) {
            recordCount = listConfirmUnit.size();
        }

        try {

            //循环房间，归类到项目中
            for (int i = 0; i < recordCount; i++) {

                Map<String, Object> mapobject = listConfirmUnit.get(i);
                int mainId; //合同客户表中
                String customerName,checkfeeId;

                //认购日期
                String work_date = mapobject.get("work_date")==null?"":mapobject.get("work_date").toString();
                //签约日期
                String sign_date = mapobject.get("sign_date")==null?"":mapobject.get("sign_date").toString();
                //对数日期
                String checkfee_date = mapobject.get("checkfee_date")==null?"":mapobject.get("checkfee_date").toString();
                String unit_id = mapobject.get("unit_id")==null?"":mapobject.get("unit_id").toString();
                String build_id = mapobject.get("build_id")==null?"":mapobject.get("build_id").toString();

                //销售状态
                //String sale_state = mapobject.get("sale_state").toString();
                //单元成交或合同总金额
                String sum_money = mapobject.get("contract_sum_money") == null ? "0" : mapobject.get("contract_sum_money").toString();
                //实收金额
                String payment_amount = mapobject.get("payment_amount") == null ? "0" : mapobject.get("payment_amount").toString();
                //单价（建筑面积）
                String build_price = mapobject.get("build_price") == null ? "0" : mapobject.get("build_price").toString();


                if (confirmCond.getSaleState()!=null && confirmCond.getSaleState().equals(ContUnitSaleState.CONFIRM)) {
                    //获取成交价格和金额
                    sum_money = mapobject.get("confirm_sum_money") == null ? "0" : mapobject.get("confirm_sum_money").toString();
                    checkFeeMap.put("pay_name", mapobject.get("confirm_pay_name")==null?"": mapobject.get("confirm_pay_name").toString());
                    checkFeeMap.put("sales",mapobject.get("confirm_sales_id")==null?"": getSalesName(
                            mapobject.get("confirm_sales_id").toString()));

                    mainId =  Integer.parseInt(mapobject.get("confirm_id").toString());
                    customerName = ContractCustomerUtils.getCustomerNameByMainIdAndConfirmType(mainId,
                            ContConfirmType.CONFIRM);

                } else {
                    //合同
                    checkFeeMap.put("pay_name",mapobject.get("contract_pay_name")==null?"": mapobject.get("contract_pay_name").toString());
                    checkFeeMap.put("sales",mapobject.get("contract_sales_id")==null?"": getSalesName(mapobject.get("contract_sales_id").toString()));

                    mainId =  Integer.parseInt(mapobject.get("contract_id").toString());
                    customerName = ContractCustomerUtils.getCustomerNameByMainIdAndConfirmType(mainId,
                            ContConfirmType.CONTRACT);

                }

                work_date = CommonUtils.getDateString(CommonUtils.getDateFromString(work_date));
                sign_date = CommonUtils.getDateString(CommonUtils.getDateFromString(sign_date));
                checkfee_date = CommonUtils.getDateString(CommonUtils.getDateFromString(checkfee_date));

                //类型转换String 2 BigDecimal
                BigDecimal b_sum_money = CommonUtils.exceptionToZero(sum_money).setScale(2, BigDecimal.ROUND_HALF_UP);
                BigDecimal b_payment_amount = CommonUtils.exceptionToZero(payment_amount).setScale(2, BigDecimal.ROUND_HALF_UP);
                BigDecimal b_build_price = new BigDecimal(build_price).setScale(0, BigDecimal.ROUND_HALF_UP);
                SUM_build_area = SUM_build_area.add(new BigDecimal(mapobject.get("BUILD_AREA").toString()));
                SUM_build_price = SUM_build_price.add(b_build_price);
                SUM_sum_money = SUM_sum_money.add(b_sum_money);


                PropertyBuild build = iPropertyBuildServices.findPropertyBuildById(Integer.parseInt(build_id));

                checkFeeMap.put("unit_id",unit_id);
                checkFeeMap.put("work_date", work_date);
                checkFeeMap.put("sign_date", sign_date);
                checkFeeMap.put("checkfee_date",checkfee_date);
                checkFeeMap.put("checkfeeTypeName", mapobject.get("checkfee_type")==null?"": EnumUnitCheckfeeType.getTextByValue(
                        Integer.parseInt(mapobject.get("checkfee_type").toString())));
                checkFeeMap.put("area_name",build.getAreaName());
                checkFeeMap.put("build_name", mapobject.get("build_name")==null?"":mapobject.get("build_name").toString());
                checkFeeMap.put("unit_no", mapobject.get("unit_no")==null?"":mapobject.get("unit_no").toString());
                checkFeeMap.put("customer_name", customerName);
                checkFeeMap.put("contract_no",mapobject.get("contract_no") == null ? "" : mapobject.get("contract_no").toString());
                checkFeeMap.put("build_area", mapobject.get("BUILD_AREA"));
                checkFeeMap.put("build_price", CommonUtils.moneyString(b_build_price, 0, ""));
                checkFeeMap.put("sum_price", CommonUtils.moneyString(b_sum_money, 0, ""));
                checkFeeMap.put("payment_amount", CommonUtils.moneyString(b_payment_amount, 0, ""));


                //其余状态需读实收表，计算回款情况
                Map<String, Object> map = getSaleUnitReceipt(Integer.parseInt(unit_id), confirmCond);
                repayMoney =  map.get("repayMoney") == null ? "0" : map.get("repayMoney").toString();
                repayAmount =  map.get("repayAmount") == null ? "0" : map.get("repayAmount").toString();

                checkFeeMap.put("repayMoney",repayMoney);
                checkFeeMap.put("repayAmount", repayAmount);
                checkFeeMap.put("receiptId", map.get("receiptId"));

                SUM_repayMoney = SUM_repayMoney.add(CommonUtils.exceptionToZero(repayMoney));
                SUM_repayAmount = SUM_repayMoney.add(CommonUtils.exceptionToZero(repayAmount));
                //====================回款金额 end

                checkFeeArray.add(checkFeeMap);

            }

            /*合计：*/
            checkFeeMap = new JSONObject();
            checkFeeMap.put("build_area", SUM_build_area);

            checkFeeMap.put("checkfeeTypeName", "总记录数:");
            checkFeeMap.put("checkfee_date", recordCount);
            checkFeeMap.put("customer_name", "合计:");
            checkFeeMap.put("sum_price", CommonUtils.moneyString(SUM_sum_money, 0, ""));
            checkFeeMap.put("repayMoney", CommonUtils.moneyString(SUM_repayMoney, 0, ""));
            checkFeeMap.put("repayAmount", CommonUtils.moneyString(SUM_repayAmount, 0, ""));

            checkFeeFooterArray.add(checkFeeMap);

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("total", recordCount);// total键 存放总记录数，必须的
            map.put("rows", checkFeeArray);// rows键 存放每页记录 list
            map.put("footer", checkFeeFooterArray);// footer 存放合计

            unitList = JSONObject.fromObject(map);// 格式化result一定要是JSONObject
            ActionContext.getContext().getValueStack().set("unitList", unitList);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return SUCCESS;
    }

    /**
     * 针对部分回款
     * 从实收款中获取回款金额，把实收id 用“,”连接传回页面，并统计实收款
     * @param unit_id 单元id
     * @return
     */
    public Map<String, Object> getSaleUnitReceipt(int unit_id) {
        Map<String, Object> map = new HashMap<String, Object>();

        BigDecimal repayAmount = new BigDecimal(0);
        BigDecimal repayMoney = new BigDecimal(0);
        String strReceiptId = "";
        List<SaleUnitReceipt> receiptList = iSaleUnitReceiptServices.findReceiptListByUnitId(unit_id);
        for(Iterator it = receiptList.iterator(); it.hasNext();){
            SaleUnitReceipt sur = (SaleUnitReceipt)it.next();
            int checkfeeId = sur.getCheckfeeId();
            int receiptId =sur.getId();
            strReceiptId += Integer.valueOf(receiptId) + separator;

            if(checkfeeId==0){
                //未对数
                repayMoney = repayMoney.add(sur.getReceiptMoney());
            }

            repayAmount = repayAmount.add(sur.getReceiptMoney());
        }
        map.put("repayMoney", repayMoney);
        map.put("repayAmount", repayAmount);
        map.put("receiptId", strReceiptId);
        return map;
    }

    /**
     * 针对部分回款
     * 从实收款中获取回款金额，把实收id 用“,”连接传回页面，并统计实收款
     * @param unit_id 单元id
     * @param confirmCond 传递查询条件
     * @return
     */
    public Map<String, Object> getSaleUnitReceipt(int unit_id,ConfirmCond confirmCond) {
        Date receiptDate = null;
        Date receiptDateEnd = null;
        if(!CommonUtils.isStrEmpty(confirmCond.getDate1())){
            receiptDate =CommonUtils.getDateFromString(confirmCond.getDate1());
        }
        if(!CommonUtils.isStrEmpty(confirmCond.getDate2())){
            receiptDateEnd =CommonUtils.getDateFromString(confirmCond.getDate2());
        }

        Map<String, Object> map = new HashMap<String, Object>();

        BigDecimal repayAmount = new BigDecimal(0);
        BigDecimal repayMoney = new BigDecimal(0);
        String strReceiptId = "";
        List<SaleUnitReceipt> receiptList = iSaleUnitReceiptServices.findReceiptListByUnitId(unit_id);
        for(Iterator it = receiptList.iterator(); it.hasNext();){

            SaleUnitReceipt sur = (SaleUnitReceipt)it.next();
            int checkfeeId = sur.getCheckfeeId();
            int receiptId =sur.getId();

            if(checkfeeId==0) {
                //未对数
                if(receiptDate!=null){
                    if (sur.getReceiptDate().equals(receiptDate) || sur.getReceiptDate().equals(receiptDateEnd)
                            || (sur.getReceiptDate().after(receiptDate) && sur.getReceiptDate().before(receiptDateEnd))){
                        //在筛选的回款日期之前
                        strReceiptId += Integer.valueOf(receiptId) + separator;
                        repayMoney = repayMoney.add(sur.getReceiptMoney());
                    }
                } else {
                    strReceiptId += Integer.valueOf(receiptId) + separator;
                    repayMoney = repayMoney.add(sur.getReceiptMoney());
                }
            }


            repayAmount = repayAmount.add(sur.getReceiptMoney());
        }
        map.put("repayMoney", repayMoney);
        map.put("repayAmount", repayAmount);
        map.put("receiptId", strReceiptId);
        return map;
    }

    /**
     * 获取实收ID （不用）
     * @param unit_id
     * @param checkfeeId
     * @return
     */
    public String getReceiptId(int unit_id,int checkfeeId){

        String strReceiptId = "";
        List<SaleUnitReceipt> receiptList = iSaleUnitReceiptServices.findReceiptListByUnitId(unit_id);
        for(Iterator it = receiptList.iterator(); it.hasNext();){
            SaleUnitReceipt sur = (SaleUnitReceipt)it.next();

            int receiptId =sur.getId();
            if(checkfeeId==sur.getCheckfeeId()){
                strReceiptId += Integer.valueOf(receiptId) + separator;
            }
        }
        return strReceiptId;
    }


    /**
     * 新增对数表记录，同一项目日期，只增加一次
     * @param projectIds   项目
     * @param checkFeeDate 对数日期
     * @param seleType     回款类型
     */
    public void addCheckfeeList(String projectIds,Date checkFeeDate,String seleType) {

        List<CheckfeeList> cl = findCheckfeeList(projectIds,checkFeeDate);

        //判断是否有重复
        if(CommonUtils.isCollectionEmpty(cl) && !CommonUtils.isStrEmpty(seleType)){

            //同一项目日期，只增加一次
            Date date = new Date();
            CheckfeeList checkfeeList = new CheckfeeList();
            checkfeeList.setPropertyProjectId(Integer.parseInt(projectIds));
            checkfeeList.setCheckfeeDate(checkFeeDate);
            checkfeeList.setCheckfeeType(Integer.parseInt(seleType));
            checkfeeList.setRemark("");

            checkfeeList.setIsDeleted(CommonUtils.NORMAL);
            checkfeeList.setCreatedTime(date);
            checkfeeList.setCreatedId(SessionUser.getUserId());
            checkfeeList.setModId(SessionUser.getUserId());
            checkfeeList.setModTime(date);
            iCheckfeeListServices.addCheckfeeList(checkfeeList);
        }
    }

    /**
     * 查找checkfeeList ,查看对数列表
     * @param projectIds 项目id
     * @param checkFeeDate 对数日期
     * @return
     */
    public  List<CheckfeeList> findCheckfeeList(String projectIds,Date checkFeeDate) {
        CheckfeeListCond checkfeeListCond = new CheckfeeListCond();
        checkfeeListCond.setPropertyProjectId(Integer.parseInt(projectIds));
        checkfeeListCond.setCheckfeeDate(checkFeeDate);
        List<CheckfeeList> cl = iCheckfeeListServices.findCheckfeeListByPrjId(checkfeeListCond);
        return cl;
    }

    /**
     * 获取对数表回款类型（checkfeeList）的对数表类型（1：全额，2：部分）
     * @param projectIds
     * @param checkFeeDate
     * @return
     */
    public String getRefund(String projectIds,Date checkFeeDate) {
        String refund = "";
        List<CheckfeeList> cl = findCheckfeeList(projectIds,checkFeeDate);
        if((cl!=null && cl.size()>0)){
            CheckfeeList checkfeeList = (CheckfeeList)cl.get(0);
            refund = checkfeeList.getCheckfeeType() + "";
        }
        return refund;
    }

    public String replaceMoney(String money){
        if(CommonUtils.isStrEmpty(money))  return "0";
        return money.replaceAll(",","");
    }

   public String[] splitArr(String arrs){
       if(CommonUtils.isStrEmpty(arrs)) return null;
       return arrs.split(",");
   }
   @SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Map> createDownSrc(String contSessionAttributeType){
   	JSONObject src = (JSONObject)request.getSession().getAttribute(contSessionAttributeType);
   	List<Map> down = new ArrayList<Map>();
   	if(src==null)
   		return null;
		JSONArray rows = (JSONArray) src.get("rows");
		for (int i = 0; i < rows.size(); i++) {
			Map t = new HashMap();
			JSONObject j = (JSONObject) rows.get(i);
			t.put("work_date", j.get("work_date"));
			t.put("unit_no",j.get("unit_no"));
			t.put("customer_name", j.get("customer_name"));
			t.put("build_area",j.get("build_area"));
			t.put("build_price", j.get("build_price"));
			t.put("sum_price",j.get("sum_price"));
			t.put("commission", j.get("commission"));
			t.put("secondcommission",j.get("secondcommission"));
			t.put("should_amount", j.get("should_amount"));
			t.put("secondshould_amount",j.get("secondshould_amount"));
			t.put("total_should_amount", j.get("total_should_amount"));
			t.put("payment_amount",j.get("payment_amount"));
			t.put("amount", j.get("amount"));
			t.put("relCommissionAmount",j.get("relCommissionAmount"));
			down.add(t);
		}
		return down;
   }
}
