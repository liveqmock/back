package com.ihk.saleunit.action.new_questions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.property.data.pojo.PropertyArea;
import com.ihk.property.data.pojo.PropertyAreaCond;
import com.ihk.property.data.pojo.PropertyBuild;
import com.ihk.property.data.pojo.PropertyBuildCond;
import com.ihk.property.data.pojo.PropertyProject;
import com.ihk.property.data.services.IPropertyAreaServices;
import com.ihk.property.data.services.IPropertyBuildServices;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.saleunit.data.pojo.Question;
import com.ihk.saleunit.data.pojo.QuestionTopic;
import com.ihk.saleunit.data.pojo.QuestionTopicCond;
import com.ihk.saleunit.data.services.IQuestionServices;
import com.ihk.saleunit.data.services.IQuestionTopicServices;
import com.ihk.utils.CommonPojoUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.SupperAction;
import com.ihk.utils.saleunitnew.JsonUtils;

/**
 * 楼盘初始 复制问卷
 * */
public class QuestionCopyAction extends SupperAction{
	private static final long serialVersionUID = 1L;
	@Autowired IQuestionServices questionServices; 
	@Autowired IQuestionTopicServices questionTopicServices;
	@Autowired IPropertyAreaServices propertyAreaServices;
	@Autowired IPropertyBuildServices propertyBuildServices;
	@Autowired IPropertyUnitServices propertyUnitServices;
	private int qid;
	List<PropertyProject> proList;
	
	public String copyDialog(){
		Question quest = questionServices.findQuestionById(qid);
		this.request.getSession().setAttribute("selectBuildId", quest.getBuildId()+"");
		proList = JsonUtils.roleProlist();
		
		return "suc";
	}
	
	private int pid;
	public String getArea() throws Exception{
		PropertyAreaCond cond = new PropertyAreaCond();
		cond.setPropertyId(pid);
		List<PropertyArea> areaList = propertyAreaServices.findPropertyArea(cond);
		StringBuffer sb = new StringBuffer();
		for(PropertyArea area: areaList){
			sb.append("<tr class='p"+pid+"' id='a"+area.getId()+"' style=\"background-color:#ffffff;color:#000000  \" onclick=\"javascript:click_area_tr("+area.getId()+")\"><td>");
			sb.append("&nbsp;&nbsp;&nbsp;");
			sb.append("<span style=\"color:blue\">[+]</span>" +area.getAreaName());
			sb.append("</td><td></td></tr>");
		}
		
		CustomerUtils.writeResponse(response, sb.toString());
		
		return null;
	}
	
	private int aid;
	public String getBuild() throws Exception{
		PropertyBuildCond cond = new PropertyBuildCond();
		cond.setAreaId(aid+"");
		List<PropertyBuild> buildList = propertyBuildServices.findPropertyBuild(cond);
		String selectBuildId = request.getSession().getAttribute("selectBuildId").toString();
		int intSelectBuildId = 0;//去掉复制的原楼栋
		if(selectBuildId!=null){
			intSelectBuildId = Integer.parseInt(selectBuildId);
		}
		StringBuffer sb = new StringBuffer();
		for(PropertyBuild build: buildList){
			if(build.getId() == intSelectBuildId)continue;
			sb.append("<tr id='b"+build.getId()+"' class='a"+aid+"  p"+build.getPropertyId()+"' style=\"background-color: 	#ffffff;color:#000000;line-height: 14px\" ><td>");
			sb.append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
			sb.append(build.getBuildName());
			sb.append("</td><td> <input type='checkbox' name='buildIds' value = '"+build.getId()+"'/>  </td></tr>");
		}
		
		CustomerUtils.writeResponse(response, sb.toString());
		
		return null;
	}
	
	private String buildIds;
	/**
	 * 复制选定的问卷到楼栋
	 * @param qid 问卷id
	 * @param buildIds 楼栋IDS
	 * */
	public String copyForm() throws Exception{
		//1 question 复制
		
		//2 toc 复制
		String[] bids = buildIds.split(", ");
		Question qu ;
		Question selQuestion = questionServices.findQuestionById(qid);
		
		
		for(String bid : bids) {
			qu = new Question();
			qu.setBuildId(Integer.parseInt(bid));
			CommonPojoUtils.initPojoCommonFiled(qu);
			qu.setQuestionName(selQuestion.getQuestionName());
			questionServices.addQuestion(qu);
			
			QuestionTopicCond cond = new QuestionTopicCond();
			QuestionTopic initq = new QuestionTopic();
			CommonPojoUtils.initPojoCommonFiled(initq);
			cond.setTopic(initq);
			cond.setLikeQuestionId(qid+"");
			cond.setQuestionId(qu.getId());
			
			questionTopicServices.copyByDemo(cond);
		}
		
		
		addActionMessage("复制成功");
		return copyDialog();
	}

	
	
	public int getQid() {
		return qid;
	}

	public void setQid(int qid) {
		this.qid = qid;
	}

	public String getBuildIds() {
		return buildIds;
	}

	public void setBuildIds(String buildIds) {
		this.buildIds = buildIds;
	}

	public List<PropertyProject> getProList() {
		return proList;
	}

	public void setProList(List<PropertyProject> proList) {
		this.proList = proList;
	}



	public int getPid() {
		return pid;
	}



	public void setPid(int pid) {
		this.pid = pid;
	}



	public int getAid() {
		return aid;
	}



	public void setAid(int aid) {
		this.aid = aid;
	}
	
	
	
}
