package com.ihk.saleunit.action.new_questions;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.saleunit.data.pojo.Question;
import com.ihk.saleunit.data.pojo.QuestionTopic;
import com.ihk.saleunit.data.services.IQuestionServices;
import com.ihk.saleunit.data.services.IQuestionTopicServices;
import com.ihk.utils.MyTransationTemplate;
import com.ihk.utils.SessionUser;

/**
 * 2012-10-15
 * 初始化售后客户问卷
 * 
 * jira 554 : 每个楼栋都需要默认一套基本问卷
 * @author just
 * 
 * */
public class InitQuestion {
	
	
	/**
	 * 添加基本售后问卷
	 * @param bid 给那个楼栋新建售后问卷?
	 * */
	public boolean addBaseBeforQuestion(int bid ,IQuestionServices questionServices,IQuestionTopicServices questionTopicServices){
		try {
	
			Question ques = new Question();
					ques.setQuestionName("基本问卷");
					ques.setBuildId(bid);
					ques.setIsDeleted("0");
					ques.setCreatedId(SessionUser.getUserId());
					ques.setCreatedTime(new Date());
					ques.setModId(SessionUser.getUserId());
					ques.setModTime(ques.getCreatedTime());
					questionServices.addQuestion(ques);
					
					List<QuestionTopic> tocList = getTocByQuestionId(ques.getId());
					
					for(QuestionTopic t : tocList){
						questionTopicServices.addQuestionTopic(t);
					}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		

		return true;
	}
	
	/**
	 * 这里要逐条复制售前客户基本问卷需要的项
	 * */
	private List<QuestionTopic> getTocByQuestionId(int qid){
		List<QuestionTopic> quList = new ArrayList<QuestionTopic>(7);
		QuestionTopic customerHomeProvince = new QuestionTopic();
		customerHomeProvince.setQuestionId(qid);
		customerHomeProvince.setTopicContent("本地");
		customerHomeProvince.setTopicName("客户居住区域");
		customerHomeProvince.setTopicType("1");
		initToc(customerHomeProvince);
		quList.add(customerHomeProvince);
		
		QuestionTopic customerWorkProvince = new QuestionTopic();
		customerWorkProvince.setQuestionId(qid);
		customerWorkProvince.setTopicContent("本地");
		customerWorkProvince.setTopicName("客户工作区域");
		customerWorkProvince.setTopicType("1");
		initToc(customerWorkProvince);
		quList.add(customerWorkProvince);
		
		QuestionTopic customerNativePlace  = new QuestionTopic();
		customerNativePlace.setQuestionId(qid);
		customerNativePlace.setTopicContent("本地");
		customerNativePlace.setTopicName("客户籍贯");
		customerNativePlace.setTopicType("1");
		initToc(customerNativePlace);
		quList.add(customerNativePlace);
		
		QuestionTopic customerBuyUse  = new QuestionTopic();
		customerBuyUse.setQuestionId(qid);
		customerBuyUse.setTopicContent("自住\r\n投资\r\n自住兼投资");
		customerBuyUse.setTopicType("1");
		customerBuyUse.setTopicName("购房用途");
		initToc(customerBuyUse);
		quList.add(customerBuyUse);
		
		QuestionTopic customerBuyCount  = new QuestionTopic();
		customerBuyCount.setQuestionId(qid);
		customerBuyCount.setTopicContent("首次\r\n2次\r\n3次\r\n3次以上");
		customerBuyCount.setTopicType("1");
		customerBuyCount.setTopicName("置业次数");
		initToc(customerBuyCount);
		quList.add(customerBuyCount);
		
		
		QuestionTopic customerHouseType  = new QuestionTopic();
		customerHouseType.setQuestionId(qid);
		customerHouseType.setTopicContent("住宅\r\n公寓\r\n办公\r\n商业\r\n车位");
		customerHouseType.setTopicType("1");
		customerHouseType.setTopicName("产品类型");
		initToc(customerHouseType);
		quList.add(customerHouseType);
		
		QuestionTopic customerCustomerSource  = new QuestionTopic();
		customerCustomerSource.setQuestionId(qid);
		customerCustomerSource.setTopicContent("来电\r\n来访\r\n巡展\r\nCALL客\r\n陌拜\r\n电转访\r\n复访");
		customerCustomerSource.setTopicType("1");
		customerCustomerSource.setTopicName("客户来源");
		initToc(customerCustomerSource);
		quList.add(customerCustomerSource);
		
		
		return quList;
	}
	
	private void initToc(QuestionTopic t ){
		Date now = new Date();
		t.setCreatedId(SessionUser.getUserId());
		t.setCreatedTime(now);
		t.setModId(SessionUser.getUserId());
		t.setModTime(now);
		t.setIsDeleted("0");
	}
	
	
	
	
	
	
	
	
	
	
}
