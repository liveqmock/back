package com.ihk.saleunit.data;

import java.util.List;

import com.ihk.saleunit.data.pojo.PayDetail;
import com.ihk.saleunit.data.pojo.PayDetailCond;
 
/**
 * PayDetail数据访问接口Mapper
 * @author 
 *
 */ 
public interface IPayDetailMapper {

	/**
	 * 新增PayDetail
	 * @param payDetail
	 */
	public void addPayDetail(PayDetail payDetail) ;

	/**
	 * 根据条件删除PayDetail
	 * @param cond 删除条件
	 */
	public void deletePayDetail(int id) throws RuntimeException;

	/**
	 * 修改PayDetail
	 * @param payDetail
	 */
	public void updatePayDetail(PayDetail payDetail) throws RuntimeException;

	/**
	 * 查找一条PayDetail
	 * @return PayDetail
	 * @param id 主键id
	 */
	public PayDetail findPayDetailById(int id) throws RuntimeException;

	/**
	 * 分页查找PayDetail
	 * @param cond 查询条件
	 * @return PayDetail列表
	 */
	public List<PayDetail> findPayDetailPage(PayDetailCond cond) ;

	/**
	 * 查找全部PayDetail
	 * @param cond 查询条件
	 * @return PayDetail列表
	 */
	public List<PayDetail> findPayDetail(PayDetailCond cond) ;

	/**
	 * 查找符合条件的记录条数PayDetail
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findPayDetailCount(PayDetailCond cond) ;
	
	/**
	 * 查找最大排序号
	 * @return
	 * @throws RuntimeException
	 */
	public Integer findPayDetailMaxOrderIndex() throws RuntimeException;
}
