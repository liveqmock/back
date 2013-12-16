package com.ihk.sale.data;

import java.util.List;
import java.util.Map;

import com.ihk.sale.data.pojo.PresaleMonitorAll;
import com.ihk.sale.data.pojo.PresaleMonitorAllCond;

/**
 * PresaleMonitorAll数据访问接口Mapper
 * @author 
 *
 */ 
public interface IPresaleMonitorAllMapper {

	/**
	 * 新增PresaleMonitorAll
	 * @param presaleMonitorAll
	 */
	public void addPresaleMonitorAll(PresaleMonitorAll presaleMonitorAll) ;

	/**
	 * 根据条件删除PresaleMonitorAll
	 * @param cond 删除条件
	 */
	public void deletePresaleMonitorAll(int id) throws RuntimeException;

	/**
	 * 修改PresaleMonitorAll
	 * @param presaleMonitorAll
	 */
	public void updatePresaleMonitorAll(PresaleMonitorAll presaleMonitorAll) throws RuntimeException;

	/**
	 * 查找一条PresaleMonitorAll
	 * @return PresaleMonitorAll
	 * @param id 主键id
	 */
	public PresaleMonitorAll findPresaleMonitorAllById(int id) throws RuntimeException;

	/**
	 * 分页查找PresaleMonitorAll
	 * @param cond 查询条件
	 * @return PresaleMonitorAll列表
	 */
	public List<PresaleMonitorAll> findPresaleMonitorAllPage(PresaleMonitorAllCond cond) ;

	/**
	 * 查找符合条件的记录条数PresaleMonitorAll
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findPresaleMonitorAllCount(PresaleMonitorAllCond cond) ;
}
