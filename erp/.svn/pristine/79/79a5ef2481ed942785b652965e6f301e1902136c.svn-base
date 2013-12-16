package com.ihk.article.action.guangzhou;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.article.data.pojo.Article;
import com.ihk.article.data.pojo.ArticleCond;
import com.ihk.article.data.services.IArticleServices;
import com.ihk.constanttype.EnumDevFlag;
import com.ihk.customer.data.pojo.CustomerFollowCond;

import com.ihk.permission.PermissionUtils;
import com.ihk.user.data.pojo.RolePriv;
import com.ihk.utils.ActionAjaxPageCallback;
import com.ihk.utils.ActionTemplate;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.DateTimeUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.Pager;
import com.ihk.utils.SessionUser;
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
	private IArticleServices articleServices;
	private Article article;
	private ArticleCond cond;
	
	public String searchArticle(){
		return SUCCESS;
	}

	public String searchArticleAjax() {
		if(cond==null){
			cond = new ArticleCond();
		}
		setCondOrderSortByRequest(cond);
		cond.setDevFlag(EnumDevFlag.GUANGZHOU.toString());//广州标示

		//只查看全部公告或者指定的该公司公告
		List<Integer> companyIds = new ArrayList<Integer>();
		companyIds.add(0);	
		companyIds.addAll(PermissionUtils.getUserCompanyIdList());
		cond.setSearchCompanyIds(companyIds);
		
		ActionTemplate.executeAjaxPage(this, cond, new ActionAjaxPageCallback() {
			
			@Override
			public int initTotal() throws Exception {
				//分页的做法 DEMO
				return articleServices.findArticleCount(cond);
			}
			
			//获取table中要显示的json
			@Override
			public List<Map<String, String>> initRows() throws Exception {
				
				List<Map<String, String>> retList = new ArrayList<Map<String,String>>();
				
				List<Article> list= articleServices.findArticlePage(cond);
				
				if(!CommonUtils.isCollectionEmpty(list)){
					
					Map<String, String> map = null;
					
					//与jsp中table的表头(th field)定义一致
					for(Article obj : list){
						
						map = new HashMap<String, String>();

						map.put("id", String.valueOf(obj.getId()));
						map.put("companyName", DescUtils.getCompanyRealName(obj.getCompanyId()));
						map.put("title", obj.getTitle());
						map.put("summary", obj.getSummary());	
						map.put("articleType", obj.getDescArticleType());	
						map.put("userRealName", DescUtils.getUserRealName(obj.getCreatedId()));				
						map.put("createdTime", DateTimeUtils.toStr(obj.getCreatedTime()));
												
						retList.add(map);
					}
					
				}
				return retList;
			}
		});
		return null;
	}
	
	public ArticleCond getCond() {
		return cond;
	}

	public void setCond(ArticleCond cond) {
		this.cond = cond;
	}

	public IArticleServices getiArticleServices() {
		return articleServices;
	}
	public void setiArticleServices(IArticleServices articleServices) {
		this.articleServices = articleServices;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}

	
}
