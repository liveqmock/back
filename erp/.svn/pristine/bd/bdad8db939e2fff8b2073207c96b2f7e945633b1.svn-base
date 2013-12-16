package com.ihk.saleunit.data;

import java.util.List;

import com.ihk.saleunit.data.pojo.MakeBuildPrice;
import com.ihk.saleunit.data.pojo.MakeBuildPriceCond;

/**
 * MakeBuildPrice数据访问接口Mapper
 * @author 
 *
 */ 
public interface IMakeBuildPriceMapper {

	/**
	 * 新增MakeBuildPrice
	 * @param makeBuildPrice
	 */
	public void addMakeBuildPrice(MakeBuildPrice makeBuildPrice) ;

	/**
	 * 根据条件删除MakeBuildPrice
	 * @param cond 删除条件
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
	public List<MakeBuildPrice> findMakeBuildPricePage(MakeBuildPriceCond cond) ;

	/**
	 * 查找全部MakeBuildPrice
	 * @param cond 查询条件
	 * @return MakeBuildPrice列表
	 */
	public List<MakeBuildPrice> findMakeBuildPrice(MakeBuildPriceCond cond) ;

	/**
	 * 查找符合条件的记录条数MakeBuildPrice
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findMakeBuildPriceCount(MakeBuildPriceCond cond) ;
}
