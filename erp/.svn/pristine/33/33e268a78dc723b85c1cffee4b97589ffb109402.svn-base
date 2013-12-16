package com.ihk.quartz;


import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.ihk.article.data.pojo.Article;
import com.ihk.constanttype.EnumDevFlag;
import com.ihk.user.data.pojo.CompanyProject;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.HengDaUtils;

/**
 * 恒大的自动公告
 * 填写录入情况
 * @author peter.kuang
 *
 */
public class HengDaArticleQuartz {
	
	private static final Logger logger = Logger.getLogger(HengDaArticleQuartz.class); 
	
	// 每天17点自动发送一条当天未录入数据的公司名单至首页的系统公告中
	public void addHangDaNotDataCompanyArticle() throws Exception{
		
		logger.info(CommonUtils.getNowForLocalString() + "定时器开始执行...");
		
		String now = CommonUtils.getNowForString();
		
		Article article = new Article();
		article.setArticleType(articleType);
		article.setTitle(title.replace("{titleDate}", now));
		article.setSummary(summary);
		
		List<CompanyProject> notDataComProject = HengDaUtils.getNotDataCompamyForHengDaByMonitorDate(now);
		String content = getArticleContent(notDataComProject);
		article.setContent(content); // 截止21日下午17:00，未录入当天数据的项目有：广西钦州恒大绿洲、广东恒大山水城、湖南浏阳恒大华府、江苏淮安恒大雅苑
		
		Article getArticle = HengDaUtils.getMaxIndexArticle(now);
		if(getArticle == null){
			article.setOrderIndex(1); //
		}else{
			Integer maxIndex = getArticle.getOrderIndex();
			if(maxIndex == null || maxIndex == 0){
				article.setOrderIndex(1); 
			}else{
				article.setOrderIndex(maxIndex + 1); 
			}
		}
		
		article.setDevFlag(EnumDevFlag.HENGDA.name());
		article.setIsDeleted(CommonUtils.NORMAL);
		article.setCreatedId(createdId);
		article.setModId(modId);
		
		Date date = new Date();
		article.setCreatedTime(date);
		article.setModTime(date);
		
		HengDaUtils.addArticle(article);
		
	}
	
	private String getArticleContent(List<CompanyProject> notDataComProject){
		// 截止21日下午17:00，未录入当天数据的项目有：广西钦州恒大绿洲、广东恒大山水城、湖南浏阳恒大华府、江苏淮安恒大雅苑
		StringBuffer sb = new StringBuffer();
		sb.append("<p>截止").append(CommonUtils.getNowForString()).append("下午17:00,未录入当天数据的公司有:</p>");
		
		for(CompanyProject comProject : notDataComProject){
			sb.append("<p>").append(comProject.getProjectName()).append("</p>");
		}
		
		return sb.toString();
	}
	
	//通过配置文件获取
	private String articleType; //类型
	
	private String title;  //标题 : {title}:未录入数据情况
	private String summary; //摘要 : 未录入数据公司名单
	private String content; //内容
	
	private int createdId; //创建者id
	private int modId; //修改者id

	public String getArticleType() {
		return articleType;
	}
	public void setArticleType(String articleType) {
		this.articleType = articleType;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getCreatedId() {
		return createdId;
	}
	public void setCreatedId(int createdId) {
		this.createdId = createdId;
	}
	public int getModId() {
		return modId;
	}
	public void setModId(int modId) {
		this.modId = modId;
	}
	

}
