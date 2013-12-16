package com.kn.data;

import java.util.List;

import com.kn.data.pojo.KN_App_User;
import com.kn.data.pojo.KN_App_User_Cond;
import com.kn.data.pojo.KN_LPCS_DY;
import com.kn.data.pojo.KN_LPCS_DY_Cond;
import com.kn.data.pojo.KN_LPCS_LP_OLD;
import com.kn.data.pojo.KN_LPCS_LP_OLD_Cond;
import com.kn.data.pojo.KN_LPCS_LT_OLD;
import com.kn.data.pojo.KN_LPCS_LT_OLD_Cond;

/**
 * 楼盘初始_楼梯_OLD 
 * @author 
 *
 */ 
public interface IKN_LPCS_LT_OLD_Mapper {


	public List<KN_LPCS_LT_OLD> findKN_LPCS_LT_OLD(KN_LPCS_LT_OLD_Cond cond) ;
}
