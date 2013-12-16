package com.ihk.saleunit.action.check_commission_sec;

import com.ihk.constanttype.ContConfirmType;
import com.ihk.constanttype.ContContractManager;
import com.ihk.constanttype.ContUnitSaleState;
import com.ihk.constanttype.EnumUnitCheckCommissionType;
import com.ihk.property.data.pojo.PropertyBuild;
import com.ihk.saleunit.data.pojo.ConfirmCond;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.ReportUtils;
import com.ihk.utils.contract.customer.ContractCustomerUtils;
import com.ihk.utils.financial.FinancialUtils;
import com.ihk.utils.financial.MultManagerCommissionPojo;
import com.opensymphony.xwork2.ActionContext;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hslf.examples.ApacheconEU08;

/**
 * Created with IntelliJ IDEA.
 * User: Lenovo
 * Date: 13-7-13
 * Time: 上午9:52
 * To change this template use File | Settings | File Templates.
 */
public class CheckCommissionViewAction extends CheckCommissionManagerAction {
    /**
     * 对佣表查看初始化，弹框时用
     * @return
     * @throws Exception
     */
    public String checkcommission_view_init() throws Exception {

        setCond();

        String checkCommissionDate = request.getParameter("checkCommissionDate");
        confirmCond.setCheckCommissionDate(checkCommissionDate);

        request.getSession().setAttribute("CheckCommissionCond", confirmCond);

        return SUCCESS;
    }

    /**
     * 修改对佣表
     * @return
     * @throws Exception
     */
    public String checkcommission_mod() throws Exception {

        initSearchDate();
        initListDate();
        /*saleMap = ContUnitSaleState.getContractState(false);
        checkFeeTypeMap = EnumUnitCheckfeeType.getCheckfeeType();*/

        return SUCCESS;
    }

    /**
     * 对佣表查看列表返回json
     * @return 返回json
     * @throws Exception
     */
    public String checkcommission_view() throws Exception {
        confirmCond = (ConfirmCond)request.getSession().getAttribute("CheckCommissionCond");

        ConfirmCond cond = new ConfirmCond();
        cond.setCheckCommissionDate(cond.getCheckCommissionDate());
        cond.setCheckCommissionType(cond.getCheckCommissionType());

        checkCommissionList(confirmCond);
        return SUCCESS;
    }

    /**
     * 修改对佣表 查看
     * @return
     * @throws Exception
     */
    public String checkmod_view() throws Exception {
        setCond();
        
        ConfirmCond cond = new ConfirmCond();
        cond.setCheckCommissionDate(cond.getCheckCommissionDate());
//        cond.setCheckCommissionType(cond.getCheckCommissionType());

        checkCommissionList(confirmCond);
        return SUCCESS;
    }

    private String checkCommissionList(ConfirmCond confirmCond) {
        JSONArray checkFeeArray = new JSONArray(); //list
        JSONArray checkFeeFooterArray = new JSONArray(); //footer 合计
        JSONObject checkFeeMap = new JSONObject();
        JSONObject unitList;

        BigDecimal SUM_build_area = new BigDecimal(0); //建筑面积
        BigDecimal SUM_build_price = new BigDecimal(0);//成交单价
        BigDecimal SUM_sum_money = new BigDecimal(0); //成交金额

        BigDecimal SUM_repayMoney = new BigDecimal(0); //回款金额
        BigDecimal SUM_repayAmount = new BigDecimal(0); //回款总金额

        BigDecimal SUM_secCommission = new BigDecimal(0); //一二手佣金点数
        BigDecimal SUM_secCommissionAmount = new BigDecimal(0); //一二手佣金

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

        if(!CommonUtils.isStrEmpty(commissionType) && icommissionType==EnumUnitCheckCommissionType.HaveNotCheckFee.getValue()){
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
                if("0".equals(mapobject.get("is_second_linkage")))
                	continue;
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

                //
                BigDecimal b_sum_money = CommonUtils.exceptionToZero(sum_money).setScale(2, BigDecimal.ROUND_HALF_UP);
                BigDecimal b_payment_amount = CommonUtils.exceptionToZero(payment_amount).setScale(2, BigDecimal.ROUND_HALF_UP);
                BigDecimal b_build_price = new BigDecimal(build_price).setScale(0, BigDecimal.ROUND_HALF_UP);
                SUM_build_area = SUM_build_area.add(new BigDecimal(mapobject.get("BUILD_AREA").toString()));
                SUM_build_price = SUM_build_price.add(b_build_price);
                SUM_sum_money = SUM_sum_money.add(b_sum_money);

                BigDecimal secCommission = mapobject.get("sec_commission")==null?BigDecimal.ZERO : CommonUtils.exceptionToZero(mapobject.get("sec_commission").toString()).setScale(2, BigDecimal.ROUND_HALF_UP);
                BigDecimal secCommissionAmount = mapobject.get("sec_commission_amount")==null?BigDecimal.ZERO : CommonUtils.exceptionToZero(mapobject.get("sec_commission_amount").toString()).setScale(2, BigDecimal.ROUND_HALF_UP);
                SUM_secCommission = secCommission;
                SUM_secCommissionAmount = SUM_secCommissionAmount.add(secCommissionAmount);

                String unit_id = mapobject.get("unit_id")==null?"":mapobject.get("unit_id").toString();
                String build_id = mapobject.get("build_id")==null?"":mapobject.get("build_id").toString();
                PropertyBuild build = iPropertyBuildServices.findPropertyBuildById(Integer.parseInt(build_id));
                //Map<String, Object> commissionMap = getCommissionSec(commissionList,work_date);
                BigDecimal sec_commission =  getCommissionSec(commissionList,work_date);
//                Object commission  =  mapobject.get("commission")==null? ;
                
                checkFeeMap.put("sec_commission",sec_commission);
                checkFeeMap.put("sec_commissionAmount",mapobject.get("sec_commission_amount"));

                checkFeeMap.put("paymentAmount",mapobject.get("payment_amount"));

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
                /*SUM_repayMoney =  SUM_repayMoney.add(CommonUtils.exceptionToZero(repayMoney));
                SUM_repayAmount = SUM_repayAmount.add(CommonUtils.exceptionToZero(repayAmount));*/

                checkFeeArray.add(checkFeeMap);

            }

                        /*合计：*/
            checkFeeMap = new JSONObject();
            checkFeeMap.put("build_area", SUM_build_area);

            checkFeeMap.put("checkfeeTypeName", "总记录数:");
            checkFeeMap.put("checkfee_date", recordCount);
            checkFeeMap.put("customer_name", "合计");
            checkFeeMap.put("sum_price", SUM_sum_money);
            checkFeeMap.put("repayMoney",SUM_repayMoney);
            checkFeeMap.put("repayAmount",SUM_repayAmount);

            checkFeeMap.put("sec_commission",SUM_secCommission);
            checkFeeMap.put("sec_commissionAmount",SUM_secCommissionAmount);

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
     * 新建预对数表-导出对数
     * @return
     * @throws Exception
     */
    public String exportExcel() throws Exception{

        Map<String, Object> map = new HashMap<String, Object>();
        String srcFileName = "unit-checkcommission.xls";
        String fileName = "对佣表.xls";

        confirmCond = (ConfirmCond)request.getSession().getAttribute("CheckCommissionCond");

        List<Map<String, Object>> list = getExportList(confirmCond);

        map.put("checkCommissionList", list);

        ReportUtils.downLoadReport(map, srcFileName, fileName, response);

        return null;
    }

    /**
     * 修改预对佣表-导出对数
     * @return
     * @throws Exception
     */
    public String exportExcel_Mod() throws Exception{

        Map<String, Object> map = new HashMap<String, Object>();
        String srcFileName = "unit-checkcommission_sec.xls";
        String fileName = "对佣表.xls";

        setCond();

        List<Map<String, Object>> list = getExportList(confirmCond);

        map.put("checkCommissionList", list);

        ReportUtils.downLoadReport(map, srcFileName, fileName, response);

        return null;
    }

    public List<Map<String, Object>> getExportList(ConfirmCond cond){
        List<Map<String, Object>> list = iCheckcommissionServices.findCheckcommissionView(cond);
        List<Map<String, Object>> checkFeeList = new ArrayList<Map<String,Object>>();

        if(CommonUtils.isCollectionEmpty(list)){

            return null;
        }

        BigDecimal SUM_build_area = new BigDecimal(0); //建筑面积
        BigDecimal SUM_build_price = new BigDecimal(0);//成交单价
        BigDecimal SUM_sum_money = new BigDecimal(0); //成交金额

        Map<String, Object> checkFeeMap = null;

        try {

            //循环房间，归类到项目中
            for (int i = 0; i < list.size(); i++) {

                checkFeeMap = new HashMap<String, Object>();

                Map<String, Object> mapobject = list.get(i);
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
                String sign_date = mapobject.get("sign_date")==null?"":mapobject.get("sign_date").toString();
                String checkcommission_date = mapobject.get("checkcommission_date")==null?"":mapobject.get("checkcommission_date").toString();

                work_date = CommonUtils.getDateString(CommonUtils.getDateFromString(work_date));
                sign_date = CommonUtils.getDateString(CommonUtils.getDateFromString(sign_date));
                checkcommission_date = CommonUtils.getDateString(CommonUtils.getDateFromString(checkcommission_date));

                //=====================合计佣金和点数
                BigDecimal t_commission ,t_commissionAmount ;
                BigDecimal commission = mapobject.get("commission")==null? new BigDecimal(0): CommonUtils.exceptionToZero(mapobject.get("commission").toString());
                BigDecimal commissionAmount = mapobject.get("commission_amount")==null? new BigDecimal(0): CommonUtils.exceptionToZero(mapobject.get("commission_amount").toString());
                BigDecimal rel_commission = mapobject.get("rel_commission")==null? new BigDecimal(0): CommonUtils.exceptionToZero(mapobject.get("rel_commission").toString());
                BigDecimal rel_commission_amount = mapobject.get("rel_commission_amount")==null? new BigDecimal(0): CommonUtils.exceptionToZero(mapobject.get("rel_commission_amount").toString());
                BigDecimal sec_commission = mapobject.get("sec_commission")==null? new BigDecimal(0): CommonUtils.exceptionToZero(mapobject.get("sec_commission").toString());
                BigDecimal sec_commissionAmount = mapobject.get("sec_commission_amount")==null? new BigDecimal(0): CommonUtils.exceptionToZero(mapobject.get("sec_commission_amount").toString());

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

                checkFeeMap.put("commission",commission);
                checkFeeMap.put("commissionAmount",commissionAmount);
                checkFeeMap.put("rel_commission",rel_commission);
                checkFeeMap.put("rel_commissionAmount",rel_commission_amount);
                checkFeeMap.put("sec_commission",sec_commission);
                checkFeeMap.put("sec_commissionAmount",sec_commissionAmount);
                checkFeeMap.put("paymentAmount",mapobject.get("payment_amount"));
                checkFeeMap.put("t_commission",t_commission );
                checkFeeMap.put("t_commissionAmount", t_commissionAmount);

                checkFeeMap.put("contract_no",  mapobject.get("contract_no")==null?"": mapobject.get("contract_no").toString());
                checkFeeMap.put("unit_id", mapobject.get("unit_id")==null?"":mapobject.get("unit_id").toString());
                checkFeeMap.put("work_date", work_date);
                checkFeeMap.put("sign_date", sign_date);
                checkFeeMap.put("checkcommission_date",checkcommission_date);
                checkFeeMap.put("checkcommissionTypeName", mapobject.get("checkcommission_type")==null?"": EnumUnitCheckCommissionType.getTextByValue(
                        Integer.parseInt(mapobject.get("checkcommission_type").toString())));

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
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Map> createDownSrc(){
    	JSONObject src = (JSONObject)request.getSession().getAttribute("Down");
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
