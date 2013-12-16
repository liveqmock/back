package com.ihk.customer.action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.EnumChartCycel;
import com.ihk.constanttype.EnumPrivCode;
import com.ihk.customer.data.pojo.CustomerCond;
import com.ihk.customer.data.services.ICustomerServices;
import com.ihk.permission.PermissionUtils;
import com.ihk.setting.data.pojo.CodeDtl;
import com.ihk.setting.data.pojo.ProjectCode;
import com.ihk.setting.data.pojo.ProjectCodeCond;
import com.ihk.setting.data.services.ICodeDtlServices;
import com.ihk.setting.data.services.ICodeTypeServices;
import com.ihk.setting.data.services.IProjectCodeServices;
import com.ihk.utils.ActionTemplate;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.DateTimeUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.HighChartsUtils;
import com.ihk.utils.SupperAction;
import com.ihk.utils.method.ActionAjaxMethodModifyNoThrowsExceptionCallback;

/**
 * 客户单项数据走势
 *  * 
 * 实现思路
 * 1,按时间取得数据库对应的分组明细数据(以类别,日期分组)
 * 2,形成显示的表格List<List>,嵌套显示表格
 */
public class ChartCategoryNumAction extends SupperAction {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(ChartCategoryNumAction.class);

	@Autowired
	ICodeTypeServices codeTypeServices;
	@Autowired
	ICustomerServices customerServices;
	@Autowired
	ICodeDtlServices codeDtlServices;
	@Autowired
	IProjectCodeServices projectCodeServices;
	
	private CustomerCond cond;
	
	/**
	 * 数据库分组结果<br>
	 * 数据格式[categoryDate,category,num] 说明为:[日期,分类,数量]
	 */
	private List<Map> listDBData;

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

	
	
//	private String getCodeDesc(String val){		
//		String str = "";
//		for(int i=0;i<listCategory.size();i++){
//			if(val.equals(listCategory.get(i).get(0))){
//				str = listCategory.get(i).get(1).toString();
//				logger.info("doget"+str);
//				i=listCategory.size();
//			}
//		}
//		
//		return str;		
//	}

	public String index() {
		//项目问卷下拉框
		questionList=new LinkedHashMap<String,String>();
		questionList.put("0", "请选择");
		return "success";
	}

	/**
	 * 点击查询的数据返回
	 * @return
	 * @throws Exception
	 */
	public String searchAjax() throws Exception {
		//做法
		//listDBData的数据格式[categoryDate,category,num] 说明为:[日期,分类,数量]
		//得到列表列表listDate
		//得到日期列表listCategory
		
		//以上3个列表，拼凑出highchart需要的格式

		if (CustomerUtils.isStrEmpty(cond.getVisitDate1())) {
			cond.setVisitDate1(CommonUtils.getMonthFirstForString());
		}
		if (CustomerUtils.isStrEmpty(cond.getVisitDate2())) {
			cond.setVisitDate2(CommonUtils.getOneDayBeforeForString(new Date()));
		}
		
		//DEMO 异步返回一个Map,json的格式
		ActionTemplate.executeAjaxMethod(this, new ActionAjaxMethodModifyNoThrowsExceptionCallback() {			
			
			//获取table中要显示的json
			@Override
			public void modifyMethod() throws Exception {
				if(selCategory==null){
					selCategory = "HOME_DISTRICT";
				}
				boolean isSpecialAnswer = false;
				if(selCategory.matches("^[0-9]+$")==true){
					isSpecialAnswer = true;//是项目的特殊问卷(自定义问卷)
				}
				//查询数据库,形成分组(类别,日期)后的数据
				cond.setGroupField(selCategory);
				
				//日期列表
				DateTime[] dates = DateTimeUtils.getDates(cond.getVisitDate1(),cond.getVisitDate2());
				List<String> listDate = DateTimeUtils.toListStr(dates);	
				String[] arrayDates = new String[listDate.size()];
				for(int i=0;i<listDate.size();i++){
					arrayDates[i] = listDate.get(i);
				}

				//类别列表
				List<CodeDtl> listCode = new ArrayList<CodeDtl>();
				listCode = HighChartsUtils.initCodeDtlListForHomeWorkDistrict(codeTypeServices, codeDtlServices, cond, selCategory, listCode);
				Map<String,String> mapCategory = new HashMap<String,String>();
				for(CodeDtl c:listCode){
					if(isSpecialAnswer){
						mapCategory.put(c.getCodeDesc().trim(),c.getCodeDesc().trim());						
					}
					else{
						mapCategory.put(c.getCodeVal(),c.getCodeDesc().trim());						
					}					
				}
			
				List<Map> listData=null;
				//实际数据库的数据
				Map<String,Integer> mapData = new HashMap<String,Integer>();
				
				if(isSpecialAnswer){
					cond.setTopicId(selCategory);
					listData = customerServices.findCustomerGroupQuestionTopic(cond); 
					
					if(listData.size()!=0){
						for(Map m :listData){
							String[] s=String.valueOf(m.get("anwserContent")).split("\\r\\n");
							for(String c:s){
								if(c.startsWith("1")){
									//直接根据回答,算出回答的数量
									int num=1;
									String tempKey = c.split(":")[1].trim()+":"+m.get("categoryDate").toString();
									if(mapData.containsKey(tempKey)){
										num = mapData.get(tempKey)+1;
									}
									mapData.put(tempKey, num);
									continue;
								}
								
							}
							
						}
						
					}
				}else{
					cond.setGroupField(selCategory);
					listDBData=customerServices.findCustomerGroup(cond);

					for(Map m:listDBData){
						if(m.get("category")==null || m.get("categoryDate")==null){
							continue;
						}
						String k = m.get("category").toString()+":"+m.get("categoryDate").toString();
						Integer v = Integer.valueOf(m.get("num").toString());
						mapData.put(k, v);
					}	
				}					

				String str = HighChartsUtils.getChartDataByXAndMap(arrayDates, mapCategory, mapData);
				
				//根据日期列表,类别列表,实际数据三者形成返回的Map				
				Map<String,String> retMap = new HashMap<String,String>();
				retMap.put("chartdata", str);
				setUpEasyuiAjaxForSucc("",retMap);
			}
		});
		return null;
	}
	


}
