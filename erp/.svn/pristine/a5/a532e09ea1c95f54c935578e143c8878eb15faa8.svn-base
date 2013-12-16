package com.ihk.property.data.services.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.property.data.ICheckcommissionMapper;
import com.ihk.property.data.pojo.Checkcommission;
import com.ihk.property.data.pojo.CheckcommissionCond;
import com.ihk.property.data.services.ICheckcommissionServices;
import com.ihk.saleunit.data.pojo.ConfirmCond;
import com.ihk.utils.base.PojoDeleteCond;

/**
 * Checkcommission的Services实现(业务实现)
 * @author 
 *
 */
@Service("checkcommissionServices")
public class CheckcommissionServices implements ICheckcommissionServices {
	/**
	 * checkcommission数据访问接口
	 */
	@Autowired	 ICheckcommissionMapper checkcommissionMapper;

	/**
	 * 删除一条Checkcommission
	 * @param id
	 */
    @Override
	public void deleteCheckcommission(int id) throws RuntimeException {
		checkcommissionMapper.deleteCheckcommission(new PojoDeleteCond(id));
	}

    @Override
    public void deleteCheckcommissionByUnitId(CheckcommissionCond cond) throws RuntimeException {
        checkcommissionMapper.deleteCheckcommissionByUnitId(cond);
    }
    @Override
    public void updateCheckcommissionByUnitId(CheckcommissionCond cond) throws RuntimeException {
        checkcommissionMapper.updateCheckcommissionByUnitId(cond);
    }

    @Override
    public void saveCommission(CheckcommissionCond cond) throws RuntimeException {
        checkcommissionMapper.saveCommission(cond);
    }

    public void savePayment(CheckcommissionCond cond) throws RuntimeException {
        checkcommissionMapper.savePayment(cond);
    }

	/**
	 * 新增Checkcommission
	 * @param checkcommission
	 */
    @Override
	public void addCheckcommission(Checkcommission checkcommission) throws RuntimeException {		
		checkcommissionMapper.addCheckcommission(checkcommission);
	}

	/**
	 * 查找一条Checkcommission
	 * @return Checkcommission
	 * @param id 主键id
	 */
	@Override
	public Checkcommission findCheckcommissionById(int id) throws RuntimeException {
		return checkcommissionMapper.findCheckcommissionById(id);
	}

	/**
	 * 修改Checkcommission
	 * @param checkcommission
	 */
	@Override
	public void updateCheckcommission(Checkcommission checkcommission) throws RuntimeException {
		checkcommissionMapper.updateCheckcommission(checkcommission);		
	}
	    
	/**
	 * 分页查找Checkcommission
	 * @param cond 查询条件
	 * @return Checkcommission列表
	 */
    @Override
	public List<Checkcommission> findCheckcommissionPage(CheckcommissionCond cond) throws RuntimeException {
		int recordCount = checkcommissionMapper.findCheckcommissionCount(cond);
		
		cond.recordCount = recordCount;
				
		return checkcommissionMapper.findCheckcommissionPage(cond);
	}
        
	/**
	 * 查找全部Checkcommission
	 * @param cond 查询条件
	 * @return Checkcommission列表
	 */
    @Override
	public List<Checkcommission> findCheckcommission(CheckcommissionCond cond) throws RuntimeException {
    	return checkcommissionMapper.findCheckcommission(cond);
	}
    
    /**
	 * ajax分页查找Checkcommission
	 * @param cond 查询条件
	 * @return Checkcommission列表
	 */
    @Override
	public List<Checkcommission> findCheckcommissionForAjax(CheckcommissionCond cond) throws RuntimeException {
        return checkcommissionMapper.findCheckcommissionForAjax(cond);
	}
    
     /**
	 * ajax分页查找Checkcommission总数
	 * @param cond 查询条件
	 * @return int
	 */
    @Override
    public int findCheckcommissionCountForAjax(CheckcommissionCond cond) throws RuntimeException {
        return checkcommissionMapper.findCheckcommissionCountForAjax(cond);
    }


    @Override
    public void updateCheckcommissionByRepay(CheckcommissionCond cond) throws RuntimeException {
        checkcommissionMapper.updateCheckcommissionByRepay(cond);
    }

    @Override
    public List<Map<String, Object>> findCheckfeeEd(ConfirmCond cond) throws RuntimeException {
        return checkcommissionMapper.findCheckfeeEd(cond);
    }

    @Override
    public List<Map<String, Object>> findCheckfeePart(ConfirmCond cond) throws RuntimeException {
        return checkcommissionMapper.findCheckfeePart(cond);
    }

    /**
     * 查找对佣表
     * @param cond 查询条件
     * @return Checkcommission列表
     */
    @Override
    public List<Map<String, Object>> findCheckcommissionView(ConfirmCond cond) throws RuntimeException {
        return checkcommissionMapper.findCheckcommissionView(cond);
    }

    @Override
    public List<Map<String, Object>> checkDateList(CheckcommissionCond cond) throws RuntimeException {
        return checkcommissionMapper.checkDateList(cond);
    }

    @Override
    public List<Map<String, Object>> sumByUnitId(CheckcommissionCond cond) throws RuntimeException {
        return checkcommissionMapper.sumByUnitId(cond);
    }
    
    
    @SuppressWarnings("rawtypes")
	@Override
    public List<Map> findCheckcommissionByUnitIdList(Map<String, List> maps)
    		throws RuntimeException {
    	// TODO Auto-generated method stub
    	return checkcommissionMapper.findCheckcommissionByUnitIdList(maps);
    }
}
