package com.ihk.setup.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.property.data.pojo.PayWayDiscount;
import com.ihk.property.data.services.IPayWayDiscountServices;
import com.ihk.utils.CommonPojoUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.MyTransationTemplate;
import com.ihk.utils.SupperAction;
import com.ihk.utils.saleunitnew.DiscountManagerUtils;

/**
 * 设置付款方式的折扣
 * @author dtc
 * 2012-10-25,下午04:53:54
 */
@SuppressWarnings("unchecked")
public class PayWayDiscountAction extends SupperAction{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	IPayWayDiscountServices payWayDiscountServices;
	
	/**
	 * 付款方式折扣
	 * @return
	 * @throws Exception
	 */
	public String forDiscountModify() throws Exception{
		
		payWayId = request.getParameter("payWayId");
		init(payWayId);
		
		removeSuggestion();
		
		return "forDiscountModify";
	}
	
	/**
	 * 获取pay_way_discount(付款方式折扣)的table map String
	 * @return
	 * @throws Exception
	 */
	public String ajaxPayWayDiscountList() throws Exception{
		
		payWayId = request.getParameter("payWayId");
		
		payWayDiscountList = payWayDiscountServices.findPayWayDiscountByPayWayId(Integer.parseInt(payWayId));
		
		String out = DiscountManagerUtils.payWayDiscountListJson(payWayDiscountList);
		
		CustomerUtils.writeResponse(response, out);
		
		return null;
	}
	
	public String discountModify() throws Exception{
		
		try{
			new MyTransationTemplate() {
				
				@Override
				protected void doExecuteCallback() throws Exception {
					
					String someDetail = request.getParameter("someDetail");
					
					payWayId = request.getParameter("payWayId");
					
					payWayDiscountServices.deletePayWayDiscountByPayWayId(Integer.parseInt(payWayId));
					
					if(!CommonUtils.isStrEmpty(someDetail)){
						
						List<PayWayDiscount> tmpList = initForAddDiscountDetail(someDetail, Integer.parseInt(payWayId));
						for(PayWayDiscount detail : tmpList){
							
							payWayDiscountServices.addPayWayDiscount(detail);
						}
						
					}
					
					setSuggestion_Success();
					setUpMarkToClose();
					
				}
			}.execute();
			
		}catch (Exception e) {
			setSuggestion_Fail();
		}
		
		init(payWayId);
		
		return "discountModify";
	}
	
	private void init(String payWayId){
		
		url = "./saleunit_setup/payway/ajaxPayWayDiscountList.action?payWayId=" + payWayId;
		
		selTypes = DescUtils.getInitSelForGuangZhou(selTypes, EnumCodeTypeName.SALEUNIT_DISCOUNT_TYPE);
		types = CommonUtils.getMapJsonSetUpKeyAndValueName(selTypes, "typeId", "name");
		
	}
	
	private List<PayWayDiscount> initForAddDiscountDetail(String someDetail, int payWayId) throws Exception{
		//typeId1=3&percent1=99&remark1=&typeId2=4&percent2=97&remark2=&detailCount=2
		
		Map<String, String> map = new HashMap<String, String>();
		
		String[] details = someDetail.split("&");
		for(String detail : details){
			
			String[] tmp = detail.split("=");
			try{
				
				map.put(tmp[0], tmp[1]);
			}catch(Exception e){
				
				map.put(tmp[0], "");
			}
		}
		
		List<PayWayDiscount> retList = new ArrayList<PayWayDiscount>();
		int beanCount = Integer.parseInt(map.get("detailCount"));
		
		for(int i=1; i<=beanCount; i++){
			
			PayWayDiscount tmpDetail = new PayWayDiscount();
			
			String typeId = map.get("typeId" + i);
			String percent = map.get("percent" + i);
			String remark = map.get("remark" + i);
			
			if(CommonUtils.isStrEmpty(typeId) && CommonUtils.isStrEmpty(percent) && CommonUtils.isStrEmpty(remark))
				continue;
			
			tmpDetail.setPayWayId(payWayId);
			tmpDetail.setDiscountType(typeId);
			tmpDetail.setDiscountPercent(CommonUtils.exceptionToZero(percent));
			tmpDetail.setRemark(remark);
			
			CommonPojoUtils.initPojoCommonFiled(tmpDetail);
			
			retList.add(tmpDetail);
			
		}
		
		return retList;
	}
	
	//
	private String types; //类型
	private LinkedHashMap<String, String> selTypes;
	
	private String url; //加载pay_way_discount付款方式折扣的详细url
	
	private List<PayWayDiscount> payWayDiscountList;
	
	private String payWayId;
	
	public void setPayWayId(String payWayId) {
		this.payWayId = payWayId;
	}
	
	public String getPayWayId() {
		return payWayId;
	}
	
	public void setPayWayDiscountList(List<PayWayDiscount> payWayDiscountList) {
		this.payWayDiscountList = payWayDiscountList;
	}
	
	public List<PayWayDiscount> getPayWayDiscountList() {
		return payWayDiscountList;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getUrl() {
		return url;
	}

	public String getTypes() {
		return types;
	}
	
	public void setTypes(String types) {
		this.types = types;
	}
	
	public LinkedHashMap<String, String> getSelTypes() {
		return selTypes;
	}
	
	public void setSelTypes(LinkedHashMap<String, String> selTypes) {
		this.selTypes = selTypes;
	}
	
	

}
