package com.ihk.article.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.article.data.pojo.Article;
import com.ihk.article.data.pojo.ArticleCond;

/**
 * Article的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
public interface IArticleServices {
	/**
	 * 新增Article
	 * @param article
	 */
	public void addArticle(Article article) throws RuntimeException;

	/**
	 * 删除一条Article
	 * @param id
	 */
	public void deleteArticle(int id) throws RuntimeException;

	/**
	 * 修改Article
	 * @param article
	 */
	public void updateArticle(Article article) throws RuntimeException;

	/**
	 * 查找一条Article
	 * @return Article
	 * @param id 主键id
	 */
	public Article findArticleById(int id) throws RuntimeException;

	/**
	 * 查找符合条件的记录条数Article
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findArticleCount(ArticleCond cond) throws RuntimeException;
	
	/**
	 * 分页查找Article
	 * @param cond 查询条件
	 * @return Article列表
	 */
	public List<Article> findArticlePage(ArticleCond cond) throws RuntimeException;

	/**
	 * 查找全部Article
	 * @param cond 查询条件
	 * @return Article列表
	 */
	public List<Article> findArticle(ArticleCond cond) throws RuntimeException;
	
	/**
	 * 获取最大的index给定时器使用
	 * @param cond
	 * @return
	 */
	public Article findArticleIndexMax(ArticleCond cond);  //获取最大的index给定时器使用

	/**
	 * 查找指定条件之前的Article
	 * @param cond 查询条件
	 * @return Article列表
	 */
	public List<Article> findPreArticle(ArticleCond cond) throws RuntimeException;

	/**
	 * 查找指定条件之后的Article
	 * @param cond 查询条件
	 * @return Article列表
	 */
	public List<Article> findNextArticle(ArticleCond cond) throws RuntimeException;
	
}