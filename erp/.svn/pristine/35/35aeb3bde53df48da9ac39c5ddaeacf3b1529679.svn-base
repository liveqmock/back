package com.ihk.customer.action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.customer.collection.XLSExport;
import com.ihk.customer.data.pojo.CustomerCond;
import com.ihk.customer.data.services.ICustomerServices;
import com.ihk.setting.data.pojo.CodeDtl;
import com.ihk.setting.data.services.ICodeDtlServices;
import com.ihk.setting.data.services.ICodeTypeServices;
import com.ihk.setting.data.services.IRegionServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.HighChartsUtils;
import com.ihk.utils.SupperAction;

/**
 * 交叉分析组合图
 */
public class ChartCustomerDoublePieAction extends SupperAction {


	private static final long serialVersionUID = 1L;
	
	@Autowired
	ICustomerServices customerServices;
	@Autowired
	ICodeTypeServices codeTypeServices;
	@Autowired
	ICodeDtlServices codeDtlServices;
	@Autowired
	IRegionServices regionServices;
	
	public String customerDoublePieFirst() throws Exception{
		
		initSearchDate();
		
		return "customerDoublePieFirst";
	}
	
	public String customerDoublePie() throws Exception{
		
		initSearchDate();
		
		if(!CustomerUtils.isStrEmpty(selCategory1) && !CustomerUtils.isStrEmpty(selCategory2)){
			
			int projectId = customerCond.getProjectId();
			if(projectId > 0){
				//查找单个项目
				
				List<Integer> projectIds = new ArrayList<Integer>();
				projectIds.add(projectId);
				customerCond.setProjectIds(projectIds);
			}else{
				//查找所有的项目
				
				customerCond.addPermissionChartProjectIds(); //设置可以查看的项目
			}
			
			//如果为HOME_DISTRICT(对应字段HOME_REGION)或WORK_DISTRICT(对应字段WORK_REGION),应该要查region表
			
			customerCond.setCol1(selCategory1);
			customerCond.setCol2(selCategory2);
			
			List<Map<String, Object>> listMap = customerServices.findCustomerDoublePie(customerCond);
			Map<String, String> resultMap = new HashMap<String, String>();
			
			for(Map<String, Object> map : listMap){
				
				String key1 = map.get("c1") == null ? "0" : map.get("c1").toString();
				String key2 = map.get("c2") == null ? "0" : map.get("c2").toString();
				String val = map.get("cou").toString() == null ? "0" : map.get("cou").toString();
				
				resultMap.put(key1 + "-" + key2, val);
				
			}
			
			/*List<CodeDtl> codeList1 = codeTypeServices.findCodeList(map.get(selCategory1), ContProjectId.GUANG_ZHOU);
			List<CodeDtl> codeList2 = codeTypeServices.findCodeList(map.get(selCategory2), ContProjectId.GUANG_ZHOU);
			List<Region> gzRegions = regionServices.findRegionByCityId(ContCityId.GUANG_ZHOU);
			*/
			
			List<CodeDtl> codeList1 = new ArrayList<CodeDtl>(); 
			codeList1 = HighChartsUtils
				.initCodeDtlListForHomeWorkDistrict(codeTypeServices, codeDtlServices, customerCond, map.get(selCategory1), codeList1);
			
			List<CodeDtl> codeList2 = new ArrayList<CodeDtl>(); 
			codeList2 = HighChartsUtils
				.initCodeDtlListForHomeWorkDistrict(codeTypeServices, codeDtlServices, customerCond, map.get(selCategory2), codeList2);
			
			/*
			List<Region> gzRegions = regionServices.findRegionByCityId(ContCityId.GUANG_ZHOU);
			
			if("HOME_DISTRICT".equalsIgnoreCase(selCategory1) || "WORK_DISTRICT".equalsIgnoreCase(selCategory1)){
				
				Map<String, String> tmpMap = new HashMap<String, String>();
				
				for(Region region : gzRegions){
					
					tmpMap.put(region.getRegionName(), region.getRegionId() + "");
				}
				
				for(CodeDtl code : codeList1){
					String desc = code.getCodeDesc();
					
					String val = "";
					if(tmpMap.containsKey(desc + "区")){
						
						val = tmpMap.get(desc + "区");
					}else{
						
						val = tmpMap.get(desc + "市");
					}
					
					code.setCodeVal(val);
				}
				
			}
			
			if("HOME_DISTRICT".equalsIgnoreCase(selCategory2) || "WORK_DISTRICT".equalsIgnoreCase(selCategory2)){
				
				Map<String, String> tmpMap = new HashMap<String, String>();
				
				for(Region region : gzRegions){
					
					tmpMap.put(region.getRegionName(), region.getRegionId() + "");
				}
				
				for(CodeDtl code : codeList2){
					String desc = code.getCodeDesc();
					
					String val = "";
					if(tmpMap.containsKey(desc + "区")){
						
						val = tmpMap.get(desc + "区");
					}else{
						
						val = tmpMap.get(desc + "市");
					}
					
					code.setCodeVal(val);
				}
				
			}
			*/
			
			/////////////////////
			if(tableList == null){
				tableList = new ArrayList<List<Map>>();
				//行数为codeList1.size()+1, 列数为codeList2.size()+1
			}
			
			//第一行
			List<Map> row1 = new ArrayList<Map>();
			row1.add(getMapByText(""));
			for(CodeDtl code : codeList2){
				row1.add(getMapByText(code.getCodeDesc()));
			}
			row1.add(getMapByText("合计"));
			tableList.add(row1);
			
			//第一列,不包括(1,1)
			List<String> col1 = new ArrayList<String>();
			for(CodeDtl code : codeList1){
				col1.add(code.getCodeDesc());
			}
			
			//其他行
			for(int i=0; i<codeList1.size(); i++){
				CodeDtl dtl = codeList1.get(i);
				
				List<Map> row = new ArrayList<Map>();
				//其他行第一列
				HashMap column1 = new HashMap();
				column1.put("text", col1.get(i));
				column1.put("para1", col1.get(i));
				column1.put("para2", col1.get(i));
				row.add(column1);
				
				int rowCount = 0;
				//其他行其他列(具体的比例个数)
				for(CodeDtl code : codeList2){
					
					String key = dtl.getCodeVal() + "-" + code.getCodeVal(); 
					if(!resultMap.containsKey(key)){
						HashMap tdValue = new HashMap();
						tdValue.put("text", "0");
						tdValue.put("para1", dtl.getCodeVal());
						tdValue.put("para2", code.getCodeVal());
						
						row.add(tdValue);
//						row.add("0");
					}else{
						
						Integer rowValue = Integer.parseInt(resultMap.get(key));
						rowCount += rowValue;

						HashMap tdValue = new HashMap();
						tdValue.put("text", rowValue + "");
						tdValue.put("para1", dtl.getCodeVal());
						tdValue.put("para2", code.getCodeVal());

						row.add(tdValue);
//						row.add(rowValue + ""); //获取具体的数据
					}
					
				}
				
				//最后合计列
				HashMap columnSum = new HashMap();
				columnSum.put("text", rowCount);
				columnSum.put("para1", "0");
				columnSum.put("para2", "0");
				row.add(columnSum);
//				row.add(rowCount + "");
				
				tableList.add(row);
			}
			
			//最后一行
			List<Map> lastRow = new ArrayList<Map>();
			lastRow.add(getMapByText("合计"));
			
			List<List<Map>> tmpTableList = new ArrayList<List<Map>>();
			for(int i=1; i<tableList.size(); i++){
				
				List<Map> rowList = tableList.get(i);
				tmpTableList.add(rowList);
			}
			
			int allCount = 0;
			int otherCols = codeList2.size();
			for(int i=0; i<otherCols; i++){
				int index = i+1;
				int indexCount = getCountFromListAndIndex(index, tmpTableList);
				allCount += indexCount;
				lastRow.add(getMapByText(indexCount + ""));
			}
			
			lastRow.add(getMapByText(allCount + ""));
			tableList.add(lastRow);
			
		}
		request.getSession().setAttribute("tableList", tableList);
		
		//设置在session用于查看客户明细
		request.getSession().setAttribute("customerCond", customerCond); 
		
		return "customerDoublePie";
	}
	
	private Map getMapByText(String text){
		HashMap column1 = new HashMap();
		column1.put("text", text);
		column1.put("para1", "0");
		column1.put("para2", "0");
		
		return column1;
	}
	
	private int getCountFromListAndIndex(int index, List<List<Map>> lists){
		
		int count = 0;
		
		for(List<Map> list : lists){
			count += Integer.parseInt(list.get(index).get("text").toString());
		}
		
		return count;
	}
	
	private static Map<String, String> map = new HashMap<String, String>();
	
	static{
		
		//必填类型
		map.put("RATING", "RATING");
		map.put("HOME_DISTRICT", "HOME_DISTRICT");
		map.put("WORK_DISTRICT", "WORK_DISTRICT");
		
		map.put("BUY_USE", "BUY_USE");		
		map.put("BUY_COUNT", "BUY_COUNT");
		map.put("PRICE_AMOUNT", "PRICE_AMOUNT");
		
		map.put("HOUSE_TYPE", "HOUSE_TYPE");
		map.put("CUSTOMER_SOURCE", "CUSTOMER_SOURCE");
		map.put("REQUEST_AREA", "REQUEST_AREA");
		
		//选填类型
		map.put("VISIT_COUNT", "VISIT_COUNT");
		map.put("GENDER", "GENDER");
		map.put("AGE_RANGE", "AGE_RANGE");
		
		map.put("FAMILY_TYPE", "FAMILY_TYPE");
		map.put("FAMILY_INCOME", "FAMILY_INCOME");
		map.put("JOB_TYPE", "JOB_TYPE");
		
		map.put("JOB_INDUSTRY", "JOB_INDUSTRY");
		map.put("BUY_AIM", "BUY_AIM");
		map.put("PAY_TYPE", "PAY_TYPE");
		
		map.put("INTENT_BUYNUM", "INTENT_BUYNUM");
		map.put("ROOM_TYPE", "ROOM_TYPE");
		
	}
	
	private void initSearchDate(){
		if (customerCond == null) {
			customerCond = new CustomerCond();
			customerCond.addPermissionChartProjectIds();			
			customerCond.setSearchProjectIds(customerCond.getPrivProjectIds());
			
			customerCond.setDate1(CommonUtils.getMonthFirstForString());
			customerCond.setDate2(CommonUtils.getOneDayBeforeForString(new Date()));
		}
		
		if(selCategory1 == null){
			selCategory1 = EnumCodeTypeName.WORK_DISTRICT.toString();
		}
		if(selCategory2 == null){
			selCategory2 = EnumCodeTypeName.BUY_USE.toString();
		}
		
	}
	
	/**
	 * 下拉框(必填分析类型)
	 */
	private Map<String, String> listSelCategory;
	/**
	 * 下拉框(非必填)
	 */
	private Map<String, String> listSelCategory2;
	
	private CustomerCond customerCond;
	private String projectName;
	
	//选中的分析类型
	private String selCategory1;
	private String selCategory2;
	private String selCategory3;
	
	//要显示的结果
	List<List<Map>> tableList;
	
	public void setSelCategory3(String selCategory3) {
		this.selCategory3 = selCategory3;
	}
	
	public String getSelCategory3() {
		return selCategory3;
	}
	
	public List<List<Map>> getTableList() {
		return tableList;
	}
	
	public void setTableList(List<List<Map>> tableList) {
		this.tableList = tableList;
	}
	
	public String getSelCategory1() {
		return selCategory1;
	}

	public void setSelCategory1(String selCategory1) {
		this.selCategory1 = selCategory1;
	}

	public String getSelCategory2() {
		return selCategory2;
	}

	public void setSelCategory2(String selCategory2) {
		this.selCategory2 = selCategory2;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	public String getProjectName() {
		return projectName;
	}
	
	public void setCustomerCond(CustomerCond customerCond) {
		this.customerCond = customerCond;
	}
	
	public CustomerCond getCustomerCond() {
		return customerCond;
	}
	
	public void setListSelCategory(Map<String, String> listSelCategory) {
		this.listSelCategory = listSelCategory;
	}
	
	public Map<String, String> getListSelCategory() {
		if(listSelCategory==null){
			listSelCategory = CustomerUtils.getListSelCategoryForMust();
		}
		return listSelCategory;
	}
	
	public void setListSelCategory2(Map<String, String> listSelCategory2) {
		this.listSelCategory2 = listSelCategory2;
	}
	
	public Map<String, String> getListSelCategory2() {
		if(listSelCategory2==null){
			listSelCategory2 = CustomerUtils.getListSelCategoryForNotMust();
		}
		return listSelCategory2;
	}
	
	//文件名参数变量
	private String fileName;
	
	public String getFileName() {
        return fileName;
	}

	public void setFileName(String fileName) {
        this.fileName = fileName;
	}
	
	//从下载文件原始存放路径读取得到文件输出流
	public InputStream getDownloadFile() {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		try{
			List<List> list = new ArrayList();
			list.addAll((List) request.getSession().getAttribute("tableList"));
			XLSExport.exportListExcel(list).write(baos);
		}catch(Exception e){
			e.printStackTrace();
		}
		byte[] ba = baos.toByteArray();  
        ByteArrayInputStream bais = new ByteArrayInputStream(ba);
        return bais;
	}
	
	//如果下载文件名为中文，进行字符编码转换
	public String getDownloadChineseFileName() {
        String downloadChineseFileName = fileName;
        try {
                  downloadChineseFileName = new String(downloadChineseFileName.getBytes(),"ISO8859-1");
        } catch(UnsupportedEncodingException e) {
                  e.printStackTrace();
        }
        return downloadChineseFileName;
	}
	
	/**
	 * 导出
	 * @return
	 * @throws Exception
	 */
	public String export() throws Exception {
		return SUCCESS;
	}

}
