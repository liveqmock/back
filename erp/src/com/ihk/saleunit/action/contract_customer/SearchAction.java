package com.ihk.saleunit.action.contract_customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.ContConfirmType;
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

/**
 * 成交客户
 * @author dtc
 * 2012-12-20,下午03:42:30
 */
public class SearchAction extends SupperAction{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	IContractCustomerServices contractCustomerServices;
	@Autowired
	IConfirmServices confirmServices;
	@Autowired
	IContractServices contractServices;
	@Autowired
	ICompanyProjectServices companyProjectServices;
	
	/**
	 * 跳到layout页面
	 * @return
	 * @throws Exception
	 */
	public String layoutDataGrid() throws Exception{
		
		initSearchData();
		request.getSession().removeAttribute("buildDownloadCusList");
		return "layoutDataGrid";
	}
	
	/**
	 * easyui datagrid 的分页
	 * @return
	 * @throws Exception
	 */
	public String customerAjaxTable() throws Exception{
		
		if(contractCustomerCond == null){
			
			contractCustomerCond = new ContractCustomerCond();
		}
		
		if(ContConfirmType.CONTRACT.equals(contractCustomerCond.getConfirmType())){
			
			contractCustomerCond.setConfirmTypeName("contract");
			contractCustomerCond.setAgreeNoName("contract_no");
			
		}else if(ContConfirmType.CONFIRM.equals(contractCustomerCond.getConfirmType())){
			
			contractCustomerCond.setConfirmTypeName("confirm");
			contractCustomerCond.setAgreeNoName("agree_no");
		}else{
			contractCustomerCond.setConfirmTypeName("confirm");
		}
		
		List<Integer> buildIds = ContractCustomerUtils.getBuildIdsByRequest(request);
		contractCustomerCond.setBuildIds(buildIds);
		
		ActionTemplate.executeAjaxPage(this, contractCustomerCond, new ActionAjaxPageCallback() {
			
			@Override
			public int initTotal() {
				
				if(CommonUtils.isCollectionEmpty(contractCustomerCond.getBuildIds())){
					
					return 0;
				}
				if(contractCustomerCond.getConfirmType().equals("-1")){
					return contractCustomerServices.findContractConfirmCustCount(contractCustomerCond);
				}
				return contractCustomerServices.findcontractCustAndConfirmCount(contractCustomerCond);
			}
			
			@Override
			public List<Map<String, String>> initRows() {
				
				List<Map<String, String>> retList = new ArrayList<Map<String,String>>();
				
				if(CommonUtils.isCollectionEmpty(contractCustomerCond.getBuildIds())){
					
					return retList;
				}
				List<ContractCustConfirm> cusList;
				List<ContractCustConfirm> downloadList;
				if(contractCustomerCond.getConfirmType().equals("-1")){
					cusList = contractCustomerServices.findContractConfirmCust(contractCustomerCond); 
					contractCustomerCond.startLine=0;
					contractCustomerCond.pageSize=0;
					downloadList= contractCustomerServices.findContractConfirmCust(contractCustomerCond); 
				}else{
					cusList = contractCustomerServices.findcontractCustAndConfirm(contractCustomerCond);
					contractCustomerCond.startLine=0;
					contractCustomerCond.pageSize=0;
					downloadList= contractCustomerServices.findcontractCustAndConfirm(contractCustomerCond); 
				}
				if(!CommonUtils.isCollectionEmpty(cusList)){
					
					Map<String, String> map = null;
					
					for(ContractCustConfirm cus : cusList){
						
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
						String householdProvince="";
						String householdCity="";
						String householdRegion="";
						String homeProvince="";
						String homeCity="";
						String homeRegion="";
						for(ContractCustomer cc:ccList){
							ccName=ccName+cc.getCustomerName()+" ";
							ccPhone=ccPhone+cc.getMobilePhone()+" ";
							ccHomePhone=ccHomePhone + cc.getPhone()+" ";
							ccIdcardType=ccIdcardType+cc.getIdcardTypeStr()+" ";
							ccIdcardNo=ccIdcardNo+cc.getIdcardNo()+" ";
							gender=gender+cc.getGenderStr()+" ";
							address=address+cc.getAddress()+" ";
							householdProvince = cc.getHouseholdProvinceStr()==null?"":cc.getHouseholdProvinceStr();
							householdCity = cc.getHouseholdCityStr()==null?"":cc.getHouseholdCityStr();
							householdRegion = cc.getHouseholdRegionStr()==null?"":cc.getHouseholdRegionStr();
							homeProvince = cc.getHomeProvinceStr()==null?"":cc.getHomeProvinceStr();
							homeCity = cc.getHomeCityStr()==null?"":cc.getHomeCityStr();
							homeRegion = cc.getHomeRegionStr()==null?"":cc.getHomeRegionStr();
							house=house+householdProvince+householdCity+householdRegion+" ";
							home=home+homeProvince+homeCity+homeRegion+" ";	
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
				request.getSession().setAttribute("buildDownloadCusList", downloadList);
				return retList;
			}
		});
		
		return null;
	}
	
	/**
	 * 获取一行的数据,用于显示
	 * @return
	 * @throws Exception
	 */
	public String getRowDataToShow() throws Exception{
		
		return "getRowDataToShow";
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
		
		
		
		List<ContractCustConfirm> cusList = (List<ContractCustConfirm>)request.getSession().getAttribute("buildDownloadCusList");
		
		Map<String, Object> map =  new HashMap<String, Object>();
		//List<Map<String, Object>> retList = new ArrayList<Map<String,Object>>();

		if(!CommonUtils.isCollectionEmpty(cusList)){
			for(ContractCustConfirm cus : cusList){
				int cid=(Integer)cus.getCid();
				List<ContractCustomer> ccList=contractCustomerServices.findContractCustomerByMainIdAndConfirmType(cid, cus.getConfirmType());
				String ccName="";
				String ccPhone="";
				String ccIdcardType="";
				String ccIdcardNo="";
				String gender="";
				String address="";
				String house="";
				String home="";
				String ccHomePhone="";
//				String householdProvince="";
//				String householdCity="";
//				String householdRegion="";
//				String homeProvince="";
//				String homeCity="";
//				String homeRegion="";
				for(ContractCustomer cc:ccList){
					ccName=ccName+cc.getCustomerName()+" ";
					ccPhone=ccPhone+cc.getMobilePhone()+" ";
					ccHomePhone=ccHomePhone + cc.getPhone()+" ";
					ccIdcardType=ccIdcardType+cc.getIdcardType()+" ";
					gender=gender+cc.getGender()+" ";
					ccIdcardNo=ccIdcardNo+cc.getIdcardNo()+" ";
					address=address+cc.getAddress()+" ";
//					householdProvince = cc.getHouseholdProvinceStr()==null?"":cc.getHouseholdProvinceStr();
//					householdCity = cc.getHouseholdCityStr()==null?"":cc.getHouseholdCityStr();
//					householdRegion = cc.getHouseholdRegionStr()==null?"":cc.getHouseholdRegionStr();
//					homeProvince = cc.getHomeProvinceStr()==null?"":cc.getHomeProvinceStr();
//					homeCity = cc.getHomeCityStr()==null?"":cc.getHomeCityStr();
//					homeRegion = cc.getHomeRegionStr()==null?"":cc.getHomeRegionStr();
//					house=house+householdProvince+householdCity+householdRegion+" ";
//					home=home+homeProvince+homeCity+homeRegion+" ";	
//					cus.setHousehold(house);
//					cus.setHome(home);
				}
				if(cus.getConfirmType().equals(ContConfirmType.CONFIRM)){
					cus.setPayType(confirmServices.findConfirmById(cid).getPayTypeStr());
					cus.setInsideArea( confirmServices.findConfirmById(cid).getUnit().getInsideArea()+"");
					cus.setProjectName(companyProjectServices.findCompanyProjectById(confirmServices.findConfirmById(cid).getUnit().getCompanyProjectId()).getProjectName()+"");
					cus.setFloor(confirmServices.findConfirmById(cid).getUnit().getFloorNum()+"");
				}
				if(cus.getConfirmType().equals(ContConfirmType.CONTRACT)){
					cus.setPayType(contractServices.findContractById(cid).getPayTypeStr());
					cus.setInsideArea(contractServices.findContractById(cid).getUnit().getInsideArea()+"");
					cus.setProjectName(companyProjectServices.findCompanyProjectById(contractServices.findContractById(cid).getUnit().getCompanyProjectId()).getProjectName()+"");
					cus.setFloor(contractServices.findContractById(cid).getUnit().getFloorNum()+"");
				}
				
				cus.setArea(DescUtils.findAreaName(cid, cus.getConfirmType()));
				
				cus.setCustomerName(ccName);
				cus.setPhone(ccPhone);
				cus.setHomePhone(ccHomePhone);
				cus.setIdcardType(ccIdcardType);
				cus.setIdcardNo(ccIdcardNo);
				cus.setGender(gender);
				cus.setAddress(address);

			}
		}
		
		map.put("cusList", cusList);
		
		//ReportUtils.downLoadReport(sb.toString(), "成交客户", response);
		ReportUtils.downLoadReport(map, "contract-customer.xls", "成交客户.xls", response);
		
		return null;
	}
	
	/**
	 * 初始化查询条件及相关数据
	 */
	private void initSearchData(){
		
		if(contractCustomerCond == null){
			contractCustomerCond = new ContractCustomerCond();
		
			contractCustomerCond.setDate1(CommonUtils.getMonthFirstForString());
			contractCustomerCond.setDate2(CommonUtils.getMonthEndForString());
		}
		
		selConfirmType = ContractCustomerUtils.initConfirmType(false);
		contractCustomerCond.setConfirmType(ContConfirmType.CONFIRM);
		
	}
	
	////
	
	private ContractCustomer contractCustomer;
	
	private ContractCustomerCond contractCustomerCond;
	
	private Map<String, String> selConfirmType;
	
	private List<ContractCustConfirm> downloadCusList;

	public List<ContractCustConfirm> getDownloadCusList() {
		return downloadCusList;
	}

	public void setDownloadCusList(List<ContractCustConfirm> downloadCusList) {
		this.downloadCusList = downloadCusList;
	}

	public ContractCustomer getContractCustomer() {
		return contractCustomer;
	}

	public void setContractCustomer(ContractCustomer contractCustomer) {
		this.contractCustomer = contractCustomer;
	}

	public ContractCustomerCond getContractCustomerCond() {
		return contractCustomerCond;
	}

	public void setContractCustomerCond(ContractCustomerCond contractCustomerCond) {
		this.contractCustomerCond = contractCustomerCond;
	}

	public Map<String, String> getSelConfirmType() {
		return selConfirmType;
	}

	public void setSelConfirmType(Map<String, String> selConfirmType) {
		this.selConfirmType = selConfirmType;
	}
	
}
