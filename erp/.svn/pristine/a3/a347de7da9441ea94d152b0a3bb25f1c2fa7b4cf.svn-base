package com.ihk.demo.action.easyui;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.property.data.pojo.PropertyBuild;
import com.ihk.property.data.pojo.PropertyGroup;
import com.ihk.property.data.services.IPropertyBuildServices;
import com.ihk.property.data.services.IPropertyGroupServices;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.saleunit.data.pojo.Chip;
import com.ihk.saleunit.data.pojo.PayBill;
import com.ihk.saleunit.data.pojo.PayBillCond;
import com.ihk.saleunit.data.services.IChipServices;
import com.ihk.saleunit.data.services.IContractCustomerServices;
import com.ihk.saleunit.data.services.IPayBillServices;
import com.ihk.utils.AJAXBeanUtils;
import com.ihk.utils.AJAXUtils;
import com.ihk.utils.ActionPageCallback;
import com.ihk.utils.ActionTemplate;
import com.ihk.utils.CommonPojoUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.MyTransationTemplate;
import com.ihk.utils.SupperAction;
import com.ihk.utils.chip.ChipManagerUtils;
import com.ihk.utils.chip.ChipTypeUtils;
import com.ihk.utils.saleunitnew.DefaultFromPropertyUtils;

/**
 * 增删改查的基本用法
 * 
 */
@SuppressWarnings("rawtypes")
public class SearchPayBillAction extends SupperAction {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	IPayBillServices payBillServices;  
    
	private PayBillCond searchPayBillCond;  
    
	public PayBillCond getSearchPayBillCond() {
		return searchPayBillCond;
	}

	public void setSearchPayBillCond(PayBillCond searchPayBillCond) {
		this.searchPayBillCond = searchPayBillCond;
	}
    
	private List<PayBill> searchListPayBill;
    
	public List<PayBill> getSearchListPayBill() {		
		return searchListPayBill;
	}

	public void setSearchListPayBillList(List<PayBill> searchListPayBill) {
		this.searchListPayBill = searchListPayBill;
	}
      
    //新建页面用于保存页面数据的对象
	private PayBill createPayBill;  
    
	public PayBill getCreatePayBill() {
		return createPayBill;
	}

	public void setCreatePayBill(PayBill createPayBill) {
		this.createPayBill = createPayBill;
	}
      
	
    //编辑页面用于保存页面数据的对象
	private PayBill editPayBill;  
    
	public PayBill getEditPayBill() {
		return editPayBill;
	}

	public void setEditPayBill(PayBill editPayBill) {
		this.editPayBill = editPayBill;
	}
		
    /**
    * 执行查询
    */
	public String searchPayBill() throws Exception{		
		
		if(searchPayBillCond == null){ 
			searchPayBillCond = new PayBillCond();	

//			searchpayBillCond.setDate1(CommonUtils.getMonthFirstForString());
//			searchpayBillCond.setDate2(CommonUtils.getMonthEndForString());
		}
		
		ActionTemplate actionTemplate = new ActionTemplate(this, searchPayBillCond);
		actionTemplate.executePage(new ActionPageCallback() {
		
			@Override
			public void initActionPageList() {

				searchListPayBill = payBillServices.findPayBillPage(searchPayBillCond);	
			}
			
		}, 20);
		
		
		return "finish";
	}
	
	/**
	 * ajax新增付款单
	 * @return
	 * @throws Exception
	 */
	public String ajaxCreatePayBill() throws Exception{
		
        //信息提示
		final Map<String, String> mapMassage = new HashMap<String, String>();
		
		try{			
			new MyTransationTemplate() {
				
				@Override
				protected void doExecuteCallback() throws Exception {
					//新增前的一些数据处理			
                    
					//预处理表中的创建人信息
					CommonPojoUtils.initPojoCommonFiled(createPayBill);
										
					payBillServices.addPayBill(createPayBill);
					
					mapMassage.put("type", "true");
					
				}
			}.execute();
			
		}catch(Exception e){
			
			mapMassage.put("type", "false");
			mapMassage.put("message", e.getMessage());
			e.printStackTrace();
		}
		
		CustomerUtils.writeResponse(response, CommonUtils.getMapJson(mapMassage));
		
		return null;
	}
    
    
	/**
	 * 取得PayBill用于编辑页面 的ajax
	 * @return
	 * @throws Exception
	 */
	public String ajaxGetPayBillById() throws Exception{
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		editPayBill = payBillServices.findPayBillById(id); 
		
		if(editPayBill == null){		
			AJAXUtils.writeResponse(response, "");
		}
		else{
			//输出json数据
			AJAXUtils.writeResponse(response, AJAXBeanUtils.getJsonPayBill(editPayBill));
		}
		
		return null; 
	}
    
    
	/**
	 * 修改付款单ajax方法
	 * @return
	 * @throws Exception
	 */
	public String ajaxUpdatePayBill() throws Exception{
		
		final Map<String, String> mapMessage = new HashMap<String, String>();
		
		try{
			
			new MyTransationTemplate() {
				
				@Override
				protected void doExecuteCallback() throws Exception {
					
					PayBill oldPayBill = payBillServices.findPayBillById(editPayBill.getId());
					
					CommonPojoUtils.initPojoForUpdate(oldPayBill, editPayBill);					

                    
					//editPayBill.setChipNo(oldChip.getChipNo());
					//editPayBill.setChipType(oldChip.getChipType());					
	
					payBillServices.updatePayBill(editPayBill);
					
					mapMessage.put("type", "true");
					
				}
			}.execute();
			
		}catch(Exception e){
			
			mapMessage.put("type", "false");
			mapMessage.put("message", e.getMessage());
			e.printStackTrace();
		}
		
		CustomerUtils.writeResponse(response, CommonUtils.getMapJson(mapMessage));
		
		return null;
	}
	
}
