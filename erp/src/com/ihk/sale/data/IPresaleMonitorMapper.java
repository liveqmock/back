package com.ihk.sale.data;

import java.util.List;
import java.util.Map;

import com.ihk.sale.data.pojo.PresaleMonitor;
import com.ihk.sale.data.pojo.PresaleMonitorCond;

/**
 * PresaleMonitor数据访问接口Mapper
 * @author 
 *
 */ 
public interface IPresaleMonitorMapper {

	/**
	 * 新增PresaleMonitor
	 * @param presaleMonitor
	 */
	public void addPresaleMonitor(PresaleMonitor presaleMonitor) ;

	/**
	 * 根据条件删除PresaleMonitor
	 * @param cond 删除条件
	 */
	public void deletePresaleMonitor(int id) throws RuntimeException;


	/**
	 * 修改PresaleMonitor
	 * @param presaleMonitor
	 */
	public void updatePresaleMonitor(PresaleMonitor presaleMonitor) throws RuntimeException;

	/**
	 * 查找一条PresaleMonitor
	 * @return PresaleMonitor
	 * @param id 主键id
	 */
	public PresaleMonitor findPresaleMonitorById(int id) throws RuntimeException;

	/**
	 * 分页查找PresaleMonitor
	 * @param cond 查询条件
	 * @return PresaleMonitor列表
	 */
	public List<PresaleMonitor> findPresaleMonitorPage(PresaleMonitorCond cond) ;

	/**
	 * 查找符合条件的记录条数PresaleMonitor
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findPresaleMonitorCount(PresaleMonitorCond cond) ;
	
	/**
	 * 根据日期查找数据
	 * */
	public int findPresaleMonitorByMonitorDate(PresaleMonitor pre);
	
	/**
	 * intention_all 累计认筹字段所需要的
	 * @param pre
	 * @return
	 * @throws RuntimeException
	 */
	public PresaleMonitor intentionAll_select(PresaleMonitor pre)throws RuntimeException;
	
	/**
	 * 添加累计
	 * @param pre
	 */
	public void intentionAll_add(PresaleMonitor pre);
	
	/**
	 * 删除累计
	 * @param pre
	 */
	public void intentionAll_del(PresaleMonitor pre);
}
