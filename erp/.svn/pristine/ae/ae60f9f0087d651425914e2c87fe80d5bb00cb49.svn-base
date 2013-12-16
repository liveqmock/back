package com.ihk.property.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.property.data.ICheckfeeListMapper;
import com.ihk.property.data.pojo.CheckfeeList;
import com.ihk.property.data.pojo.CheckfeeListCond;
import com.ihk.property.data.services.ICheckfeeListServices;
import com.ihk.utils.base.PojoDeleteCond;

/**
 * CheckfeeList的Services实现(业务实现)
 * @author 
 *
 */
@Service("checkfeeListServices")
public class CheckfeeListServices implements ICheckfeeListServices {
	/**
	 * checkfeeList数据访问接口
	 */
	@Autowired	 ICheckfeeListMapper checkfeeListMapper;

	/**
	 * 删除一条CheckfeeList
	 * @param id
	 */
    @Override
	public void deleteCheckfeeList(int id) throws RuntimeException {
		checkfeeListMapper.deleteCheckfeeList(new PojoDeleteCond(id));
	}

	/**
	 * 新增CheckfeeList
	 * @param checkfeeList
	 */
    @Override
	public void addCheckfeeList(CheckfeeList checkfeeList) throws RuntimeException {		
		checkfeeListMapper.addCheckfeeList(checkfeeList);
	}

	/**
	 * 查找一条CheckfeeList
	 * @return CheckfeeList
	 * @param id 主键id
	 */
	@Override
	public CheckfeeList findCheckfeeListById(int id) throws RuntimeException {
		return checkfeeListMapper.findCheckfeeListById(id);
	}


    /**
     * 查找CheckfeeList 不分页
     * @return CheckfeeList
     */
    public  List<CheckfeeList>  findCheckfeeListByPrjId(CheckfeeListCond checkfeeListCond) throws RuntimeException {
        return checkfeeListMapper.findCheckfeeListByPrjId(checkfeeListCond);
    }

	/**
	 * 修改CheckfeeList
	 * @param checkfeeList
	 */
	@Override
	public void updateCheckfeeList(CheckfeeList checkfeeList) throws RuntimeException {
		checkfeeListMapper.updateCheckfeeList(checkfeeList);		
	}
	    
	/**
	 * 分页查找CheckfeeList
	 * @param cond 查询条件
	 * @return CheckfeeList列表
	 */
    @Override
	public List<CheckfeeList> findCheckfeeListPage(CheckfeeListCond cond) throws RuntimeException {
		int recordCount = checkfeeListMapper.findCheckfeeListCount(cond);
		
		cond.recordCount = recordCount;
				
		return checkfeeListMapper.findCheckfeeListPage(cond);
	}
        
	/**
	 * 查找全部CheckfeeList
	 * @param cond 查询条件
	 * @return CheckfeeList列表
	 */
    @Override
	public List<CheckfeeList> findCheckfeeList(CheckfeeListCond cond) throws RuntimeException {
    	return checkfeeListMapper.findCheckfeeList(cond);
	}
    
    /**
	 * ajax分页查找CheckfeeList
	 * @param cond 查询条件
	 * @return CheckfeeList列表
	 */
    @Override
	public List<CheckfeeList> findCheckfeeListForAjax(CheckfeeListCond cond) throws RuntimeException {
        return checkfeeListMapper.findCheckfeeListForAjax(cond);
	}
    
     /**
	 * ajax分页查找CheckfeeList总数
	 * @param cond 查询条件
	 * @return int
	 */
    @Override
    public int findCheckfeeListCountForAjax(CheckfeeListCond cond) throws RuntimeException {
        return checkfeeListMapper.findCheckfeeListCountForAjax(cond);
    }
    

}
