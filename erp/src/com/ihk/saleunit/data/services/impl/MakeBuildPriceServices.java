package com.ihk.saleunit.data.services.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.saleunit.data.IMakeBuildPriceMapper;
import com.ihk.saleunit.data.pojo.MakeBuildPrice;
import com.ihk.saleunit.data.pojo.MakeBuildPriceCond;
import com.ihk.saleunit.data.services.IMakeBuildPriceServices;

/**
 * MakeBuildPrice的Services实现(业务实现)
 * @author 
 *
 */
@Service("makeBuildPriceServices")
@SuppressWarnings("unchecked")
public class MakeBuildPriceServices implements IMakeBuildPriceServices {
	/**
	 * makeBuildPrice数据访问接口
	 */
	@Autowired	 IMakeBuildPriceMapper makeBuildPriceMapper;

	/**
	 * 删除一条MakeBuildPrice
	 * @param id
	 */
	public void deleteMakeBuildPrice(int id) throws RuntimeException {
		makeBuildPriceMapper.deleteMakeBuildPrice(id);
	}

	/**
	 * 新增MakeBuildPrice
	 * @param makeBuildPrice
	 */
	public void addMakeBuildPrice(MakeBuildPrice makeBuildPrice) throws RuntimeException {		
		makeBuildPriceMapper.addMakeBuildPrice(makeBuildPrice);
	}

	/**
	 * 查找一条MakeBuildPrice
	 * @return MakeBuildPrice
	 * @param id 主键id
	 */
	@Override
	public MakeBuildPrice findMakeBuildPriceById(int id) throws RuntimeException {
		return makeBuildPriceMapper.findMakeBuildPriceById(id);
	}

	/**
	 * 修改MakeBuildPrice
	 * @param makeBuildPrice
	 */
	@Override
	public void updateMakeBuildPrice(MakeBuildPrice makeBuildPrice) throws RuntimeException {
		makeBuildPriceMapper.updateMakeBuildPrice(makeBuildPrice);		
	}

	/**
	 * 分页查找MakeBuildPrice
	 * @param cond 查询条件
	 * @return MakeBuildPrice列表
	 */
	public List<MakeBuildPrice> findMakeBuildPricePage(MakeBuildPriceCond cond) throws RuntimeException {
		int recordCount = makeBuildPriceMapper.findMakeBuildPriceCount(cond);
		
		cond.recordCount = recordCount;
				
		return makeBuildPriceMapper.findMakeBuildPricePage(cond);
	}

	/**
	 * 查找全部MakeBuildPrice
	 * @param cond 查询条件
	 * @return MakeBuildPrice列表
	 */
	public List<MakeBuildPrice> findMakeBuildPrice(MakeBuildPriceCond cond) throws RuntimeException {
    	return makeBuildPriceMapper.findMakeBuildPrice(cond);
	}
}
