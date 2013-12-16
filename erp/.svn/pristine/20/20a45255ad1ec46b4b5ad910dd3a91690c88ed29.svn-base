package com.ihk.article.action;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.article.data.pojo.Article;
import com.ihk.article.data.pojo.ArticleCond;
import com.ihk.article.data.services.IArticleServices;
import com.ihk.constanttype.EnumDevFlag;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.Pager;
import com.ihk.utils.SupperAction;
import com.opensymphony.xwork2.ActionContext;

/**
 * 查找文章的action
 * @author peter.kuang
 *
 */
public class SearchArticleAction extends SupperAction {
	private static final long serialVersionUID = -21166376954568005L;
	@Autowired 
	private IArticleServices iArticleServices;
	private Article article;
	private ArticleCond cond;
	private List<Article> articlelist;
//	private String ids;
	public String searchAllArticle(){
		if(cond == null){
			cond = new ArticleCond();
			cond.setDate1(CustomerUtils.getNowForString());
		}
		
		cond.setDevFlag(EnumDevFlag.HENGDA.toString());//默认恒大公告
		String action = CustomerUtils.getActionNameFromRequest(request);
		Pager page = new Pager(ActionContext.getContext(),pageSize,action);
		
		
		page.setCond(cond);
		articlelist= iArticleServices.findArticlePage(cond);
		this.setShowPage(page.toHtmlString());
		return "searchAllArticle";
	}
	

	


//	public String deleteArticle(){
//		String tempids[]=ids.split("_");
//		for (String id:tempids){
//			iArticleServices.deleteArticle(Integer.parseInt(id));
//			
//		}
//		
//		return "deleteArticle";
//	}
	





//	public String getIds() {
//		return ids;
//	}
//
//	public void setIds(String ids) {
//		this.ids = ids;
//	}

	public ArticleCond getCond() {
		return cond;
	}

	public void setCond(ArticleCond cond) {
		this.cond = cond;
	}

	
	public List<Article> getArticlelist() {
		return articlelist;
	}

	public void setArticlelist(List<Article> articlelist) {
		this.articlelist = articlelist;
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
