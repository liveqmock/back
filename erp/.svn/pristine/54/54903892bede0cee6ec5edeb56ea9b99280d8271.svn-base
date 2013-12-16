package com.ihk.article.action.guangzhou;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.article.data.pojo.Article;
import com.ihk.article.data.services.IArticleServices;
import com.ihk.constanttype.ContDevCode;
import com.ihk.constanttype.EnumDevFlag;
import com.ihk.permission.PermissionUtils;
import com.ihk.user.data.pojo.Company;
import com.ihk.user.data.pojo.CompanyCond;
import com.ihk.user.data.pojo.UserAccount;
import com.ihk.user.data.services.ICompanyServices;
import com.ihk.utils.ActionTemplate;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;
import com.ihk.utils.method.ActionAjaxMethodModifyCallback;

/**
 * 录入文章的action
 * @author peter.kuang
 *
 */
public class InputArticleAction extends SupperAction{
	private static final long serialVersionUID = 6664078166881014662L;
	@Autowired 
	private IArticleServices iArticleServices;
	private Article article;
	
	public String indexInput(){
		return "suc";
	}
	
	public String input(){
		ActionTemplate.executeAjaxMethod(true, this, new ActionAjaxMethodModifyCallback() {
			
			@Override
			public void modifyMethodException(Exception e) {
				setUpEasyuiAjaxForFail(e.getMessage());
				
			}
			
			@Override
			public void modifyMethod() throws Exception {
				article=initSaleMonitorToAdd(article);
				iArticleServices.addArticle(article);
				setSuggestion(CommonUtils.SUCCSUGG);			
			}
		});
		return null;
	}
	
	private Article initSaleMonitorToAdd(Article article){
		Date date = new Date();	
		article.setIsDeleted(CommonUtils.NORMAL);
		article.setCreatedId(SessionUser.getUserId());
		article.setCreatedTime(date);
		article.setModId(SessionUser.getUserId());
		article.setModTime(date);

		article.setDevFlag(EnumDevFlag.GUANGZHOU.toString());//广州表示

		return article;
	}
	private String suggestion; //操作提示
	public String getSuggestion() {
		return suggestion;
	}

	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
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
