package com.ihk.saleunit.data;

import java.util.List;
import java.util.Map;

import com.ihk.saleunit.data.pojo.MakeBuildPriceDetail;
import com.ihk.saleunit.data.pojo.MakeBuildPriceDetailCond;

/**
 * MakeBuildPriceDetail数据访问接口Mapper
 * @author 
 *
 */ 
public interface IMakeBuildPriceDetailMapper {

	/**
	 * 新增MakeBuildPriceDetail
	 * @param makeBuildPriceDetail
	 */
	public void addMakeBuildPriceDetail(MakeBuildPriceDetail makeBuildPriceDetail) ;

	/**
	 * 根据条件删除MakeBuildPriceDetail
	 * @param cond 删除条件
	 */
	public void deleteMakeBuildPriceDetail(int id) throws RuntimeException;

	/**
	 * 修改MakeBuildPriceDetail
	 * @param makeBuildPriceDetail
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
	 * @return MakeBuildPriceDetail列表
	 */
	public List<MakeBuildPriceDetail> findMakeBuildPriceDetailPage(MakeBuildPriceDetailCond cond) ;

	/**
	 * 查找全部MakeBuildPriceDetail
	 * @param cond 查询条件
	 * @return MakeBuildPriceDetail列表
	 */
	public List<MakeBuildPriceDetail> findMakeBuildPriceDetail(MakeBuildPriceDetailCond cond) ;

	/**
	 * 查找符合条件的记录条数MakeBuildPriceDetail
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findMakeBuildPriceDetailCount(MakeBuildPriceDetailCond cond) ;
}
