package com.ihk.saleunit.action.new_report;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.saleunit.action.new_report.cond.ZsCustomerAnalysisCond;
import com.ihk.saleunit.data.pojo.QuestionAnswerDetail;
import com.ihk.saleunit.data.services.IQuestionAnswerDetailServices;
import com.ihk.utils.ActionAjaxPageCallback;
import com.ihk.utils.ActionTemplate;
import com.ihk.utils.SupperAction;

/**
 * 中山客户情况分析
 * @author dtc
 * 2013-9-3,上午10:15:47
 */
public class ZhongShanCustomerAnalysisAction extends SupperAction{

	private static final long serialVersionUID = -1213089449706404481L;
	
	@Autowired
	IQuestionAnswerDetailServices questionAnswerDetailServices;
	
	/**
	 * 跳到界面
	 * @return
	 * @throws Exception
	 */
	public String toCustomerManager() throws Exception{
		
		return "toCustomerManager";
	}
	
	/**
	 * 表格数据action
	 * @return
	 * @throws Exception
	 */
	public String customerAjax() throws Exception{
		
		if(cond == null){
			cond = new ZsCustomerAnalysisCond();
		}
		
		ActionTemplate.executeAjaxPage(this, cond, new ActionAjaxPageCallback() {
			
			@Override
			public int initTotal() throws Exception {
				return 0;
			}
			
			@Override
			public List<Map<String, String>> initRows() throws Exception {
				
				List<Map<String, String>> mapList = new ArrayList<Map<String, String>>();
				
				List<QuestionAnswerDetail> detailList = questionAnswerDetailServices.findQuestionAnswerDetailByZsCond(cond);
				
				System.out.println(detailList.size());
				
				Map<String, String> map = null;
				
				for(int i=1; i<=100; i++){
					
					map = new LinkedHashMap<String, String>();
					
					map.put("questionName", "问题" + i);
					map.put("countPerson", i + "");
					
					mapList.add(map);
					
				}
				
				return mapList;
			}
		});
		
		return null;
	}
	
	////
	
	/**
	 * 查找cond
	 */
	private ZsCustomerAnalysisCond cond;
	
	public void setCond(ZsCustomerAnalysisCond cond) {
		this.cond = cond;
	}
	
	public ZsCustomerAnalysisCond getCond() {
		return cond;
	}
	
}
