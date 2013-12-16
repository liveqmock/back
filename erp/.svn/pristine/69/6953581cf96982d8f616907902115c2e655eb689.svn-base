package com.ihk.saleunit.data.services.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.constanttype.EnumChangeType;
import com.ihk.saleunit.data.IChangePriceMapper;
import com.ihk.saleunit.data.pojo.ApprovalChange;
import com.ihk.saleunit.data.pojo.ChangePrice;
import com.ihk.saleunit.data.pojo.ChangePriceCond;
import com.ihk.saleunit.data.services.IApprovalChangeServices;
import com.ihk.saleunit.data.services.IChangePriceServices;
import com.ihk.utils.SessionUser;

/**
 * ChangePrice的Services实现(业务实现)
 * @author 
 *
 */
@Service("changePriceServices")
@SuppressWarnings("unchecked")
public class ChangePriceServices implements IChangePriceServices {
	/**
	 * changePrice数据访问接口
	 */
	@Autowired	 IChangePriceMapper changePriceMapper;
	@Autowired IApprovalChangeServices iApprovalChangeServices;

	/**
	 * 删除一条ChangePrice
	 * @param id
	 */
	public void deleteChangePrice(int id) throws RuntimeException {
		changePriceMapper.deleteChangePrice(id);
	}

	/**
	 * 新增ChangePrice
	 * @param changePrice
	 */
	public void addChangePrice(ChangePrice changePrice) throws RuntimeException {		
		changePriceMapper.addChangePrice(changePrice);
		ApprovalChange app = new ApprovalChange();
		app.setApplyType(EnumChangeType.CHANGE_PRICE.toString());
		app.setApplyId(changePrice.getId());
		app.setIsDeleted("0");
		app.setCreatedId(SessionUser.getUserId());
		app.setModId(app.getCreatedId());
		app.setCreatedTime(new Date());
		app.setModTime(app.getCreatedTime());
		iApprovalChangeServices.addApprovalChange(app);
		
	}

	/**
	 * 查找一条ChangePrice
	 * @return ChangePrice
	 * @param id 主键id
	 */
	@Override
	public ChangePrice findChangePriceById(int id) throws RuntimeException {
		return changePriceMapper.findChangePriceById(id);
	}

	/**
	 * 修改ChangePrice
	 * @param changePrice
	 */
	@Override
	public void updateChangePrice(ChangePrice changePrice) throws RuntimeException {
		changePriceMapper.updateChangePrice(changePrice);		
	}

	/**
	 * 分页查找ChangePrice
	 * @param cond 查询条件
	 * @return ChangePrice列表
	 */
	public List<ChangePrice> findChangePricePage(ChangePriceCond cond) throws RuntimeException {
		int recordCount = changePriceMapper.findChangePriceCount(cond);
		
		cond.recordCount = recordCount;
				
		return changePriceMapper.findChangePricePage(cond);
	}

	/**
	 * 查找全部ChangePrice
	 * @param cond 查询条件
	 * @return ChangePrice列表
	 */
	public List<ChangePrice> findChangePrice(ChangePriceCond cond) throws RuntimeException {
    	return changePriceMapper.findChangePrice(cond);
	}
}
