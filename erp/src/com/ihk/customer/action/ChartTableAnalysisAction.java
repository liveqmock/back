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
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.ContSessionAttribute;
import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.constanttype.EnumPrivCode;
import com.ihk.customer.collection.XLSExport;
import com.ihk.customer.data.pojo.CustomerCond;
import com.ihk.customer.data.services.ICustomerServices;
import com.ihk.permission.PermissionUtils;
import com.ihk.report.data.pojo.precustomer.ReportPreCustomerProjectCond;
import com.ihk.saleunit.data.pojo.QuestionTopic;
import com.ihk.saleunit.data.pojo.QuestionTopicCond;
import com.ihk.saleunit.data.services.IQuestionServices;
import com.ihk.saleunit.data.services.IQuestionTopicServices;
import com.ihk.setting.data.pojo.CodeDtl;
import com.ihk.setting.data.pojo.ProjectCodeCond;
import com.ihk.setting.data.services.ICodeDtlServices;
import com.ihk.setting.data.services.ICodeTypeServices;
import com.ihk.setting.data.services.IProjectCodeServices;
import com.ihk.utils.AJAXUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.DateTimeUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.HighChartsUtils;
import com.ihk.utils.ReportUtils;
import com.ihk.utils.SupperAction;

/**
 * 单项数据分析表
 * 
 * 实现思路:
 * 1，根据条件，形成日期的x轴(表格的thead)
 * 2,根据条件,形成类型的y轴(表格的第一列)
 * 3,查询出数据库相应的数据，以日期，类型分组
 * 4，根据以上基础数据，形成表格的主体内容
 */
public class ChartTableAnalysisAction extends SupperAction {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(ChartTableAnalysisAction.class);

	@Autowired
	ICodeTypeServices codeTypeServices;
	@Autowired
	ICustomerServices customerServices;
	@Autowired
	ICodeDtlServices codeDtlServices;
	@Autowired
	IQuestionServices questionServices;
	@Autowired
	IQuestionTopicServices questionTopicServices;
	@Autowired
	IProjectCodeServices projectCodeServices;
			
	private CustomerCond cond;

	private LinkedHashMap<String,String> questionList;

	public LinkedHashMap<String,String> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(LinkedHashMap<String,String> questionList) {
		this.questionList = questionList;
	}
	
	
	/**
	 * 日期坐标行(Map[date,shortDate,showWeek]内容为yyyy-MM-dd,dd,星期) 
	 */
	private ArrayList<Map<String, String>> listDate;
	/**
	 * 分组的tr标题(Map[codeVal,codeDesc]内容为codeVal,codeDesc)
	 */
	private List<Map<String, String>> listCategory;	
	/**
	 * 数据库分组结果Map[categoryDate,category,num]
	 */
	private List<Map> listDBData;
	
	//主体汇总表格数据
	private List<List> listSumTable;	
	//合计总数
	private int sumTableNum =0;
	
	private int questionId;
	
	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
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

	public int getQuesitonId() {
		return questionId;
	}

	public void setQuesitonId(int quesitonId) {
		this.questionId = quesitonId;
	}

	/**
	 * 初始化日期列表
	 */
	private void initListDate(){
		if (CustomerUtils.isStrEmpty(cond.getVisitDate1())) {
			cond.setVisitDate1(CommonUtils.getMonthFirstForString(CommonUtils.getOneDayBeforeForString(new Date())));
		}
		if (CustomerUtils.isStrEmpty(cond.getVisitDate2())) {
			cond.setVisitDate2(CommonUtils.getOneDayBeforeForString(new Date()));
		}
		DateTime[] dates = DateTimeUtils.getDates(cond.getVisitDate1(),cond.getVisitDate2());
		List<String> lDate = DateTimeUtils.toListStr(dates);
		List<String> lSimpleDate = DateTimeUtils.toListStr(dates,"dd");
		
		this.listDate = new ArrayList<Map<String,String>>();
		for(int i=0;i<lDate.size();i++){
			Map newDate = new HashMap();
			newDate.put("date",lDate.get(i) );
			newDate.put("shortDate",lSimpleDate.get(i) );
			newDate.put("showWeek",DateTimeUtils.getDayOfWeekStr(lDate.get(i)) );
			
			this.listDate.add(newDate);
		}				
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
		
	private Object deepClone(Object object) throws IOException, ClassNotFoundException    
	{    
		//将对象写到流里    
		ByteArrayOutputStream bo=new ByteArrayOutputStream();    
		ObjectOutputStream oo=new ObjectOutputStream(bo);    
		oo.writeObject(object);    
		//从流里读出来    
		ByteArrayInputStream bi=new ByteArrayInputStream(bo.toByteArray());    
		ObjectInputStream oi=new ObjectInputStream(bi);    
		return(oi.readObject());    
	}   
	
	

	public String getChartSeriesData(){
		String str = "";
		if(sumTableNum>0){
			for(int i=0;i<listSumTable.size()-1;i++){
				str+= "['"+listSumTable.get(i).get(1)+"',"+listSumTable.get(i).get(2)+"]";
				if(i<listSumTable.size()-2){
					str+= ",";
				}
			}
		}
		else{
			str = "['无数据',1]";
		}
		return str;
	}
	
	public String download() throws Exception{

		@SuppressWarnings("unchecked")
		List<Map<String, String>> dataList = (List<Map<String, String>>) request.getSession().getAttribute(ContSessionAttribute.CUSTOMER_TABLE+ContSessionAttribute.DOWNLOAD_DATA);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("dataList", dataList); //与模板里面的循环要求对应
		
		ReportUtils.downLoadReport(map, "customer-guangzhou-table.xls", "download-客户分类明细表-" + CustomerUtils.getNowForString() + ".xls", response);
		
		return null;
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
	

	/**
	 * session保存页面当前数据，用于下载
	 * @param dataList
	 */
	private void setDownloadDataInSession(List<Map<String, String>> dataList){
		request.getSession().setAttribute(ContSessionAttribute.CUSTOMER_TABLE+ContSessionAttribute.DOWNLOAD_DATA, dataList);		
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
		
		//形成日期形成的列表
		initListDate();	
		Map lDataMap = new HashMap();//为categoryDate_category:num这个的方式保存汇总数，方便再次取出			

		//查询数据库,形成分组(类别,日期)后的数据
		List<Map> listData=null;
		boolean isProjectQuestion = selCategory.matches("^[0-9]+$");
		if(isProjectQuestion){
			cond.setTopicId(selCategory);
			
			//具体回答问卷的详细内容
			listData = customerServices.findCustomerGroupQuestionTopic(cond); 
			
			if(listData.size()!=0){
				for(Map m :listData){
					int num=1;
					String[] s=String.valueOf(m.get("anwserContent")).split("\\r\\n");
					for(String c:s){
						if(c.startsWith("1")){//答卷中有1,代表回答了该选项
							String key = m.get("categoryDate")+"_"+c.split(":")[1];
							num++;
							lDataMap.put(key, num);								

							continue;
						}						
					}					
				}				
			}
		}else{
			cond.setGroupField(selCategory);
			listDBData=customerServices.findCustomerGroup(cond);
			
			for(int i=0;i<listDBData.size();i++){
				String key = listDBData.get(i).get("categoryDate")+"_"+listDBData.get(i).get("category");
				String val = String.valueOf(listDBData.get(i).get("num"));
				lDataMap.put(key, val);
			}
		}

		List<Map<String, String>> retList = new ArrayList<Map<String,String>>();//输出到页面的内容
		for(int i=0;i<listCategory.size();i++){
			for(int j=0;j<listDate.size();j++){
				String key = listDate.get(j).get("date")+"_"+listCategory.get(i).get("codeDesc");
				if(isProjectQuestion==false){
					key = listDate.get(j).get("date")+"_"+listCategory.get(i).get("codeVal");
				}
				if(lDataMap.containsKey(key)){
					Map<String, String> map = new HashMap<String, String>();

					map.put("category", listCategory.get(i).get("codeDesc"));
					map.put("date", listDate.get(j).get("date"));
					map.put("sumCount", lDataMap.get(key).toString());

					retList.add(map);	
				}
				
			}
		}
		
//		initMapSumTable();

		setDownloadDataInSession(retList);
		
		AJAXUtils.writeResponse(response, CommonUtils.getMapJsonAnd(retList));
		
		return "success";
	}
}
