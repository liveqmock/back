package com.ihk.saleunit.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.saleunit.data.pojo.MakeBuildPrice;
import com.ihk.saleunit.data.pojo.MakeBuildPriceCond;

/**
 * MakeBuildPrice的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
@SuppressWarnings("unchecked")
public interface IMakeBuildPriceServices {
	/**
	 * 新增MakeBuildPrice
	 * @param makeBuildPrice
	 */
	public void addMakeBuildPrice(MakeBuildPrice makeBuildPrice) throws RuntimeException;

	/**
	 * 删除一条MakeBuildPrice
	 * @param id
	 */
	public void deleteMakeBuildPrice(int id) throws RuntimeException;

	/**
	 * 修改MakeBuildPrice
	 * @param makeBuildPrice
	 */
	public void updateMakeBuildPrice(MakeBuildPrice makeBuildPrice) throws RuntimeException;

	/**
	 * 查找一条MakeBuildPrice
	 * @return MakeBuildPrice
	 * @param id 主键id
	 */
	public MakeBuildPrice findMakeBuildPriceById(int id) throws RuntimeException;

	/**
	 * 分页查找MakeBuildPrice
	 * @param cond 查询条件
	 * @return MakeBuildPrice列表
	 */
	public List<MakeBuildPrice> findMakeBuildPricePage(MakeBuildPriceCond cond) throws RuntimeException;

	/**
	 * 查找全部MakeBuildPrice
	 * @param cond 查询条件
	 * @return MakeBuildPrice列表
	 */
	public List<MakeBuildPrice> findMakeBuildPrice(MakeBuildPriceCond cond) throws RuntimeException;
}