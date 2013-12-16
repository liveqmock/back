package com.ihk.indexReport.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.article.data.pojo.Article;
import com.ihk.article.data.pojo.ArticleCond;
import com.ihk.article.data.services.IArticleServices;
import com.ihk.constanttype.EnumDevFlag;
import com.ihk.permission.PermissionUtils;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;

public class Report11Action  extends SupperAction {

	@Autowired
	IArticleServices iArticleServices;
	private List<Article> listArt;


	public String getReport() {
		// 最新的15条公告
		
		if (SessionUser.getProjectId() == 66) {
			this.listArt = new ArrayList<Article>();
		} else {
			ArticleCond artcond = new ArticleCond();
			artcond.topNum = 15;
			artcond.setDevFlag(EnumDevFlag.GUANGZHOU.toString());
			
			//只查看全部公告或者指定的该公司公告
			List<Integer> companyIds = new ArrayList<Integer>();
			companyIds.add(0);	
			companyIds.addAll(PermissionUtils.getUserCompanyIdList());
			artcond.setSearchCompanyIds(companyIds);
			
			this.listArt = iArticleServices.findArticle(artcond);
		}
		return "suc";
	}

	public List<Article> getListArt() {
		return listArt;
	}

	public void setListArt(List<Article> listArt) {
		this.listArt = listArt;
	}



	

}
