package com.ihk.user.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.user.data.pojo.InputMemory;
import com.ihk.user.data.pojo.InputMemoryCond;

/**
 * InputMemory的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
public interface IInputMemoryServices {
	/**
	 * 新增InputMemory
	 * @param inputMemory
	 */
	public void addInputMemory(InputMemory inputMemory) throws RuntimeException;

	/**
	 * 删除一条InputMemory
	 * @param id
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
	public List<InputMemory> findInputMemoryPage(InputMemoryCond cond) throws RuntimeException;

	/**
	 * 查找全部InputMemory
	 * @param cond 查询条件
	 * @return InputMemory列表
	 */
	public List<InputMemory> findInputMemory(InputMemoryCond cond) throws RuntimeException;
	
	/**
	 * 查找最新的录入
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public InputMemory findInputMemoryForNew(InputMemoryCond cond) throws RuntimeException;  //获取最后的录入记录
}