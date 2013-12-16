package com.ihk.article.data.pojo;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.ihk.utils.DateTimeUtils;

/**
 * Article的实体类
 * @author 
 *
 */
public class Article implements Serializable{
	private static final long serialVersionUID = 1L;
    
		private int id;
		private String articleType;
		private String title;
		private String summary;
		private String content;
		private int orderIndex;
		private String devFlag;
		private String isCrm;
		private String isSale;
		private int companyId;
		private String isDeleted;
		private int createdId;
		private Date createdTime;
		private int modId;
		private Date modTime;
		private boolean showNew;


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
		 * 取得ArticleType(文章类型)
		 */
		public String getArticleType() {
			return articleType;
		}

		/**
		 * 设置articleType(文章类型)
		 * @param articleType (文章类型)
		 */
		public void setArticleType(String articleType) {
			this.articleType = articleType;
		}
	    
		/**
		 * 取得Title(标题)
		 */
		public String getTitle() {
			return title;
		}

		/**
		 * 设置title(标题)
		 * @param title (标题)
		 */
		public void setTitle(String title) {
			this.title = title;
		}
	    
		/**
		 * 取得Summary(摘要)
		 */
		public String getSummary() {
			return summary;
		}

		/**
		 * 设置summary(摘要)
		 * @param summary (摘要)
		 */
		public void setSummary(String summary) {
			this.summary = summary;
		}
	    
		/**
		 * 取得Content(内容)
		 */
		public String getContent() {
			return content;
		}

		/**
		 * 设置content(内容)
		 * @param content (内容)
		 */
		public void setContent(String content) {
			this.content = content;
		}
	    
		/**
		 * 取得OrderIndex(顺序)
		 */
		public int getOrderIndex() {
			return orderIndex;
		}

		/**
		 * 设置orderIndex(顺序)
		 * @param orderIndex (顺序)
		 */
		public void setOrderIndex(int orderIndex) {
			this.orderIndex = orderIndex;
		}
	    
		/**
		 * 取得DevFlag(开发标识)
		 */
		public String getDevFlag() {
			return devFlag;
		}

		/**
		 * 设置devFlag(开发标识)
		 * @param devFlag (开发标识)
		 */
		public void setDevFlag(String devFlag) {
			this.devFlag = devFlag;
		}
	    
		/**
		 * 取得IsCrm(是否具有crm功能)
		 */
		public String getIsCrm() {
			return isCrm;
		}

		/**
		 * 设置isCrm(是否具有crm功能)
		 * @param isCrm (是否具有crm功能)
		 */
		public void setIsCrm(String isCrm) {
			this.isCrm = isCrm;
		}
	    
		/**
		 * 取得IsSale(是否具有销售监控功能)
		 */
		public String getIsSale() {
			return isSale;
		}

		/**
		 * 设置isSale(是否具有销售监控功能)
		 * @param isSale (是否具有销售监控功能)
		 */
		public void setIsSale(String isSale) {
			this.isSale = isSale;
		}

		/**
		 * 取得CompanyId(公司id)
		 */
		public int getCompanyId() {
			return companyId;
		}

		/**
		 * 设置companyId(公司id)
		 * @param companyId (公司id)
		 */
		public void setCompanyId(int companyId) {
			this.companyId = companyId;
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
	    
		
		public Article(){};


		/**
		 * 
		 * @param id ()
		 * @param articleType (文章类型)
		 * @param title (标题)
		 * @param summary (摘要)
		 * @param content (内容)
		 * @param orderIndex (顺序)
		 * @param devFlag (开发标识)
		 * @param isCrm (是否具有crm功能)
		 * @param isSale (是否具有销售监控功能)
		 * @param isDeleted (是否删除)
		 * @param createdId (创建人)
		 * @param createdTime (创建时间)
		 * @param modId (修改人)
		 * @param modTime (修改时间)
		 */
		public Article(    
			int id,
	        		String articleType,
	        		String title,
	        		String summary,
	        		String content,
	        		int orderIndex,
	        		String devFlag,
	        		String isCrm,
	        		String isSale,
	        		String isDeleted,
	        		int createdId,
	        		Date createdTime,
	        		int modId,
	        		Date modTime
	        ) {
			super();  
			this.id = id;
			this.articleType = articleType;
			this.title = title;
			this.summary = summary;
			this.content = content;
			this.orderIndex = orderIndex;
			this.devFlag = devFlag;
			this.isCrm = isCrm;
			this.isSale = isSale;
			this.isDeleted = isDeleted;
			this.createdId = createdId;
			this.createdTime = createdTime;
			this.modId = modId;
			this.modTime = modTime;
		}
	    
		/**
		 * 
		 * @param articleType (文章类型)
		 * @param title (标题)
		 * @param summary (摘要)
		 * @param content (内容)
		 * @param orderIndex (顺序)
		 * @param devFlag (开发标识)
		 * @param isCrm (是否具有crm功能)
		 * @param isSale (是否具有销售监控功能)
		 * @param isDeleted (是否删除)
		 * @param createdId (创建人)
		 * @param createdTime (创建时间)
		 * @param modId (修改人)
		 * @param modTime (修改时间)
		 */
		public Article(    
			String articleType,
	        		String title,
	        		String summary,
	        		String content,
	        		int orderIndex,
	        		String devFlag,
	        		String isCrm,
	        		String isSale,
	        		String isDeleted,
	        		int createdId,
	        		Date createdTime,
	        		int modId,
	        		Date modTime
	        ) {
			super();		
			this.articleType = articleType;
			this.title = title;
			this.summary = summary;
			this.content = content;
			this.orderIndex = orderIndex;
			this.devFlag = devFlag;
			this.isCrm = isCrm;
			this.isSale = isSale;
			this.isDeleted = isDeleted;
			this.createdId = createdId;
			this.createdTime = createdTime;
			this.modId = modId;
			this.modTime = modTime;
		}
	

	//以下代码不是生成器产生
		//扩展属性
	public String getDayString(){
		
		//return DateTimeUtils.getDateFormatStr(this.createdTime).substring(5);
		
		return DateTimeUtils.toStr(this.createdTime);
	}
	
	public boolean getShowNew(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		Date now=null;
		try {
			now = sdf.parse(c.getTime().toLocaleString());//获取当前日期
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//获取创建日期后七天
		c.setTime(createdTime);
		c.add(Calendar.DAY_OF_YEAR, 7);
		Date dayAfterWeek = c.getTime();
		return dayAfterWeek.after(now); //创建日期后的第七天是否在当前日期后
	}

	//以下代码不是生成器产生
		//扩展属性
	public String getDescArticleType(){
		if(articleType.equalsIgnoreCase("1")){
			return "系统公告";
		}
		else if(articleType.equalsIgnoreCase("2")){
			return "更新公告";
		}
		
		return "";
		
	}
}
