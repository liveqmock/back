package com.ihk.junit.import_cus.hubei.stl;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import jxl.Cell;
import jxl.CellType;
import jxl.DateCell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import com.ihk.customer.data.pojo.Customer;
import com.ihk.customer.data.pojo.CustomerFocus;
import com.ihk.customer.data.pojo.CustomerKnown;
import com.ihk.customer.data.services.ICustomerFocusServices;
import com.ihk.customer.data.services.ICustomerKnownServices;
import com.ihk.junit.import_cus.dongguan.utils.DongGuanUtils;
import com.ihk.junit.import_cus.hubei.th.ThLaiFanBean;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;

/**
 * 导入帮助类
 * @author dtc
 * 2013-8-15,下午03:25:37
 */
public class LeadingInUtils {
	
	/**
	 * 返回客户String list,并去除重复的号码,号码在第三列
	 * @param file
	 * @return
	 */
	public static List<String> realXls(String file) {
		
		List<String> cellList = new ArrayList<String>();

		Workbook book = null;

		try {

			book = Workbook.getWorkbook(new File(file));
			Sheet[] sheets = book.getSheets();

			if (CommonUtils.isCollectionEmpty(sheets)) {
				return null;
			}
			
			StringBuffer sb = null;

			for (Sheet sheet : sheets) {

				int rows = sheet.getRows();

				for (int i = 0; i < rows; i++) {
					
					sb = new StringBuffer();

					Cell[] cells = sheet.getRow(i);

					if (CommonUtils.isCollectionEmpty(cells))
						continue;
					
					for (Cell cell : cells) {
						
						String contents = "";
						
						if(cell.getType() == CellType.DATE){
							//如果为日期格式
							
							DateCell dc = (DateCell)cell;
							
							Date date = dc.getDate();
							SimpleDateFormat ds = new SimpleDateFormat("yyyy/MM/dd");
							contents = ds.format(date);
							
						}else{
							
							contents = cell.getContents().trim();
						}
						
						if(CommonUtils.isStrEmpty(contents)){
							
							sb.append("*").append("|");
						}else{
							
							sb.append(contents).append("|");
						}
						
					}
					
					cellList.add(sb.toString());

				}

			}

		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (book != null) {
				book.close();
			}
		}
		
		List<String> retList = new ArrayList<String>();
		List<String> phoneList = new ArrayList<String>();
		
		String phone = "";
		
		for(String cell : cellList){
			
			phone = cell.split("\\|")[2];
			if("".equals(phone) || "*".equals(phone) || phoneList.contains(phone)){
				continue;
			}
			
			phoneList.add(phone);
			retList.add(cell);
		}
		
		
		return retList;
	}
	
	/**
	 * 转换来访日期
	 * @param vd
	 * @return
	 */
	public static String changeVisitDate(String vd){
		
		String ret = "";
		
		try{
			String[] date = vd.split("/");
			
			ret += date[0] + "-";
			
			String month = date[1];
			String day = date[2];
			
			if(Integer.parseInt(month) < 10){
				
				ret += "0" + Integer.parseInt(month) + "-";
			}else{
				
				ret += month + "-";
			}
			
			if(Integer.parseInt(day) < 10){
				
				ret += "0" + Integer.parseInt(day);
			}else{
				
				ret += day;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return ret;
	}
	
	/**
	 * 获取关注点
	 * @param bean
	 * @param customerId
	 * @return
	 */
	public static List<CustomerFocus> getFocusByBeanAndCustomerId(StlLaiDianBean bean, int customerId){
		
		if(customerId <= 0 || bean == null || CommonUtils.isStrEmpty(bean.getCustomerFocus())){
			
			return null;
		}
		
		String[] focus = bean.getCustomerFocus();
		
		List<CustomerFocus> retList = new ArrayList<CustomerFocus>();
		CustomerFocus cusFocus = null;
		
		for(String tmp : focus){
			
			cusFocus = new CustomerFocus();
			
			cusFocus.setCustomerId(customerId);
			cusFocus.setFocusPoint(tmp);
			
			retList.add(cusFocus);
			
		}
		
		return retList;
	}
	
	/**
	 * 获取获知途径
	 * @param bean
	 * @param customerId
	 * @return
	 */
	public static List<CustomerKnown> getKnownByBeanAndCustomerId(StlLaiDianBean bean, int customerId){
		
		if(customerId <= 0 || bean == null || CommonUtils.isStrEmpty(bean.getKnownFroms())){
			
			return null;
		}
		
		String[] knowns = bean.getKnownFroms();
		
		List<CustomerKnown> retList = new ArrayList<CustomerKnown>();
		CustomerKnown known = null;
		
		for(String tmp : knowns){
			
			known = new CustomerKnown();
			
			known.setCustomerId(customerId);
			known.setKnownFrom(tmp);
			
			retList.add(known);
			
		}
		
		return retList;
	}
	
	/**
	 * 获取关注点
	 * @param bean
	 * @param customerId
	 * @return
	 */
	public static List<CustomerFocus> getFocusByBeanAndCustomerId(ThLaiFanBean bean, int customerId){
		
		if(customerId <= 0 || bean == null || CommonUtils.isStrEmpty(bean.getCustomerFocus())){
			
			return null;
		}
		
		String[] focus = bean.getCustomerFocus();
		
		List<CustomerFocus> retList = new ArrayList<CustomerFocus>();
		CustomerFocus cusFocus = null;
		
		for(String tmp : focus){
			
			cusFocus = new CustomerFocus();
			
			cusFocus.setCustomerId(customerId);
			cusFocus.setFocusPoint(tmp);
			
			retList.add(cusFocus);
			
		}
		
		return retList;
	}
	
	/**
	 * 获取获知途径
	 * @param bean
	 * @param customerId
	 * @return
	 */
	public static List<CustomerKnown> getKnownByBeanAndCustomerId(ThLaiFanBean bean, int customerId){
		
		if(customerId <= 0 || bean == null || CommonUtils.isStrEmpty(bean.getKnownFroms())){
			
			return null;
		}
		
		String[] knowns = bean.getKnownFroms();
		
		List<CustomerKnown> retList = new ArrayList<CustomerKnown>();
		CustomerKnown known = null;
		
		for(String tmp : knowns){
			
			known = new CustomerKnown();
			
			known.setCustomerId(customerId);
			known.setKnownFrom(tmp);
			
			retList.add(known);
			
		}
		
		return retList;
	}
	
	/**
	 * 获取对应的值
	 * @param map
	 * @param fields
	 * @return
	 */
	public static String getValByMapAndFields(Map<Integer, String> map, String[] fields){
		
		String ret = "";
		
		Set<Integer> keys = map.keySet();
		
		for(int key : keys){
			
			if(!"*".equals(fields[key])){
				
				ret = map.get(key);
				break;
			}
		}
		
		return ret;
	}
	
	/**
	 * 开始坐标,及map的value,fields数组,获取对应的值
	 * @param start
	 * @param val
	 * @param fields
	 * @return
	 */
	public static String getValByMapAndFields(int start, String[] val, String[] fields){
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		int length = val.length;
		
		for(int i=0; i<length; i++){
			
			map.put(start + i, val[i]);
		}
		
		return getValByMapAndFields(map, fields);
	}
	
	/**
	 * 获取关注点
	 * @param start
	 * @param val
	 * @param fields
	 * @param customerId
	 * @return
	 */
	private static List<CustomerFocus> getFocusByCustomerId(int start, String[] val, String[] fields, int customerId){
		
		int length = val.length;
		
		List<String> focus = new ArrayList<String>();
		
		for(int i=0; i<length; i++){
			
			String getVal = fields[start + i]; //xls中的值
			if(CommonUtils.isStrEmpty(getVal) || "*".equals(getVal)){
				continue;
			}
			
			focus.add(getVal);
		}
		
		List<CustomerFocus> retList = new ArrayList<CustomerFocus>();
		CustomerFocus cusFocus = null;
		
		for(String tmp : focus){
			
			cusFocus = new CustomerFocus();
			
			cusFocus.setCustomerId(customerId);
			cusFocus.setFocusPoint(tmp);
			
			retList.add(cusFocus);
			
		}
		
		return retList;
	}
	
	/**
	 * 根据客户id新增关注点
	 * @param start
	 * @param val
	 * @param fields
	 * @param customerId
	 * @param customerFocusServices
	 */
	public static void addFocusByCustomerId(int start, String[] val, String[] fields, int customerId, ICustomerFocusServices customerFocusServices){
		
		List<CustomerFocus> focusList = getFocusByCustomerId(start, val, fields, customerId);
		if(!CommonUtils.isCollectionEmpty(focusList)){
			
			for(CustomerFocus focus : focusList){
				
				customerFocusServices.addCustomerFocus(focus);
			}
			
		}
	}
	
	/**
	 * 获取获知途径
	 * @param start
	 * @param val
	 * @param fields
	 * @param customerId
	 * @return
	 */
	private static List<CustomerKnown> getKnownByCustomerId(int start, String[] val, String[] fields, int customerId){
		
		int length = val.length;
		
		List<String> knowns = new ArrayList<String>();
		
		for(int i=0; i<length; i++){
			
			String getVal = fields[start + i]; //xls中的值
			if(CommonUtils.isStrEmpty(getVal) || "*".equals(getVal)){
				continue;
			}
			
			knowns.add(getVal);
		}
		
		List<CustomerKnown> retList = new ArrayList<CustomerKnown>();
		CustomerKnown known = null;
		
		for(String tmp : knowns){
			
			known = new CustomerKnown();
			
			known.setCustomerId(customerId);
			known.setKnownFrom(tmp);
			
			retList.add(known);
			
		}
		
		return retList;
	}
	
	/**
	 * 根据客户id,新增获知途径
	 * @param start
	 * @param val
	 * @param fields
	 * @param customerId
	 * @param customerKnownServices
	 */
	public static void addKnownByCustomerId(int start, String[] val, String[] fields, int customerId, ICustomerKnownServices customerKnownServices){
		
		List<CustomerKnown> knownList = getKnownByCustomerId(start, val, fields, customerId);
		if(!CommonUtils.isCollectionEmpty(knownList)){
			
			for(CustomerKnown known : knownList){
				
				customerKnownServices.addCustomerKnown(known);
			}
		}
		
	}
	
	
	/**
	 * 设置客户的基本字段<br/>
	 * 来访/来电日期,客户姓名,电话,居住省,居住市,所属公司,所属项目,所属用户,客户来源
	 * @param fields
	 * @param homeProvince
	 * @param homeCity
	 * @param companyId
	 * @param projectId
	 * @param userId
	 * @param customerSource,1为来电,2为来访
	 * @return
	 */
	public static Customer stringToBean(String[] fields, int homeProvince, int homeCity, int companyId, int projectId,
			int userId, int customerSource){
		
		try{
		
			if(CommonUtils.isStrEmpty(fields)){
				
				return null;
			}
			
			Customer customer = new Customer();
			
			customer.setVisitDate(LeadingInUtils.changeVisitDate(fields[0]));
			customer.setCustomerName(fields[1]);
			customer.setPhone(DongGuanUtils.getPhone(fields[2]));
			
			customer.setCustomerNo(CustomerUtils.getTmpCustomerNo());
			
			customer.setHomeProvince(homeProvince); //居住省
			customer.setHomeCity(homeCity); //居住市
			
			customer.setCompanyId(companyId);
			customer.setProjectId(projectId); //
			
			customer.setTeamId(0);
			customer.setUserId(userId);
			
			customer.setManagerId(userId);
			customer.setCustomerSource(customerSource + ""); //客户来源,来电
			
			customer.setIsDeleted(CommonUtils.NORMAL);
			customer.setCreatedId(userId);
			customer.setCreatedTime(new Date());
			customer.setModId(userId);
			customer.setModTime(new Date());
			
			return customer;
			
		}catch (Exception e) {
			return null;
		}
	}

}
