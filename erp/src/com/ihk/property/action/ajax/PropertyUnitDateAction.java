package com.ihk.property.action.ajax;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ihk.utils.saleunitnew.PropertyTreeUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.ContUnitSaleState;
import com.ihk.constanttype.EnumSelectTypeSessionKey;
import com.ihk.property.data.pojo.PropertyBuild;
import com.ihk.property.data.pojo.PropertyBuildCond;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.pojo.PropertyUnitCond;
import com.ihk.property.data.services.IPropertyBuildServices;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.saleunit.data.pojo.Confirm;
import com.ihk.saleunit.data.pojo.Contract;
import com.ihk.utils.DescUtils;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;


/**
 * 查询unit数据
 * 使用easyui ajax方式
 * */
public class PropertyUnitDateAction  extends SupperAction{
	
	private static final long serialVersionUID = 1L;
	
	@Autowired IPropertyUnitServices propertyUnitServices;
	@Autowired IPropertyBuildServices propertyBuildServices;
	private JSONObject result;
	private PropertyUnitCond unitCond;
	
	private int rows;
	private int page;
	
	public String search(){
		
		if(unitCond == null)return "suc";
		List<PropertyUnit> unitList = new ArrayList<PropertyUnit>();
		
		if(unitCond.getUnitNo() != null)unitCond.setUnitNo( unitCond.getUnitNo().trim());

        unitCond.setCompanyProjectId(PropertyTreeUtils.getLeftTreeProjectIdSession(request));

		int count = propertyUnitServices.searchPropertyUnitCount(unitCond);
		unitCond.pageSize = rows;
		unitCond.startLine = (page - 1) * rows;
		unitList = this.propertyUnitServices.searchPropertyUnitPage(unitCond);
		
		JSONArray proJsList = new JSONArray();
		JSONObject onePro = new JSONObject();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for(PropertyUnit cc : unitList){
            cc.setId(cc.getUnitId());
			if(! cc.getSaleState().equals(ContUnitSaleState.SALE_ABLE)){
                //非可售
				Contract contract = cc.getContract();
				Confirm confirm = cc.getConfirm();
				if(contract != null){

					onePro.put("customerName",contract.getCustomerName());
					onePro.put("saleSumPrice", contract.getSalePrice());
					onePro.put("saleUser", contract.getSalesName());
				}else if( confirm != null){

					onePro.put("customerName",confirm.getCustomerName());
					onePro.put("saleSumPrice", confirm.getSalePrice());
					onePro.put("saleUser", confirm.getSalesName());
				}

		    } else {
                onePro.put("customerName","");
                onePro.put("saleSumPrice", "");
                onePro.put("saleUser", "");
            }
            onePro.put("saleDate", cc.getConfirmDate());
			onePro.put("id", cc.getId());
			onePro.put("unitid", cc.getId());
			onePro.put("unitNo", cc.getUnitTreeName());
			onePro.put("saleState", cc.getSaleStateStr());
			onePro.put("payName", cc.getPayName());

			onePro.put("buildArea", cc.getBuildArea());
			onePro.put("ConfirmContractCreateOrShowHref", cc.getConfirmContractCreateOrShowHref());
			proJsList.add(onePro);
		}
		Map<String, Object> json = new HashMap<String, Object>();
		json.put("total", count);// total键 存放总记录数，必须的
		json.put("rows", proJsList);// rows键 存放每页记录 list
		result = JSONObject.fromObject(json);// 格式化result一定要是JSONObject
		return "suc";
	}
	
	
	public String index(){
		init();
		return "suc";
	}
	
	private Map buildList;
	private Map saleStateList;
	private void init(){
		
		String key = EnumSelectTypeSessionKey.Appoint.getValue();
		int proId = (Integer)request.getSession().getAttribute(key);
		
		PropertyBuildCond buildCond = new PropertyBuildCond();
		buildCond.setCompanyProjectId(proId);
		List<PropertyBuild> listBuild = propertyBuildServices.findPropertyBuild(buildCond);
		
		buildList = new HashMap<String, String>();
		for(PropertyBuild b : listBuild){
			buildList.put(b.getId(),DescUtils.findPropertyProject(b.getPropertyId()).getPropertyName() + " - "+
					DescUtils.getPropertyAreaServices().findPropertyAreaById(b.getAreaId()).getAreaName() +" - " + b.getBuildName());
		}
		
		saleStateList = ContUnitSaleState.getSaleState();
	}

	public Map getSaleStateList() {
		return saleStateList;
	}

	public void setSaleStateList(Map saleStateList) {
		this.saleStateList = saleStateList;
	}

	public Map getBuildList() {
		return buildList;
	}

	public void setBuildList(Map buildList) {
		this.buildList = buildList;
	}

	public JSONObject getResult() {
		return result;
	}

	public void setResult(JSONObject result) {
		this.result = result;
	}


	public PropertyUnitCond getUnitCond() {
		return unitCond;
	}

	public void setUnitCond(PropertyUnitCond unitCond) {
		this.unitCond = unitCond;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
	
}
