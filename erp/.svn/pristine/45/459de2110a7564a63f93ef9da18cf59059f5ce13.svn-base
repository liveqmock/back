package com.ihk.kn.data;

import java.util.List;
import java.util.Map;

import com.ihk.kn.data.pojo.OlddbIdlog;
import com.ihk.kn.data.pojo.OlddbIdlogCond;

import com.ihk.utils.base.PojoDeleteCond;

/**
 * OlddbIdlog数据访问接口Mapper
 * @author 
 *
 */ 
public interface IOlddbIdlogMapper {

	/**
	 * 新增OlddbIdlog
	 * @param olddbIdlog
	 */
	public void addOlddbIdlog(OlddbIdlog olddbIdlog) ;

	/**
	 * 根据条件删除OlddbIdlog
	 * @param cond 删除条件
	 */
	public void deleteOlddbIdlog(PojoDeleteCond cond) throws RuntimeException;


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
	public List<OlddbIdlog> findOlddbIdlogPage(OlddbIdlogCond cond) ;
        
	/**
	 * 查找全部OlddbIdlog
	 * @param cond 查询条件
	 * @return OlddbIdlog列表
	 */
	public List<OlddbIdlog> findOlddbIdlog(OlddbIdlogCond cond) ;
    
	/**
	 * 查找符合条件的记录条数OlddbIdlog
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findOlddbIdlogCount(OlddbIdlogCond cond) ;
	
	/**
	 * @param cond.myId 
	 * @param cond.myTable
	 * @return limit1的数据
	 */
	public OlddbIdlog findOlddbIdlogByOldIdAndTableName(OlddbIdlogCond cond) ;
	
	
	
	public List<Map<String,Integer>> findIdMapByTableName(String tableName)throws RuntimeException;
	
	
	public List<Map> findQuestionByCustomerId(int id);
	
	
	
	
	
}
