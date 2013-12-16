package com.ihk.demo.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.demo.data.IDemoTableMapper;
import com.ihk.demo.data.pojo.DemoTable;
import com.ihk.demo.data.pojo.DemoTableCond;
import com.ihk.demo.data.services.IDemoTableServices;
import com.ihk.utils.base.PojoDeleteCond;

/**
 * DemoTable的Services实现(业务实现)
 * @author 
 *
 */
@Service("demoTableServices")
public class DemoTableServices implements IDemoTableServices {
	/**
	 * demoTable数据访问接口
	 */
	@Autowired	 IDemoTableMapper demoTableMapper;

	/**
	 * 删除一条DemoTable
	 * @param id
	 */
	public void deleteDemoTable(int id) throws RuntimeException {
		demoTableMapper.deleteDemoTable(new PojoDeleteCond(id));
	}

	/**
	 * 新增DemoTable
	 * @param demoTable
	 */
	public void addDemoTable(DemoTable demoTable) throws RuntimeException {		
		demoTableMapper.addDemoTable(demoTable);
	}

	/**
	 * 查找一条DemoTable
	 * @return DemoTable
	 * @param id 主键id
	 */
	@Override
	public DemoTable findDemoTableById(int id) throws RuntimeException {
		return demoTableMapper.findDemoTableById(id);
	}

	/**
	 * 修改DemoTable
	 * @param demoTable
	 */
	@Override
	public void updateDemoTable(DemoTable demoTable) throws RuntimeException {
		demoTableMapper.updateDemoTable(demoTable);		
	}

	/**
	 * 分页查找DemoTable
	 * @param cond 查询条件
	 * @return DemoTable列表
	 */
	public List<DemoTable> findDemoTablePage(DemoTableCond cond) throws RuntimeException {
		int recordCount = demoTableMapper.findDemoTableCount(cond);
		
		cond.recordCount = recordCount;
				
		return demoTableMapper.findDemoTablePage(cond);
	}

	/**
	 * 查找全部DemoTable
	 * @param cond 查询条件
	 * @return DemoTable列表
	 */
	public List<DemoTable> findDemoTable(DemoTableCond cond) throws RuntimeException {
    	return demoTableMapper.findDemoTable(cond);
	}
}
