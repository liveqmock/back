package com.ihk.saleunit.data.services.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.saleunit.data.IChangeOwnerDetailMapper;
import com.ihk.saleunit.data.pojo.ChangeOwnerDetail;
import com.ihk.saleunit.data.pojo.ChangeOwnerDetailCond;
import com.ihk.saleunit.data.services.IChangeOwnerDetailServices;

/**
 * ChangeOwnerDetail的Services实现(业务实现)
 * @author 
 *
 */
@Service("changeOwnerDetailServices")
@SuppressWarnings("unchecked")
public class ChangeOwnerDetailServices implements IChangeOwnerDetailServices {
	/**
	 * changeOwnerDetail数据访问接口
	 */
	@Autowired	 IChangeOwnerDetailMapper changeOwnerDetailMapper;

	/**
	 * 删除一条ChangeOwnerDetail
	 * @param id
	 */
	public void deleteChangeOwnerDetail(int id) throws RuntimeException {
		changeOwnerDetailMapper.deleteChangeOwnerDetail(id);
	}

	/**
	 * 新增ChangeOwnerDetail
	 * @param changeOwnerDetail
	 */
	public void addChangeOwnerDetail(ChangeOwnerDetail changeOwnerDetail) throws RuntimeException {		
		changeOwnerDetailMapper.addChangeOwnerDetail(changeOwnerDetail);
	}

	/**
	 * 查找一条ChangeOwnerDetail
	 * @return ChangeOwnerDetail
	 * @param id 主键id
	 */
	@Override
	public ChangeOwnerDetail findChangeOwnerDetailById(int id) throws RuntimeException {
		return changeOwnerDetailMapper.findChangeOwnerDetailById(id);
	}

	/**
	 * 修改ChangeOwnerDetail
	 * @param changeOwnerDetail
	 */
	@Override
	public void updateChangeOwnerDetail(ChangeOwnerDetail changeOwnerDetail) throws RuntimeException {
		changeOwnerDetailMapper.updateChangeOwnerDetail(changeOwnerDetail);		
	}

	/**
	 * 分页查找ChangeOwnerDetail
	 * @param cond 查询条件
	 * @return ChangeOwnerDetail列表
	 */
	public List<ChangeOwnerDetail> findChangeOwnerDetailPage(ChangeOwnerDetailCond cond) throws RuntimeException {
		int recordCount = changeOwnerDetailMapper.findChangeOwnerDetailCount(cond);
		
		cond.recordCount = recordCount;
				
		return changeOwnerDetailMapper.findChangeOwnerDetailPage(cond);
	}

	/**
	 * 查找全部ChangeOwnerDetail
	 * @param cond 查询条件
	 * @return ChangeOwnerDetail列表
	 */
	public List<ChangeOwnerDetail> findChangeOwnerDetail(ChangeOwnerDetailCond cond) throws RuntimeException {
    	return changeOwnerDetailMapper.findChangeOwnerDetail(cond);
	}
}
