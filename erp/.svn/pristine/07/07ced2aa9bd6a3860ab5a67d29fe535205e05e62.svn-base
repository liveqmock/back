package com.ihk.sale.data.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.sale.data.ISaleMonitorLogMapper;
import com.ihk.sale.data.ISaleMonitorLogbeforeMapper;
import com.ihk.sale.data.ISaleMonitorMapper;
import com.ihk.sale.data.pojo.SaleMonitor;
import com.ihk.sale.data.pojo.SaleMonitorCond;
import com.ihk.sale.data.pojo.SaleMonitorLog;
import com.ihk.sale.data.pojo.SaleMonitorLogbefore;
import com.ihk.sale.data.pojo.SaleMonitorLogbeforeCond;
import com.ihk.sale.data.services.ISaleMonitorServices;
import com.ihk.utils.CacheFrontName;
import com.ihk.utils.CacheUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.DateTimeUtils;
import com.ihk.utils.MyTransationTemplate;

/**
 * SaleMonitor的Services实现(业务实现)
 * @author 
 *
 */
@Service("saleMonitorServices")
public class SaleMonitorServices implements ISaleMonitorServices {

	/**
	 * saleMonitor数据访问接口
	 */
	@Autowired	 ISaleMonitorMapper saleMonitorMapper;
	//@Autowired   SaleMonitorLogServices saleMonitorLogServices;
	//@Autowired   SaleMonitorLogbeforeServices saleMonitorLogbeforeServices;
	
	@Autowired ISaleMonitorLogMapper saleMonitorLogMapper;
	@Autowired ISaleMonitorLogbeforeMapper saleMonitorLogbeforeMapper;
	
	private static final Logger logger = Logger.getLogger(SaleMonitorServices.class);

	/**
	 * 删除一条SaleMonitor
	 * @param id
	 */
	public void deleteSaleMonitor(int id) throws RuntimeException {
		saleMonitorMapper.deleteSaleMonitor(id);
	}

	/**
	 * 新增SaleMonitor
	 * @param saleMonitor
	 */
	public void addSaleMonitor(SaleMonitor saleMonitor) throws RuntimeException {
		/*
		SaleMonitorCond cond = new SaleMonitorCond();
		cond.setMonitorDate(saleMonitor.getMonitorDate()+"");
		cond.setProjectId(SessionUser.getProjectId());
	
		boolean isExists;
		try {
			isExists = this.findMonitorDateIsExistsByProject(cond);
		} catch (Exception e) {
			e.printStackTrace();
			return ;
		}
		if(isExists){
			return ;
		}
		*/
		saleMonitorMapper.addSaleMonitor(saleMonitor);
	}


	/**
	 * 管理员,新增
	 */
	@Override
	public void addSaleMonitorForAdmin(SaleMonitor saleMonitor)
			throws RuntimeException {
		
		saleMonitorMapper.addSaleMonitor(saleMonitor);
	}


	/**
	 * 查找一条SaleMonitor
	 * @return SaleMonitor
	 * @param id 主键id
	 */
	@Override
	public SaleMonitor findSaleMonitorById(int id) throws RuntimeException {
		return saleMonitorMapper.findSaleMonitorById(id);
	}

	/**
	 * 修改SaleMonitor
	 * @param saleMonitor
	 */
	@Override
	public void updateSaleMonitor(final SaleMonitor oldSaleMonitor,final SaleMonitor saleMonitor) throws RuntimeException {
		final SaleMonitorLog log = new SaleMonitorLog();
		final SaleMonitorLogbefore logbefore = new SaleMonitorLogbefore();
		BeanUtils.copyProperties(oldSaleMonitor, log);
		//把原来的数据保存在salemonitorlog 如果修改的时间超过1天 把修改信息保存到salemonitorbefor 
		log.setDataId(saleMonitor.getId());
		log.setId(0);
		final boolean isOneDayLater = CommonUtils.isOneDayLater(saleMonitor.getCreatedTime(), new Date()); //判断是否超过24h
		
		
		try {
			new MyTransationTemplate() {
				
				@Override
				protected void doExecuteCallback() throws Exception {
					if(isOneDayLater){
						logbefore.setDataId(saleMonitor.getId());
						logbefore.setModTime(new Date());
						logbefore.setIsRunPlan(CommonUtils.NORMAL);
						
						//saleMonitorLogbeforeServices.addSaleMonitorLogbefore(logbefore);
						saleMonitorLogbeforeMapper.addSaleMonitorLogbefore(logbefore);
					}		
					//saleMonitorLogServices.addSaleMonitorLog(log);
					saleMonitorLogMapper.addSaleMonitorLog(log);
					saleMonitorMapper.updateSaleMonitor(saleMonitor);	
					
				}
			}.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}

	/**
	 * 分页查找SaleMonitor
	 * @param cond 查询条件
	 * @return SaleMonitor列表
	 */
	@SuppressWarnings("unchecked")
	public List<SaleMonitor> findSaleMonitorPage(SaleMonitorCond cond) throws RuntimeException {
		
		int recordCount = 0;
		List<SaleMonitor> retList = new ArrayList<SaleMonitor>();
		
		// recordCount
		String countCacheName = CacheFrontName.SALE_MONITOR + "findSaleMonitorCount";
		String key = CacheUtils.getCacheKey(CacheUtils.condToString(cond));
		
		Object countObj = CacheUtils.getValueByCacheNameAndKey(countCacheName, key);
		if(countObj == null){
			
			recordCount = saleMonitorMapper.findSaleMonitorCount(cond);  //正常流程的返回值
			CacheUtils.put(countCacheName, key, recordCount);
			
		}else{
			
			recordCount = (Integer) countObj;
		}
		
		cond.recordCount = recordCount;
		
		// retList
		String listCacheName = CacheFrontName.SALE_MONITOR + "findSaleMonitorPage";
		
		Object listObj = CacheUtils.getValueByCacheNameAndKey(listCacheName, key);
		if(listObj == null){
			
			retList = saleMonitorMapper.findSaleMonitorPage(cond);  //正常流程的返回值
			CacheUtils.put(listCacheName, key, retList);
			
		}else{
			
			retList = (List<SaleMonitor>) listObj;
		}
		
		return retList;
		
		/*
		int recordCount = saleMonitorMapper.findSaleMonitorCount(cond);
		
		cond.recordCount = recordCount;
				
		return saleMonitorMapper.findSaleMonitorPage(cond);
		*/
		
	}

	/**
	 * 根据项目,查找数据是否已经存在
	 */
	@Override
	public boolean findMonitorDateIsExistsByProject(SaleMonitorCond cond) throws Exception {
		
		List<SaleMonitor> saleList = saleMonitorMapper.findMonitorDateIsExistsByProject(cond);
		
		return saleList.isEmpty() ? false : true;
	}


	/**
	 * 查找全部SaleMonitor
	 * @param cond 查询条件
	 * @return SaleMonitor列表
	 */
	@Override
	public List<SaleMonitor> findSaleMonitor(SaleMonitorCond cond)
			throws RuntimeException {
		return saleMonitorMapper.findSaleMonitor(cond);
	}

	/**
	 * 查找项目
	 */
	@Override
	public List<Map<String, Integer>> findProject() {
		return saleMonitorMapper.findProject();
	}

	/**
	 * 根据日期查找
	 */
	@Override
	public SaleMonitor findSaleMonitorForSearchTime(SaleMonitorCond cond)
			throws Exception {
		//追加权限限制
		cond.addPermissionProjectIds();
		return saleMonitorMapper.findSaleMonitorForSearchTime(cond);
	}

	/**
	 * 如果存在,则查找出来
	 */
	@Override
	public SaleMonitor findMonitorDateIsExists(SaleMonitorCond cond) {
		List<SaleMonitor> saleList = saleMonitorMapper.findMonitorDateIsExistsByProject(cond);
		
		return saleList.isEmpty() ? null : saleList.get(0);
	}

	/**
	 * 查找
	 */
	@Override
	public List<SaleMonitor> findSaleMonitorList(SaleMonitorCond cond) {
		return saleMonitorMapper.findSaleMonitorList(cond);
	}

	/**
	 * 查找,根据项目,日期分组
	 */
	@Override
	public List<SaleMonitor> findSaleMonitorGroupbyProjectDate(SaleMonitorCond cond)
			throws RuntimeException {
		return saleMonitorMapper.findSaleMonitorGroupbyProjectDate( cond);
	}
	
	/**
	 * 查找,根据公司,日期分组
	 */
	@Override
	public List<SaleMonitor> findSaleMonitorGroupbyCompanyDate(SaleMonitorCond cond)
			throws RuntimeException {
		return saleMonitorMapper.findSaleMonitorGroupbyCompanyDate( cond);
	}
	
	/**
	 * 查找,根据全国,日期分组
	 */
	@Override
	public List<SaleMonitor> findSaleMonitorGroupbyCountryDate(SaleMonitorCond cond)
			throws RuntimeException {
		return saleMonitorMapper.findSaleMonitorGroupbyCountryDate( cond);
	}
	
	/**
	 * 分组显示
	 * flagKey[week_company,week_country,month_company,month_country]
	 */
	private List<SaleMonitor> getGroupBy(List<SaleMonitor> list,String flagKey){
		Map<String,SaleMonitor> map = new HashMap(); 
		for (int i=0;i<list.size(); i++) {
			SaleMonitor sInList = list.get(i);
			String key = "";
			String keyDate = "";
			if(flagKey.equals("week_project")){//每周,项目
				keyDate = DateTimeUtils.getMondayStr(sInList.getMonitorDateString()); 
				key = keyDate +"."+sInList.getProjectId();
			}
			else if(flagKey.equals("week_company")){//每周,公司(区域)
				keyDate = DateTimeUtils.getMondayStr(sInList.getMonitorDateString()); 
				key = keyDate +"."+sInList.getCompanyId();
			}
			else if(flagKey.equals("week_country")){//每周,全国
				keyDate = DateTimeUtils.getMondayStr(sInList.getMonitorDateString()); 
				key = keyDate;
			}
			else if(flagKey.equals("month_company")){//每月,项目
				keyDate = DateTimeUtils.getMonthFirstDayStr(sInList.getMonitorDateString()); 
				key = keyDate+"."+sInList.getProjectId();
			}
			else if(flagKey.equals("month_company")){//每月,公司(区域)
				keyDate = DateTimeUtils.getMonthFirstDayStr(sInList.getMonitorDateString()); 
				key = keyDate+"."+sInList.getCompanyId();
			}
			else if(flagKey.equals("month_country")){//每月,全国
				keyDate = DateTimeUtils.getMonthFirstDayStr(sInList.getMonitorDateString()); 
				key = keyDate;
			}
			
			//累计求和
			if(map.containsKey(key)){
				SaleMonitor sInMap = (SaleMonitor)map.get(key);
				sInMap.setPhoneNum(sInMap.getPhoneNum()+sInList.getPhoneNum());
				sInMap.setVisitorNum(sInMap.getVisitorNum()+sInList.getVisitorNum());
				sInMap.setHouseNum(sInMap.getHouseNum()+sInList.getHouseNum());
				sInMap.setHouseArea(sInMap.getHouseArea().add(sInList.getHouseArea()));
				sInMap.setHouseMoney(sInMap.getHouseMoney().add(sInList.getHouseMoney()));
				sInMap.setShopNum(sInMap.getShopNum()+sInList.getShopNum());
				sInMap.setShopArea(sInMap.getShopArea().add(sInList.getShopArea()));
				sInMap.setShopMoney(sInMap.getShopMoney().add(sInList.getShopMoney()));
				sInMap.setParkNum(sInMap.getParkNum()+sInList.getParkNum());
				sInMap.setParkArea(sInMap.getParkArea().add(sInList.getParkArea()));
				sInMap.setParkMoney(sInMap.getParkMoney().add(sInList.getParkMoney()));
				sInMap.setSumNum(sInMap.getSumNum()+sInList.getSumNum());
				sInMap.setSumArea(sInMap.getSumArea().add(sInList.getSumArea()));
				sInMap.setSumMoney(sInMap.getSumMoney().add(sInList.getSumMoney()));
				sInMap.setContractHouseNum(sInMap.getContractHouseNum()+sInList.getContractHouseNum());
				sInMap.setContractHouseArea(sInMap.getContractHouseArea().add(sInList.getContractHouseArea()));
				sInMap.setContractHouseMoney(sInMap.getContractHouseMoney().add(sInList.getContractHouseMoney()));
				sInMap.setContractShopNum(sInMap.getContractShopNum()+sInList.getContractShopNum());
				sInMap.setContractShopArea(sInMap.getContractShopArea().add(sInList.getContractShopArea()));
				sInMap.setContractShopMoney(sInMap.getContractShopMoney().add(sInList.getContractShopMoney()));
				sInMap.setContractParkNum(sInMap.getContractParkNum()+sInList.getContractParkNum());
				sInMap.setContractParkArea(sInMap.getContractParkArea().add(sInList.getContractParkArea()));
				sInMap.setContractParkMoney(sInMap.getContractParkMoney().add(sInList.getContractParkMoney()));
				sInMap.setContractSumNum(sInMap.getContractSumNum()+sInList.getContractSumNum());
				sInMap.setContractSumArea(sInMap.getContractSumArea().add(sInList.getContractSumArea()));
				sInMap.setContractSumMoney(sInMap.getContractSumMoney().add(sInList.getContractSumMoney()));
				sInMap.setUndoHouseNum(sInMap.getUndoHouseNum()+sInList.getUndoHouseNum());
				sInMap.setUndoHouseArea(sInMap.getUndoHouseArea().add(sInList.getUndoHouseArea()));
				sInMap.setUndoHouseMoney(sInMap.getUndoHouseMoney().add(sInList.getUndoHouseMoney()));
				sInMap.setUndoShopNum(sInMap.getUndoShopNum()+sInList.getUndoShopNum());
				sInMap.setUndoShopArea(sInMap.getUndoShopArea().add(sInList.getUndoShopArea()));
				sInMap.setUndoShopMoney(sInMap.getUndoShopMoney().add(sInList.getUndoShopMoney()));
				sInMap.setUndoParkNum(sInMap.getUndoParkNum()+sInList.getUndoParkNum());
				sInMap.setUndoParkArea(sInMap.getUndoParkArea().add(sInList.getUndoParkArea()));
				sInMap.setUndoParkMoney(sInMap.getUndoParkMoney().add(sInList.getUndoParkMoney()));
				sInMap.setUndoSumNum(sInMap.getUndoSumNum()+sInList.getUndoSumNum());
				sInMap.setUndoSumArea(sInMap.getUndoSumArea().add(sInList.getUndoSumArea()));
				sInMap.setUndoSumMoney(sInMap.getUndoSumMoney().add(sInList.getUndoSumMoney()));
				sInMap.setTempNum(sInMap.getTempNum()+sInList.getTempNum());
				sInMap.setRescissionNum(sInMap.getRescissionNum()+sInList.getRescissionNum());
				sInMap.setCompleteArea(sInMap.getCompleteArea()+sInList.getCompleteArea());
				sInMap.setCompleteMoney(sInMap.getCompleteMoney()+sInList.getCompleteMoney());
				sInMap.setIntentionNum(sInMap.getIntentionNum()+sInList.getIntentionNum());

				map.put(key,sInMap);				
			}
			else{
				sInList.setMonitorDateString(keyDate);
				sInList.setMonitorDate(DateTimeUtils.getDate(keyDate));
				map.put(key, sInList);
			}	
		}
		
		List<SaleMonitor> listRet = new ArrayList();

        for (Map.Entry<String, SaleMonitor> entry : map.entrySet()) {
        	listRet.add((SaleMonitor)entry.getValue());
        }	
		return listRet;
	}

	/**
	 * 查找,根据项目,周分组
	 */
	@Override
	public List<SaleMonitor> findSaleMonitorGroupbyProjectWeek(SaleMonitorCond cond)
			throws RuntimeException {
		List<SaleMonitor> list = findSaleMonitorGroupbyProjectDate(cond);
		
		List<SaleMonitor> listRet = getGroupBy(list,"week_project");
		
		return listRet;
	}
	
	/**
	 * 查找,根据公司,周分组
	 */
	@Override
	public List<SaleMonitor> findSaleMonitorGroupbyCompanyWeek(SaleMonitorCond cond)
			throws RuntimeException {
		List<SaleMonitor> list = findSaleMonitorGroupbyCompanyDate(cond);
		
		List<SaleMonitor> listRet = getGroupBy(list,"week_company");
		
		return listRet;
	}
	
	/**
	 * 查找,根据全国,周分组
	 */
	@Override
	public List<SaleMonitor> findSaleMonitorGroupbyCountryWeek(SaleMonitorCond cond)
			throws RuntimeException {
		List<SaleMonitor> list = findSaleMonitorGroupbyCountryDate(cond);

		List<SaleMonitor> listRet = getGroupBy(list,"week_country");
		
		return listRet;
	}

	/**
	 * 查找,根据项目,月分组
	 */
	@Override
	public List<SaleMonitor> findSaleMonitorGroupbyProjectMonth(SaleMonitorCond cond)
			throws RuntimeException {
		List<SaleMonitor> list = findSaleMonitorGroupbyProjectDate(cond);
		
		List<SaleMonitor> listRet = getGroupBy(list,"month_project");
		
		return listRet;
	}
	

	/**
	 * 查找,根据公司,月分组
	 */
	@Override
	public List<SaleMonitor> findSaleMonitorGroupbyCompanyMonth(SaleMonitorCond cond)
			throws RuntimeException {
		List<SaleMonitor> list = findSaleMonitorGroupbyCompanyDate(cond);
		
		List<SaleMonitor> listRet = getGroupBy(list,"month_company");
		
		return listRet;
	}
	
	/**
	 * 查找,根据全国,月分组
	 */
	@Override
	public List<SaleMonitor> findSaleMonitorGroupbyCountryMonth(SaleMonitorCond cond)
			throws RuntimeException {
		List<SaleMonitor> list = findSaleMonitorGroupbyCountryDate(cond);
		
		List<SaleMonitor> listRet = getGroupBy(list,"month_country");
		
		return listRet;
	}
	
	/**
	 * 查找,用于定时器
	 */
	@Override
	public List<SaleMonitor> findSaleMonitorFromLogbeforeForQuartz(
			SaleMonitorLogbeforeCond logBeforeCond) {
		return saleMonitorMapper.findSaleMonitorFromLogbeforeForQuartz(logBeforeCond);
	}

	/**
	 * 查找 用于定时器更新
	 */
	@Override
	public SaleMonitor findSaleMonitorForQuartzUpdate(SaleMonitorCond cond) {
		return saleMonitorMapper.findSaleMonitorForQuartzUpdate(cond);
	}

	/**
	 * 查找其他数据,根据查询日期
	 */
	@Override
	public Map<String, Number> findOtherDataForSearchTime(SaleMonitorCond cond) {
		
		return saleMonitorMapper.findOtherDataForSearchTime(cond);
	}

	/**
	 * 查找，报送数据的数量
	 */
	@Override
	public List<Map<String, Integer>> findSaleMonitorInCount(SaleMonitorCond cond) {
		
		return saleMonitorMapper.findSaleMonitorInCount(cond);
	}

	/**
	 * 根据monitorDate查找
	 */
	@Override
	public List<SaleMonitor> findSaleMonitorByMonitorDate(String monitorDate) {
		
		return saleMonitorMapper.findSaleMonitorByMonitorDate(monitorDate);
	}

	
}
