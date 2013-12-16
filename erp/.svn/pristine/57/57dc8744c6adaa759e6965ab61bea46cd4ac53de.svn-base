package com.ihk.saleunit.action.contract_unit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.ContUnitSaleState;
import com.ihk.property.data.pojo.PropertyBuild;
import com.ihk.property.data.pojo.PropertyBuildCond;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.pojo.PropertyUnitCond;
import com.ihk.property.data.services.IPropertyBuildServices;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.utils.ActionAjaxPageCallback;
import com.ihk.utils.ActionTemplate;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;
import com.ihk.utils.contract.customer.ContractCustomerUtils;
import com.ihk.utils.contract.unit.ContractDetailUtils;
import com.ihk.utils.saleunitnew.PropertyUnitUtils;

/**
 * 明细action
 * @author dtc
 * 2013-1-9,下午04:21:35
 */
public class DetailManagerAction extends SupperAction{

	private static final long serialVersionUID = 1L;
	
	@Autowired 
	IPropertyBuildServices propertyBuildServices;
	@Autowired
	IPropertyUnitServices propertyUnitServices;
	
	/**
	 * 初始化明细tabs
	 * @return
	 * @throws Exception
	 */
	public String toDetailTabs() throws Exception{
		
		String type = request.getParameter("type");
		
		if(CommonUtils.isStrEmpty(type)){
			//表示没有选择tree
			/*int proId = SessionUser.getProjectId();
			PropertyBuildCond buildCond = new PropertyBuildCond();
			buildCond.setCompanyProjectId(proId);
			List<PropertyBuild> tmpList = propertyBuildServices.findPropertyBuild(buildCond);*/
			
			buildMap = PropertyUnitUtils.buildListToMap(null);

		}else{
			
			List<PropertyBuild> tmpList = ContractCustomerUtils.getBuildListByRequest(request);
			
			buildMap = PropertyUnitUtils.buildListToMap(tmpList);

		}
        if(buildMap.size()==2) buildMap.remove("");

		saleMap = ContUnitSaleState.getContractState();
		
		return "toDetailTabs";
	}
	
	/**
	 * 明细table
	 * @return
	 * @throws Exception
	 */
	public String unitDetailAjaxTable() throws Exception{
		
		if(cond == null){
			cond = new PropertyUnitCond();
		}
		
		cond.setBuildIds(CommonUtils.stringToList(request.getParameter("buildId")));
		
		ActionTemplate.executeAjaxPage(this, cond, new ActionAjaxPageCallback() {
			
			@Override
			public int initTotal() {
				
				if(CommonUtils.isCollectionEmpty(cond.getBuildIds())){
					
					return 0;
				}
				
				return propertyUnitServices.findPropertyUnitCountForAjax(cond);
			}
			
			@Override
			public List<Map<String, String>> initRows() {
				
				List<Map<String, String>> retList = new ArrayList<Map<String,String>>();
				
				if(CommonUtils.isCollectionEmpty(cond.getBuildIds())){
					
					return retList;
				}
				
				List<PropertyUnit> unitList = propertyUnitServices.findPropertyUnitForAjax(cond);
				
				if(!CommonUtils.isCollectionEmpty(unitList)){
					
					Map<String, String> map = null;
					
					for(PropertyUnit unit : unitList){
						
						map = new HashMap<String, String>();
						
						map.put("id", unit.getId() + ""); //单元id
						
						map.put("unitNo", unit.getUnitNo()); //房间号
						map.put("allName", unit.getAllName()); //房间全名
						map.put("saleState", unit.getSaleStateStr()); //房间状态
						
						map.put("buildArea", unit.getBuildArea() == null ? "0" : unit.getBuildArea().toString()); //建筑面积
						
						map.put("buildPrice", ContractDetailUtils.getBuildPrice(unit)); //buildPrice 销售单价,从对应的成交或合同单中获取,否则为空
						map.put("sumMoney", ContractDetailUtils.getSumMoney(unit)); //sumMoney 销售总价,从对应的成交或合同单中获取,否则为空

                        map.put("shouldAmount", ContractDetailUtils.getShouldAmount(unit));
                        map.put("paymentAmount", ContractDetailUtils.getPaymentAmount(unit));
                        map.put("baseprice", unit.getBaseprice()==null?"-":unit.getBaseprice().toString());
                        map.put("totalBaseprice", unit.getTotalBaseprice()==null?"-":unit.getTotalBaseprice().toString());

						retList.add(map);
						
					}
				}
				
				return retList;
			}
		});
		
		return null;
	}
	
	
	////
	/**
	 * 楼栋
	 */
	private Map<String, String> buildMap;
	
	/**
	 * 单元状态
	 */
	private Map<String, String> saleMap;
	
	private PropertyUnitCond cond;
	
	public void setSaleMap(Map<String, String> saleMap) {
		this.saleMap = saleMap;
	}
	
	public Map<String, String> getSaleMap() {
		return saleMap;
	}
	
	public void setCond(PropertyUnitCond cond) {
		this.cond = cond;
	}
	
	public PropertyUnitCond getCond() {
		return cond;
	}
	
	public void setBuildMap(Map<String, String> buildMap) {
		this.buildMap = buildMap;
	}
	
	public Map<String, String> getBuildMap() {
		return buildMap;
	}
	
}
