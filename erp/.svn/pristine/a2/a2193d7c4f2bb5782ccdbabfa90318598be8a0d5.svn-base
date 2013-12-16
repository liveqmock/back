package com.ihk.saleunit.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.saleunit.data.IReceiptMapper;
import com.ihk.saleunit.data.pojo.Receipt;
import com.ihk.saleunit.data.pojo.ReceiptCond;
import com.ihk.saleunit.data.services.IReceiptServices;
import com.ihk.utils.base.PojoDeleteCond;

/**
 * Receipt的Services实现(业务实现)
 * @author 
 *
 */
@Service("receiptServices")
public class ReceiptServices implements IReceiptServices {
	/**
	 * receipt数据访问接口
	 */
	@Autowired	 IReceiptMapper receiptMapper;

	/**
	 * 删除一条Receipt
	 * @param id
	 */
	public void deleteReceipt(int id) throws RuntimeException {
		receiptMapper.deleteReceipt(new PojoDeleteCond(id));
	}

	/**
	 * 新增Receipt
	 * @param receipt
	 */
	public void addReceipt(Receipt receipt) throws RuntimeException {		
		receiptMapper.addReceipt(receipt);
	}

	/**
	 * 查找一条Receipt
	 * @return Receipt
	 * @param id 主键id
	 */
	@Override
	public Receipt findReceiptById(int id) throws RuntimeException {
		return receiptMapper.findReceiptById(id);
	}

	/**
	 * 修改Receipt
	 * @param receipt
	 */
	@Override
	public void updateReceipt(Receipt receipt) throws RuntimeException {
		receiptMapper.updateReceipt(receipt);		
	}

	/**
	 * 分页查找Receipt
	 * @param cond 查询条件
	 * @return Receipt列表
	 */
	public List<Receipt> findReceiptPage(ReceiptCond cond) throws RuntimeException {
		int recordCount = receiptMapper.findReceiptCount(cond);
		
		cond.recordCount = recordCount;
				
		return receiptMapper.findReceiptPage(cond);
	}

	/**
	 * 查找全部Receipt
	 * @param cond 查询条件
	 * @return Receipt列表
	 */
	public List<Receipt> findReceipt(ReceiptCond cond) throws RuntimeException {
    	return receiptMapper.findReceipt(cond);
	}

	/**
	 * 根据unitId查找
	 */
	@Override
	public List<Receipt> findReceiptByUnitId(int unitId)
			throws RuntimeException {
		
		return receiptMapper.findReceiptByUnitId(unitId);
	}
}
