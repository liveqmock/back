package com.ihk.demo.data;

import java.util.List;

import com.ihk.demo.data.pojo.DemoTable;
import com.ihk.demo.data.pojo.DemoTableCond;
import com.ihk.utils.base.PojoDeleteCond;
 

/**
 * DemoTable数据访问接口Mapper
 * @author 
 *
 */ 
public interface IDemoTableMapper {

	/**
	 * 新增DemoTable
	 * @param demoTable
	 */
	public void addDemoTable(DemoTable demoTable) ;

	/**
	 * 根据条件删除DemoTable
	 * @param cond 删除条件
	 */
	public void deleteDemoTable(PojoDeleteCond cond) throws RuntimeException;


	/**
	 * 修改DemoTable
	 * @param demoTable
	 */
	public void updateDemoTable(DemoTable demoTable) throws RuntimeException;
	
    
	/**
	 * 查找一条DemoTable
	 * @return DemoTable
	 * @param id 主键id
	 */
	public DemoTable findDemoTableById(int id) throws RuntimeException;
	    
	/**
	 * 分页查找DemoTable
	 * @param cond 查询条件
	 * @return DemoTable列表
	 */
	public List<DemoTable> findDemoTablePage(DemoTableCond cond) ;
        
	/**
	 * 查找全部DemoTable
	 * @param cond 查询条件
	 * @return DemoTable列表
	 */
	public List<DemoTable> findDemoTable(DemoTableCond cond) ;
    
	/**
	 * 查找符合条件的记录条数DemoTable
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findDemoTableCount(DemoTableCond cond) ;
}
