package com.ihk.junit.import_cus.template;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jxl.Cell;
import jxl.biff.EmptyCell;

import org.junit.Test;

import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.customer.data.pojo.Customer;
import com.ihk.customer.data.services.ICustomerServices;
import com.ihk.junit.SupperJunit;
import com.ihk.junit.import_confirm.utils.ExceptionDataPojo;
import com.ihk.junit.import_confirm.utils.ExceptionDataUtils;
import com.ihk.junit.import_confirm.utils.LogDataUtils;
import com.ihk.junit.import_confirm.utils.RealXlsUtils;
import com.ihk.junit.import_confirm.utils.WriterTxtUtils;
import com.ihk.setting.data.pojo.City;
import com.ihk.setting.data.pojo.CityCond;
import com.ihk.setting.data.pojo.ProjectCode;
import com.ihk.setting.data.pojo.Province;
import com.ihk.setting.data.pojo.ProvinceCond;
import com.ihk.setting.data.pojo.Region;
import com.ihk.setting.data.pojo.RegionCond;
import com.ihk.setting.data.services.ICityServices;
import com.ihk.setting.data.services.IProjectCodeServices;
import com.ihk.setting.data.services.IProvinceServices;
import com.ihk.setting.data.services.IRegionServices;
import com.ihk.user.data.pojo.CompanyProject;
import com.ihk.user.data.pojo.UserAccount;
import com.ihk.user.data.services.ICompanyProjectServices;
import com.ihk.user.data.services.IUserAccountServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;

/**
 * 售前客户导入模板
 * @author dtc
 * 2013-10-25,上午10:19:45
 */
public class ImportCustomerTemplate extends SupperJunit{
	
	IProjectCodeServices projectCodeServices = (IProjectCodeServices) factory.getBean("projectCodeServices");
	
	IProvinceServices provinceServices = (IProvinceServices) factory.getBean("provinceServices");
	
	ICityServices cityServices = (ICityServices) factory.getBean("cityServices");
	
	IRegionServices regionServices = (IRegionServices) factory.getBean("regionServices");
	
	ICompanyProjectServices companyProjectServices = (ICompanyProjectServices) factory.getBean("companyProjectServices");
	
	ICustomerServices customerServices = (ICustomerServices) factory.getBean("customerServices");
	
	IUserAccountServices userAccountServices = (IUserAccountServices) factory.getBean("userAccountServices");
	
	int projectId = 0;
	
	int companyId = 0;
	
	List<Province> proList = null;
	List<City> cityList = null;
	List<Region> regionList = null;
	
	@Test
	public void importCustomer(){
		
		moreImportData();
		
	}
	
	/**
	 * 批量导入
	 */
	private void moreImportData(){
		
		proList = provinceServices.findProvince(new ProvinceCond());
		cityList = cityServices.findCity(new CityCond());
		regionList = regionServices.findRegion(new RegionCond());
		
		File file = new File("C:\\customer");
		
		File[] files = file.listFiles();
		
		for(File f : files){
			
			String fileName = f.getAbsolutePath();
			if("C:\\customer\\exception".equalsIgnoreCase(fileName)){
				continue;
			}
			
			projectId = getProjectIdByFileName(fileName);
			
			if(projectId == 0){
				
				try {
					WriterTxtUtils.writerTxt("C:\\customer\\exception\\有异常的售前客户文档.txt", fileName + "\r\n", true);
				} catch (Exception e) {
					e.printStackTrace();
				} 
				continue;
			}
			
			CompanyProject project = companyProjectServices.findCompanyProjectById(projectId);
			if(project == null){
				
				try {
					WriterTxtUtils.writerTxt("C:\\customer\\exception\\有异常的售前客户文档.txt", fileName + "\r\n", true);
				} catch (Exception e) {
					e.printStackTrace();
				} 
				continue;
			}
			
			companyId = project.getCompanyId();
			
			try {
				importData(f.getAbsolutePath());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			LogDataUtils.log(LogDataUtils.CUSTOMER_TYPE, fileName.replace("C:\\customer\\", "").replace("c:\\customer\\", ""));
		}
		
	}
	
	/**
	 * 一个文档的具体导入
	 * @param file
	 * @throws Exception 
	 */
	private void importData(String file) throws Exception {
		
		List<Cell[]> cellList = RealXlsUtils.realCustomeXls(file);
		
		List<ExceptionDataPojo> exceptionPojoList = new ArrayList<ExceptionDataPojo>();
		ExceptionDataPojo exPojo = null;
		
		int size = cellList.size();
		if(size <= 1){
			return ;
		}
		
		exPojo = new ExceptionDataPojo(cellList.get(0), ""); //第一行为说明,不用处理
		exceptionPojoList.add(exPojo);
		
		for(int i=1; i<size; i++){
			
			Cell[] cell = cellList.get(i); //从第二行开始
			
			try{
				
				Customer cus = new Customer();
				
				cus.setProjectId(projectId); //项目id
				cus.setCompanyId(companyId); //公司id
				
				cus.setCustomerName(getCustomerName(cell)); //客户姓名
				
				cus.setRating(getProjectCodeVal(cell[1], EnumCodeTypeName.RATING, "客户评级")); //客户评级
				
				cus.setVisitDate(getVisitDate(cell)); //来访日期
				
				String phone = cell[3].getContents(); //移动电话 
				String homePhone = cell[4].getContents(); //固定电话 
				
				if(CommonUtils.isStrEmpty(phone) && CommonUtils.isStrEmpty(homePhone)){
					throw new Exception("移动电话及固定电话不能同时为空");
				}
				
				if(CommonUtils.isStrEmpty(phone)){
					cus.setPhone("");
				}else{
					cus.setPhone(phone.trim());
				}
				
				if(CommonUtils.isStrEmpty(homePhone)){
					cus.setHomePhone("");
				}else{
					cus.setHomePhone(homePhone.trim());
				}
				
				cus.setHomeProvince(getProvince(proList, cell[5].getContents())); //居住区域省
				cus.setHomeCity(getCity(cityList, cell[6].getContents())); //居住区域市
				cus.setHomeRegion(getRegion(regionList, cell[7].getContents()));  //居住区域区
				cus.setHomeContent(cell[8].getContents()); //居住区域自填
				
				cus.setWorkProvince(getProvince(proList, cell[9].getContents())); //工作区域省
				cus.setWorkCity(getCity(cityList, cell[10].getContents())); //工作区域市
				cus.setWorkRegion(getRegion(regionList, cell[11].getContents())); //工作区域区
				cus.setWorkContent(cell[12].getContents()); //工作区域自填

				cus.setBuyUse(getProjectCodeVal(cell[13], EnumCodeTypeName.BUY_USE, "购房用途")); //购房用途

				cus.setBuyCount(getProjectCodeVal(cell[14], EnumCodeTypeName.BUY_COUNT, "置业次数")); //置业次数

				cus.setPriceNum(getPriceNum(cell)); //意向总价

				cus.setHouseType(getProjectCodeVal(cell[16], EnumCodeTypeName.HOUSE_TYPE, "产品类型")); //产品类型

				cus.setCustomerSource(getProjectCodeVal(cell[17], EnumCodeTypeName.CUSTOMER_SOURCE, "客户来源")); //客户来源

				cus.setAreaNum(getAreaNum(cell)); //意向面积

				int userId = getUserId(cell);  //销售人员
				cus.setUserId(userId);

				cus.setCustomerNo(CustomerUtils.getTmpCustomerNo()); //客户编号
				
				cus.setIsDeleted(CommonUtils.NORMAL);
				cus.setCreatedId(userId);
				cus.setCreatedTime(new Date());
				cus.setModId(userId);
				cus.setModTime(new Date());
				
				customerServices.saveCustomer(cus);
				
			}catch (Exception e) {
				
				String message = e.getMessage();
				
				exPojo = new ExceptionDataPojo(cell, message);
				exceptionPojoList.add(exPojo);
			}
			
		}
		
		//输出有错数据 exceptionPojoList
		String exceFileName = getExcelFileName(file);
		ExceptionDataUtils.writerXlsByJxl(exceptionPojoList, exceFileName, 21);
		
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
	 * 获取公司项目id,如果不一致就返回0
	 * @param fileName
	 * @return
	 */
	private int getProjectIdByFileName(String fileName) {
		
		//C:\\customer\\御名峰_293.xls
		
		int ret = 0;
		
		try{
			
			int start = fileName.lastIndexOf("\\");
			int end = fileName.lastIndexOf(".");
			
			fileName = fileName.substring(start+1, end); //御名峰_293
			
			String[] nameAndId = fileName.split("_");
			
			String name = nameAndId[0];
			int projectId = Integer.parseInt(nameAndId[1]);
			
			CompanyProject project = companyProjectServices.findCompanyProjectById(projectId);
			
			if(name.equals(project.getProjectName())){
				
				ret = projectId;
			}
			
		}catch (Exception e) {
		}
		
		return ret;
	}
	
	/**
	 * 客户姓名
	 * @param cell
	 * @return
	 */
	private String getCustomerName(Cell[] cell){
		
		String name = "";
		
		try{
			
			name = cell[0].getContents().trim();
			
		}catch (Exception e) {
			
			throw new RuntimeException("客户姓名有问题");
		}
		
		if(CommonUtils.isStrEmpty(name)){
			
			//throw new RuntimeException("客户姓名有问题");
			name = "";
		}
		
		return name;
	}
	
	/**
	 * 获取codeList对应的值,出异常返回对应的异常信息
	 * @param cell
	 * @param name
	 * @param message
	 * @return
	 * @throws Exception
	 */
	private String getProjectCodeVal(Cell cell, EnumCodeTypeName name, String message) throws Exception{
		
		try{
		
			if(cell == null || cell instanceof EmptyCell){
				
				return "";
			}
			
			String content = cell.getContents();
			
			if(CommonUtils.isStrEmpty(content)){
				
				return "";
			}
			
			content = content.trim();
			
			String ret = "";
			
			List<ProjectCode> codeList = projectCodeServices.findProjectCodeByProjectIdAndTypeName(projectId, name.toString());
			
			for(ProjectCode rating : codeList){
				
				String desc = rating.getCodeDesc();
				if(desc.equals(content)){
					
					ret = rating.getCodeVal();
					break;
				}
				
			}
		
			return ret;
			
		}catch (Exception e) {
			
			throw new Exception(message + "有异常");
			
		}
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
	 * 意向总价
	 * @param cell
	 * @return
	 * @throws Exception 
	 */
	private int getPriceNum(Cell[] cell) throws Exception{
		
		Cell c = cell[15];
		
		String priceNum = "";
		
		if(c == null || c instanceof EmptyCell){
			
			//throw new Exception("意向总价有异常");
			priceNum = "0";
		}else{
			
			priceNum = c.getContents();
			
			if(CommonUtils.isStrEmpty(priceNum)){
				
				return 0;
			}
			
			priceNum = priceNum.trim();
			
			if(!CommonUtils.isIntString(priceNum)){
				
				throw new Exception("意向总价有异常");
			}
			
		}
		
		return Integer.parseInt(priceNum);
	}
	
	/**
	 * 意向面积
	 * @param cell
	 * @return
	 * @throws Exception 
	 */
	private int getAreaNum(Cell[] cell) throws Exception{
		
		Cell c = cell[18];
		
		String areaNum = "";
		
		if(c == null || c instanceof EmptyCell){
			
			//throw new Exception("意向面积有异常");
			areaNum = "0";
		}else{
			
			areaNum = c.getContents();
			
			if(CommonUtils.isStrEmpty(areaNum)){
				
				return 0;
			}
			
			areaNum = areaNum.trim();
			
			if(!CommonUtils.isIntString(areaNum)){
				
				throw new Exception("意向面积有异常");
			}
			
		}
		
		return Integer.parseInt(areaNum);
	}
	
	/**
	 * 所属销售
	 * @param cell
	 * @return
	 * @throws Exception 
	 */
	private int getUserId(Cell[] cell) throws Exception{
		
		Cell c = cell[19];
		
		if(c == null || c instanceof EmptyCell){
			
			throw new Exception("销售有问题");
		}
		
		String content = c.getContents();
		if(CommonUtils.isStrEmpty(content)){
			
			throw new Exception("销售有问题");
		}
		
		UserAccount userAccount = userAccountServices.findUserAccountByUserNameIncludeDelete(content.trim());
		if(userAccount == null){
			
			throw new Exception("销售有问题");
		}
		
		return userAccount.getId();
	}
	
	/**
	 * 来访日期
	 * @param cell
	 * @return
	 * @throws Exception 
	 */
	private String getVisitDate(Cell[] cell) throws Exception{
		
		String date = "";
		
		Cell c = cell[2];
		
		if(c == null || c instanceof EmptyCell){
			
			return "";
		}
		
		String dateStr = c.getContents();
		
		if(CommonUtils.isStrEmpty(dateStr)){
			
			return "";
		}
		
		date = dateStr.trim().replace("/", "-");
		String[] array = date.split("-");
		if(array[0].length() == 2){
			
			date = "20" + date;
		}
		
		return date;
	}
	
}

