package com.ihk.setting.data;

import java.util.List;

import com.ihk.setting.data.pojo.Block;
import com.ihk.setting.data.pojo.BlockCond;

/**
 * Block数据访问接口Mapper
 * @author 
 *
 */ 
public interface IBlockMapper {

	/**
	 * 新增Block
	 * @param block
	 */
	public void addBlock(Block block) ;

	/**
	 * 根据条件删除Block
	 * @param cond 删除条件
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
	public List<Block> findBlockPage(BlockCond cond) ;

	/**
	 * 查找全部Block
	 * @param cond 查询条件
	 * @return Block列表
	 */
	public List<Block> findBlock(BlockCond cond) ;

	/**
	 * 查找符合条件的记录条数Block
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findBlockCount(BlockCond cond) ;
	
	/**
	 * 根据区域与ProjectId查找
	 * @param cond
	 * @return
	 * @throws Exception
	 */
	public List<Block> findBlockByRegionIdAndProjectId(BlockCond cond) throws Exception;
}
