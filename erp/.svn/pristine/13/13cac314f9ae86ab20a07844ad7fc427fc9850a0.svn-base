package com.ihk.property.data.services.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.property.data.ICheckcommissionListMapper;
import com.ihk.property.data.pojo.CheckcommissionList;
import com.ihk.property.data.pojo.CheckcommissionListCond;
import com.ihk.property.data.services.ICheckcommissionListServices;

import com.ihk.utils.base.PojoDeleteCond;

/**
 * CheckcommissionList的Services实现(业务实现)
 * @author 
 *
 */
@Service("checkcommissionListServices")
public class CheckcommissionListServices implements ICheckcommissionListServices {
	/**
	 * checkcommissionList数据访问接口
	 */
	@Autowired	 ICheckcommissionListMapper checkcommissionListMapper;

	/**
	 * 删除一条CheckcommissionList
	 * @param id
	 */
    @Override
	public void deleteCheckcommissionList(int id) throws RuntimeException {
		checkcommissionListMapper.deleteCheckcommissionList(new PojoDeleteCond(id));
	}

	/**
	 * 新增CheckcommissionList
	 * @param checkcommissionList
	 */
    @Override
	public void addCheckcommissionList(CheckcommissionList checkcommissionList) throws RuntimeException {		
		checkcommissionListMapper.addCheckcommissionList(checkcommissionList);
	}

	/**
	 * 查找一条CheckcommissionList
	 * @return CheckcommissionList
	 * @param id 主键id
	 */
	@Override
	public CheckcommissionList findCheckcommissionListById(int id) throws RuntimeException {
		return checkcommissionListMapper.findCheckcommissionListById(id);
	}

	/**
	 * 修改CheckcommissionList
	 * @param checkcommissionList
	 */
	@Override
	public void updateCheckcommissionList(CheckcommissionList checkcommissionList) throws RuntimeException {
		checkcommissionListMapper.updateCheckcommissionList(checkcommissionList);		
	}
	    
	/**
	 * 分页查找CheckcommissionList
	 * @param cond 查询条件
	 * @return CheckcommissionList列表
	 */
    @Override
	public List<CheckcommissionList> findCheckcommissionListPage(CheckcommissionListCond cond) throws RuntimeException {
		int recordCount = checkcommissionListMapper.findCheckcommissionListCount(cond);
		
		cond.recordCount = recordCount;
				
		return checkcommissionListMapper.findCheckcommissionListPage(cond);
	}
        
	/**
	 * 查找全部CheckcommissionList
	 * @param cond 查询条件
	 * @return CheckcommissionList列表
	 */
    @Override
	public List<CheckcommissionList> findCheckcommissionList(CheckcommissionListCond cond) throws RuntimeException {
    	return checkcommissionListMapper.findCheckcommissionList(cond);
	}
    
    /**
	 * ajax分页查找CheckcommissionList
	 * @param cond 查询条件
	 * @return CheckcommissionList列表
	 */
    @Override
	public List<CheckcommissionList> findCheckcommissionListForAjax(CheckcommissionListCond cond) throws RuntimeException {
        return checkcommissionListMapper.findCheckcommissionListForAjax(cond);
	}
    
     /**
	 * ajax分页查找CheckcommissionList总数
	 * @param cond 查询条件
	 * @return int
	 */
    @Override
    public int findCheckcommissionListCountForAjax(CheckcommissionListCond cond) throws RuntimeException {
        return checkcommissionListMapper.findCheckcommissionListCountForAjax(cond);
    }

    @Override
    public List<CheckcommissionList> findCheckcommissionListByPrjId(CheckcommissionListCond cond) throws RuntimeException {
        return checkcommissionListMapper.findCheckcommissionListByPrjId(cond);
    }
}
