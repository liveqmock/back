package com.ihk.saleunit.data;

import java.util.List;

import com.ihk.saleunit.data.pojo.Receipt;
import com.ihk.saleunit.data.pojo.ReceiptCond;
import com.ihk.utils.base.PojoDeleteCond;

/**
 * Receipt数据访问接口Mapper
 * @author 
 *
 */ 
public interface IReceiptMapper {

	/**
	 * 新增Receipt
	 * @param receipt
	 */
	public void addReceipt(Receipt receipt) ;

	/**
	 * 根据条件删除Receipt
	 * @param cond 删除条件
	 */
	public void deleteReceipt(PojoDeleteCond cond) throws RuntimeException;

	/**
	 * 修改Receipt
	 * @param receipt
	 */
	public void updateReceipt(Receipt receipt) throws RuntimeException;

	/**
	 * 查找一条Receipt
	 * @return Receipt
	 * @param id 主键id
	 */
	public Receipt findReceiptById(int id) throws RuntimeException;

	/**
	 * 分页查找Receipt
	 * @param cond 查询条件
	 * @return Receipt列表
	 */
	public List<Receipt> findReceiptPage(ReceiptCond cond) ;

	/**
	 * 查找全部Receipt
	 * @param cond 查询条件
	 * @return Receipt列表
	 */
	public List<Receipt> findReceipt(ReceiptCond cond) ;

	/**
	 * 查找符合条件的记录条数Receipt
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findReceiptCount(ReceiptCond cond) ;
	
	/**
	 * 查找根据unitId
	 * @param unitId
	 * @return
	 * @throws RuntimeException
	 */
	public List<Receipt> findReceiptByUnitId(int unitId) throws RuntimeException;
}
