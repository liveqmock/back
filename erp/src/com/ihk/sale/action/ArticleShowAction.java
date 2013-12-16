package com.ihk.sale.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.article.data.pojo.Article;
import com.ihk.article.data.pojo.ArticleCond;
import com.ihk.article.data.services.IArticleServices;
import com.ihk.constanttype.EnumDevFlag;
import com.ihk.utils.SupperAction;

/**
 * 文章的显示
 * @author peter.kuang
 *
 */
public class ArticleShowAction extends SupperAction{
	private static final long serialVersionUID = 1L;
	
	@Autowired IArticleServices articleServices;


	private Article showArticle;
	private String id;//接收ID
	private List<Article> lastArticleList;//index页面显示最新公告
	
	/**展示最新消息的详细类容  从index页面的最新消息a连接提交*/ 
	public String articleIndex(){
		ArticleCond arcond = new ArticleCond();
		arcond.startLine = 0;
		arcond.pageSize = 20; 
		arcond.setDevFlag(EnumDevFlag.HENGDA.toString());
		lastArticleList = articleServices.findArticlePage(arcond);
		this.showArticle =  articleServices.findArticleById(Integer.parseInt(id));
		return "show";
	}
	
	
	/////////set get
	
	public Article getShowArticle() {
		return showArticle;
	}
	public List<Article> getLastArticleList() {
		return lastArticleList;
	}



	public void setShowArticle(Article showArticle) {
		this.showArticle = showArticle;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
