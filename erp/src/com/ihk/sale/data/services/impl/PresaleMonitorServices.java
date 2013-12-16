package com.ihk.sale.data.services.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.sale.data.IPresaleMonitorMapper;
import com.ihk.sale.data.pojo.PresaleMonitor;
import com.ihk.sale.data.pojo.PresaleMonitorCond;
import com.ihk.sale.data.services.IPresaleMonitorServices;

/**
 * PresaleMonitor的Services实现(业务实现)
 * @author 
 *
 */
@Service("presaleMonitorServices")
@SuppressWarnings("unchecked")
public class PresaleMonitorServices implements IPresaleMonitorServices {

	/**
	 * presaleMonitor数据访问接口
	 */
	@Autowired	 IPresaleMonitorMapper presaleMonitorMapper;
	
	/**
	 * 判断是否该日期已经有数据
	 */
	@Override
	public boolean valDate(PresaleMonitor pre){
		//找到数据就是t 没找到就是false
//		System.out.println(this.findPresaleMonitorByMonitorDate(pre));
		if(this.findPresaleMonitorByMonitorDate(pre) == 0 ){
			return false;
		}
		return true;
	}

	/**
	 * 删除一条PresaleMonitor
	 * @param id
	 */
	public void deletePresaleMonitor(int id) throws RuntimeException {
		PresaleMonitor pre = presaleMonitorMapper.findPresaleMonitorById(id);
		presaleMonitorMapper.intentionAll_del(pre);
		presaleMonitorMapper.deletePresaleMonitor(id);
	}

	/**
	 * 新增PresaleMonitor
	 * @param presaleMonitor
	 */
	public void addPresaleMonitor(PresaleMonitor presaleMonitor) throws RuntimeException {	
		PresaleMonitor temp = presaleMonitorMapper.intentionAll_select(presaleMonitor);
		if(temp == null){
			presaleMonitor.setIntentionAll(presaleMonitor.getIntentionNum());
		}else{
			presaleMonitor.setIntentionAll(temp.getIntentionAll() + presaleMonitor.getIntentionNum());
			
		}	
		presaleMonitorMapper.addPresaleMonitor(presaleMonitor);
		presaleMonitorMapper.intentionAll_add(presaleMonitor);
	}

	/**
	 * 查找一条PresaleMonitor
	 * @return PresaleMonitor
	 * @param id 主键id
	 */
	@Override
	public PresaleMonitor findPresaleMonitorById(int id) throws RuntimeException {
		return presaleMonitorMapper.findPresaleMonitorById(id);
	}

	/**
	 * 修改PresaleMonitor
	 * @param presaleMonitor
	 */
	@Override
	public void updatePresaleMonitor(PresaleMonitor presaleMonitor) throws RuntimeException {
		PresaleMonitor temp = presaleMonitorMapper.findPresaleMonitorById(presaleMonitor.getId());
		presaleMonitorMapper.intentionAll_del(temp);
		presaleMonitorMapper.intentionAll_add(presaleMonitor);
		presaleMonitor.setIntentionAll(temp.getIntentionAll() + presaleMonitor.getIntentionNum() - temp.getIntentionNum() );
		presaleMonitorMapper.updatePresaleMonitor(presaleMonitor);		
	}

	/**
	 * 分页查找PresaleMonitor
	 * @param cond 查询条件
	 * @return PresaleMonitor列表
	 */
	public List findPresaleMonitorPage(PresaleMonitorCond cond) throws RuntimeException {
		int recordCount = presaleMonitorMapper.findPresaleMonitorCount(cond);
		
		cond.recordCount = recordCount;
				
		return presaleMonitorMapper.findPresaleMonitorPage(cond);
	}

	/**
	 * 符合条件的记录数
	 */
	@Override
	public int findPresaleMonitorCount(PresaleMonitorCond cond) {
		return presaleMonitorMapper.findPresaleMonitorCount(cond);
	}

	/**
	 * 根据日期查找
	 */
	@Override
	public int findPresaleMonitorByMonitorDate(PresaleMonitor pre) {
		return presaleMonitorMapper.findPresaleMonitorByMonitorDate(pre);
	}
}
