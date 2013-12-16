package com.ihk.saleunit.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.saleunit.data.IReceiptDetailMapper;
import com.ihk.saleunit.data.pojo.ReceiptDetail;
import com.ihk.saleunit.data.pojo.ReceiptDetailCond;
import com.ihk.saleunit.data.services.IReceiptDetailServices;
import com.ihk.utils.base.PojoDeleteCond;

/**
 * ReceiptDetail的Services实现(业务实现)
 * @author 
 *
 */
@Service("receiptDetailServices")
public class ReceiptDetailServices implements IReceiptDetailServices {
	/**
	 * receiptDetail数据访问接口
	 */
	@Autowired	 IReceiptDetailMapper receiptDetailMapper;

	/**
	 * 删除一条ReceiptDetail
	 * @param id
	 */
	public void deleteReceiptDetail(int id) throws RuntimeException {
		receiptDetailMapper.deleteReceiptDetail(new PojoDeleteCond(id));
	}

	/**
	 * 新增ReceiptDetail
	 * @param receiptDetail
	 */
	public void addReceiptDetail(ReceiptDetail receiptDetail) throws RuntimeException {		
		receiptDetailMapper.addReceiptDetail(receiptDetail);
	}

	/**
	 * 查找一条ReceiptDetail
	 * @return ReceiptDetail
	 * @param id 主键id
	 */
	@Override
	public ReceiptDetail findReceiptDetailById(int id) throws RuntimeException {
		return receiptDetailMapper.findReceiptDetailById(id);
	}

	/**
	 * 修改ReceiptDetail
	 * @param receiptDetail
	 */
	@Override
	public void updateReceiptDetail(ReceiptDetail receiptDetail) throws RuntimeException {
		receiptDetailMapper.updateReceiptDetail(receiptDetail);		
	}

	/**
	 * 分页查找ReceiptDetail
	 * @param cond 查询条件
	 * @return ReceiptDetail列表
	 */
	public List<ReceiptDetail> findReceiptDetailPage(ReceiptDetailCond cond) throws RuntimeException {
		int recordCount = receiptDetailMapper.findReceiptDetailCount(cond);
		
		cond.recordCount = recordCount;
				
		return receiptDetailMapper.findReceiptDetailPage(cond);
	}

	/**
	 * 查找全部ReceiptDetail
	 * @param cond 查询条件
	 * @return ReceiptDetail列表
	 */
	public List<ReceiptDetail> findReceiptDetail(ReceiptDetailCond cond) throws RuntimeException {
    	return receiptDetailMapper.findReceiptDetail(cond);
	}

	/**
	 * 根据receiptId查找
	 */
	@Override
	public List<ReceiptDetail> findReceiptDetailByReceiptId(int receiptId)
			throws RuntimeException {
		
		return receiptDetailMapper.findReceiptDetailByReceiptId(receiptId);
	}

	/**
	 * 根据billId查找
	 */
	@Override
	public ReceiptDetail findReceiptDetailByBillId(int billId)
			throws RuntimeException {
		
		return receiptDetailMapper.findReceiptDetailByBillId(billId);
	}
}
