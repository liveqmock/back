package com.ihk.saleunit.action.check_commission_sec;

import com.ihk.constanttype.*;
import com.ihk.property.data.pojo.*;
import com.ihk.saleunit.action.check_fee.CheckFeeAction;
import com.ihk.saleunit.data.pojo.ConfirmCond;
import com.ihk.utils.*;
import com.ihk.utils.contract.customer.ContractCustomerUtils;
import com.ihk.utils.financial.FinancialUtils;
import com.ihk.utils.financial.MultManagerCommissionPojo;
import com.ihk.utils.method.ActionAjaxMethodModifyCallback;
import com.opensymphony.xwork2.ActionContext;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.junit.internal.matchers.Each;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Lenovo
 * Date: 13-7-10
 * Time: 上午10:29
 * 对佣管理.继承 对数action
 * 一二手联动对佣管理
 */
public class CheckCommissionManagerAction extends CheckFeeAction {
    @Autowired
    com.ihk.property.data.services.ICheckcommissionSecServices iCheckcommissionServices;
    @Autowired
    com.ihk.property.data.services.ICheckcommissionListSecServices iCheckcommissionListServices;

    protected Map<String, String> checkFeeCommissionMap;//对佣状态

    public Map<String, String> getCheckFeeCommissionMap() {
        return checkFeeCommissionMap;
    }

    public void setCheckFeeCommissionMap(Map<String, String> checkFeeCommissionMap) {
        this.checkFeeCommissionMap = checkFeeCommissionMap;
    }
    List<MultManagerCommissionPojo> commissionList;
    public void setCond(){
        String projectId = request.getParameter("projectIds");
        String sBuildId = request.getParameter("buildId");
        String sAreaId = request.getParameter("areaId");
        String saleState = request.getParameter("saleState");
        String checkFeeDate = request.getParameter("checkFeeDate");
        String checkCommissionDate = request.getParameter("checkCommissionDate");
        String checkCommissionType = request.getParameter("checkCommissionType");
        String repayType = request.getParameter("repayType");

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
        confirmCond.setCheckCommissionDate(checkCommissionDate);
        confirmCond.setCheckCommissionType(checkCommissionType);
        confirmCond.setRepayType(repayType);
        commissionList = FinancialUtils.getMultCommission(projectid, areaId, buildId, ContContractManager.MAIN_CONTRACT);

    }
    /**
     * 新建对佣表
     * @return
     * @throws Exception
     */
    public String checkcommission_list() throws Exception {
        initSearchDate();
        saleMap = ContUnitSaleState.getContractState(false);
        checkFeeTypeMap = EnumUnitCheckfeeType.getCheckfeeType();
        return SUCCESS;
    }

    /**
     * 单元新增 弹窗
     * @return
     * @throws Exception
     */
    public String checkcommission_addUnit()  throws Exception {
        String propertyProjectId = request.getParameter("propertyProjectId");
        String repayType = request.getParameter("repayType");
        propertyUnitCond = new PropertyUnitCond();
        propertyUnitCond.setStrSearchCompanyProjectIds(propertyProjectId);
        propertyUnitCond.setRepayType(repayType);
        return SUCCESS;
    }

    /**
     * 对佣查询
     * @return
     * @throws Exception
     */
    public String checkcommission_confirm() throws Exception {


        checkFeeCommissionMap = EnumUnitCheckCommissionType.getCheckfeeType();

        return SUCCESS;
    }

    /**
     * 查询已对数的单元列表
     * @return
     * @throws Exception
     */
    public String checkfeelist_confirm() throws Exception {

        setCond();

        //签约日期
        String signDate = request.getParameter("signDate");
        String signDateEnd = request.getParameter("signDateEnd");

        //回款日期
        String receiptDate = request.getParameter("receiptDate");
        String receiptDateEnd = request.getParameter("receiptDateEnd");
        String repayType = request.getParameter("repayType");

        //已对数
        confirmCond.setCheckFeeType(EnumUnitCheckfeeType.CheckFeeEd.getValue()+"");


        //全额回款
        if(!CommonUtils.isStrEmpty(signDate)){
            confirmCond.setStartDate(signDate);
        }
        if(!CommonUtils.isStrEmpty(signDateEnd)){
            confirmCond.setEndDate(CommonUtils.getDateString(CommonUtils.getAfterDateForDay(CommonUtils.getDateFromString(signDateEnd),1)));
        }


        //查询已对数单元
        unitList(confirmCond);

        return SUCCESS;
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

        BigDecimal SUM_secCommission = new BigDecimal(0); //回款金额
        BigDecimal SUM_secCommissionAmount = new BigDecimal(0); //回款总金额


        List<Map<String, Object>> listConfirmUnit = null;

        String commissionType = confirmCond.getCheckCommissionType();
        int iCommissionType = 0;

        if(!CommonUtils.isStrEmpty(commissionType)){
            iCommissionType = Integer.parseInt(commissionType);

        } else {
            //回款类型
            String repayType = confirmCond.getRepayType();
            if (repayType.equals(ALL_REFUND)){
                //全额
                //从已对数表中获取单元
                listConfirmUnit = iCheckcommissionServices.findCheckfeeEd(confirmCond);
            } else {
                //部分
                listConfirmUnit = iCheckcommissionServices.findCheckfeePart(confirmCond);
            }
        }

        int recordCount = 0;
        if (listConfirmUnit != null) {
            recordCount = listConfirmUnit.size();
        }

        List projectIds = confirmCond.getProjectIds();
        int projectid = Integer.parseInt(projectIds.get(0).toString());
        List<MultManagerCommissionPojo> commissionList = FinancialUtils.getMultCommission(projectid, 0, 0,
                ContContractManager.MAIN_CONTRACT);
        List<MultManagerCommissionPojo> secondcommissionList = FinancialUtils.getMultCommission(projectid, 0, 0,
                ContContractManager.SECOND_LINKAGE);

        try {
            for (int i = 0; i < recordCount; i++) {

                Map<String, Object> mapobject = listConfirmUnit.get(i);
                int mainId; //合同客户表中
                String customerName,checkfeeId;

                //单元成交或合同总金额
                String sum_money = mapobject.get("sum_money") == null ? "0" : mapobject.get("sum_money").toString();
                //实收金额
                String payment_amount = mapobject.get("payment_amount") == null ? "0" : mapobject.get("payment_amount").toString();
                //单价（建筑面积）
                String build_price = mapobject.get("build_price") == null ? "0" : mapobject.get("build_price").toString();

                String isRelation = CommonUtils.isStrEmpty(mapobject.get("is_relation")) ? "0" : mapobject.get("is_relation").toString();
                //一二手联动
                String isSecondLinkage = CommonUtils.isStrEmpty(mapobject.get("is_second_linkage")) ? "0" : mapobject.get("is_second_linkage").toString();
                if("1".equalsIgnoreCase(isSecondLinkage)){
                if (confirmCond.getSaleState()!=null && confirmCond.getSaleState().equals(ContUnitSaleState.CONFIRM)) {
                    //获取成交价格和金额
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


                BigDecimal b_sum_money = CommonUtils.exceptionToZero(sum_money).setScale(2, BigDecimal.ROUND_HALF_UP);
                BigDecimal b_payment_amount = CommonUtils.exceptionToZero(payment_amount).setScale(2, BigDecimal.ROUND_HALF_UP);
                BigDecimal b_build_price = new BigDecimal(build_price).setScale(0, BigDecimal.ROUND_HALF_UP);
                SUM_build_area = SUM_build_area.add(new BigDecimal(mapobject.get("BUILD_AREA").toString()));
                SUM_build_price = SUM_build_price.add(b_build_price);
                SUM_sum_money = SUM_sum_money.add(b_sum_money);

                String unit_id = mapobject.get("unit_id")==null?"":mapobject.get("unit_id").toString();
                String build_id = mapobject.get("build_id")==null?"":mapobject.get("build_id").toString();
                PropertyBuild build = iPropertyBuildServices.findPropertyBuildById(Integer.parseInt(build_id));

                //佣金计算
                //Map<String, Object> commissionMap = getCommission(commissionList,work_date,b_sum_money);

                //一二手联动佣金
                BigDecimal sec_commission = getCommissionSec(secondcommissionList,work_date);
                BigDecimal sec_commissionAmount = sec_commission.multiply(b_sum_money).divide(new BigDecimal(100)).setScale(2,
                                                BigDecimal.ROUND_HALF_UP);

                checkFeeMap.put("sec_commission",sec_commission);
                checkFeeMap.put("sec_commissionAmount",sec_commissionAmount);

                SUM_secCommission = sec_commission;
                SUM_secCommissionAmount = SUM_secCommissionAmount.add(sec_commissionAmount);


                /*if(isRelation.equals("1")){
                    //关系户
                    checkFeeMap.put("commission","0");
                    checkFeeMap.put("commissionAmount","0");

                    checkFeeMap.put("rel_commission",commissionMap.get("rel_commission"));
                    checkFeeMap.put("rel_commissionAmount",commissionMap.get("rel_commissionAmount"));
                } else {
                    checkFeeMap.put("commission",commissionMap.get("commission"));
                    checkFeeMap.put("commissionAmount",commissionMap.get("commissionAmount"));

                    checkFeeMap.put("rel_commission","");
                    checkFeeMap.put("rel_commissionAmount","");
                }*/

                checkFeeMap.put("checkfeeid",mapobject.get("checkfeeID").toString());
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
                checkFeeMap.put("build_price", b_build_price);
                checkFeeMap.put("sum_price", b_sum_money);
                checkFeeMap.put("payment_amount", CommonUtils.moneyString(b_payment_amount, 0, ""));

                //获取回款金额，记录回款数据，勾选加入对数表后更新回款表的日期和状态

                /*if(iCommissionType==EnumUnitCheckCommissionType.CheckFeeIng.getValue() ||
                        iCommissionType==EnumUnitCheckCommissionType.CheckFeeEd.getValue()) {
                    //对佣中 和 已对佣未结佣 直接读取 checkcommission表
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
                }*/

                //实收汇总
                //SUM_repayMoney = SUM_repayMoney.add(CommonUtils.exceptionToZero(repayMoney));
                //SUM_repayAmount = SUM_repayMoney.add(CommonUtils.exceptionToZero(repayAmount));

                checkFeeArray.add(checkFeeMap);
                }
            }

                /*合计：*/
            checkFeeMap = new JSONObject();
            checkFeeMap.put("build_area", SUM_build_area);

            checkFeeMap.put("checkfeeTypeName", "总记录数:");
            checkFeeMap.put("checkfee_date", recordCount);
            checkFeeMap.put("customer_name", "合计:");
            checkFeeMap.put("sum_price", SUM_sum_money);

            checkFeeMap.put("repayMoney", SUM_repayMoney);
            checkFeeMap.put("repayAmount", SUM_repayAmount);

            checkFeeMap.put("sec_commission", SUM_secCommission);
            checkFeeMap.put("sec_commissionAmount", SUM_secCommissionAmount);

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

    public String getCheckCommissionRefundType() throws Exception{

        String projectIds = request.getParameter("projectIds");
        String checkCommissionDateStr = request.getParameter("checkCommissionDate");
        Date checkCommissionDate = CommonUtils.getDateFromString(checkCommissionDateStr);

        String type = getRepayType(projectIds, checkCommissionDate); //1：全额，2：部分

        Map<String, String> map = new HashMap<String, String>();
        map.put("type", type);

        CustomerUtils.writeResponse(response, CommonUtils.getMapJson(map));

        return null;
    }
    /**
     * 添加到对佣表
     * @return
     * @throws Exception
     */
    public String add_checkcommission() throws Exception{

        ActionTemplate.executeAjaxMethod(true, this, new ActionAjaxMethodModifyCallback() {

            @Override
            public void modifyMethodException(Exception e) {
            }

            @Override
            public void modifyMethod() throws Exception {
                setCond();
                String checkfeeids = request.getParameter("checkfeeid");
                String repayType = request.getParameter("repayType");
                String receiptId = request.getParameter("receiptId");
                String ids = request.getParameter("ids");
                String checkCommissionDateStr = request.getParameter("checkCommissionDate");
                String projectIds = request.getParameter("projectIds");
                String commissions = request.getParameter("commission");
                String commissionAmounts = request.getParameter("commissionAmount");
                String sec_commissions = request.getParameter("sec_commission");
                String sec_commissionAmounts = request.getParameter("sec_commissionAmount");
                String rel_commissions = request.getParameter("rel_commission");
                String rel_commissionAmounts = request.getParameter("rel_commissionAmount");
                Date commissionDate = CommonUtils.getDateFromString(checkCommissionDateStr);

                String repayMoneys = CommonUtils.isStrEmpty(
                        request.getParameter("repayMoney")) ? "0" : request.getParameter("repayMoney");
                String repayAmounts = CommonUtils.isStrEmpty(
                        request.getParameter("repayAmount")) ? "0" : request.getParameter("repayAmount");

                if (CommonUtils.isStrZeroEmpty(ids)) {
                    return;
                }
                Date date = new Date();
                String[] idsArr = splitArr(ids);
                String[] checkfeeidsArr = splitArr(checkfeeids);
                String[] repayMoneysArr = splitArr(repayMoneys);
                String[] repayAmountsArr = splitArr(repayAmounts);
                String[] commissionsArr = splitArr(commissions);
                String[] commissionAmountsArr = splitArr(commissionAmounts);
                String[] sec_commissionsArr = splitArr(sec_commissions);
                String[] sec_commissionAmountsArr = splitArr(sec_commissionAmounts);
                String[] rel_commissionsArr = splitArr(rel_commissions);
                String[] rel_commissionAmountsArr = splitArr(rel_commissionAmounts);

                if (CommonUtils.isStrEmpty(repayType)) {
                    repayType = getRepayType(projectIds, commissionDate);
                }

                for (int i = 0; i < idsArr.length; i++) {
                    int unitId = Integer.parseInt(idsArr[i]);
                    String strCheckfeeid = checkfeeidsArr[i];
                    int icheckfeeid = 0;
                    if(CommonUtils.isStrEmpty(strCheckfeeid)){
                        Checkfee checkfee =  iCheckfeeServices.findCheckfeeByUnitId(unitId);
                        icheckfeeid = checkfee.getId();
                    } else {
                        icheckfeeid = Integer.parseInt(strCheckfeeid);
                    }

                    Checkcommission checkcommission = new Checkcommission();
                    checkcommission.setUnitId(unitId);
                    checkcommission.setCheckcommissionDate(commissionDate);
                    checkcommission.setCheckcommissionType(EnumUnitCheckfeeType.CheckFeeIng.getValue());
                    checkcommission.setIsDeleted(CommonUtils.NORMAL);
                    checkcommission.setCreatedId(SessionUser.getUserId());
                    checkcommission.setCreatedTime(date);
                    checkcommission.setModId(SessionUser.getUserId());
                    checkcommission.setModTime(date);
                    checkcommission.setRepayMoney(BigDecimal.ZERO);
                    checkcommission.setRepayAmount(BigDecimal.ZERO);
                    checkcommission.setCheckfeeId(icheckfeeid);

                    if(!CommonUtils.isStrEmpty(commissionsArr)){
                        checkcommission.setCommission(CommonUtils.exceptionToZero(commissionsArr[i]));
                    }
                    if(!CommonUtils.isStrEmpty(commissionAmountsArr)){
                        checkcommission.setCommissionAmount(CommonUtils.exceptionToZero(commissionAmountsArr[i]));
                    }
                    if(!CommonUtils.isStrEmpty(sec_commissionsArr)){
                        checkcommission.setSec_commission(CommonUtils.exceptionToZero(sec_commissionsArr[i]));
                    }
                    if(!CommonUtils.isStrEmpty(sec_commissionAmountsArr)){
                        checkcommission.setSec_commissionAmount(CommonUtils.exceptionToZero(sec_commissionAmountsArr[i]));
                    }
                    if(!CommonUtils.isStrEmpty(rel_commissionsArr)){
                        checkcommission.setRel_commission(CommonUtils.exceptionToZero(rel_commissionsArr[i]));
                    }
                    if(!CommonUtils.isStrEmpty(rel_commissionAmountsArr)){
                        checkcommission.setRel_commissionAmount(CommonUtils.exceptionToZero(rel_commissionAmountsArr[i]));
                    }

                    //处理回款金额
                    if (ALL_REFUND.equals(repayType)) {
                        addCheckCommission(checkcommission, receiptId , repayType, projectIds,i );
                    } else {

                        BigDecimal repayMoney = new BigDecimal(repayMoneysArr[i]);
                        BigDecimal repayAmount = new BigDecimal(repayAmountsArr[i]);

                        checkcommission.setRepayMoney(repayMoney);
                        checkcommission.setRepayAmount(repayAmount);
                        //存入对数表
                        addCheckCommission(checkcommission, receiptId , repayType, projectIds,i );
                        //addCheckCommission(unitId, commissionDate, receiptId, repayMoney, repayAmount, repayType,
                        //        projectIds, i ,icheckfeeid);
                    }

                }

                addCheckCommissionList(projectIds, commissionDate, repayType);
                //throw new Exception();
            }
        });

        return null;
    }

    /**
     * 保存佣金点数
     * @return
     * @throws Exception
     */
    public String savecommission() throws Exception{

        ActionTemplate.executeAjaxMethod(true, this, new ActionAjaxMethodModifyCallback() {

            @Override
            public void modifyMethodException(Exception e) {
            }

            @Override
            public void modifyMethod() throws Exception {
                //String commissions = request.getParameter("commissions");
               // String commissionAmounts = request.getParameter("commissionAmounts");
                String sec_commissions = request.getParameter("sec_commissions");
                String sec_commissionAmounts = request.getParameter("sec_commissionAmounts");
                String rel_commissions = request.getParameter("rel_commissions");
                String rel_commissionAmounts = request.getParameter("rel_commissionAmounts");

                String checkcommissionIds = request.getParameter("checkcommissionId");

                //String[] commissionsArr = commissions.split(",");
                //String[] commissionAmountsArr = commissionAmounts.split(",");
                String[] sec_commissionsArr = sec_commissions.split(",");
                String[] sec_commissionAmountsArr = sec_commissionAmounts.split(",");
                String[] rel_commissionsArr = rel_commissions.split(",");
                String[] rel_commissionAmountsArr = rel_commissionAmounts.split(",");
                String[] checkcommissionIdsArr = checkcommissionIds.split(",");

                for (int i = 0; i < checkcommissionIdsArr.length; i++) {
                    //BigDecimal commission = CommonUtils.exceptionToZero(commissionsArr[i]);
                    //BigDecimal commissionAmount = CommonUtils.exceptionToZero(commissionAmountsArr[i]);
                    BigDecimal sec_commission = CommonUtils.exceptionToZero(sec_commissionsArr[i]);
                    BigDecimal sec_commissionAmount = CommonUtils.exceptionToZero(sec_commissionAmountsArr[i]);
                    BigDecimal rel_commission = CommonUtils.exceptionToZero(rel_commissionsArr[i]);
                    BigDecimal rel_commissionAmount = CommonUtils.exceptionToZero(rel_commissionAmountsArr[i]);

                    Date date = new Date();

                    //dosave
                    CheckcommissionCond cond = new CheckcommissionCond();

                    //cond.setCommission(commission);
                    //cond.setCommissionAmount(commissionAmount);
                    cond.setSec_commission(sec_commission);
                    cond.setSec_commissionAmount(sec_commissionAmount);
                    cond.setRel_commission(rel_commission);
                    cond.setRel_commissionAmount(rel_commissionAmount);
                    cond.setId(Integer.parseInt(checkcommissionIdsArr[i]));
                    cond.setModId(SessionUser.getUserId());
                    cond.setModTime(date);
                    cond.setCommissionTime(date);
                    iCheckcommissionServices.saveCommission(cond);
                }
            }
        });

        return null;
    }


    /**
     * 加入对佣表
     * 1、checkcommission 新增记录
     * 2、部分回款需要写 sale_unit_receipt 的 checkfee_id
     * @param unitId  单元id
     * @param checkCommissionDate  对佣日期
     * @param receiptId 实收
     * @param repayType 是否全额回款（0--全额，1--部分）
     * @param repayMoney 回款金额
     * @param repayAmount 回款总金额
     */
    private void addCheckCommission(int unitId,Date checkCommissionDate,String receiptId,
                                    BigDecimal repayMoney,BigDecimal repayAmount,
                                    String repayType,String projectIds,int iarr,int checkfeeid){
        Date date = new Date();
        Checkcommission checkcommission = new Checkcommission();

        checkcommission.setUnitId(unitId);
        checkcommission.setCheckcommissionDate(checkCommissionDate);
        checkcommission.setCheckcommissionType(EnumUnitCheckfeeType.CheckFeeIng.getValue());
        checkcommission.setIsDeleted(CommonUtils.NORMAL);
        checkcommission.setCreatedId(SessionUser.getUserId());
        checkcommission.setCreatedTime(date);
        checkcommission.setModId(SessionUser.getUserId());
        checkcommission.setModTime(date);
        checkcommission.setRepayMoney(repayMoney);
        checkcommission.setRepayAmount(repayAmount);
        checkcommission.setCheckfeeId(checkfeeid);


        if(CommonUtils.isStrEmpty(repayType)) {
            //回款类型为空,从列表中获取
            repayType = getRepayType(projectIds,checkCommissionDate);
        }

        if(repayType.equals(ALL_REFUND)){
            //全额回款，直接添加到checkcommission对佣表中
            iCheckcommissionServices.addCheckcommission(checkcommission);
            //更新对数表
            updateCheckfeeCommissionId(checkfeeid,EnumUnitCheckfeeType.CheckFeeIng.getValue(),EnumUnitCheckSecType.CheckSecIng.getValue());
        } else {
            //部分回款
            if (receiptId==null){
                //实收id为空，重新获取实收金额等
                Map<String, Object> map = getSaleUnitReceipt(unitId);
                receiptId = (String)map.get("receiptId");
            }

            //增加到checkcommission 对佣表中表
            CheckcommissionCond cond = new CheckcommissionCond();
            cond.setUnitId(unitId);
            cond.setCheckCommissionDate(checkCommissionDate);
            List<Checkcommission> checkcommissionList= iCheckcommissionServices.findCheckcommission(cond);
            if(checkcommissionList!=null && checkcommissionList.size()>0){
                //对佣表已存在,update 操作
                Checkcommission ck = checkcommissionList.get(0);
                cond = new CheckcommissionCond();
                cond.setCommission(ck.getCommission());
                cond.setCommissionAmount(ck.getCommissionAmount());
                cond.setSec_commission(ck.getSec_commission());
                cond.setSec_commissionAmount(ck.getSec_commissionAmount());
                cond.setRel_commission(ck.getRel_commission());
                cond.setRel_commissionAmount(ck.getRel_commissionAmount());

                cond.setId(ck.getId());
                cond.setRepayMoney(repayMoney);
                cond.setModId(SessionUser.getUserId());
                cond.setModTime(date);
                iCheckcommissionServices.updateCheckcommissionByRepay(cond);
            }else{
                //insert 操作
                iCheckcommissionServices.addCheckcommission(checkcommission);

                //更新对数表
                updateCheckfeeCommissionId(checkfeeid,EnumUnitCheckfeeType.CheckFeeIng.getValue(),EnumUnitCheckSecType.CheckSecIng.getValue());
            }

            //更新 实收表
            updateSaleUnitReceipt(receiptId,checkcommission.getId(),iarr);

        }
    }
    private void addCheckCommission(Checkcommission checkcommission, String receiptId ,String repayType,String projectIds,int iarr ){

        Date date = new Date();


        if(CommonUtils.isStrEmpty(repayType)) {
            //回款类型为空,从列表中获取
            repayType = getRepayType(projectIds,checkcommission.getCheckcommissionDate());
        }

        if(repayType.equals(ALL_REFUND)){
            //全额回款，直接添加到checkcommission对佣表中
            iCheckcommissionServices.addCheckcommission(checkcommission);
            //更新对数表,对数中
//            updateCheckfeeCommissionId(checkcommission.getCheckfeeId(),EnumUnitCheckCommissionType.CheckFeeIng.getValue());
            updateCheckfeeCommissionId(checkcommission.getCheckfeeId(),EnumUnitCheckCommissionType.HaveNotCheckFee.getValue(),EnumUnitCheckSecType.CheckSecIng.getValue());
            
        } else {
            //部分回款
            if (receiptId==null){
                //实收id为空，重新获取实收金额等
                Map<String, Object> map = getSaleUnitReceipt(checkcommission.getUnitId());
                receiptId = (String)map.get("receiptId");
            }

            //增加到checkcommission 对佣表中表
            CheckcommissionCond cond = new CheckcommissionCond();
            cond.setUnitId(checkcommission.getUnitId());
            cond.setCheckCommissionDate(checkcommission.getCheckcommissionDate());
            List<Checkcommission> checkcommissionList= iCheckcommissionServices.findCheckcommission(cond);
            if(checkcommissionList!=null && checkcommissionList.size()>0){
                //对佣表已存在,update 操作
                Checkcommission ck = checkcommissionList.get(0);

                cond = new CheckcommissionCond();
                cond.setCommission(ck.getCommission());
                cond.setCommissionAmount(ck.getCommissionAmount());
                cond.setSec_commission(ck.getSec_commission());
                cond.setSec_commissionAmount(ck.getSec_commissionAmount());
                cond.setRel_commission(ck.getRel_commission());
                cond.setRel_commissionAmount(ck.getRel_commissionAmount());

                cond.setId(ck.getId());
                cond.setRepayMoney(checkcommission.getRepayMoney());
                cond.setModId(SessionUser.getUserId());
                cond.setModTime(date);
                iCheckcommissionServices.updateCheckcommissionByRepay(cond);
            }else{
                //insert 操作
                iCheckcommissionServices.addCheckcommission(checkcommission);
                //更新对数表，部分对数
                updateCheckfeeCommissionId(checkcommission.getCheckfeeId(),EnumUnitCheckCommissionType.PartCommission.getValue(),EnumUnitCheckSecType.CheckSecIng.getValue());
            }

            //更新 实收表
            updateSaleUnitReceipt(receiptId,checkcommission.getId(),iarr);

        }
    }

    /**
     * 恢复可对佣
     * @return
     * @throws Exception
     */
    public String resume_checkcommission() throws Exception{

        ActionTemplate.executeAjaxMethod(true, this, new ActionAjaxMethodModifyCallback() {

            @Override
            public void modifyMethodException(Exception e) {
            }

            @Override
            public void modifyMethod() throws Exception {

                String projectIds = request.getParameter("projectIds");
                String ids = request.getParameter("ids");
                String checkCommissionDateStr = request.getParameter("checkCommissionDate");
                String checkIds = request.getParameter("checkIds");
                String checkCommissionIds = request.getParameter("checkCommissionIds");
//                String receiptIds = request.getParameter("receiptId");

                if(CommonUtils.isStrZeroEmpty(ids)){
                    return ;
                }

                String[] idsArr = ids.split(",");
                String[] checkCommissionDateArr = checkCommissionDateStr.split(",");
                String[] checkCommissionIdsArr = checkCommissionIds.split(",");
                String[] checkIdsArr = checkIds.split(",");
                String[] projectIdsArr = projectIds.split(",");

//                String[] receiptIdsArr = receiptIds==null ? null : receiptIds.split(",");


                int i=0;
                for(String idStr : idsArr){
                    int unitId = Integer.parseInt(idStr);

                    Date checkCommissionDate = CommonUtils.getDateFromString(checkCommissionDateArr[i]);
                    int checkCommissionId = Integer.parseInt(checkCommissionIdsArr[i]);
                    int checkfeeid = Integer.parseInt(checkIdsArr[i]);
                    String projectId = projectIds;

//                    String receiptId = receiptIdsArr==null ? "" :  receiptIdsArr[i] ;
                    //update对数表
                    //update实收款表
                    //delete对佣表
                    //(int checkfeeid,int checkcommissionId,Date checkCommissionDate,String receiptId,String projectIds,int iarr)
                    delCheckCommission(checkfeeid,checkCommissionId,checkCommissionDate,null,projectId,i);
                    i++;
                }
            }
        });

        return null;
    }

    /**
     * 确认与开发商已对佣
     * 1、checkcommission 更改checkcommission_type
     * 2、sale_unit_receipt 不更改
     * 3、checkfee 更改 checkcommission_type
     * @return
     * @throws Exception
     */
    public String final_checkcommission() throws Exception{

        ActionTemplate.executeAjaxMethod(true, this, new ActionAjaxMethodModifyCallback() {

            @Override
            public void modifyMethodException(Exception e) {
            }

            @Override
            public void modifyMethod() throws Exception {

                String ids = request.getParameter("ids");
                String checkIds = request.getParameter("checkIds");
                String checkCommissionIds = request.getParameter("checkCommissionIds");

                int checkCommissionType = EnumUnitCheckCommissionType.CheckFeeEd.getValue();
                String checkDateStr = request.getParameter("checkCommissionDate");
                Date checkCommissionDate = CommonUtils.getDateFromString(checkDateStr);

                if(CommonUtils.isStrZeroEmpty(ids)){

                    return ;
                }

                String[] idsArr = ids.split(",");
                String[] checkCommissionIdsArr = checkCommissionIds.split(",");
                String[] checkIdsArr = checkIds.split(",");

                int i=0;
                for(String idStr : checkCommissionIdsArr){
                    int id = Integer.parseInt(idStr);
                    int checkfeeid = Integer.parseInt(checkIdsArr[i]);

                    //根据结佣表id 改变状态
                    updateCheckCommission(id,checkCommissionType);
                    updateCheckfeeCommissionId(checkfeeid,checkCommissionType,EnumUnitCheckSecType.CheckSecEd.getValue());
                    i++;
                }

            }
        });

        return null;
    }

    /**
     * 删除对佣
     * 1、checkcommission 删除记录
     * 2、sale_unit_receipt 实收表 清除checkfee_id ，设为 0
     * @return
     * @throws Exception
     */
    public String del_checkcommission() throws Exception{

        ActionTemplate.executeAjaxMethod(true, this, new ActionAjaxMethodModifyCallback() {

            @Override
            public void modifyMethodException(Exception e) {
            }

            @Override
            public void modifyMethod() throws Exception {

                String projectIds = request.getParameter("projectIds");
                String receiptId = request.getParameter("receiptId");
                String ids = request.getParameter("ids");
                String checkCommissionIds = request.getParameter("checkCommissionIds");
                String checkIds = request.getParameter("checkIds");
                String checkCommissionDateStr = request.getParameter("checkCommissionDate");
                Date checkCommissionDate = CommonUtils.getDateFromString(checkCommissionDateStr);

                if (CommonUtils.isStrZeroEmpty(ids)) {
                    return;
                }

                String[] checkCommissionIdsArr = checkCommissionIds.split(",");
                String[] checkIdsArr = checkIds.split(",");

                int i = 0;
                for (String idStr : checkCommissionIdsArr) {
                    int checkcommissionId = Integer.parseInt(idStr);
                    int checkfeeId = Integer.parseInt(checkIdsArr[i]);
                    //删除对佣表
                    delCheckCommission(checkfeeId,checkcommissionId, checkCommissionDate, receiptId, projectIds, i);

                    i++;
                }

            }
        });

        return null;
    }

    /**
     * 删除对佣表
     * @param checkfeeid checkfeeid id
     * @param checkcommissionId checkcommission id
     * @param checkCommissionDate 对数日期
     * @param receiptId 实收id
     * @param projectIds 项目id
     */
    private void delCheckCommission(int checkfeeid,int checkcommissionId,Date checkCommissionDate,String receiptId,String projectIds,int iarr){
        //删除 checkcommission
        delCheckCommission(checkcommissionId);
        //update 对数表对佣状态为 为对佣
        updateCheckfeeCommissionId(checkfeeid,EnumUnitCheckCommissionType.HaveNotCheckFee.getValue(),EnumUnitCheckSecType.HaveNotCheckSec.getValue());
        //对部分回款的处理，回款类型获取
        String repayType = getRepayType(projectIds,checkCommissionDate);
        if(repayType.equals(PART_REFUND)){
            //部分回款 ，更新实收表
            iSaleUnitReceiptServices.updateSaleUnitReceiptCheckCommissionId(checkcommissionId);
            /*if (!CommonUtils.isStrEmpty(receiptId)) {
                //更新实收表
                updateSaleUnitReceipt(receiptId,0,iarr);
            }*/
        }
    }

    /**
     * 删除 checkCommission 记录
     * @param checkcommissionId
     */
    private void delCheckCommission(int checkcommissionId ){
        CheckcommissionCond checkcommissionCond = new CheckcommissionCond();
        checkcommissionCond.setId(checkcommissionId);
        //checkcommissionCond.setCheckCommissionDate(checkCommissionDate);

        iCheckcommissionServices.deleteCheckcommissionByUnitId(checkcommissionCond);
    }

    /**
     * 更新对佣表状态（通过id和更改对佣表状态）
     * @param id Checkcommission id
     * @param checkCommissionType
     */
    private void updateCheckCommission(int id,int checkCommissionType){
        Date date = new Date();
        Checkcommission checkcommission = new Checkcommission();
        checkcommission.setId(id);
        checkcommission.setCheckcommissionType(checkCommissionType);
        checkcommission.setModId(SessionUser.getUserId());
        checkcommission.setModTime(date);
        iCheckcommissionServices.updateCheckcommission(checkcommission);
    }

    /**
     * 更新 实收表 checkfeeId （对数功能不需要，改为对佣 id）
     * @param receiptId
     */
    private void updateSaleUnitReceipt(String receiptId ,int checkfeeId,int iarr) {

        String[] receiptIdArr = receiptId.split(",");
        String[] receiptIdStr = receiptIdArr[iarr].split(separator);

        for(String strReceiptIdArr : receiptIdStr){
            if(!CommonUtils.isStrEmpty(strReceiptIdArr)) {
                int iReceiptId = Integer.parseInt(strReceiptIdArr);

                //部分回款，将实收对佣日期设为 0
                iSaleUnitReceiptServices.updateSaleUnitReceiptCheckFeeId(iReceiptId,checkfeeId);
                //BaseLogger.info(this.getClass(),"=====" + iReceiptId + "===");
            }
        }
    }

    /**
     * 新增对佣表记录，同一项目日期，只增加一次
     * @param projectIds   项目
     * @param checkCommissionDate 对数日期
     * @param repayType     回款类型
     */
    public void addCheckCommissionList(String projectIds,Date checkCommissionDate,String repayType) {

        List<CheckcommissionListSec> cl = findCheckCommissionList(projectIds,checkCommissionDate);

        //判断是否有重复
        if(CommonUtils.isCollectionEmpty(cl) && !CommonUtils.isStrEmpty(repayType)){

            //同一项目日期，只增加一次
            Date date = new Date();
            CheckcommissionListSec checkcommissionList = new CheckcommissionListSec();
            checkcommissionList.setPropertyProjectId(Integer.parseInt(projectIds));
            checkcommissionList.setCheckcommissionDate(checkCommissionDate);
            checkcommissionList.setRepayType(Integer.parseInt(repayType));
            checkcommissionList.setRemark("");

            checkcommissionList.setIsDeleted(CommonUtils.NORMAL);
            checkcommissionList.setCreatedTime(date);
            checkcommissionList.setCreatedId(SessionUser.getUserId());
            checkcommissionList.setModId(SessionUser.getUserId());
            checkcommissionList.setModTime(date);
            iCheckcommissionListServices.addCheckcommissionList(checkcommissionList);
        }
    }

    /**
     * 获取回款类型（checkcommissionList）的对佣表类型（1：全额，2：部分）
     * @param projectIds
     * @param checkCommissionDate
     * @return
     */
    public String getRepayType(String projectIds,Date checkCommissionDate) {
        String refund = "";
        List<CheckcommissionListSec> cl = findCheckCommissionList(projectIds, checkCommissionDate);
        if((cl!=null && cl.size()>0)){
            CheckcommissionListSec checkcommissionList = (CheckcommissionListSec)cl.get(0);
            refund = checkcommissionList.getRepayType() + "";
        }
        return refund;
    }

    /**
     * 查找 CheckcommissionList ,查看对佣列表
     * @param projectIds 项目id
     * @param checkCommissionDate 对数日期
     * @return
     */
    public  List<CheckcommissionListSec> findCheckCommissionList(String projectIds,Date checkCommissionDate) {
        CheckcommissionListSecCond checkcommissionListCond = new CheckcommissionListSecCond();
        checkcommissionListCond.setPropertyProjectId(Integer.parseInt(projectIds));
        checkcommissionListCond.setCheckcommissionDate(checkCommissionDate);
        List<CheckcommissionListSec> cl = iCheckcommissionListServices.findCheckcommissionListByPrjId(checkcommissionListCond);
        return cl;
    }

    /**
     * 更新对数表
     * @param id checkfee id
     * @param commissionType 对佣状态
     */
    private void updateCheckfeeCommissionId(int id  ,int commissionType,int checkSecType) {
        Date date = new Date();
        Checkfee checkfee = new Checkfee();
        checkfee.setId(id);
        checkfee.setCheckcommissionType(commissionType);
        checkfee.setModId(SessionUser.getUserId());
        checkfee.setModTime(date);
        //已做过一二手对佣，不影响基础对佣
        checkfee.setIsSecCheck(checkSecType);
        iCheckfeeServices.updateCheckfee(checkfee);
        
    }

    /**
     * 获取对佣日期
     * @return
     * @throws Exception
     */
    public String getDateListForCombotree() throws Exception{
        String noText = "-没有对佣日期-";
        String changeText = "-选择对佣日期-";

        JSONArray array = new JSONArray();
        JSONObject json = null;

        String propertyId = request.getParameter("propertyId");
        String checkCommissionType = request.getParameter("checkCommissionType");

        if(CommonUtils.isStrZeroEmpty(propertyId)){

            json = new JSONObject();

            json.put("id", "");
            json.put("text", noText);

            array.add(json);

            CustomerUtils.writeResponse(response, array.toString());

            return null;
        }

        CheckcommissionCond cond = new CheckcommissionCond();
        cond.setPropertyId(Integer.parseInt(propertyId));
        if(!CommonUtils.isStrEmpty(checkCommissionType)){
            cond.setCheckCommissionType(Integer.parseInt(checkCommissionType));
        }

        List<Map<String, Object>> checkDateList = iCheckcommissionServices.checkDateList(cond);

        if(CommonUtils.isCollectionEmpty(checkDateList)){

            json = new JSONObject();

            json.put("id", "");
            json.put("text", noText);

            array.add(json);

        }else{

            json = new JSONObject();

            json.put("id", "");
            json.put("text", changeText);

            array.add(json);

            for (int i = 0; i < checkDateList.size(); i++) {

                Map<String, Object> mapobject = checkDateList.get(i);

                String checkcommission_date = mapobject.get("checkcommission_date")==null?"":mapobject.get("checkcommission_date").toString();
                if(!CommonUtils.isStrEmpty(checkcommission_date)){

                    json.put("id", CommonUtils.getDateString(CommonUtils.getDateFromString(checkcommission_date)));
                    json.put("text", CommonUtils.getDateString(CommonUtils.getDateFromString(checkcommission_date)));

                    array.add(json);
                }

            }
        }

        CustomerUtils.writeResponse(response, array.toString());

        return null;
    }


    /**
     * 获取对应的佣金
     * @param list
     * @param work_date
     * @return
     */
    public BigDecimal getCommissionSec(List<MultManagerCommissionPojo> list,String work_date) throws Exception {
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

    public Map<String, Object>  getCommission(List<MultManagerCommissionPojo> list,String work_date ,BigDecimal sumMoney) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        //应收佣金
        BigDecimal commissionAmount = new BigDecimal(0);
        BigDecimal commission = new BigDecimal(0);
        BigDecimal relationCommission = new BigDecimal(0);
        BigDecimal relationMoney = new BigDecimal(0);

        //佣金初始化
        map.put("commission", commission);
        map.put("commissionAmount", commissionAmount);

        //关系户初始化
        map.put("rel_commission", relationCommission);
        map.put("rel_commissionAmount",relationMoney);

        if (list==null) return map;

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

                        commissionAmount = commission.multiply(sumMoney).divide(new BigDecimal(100)).setScale(2,
                                BigDecimal.ROUND_HALF_UP);
                    }
                }

                relationCommission = m.getRelationCommission();
                relationMoney = m.getRelationMoney();

            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        //佣金
        map.put("commission", commission);
        map.put("commissionAmount", commissionAmount);

        //关系户
        map.put("rel_commission", relationCommission);
        map.put("rel_commissionAmount",relationMoney);

        return map;
    }

}
