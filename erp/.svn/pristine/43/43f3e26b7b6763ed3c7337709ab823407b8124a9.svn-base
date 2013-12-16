package com.ihk.article.action.guangzhou;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.article.data.pojo.Article;
import com.ihk.article.data.services.IArticleServices;
import com.ihk.constanttype.EnumDevFlag;
import com.ihk.user.data.pojo.UserAccount;
import com.ihk.utils.ActionTemplate;
import com.ihk.utils.CommonPojoUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;
import com.ihk.utils.exception.RepeatTitleException;
import com.ihk.utils.method.ActionAjaxMethodModifyCallback;

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
	
	
	public String indexUpdate(){
		this.article =iArticleServices.findArticleById(getArticleId());
		request.getSession().setAttribute("oldArticle", article);
		return "suc";
	}
	
	public String update(){

		ActionTemplate.executeAjaxMethod(true, this, new ActionAjaxMethodModifyCallback() {
			
			@Override
			public void modifyMethodException(Exception e) {
				setUpEasyuiAjaxForFail(e.getMessage());
				
			}
			
			@Override
			public void modifyMethod() throws Exception {
				Article temp = (Article)request.getSession().getAttribute("oldArticle");
				temp.setArticleType(article.getArticleType());
				temp.setContent(article.getContent());
				temp.setCompanyId(article.getCompanyId());
			
				temp.setIsDeleted("0");
				temp.setModId(SessionUser.getUserId());
				temp.setModTime(new Date());
				temp.setOrderIndex(article.getOrderIndex());
				temp.setSummary(article.getSummary());
				temp.setTitle(article.getTitle());
			
			
				article.setDevFlag(EnumDevFlag.GUANGZHOU.toString());
				
				iArticleServices.updateArticle(temp);				
			}
		});
		return null;
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
