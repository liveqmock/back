package com.ihk.saleunit.action.check_fee;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ihk.constanttype.ContConfirmType;
import com.ihk.constanttype.ContUnitSaleState;
import com.ihk.constanttype.EnumUnitCheckfeeType;
import com.ihk.saleunit.data.pojo.ConfirmCond;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.ReportUtils;
import com.ihk.utils.contract.customer.ContractCustomerUtils;

/**
 * Created with IntelliJ IDEA.
 * User: Lenovo
 * Date: 13-5-27
 * Time: 下午5:58
 * 查看对数表.
 */
public class CheckFeeViewAction extends CheckFeeAction {

    private static final long serialVersionUID = 4839941012012394417L;

	/**
     * 对数表查看初始化，弹框时用
     * @return
     * @throws Exception
     */
    public String checkfee_view_init() throws Exception {

        setCond();

        String checkFeeDate = request.getParameter("checkFeeDate");
        confirmCond.setCheckFeeDate(checkFeeDate);

        request.getSession().setAttribute("CheckFeeCond",confirmCond);

        return SUCCESS;
    }

    /**
     * 对数表查看列表返回json
     * @return 返回json
     * @throws Exception
     */
    public String checkfee_view() throws Exception {
        confirmCond = (ConfirmCond)request.getSession().getAttribute("CheckFeeCond");
        unitList(confirmCond);
        return SUCCESS;
    }

    /**
     * 新建预对数表-导出对数
     * @return
     * @throws Exception
     */
    public String exportExcel() throws Exception{

        Map<String, Object> map = new HashMap<String, Object>();
        String srcFileName = "unit-checkfee.xls";
        String fileName = "成交客户.xls";

        confirmCond = (ConfirmCond)request.getSession().getAttribute("CheckFeeCond");

        List<Map<String, Object>> checkFeeList = getExportList(confirmCond);

        map.put("checkFeeList", checkFeeList);

        ReportUtils.downLoadReport(map, srcFileName, fileName, response);

        return null;
    }

    /**
     * 修改预对数表-导出对数
     * @return
     * @throws Exception
     */
    public String exportExcel_Mod() throws Exception{

        Map<String, Object> map = new HashMap<String, Object>();
        String srcFileName = "unit-checkfee.xls";
        String fileName = "成交客户.xls";

        setCond();

        List<Map<String, Object>> checkFeeList = getExportList(confirmCond);

        map.put("checkFeeList", checkFeeList);

        ReportUtils.downLoadReport(map, srcFileName, fileName, response);

        return null;
    }

    public List<Map<String, Object>> getExportList(ConfirmCond confirmCond){
        List<Map<String, Object>> listConfirmUnit = confirmServices.checkFeeList(confirmCond);
        List<Map<String, Object>> checkFeeList = new ArrayList<Map<String,Object>>();

        if(CommonUtils.isCollectionEmpty(listConfirmUnit)){

            return null;
        }

        BigDecimal SUM_build_area = new BigDecimal(0); //建筑面积
        BigDecimal SUM_build_price = new BigDecimal(0);//成交单价
        BigDecimal SUM_sum_money = new BigDecimal(0); //成交金额

        Map<String, Object> checkFeeMap = null;

        try {

            //循环房间，归类到项目中
            for (int i = 0; i < listConfirmUnit.size(); i++) {

                checkFeeMap = new HashMap<String, Object>();

                Map<String, Object> mapobject = listConfirmUnit.get(i);
                int mainId; //合同客户表中
                String customerName;

                //销售状态
                //String sale_state = mapobject.get("sale_state").toString();
                //单元成交或合同总金额
                String sum_money = mapobject.get("contract_sum_money") == null ? "0" : mapobject.get("contract_sum_money").toString();
                //实收金额
                String payment_amount = mapobject.get("payment_amount") == null ? "0" : mapobject.get("payment_amount").toString();
                //单价（建筑面积）
                String build_price = mapobject.get("build_price") == null ? "0" : mapobject.get("build_price").toString();
                String saleState = mapobject.get("sale_state").toString();
                if(saleState.equals(ContUnitSaleState.CONFIRM)) {
                	sum_money = mapobject.get("confirm_sum_money") == null ? "0" : mapobject.get("confirm_sum_money").toString();
                  checkFeeMap.put("pay_name", mapobject.get("confirm_pay_name")==null?"": mapobject.get("confirm_pay_name").toString());
                  checkFeeMap.put("sales",mapobject.get("confirm_sales_id")==null?"": getSalesName(
                          mapobject.get("confirm_sales_id").toString()));

                  mainId =  Integer.parseInt(mapobject.get("confirm_id").toString());
                  customerName = ContractCustomerUtils.getCustomerNameByMainIdAndConfirmType(mainId,
                          ContConfirmType.CONFIRM);
                }else{
                	checkFeeMap.put("pay_name",mapobject.get("contract_pay_name")==null?"": mapobject.get("contract_pay_name").toString());
                  checkFeeMap.put("sales",mapobject.get("contract_sales_id")==null?"": getSalesName(mapobject.get("contract_sales_id").toString()));

                  mainId =  Integer.parseInt(mapobject.get("contract_id").toString());
                  customerName = ContractCustomerUtils.getCustomerNameByMainIdAndConfirmType(mainId,
                          ContConfirmType.CONTRACT);
                }

                //认购日期
                String work_date = mapobject.get("work_date")==null?"":mapobject.get("work_date").toString();
                String sign_date = mapobject.get("sign_date")==null?"":mapobject.get("sign_date").toString();
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

                checkFeeMap.put("contract_no",  mapobject.get("contract_no")==null?"": mapobject.get("contract_no").toString());
                checkFeeMap.put("unit_id", mapobject.get("unit_id")==null?"":mapobject.get("unit_id").toString());
                checkFeeMap.put("work_date", work_date);
                checkFeeMap.put("sign_date", sign_date);
                checkFeeMap.put("checkfee_date",checkfee_date);
                checkFeeMap.put("checkfeeTypeName", mapobject.get("checkfee_type")==null?"": EnumUnitCheckfeeType.getTextByValue(
                        Integer.parseInt(mapobject.get("checkfee_type").toString())));

                checkFeeMap.put("build_name", mapobject.get("build_name")==null?"":mapobject.get("build_name").toString());
                checkFeeMap.put("unit_no", mapobject.get("unit_no")==null?"":mapobject.get("unit_no").toString());
                checkFeeMap.put("customer_name", customerName);
                checkFeeMap.put("build_area", mapobject.get("BUILD_AREA"));
                checkFeeMap.put("build_price", CommonUtils.moneyString(b_build_price, 0, ""));
                checkFeeMap.put("sum_price", CommonUtils.moneyString(b_sum_money, 0, ""));
                checkFeeMap.put("payment_amount", CommonUtils.moneyString(b_payment_amount, 0, ""));

                checkFeeList.add(checkFeeMap);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return  checkFeeList;
    }

    /**
     * 根据单元id获取一条对数数据,(暂时没用到)
     * @return
     * @throws Exception
     */
    public String getCheckFeeRowDataForAddByUnitId() throws Exception{

       /* int unitId = Integer.parseInt(request.getParameter("unitId"));

        List<Map<String, Object>> checkFeeList = confirmServices.findCheckFeeDataByUnitId(unitId);*/

        return null;
    }


}
