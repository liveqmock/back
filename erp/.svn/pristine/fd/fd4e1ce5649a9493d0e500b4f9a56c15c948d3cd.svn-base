package com.ihk.customer.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.ContConfirmType;
import com.ihk.constanttype.EnumPrivCode;
import com.ihk.permission.PermissionUtils;
import com.ihk.property.data.pojo.PropertyUnitCond;
import com.ihk.saleunit.data.pojo.Contract;
import com.ihk.saleunit.data.pojo.ContractCustConfirm;
import com.ihk.saleunit.data.pojo.ContractCustomer;
import com.ihk.saleunit.data.pojo.ContractCustomerCond;
import com.ihk.saleunit.data.services.IConfirmServices;
import com.ihk.saleunit.data.services.IContractCustomerServices;
import com.ihk.saleunit.data.services.IContractServices;
import com.ihk.user.data.services.ICompanyProjectServices;
import com.ihk.utils.ActionAjaxPageCallback;
import com.ihk.utils.ActionTemplate;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.ReportUtils;
import com.ihk.utils.SupperAction;
import com.ihk.utils.contract.customer.ContractCustomerUtils;

public class KhcjReportAction extends SupperAction{
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	IContractCustomerServices contractCustomerServices;
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
	public String khcj() throws Exception {
		//DEMO 例子 初始化查询条件,权限之类
		initSearchData();
		request.getSession().setAttribute(COND, contractCustomerCond);
		request.getSession().removeAttribute("projectDownloadCusList");
		return SUCCESS;
	}
	
	/**
	 * ajax action
	 * @return
	 * @throws Exception
	 */
	public String khcjReportAjax() throws Exception{
		
		//查找之前要做一些相应的处理
		
		if(contractCustomerCond == null){
			
			contractCustomerCond = (ContractCustomerCond)request.getSession().getAttribute(COND);
		}
		
		if("2".equals(contractCustomerCond.getConfirmType())){
			
			contractCustomerCond.setConfirmTypeName("contract");
			contractCustomerCond.setAgreeNoName("contract_no");
			contractCustomerCond.setRealDate("sign_date");
			
		}else if("1".equals(contractCustomerCond.getConfirmType())){
			
			contractCustomerCond.setConfirmTypeName("confirm");
			contractCustomerCond.setAgreeNoName("agree_no");
			contractCustomerCond.setRealDate("work_date");
		}else{
			
		}
		
		if(!CommonUtils.isStrEmpty(contractCustomerCond.getSearchProjectIdStr())){
			
			List<Integer> projectIds = CommonUtils.stringToList(contractCustomerCond.getSearchProjectIdStr());
			if(!CommonUtils.isCollectionEmpty(projectIds)){
				contractCustomerCond.setSearchProjectIds(projectIds);
			}
			
		}else{
			//如果没选择就设为其权限对应的项目id
			initPermissionProjectIds();
		}
		
		//DEMO 查找具体的封装方法例子
		ActionTemplate.executeAjaxPage(this, contractCustomerCond, new ActionAjaxPageCallback() {
			
			//获取总条数,返回0表示不分页
			@Override
			public int initTotal() throws Exception {
				if(contractCustomerCond.getConfirmType().equals("-1")){
					return contractCustomerServices.findContractConfirmCustCount(contractCustomerCond);
				}
				return contractCustomerServices.findcontractCustAndConfirmCount(contractCustomerCond);
			
			}
			
			//获取table中要显示的json
			@Override
			public List<Map<String, String>> initRows() throws Exception {
				
				List<Map<String, String>> retList = new ArrayList<Map<String,String>>();
				List<ContractCustConfirm> list;
				List<ContractCustConfirm> downloadList;     //区分下载的数据 和查询的数据
				if(contractCustomerCond.getConfirmType().equals("-1")){
					list = contractCustomerServices.findContractConfirmCust(contractCustomerCond); 
					contractCustomerCond.startLine=0;
					contractCustomerCond.pageSize=0;
					downloadList= contractCustomerServices.findContractConfirmCust(contractCustomerCond); 
				}else{
					list = contractCustomerServices.findcontractCustAndConfirm(contractCustomerCond);
					contractCustomerCond.startLine=0;
					contractCustomerCond.pageSize=0;
					downloadList= contractCustomerServices.findcontractCustAndConfirm(contractCustomerCond); 
				}
				
				if(!CommonUtils.isCollectionEmpty(list)){
					
					Map<String, String> map = null;
					
					//与jsp中table的表头(th field)定义一致
					for(ContractCustConfirm cus : list){
						
						map = new HashMap<String, String>();
						
						map.put("id", cus.getId() + "");
						
						map.put("confirmType", cus.getConfirmTypeStr());
						
						int cid=(Integer)cus.getCid();
						List<ContractCustomer> ccList=contractCustomerServices.findContractCustomerByMainIdAndConfirmType(cid, cus.getConfirmType());
						String ccName="";
						String ccPhone="";
						String ccHomePhone="";
						String ccIdcardType="";
						String ccIdcardNo="";
						String gender="";
						String address="";
						String house="";
						String home="";
						for(ContractCustomer cc:ccList){
							ccName=ccName+cc.getCustomerName()+" ";
							ccPhone=ccPhone+cc.getMobilePhone()+" ";
							ccHomePhone=ccHomePhone + cc.getPhone()+" ";
							ccIdcardType=ccIdcardType+cc.getIdcardTypeStr()+" ";
							ccIdcardNo=ccIdcardNo+cc.getIdcardNo()+" ";
							gender=gender+cc.getGenderStr()+" ";
							address=address+cc.getAddress()+" ";
							String householdProvince = cc.getHouseholdProvinceStr()==null?"":cc.getHouseholdProvinceStr();
							String householdCity = cc.getHouseholdCityStr()==null?"":cc.getHouseholdCityStr();
							String householdRegion = cc.getHouseholdRegionStr()==null?"":cc.getHouseholdRegionStr();
							String homeProvince = cc.getHomeProvinceStr()==null?"":cc.getHomeProvinceStr();
							String homeCity = cc.getHomeCityStr()==null?"":cc.getHomeCityStr();
							String homeRegion = cc.getHomeRegionStr()==null?"":cc.getHomeRegionStr();
							house=householdProvince+householdCity+householdRegion+" ";
							home=homeProvince+homeCity+homeRegion+" ";	
						}
						if(cus.getConfirmType().equals(ContConfirmType.CONFIRM)){
							map.put("payType", confirmServices.findConfirmById(cid).getPayTypeStr());
							map.put("insideArea", confirmServices.findConfirmById(cid).getUnit().getInsideArea()+"");
							map.put("projectName",companyProjectServices.findCompanyProjectById(confirmServices.findConfirmById(cid).getUnit().getCompanyProjectId()).getProjectName()+"");
							map.put("floor", confirmServices.findConfirmById(cid).getUnit().getFloorNum()+"");
						}
						if(cus.getConfirmType().equals(ContConfirmType.CONTRACT)){
							map.put("payType", contractServices.findContractById(cid).getPayTypeStr());
							map.put("insideArea", contractServices.findContractById(cid).getUnit().getInsideArea()+"");
							map.put("projectName",companyProjectServices.findCompanyProjectById(contractServices.findContractById(cid).getUnit().getCompanyProjectId()).getProjectName()+"");
							map.put("floor", contractServices.findContractById(cid).getUnit().getFloorNum()+"");
						}
						map.put("area", DescUtils.findAreaName(cid, cus.getConfirmType()));
						
						map.put("household", house);
						map.put("home", home);
						map.put("customerName", ccName);
						
						map.put("buildName", cus.getBuildName());
						map.put("unitNo", cus.getUnitNo());
						map.put("buildArea", cus.getBuildArea() == null ? "0" : cus.getBuildArea().toString());
						
						map.put("agreeNo", cus.getAgreeNo());
						map.put("workDate", cus.getWorkDate() == null ? "" : CommonUtils.getDateString(cus.getWorkDate()));
						map.put("sumMoney", cus.getSumMoney() == null ? "0" : cus.getSumMoney().toString());
						
						map.put("phone", ccPhone);
						map.put("homePhone", ccHomePhone);
						map.put("idcardType", ccIdcardType); //
						map.put("idcardNo", ccIdcardNo);
						map.put("gender", gender); //
						map.put("address", address);
						
						retList.add(map);
					}
					
				}
				request.getSession().setAttribute("projectDownloadCusList", downloadList);
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
	public String download() throws Exception{
		
		if(contractCustomerCond == null){
			
			contractCustomerCond = new ContractCustomerCond();
		}
		
		if("2".equals(contractCustomerCond.getConfirmType())){
			
			contractCustomerCond.setConfirmTypeName("contract");
			contractCustomerCond.setAgreeNoName("contract_no");
			
		}else{
			
			contractCustomerCond.setConfirmTypeName("confirm");
			contractCustomerCond.setAgreeNoName("agree_no");
		}
		
		List<Integer> buildIds = ContractCustomerUtils.getBuildIdsByRequest(request);
		contractCustomerCond.setBuildIds(buildIds);
		
		contractCustomerCond.startLine = -1; //查找所有
		
		
		
		@SuppressWarnings("unchecked")
		List<ContractCustConfirm> cusList = (List<ContractCustConfirm>)request.getSession().getAttribute("projectDownloadCusList");
		
		Map<String, Object> map =  new HashMap<String, Object>();
		//List<Map<String, Object>> retList = new ArrayList<Map<String,Object>>();
		
//		if(!CommonUtils.isCollectionEmpty(cusList)){
//			for(ContractCustConfirm cus : cusList){
//				int cid=(Integer)cus.getCid();
//				//List<ContractCustomer> ccList=contractCustomerServices.findContractCustomerByMainIdAndConfirmType(cid, cus.getConfirmType());
//				String ccName="";
//				String ccPhone="";
//				String ccIdcardType="";
//				String ccIdcardNo="";
//				String gender="";
//				String address="";
//				String house="";
//				String home="";
//				String ccHomePhone="";
//				String householdProvince="";
//				String householdCity="";
//				String householdRegion="";
//				String homeProvince="";
//				String homeCity="";
//				String homeRegion="";
//				for(ContractCustConfirm cc:cusList){
//					ccName=ccName+cc.getCustomerName()+" ";
//					ccPhone=ccPhone+cc.getPhone()+" ";
//					ccHomePhone=ccHomePhone + cc.getHomePhone()+" ";
//					ccIdcardType=ccIdcardType+cc.getIdcardType()+" ";
//					gender=gender+cc.getGender()+" ";
//					ccIdcardNo=ccIdcardNo+cc.getIdcardNo()+" ";
//					address=address+cc.getAddress()+" ";
//					householdProvince = cc.getHouseholdProvinceStr()==null?"":cc.getHouseholdProvinceStr();
//					householdCity = cc.getHouseholdCityStr()==null?"":cc.getHouseholdCityStr();
//					householdRegion = cc.getHouseholdRegionStr()==null?"":cc.getHouseholdRegionStr();
//					homeProvince = cc.getHomeProvinceStr()==null?"":cc.getHomeProvinceStr();
//					homeCity = cc.getHomeCityStr()==null?"":cc.getHomeCityStr();
//					homeRegion = cc.getHomeRegionStr()==null?"":cc.getHomeRegionStr();
//					house=house+householdProvince+householdCity+householdRegion+" ";
//					home=home+homeProvince+homeCity+homeRegion+" ";	
//					
//				}
				
//				cus.setPayType(cus.getPayName());
//				cus.setInsideArea(cus.getInsideArea());
//				cus.setFloor(cus.getFloorNum());
//				cus.setArea(cus.getAreaName());
////				if(cus.getConfirmType().equals(ContConfirmType.CONTRACT)){
////					Contract contract = contractServices.findContractById(cid);
////					cus.setPayType(contract.getPayTypeStr());
////					cus.setInsideArea(contract.getUnit().getInsideArea()+"");
////					cus.setProjectName(companyProjectServices.findCompanyProjectById(contract.getUnit().getCompanyProjectId()).getProjectName()+"");
////					cus.setFloor(contract.getUnit().getFloorNum()+"");
////				}
//				cus.setCustomerName(ccName);
//				cus.setPhone(ccPhone);
//				cus.setHomePhone(ccHomePhone);
//				cus.setIdcardType(ccIdcardType);
//				cus.setIdcardNo(ccIdcardNo);
//				cus.setGender(gender);
//				cus.setAddress(address);
//
//			}
//		}
		
		map.put("cusList", cusList);
		
		//ReportUtils.downLoadReport(sb.toString(), "成交客户", response);
		ReportUtils.downLoadReport(map, "contract-customer.xls", "成交客户.xls", response);
		
		return null;
	}
	
	
	
	
	
	private void initSearchData(){
		
		if(contractCustomerCond == null){
			contractCustomerCond = new ContractCustomerCond();
		
			contractCustomerCond.setDate1(CommonUtils.getMonthFirstForString());
			contractCustomerCond.setDate2(CommonUtils.getMonthEndForString());
		}
		
		selConfirmType = ContractCustomerUtils.initConfirmType(false);
		contractCustomerCond.setConfirmType(ContConfirmType.CONFIRM);
		
		initPermissionProjectIds();
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
		
		contractCustomerCond.setSearchProjectIds(propertyUnitCond.getSearchCompanyProjectIds());
	}
	
	/**
	 * 客户成交表条件
	 */
	ContractCustomerCond contractCustomerCond;
	PropertyUnitCond propertyUnitCond;
	
	private Map<String, String> selConfirmType;
	
	public void setSelConfirmType(Map<String, String> selConfirmType) {
		this.selConfirmType = selConfirmType;
	}
	
	public Map<String, String> getSelConfirmType() {
		return selConfirmType;
	}

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
	
}
