package com.ihk.saleunit.data.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ihk.permission.PermissionUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.SearchCond;

/**
 * QuestionTopic的查询条件
 * @author peter.kuang
 *
 */
public class QuestionTopicCond extends SearchCond{
	private static final long serialVersionUID = 1L;

	private int questionId;	
    
	private String likeQuestionId;
	
	private QuestionTopic topic;

	private int companyProjectId;

	private String date1;
	
	private String date2;
	
	private String topicName;
	
	/**
	 * 公司项目id
	 * @return
	 */
	public int getCompanyProjectId() {
		return companyProjectId;
	}

	public void setCompanyProjectId(int companyProjectId) {
		this.companyProjectId = companyProjectId;
	}

	/**
	 * 传入mapper查询的公司项目id(sql语句用)
	 */
	private List<Integer> companyProjectIds;

	/**
	 * 销控中心的项目id权限
	 */
	private List<Integer> privCompanyProjectIds;

	/**
	 * 页面查询的公司项目id
	 */
	private List<Integer> searchCompanyProjectIds;

	/**
	 * 查询项目id的的字符串,以逗号分隔
	 */
	private String strSearchCompanyProjectIds;

	/**
	 * 查询项目名称的的字符串,以逗号分隔
	 */
	private String strSearchCompanyProjectNames;
	

	public QuestionTopicCond setQuestionId(int questionId) {
		this.questionId = questionId;
		return this;
	}

	public String getLikeQuestionId() {
		return likeQuestionId;
	}

	public void setLikeQuestionId(String likeQuestionId) {
		this.likeQuestionId = likeQuestionId;
	}

	public QuestionTopic getTopic() {
		return topic;
	}

	public void setTopic(QuestionTopic topic) {
		this.topic = topic;
	}

	public int getQuestionId() {
		return questionId;
	}
	

	public String getDate1() {
		return date1;
	}

	public void setDate1(String date1) {
		this.date1 = date1;
	}

	public String getDate2() {
		return date2;
	}

	public void setDate2(String date2) {
		this.date2 = date2;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public List<Integer> getCompanyProjectIds() {
		return companyProjectIds;
	}

	public void setCompanyProjectIds(List<Integer> companyProjectIds) {
		 this.companyProjectIds=CommonUtils.getListCopy(companyProjectIds);		
	}

	public List<Integer> getSearchCompanyProjectIds() {
		return searchCompanyProjectIds;
	}

	public void setSearchProjectIds(List<Integer> searchCompanyProjectIds) {
		this.searchCompanyProjectIds = CommonUtils.getListCopy(searchCompanyProjectIds);		

		strSearchCompanyProjectIds = CommonUtils.ListToString(this.searchCompanyProjectIds);
		autoSetCompanyProjectIds();
	}

	/**
	 * 自动合并数据权限与页面传入的查询项目
	 * 取数据权限与查询权限的交集
	 */
	private void autoSetCompanyProjectIds(){
		if(companyProjectIds==null){
			companyProjectIds = new ArrayList<Integer>();
		}
		
		companyProjectIds.clear();

		if(privCompanyProjectIds!=null && searchCompanyProjectIds!=null && searchCompanyProjectIds.size()>0){//取得交集
			for(int i=0;i<privCompanyProjectIds.size();i++){
				if(this.searchCompanyProjectIds.contains(privCompanyProjectIds.get(i)) && !this.companyProjectIds.contains(privCompanyProjectIds.get(i))){
					this.companyProjectIds.add(privCompanyProjectIds.get(i));
				}				
			}
		}
		else{
			 this.companyProjectIds = CommonUtils.getListCopy(privCompanyProjectIds);//默认等于数据权限
		}
	}
	

	public List<Integer> getPrivCompanyProjectIds() {
		return privCompanyProjectIds;
	}

	public void setPrivCompanyProjectIds(List<Integer> privCompanyProjectIds) {
		this.privCompanyProjectIds=CommonUtils.getListCopy( privCompanyProjectIds);

		autoSetCompanyProjectIds();
	}

	/**
	 * 追加能查看的项目id
	 */
	public void addPermissionProjectIds(){
		List<Integer> listIds = PermissionUtils.getProjectIdListByXKZX();
		for(int i=0;i<listIds.size();i++){
			if(privCompanyProjectIds==null){
				privCompanyProjectIds = new ArrayList<Integer>();
			}
			if(!this.privCompanyProjectIds.contains(listIds.get(i))){
				this.privCompanyProjectIds.add(listIds.get(i));
			}
		}
		
		autoSetCompanyProjectIds();
	}
}
