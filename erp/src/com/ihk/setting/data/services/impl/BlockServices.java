package com.ihk.setting.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.setting.data.IBlockMapper;
import com.ihk.setting.data.pojo.Block;
import com.ihk.setting.data.pojo.BlockCond;
import com.ihk.setting.data.services.IBlockServices;

/**
 * Block的Services实现(业务实现)
 * @author 
 *
 */
@Service("blockServices")
public class BlockServices implements IBlockServices {
	/**
	 * block数据访问接口
	 */
	@Autowired	 IBlockMapper blockMapper;

	/**
	 * 删除一条Block
	 * @param id
	 */
	public void deleteBlock(int id) throws RuntimeException {
		blockMapper.deleteBlock(id);
	}

	/**
	 * 新增Block
	 * @param block
	 */
	public void addBlock(Block block) throws RuntimeException {		
		blockMapper.addBlock(block);
	}

	/**
	 * 查找一条Block
	 * @return Block
	 * @param id 主键id
	 */
	@Override
	public Block findBlockById(int id) throws RuntimeException {
		return blockMapper.findBlockById(id);
	}

	/**
	 * 修改Block
	 * @param block
	 */
	@Override
	public void updateBlock(Block block) throws RuntimeException {
		blockMapper.updateBlock(block);		
	}

	/**
	 * 分页查找Block
	 * @param cond 查询条件
	 * @return Block列表
	 */
	public List<Block> findBlockPage(BlockCond cond) throws RuntimeException {
		int recordCount = blockMapper.findBlockCount(cond);
		
		cond.recordCount = recordCount;
				
		return blockMapper.findBlockPage(cond);
	}

	/**
	 * 查找全部Block
	 * @param cond 查询条件
	 * @return Block列表
	 */
	public List<Block> findBlock(BlockCond cond) throws RuntimeException {
    	return blockMapper.findBlock(cond);
	}

	/**
	 * 根据项目id与区域查找
	 */
	@Override
	public List<Block> findBlockByRegionIdAndProjectId(BlockCond cond) throws Exception {
		return blockMapper.findBlockByRegionIdAndProjectId(cond);
	}
}
