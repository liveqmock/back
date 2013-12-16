package com.ihk.junit.import_confirm.template;

import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import jxl.Cell;

import org.junit.Test;

import com.ihk.constanttype.ContConfirmType;
import com.ihk.constanttype.ContUnitSaleState;
import com.ihk.junit.SupperJunit;
import com.ihk.junit.import_confirm.utils.ExceptionDataPojo;
import com.ihk.junit.import_confirm.utils.ExceptionDataUtils;
import com.ihk.junit.import_confirm.utils.LogDataUtils;
import com.ihk.junit.import_confirm.utils.RealXlsUtils;
import com.ihk.junit.import_confirm.utils.WriterTxtUtils;
import com.ihk.property.data.pojo.PropertyBuild;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.services.IPropertyBuildServices;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.saleunit.data.pojo.Confirm;
import com.ihk.saleunit.data.pojo.Contract;
import com.ihk.saleunit.data.pojo.ContractCustomer;
import com.ihk.saleunit.data.services.IConfirmServices;
import com.ihk.saleunit.data.services.IContractCustomerServices;
import com.ihk.saleunit.data.services.IContractServices;
import com.ihk.setting.data.pojo.City;
import com.ihk.setting.data.pojo.CityCond;
import com.ihk.setting.data.pojo.Province;
import com.ihk.setting.data.pojo.ProvinceCond;
import com.ihk.setting.data.pojo.Region;
import com.ihk.setting.data.pojo.RegionCond;
import com.ihk.setting.data.services.ICityServices;
import com.ihk.setting.data.services.IProvinceServices;
import com.ihk.setting.data.services.IRegionServices;
import com.ihk.user.data.pojo.CompanyProject;
import com.ihk.user.data.pojo.UserAccount;
import com.ihk.user.data.services.ICompanyProjectServices;
import com.ihk.user.data.services.IUserAccountServices;
import com.ihk.utils.CommonPojoUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.MyTransationTemplate;
import com.ihk.utils.contract.sale.SaleUtils;
import com.ihk.utils.saleunit.PayWayUtils;

/**
 * 合同模板
 * @author dtc
 * 2013-9-29,下午02:37:37
 */
public class ImportContractTemplate extends SupperJunit{
	
	IPropertyUnitServices propertyUnitServices = (IPropertyUnitServices) factory.getBean("propertyUnitServices");
	
	IPropertyBuildServices propertyBuildServices = (IPropertyBuildServices) factory.getBean("propertyBuildServices");
	
	ICompanyProjectServices companyProjectServices = (ICompanyProjectServices) factory.getBean("companyProjectServices");
	
	IConfirmServices confirmServices = (IConfirmServices) factory.getBean("confirmServices");
	
	IContractServices contractServices = (IContractServices) factory.getBean("contractServices");
	
	IContractCustomerServices contractCustomerServices = (IContractCustomerServices) factory.getBean("contractCustomerServices");
	
	IProvinceServices provinceServices = (IProvinceServices) factory.getBean("provinceServices");
	
	ICityServices cityServices = (ICityServices) factory.getBean("cityServices");
	
	IRegionServices regionServices = (IRegionServices) factory.getBean("regionServices");
	
	IUserAccountServices userAccountServices = (IUserAccountServices) factory.getBean("userAccountServices");
	
	final static String pattern = "yyyy-MM-dd";
	
	@Test
	public void _import() throws Exception{
		
		//1. buildId, 2900
		
		/*int buildId = 2886; 
		int companyProjectId = 51;
		int propertyProjectId = 382;
		
		int createdId = -1;
		
		String file = "C:\\contract\\2.xls";
		file = "c:\\contract\\2_exception.xls";
		
		importData(companyProjectId, buildId, propertyProjectId, createdId, file);*/
		
		moreImportData();
		
	}
	
	/**
	 * 遍历文件夹下的所有文件,文件名为楼栋id
	 */
	private void moreImportData(){
		
		File file = new File("C:\\contract");
		
		File[] files = file.listFiles();
		
		for(File f : files){
			
			String fileName = f.getAbsolutePath();
			if("C:\\contract\\exception".equalsIgnoreCase(fileName)){
				continue;
			}
			
			int buildId = getBuildIdByFileName(fileName);
			if(buildId == 0){
				continue;
			}
			
			//根据楼栋id获取companyProjectId,propertyProjectId
			PropertyBuild build = propertyBuildServices.findPropertyBuildById(buildId);
			
			if(build == null || build.getCompanyProjectId() <= 0 || build.getPropertyId() <= 0){
				
				try {
					WriterTxtUtils.writerTxt("C:\\contract\\exception\\有异常的成交文档.txt", fileName + "\r\n", true);
				} catch (Exception e) {
					e.printStackTrace();
				} 
				
				continue;
			}
			
			try {
				importData(build.getCompanyProjectId(), buildId, build.getPropertyId(), -1, f.getAbsolutePath());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			LogDataUtils.log(LogDataUtils.CONTRACT_TYPE, fileName.replace("C:\\contract\\", "").replace("c:\\contract\\", ""));
		}
		
	}
	
	/**
	 * 实际的数据导入
	 * @param companyProjectId
	 * @param buildId
	 * @param propertyProjectId
	 * @param createdId
	 * @param file
	 * @throws Exception
	 */
	private void importData(final int companyProjectId, int buildId, final int propertyProjectId, final int createdId, 
			String file) throws Exception{
		
		final int companyId = getCompanyIdByCompanyProjectId(companyProjectId);
		
		final List<Province> proList = provinceServices.findProvince(new ProvinceCond());
		final List<City> cityList = cityServices.findCity(new CityCond());
		final List<Region> regionList = regionServices.findRegion(new RegionCond());
		
		List<Cell[]> cellList = RealXlsUtils.realXls(file);
		
		//2. 
		final Map<String, String> payWayMap = getPayWayMapByBuildId(buildId);
		
		List<ExceptionDataPojo> exceptionPojoList = new ArrayList<ExceptionDataPojo>();
		ExceptionDataPojo exPojo = null;
		
		for(final Cell[] cell : cellList){
			
			String floorNum = cell[3].getContents().trim().replace("'", ""); //楼层
			String roomNo = cell[4].getContents().trim().replace("'", "");; //房号
			
			//保留第一行,输出异常文档的时候会判断是否只有一条数据,如果只是一条,不用输出
			if("楼层".equals(floorNum) && "房号".equals(roomNo)){
				
				exPojo = new ExceptionDataPojo(cell, "");
				exceptionPojoList.add(exPojo);
				
				continue;
			}
			
			//判断文档中的数据与文档名称是否一致
			try{
				
				if(!propertyName.trim().equals(cell[0].getContents().trim()) || !areaName.trim().equals(cell[1].getContents().trim()) 
						|| !buildName.trim().equals(cell[2].getContents().trim())){
					
					exPojo = new ExceptionDataPojo(cell, "文件名与文档中的项目_分区_楼栋不一致");
					exceptionPojoList.add(exPojo);
					
					continue;
				}
				
			}catch (Exception e) {
				
				exPojo = new ExceptionDataPojo(cell, "文件名与文档中的项目_分区_楼栋不一致");
				exceptionPojoList.add(exPojo);
				
				continue;
				
			}
			
			//3.
			final PropertyUnit unit = getUnit(buildId, cell, true);
			if(unit == null || !ContUnitSaleState.CONFIRM.equals(unit.getSaleState())){
			//if(unit == null){
				//获取的单元不能进行成交
				
				exPojo = new ExceptionDataPojo(cell, "单元为空或单元状态不合法");
				exceptionPojoList.add(exPojo);
				
				continue;
			}
			
			final Confirm confirm = confirmServices.findConfirmByUnitId(unit.getId());
			if(confirm == null){
				
				exPojo = new ExceptionDataPojo(cell, "没有对应的成交单");
				exceptionPojoList.add(exPojo);
				
				continue;
			}
			
			try{
				
				new MyTransationTemplate() {
					
					@Override
					protected void doExecuteCallback() throws Exception {
						
						PropertyUnit updateUnit = getUpdateUnit(cell, unit);
						
						//修改单元"建筑面积","套内面积","标准总价 ",修改房间的状态
						updateUnit.setSaleState(ContUnitSaleState.CONTRACT);
						propertyUnitServices.updatePropertyUnit(updateUnit);
						
						//新增合同
						Contract contract = getContract(cell, unit, pattern, payWayMap, createdId, confirm, propertyProjectId);
						
						//设置销售
						contract = setContractSalesId(cell, contract);
						
						contractServices.addContract(contract);
						
						//新增客户
						List<ContractCustomer> cusList = getCustomers(cell, companyId, companyProjectId, ContConfirmType.CONTRACT, 
								contract.getId(), proList, cityList, regionList);
						
						if(!CommonUtils.isCollectionEmpty(cusList)){
							
							for(ContractCustomer cus : cusList){
								
								contractCustomerServices.addContractCustomer(cus);
							}
						}
					}
				}.execute();
				
			}catch (Exception e) {
				e.printStackTrace();
				
				String message = e.getMessage();
				if(message != null && message.contains("Data too long for column 'idcard_no'")){
					message = "证件号码不合法";
				}else if(message != null && message.contains("Out of range value for column 'inside_area'")){
					message = "套内面积不合法";
				}
				
				exPojo = new ExceptionDataPojo(cell, message);
				exceptionPojoList.add(exPojo);
				
			}
			
		}
		
		//输出有错数据 exceptionPojoList
		String exceFileName = getExcelFileName(file);
		ExceptionDataUtils.writerXlsByJxl(exceptionPojoList, exceFileName, 31);
		
	}
	
	/**
	 * 文件名格式: 楼盘项目名称,分区名称,楼栋名称(楼栋id)
	 * 如:C:\contract\御名峰公馆,御名峰公馆,1座(2779).xls
	 * 根据文件名获取楼栋id
	 * @param fileName
	 * @return
	 */
	private int getBuildIdByFileName(String fileName){
		
		//C:\contract\御名峰公馆,御名峰公馆,1座(2779).xls
		
		fileName = fileName.replace("，", ",").replace("（", "(").replace("）", ")");
		
		int start = fileName.lastIndexOf("\\");
		int end = fileName.lastIndexOf(".");
		
		fileName = fileName.substring(start+1, end);
		
		String[] arr = fileName.split(",");
		
		propertyName = arr[0]; //楼盘项目名称
		areaName = arr[1]; //分区名称
		
		String buildNameAndId = arr[2]; //1座(2779)
		
		int limitStart = buildNameAndId.lastIndexOf("(");
		
		buildName = buildNameAndId.substring(0, limitStart); //楼栋名称
		int buildId = Integer.parseInt(buildNameAndId.substring(limitStart+1, buildNameAndId.length()-1));
		
		//判断 propertyName areaName buildName buildId 是否一致
		
		//根据id获取其全名:项目-分区-楼栋
		String allName = propertyBuildServices.findPropertyBuildAllNameByBuildId(buildId);
		if(!(propertyName + "-" + areaName + "-" + buildName).equals(allName)){
			
			try {
				WriterTxtUtils.writerTxt("C:\\contract\\exception\\有异常的合同文档.txt", fileName + "\r\n", true);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return 0;
		}
		
		return buildId;
	}
	
	/**
	 * 根据读取的文件名获取异常的文件名
	 * @param file
	 * @return
	 */
	private static String getExcelFileName(String file){
		
		int limitIndex = file.lastIndexOf("\\");
		
		int index = file.lastIndexOf(".");
		
		return file.substring(0, limitIndex) + File.separator + "exception" + 
			file.substring(limitIndex, index) + "" + file.substring(index);
	}
	
	/**
	 * 设置合同的销售人员
	 * @param cell
	 * @param contract
	 * @return
	 * @throws Exception 
	 */
	private Contract setContractSalesId(Cell[] cell, Contract contract) throws Exception{
		
		StringBuffer sb = new StringBuffer();
		
		String sales = cell[29].getContents();
		if(!CommonUtils.isStrEmpty(sales)){
			
			sales = sales.replace("，", ","); //huzhenxiang，huanghuimin
			
			String[] names = sales.split(",");
			
			for(String userName : names){
				
				//如果销售名称有中文就放到备注中
				if(CommonUtils.isIncludeChinese(userName)){
					
					contract.setRemark(contract.getRemark() + ",销售：" + userName);
					continue;
				}
				
				UserAccount userAccount = userAccountServices.findUserAccountByUserNameIncludeDelete(userName);
				if(userAccount == null){
					
					throw new Exception("销售有问题");
				}
				
				sb.append(userAccount.getId()).append(",");
				
			}
			
			contract.setSalesId(sb.toString());
			
			contract = SaleUtils.initSalesId(contract);
		}
		
		return contract;
	}
	
	
	/**
	 * 获取一行数据对应的单元,如果返回null表示该行对应的数据有问题
	 * @param buildId
	 * @param cell
	 * @param isChangeEmpty, 是否去掉前面的0
	 * @return
	 */
	private PropertyUnit getUnit(int buildId, Cell[] cell, boolean isChangeEmpty){
		
		PropertyUnit unit = null;
		List<PropertyUnit> unitList = null;
		
		try{
			String floorNum = cell[3].getContents().trim().replace("'", ""); //楼层
			String roomNo = cell[4].getContents().trim().replace("'", "");; //房号
			
			if("楼层".equals(floorNum) && "房号".equals(roomNo)){
				return unit;
			}
			
			/*if(isChangeEmpty){
				roomNo = Integer.parseInt(roomNo) + "";
			}*/
			
			unitList = propertyUnitServices.findUnitByBuildIdAndFloorNumAndRoomNo(buildId, floorNum, roomNo);
			if(CommonUtils.isCollectionEmpty(unitList)){
				
				if(CommonUtils.isIntString(roomNo)){
					unitList = propertyUnitServices.findUnitByBuildIdAndFloorNumAndRoomNo(buildId, floorNum, Integer.parseInt(roomNo) + "");
				}
			}
			
			if(!CommonUtils.isCollectionEmpty(unitList)){
				
				unit = unitList.get(unitList.size()-1);
			}
			
		}catch (Exception e) {
		}
		
		return unit;
	}
	
	/**
	 * 返回要更新的单元
	 * @param cell
	 * @param unit
	 * @return
	 * @throws Exception 
	 */
	private PropertyUnit getUpdateUnit(Cell[] cell, PropertyUnit unit) throws Exception{
		
		BigDecimal buildArea = new BigDecimal(0); //建筑面积 
		try{
			buildArea = new BigDecimal(cell[5].getContents().trim());
		}catch (Exception e) {
			throw new Exception("建筑面积有问题");
		}
		
		BigDecimal insideArea = new BigDecimal(0); //套内面积 
		try{
			insideArea = new BigDecimal(cell[6].getContents().trim());
		}catch (Exception e) {
			//throw new Exception("套内面积有问题");
		}
		
		BigDecimal sumPrice = new BigDecimal(0); //标准总价 
		try{
			sumPrice = new BigDecimal(cell[10].getContents().trim());
		}catch (Exception e) {
			//throw new Exception("标准总价有问题");
		}
		
		BigDecimal buildPrice = new BigDecimal(0); //建筑单价 
		try{
			buildPrice = sumPrice.divide(buildArea, RoundingMode.HALF_UP);
		}catch (Exception e) {
			//throw new Exception("建筑单价有问题");
		}
		
		BigDecimal insidePrice = new BigDecimal(0); //套内单价 
		try{
			insidePrice = sumPrice.divide(insideArea, RoundingMode.HALF_UP);
		}catch (Exception e) {
			//throw new Exception("套内单价有问题");
		}
		
		unit.setBuildArea(buildArea);
		unit.setInsideArea(insideArea);
		unit.setSumPrice(sumPrice);
		unit.setBuildPrice(buildPrice);
		unit.setInsidePrice(insidePrice);
		
		return unit;
	}
	                                     
	
	/**
	 * 根据楼栋id获取对应的付款方式map
	 * @param buildId
	 * @return
	 */
	private Map<String, String> getPayWayMapByBuildId(int buildId){
		
		PropertyBuild build = propertyBuildServices.findPropertyBuildById(buildId);
		
		int projectId = build.getPropertyId();
		
		return PayWayUtils.getSelPayWayByProjectId(projectId);
	}
	
	/**
	 * 获取付款方式对应的值
	 * @param cell
	 * @param payWayMap
	 * @return
	 */
	private int getPayWayId(Cell[] cell, Map<String, String> payWayMap){
		
		int ret = 0;
		
		try{
			
			String payWay = cell[7].getContents();
			
			Set<String> keys = payWayMap.keySet();
			
			for(String key : keys){
				
				String value = payWayMap.get(key);
				if(payWay.equals(value)){
					
					ret = Integer.parseInt(key);
					break;
				}
			}
			
		}catch (Exception e) {
			ret = 0;
		}
		
		return ret;
	}
	
	/**
	 * 返回合同
	 * @param cell
	 * @param unit
	 * @param pattern
	 * @param payWayMap
	 * @param createdId
	 * @param confirm
	 * @param propertyProjectId
	 * @return
	 * @throws Exception
	 */
	private Contract getContract(Cell[] cell, PropertyUnit unit, String pattern, Map<String, String> payWayMap, 
			int createdId, Confirm confirm, int propertyProjectId) throws Exception{
		
		//合同编号	成交日期	 成交总价
		
		Contract contract = new Contract();
		
		String contractNo = cell[8].getContents();
		if(!CommonUtils.isStrEmpty(contractNo)){
			
			contractNo = contractNo.trim();
		}
		
		Date signDate = null;
		try {
			signDate = initDate(cell[9].getContents(), "20"); //合同日期
			
		} catch (ParseException e) {

			throw new Exception("合同日期有问题");
			
		}
		
		
		BigDecimal buildArea = new BigDecimal(0); //建筑面积 
		try{
			buildArea = new BigDecimal(cell[5].getContents().trim());
		}catch (Exception e) {
			//throw new Exception("建筑面积有问题");
		}
		
		BigDecimal insideArea = new BigDecimal(0); //套内面积 
		try{
			insideArea = new BigDecimal(cell[6].getContents().trim());
		}catch (Exception e) {
			//throw new Exception("套内面积有问题");
		}
		
		String sumMoneyStr = cell[11].getContents(); //成交总价 
		BigDecimal sumMoney = new BigDecimal(0);
		try{
			sumMoney = new BigDecimal(sumMoneyStr.trim());
		}catch (Exception e) {
			//throw new Exception("成交总价有问题");
		}
		
		BigDecimal buildPrice = new BigDecimal(0); //建筑成交单价 
		try{
			buildPrice = sumMoney.divide(buildArea, RoundingMode.HALF_UP); 
		}catch (Exception e) {
		}
		
		BigDecimal insideUnitPrice = new BigDecimal(0); //套内成交单价
		try{
			insideUnitPrice = sumMoney.divide(insideArea, RoundingMode.HALF_UP); 
		}catch (Exception e) {
		}
		
		contract.setConfirmId(confirm.getId());

		contract.setPayWayId(getPayWayId(cell, payWayMap));
		
		contract.setUnitId(unit.getId());
		contract.setContractNo(contractNo);
		contract.setSignDate(signDate);
		contract.setSumMoney(sumMoney);
		contract.setBuildPrice(buildPrice);
		contract.setInsideUnitPrice(insideUnitPrice);
		
		contract.setPropertyProjectId(propertyProjectId);
		
		contract.setIsDeleted(CommonUtils.NORMAL);
		contract.setCreatedId(createdId);
		contract.setCreatedTime(new Date());
		contract.setModId(createdId);
		contract.setModTime(new Date());
		
		return contract;
	}
	
	/**
	 * 格式化日期
	 * @param cell
	 * @return
	 * @throws ParseException 
	 */
	private static Date initDate(String dateStr, String limit) throws ParseException{
		
		if(CommonUtils.isStrEmpty(dateStr)){
			
			return null;
		}
		
		String date = dateStr.trim().replace("/", "-");
		String[] array = date.split("-");
		if(array[0].length() == 2){
			
			date = limit + date;
		}
		
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		Date retDate =(Date)df.parse(date.trim().replace("'", "")); 
		
		return retDate;
	}
	
	
	/**
	 * 获取公司id
	 * @param companyProjectId
	 * @return
	 */
	private int getCompanyIdByCompanyProjectId(int companyProjectId){
		
		CompanyProject companyProject = companyProjectServices.findCompanyProjectById(companyProjectId);
		
		return companyProject == null ? 0 : companyProject.getCompanyId();
	}
	
	/**
	 * 获取成交客户list,以客户姓名为准
	 * @param cell
	 * @param companyId
	 * @param companyProjectId
	 * @param confirmType
	 * @param mainId
	 * @return
	 * @throws Exception 
	 */
	private List<ContractCustomer> getCustomers(Cell[] cell, int companyId, int companyProjectId,
			String confirmType, int mainId,
			List<Province> proList, List<City> cityList, List<Region> regionList) throws Exception{
		//客户姓名	手机号码	固定电话 	性别 15	证件类型 	证件号码	生日 	
		//通讯地址	邮编	户籍省	户籍市	户籍区	户籍自填	居住区域省	居住区域市	居住区域区	居住区域自填
		
		List<ContractCustomer> retList = new ArrayList<ContractCustomer>();
		
		String target = "，";
		String source = ",";
		
		String name = cell[12].getContents().trim().replace("'", "").replace("、", ",").replace("，", ",").replace(target, source);
		String[] nameArr = name.split(",");
		
		int length = nameArr.length;
		
		ContractCustomer customer = null;
		
		for(int i=0; i<length; i++){
			
			customer = new ContractCustomer();
			
			customer.setCustomerName(nameArr[i].trim());
			
			customer.setMobilePhone(getArrayVal(cell[13].getContents(), length, i));
			customer.setPhone(getArrayVal(cell[14].getContents(), length, i));
			
			customer.setGender(getArrayVal(getGender(cell[15].getContents()), length, i));
			
			String idcardType = getArrayVal(getIdcardType(cell[16].getContents()), length, i);
			if(CommonUtils.isStrEmpty(idcardType)){
				idcardType = "1";
			}
			customer.setIdcardType(idcardType);//证件类型默认为1
			
			customer.setIdcardNo(getArrayVal(cell[17].getContents(), length, i));
			
			customer.setBirthday(getBirthday(cell[18].getContents(), pattern)); //生日
			
			customer.setAddress(getArrayVal(cell[19].getContents(), length, i)); //通信地址
			
			customer.setPostcode(getArrayVal(cell[20].getContents(), length, i)); //邮编
			
			customer.setHouseholdProvince(getProvince(proList, getArrayVal(cell[21].getContents(), length, i)));
			customer.setHouseholdCity(getCity(cityList, getArrayVal(cell[22].getContents(), length, i)));
			customer.setHouseholdRegion(getRegion(regionList, getArrayVal(cell[23].getContents(), length, i)));
			customer.setHouseholdContent(getArrayVal(cell[24].getContents(), length, i));
			
			customer.setHomeProvince(getProvince(proList, getArrayVal(cell[25].getContents(), length, i)));
			customer.setHomeCity(getCity(cityList, getArrayVal(cell[26].getContents(), length, i)));
			customer.setHomeRegion(getRegion(regionList, getArrayVal(cell[27].getContents(), length, i)));
			try{
				customer.setHomeContent(getArrayVal(cell[28].getContents(), length, i));
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			customer.setCompanyId(companyId);
			customer.setProjectId(companyProjectId);
			customer.setIsValid(CommonUtils.NORMAL);
			customer.setConfirmType(confirmType);
			customer.setMainId(mainId);
			
			CommonPojoUtils.initPojoCommonFiled(customer);
			
			retList.add(customer);
			
		}

		return retList;
	}
	
	/**
	 * 获取生日
	 * @param day
	 * @return
	 */
	private static Date getBirthday(String day, String pattern){
		
		/*if(CommonUtils.isStrEmpty(day)){
			
			return null;
		}
		
		Date retDate = null;
		
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		try {
			retDate =(Date)df.parse("19" + day.trim());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return retDate;*/
		
		try {
			
			return initDate(day, "19");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * 获取省
	 * @param proList
	 * @param province
	 * @return
	 */
	private int getProvince(List<Province> proList, String province){
		
		if(CommonUtils.isStrEmpty(province)){
			
			return 0;
		}
		
		int ret = 0;
		
		for(Province pro : proList){
			
			if(province.equals(pro.getProvinceName())){
				
				ret = pro.getProvinceId();
				break;
			}
		}
		
		return ret;
	}
	
	/**
	 * 获取市
	 * @param cityList
	 * @param city
	 * @return
	 */
	private int getCity(List<City> cityList, String city){
		
		if(CommonUtils.isStrEmpty(city)){
			
			return 0;
		}
		
		int ret = 0;
		
		for(City c : cityList){
			
			if(city.equals(c.getCityName())){
				
				ret = c.getCityId();
				break;
			}
		}
		
		return ret;
	}
	
	/**
	 * 获取区
	 * @param regionList
	 * @param region
	 * @return
	 */
	private int getRegion(List<Region> regionList, String region){
		
		if(CommonUtils.isStrEmpty(region)){
			
			return 0;
		}
		
		int ret = 0;
		
		for(Region r : regionList){
			
			if(region.equals(r.getRegionName())){
				
				ret = r.getRegionId();
				break;
			}
		}
		
		return ret;
	}
	
	/**
	 * 获取证件类型
	 * 身份证，驾驶证，士官证，护照，其他
	 * @param idcardType
	 * @return
	 */
	private String getIdcardType(String idcardType){
		
		if(CommonUtils.isStrEmpty(idcardType)){
			
			return "";
		}
		
		if("身份证".equals(idcardType)){
			
			return "1";
		}
		
		if("驾驶证".equals(idcardType)){
			
			return "2";
		}
		
		if("士官证".equals(idcardType)){
			
			return "3";
		}
		
		if("护照".equals(idcardType)){
			
			return "4";
		}
		
		if("其他".equals(idcardType)){
			
			return "5";
		}
		
		return "";
	}
	
	/**
	 * 性别
	 * @param gender
	 * @return
	 */
	private String getGender(String gender){
		
		if(CommonUtils.isStrEmpty(gender)){
			
			return "";
		}
		
		if("男".equals(gender)){
			
			return "1";
		}
		
		if("女".equals(gender)){
			
			return "0";
		}
		
		return "";
	}
	
	/**
	 * 获取值
	 * @param val
	 * @param nameLength
	 * @param nameIndex
	 * @return
	 */
	private String getArrayVal(String val, int nameLength, int nameIndex){
		
		String ret = "";
		
		if(CommonUtils.isStrEmpty(val)){
			
			return ret;
		}
		
		try{
		
			val = val.trim().replace("，", ",").replace("、", ",").replace("'", "");
			
			String[] phoneArr = val.split(",");
			
			int phoneLength = phoneArr.length;
			
			if(nameLength == nameIndex + 1){
				
				ret = getArrayString(phoneArr, nameIndex, phoneLength);
			}else{
				
				ret = phoneArr[nameIndex];
			}
			
		}catch (Exception e) {
			
			ret = "";
		}
		
		return ret;
	}
	
	/**
	 * 根据下标获取数组字符串
	 * @param arr
	 * @param start
	 * @param end
	 * @return
	 */
	private String getArrayString(String[] arr, int start, int end){
		
		StringBuffer sb = new StringBuffer();
		
		for(int index = start; index <= end; index++){
			
			try{
				sb.append(arr[index].trim()).append(",");
			}catch (Exception e) {
			}
		}
		
		return CommonUtils.removeLastChar(sb.toString());
	}
	
	private String propertyName;
	
	private String areaName;
	
	private String buildName;
	
	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getBuildName() {
		return buildName;
	}

	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}
	
	public static void main(String[] args) {
		
		String name = "曹穗谊，连海波";
		
		String[] names = name.replace("，", ",").split(",");
		
		for(String a : names){
			
			System.out.println(a.trim());
		}
		
		String phone = "13622832388";
		
		String[] phones = phone.split(",");
		
		for(String p : phones){
			
			System.out.println(p);
		}
		
		
	}

}
