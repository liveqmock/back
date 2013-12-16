package com.ihk.saleunit.action.new_report;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.ContUnitSaleState;
import com.ihk.customer.data.pojo.CustomerFollowCond;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.pojo.PropertyUnitCond;
import com.ihk.property.data.pojo.PropertyUnitReportCond;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.saleunit.data.pojo.Confirm;
import com.ihk.saleunit.data.pojo.ConfirmCond;
import com.ihk.saleunit.data.pojo.Contract;
import com.ihk.saleunit.data.pojo.ContractCond;
import com.ihk.saleunit.data.services.IConfirmServices;
import com.ihk.saleunit.data.services.IContractServices;
import com.ihk.saleunit.data.services.IReportDefineColumnServices;
import com.ihk.saleunit.data.services.IReportDefineTypeServices;
import com.ihk.utils.ActionAjaxPageCallback;
import com.ihk.utils.ActionTemplate;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.DateTimeUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.SupperAction;
import com.ihk.utils.saleunit.ReportShowUtils;

/**
 * 销售分析 报表 详细
 * */
public class SaleReportUnitAction extends SupperAction{
	private static final long serialVersionUID = 1L;
	@Autowired
	IPropertyUnitServices propertyUnitServices;
	@Autowired
	IConfirmServices confirmServices;
	@Autowired
	IContractServices contractServices;
	@Autowired
	IReportDefineTypeServices reportDefineTypeServices;
	@Autowired
	IReportDefineColumnServices reportDefineColumnServices;
	private PropertyUnitCond propertyUnitCond;
	private PropertyUnitReportCond cond;
	private String initJs;
	private JSONObject res;
	private String saleName;
	private String saleId;
	
	/** 直接点进来 初始化cond */
	public String index() {
		if(cond != null){
			propertyUnitCond = new PropertyUnitCond();
			propertyUnitCond.setStrSearchCompanyProjectIds(cond.getCompanyProjectId()+"");
			if(saleId != null){
				saleName = "";
				String[] s = saleId.split(",");
				
				for(String n : s){
					if(n.trim().equals("") || n.equals("0"))continue;
					saleName += DescUtils.getUserRealName(Integer.parseInt(n));
				}
			}
			initJs = "submitSearch()";
		}else{
			cond = new PropertyUnitReportCond();
			cond.setDate1(DateTimeUtils.getMonthFirstDayStr(new Date()));
			cond.setDate3(DateTimeUtils.getMonthFirstDayStr(new Date()));
		}
		return "success";
	}
	
	
	/**
	 * 销售分析汇总
	 * 详细信息
	 * */
	public String search1(){
		try {
			 Date date1 = null ;
			 Date date2 = null ;
			 Date date3 = null ;
			 Date date4 = null ;
			 if(cond.getDate1()!=null && !cond.getDate1().equals(""))date1 = DateTimeUtils.getDate(cond.getDate1()); 
			 if(cond.getDate2()!=null && !cond.getDate2().equals(""))date2 = DateTimeUtils.getDate(cond.getDate2()); 
			 if(cond.getDate3()!=null && !cond.getDate3().equals(""))date3 = DateTimeUtils.getDate(cond.getDate3()); 
			 if(cond.getDate4()!=null && !cond.getDate4().equals(""))date4 = DateTimeUtils.getDate(cond.getDate4()); 
		if(propertyUnitCond == null || propertyUnitCond.getProjectId() == 0 ){
			return null;
		}
		JSONArray proJsList = new JSONArray();
		JSONObject onePro = new JSONObject();
		List<PropertyUnit> allUnit = this.propertyUnitServices.findPropertyUnit(propertyUnitCond);
		init(allUnit);
		//TODO 得到所有销售 联合销售算一个
		
		int count  = 0;
		for(PropertyUnit u : allUnit){
			Confirm confirm = null;
			Contract contract = null;
			if(u.getSaleState().equals(ContUnitSaleState.CONTRACT))	{
				contract = u.getContract();
				try {
					if(  (date3!=null && date3.after(contract.getWorkDate()))
							|| (date4!=null&&date4.before(contract.getWorkDate())) ){
						continue;
					}
				} catch (Exception e) {
					continue;
				}
			}else if(u.getSaleState().equals(ContUnitSaleState.CONFIRM))	{
				confirm = u.getConfirm();
				try {
					if(  (date1!=null && date1.after(confirm.getWorkDate()))
							|| (date2!=null&&date2.before(confirm.getWorkDate())) ){
						continue;
					}
				} catch (Exception e) {
					continue;
				}
			}
			
			if(confirm == null &&  contract == null)continue;
			
				String saleuser = confirm==null?contract.getSalesId(): confirm.getSalesId();
				String names = "";
				if(saleuser.equals("")){
					//name ="";
				}else if( saleuser.equals("0")){
					onePro.put("sales", "N/A");
					names = "N/A";
				}else{
					String[] s = saleuser.split(",");
					for(String n : s){
						try {
						names += DescUtils.getUserRealName(Integer.parseInt(n));
						} catch (Exception e) {
							
							continue;
						}
					}
				}
				if(saleName !=null && names.indexOf(saleName)<0)continue;
				
				onePro.put("salesName",names);
				onePro.put("build", u.getDescBuildId());
				onePro.put("roomNo", u.getUnitNo());
				onePro.put("saleDate",confirm ==null ? "-": CustomerUtils.getDateString(confirm.getWorkDate()) );
				onePro.put("saleDate2",contract ==null ? "-": CustomerUtils.getDateString(contract.getWorkDate()) );
				onePro.put("customerName",confirm==null? contract.getCustomerName():confirm.getCustomerName());
				onePro.put("buildArea", u.getBuildArea());
				onePro.put("insideArea", u.getInsideArea());
				onePro.put("sumPrice", u.getSumPrice());
				onePro.put("salePrice",confirm ==null ?contract.getSumMoney(): confirm.getSumMoney());
				onePro.put("payWay",confirm ==null?contract.getPayTypeStr(): confirm.getPayTypeStr());
				onePro.put("discountPercent",confirm ==null ?contract.getDiscountPercent(): confirm.getDiscountPercent());
				proJsList.add(onePro);
				count++;
		}
		
		Map<String, Object> json = new HashMap<String, Object>();
		json.put("total", count);// total键 存放总记录数，必须的
		json.put("rows", proJsList);// rows键 存放每页记录 list
		res = JSONObject.fromObject(json);// 格式化result一定要是JSONObject
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "suc";
	}
	
	private int page;
	private int rows;
	private int type;
	

	public String saleReportUnitAjax()throws Exception {
		if(cond==null){
			cond = new PropertyUnitReportCond();
		}
		setCondOrderSortByRequest(cond);
		
		ActionTemplate.executeAjaxPage(this, cond, new ActionAjaxPageCallback() {
			
			@Override
			public int initTotal() throws Exception {
				//不分页的做法
				cond.pageSize = 0;
				return 0;
			}
			
			//获取table中要显示的json
			@Override
			public List<Map<String, String>> initRows() throws Exception {
				
				List<Map<String, String>> retList = new ArrayList<Map<String,String>>();

				List<Map> list;	
				list = propertyUnitServices.findListForXSFXXXConfirm(cond);
				list.addAll(propertyUnitServices.findListForXSFXXXContract(cond));
				
				if(!CommonUtils.isCollectionEmpty(list)){
					
					Map<String, String> map = null;
					
					//与jsp中table的表头(th field)定义一致
					for(Map obj : list){
						
						map = new HashMap<String, String>();

						map.put("id",obj.get("id").toString());
						map.put("salesName",obj.get("salesName").toString());
						map.put("build", obj.get("build").toString());
						map.put("roomNo", obj.get("roomNo").toString());
						if(type == 0){
							map.put("saleDate",CommonUtils.getDateString((Date)obj.get("saleDate")));
						}else {
							map.put("saleDate2",CommonUtils.getDateString((Date)obj.get("saleDate")));
						}
						
						map.put("customerName",obj.get("customerName").toString());
						map.put("buildArea", obj.get("buildArea").toString());
						map.put("insideArea", obj.get("insideArea").toString());
						map.put("sumPrice", obj.get("sumPrice").toString());
						map.put("salePrice",obj.get("salePrice").toString());
						map.put("payWay",obj.get("payWay").toString());
						map.put("discountPercent",obj.get("discountPercent").toString());						
																		
						retList.add(map);
					}

//					setChartSeriesDataInSession(retList);
//					setDownloadDataInSession(retList);
					
					// 添加合计
//					int sumPhoneCount = 0;
//					int sumVisitCount = 0;
//					for (Map line : retList) {
//						sumPhoneCount += Integer.parseInt((line.get("phoneCount").toString()));
//						sumVisitCount += Integer.parseInt((line.get("visitCount").toString()));
//					}
//
//					Map<String, String> sumMap = new HashMap<String, String>();
//					sumMap.put("projectName", "");
//					sumMap.put("realName", "合计");
//					sumMap.put("phoneCount", String.valueOf(sumPhoneCount));
//					sumMap.put("visitCount", String.valueOf(sumVisitCount));
//					retList.add(sumMap);
					
				}
				return retList;
			}
		});
		return null;
	}
	
	public String search(){
		try {
		JSONArray proJsList = new JSONArray();
		JSONObject onePro = new JSONObject();
		List<Map> listmap;	
		if(cond.getCompanyProjectId() ==0){
			return null;
		}
		
		if(type == 0){
			listmap = this.propertyUnitServices.findListForXSFXXXConfirm(cond);
		}else if(type == 1){
			listmap = this.propertyUnitServices.findListForXSFXXXContract(cond);
		}else{
			listmap = this.propertyUnitServices.findListForXSFXXXConfirm(cond);
			listmap.addAll(this.propertyUnitServices.findListForXSFXXXContract(cond));
		}
		
		System.out.println(listmap.size());
		for(Map m : listmap){
			onePro.put("id",m.get("id"));
			onePro.put("salesName",m.get("salesName"));
			onePro.put("build", m.get("build"));
			onePro.put("roomNo", m.get("roomNo"));
			if(type == 0){
				onePro.put("saleDate",CommonUtils.getDateString((Date)m.get("saleDate")));
			}else {
				onePro.put("saleDate2",CommonUtils.getDateString((Date)m.get("saleDate")));
			}
			
			onePro.put("customerName",m.get("customerName"));
			onePro.put("buildArea", m.get("buildArea"));
			onePro.put("insideArea", m.get("insideArea"));
			onePro.put("sumPrice", m.get("sumPrice"));
			onePro.put("salePrice",m.get("salePrice"));
			onePro.put("payWay",m.get("payWay"));
			onePro.put("discountPercent",m.get("discountPercent"));
			proJsList.add(onePro);
		}
				
		
		Map<String, Object> json = new HashMap<String, Object>();
		json.put("total", listmap.size());// total键 存放总记录数，必须的
		json.put("rows", proJsList);// rows键 存放每页记录 list
		res = JSONObject.fromObject(json);// 格式化result一定要是JSONObject
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "suc";
	}
	
	private void init(List<PropertyUnit> unitList){ 
		ConfirmCond confirmCond = new ConfirmCond();
		confirmCond.setCompanyProjectId(this.propertyUnitCond.getProjectId());
		List<Confirm> listConfirm = confirmServices.findConfirm(confirmCond);
		ContractCond contractCond = new ContractCond();
		contractCond.setCompanyProjectId(this.propertyUnitCond.getProjectId());
		List<Contract> listContract = contractServices.findContractPage(contractCond);
		ReportShowUtils.initListPropertyUnit_Confirm(unitList,listConfirm);
		ReportShowUtils.initListPropertyUnit_Contract(unitList,listContract);
	}
	
	
	
	

	public PropertyUnitCond getPropertyUnitCond() {
		return propertyUnitCond;
	}

	public void setPropertyUnitCond(PropertyUnitCond propertyUnitCond) {
		this.propertyUnitCond = propertyUnitCond;
	}

	public JSONObject getRes() {
		return res;
	}

	public void setRes(JSONObject res) {
		this.res = res;
	}

	public String getInitJs() {
		return initJs;
	}

	public void setInitJs(String initJs) {
		this.initJs = initJs;
	}

	public String getSaleName() {
		return saleName;
	}

	public void setSaleName(String saleName) {
		this.saleName = saleName;
	}

	public String getSaleId() {
		return saleId;
	}

	public void setSaleId(String saleId) {
		this.saleId = saleId;
	}

	public PropertyUnitReportCond getCond() {
		return cond;
	}

	public void setCond(PropertyUnitReportCond cond) {
		this.cond = cond;
	}


	public int getType() {
		return type;
	}


	public void setType(int type) {
		this.type = type;
	}
	
	public int getPage() {
		return page;
	}


	public void setPage(int page) {
		this.page = page;
	}


	public int getRows() {
		return rows;
	}


	public void setRows(int rows) {
		this.rows = rows;
	}


}



















