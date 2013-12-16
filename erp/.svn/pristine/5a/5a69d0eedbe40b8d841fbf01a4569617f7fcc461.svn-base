package com.ihk.sale.data.services;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.sale.data.pojo.SaleMonitor;
import com.ihk.sale.data.pojo.SaleMonitorCond;
import com.ihk.sale.data.pojo.SaleMonitorLogbeforeCond;

/**
 * SaleMonitor的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
public interface ISaleMonitorServices {

	/**
	 * 新增SaleMonitor
	 * @param saleMonitor
	 */
	public void addSaleMonitor(SaleMonitor saleMonitor) throws RuntimeException;
	

	/**
	 * 管理员新增SaleMonitor
	 * @param saleMonitor
	 */
	public void addSaleMonitorForAdmin(SaleMonitor saleMonitor) throws RuntimeException;

	/**
	 * 删除一条SaleMonitor
	 * @param id
	 */
	public void deleteSaleMonitor(int id) throws RuntimeException;

	/**
	 * 修改SaleMonitor
	 * @param saleMonitor
	 */
	public void updateSaleMonitor(SaleMonitor oldSaleMonitor,SaleMonitor saleMonitor) throws RuntimeException;

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
	public List<SaleMonitor> findSaleMonitorPage(SaleMonitorCond cond) throws RuntimeException;
	
	/**
	 * 判断该项目是否已经录入
	 * @param cond
	 * @return
	 * @throws Exception
	 */
	public boolean findMonitorDateIsExistsByProject(SaleMonitorCond cond) throws Exception;
	
	/**
	 * 查找全部
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public List<SaleMonitor> findSaleMonitor(SaleMonitorCond cond) throws RuntimeException; //查找符合条件的所有SaleMonitor 管理员使用,不分页

	/**
	 * 查找项目
	 * @return
	 */
	public List<Map<String, Integer>> findProject();
	
	/**
	 * 查找,根据时间
	 * @param cond
	 * @return
	 * @throws Exception
	 */
	public SaleMonitor findSaleMonitorForSearchTime(SaleMonitorCond cond) throws Exception; //在售数据分段汇总,根据日期段来查询

	/**
	 * 在"汇总查询"中的项目列表显示数据,包括周月年
	 * @param cond
	 * @return
	 */
	public Map<String, Number> findOtherDataForSearchTime(SaleMonitorCond cond); //在"汇总查询"中的项目列表显示数据,包括周月年
	
	/**
	 * 查找存在的SaleMonitor
	 * @param cond
	 * @return
	 */
	public SaleMonitor findMonitorDateIsExists(SaleMonitorCond cond) ;
	
	/**
	 * 查找周累计
	 * @param cond
	 * @return
	 */
	public List<SaleMonitor> findSaleMonitorList(SaleMonitorCond cond);  //查找周累计

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
	 * 以项目与每周一汇总分组
	 * @param cond
	 * @return
	 */
	public List<SaleMonitor> findSaleMonitorGroupbyProjectWeek(SaleMonitorCond cond);  //以项目与每周一汇总分组
	
	/**
	 * 以公司与每周一汇总分组
	 * @param cond
	 * @return
	 */
	public List<SaleMonitor> findSaleMonitorGroupbyCompanyWeek(SaleMonitorCond cond);  //以公司与每周一汇总分组
	
	/**
	 * 以全国与每周一汇总分组
	 * @param cond
	 * @return
	 */
	public List<SaleMonitor> findSaleMonitorGroupbyCountryWeek(SaleMonitorCond cond);  //以全国与每周一汇总分组

	/**
	 * 以公司与每月一号汇总分组
	 * @param cond
	 * @return
	 */
	public List<SaleMonitor> findSaleMonitorGroupbyProjectMonth(SaleMonitorCond cond);  //以公司与每月一号汇总分组
	
	/**
	 * 以公司与每月一号汇总分组
	 * @param cond
	 * @return
	 */
	public List<SaleMonitor> findSaleMonitorGroupbyCompanyMonth(SaleMonitorCond cond);  //以公司与每月一号汇总分组
	
	/**
	 * 以全国与每月一号汇总分组
	 * @param cond
	 * @return
	 */
	public List<SaleMonitor> findSaleMonitorGroupbyCountryMonth(SaleMonitorCond cond);  //以全国与每月一号汇总分组
	
	/**
	 * 查找，用于定时器
	 * @param logBeforeCond
	 * @return
	 */
	public List<SaleMonitor> findSaleMonitorFromLogbeforeForQuartz(SaleMonitorLogbeforeCond logBeforeCond);
	
	/**
	 * 查找天数据供定时器中的更新使用
	 * @param cond
	 * @return
	 */
	public SaleMonitor findSaleMonitorForQuartzUpdate(SaleMonitorCond cond); //查找天数据供定时器中的更新使用
	
	/**
	 * 录入次数查询
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public List<Map<String, Integer>> findSaleMonitorInCount(SaleMonitorCond cond) throws RuntimeException; //录入次数查询
	
	/**
	 * 定时器使用
	 * @param monitorDate
	 * @return
	 */
	public List<SaleMonitor> findSaleMonitorByMonitorDate(String monitorDate); //定时器使用
	
	
}