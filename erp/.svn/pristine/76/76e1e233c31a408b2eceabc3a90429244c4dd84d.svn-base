package com.ihk.kn.data.services.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.kn.data.IOlddbIdlogMapper;
import com.ihk.kn.data.pojo.OlddbIdlog;
import com.ihk.kn.data.pojo.OlddbIdlogCond;
import com.ihk.kn.data.services.IOlddbIdlogServices;
import com.ihk.utils.base.PojoDeleteCond;
import com.kn.data.IKNLOG_XSGL_RGS_Mapper;
import com.kn.data.pojo.KNLOG_XSGL_RGS;

/**
 * OlddbIdlog的Services实现(业务实现)
 * 
 * @author
 * 
 */
@Service("olddbIdlogServices")
public class OlddbIdlogServices implements IOlddbIdlogServices {
	/**
	 * olddbIdlog数据访问接口
	 */
	@Autowired
	IOlddbIdlogMapper olddbIdlogMapper;
	@Autowired
	IKNLOG_XSGL_RGS_Mapper kNLOG_XSGL_RGS_Mapper;

	/**
	 * 删除一条OlddbIdlog
	 * 
	 * @param id
	 */
	public void deleteOlddbIdlog(int id) throws RuntimeException {
		olddbIdlogMapper.deleteOlddbIdlog(new PojoDeleteCond(id));
	}

	/**
	 * 新增OlddbIdlog
	 * 
	 * @param olddbIdlog
	 */
	public void addOlddbIdlog(OlddbIdlog olddbIdlog) throws RuntimeException {
		olddbIdlogMapper.addOlddbIdlog(olddbIdlog);
	}

	/**
	 * 查找一条OlddbIdlog
	 * 
	 * @return OlddbIdlog
	 * @param id
	 *            主键id
	 */
	@Override
	public OlddbIdlog findOlddbIdlogById(int id) throws RuntimeException {
		return olddbIdlogMapper.findOlddbIdlogById(id);
	}

	/**
	 * 修改OlddbIdlog
	 * 
	 * @param olddbIdlog
	 */
	@Override
	public void updateOlddbIdlog(OlddbIdlog olddbIdlog) throws RuntimeException {
		olddbIdlogMapper.updateOlddbIdlog(olddbIdlog);
	}

	/**
	 * 分页查找OlddbIdlog
	 * 
	 * @param cond
	 *            查询条件
	 * @return OlddbIdlog列表
	 */
	public List<OlddbIdlog> findOlddbIdlogPage(OlddbIdlogCond cond)
			throws RuntimeException {
		int recordCount = olddbIdlogMapper.findOlddbIdlogCount(cond);

		cond.recordCount = recordCount;

		return olddbIdlogMapper.findOlddbIdlogPage(cond);
	}

	/**
	 * 查找全部OlddbIdlog
	 * 
	 * @param cond
	 *            查询条件
	 * @return OlddbIdlog列表
	 */
	public List<OlddbIdlog> findOlddbIdlog(OlddbIdlogCond cond)
			throws RuntimeException {
		return olddbIdlogMapper.findOlddbIdlog(cond);
	}

	@Override
	public OlddbIdlog findOlddbIdlogByOldIdAndTableName(OlddbIdlogCond cond)
			throws RuntimeException {
		return olddbIdlogMapper.findOlddbIdlogByOldIdAndTableName(cond);
	}

	@Override
	public void addKNLOG_XSGL_RGS(KNLOG_XSGL_RGS knlogXsglRgs)
			throws RuntimeException {
		kNLOG_XSGL_RGS_Mapper.addKNLOG_XSGL_RGS(knlogXsglRgs);
	}

	@Override
	public List<Map<String,Integer>> findIdMapByTableName(String tableName)
			throws RuntimeException {
		// TODO Auto-generated method stub
		return olddbIdlogMapper.findIdMapByTableName(tableName);
	}

	@Override
	public List<Map> findQuestionByCustomerId(int id) throws RuntimeException {
		// TODO Auto-generated method stub
		return olddbIdlogMapper.findQuestionByCustomerId(id);
	}

}
