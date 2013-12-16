package com.ihk.saleunit.action.new_report;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.ContConfirmType;
import com.ihk.constanttype.EnumPrivCode;
import com.ihk.customer.data.pojo.Customer;
import com.ihk.customer.data.pojo.CustomerCond;
import com.ihk.customer.data.services.ICustomerServices;
import com.ihk.permission.PermissionUtils;
import com.ihk.property.data.pojo.PropertyUnitCond;
import com.ihk.saleunit.data.pojo.ContractCustConfirm;
import com.ihk.saleunit.data.pojo.ContractCustomer;
import com.ihk.saleunit.data.pojo.ContractCustomerCond;
import com.ihk.saleunit.data.services.IConfirmServices;
import com.ihk.saleunit.data.services.IContractServices;
import com.ihk.user.data.services.ICompanyProjectServices;
import com.ihk.utils.ActionAjaxPageCallback;
import com.ihk.utils.ActionTemplate;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.ReportUtils;
import com.ihk.utils.SupperAction;
import com.ihk.utils.contract.customer.ContractCustomerUtils;

public class ZhongShanConfirmDetailAction extends SupperAction{
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	ICustomerServices customerServices;
	@Autowired
	IConfirmServices confirmServices;
	@Autowired
	IContractServices contractServices;
	@Autowired
	ICompanyProjectServices companyProjectServices;
	
	private final static String COND = "khcj_cond";
	
	private JSONObject result;
	
	public JSONObject getResult() {
		return result;
	}

	public void setResult(JSONObject result) {
		this.result = result;
	}

	/**
	 * 跳到jsp页面
	 * @return
	 * @throws Exception
	 */
	public String zhongshanConfirmDetail() throws Exception {
		//DEMO 例子 初始化查询条件,权限之类
		initSearchData();
		request.getSession().setAttribute(COND, customerCond);
		request.getSession().removeAttribute("projectDownloadCusList");
		return SUCCESS;
	}
	
	/**
	 * ajax action
	 * @return
	 * @throws Exception
	 */
	public String zhongshanConfirmDetailAjax() throws Exception{
		//DEMO 查找具体的封装方法例子
		ActionTemplate.executeAjaxPage(this,customerCond, new ActionAjaxPageCallback() {
			
			
			//获取总条数,返回0表示不分页
			@Override
			public int initTotal() throws Exception {
				return customerServices.findCustomerCountGroupByVisitDateCount(customerCond);
			}
			
			//获取table中要显示的json
			@Override
			public List<Map<String, String>> initRows() throws Exception {
				
				List<Map<String, String>> retList = new ArrayList<Map<String,String>>();
//				List<Customer> list;
//				List<Customer> downloadList;     //区分下载的数据 和查询的数据
				List<Map<String, Object>> listMap= customerServices.findCustomerCountGroupByVisitDate(customerCond);
				Map<String, String> map; 
				map=new HashMap<String, String>();
				for(Map<String, Object> m:listMap){
					map=new HashMap<String, String>();
					if(m.get("visit_date")==null){
						map.put("visit_date", "0");
					}else if("total".equals(m.get("visit_date"))){
						map.put("visit_date", "本周数据合计");
					}else{
						map.put("visit_date",m.get("visit_date").toString());
					}
					if(m.get("coming_customer")==null){
						map.put("coming_customer", "0");
					}else if("percent".equals(m.get("coming_customer"))){
						map.put("coming_customer", "占来访比例");
					}else{
						map.put("coming_customer",m.get("coming_customer").toString());
					}
					map.put("new_customer", m.get("new_customer")==null?"0":CommonUtils.parseString(m.get("new_customer").toString(), 0));
					map.put("old_customer", m.get("old_customer")==null?"0":CommonUtils.parseString(m.get("old_customer").toString(),0));
					map.put("phone_customer", m.get("phone_customer")==null?"0":CommonUtils.parseString(m.get("phone_customer").toString(),0));
					map.put("confirm_amount", m.get("confirm_amount")==null?"0":CommonUtils.parseString(m.get("confirm_amount").toString(),0));
					map.put("sum_money", m.get("sum_money")==null?"0":m.get("sum_money").toString());
					map.put("confirm_area", m.get("confirm_area")==null?"0":m.get("confirm_area").toString());
					map.put("average_price", m.get("average_price")==null?"0":m.get("average_price").toString());
					retList.add(map);
				}
				//下载全部数据
				List<Map<String, String>> retListDownload = new ArrayList<Map<String,String>>();
				customerCond.pageSize=0;
				customerCond.recordCount=0;
				List<Map<String, Object>> listMapDownload= customerServices.findCustomerCountGroupByVisitDate(customerCond);
				map=new HashMap<String, String>();
				for(Map<String, Object> m:listMapDownload){
					map=new HashMap<String, String>();
					if(m.get("visit_date")==null){
						map.put("visit_date", "0");
					}else if("total".equals(m.get("visit_date"))){
						map.put("visit_date", "本周数据合计");
					}else{
						map.put("visit_date",m.get("visit_date").toString());
					}
					if(m.get("coming_customer")==null){
						map.put("coming_customer", "0");
					}else if("percent".equals(m.get("coming_customer"))){
						map.put("coming_customer", "占来访比例");
					}else{
						map.put("coming_customer",m.get("coming_customer").toString());
					}
					map.put("new_customer", m.get("new_customer")==null?"0":CommonUtils.parseString(m.get("new_customer").toString(), 0));
					map.put("old_customer", m.get("old_customer")==null?"0":CommonUtils.parseString(m.get("old_customer").toString(),0));
					map.put("phone_customer", m.get("phone_customer")==null?"0":CommonUtils.parseString(m.get("phone_customer").toString(),0));
					map.put("confirm_amount", m.get("confirm_amount")==null?"0":CommonUtils.parseString(m.get("confirm_amount").toString(),0));
					map.put("sum_money", m.get("sum_money")==null?"0":m.get("sum_money").toString());
					map.put("confirm_area", m.get("confirm_area")==null?"0":m.get("confirm_area").toString());
					map.put("average_price", m.get("average_price")==null?"0":m.get("average_price").toString());
					retListDownload.add(map);
				}
				
				request.getSession().setAttribute("zhongshanDownloadList", retListDownload);
				return retList;
			}
		});
		
		return null;
	}
	
	/**
	 * action方法,该方法有bug,改用khcjReportAjax(),
	 * @return
	 * @throws Exception
	 */
	@Deprecated
	public String khcjReport() throws Exception {
		
		/**
		ContractCustomerCond cond = (ContractCustomerCond)request.getSession().getAttribute(COND);
		if(cond == null)
			cond = new ContractCustomerCond();
		int recordCount = contractCustomerServices.findcontractCustAndConfirmCount(cond);
		//HttpServletRequest re = ServletActionContext.getRequest();
    	int rows = Integer.parseInt((request.getParameter("rows") == null) ? "10" : request.getParameter("rows"));
		int page = Integer.parseInt((request.getParameter("page") == null) ? "1" : request.getParameter("page"));
		cond.pageSize = rows;
		cond.startLine = (page - 1) * rows;
		List<Map<String, Object>> map = contractCustomerServices.findcontractCustAndConfirm(cond);  //不正确
		try{
			JSONArray jsonArray = new JSONArray();
			JSONObject jsonobj = new JSONObject();
			for(int i=0; i<map.size(); i++){
				jsonobj.put("xs0", map.get(i).get("projectName"));
				jsonobj.put("xs1", map.get(i).get("buildId"));
				jsonobj.put("xs2", map.get(i).get("roomNo"));
				jsonobj.put("xs3", map.get(i).get("customerName"));
				jsonobj.put("xs4", map.get(i).get("idcardNo"));
				jsonobj.put("xs5", map.get(i).get("address"));
				jsonobj.put("xs6", map.get(i).get("phone"));
				jsonobj.put("xs7", map.get(i).get("buildArea"));
				jsonobj.put("xs8", map.get(i).get("sumPrice"));
				jsonobj.put("xs9", CommonUtils.getDateString((Date)map.get(i).get("workDate")));
				
				jsonArray.add(jsonobj);
			}
			Map<String, Object> json = new HashMap<String, Object>();
			json.put("total", recordCount);// total键 存放总记录数，必须的
			json.put("rows", jsonArray);// rows键 存放每页记录 list
			result = JSONObject.fromObject(json);// 格式化result一定要是JSONObject
		}catch(Exception ex){
			ex.printStackTrace();
		}
		*/
		
		return SUCCESS;
	}
	
	/**
	 * 下载数据cond.startLine = -1;表示查找所有
	 * @return
	 * @throws Exception
	 */
	public String zhongshanConfirmDetailDownload() throws Exception{
		if(customerCond == null){
			customerCond = new CustomerCond();
		}
		List<ContractCustConfirm> cusList = (List<ContractCustConfirm>)request.getSession().getAttribute("zhongshanDownloadList");
		Map<String, Object> map =  new HashMap<String, Object>();
		map.put("cusList", cusList);
		
		ReportUtils.downLoadReport(map, "zhongshan-confirm-detail.xls", "来访来电成交简况.xls", response);
		
		return null;
	}
	
	
	
	
	
	private void initSearchData(){
		
		String today = CustomerUtils.getNowForString();
		String before7Day = CommonUtils.getOneWeekBeforeForString();
		if(customerCond == null){
			customerCond = new CustomerCond();
		}
		customerCond.setDate1(before7Day);
		if(CustomerUtils.isStrEmpty(customerCond.getDate2())){
			customerCond.setDate2(today);
		}
	}
	
	
	/**
	 * 通过propertyUnitCond获取权限所能看多的项目id
	 */
	private void initPermissionProjectIds(){
		
		if (propertyUnitCond == null){
			propertyUnitCond = new PropertyUnitCond();

			propertyUnitCond.addPermissionCompanyProjectIds(PermissionUtils.getUserProjectIdList(EnumPrivCode.REPORT_SALEUNIT_STAT));		
			propertyUnitCond.setSearchCompanyProjectIds(propertyUnitCond.getPrivCompanyProjectIds());
			
		}else if(propertyUnitCond.getPrivCompanyProjectIds()==null){

			propertyUnitCond.addPermissionCompanyProjectIds(PermissionUtils.getUserProjectIdList(EnumPrivCode.REPORT_SALEUNIT_STAT));			
		}
		
		customerCond.setCompanyProjectIds(propertyUnitCond.getSearchCompanyProjectIds());
	}
	
	/**
	 * 客户成交表条件
	 */
	CustomerCond customerCond;
	PropertyUnitCond propertyUnitCond;
	
	private Map<String, String> selConfirmType;
	
	public void setSelConfirmType(Map<String, String> selConfirmType) {
		this.selConfirmType = selConfirmType;
	}
	
	public Map<String, String> getSelConfirmType() {
		return selConfirmType;
	}

	

	public CustomerCond getCustomerCond() {
		return customerCond;
	}

	public void setCustomerCond(CustomerCond customerCond) {
		this.customerCond = customerCond;
	}

	public PropertyUnitCond getPropertyUnitCond() {
		return propertyUnitCond;
	}

	public void setPropertyUnitCond(PropertyUnitCond propertyUnitCond) {
		this.propertyUnitCond = propertyUnitCond;
	}
	
}

