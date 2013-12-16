package com.ihk.saleunit.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.saleunit.data.pojo.MakeBuildPriceDetail;
import com.ihk.saleunit.data.pojo.MakeBuildPriceDetailCond;

/**
 * MakeBuildPriceDetail的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
@SuppressWarnings("unchecked")
public interface IMakeBuildPriceDetailServices {
	/**
	 * 新增MakeBuildPriceDetail
	 * @param makeBuildPriceDetail
	 */
	public void addMakeBuildPriceDetail(MakeBuildPriceDetail makeBuildPriceDetail) throws RuntimeException;

	/**
	 * 删除一条MakeBuildPriceDetail
	 * @param id
	 */
	public void deleteMakeBuildPriceDetail(int id) throws RuntimeException;

	/**
	 * 修改MakeBuildPrice
	 * @param makeBuildPrice
	 */
	public void updateMakeBuildPriceDetail(MakeBuildPriceDetail makeBuildPriceDetail) throws RuntimeException;

	/**
	 * 查找一条MakeBuildPriceDetail
	 * @return MakeBuildPriceDetail
	 * @param id 主键id
	 */
	public MakeBuildPriceDetail findMakeBuildPriceDetailById(int id) throws RuntimeException;

	/**
	 * 分页查找MakeBuildPriceDetail
	 * @param cond 查询条件
	 * @return MakeBuildPrice列表
	 */
	public List<MakeBuildPriceDetail> findMakeBuildPriceDetailPage(MakeBuildPriceDetailCond cond) throws RuntimeException;

	/**
	 * 查找全部MakeBuildPriceDetail
	 * @param cond 查询条件
	 * @return MakeBuildPriceDetail列表
	 */
	public List<MakeBuildPriceDetail> findMakeBuildPriceDetail(MakeBuildPriceDetailCond cond) throws RuntimeException;
}