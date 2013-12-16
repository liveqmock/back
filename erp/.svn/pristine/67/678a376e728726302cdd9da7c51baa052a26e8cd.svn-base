package com.ihk.setting.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.setting.data.pojo.Block;
import com.ihk.setting.data.pojo.BlockCond;

/**
 * Block的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
public interface IBlockServices {
	/**
	 * 新增Block
	 * @param block
	 */
	public void addBlock(Block block) throws RuntimeException;

	/**
	 * 删除一条Block
	 * @param id
	 */
	public void deleteBlock(int id) throws RuntimeException;

	/**
	 * 修改Block
	 * @param block
	 */
	public void updateBlock(Block block) throws RuntimeException;

	/**
	 * 查找一条Block
	 * @return Block
	 * @param id 主键id
	 */
	public Block findBlockById(int id) throws RuntimeException;

	/**
	 * 分页查找Block
	 * @param cond 查询条件
	 * @return Block列表
	 */
	public List<Block> findBlockPage(BlockCond cond) throws RuntimeException;

	/**
	 * 查找全部Block
	 * @param cond 查询条件
	 * @return Block列表
	 */
	public List<Block> findBlock(BlockCond cond) throws RuntimeException;
	
	/**
	 * 根据RegionIdAndProjectId查找
	 * @param cond
	 * @return
	 * @throws Exception
	 */
	public List<Block> findBlockByRegionIdAndProjectId(BlockCond cond) throws Exception;  //根据project id和region id获取板块list
}