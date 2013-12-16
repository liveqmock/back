package com.ihk.saleunit.data.pojo;

import java.io.Serializable;
import java.util.Date;

import com.ihk.utils.mobile.MobileCustomerUtils;

/**
 * QuestionTopic的实体类
 * @author 
 *
 */
public class QuestionTopic implements Serializable{
	private static final long serialVersionUID = 1L;

	//以下由代码生成器生成,如果手工添加代码，务必写在本代码页面最下方
    
	private int id;
	private int questionId;
	private String topicGroup;
	private String topicName;
	private String topicType;
	private String fillType;
	private String topicContent;
	private int orderIndex;
	private String isDeleted;
	private int createdId;
	private Date createdTime;
	private int modId;
	private Date modTime;

	/**
	 * 取得isRequired 
	 * 判断选填中的必填,fill_type=1必填，否则选填.
	 * @return
	 */
	public boolean getIsRequired() {
		if("1".equals(fillType))
			return true;
		else
			return false;
	}

	/**
	 * 取得Id()
	 */
	public int getId() {
		return id;
	}

	/**
	 * 设置id()
	 * @param id ()
	 */
	public void setId(int id) {
		this.id = id;
	}
    
	/**
	 * 取得QuestionId(问卷id)
	 */
	public int getQuestionId() {
		return questionId;
	}

	/**
	 * 设置questionId(问卷id)
	 * @param questionId (问卷id)
	 */
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
    
	/**
	 * 取得TopicGroup(类别分组)
	 */
	public String getTopicGroup() {
		return topicGroup;
	}

	/**
	 * 设置topicGroup(类别分组)
	 * @param topicGroup (类别分组)
	 */
	public void setTopicGroup(String topicGroup) {
		this.topicGroup = topicGroup;
	}
    
	/**
	 * 取得TopicName(题目名称)
	 */
	public String getTopicName() {
		return topicName;
	}

	/**
	 * 设置topicName(题目名称)
	 * @param topicName (题目名称)
	 */
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
    
	/**
	 * 取得TopicType(题目类型)
	 */
	public String getTopicType() {
		return topicType;
	}

	/**
	 * 设置topicType(题目类型)
	 * @param topicType (题目类型)
	 */
	public void setTopicType(String topicType) {
		this.topicType = topicType;
	}
	
	/**
	 * 取得fillType(选填/必填)
	 * @return
	 */
	public String getFillType() {
		return fillType;
	}

	/**
	 * 设置fillType(选填/必填)
	 * @return
	 */
	public void setFillType(String fillType) {
		this.fillType = fillType;
	}
    
	/**
	 * 取得TopicContent(题目内容)
	 */
	public String getTopicContent() {
		return topicContent;
	}

	/**
	 * 设置topicContent(题目内容)
	 * @param topicContent (题目内容)
	 */
	public void setTopicContent(String topicContent) {
		this.topicContent = topicContent;
	}
    
	/**
	 * 取得OrderIndex(序号)
	 */
	public int getOrderIndex() {
		return orderIndex;
	}

	/**
	 * 设置orderIndex(序号)
	 * @param orderIndex (序号)
	 */
	public void setOrderIndex(int orderIndex) {
		this.orderIndex = orderIndex;
	}
    
	/**
	 * 取得IsDeleted(是否删除)
	 */
	public String getIsDeleted() {
		return isDeleted;
	}

	/**
	 * 设置isDeleted(是否删除)
	 * @param isDeleted (是否删除)
	 */
	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}
    
	/**
	 * 取得CreatedId(创建人)
	 */
	public int getCreatedId() {
		return createdId;
	}

	/**
	 * 设置createdId(创建人)
	 * @param createdId (创建人)
	 */
	public void setCreatedId(int createdId) {
		this.createdId = createdId;
	}
    
	/**
	 * 取得CreatedTime(创建时间)
	 */
	public Date getCreatedTime() {
		return createdTime;
	}

	/**
	 * 设置createdTime(创建时间)
	 * @param createdTime (创建时间)
	 */
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
    
	/**
	 * 取得ModId(修改人)
	 */
	public int getModId() {
		return modId;
	}

	/**
	 * 设置modId(修改人)
	 * @param modId (修改人)
	 */
	public void setModId(int modId) {
		this.modId = modId;
	}
    
	/**
	 * 取得ModTime(修改时间)
	 */
	public Date getModTime() {
		return modTime;
	}

	/**
	 * 设置modTime(修改时间)
	 * @param modTime (修改时间)
	 */
	public void setModTime(Date modTime) {
		this.modTime = modTime;
	}
    
	
	public QuestionTopic(){};


	/**
	 * 
	 * @param id ()
	 * @param questionId (问卷id)
	 * @param topicGroup (类别分组)
	 * @param topicName (题目名称)
	 * @param topicType (题目类型)
	 * @param topicContent (题目内容)
	 * @param orderIndex (序号)
	 * @param isDeleted (是否删除)
	 * @param createdId (创建人)
	 * @param createdTime (创建时间)
	 * @param modId (修改人)
	 * @param modTime (修改时间)
	 */
	public QuestionTopic(    
		int id,
        		int questionId,
        		String topicGroup,
        		String topicName,
        		String topicType,
        		String topicContent,
        		int orderIndex,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime
        ) {
		super();  
		this.id = id;
		this.questionId = questionId;
		this.topicGroup = topicGroup;
		this.topicName = topicName;
		this.topicType = topicType;
		this.topicContent = topicContent;
		this.orderIndex = orderIndex;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
    
	/**
	 * 
	 * @param questionId (问卷id)
	 * @param topicGroup (类别分组)
	 * @param topicName (题目名称)
	 * @param topicType (题目类型)
	 * @param topicContent (题目内容)
	 * @param orderIndex (序号)
	 * @param isDeleted (是否删除)
	 * @param createdId (创建人)
	 * @param createdTime (创建时间)
	 * @param modId (修改人)
	 * @param modTime (修改时间)
	 */
	public QuestionTopic(    
		int questionId,
        		String topicGroup,
        		String topicName,
        		String topicType,
        		String topicContent,
        		int orderIndex,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime
        ) {
		super();		
		this.questionId = questionId;
		this.topicGroup = topicGroup;
		this.topicName = topicName;
		this.topicType = topicType;
		this.topicContent = topicContent;
		this.orderIndex = orderIndex;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
    

	//以上由代码生成器生成
	//以下非代码生成器生成,不可覆盖,以下是手工代码
    
	
	
	
	public String getInputHtml(){
		//type 1 是单选
		String res = "";
		if(topicType.equals("1")){
			String rad[] = topicContent.split("\r\n");
			for (String s : rad) {
				res += "&nbsp;&nbsp;<label>"+s+"<input type='radio' name = 'formMap.hh"+id+"' value = '"+s+"'/></label>";
			}
		}else if(topicType.equals("2")){
			String rad[] = topicContent.split("\r\n");
			for (String s : rad) {
				res += "&nbsp;&nbsp;<label>"+s+"<input type='checkbox' name = 'formMap.hh"+id+"' value = '"+s+"'/></label>";
			}
			
		}
		return res; 
	}
	
	public String getInputAndOtherHtml(){
		//type 1 是单选 2是多选 3是纯文本框
		String res = "";
		if(topicType.equals("1")){
			String rad[] = topicContent.split("\r\n");
			for(int i = 0 ;i < rad.length ;i++){
				res += "&nbsp;&nbsp;<label><input style='vertical-align: middle;' type='radio' name = 'formMap.hh"+id+"' value = '"+i+"'/><span style='vertical-align: middle;'>"+rad[i]+"</span></label>";
			}
			res += "&nbsp;&nbsp;<label><span style='vertical-align: middle;'></span><input style='vertical-align: middle;' type='text' name = 'formMap.hhother"+id+"' value = ''/></label>";
		}else if(topicType.equals("2")){
			String rad[] = topicContent.split("\r\n");
			for(int i = 0 ;i < rad.length ;i++){
				res += "&nbsp;&nbsp;<label><input style='vertical-align: middle;' type='checkbox' name = 'formMap.hh"+id+"' value = '"+i+"'/><span style='vertical-align: middle;'>"+rad[i]+"</span></label>";
			}
			res += "&nbsp;&nbsp;<label><span style='vertical-align: middle;'></span><input style='vertical-align: middle;' type='text' name = 'formMap.hhother"+id+"' value = ''/></label>";
		}else if(topicType.equals("3")){
			res += "<input style='width:80%; vertical-align: middle;' type='text' name = 'formMap.hhother"+id+"' value = ''/></label>";
		}
		return res; 
	}
	
	/**
	 * 手机的选项
	 * @return
	 */
	public String getInputAndOtherHtmlForMobile(){
		
		return MobileCustomerUtils.getQuestionTopicHtml(this);
	}
	
}
