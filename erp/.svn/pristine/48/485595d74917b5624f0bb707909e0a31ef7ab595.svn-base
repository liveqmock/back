package com.ihk.saleunit.log;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.aopalliance.intercept.MethodInvocation;

import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.saleunit.data.pojo.CancelUnit;
import com.ihk.saleunit.data.pojo.Confirm;
import com.ihk.saleunit.data.pojo.ConfirmBook;
import com.ihk.saleunit.data.pojo.Contract;
import com.ihk.saleunit.data.pojo.CustomerRename;
import com.ihk.saleunit.data.pojo.ReplaceUnit;
import com.ihk.saleunit.data.pojo.Tart;
import com.ihk.saleunit.data.pojo.UnitOperRecord;
import com.ihk.saleunit.log.pojo.Log;
import com.ihk.saleunit.log.services.ILogService;
import com.ihk.utils.DescUtils;
import com.ihk.utils.log.CompareUtils;
import com.ihk.utils.request.HttpRequestUtils;
import com.ihk.utils.saleunit.MyPropertyUtils;

/**
 * 单元交易操作日记记录
 * @author xushaojia
 *
 */
public class UnitTransactionLogService {
	//TODO 未写日记的记录service
	private static ILogService logService = CompareUtils.getLogService();
	
	private MethodInvocation invocation;
	
	public UnitTransactionLogService(MethodInvocation invocation){
		this.invocation = invocation;
	}
	
	public void addConfirmBookLog() throws Exception {
		ConfirmBook nowBook = (ConfirmBook) HttpRequestUtils.getRequest().getAttribute("confirmBook");
		Log log = new Log();
		CompareUtils.initPojoCommonFiled(log);
		log.setType("新建临定");
		log.setModul("销售中心");
		log.setOperationProcedure( "单元-"+nowBook.getUnit().getUnitNo()+"新建临定");
		log.setUnitId(nowBook.getUnitId());
		logService.addLog(log);
		return ;
	}
	
	/**
	 * 单元临定信息修改日志
	 * @return
	 * @throws Exception 
	 */
	public void updateConfirmBookLog() throws Exception{
		ConfirmBook nowBook = (ConfirmBook) HttpRequestUtils.getRequest().getAttribute("confirmBook");
		if(nowBook==null){
			return;
		}
		ConfirmBook lastBook = MyPropertyUtils.getConfirmBookServices().findConfirmBookById(nowBook.getId());
		
		Map<String, String> changeMap = new HashMap<String, String>();
		String nowCustomerId = (String)HttpRequestUtils.getRequest().getParameter("customerId");
		nowCustomerId = nowCustomerId.substring(0, nowCustomerId.length()-1);
		if(!lastBook.getSalesId().equals(nowBook.getSalesId())){
			String salesChange = CompareUtils.compareSalesId(lastBook.getSalesId(), nowBook.getSalesId());
			changeMap.put("销售人员变动",salesChange);
		}
		if(!lastBook.getCustomerIds().equals(nowCustomerId)){
			String customerChange  = CompareUtils.compareCustomerId(lastBook.getCustomerIds(), nowCustomerId);
			changeMap.put("销售客户变更", customerChange);
		}
		if(lastBook.getBookMoney().compareTo(nowBook.getBookMoney())!=0){
			changeMap.put("应收定金更改", lastBook.getBookMoney()+">>"+nowBook.getBookMoney());
		}
		String endDateChange = CompareUtils.equals(lastBook.getEndDate(), nowBook.getEndDate());
		if(!"".equals(endDateChange)){
			changeMap.put("失效日期更改", endDateChange);
		}
		if(changeMap.isEmpty())
			return;
		Log log = new Log();
		CompareUtils.initPojoCommonFiled(log);
		log.setType("修改临定");
		log.setModul("销售中心");
		log.setUnitId(nowBook.getUnitId());
		log.setOperationProcedure("修改单元"+nowBook.getUnit().getUnitNo()+"临定信息<br/>"+CompareUtils.createChange(changeMap));
		logService.addLog(log);
		return;
	}
	
	/**
	 * 增加挞定的记录
	 * @return
	 * @throws Exception 
	 */
	public void addTartActionLog() throws Exception {
		Tart tart = (Tart)HttpRequestUtils.getRequest().getAttribute("tart");
		PropertyUnit unit = MyPropertyUtils.getPropertyUnitServices().findPropertyUnitById(tart.getUnitId());
		Log log = new Log();
		
		CompareUtils.initPojoCommonFiled(log);
		if(!"".equals(tart.getRemark()))
			log.setOperationProcedure("单元-"+unit.getUnitNo()+"新建挞定--备注"+tart.getRemark()+")");
		else
			log.setOperationProcedure("单元-"+unit.getUnitNo()+"新建挞定");
		log.setType("新建挞定");
		log.setUnitId(tart.getUnitId());
		log.setModul("销售中心");
		logService.addLog(log);
		return;
	}
	
	/**
	 * 撤销挞定的记录
	 * @throws Exception 
	 */
	public void deleteTartActionLog() throws Exception{
		int recordId = (Integer)HttpRequestUtils.getRequest().getAttribute("recordId");
		UnitOperRecord unitOperRecord=MyPropertyUtils.getUnitOperRecordServices().findUnitOperRecordById(recordId);
		PropertyUnit unit = MyPropertyUtils.getPropertyUnitServices().findPropertyUnitById(unitOperRecord.getUnitId());
		Log log = new Log();
		CompareUtils.initPojoCommonFiled(log);
		log.setOperationProcedure("单元-"+unit.getUnitNo()+"撤销挞定");
		log.setUnitId(unitOperRecord.getUnitId());
		log.setModul("销售中心");
		logService.addLog(log);
		return;
	}

	
	/**
	 * 增加成交的记录
	 * @throws Exception 
	 */
	public void addConfirmLog() throws Exception {
		Confirm confirm = (Confirm) HttpRequestUtils.getRequest().getAttribute("confirm");
		Confirm confirm1 = (Confirm) invocation.getArguments()[0];

		Log log = new Log();
		CompareUtils.initPojoCommonFiled(log);
		log.setType("新建成交");
		log.setOperationProcedure("单元-"+confirm.getUnit().getUnitNo()+"新建成交");
		log.setUnitId(confirm.getUnitId());
		if(confirm.getUnitId()!=confirm1.getUnitId()){//追加判断该成交记录是谁传过来的，相同为默认新建成交，不同为退房时的成交
			log.setUnitId(confirm1.getUnitId());
			log.setOperationProcedure("新建成交（新建换房时）");
		}
		log.setModul("销售中心");
		logService.addLog(log);
		return ;
	}
	
	
	/**
	 * 修改成交信息的记录
	 * @throws Exception 
	 */
	public void updateConfirmLog() throws Exception{
		Confirm nowConfirm = (Confirm) HttpRequestUtils.getRequest().getAttribute("confirm");
		Confirm lastConfirm = MyPropertyUtils.getConfirmServices().findConfirmById(nowConfirm.getId());
		
		String nowCustomerId = (String)HttpRequestUtils.getRequest().getParameter("customerId"); //得到表单提交的新客户
		
		nowCustomerId = nowCustomerId.substring(0, nowCustomerId.length()-1);
		//表单的unit
		PropertyUnit unit =  (PropertyUnit) HttpRequestUtils.getRequest().getAttribute("unit");
		
		Map<String, String> changes = new HashMap<String, String>();
		//销售人员
		if(lastConfirm.getSalesId()!=null){
			if(!lastConfirm.getSalesId().equals(nowConfirm.getSalesId())){
				String salesChange = CompareUtils.compareSalesId(lastConfirm.getSalesId(), nowConfirm.getSalesId());
				changes.put("销售人员变动",salesChange);
			}
		}
		//销售客户
		if(lastConfirm.getCustomerIds()!=null){
			if(!lastConfirm.getCustomerIds().equals(nowCustomerId)){
				String last = lastConfirm.getCustomerIds();
				String customerChange  = CompareUtils.compareCustomerId(last, nowCustomerId);
				changes.put("销售客户变更", customerChange);
			}
		}
		//建筑面积
		
		String buildArea =	CompareUtils.equals(lastConfirm.getUnit().getBuildArea(), unit.getBuildArea());
		if(!"".equals( buildArea))
			changes.put("建筑面积变动", buildArea);
		//套内面积
		BigDecimal nowUnitInsideArea = unit.getInsideArea();
		BigDecimal lastUnitInsideArea =  DescUtils.getUnitById(lastConfirm.getUnitId()).getInsideArea();
		String unitInsidAreaChange  = CompareUtils.compareUnitInsideArea(nowUnitInsideArea, lastUnitInsideArea);
		if(unitInsidAreaChange!=null){
			changes.put("套内面积变动", unitInsidAreaChange);
		}
		//付款方式
		String payTypeChange =  CompareUtils.comparePayType(lastConfirm.getPayWayId(), nowConfirm.getPayWayId(), lastConfirm.getUnitId());
		if(payTypeChange!=null)
			
			changes.put("付款方式变动", payTypeChange);
		
		//成交总价
		String sumMoneyChange = CompareUtils.equals(lastConfirm.getSumMoney(), nowConfirm.getSumMoney());
		if(!"".equals(sumMoneyChange))
			changes.put("成交总价变动", sumMoneyChange);
		//认购书编号
		String agreeNoChange = CompareUtils.equals(lastConfirm.getAgreeNo(), nowConfirm.getAgreeNo());
		if(!"".equals(agreeNoChange))
			changes.put("认购书编号变动", agreeNoChange);
		//认购日期
		String workDateChange = CompareUtils.equals(lastConfirm.getWorkDate(), nowConfirm.getWorkDate());
		if(!"".equals(workDateChange))
			changes.put("认购书日期变动", workDateChange);
		//关系户
		String isRelationChange = CompareUtils.compareIsRelation(lastConfirm.getIsRelation(), nowConfirm.getIsRelation());
		if(isRelationChange!=null)
			changes.put("是否关系户变动", isRelationChange);
		//一二手联动
		String isSecondLinkageChange = CompareUtils.compareIsRelation(lastConfirm.getIsSecondLinkage(), nowConfirm.getIsSecondLinkage());
		if(isSecondLinkageChange!=null)
			changes.put("一二手联动变动", isSecondLinkageChange);
		//备注
		String remarkChange = CompareUtils.equals(lastConfirm.getRemark(), nowConfirm.getRemark());
		if(!"".equals(remarkChange))
			changes.put("备注变动", remarkChange);
		if(changes.isEmpty())
			return;
		Log log = new Log();
		CompareUtils.initPojoCommonFiled(log);
		log.setType("修改成交");
		log.setUnitId(nowConfirm.getUnitId());
		log.setModul("销售中心");
		log.setOperationProcedure("单元"+nowConfirm.getUnit().getUnitNo()+"修改成交信息<br/>"+CompareUtils.createChange(changes));
		logService.addLog(log);
		return ;
	}

	/**
	 * 新建退房
	 * @throws Exception
	 */
	public void addCancelUnitLog() throws Exception {
		
		CancelUnit cancelUnit = (CancelUnit) HttpRequestUtils.getRequest().getAttribute("cancelUnit");
		PropertyUnit unit = MyPropertyUtils.getPropertyUnitServices().findPropertyUnitById(cancelUnit.getUnitId());
		Log log = new Log();
		CompareUtils.initPojoCommonFiled(log);
		if(!"".equals(cancelUnit.getRemark()))
			log.setOperationProcedure("单元-"+unit.getUnitNo()+"新建退房--备注:（ "+cancelUnit.getRemark()+")");
		else
			log.setOperationProcedure("单元-"+unit.getUnitNo()+"新建退房");
		
		
		log.setType("新建退房");
		log.setModul("销售中心");
		log.setUnitId(cancelUnit.getUnitId());
		logService.addLog(log);
		return;
		
	}
	
	public void deleteCancelUnitLog() throws Exception{
		int recordId =  (Integer)HttpRequestUtils.getRequest().getAttribute("recordId");
		int unitId = MyPropertyUtils.getUnitOperRecordServices().findUnitOperRecordById(recordId).getUnitId();
		PropertyUnit unit = MyPropertyUtils.getPropertyUnitServices().findPropertyUnitById(unitId);
		Log log = new Log();
		CompareUtils.initPojoCommonFiled(log);
		log.setOperationProcedure("单元-"+unit.getUnitNo()+"撤销退房");
		log.setType("撤销退房");
		log.setUnitId(unitId);
		log.setModul("销售中心");
		logService.addLog(log);
		
	}

	/**
	 * 新建合同
	 * @throws Exception 
	 */
	public void addContractLog() throws Exception {
		int unitId = ((Contract)HttpRequestUtils.getRequest().getAttribute("contract")).getUnitId();
		PropertyUnit unit = MyPropertyUtils.getPropertyUnitServices().findPropertyUnitById(unitId);
		Log log = new Log();
		CompareUtils.initPojoCommonFiled(log);
		log.setType("新建合同");
		log.setOperationProcedure("单元-"+unit.getUnitNo()+"新建合同");
		logService.addLog(log);
		log.setUnitId(unitId);
		log.setModul("销售中心");
		logService.addLog(log);
		return ;
	}
	
	/**
	 * 修改合同
	 * @throws Exception
	 */
	public void updateContractLog() throws Exception{
		Contract nowContract = (Contract)HttpRequestUtils.getRequest().getAttribute("contract");
		Contract lastContract = MyPropertyUtils.getContractServices().findContractById(nowContract.getId());
		
		PropertyUnit nowUnit = (PropertyUnit)HttpRequestUtils.getRequest().getAttribute("selectUnit");
		
		PropertyUnit lastUnit = lastContract.getUnit();
		
		String nowCustomerId = (String)HttpRequestUtils.getRequest().getParameter("customerId"); //得到表单提交的新客户
		
		nowCustomerId = nowCustomerId.substring(0, nowCustomerId.length()-1);
		
		Map<String,String> changeMap = new HashMap<String, String>();
		
		//合同编号
		String contractNoChange = CompareUtils.equals(lastContract.getContractNo(), nowContract.getContractNo());
		if(!"".equals(contractNoChange))
			changeMap.put("合同编号变动", contractNoChange);
		//签约合同日期
		String signDateChange = CompareUtils.equals(lastContract.getSignDate(), nowContract.getSignDate());
		if(!"".equals(signDateChange))
			changeMap.put("签约合同日期", signDateChange);
		//建筑面积
		
		String buildArea =	CompareUtils.equals(lastContract.getUnit().getBuildArea(), nowUnit.getBuildArea());
		if(!"".equals( buildArea))
			changeMap.put("建筑面积变动", buildArea);
		//套内面积
		if(lastUnit.getInsideArea()!=null){
		String unitInsidAreaChange  = CompareUtils.compareUnitInsideArea(lastUnit.getInsideArea(), nowUnit.getInsideArea());
		if(unitInsidAreaChange!=null){
			changeMap.put("套内面积变动", unitInsidAreaChange);
		}
		}
		//付款方式
		
		String payTypeChange =  CompareUtils.comparePayType(lastContract.getPayWayId(), nowContract.getPayWayId(), lastContract.getUnitId());
		if(payTypeChange!=null)
			changeMap.put("付款方式变动", payTypeChange);
		//成交总价
		String sumMoneyChange = CompareUtils.equals(lastContract.getSumMoney(), nowContract.getSumMoney());
		if(!"".equals(sumMoneyChange))
			changeMap.put("成交总价变动", sumMoneyChange);
		//关系户
		String isRelationChange = CompareUtils.compareIsRelation(lastContract.getIsRelation(), nowContract.getIsRelation());
		if(isRelationChange!=null)
			changeMap.put("是否关系户变动", isRelationChange);
		//一二手联动
		String isSecondLinkageChange = CompareUtils.compareIsRelation(lastContract.getIsSecondLinkage(), nowContract.getIsSecondLinkage());
		if(isSecondLinkageChange!=null)
			changeMap.put("一二手联动变动", isSecondLinkageChange);
		//销售人员
		if(lastContract.getSalesId()!=null){
		if(!lastContract.getSalesId().equals(nowContract.getSalesId())){
			String salesChange = CompareUtils.compareSalesId(lastContract.getSalesId(), nowContract.getSalesId());
			changeMap.put("销售人员变动",salesChange);
		}
		}
		//销售客户
		if(lastContract.getCustomerIds()!=null){
		if(!lastContract.getCustomerIds().equals(nowCustomerId)){
			String last = lastContract.getCustomerIds();
			String customerChange  = CompareUtils.compareCustomerId(last, nowCustomerId);
			changeMap.put("销售客户变更", customerChange);
		}
		}
		if(changeMap.isEmpty())
			return ;
		Log log = new Log();
		CompareUtils.initPojoCommonFiled(log);
		log.setUnitId(lastContract.getUnitId());
		log.setType("修改合同");
		log.setOperationProcedure("单元-"+nowContract.getUnit().getUnitNo()+"修改合同信息<br/>"+CompareUtils.createChange(changeMap));
		log.setModul("销售中心");
		logService.addLog(log);
		return;
	}
	
	/**
	 * 新建换房
	 * @throws Exception 
	 */
	public void addReplaceUnitLog() throws Exception{
		ReplaceUnit replaceUnit = (ReplaceUnit) HttpRequestUtils.getRequest().getAttribute("replaceUnit");
		PropertyUnit unit = MyPropertyUtils.getPropertyUnitServices().findPropertyUnitById(replaceUnit.getUnitId1());
		Log log = new Log();
		if(!"".equals(replaceUnit.getRemark()))
			log.setOperationProcedure("单元-"+unit.getUnitNo()+"新建换房<br/>"+"备注("+replaceUnit.getRemark()+")");
		else
			log.setOperationProcedure("单元-"+unit.getUnitNo()+"新建换房");
		CompareUtils.initPojoCommonFiled(log);
		log.setUnitId(replaceUnit.getUnitId1());
		log.setType("新建换房");
		log.setModul("销售中心");
		logService.addLog(log);
		return;
	}

	/**
	 * 单元改名
	 * @throws Exception
	 */
	public void addCustomerRenameLog() throws Exception{
		Confirm confirm = (Confirm) HttpRequestUtils.getRequest().getAttribute("confirm");
		CustomerRename customerRename = (CustomerRename)HttpRequestUtils.getRequest().getAttribute("customerRename");
		StringBuilder sb = new StringBuilder();
		
		Map<String, String> changeMap = new HashMap<String, String>();
		if(!customerRename.getPrevCustomerId().equals(customerRename.getNextCustomerId())){
			String customerChange = CompareUtils.compareCustomerId(customerRename.getPrevCustomerId(), customerRename.getNextCustomerId());
			changeMap.put("销售客户变动", customerChange);
		}
		if(!changeMap.isEmpty())
			sb.append(CompareUtils.createChange(changeMap));
		Log log = new Log();
		CompareUtils.initPojoCommonFiled(log);
		sb.append("<br/>");
		if(!"".equals(customerRename.getRemark()))
			sb.append("备注("+customerRename.getRemark()+")");
		else
			sb.append("新建改名");
		log.setOperationProcedure("单元-"+confirm.getUnit().getUnitNo()+sb.toString());
		log.setUnitId(confirm.getUnitId());
		log.setType("新建改名");
		log.setModul("销售中心");
		logService.addLog(log);
		return ;
		
	}
}
