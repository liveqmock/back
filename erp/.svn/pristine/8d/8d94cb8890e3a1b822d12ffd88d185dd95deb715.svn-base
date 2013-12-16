package com.ihk.kn.data.services;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.kn.data.pojo.OlddbIdlog;
import com.ihk.kn.data.pojo.OlddbIdlogCond;
import com.kn.data.pojo.KNLOG_XSGL_RGS;

/**
 * OlddbIdlog的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
@SuppressWarnings("unchecked")
public interface IOlddbIdlogServices {

	/**
	 * 新增OlddbIdlog
	 * @param olddbIdlog
	 */
	public void addOlddbIdlog(OlddbIdlog olddbIdlog) throws RuntimeException;

	/**
	 * 删除一条OlddbIdlog
	 * @param id
	 */
	public void deleteOlddbIdlog(int id) throws RuntimeException;

	/**
	 * 修改OlddbIdlog
	 * @param olddbIdlog
	 */
	public void updateOlddbIdlog(OlddbIdlog olddbIdlog) throws RuntimeException;

	/**
	 * 查找一条OlddbIdlog
	 * @return OlddbIdlog
	 * @param id 主键id
	 */
	public OlddbIdlog findOlddbIdlogById(int id) throws RuntimeException;
    
	/**
	 * 分页查找OlddbIdlog
	 * @param cond 查询条件
	 * @return OlddbIdlog列表
	 */
	public List<OlddbIdlog> findOlddbIdlogPage(OlddbIdlogCond cond) throws RuntimeException;
    
	/**
	 * 查找全部OlddbIdlog
	 * @param cond 查询条件
	 * @return OlddbIdlog列表
	 */
	public List<OlddbIdlog> findOlddbIdlog(OlddbIdlogCond cond) throws RuntimeException;
	
	/**
	 * @param cond.myId 
	 * @param cond.myTable
	 * @return limit1的数据
	 */
	public OlddbIdlog findOlddbIdlogByOldIdAndTableName(OlddbIdlogCond cond) throws RuntimeException;
	
	
	public void addKNLOG_XSGL_RGS(KNLOG_XSGL_RGS knlog_xsgl_rgs) throws RuntimeException;
	
	
	
	public List<Map<String, Integer>> findIdMapByTableName(String tableName)throws RuntimeException;
	
	
	
	public List<Map> findQuestionByCustomerId(int id)throws RuntimeException;
	
	
	
	
	
	
	
	
	
	
	
	
	
}