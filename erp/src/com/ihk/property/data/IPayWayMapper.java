package com.ihk.property.data;

import java.util.List;
import java.util.Map;

import com.ihk.property.data.pojo.PayWay;
import com.ihk.property.data.pojo.PayWayCond;

/**
 * PayWay数据访问接口Mapper
 * @author 
 *
 */ 
public interface IPayWayMapper {

	/**
	 * 新增PayWay
	 * @param payWay
	 */
	public void addPayWay(PayWay payWay) ;

	/**
	 * 根据条件删除PayWay
	 * @param cond 删除条件
	 */
	public void deletePayWay(int id) throws RuntimeException;

	/**
	 * 修改PayWay
	 * @param payWay
	 */
	public void updatePayWay(PayWay payWay) throws RuntimeException;

    
	/**
	 * 查找一条PayWay
	 * @return PayWay
	 * @param id 主键id
	 */
	public PayWay findPayWayById(int id) throws RuntimeException;

	/**
	 * 分页查找PayWay
	 * @param cond 查询条件
	 * @return PayWay列表
	 */
	public List<PayWay> findPayWayPage(PayWayCond cond) ;

	/**
	 * 查找全部PayWay
	 * @param cond 查询条件
	 * @return PayWay列表
	 */
	public List<PayWay> findPayWay(PayWayCond cond) ;

	/**
	 * 查找符合条件的记录条数PayWay
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findPayWayCount(PayWayCond cond) ;
	
	/*KN
	 * */
	public PayWay findPayWayByNameAndProId(Map p );
}
