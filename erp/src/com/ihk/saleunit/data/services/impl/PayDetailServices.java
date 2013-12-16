package com.ihk.saleunit.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.saleunit.data.IPayDetailMapper;
import com.ihk.saleunit.data.pojo.PayDetail;
import com.ihk.saleunit.data.pojo.PayDetailCond;
import com.ihk.saleunit.data.services.IPayDetailServices;

/**
 * PayDetail的Services实现(业务实现)
 * @author 
 *
 */
@Service("payDetailServices")
public class PayDetailServices implements IPayDetailServices {
	/**
	 * payDetail数据访问接口
	 */
	@Autowired	 IPayDetailMapper payDetailMapper;

	/**
	 * 删除一条PayDetail
	 * @param id
	 */
	public void deletePayDetail(int id) throws RuntimeException {
		payDetailMapper.deletePayDetail(id);
	}

	/**
	 * 新增PayDetail
	 * @param payDetail
	 */
	public void addPayDetail(PayDetail payDetail) throws RuntimeException {		
		payDetailMapper.addPayDetail(payDetail);
	}

	/**
	 * 查找一条PayDetail
	 * @return PayDetail
	 * @param id 主键id
	 */
	@Override
	public PayDetail findPayDetailById(int id) throws RuntimeException {
		return payDetailMapper.findPayDetailById(id);
	}

	/**
	 * 修改PayDetail
	 * @param payDetail
	 */
	@Override
	public void updatePayDetail(PayDetail payDetail) throws RuntimeException {
		payDetailMapper.updatePayDetail(payDetail);		
	}

	/**
	 * 分页查找PayDetail
	 * @param cond 查询条件
	 * @return PayDetail列表
	 */
	public List<PayDetail> findPayDetailPage(PayDetailCond cond) throws RuntimeException {
		int recordCount = payDetailMapper.findPayDetailCount(cond);
		
		cond.recordCount = recordCount;
				
		return payDetailMapper.findPayDetailPage(cond);
	}

	/**
	 * 查找全部PayDetail
	 * @param cond 查询条件
	 * @return PayDetail列表
	 */
	public List<PayDetail> findPayDetail(PayDetailCond cond) throws RuntimeException {
    	return payDetailMapper.findPayDetail(cond);
	}

	/**
	 * 查找最大序号
	 */
	@Override
	public Integer findPayDetailMaxOrderIndex() throws RuntimeException {
		return payDetailMapper.findPayDetailMaxOrderIndex();
	}
}
