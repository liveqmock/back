package com.ihk.customer.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.EnumPrivCode;
import com.ihk.permission.PermissionUtils;
import com.ihk.property.data.pojo.PropertyUnitCond;
import com.ihk.saleunit.data.pojo.QuestionAnswerDetail;
import com.ihk.saleunit.data.pojo.QuestionAnswerDetailCond;
import com.ihk.saleunit.data.pojo.QuestionCond;
import com.ihk.saleunit.data.pojo.QuestionTopic;
import com.ihk.saleunit.data.pojo.QuestionTopicCond;
import com.ihk.saleunit.data.services.IQuestionAnswerDetailServices;
import com.ihk.saleunit.data.services.IQuestionTopicServices;
import com.ihk.saleunit.data.services.IReportDefineColumnServices;
import com.ihk.saleunit.data.services.IReportDefineTypeServices;
import com.ihk.user.data.pojo.CompanyProject;
import com.ihk.user.data.pojo.CompanyProjectCond;
import com.ihk.user.data.services.ICompanyProjectServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.ReportUtils;
import com.ihk.utils.SupperAction;


/**
 * 报表：售后问卷分析
 * 性能暂不考虑，如果性能有问题，做成定时器来实施
 */
public class ShwjReportAction extends SupperAction {

	private static final long serialVersionUID = 1L;

	@Autowired
	IQuestionTopicServices questionTopicServices;
	@Autowired
	IQuestionAnswerDetailServices questionAnswerDetailServices;
	@Autowired
	ICompanyProjectServices companyProjectServices;

	@Autowired
	IReportDefineTypeServices reportDefineTypeServices;
	@Autowired
	IReportDefineColumnServices reportDefineColumnServices;
	
	public String shwjReportFirst() throws Exception{
		
		initSearchDate();
		
		return "shwjReportFirst";
	}
	
	public String shwjReport() throws Exception{
		
		initSearchDate();
		
		CompanyProjectCond companyProjectCond = new CompanyProjectCond();
		companyProjectCond.setProjectId(String.valueOf(propertyUnitCond.getProjectId()));
		//公司项目
		List<CompanyProject> companyProject = companyProjectServices.findCompanyProjectByCond(companyProjectCond);
		HashMap<Integer, List<QuestionTopic>> comTopic = new HashMap<Integer, List<QuestionTopic>>();
		for(int n=0; n<companyProject.size(); n++){
			QuestionTopicCond cond = new QuestionTopicCond();
			cond.setCompanyProjectId(companyProject.get(n).getId());
			List<QuestionTopic> tops = questionTopicServices.findQuestionTopic(cond);
			comTopic.put(companyProject.get(n).getId(), tops);
		}
		
		//查询问卷
		List<QuestionTopic> listTopic = questionTopicServices.findQuestionTopic(questionTopicCond);
						
		List<QuestionAnswerDetail> listAnswer = questionAnswerDetailServices.findQuestionAnswerDetail(questionAnswerDetailCond);
		
		//答案以topicId进行分组
		HashMap<Integer, List<QuestionAnswerDetail>> hmAnswer = new HashMap<Integer, List<QuestionAnswerDetail>>();
		for(int i=0;i<listAnswer.size();i++){
			QuestionAnswerDetail answer = listAnswer.get(i);
			if(hmAnswer.containsKey(answer.getTopicId())){
				List<QuestionAnswerDetail> listInMap = hmAnswer.get(answer.getTopicId());
				listInMap.add(answer);				
			}
			else{
				List<QuestionAnswerDetail> listInMap = new ArrayList<QuestionAnswerDetail>();
				listInMap.add(answer);
				
				hmAnswer.put(answer.getTopicId(), listInMap);
			}
		}

		StringBuilder sb = new StringBuilder();
		//构件公司项目表格
		for(int m=0; m<companyProject.size(); m++){
			sb.append("<table width=\"100%\"  border=\"1\" align=\"center\" cellpadding=\"1\" cellspacing=\"0\" style=\"border-color:#a9d9ff;\">");
			sb.append("<tr bgcolor='#FFFFFF'>");
			sb.append("<th width='30%'>");
			sb.append("项目");
			sb.append("</th>");
			sb.append("<th>");
			sb.append(companyProject.get(m).getProjectName());
			sb.append("</th>");
			sb.append("</tr>");
			
			sb.append("<tr bgcolor='#FFFFFF'>");
			sb.append("<td width='30%'>");
			sb.append("问卷数量");
			sb.append("</td>");
			sb.append("<td>");
			sb.append(comTopic.get(companyProject.get(m).getId()).size());
			sb.append("</td>");
			sb.append("</tr>");
			sb.append("</table>");
		}
		
		//构建问卷的表格的表头
		for(int i=0;i<listTopic.size();i++){			
			QuestionTopic topic = listTopic.get(i);

			StringBuilder sbTRs = new StringBuilder();//具体的数据
			sbTRs.append("<tr bgcolor='#FFFFFF'><td>&nbsp;</td>");
			
			sb.append("<table width=\"100%\" border=\"1\"  align=\"center\" cellpadding=\"0\" cellspacing=\"1\" style=\"border-color:#a9d9ff;\" >");
			sb.append("<tr bgcolor='#FFFFFF'>");
			sb.append("<th>");
			sb.append(topic.getTopicName());
			sb.append("</th>");
			
			String[] content = topic.getTopicContent().split("\r\n");
			List<QuestionAnswerDetail> listInMap = hmAnswer.get(topic.getId());
			for(String c:content){
				sb.append("<th>");
				sb.append(c);
				sb.append("</th>");

				sbTRs.append("<td>");
				int answerCount = 0;
				if(listInMap!=null){
					for(int j=0;j<listInMap.size();j++){
						String an = listInMap.get(j).getAnwserContent();
						if(an.contains("1:"+c)){
							answerCount++;
						}
					}
				}
				sbTRs.append(String.valueOf(answerCount));	
				sbTRs.append("</td>");	
			}

			sb.append("</tr>");
			
			//具体答卷的一行
			sbTRs.append("</tr>");
			sb.append(sbTRs.toString());
			
			
			
			sb.append("</table>");
			sb.append("<br>");
		}

		System.out.println(sb.toString()+"sb");
		
		//查询答卷
		
		
		//根据问卷与答卷，形成多个table
						
		
		setShowTables(sb.toString());//设置输出
		request.getSession().setAttribute("showTables",showTables);
		return "success";
	}	

	private String showTables;
	public String getShowTables(){
		return showTables;
	}
	
	public void setShowTables(String showTables){
		this.showTables = showTables;
	}

	private QuestionCond questionCond;	

	private QuestionTopicCond questionTopicCond;	

	private QuestionAnswerDetailCond questionAnswerDetailCond;	
	
	private PropertyUnitCond propertyUnitCond;

	public PropertyUnitCond getPropertyUnitCond() {
		return propertyUnitCond;
	}

	public void setPropertyUnitCond(PropertyUnitCond propertyUnitCond) {
		this.propertyUnitCond = propertyUnitCond;
	}

	public QuestionCond getQuestionCond() {
		return questionCond;
	}

	public void setQuestionCond(QuestionCond questionCond) {
		this.questionCond = questionCond;
		autoSetCond();
	}
	
	private void autoSetCond(){
		if(questionTopicCond==null){
			questionTopicCond = new QuestionTopicCond();
		}
		if(questionAnswerDetailCond==null){
			questionAnswerDetailCond = new QuestionAnswerDetailCond();
		}
		if(propertyUnitCond == null)
			propertyUnitCond = new PropertyUnitCond();

		propertyUnitCond.addPermissionCompanyProjectIds(PermissionUtils.getUserProjectIdList(EnumPrivCode.REPORT_SALEUNIT_STAT));
		questionTopicCond.setCompanyProjectId(propertyUnitCond.getProjectId());
		questionTopicCond.setDate1(questionCond.getDate1());
		questionTopicCond.setDate2(questionCond.getDate2());
		
		questionAnswerDetailCond.setCompanyProjectId(propertyUnitCond.getProjectId());
		questionAnswerDetailCond.setDate1(questionCond.getDate1());
		questionAnswerDetailCond.setDate2(questionCond.getDate2());
	}
	
	private void initSearchDate(){
		if (questionCond == null) {
			questionCond = new QuestionCond();
		if(propertyUnitCond == null)
			propertyUnitCond = new PropertyUnitCond();
		
		//propertyUnitCond.addPermissionProjectIds();
		//propertyUnitCond.setSearchProjectIds(propertyUnitCond.getPrivProjectIds());
			
		questionCond.setDate1(CommonUtils.getMonthFirstForString());
		questionCond.setDate2(CommonUtils.getMonthEndForString());

			autoSetCond();
		}	
		
		if(selCategory1 == null){
			selCategory1 = "CJSJJC_LC";//默认楼层
		}
		
	}
	
	//下拉框(分析内容1)
	private LinkedHashMap<String, String> listSelCategory1;
	
	//选中的分析内容1
	private String selCategory1;
		
	public String getSelCategory1() {
		return selCategory1;
	}

	public void setSelCategory1(String selCategory1) {
		this.selCategory1 = selCategory1;
	}

	/**
	 * 分析内容1的列表
	 * @return
	 */
	public LinkedHashMap<String, String> getListSelCategory1() {
		if(listSelCategory1==null){
			listSelCategory1 = new LinkedHashMap<String, String>();
			
			listSelCategory1.put("CJSJJC_LC","楼层");
			listSelCategory1.put("CJSJJC_FH","房号");
			listSelCategory1.put("CJSJJC_JZMJ","建筑面积");
			listSelCategory1.put("CJSJJC_TNMJ","套内面积");
			listSelCategory1.put("CJSJJC_ZXBZ","装修标准");
			listSelCategory1.put("CJSJJC_FJJG","房间结构");
			listSelCategory1.put("CJSJJC_CPLX","产品类型");
			listSelCategory1.put("CJSJJC_CX","朝向");
			listSelCategory1.put("CJSJJC_JG","景观");
			listSelCategory1.put("CJSJJC_CJZJ","成交总价");
			listSelCategory1.put("CJSJJC_FKFS","付款方式");			

			listSelCategory1.put("CJSJJC_JZQY","居住区域");
			listSelCategory1.put("CJSJJC_GZQY","工作区域");
			listSelCategory1.put("CJSJJC_ZYCS","置业次数");
			listSelCategory1.put("CJSJJC_GFYT","购房用途");
			listSelCategory1.put("CJSJJC_KHLY","客户来源");
			listSelCategory1.put("CJSJJC_HY","行业");
			listSelCategory1.put("CJSJJC_JTRS","家庭人数");
			listSelCategory1.put("CJSJJC_NLC","年龄层");
			listSelCategory1.put("CJSJJC_XSRR","销售人员");

		}
		return listSelCategory1;
	}
	
	//导出
	public String download() throws Exception {
		
		final StringBuffer sb = new StringBuffer();
		sb.append((String)request.getSession().getAttribute("showTables"));
		
		String fileName = "download-" + CustomerUtils.getNowForString() + "-.xls";
		ReportUtils.downLoadReport(sb.toString(), fileName, response);
		return SUCCESS;
	}

}
