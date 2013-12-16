package com.ihk.sale.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.sale.data.pojo.PresaleMonitor;
import com.ihk.sale.data.pojo.PresaleMonitorCond;

/**
 * PresaleMonitor的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
@SuppressWarnings("unchecked")
public interface IPresaleMonitorServices {

	/**
	 * 新增PresaleMonitor
	 * @param presaleMonitor
	 */
	public void addPresaleMonitor(PresaleMonitor presaleMonitor) throws RuntimeException;

	/**
	 * 删除一条PresaleMonitor
	 * @param id
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
	public List findPresaleMonitorPage(PresaleMonitorCond cond) throws RuntimeException;
	
	/**
	 * PresaleMonitor的记录数
	 * @param cond
	 * @return
	 */
	public int findPresaleMonitorCount(PresaleMonitorCond cond) ;
	
	/**
	 * 验证数据date是否重复
	 * result ttre = 找到了数据 有重复 
	 * 			false = 没有找到数据可以add
	 * */
	public boolean valDate(PresaleMonitor pre);//验证数据date是否重复
	
	/**
	 * 根据日期查找数据
	 * */
	public int findPresaleMonitorByMonitorDate(PresaleMonitor pre);
}