package com.ihk.saleunit.data.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.saleunit.data.ISaleUnitReceiptMapper;
import com.ihk.saleunit.data.pojo.SaleUnitReceipt;
import com.ihk.saleunit.data.pojo.SaleUnitReceiptCond;
import com.ihk.saleunit.data.services.ISaleUnitReceiptServices;
import com.ihk.utils.SessionUser;
import com.ihk.utils.base.PojoDeleteCond;

@Service("saleUnitReceiptServices")
public class SaleUnitReceiptServices implements ISaleUnitReceiptServices {
	@Autowired	 ISaleUnitReceiptMapper saleUnitReceiptMapper;

	public void deleteSaleUnitReceipt(int id) throws RuntimeException {
		saleUnitReceiptMapper.deleteSaleUnitReceipt(new PojoDeleteCond(id));
	}

	public void addSaleUnitReceipt(SaleUnitReceipt saleUnitReceipt) throws RuntimeException {		
		saleUnitReceiptMapper.addSaleUnitReceipt(saleUnitReceipt);
	}

	@Override
	public SaleUnitReceipt findSaleUnitReceiptById(int id) throws RuntimeException {
		return saleUnitReceiptMapper.findSaleUnitReceiptById(id);
	}

	@Override
	public void updateSaleUnitReceipt(SaleUnitReceipt saleUnitReceipt) throws RuntimeException {
		saleUnitReceiptMapper.updateSaleUnitReceipt(saleUnitReceipt);		
	}
	
    @Override
	public List<SaleUnitReceipt> findSaleUnitReceiptPage(SaleUnitReceiptCond cond) throws RuntimeException {
		int recordCount = saleUnitReceiptMapper.findSaleUnitReceiptCount(cond);
		
		cond.recordCount = recordCount;
				
		return saleUnitReceiptMapper.findSaleUnitReceiptPage(cond);
	}
    
    @Override
	public List<SaleUnitReceipt> findSaleUnitReceipt(SaleUnitReceiptCond cond) throws RuntimeException {
    	return saleUnitReceiptMapper.findSaleUnitReceipt(cond);
	}
    
    @Override
	public List<SaleUnitReceipt> findSaleUnitReceiptForAjax(SaleUnitReceiptCond cond) throws RuntimeException {
        return saleUnitReceiptMapper.findSaleUnitReceiptForAjax(cond);
	}
    
    @Override
    public int findSaleUnitReceiptCountForAjax(SaleUnitReceiptCond cond) throws RuntimeException {
        return saleUnitReceiptMapper.findSaleUnitReceiptCountForAjax(cond);
    }

	@Override
	public List<SaleUnitReceipt> findReceiptListByUnitId(int unitId)
			throws RuntimeException {
		return saleUnitReceiptMapper.findReceiptListByUnitId(unitId);
	}
	
	@Override
	public List<SaleUnitReceipt> findReceiptListByBillId(int billId)
			throws RuntimeException {
		return saleUnitReceiptMapper.findReceiptListByBillId(billId);
	}

	@Override
	public void updateSaleUnitReceiptCheckFeeId(int receiptId, int checkFeeId)
			throws RuntimeException {
		
		SaleUnitReceiptCond cond = new SaleUnitReceiptCond();
		
		cond.setReceiptId(receiptId);
		cond.setCheckFeeId(checkFeeId);
		cond.setModId(SessionUser.getUserId());
		cond.setModTime(new Date());
		
		saleUnitReceiptMapper.updateSaleUnitReceiptCheckFeeId(cond);
		
	}

    @Override
    public void updateSaleUnitReceiptCheckCommissionId(int checkFeeId)
            throws RuntimeException {

        SaleUnitReceiptCond cond = new SaleUnitReceiptCond();

        cond.setCheckFeeId(checkFeeId);
        cond.setModId(SessionUser.getUserId());
        cond.setModTime(new Date());

        saleUnitReceiptMapper.updateSaleUnitReceiptCheckCommissionId(cond);

    }

}
