package com.ihk.article.action;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.article.data.pojo.Article;
import com.ihk.article.data.services.IArticleServices;
import com.ihk.constanttype.EnumDevFlag;
import com.ihk.user.data.pojo.UserAccount;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.SupperAction;

/**
 * 修改文章的action
 * @author peter.kuang
 *
 */
public class UpdateArticleAction extends SupperAction {

	private static final long serialVersionUID = 7264391379782728431L;
	@Autowired 
	private IArticleServices iArticleServices;
	private Article article;
	private Integer articleId;
	private String suggestion; //操作提示
	
	
	public String updateForArticle(){
		this.article =iArticleServices.findArticleById(getArticleId());
		return "forupdate";
	}
	public String updateArticle(){
		article =initSaleMonitorToAdd(article);
		article.setId(getArticleId());
		article.setDevFlag(EnumDevFlag.HENGDA.toString());
		iArticleServices.updateArticle(article);
		setSuggestion(CommonUtils.SUCCSUGG);
		return "update";
	}
	
private Article initSaleMonitorToAdd(Article article){
		
		HttpSession session = request.getSession();
		Object obj = session.getAttribute(CommonUtils.USER_SESSION_KEY);
		UserAccount user = (UserAccount) obj;
		
		Date date = new Date();
		
		article.setIsDeleted(CommonUtils.NORMAL);
		article.setCreatedId(user.getId());
		article.setCreatedTime(date);
		article.setModId(user.getId());
		article.setModTime(date);
		
		
		return article;
	}
	
	
	
	public String getSuggestion() {
	return suggestion;
}
public void setSuggestion(String suggestion) {
	this.suggestion = suggestion;
}
	public Integer getArticleId() {
		return articleId;
	}
	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}
	public IArticleServices getiArticleServices() {
		return iArticleServices;
	}
	public void setiArticleServices(IArticleServices iArticleServices) {
		this.iArticleServices = iArticleServices;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
}
