package com.ihk.saleunit.data;

import java.util.List;

import com.ihk.saleunit.data.pojo.ReceiptDetail;
import com.ihk.saleunit.data.pojo.ReceiptDetailCond;
import com.ihk.utils.base.PojoDeleteCond;

/**
 * ReceiptDetail数据访问接口Mapper
 * @author 
 *
 */ 
public interface IReceiptDetailMapper {

	/**
	 * 新增ReceiptDetail
	 * @param receiptDetail
	 */
	public void addReceiptDetail(ReceiptDetail receiptDetail) ;

	/**
	 * 根据条件删除ReceiptDetail
	 * @param cond 删除条件
	 */
	public void deleteReceiptDetail(PojoDeleteCond cond) throws RuntimeException;

	/**
	 * 修改ReceiptDetail
	 * @param receiptDetail
	 */
	public void updateReceiptDetail(ReceiptDetail receiptDetail) throws RuntimeException;

	/**
	 * 查找一条ReceiptDetail
	 * @return ReceiptDetail
	 * @param id 主键id
	 */
	public ReceiptDetail findReceiptDetailById(int id) throws RuntimeException;

	/**
	 * 分页查找ReceiptDetail
	 * @param cond 查询条件
	 * @return ReceiptDetail列表
	 */
	public List<ReceiptDetail> findReceiptDetailPage(ReceiptDetailCond cond) ;

	/**
	 * 查找全部ReceiptDetail
	 * @param cond 查询条件
	 * @return ReceiptDetail列表
	 */
	public List<ReceiptDetail> findReceiptDetail(ReceiptDetailCond cond) ;

	/**
	 * 查找符合条件的记录条数ReceiptDetail
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findReceiptDetailCount(ReceiptDetailCond cond) ;
	
	/**
	 * 根据ReceiptId查找
	 * @param receiptId
	 * @return
	 * @throws RuntimeException
	 */
	public List<ReceiptDetail> findReceiptDetailByReceiptId(int receiptId) throws RuntimeException;
	
	/**
	 * 根据billId查找
	 * @param billId
	 * @return
	 * @throws RuntimeException
	 */
	public ReceiptDetail findReceiptDetailByBillId(int billId) throws RuntimeException;

}
