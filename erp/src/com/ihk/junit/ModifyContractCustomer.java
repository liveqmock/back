package com.ihk.junit;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.ihk.constanttype.ContConfirmType;
import com.ihk.constanttype.ContContractManager;
import com.ihk.constanttype.ContUnitSaleState;
import com.ihk.property.data.services.ICheckcommissionServices;
import com.ihk.property.data.services.ICheckfeeServices;
import com.ihk.saleunit.action.new_report.CommissionAction;
import com.ihk.saleunit.data.pojo.ConfirmCond;
import com.ihk.saleunit.data.services.IConfirmServices;
import com.ihk.saleunit.data.services.IContractCustomerServices;
import com.ihk.saleunit.data.services.IContractServices;
import com.ihk.saleunit.data.services.IOtherExpensesServices;
import com.ihk.saleunit.data.services.IQuestionServices;
import com.ihk.saleunit.data.services.IQuestionTopicServices;
import com.ihk.saleunit.data.services.ISaleDefaultQuestionServices;
import com.ihk.saleunit.data.services.impl.OtherExpensesServices;
import com.ihk.setting.data.services.IProjectCodeServices;
import com.ihk.user.data.pojo.UserAccount;
import com.ihk.user.data.pojo.UserAccountCond;
import com.ihk.user.data.services.IUserAccountServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.ReportUtils;
import com.ihk.utils.contract.customer.ContractCustomerUtils;
import com.ihk.utils.financial.FinancialUtils;
import com.ihk.utils.financial.MultManagerCommissionPojo;
import com.ihk.utils.saleunit.MyPropertyUtils;

/**
 * 有关成交客户的
 * 
 * @author dtc 2013-5-23,下午08:19:23
 */
@SuppressWarnings({ "rawtypes", "unused", "unchecked" })
public class ModifyContractCustomer extends CommissionAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6023534515080820010L;


	private static FileSystemXmlApplicationContext factory;

	
	private static IContractCustomerServices contractCustomerServices;
	private static IContractServices contractServices;
	private static IConfirmServices confirmServices;
	private static ISaleDefaultQuestionServices saleDefaultQuestionServices;
	private static IQuestionServices questionServices;
	private static IQuestionTopicServices questionTopicServices;
	private static IProjectCodeServices projectCodeServices;
	private static IOtherExpensesServices expensesServices;

	private static ICheckcommissionServices checkcommissionServices;

	private static ICheckfeeServices checkfeeServices;

	private static OtherExpensesServices otherExpensesServices;
	
	private static IUserAccountServices accountServices;

	@BeforeClass
	public static void init() {

		factory = new FileSystemXmlApplicationContext(
				"src/Junit-applicationContext.xml");

		contractCustomerServices = (IContractCustomerServices) factory
				.getBean("contractCustomerServices");

		contractServices = (IContractServices) factory
				.getBean("contractServices");

		confirmServices = (IConfirmServices) factory.getBean("confirmServices");

		saleDefaultQuestionServices = (ISaleDefaultQuestionServices) factory
				.getBean("saleDefaultQuestionServices");

		questionTopicServices = (IQuestionTopicServices) factory
				.getBean("questionTopicServices");

		questionServices = (IQuestionServices) factory
				.getBean("questionServices");

		projectCodeServices = (IProjectCodeServices) factory
				.getBean("projectCodeServices");

		expensesServices = (IOtherExpensesServices) factory
				.getBean("otherExpensesServices");

		checkcommissionServices = (ICheckcommissionServices) factory
				.getBean("checkcommissionServices");

		checkfeeServices = (ICheckfeeServices) factory
				.getBean("checkfeeServices");

		otherExpensesServices = (OtherExpensesServices) factory
				.getBean("otherExpensesServices");
		
		
		accountServices = (IUserAccountServices) factory.getBean("userAccountServices");
	}

	private List<String> string2str(String projectIds) {
		String[] strProjectIds = projectIds.split(",");
		String[] iProjectIds = new String[strProjectIds.length];
		for (int i = 0; i < strProjectIds.length; i++) {
			iProjectIds[i] = strProjectIds[i];
		}

		return Arrays.asList(iProjectIds);
	}
	@Test
public void t(){
		UserAccountCond cond = new UserAccountCond();
		cond.setCompanyProjectIds(Arrays.asList(413, 272));
		cond.setIsDeleted(-1);
		cond.setRoleId("11");
		List<UserAccount> accounts =  accountServices.findUserAccount(cond);
	
		for (UserAccount userAccount : accounts) {
			System.out.println(userAccount.getId());
		}
	
}
	//@Test

	public void commissionUnitAffirm() throws Exception {
		JSONArray jsonArray = new JSONArray(); // list
		JSONArray jsonFooterArray = new JSONArray(); // footer 合计
		JSONObject jsonobj = new JSONObject();
		JSONObject unitList;

		String projectId = "313";
		String sBuildId = null;
		String sAreaId = null;

		List<Integer> projectIds = new ArrayList<Integer>();
		projectIds.add(Integer.parseInt(projectId));
		int projectid = projectId == null || projectId.length() == 0 ? 0
				: Integer.parseInt(projectId);
		int buildId = sBuildId == null || sBuildId.length() == 0 ? 0 : Integer
				.parseInt(sBuildId);
		int areaId = sAreaId == null || sAreaId.length() == 0 ? 0 : Integer
				.parseInt(sAreaId);

		confirmCond = new ConfirmCond();
		confirmCond.setProjectIds(projectIds);
		confirmCond.setBuildId(sBuildId);
		confirmCond.setAreaId(sAreaId);

		List<MultManagerCommissionPojo> commissionList = FinancialUtils
				.getMultCommission(projectid, areaId, buildId,
						ContContractManager.MAIN_CONTRACT);
		List<MultManagerCommissionPojo> secondcommissionList = FinancialUtils
				.getMultCommission(projectid, areaId, buildId,
						ContContractManager.SECOND_LINKAGE);

		// ----------end 跳吧判断

		BigDecimal SUM_build_area = new BigDecimal(0); // 建筑面积
		BigDecimal SUM_build_price = new BigDecimal(0);// 成交单价
		BigDecimal SUM_sum_money = new BigDecimal(0); // 成交金额
		BigDecimal SUM_should_amount = new BigDecimal(0);// 应收金额
		BigDecimal SUM_should_amount2 = new BigDecimal(0);// 一二手联动应收金额
		BigDecimal SUM_total_should_amount = new BigDecimal(0);// 总应收金额
		BigDecimal SUM_payment_amount = new BigDecimal(0); // 实收金额
		BigDecimal SUM_amount = new BigDecimal(0);// 未收金额
		BigDecimal SUM_relamount = new BigDecimal(0);// 关系户佣金金额

		List<Map<String, Object>> listConfirmUnit = confirmServices
				.commissionReportByUnit(confirmCond);
		List<Map<String, Object>> cusList = MyPropertyUtils
				.getContractCustomerServices()
				.findContractCustomerByPropertyId(projectid);

		int recordCount = 0;
		if (listConfirmUnit != null) {
			recordCount = listConfirmUnit.size();
		}

		try {

			Map<String, Object> maps = new HashMap<String, Object>();
			maps.put("propertyProjectId", projectId);
			maps.put("propertyAreaId", sAreaId);
			maps.put("propertyBuildId", sBuildId);
			List<Map> list = checkfeeServices.findCheckfeeListByCond(maps);

			// 循环房间，归类到项目中
			for (int i = 0; i < list.size(); i++) {

				Map<String, Object> mapobject = list.get(i);

				String unitId = mapobject.get("unit_id").toString();

				// 销售状态
				String sale_state = mapobject.get("sale_state").toString();
				// 单元成交或合同总金额
				String sum_money = mapobject.get("sum_money") == null ? "0"
						: mapobject.get("sum_money").toString();

				// 单价（建筑面积）
				String build_price = mapobject.get("build_price") == null ? "0"
						: mapobject.get("build_price").toString();

				int mainId; // 合同客户表中
				String customerName = "";
				if (sale_state.equals(ContUnitSaleState.CONFIRM)) {
					// 成交
					jsonobj.put("status", 0); // 颜色状态标识
					String confirmId = mapobject.get("confirm_id") == null ? ""
							: mapobject.get("confirm_id").toString();
					if (confirmId.length() > 0) {
						mainId = Integer.parseInt(confirmId);

						customerName = ContractCustomerUtils
								.getCustomerNameByMainIdAndConfirmType(cusList,
										mainId, ContConfirmType.CONFIRM);
					}
				} else {
					// 合同
					jsonobj.put("status", 1); // 颜色状态标识
					String contractId = mapobject.get("contract_id") == null ? ""
							: mapobject.get("contract_id").toString();
					if (contractId.length() > 0) {
						mainId = Integer.parseInt(contractId);
						customerName = ContractCustomerUtils
								.getCustomerNameByMainIdAndConfirmType(cusList,
										mainId, ContConfirmType.CONTRACT);
					}

				}

				BigDecimal commission = BigDecimal.ZERO; // 佣金点
				BigDecimal shouldAmount = BigDecimal.ZERO; // 应收佣金
				BigDecimal secondcommission = BigDecimal.ZERO; // 一二手联动佣金点
				BigDecimal b_sum_money = BigDecimal.ZERO;// 成交金额
				// 认购日期
				String work_date = mapobject.get("work_date").toString();

				work_date = CommonUtils.getDateString(CommonUtils
						.getDateFromString(work_date));

				// =======================实收金额
				String payment_amount = "0";
				String commission_time = null;

				payment_amount = mapobject.get("payment_amount") == null ? payment_amount
						: mapobject.get("payment_amount").toString();
				commission_time = mapobject.get("commission_time") == null ? commission_time
						: mapobject.get("commission_time").toString();

				// =======================实收金额 end

				if (!CommonUtils.isStrEmpty(commission_time)) {
					// 佣金日期不为空，读对佣表
					jsonobj.put("commissionStatus", 0); // 颜色状态标识
					commission = mapobject.get("commission") == null ? BigDecimal.ZERO
							: CommonUtils.exceptionToZero(mapobject.get(
									"commission").toString());
					b_sum_money = CommonUtils.exceptionToZero(sum_money)
							.setScale(2, BigDecimal.ROUND_HALF_UP);
					shouldAmount = mapobject.get("commission_amount") == null ? BigDecimal.ZERO
							: CommonUtils.exceptionToZero(mapobject.get(
									"commission_amount").toString());

				} else {
					jsonobj.put("commissionStatus", 1); // 颜色状态标识
					// 获取佣金
					commission = getCommission(commissionList, work_date);
					// 通过佣金计算应收金额
					b_sum_money = CommonUtils.exceptionToZero(sum_money)
							.setScale(2, BigDecimal.ROUND_HALF_UP);
					shouldAmount = ((b_sum_money.multiply(commission))
							.divide(new BigDecimal(100))).setScale(2,
							BigDecimal.ROUND_HALF_UP);

				}

				// -------------------------一二手联动判断 start
				boolean isSecondLinkage = isSecondLinkage(mapobject);

				if (isSecondLinkage) {
					secondcommission = getCommission(secondcommissionList,
							work_date);
				} else {
					secondcommission = new BigDecimal(BigInteger.ZERO);
				}
				// -------------------------一二手联动判断 end
				// 关系户判断

				boolean isRelation = isRelation(mapobject);
				// 关系户佣金
				BigDecimal relCommissionAmount = getRelCommission(
						commissionList, work_date, b_sum_money);

				if (!isRelation) {
					relCommissionAmount = BigDecimal.ZERO;
				} else {
					commission = BigDecimal.ZERO;
					shouldAmount = BigDecimal.ZERO;
				}

				// 通过佣金计算一二手联动应收金额
				BigDecimal shouldAmount2 = ((b_sum_money
						.multiply(secondcommission))
						.divide(new BigDecimal(100))).setScale(2,
						BigDecimal.ROUND_HALF_UP);

				// 合计应收（一手+一二手联动应收金额 or 一二手联动应收金额+关系户）
				BigDecimal totalShouldAmount = sumShouldAmount(shouldAmount,
						shouldAmount2, relCommissionAmount);

				BigDecimal b_payment_amount = CommonUtils.exceptionToZero(
						payment_amount).setScale(2, BigDecimal.ROUND_HALF_UP);
				BigDecimal b_build_price = new BigDecimal(build_price)
						.setScale(0, BigDecimal.ROUND_HALF_UP);

				SUM_build_area = SUM_build_area.add(new BigDecimal(mapobject
						.get("BUILD_AREA").toString()));
				SUM_build_price = SUM_build_price.add(b_build_price);
				SUM_sum_money = SUM_sum_money.add(b_sum_money);
				SUM_should_amount = SUM_should_amount.add(shouldAmount);
				SUM_should_amount2 = SUM_should_amount2.add(shouldAmount2);
				SUM_total_should_amount = SUM_total_should_amount
						.add(totalShouldAmount);
				SUM_payment_amount = SUM_payment_amount.add(b_payment_amount);
				SUM_amount = SUM_amount.add(shouldAmount
						.subtract(b_payment_amount));
				SUM_relamount = SUM_relamount.add(relCommissionAmount);

				jsonobj.put("work_date", work_date);
				jsonobj.put("unit_no", mapobject.get("property_unit_no")
						.toString());
				jsonobj.put("customer_name", customerName);
				jsonobj.put("build_area", mapobject.get("BUILD_AREA"));
				jsonobj.put("build_price",
						CommonUtils.moneyString(b_build_price, 0, ""));
				jsonobj.put("sum_price",
						CommonUtils.moneyString(b_sum_money, 0, ""));
				jsonobj.put("commission",
						commission.compareTo(BigDecimal.ZERO) == 0 ? "-"
								: commission);
				jsonobj.put("secondcommission", secondcommission
						.compareTo(BigDecimal.ZERO) == 0 ? "-"
						: secondcommission);
				jsonobj.put("should_amount",
						CommonUtils.moneyString(shouldAmount, 0, ""));
				jsonobj.put("secondshould_amount",
						CommonUtils.moneyString(shouldAmount2, 0, ""));
				jsonobj.put("total_should_amount",
						CommonUtils.moneyString(totalShouldAmount, 0, ""));
				jsonobj.put("payment_amount",
						CommonUtils.moneyString(b_payment_amount, 0, ""));
				jsonobj.put("amount", CommonUtils.moneyString(totalShouldAmount
						.subtract(b_payment_amount)));
				jsonobj.put("relCommissionAmount",
						CommonUtils.moneyString(relCommissionAmount));

				jsonArray.add(jsonobj);

			}

			/* 合计： */
			jsonobj = new JSONObject();
			jsonobj.put("build_area", SUM_build_area);
			jsonobj.put("sum_price",
					CommonUtils.moneyString(SUM_sum_money, 0, ""));

			jsonobj.put("secondshould_amount",
					CommonUtils.moneyString(SUM_should_amount, 0, ""));
			jsonobj.put("relCommissionAmount",
					CommonUtils.moneyString(SUM_relamount, 0, ""));
			jsonobj.put("should_amount",
					CommonUtils.moneyString(SUM_should_amount, 0, ""));
			jsonobj.put("secondshould_amount",
					CommonUtils.moneyString(SUM_should_amount2, 0, ""));

			jsonobj.put("total_should_amount",
					CommonUtils.moneyString(SUM_total_should_amount, 0, ""));
			jsonobj.put("payment_amount",
					CommonUtils.moneyString(SUM_payment_amount, 0, ""));
			jsonobj.put("amount", CommonUtils.moneyString(SUM_amount, 0, ""));
			jsonobj.put("customer_name", "合计:");
			jsonFooterArray.add(jsonobj);

			Map<String, Object> json = new HashMap<String, Object>();
			json.put("total", recordCount);// total键 存放总记录数，必须的
			json.put("rows", jsonArray);// rows键 存放每页记录 list
			json.put("footer", jsonFooterArray);// footer 存放合计

			unitList = JSONObject.fromObject(json);// 格式化result一定要是JSONObject

			createDownSrc(unitList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return;
	}

	public void createDownSrc(JSONObject src) {
		List<Map> down = new ArrayList<Map>();
		JSONArray rows = (JSONArray) src.get("rows");
		for (int i = 0; i < rows.size(); i++) {
			Map t = new HashMap();
			JSONObject j = (JSONObject) rows.get(i);
//			System.out.println(j.get("work_date"));
			t.put("work_date", j.get("work_date"));
		}
		Map<String, Object> map = new HashMap<String, Object>();
        String srcFileName = "commission-unit.xls";
        String fileName = "单元结佣表.xls";


        map.put("CommissionList", down);

        try {
			ReportUtils.downLoadReport(map, srcFileName, fileName, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}