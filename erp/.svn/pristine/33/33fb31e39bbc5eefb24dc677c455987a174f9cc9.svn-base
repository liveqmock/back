package com.ihk.article.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.article.data.pojo.Article;
import com.ihk.article.data.services.IArticleServices;
import com.ihk.utils.SupperAction;

/**
 * 删除文章的action
 * @author peter.kuang
 *
 */
public class DeleteArticleAction extends SupperAction {
	private static final long serialVersionUID = 1L;
	@Autowired 
	private IArticleServices iArticleServices;
	private Article article;
	private String ids;
	
	public String deleteArticle(){
		String[] tempids=ids.split("_");
		for (String id:tempids){
			iArticleServices.deleteArticle(Integer.parseInt(id));
		}
		return "deleteArticle";
	}
	
	
	
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
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
