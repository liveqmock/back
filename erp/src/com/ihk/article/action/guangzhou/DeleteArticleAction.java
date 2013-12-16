package com.ihk.article.action.guangzhou;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.article.data.pojo.Article;
import com.ihk.article.data.services.IArticleServices;
import com.ihk.constanttype.ContUserId;
import com.ihk.utils.ActionTemplate;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;
import com.ihk.utils.method.ActionAjaxMethodModifyCallback;

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
		//删除文章 在弹出的窗体中异步处理
		ActionTemplate.executeAjaxMethod(true, this, new ActionAjaxMethodModifyCallback() {
			
			@Override
			public void modifyMethodException(Exception e) {
				setUpEasyuiAjaxForFail(e.getMessage());
			}
			
			@Override
			public void modifyMethod() throws Exception {
				String tempids[]=ids.split("_");
				for (String id:tempids){
					iArticleServices.deleteArticle(Integer.parseInt(id));
				}
			}
		});

		return null;
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
