package com.ihk.saleunit.action.contract_unit;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.property.data.pojo.PropertyProject;
import com.ihk.property.data.services.IPropertyProjectServices;
import com.ihk.saleunit.data.pojo.OtherExpenses;
import com.ihk.saleunit.data.pojo.OtherExpensesCond;
import com.ihk.saleunit.data.services.IOtherExpensesServices;
import com.ihk.utils.ActionAjaxPageByFooterCallback;
import com.ihk.utils.ActionMethodModifyUtils;
import com.ihk.utils.ActionTemplate;
import com.ihk.utils.CommonPojoUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.SupperAction;

/**
 * 其他费用
 * @author dtc
 * 2013-1-14,下午04:49:38
 */
public class OtherExpensesAction extends SupperAction{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	IOtherExpensesServices otherExpensesServices;
	@Autowired
	IPropertyProjectServices propertyProjectServices;
	
	/**
	 * 跳到列表页面
	 * @return
	 * @throws Exception
	 */
	public String toOtherExpensesTabs() throws Exception{
		
		//projectMap = PropertyProjectMapUtils.getMap(Integer.parseInt(request.getParameter("companyProjectId")));
		
		return "toOtherExpensesTabs";
	}
	
	/**
	 * 列表
	 * @return
	 * @throws Exception
	 */
	public String otherExpensesAjaxTable() throws Exception{
		
		if(cond == null){
			cond = new OtherExpensesCond();
		}
		
		//String propertyProjectId = request.getParameter("propertyProjectId");
		if(CommonUtils.isStrZeroEmpty(propertyProjectId)){
			cond.setProjectId(0);
		}else{
			cond.setProjectId(Integer.parseInt(propertyProjectId));
		}
		
		ActionTemplate.executeAjaxPage(this, cond, new ActionAjaxPageByFooterCallback() {
			
			@Override
			public int initTotal() throws Exception {
				
				return otherExpensesServices.findOtherExpensesCountForAjax(cond);
			}
			
			@Override
			public List<Map<String, Object>> initRows() throws Exception {
				
				List<Map<String, Object>> retList = new ArrayList<Map<String,Object>>();
				
				List<OtherExpenses> otherList = otherExpensesServices.findOtherExpensesForAjax(cond);
				
				if(!CommonUtils.isCollectionEmpty(otherList)){
					
					Map<String, Object> map = null;
					
					for(OtherExpenses other : otherList){
						
						map = new HashMap<String, Object>();
						
						map.put("id", other.getId() + "");
						
						map.put("propertyName", other.getPropertyName());
						
						map.put("enterTime", CustomerUtils.getDateString(other.getEnterTime()));
						map.put("expensesName", other.getExpensesName());
						
						map.put("expensesMoney", other.getExpensesMoney() == null ? "0" : other.getExpensesMoney().toString());
						
						map.put("remark", other.getRemark());
						
						map.put("oper", initOper(other));
						
						retList.add(map);
					}
				}
				
				return retList;
			}

			@Override
			public JSONArray initFootor(List<Map<String, Object>> rows)
					throws Exception {
				
				JSONArray retArr = new JSONArray();
				
				JSONObject json = new JSONObject();
				//expensesMoney
				
				json.put("expensesName", "该页合计");
				
				if(!CommonUtils.isCollectionEmpty(rows)){
					
					BigDecimal countMoney = new BigDecimal(0);
					for(Map<String, Object> row : rows){
						
						Object expensesMoney = row.get("expensesMoney");
						
						if(expensesMoney != null){
							countMoney = countMoney.add(new BigDecimal(expensesMoney.toString()));
						}
					}
					
					json.put("expensesMoney", countMoney.toString());
					retArr.add(json);
					
				}else{
					
					json.put("expensesMoney", "0");
					retArr.add(json);
				}
				
				return retArr;
			}
		});
		
		return null;
	}
	
	/**
	 * 跳到新增页面
	 * @return
	 * @throws Exception
	 */
	public String toAddOtherExpenses() throws Exception{
		
		project = propertyProjectServices.findPropertyProjectById(Integer.parseInt(request.getParameter("propertyProjectId")));
		
		return "toAddOtherExpenses";
	}
	
	/**
	 * 新增
	 * @return
	 * @throws Exception
	 */
	public String addOtherExpenses() throws Exception{
		
		return new ActionMethodModifyUtils() {
			
			@Override
			protected void modifyMethod() throws Exception {
				
				CommonPojoUtils.initPojoCommonFiled(other);
				
				otherExpensesServices.addOtherExpenses(other);
				
			}
		}.doModify(this);
		
	}
	
	/**
	 * 跳到编辑页面
	 * @return
	 * @throws Exception
	 */
	public String toModifyOtherExpenses() throws Exception{
		
		other = otherExpensesServices.findOtherExpensesById(Integer.parseInt(request.getParameter("otherId")));
		
		return "toModifyOtherExpenses";
	}
	
	/**
	 * 编辑
	 * @return
	 * @throws Exception
	 */
	public String modifyOtherExpenses() throws Exception{
		
		return new ActionMethodModifyUtils() {
			
			@Override
			protected void modifyMethod() throws Exception {
				
				OtherExpenses oldOther = otherExpensesServices.findOtherExpensesById(other.getId());
				CommonPojoUtils.initPojoForUpdate(oldOther, other);
				
				otherExpensesServices.updateOtherExpenses(other);
				
			}
		}.doModify(this);
	}
	
	/**
	 * 删除
	 * @return
	 * @throws Exception
	 */
	public String deleteOtherExpenses() throws Exception{
		
		return new ActionMethodModifyUtils() {
			
			@Override
			protected void modifyMethod() throws Exception {
				
				int otherId = Integer.parseInt(request.getParameter("otherId"));
				otherExpensesServices.deleteOtherExpenses(otherId);
				
			}
		}.doModify(this);
	}
	
	/**
	 * 初始化操作<a../>
	 * @return
	 */
	private String initOper(OtherExpenses other){
		
		StringBuffer href = new StringBuffer();
		
		//<a onclick="return createTempConfirmDialog('59343')" style="color:#1199FF; text-decoration:underline" href="javascript:void(0)">新建临订</a>
		
		href.append("<a onclick=\"return modifyOther('")
			.append(other.getId()).append("')\" ")
			.append("style='color:#1199FF; text-decoration:underline; padding:0 20px 0 0px' ")
			.append("href='javascript:void(0)'>编辑</a>")
			.append("<a onclick=\"return deleteOther('")
			.append(other.getId()).append("')\" ")
			.append("style='color:#1199FF; text-decoration:underline' ")
			.append("href='javascript:void(0)'>删除</a>")
			;
		
		return href.toString();
	}
	
	////
	
	/**
	 * 楼盘项目
	 */
	private Map<String, String> projectMap;
	
	private OtherExpensesCond cond;
	
	private PropertyProject project;
	
	private OtherExpenses other;
	
	private String propertyProjectId;
	
	public void setPropertyProjectId(String propertyProjectId) {
		this.propertyProjectId = propertyProjectId;
	}
	
	public String getPropertyProjectId() {
		return propertyProjectId;
	}
	
	public void setOther(OtherExpenses other) {
		this.other = other;
	}
	
	public OtherExpenses getOther() {
		return other;
	}
	
	public void setProject(PropertyProject project) {
		this.project = project;
	}
	
	public PropertyProject getProject() {
		return project;
	}
	
	public void setCond(OtherExpensesCond cond) {
		this.cond = cond;
	}
	
	public OtherExpensesCond getCond() {
		return cond;
	}
	
	public void setProjectMap(Map<String, String> projectMap) {
		this.projectMap = projectMap;
	}
	
	public Map<String, String> getProjectMap() {
		return projectMap;
	}

}
