package com.ihk.property.data.services.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.constanttype.ContUnitSaleState;
import com.ihk.constanttype.EnumPrivCode;
import com.ihk.permission.PermissionUtils;
import com.ihk.property.data.IPropertyUnitMapper;
import com.ihk.property.data.pojo.CjsjjcUnitCond;
import com.ihk.property.data.pojo.PropertyBuild;
import com.ihk.property.data.pojo.PropertyProject;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.pojo.PropertyUnitCheckFeeCond;
import com.ihk.property.data.pojo.PropertyUnitCond;
import com.ihk.property.data.pojo.PropertyUnitReportCond;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.DateTimeUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.SessionUser;
import com.ihk.utils.base.PojoDeleteCond;

/**
 * PropertyUnit的Services实现(业务实现)
 * @author 
 *
 */
@Service("propertyUnitServices")
public class PropertyUnitServices implements IPropertyUnitServices {
	/**
	 * propertyUnit数据访问接口
	 */
	@Autowired	 IPropertyUnitMapper propertyUnitMapper;

	/**
	 * 删除一条PropertyUnit
	 * @param id
	 */
	public void deletePropertyUnit(int id) throws RuntimeException {
		
		PropertyUnit unit = propertyUnitMapper.findPropertyUnitById(id);
		if(unit != null && !ContUnitSaleState.SALE_ABLE.equals(unit.getSaleState())){
			throw new RuntimeException("非可售单元,不能删除");
		}
		
		propertyUnitMapper.deletePropertyUnit(new PojoDeleteCond(id));
	}

	/**
	 * 新增PropertyUnit
	 * @param propertyUnit
	 */
	public void addPropertyUnit(PropertyUnit propertyUnit) throws RuntimeException {
		propertyUnit.setSaleState(ContUnitSaleState.SALE_ABLE);
		if(propertyUnit.getCompanyProjectId() == 0){
			PropertyBuild build = DescUtils.getBuildById(propertyUnit.getBuildId());
			int propertyId = build.getPropertyId();
			PropertyProject property = DescUtils.findPropertyProject(propertyId);
			int companyProjectId = property.getCompanyProjectId();
			
			propertyUnit.setCompanyProjectId(companyProjectId);
		}
		
		propertyUnitMapper.addPropertyUnit(propertyUnit);
	}
	
	public void addKnPropertyUnit(PropertyUnit propertyUnit) throws RuntimeException {
		propertyUnitMapper.addPropertyUnit(propertyUnit);
	}

	/**
	 * 查找一条PropertyUnit
	 * @return PropertyUnit
	 * @param id 主键id
	 */
	@Override
	public PropertyUnit findPropertyUnitById(int id) throws RuntimeException {
		return propertyUnitMapper.findPropertyUnitById(id);
	}

	/**
	 * 修改PropertyUnit
	 * @param propertyUnit
	 */
	@Override
	public void updatePropertyUnit(PropertyUnit propertyUnit) throws RuntimeException {
		propertyUnitMapper.updatePropertyUnit(propertyUnit);		
	}

	/**
	 * 分页查找PropertyUnit
	 * @param cond 查询条件
	 * @return PropertyUnit列表
	 */
	public List<PropertyUnit> findPropertyUnitPage(PropertyUnitCond cond) throws RuntimeException {
		int recordCount = propertyUnitMapper.findPropertyUnitCount(cond);
		
		cond.recordCount = recordCount;
				
		return propertyUnitMapper.findPropertyUnitPage(cond);
	}

    /**
     * 销售中心-列表-搜索
     * @param cond
     * @return
     * @throws RuntimeException
     */
    public List<PropertyUnit> searchPropertyUnitPage(PropertyUnitCond cond) throws RuntimeException {
        int recordCount = propertyUnitMapper.searchPropertyUnitCount(cond);

        cond.recordCount = recordCount;

        return propertyUnitMapper.searchPropertyUnitPage(cond);
    }
    @Override
    public int searchPropertyUnitCount(PropertyUnitCond cond)
            throws RuntimeException {
        return propertyUnitMapper.searchPropertyUnitCount(cond);
    }

    /**
	 * 查找全部PropertyUnit
	 * @param cond 查询条件
	 * @return PropertyUnit列表
	 */
	public List<PropertyUnit> findPropertyUnit(PropertyUnitCond cond) throws RuntimeException {	
		//追加权限限制
		cond.addPermissionCompanyProjectIds(PermissionUtils.getUserProjectIdList(EnumPrivCode.SALEUNIT_INIT_CREATE));
    	return propertyUnitMapper.findPropertyUnit(cond);
	}

	@Override
	public void updateByIds(Map m )
			throws RuntimeException {
		propertyUnitMapper.updateByIds(m);
	}

	@Override
	public int findPropertyUnitCount(PropertyUnitCond cond)
			throws RuntimeException {
		return propertyUnitMapper.findPropertyUnitCount(cond);
	}

	@Deprecated
	@Override
	public List<PropertyUnit> findUnitNameByIds(PropertyUnitCond cond)
			throws RuntimeException {
		return propertyUnitMapper.findUnitNameByIds(cond);
	}

	@Override
	public List<PropertyUnit> findUnitsByBuildId(int buildId) throws RuntimeException {
		
		return propertyUnitMapper.findUnitsByBuildId(buildId);
	}

	@Override
	public int findUnitIdByLikeUnitNo(String unitNo) throws RuntimeException {
		return propertyUnitMapper.findUnitIdByLikeUnitNo(unitNo);
	}

	@Override
	public List<PropertyUnit> findAddonPropertyUnitByMainId(int mainId)
			throws RuntimeException {
		
		return propertyUnitMapper.findAddonPropertyUnitByMainId(mainId);
	}

	@Override
	public void updatePropertyUnitSaleState(Map<String, String> map) throws RuntimeException {
		
		Map<String, Object> objMap = new HashMap<String, Object>();
		
		objMap.put("id", map.get("id"));
		objMap.put("saleState", map.get("saleState"));
		objMap.put("modId", SessionUser.getUserIdStr());
		//加入修改时间的指定
		if(!map.containsKey("modTime"))	
			objMap.put("modTime", new Date());
		else
			objMap.put("modTime", DateTimeUtils.getDate(map.get("modTime"),"yyyy-MM-dd hh:mm:ss"));
		propertyUnitMapper.updatePropertyUnitSaleState(objMap);
	}

	@Override
	public List<Map> findStrListBuyBuildIdForRepeat(int buildId)
			throws RuntimeException {
		return propertyUnitMapper.findStrListBuyBuildIdForRepeat(buildId);
	}

	@Override
	public List<PropertyUnit> findUnitListByGroupId(int groupId)
			throws RuntimeException {
		return propertyUnitMapper.findUnitListByGroupId(groupId);
	}

	@Override
	public int findMaxFloorByBuildIdList(PropertyUnitCond cond)
			throws RuntimeException {
		return propertyUnitMapper.findMaxFloorByBuildIdList(cond);
	}

	@Override
	public int findMinFloorByBuildIdList(PropertyUnitCond cond)
			throws RuntimeException {
		return propertyUnitMapper.findMinFloorByBuildIdList(cond);
	}

	@Override
	public PropertyUnit findUnitOneByBuildId(int buildId)
			throws RuntimeException {
		
		return propertyUnitMapper.findUnitOneByBuildId(buildId);
	}

	@Override
	public void updatePropertyUnitChipByUnitIdAndChipTypeWithCountNo(
			int unitId, int chipType, int chipCountNo) throws RuntimeException {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("unitId", unitId);
		map.put("chipType", chipType);
		map.put("chipCountNo", chipCountNo);
		
		propertyUnitMapper.updatePropertyUnitChipByUnitIdAndChipTypeWithCountNo(map);
	}

	@Override
	public List<Map> reportForRCFX(PropertyUnitCond cond) throws RuntimeException {
		return propertyUnitMapper.reportForRCFX(cond);
	}

	@Override
	public int deletePropertyUnitByBuildId(int buildId) throws RuntimeException {
		return propertyUnitMapper.deletePropertyUnitByBuildId(buildId);
	}

	@Override
	public List<PropertyUnit> findPropertyUnitForAjax(PropertyUnitCond cond)
			throws RuntimeException {
		return propertyUnitMapper.findPropertyUnitForAjax(cond);
	}

	@Override
	public int findPropertyUnitCountForAjax(PropertyUnitCond cond)
			throws RuntimeException {
		return propertyUnitMapper.findPropertyUnitCountForAjax(cond);
	}

	@Override
	public int findCountConfirm(PropertyUnitReportCond cond)
			throws RuntimeException {
		
		return propertyUnitMapper.findCountConfirm(cond);
	}

	@Override
	public int findCountContract(PropertyUnitReportCond cond)
			throws RuntimeException {
		
		return propertyUnitMapper.findCountContract(cond);
	}

	@Override
	public BigDecimal findSumBuildAreaConfirm(PropertyUnitReportCond cond)
			throws RuntimeException {
		
		return propertyUnitMapper.findSumBuildAreaConfirm(cond);
	}

	@Override
	public BigDecimal findSumBuildAreaContract(PropertyUnitReportCond cond)
			throws RuntimeException {
		
		return propertyUnitMapper.findSumBuildAreaContract(cond);
	}

	@Override
	public BigDecimal findSumInsideAreaConfirm(PropertyUnitReportCond cond)
			throws RuntimeException {
		
		return propertyUnitMapper.findSumInsideAreaConfirm(cond);
	}

	@Override
	public BigDecimal findSumInsideAreaContract(PropertyUnitReportCond cond)
			throws RuntimeException {
		
		return propertyUnitMapper.findSumInsideAreaContract(cond);
	}

	@Override
	public BigDecimal findSumPriceConfirm(PropertyUnitReportCond cond)
			throws RuntimeException {
		
		return propertyUnitMapper.findSumPriceConfirm(cond);
	}

	@Override
	public BigDecimal findSumPriceContract(PropertyUnitReportCond cond)
			throws RuntimeException {
		
		return propertyUnitMapper.findSumPriceContract(cond);
	}

	@Override
	public int findCountShengYu(PropertyUnitReportCond cond)
			throws RuntimeException {
		
		return propertyUnitMapper.findCountShengYu(cond);
	}

	@Override
	public BigDecimal findSumBuildAreaShengYu(PropertyUnitReportCond cond)
			throws RuntimeException {
		
		return propertyUnitMapper.findSumBuildAreaShengYu(cond);
	}

	@Override
	public BigDecimal findSumInsideAreaShengYu(PropertyUnitReportCond cond)
			throws RuntimeException {
		
		return propertyUnitMapper.findSumInsideAreaShengYu(cond);
	}

	@Override
	public BigDecimal findSumPriceShengYu(PropertyUnitReportCond cond)
			throws RuntimeException {
		
		return propertyUnitMapper.findSumPriceShengYu(cond);
	}

	@Override
	public List<PropertyUnit> findOldDbLogAndUnit() throws RuntimeException {
		
		return propertyUnitMapper.findOldDbLogAndUnit();
	}

	@Override
	public List<Map> findListForXSFXXXConfirm(PropertyUnitReportCond cond)
			throws RuntimeException {
		return propertyUnitMapper.findListForXSFXXXConfirm(cond);
	}

	@Override
	public List<Map> findListForXSFXXXContract(PropertyUnitReportCond cond)
			throws RuntimeException {
		return propertyUnitMapper.findListForXSFXXXContract(cond);
	}

	@Override
	public List<Map> findListMapForReportByPidAndUserId(
			PropertyUnitReportCond cond) throws RuntimeException {
		return propertyUnitMapper.findListMapForReportByPidAndUserId(cond);
	}

	@Override
	public List<Map> findListMapForReportByPidAndUserIdContract(
			PropertyUnitReportCond cond) throws RuntimeException {
		//追加权限限制
		cond.addPermissionCompanyProjectIds(PermissionUtils.getUserProjectIdList(EnumPrivCode.REPORT_SALEUNIT_STAT));
		return propertyUnitMapper.findListMapForReportByPidAndUserIdContract(cond);
	}

	@Override
	public List<Map> findListMapForReportByPidAndUserIdContractXX(
			PropertyUnitReportCond cond) throws RuntimeException {
		
		return propertyUnitMapper.findListMapForReportByPidAndUserIdContractXX(cond);
	}

	@Override
	public List<Map> findListMapForReportByPidAndUserIdXX(
			PropertyUnitReportCond cond) throws RuntimeException {
		
		return propertyUnitMapper.findListMapForReportByPidAndUserIdXX(cond);
	}

	@Override
	public List<PropertyUnit> findConfirmUnit(PropertyUnitCond cond)
			throws Exception {
		
		return propertyUnitMapper.findConfirmUnit(cond);
	}

	@Override
	public List<String> findForCjsjjc(CjsjjcUnitCond cond) throws RuntimeException {
		
		List<String> retList = new ArrayList<String>();
		
		List<Map<String, Object>> getMapList = propertyUnitMapper.findForCjsjjc(cond);
		
		if(!CommonUtils.isCollectionEmpty(getMapList)){
			
			for(Map<String, Object> map : getMapList){
				
				if(map == null)
					continue;
				
				Object getVal = map.get("val");
				if(getVal != null && !CommonUtils.isStrEmpty(getVal.toString())){
					retList.add(getVal.toString());
				}
			}
		}
		
		//Collections.sort(retList);
		
		return retList;
		
	}

	@Override
	public int findUnitCompanyId(int unitId) throws RuntimeException {
		
		return propertyUnitMapper.findUnitCompanyId(unitId);
	}

	@Override
	public int findListForXSFXXXConfirMcount(PropertyUnitReportCond cond)
			throws RuntimeException {
		return propertyUnitMapper.findListForXSFXXXConfirMcount(cond);
	}

	@Override
	public int findListForXSFXXXContracTcount(PropertyUnitReportCond cond)
			throws RuntimeException {
		return propertyUnitMapper.findListForXSFXXXContracTcount(cond);
	}

	@Override
	public PropertyUnit findLastModifyUnitByBuildId(int buildId)
			throws RuntimeException {
		
		return propertyUnitMapper.findLastModifyUnitByBuildId(buildId);
	}

	@Override
	public void updateUnitCheckFeeByIdsAndDate(List<Integer> ids,
			Date checkFeeDate, int checkfeeType) throws RuntimeException {
		
		PropertyUnitCheckFeeCond cond = new PropertyUnitCheckFeeCond(ids, checkFeeDate, checkfeeType);
		
		propertyUnitMapper.updateUnitCheckFeeByIdsAndDate(cond);
		
	}

	@Override
	public List<PropertyUnit> findUnitByBuildIdAndFloorNumAndRoomNo(int buildId,
			String floorNum, String roomNo) throws RuntimeException {
		
		PropertyUnit unit = new PropertyUnit();
		
		unit.setBuildId(buildId);
		unit.setFloorNum(floorNum);
		unit.setRoomNo(roomNo);
		
		return propertyUnitMapper.findUnitByBuildIdAndFloorNumAndRoomNo(unit);
	}

	@Override
	public PropertyUnit findLastModifyUnitByAreaId(int areaId) {
		return propertyUnitMapper.findLastModifyUnitByAreaId(areaId);
	}

	@Override
	public PropertyUnit findLastModifyUnitByProjectId(int projectId) {
		return propertyUnitMapper.findLastModifyUnitByProjectId(projectId);
	}

	@Override
	public PropertyUnit findPropertyUnitById2(int id) throws RuntimeException {
		return propertyUnitMapper.findPropertyUnitById(id);
	}

}
