package com.ihk.saleunit.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.constanttype.ContUnitSaleState;
import com.ihk.saleunit.data.IConfirmBookMapper;
import com.ihk.saleunit.data.pojo.ConfirmBook;
import com.ihk.saleunit.data.pojo.ConfirmBookCond;
import com.ihk.saleunit.data.services.IConfirmBookServices;
import com.ihk.utils.base.PojoDeleteCond;
import com.ihk.utils.contract.sale.SaleUtils;
import com.ihk.utils.saleunitnew.UnitOperRecordUtils;

/**
 * ConfirmBook的Services实现(业务实现)
 * @author 
 *
 */
@Service("confirmBookServices")
public class ConfirmBookServices implements IConfirmBookServices {
	/**
	 * confirmBook数据访问接口
	 */
	@Autowired	 IConfirmBookMapper confirmBookMapper;

	/**
	 * 删除一条ConfirmBook
	 * @param id
	 */
	public void deleteConfirmBook(int id) throws RuntimeException {
		confirmBookMapper.deleteConfirmBook(new PojoDeleteCond(id));
	}

	/**
	 * 新增ConfirmBook
	 * @param confirmBook
	 */
	public void addConfirmBook(ConfirmBook confirmBook) throws RuntimeException {
		
		//sman,2013.5.22为salesId前后都加上,
		confirmBook = SaleUtils.initSalesId(confirmBook);
		
		confirmBookMapper.addConfirmBook(confirmBook);
		
		//sman,2013.7.13增加ContractSalesman,要放到新增后面,要不拿不到对应的主键id
		SaleUtils.addContractSalesman(confirmBook);
		
		//增加记录
		UnitOperRecordUtils.addOperRecord(confirmBook.getUnitId(), ContUnitSaleState.CONFIRM_BOOK, confirmBook.getId());
	}

	/**
	 * 查找一条ConfirmBook
	 * @return ConfirmBook
	 * @param id 主键id
	 */
	@Override
	public ConfirmBook findConfirmBookById(int id) throws RuntimeException {
		return confirmBookMapper.findConfirmBookById(id);
	}


	/**
	 * 修改ConfirmBook
	 * @param confirmBook
	 */
	@Override
	public void updateConfirmBook(ConfirmBook confirmBook) throws RuntimeException {
		
		//sman,2013.5.22为salesId前后都加上,
		confirmBook = SaleUtils.initSalesId(confirmBook);
		
		//sman,2013.8.1增加ContractSalesman
		SaleUtils.updateContractSalesman(confirmBook);
		
		confirmBookMapper.updateConfirmBook(confirmBook);		
	}

	/**
	 * 分页查找ConfirmBook
	 * @param cond 查询条件
	 * @return ConfirmBook列表
	 */
	public List<ConfirmBook> findConfirmBookPage(ConfirmBookCond cond) throws RuntimeException {
		int recordCount = confirmBookMapper.findConfirmBookCount(cond);
		
		cond.recordCount = recordCount;
				
		return confirmBookMapper.findConfirmBookPage(cond);
	}

	/**
	 * 查找全部ConfirmBook
	 * @param cond 查询条件
	 * @return ConfirmBook列表
	 */
	public List<ConfirmBook> findConfirmBook(ConfirmBookCond cond) throws RuntimeException {
    	return confirmBookMapper.findConfirmBook(cond);
	}

	/**
	 * 根据unitId查找
	 */
	@Override
	public ConfirmBook findConfirmBookByUnitId(int unitId)
			throws RuntimeException {
		return confirmBookMapper.findConfirmBookByUnitId(unitId);
	}
	
	/**
	 * 查找临订,根据unitId,包括已删除的
	 * @param unitId
	 * @return
	 * @throws RuntimeException
	 */
	@Override
	public ConfirmBook findConfirmBookByUnitIdIncludeIsDeleted(int unitId)
			throws RuntimeException {
		return confirmBookMapper.findConfirmBookByUnitIdIncludeIsDeleted(unitId);
	}
	
	
	@Override
	public void updateConfirmBookBefore(ConfirmBook confirmBook) throws RuntimeException {
		confirmBookMapper.updateConfirmBookBefore(confirmBook);
		
	}
}
