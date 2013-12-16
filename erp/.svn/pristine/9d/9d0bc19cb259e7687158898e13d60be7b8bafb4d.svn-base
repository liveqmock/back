package com.ihk.demo.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.demo.data.pojo.DemoTable;
import com.ihk.demo.data.pojo.DemoTableCond;

/**
 * DemoTable的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
@SuppressWarnings("unchecked")
public interface IDemoTableServices {

	/**
	 * 新增DemoTable
	 * @param demoTable
	 */
	public void addDemoTable(DemoTable demoTable) throws RuntimeException;

	/**
	 * 删除一条DemoTable
	 * @param id
	 */
	public void deleteDemoTable(int id) throws RuntimeException;

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
	public List<DemoTable> findDemoTablePage(DemoTableCond cond) throws RuntimeException;
    
	/**
	 * 查找全部DemoTable
	 * @param cond 查询条件
	 * @return DemoTable列表
	 */
	public List<DemoTable> findDemoTable(DemoTableCond cond) throws RuntimeException;
}