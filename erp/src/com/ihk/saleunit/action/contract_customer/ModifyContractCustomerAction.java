package com.ihk.saleunit.action.contract_customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.ContConfirmType;
import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.customer.data.pojo.Customer;
import com.ihk.customer.data.services.ICustomerServices;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.saleunit.data.pojo.Chip;
import com.ihk.saleunit.data.pojo.Confirm;
import com.ihk.saleunit.data.pojo.ConfirmBook;
import com.ihk.saleunit.data.pojo.Contract;
import com.ihk.saleunit.data.pojo.ContractCustomer;
import com.ihk.saleunit.data.pojo.ContractCustomerCond;
import com.ihk.saleunit.data.services.IContractCustomerServices;
import com.ihk.saleunit.data.services.IContractServices;
import com.ihk.user.data.pojo.CompanyProject;
import com.ihk.user.data.services.ICompanyProjectServices;
import com.ihk.utils.ActionTemplate;
import com.ihk.utils.CommonPojoUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;
import com.ihk.utils.exception.UnitChangeException;
import com.ihk.utils.method.ActionAjaxMethodModifyCallback;
import com.ihk.utils.saleunit.MyPropertyUtils;

/**
 * 成交客户的相关操作
 * @author dtc
 * 2013-5-16,下午03:45:00
 */
@SuppressWarnings("rawtypes")
public class ModifyContractCustomerAction extends SupperAction{

	private static final long serialVersionUID = -5600693836500326471L;
	
	@Autowired
	ICustomerServices customerServices;
	@Autowired
	IContractCustomerServices contractCustomerServices;
	@Autowired
	IPropertyUnitServices unitServices;
	@Autowired
	ICompanyProjectServices projectServices;
	@Autowired
	IContractServices contractServices;
	
	/**
	 * 跳到新增客户的界面
	 * @return
	 * @throws Exception
	 */
	public String toAddContractCustomer() throws Exception{
		
		int unitId = Integer.parseInt(request.getParameter("unitId"));
		
		init(unitId);
		
		if(ContConfirmType.CHIP.equals(confirmType)){
			return "toAddChipContractCustomer";
		}
		
		return "toAddContractCustomer";
	}
	
	/**
	 * 根据客户类型判断其对应的公司项目下是否存在该手机号码,
	 * 如果有多个就返回给录入人员选择
	 * @return
	 * @throws Exception
	 */
	public String isMobilePhoneExistsByProjectIdAndConfirmType() throws Exception{
		
		String projectId = request.getParameter("projectId");
		String mobilePhone = request.getParameter("mobilePhone");
		
		if(ContConfirmType.CONFIRM_BOOK.equals(confirmType)){
			//临定:认筹-->售前
			
			List<ContractCustomer> chipCustomerList = getContractCustomerList(projectId, mobilePhone, ContConfirmType.CHIP);
			
			if(!CommonUtils.isCollectionEmpty(chipCustomerList)){
				//如果有认筹客户,就直接返回
				
				copyCusList = getCopyCustomerPojoFromContractCustomerList(chipCustomerList, ContConfirmType.CHIP);
				
				if(CommonUtils.isCollectionEmpty(copyCusList)){
					return null;
				}
				
				return "isMobilePhoneExistsByProjectIdAndConfirmType";
			}
			
			List<Customer> customerList = customerServices.findCustomerPhoneIsExistsByProjectId(mobilePhone, projectId);
			
			if(!CommonUtils.isCollectionEmpty(customerList)){
				//售前客户
				
				copyCusList = getCopyCustomerPojoFromCustomerList(customerList, ContConfirmType.CUSTOMER);
				
				if(CommonUtils.isCollectionEmpty(copyCusList)){
					return null;
				}
				
				return "isMobilePhoneExistsByProjectIdAndConfirmType";
			}
			
			
		}else if(ContConfirmType.CHIP.equals(confirmType)){
			//认筹:售前
			List<Customer> customerList = customerServices.findCustomerPhoneIsExistsByProjectId(mobilePhone, projectId);
			
			if(!CommonUtils.isCollectionEmpty(customerList)){
				//售前客户
				
				copyCusList = getCopyCustomerPojoFromCustomerList(customerList, ContConfirmType.CUSTOMER);
				
				if(CommonUtils.isCollectionEmpty(copyCusList)){
					return null;
				}
				
				return "isMobilePhoneExistsByProjectIdAndConfirmType";
			}
			
			
		}else if(ContConfirmType.CONFIRM.equals(confirmType)){
			//成交:临定-->认筹-->售前
			
			List<ContractCustomer> confirmBookCustomerList = getContractCustomerList(projectId, mobilePhone, ContConfirmType.CONFIRM_BOOK);
			
			if(!CommonUtils.isCollectionEmpty(confirmBookCustomerList)){
				//临定客户
				
				copyCusList = getCopyCustomerPojoFromContractCustomerList(confirmBookCustomerList, ContConfirmType.CONFIRM_BOOK);
				
				if(CommonUtils.isCollectionEmpty(copyCusList)){
					return null;
				}
				
				return "isMobilePhoneExistsByProjectIdAndConfirmType";
			}
			
			List<ContractCustomer> chipCustomerList = getContractCustomerList(projectId, mobilePhone, ContConfirmType.CHIP);
			
			if(!CommonUtils.isCollectionEmpty(chipCustomerList)){
				//如果有认筹客户,就直接返回
				
				copyCusList = getCopyCustomerPojoFromContractCustomerList(chipCustomerList, ContConfirmType.CHIP);
				
				if(CommonUtils.isCollectionEmpty(copyCusList)){
					return null;
				}
				
				return "isMobilePhoneExistsByProjectIdAndConfirmType";
			}
			
			List<Customer> customerList = customerServices.findCustomerPhoneIsExistsByProjectId(mobilePhone, projectId);
			
			if(!CommonUtils.isCollectionEmpty(customerList)){
				//售前客户
				
				copyCusList = getCopyCustomerPojoFromCustomerList(customerList, ContConfirmType.CUSTOMER);
				
				if(CommonUtils.isCollectionEmpty(copyCusList)){
					return null;
				}
				
				return "isMobilePhoneExistsByProjectIdAndConfirmType";
			}
			
		}
		
		return null;
	}
	
	/**
	 * 根据客户类型及id复制相关的资料,用于新增合同客户
	 * @return
	 * @throws Exception
	 */
	public String copyForAddContractCustomer() throws Exception{
		
		String preCustomerType = request.getParameter("preCustomerType");
		int customerId = Integer.parseInt(request.getParameter("customerId"));
		int projectId = Integer.parseInt(request.getParameter("projectId"));
		
		if(preCustomerType.equals(ContConfirmType.CUSTOMER)){
			//来源为售前客户
			
			Customer srcCustomer = customerServices.getCustomerById(customerId);
			
			customer = new ContractCustomer();
			
			customer.setMobilePhone(srcCustomer.getPhone()); //移动电话
			customer.setConfirmType(confirmType);
			customer.setProjectId(projectId);
			
			customer.setCustomerName(srcCustomer.getCustomerName());
			customer.setGender(srcCustomer.getGender());
			
			customer.setPhone(srcCustomer.getHomePhone()); //固定电话
			
			customer.setIdcardType(srcCustomer.getIdcardType()); //证件类型
			customer.setIdcardNo(srcCustomer.getIdcardNo()); //证件号码
			
			customer.setBirthday(srcCustomer.getBirthday());//生日
			
			customer.setAddress(srcCustomer.getAddress());
			customer.setPostcode(srcCustomer.getPostcode()); //邮编

			customer.setHomeProvince(srcCustomer.getHomeProvince());
			customer.setHomeCity(srcCustomer.getHomeCity());
			customer.setHomeRegion(srcCustomer.getHomeRegion());
			customer.setHomeContent(srcCustomer.getHomeContent());
			
			customer.setWorkProvince(srcCustomer.getWorkProvince());
			customer.setWorkCity(srcCustomer.getWorkCity());
			customer.setWorkRegion(srcCustomer.getWorkRegion());
			customer.setWorkContent(srcCustomer.getWorkContent());
			
		}else{
			//来源为成交客户
			
			customer = contractCustomerServices.findContractCustomerById(customerId);
			
			customer.setConfirmType(confirmType);
		}
		
		//客户来源类型及对应的id
		customer.setPreCustomerType(preCustomerType);
		customer.setPreCustomerId(customerId);
		
		init(0);
		if(ContConfirmType.CHIP.equals(confirmType)){
			return "copyForAddChipContractCustomer";
		}
		
		return "copyForAddContractCustomer";
	}
	
	/**
	 * 新增客户
	 * @return
	 * @throws Exception
	 */
	public String addContractCustomer() throws Exception{
		
		ActionTemplate.executeAjaxMethod(this, new ActionAjaxMethodModifyCallback() {
			
			@Override
			public void modifyMethod() throws Exception {
				if("".equals(customer.getHomeContent())&&customer.getHomeProvince()==0){
					throw new UnitChangeException();	
				}
				if("".equals(customer.getHouseholdContent())&&customer.getHouseholdProvince()==0){
					throw new UnitChangeException();
				}
				CompanyProject project = projectServices.findCompanyProjectById(customer.getProjectId());
				
				customer.setCompanyId(project.getCompanyId());
				customer.setUserId(SessionUser.getUserId());
				customer.setIsValid(CommonUtils.NORMAL);
				
				CommonPojoUtils.initPojoCommonFiled(customer);
				
				contractCustomerServices.addContractCustomer(customer);
				
				Map<String, String> succMap = new HashMap<String, String>();
				
				succMap.put("customerId", customer.getId() + "");
				succMap.put("customerName", customer.getCustomerName());
				succMap.put("mobilePhone", customer.getMobilePhone());
				
				setUpEasyuiAjaxForSucc("", succMap);
				
			}
			
			@Override
			public void modifyMethodException(Exception e) {
				
				String failTitle = "";
				
				String customerConfirmType = customer.getConfirmType();
				
				if(ContConfirmType.CHIP.equals(customerConfirmType)){
					
					failTitle = "新增认筹客户失败";
				}else if(ContConfirmType.CONFIRM_BOOK.equals(customerConfirmType)){
					
					failTitle = "新增临定客户失败";
				}else if(ContConfirmType.CONFIRM.equals(customerConfirmType)){
					
					failTitle = "新增成交客户失败";
				}
				if(e instanceof UnitChangeException){
					failTitle="户籍和居住区域的省份、内容必填其中之一";
				}
				
				setUpEasyuiAjaxForFail(failTitle);
				
			}
			
		});
		
		return null;
	}
	
	/**
	 * 跳到修改页面
	 * @return
	 * @throws Exception
	 */
	public String toModifyContractCustomer() throws Exception{
		
		int customerId = Integer.parseInt(request.getParameter("customerId"));
		
		customer = contractCustomerServices.findContractCustomerById(customerId);
		
		oldCustomerId=request.getParameter("oldCustomerId");
		
		init(0);
		
		if(ContConfirmType.CHIP.equals(customer.getConfirmType())){
			return "toModifyChipContractCustomer";
		}
		return "toModifyContractCustomer";
	}
	
	/**
	 * 跳到查看页面
	 * @return
	 * @throws Exception
	 */
	public String toModifyContractCustomerReadOnly() throws Exception{
		
		int customerId = Integer.parseInt(request.getParameter("customerId"));
		
		customer = contractCustomerServices.findContractCustomerById(customerId);
		
		oldCustomerId=request.getParameter("oldCustomerId");
		
		init(0);
		
		if(ContConfirmType.CHIP.equals(customer.getConfirmType())){
			return "toModifyChipContractCustomerReadOnly";
		}
		return "toModifyContractCustomerReadOnly";
	}
	
	/**
	 * 修改认筹,临定,成交,合同...时要获取的客户数据
	 * @return
	 * @throws Exception
	 */
	public String getContractCustomerJson() throws Exception{
		
		int mainId = Integer.parseInt(request.getParameter("mainId"));
		
		List<ContractCustomer> conCusList = contractCustomerServices.findContractCustomerByMainIdAndConfirmType(mainId, confirmType);
		
		JSONArray array = new JSONArray();
		JSONObject json = null;
		
		if(!CommonUtils.isCollectionEmpty(conCusList)){
			
			for(ContractCustomer con : conCusList){
				
				json = new JSONObject();
				
				json.put("customerId", con.getId());
				json.put("customerName", con.getCustomerName());
				json.put("mobilePhone", con.getMobilePhone());
				
				array.add(json);
			}
		}
		
		CustomerUtils.writeResponse(response, array.toString());
		
		return null;
	}
	
	/**
	 * 修改客户
	 * @return
	 * @throws Exception
	 */
	public String updateContractCustomer() throws Exception{
		
		ActionTemplate.executeAjaxMethod(this, new ActionAjaxMethodModifyCallback() {

			@Override
			public void modifyMethod() throws Exception {
				if("".equals(customer.getHomeContent())&&customer.getHomeProvince()==0){
					throw new UnitChangeException();	
				}
				if("".equals(customer.getHouseholdContent())&&customer.getHouseholdProvince()==0){
					throw new UnitChangeException();
				}
				CommonPojoUtils.initPojoCommonFiled(customer);
				if("".equals(request.getParameter("oldCustomerId"))){
					customer.setIsValid(CommonUtils.DELETED);
					contractCustomerServices.addContractCustomer(customer);
				}
				if("undefined".equals(request.getParameter("oldCustomerId"))){
					contractCustomerServices.updateContractCustomer(customer);
				}
				
				Map<String, String> succMap = new HashMap<String, String>();
				
				succMap.put("customerId", customer.getId() + "");
				succMap.put("customerName", customer.getCustomerName());
				succMap.put("mobilePhone", customer.getMobilePhone());
				
				setUpEasyuiAjaxForSucc("", succMap);
			}

			@Override
			public void modifyMethodException(Exception e) {

				String failTitle = "";
				
				String customerConfirmType = customer.getConfirmType();
				
				if(ContConfirmType.CHIP.equals(customerConfirmType)){
					
					failTitle = "修改认筹客户失败";
				}else if(ContConfirmType.CONFIRM_BOOK.equals(customerConfirmType)){
					
					failTitle = "修改临定客户失败";
				}else if(ContConfirmType.CONFIRM.equals(customerConfirmType)){
					
					failTitle = "修改成交客户失败";
				}
				if(e instanceof UnitChangeException){
					failTitle="户籍和居住区域的省份、内容必填其中之一";
				}
				
				
				setUpEasyuiAjaxForFail(failTitle);
			}
			
		});
		
		return null;
	}
	

	/**
	 * 修改认筹,临定,成交,合同...时要获取的客户数据
	 * @return
	 * @throws Exception
	 */
	public String getOldContractCustomerJson() throws Exception{
		
		String customerModuleId = request.getParameter("customerModuleId");
		
		List<Integer> conCusList=CommonUtils.stringToList(customerModuleId);
		 
		
		JSONArray array = new JSONArray();
		JSONObject json = null;
		
		if(!CommonUtils.isCollectionEmpty(conCusList)){
			
			for(Integer con : conCusList){
				
				ContractCustomer cc=contractCustomerServices.findContractCustomerById(con);
				json = new JSONObject();
				
				json.put("customerId", cc.getId());
				json.put("customerName", cc.getCustomerName());
				json.put("mobilePhone", cc.getMobilePhone());
				
				array.add(json);
			}
		}
		
		CustomerUtils.writeResponse(response, array.toString());
		
		return null;
	}
	
	
	

	/**
	 * 删除客户
	 * @return
	 * @throws Exception
	 */
	public String deleteContractCustomer() throws Exception{
		
		ActionTemplate.executeAjaxMethod(this, new ActionAjaxMethodModifyCallback() {
			
			@Override
			public void modifyMethodException(Exception e) {
				
				contractCustomerServices.deleteContractCustomer(Integer.parseInt(request.getParameter("id")));
			}
			
			@Override
			public void modifyMethod() throws Exception {
			}
		});
		
		return null;
	}
	
	/**
	 * 根据成交客户,获取页面显示选择的list
	 * @param contractCustomerList
	 * @param copyCustomerConfirmType
	 * @return
	 */
	private List<CopyCustomerPojo> getCopyCustomerPojoFromContractCustomerList(List<ContractCustomer> contractCustomerList, String copyCustomerConfirmType){
		
		List<CopyCustomerPojo> retList = new ArrayList<CopyCustomerPojo>();
		
		if(!CommonUtils.isCollectionEmpty(contractCustomerList)){
			
			String source = "";
			if(ContConfirmType.CHIP.equals(copyCustomerConfirmType)){
				
				source = "(" + ContConfirmType.CHIP_STR_CN + ")";
				
			}else if(ContConfirmType.CONFIRM_BOOK.equals(copyCustomerConfirmType)){
				
				source = "(" + ContConfirmType.CONFIRM_BOOK_STR_CN + ")";
				
			}else if(ContConfirmType.CONFIRM.equals(copyCustomerConfirmType)){
				
				source = "(" + ContConfirmType.CONFIRM_STR_CN + ")";
				
			}else if(ContConfirmType.CONTRACT.equals(copyCustomerConfirmType)){
				
				source = "(" + ContConfirmType.CONTRACT_STR_CN + ")";
				
			}
			
			CopyCustomerPojo pojo = null;
			
			for(ContractCustomer cus : contractCustomerList){
				
				if(cus.getMainId() <= 0)
					continue;
				
				pojo = new CopyCustomerPojo(cus.getId(), cus.getCustomerName() + source, 
						copyCustomerConfirmType, getUnitNameByContractCustomer(cus), 
						getSalesIdByContractCustomer(cus), getSalesNameByContractCustomer(cus));
				
				retList.add(pojo);
			}
		}
		
		return retList;
	}
	
	/**
	 * 根据售前客户,获取页面显示选择的list
	 * @param customerList
	 * @param copyCustomerConfirmType
	 * @return
	 */
	private List<CopyCustomerPojo> getCopyCustomerPojoFromCustomerList(List<Customer> customerList, String copyCustomerConfirmType){
		
		List<CopyCustomerPojo> retList = new ArrayList<CopyCustomerPojo>();
		
		if(!CommonUtils.isCollectionEmpty(customerList)){
			
			CopyCustomerPojo pojo = null;
			
			String source = "";
			
			for(Customer cus : customerList){
				
				source = DescUtils.getCodeDesc(EnumCodeTypeName.CUSTOMER_SOURCE, cus.getCustomerSource(), cus.getProjectId());
				if(!CommonUtils.isStrEmpty(source)){
					source = "(" + source + ")";
				}
				
				pojo = new CopyCustomerPojo(cus.getId(), cus.getCustomerName() + source, copyCustomerConfirmType
						,"", cus.getUserId() + "", getSalesNameByContractCustomer(cus));
				
				retList.add(pojo);
			}
		}
		
		return retList;
	}
	
	/**
	 * 根据成交客户获取对应的销售id
	 * @param cus
	 * @return
	 */
	private String getSalesIdByContractCustomer(ContractCustomer cus){
		
		try{
			
			String ret = "";
		
			String confirmType = cus.getConfirmType();
			int mainId = cus.getMainId();
			
			if(ContConfirmType.CHIP.equals(confirmType)){
				
				Chip chip = MyPropertyUtils.getChipServices().findChipById(mainId);
				if(chip != null){
					
					ret = chip.getSalesId();
				}
				
			}else if(ContConfirmType.CONFIRM_BOOK.equals(confirmType)){
				
				ConfirmBook book = MyPropertyUtils.getConfirmBookServices().findConfirmBookById(mainId);
				if(book != null){
					
					ret = book.getSalesId();
				}
				
			}else if(ContConfirmType.CONFIRM.equals(confirmType)){
				
				Confirm confirm = MyPropertyUtils.getConfirmServices().findConfirmById(mainId);
				if(confirm != null){
					
					ret = confirm.getSalesId();
				}
				
			}else if(ContConfirmType.CONTRACT.equals(confirmType)){
				
				Contract contract = MyPropertyUtils.getContractServices().findContractById(mainId);
				if(contract != null){
					
					ret = contract.getSalesId();
				}
			}
			
			return ret;
			
		}catch (Exception e) {
			
			return "";
		}
	}
	
	/**
	 * 根据成交客户获取对应的销售名称
	 * @param cus
	 * @return
	 */
	private String getSalesNameByContractCustomer(ContractCustomer cus){
		
		try{
			
			String ret = "";
		
			String confirmType = cus.getConfirmType();
			int mainId = cus.getMainId();
			
			if(ContConfirmType.CHIP.equals(confirmType)){
				
				Chip chip = MyPropertyUtils.getChipServices().findChipById(mainId);
				if(chip != null){
					
					ret = chip.getSalesName();
				}
				
			}else if(ContConfirmType.CONFIRM_BOOK.equals(confirmType)){
				
				ConfirmBook book = MyPropertyUtils.getConfirmBookServices().findConfirmBookById(mainId);
				if(book != null){
					
					ret = book.getSalesName();
				}
				
			}else if(ContConfirmType.CONFIRM.equals(confirmType)){
				
				Confirm confirm = MyPropertyUtils.getConfirmServices().findConfirmById(mainId);
				if(confirm != null){
					
					ret = confirm.getSalesName();
				}
				
			}else if(ContConfirmType.CONTRACT.equals(confirmType)){
				
				Contract contract = MyPropertyUtils.getContractServices().findContractById(mainId);
				if(contract != null){
					
					ret = contract.getSalesName();
				}
			}
			
			return ret;
			
		}catch (Exception e) {
			
			return "";
		}
	}
	
	/**
	 * 获取售前客户的销售人员
	 * @param cus
	 * @return
	 */
	private String getSalesNameByContractCustomer(Customer cus){
		
		String ret = cus.getDescUserId();
		
		return ret == null ? "" : ret;
	}
	
	/**
	 * 根据成交客户获取单元名称:分区,楼栋,单元编号
	 * @param cus
	 * @return
	 */
	private String getUnitNameByContractCustomer(ContractCustomer cus){
		
		try{
			
			String ret = "";
		
			String confirmType = cus.getConfirmType();
			int mainId = cus.getMainId();
			
			if(ContConfirmType.CHIP.equals(confirmType)){
				
				Chip chip = MyPropertyUtils.getChipServices().findChipById(mainId);
				if(chip != null){
					
					ret = getUnitNameByUnitIdForCopyCustomerPojo(chip.getUnitId1());
				}
				
			}else if(ContConfirmType.CONFIRM_BOOK.equals(confirmType)){
				
				ConfirmBook book = MyPropertyUtils.getConfirmBookServices().findConfirmBookById(mainId);
				if(book != null){
					
					ret = getUnitNameByUnitIdForCopyCustomerPojo(book.getUnitId());
				}
				
			}else if(ContConfirmType.CONFIRM.equals(confirmType)){
				
				Confirm confirm = MyPropertyUtils.getConfirmServices().findConfirmById(mainId);
				if(confirm != null){
					
					ret = getUnitNameByUnitIdForCopyCustomerPojo(confirm.getUnitId());
				}
				
			}else if(ContConfirmType.CONTRACT.equals(confirmType)){
				
				Contract contract = MyPropertyUtils.getContractServices().findContractById(mainId);
				if(contract != null){
					
					ret = getUnitNameByUnitIdForCopyCustomerPojo(contract.getUnitId());
				}
			}
			
			return ret;
			
		}catch (Exception e) {
			
			return "";
		}
	}
	
	/**
	 * 根据单元id获取:分区,楼栋,单元编号
	 * @param unitId
	 * @return
	 */
	private String getUnitNameByUnitIdForCopyCustomerPojo(int unitId){
		
		PropertyUnit unit = MyPropertyUtils.getPropertyUnitServices().findPropertyUnitById(unitId);
		
		return unit.getUnitTreeName();
	}
	
	/**
	 * 根据项目,号码及类型获取对应的成交客户
	 * @param projectId
	 * @param mobilePhone
	 * @param confirmType
	 * @return
	 */
	private List<ContractCustomer> getContractCustomerList(String projectId, String mobilePhone, String confirmType){
		
		ContractCustomerCond cond = new ContractCustomerCond();
		
		cond.setProjectId(projectId);
		cond.setMobilePhone(mobilePhone);
		cond.setIsValid(CommonUtils.NORMAL);
		cond.setConfirmType(confirmType);
		
		List<ContractCustomer> contractCustomerList = contractCustomerServices.findValidCustomerByProjectIdPhoneType(cond);
		
		return contractCustomerList;
	}
	
	/**
	 * 初始化相关的数据
	 */
	private void init(int unitId){
		
		if(unitId > 0){
			unit = unitServices.findPropertyUnitById(unitId);
		}
		
		selCustomerGender = DescUtils.getInitSelEmptyAndGender(selCustomerGender);
		selCustomerIdCardType = DescUtils.getInitSelForGuangZhou(selCustomerIdCardType, EnumCodeTypeName.SALEUNIT_IDCARD_TYPE, true);
	}
	
	////
	private ContractCustomer customer;
	
	/**
	 * 新建客户,性别
	 */
	private LinkedHashMap selCustomerGender; //新建客户,性别
	
	/**
	 * 新建客户,证件类型
	 */
	private LinkedHashMap selCustomerIdCardType; //新建客户,证件类型
	
	/**
	 * 要新增的成交客户的客户类型
	 */
	private String confirmType;
	
	/**
	 * 已选择的销售id
	 */
	private String salesId;
	
	/**
	 * 单元
	 */
	private PropertyUnit unit;
	
	/**
	 * 供copy的客户list
	 */
	private List<CopyCustomerPojo> copyCusList;
	
	private String oldCustomerId;
	
	public String getOldCustomerId() {
		return oldCustomerId;
	}

	public void setOldCustomerId(String oldCustomerId) {
		this.oldCustomerId = oldCustomerId;
	}

	public void setCopyCusList(List<CopyCustomerPojo> copyCusList) {
		this.copyCusList = copyCusList;
	}
	
	public List<CopyCustomerPojo> getCopyCusList() {
		return copyCusList;
	}
	
	public void setSalesId(String salesId) {
		this.salesId = salesId;
	}
	
	public String getSalesId() {
		return salesId;
	}
	
	public void setUnit(PropertyUnit unit) {
		this.unit = unit;
	}
	
	public PropertyUnit getUnit() {
		return unit;
	}
	
	public void setConfirmType(String confirmType) {
		this.confirmType = confirmType;
	}
	
	public String getConfirmType() {
		return confirmType;
	}
	
	public void setSelCustomerGender(LinkedHashMap selCustomerGender) {
		this.selCustomerGender = selCustomerGender;
	}
	
	public LinkedHashMap getSelCustomerGender() {
		return selCustomerGender;
	}
	
	public void setSelCustomerIdCardType(LinkedHashMap selCustomerIdCardType) {
		this.selCustomerIdCardType = selCustomerIdCardType;
	}
	
	public LinkedHashMap getSelCustomerIdCardType() {
		return selCustomerIdCardType;
	}
	
	public void setCustomer(ContractCustomer customer) {
		this.customer = customer;
	}
	
	public ContractCustomer getCustomer() {
		return customer;
	}


}
