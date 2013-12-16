package com.ihk.customer.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.constanttype.EnumPrivCode;
import com.ihk.customer.data.pojo.Customer;
import com.ihk.customer.data.services.ICustomerServices;
import com.ihk.permission.PermissionUtils;
import com.ihk.property.data.pojo.PropertyUnitCond;
import com.ihk.saleunit.data.pojo.ContractCustomer;
import com.ihk.saleunit.data.pojo.ContractCustomerCond;
import com.ihk.saleunit.data.services.IContractCustomerServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.SupperAction;

public class CjkhbjReportAction extends SupperAction {

	/**
	 * 根据售后客户表contract_customer取得客户相关信息
	 */
	@Autowired
	private IContractCustomerServices contractCustomerServices;
	@Autowired
	private ICustomerServices customerServices;
	
	private JSONObject result; 
	
	public JSONObject getResult() {
		return result;
	}

	public void setResult(JSONObject result) {
		this.result = result;
	}
	
	public String cjkhbjFirst() throws Exception{
		
		initSearchDate();
		return "cjkhbjFirst";
	}

	public String cjkhbj() throws Exception {
		
		initSearchDate();
		return SUCCESS;
	}
	
	public String cjkhbjReport() throws Exception {
		
		try{
			String date1=request.getParameter("date1");
			String date2=request.getParameter("date2");
			String hiddenId=request.getParameter("hiddenId");
			JSONArray jsonArray = new JSONArray();
			JSONObject jsonobj = new JSONObject();
			contractCustomerCond=new ContractCustomerCond();
			contractCustomerCond.setDate1(date1);
			contractCustomerCond.setDate2(date2);
			List<Integer> list=new ArrayList<Integer>();
			for(String s:hiddenId.split(",")){
				if(s!=null&&!"".equals(s)){
					list.add(Integer.parseInt(s));
				}
			}
			if(list.size()!=0){
				contractCustomerCond.setSearchProjectIds(list);
			}
			List<ContractCustomer> ccList=contractCustomerServices.findContractCustomer(contractCustomerCond);
			String homeProvince="";
			String homeCity="";
			String homeRegion="";
			String workProvince="";
			String workCity="";
			String workRegion="";
			for(ContractCustomer cc:ccList){
				jsonobj.put("xs0", cc.getCustomerName());
				homeProvince=cc.getHomeProvinceStr()==null?"":cc.getHomeProvinceStr();
				homeCity=cc.getHomeCityStr()==null?"":cc.getHomeCityStr();
				homeRegion=cc.getHomeRegionStr()==null?"":cc.getHomeRegionStr();
				workProvince=cc.getWorkProvinceStr()==null?"":cc.getWorkProvinceStr();
				workCity=cc.getWorkCityStr()==null?"":cc.getWorkCityStr();
				workRegion=cc.getWorkRegionStr()==null?"":cc.getWorkRegionStr();
				jsonobj.put("xs1",homeProvince+homeCity+homeRegion);
				jsonobj.put("xs2", workProvince+workCity+workRegion);
				if(cc.getPreCustomerId()!=0){		//判断是否售前客户
					Customer customer=customerServices.getCustomerById(cc.getPreCustomerId());
					if(customer!=null){
						jsonobj.put("xs3", DescUtils.getCodeDesc(EnumCodeTypeName.BUY_USE, customer.getBuyUse(), customer.getProjectId()));
						jsonobj.put("xs4",DescUtils.getCodeDesc(EnumCodeTypeName.BUY_COUNT, customer.getBuyCount(), customer.getProjectId()) );
						jsonobj.put("xs5", DescUtils.getCodeDesc(EnumCodeTypeName.HOUSE_TYPE, customer.getHouseType(), customer.getProjectId()));
						jsonobj.put("xs6", DescUtils.getCodeDesc(EnumCodeTypeName.CUSTOMER_SOURCE, customer.getCustomerSource(), customer.getProjectId()));
					}
				}
				
				jsonArray.add(jsonobj);
			}
			
			
			Map<String, Object> json = new HashMap<String, Object>();
			json.put("total", 1);// total键 存放总记录数，必须的
			json.put("rows", jsonArray);// rows键 存放每页记录 list
			result = JSONObject.fromObject(json);// 格式化result一定要是JSONObject
		}catch(Exception e){
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	//客户成交表条件
	private ContractCustomerCond contractCustomerCond;
	private PropertyUnitCond propertyUnitCond;

	public ContractCustomerCond getContractCustomerCond() {
		return contractCustomerCond;
	}

	public void setContractCustomerCond(ContractCustomerCond contractCustomerCond) {
		this.contractCustomerCond = contractCustomerCond;
	}

	public PropertyUnitCond getPropertyUnitCond() {
		return propertyUnitCond;
	}

	public void setPropertyUnitCond(PropertyUnitCond propertyUnitCond) {
		this.propertyUnitCond = propertyUnitCond;
	}
	
	private void initSearchDate(){
		if (propertyUnitCond == null){
			propertyUnitCond = new PropertyUnitCond();
				
			propertyUnitCond.addPermissionCompanyProjectIds(PermissionUtils.getUserProjectIdList(EnumPrivCode.REPORT_SALEUNIT_STAT));			
			propertyUnitCond.setSearchCompanyProjectIds(propertyUnitCond.getPrivCompanyProjectIds());
		}else if(propertyUnitCond.getPrivCompanyProjectIds()==null){
			propertyUnitCond.addPermissionCompanyProjectIds(PermissionUtils.getUserProjectIdList(EnumPrivCode.REPORT_SALEUNIT_STAT));
		}
		if(contractCustomerCond == null){
			contractCustomerCond = new ContractCustomerCond();
		
			contractCustomerCond.setDate1(CommonUtils.getMonthFirstForString());
			contractCustomerCond.setDate2(CommonUtils.getMonthEndForString());
		}
		contractCustomerCond.setSearchProjectIds(propertyUnitCond.getSearchCompanyProjectIds());
	}
}
