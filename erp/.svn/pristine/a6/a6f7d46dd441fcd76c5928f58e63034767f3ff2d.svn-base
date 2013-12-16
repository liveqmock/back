package com.ihk.property.data;
import java.util.List;
import java.util.Map;

import com.ihk.property.data.pojo.PayWayDetail;
import com.ihk.property.data.pojo.PayWayDetailCond;
import com.ihk.utils.base.PojoDeleteCond;


/**
 * PayWayDetail数据访问接口Mapper
 * @author 
 *
 */ 
public interface IPayWayDetailMapper {

	/**
	 * 新增PayWayDetail
	 * @param payWayDetail
	 */
	public void addPayWayDetail(PayWayDetail payWayDetail) ;

	/**
	 * 根据条件删除PayWayDetail
	 * @param cond 删除条件
	 */
	public void deletePayWayDetail(PojoDeleteCond cond) throws RuntimeException;


	/**
	 * 修改PayWayDetail
	 * @param payWayDetail
	 */
	public void updatePayWayDetail(PayWayDetail payWayDetail) throws RuntimeException;

	/**
	 * 查找一条PayWayDetail
	 * @return PayWayDetail
	 * @param id 主键id
	 */
	public PayWayDetail findPayWayDetailById(int id) throws RuntimeException;

	/**
	 * 分页查找PayWayDetail
	 * @param cond 查询条件
	 * @return PayWayDetail列表
	 */
	public List<PayWayDetail> findPayWayDetailPage(PayWayDetailCond cond) ;

	/**
	 * 查找全部PayWayDetail
	 * @param cond 查询条件
	 * @return PayWayDetail列表
	 */
	public List<PayWayDetail> findPayWayDetail(PayWayDetailCond cond) ;

	/**
	 * 查找符合条件的记录条数PayWayDetail
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findPayWayDetailCount(PayWayDetailCond cond) ;
	
	/**
	 * 根据wayId进行查询明细
	 * @param wayId
	 * @return
	 * @throws RuntimeException
	 */
	public List<PayWayDetail> findPayWayDetailByWayId(int wayId) throws RuntimeException;
	
	/**
	 * 根据wayId与PayType进行查询
	 * @param map [?,?]
	 * @return
	 * @throws RuntimeException
	 */
	public List<PayWayDetail> findPayWayDetailByWayIdAndPayType(Map<String, String> map) throws RuntimeException;
}
