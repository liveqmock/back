package com.ihk.saleunit.action.new_report;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.ContContractManager;
import com.ihk.constanttype.ContUnitSaleState;
import com.ihk.saleunit.data.pojo.ConfirmCond;
import com.ihk.saleunit.data.services.IOtherExpensesServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.DateTimeUtils;
import com.ihk.utils.financial.FinancialUtils;
import com.ihk.utils.financial.MultManagerCommissionPojo;
import com.opensymphony.xwork2.ActionContext;

/**
 * Created with IntelliJ IDEA.
 * User: Lenovo
 * Date: 13-4-8
 * Time: 下午3:27
 * 项目结佣.
 */
@SuppressWarnings("serial")
public class CommissionPrjReportAction extends CommissionAction {
    @Autowired
    IOtherExpensesServices otherExpensesServices;

    private final Logger logger = Logger.getLogger(CommissionPrjReportAction.class);

    public String commission_detailFirst() throws Exception {

        initSearchDate();
        initListDate();

        return "commission_detailFirst";
    }

    public String commission_prj() throws Exception {
        initSearchDate();
        initListDate();
        prjCommission();
        return SUCCESS;
    }
    
    public String commission_affirm_prj() throws Exception{
    	initSearchDate();
        initListDate();
        prjCommissionAffirm();
    	return SUCCESS;
    }

    /**
     * 佣金报表实现(系统计算)
     * @return
     * @throws Exception
     */
    @SuppressWarnings("rawtypes")
	public String prjCommission()  throws Exception{
        JSONArray jsonArray = new JSONArray(); //list
        JSONArray jsonFooterArray = new JSONArray(); //footer 合计
        JSONObject jsonobj = new JSONObject();
        JSONObject prjList;

        logger.info("结佣明细表:输出开始 " + DateTimeUtils.getNow());

        String projectIds = request.getParameter("projectIds");
        if (projectIds == null) return SUCCESS;

        //合计项目
        BigDecimal tSUM_build_area = new BigDecimal(0); //建筑面积
        BigDecimal tSUM_build_price = new BigDecimal(0);//成交单价
        BigDecimal tSUM_sum_money = new BigDecimal(0); //成交金额
        BigDecimal tSUM_should_amount = new BigDecimal(0);//应收金额
        BigDecimal tSUM_should_amount2 = new BigDecimal(0);//应收金额
        BigDecimal tSUM_total_should_amount = new BigDecimal(0);//应收金额
        BigDecimal tSUM_payment_amount = new BigDecimal(0); //实收金额
        BigDecimal tSUM_amount = new BigDecimal(0);//未收金额
        BigDecimal tSUM_relamount = new BigDecimal(0);//关系户金额
        BigDecimal tSUM_otherMoney = new BigDecimal(0);//其它费用

        int recordCount = 0;
        if (projectIds != null) {
            List<String> prjlist = string2str(projectIds);
            recordCount = prjlist.size();
            Map<String,List> list = new HashMap<String, List>();
            list.put("list", prjlist);
            //其他费用
            List<Map> otherExpenses = otherExpensesServices.findOtherExpensesByProjectIds(list);
            
            
            for (int p = 0; p < recordCount; p++) {
                //处理每一个项目
                int projectid = Integer.parseInt(prjlist.get(p));
                int areaId = 0;
                int buildId = 0;
                confirmCond = new ConfirmCond();
                confirmCond.setPropertyId(prjlist.get(p));
                //取项目下的单元
                List<Map<String, Object>> listConfirmUnit = confirmServices.commissionReportByPrj(confirmCond);

                //取佣金
                List<MultManagerCommissionPojo> commissionList ;
                List<MultManagerCommissionPojo> secondcommissionList;
                if (listConfirmUnit!=null && listConfirmUnit.size()>0){
                    commissionList = FinancialUtils.getMultCommission(projectid, areaId, buildId, ContContractManager.MAIN_CONTRACT);
                    secondcommissionList = FinancialUtils.getMultCommission(projectid,areaId, buildId, ContContractManager.SECOND_LINKAGE);

                    String project_name = "";
                    BigDecimal SUM_build_area = new BigDecimal(0); //建筑面积
                    BigDecimal SUM_build_price = new BigDecimal(0);//成交单价
                    BigDecimal SUM_sum_money = new BigDecimal(0); //成交金额
                    BigDecimal SUM_should_amount = new BigDecimal(0);//应收金额
                    BigDecimal SUM_should_amount2 = new BigDecimal(0);//一二手联动应收金额
                    BigDecimal SUM_total_should_amount = new BigDecimal(0);//总应收金额
                    BigDecimal SUM_payment_amount = new BigDecimal(0); //实收金额
                    BigDecimal SUM_amount = new BigDecimal(0);//未收金额
                    BigDecimal SUM_relamount = new BigDecimal(0);//关系户佣金金额

                    //循环房间，归类到项目中
                    for (int i = 0; i < listConfirmUnit.size(); i++) {

                        Map<String, Object> mapobject = listConfirmUnit.get(i);

                        try {

                            //project_name =  mapobject.get("project_name").toString();
                            project_name =  mapobject.get("property_name").toString();
                            //销售状态
                            String sale_state = mapobject.get("sale_state").toString();
                            //单元成交或合同总金额
                            String sum_money = mapobject.get("sum_money") == null ? "0" : mapobject.get(
                                    "sum_money").toString();

                            //单价（建筑面积）
                            String build_price = mapobject.get("build_price") == null ? "0" : mapobject.get(
                                    "build_price").toString();

                            jsonobj.put("status", 0);
                            if (sale_state.equals(ContUnitSaleState.CONTRACT)) {
                                sum_money = mapobject.get("contract_sum_money") == null ? "0" : mapobject.get("contract_sum_money").toString();
                                jsonobj.put("status", 1);
                                //获取合同价格和金额
                                /*int unitid = Integer.parseInt(mapobject.get("unit_id").toString());
                                Contract contract = contractServices.findContractByUnitId(unitid);

                                if (contract != null) {
                                    sum_money = contract.getSumMoney().toString();
                                    jsonobj.put("status", 1);
                                }*/
                            }

                            //认购日期
                            String work_date = mapobject.get("work_date")==null?"":mapobject.get("work_date").toString();
                            work_date = CommonUtils.getDateString(CommonUtils.getDateFromString(work_date));

                            BigDecimal commission = BigDecimal.ZERO;  //佣金点
                            BigDecimal shouldAmount = BigDecimal.ZERO;  //应收佣金
                            BigDecimal secondcommission = BigDecimal.ZERO;  //一二手联动佣金点
                            BigDecimal b_sum_money = BigDecimal.ZERO;  //成交金额

                            //=======================实收金额
                            String payment_amount = "0";
                            String commission_time= null ;

                            //Map<String, Object> mapsum = sumByUnitId(unitId);

                            //if (mapsum!=null){
                                payment_amount = mapobject.get("payment_amount") == null ? payment_amount : mapobject.get("payment_amount").toString();
                                commission_time = mapobject.get("commission_time") == null ? commission_time : mapobject.get("commission_time").toString();
                            //}
                            //=======================实收金额 end

                            if(!CommonUtils.isStrEmpty(commission_time)) {
                                //佣金日期不为空，读对佣表
                                jsonobj.put("commissionStatus", 0); //颜色状态标识
                                commission = mapobject.get("commission") == null ? BigDecimal.ZERO : CommonUtils.exceptionToZero(mapobject.get("commission").toString());
                                shouldAmount = mapobject.get("commission_amount") == null ? BigDecimal.ZERO : CommonUtils.exceptionToZero(mapobject.get("commission_amount").toString());
                            } else {
                                jsonobj.put("commissionStatus", 1); //颜色状态标识
                                //获取佣金
                                commission = getCommission(commissionList, work_date);

                                //通过佣金计算应收金额
                                b_sum_money  = CommonUtils.exceptionToZero(sum_money).setScale(2,BigDecimal.ROUND_HALF_UP);
                                shouldAmount = ((b_sum_money.multiply(commission)).divide(new BigDecimal(100))).setScale(2, BigDecimal.ROUND_HALF_UP);

                            }


                            //-------------------------一二手联动判断 start
                            boolean isSecondLinkage = isSecondLinkage(mapobject);

                            if(isSecondLinkage){
                                secondcommission = getCommission(secondcommissionList,work_date);
                            }else {
                                secondcommission = new BigDecimal(BigInteger.ZERO);
                            }
                            //-------------------------一二手联动判断 end

                            //关系户判断
                            
                            boolean isRelation = isRelation(mapobject);
                            //关系户佣金
                            BigDecimal relCommissionAmount = getRelCommission(commissionList,work_date,b_sum_money);
                            
                            if(!isRelation){
                            	relCommissionAmount = BigDecimal.ZERO;
                            }else{
                            	commission = BigDecimal.ZERO;
                            	shouldAmount = BigDecimal.ZERO;
                            }

                            //通过佣金计算一二手联动应收金额
                            BigDecimal b_should_amount2 = ((b_sum_money.multiply(secondcommission)).divide(new BigDecimal(100))).setScale(2, BigDecimal.ROUND_HALF_UP);



                            //合计应收（一手+一二手联动应收金额 or 一二手联动应收金额+关系户）
                            BigDecimal total_should_amount = shouldAmount.add(b_should_amount2);

                            BigDecimal b_payment_amount = CommonUtils.exceptionToZero(payment_amount).setScale(2,
                                    BigDecimal.ROUND_HALF_UP);
                            BigDecimal b_build_price = new BigDecimal(build_price).setScale(0, BigDecimal.ROUND_HALF_UP);

                            //项目合计
                            SUM_build_area = SUM_build_area.add(new BigDecimal(mapobject.get("BUILD_AREA").toString()));
                            SUM_build_price = SUM_build_price.add(b_build_price);
                            SUM_sum_money = SUM_sum_money.add(b_sum_money);
                            SUM_should_amount = SUM_should_amount.add(shouldAmount);
                            SUM_should_amount2 = SUM_should_amount2.add(b_should_amount2);
                            SUM_total_should_amount = SUM_total_should_amount.add(total_should_amount);
                            SUM_payment_amount = SUM_payment_amount.add(b_payment_amount);
                            SUM_amount = SUM_amount.add(shouldAmount.subtract(b_payment_amount));
                            SUM_relamount = SUM_relamount.add(relCommissionAmount);

                            //项目总计
                            tSUM_build_area = tSUM_build_area.add(new BigDecimal(mapobject.get("BUILD_AREA").toString()));
                            tSUM_build_price = tSUM_build_price.add(b_build_price);
                            tSUM_sum_money = tSUM_sum_money.add(b_sum_money);
                            tSUM_should_amount = tSUM_should_amount.add(shouldAmount);
                            tSUM_should_amount2 = tSUM_should_amount2.add(b_should_amount2);
                            tSUM_total_should_amount = tSUM_total_should_amount.add(total_should_amount);
                            tSUM_payment_amount = tSUM_payment_amount.add(b_payment_amount);
                            tSUM_amount = tSUM_amount.add(shouldAmount.subtract(b_payment_amount));
                            tSUM_relamount = tSUM_relamount.add(relCommissionAmount);


                        } catch (Exception e) {
                            e.printStackTrace();
                            logger.error("prjCommission Exception:" + e.getMessage());
                        }
                    }

                    //otherExpensesTd 其它费用
                    BigDecimal otherMoney = new BigDecimal(0);


                    for (Map m : otherExpenses) {
						if((m.get("projectId")+"").equals(prjlist.get(p))){
							otherMoney = otherMoney.add(new BigDecimal(m.get("sumExpensesMoney")+""));
						}
					}
                    tSUM_otherMoney = tSUM_otherMoney.add(otherMoney);
                    /*项目合计：*/

                    if(SUM_sum_money.compareTo(BigDecimal.ZERO)>0){
                        tSUM_amount = tSUM_amount.subtract(otherMoney);
                        SUM_amount = SUM_amount.subtract(otherMoney);

                        jsonobj = new JSONObject();
                        if(SUM_build_area.compareTo(BigDecimal.ZERO)==0){
                        	jsonobj.put("build_price",BigDecimal.ZERO);
                        }else{
                        	jsonobj.put("build_price", SUM_sum_money.divide(SUM_build_area,2,BigDecimal.ROUND_HALF_UP).setScale(0, BigDecimal.ROUND_HALF_UP));
                        }
                        
                        jsonobj.put("project_name", project_name);
                        jsonobj.put("build_area", SUM_build_area);
                        jsonobj.put("sum_price", CommonUtils.moneyString(SUM_sum_money, 0, ""));
                        jsonobj.put("should_amount", CommonUtils.moneyString(SUM_should_amount, 0, ""));
                        jsonobj.put("secondshould_amount", CommonUtils.moneyString(SUM_should_amount2, 0, ""));
                        jsonobj.put("relCommissionAmount", CommonUtils.moneyString(SUM_relamount, 0, ""));
                        jsonobj.put("total_should_amount", CommonUtils.moneyString(SUM_total_should_amount, 0, ""));
                        jsonobj.put("payment_amount", CommonUtils.moneyString(SUM_payment_amount, 0, ""));
                        jsonobj.put("amount", CommonUtils.moneyString(SUM_amount, 0, ""));
                        jsonobj.put("otherAmount", CommonUtils.moneyString(otherMoney, 0, ""));

                        jsonArray.add(jsonobj);
                    }
                }
            }
        }

        /*合计：*/

        if(tSUM_sum_money.compareTo(BigDecimal.ZERO)>0 && tSUM_build_area.compareTo(BigDecimal.ZERO)>0){
            jsonobj = new JSONObject();
            if(tSUM_build_area.compareTo(BigDecimal.ZERO)==0){
            	jsonobj.put("build_price",BigDecimal.ZERO);
            }else{
            	jsonobj.put("build_price", tSUM_sum_money.divide(tSUM_build_area,2,BigDecimal.ROUND_HALF_UP).setScale(0, BigDecimal.ROUND_HALF_UP));
            }

            jsonobj.put("build_area", tSUM_build_area);
            jsonobj.put("sum_price", CommonUtils.moneyString(tSUM_sum_money, 0, ""));
            jsonobj.put("should_amount", CommonUtils.moneyString(tSUM_should_amount, 0, ""));
            jsonobj.put("secondshould_amount", CommonUtils.moneyString(tSUM_should_amount2, 0, ""));
            jsonobj.put("relCommissionAmount", CommonUtils.moneyString(tSUM_relamount, 0, ""));
            jsonobj.put("total_should_amount", CommonUtils.moneyString(tSUM_total_should_amount, 0, ""));
            jsonobj.put("payment_amount", CommonUtils.moneyString(tSUM_payment_amount, 0, ""));
            jsonobj.put("amount", CommonUtils.moneyString(tSUM_amount, 0, ""));
            jsonobj.put("otherAmount", CommonUtils.moneyString(tSUM_otherMoney, 0, ""));
            jsonobj.put("project_name", "合计:");
            jsonFooterArray.add(jsonobj);
        }


        logger.info("结佣明细表:输出完毕 " + DateTimeUtils.getNow());

        Map<String, Object> json = new HashMap<String, Object>();
        json.put("total", recordCount);// total键 存放总记录数，必须的
        json.put("rows", jsonArray);// rows键 存放每页记录 list
        json.put("footer", jsonFooterArray);// footer 存放合计

        prjList = JSONObject.fromObject(json);// 格式化result一定要是JSONObject
        ActionContext.getContext().getValueStack().set("prjList", prjList);

        return SUCCESS;
    }

    /**
     * 佣金报表实现(开发商确认)
     * @return
     * @throws Exception
     */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String prjCommissionAffirm()  throws Exception{
        JSONArray jsonArray = new JSONArray(); //list
        JSONArray jsonFooterArray = new JSONArray(); //footer 合计
        JSONObject jsonobj = new JSONObject();
        JSONObject prjList;

        logger.info("结佣明细表:输出开始 " + DateTimeUtils.getNow());

        String projectIds = request.getParameter("projectIds");
        if (projectIds == null) return SUCCESS;

        //合计项目
        BigDecimal tSUM_build_area = new BigDecimal(0); //建筑面积
        BigDecimal tSUM_build_price = new BigDecimal(0);//成交单价
        BigDecimal tSUM_sum_money = new BigDecimal(0); //成交金额
        BigDecimal tSUM_should_amount = new BigDecimal(0);//应收金额
        BigDecimal tSUM_should_amount2 = new BigDecimal(0);//应收金额
        BigDecimal tSUM_total_should_amount = new BigDecimal(0);//应收金额
        BigDecimal tSUM_payment_amount = new BigDecimal(0); //实收金额
        BigDecimal tSUM_amount = new BigDecimal(0);//未收金额
        BigDecimal tSUM_relamount = new BigDecimal(0);//关系户金额
        BigDecimal tSUM_otherMoney = new BigDecimal(0);//其它费用

        
        
        int recordCount = 0;
        if (projectIds != null) {
            List<String> prjlist = string2str(projectIds);
            recordCount = prjlist.size();
            Map<String,List> list = new HashMap<String, List>();
            list.put("list", prjlist);
            //其他费用
            List<Map> otherExpenses = otherExpensesServices.findOtherExpensesByProjectIds(list);
            
            for (int p = 0; p < recordCount; p++) {
                //处理每一个项目
                int projectid = Integer.parseInt(prjlist.get(p));
                int areaId = 0;
                int buildId = 0;
                confirmCond = new ConfirmCond();
                confirmCond.setPropertyId(prjlist.get(p));
                //取项目下的单元
//                List<Map<String, Object>> listConfirmUnit = confirmServices.commissionReportByPrj(confirmCond);

        		Map<String, Object> maps = new HashMap<String, Object>();
        		maps.put("propertyProjectId", projectid);
        		List<Map> lists =  checkfeeServices.findCheckfeeListByCond(maps);
                //取佣金
                List<MultManagerCommissionPojo> commissionList ;
                List<MultManagerCommissionPojo> secondcommissionList;
                if (lists!=null && lists.size()>0){
                    commissionList = FinancialUtils.getMultCommission(projectid, areaId, buildId, ContContractManager.MAIN_CONTRACT);
                    secondcommissionList = FinancialUtils.getMultCommission(projectid,areaId, buildId, ContContractManager.SECOND_LINKAGE);

                    String project_name = "";
                    BigDecimal SUM_build_area = new BigDecimal(0); //建筑面积
                    BigDecimal SUM_build_price = new BigDecimal(0);//成交单价
                    BigDecimal SUM_sum_money = new BigDecimal(0); //成交金额
                    BigDecimal SUM_should_amount = new BigDecimal(0);//应收金额
                    BigDecimal SUM_should_amount2 = new BigDecimal(0);//一二手联动应收金额
                    BigDecimal SUM_total_should_amount = new BigDecimal(0);//总应收金额
                    BigDecimal SUM_payment_amount = new BigDecimal(0); //实收金额
                    BigDecimal SUM_amount = new BigDecimal(0);//未收金额
                    BigDecimal SUM_relamount = new BigDecimal(0);//关系户佣金金额

                    //循环房间，归类到项目中
                    for (int i = 0; i < lists.size(); i++) {

                        Map<String, Object> mapobject = lists.get(i);

                        try {

                            //project_name =  mapobject.get("project_name").toString();
                            project_name =  mapobject.get("property_name").toString();
                            //销售状态
                            String sale_state = mapobject.get("sale_state").toString();
                            //单元成交或合同总金额
                            String sum_money = mapobject.get("sum_money") == null ? "0" : mapobject.get(
                                    "sum_money").toString();

                            //单价（建筑面积）
                            String build_price = mapobject.get("build_price") == null ? "0" : mapobject.get(
                                    "build_price").toString();

                            jsonobj.put("status", 0);
                            if (sale_state.equals(ContUnitSaleState.CONTRACT)) {
                                sum_money = mapobject.get("contract_sum_money") == null ? "0" : mapobject.get("contract_sum_money").toString();
                                jsonobj.put("status", 1);
                                //获取合同价格和金额
                                /*int unitid = Integer.parseInt(mapobject.get("unit_id").toString());
                                Contract contract = contractServices.findContractByUnitId(unitid);

                                if (contract != null) {
                                    sum_money = contract.getSumMoney().toString();
                                    jsonobj.put("status", 1);
                                }*/
                            }

                            //认购日期
                            String work_date = mapobject.get("work_date")==null?"":mapobject.get("work_date").toString();
                            work_date = CommonUtils.getDateString(CommonUtils.getDateFromString(work_date));

                            BigDecimal commission = BigDecimal.ZERO;  //佣金点
                            BigDecimal shouldAmount = BigDecimal.ZERO;  //应收佣金
                            BigDecimal secondcommission = BigDecimal.ZERO;  //一二手联动佣金点
                            BigDecimal b_sum_money = BigDecimal.ZERO;  //成交金额

                            //=======================实收金额
                            String payment_amount = "0";
                            String commission_time= null ;

                            //Map<String, Object> mapsum = sumByUnitId(unitId);

                            //if (mapsum!=null){
                                payment_amount = mapobject.get("payment_amount") == null ? payment_amount : mapobject.get("payment_amount").toString();
                                commission_time = mapobject.get("commission_time") == null ? commission_time : mapobject.get("commission_time").toString();
                            //}
                            //=======================实收金额 end

                            if(!CommonUtils.isStrEmpty(commission_time)) {
                                //佣金日期不为空，读对佣表
                                jsonobj.put("commissionStatus", 0); //颜色状态标识
                                commission = mapobject.get("commission1") == null ? BigDecimal.ZERO : CommonUtils.exceptionToZero(mapobject.get("commission1").toString());
                                shouldAmount = mapobject.get("commission_amount1") == null ? BigDecimal.ZERO : CommonUtils.exceptionToZero(mapobject.get("commission_amount1").toString());
                                b_sum_money  = CommonUtils.exceptionToZero(sum_money).setScale(2,BigDecimal.ROUND_HALF_UP);
                            } else {
                                jsonobj.put("commissionStatus", 1); //颜色状态标识
                                //获取佣金
                                commission = getCommission(commissionList, work_date);

                                //通过佣金计算应收金额
                                b_sum_money  = CommonUtils.exceptionToZero(sum_money).setScale(2,BigDecimal.ROUND_HALF_UP);
                                shouldAmount = ((b_sum_money.multiply(commission)).divide(new BigDecimal(100))).setScale(2, BigDecimal.ROUND_HALF_UP);

                            }


                            //-------------------------一二手联动判断 start
                            boolean isSecondLinkage = isSecondLinkage(mapobject);

                            if(isSecondLinkage){
//                              
                          	Object sec_commission =  mapobject.get("sec_commission1");
                          	if(sec_commission!=null)
                          		secondcommission = new BigDecimal(sec_commission.toString());
                          	else
                          		secondcommission = getCommission(secondcommissionList,work_date);
                          }else {
                              secondcommission = new BigDecimal(BigInteger.ZERO);
                          }
                            //-------------------------一二手联动判断 end

                            //关系户判断
                            
                            boolean isRelation = isRelation(mapobject);
                            //关系户佣金
                            BigDecimal relCommissionAmount = getRelCommission(commissionList,work_date,b_sum_money);
                            
                            if(!isRelation){
                            	relCommissionAmount = BigDecimal.ZERO;
                            }else{
                            	commission = BigDecimal.ZERO;
                            	shouldAmount = BigDecimal.ZERO;
                            }

                            //通过佣金计算一二手联动应收金额
                            BigDecimal b_should_amount2 = ((b_sum_money.multiply(secondcommission)).divide(new BigDecimal(100))).setScale(2, BigDecimal.ROUND_HALF_UP);



                            //合计应收（一手+一二手联动应收金额 or 一二手联动应收金额+关系户）
                            BigDecimal total_should_amount = shouldAmount.add(b_should_amount2);

                            BigDecimal b_payment_amount = CommonUtils.exceptionToZero(payment_amount).setScale(2,
                                    BigDecimal.ROUND_HALF_UP);
                            BigDecimal b_build_price = new BigDecimal(build_price).setScale(0, BigDecimal.ROUND_HALF_UP);

                            //项目合计
                            SUM_build_area = SUM_build_area.add(new BigDecimal(mapobject.get("BUILD_AREA").toString()));
                            SUM_build_price = SUM_build_price.add(b_build_price);
                            SUM_sum_money = SUM_sum_money.add(b_sum_money);
                            SUM_should_amount = SUM_should_amount.add(shouldAmount);
                            SUM_should_amount2 = SUM_should_amount2.add(b_should_amount2);
                            SUM_total_should_amount = SUM_total_should_amount.add(total_should_amount);
                            SUM_payment_amount = SUM_payment_amount.add(b_payment_amount);
                            SUM_amount = SUM_amount.add(shouldAmount.subtract(b_payment_amount));
                            SUM_relamount = SUM_relamount.add(relCommissionAmount);

                            //项目总计
                            tSUM_build_area = tSUM_build_area.add(new BigDecimal(mapobject.get("BUILD_AREA").toString()));
                            tSUM_build_price = tSUM_build_price.add(b_build_price);
                            tSUM_sum_money = tSUM_sum_money.add(b_sum_money);
                            tSUM_should_amount = tSUM_should_amount.add(shouldAmount);
                            tSUM_should_amount2 = tSUM_should_amount2.add(b_should_amount2);
                            tSUM_total_should_amount = tSUM_total_should_amount.add(total_should_amount);
                            tSUM_payment_amount = tSUM_payment_amount.add(b_payment_amount);
                            tSUM_amount = tSUM_amount.add(shouldAmount.subtract(b_payment_amount));
                            tSUM_relamount = tSUM_relamount.add(relCommissionAmount);


                        } catch (Exception e) {
                            e.printStackTrace();
                            logger.error("prjCommission Exception:" + e.getMessage());
                        }
                    }

                    //otherExpensesTd 其它费用
                    BigDecimal otherMoney = new BigDecimal(0);


                    for (Map m : otherExpenses) {
						if((m.get("projectId")+"").equals(prjlist.get(p))){
							otherMoney = otherMoney.add(new BigDecimal(m.get("sumExpensesMoney")+""));
						}
					}
                    tSUM_otherMoney = tSUM_otherMoney.add(otherMoney);
                    /*项目合计：*/

                    if(SUM_sum_money.compareTo(BigDecimal.ZERO)>0){
                        tSUM_amount = tSUM_amount.subtract(otherMoney);
                        SUM_amount = SUM_amount.subtract(otherMoney);

                        jsonobj = new JSONObject();
                        if(SUM_build_area.compareTo(BigDecimal.ZERO)==0){
                        	jsonobj.put("build_price",BigDecimal.ZERO);
                        }else{
                        	jsonobj.put("build_price", SUM_sum_money.divide(SUM_build_area,2,BigDecimal.ROUND_HALF_UP).setScale(0, BigDecimal.ROUND_HALF_UP));
                        }
                        jsonobj.put("project_name", project_name);
                        
                        jsonobj.put("build_area", SUM_build_area);
                        jsonobj.put("sum_price", CommonUtils.moneyString(SUM_sum_money, 0, ""));
                        jsonobj.put("should_amount", CommonUtils.moneyString(SUM_should_amount, 0, ""));
                        jsonobj.put("secondshould_amount", CommonUtils.moneyString(SUM_should_amount2, 0, ""));
                        jsonobj.put("relCommissionAmount", CommonUtils.moneyString(SUM_relamount, 0, ""));
                        jsonobj.put("total_should_amount", CommonUtils.moneyString(SUM_total_should_amount, 0, ""));
                        jsonobj.put("payment_amount", CommonUtils.moneyString(SUM_payment_amount, 0, ""));
                        jsonobj.put("amount", CommonUtils.moneyString(SUM_amount, 0, ""));
                        jsonobj.put("otherAmount", CommonUtils.moneyString(otherMoney, 0, ""));

                        jsonArray.add(jsonobj);
                    }
                }
            }
        }

        /*合计：*/

        if(tSUM_sum_money.compareTo(BigDecimal.ZERO)>0 && tSUM_build_area.compareTo(BigDecimal.ZERO)>0){
            jsonobj = new JSONObject();
            if(tSUM_build_area.compareTo(BigDecimal.ZERO)==0){
            	jsonobj.put("build_price",BigDecimal.ZERO);
            }else{
            	jsonobj.put("build_price", tSUM_sum_money.divide(tSUM_build_area,2,BigDecimal.ROUND_HALF_UP).setScale(0, BigDecimal.ROUND_HALF_UP));
            }
            

            jsonobj.put("build_area", tSUM_build_area);
            jsonobj.put("sum_price", CommonUtils.moneyString(tSUM_sum_money, 0, ""));
            jsonobj.put("should_amount", CommonUtils.moneyString(tSUM_should_amount, 0, ""));
            jsonobj.put("secondshould_amount", CommonUtils.moneyString(tSUM_should_amount2, 0, ""));
            jsonobj.put("relCommissionAmount", CommonUtils.moneyString(tSUM_relamount, 0, ""));
            jsonobj.put("total_should_amount", CommonUtils.moneyString(tSUM_total_should_amount, 0, ""));
            jsonobj.put("payment_amount", CommonUtils.moneyString(tSUM_payment_amount, 0, ""));
            jsonobj.put("amount", CommonUtils.moneyString(tSUM_amount, 0, ""));
            jsonobj.put("otherAmount", CommonUtils.moneyString(tSUM_otherMoney, 0, ""));
            jsonobj.put("project_name", "合计:");
            jsonFooterArray.add(jsonobj);
        }


        logger.info("结佣明细表:输出完毕 " + DateTimeUtils.getNow());

        Map<String, Object> json = new HashMap<String, Object>();
        json.put("total", recordCount);// total键 存放总记录数，必须的
        json.put("rows", jsonArray);// rows键 存放每页记录 list
        json.put("footer", jsonFooterArray);// footer 存放合计

        prjList = JSONObject.fromObject(json);// 格式化result一定要是JSONObject
        ActionContext.getContext().getValueStack().set("prjList", prjList);

        return SUCCESS;
    }
    
    
    
    private List<String> string2str(String projectIds) {
        String[] strProjectIds = projectIds.split(",");
        String[] iProjectIds = new String[strProjectIds.length];
        for (int i = 0; i < strProjectIds.length; i++) {
            iProjectIds[i] = strProjectIds[i];
        }

        return Arrays.asList(iProjectIds);
    }


}
