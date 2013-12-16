package com.ihk.saleunit.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.saleunit.data.pojo.ChangePrice;
import com.ihk.saleunit.data.pojo.ChangePriceCond;

/**
 * ChangePrice的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
@SuppressWarnings("unchecked")
public interface IChangePriceServices {
	/**
	 * 新增ChangePrice
	 * @param changePrice
	 */
	public void addChangePrice(ChangePrice changePrice) throws RuntimeException;

	/**
	 * 删除一条ChangePrice
	 * @param id
	 */
	public void deleteChangePrice(int id) throws RuntimeException;

	/**
	 * 修改ChangePrice
	 * @param changePrice
	 */
	public void updateChangePrice(ChangePrice changePrice) throws RuntimeException;

	/**
	 * 查找一条ChangePrice
	 * @return ChangePrice
	 * @param id 主键id
	 */
	public ChangePrice findChangePriceById(int id) throws RuntimeException;

	/**
	 * 分页查找ChangePrice
	 * @param cond 查询条件
	 * @return ChangePrice列表
	 */
	public List<ChangePrice> findChangePricePage(ChangePriceCond cond) throws RuntimeException;

	/**
	 * 查找全部ChangePrice
	 * @param cond 查询条件
	 * @return ChangePrice列表
	 */
	public List<ChangePrice> findChangePrice(ChangePriceCond cond) throws RuntimeException;
}