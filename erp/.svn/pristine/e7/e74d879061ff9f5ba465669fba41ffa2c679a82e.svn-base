package com.ihk.article.action.guangzhou;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.article.data.pojo.Article;
import com.ihk.article.data.pojo.ArticleCond;
import com.ihk.article.data.services.IArticleServices;
import com.ihk.constanttype.EnumDevFlag;
import com.ihk.utils.DateTimeUtils;
import com.ihk.utils.SupperAction;

/**
 * 文章显示的action
 * @author peter.kuang
 *
 */
public class ArticleShowAction extends SupperAction{
	private static final long serialVersionUID = 1L;
	
	@Autowired IArticleServices articleServices;


	private Article showArticle;
	private Article preArticle;
	private Article nextArticle;
	private String id;//接收ID
	
	public String articleIndex(){
		this.showArticle =  articleServices.findArticleById(Integer.parseInt(id));
		
		ArticleCond arcond = new ArticleCond();
		arcond.startLine = 0;
		arcond.pageSize = 2; 
		arcond.setDevFlag(EnumDevFlag.GUANGZHOU.toString());
		arcond.setModTime(DateTimeUtils.toDateTime(showArticle.getModTime()).toString("yyyy-MM-dd HH:mm:ss"));

		List<Article> list = articleServices.findPreArticle(arcond);
		if(list.size()>0){
			preArticle = list.get(0);
		}
		list = articleServices.findNextArticle(arcond);
		if(list.size()>0){
			nextArticle = list.get(0);
		}
		
		return "suc";
	}
	
	
	
	
	public Article getPreArticle() {
		return preArticle;
	}

	public void setPreArticle(Article preArticle) {
		this.preArticle = preArticle;
	}

	public Article getNextArticle() {
		return nextArticle;
	}

	public void setNextArticle(Article nextArticle) {
		this.nextArticle = nextArticle;
	}

	public Article getShowArticle() {
		return showArticle;
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
