package com.kn.data.services.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kn.data.IKN_CUGL_SSK_Mapper;
import com.kn.data.IKN_CWGL_YSK_Mapper;
import com.kn.data.IKN_DATABASES_Mapper;
import com.kn.data.IKN_KHGXGL_KH_Mapper;
import com.kn.data.IKN_LPCS_DY_Mapper;
import com.kn.data.IKN_LPCS_LG_OLD_Mapper;
import com.kn.data.IKN_LPCS_LP2_Mapper;
import com.kn.data.IKN_LPCS_LP_OLD_Mapper;
import com.kn.data.IKN_LPCS_LT_OLD_Mapper;
import com.kn.data.IKN_RGS_YZ_Mapper;
import com.kn.data.IKN_XSGL_RGS_Mapper;
import com.kn.data.IKN_XSGL_YZJL_Mapper;
import com.kn.data.IOldDataMapper;
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
import com.kn.data.services.IOldDataServices;

@Service("oldDataServices")
public class OldDataServices implements IOldDataServices {

	@Autowired	 IOldDataMapper oldDataMapper;
	@Autowired	 IKN_LPCS_DY_Mapper kN_LPCS_DY_Mapper;
	@Autowired	 IKN_LPCS_LP_OLD_Mapper kN_LPCS_LP_OLD_Mapper;
	@Autowired	 IKN_LPCS_LT_OLD_Mapper kN_LPCS_LT_OLD_Mapper;
	@Autowired	 IKN_LPCS_LG_OLD_Mapper kN_LPCS_LG_OLD_Mapper;
	@Autowired	 IKN_LPCS_LP2_Mapper kN_LPCS_LP2_Mapper;
	@Autowired	 IKN_DATABASES_Mapper kN_DATABASES_Mapper;
	@Autowired	 IKN_KHGXGL_KH_Mapper kN_KHGXGL_KH_Mapper;
	@Autowired   IKN_RGS_YZ_Mapper  kN_RGS_YZ_Mapper;//放些额外的查询
	@Autowired   IKN_XSGL_YZJL_Mapper  kN_XSGL_YZJL_Mapper;//放些额外的查询
	@Autowired     IKN_CWGL_YSK_Mapper kN_CWGL_YSK_Mapper;
	@Autowired     IKN_CUGL_SSK_Mapper kN_CUGL_SSK_Mapper;
	
	@Autowired   IKN_XSGL_RGS_Mapper  kN_XSGL_RGS_Mapper ;
	public List<KN_App_User> findKN_App_User(KN_App_User_Cond cond) throws RuntimeException {
    	return oldDataMapper.findKN_App_User(cond);
	}


	@Override
	public List<KN_LPCS_DY> findKN_LPCS_DY(KN_LPCS_DY_Cond cond) throws RuntimeException {
		return kN_LPCS_DY_Mapper.findKN_LPCS_DY(cond);
	}

	@Override
	public List<KN_LPCS_LP_OLD> findKN_LPCS_LP_OLD(KN_LPCS_LP_OLD_Cond cond) throws RuntimeException {
		return kN_LPCS_LP_OLD_Mapper.findKN_LPCS_LP_OLD(cond);
	}


	@Override
	public List<KN_LPCS_LT_OLD> findKN_LPCS_LT_OLD(KN_LPCS_LT_OLD_Cond cond) throws RuntimeException {
		return kN_LPCS_LT_OLD_Mapper.findKN_LPCS_LT_OLD(cond);
	}


	@Override
	public List<KN_LPCS_LG_OLD> findKN_LPCS_LG_OLD(KN_LPCS_LG_OLD_Cond cond)
			throws RuntimeException {
		return  kN_LPCS_LG_OLD_Mapper.findKN_LPCS_LG_OLD(cond);
	}


	@Override
	public List<KN_LPCS_LP2> findKN_LPCS_LP2(KN_LPCS_LP2_Cond cond)
			throws RuntimeException {
		return kN_LPCS_LP2_Mapper.findKN_LPCS_LP2(cond);
	}


	@Override
	public List<KN_DATABASES> findKN_DATABASES(KN_DATABASES_Cond cond)
			throws RuntimeException {
		return kN_DATABASES_Mapper.findKN_DATABASES(cond);
	}


	@Override
	public KN_LPCS_LP2 findKN_LPCS_LP2_byId(int id) throws RuntimeException {
		return kN_LPCS_LP2_Mapper.findKN_LPCS_LP2_byId(id);
	}


	@Override
	public KN_DATABASES findKN_DATABASES_byId(int id) throws RuntimeException {
		return kN_DATABASES_Mapper.findKN_DATABASES_byId(id);
	}


	@Override
	public List<KN_KHGXGL_KH> findKnKhgxglKh(KN_KHGXGL_KH_Cond cond)
			throws RuntimeException {
		return kN_KHGXGL_KH_Mapper.findKnKhgxglKh(cond);
	}


	@Override
	public List<KN_RGS_YZ> findKN_RGS_YZ(KN_RGS_YZ_Cond cond)
			throws RuntimeException {
		return kN_RGS_YZ_Mapper.findKN_RGS_YZ(cond);
	}


	@Override
	public List<KN_LPCS_LP2> findKN_LPCS_LP2_4ceng() throws RuntimeException {
		return kN_LPCS_LP2_Mapper.findKN_LPCS_LP2_4ceng();
	}


	@Override
	public List<KN_LPCS_LP2> findKN_LPCS_LP2_5ceng() throws RuntimeException {
		return kN_LPCS_LP2_Mapper.findKN_LPCS_LP2_5ceng();
	}


	@Override
	public List<KN_KHGXGL_KH> findKnKhgxglKh_quyu() throws RuntimeException {
		return kN_KHGXGL_KH_Mapper.findKnKhgxglKh_quyu();
	}


	@Override
	public List<KN_XSGL_RGS> findKN_XSGL_RGS(KN_XSGL_RGS_Cond cond)
			throws RuntimeException {
		return kN_XSGL_RGS_Mapper.findKN_XSGL_RGS(cond);
	}


	@Override
	public List<KN_XSGL_RGS> findKN_XSGL_RGS_HT(KN_XSGL_RGS_Cond cond)
			throws RuntimeException {
		return kN_XSGL_RGS_Mapper.findKN_XSGL_RGS_HT(cond);
	}


	@Override
	public List<Map> findUser() throws RuntimeException {
		return kN_RGS_YZ_Mapper.findUser();
	}


	@Override
	public List<Map> findKnKhgxglKh_by_zrr(String zrr)
			throws RuntimeException {
		return kN_KHGXGL_KH_Mapper.findKnKhgxglKh_by_zrr(zrr);
	}


	@Override
	public KN_KHGXGL_KH findKN_KHGXGL_KH_byId(int id) throws RuntimeException {
		// TODO Auto-generated method stub
		return kN_KHGXGL_KH_Mapper.findKN_KHGXGL_KH_byId(id);
	}


	@Override
	public List<KN_KHGXGL_KH> findKN_KHGXGL_KH_forAddcom()
			throws RuntimeException {
		return kN_KHGXGL_KH_Mapper.findKN_KHGXGL_KH_forAddcom();
	}


	@Override
	public List<Map> findKN_LPCS_DY_xqmj() throws RuntimeException {
		return kN_LPCS_DY_Mapper.findKN_LPCS_DY_xqmj();
	}


	@Override
	public List<Map> findKN_LPCS_DY_xqjg() throws RuntimeException {
		// TODO Auto-generated method stub
		return kN_LPCS_DY_Mapper.findKN_LPCS_DY_xqjg();
	}


	@Override
	public List<KN_XSGL_YZJL> findKN_XSGL_YZJL() throws RuntimeException {
		return kN_XSGL_YZJL_Mapper.findKN_XSGL_YZJL();
	}


	@Override
	public List<KN_CWGL_YSK> findKN_CWGL_YSK() throws RuntimeException {
		// TODO Auto-generated method stub
		return kN_CWGL_YSK_Mapper.findKN_CWGL_YSK();
	}


	@Override
	public List<KN_CUGL_SSK> findKN_CUGL_SSK() throws RuntimeException {
		return kN_CUGL_SSK_Mapper.findKN_CUGL_SSK();
	}


	@Override
	public List<Map<String,Object>> findwenjuan() throws RuntimeException {
		return kN_KHGXGL_KH_Mapper.findwenjuan();
	}


}
