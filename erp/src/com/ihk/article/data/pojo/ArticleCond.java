package com.ihk.article.data.pojo;

import com.ihk.permission.CompanyProjectPermissionCond;

/**
 * Article的查询条件
 * @author 
 *
 */
public class ArticleCond extends CompanyProjectPermissionCond{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String articleType;	
    private String title;
    private String date1;
    private String devFlag;
    private String id;
    private String modTime;
	
    

	public String getModTime() {
		return modTime;
	}

	public void setModTime(String modTime) {
		this.modTime = modTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDevFlag() {
		return devFlag;
	}

	public void setDevFlag(String devFlag) {
		this.devFlag = devFlag;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDate1() {
		return date1;
	}

	public void setDate1(String date1) {
		this.date1 = date1;
	}

	public String getArticleType() {
		return articleType;
	}

	public void setArticleType(String articleType) {
		this.articleType = articleType;
	}

	
}
