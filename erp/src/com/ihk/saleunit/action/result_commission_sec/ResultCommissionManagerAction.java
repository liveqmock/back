package com.ihk.saleunit.action.result_commission_sec;

import com.ihk.constanttype.ContConfirmType;
import com.ihk.constanttype.ContUnitSaleState;
import com.ihk.constanttype.EnumUnitCheckCommissionType;
import com.ihk.property.data.pojo.CheckcommissionCond;
import com.ihk.property.data.pojo.PropertyBuild;
import com.ihk.property.data.pojo.PropertyProject;
import com.ihk.saleunit.action.check_commission.CheckCommissionViewAction;
import com.ihk.saleunit.data.pojo.ApPayment;
import com.ihk.saleunit.data.pojo.ConfirmCond;
import com.ihk.saleunit.data.services.IApPaymentServices;
import com.ihk.utils.*;
import com.ihk.utils.contract.customer.ContractCustomerUtils;
import com.ihk.utils.method.ActionAjaxMethodModifyCallback;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Lenovo
 * Date: 13-8-8
 * Time: 上午10:25
 * 结佣管理 继承 对数action.
 */
public class ResultCommissionManagerAction extends CheckCommissionViewAction {
    @Autowired
    com.ihk.property.data.services.ICheckcommissionSecServices iCheckcommissionServices;
    @Autowired
    com.ihk.property.data.services.ICheckcommissionListSecServices iCheckcommissionListServices;
    @Autowired
    IApPaymentServices apPaymentServices;

    public String resultcommission_list() throws Exception {

        return SUCCESS;
    }

    /**
     * 保存实收金额
     * @return
     * @throws Exception
     */
    public String savePayment()throws Exception{

        ActionTemplate.executeAjaxMethod(true, this, new ActionAjaxMethodModifyCallback() {

            @Override
            public void modifyMethodException(Exception e) {
            }

            @Override
            public void modifyMethod() throws Exception {
                Date date = new Date();
                //合计勾选单元应收佣金
                BigDecimal sum_commissionAmount = new BigDecimal(0);
                BigDecimal sum_paymentAmount = new BigDecimal(0);
                BigDecimal b_paymentAmount = new BigDecimal(0);
                //实收
                String paymentAmount = request.getParameter("paymentAmount");

                String checkcommissionIds = request.getParameter("checkcommissionIds");
                String projectIds = request.getParameter("projectIds");
                String ids = request.getParameter("ids");
                String checkCommissionDates = request.getParameter("checkCommissionDates");
                //应收
                String t_commissionAmounts = request.getParameter("t_commissionAmounts");
                
                String[] idsArr = splitArr(ids);
                String[] checkcommissionIdsArr = splitArr(checkcommissionIds);
                String[] checkCommissionDatesArr = splitArr(checkCommissionDates);
                String[] t_commissionAmountsArr = splitArr(t_commissionAmounts);

                //合计应收佣金
                for (int i = 0; i < t_commissionAmountsArr.length; i++) {
                    BigDecimal t_commissionAmount = CommonUtils.exceptionToZero(t_commissionAmountsArr[i]);
                    sum_commissionAmount = sum_commissionAmount.add(t_commissionAmount);
                }

                //按比例拆分实收
                MathContext mc = new MathContext(2, RoundingMode.HALF_DOWN);
                //实收总额
                BigDecimal inp_paymentAmount = CommonUtils.exceptionToZero(paymentAmount);
                BigDecimal scale = inp_paymentAmount.divide(sum_commissionAmount, mc).setScale(4,
                        BigDecimal.ROUND_HALF_UP);

                //多个单元的时候，拆分到单元
                for (int i = 0; i < idsArr.length - 1; i++) {
                    Date checkCommissionDate = CommonUtils.getDateFromString(checkCommissionDatesArr[i]);
                    int icheckcommissionId = Integer.parseInt(checkcommissionIdsArr[i]);
                    //应收佣金
                    BigDecimal t_commissionAmount = CommonUtils.exceptionToZero(t_commissionAmountsArr[i]);
                    //单元实收
                    b_paymentAmount = scale.multiply(t_commissionAmount).setScale(0, BigDecimal.ROUND_HALF_UP);

                    if (t_commissionAmount.compareTo(b_paymentAmount) == 1) {
                        //判断应收>实收
                        sum_paymentAmount = sum_paymentAmount.add(b_paymentAmount);
                        //保存
                        CheckcommissionCond cond = new CheckcommissionCond();
                        cond.setId(icheckcommissionId);
                        cond.setPaymentAmount(b_paymentAmount);
                        cond.setModId(SessionUser.getUserId());
                        cond.setModTime(date);

                        iCheckcommissionServices.savePayment(cond);
                        addApPayment(projectIds, idsArr[i], date, b_paymentAmount, checkCommissionDate);
                        //System.out.println("b_paymentAmount="+b_paymentAmount + "====" + scale + "===== sum_paymentAmount="+sum_paymentAmount);
                    }

                }

                if (idsArr.length >= 1) {
                    int i = idsArr.length - 1;
                    //处理最后一个单元实收 或 只有1个单元
                    int icheckcommissionId = Integer.parseInt(checkcommissionIdsArr[i]);
                    Date checkCommissionDate = CommonUtils.getDateFromString(checkCommissionDatesArr[i]);
                    //单元实收
                    b_paymentAmount = inp_paymentAmount.subtract(sum_paymentAmount);

                    //保存
                    CheckcommissionCond cond = new CheckcommissionCond();
                    cond.setId(icheckcommissionId);
                    cond.setPaymentAmount(b_paymentAmount);
                    cond.setModId(SessionUser.getUserId());
                    cond.setModTime(date);

                    iCheckcommissionServices.savePayment(cond);
                    addApPayment(projectIds, idsArr[i], date, b_paymentAmount, checkCommissionDate);

                    //System.out.println("b_paymentAmount="+b_paymentAmount);
                }
            }
        });

        return null;
    }

    /**
     * 保存明细到实收表
     * @param projectIds
     * @param date
     * @param b_paymentAmount
     */
    private void addApPayment(String projectIds,String unitId,Date date,BigDecimal b_paymentAmount,Date checkCommissionDate){
        ApPayment ment = new ApPayment();
        int unit_id = Integer.parseInt(unitId);
        ment.setPropertyId(Integer.parseInt(projectIds));
        ment.setUnitId(unit_id);
        ment.setImpdate(date);
        ment.setReceiptdate(date);
        ment.setAmount(b_paymentAmount);
        ment.setReceiptdate(checkCommissionDate);

        PropertyProject propertyProject = DescUtils.findPropertyProjectByUnitId(unit_id);
        ment.setCompanyId(propertyProject.getCompanyProjectId());

        PropertyBuild propertyBuild = DescUtils.findPropertyBuildByUnitId(unit_id);
        ment.setBuildId(propertyBuild.getId());
        ment.setAreaId(propertyBuild.getAreaId());

        apPaymentServices.addApPayment(ment);
    }

    /**
     * 修改预对数表-导出对数
     * @return
     * @throws Exception
     */
    public String exportResultCommission() throws Exception{

        Map<String, Object> map = new HashMap<String, Object>();
        String srcFileName = "unit-resultcommission.xls";
        String fileName = "结佣表.xls";

        setCond();
        ConfirmCond cond = new ConfirmCond();
        cond.setCheckCommissionDate(cond.getCheckCommissionDate());
        cond.setCheckCommissionType(cond.getCheckCommissionType());

        List<Map<String, Object>> list = checkCommissionList(confirmCond);

        map.put("resultCommissionList", list);

        ReportUtils.downLoadReport(map, srcFileName, fileName, response);

        return null;
    }
    private  List<Map<String, Object>> checkCommissionList(ConfirmCond confirmCond) {
        JSONArray checkFeeArray = new JSONArray(); //list
        //JSONArray checkFeeFooterArray = new JSONArray(); //footer 合计
        JSONObject checkFeeMap = new JSONObject();
        //JSONObject unitList;

        BigDecimal SUM_build_area = new BigDecimal(0); //建筑面积
        BigDecimal SUM_build_price = new BigDecimal(0);//成交单价
        BigDecimal SUM_sum_money = new BigDecimal(0); //成交金额

        BigDecimal SUM_repayMoney = new BigDecimal(0); //回款金额
        BigDecimal SUM_repayAmount = new BigDecimal(0); //回款总金额
        String repayMoney ,repayAmount;
        BigDecimal b_repayMoney = new BigDecimal(0) ,b_repayAmount = new BigDecimal(0);

        List<Map<String, Object>> listConfirmUnit = null;

        //回款类型
        String repayType = confirmCond.getRepayType();
        String commissionType = confirmCond.getCheckCommissionType();
        int icommissionType = 0;
        if(!CommonUtils.isStrEmpty(commissionType)){
            icommissionType = Integer.parseInt(commissionType);
        }

        if(!CommonUtils.isStrEmpty(commissionType) && icommissionType== EnumUnitCheckCommissionType.HaveNotCheckFee.getValue()){
            //查询对佣表-未对佣
            listConfirmUnit = iCheckcommissionServices.findCheckfeeEd(confirmCond); //findCheckcommissionView
        } else {
            listConfirmUnit = iCheckcommissionServices.findCheckcommissionView(confirmCond);
        }

        int recordCount = 0;
        if (listConfirmUnit != null) {
            recordCount = listConfirmUnit.size();
        }

        try {
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
                String isRelation = CommonUtils.isStrEmpty(mapobject.get("is_relation")) ? "0" : mapobject.get("is_relation").toString();

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
                //对佣日期
                String checkcommission_date = mapobject.get("checkcommission_date")==null?"":mapobject.get("checkcommission_date").toString();
                String checkcommission_id = mapobject.get("checkcommission_id")==null?"":mapobject.get("checkcommission_id").toString();
                String checkfeeid = mapobject.get("checkfee_id")==null?"":mapobject.get("checkfee_id").toString();

                work_date = CommonUtils.getDateString(CommonUtils.getDateFromString(work_date));
                sign_date = CommonUtils.getDateString(CommonUtils.getDateFromString(sign_date));
                checkcommission_date = CommonUtils.getDateString(CommonUtils.getDateFromString(checkcommission_date));

                //=====================合计佣金和点数
                BigDecimal t_commission ,t_commissionAmount;
                BigDecimal commission = mapobject.get("commission")==null? new BigDecimal(0): CommonUtils.exceptionToZero(mapobject.get("commission").toString());
                BigDecimal commissionAmount = mapobject.get("commission_amount")==null? new BigDecimal(0): CommonUtils.exceptionToZero(mapobject.get("commission_amount").toString());
                BigDecimal rel_commission = mapobject.get("rel_commission")==null? new BigDecimal(0): CommonUtils.exceptionToZero(mapobject.get("rel_commission").toString());
                BigDecimal rel_commission_amount = mapobject.get("rel_commission_amount")==null? new BigDecimal(0): CommonUtils.exceptionToZero(mapobject.get("rel_commission_amount").toString());
                BigDecimal sec_commission = mapobject.get("sec_commission")==null? new BigDecimal(0): CommonUtils.exceptionToZero(mapobject.get("sec_commission").toString());
                BigDecimal sec_commissionAmount = mapobject.get("sec_commissionAmount")==null? new BigDecimal(0): CommonUtils.exceptionToZero(mapobject.get("sec_commissionAmount").toString());

                if(rel_commission.compareTo(BigDecimal.ZERO)==0 && rel_commission_amount.compareTo(BigDecimal.ZERO)==0){
                    t_commission = commission.add(sec_commission);
                } else {
                    t_commission = rel_commission.add(sec_commission);
                }
                if(rel_commission_amount.compareTo(BigDecimal.ZERO)==0 && rel_commission_amount.compareTo(BigDecimal.ZERO)==0){
                    t_commissionAmount = commissionAmount.add(sec_commissionAmount);
                } else {
                    t_commissionAmount = rel_commission_amount.add(sec_commissionAmount);
                }
                //======================= 合计佣金和点数 end

                BigDecimal b_sum_money = CommonUtils.exceptionToZero(sum_money).setScale(2, BigDecimal.ROUND_HALF_UP);
                BigDecimal b_payment_amount = CommonUtils.exceptionToZero(payment_amount).setScale(2, BigDecimal.ROUND_HALF_UP);
                BigDecimal b_build_price = new BigDecimal(build_price).setScale(0, BigDecimal.ROUND_HALF_UP);
                SUM_build_area = SUM_build_area.add(new BigDecimal(mapobject.get("BUILD_AREA").toString()));
                SUM_build_price = SUM_build_price.add(b_build_price);
                SUM_sum_money = SUM_sum_money.add(b_sum_money);

                String unit_id = mapobject.get("unit_id")==null?"":mapobject.get("unit_id").toString();
                String build_id = mapobject.get("build_id")==null?"":mapobject.get("build_id").toString();
                PropertyBuild build = iPropertyBuildServices.findPropertyBuildById(Integer.parseInt(build_id));

                //checkFeeMap.put("commission",commission);
                //checkFeeMap.put("commissionAmount",commissionAmount);
                //checkFeeMap.put("rel_commission",rel_commission);
                //checkFeeMap.put("rel_commissionAmount",rel_commission_amount);
                checkFeeMap.put("sec_commission",sec_commission);
                checkFeeMap.put("sec_commissionAmount",sec_commissionAmount);
                checkFeeMap.put("paymentAmount",mapobject.get("payment_amount"));
                checkFeeMap.put("t_commission",t_commission );
                checkFeeMap.put("t_commissionAmount", t_commissionAmount);

                checkFeeMap.put("unit_id",unit_id);
                checkFeeMap.put("work_date", work_date);
                checkFeeMap.put("sign_date", sign_date);
                checkFeeMap.put("checkfeeid",checkfeeid);
                checkFeeMap.put("checkcommissionId",checkcommission_id);
                checkFeeMap.put("checkcommission_date",checkcommission_date);
                checkFeeMap.put("checkcommissionTypeName", mapobject.get("checkcommission_type")==null?"": EnumUnitCheckCommissionType.getTextByValue(
                        Integer.parseInt(mapobject.get("checkcommission_type").toString())));
                checkFeeMap.put("area_name",build.getAreaName());
                checkFeeMap.put("build_name", mapobject.get("build_name")==null?"":mapobject.get("build_name").toString());
                checkFeeMap.put("unit_no", mapobject.get("unit_no")==null?"":mapobject.get("unit_no").toString());
                checkFeeMap.put("customer_name", customerName);
                checkFeeMap.put("contract_no",mapobject.get("contract_no") == null ? "" : mapobject.get("contract_no").toString());
                checkFeeMap.put("build_area", mapobject.get("BUILD_AREA"));
                checkFeeMap.put("build_price", b_build_price);
                checkFeeMap.put("sum_price", b_sum_money);
                checkFeeMap.put("payment_amount", b_payment_amount);

                repayMoney =  mapobject.get("repay_money") == null ? "0" : mapobject.get("repay_money").toString();
                repayAmount =  mapobject.get("repay_amount") == null ? "0" : mapobject.get("repay_amount").toString();
                checkFeeMap.put("repayMoney", repayMoney);
                checkFeeMap.put("repayAmount", repayAmount);


                //实收汇总
                SUM_repayMoney =  SUM_repayMoney.add(CommonUtils.exceptionToZero(repayMoney));
                SUM_repayAmount = SUM_repayAmount.add(CommonUtils.exceptionToZero(repayAmount));

                checkFeeArray.add(checkFeeMap);

            }

            /*合计：*/
            /*checkFeeMap = new JSONObject();
            checkFeeMap.put("build_area", SUM_build_area);

            checkFeeMap.put("checkfeeTypeName", "总记录数:");
            checkFeeMap.put("checkfee_date", recordCount);
            checkFeeMap.put("customer_name", "合计:");
            checkFeeMap.put("sum_price", SUM_sum_money);
            checkFeeMap.put("repayMoney",SUM_repayMoney);
            checkFeeMap.put("repayAmount",SUM_repayAmount);

            checkFeeFooterArray.add(checkFeeMap);

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("total", recordCount);// total键 存放总记录数，必须的
            map.put("rows", checkFeeArray);// rows键 存放每页记录 list
            map.put("footer", checkFeeFooterArray);// footer 存放合计*/

            //unitList = JSONObject.fromObject(map);// 格式化result一定要是JSONObject
            //ActionContext.getContext().getValueStack().set("unitList", unitList);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return checkFeeArray;
    }


}
