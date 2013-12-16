package com.ihk.saleunit.data.services.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.saleunit.data.IChipMapper;
import com.ihk.saleunit.data.pojo.Chip;
import com.ihk.saleunit.data.pojo.ChipCond;
import com.ihk.saleunit.data.services.IChipServices;
import com.ihk.utils.base.PojoDeleteCond;
import com.ihk.utils.chip.ChipManagerUtils;
import com.ihk.utils.contract.sale.SaleUtils;

/**
 * Chip的Services实现(业务实现)
 * @author 
 *
 */
@Service("chipServices")
public class ChipServices implements IChipServices {
	/**
	 * chip数据访问接口
	 */
	@Autowired	 IChipMapper chipMapper;

	/**
	 * 删除一条Chip
	 * @param id
	 */
	public void deleteChip(int id) throws RuntimeException {
		chipMapper.deleteChip(new PojoDeleteCond(id));
	}

	/**
	 * 新增Chip
	 * @param chip
	 */
	public void addChip(Chip chip) throws RuntimeException {		
		
		//sman,2013.5.23为salesId前后都加上,
		chip = SaleUtils.initSalesId(chip);
		
		//sman,2013.7.13增加ContractSalesman
		SaleUtils.addContractSalesman(chip);
		
		chipMapper.addChip(chip);
		
		//增加记录
		ChipManagerUtils.addChipUnitOperRecord(chip);
	}

	/**
	 * 查找一条Chip
	 * @return Chip
	 * @param id 主键id
	 */
	@Override
	public Chip findChipById(int id) throws RuntimeException {
		return chipMapper.findChipById(id);
	}

	/**
	 * 修改Chip
	 * @param chip
	 */
	@Override
	public void updateChip(Chip chip) throws RuntimeException {
		
		//sman,2013.5.23为salesId前后都加上,
		chip = SaleUtils.initSalesId(chip);
		
		chipMapper.updateChip(chip);
		
		//sman,2013.8.1增加ContractSalesman,要放到新增后面,要不拿不到对应的主键id
		SaleUtils.updateContractSalesman(chip);
	}

	/**
	 * 分页查找Chip
	 * @param cond 查询条件
	 * @return Chip列表
	 */
	public List<Chip> findChipPage(ChipCond cond) throws RuntimeException {
		int recordCount = chipMapper.findChipCount(cond);
		
		cond.recordCount = recordCount;
				
		return chipMapper.findChipPage(cond);
	}

	/**
	 * 查找全部Chip
	 * @param cond 查询条件
	 * @return Chip列表
	 */
	public List<Chip> findChip(ChipCond cond) throws RuntimeException {
    	return chipMapper.findChip(cond);
	}

	/**
	 * 根据unitId与chipNo查找
	 */
	@Override
	public List<Chip> findChipByUnitIdAndChipNo(int unitId, int chipNo)
			throws RuntimeException {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("unitId", unitId);
		map.put("chipNo", chipNo);
		
		return chipMapper.findChipByUnitIdAndChipNo(map);
	}

	/**
	 * 查找最大认筹号
	 */
	@Override
	public Chip findMaxNoChip() throws RuntimeException {
		
		return chipMapper.findMaxNoChip();
	}

	@Override
	public List<Chip> findChipByPropertyProjectId(int propertyProjectId)
			throws RuntimeException {
		
		return chipMapper.findChipByPropertyProjectId(propertyProjectId);
	}

	@Override
	public void disabledChip(int id) throws RuntimeException {
		
		chipMapper.disabledChip(new PojoDeleteCond(id));
	}
}
