package com.ihk.user.data;

import java.util.List;

import com.ihk.user.data.pojo.InputMemory;
import com.ihk.user.data.pojo.InputMemoryCond;

/**
 * InputMemory数据访问接口Mapper
 * @author 
 *
 */ 
public interface IInputMemoryMapper {

	/**
	 * 新增InputMemory
	 * @param inputMemory
	 */
	public void addInputMemory(InputMemory inputMemory) ;

	/**
	 * 根据条件删除InputMemory
	 * @param cond 删除条件
	 */
	public void deleteInputMemory(int id) throws RuntimeException;

	/**
	 * 修改InputMemory
	 * @param inputMemory
	 */
	public void updateInputMemory(InputMemory inputMemory) throws RuntimeException;

	/**
	 * 查找一条InputMemory
	 * @return InputMemory
	 * @param id 主键id
	 */
	public InputMemory findInputMemoryById(int id) throws RuntimeException;

	/**
	 * 分页查找InputMemory
	 * @param cond 查询条件
	 * @return InputMemory列表
	 */
	public List<InputMemory> findInputMemoryPage(InputMemoryCond cond) ;

	/**
	 * 查找全部InputMemory
	 * @param cond 查询条件
	 * @return InputMemory列表
	 */
	public List<InputMemory> findInputMemory(InputMemoryCond cond) ;

	/**
	 * 查找符合条件的记录条数InputMemory
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findInputMemoryCount(InputMemoryCond cond) ;
	
	/**
	 * 查找最近的录入记录
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public InputMemory findInputMemoryForNew(InputMemoryCond cond) throws RuntimeException;  //获取最后的录入记录
}
