package com.ihk.customer.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.ContCompanyId;
import com.ihk.constanttype.ContSessionAttribute;
import com.ihk.constanttype.ContTable;
import com.ihk.constanttype.EnumPrivCode;
import com.ihk.customer.data.pojo.CustomerCond;
import com.ihk.customer.data.services.ICustomerServices;
import com.ihk.permission.PermissionUtils;
import com.ihk.saleunit.data.pojo.QuestionAnswerDetailCond;
import com.ihk.saleunit.data.pojo.QuestionTopic;
import com.ihk.saleunit.data.pojo.QuestionTopicCond;
import com.ihk.saleunit.data.services.IQuestionAnswerDetailServices;
import com.ihk.saleunit.data.services.IQuestionTopicServices;
import com.ihk.utils.ActionAjaxPageCallback;
import com.ihk.utils.ActionTemplate;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.GuangZhouUtils;
import com.ihk.utils.ReportUtils;
import com.ihk.utils.SupperAction;

/**
 * 报表：客户标红表分析(统计每个字段录入的情况) 
 * 1: 默认标红 (必须分析的字段)
 * 2: red表标红
 * form表单条件
 * 1: 项目
 * 2: 时间跨度
 * 
 * jsp: customer/guangzhou/customerRed_analysis.jsp
 * */
public class CustomerRedAnalysis extends SupperAction{

	private static final long serialVersionUID = 1L;
	@Autowired ICustomerServices customerServices;
	@Autowired IQuestionAnswerDetailServices questionAnswerDetailServices;	
	@Autowired IQuestionTopicServices questionTopicServices;	
		
	/**
	 * index jsp
	 * */
	public String index(){
		return "success";				
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
		setCondOrderSortByRequest(cond);

		if(cond.getSearchCompanyProjectIds().size() == 0){
			
			CustomerUtils.writeResponse(response, "[]");
			
			return null;
		}
		List<Integer> prlist = PermissionUtils.getUserProjectIdList(EnumPrivCode.REPORT_PRECUSTOMER_DOWNLOAD);
		if(prlist == null || prlist.size() == 0){
			
			CustomerUtils.writeResponse(response, "[]");
			
			return null;
		}

		ActionTemplate.executeAjaxPage(this, cond, new ActionAjaxPageCallback() {
			
			@Override
			public int initTotal() throws Exception {
				//不分页的做法
				cond.pageSize = 0;
				return 0;
			}

			//获取table中要显示的json
			@Override
			public List<Map<String, String>> initRows() throws Exception {
				
				List<Map<String, String>> retList = new ArrayList<Map<String,String>>();
				
				List<Map> list = customerServices.findAllFiledInputCount(cond); 
				
				if(!CommonUtils.isCollectionEmpty(list)){
					
					Map<String, String> map = null;
					
					//总数量
					int sum = 0;
					if(list!=null && list.size()>0){
						sum = Integer.valueOf(list.get(0).get("inputCount").toString());
					}			   

					//修正从数据库取出的值,与jsp中table的表头(th field)定义一致
					for(Map row:list){
						if(row.get("fieldName").toString().equalsIgnoreCase("workBlock"))//跳过工作区域
							continue;

						map = new HashMap<String, String>();
						map.put("fieldName", GuangZhouUtils.getRowName(row.get("fieldName").toString()));
						map.put("inputCount", row.get("inputCount").toString());
						map.put("notInputCount", String.valueOf(sum - Integer.valueOf(row.get("inputCount").toString())));
						if(sum==0){
							map.put("inputRate","-");
						}
						else{
							map.put("inputRate",(Integer.valueOf(row.get("inputCount").toString()))*100/sum+"%");
						}	
						retList.add(map);
					}
					

				   	//如果是单一项目，着输出自定义项目的内容
				   	if(cond.getSearchProjectIds()!=null && cond.getSearchProjectIds().size()==1){
				   		boolean isDefine = addDefineQuestion(retList,sum);	
				   		//如果是安徽公司的项目，输出customer的选填内容
				   		if(isDefine == false ||
				   				DescUtils.getCompanyIdByProjectId(cond.getSearchProjectIds().get(0))==ContCompanyId.AN_HUI){
				   			addOptionFieldCount(retList,sum);
				   		}
				   	}

					setDownloadDataInSession(retList);
				}
				return retList;				
			}
		});
		
		return null;
	}

	/**
	 * session保存页面当前数据，用于下载
	 * @param dataList
	 */
	private void setDownloadDataInSession(List<Map<String, String>> dataList){
		request.getSession().setAttribute(ContSessionAttribute.CUSTOMER_RED_ANALYSIS+ContSessionAttribute.DOWNLOAD_DATA, dataList);		
	}
	
	/**
	 * 选填内容的答卷情况
	 * @param sum
	 */
	private void addOptionFieldCount(List<Map<String, String>> retList,int sum){
		List<Map> optionLists = this.customerServices.findOptionFieldInputCount(cond);	

	   	for(Map row:optionLists){
	   		Map<String, String> newMap = new HashMap<String, String>();
	   		//问卷的题目
	   		newMap.put("fieldName", GuangZhouUtils.getRowName(row.get("fieldName").toString()));
	   		newMap.put("inputCount", String.valueOf(Integer.valueOf(row.get("inputCount").toString())));
	   		newMap.put("notInputCount", String.valueOf(sum - Integer.valueOf(row.get("inputCount").toString())));
	   		if(sum==0){
	   			newMap.put("inputRate","-");
	   		}
	   		else{
	   			newMap.put("inputRate",(Integer.valueOf(row.get("inputCount").toString()))*100/sum+"%");
	   		}
	   		
	   		retList.add(newMap);
	   	}
	}
	
	/**
	 * 增加自定义问卷的答卷数输出
	 * @param sum
	 */
	private boolean addDefineQuestion(List<Map<String, String>> retList,int sum){
		QuestionAnswerDetailCond questionAnswerDetailCond =  new QuestionAnswerDetailCond();
   		questionAnswerDetailCond.setCompanyProjectId(cond.getSearchProjectIds().get(0)); 	//查询单一项目的录入情况
   		questionAnswerDetailCond.setDate1(cond.getDate1());
   		questionAnswerDetailCond.setDate2(cond.getDate2());
   		if(cond.getUserId()!=null&& cond.getUserId().isEmpty()==false){
   			questionAnswerDetailCond.setCreatedId(Integer.valueOf(cond.getUserId()));
   		}
	   	List<Map> listTopicCount = questionAnswerDetailServices.findQuestionAnswerInputCount(questionAnswerDetailCond);

	   	//先把该项目的问卷调出来，再匹配填写的情况	(即使没有答卷，也要填充表格)	
	   	QuestionTopicCond questionTopicCond = new QuestionTopicCond();
	   	questionTopicCond.setSearchProjectIds(cond.getSearchProjectIds());
	   	questionTopicCond.setPrivCompanyProjectIds(cond.getSearchProjectIds());
	   	List<QuestionTopic> listTopic = questionTopicServices.findQuestionTopic(questionTopicCond);
	   	
	   	for(int i=0;i<listTopic.size();i++){
	   		if(listTopic.get(i).getTopicName().equalsIgnoreCase("工作地板块")) 
	   			continue;
	   		
	   		Map<String, String> newMap = new HashMap<String, String>();
	   		//问卷的题目
	   		newMap.put("fieldName", listTopic.get(i).getTopicName());
	   		newMap.put("inputCount", "0");
	   		newMap.put("notInputCount", "0");
	   		newMap.put("inputRate","-");
	   		
	   		//问卷的填写数量
		   	for(Map row:listTopicCount){
		   		if( row.get("topicName").toString().equalsIgnoreCase(listTopic.get(i).getTopicName())){
			   		newMap.put("inputCount", String.valueOf(Integer.valueOf(row.get("inputCount").toString())));
			   		if(sum>=Integer.valueOf(row.get("inputCount").toString())){
			   			newMap.put("notInputCount", String.valueOf(sum - Integer.valueOf(row.get("inputCount").toString())));
			   		}
			   		else{
			   			newMap.put("notInputCount", "0");
			   		}

			   		if(sum==0){
			   			newMap.put("inputRate","-");
			   		}
			   		else{
				   		if(sum>=Integer.valueOf(row.get("inputCount").toString())){
				   			newMap.put("inputRate",(Integer.valueOf(row.get("inputCount").toString()))*100/sum+"%");
				   		}
				   		else{
				   			newMap.put("inputRate","100%");				   			
				   		}
			   		}
			   		break;
		   		}
		   	}
		   	retList.add(newMap);
	   	}
	   	
	   	if(listTopic!=null && listTopic.size()>0){
	   		return true;
	   	}
	   	return false;
	}
	
	private CustomerCond cond;//表单用查询条件
	
	public CustomerCond getCond() {
		return cond;
	}

	public void setCond(CustomerCond cond) {
		this.cond = cond;
	}
	
	/**
	 * 导出数据
	 * @return
	 * @throws Exception
	 */
	public String download() throws Exception {
		@SuppressWarnings("unchecked")
		List<Map<String, String>> dataList = (List<Map<String, String>>) request.getSession().getAttribute(ContSessionAttribute.CUSTOMER_RED_ANALYSIS+ContSessionAttribute.DOWNLOAD_DATA);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("dataList", dataList); //与模板里面的循环要求对应
		
		ReportUtils.downLoadReport(map, "customer-red-analysis.xls", "download-客户质量分析-" + CustomerUtils.getNowForString() + ".xls", response);
		
		return null;
		
	}
	
}
