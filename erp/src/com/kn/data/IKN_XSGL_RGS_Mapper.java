package com.kn.data;

import java.util.List;

import com.kn.data.pojo.KN_XSGL_RGS;
import com.kn.data.pojo.KN_XSGL_RGS_Cond;

/**
 * 销售管理_认购书
 * @author 
 *
 */ 
public interface IKN_XSGL_RGS_Mapper {

	public List<KN_XSGL_RGS> findKN_XSGL_RGS(KN_XSGL_RGS_Cond cond) ;
	
	public List<KN_XSGL_RGS> findKN_XSGL_RGS_HT(KN_XSGL_RGS_Cond cond) ;
	
}
