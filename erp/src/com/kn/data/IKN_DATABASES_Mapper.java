package com.kn.data;

import java.util.List;

import com.kn.data.pojo.KN_DATABASES;
import com.kn.data.pojo.KN_DATABASES_Cond;

/**
 * 楼盘初始_单元 
 * @author 
 *
 */ 
public interface IKN_DATABASES_Mapper {

	public List<KN_DATABASES> findKN_DATABASES(KN_DATABASES_Cond cond) ;
	
	public KN_DATABASES findKN_DATABASES_byId(int id) ;
	
}
