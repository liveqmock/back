package com.ihk.sale.data;

import java.util.List;
import java.util.Map;

import com.ihk.sale.data.pojo.SaleMonitor;
import com.ihk.sale.data.pojo.SaleMonitorCond;
import com.ihk.sale.data.pojo.SaleMonitorLogbeforeCond;

/**
 * SaleMonitor数据访问接口Mapper
 * @author 
 *
 */ 
public interface ISaleMonitorMapper {

	/**
	 * 新增SaleMonitor
	 * @param saleMonitor
	 */
	public void addSaleMonitor(SaleMonitor saleMonitor) ;

	/**
	 * 根据条件删除SaleMonitor
	 * @param cond 删除条件
	 */
	public void deleteSaleMonitor(int id) throws RuntimeException;

	/**
	 * 修改SaleMonitor
	 * @param saleMonitor
	 */
	public void updateSaleMonitor(SaleMonitor saleMonitor) throws RuntimeException;

	/**
	 * 查找一条SaleMonitor
	 * @return SaleMonitor
	 * @param id 主键id
	 */
	public SaleMonitor findSaleMonitorById(int id) throws RuntimeException;

	/**
	 * 分页查找SaleMonitor
	 * @param cond 查询条件
	 * @return SaleMonitor列表
	 */
	public List<SaleMonitor> findSaleMonitorPage(SaleMonitorCond cond) ;

	/**
	 * 查找符合条件的记录条数SaleMonitor
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findSaleMonitorCount(SaleMonitorCond cond) ;
	

	/**
	 * 查找符合条件的记录条数SaleMonitor
	 * 根据项目进行判断是否已经存在
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public List<SaleMonitor> findMonitorDateIsExistsByProject(SaleMonitorCond cond)throws RuntimeException;

	/**
	 * 查找全部SaleMonitor
	 * @param cond 查询条件
	 * @return SaleMonitor列表
	 */
	public List<SaleMonitor> findSaleMonitor(SaleMonitorCond cond) throws RuntimeException;   //管理员使用

	/**
	 * 查找项目
	 * @return
	 */
	public List<Map<String, Integer>> findProject();
	
	/**
	 * 根据时间,查找
	 * @param cond
	 * @return
	 * @throws Exception
	 */
	public SaleMonitor findSaleMonitorForSearchTime(SaleMonitorCond cond) throws Exception;
	
	/**
	 * 查找累计
	 * @param cond
	 * @return
	 */
	public List<SaleMonitor> findSaleMonitorList(SaleMonitorCond cond);  //查找累计

	/**
	 * 以项目与日期分组
	 * @param cond
	 * @return
	 */
	public List<SaleMonitor> findSaleMonitorGroupbyProjectDate(SaleMonitorCond cond);  //以项目与日期分组
	
	/**
	 * 以公司与日期分组
	 * @param cond
	 * @return
	 */
	public List<SaleMonitor> findSaleMonitorGroupbyCompanyDate(SaleMonitorCond cond);  //以公司与日期分组
	
	/**
	 * 以全国与日期分组
	 * @param cond
	 * @return
	 */
	public List<SaleMonitor> findSaleMonitorGroupbyCountryDate(SaleMonitorCond cond);  //以全国与日期分组
	
	/**
	 * quartz中的修改部分
	 * @param logBeforeCond
	 * @return
	 */
	public List<SaleMonitor> findSaleMonitorFromLogbeforeForQuartz(SaleMonitorLogbeforeCond logBeforeCond); //quartz中的修改部分
	
	/**
	 * 查找天数据供定时器中的更新使用
	 * @param cond
	 * @return
	 */
	public SaleMonitor findSaleMonitorForQuartzUpdate(SaleMonitorCond cond); //查找天数据供定时器中的更新使用
	
	/**
	 * 在"汇总查询"中的项目列表显示数据,包括周月年
	 * @param cond
	 * @return
	 */
	public Map<String, Number> findOtherDataForSearchTime(SaleMonitorCond cond); //在"汇总查询"中的项目列表显示数据,包括周月年
	
	/**
	 * 录入次数查询
	 * @param cond
	 * @return
	 */
	public List<Map<String, Integer>> findSaleMonitorInCount(SaleMonitorCond cond); //录入次数查询
	
	/**
	 * 定时器使用
	 * @param monitorDate
	 * @return
	 */
	public List<SaleMonitor> findSaleMonitorByMonitorDate(String monitorDate); //定时器使用
	
}
