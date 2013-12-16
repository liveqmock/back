package com.ihk.saleunit.action.tempconfirm;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

import com.ihk.constanttype.ContConfirmType;
import com.ihk.constanttype.ContUnitSaleState;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.saleunit.data.pojo.ConfirmBook;
import com.ihk.saleunit.data.services.IConfirmBookServices;
import com.ihk.saleunit.data.services.IContractCustomerServices;
import com.ihk.utils.ActionTemplate;
import com.ihk.utils.CommonPojoUtils;
import com.ihk.utils.SupperAction;
import com.ihk.utils.contract.customer.ContractCustomerUtils;
import com.ihk.utils.method.ActionAjaxMethodModifyCallback;
import com.ihk.utils.saleunit.PayWayUtils;
import com.ihk.utils.saleunit.UnitSaleStateUtils;

/**
 * 基于easyui的临定
 * @author dtc
 * 2013-5-16,上午11:03:17
 */
public class EasyuiConfirmBookAction extends SupperAction{

	private static final long serialVersionUID = 8275226429684581983L;
	
	@Autowired
	IPropertyUnitServices unitServices;
	@Autowired
	IConfirmBookServices confirmBookServices;
	@Autowired
	IContractCustomerServices contractCustomerServices;
	
	/**
	 * 跳到新建页面
	 * @return
	 * @throws Exception
	 */
	public String toCreateConfirmBookDialog() throws Exception{
		
		int unitId = Integer.parseInt(request.getParameter("unitId"));
		
		init(unitId);
		
		return "toCreateConfirmBookDialog";
	}
	
	/**
	 * 新增临定
	 * @return
	 * @throws Exception
	 */
	public String addConfirmBook() throws Exception{
		
		ActionTemplate.executeAjaxMethod(true, this, new ActionAjaxMethodModifyCallback() {
			
			@Override
			public void modifyMethod() throws Exception {
				
				//保存临定
				CommonPojoUtils.initPojoCommonFiled(confirmBook);
				confirmBookServices.addConfirmBook(confirmBook);
				
				//设置客户mainId
				String customerId = request.getParameter("customerId");
				ContractCustomerUtils.setUpContractCustomerMainId(customerId, confirmBook.getId());
				
				//修改单元状态
				UnitSaleStateUtils.changeSaleState(unitServices, confirmBook.getUnitId(), ContUnitSaleState.CONFIRM_BOOK);
			}
			
			@Override
			public void modifyMethodException(Exception e) {
				
			}
			
		});
		
		return null;
	}
	
	/**
	 * 跳到查看修改页面
	 * @return
	 * @throws Exception
	 */
	public String toShowConfirmBookDialog() throws Exception{
		
		int confirmBookId = Integer.parseInt(request.getParameter("confirmBookId"));
		
		confirmBook = confirmBookServices.findConfirmBookById(confirmBookId);
		
		init(confirmBook.getUnitId());
		
		return "toShowConfirmBookDialog";
	}
	
	/**
	 * 修改临定
	 * @return
	 * @throws Exception
	 */
	public String updateConfirmBook() throws Exception{
		
		ActionTemplate.executeAjaxMethod(this, new ActionAjaxMethodModifyCallback() {
			
			@Override
			public void modifyMethod() throws Exception {
				
				ConfirmBook oldBook = confirmBookServices.findConfirmBookById(confirmBook.getId());
				
				CommonPojoUtils.initPojoForUpdate(oldBook, confirmBook);
				
				confirmBookServices.updateConfirmBook(confirmBook);
				
				String[] oldCustomerId = confirmBook.getCustomerIds().split(",");
				
				String[] nowCustomerId = request.getParameter("customerId").split(",");
				
				List<Integer> oldIdList = new ArrayList<Integer>();
				
				for (int i = 0; i < oldCustomerId.length; i++) {
					if(!"".equals(oldCustomerId[i])){
						oldIdList.add(Integer.parseInt(oldCustomerId[i]));
					}
				}
				
				List<Integer> nowIdList = new ArrayList<Integer>();
				
				for (int i = 0; i < nowCustomerId.length; i++) {
					if(!"".equals(nowCustomerId[i])){
						nowIdList.add(Integer.parseInt(nowCustomerId[i]));
					}
				}
				
				List<Integer> noChange = new ArrayList<Integer>();
				
				noChange.addAll(oldIdList);//复制
				
				noChange.retainAll(nowIdList);//差集
				
				oldIdList.removeAll(noChange);//删除
				
				nowIdList.removeAll(noChange);//新增
				
				StringBuffer addCustomerId = new StringBuffer(",");
				for (Integer i : nowIdList) {
					addCustomerId.append(i+",");
				}
				for (Integer i : oldIdList) {
					contractCustomerServices.deleteContractCustomer(i);
				}
				
				ContractCustomerUtils.setUpContractCustomerMainId(addCustomerId.toString(), confirmBook.getId());

			}
			
			@Override
			public void modifyMethodException(Exception e) {
				
			}
			
		});
		
		return null;
	}
	
	/**
	 * 一些初始化
	 * @param unitId
	 */
	private void init(int unitId){
		
		confirmType = ContConfirmType.CONFIRM_BOOK;
		
		unit = unitServices.findPropertyUnitById(unitId);
		selPayType = PayWayUtils.getSelPayWayByUnitId(unitId);
		
	}
	
	////
	
	/**
	 * 临定
	 */
	private ConfirmBook confirmBook;
	
	private PropertyUnit unit;
	
	/**
	 * 付款方式(根据楼栋,从表pay_way中获取)
	 */
	private LinkedHashMap<String, String> selPayType;
	
	/**
	 * 成交客户类型,从ContConfirmType.java中获取
	 */
	private String confirmType;
	
	public void setConfirmType(String confirmType) {
		this.confirmType = confirmType;
	}
	
	public String getConfirmType() {
		return confirmType;
	}
	
	public void setConfirmBook(ConfirmBook confirmBook) {
		this.confirmBook = confirmBook;
	}
	
	public ConfirmBook getConfirmBook() {
		return confirmBook;
	}
	
	public void setSelPayType(LinkedHashMap<String, String> selPayType) {
		this.selPayType = selPayType;
	}
	
	public LinkedHashMap<String, String> getSelPayType() {
		return selPayType;
	}
	
	public void setUnit(PropertyUnit unit) {
		this.unit = unit;
	}
	
	public PropertyUnit getUnit() {
		return unit;
	}

}
