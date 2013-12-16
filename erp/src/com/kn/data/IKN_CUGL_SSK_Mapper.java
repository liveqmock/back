package com.kn.data;

import java.util.List;

import com.kn.data.pojo.KN_CUGL_SSK;
import com.kn.data.pojo.KN_CUGL_SSK_Cond;

/**
 * KN_CUGL_SSK数据访问接口Mapper
 * @author 
 *
 */ 
public interface IKN_CUGL_SSK_Mapper {

	/**
	 * 查找全部KN_CUGL_SSK
	 * @param cond 查询条件
	 * @return KN_CUGL_SSK列表
	 */
	public List<KN_CUGL_SSK> findKN_CUGL_SSK() ;
    

}
