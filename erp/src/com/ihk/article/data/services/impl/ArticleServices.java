package com.ihk.article.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.article.data.IArticleMapper;
import com.ihk.article.data.pojo.Article;
import com.ihk.article.data.pojo.ArticleCond;
import com.ihk.article.data.services.IArticleServices;

/**
 * Article的Services实现(业务实现)
 * @author 
 *
 */
@Service("articleServices")
public class ArticleServices implements IArticleServices {
	/**
	 * article数据访问接口
	 */
	@Autowired	 IArticleMapper articleMapper;

	/**
	 * 删除一条Article
	 * @param id
	 */
	public void deleteArticle(int id) throws RuntimeException {
		articleMapper.deleteArticle(id);
	}

	/**
	 * 新增Article
	 * @param article
	 */
	public void addArticle(Article article) throws RuntimeException {		
		articleMapper.addArticle(article);
	}

	/**
	 * 查找一条Article
	 * @return Article
	 * @param id 主键id
	 */
	@Override
	public Article findArticleById(int id) throws RuntimeException {
		return articleMapper.findArticleById(id);
	}

	/**
	 * 修改Article
	 * @param article
	 */
	@Override
	public void updateArticle(Article article) throws RuntimeException {
		articleMapper.updateArticle(article);		
	}

	public int findArticleCount(ArticleCond cond) throws RuntimeException{
		return articleMapper.findArticleCount(cond);
	}
	
	/**
	 * 分页查找Article
	 * @param cond 查询条件
	 * @return Article列表
	 */
	public List<Article> findArticlePage(ArticleCond cond) throws RuntimeException {
		int recordCount = articleMapper.findArticleCount(cond);
		
		cond.recordCount = recordCount;
				
		return articleMapper.findArticlePage(cond);
	}

	/**
	 * 查找全部Article
	 * @param cond 查询条件
	 * @return Article列表
	 */
	public List<Article> findArticle(ArticleCond cond) throws RuntimeException {
    	return articleMapper.findArticle(cond);
	}

	/**
	 * 获取最大的index给定时器使用
	 */
	@Override
	public Article findArticleIndexMax(ArticleCond cond) {
		return articleMapper.findArticleIndexMax(cond);
	}

	@Override
	public List<Article> findPreArticle(ArticleCond cond)
			throws RuntimeException {
    	return articleMapper.findPreArticle(cond);
	}

	@Override
	public List<Article> findNextArticle(ArticleCond cond)
			throws RuntimeException {
    	return articleMapper.findNextArticle(cond);
	}
}
