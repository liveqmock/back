package com.kn.data;

import java.util.List;
import java.util.Map;

import com.kn.data.pojo.KN_LPCS_DY;
import com.kn.data.pojo.KN_LPCS_DY_Cond;

/**
 * 楼盘初始_单元 
 * @author 
 *
 */ 
public interface IKN_LPCS_DY_Mapper {


	public List<KN_LPCS_DY> findKN_LPCS_DY(KN_LPCS_DY_Cond cond) ;
	
	public List<Map> findKN_LPCS_DY_xqmj() ;
	
	public List<Map> findKN_LPCS_DY_xqjg() ;
	
	
}
