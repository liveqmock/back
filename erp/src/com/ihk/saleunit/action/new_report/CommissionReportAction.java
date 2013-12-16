package com.ihk.saleunit.action.new_report;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.ihk.constanttype.ContConfirmType;
import com.ihk.constanttype.ContContractManager;
import com.ihk.constanttype.ContUnitSaleState;
import com.ihk.saleunit.data.pojo.ConfirmCond;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.DateTimeUtils;
import com.ihk.utils.ReportUtils;
import com.ihk.utils.contract.customer.ContractCustomerUtils;
import com.ihk.utils.financial.FinancialUtils;
import com.ihk.utils.financial.MultManagerCommissionPojo;
import com.ihk.utils.saleunit.MyPropertyUtils;
import com.opensymphony.xwork2.ActionContext;

/**
 * 单元结佣明细表
 */
public class CommissionReportAction extends CommissionAction {
    private final Logger logger = Logger.getLogger(CommissionReportAction.class);

    private static final long serialVersionUID = 1L;
    
    /**
     * 单元佣金报表显示，不显示数据
     * @return
     * @throws Exception
     */
    public String commission_detailFirst() throws Exception {

        initSearchDate();
        initListDate();

        return "commission_detailFirst";
    }

    /**
     * 单元佣金计算(系统计算)
     * @return 返回json
     * @throws Exception
     */
    public String commission_unit() throws Exception {
        initSearchDate();
        initListDate();
        unitCommission();
        return SUCCESS;
    }

    /**
     * 单元佣金计算(系统计算)
     * @return  生成json返回
     */
    public String unitCommission() {
        JSONArray jsonArray = new JSONArray(); //list
        JSONArray jsonFooterArray = new JSONArray(); //footer 合计
        JSONObject jsonobj = new JSONObject();
        JSONObject unitList;

        String projectId = request.getParameter("projectIds");
        String sBuildId = request.getParameter("buildId");
        String sAreaId = request.getParameter("areaId");

        List<Integer> projectIds = new ArrayList<Integer>();
        projectIds.add(Integer.parseInt(projectId));
        int projectid = projectId == null || projectId.length() == 0 ? 0 : Integer.parseInt(projectId);
        int buildId = sBuildId == null || sBuildId.length() == 0 ? 0 : Integer.parseInt(sBuildId);
        int areaId = sAreaId == null || sAreaId.length() == 0 ? 0 : Integer.parseInt(sAreaId);

        confirmCond = new ConfirmCond();
        confirmCond.setProjectIds(projectIds);
        confirmCond.setBuildId(sBuildId);
        confirmCond.setAreaId(sAreaId);


        List<MultManagerCommissionPojo> commissionList= FinancialUtils.getMultCommission(projectid, areaId, buildId, ContContractManager.MAIN_CONTRACT);
        List<MultManagerCommissionPojo> secondcommissionList= FinancialUtils.getMultCommission(projectid, areaId, buildId, ContContractManager.SECOND_LINKAGE);


        //----------end 跳吧判断

        BigDecimal SUM_build_area = new BigDecimal(0); //建筑面积
        BigDecimal SUM_build_price = new BigDecimal(0);//成交单价
        BigDecimal SUM_sum_money = new BigDecimal(0); //成交金额
        BigDecimal SUM_should_amount = new BigDecimal(0);//应收金额
        BigDecimal SUM_should_amount2 = new BigDecimal(0);//一二手联动应收金额
        BigDecimal SUM_total_should_amount = new BigDecimal(0);//总应收金额
        BigDecimal SUM_payment_amount = new BigDecimal(0); //实收金额
        BigDecimal SUM_amount = new BigDecimal(0);//未收金额
        BigDecimal SUM_relamount = new BigDecimal(0);//关系户佣金金额

        List<Map<String, Object>> listConfirmUnit = confirmServices.commissionReportByUnit(confirmCond);
        List<Map<String, Object>> cusList = MyPropertyUtils.getContractCustomerServices().findContractCustomerByPropertyId(projectid);

        int recordCount = 0;
        if (listConfirmUnit != null) {
            recordCount = listConfirmUnit.size();
        }

        try {

            //循环房间，归类到项目中
            for (int i = 0; i < listConfirmUnit.size(); i++) {

                Map<String, Object> mapobject = listConfirmUnit.get(i);

                String unitId = mapobject.get("unit_id").toString();

                //销售状态
                String sale_state = mapobject.get("sale_state").toString();
                //单元成交或合同总金额
                String sum_money = mapobject.get("sum_money") == null ? "0" : mapobject.get("sum_money").toString();

                //单价（建筑面积）
                String build_price = mapobject.get("build_price") == null ? "0" : mapobject.get("build_price").toString();

                int mainId; //合同客户表中
                String customerName="";
                if (sale_state.equals(ContUnitSaleState.CONFIRM)) {
                    //成交
                    jsonobj.put("status", 0); //颜色状态标识
                    String confirmId = mapobject.get("confirm_id")==null?"":mapobject.get("confirm_id").toString();
                    if(confirmId.length()>0){
                        mainId =  Integer.parseInt(confirmId);

                        customerName = ContractCustomerUtils.getCustomerNameByMainIdAndConfirmType(cusList,mainId, ContConfirmType.CONFIRM);
                    }
                } else {
                    //合同
                    jsonobj.put("status", 1);  //颜色状态标识
                    String contractId = mapobject.get("contract_id")==null?"":mapobject.get("contract_id").toString();
                    if(contractId.length()>0){
                        mainId =  Integer.parseInt(contractId);
                        customerName = ContractCustomerUtils.getCustomerNameByMainIdAndConfirmType(cusList,mainId,ContConfirmType.CONTRACT);
                    }

                }

                BigDecimal commission = BigDecimal.ZERO;  //佣金点
                BigDecimal shouldAmount = BigDecimal.ZERO;  //应收佣金
                BigDecimal secondcommission = BigDecimal.ZERO;  //一二手联动佣金点
                BigDecimal b_sum_money = BigDecimal.ZERO;//成交金额
                //认购日期
                String work_date = mapobject.get("work_date").toString();

                work_date = CommonUtils.getDateString(CommonUtils.getDateFromString(work_date));

                //=======================实收金额
                String payment_amount = "0";
                String commission_time= null ;


                payment_amount = mapobject.get("payment_amount") == null ? payment_amount : mapobject.get("payment_amount").toString();
                commission_time = mapobject.get("commission_time") == null ? commission_time : mapobject.get("commission_time").toString();

                //=======================实收金额 end

                if(!CommonUtils.isStrEmpty(commission_time)) {
                    //佣金日期不为空，读对佣表
                    jsonobj.put("commissionStatus", 0); //颜色状态标识
                    commission = mapobject.get("commission") == null ? BigDecimal.ZERO : CommonUtils.exceptionToZero(mapobject.get("commission").toString());
                    b_sum_money = CommonUtils.exceptionToZero(sum_money).setScale(2, BigDecimal.ROUND_HALF_UP);
                    shouldAmount = mapobject.get("commission_amount") == null ? BigDecimal.ZERO : CommonUtils.exceptionToZero(mapobject.get("commission_amount").toString());
                } else {
                    jsonobj.put("commissionStatus", 1); //颜色状态标识
                    //获取佣金
                    commission = getCommission(commissionList,work_date);
                    //通过佣金计算应收金额
                    b_sum_money = CommonUtils.exceptionToZero(sum_money).setScale(2, BigDecimal.ROUND_HALF_UP);
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
                BigDecimal shouldAmount2 = ((b_sum_money.multiply(secondcommission)).divide(new BigDecimal(100))).setScale(2, BigDecimal.ROUND_HALF_UP);


                //合计应收（一手+一二手联动应收金额 or 一二手联动应收金额+关系户）
                BigDecimal totalShouldAmount = sumShouldAmount(shouldAmount,shouldAmount2,relCommissionAmount);

                BigDecimal b_payment_amount = CommonUtils.exceptionToZero(payment_amount).setScale(2, BigDecimal.ROUND_HALF_UP);
                BigDecimal b_build_price = new BigDecimal(build_price).setScale(0, BigDecimal.ROUND_HALF_UP);

                SUM_build_area = SUM_build_area.add(new BigDecimal(mapobject.get("BUILD_AREA").toString()));
                SUM_build_price = SUM_build_price.add(b_build_price);
                SUM_sum_money = SUM_sum_money.add(b_sum_money);
                SUM_should_amount = SUM_should_amount.add(shouldAmount);
                SUM_should_amount2 = SUM_should_amount2.add(shouldAmount2);
                SUM_total_should_amount = SUM_total_should_amount.add(totalShouldAmount);
                SUM_payment_amount = SUM_payment_amount.add(b_payment_amount);
                SUM_amount = SUM_amount.add(shouldAmount.subtract(b_payment_amount));
                SUM_relamount = SUM_relamount.add(relCommissionAmount);

                jsonobj.put("work_date", work_date);
                jsonobj.put("unit_no", mapobject.get("build_name").toString() + mapobject.get("unit_no").toString());
                jsonobj.put("customer_name", customerName);
                jsonobj.put("build_area", mapobject.get("BUILD_AREA"));
                jsonobj.put("build_price", CommonUtils.moneyString(b_build_price, 0, ""));
                jsonobj.put("sum_price", CommonUtils.moneyString(b_sum_money, 0, ""));
                jsonobj.put("commission", commission.compareTo(BigDecimal.ZERO)==0 ?"-":commission);
                jsonobj.put("secondcommission",  secondcommission.compareTo(BigDecimal.ZERO)==0 ?"-":secondcommission);
                jsonobj.put("should_amount", CommonUtils.moneyString(shouldAmount, 0, ""));
                jsonobj.put("secondshould_amount", CommonUtils.moneyString(shouldAmount2, 0, ""));
                jsonobj.put("total_should_amount", CommonUtils.moneyString(totalShouldAmount, 0, ""));
                jsonobj.put("payment_amount", CommonUtils.moneyString(b_payment_amount, 0, ""));
                jsonobj.put("amount", CommonUtils.moneyString(totalShouldAmount.subtract(b_payment_amount)));
                jsonobj.put("relCommissionAmount", CommonUtils.moneyString(relCommissionAmount));


                jsonArray.add(jsonobj);

            }

            /*合计：*/
            jsonobj = new JSONObject();
            jsonobj.put("build_area", SUM_build_area);
            jsonobj.put("sum_price", CommonUtils.moneyString(SUM_sum_money, 0, ""));

            jsonobj.put("secondshould_amount", CommonUtils.moneyString(SUM_should_amount, 0, ""));
            jsonobj.put("relCommissionAmount", CommonUtils.moneyString(SUM_relamount, 0, ""));
            jsonobj.put("should_amount", CommonUtils.moneyString(SUM_should_amount, 0, ""));
            jsonobj.put("secondshould_amount", CommonUtils.moneyString(SUM_should_amount2, 0, ""));

            jsonobj.put("total_should_amount", CommonUtils.moneyString(SUM_total_should_amount, 0, ""));
            jsonobj.put("payment_amount", CommonUtils.moneyString(SUM_payment_amount, 0, ""));
            jsonobj.put("amount", CommonUtils.moneyString(SUM_amount, 0, ""));
            jsonobj.put("customer_name", "合计:");
            jsonFooterArray.add(jsonobj);

            logger.info("结佣明细表:输出完毕" + DateTimeUtils.getNow());

            Map<String, Object> json = new HashMap<String, Object>();
            json.put("total", recordCount);// total键 存放总记录数，必须的
            json.put("rows", jsonArray);// rows键 存放每页记录 list
            json.put("footer", jsonFooterArray);// footer 存放合计

            unitList = JSONObject.fromObject(json);// 格式化result一定要是JSONObject
            ActionContext.getContext().getValueStack().set("unitList", unitList);
            request.getSession().setAttribute("Down", unitList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return SUCCESS;
    }

    
    /**
     * 单元佣金计算(开发商确认)
     * @return
     * @throws Exception
     */
    @SuppressWarnings({ "rawtypes", "unused", "unchecked" })
	public String commissionUnitAffirm() throws Exception{
    	JSONArray jsonArray = new JSONArray(); //list
        JSONArray jsonFooterArray = new JSONArray(); //footer 合计
        JSONObject jsonobj = new JSONObject();
        JSONObject unitList;

        String projectId = request.getParameter("projectIds");
        String sBuildId = request.getParameter("buildId");
        String sAreaId = request.getParameter("areaId");

        List<Integer> projectIds = new ArrayList<Integer>();
        projectIds.add(Integer.parseInt(projectId));
        int projectid = projectId == null || projectId.length() == 0 ? 0 : Integer.parseInt(projectId);
        int buildId = sBuildId == null || sBuildId.length() == 0 ? 0 : Integer.parseInt(sBuildId);
        int areaId = sAreaId == null || sAreaId.length() == 0 ? 0 : Integer.parseInt(sAreaId);

        confirmCond = new ConfirmCond();
        confirmCond.setProjectIds(projectIds);
        confirmCond.setBuildId(sBuildId);
        confirmCond.setAreaId(sAreaId);


        List<MultManagerCommissionPojo> commissionList= FinancialUtils.getMultCommission(projectid, areaId, buildId, ContContractManager.MAIN_CONTRACT);
        List<MultManagerCommissionPojo> secondcommissionList= FinancialUtils.getMultCommission(projectid, areaId, buildId, ContContractManager.SECOND_LINKAGE);


        //----------end 跳吧判断

        BigDecimal SUM_build_area = new BigDecimal(0); //建筑面积
        BigDecimal SUM_build_price = new BigDecimal(0);//成交单价
        BigDecimal SUM_sum_money = new BigDecimal(0); //成交金额
        BigDecimal SUM_should_amount = new BigDecimal(0);//应收金额
        BigDecimal SUM_should_amount2 = new BigDecimal(0);//一二手联动应收金额
        BigDecimal SUM_total_should_amount = new BigDecimal(0);//总应收金额
        BigDecimal SUM_payment_amount = new BigDecimal(0); //实收金额
        BigDecimal SUM_amount = new BigDecimal(0);//未收金额
        BigDecimal SUM_relamount = new BigDecimal(0);//关系户佣金金额

        List<Map<String, Object>> listConfirmUnit = confirmServices.commissionReportByUnit(confirmCond);
        List<Map<String, Object>> cusList = MyPropertyUtils.getContractCustomerServices().findContractCustomerByPropertyId(projectid);

        int recordCount = 0;
        if (listConfirmUnit != null) {
            recordCount = listConfirmUnit.size();
        }

        try {
        	
    		Map<String, Object> maps = new HashMap<String, Object>();
    		maps.put("propertyProjectId", projectId);
    		maps.put("propertyAreaId", sAreaId);
    		maps.put("propertyBuildId", sBuildId);
    		List<Map> list =  checkfeeServices.findCheckfeeListByCond(maps);
        	
            //循环房间，归类到项目中
            for (int i = 0; i < list.size(); i++) {

                Map<String, Object> mapobject = list.get(i);

                String unitId = mapobject.get("unit_id").toString();

                //销售状态
                String sale_state = mapobject.get("sale_state").toString();
                //单元成交或合同总金额
                String sum_money = mapobject.get("sum_money") == null ? "0" : mapobject.get("sum_money").toString();

                //单价（建筑面积）
                String build_price = mapobject.get("build_price") == null ? "0" : mapobject.get("build_price").toString();

                int mainId; //合同客户表中
                String customerName="";
                if (sale_state.equals(ContUnitSaleState.CONFIRM)) {
                    //成交
                    jsonobj.put("status", 0); //颜色状态标识
                    String confirmId = mapobject.get("confirm_id")==null?"":mapobject.get("confirm_id").toString();
                    if(confirmId.length()>0){
                        mainId =  Integer.parseInt(confirmId);

                        customerName = ContractCustomerUtils.getCustomerNameByMainIdAndConfirmType(cusList,mainId, ContConfirmType.CONFIRM);
                    }
                } else {
                    //合同
                    jsonobj.put("status", 1);  //颜色状态标识
                    String contractId = mapobject.get("contract_id")==null?"":mapobject.get("contract_id").toString();
                    if(contractId.length()>0){
                        mainId =  Integer.parseInt(contractId);
                        customerName = ContractCustomerUtils.getCustomerNameByMainIdAndConfirmType(cusList,mainId,ContConfirmType.CONTRACT);
                    }

                }

                BigDecimal commission = BigDecimal.ZERO;  //佣金点
                BigDecimal shouldAmount = BigDecimal.ZERO;  //应收佣金
                BigDecimal secondcommission = BigDecimal.ZERO;  //一二手联动佣金点
                BigDecimal b_sum_money = BigDecimal.ZERO;//成交金额
                //认购日期
                String work_date = mapobject.get("work_date").toString();

                work_date = CommonUtils.getDateString(CommonUtils.getDateFromString(work_date));

                //=======================实收金额
                String payment_amount = "0";
                String commission_time= null ;


                payment_amount = mapobject.get("payment_amount") == null ? payment_amount : mapobject.get("payment_amount").toString();
                commission_time = mapobject.get("commission_time") == null ? commission_time : mapobject.get("commission_time").toString();

                //=======================实收金额 end

                if(!CommonUtils.isStrEmpty(commission_time)) {
                    //佣金日期不为空，读对佣表
                    jsonobj.put("commissionStatus", 0); //颜色状态标识
                    commission = mapobject.get("commission1") == null ? BigDecimal.ZERO : CommonUtils.exceptionToZero(mapobject.get("commission1").toString());
                    b_sum_money = CommonUtils.exceptionToZero(sum_money).setScale(2, BigDecimal.ROUND_HALF_UP);
                    shouldAmount = mapobject.get("commission_amount1") == null ? BigDecimal.ZERO : CommonUtils.exceptionToZero(mapobject.get("commission_amount1").toString());
                    
                } else {
                    jsonobj.put("commissionStatus", 1); //颜色状态标识
                    //获取佣金
                    commission = getCommission(commissionList,work_date);
                    //通过佣金计算应收金额
                    b_sum_money = CommonUtils.exceptionToZero(sum_money).setScale(2, BigDecimal.ROUND_HALF_UP);
                    shouldAmount = ((b_sum_money.multiply(commission)).divide(new BigDecimal(100))).setScale(2, BigDecimal.ROUND_HALF_UP);
                    if(mapobject.get("commission_amount1")!=null)
                    	shouldAmount = new BigDecimal( mapobject.get("commission_amount1").toString());
                    else
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
                BigDecimal shouldAmount2;
                if(mapobject.get("sec_commission_amount1")!=null){
                	shouldAmount2 = new BigDecimal(mapobject.get("sec_commission_amount1").toString());
                }else{
                shouldAmount2 = ((b_sum_money.multiply(secondcommission)).divide(new BigDecimal(100))).setScale(2, BigDecimal.ROUND_HALF_UP);
                }

                //合计应收（一手+一二手联动应收金额 or 一二手联动应收金额+关系户）
                BigDecimal totalShouldAmount = sumShouldAmount(shouldAmount,shouldAmount2,relCommissionAmount);

                BigDecimal b_payment_amount = CommonUtils.exceptionToZero(payment_amount).setScale(2, BigDecimal.ROUND_HALF_UP);
                BigDecimal b_build_price = new BigDecimal(build_price).setScale(0, BigDecimal.ROUND_HALF_UP);

                SUM_build_area = SUM_build_area.add(new BigDecimal(mapobject.get("BUILD_AREA").toString()));
                SUM_build_price = SUM_build_price.add(b_build_price);
                SUM_sum_money = SUM_sum_money.add(b_sum_money);
                SUM_should_amount = SUM_should_amount.add(shouldAmount);
                SUM_should_amount2 = SUM_should_amount2.add(shouldAmount2);
                SUM_total_should_amount = SUM_total_should_amount.add(totalShouldAmount);
                SUM_payment_amount = SUM_payment_amount.add(b_payment_amount);
                SUM_amount = SUM_amount.add(shouldAmount.subtract(b_payment_amount));
                SUM_relamount = SUM_relamount.add(relCommissionAmount);

                jsonobj.put("work_date", work_date);
                jsonobj.put("unit_no", mapobject.get("property_unit_no").toString());
                jsonobj.put("customer_name", customerName);
                jsonobj.put("build_area", mapobject.get("BUILD_AREA"));
                jsonobj.put("build_price", CommonUtils.moneyString(b_build_price, 0, ""));
                jsonobj.put("sum_price", CommonUtils.moneyString(b_sum_money, 0, ""));
                jsonobj.put("commission", commission.compareTo(BigDecimal.ZERO)==0 ?"-":commission);
                jsonobj.put("secondcommission",  secondcommission.compareTo(BigDecimal.ZERO)==0 ?"-":secondcommission);
                jsonobj.put("should_amount", CommonUtils.moneyString(shouldAmount, 0, ""));
                jsonobj.put("secondshould_amount", CommonUtils.moneyString(shouldAmount2, 0, ""));
                jsonobj.put("total_should_amount", CommonUtils.moneyString(totalShouldAmount, 0, ""));
                jsonobj.put("payment_amount", CommonUtils.moneyString(b_payment_amount, 0, ""));
                jsonobj.put("amount", CommonUtils.moneyString(totalShouldAmount.subtract(b_payment_amount)));
                jsonobj.put("relCommissionAmount", CommonUtils.moneyString(relCommissionAmount));


                jsonArray.add(jsonobj);

            }

            /*合计：*/
            jsonobj = new JSONObject();
            jsonobj.put("build_area", SUM_build_area);
            jsonobj.put("sum_price", CommonUtils.moneyString(SUM_sum_money, 0, ""));

            jsonobj.put("secondshould_amount", CommonUtils.moneyString(SUM_should_amount, 0, ""));
            jsonobj.put("relCommissionAmount", CommonUtils.moneyString(SUM_relamount, 0, ""));
            jsonobj.put("should_amount", CommonUtils.moneyString(SUM_should_amount, 0, ""));
            jsonobj.put("secondshould_amount", CommonUtils.moneyString(SUM_should_amount2, 0, ""));

            jsonobj.put("total_should_amount", CommonUtils.moneyString(SUM_total_should_amount, 0, ""));
            jsonobj.put("payment_amount", CommonUtils.moneyString(SUM_payment_amount, 0, ""));
            jsonobj.put("amount", CommonUtils.moneyString(SUM_amount, 0, ""));
            jsonobj.put("customer_name", "合计:");
            jsonFooterArray.add(jsonobj);

            logger.info("结佣明细表:输出完毕" + DateTimeUtils.getNow());

            Map<String, Object> json = new HashMap<String, Object>();
            json.put("total", recordCount);// total键 存放总记录数，必须的
            json.put("rows", jsonArray);// rows键 存放每页记录 list
            json.put("footer", jsonFooterArray);// footer 存放合计

            unitList = JSONObject.fromObject(json);// 格式化result一定要是JSONObject
            ActionContext.getContext().getValueStack().set("unitList", unitList);
            request.getSession().setAttribute("Down", unitList);
//           HttpRequestUtils.getRequest().getSession().setAttribute("Down", unitList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return SUCCESS;
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
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
    
    /**
     * 下载
     * @return
     * @throws Exception
     */
    public String exportExcel()  throws Exception{
        initSearchDate();
        initListDate();

        Map<String, Object> map = new HashMap<String, Object>();
        String srcFileName = "commission-unit.xls";
        String fileName = "单元结佣表.xls";

        List<Map> list = createDownSrc();

        map.put("CommissionList", list);

        ReportUtils.downLoadReport(map, srcFileName, fileName, response);

        return null;
    }

    private List<Map<String, Object>> getExportList() {
        List<Map<String, Object>> expList = new ArrayList<Map<String,Object>>();
        Map<String, Object> expMap = null;

        JSONArray jsonArray = new JSONArray(); //list
        JSONArray jsonFooterArray = new JSONArray(); //footer 合计
        JSONObject jsonobj = new JSONObject();
        JSONObject unitList;

        String projectId = request.getParameter("projectIds");
        String sBuildId = request.getParameter("buildId");
        String sAreaId = request.getParameter("areaId");

        List<Integer> projectIds = new ArrayList<Integer>();
        projectIds.add(Integer.parseInt(projectId));
        int projectid = projectId == null || projectId.length() == 0 ? 0 : Integer.parseInt(projectId);
        int buildId = sBuildId == null || sBuildId.length() == 0 ? 0 : Integer.parseInt(sBuildId);
        int areaId = sAreaId == null || sAreaId.length() == 0 ? 0 : Integer.parseInt(sAreaId);

        confirmCond = new ConfirmCond();
        confirmCond.setProjectIds(projectIds);
        confirmCond.setBuildId(sBuildId);
        confirmCond.setAreaId(sAreaId);

        
        List<MultManagerCommissionPojo> commissionList= FinancialUtils.getMultCommission(projectid, areaId, buildId, ContContractManager.MAIN_CONTRACT);
        List<MultManagerCommissionPojo> secondcommissionList= FinancialUtils.getMultCommission(projectid, areaId, buildId, ContContractManager.SECOND_LINKAGE);


        //----------end 跳吧判断

        BigDecimal SUM_build_area = new BigDecimal(0); //建筑面积
        BigDecimal SUM_build_price = new BigDecimal(0);//成交单价
        BigDecimal SUM_sum_money = new BigDecimal(0); //成交金额
        BigDecimal SUM_should_amount = new BigDecimal(0);//应收金额
        BigDecimal SUM_should_amount2 = new BigDecimal(0);//一二手联动应收金额
        BigDecimal SUM_total_should_amount = new BigDecimal(0);//总应收金额
        BigDecimal SUM_payment_amount = new BigDecimal(0); //实收金额
        BigDecimal SUM_amount = new BigDecimal(0);//未收金额
        BigDecimal SUM_relamount = new BigDecimal(0);//关系户佣金金额

        List<Map<String, Object>> listConfirmUnit = confirmServices.commissionReportByUnit(confirmCond);
        int recordCount = 0;
        if (listConfirmUnit != null) {
            recordCount = listConfirmUnit.size();
        }

        try {

            //循环房间，归类到项目中
            for (int i = 0; i < listConfirmUnit.size(); i++) {
                expMap = new HashMap<String, Object>();
                Map<String, Object> mapobject = listConfirmUnit.get(i);

                String unitId = mapobject.get("unit_id").toString();

                //销售状态
                String sale_state = mapobject.get("sale_state").toString();
                //单元成交或合同总金额
                String sum_money = mapobject.get("sum_money") == null ? "0" : mapobject.get("sum_money").toString();

                //单价（建筑面积）
                String build_price = mapobject.get("build_price") == null ? "0" : mapobject.get("build_price").toString();

                int mainId; //合同客户表中
                String customerName;
                if (sale_state.equals(ContUnitSaleState.CONFIRM)) {
                    //成交
                    jsonobj.put("status", 0); //颜色状态标识
                    mainId =  Integer.parseInt(mapobject.get("confirm_id").toString());
                    customerName = ContractCustomerUtils.getCustomerNameByMainIdAndConfirmType(mainId, ContConfirmType.CONFIRM);

                } else {
                    //合同
                    jsonobj.put("status", 1);  //颜色状态标识
                    mainId =  Integer.parseInt(mapobject.get("contract_id").toString());
                    customerName = ContractCustomerUtils.getCustomerNameByMainIdAndConfirmType(mainId,ContConfirmType.CONTRACT);

                }

                //认购日期
                String work_date = mapobject.get("work_date").toString();
                work_date = CommonUtils.getDateString(CommonUtils.getDateFromString(work_date));

                BigDecimal commission = BigDecimal.ZERO;  //佣金点
                BigDecimal shouldAmount = BigDecimal.ZERO;  //应收佣金
                BigDecimal secondcommission = BigDecimal.ZERO;  //一二手联动佣金点
                BigDecimal b_sum_money = BigDecimal.ZERO;;//成交金额

                //=======================实收金额
                String payment_amount = "0";
                String commission_time= null ;

                Map<String, Object> mapsum = sumByUnitId(unitId);

                if (mapsum!=null){
                    payment_amount = mapsum.get("payment_amount") == null ? payment_amount : mapsum.get("payment_amount").toString();
                    commission_time = mapsum.get("commission_time") == null ? commission_time : mapsum.get("commission_time").toString();
                }
                //=======================实收金额 end

                if(!CommonUtils.isStrEmpty(commission_time)) {
                    //佣金日期不为空，读对佣表
                    jsonobj.put("commissionStatus", 0); //颜色状态标识
                    commission = mapsum.get("commission") == null ? BigDecimal.ZERO : CommonUtils.exceptionToZero(mapsum.get("commission").toString());
                    b_sum_money = CommonUtils.exceptionToZero(sum_money).setScale(2, BigDecimal.ROUND_HALF_UP);
                    shouldAmount = mapsum.get("commission_amount") == null ? BigDecimal.ZERO : CommonUtils.exceptionToZero(mapsum.get("commission_amount").toString());
                } else {
                    jsonobj.put("commissionStatus", 1); //颜色状态标识
                    //获取佣金
                    commission = getCommission(commissionList,work_date);
                    //通过佣金计算应收金额
                    b_sum_money = CommonUtils.exceptionToZero(sum_money).setScale(2, BigDecimal.ROUND_HALF_UP);
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

                //关系户佣金
                BigDecimal relCommissionAmount = getRelCommission(commissionList,work_date,b_sum_money);

                //通过佣金计算一二手联动应收金额
                BigDecimal shouldAmount2 = ((b_sum_money.multiply(secondcommission)).divide(new BigDecimal(100))).setScale(2, BigDecimal.ROUND_HALF_UP);


                //合计应收（一手+一二手联动应收金额 or 一二手联动应收金额+关系户）
                BigDecimal totalShouldAmount = sumShouldAmount(shouldAmount,shouldAmount2,relCommissionAmount);

                BigDecimal b_payment_amount = CommonUtils.exceptionToZero(payment_amount).setScale(2, BigDecimal.ROUND_HALF_UP);
                BigDecimal b_build_price = new BigDecimal(build_price).setScale(0, BigDecimal.ROUND_HALF_UP);

                SUM_build_area = SUM_build_area.add(new BigDecimal(mapobject.get("BUILD_AREA").toString()));
                SUM_build_price = SUM_build_price.add(b_build_price);
                SUM_sum_money = SUM_sum_money.add(b_sum_money);
                SUM_should_amount = SUM_should_amount.add(shouldAmount);
                SUM_should_amount2 = SUM_should_amount2.add(shouldAmount2);
                SUM_total_should_amount = SUM_total_should_amount.add(totalShouldAmount);
                SUM_payment_amount = SUM_payment_amount.add(b_payment_amount);
                SUM_amount = SUM_amount.add(shouldAmount.subtract(b_payment_amount));
                SUM_relamount = SUM_relamount.add(relCommissionAmount);

                expMap.put("work_date", work_date);
                expMap.put("unit_no", mapobject.get("build_name").toString() + mapobject.get("unit_no").toString());
                expMap.put("customer_name", customerName);
                expMap.put("build_area", mapobject.get("BUILD_AREA"));
                expMap.put("build_price", CommonUtils.moneyString(b_build_price, 0, ""));
                expMap.put("sum_price", CommonUtils.moneyString(b_sum_money, 0, ""));
                expMap.put("commission", commission);
                expMap.put("secondcommission", CommonUtils.moneyString(secondcommission, 0, ""));
                expMap.put("should_amount", CommonUtils.moneyString(shouldAmount, 0, ""));
                expMap.put("secondshould_amount", CommonUtils.moneyString(shouldAmount2, 0, ""));
                expMap.put("total_should_amount", CommonUtils.moneyString(totalShouldAmount, 0, ""));
                expMap.put("payment_amount", CommonUtils.moneyString(b_payment_amount, 0, ""));
                expMap.put("amount", CommonUtils.moneyString(totalShouldAmount.subtract(b_payment_amount)));
                expMap.put("relCommissionAmount", CommonUtils.moneyString(relCommissionAmount));

                expList.add(expMap);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return expList;
    }



}
