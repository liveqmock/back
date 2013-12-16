package com.ihk.saleunit.log;

import java.util.HashMap;
import java.util.Map;

import org.aopalliance.intercept.MethodInvocation;

import com.ihk.constanttype.ContUnitSaleState;
import com.ihk.property.data.pojo.PropertyArea;
import com.ihk.property.data.pojo.PropertyBuild;
import com.ihk.property.data.pojo.PropertyProject;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.saleunit.log.pojo.Log;
import com.ihk.saleunit.log.services.ILogService;
import com.ihk.utils.DateTimeUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.log.CompareUtils;
import com.ihk.utils.request.HttpRequestUtils;
import com.ihk.utils.saleunit.MyPropertyUtils;

public class BuildingAreaUnitInitLogService {
	
	
	private static MethodInvocation invocation;
	
	public static void setInvocation(MethodInvocation invocation) {
		BuildingAreaUnitInitLogService.invocation = invocation;
	}
	
	public static MethodInvocation getInvocation() {
		return invocation;
	}


	private static ILogService logService = CompareUtils.getLogService();
	/**
	 * 记录新建楼盘
	 * 
	 * @throws Exception
	 */
	public void addPropertyProjectLog() throws Exception {
		PropertyProject pe = (PropertyProject) invocation.getArguments()[0];
		if (pe != null) {
			Log log = new Log();
			CompareUtils.initPojoCommonFiled(log);
			log.setType("新建楼盘");
			log.setModul("楼盘初始");
			log.setPropertyId(pe.getId());
			log.setOperationProcedure("新建楼盘-"+pe.getPropertyName());
			logService.addLog(log);
		}
	}
	/**
	 * 记录楼盘修改
	 * @throws Exception
	 */
	public void updatePropertyProjectLog() throws Exception{
		PropertyProject nowPp = (PropertyProject) invocation.getArguments()[0];
		if (nowPp != null) {
			PropertyProject lastPp =  MyPropertyUtils.getPropertyProjectServices().findPropertyProjectById(nowPp.getId());
			String change = CompareUtils.equals(lastPp.getPropertyName(), nowPp.getPropertyName());
			if(!"".equals(change)){
			Log log = new Log();
			CompareUtils.initPojoCommonFiled(log);
			log.setType("修改楼盘");
			log.setModul("楼盘初始");
			log.setPropertyId(nowPp.getId());
			log.setOperationProcedure("修改楼盘-"+lastPp.getPropertyName()+"名称"+ change);
			logService.addLog(log);
			
			}
		}
	}
	
	/**
	 * 记录楼盘删除
	 * @throws Exception
	 */
	public static void deletePropertyProjectLog() throws Exception{
		PropertyProject nowPp = (PropertyProject) HttpRequestUtils.getRequest().getAttribute("upProject");
		if(nowPp!=null){
			Log log = new Log();
			CompareUtils.initPojoCommonFiled(log);
			log.setType("删除楼盘");
			log.setModul("楼盘初始");
			log.setPropertyId(nowPp.getId());
			log.setOperationProcedure("删除楼盘-"+nowPp.getPropertyName());
			logService.addLog(log);
		}
	}
	
	/**
	 * 记录新建分区
	 * @throws Exception
	 */
	public static void addPropertyAreaLog() throws Exception{
		PropertyArea pe = (PropertyArea)invocation.getArguments()[0];
		if(pe!=null){
			Log log = new Log();
			CompareUtils.initPojoCommonFiled(log);
			log.setType("新建分区");
			log.setModul("楼盘初始");
			log.setPropertyId(pe.getPropertyId());
			log.setAreaId(pe.getId());
			log.setOperationProcedure("新建分区-"+pe.getAreaName());
			logService.addLog(log);
		}
	}
	
	/**
	 * 记录修改分区
	 * @throws Exception
	 */
	public static void updatePropertyAreaLog() throws Exception{
		PropertyArea now = (PropertyArea)invocation.getArguments()[0];
		if(now!=null){
			PropertyArea last = DescUtils.getPropertyAreaServices().findPropertyAreaById(now.getId());
			String change = CompareUtils.equals(last.getAreaName(), now.getAreaName());
			if (!"".equals(change)) {
				Log log = new Log();
				CompareUtils.initPojoCommonFiled(log);
				log.setType("修改分区");
				log.setModul("楼盘初始");
				log.setPropertyId(now.getPropertyId());
				log.setAreaId(now.getId());
				log.setOperationProcedure("修改分区-"+last.getAreaName()+"名:" + change);
				logService.addLog(log);
			}
		}
	}
	
	/**
	 * 记录删除分区
	 * @throws Exception 
	 */
	public static void deletePropertyAreaLog() throws Exception{
		int id = (Integer) invocation.getArguments()[0];
		PropertyArea property = DescUtils.getPropertyAreaServices().findPropertyAreaById(id);
		Log log = new Log();
		CompareUtils.initPojoCommonFiled(log);
		log.setType("删除分区");
		log.setModul("楼盘初始");
		log.setPropertyId(property.getPropertyId());
		log.setAreaId(id);
		log.setOperationProcedure("删除分区-"+property.getAreaName());
		logService.addLog(log);
	}
	
	/**
	 * 记录新建楼栋
	 * @throws Exception 
	 */
	public static void addPropertyBuildLog()throws Exception{
		PropertyBuild pe = (PropertyBuild)invocation.getArguments()[0];
		if(pe!=null){
			Log log = new Log();
			CompareUtils.initPojoCommonFiled(log);
			log.setType("新建楼栋");
			log.setModul("楼盘初始");
			log.setPropertyId(pe.getPropertyId());
			log.setAreaId(pe.getAreaId());
			log.setBuildId(pe.getId());
			log.setOperationProcedure("新建楼栋-"+pe.getBuildName());
			logService.addLog(log);
		}
	}
	
	/**
	 * 记录修改楼栋
	 * @throws Exception
	 */
	public static void updatePropertyBuildLog() throws Exception {
		PropertyBuild now = (PropertyBuild) invocation.getArguments()[0];
		PropertyBuild last = MyPropertyUtils.getPropertyBuildServices()
				.findPropertyBuildById(now.getId());
		if (now != null) {
			String change = CompareUtils.equals(last.getBuildName(),
					now.getBuildName());
			if (!"".equals(change)) {
				Log log = new Log();
				CompareUtils.initPojoCommonFiled(log);
				log.setType("修改楼栋");
				log.setModul("楼盘初始");
				log.setPropertyId(now.getPropertyId());
				log.setAreaId(now.getAreaId());
				log.setBuildId(now.getId());
				log.setOperationProcedure("楼栋-"+last.getBuildName()+"名称:"+change);
				logService.addLog(log);
			}
		}
	}
	
	/**
	 * 记录楼栋删除
	 * @throws Exception
	 */
	public static void deletePropertyBuildLog() throws Exception{
		Integer id = (Integer) invocation.getArguments()[0]; 
		
		if(id!=null){
			PropertyBuild pe = MyPropertyUtils.getPropertyBuildServices().findPropertyBuildById(id);
			Log log = new Log();
			CompareUtils.initPojoCommonFiled(log);
			log.setType("删除楼栋");
			log.setModul("楼盘初始");
			log.setPropertyId(pe.getPropertyId());
			log.setAreaId(pe.getAreaId());
			log.setBuildId(pe.getId());
			log.setOperationProcedure("删除楼栋-"+pe.getBuildName());
			logService.addLog(log);
		}
	}
	
	/**
	 * 记录新建单元
	 * @throws Exception
	 */
	public static void addPropertyUnitLog() throws Exception{
		PropertyUnit unit = (PropertyUnit) invocation.getArguments()[0];
		PropertyBuild build = MyPropertyUtils.getPropertyBuildServices().findPropertyBuildById(unit.getBuildId());
		PropertyArea area =  MyPropertyUtils.getPropertyAreaServices().findPropertyAreaById(build.getAreaId());
		Log log = new Log();
		CompareUtils.initPojoCommonFiled(log);
		log.setType("新建单元");
		log.setModul("楼盘初始");
		log.setBuildId(unit.getBuildId());
		log.setUnitId(unit.getId());
		log.setAreaId(area.getId());
		log.setPropertyId(area.getPropertyId());
		log.setOperationProcedure("新建单元-"+unit.getUnitNo());
		String string =  HttpRequestUtils.getRequest().getRequestURI();
		if(string.endsWith("initSomeUnitForm.action")){
			log.setType("批量新建单元");
			log.setCreatedTime(unit.getCreatedTime());
		}
		logService.addLog(log);
		if(false)
			throw new Exception();
		return ;
	}
	
	
	/**
	 * 记录修改单元
	 * @throws Exception
	 */
	public static void updatePropertyUnitLog() throws Exception{
		//TODO 需要追加其他操作的单元状态改变
		
		PropertyUnit now = (PropertyUnit) invocation.getArguments()[0];
		PropertyUnit last = MyPropertyUtils.getPropertyUnitServices().findPropertyUnitById(now.getId());
		
		
		
		PropertyBuild build = MyPropertyUtils.getPropertyBuildServices().findPropertyBuildById(last.getBuildId());
		PropertyArea area =  MyPropertyUtils.getPropertyAreaServices().findPropertyAreaById(build.getAreaId());
		String string =  HttpRequestUtils.getRequest().getRequestURI();
		Log log = new Log();
		CompareUtils.initPojoCommonFiled(log);
		log.setType("修改单元");
		log.setModul("楼盘初始");
		log.setBuildId(now.getBuildId());
		log.setUnitId(now.getId());
		log.setAreaId(area.getId());
		log.setPropertyId(area.getPropertyId());
		if (string.endsWith("updateOneUnitForm.action")) {
			if (now != null) {
				Map<String,String> changeMap = new HashMap<String, String>();
				String floorNumChange = CompareUtils.equals(last.getFloorNum(), now.getFloorNum());
				if(!"".equals(floorNumChange))
					changeMap.put("楼层号变动", floorNumChange);
				String unitNoChange = CompareUtils.equals(last.getUnitNo(), now.getUnitNo());
				if(!"".equals(unitNoChange))
					changeMap.put("单元号号变动", unitNoChange);
				String roomNoChange = CompareUtils.equals(last.getRoomNo(), now.getRoomNo());
				if(!"".equals(roomNoChange))
					changeMap.put("房间号变动", roomNoChange);
				String buildAreaChange = CompareUtils.equals(last.getBuildArea(), now.getBuildArea());
				if(!"".equals(buildAreaChange))
					changeMap.put("建筑面积变动", buildAreaChange);
				String buildPriceChange = CompareUtils.equals(last.getBuildPrice(), now.getBuildPrice());
				if(!"".equals(buildPriceChange))
					changeMap.put("建筑单价变动", buildPriceChange);
				String insideAreaChange = CompareUtils.equals(last.getInsideArea(), now.getInsideArea());
				if(!"".equals(insideAreaChange))
					changeMap.put("套内面积变动", insideAreaChange);
				String insidePriceChange = CompareUtils.equals(last.getInsidePrice(), now.getInsidePrice());
				if(!"".equals(insidePriceChange))
					changeMap.put("套内单价变动", insideAreaChange);
				String priceWayChange = CompareUtils.equals(last.getPriceWayStr(), now.getPriceWayStr());
				if(!"".equals(priceWayChange))
					changeMap.put("计价方式变动", insideAreaChange);
				String sumPriceChange = CompareUtils.equals(last.getSumPrice(), now.getSumPrice());
				if(!"".equals(sumPriceChange))
					changeMap.put("总价变动", sumPriceChange);
				String orientationChange = CompareUtils.compareOrientation(last.getOrientation(), now.getOrientation());
				if(!"".equals(orientationChange))
					changeMap.put("朝向变动", orientationChange);
				String roomStructure = CompareUtils.compareRoomStructure(last,now);
				if(!"".equals(roomStructure))
					changeMap.put("房间结构变动", roomStructure);		
				String saleTimeChange = CompareUtils.equals(last.getSaleTime(), now.getSaleTime());
				if(!"".equals(saleTimeChange))
					changeMap.put("推货日期变动", saleTimeChange);
				String productTypeChange = CompareUtils.equals(last.getProductTypeStr(), now.getProductTypeStr());
				if(!"".equals(productTypeChange))
					changeMap.put("产品类型变动", productTypeChange);
				String renovatePriceChange = CompareUtils.equals(last.getRenovatePrice(), now.getRenovatePrice());
				if(!"".equals(renovatePriceChange))
					changeMap.put("装修单价变动", renovatePriceChange);
				String renovateMoneyChange = CompareUtils.equals(last.getRenovateMoney(), now.getRenovateMoney());
				if(!"".equals(renovateMoneyChange))
					changeMap.put("装修款变动", renovateMoneyChange);
				String sceneryChange = CompareUtils.equals(last.getScenery(), now.getScenery());
				if(!"".equals(sceneryChange))
					changeMap.put("景观变动", sceneryChange);
				String remarkChange = CompareUtils.equals(last.getRemark(), now.getRemark());
				if(!"".equals(remarkChange))
					changeMap.put("备注变动", remarkChange);
				log.setOperationProcedure("单元"+now.getUnitNo()+"信息修改<br/>"+CompareUtils.createChange(changeMap));
				logService.addLog(log);
			}
		
		}

	}
	
	
	/**
	 * 记录删除单元
	 * @throws Exception
	 */
	public static void deletePropertyUnitLog()throws Exception{
		Integer selectuid = (Integer)invocation.getArguments()[0];
		PropertyUnit deleteUnit =   MyPropertyUtils.getPropertyUnitServices().findPropertyUnitById(selectuid);
		PropertyBuild build = MyPropertyUtils.getPropertyBuildServices().findPropertyBuildById(deleteUnit.getBuildId());
		PropertyArea area =  MyPropertyUtils.getPropertyAreaServices().findPropertyAreaById(build.getAreaId());
		Log log = new Log();
		CompareUtils.initPojoCommonFiled(log);
		log.setType("删除单元");
		String string =  HttpRequestUtils.getRequest().getRequestURI();
		if(string.endsWith("delSomeUnit.action")){
			log.setType("批量删除单元");
		}
		log.setModul("楼盘初始");
		log.setBuildId(deleteUnit.getBuildId());
		log.setUnitId(deleteUnit.getId());
		log.setAreaId(area.getId());
		log.setPropertyId(area.getPropertyId());
		log.setOperationProcedure("删除单元-"+deleteUnit.getUnitNo());
		logService.addLog(log);
	}
	
	/**
	 * 单元状态修改
	 * @throws Exception
	 */
	public static void updatePropertyUnitSaleStateLog() throws Exception{
		Map<String,String> map = (HashMap<String, String>)invocation.getArguments()[0];
		
		 int unitId =  Integer.valueOf(map.get("id"));
		 PropertyUnit unit =  MyPropertyUtils.getPropertyUnitServices().findPropertyUnitById(unitId);
		 PropertyBuild build = MyPropertyUtils.getPropertyBuildServices().findPropertyBuildById(unit.getBuildId());
		 PropertyArea area =  MyPropertyUtils.getPropertyAreaServices().findPropertyAreaById(build.getAreaId());
		 String string =  HttpRequestUtils.getRequest().getRequestURI();
		 Log log = new Log();
		 CompareUtils.initPojoCommonFiled(log);
		 if(string.endsWith("updateSaleStateBySomeUnitIds.action")){
			 log.setType("批量修改单元状态");
			 log.setCreatedTime(DateTimeUtils.getDate(map.get("modTime"), "yyyy-MM-dd hh:mm:ss"));
			 log.setModTime(DateTimeUtils.getDate(map.get("modTime"), "yyyy-MM-dd hh:mm:ss"));
		 }
		  log.setModul("楼盘初始");
		  log.setUnitId(unitId);
		  log.setBuildId(unit.getBuildId());
		  log.setAreaId(area.getId());
		  log.setPropertyId(area.getPropertyId());
		  log.setOperationProcedure("修改单元"+unit.getUnitNo()+"状态为"
					+ CompareUtils.equals(unit.getSaleStateStr(),
							ContUnitSaleState.getSaleState().get(map.get("saleState")) ));
		  logService.addLog(log);
	}
}
