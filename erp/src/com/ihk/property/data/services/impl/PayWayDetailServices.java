package com.ihk.property.data.services.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.property.data.IPayWayDetailMapper;
import com.ihk.property.data.pojo.PayWayDetail;
import com.ihk.property.data.pojo.PayWayDetailCond;
import com.ihk.property.data.services.IPayWayDetailServices;
import com.ihk.utils.base.PojoDeleteCond;

/**
 * PayWayDetail的Services实现(业务实现)
 * @author 
 *
 */
@Service("payWayDetailServices")
public class PayWayDetailServices implements IPayWayDetailServices {
	/**
	 * payWayDetail数据访问接口
	 */
	@Autowired	 IPayWayDetailMapper payWayDetailMapper;

	/**
	 * 删除一条PayWayDetail
	 * @param id
	 */
	public void deletePayWayDetail(int id) throws RuntimeException {
		payWayDetailMapper.deletePayWayDetail(new PojoDeleteCond(id));
	}


	/**
	 * 新增PayWayDetail
	 * @param payWayDetail
	 */
	public void addPayWayDetail(PayWayDetail payWayDetail) throws RuntimeException {		
		payWayDetailMapper.addPayWayDetail(payWayDetail);
	}

	/**
	 * 查找一条PayWayDetail
	 * @return PayWayDetail
	 * @param id 主键id
	 */
	@Override
	public PayWayDetail findPayWayDetailById(int id) throws RuntimeException {
		return payWayDetailMapper.findPayWayDetailById(id);
	}


	/**
	 * 修改PayWayDetail
	 * @param payWayDetail
	 */
	@Override
	public void updatePayWayDetail(PayWayDetail payWayDetail) throws RuntimeException {
		payWayDetailMapper.updatePayWayDetail(payWayDetail);		
	}

	/**
	 * 分页查找PayWayDetail
	 * @param cond 查询条件
	 * @return PayWayDetail列表
	 */
	public List<PayWayDetail> findPayWayDetailPage(PayWayDetailCond cond) throws RuntimeException {
		int recordCount = payWayDetailMapper.findPayWayDetailCount(cond);
		
		cond.recordCount = recordCount;
				
		return payWayDetailMapper.findPayWayDetailPage(cond);
	}

	/**
	 * 查找全部PayWayDetail
	 * @param cond 查询条件
	 * @return PayWayDetail列表
	 */
	public List<PayWayDetail> findPayWayDetail(PayWayDetailCond cond) throws RuntimeException {
    	return payWayDetailMapper.findPayWayDetail(cond);
	}

	@Override
	public List<PayWayDetail> findPayWayDetailByWayId(int wayId)
			throws RuntimeException {
		
		return payWayDetailMapper.findPayWayDetailByWayId(wayId);
	}

	/**
	 * 根据wayId,payType查找
	 */
	@Override
	public List<PayWayDetail> findPayWayDetailByWayIdAndPayType(int wayId,
			String payType) throws RuntimeException {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("wayId", wayId + "");
		map.put("payType", payType);
		
		return payWayDetailMapper.findPayWayDetailByWayIdAndPayType(map);
	}
}
