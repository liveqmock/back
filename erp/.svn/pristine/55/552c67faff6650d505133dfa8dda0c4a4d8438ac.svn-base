package com.ihk.property.data.services.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.property.data.ICheckfeeMapper;
import com.ihk.property.data.pojo.Checkfee;
import com.ihk.property.data.services.ICheckfeeServices;
import com.ihk.saleunit.action.check_fee.pojo.CheckFeeCond;
import com.ihk.utils.base.PojoDeleteCond;

/**
 * Checkfee的Services实现(业务实现)
 * @author 
 *
 */
@SuppressWarnings("rawtypes")
@Service("checkfeeServices")
public class CheckfeeServices implements ICheckfeeServices {
	/**
	 * checkfee数据访问接口
	 */
	@Autowired	 ICheckfeeMapper checkfeeMapper;

	/**
	 * 删除一条Checkfee
	 * @param id
	 */
    @Override
	public void deleteCheckfee(int id) throws RuntimeException {
		checkfeeMapper.deleteCheckfee(new PojoDeleteCond(id));
	}

    /**
     * 按单元id删除一条Checkfee
     * @param cond
     */
    @Override
    public void deleteCheckfeeByUnitId(CheckFeeCond cond) throws RuntimeException {

        checkfeeMapper.deleteCheckfeeByUnitId(cond);
    }

	/**
	 * 新增Checkfee
	 * @param checkfee
	 */
    @Override
	public void addCheckfee(Checkfee checkfee) throws RuntimeException {		
		checkfeeMapper.addCheckfee(checkfee);
	}

	/**
	 * 查找一条Checkfee
	 * @return Checkfee
	 * @param id 主键id
	 */
	@Override
	public Checkfee findCheckfeeById(int id) throws RuntimeException {
		return checkfeeMapper.findCheckfeeById(id);
	}

    @Override
    public Checkfee findCheckfeeByUnitId(int unitId) throws RuntimeException {
        return checkfeeMapper.findCheckfeeByUnitId(unitId);
    }

	/**
	 * 修改Checkfee
	 * @param checkfee
	 */
	@Override
	public void updateCheckfee(Checkfee checkfee) throws RuntimeException {
		checkfeeMapper.updateCheckfee(checkfee);		
	}
	    
	/**
	 * 修改对数表状态
	 * @param cond
	 */
	@Override
    public void updateCheckfeeByUnitId(CheckFeeCond cond) throws RuntimeException {
		checkfeeMapper.updateCheckfeeByUnitId(cond);
	}

	/**
	 * 修改回款金额
	 * @param cond
	 */
	@Override
    public void updateCheckfeeByRepay(CheckFeeCond cond) throws RuntimeException {
		checkfeeMapper.updateCheckfeeByRepay(cond);
	}

	/**
	 * 分页查找Checkfee
	 * @param cond 查询条件
	 * @return Checkfee列表
	 */
    @Override
	public List<Checkfee> findCheckfeePage(CheckFeeCond cond) throws RuntimeException {
		int recordCount = checkfeeMapper.findCheckfeeCount(cond);
		
		cond.recordCount = recordCount;
				
		return checkfeeMapper.findCheckfeePage(cond);
	}
        
	/**
	 * 查找全部Checkfee
	 * @param cond 查询条件
	 * @return Checkfee列表
	 */
    @Override
	public List<Checkfee> findCheckfee(CheckFeeCond cond) throws RuntimeException {
    	return checkfeeMapper.findCheckfee(cond);
	}
    
    /**
	 * ajax分页查找Checkfee
	 * @param cond 查询条件
	 * @return Checkfee列表
	 */
    @Override
	public List<Checkfee> findCheckfeeForAjax(CheckFeeCond cond) throws RuntimeException {
        return checkfeeMapper.findCheckfeeForAjax(cond);
	}
    
     /**
	 * ajax分页查找Checkfee总数
	 * @param cond 查询条件
	 * @return int
	 */
    @Override
    public int findCheckfeeCountForAjax(CheckFeeCond cond) throws RuntimeException {
        return checkfeeMapper.findCheckfeeCountForAjax(cond);
    }

	@Override
	public Checkfee findLastCheckfeeDateByBillId(int billId)
			throws RuntimeException {
		return checkfeeMapper.findLastCheckfeeDateByBillId(billId);
	}
	
    @Override
    public List<Map> findCheckfeeListByUnitIdList(Map<String, List> ids)
    		throws RuntimeException {
    	return  checkfeeMapper.findCheckfeeListByUnitIdList(ids);
    }
    
    
	@Override
    public List<Map> findCheckfeeListByCond(Map<String, Object> map)
    		throws RuntimeException {
    	return checkfeeMapper.findCheckfeeListByCond(map);
    }
}
