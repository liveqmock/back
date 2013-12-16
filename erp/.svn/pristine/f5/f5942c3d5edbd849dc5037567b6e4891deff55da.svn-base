package com.ihk.saleunit.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.saleunit.data.IMakeBuildPriceDetailMapper;
import com.ihk.saleunit.data.pojo.MakeBuildPriceDetail;
import com.ihk.saleunit.data.pojo.MakeBuildPriceDetailCond;
import com.ihk.saleunit.data.services.IMakeBuildPriceDetailServices;

/**
 * MakeBuildPriceDetail的Services实现(业务实现)
 * @author 
 *
 */
@Service("makeBuildPriceDetailServices")
@SuppressWarnings("unchecked")
public class MakeBuildPriceDetailServices implements IMakeBuildPriceDetailServices {
	/**
	 * makeBuildPriceDetail数据访问接口
	 */
	@Autowired	 IMakeBuildPriceDetailMapper makeBuildPriceDetailMapper;

	/**
	 * 删除一条MakeBuildPriceDetail
	 * @param id
	 */
	public void deleteMakeBuildPriceDetail(int id) throws RuntimeException {
		makeBuildPriceDetailMapper.deleteMakeBuildPriceDetail(id);
	}

	/**
	 * 新增MakeBuildPriceDetail
	 * @param makeBuildPriceDetail
	 */
	public void addMakeBuildPriceDetail(MakeBuildPriceDetail makeBuildPriceDetail) throws RuntimeException {		
		makeBuildPriceDetailMapper.addMakeBuildPriceDetail(makeBuildPriceDetail);
	}

	/**
	 * 查找一条MakeBuildPriceDetail
	 * @return MakeBuildPriceDetail
	 * @param id 主键id
	 */
	@Override
	public MakeBuildPriceDetail findMakeBuildPriceDetailById(int id) throws RuntimeException {
		return makeBuildPriceDetailMapper.findMakeBuildPriceDetailById(id);
	}


	/**
	 * 修改MakeBuildPriceDetail
	 * @param makeBuildPriceDetail
	 */
	@Override
	public void updateMakeBuildPriceDetail(MakeBuildPriceDetail makeBuildPriceDetail) throws RuntimeException {
		makeBuildPriceDetailMapper.updateMakeBuildPriceDetail(makeBuildPriceDetail);		
	}

	/**
	 * 分页查找MakeBuildPriceDetail
	 * @param cond 查询条件
	 * @return MakeBuildPriceDetail列表
	 */
	public List<MakeBuildPriceDetail> findMakeBuildPriceDetailPage(MakeBuildPriceDetailCond cond) throws RuntimeException {
		int recordCount = makeBuildPriceDetailMapper.findMakeBuildPriceDetailCount(cond);
		
		cond.recordCount = recordCount;
				
		return makeBuildPriceDetailMapper.findMakeBuildPriceDetailPage(cond);
	}

	/**
	 * 查找全部MakeBuildPriceDetail
	 * @param cond 查询条件
	 * @return MakeBuildPriceDetail列表
	 */
	public List<MakeBuildPriceDetail> findMakeBuildPriceDetail(MakeBuildPriceDetailCond cond) throws RuntimeException {
    	return makeBuildPriceDetailMapper.findMakeBuildPriceDetail(cond);
	}
}
