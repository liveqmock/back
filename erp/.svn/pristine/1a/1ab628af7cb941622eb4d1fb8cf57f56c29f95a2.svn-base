package com.ihk.customer.action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.ContSessionAttribute;
import com.ihk.constanttype.EnumPrivCode;
import com.ihk.customer.collection.XLSExport;
import com.ihk.customer.data.pojo.CustomerCond;
import com.ihk.customer.data.services.ICustomerServices;
import com.ihk.permission.PermissionUtils;
import com.ihk.setting.data.pojo.CodeDtl;
import com.ihk.setting.data.pojo.ProjectCodeCond;
import com.ihk.setting.data.services.ICodeDtlServices;
import com.ihk.setting.data.services.ICodeTypeServices;
import com.ihk.setting.data.services.IProjectCodeServices;
import com.ihk.utils.AJAXUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.HighChartsUtils;
import com.ihk.utils.ReportUtils;
import com.ihk.utils.SupperAction;

/**
 * 客户的饼图
 * 
 * 实现思路
 * 1,按时间取得数据库对应的分组数据
 * 2,形成显示的表格List<List>,嵌套显示表格
 */
public class ChartCustomerPieAction extends SupperAction {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(ChartCustomerPieAction.class);

	@Autowired
	ICodeTypeServices codeTypeServices;
	@Autowired
	ICodeDtlServices codeDtlServices;
	@Autowired
	ICustomerServices customerServices;
	@Autowired
	IProjectCodeServices projectCodeServices;
	
	private CustomerCond cond;

	/**
	 * 分组的tr标题(Map[codeVal,codeDesc]内容为codeVal,codeDesc)
	 */
	private List<Map<String, String>> listCategory;	
		
	//合计总数
	private int sumTableNum =0;
	
	//下拉框(分析类型)
	private LinkedHashMap<String, String> listSelCategory;
	
	public LinkedHashMap<String, String> getListSelCategory() {
		if(listSelCategory==null){
			listSelCategory = CustomerUtils.getListSelCategoryByQuestionId(questionId);
		}
		return listSelCategory;
	}

	//选中的分析类型
	private String selCategory;
	
	public String getSelCategory() {
		return this.selCategory;
	}
		
	public void setSelCategory(String selCategory) {
		this.selCategory = selCategory;
	}

	public CustomerCond getCond() {
		return cond;
	}

	public void setCond(CustomerCond cond) {
		this.cond = cond;
	}
	
	private int questionId;
	
	private LinkedHashMap<String,String> questionList;
	
	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public LinkedHashMap getQuestionList() {
		return questionList;
	}

	public void setQuestionList(LinkedHashMap questionList) {
		this.questionList = questionList;
	}

	//初始化分类
	private void initListCategory(){
		listCategory = new ArrayList<Map<String,String>>(); 
		List<CodeDtl> listCode = new ArrayList<CodeDtl>();

		listCode = HighChartsUtils.initCodeDtlListForHomeWorkDistrict(codeTypeServices, codeDtlServices, cond, selCategory, listCode); 
		
		for(int i=0;i<listCode.size();i++){
			Map newCategory = new HashMap();
			List<String> val = new ArrayList<String>();
			newCategory.put("codeVal", listCode.get(i).getCodeVal());
			newCategory.put("codeDesc", listCode.get(i).getCodeDesc());
			listCategory.add(newCategory);
		}
		
	}
	
	public String index() throws Exception {	
		//项目问卷下拉框
		questionList=new LinkedHashMap<String,String>();
		questionList.put("0", "请选择");
		return SUCCESS;	
	} 

	/**
	 * 点击查询的数据返回
	 * @return
	 * @throws Exception
	 */
	public String searchAjax() throws Exception {
		if(cond==null){
			cond = new CustomerCond();
		}
		
		if(cond.getSearchCompanyProjectIds()==null || cond.getSearchCompanyProjectIds().size()==0){
			return null;
		}
		cond.addPermissionChartProjectIds();
		
		if(this.questionId<0){
			return null;
		}

		responseByResult();
		
		return null;
	}
	

	public String download() throws Exception{

		@SuppressWarnings("unchecked")
		List<Map<String, String>> dataList = (List<Map<String, String>>) request.getSession().getAttribute(ContSessionAttribute.CUSTOMER_PIE+ContSessionAttribute.DOWNLOAD_DATA);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("dataList", dataList); //与模板里面的循环要求对应
		
		ReportUtils.downLoadReport(map, "customer-pie.xls", "download-客户分类比例-" + CustomerUtils.getNowForString() + ".xls", response);
		
		return null;
	}
	

	/**
	 * 输出统计结果
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public String responseByResult() throws IOException, ClassNotFoundException {	
		if(selCategory==null){
			selCategory = "HOME_DISTRICT";
		}

		//分组(类别)形成的列表
		initListCategory();

		//Map格式为[category,num]
		List<Map> listDBCategoryData;

		Map lDataMap = new HashMap();//为category:num这个的方式保存汇总数，方便再次取出		

		//查询数据库,形成分组(类别,日期)后的数据
		cond.setGroupField(selCategory);

		//查询数据库,形成分组(类别,日期)后的数据
		List<Map> listData=null;
		boolean isProjectQuestion = selCategory.matches("^[0-9]+$");
		if(isProjectQuestion){
			//对于自定义问卷，没有好办法，只有把每个答案都取出来再进行分类
			cond.setTopicId(selCategory);
			listData = customerServices.findCustomerGroupQuestionTopic(cond); 

			if(listData.size()!=0){
				for(Map m :listData){
					int num=1;
					String[] s=String.valueOf(m.get("anwserContent")).split("\\r\\n");
					for(String c:s){
						if(c.startsWith("1")){//答卷中有1,代表回答了该选项
							String key = c.split(":")[1];
							num++;
							lDataMap.put(key, num);								

							continue;
						}						
					}					
				}				
			}
		}else{
			cond.setGroupField(selCategory);
			listDBCategoryData = customerServices.findCustomerGroupByCategory(cond); 
			for(Map m:listDBCategoryData){
				lDataMap.put(m.get("category").toString(), m.get("num"));					
			}
		}
		
		List<Map<String, String>> retList = new ArrayList<Map<String,String>>();//输出到页面的内容
		for(int i=0;i<listCategory.size();i++){
				String key = listCategory.get(i).get("codeDesc");
				if(isProjectQuestion==false){
					key = listCategory.get(i).get("codeVal");
				}
				if(lDataMap.containsKey(key)){
					Map<String, String> map = new HashMap<String, String>();

					map.put("category", listCategory.get(i).get("codeDesc"));
					map.put("sumCount", lDataMap.get(key).toString());
					map.put("pieCount", "0");

					retList.add(map);	
				}
		}
		
		//总数与比例
		ReportUtils.fixListPieColumn(retList,"pieCount","sumCount");

		setChartSeriesDataInSession(retList);
		setDownloadDataInSession(retList);
		
		AJAXUtils.writeResponse(response, CommonUtils.getMapJsonAnd(retList));
		
		return "success";
	}

	/**
	 * 设置于session中的数据
	 * @param dataList
	 */
	private void setChartSeriesDataInSession(List<Map<String, String>> dataList) {
		String chartSeriesData_Phone;
			if (dataList == null || dataList.size() == 0) {
				chartSeriesData_Phone = "['无数据',1]";
				return;
			}
			String str_Phone = "";
			for (Map<String, String> p : dataList) {
				str_Phone += "['" + p.get("category") + "'," + p.get("sumCount") + "]"
						+ ",";

			}
			chartSeriesData_Phone = str_Phone;

			request.getSession().setAttribute(ContSessionAttribute.CUSTOMER_PIE+ContSessionAttribute.TITLE, "客户分类比例(项目)");
			request.getSession().setAttribute(ContSessionAttribute.CUSTOMER_PIE+ContSessionAttribute.CHART_SERIES_DATA, chartSeriesData_Phone);
	}
	

	/**
	 * session保存页面当前数据，用于下载
	 * @param dataList
	 */
	private void setDownloadDataInSession(List<Map<String, String>> dataList){
		request.getSession().setAttribute(ContSessionAttribute.CUSTOMER_PIE+ContSessionAttribute.DOWNLOAD_DATA, dataList);		
	}
	

	
}
