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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
import com.ihk.saleunit.data.pojo.ContractCustomer;
import com.ihk.saleunit.data.services.IConfirmServices;
import com.ihk.saleunit.data.services.IContractCustomerServices;
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
 * 导入成交数据模板<br/>
 * 步骤：<br/>
 * 1. 手工确定对应楼栋的id<br/>
 * 
 * 2. 确定数据库中的该项目对应的付款方式是否完整(因为旧的代码中,默认只是建了四种付款方式,缺少"分期付款")<br/>
 * 	  对应的sql：<br/>
	insert into pay_way(project_id, pay_name, is_deleted, created_id, create_time, mod_id, mod_time)<br/>
	values(project_id, '分期付款', 0,2, now(), 2, now());<br/>
   
 * 3. 判断楼层及房号确认一个单元,并判断是否可以进行成交或合同<br/>
 * 
 * 4. "建筑面积","套内面积","标准总价 "修改到单元中<br/>
 * 
 * 5. "付款方式","认购书编号","成交日期","标准总价","成交总价"新建到成交单<br/>
 * 
 * 6. 客户姓名	手机号码	固定电话 	性别 	证件类型 	证件号码	生日 	通讯地址  	邮编	<br/>
 *    户籍省		户籍市	户籍区	户籍自填	居住区域省	居住区域市	居住区域区	居住区域自填<br/>
 *    
 * @author dtc
 * 2013-9-26,下午01:57:35
 */
public class ImportTemplate extends SupperJunit{
	
	IPropertyUnitServices propertyUnitServices = (IPropertyUnitServices) factory.getBean("propertyUnitServices");
	
	IPropertyBuildServices propertyBuildServices = (IPropertyBuildServices) factory.getBean("propertyBuildServices");
	
	ICompanyProjectServices companyProjectServices = (ICompanyProjectServices) factory.getBean("companyProjectServices");
	
	IConfirmServices confirmServices = (IConfirmServices) factory.getBean("confirmServices");
	
	IContractCustomerServices contractCustomerServices = (IContractCustomerServices) factory.getBean("contractCustomerServices");
	
	IProvinceServices provinceServices = (IProvinceServices) factory.getBean("provinceServices");
	
	ICityServices cityServices = (ICityServices) factory.getBean("cityServices");
	
	IRegionServices regionServices = (IRegionServices) factory.getBean("regionServices");
	
	IUserAccountServices userAccountServices = (IUserAccountServices) factory.getBean("userAccountServices");
	
	final static String pattern = "yyyy-MM-dd";
	
	/**
	 * buildId,companyProjectId,file
	 * @throws Exception
	 */
	@Test
	public void _import() throws Exception{
		
		/*int companyProjectId = 143;
		int propertyProjectId = 384;
		
		int createdId = -1;
		
		String file = "富基广场成交客户_A1栋";
		file = "富基广场成交客户_A2栋";
		file = "富基广场成交客户_A3栋";
		file = "富基广场成交客户_A4栋";
		file = "富基广场成交客户_A4栋商铺";
		file = "富基广场成交客户_A6栋";
		file = "富基广场成交客户_A7栋";
		file = "富基广场成交客户_A8栋";
		file = "富基广场成交客户_B1栋";
		file = "富基广场成交客户_地下负二层车库";
		file = "富基广场成交客户_负三层车库";
		file = "富基广场成交客户_负一层车库";
		
		int buildId = 2892; 
		buildId = 2893;
		buildId = 2894;
		buildId = 2895;
		buildId = 2899;
		buildId = 2896;
		buildId = 2897;
		buildId = 2898;
		buildId = 2900;
		buildId = 2903;
		buildId = 2904;
		buildId = 2902;
		
		importData(companyProjectId, buildId, propertyProjectId, createdId, "C:\\confirm\\" + file + ".xls");*/
		
		//int companyProjectId = 284;
		//int propertyProjectId = 403;
		
		moreImportData();
		
	}
	
	/**
	 * 遍历文件夹下的所有文件,文件名为楼栋id
	 */
	private void moreImportData(){
		
		File file = new File("C:\\confirm");
		
		File[] files = file.listFiles();
		
		for(File f : files){
			
			String fileName = f.getAbsolutePath();
			if("C:\\confirm\\exception".equalsIgnoreCase(fileName)){
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
					WriterTxtUtils.writerTxt("C:\\confirm\\exception\\有异常的成交文档.txt", fileName + "\r\n", true);
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
			
			LogDataUtils.log(LogDataUtils.CONFIRM_TYPE, fileName.replace("C:\\confirm\\", "").replace("c:\\confirm\\", ""));
			
		}
		
	}
	
	/**
	 * 文件名格式: 楼盘项目名称,分区名称,楼栋名称(楼栋id)
	 * 如:C:\confirm\御名峰公馆,御名峰公馆,1座(2779).xls
	 * 根据文件名获取楼栋id,如果不合法就返回0,并记录到文档中
	 * @param fileName
	 * @return
	 */
	private int getBuildIdByFileName(String fileName){
		
		//C:\confirm\御名峰公馆,御名峰公馆,1座(2779).xls
		//大城云山花园,大城云山花园,6栋(B1)(3122).xls
		
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
				WriterTxtUtils.writerTxt("C:\\confirm\\exception\\有异常的成交文档.txt", fileName + "\r\n", true);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return 0;
		}
		
		return buildId;
	}
	
	/**
	 * 真正的数据导入
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
			if(unit == null || !ContUnitSaleState.SALE_ABLE.equals(unit.getSaleState())){
			//if(unit == null){
				//获取的单元不能进行成交
				exPojo = new ExceptionDataPojo(cell, "单元为空或单元状态不合法");
				exceptionPojoList.add(exPojo);
				
				continue;
			}
			
			try{
				
				new MyTransationTemplate() {
					
					@Override
					protected void doExecuteCallback() throws Exception {
						
						PropertyUnit updateUnit = getUpdateUnit(cell, unit);
						
						//修改单元"建筑面积","套内面积","标准总价 ",修改房间的状态
						updateUnit.setSaleState(ContUnitSaleState.CONFIRM);
						propertyUnitServices.updatePropertyUnit(updateUnit);  //
						
						//新增成交
						Confirm confirm = getConfirm(cell, updateUnit, pattern, payWayMap, createdId, propertyProjectId);
						
						//设置销售
						confirm = setConfirmSalesId(cell, confirm);
						
						confirmServices.addConfirm(confirm);  // 
						
						//新增客户
						List<ContractCustomer> cusList = getCustomers(cell, companyId, companyProjectId, ContConfirmType.CONFIRM, 
								confirm.getId(), proList, cityList, regionList);
						
						if(!CommonUtils.isCollectionEmpty(cusList)){
							
							for(ContractCustomer cus : cusList){
								
								contractCustomerServices.addContractCustomer(cus); //
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
		String excelFileName = getExcelFileName(file);
		ExceptionDataUtils.writerXlsByJxl(exceptionPojoList, excelFileName, 31);
		
	}
	
	/**
	 * 根据读取的文件名获取异常的文件名
	 * @param file
	 * @return
	 */
	private static String getExcelFileName(String file){
		
		//C:\confirm\11.xls
		//C:\confirm\exception\11.xls
		
		int limitIndex = file.lastIndexOf("\\");
		
		int index = file.lastIndexOf(".");
		
		return file.substring(0, limitIndex) + File.separator + "exception" + 
			file.substring(limitIndex, index) + "" + file.substring(index);
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
			buildArea = new BigDecimal(cell[5].getContents().trim().replace("'", ""));
		}catch (Exception e) {
			throw new Exception("建筑面积有问题");
		}
		
		BigDecimal insideArea = new BigDecimal(0); //套内面积 
		try{
			insideArea = new BigDecimal(cell[6].getContents().trim().replace("'", ""));
		}catch (Exception e) {
			//throw new Exception("套内面积有问题");
		}
		
		BigDecimal sumPrice = new BigDecimal(0); //标准总价 
		try{
			sumPrice = new BigDecimal(cell[10].getContents().trim().replace("'", ""));
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
	 * 返回认购
	 * @param cell
	 * @param unit
	 * @param pattern
	 * @param payWayMap
	 * @param createdId
	 * @param propertyProjectId
	 * @return
	 * @throws Exception
	 */
	private Confirm getConfirm(Cell[] cell, PropertyUnit unit, String pattern, Map<String, String> payWayMap, 
			int createdId, int propertyProjectId) throws Exception{
		
		//认购书编号	成交日期	 成交总价
		
		Confirm confirm = new Confirm();
		
		String agreeNo = cell[8].getContents();
		if(!CommonUtils.isStrEmpty(agreeNo)){
			
			agreeNo = agreeNo.trim().replace("'", "");
		}
		
		Date workDate = null;
		try {
			workDate = initDate(cell[9].getContents(), "20"); //成交日期
			
		} catch (ParseException e) {

			throw new Exception("成交日期有问题");
			
		}
		
		BigDecimal buildArea = new BigDecimal(0); //建筑面积 
		try{
			buildArea = new BigDecimal(cell[5].getContents().trim().replace("'", ""));
		}catch (Exception e) {
			//throw new Exception("建筑面积有问题");
		}
		
		BigDecimal insideArea = new BigDecimal(0); //套内面积 
		try{
			insideArea = new BigDecimal(cell[6].getContents().trim().replace("'", ""));
		}catch (Exception e) {
			//throw new Exception("套内面积有问题");
		}
		
		String sumMoneyStr = cell[11].getContents(); //成交总价 
		BigDecimal sumMoney = new BigDecimal(0);
		try{
			sumMoney = new BigDecimal(sumMoneyStr.trim().replace("'", ""));
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

		confirm.setPayWayId(getPayWayId(cell, payWayMap));
		
		confirm.setUnitId(unit.getId());
		confirm.setAgreeNo(agreeNo);
		confirm.setWorkDate(workDate);
		confirm.setSumMoney(sumMoney);
		confirm.setBuildPrice(buildPrice);
		confirm.setInsideUnitPrice(insideUnitPrice);
		
		confirm.setPropertyProjectId(propertyProjectId);
		
		confirm.setIsDeleted(CommonUtils.NORMAL);
		confirm.setCreatedId(createdId);
		confirm.setCreatedTime(new Date());
		confirm.setModId(createdId);
		confirm.setModTime(new Date());
		
		return confirm;
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
			
			customer.setCustomerName(nameArr[i].trim().replace("'", ""));
			
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
	 * 设置成交的销售人员
	 * @param cell
	 * @param confirm
	 * @return
	 * @throws Exception 
	 */
	private Confirm setConfirmSalesId(Cell[] cell, Confirm confirm) throws Exception{
		
		StringBuffer sb = new StringBuffer();
		
		String sales = null;
		
		try{
			sales = cell[29].getContents();
		}catch (Exception e) {
		}
		
		if(!CommonUtils.isStrEmpty(sales)){
			
			sales = sales.trim().replace("，", ",").replace("'", ""); //huzhenxiang，huanghuimin
			
			String[] names = sales.split(",");
			
			for(String userName : names){
				
				userName = userName.trim();
				
				//如果销售名称有中文就放到备注中
				if(CommonUtils.isIncludeChinese(userName)){
					
					confirm.setRemark(confirm.getRemark() + ",销售：" + userName);
					continue;
				}
				
				UserAccount userAccount = userAccountServices.findUserAccountByUserNameIncludeDelete(userName);
				if(userAccount == null){
					
					throw new Exception("销售有问题");
				}
				
				sb.append(userAccount.getId()).append(",");
				
			}
			
			confirm.setSalesId(sb.toString());
			
			confirm = SaleUtils.initSalesId(confirm);
		}
		
		return confirm;
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
	 * @param length
	 * @param index
	 * @return
	 */
	private String getArrayVal(String val, int length, int index){
		
		String ret = "";
		
		if(CommonUtils.isStrEmpty(val)){
			
			return ret;
		}
		
		try{
		
			val = val.trim().replace("，", ",").replace("、", ",").replace("'", "");
			
			String[] valArray = val.split(",");
			
			int valLength = valArray.length;
			
			if(length == index + 1){
				
				ret = getArrayString(valArray, index, valLength);
			}else{
				
				ret = valArray[index];
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

	public static void main(String[] args) throws Exception {
		
		/*String name = "曹穗谊，连海波";
		
		String[] names = name.replace("，", ",").split(",");
		
		for(String a : names){
			
			System.out.println(a.trim());
		}
		
		String phone = "13622832388";
		
		String[] phones = phone.split(",");
		
		for(String p : phones){
			
			System.out.println(p);
		}*/
		
		//String file = "C:\\confirm\\confirm_template.xls";
		//C:\confirm\confirm_template_exception.xls
		//System.out.println(getExcelFileName(file));
		
		/*File file = new File("C:\\confirm");
		
		File[] files = file.listFiles();
		
		for(File f : files){
			
			System.out.println(f.getAbsolutePath());
		}*/
		
		/*String fileName = "c:\\confirm\\sdfs\\123.xls";
		
		int start = fileName.lastIndexOf("\\");
		int end = fileName.lastIndexOf(".");
		
		String buildId = fileName.substring(start+1, end);
		
		System.out.println(buildId);*/
		
		//System.out.println(getBuildIdByFileName("C:\\confirm\\御名峰公馆,御名峰公馆,1座(27711119).xls"));
		
		/*String fileName = "C:\\confirm\\exception\\有异常的文档.txt";
		StringBuffer sb = new StringBuffer();
		sb.append("ddddddddddddd").append("\r\n").append("eeeeeeeeeee");
		
		WriterTxtUtils.writerTxt(fileName, sb.toString());*/
		
		String str = "11啊11啊";
		
		Pattern p = Pattern.compile("[\u4e00-\u9fa5]"); 
		Matcher m = p.matcher(str); 
		System.out.println(m.find());
		
		System.out.println(str.matches(("[\u4e00-\u9fa5]+$")));
		System.out.println("111".matches("[0-9]+"));
		
		/* Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(str);
        if (m.find()) {
            return true;
        }
        return false;*/
		
		// [u4e00-u9fa5]
		
		
		
		
		ImportTemplate it = new ImportTemplate();
		
		it.moreImportData();
		
	}
	
}
