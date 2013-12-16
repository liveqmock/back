package com.ihk.saleunit.log;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.saleunit.data.pojo.Confirm;
import com.ihk.saleunit.data.pojo.ConfirmBook;
import com.ihk.saleunit.data.pojo.Tart;
import com.ihk.saleunit.data.pojo.UnitOperRecord;
import com.ihk.saleunit.log.pojo.Log;
import com.ihk.utils.CommonPojoUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.log.CompareUtils;
import com.ihk.utils.request.HttpRequestUtils;
import com.ihk.utils.saleunit.MyPropertyUtils;

/**
 * 单元操作日记记录
 * @author xushaojia
 *
 */
public class ConfirmBookLogService {
	//TODO 未写日记的记录service
	public void addActionLog() throws Exception {
		ConfirmBook nowBook = (ConfirmBook) HttpRequestUtils.getRequest().getAttribute("confirmBook");
		Log bookLog = new Log();
		CompareUtils.initPojoCommonFiled(bookLog);
		bookLog.setOperationProcedure("新建临定");
		bookLog.setUnitId(nowBook.getUnitId());
		return ;
	}
	
	/**
	 * 单元临定信息修改日志
	 * @return
	 * @throws Exception 
	 */
	public String updateActionLog() throws Exception{
		ConfirmBook nowBook = (ConfirmBook) HttpRequestUtils.getRequest().getAttribute("confirmBook");
		if(nowBook==null){
			return null;
		}
		ConfirmBook lastBook = MyPropertyUtils.getConfirmBookServices().findConfirmBookById(nowBook.getId());
		
		Map<String, String> changeMap = this.compare(nowBook, lastBook);
		StringBuffer change = new StringBuffer();
		Set<Entry<String, String>>  set =  changeMap.entrySet();
		for (Entry<String, String> entry : set) {
			change.append(entry.getKey()+":"+entry.getValue()+";");
		}
		Log bookLog = new Log();
		CompareUtils.initPojoCommonFiled(bookLog);
		bookLog.setUnitId(nowBook.getUnitId());
		bookLog.setOperationProcedure(change.toString());
		return null;
	}
	
	/**
	 * 增加挞定的记录
	 * @return
	 * @throws Exception 
	 */
	public void addTartActionLog() throws Exception {
		Tart tart = (Tart)HttpRequestUtils.getRequest().getAttribute("tart");
		Log bookLog = new Log();
		CompareUtils.initPojoCommonFiled(bookLog);
		bookLog.setOperationProcedure("新建挞定");
		bookLog.setUnitId(tart.getUnitId());
		return;
	}
	
	/**
	 * 撤销挞定的记录
	 * @throws Exception 
	 */
	public void deleteTartActionLog() throws Exception{
		int recordId = (Integer)HttpRequestUtils.getRequest().getAttribute("recordId");
		UnitOperRecord unitOperRecord=MyPropertyUtils.getUnitOperRecordServices().findUnitOperRecordById(recordId);
		Log bookLog = new Log();
		CompareUtils.initPojoCommonFiled(bookLog);
		bookLog.setOperationProcedure("撤销挞定");
		bookLog.setUnitId(unitOperRecord.getUnitId());
		return;
	}
	/**
	 * 比较新旧数据，得到更改的项目
	 * @param nowBook
	 * @param lastBook
	 * @return
	 */
	private Map<String, String> compare(ConfirmBook nowBook,ConfirmBook lastBook){
		Map<String, String> changeMap = new HashMap<String, String>();
		String nowCustomerId = (String)HttpRequestUtils.getRequest().getParameter("customerId");
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
		if( endDateChange!=null){
			changeMap.put("失效日期更改", endDateChange);
		}
		
		System.out.println();
		return changeMap;
	}
	
	/**
	 * 增加成交的记录
	 * @throws Exception 
	 */
	public void addConfirm() throws Exception {
		Confirm confirm = (Confirm) HttpRequestUtils.getRequest().getAttribute("confirm");
		Log bookLog = new Log();
		CompareUtils.initPojoCommonFiled(bookLog);
		bookLog.setOperationProcedure("新建成交");
		bookLog.setUnitId(confirm.getUnitId());
		return ;
	}
	
	
	/**
	 * 修改成交信息的记录
	 * @throws Exception 
	 */
	public void updateConfirm() throws Exception{
		Confirm nowConfirm = (Confirm) HttpRequestUtils.getRequest().getAttribute("confirm");
		Confirm lastConfirm = MyPropertyUtils.getConfirmServices().findConfirmById(nowConfirm.getId());
		
		String nowCustomerId = (String)HttpRequestUtils.getRequest().getParameter("customerId"); //得到表单提交的新客户
		
		nowCustomerId = nowCustomerId.substring(0, nowCustomerId.length()-1);
		//表单的unit
		PropertyUnit unit =  (PropertyUnit) HttpRequestUtils.getRequest().getAttribute("unit");
		
		Map<String, String> changes = new HashMap<String, String>();
		//销售人员
		if(!lastConfirm.getSalesId().equals(nowConfirm.getSalesId())){
			String salesChange = CompareUtils.compareSalesId(lastConfirm.getSalesId(), nowConfirm.getSalesId());
			changes.put("销售人员变动",salesChange);
		}
		//销售客户
		if(!lastConfirm.getCustomerIds().equals(nowCustomerId)){
			String last = lastConfirm.getCustomerIds();
			String customerChange  = CompareUtils.compareCustomerId(last, nowCustomerId);
			changes.put("销售客户变更", customerChange);
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
			changes.put("套内面积变动:", unitInsidAreaChange);
		}
		//付款方式
		String payTypeChange =  CompareUtils.comparePayType(lastConfirm.getPayWayId(), nowConfirm.getPayWayId(), lastConfirm.getUnitId());
		if(payTypeChange!=null)
			
			changes.put("付款方式变动:", payTypeChange);
		
		//成交总价
		String sumMoneyChange = CompareUtils.equals(lastConfirm.getSumMoney(), nowConfirm.getSumMoney());
		if(!"".equals(sumMoneyChange))
			changes.put("成交总价变动:", sumMoneyChange);
		//认购书编号
		String agreeNoChange = CompareUtils.equals(lastConfirm.getAgreeNo(), nowConfirm.getAgreeNo());
		if(!"".equals(agreeNoChange))
			changes.put("认购书编号变动:", agreeNoChange);
		//认购日期
		String workDateChange = CompareUtils.equals(lastConfirm.getWorkDate(), nowConfirm.getWorkDate());
		if(!"".equals(workDateChange))
			changes.put("认购书日期变动:", workDateChange);
		//关系户
		String isRelationChange = CompareUtils.compareIsRelation(lastConfirm.getIsRelation(), nowConfirm.getIsRelation());
		if(isRelationChange!=null)
			changes.put("是否关系户变动:", isRelationChange);
		//一二手联动
		String isSecondLinkageChange = CompareUtils.compareIsRelation(lastConfirm.getIsSecondLinkage(), nowConfirm.getIsSecondLinkage());
		if(isSecondLinkageChange!=null)
			changes.put("一二手联动变动:", isSecondLinkageChange);
		//备注
		String remarkChange = CompareUtils.equals(lastConfirm.getRemark(), nowConfirm.getRemark());
		if(!"".equals(remarkChange))
			changes.put("备注变动:", remarkChange);
		
		Log bookLog = new Log();
		CompareUtils.initPojoCommonFiled(bookLog);
		bookLog.setUnitId(nowConfirm.getUnitId());
		bookLog.setOperationProcedure(CompareUtils.createChange(changes));
		return ;
	}

	/**
	 * 新建退房
	 * @throws Exception
	 */
	public void addCancelUnit() throws Exception {
		
		int unitId = (Integer)HttpRequestUtils.getRequest().getAttribute("unitId");
		Log bookLog = new Log();
		CommonPojoUtils.initPojoCommonFiled(bookLog);
		bookLog.setOperationProcedure("新建退房");
		bookLog.setType("新建");
		bookLog.setUnitId(unitId);
		return;
		
	}
	
	public void deleteCancelUnit() throws Exception{
		int recordId =  (Integer)HttpRequestUtils.getRequest().getAttribute("recordId");
		int unitId = MyPropertyUtils.getUnitOperRecordServices().findUnitOperRecordById(recordId).getUnitId();
		
		Log bookLog = new Log();
		CommonPojoUtils.initPojoCommonFiled(bookLog);
		bookLog.setOperationProcedure("撤销退房");
		bookLog.setType("撤销");
		bookLog.setUnitId(unitId);
	}
}
