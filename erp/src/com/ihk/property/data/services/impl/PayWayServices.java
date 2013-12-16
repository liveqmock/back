package com.ihk.property.data.services.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.property.data.IPayWayMapper;
import com.ihk.property.data.pojo.PayWay;
import com.ihk.property.data.pojo.PayWayCond;
import com.ihk.property.data.services.IPayWayServices;

/**
 * PayWay的Services实现(业务实现)
 * @author 
 *
 */
@Service("payWayServices")
public class PayWayServices implements IPayWayServices {
	/**
	 * payWay数据访问接口
	 */
	@Autowired	 IPayWayMapper payWayMapper;

	/**
	 * 删除一条PayWay
	 * @param id
	 */
	public void deletePayWay(int id) throws RuntimeException {
		payWayMapper.deletePayWay(id);
	}

	/**
	 * 新增PayWay
	 * @param payWay
	 */
	public void addPayWay(PayWay payWay) throws RuntimeException {		
		payWayMapper.addPayWay(payWay);
	}

	/**
	 * 查找一条PayWay
	 * @return PayWay
	 * @param id 主键id
	 */
	@Override
	public PayWay findPayWayById(int id) throws RuntimeException {
		return payWayMapper.findPayWayById(id);
	}

	/**
	 * 修改PayWay
	 * @param payWay
	 */
	@Override
	public void updatePayWay(PayWay payWay) throws RuntimeException {
		payWayMapper.updatePayWay(payWay);		
	}

	/**
	 * 分页查找PayWay
	 * @param cond 查询条件
	 * @return PayWay列表
	 */
	public List<PayWay> findPayWayPage(PayWayCond cond) throws RuntimeException {
		int recordCount = payWayMapper.findPayWayCount(cond);
		
		cond.recordCount = recordCount;
				
		return payWayMapper.findPayWayPage(cond);
	}

	/**
	 * 查找全部PayWay
	 * @param cond 查询条件
	 * @return PayWay列表
	 */
	public List<PayWay> findPayWay(PayWayCond cond) throws RuntimeException {
    	return payWayMapper.findPayWay(cond);
	}

	@Override
	public PayWay findPayWayByNameAndProId(Map p) throws RuntimeException {
		return payWayMapper.findPayWayByNameAndProId(p);
	}
}
