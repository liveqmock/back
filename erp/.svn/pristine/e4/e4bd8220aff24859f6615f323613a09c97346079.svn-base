package com.ihk.utils.financial;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ihk.constanttype.ContContractManager;
import com.ihk.constanttype.ContUnitSaleState;
import com.ihk.constanttype.EnumRoundingType;
import com.ihk.constanttype.EnumUnitPayBillFormula;
import com.ihk.property.data.pojo.ContractBarrules;
import com.ihk.property.data.pojo.ContractManager;
import com.ihk.property.data.pojo.ContractManagerCond;
import com.ihk.property.data.pojo.MyPayWay;
import com.ihk.property.data.pojo.PayWayDetail;
import com.ihk.property.data.pojo.PropertyBuild;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.pojo.UnitPayBill;
import com.ihk.property.data.services.IContractBarrulesServices;
import com.ihk.property.data.services.IContractManagerServices;
import com.ihk.property.data.services.IUnitPayBillServices;
import com.ihk.saleunit.data.pojo.Confirm;
import com.ihk.saleunit.data.pojo.ConfirmCond;
import com.ihk.saleunit.data.pojo.Contract;
import com.ihk.saleunit.data.services.IReceiptDetailServices;
import com.ihk.saleunit.data.services.ISaleUnitReceiptServices;
import com.ihk.utils.CommonPojoUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.exception.UnitPayBillException;
import com.ihk.utils.saleunit.MyPropertyUtils;

/**
 * 财务管理的帮助类
 * @author dtc
 * 2012-8-1
 */
public class FinancialUtils {
	
	/**
	 * HOUSING_LOAN, 房款
	 */
	public static final String HOUSING_LOAN = "房款";
	
	/**
	 * DEPOSIT, 定金
	 */
	public static final String DEPOSIT = "定金";
	
	/**
	 * FIRST_INSTALLMENT, 首期
	 */
	public static final String FIRST_INSTALLMENT = "首期";
	
	/**
	 * MORTGAGE, 按揭
	 */
	public static final String MORTGAGE = "按揭";

    private static IReceiptDetailServices receiptDetailServices;
    
    private static IContractManagerServices contractManagerServices;
    
    private static IContractBarrulesServices contractBarrulesServices;
    
    private static IUnitPayBillServices unitPayBillServices;
    
    private static ISaleUnitReceiptServices saleUnitReceiptServices;
    
    public void setSaleUnitReceiptServices(
			ISaleUnitReceiptServices saleUnitReceiptServices) {
		FinancialUtils.saleUnitReceiptServices = saleUnitReceiptServices;
	}
    
    public static ISaleUnitReceiptServices getSaleUnitReceiptServices() {
		return saleUnitReceiptServices;
	}
    
    public void setUnitPayBillServices(
			IUnitPayBillServices unitPayBillServices) {
		FinancialUtils.unitPayBillServices = unitPayBillServices;
	}
    
    public static IUnitPayBillServices getUnitPayBillServices() {
		return unitPayBillServices;
	}
    
    public void setContractBarrulesServices(
    		IContractBarrulesServices contractBarrulesServices) {
		FinancialUtils.contractBarrulesServices = contractBarrulesServices;
	}
    
    public static IContractBarrulesServices getContractBarrulesServices() {
		return contractBarrulesServices;
	}
    
    public void setContractManagerServices(
			IContractManagerServices contractManagerServices) {
		FinancialUtils.contractManagerServices = contractManagerServices;
	}
    
    public static IContractManagerServices getContractManagerServices() {
		return contractManagerServices;
	}

    public void setReceiptDetailServices(
            IReceiptDetailServices receiptDetailServices) {
        FinancialUtils.receiptDetailServices = receiptDetailServices;
    }

    public static IReceiptDetailServices getReceiptDetailServices() {
        return receiptDetailServices;
    }


    /**
     * 增加成交单元应付款单
     * @param confirm
     * @throws Exception
     */
    public static void addUnitPayBillByPayWayIdAndUnitId(Confirm confirm) throws Exception{

        addUnitPayBillByPayWayIdAndUnitId(confirm.getPayWayId(), confirm.getUnitId(), confirm.getSumMoney(), confirm.getWorkDate());
    }
    
    /**
     * 增加合同单元应付款单
     * @param contract
     * @throws Exception
     */
    public static void addUnitPayBillByPayWayIdAndUnitId(Contract contract) throws Exception{

        addUnitPayBillByPayWayIdAndUnitId(contract.getPayWayId(), contract.getUnitId(), contract.getSumMoney(), contract.getWorkDate());
    }


    /**
     * 增加单元应付款单,要先判断该单元是否已经有对应的应付款单,比如新建合同的时候
     * 应付款的设定应该是detail 的一套详细算法
     * @param payWayId
     * @param unitId
     * @param sumMoney 成交总价sumMoney
     * @param workDate
     * @throws Exception
     */
    public static void addUnitPayBillByPayWayIdAndUnitId(int payWayId, int unitId, BigDecimal sumMoney, Date workDate) throws Exception{

        if(payWayId <= 0)
            return ;

        //判断该单元是否已经有了应付款单,且是否已经有了实收,如果两者都存在就不修改
        List<UnitPayBill> billList = MyPropertyUtils.getUnitPayBillServices().findUnitPayBillByUnitId(unitId);
        if(!CommonUtils.isCollectionEmpty(billList) && isUnitPayBillListHaveReceipt(billList))
            return ;

        try{
        	
        	//下面的代码为根据付款方式明细增加对应的应收
            List<PayWayDetail> detailList = MyPropertyUtils.getPayWayDetailServices().findPayWayDetailByWayId(payWayId);
            
            //根据付款方式明细增加对应的应收
            addBillByDetailList(detailList, unitId, sumMoney, workDate);

        }catch (Exception e) {

            throw new UnitPayBillException();
        }
    }
    
    /**
     * 使用公式及单元id改变对应的应收
     * @param myPayWay
     * @throws Exception
     */
    public static void addUnitPayBillFormulaByMyPayWayAndId(MyPayWay myPayWay) throws Exception{
    	
		int unitId = myPayWay.getUnitId();
		PropertyUnit unit = MyPropertyUtils.getPropertyUnitServices().findPropertyUnitById(unitId);
		String saleState = unit.getSaleState();
		
		if(!ContUnitSaleState.CONFIRM.equals(saleState) && !ContUnitSaleState.CONTRACT.equals(saleState)){

			//状态不正确
			throw new Exception("该单元状态不能生成应收");
		}
		
		BigDecimal sumMoney = null;
		Date workDate = null;
		
		if(ContUnitSaleState.CONFIRM.equals(unit.getSaleState())){
			//成交
			
			Confirm confirm = MyPropertyUtils.getConfirmServices().findConfirmByUnitId(unitId);
			sumMoney = confirm.getSumMoney();
			workDate = confirm.getWorkDate();
			
			MyPropertyUtils.getConfirmServices().updateConfirmPayWayId(confirm.getId(), myPayWay.getPayWayId());
			
		}else if(ContUnitSaleState.CONTRACT.equals(unit.getSaleState())){
			//合同
			
			Contract contract = MyPropertyUtils.getContractServices().findContractByUnitId(unitId);
			sumMoney = contract.getSumMoney();
			workDate = contract.getSignDate();
			
			MyPropertyUtils.getContractServices().updateContractPayWayId(contract.getId(), myPayWay.getPayWayId());
		}
		
		int payWayId = myPayWay.getPayWayId(); //付款方式
    	int formula = myPayWay.getFormula(); //设置方式
    	
		//要先判断付款方式对应的付款明细中的fee_type是否包含按揭
		List<PayWayDetail> detailList = MyPropertyUtils.getPayWayDetailServices().findPayWayDetailByWayId(payWayId);
		if(CommonUtils.isCollectionEmpty(detailList)){
			throw new Exception("该付款方式没有对应的付款明细");
		}
		
		if(formula == 0){
			//没有选择设置方式
			addBillByDetailList(detailList, unitId, sumMoney, workDate);
			return ;
		}
		
		EnumUnitPayBillFormula enumFormula = EnumUnitPayBillFormula.getEnumByValue(formula);
		
		switch (enumFormula) {
			case Fixed_Proportion:{
				//固定比例
				int mortgage = myPayWay.getProportion();//按揭比例
				int firstInstallment = 100 - mortgage; //首期比例
				
				List<PayWayDetail> fixedProList = new ArrayList<PayWayDetail>();
				
				for(PayWayDetail detail : detailList){
					
					String feeType = detail.getFeeType();
					if(FinancialUtils.MORTGAGE.equals(feeType)){
						//按揭
						detail.setPayPercent(new BigDecimal(mortgage));
						detail.setPayMoney(new BigDecimal(0));
						
					}else if(FinancialUtils.FIRST_INSTALLMENT.equals(feeType)){
						//首期
						detail.setPayPercent(new BigDecimal(firstInstallment));
						detail.setPayMoney(new BigDecimal(0));
						
					}
					
					fixedProList.add(detail);
					
				}
				
	            //根据付款方式明细增加对应的应收
	            addBillByDetailList(fixedProList, unitId, sumMoney, workDate);
				
				break;
			}
			case Own_Proportion:{
				//自定义比例
				BigDecimal mortgage = myPayWay.getMortgage();//按揭比例
				BigDecimal firstInstallment = myPayWay.getFirstInstallment(); //首期比例
				
				List<PayWayDetail> ownProList = new ArrayList<PayWayDetail>();
				
				for(PayWayDetail detail : detailList){
					
					String feeType = detail.getFeeType();
					if(FinancialUtils.MORTGAGE.equals(feeType)){
						//按揭
						detail.setPayPercent(mortgage);
						detail.setPayMoney(new BigDecimal(0));
						
					}else if(FinancialUtils.FIRST_INSTALLMENT.equals(feeType)){
						//首期
						detail.setPayPercent(firstInstallment);
						detail.setPayMoney(new BigDecimal(0));
						
					}
					
					ownProList.add(detail);
					
				}
				
	            //根据付款方式明细增加对应的应收
	            addBillByDetailList(ownProList, unitId, sumMoney, workDate);
				
				break;
			}
			case Own_Money:{
				//自定义金额
				BigDecimal mortgageMoney = myPayWay.getMortgageMoney();//按揭金额
				BigDecimal firstInstallmentMoney = myPayWay.getFirstInstallmentMoney(); //首期金额
				
	        	//根据付款方式明细增加对应的应收(自定义金额)
	        	addBillByDetailListForOwnMoney(detailList, unitId, workDate, mortgageMoney, firstInstallmentMoney);
	        	
				break;
			}
			default:
				throw new Exception("设置方式 ");
		}
		
    }
    
    /**
     * 根据单元id判断是否已经有实收
     * @param unitId
     * @return
     */
    public static boolean isUnitPayBillListHaveReceiptByUnitId(int unitId){
    	
    	return isUnitPayBillListHaveReceipt(unitPayBillServices.findUnitPayBillByUnitId(unitId));
    }
    
    /**
     * 判断对应的应收是否已经有实收
     * @param billList
     * @return
     */
    public static boolean isUnitPayBillListHaveReceipt(List<UnitPayBill> billList){
    	
    	if(CommonUtils.isCollectionEmpty(billList)){
    		return false;
    	}
    	
    	boolean isHave = false;
    	
    	for(UnitPayBill bill : billList){
    		
    		if(!CommonUtils.isCollectionEmpty(saleUnitReceiptServices.findReceiptListByBillId(bill.getId()))){
    			
    			isHave = true;
    			break;
    		}
    	}
    	
    	return isHave;
    }
    
    /**
     * 根据付款方式明细增加对应的应收(自定义金额)
     * @param detailList
     * @param unitId
     * @param workDate
     * @param mortgageMoney
     * @param firstInstallmentMoney
     * @throws Exception
     */
    private static void addBillByDetailListForOwnMoney(List<PayWayDetail> detailList, int unitId, Date workDate,
    		BigDecimal mortgageMoney, BigDecimal firstInstallmentMoney) throws Exception{
    	
    	//先删除该单元原先旧的应收
    	MyPropertyUtils.getUnitPayBillServices().deleteUnitPayBillByUnitId(unitId);
    	
    	for(PayWayDetail detail : detailList){

            UnitPayBill bill = new UnitPayBill();

            //单元id,付款明细id
            bill.setUnitId(unitId);
            bill.setWayDetailId(detail.getId());
            
            //应收,已收,未收(根据公式)
            BigDecimal shouldAndNotPay = getUnitPayBillShouldAndNotPayForOwnMoney(detailList, detail, mortgageMoney, firstInstallmentMoney);
            bill.setShouldPay(shouldAndNotPay);
            bill.setHadPay(new BigDecimal(0));
            bill.setNotPay(shouldAndNotPay);
			
            //类别,内容
            bill.setTypeName(detail.getTypeName());
            bill.setFeeType(detail.getFeeType());

            //废弃期数,应收日期,备注
            bill.setPayPercent(detail.getPayPercent());
            bill.setPayDate(getPayDate(detail, workDate));
            bill.setRemark(detail.getRemark());

            CommonPojoUtils.initPojoCommonFiled(bill);

            MyPropertyUtils.getUnitPayBillServices().addUnitPayBill(bill);
        }
    	
    }
    
	/**
     * 根据付款方式明细增加对应的应收
     * @param detailList
     * @param unitId
     * @param sumMoney
     * @param workDate
     * @throws Exception
     */
    private static void addBillByDetailList(List<PayWayDetail> detailList, int unitId, BigDecimal sumMoney, Date workDate) throws Exception{
    	
    	//先删除该单元原先旧的应收
    	MyPropertyUtils.getUnitPayBillServices().deleteUnitPayBillByUnitId(unitId);
    	
    	for(PayWayDetail detail : detailList){

            UnitPayBill bill = new UnitPayBill();

            //单元id,付款明细id
            bill.setUnitId(unitId);
            bill.setWayDetailId(detail.getId());
            
            //应收,已收,未收(根据公式)
            BigDecimal shouldAndNotPay = getUnitPayBillShouldAndNotPay(detailList, detail, sumMoney);
            bill.setShouldPay(shouldAndNotPay);
            bill.setHadPay(new BigDecimal(0));
            bill.setNotPay(shouldAndNotPay);
			
            //类别,内容
            bill.setTypeName(detail.getTypeName());
            bill.setFeeType(detail.getFeeType());

            //废弃期数,应收日期,备注
            bill.setPayPercent(detail.getPayPercent());
            bill.setPayDate(getPayDate(detail, workDate));
            bill.setRemark(detail.getRemark());

            CommonPojoUtils.initPojoCommonFiled(bill);

            MyPropertyUtils.getUnitPayBillServices().addUnitPayBill(bill);
        }
    	
    }
    
    /**
     * 根据付款方式明细获取单元应收款的应收及未收(两者相等),在自定义金额下
     * @param detailList
     * @param detail
     * @param mortgageMoney
     * @param firstInstallmentMoney
     * @return
     */
    private static BigDecimal getUnitPayBillShouldAndNotPayForOwnMoney(
			List<PayWayDetail> detailList, PayWayDetail detail,
			BigDecimal mortgageMoney, BigDecimal firstInstallmentMoney) {
    	
    	BigDecimal retVal = new BigDecimal(0);
    	
    	String typeName = detail.getTypeName(); //收款类别:房款
    	String feeType = detail.getFeeType(); //收款内容:定金,首期,按揭,...尾款
    	
    	if(HOUSING_LOAN.equals(typeName)){
    		
    		if(DEPOSIT.equals(feeType)){
    			//定金,一般为固定金额
    			
    			retVal = detail.getPayMoney();
    		}else if(FIRST_INSTALLMENT.equals(feeType)){
    			//首期 = 固定首期,如果不包含定金,就要减去定金
    			
    			retVal = firstInstallmentMoney;
    			if(CommonUtils.TRUE_STR.equals(detail.getIsInclude())){
    				//包含定金
    				retVal = retVal.subtract(getDepoistMoney(detailList));
    			}
    		}else if(MORTGAGE.equals(feeType)){
    			//按揭 = 成交总价 - (成交总价 * 按揭比例)取整
    			retVal = mortgageMoney;
    		}    		
    	}
    	
    	return retVal;
    	
	}
    
    /**
     * 根据付款方式明细获取单元应收款的应收及未收(两者相等)
     * @param detailList
     * @param detail
     * @param sumMoney
     * @return
     */
    private static BigDecimal getUnitPayBillShouldAndNotPay(List<PayWayDetail> detailList, PayWayDetail detail, BigDecimal sumMoney){
    	
    	BigDecimal retVal = new BigDecimal(0);
    	
    	String typeName = detail.getTypeName(); //收款类别:房款
    	String feeType = detail.getFeeType(); //收款内容:定金,首期,按揭,...尾款
    	
    	if(HOUSING_LOAN.equals(typeName)){
    		
    		if(DEPOSIT.equals(feeType)){
    			//定金,一般为固定金额
    			
    			retVal = detail.getPayMoney();
    		}else if(FIRST_INSTALLMENT.equals(feeType)){
    			//首期 = (成交总价  * 首期比例) - 定金(isInclude为1就减,为0或null就不减) + B
    			
    			retVal = getPayWayDetailMoneyMulPer(sumMoney, detail.getPayPercent()); //(成交总价  * 首期比例)
    			if(CommonUtils.TRUE_STR.equals(detail.getIsInclude())){
    				//包含定金
    				retVal = retVal.subtract(getDepoistMoney(detailList));
    			}
    			
    			retVal = retVal.add(getMortgageRoundingMoney(detailList, sumMoney));
    		}else if(MORTGAGE.equals(feeType)){
    			//按揭 = 成交总价 - (成交总价 * 按揭比例)取整
    			
    			retVal = getMortgageMoney(detailList, sumMoney);
    		}else{
    			//...尾款
    			
    			//retVal = getPayWayDetailMoneyMulPer(sumMoney, detail.getPayPercent());
    		}
    		
    	}
    	
    	return retVal;
    }
    
    private static BigDecimal getFinalPayment(List<PayWayDetail> detailList, PayWayDetail detail, BigDecimal sumMoney){
    	
    	return null;
    }
    
    /**
     * 获取定金
     * @param detailList
     * @return
     */
    private static BigDecimal getDepoistMoney(List<PayWayDetail> detailList){
    	
    	BigDecimal retVal = new BigDecimal(0);
    	
    	if(CommonUtils.isCollectionEmpty(detailList)){
    		
    		return retVal;
    	}
    	
    	for(PayWayDetail detail : detailList){
    		
    		if(DEPOSIT.equals(detail.getFeeType())){
    			
    			retVal = detail.getPayMoney();
    			break;
    		}
    	}
    	
    	return retVal;
    }
    
    /**
     * 获取按揭金额 A
     * @param detailList
     * @param sumMoney
     * @return
     */
    private static BigDecimal getMortgageMoney(List<PayWayDetail> detailList, BigDecimal sumMoney){
    	
    	BigDecimal retVal = new BigDecimal(0);
    	
    	if(CommonUtils.isCollectionEmpty(detailList)){
    		
    		return retVal;
    	}
    	
    	for(PayWayDetail detail : detailList){
    		
    		if(MORTGAGE.equals(detail.getFeeType())){
    			
    			retVal = getPayWayDetailMoneyMulPer(sumMoney, detail.getPayPercent())
    				.subtract(getMortgageRoundingMoney(detailList, sumMoney));
    			break;
    		}
    	}
    	
    	return retVal;
    }
    
    /**
     * 获取按揭金额取整剩余 B
     * @param detailList
     * @param sumMoney
     * @return
     */
    private static BigDecimal getMortgageRoundingMoney(List<PayWayDetail> detailList, BigDecimal sumMoney){
    	
    	BigDecimal retVal = new BigDecimal(0);
    	
    	if(CommonUtils.isCollectionEmpty(detailList)){
    		
    		return retVal;
    	}
    	
    	for(PayWayDetail detail : detailList){
    		
    		if(MORTGAGE.equals(detail.getFeeType())){
    			
    			int modNum = detail.getModNum();
        		if(modNum == EnumRoundingType.TEN_THOUSAND.getValue()){
        			//尾数保留到万位
        			
        			retVal = getPayWayDetailMoneyMulPer(sumMoney, detail.getPayPercent()).remainder(new BigDecimal(10000)); //获取 成交总价*按揭比例 取整
        			
        		}else if(modNum == EnumRoundingType.THOUSAND.getValue()){
        			//尾数保留到千位
        			
        			retVal = getPayWayDetailMoneyMulPer(sumMoney, detail.getPayPercent()).remainder(new BigDecimal(1000)); //获取 成交总价*按揭比例 取整
        		}
        		
        		break;
    		}
    		
    	}
    	
    	return retVal;
    }
    
    /**
     * 获取付款方式明细的规则金额
     * @param money
     * @param per
     * @return
     */
    private static BigDecimal getPayWayDetailMoneyMulPer(BigDecimal money, BigDecimal per){
    	
    	return money.multiply(per).divide(new BigDecimal(100), 0, RoundingMode.HALF_UP);
    }

    /**
     * 获取初始的应收及未收,二者是相等的
     * @param detail
     * @param sumMoney
     * @return
     */
    @SuppressWarnings("unused")
	@Deprecated
    private static BigDecimal getShouldAndNotPay(PayWayDetail detail, BigDecimal sumMoney){

        BigDecimal payMoeny = detail.getPayMoney(); //固定金额
        if(!CommonUtils.isBigDecimalEmpty(payMoeny)){

            return payMoeny;
        }

        BigDecimal payPer = detail.getPayPercent().divide(new BigDecimal(100));

        return sumMoney.multiply(payPer);
    }

    /**
     * 获取应收款日期
     * @param detail
     * @param workDate
     * @return
     */
    private static Date getPayDate(PayWayDetail detail, Date workDate){

        //两种形式 如果dayNum<0 则固定时间
        if(detail.getDayNum() <= 0){

            return detail.getPayDate() == null ? workDate : detail.getPayDate();
        }else{

            return CommonUtils.getAfterDateForDay(workDate, detail.getDayNum());
        }

    }

    //======================================================================
    //应收佣金：计算佣金用

    /**
     * 面积销售率(%)
     * 累计销售之该项目住宅建筑面积总和/推出可售建筑面积总和 * 100%
     * @param property_id 楼盘项目id
     * @param area_id  分区id
     * @param build_id 楼栋id
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @param managerType 合同类型
     * @return
     */
    public static BigDecimal salesRate(int property_id,int area_id,int build_id,String startDate,String endDate,String managerType){
        ConfirmCond confirmCond = new ConfirmCond();
        confirmCond.setPropertyId(Integer.toString(property_id));
        confirmCond.setAreaId(Integer.toString(area_id));
        confirmCond.setBuildId(Integer.toString(build_id));
        confirmCond.setStartDate(startDate);
        confirmCond.setEndDate(endDate);
        confirmCond.setManagerType(managerType);

        BigDecimal b1 = MyPropertyUtils.getConfirmServices().getSumBuildArea(confirmCond);
        BigDecimal b2 = MyPropertyUtils.getConfirmServices().getTotalBuildArea(confirmCond);
        if (b2.setScale(0,BigDecimal.ROUND_HALF_DOWN).equals(new BigDecimal(0))) return new BigDecimal(0);

        return (b1.divide(b2,2,BigDecimal.ROUND_HALF_EVEN)).multiply(new BigDecimal(100));
    }
    /**
     * 套数销售率(%)
     * 累计销售之该项目住宅套数总和/推出可售套数总和 * 100%
     * @param property_id 楼盘项目id
     * @param area_id  分区id
     * @param build_id 楼栋id
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @param managerType 合同类型
     * @return
     */
    public static BigDecimal salesSuitRate(int property_id,int area_id,int build_id,String startDate,String endDate,String managerType){
        ConfirmCond confirmCond = new ConfirmCond();
        confirmCond.setPropertyId(Integer.toString(property_id));
        confirmCond.setAreaId(Integer.toString(area_id));
        confirmCond.setBuildId(Integer.toString(build_id));
        confirmCond.setStartDate(startDate);
        confirmCond.setEndDate(endDate);
        confirmCond.setManagerType(managerType);

        BigDecimal b1 = new BigDecimal(MyPropertyUtils.getConfirmServices().getConfirmSets(confirmCond));
        BigDecimal b2 = new BigDecimal(MyPropertyUtils.getConfirmServices().getAllUnitSets(confirmCond));

        if (b2.setScale(0,BigDecimal.ROUND_HALF_DOWN).equals(new BigDecimal(0))) return new BigDecimal(0);

        return (b1.divide(b2,2,BigDecimal.ROUND_HALF_EVEN)).multiply(new BigDecimal(100));
    }

    /**
     * 可售货量总套数 (推货量)
     * @param property_id
     * @param area_id     (暂不启用)
     * @param build_id    (暂不启用)
     * @param startDate   (暂不启用)
     * @param endDate      (暂不启用)
     * @param managerType (暂不启用)
     * @return
     */
    public static BigDecimal salesAllUnit(int property_id,int area_id,int build_id,String startDate,String endDate,String managerType){
        ConfirmCond confirmCond = new ConfirmCond();
        confirmCond.setPropertyId(Integer.toString(property_id));
        confirmCond.setAreaId(Integer.toString(area_id));
        confirmCond.setBuildId(Integer.toString(build_id));
        confirmCond.setStartDate(startDate);
        confirmCond.setEndDate(endDate);
        confirmCond.setManagerType(managerType);

        int b1 = MyPropertyUtils.getConfirmServices().getAllUnitSets(confirmCond);

        return new BigDecimal(b1);
    }

    /**
     * 合同签约销售套数(套)
     * @param property_id 楼盘项目id
     * @param area_id  分区id
     * @param build_id 楼栋id
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @param managerType
     * @return
     */
    public static BigDecimal salesUnit(int property_id,int area_id,int build_id,String startDate,String endDate,String managerType){
        ConfirmCond confirmCond = new ConfirmCond();
        confirmCond.setPropertyId(Integer.toString(property_id));
        confirmCond.setAreaId(Integer.toString(area_id));
        confirmCond.setBuildId(Integer.toString(build_id));
        confirmCond.setStartDate(startDate);
        confirmCond.setEndDate(endDate);
        confirmCond.setManagerType(managerType);

        int b1 = MyPropertyUtils.getConfirmServices().getContractSets(confirmCond);

        return new BigDecimal(b1);
    }

    /**
     * 认购成交销售套数(套)
     * @param property_id 楼盘项目id
     * @param area_id  分区id
     * @param build_id 楼栋id
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @param managerType
     * @return
     */
    public static BigDecimal confirmUnit(int property_id,int area_id,int build_id,String startDate,String endDate,String managerType){
        ConfirmCond confirmCond = new ConfirmCond();
        confirmCond.setPropertyId(Integer.toString(property_id));
        confirmCond.setAreaId(Integer.toString(area_id));
        confirmCond.setBuildId(Integer.toString(build_id));
        confirmCond.setStartDate(startDate);
        confirmCond.setEndDate(endDate);
        confirmCond.setManagerType(managerType);

        int b1 = MyPropertyUtils.getConfirmServices().getConfirmSets(confirmCond);

        return new BigDecimal(b1);
    }

    /**
     * 销售金额(万元)
     * @param property_id 楼盘项目id
     * @param area_id  分区id
     * @param build_id 楼栋id
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @return
     */
    public static BigDecimal salesAmount(int property_id,int area_id,int build_id,String startDate,String endDate){
         return salesAmount(property_id, area_id, build_id, startDate, endDate,"");
    }
    public static BigDecimal salesAmount(int property_id,int area_id,int build_id,String startDate,String endDate,String managerType){
        ConfirmCond confirmCond = new ConfirmCond();
        confirmCond.setPropertyId(Integer.toString(property_id));
        confirmCond.setAreaId(Integer.toString(area_id));
        confirmCond.setBuildId(Integer.toString(build_id));
        confirmCond.setStartDate(startDate);
        confirmCond.setEndDate(endDate);
        confirmCond.setManagerType(managerType);

        BigDecimal b1 = MyPropertyUtils.getConfirmServices().getContractPrice(confirmCond);

        return b1.divide(new BigDecimal(10000)).setScale(0, BigDecimal.ROUND_HALF_UP);
    }
    /**
     * 销售面积(㎡)
     * @param property_id 楼盘项目id
     * @param area_id  分区id
     * @param build_id 楼栋id
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @return
     */
    public static BigDecimal salesArea(int property_id,int area_id,int build_id,String startDate,String endDate){
        return salesArea(property_id, area_id, build_id, startDate, endDate,"");
    }
    public static BigDecimal salesArea(int property_id,int area_id,int build_id,String startDate,String endDate,String managerType){
        ConfirmCond confirmCond = new ConfirmCond();
        confirmCond.setPropertyId(Integer.toString(property_id));
        confirmCond.setAreaId(Integer.toString(area_id));
        confirmCond.setBuildId(Integer.toString(build_id));
        confirmCond.setStartDate(startDate);
        confirmCond.setEndDate(endDate);
        confirmCond.setManagerType(managerType);

        BigDecimal b1 = MyPropertyUtils.getConfirmServices().getSumBuildArea(confirmCond);

        return b1;
    }
    /**
     * 面积签约率(%)
     * 累计签约住宅建筑面积总和（合同）/累计销售住宅建筑面积（认购） * 100%
     * @param property_id 楼盘项目id
     * @param area_id  分区id
     * @param build_id 楼栋id
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @return
     */
    public static BigDecimal contractedRate (int property_id,int area_id,int build_id,String startDate,String endDate,String managerType){
        ConfirmCond confirmCond = new ConfirmCond();
        confirmCond.setPropertyId(Integer.toString(property_id));
        confirmCond.setAreaId(Integer.toString(area_id));
        confirmCond.setBuildId(Integer.toString(build_id));
        confirmCond.setStartDate(startDate);
        confirmCond.setEndDate(endDate);
        confirmCond.setManagerType(managerType);

        BigDecimal b1 = MyPropertyUtils.getConfirmServices().getContractBuildArea(confirmCond);
        BigDecimal b2 = MyPropertyUtils.getConfirmServices().getSumBuildArea(confirmCond);
        if (b2.setScale(0,BigDecimal.ROUND_HALF_DOWN).equals(new BigDecimal(0))) return new BigDecimal(0);
        return (b1.divide(b2,2,BigDecimal.ROUND_HALF_EVEN)).multiply(new BigDecimal(100));
    }
    /**
     * 套数签约率(%)
     * 累计签约住宅套数总和（合同）/累计销售住宅套数（认购） * 100%
     * @param property_id 楼盘项目id
     * @param area_id  分区id
     * @param build_id 楼栋id
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @return
     */
    public static BigDecimal suitContractedRate (int property_id,int area_id,int build_id,String startDate,String endDate,String managerType){
        ConfirmCond confirmCond = new ConfirmCond();
        confirmCond.setPropertyId(Integer.toString(property_id));
        confirmCond.setAreaId(Integer.toString(area_id));
        confirmCond.setBuildId(Integer.toString(build_id));
        confirmCond.setStartDate(startDate);
        confirmCond.setEndDate(endDate);
        confirmCond.setManagerType(managerType);

        BigDecimal b1 = new BigDecimal(MyPropertyUtils.getConfirmServices().getContractSets(confirmCond));
        BigDecimal b2 = new BigDecimal(MyPropertyUtils.getConfirmServices().getConfirmSets(confirmCond));
        if (b2.setScale(0,BigDecimal.ROUND_HALF_DOWN).equals(new BigDecimal(0))) return new BigDecimal(0);
        return (b1.divide(b2,2,BigDecimal.ROUND_HALF_EVEN)).multiply(new BigDecimal(100));
    }

    /**
     * 销售均价(元/㎡)
     * 累计实收销售金额/累计销售住宅建筑面积 * 100%
     * @param property_id 楼盘项目id
     * @param area_id  分区id
     * @param build_id 楼栋id
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @return
     */
    public static BigDecimal averagePrice (int property_id,int area_id,int build_id,String startDate,String endDate){
        return averagePrice(property_id, area_id, build_id, startDate, endDate,"");
    }
    public static BigDecimal averagePrice (int property_id,int area_id,int build_id,String startDate,String endDate,String managerType){
        ConfirmCond confirmCond = new ConfirmCond();
        confirmCond.setPropertyId(Integer.toString(property_id));
        confirmCond.setAreaId(Integer.toString(area_id));
        confirmCond.setBuildId(Integer.toString(build_id));
        confirmCond.setStartDate(startDate);
        confirmCond.setEndDate(endDate);
        confirmCond.setManagerType(managerType);

        BigDecimal b1 = MyPropertyUtils.getConfirmServices().getContractPrice(confirmCond);
        BigDecimal b2 = MyPropertyUtils.getConfirmServices().getSumBuildArea(confirmCond);
        if (b2.setScale(0,BigDecimal.ROUND_HALF_DOWN).equals(new BigDecimal(0))) return new BigDecimal(0);
        return b1.divide(b2,2,BigDecimal.ROUND_HALF_EVEN);
    }
    
    /**
     * 获取分阶段合同佣金点数,如果对应的MultManagerCommissionPojo中的commission为0表示没有对应的佣金点数
     * 正常情况下,返回null表示参数或者设置有问题
     * @param propertyId
     * @param areaId
     * @param buildId
     * @param managerType
     * @return
     */
    public static List<MultManagerCommissionPojo> getMultCommission(int propertyId,int areaId,int buildId, String managerType){
    	
    	CommissionPojo pojo = new CommissionPojo(propertyId, areaId, buildId, managerType);
    	ContractManagerCond cond = new ContractManagerCond(propertyId, areaId, buildId, managerType);
    	
    	if(buildId > 0){
    		
    		//获取楼栋对应的合同List
    		List<ContractManager> buildManager = contractManagerServices.findContractManager(cond);
    		
    		if(!CommonUtils.isCollectionEmpty(buildManager)){
    			
    			//此处ContractManager对应的propertyId, areaId, buildId都不为0
    			return contractManagerListToMultManagerCommissionPojoList(buildManager, pojo);
    		}
    		
    		//获取分区对应的合同List
    		ContractManagerCond areaCond = new ContractManagerCond(propertyId, areaId, 0, managerType);
    		List<ContractManager> areaManager = contractManagerServices.findContractManager(areaCond);
    		
    		if(!CommonUtils.isCollectionEmpty(areaManager)){
    			
    			//此处ContractManager对应的propertyId, areaId不为0,buildId为0
    			pojo.setBuildId(0);
    			
    			return contractManagerListToMultManagerCommissionPojoList(areaManager, pojo);
    		}
    		
    		//获取项目对应的合同List
    		ContractManagerCond proCond = new ContractManagerCond(propertyId, 0, 0, managerType);
    		List<ContractManager> propertyManager = contractManagerServices.findContractManager(proCond);
    		
    		if(!CommonUtils.isCollectionEmpty(propertyManager)){
    			
    			//此处ContractManager对应的propertyId不为0,areaId,buildId为0
    			pojo.setAreaId(0);
    			pojo.setBuildId(0);
    			
    			return contractManagerListToMultManagerCommissionPojoList(propertyManager, pojo);
    		}
    		
    	}else if(areaId > 0){
    		
    		ContractManagerCond areaCond = new ContractManagerCond(propertyId, areaId, 0, managerType);
    		List<ContractManager> areaManager = contractManagerServices.findContractManager(areaCond);
    		
    		if(!CommonUtils.isCollectionEmpty(areaManager)){
    			
    			//此处ContractManager对应的propertyId, areaId不为0,buildId为0
    			pojo.setBuildId(0);
    			
    			return contractManagerListToMultManagerCommissionPojoList(areaManager, pojo);
    		}
    		
    		//获取项目对应的合同List
    		ContractManagerCond proCond = new ContractManagerCond(propertyId, 0, 0, managerType);
    		List<ContractManager> propertyManager = contractManagerServices.findContractManager(proCond);
    		
    		if(!CommonUtils.isCollectionEmpty(propertyManager)){
    			
    			//此处ContractManager对应的propertyId不为0,areaId,buildId为0
    			pojo.setAreaId(0);
    			pojo.setBuildId(0);
    			
    			return contractManagerListToMultManagerCommissionPojoList(propertyManager, pojo);
    		}
    		
    	}else if(propertyId > 0){
    		
    		//获取项目对应的合同List
    		ContractManagerCond proCond = new ContractManagerCond(propertyId, 0, 0, managerType);
    		List<ContractManager> propertyManager = contractManagerServices.findContractManager(proCond);
    		
    		if(!CommonUtils.isCollectionEmpty(propertyManager)){
    			
    			//此处ContractManager对应的propertyId不为0,areaId,buildId为0
    			pojo.setAreaId(0);
    			pojo.setBuildId(0);
    			
    			return contractManagerListToMultManagerCommissionPojoList(propertyManager, pojo);
    		}
    	}
    	
    	return null;
    }

    /**
     * 获取合同佣金点数,返回0表示没有对应的点数
     * 之前旧的方案,只有一个佣金点数
     * @param property_id
     * @param area_id
     * @param build_id
     * @param managerType
     * @return
     */
    public static BigDecimal getCommission(int property_id,int area_id,int build_id, String managerType){
    	
    	CommissionPojo pojo = new CommissionPojo(property_id, area_id, build_id, managerType);
    	
    	return getCommission(pojo);
    }
    
    /**
     * 根据ContractManager List返回对应的MultManagerCommissionPojo List
     * @param managerList
     * @return
     */
    private static List<MultManagerCommissionPojo> contractManagerListToMultManagerCommissionPojoList(List<ContractManager> managerList, CommissionPojo pojo){
    	
    	//返回的list
    	List<MultManagerCommissionPojo> multPojoList = new ArrayList<MultManagerCommissionPojo>();
    	
    	if(!CommonUtils.isCollectionEmpty(managerList)){
			
			//此处ContractManager对应的propertyId, areaId, buildId都不为0
			MultManagerCommissionPojo tmpMultPojo = null;
			
			for(ContractManager manager : managerList){
				
				BigDecimal commission = getCommissionByContractManager(manager, pojo);
				
				tmpMultPojo = new MultManagerCommissionPojo(pojo.getPropertyId(), pojo.getAreaId(), pojo.getBuildId(), pojo.getManagerType(), 
						manager.getStartDate(), manager.getEndDate(), commission, manager.getRelationCommission(), manager.getRelationMoney());
				
				multPojoList.add(tmpMultPojo);
			}
			
		}
    	
    	return multPojoList;
    }

    /**
     * 获取佣金点数,返回0表示没有对应的点数
     * @param pojo
     * @return
     */
    private static BigDecimal getCommission(CommissionPojo pojo){
    	
    	int buildId = pojo.getBuildId();
    	int areaId = pojo.getAreaId();
    	int propertyId = pojo.getPropertyId();
    	String managerType = pojo.getManagerType();
    	
    	ContractManagerCond cond = new ContractManagerCond(propertyId, areaId, buildId, managerType);
    	
    	if(buildId > 0){
    		//获取楼栋对应的合同,正常逻辑下只有一条的
    		
    		//List<ContractManager> buildManager = contractManagerServices.findContractManagerByBuildId(buildId);
    		List<ContractManager> buildManager = contractManagerServices.findContractManager(cond);
    		
    		if(!CommonUtils.isCollectionEmpty(buildManager)){
    			
    			return getCommissionByContractManager(buildManager.get(0), pojo);
    		}
    		
    		//List<ContractManager> areaManager = contractManagerServices.findContractManagerByAreaId(areaId);
    		ContractManagerCond areaCond = new ContractManagerCond(propertyId, areaId, 0, managerType);
    		List<ContractManager> areaManager = contractManagerServices.findContractManager(areaCond);
    		
    		if(!CommonUtils.isCollectionEmpty(areaManager)){
    			
    			pojo.setBuildId(0);
    			
    			return getCommissionByContractManager(areaManager.get(0), pojo);
    		}
    		
    		//List<ContractManager> propertyManager = contractManagerServices.findContractManagerByProId(propertyId);
    		ContractManagerCond proCond = new ContractManagerCond(propertyId, 0, 0, managerType);
    		List<ContractManager> propertyManager = contractManagerServices.findContractManager(proCond);
    		
    		if(!CommonUtils.isCollectionEmpty(propertyManager)){
    			
    			pojo.setBuildId(0);
    			pojo.setAreaId(0);
    			
    			return getCommissionByContractManager(propertyManager.get(0), pojo);
    		}
    		
    	}else if(areaId > 0){
    		
    		//List<ContractManager> areaManager = contractManagerServices.findContractManagerByAreaId(areaId);
    		ContractManagerCond areaCond = new ContractManagerCond(propertyId, areaId, 0, managerType);
    		List<ContractManager> areaManager = contractManagerServices.findContractManager(areaCond);
    		
    		if(!CommonUtils.isCollectionEmpty(areaManager)){
    			
    			pojo.setBuildId(0);
    			
    			return getCommissionByContractManager(areaManager.get(0), pojo);
    		}
    		
    		//List<ContractManager> propertyManager = contractManagerServices.findContractManagerByProId(propertyId);
    		ContractManagerCond proCond = new ContractManagerCond(propertyId, 0, 0, managerType);
    		List<ContractManager> propertyManager = contractManagerServices.findContractManager(proCond);
    		
    		if(!CommonUtils.isCollectionEmpty(propertyManager)){
    			
    			pojo.setBuildId(0);
    			pojo.setAreaId(0);
    			
    			return getCommissionByContractManager(propertyManager.get(0), pojo);
    		}
    		
    	}else if(propertyId > 0){
    		
    		//List<ContractManager> propertyManager = contractManagerServices.findContractManagerByProId(propertyId);
    		ContractManagerCond proCond = new ContractManagerCond(propertyId, 0, 0, managerType);
    		List<ContractManager> propertyManager = contractManagerServices.findContractManager(proCond);
    		
    		if(!CommonUtils.isCollectionEmpty(propertyManager)){
    			
    			pojo.setBuildId(0);
    			pojo.setAreaId(0);
    			
    			return getCommissionByContractManager(propertyManager.get(0), pojo);
    		}
    	}
    	
    	return new BigDecimal(0);
    }
    
   /**
    * 根据项目id,获取楼栋对应的点数
    * @param propertyId
    * @return
    */
    public static Map<Integer, BigDecimal> getBuildListCommissionByPropertyId(int propertyId){
    	
    	List<PropertyBuild> buildList = MyPropertyUtils.getPropertyBuildServices().findPropertyBuildByPropertyId(propertyId);
    	
    	if(CommonUtils.isCollectionEmpty(buildList)){
    		
    		return null;
    	}
    	
    	Map<Integer, BigDecimal> retMap = new HashMap<Integer, BigDecimal>();
    	
    	for(PropertyBuild build : buildList){
    		
    		int buildId = build.getId();
    		int areaId = build.getAreaId();
    		
    		CommissionPojo pojo = new CommissionPojo(propertyId, areaId, buildId);
    		BigDecimal commission = getCommission(pojo);
    		if(CommonUtils.isBigDecimalEmpty(commission))
    			continue;
    		
    		retMap.put(buildId, commission);
    	}
    	
    	return retMap;
    }
    
    /**
     * 根据分区id,获取楼栋对应的点数
     * @param areaId
     * @return
     */
    public static Map<Integer, BigDecimal> getBuildListCommissionByAreaId(int areaId){
    	
    	List<PropertyBuild> buildList = MyPropertyUtils.getPropertyBuildServices().findPropertyBuildByAreaId(areaId);
    	
    	if(CommonUtils.isCollectionEmpty(buildList)){
    		
    		return null;
    	}
    	
    	Map<Integer, BigDecimal> retMap = new HashMap<Integer, BigDecimal>();
    	
    	for(PropertyBuild build : buildList){
    		
    		int buildId = build.getId();
    		int propertyId = build.getPropertyId();
    		
    		CommissionPojo pojo = new CommissionPojo(propertyId, areaId, buildId);
    		BigDecimal commission = getCommission(pojo);
    		if(CommonUtils.isBigDecimalEmpty(commission))
    			continue;
    		
    		retMap.put(buildId, commission);
    	}
    	
    	return retMap;
    }
    
    /**
     * 判断单元是否已经收完款(即应收与实收是否相等)
     * @param unitId
     * @return
     */
    public boolean isReceiptFinishByUnitId(int unitId){
    	
    	List<UnitPayBill> unitPayBillList = unitPayBillServices.findUnitPayBillByUnitId(unitId);
    	if(CommonUtils.isCollectionEmpty(unitPayBillList)){
    		return true;
    	}
    	
    	BigDecimal allNotPay = new BigDecimal(0);
    	
    	for(UnitPayBill bill : unitPayBillList){
			
			allNotPay = allNotPay.add(bill.getNotPay() == null ? new BigDecimal(0) : bill.getNotPay());
		}
    	
    	if(CommonUtils.isBigDecimalEmpty(allNotPay)){
    		return true;
    	}
    	
    	return false;
    }
    
    ////
    
    /**
     * 根据合同获取对应的bar点佣金点数,
     * 获取的barList按佣金点数降序排,只要符合就返回
     * @param contractManager
     * @param pojo,传进来的值,应该要明确,如果要调用楼栋对应的方法,那么就应该把分区和项目id设为0,其他的以此类推...
     * @return
     */
    private static BigDecimal getCommissionByContractManager(ContractManager contractManager, CommissionPojo pojo){
    	
    	if(contractManager == null)
    		return new BigDecimal(0);
    	
    	int contractManagerId = contractManager.getId();
    	
    	List<ContractBarrules> barList = contractBarrulesServices.findContractBarrulesByManagerId(contractManagerId);
    	if(CommonUtils.isCollectionEmpty(barList)){
    		
    		return contractManager.getDefaultCommission();
    	}
    	
    	BigDecimal retVal = new BigDecimal(0);
    	
    	for(ContractBarrules bar : barList){
    		
    		BigDecimal tmpVal = getCommissionByContractBarrules(bar, pojo);
    		if(CommonUtils.isBigDecimalEmpty(tmpVal)){
    			
    			continue;
    		}else{
    			
    			retVal = tmpVal;
    			break;
    		}
    		
    	}
    	
    	if(CommonUtils.isBigDecimalEmpty(retVal)){
    		return contractManager.getDefaultCommission(); 
    	}
    	
    	return retVal;
    }
    
    /**
     * 根据bar获取对应的佣金点数
     * 前后的数值要把=0的情况考虑进去
     * oprF:>=,>,=; oprB:<=,<
     * @param bar
     * @param pojo
     * @return
     */
    private static BigDecimal getCommissionByContractBarrules(ContractBarrules bar, CommissionPojo pojo){
    	
    	//
    	Date startDate_ = bar.getStartDate();
    	Date endDate_ = bar.getEndDate();
    	
    	String startDate = (startDate_ == null) ? "" : CommonUtils.getDateString(startDate_);
    	String endDate = (endDate_ == null) ? "" : CommonUtils.getDateString(endDate_);
    	
    	int dataF1 = bar.getDataF1(); //面积销售率(%),前
    	int dataB1 = bar.getDataB1(); //面积销售率(%),后
    	
    	int dataF2 = bar.getDataF2(); //面积签约率(%),前
    	int dataB2 = bar.getDataB2(); //面积签约率(%),后
    	
    	int dataF3 = bar.getDataF3(); //销售套数(套),前
    	int dataB3 = bar.getDataB3(); //销售套数(套),后
    	
    	int dataF4 = bar.getDataF4(); //销售金额(万元),前
    	int dataB4 = bar.getDataB4(); //销售金额(万元),后
    	
    	int dataF5 = bar.getDataF5(); //销售面积(㎡),前
    	int dataB5 = bar.getDataB5(); //销售面积(㎡),后
    	
    	int dataF6 = bar.getDataF6(); //销售均价(元/㎡),前
    	int dataB6 = bar.getDataB6(); //销售均价(元/㎡),后

        int dataF7 = bar.getDataF7(); //套数销售率(%),前
        int dataB7 = bar.getDataB7(); //套数销售率(%),后

        int dataF8 = bar.getDataF8(); //套数签约率(%),前
        int dataB8 = bar.getDataB8(); //套数签约率(%),后
    	
    	List<DealPojo> dealList = new ArrayList<DealPojo>();
    	
    	DealPojo dealPojo = null;
    	
    	int property_id = pojo.getPropertyId();
    	int area_id = pojo.getAreaId();
    	int build_id = pojo.getBuildId();
    	String managerType = pojo.getManagerType();
    	
    	//面积销售率
    	if(!(dataF1 == 0 && dataB1 == 0)){
    		
    		BigDecimal salesRate = salesRate(property_id, area_id, build_id, startDate, endDate, managerType);
    		
    		dealPojo = new DealPojo(bar.getOprF1(), dataF1, bar.getOprB1(), dataB1, salesRate);
    		
    		dealList.add(dealPojo);
    		
    	}
    	
    	//面积签约率
    	if(!(dataF2 == 0 && dataB2 == 0)){
    		
    		BigDecimal contractedRate = contractedRate(property_id, area_id, build_id, startDate, endDate, managerType);
    		
    		dealPojo = new DealPojo(bar.getOprF2(), dataF2, bar.getOprB2(), dataB2, contractedRate);
    		
    		dealList.add(dealPojo);
    		
    	}

        //套数销售率
        if(!(dataF7 == 0 && dataB7 == 0)){

            BigDecimal salesSuitRate = salesSuitRate(property_id, area_id, build_id, startDate, endDate, managerType);

            dealPojo = new DealPojo(bar.getOprF7(), dataF7, bar.getOprB7(), dataB7, salesSuitRate);

            dealList.add(dealPojo);

        }

        //套数签约率
        if(!(dataF8 == 0 && dataB8 == 0)){

            BigDecimal suitContractedRate = suitContractedRate(property_id, area_id, build_id, startDate, endDate, managerType);

            dealPojo = new DealPojo(bar.getOprF8(), dataF8, bar.getOprB8(), dataB8, suitContractedRate);

            dealList.add(dealPojo);

        }

        //销售套数
    	if(!(dataF3 == 0 && dataB3 == 0)){
    		
    		BigDecimal salesUnit = salesUnit(property_id, area_id, build_id, startDate, endDate, managerType);
    		
    		dealPojo = new DealPojo(bar.getOprF3(), dataF3, bar.getOprB3(), dataB3, salesUnit);
    		
    		dealList.add(dealPojo);
    		
    	}
    	
    	//销售金额
    	if(!(dataF4 == 0 && dataB4 == 0)){
    		
    		BigDecimal salesAmount = salesAmount(property_id, area_id, build_id, startDate, endDate, managerType);
    		
    		dealPojo = new DealPojo(bar.getOprF4(), dataF4, bar.getOprB4(), dataB4, salesAmount);
    		
    		dealList.add(dealPojo);
    	}
    	
    	//销售面积
    	if(!(dataF5 == 0 && dataB5 == 0)){
    		
    		BigDecimal salesArea = salesArea(property_id, area_id, build_id, startDate, endDate, managerType);
    		
    		dealPojo = new DealPojo(bar.getOprF5(), dataF5, bar.getOprB5(), dataB5, salesArea);
    		
    		dealList.add(dealPojo);
    	}
    	
    	//销售均价
    	if(!(dataF6 == 0 && dataB6 == 0)){
			
			BigDecimal averagePrice = averagePrice(property_id, area_id, build_id, startDate, endDate, managerType);
			
			dealPojo = new DealPojo(bar.getOprF6(), dataF6, bar.getOprB6(), dataB6, averagePrice);
			
			dealList.add(dealPojo);
		}
		
		if(CommonUtils.isCollectionEmpty(dealList)){
			
			return null;
		}
		
		if(isListAccord(dealList)){
			
			return bar.getCommission();
		}
		
    	return null;
    }
    
    /**
     * 判断要处理的list是否符合
     * @param dealList
     * @return
     */
    private static boolean isListAccord(List<DealPojo> dealList){
    	
    	int trueCount = 0;
    	
    	for(DealPojo deal : dealList){
    		
    		if(isPojoAccord(deal)){
    			
    			trueCount++;
    		}
    	}
    	
    	if(dealList.size() == trueCount){
    		return true;
    	}
    	
    	return false;
    }
    
    /**
     * 判断单条是否符合
     * @param deal
     * @return
     */
    private static boolean isPojoAccord(DealPojo deal){
    	
		BigDecimal val = deal.getVal();
		
		String oprF = deal.getOprF();
		int dataF = deal.getDataF();
		
		int dataB = deal.getDataB();
		
		if(dataF >= dataB){
			//如果左边>=右边,只要判断左边是否符合
			
			BigDecimal dataFBig = new BigDecimal(dataF);
			
			if(ContContractManager.GT_EQ_VAL.equals(oprF)){
				//表示,要判断的值>=设定的值,才符合
			
				if(val.compareTo(dataFBig) == -1){
					//要判断的值<设定的值
					
					return false;
				}
			}else if(ContContractManager.EQ_VAL.equals(oprF)){
				//=
				
				if(val.compareTo(dataFBig) != 0){
					//要判断的值!=设定的值
					
					return false;
				}
			}else if(ContContractManager.GT_VAL.equals(oprF)){
				//表示,要判断的值>设定的值,才符合
				
				if(val.compareTo(dataFBig) <= 0){
					//要判断的值<=设定的值
					
					return false;
				}
			}
			
		}else{
			//左边<右边
			
			return leftLtRight(deal);
		}
    		
		return true;
    }
    
    /**
     * 判断左边小于右边的情况
     * @param deal
     * @return
     */
    private static boolean leftLtRight(DealPojo deal){
    	
		BigDecimal val = deal.getVal();
		
		String oprF = deal.getOprF();
		int dataF = deal.getDataF();
		
		String oprB = deal.getOprB();
		int dataB = deal.getDataB();
		
		BigDecimal dataFBig = new BigDecimal(dataF); //左边的值
		BigDecimal dataBBig = new BigDecimal(dataB); //右边的值
		
		boolean isLeftAccord = true;
		boolean isRightAccord = true;
		
		if(ContContractManager.GT_EQ_VAL.equals(oprF)){
			//>=
		
			if(val.compareTo(dataFBig) == -1){
				
				isLeftAccord = false;
			}
		}else if(ContContractManager.EQ_VAL.equals(oprF)){
			//=
			
			if(val.compareTo(dataFBig) != 0){
				
				isLeftAccord = false;
			}
		}else if(ContContractManager.GT_VAL.equals(oprF)){
			//>
			
			if(val.compareTo(dataFBig) <= 0){
				
				isLeftAccord = false;
			}
		}
		
		if(ContContractManager.LT_EQ_VAL.equals(oprB)){
			//<=
			
			if(val.compareTo(dataBBig) == 1){
				
				isRightAccord = false;
			}
			
		}else if(ContContractManager.LT_VAL.equals(oprB)){
			//<
			
			if(val.compareTo(dataBBig) >= 0){
				
				isRightAccord = false;
			}
			
		}
		
		if(isLeftAccord && isRightAccord){
			
			return true;
		}
    	
    	return false;
    }
    
}
