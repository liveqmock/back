package com.kn.data.services;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.kn.data.pojo.KN_App_User;
import com.kn.data.pojo.KN_App_User_Cond;
import com.kn.data.pojo.KN_CUGL_SSK;
import com.kn.data.pojo.KN_CWGL_YSK;
import com.kn.data.pojo.KN_DATABASES;
import com.kn.data.pojo.KN_DATABASES_Cond;
import com.kn.data.pojo.KN_KHGXGL_KH;
import com.kn.data.pojo.KN_KHGXGL_KH_Cond;
import com.kn.data.pojo.KN_LPCS_DY;
import com.kn.data.pojo.KN_LPCS_DY_Cond;
import com.kn.data.pojo.KN_LPCS_LG_OLD;
import com.kn.data.pojo.KN_LPCS_LG_OLD_Cond;
import com.kn.data.pojo.KN_LPCS_LP2;
import com.kn.data.pojo.KN_LPCS_LP2_Cond;
import com.kn.data.pojo.KN_LPCS_LP_OLD;
import com.kn.data.pojo.KN_LPCS_LP_OLD_Cond;
import com.kn.data.pojo.KN_LPCS_LT_OLD;
import com.kn.data.pojo.KN_LPCS_LT_OLD_Cond;
import com.kn.data.pojo.KN_RGS_YZ;
import com.kn.data.pojo.KN_RGS_YZ_Cond;
import com.kn.data.pojo.KN_XSGL_RGS;
import com.kn.data.pojo.KN_XSGL_RGS_Cond;
import com.kn.data.pojo.KN_XSGL_YZJL;

@Transactional 
public interface IOldDataServices {

	public List<KN_App_User> findKN_App_User(KN_App_User_Cond cond) throws RuntimeException;
	
	public List<KN_LPCS_DY> findKN_LPCS_DY(KN_LPCS_DY_Cond cond) throws RuntimeException;

	public List<KN_LPCS_LP_OLD> findKN_LPCS_LP_OLD(KN_LPCS_LP_OLD_Cond cond) throws RuntimeException;

	public List<KN_LPCS_LT_OLD> findKN_LPCS_LT_OLD(KN_LPCS_LT_OLD_Cond cond) throws RuntimeException;
	
	public List<KN_LPCS_LG_OLD> findKN_LPCS_LG_OLD(KN_LPCS_LG_OLD_Cond cond) throws RuntimeException;
	
	public List<KN_LPCS_LP2> findKN_LPCS_LP2(KN_LPCS_LP2_Cond cond)  throws RuntimeException;
	
	public List<KN_DATABASES> findKN_DATABASES(KN_DATABASES_Cond cond)  throws RuntimeException;
	
	public KN_LPCS_LP2 findKN_LPCS_LP2_byId(int id) throws RuntimeException;
	
	public KN_DATABASES findKN_DATABASES_byId(int id) throws RuntimeException;
	
	public List<KN_KHGXGL_KH> findKnKhgxglKh(KN_KHGXGL_KH_Cond cond) throws RuntimeException;
	
	public List<KN_KHGXGL_KH> findKN_KHGXGL_KH_forAddcom()throws RuntimeException;
	
	public List<KN_RGS_YZ> findKN_RGS_YZ(KN_RGS_YZ_Cond cond) throws RuntimeException;
	
	//查找4层结构的楼盘2资料
	public List<KN_LPCS_LP2> findKN_LPCS_LP2_4ceng()throws RuntimeException;
	
	//查找5层结构的楼盘2资料
	public List<KN_LPCS_LP2> findKN_LPCS_LP2_5ceng()throws RuntimeException;
	
	
	public List<KN_KHGXGL_KH> findKnKhgxglKh_quyu()throws RuntimeException;
	
	public List<KN_XSGL_RGS> findKN_XSGL_RGS(KN_XSGL_RGS_Cond cond)throws RuntimeException;
	
	public List<KN_XSGL_RGS> findKN_XSGL_RGS_HT(KN_XSGL_RGS_Cond cond) throws RuntimeException;
	
	public List<Map> findUser()throws RuntimeException;
	
	public List<Map> findKnKhgxglKh_by_zrr(String zrr)throws RuntimeException;
	
	public KN_KHGXGL_KH findKN_KHGXGL_KH_byId(int id)throws RuntimeException;
	
	public List<Map> findKN_LPCS_DY_xqmj() throws RuntimeException;
	
	public List<Map> findKN_LPCS_DY_xqjg() throws RuntimeException;
	
	public List<KN_XSGL_YZJL> findKN_XSGL_YZJL() throws RuntimeException;
	
	public List<KN_CWGL_YSK> findKN_CWGL_YSK() throws RuntimeException;
	
	public List<KN_CUGL_SSK> findKN_CUGL_SSK() throws RuntimeException;
	
	public List<Map<String, Object>> findwenjuan()throws RuntimeException;
}