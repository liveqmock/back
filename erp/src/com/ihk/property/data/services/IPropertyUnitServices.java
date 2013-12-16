package com.ihk.property.data.services;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.property.data.pojo.CjsjjcUnitCond;
import com.ihk.property.data.pojo.PropertyArea;
import com.ihk.property.data.pojo.PropertyBuild;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.pojo.PropertyUnitCond;
import com.ihk.property.data.pojo.PropertyUnitReportCond;

/**
 * PropertyUnit的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
@SuppressWarnings("rawtypes")
public interface IPropertyUnitServices {

	/**
	 * 删除UNIT 根据BUILDID
	 * */
	public int deletePropertyUnitByBuildId(int buildId)throws RuntimeException;
	
	/**
	 * 新增PropertyUnit
	 * @param propertyUnit
	 */
	public void addPropertyUnit(PropertyUnit propertyUnit) throws RuntimeException;
	public void addKnPropertyUnit(PropertyUnit propertyUnit)throws RuntimeException;
	/**
	 * 删除一条PropertyUnit
	 * @param id
	 */
	public void deletePropertyUnit(int id) throws RuntimeException;

	/**
	 * 修改PropertyUnit
	 * @param propertyUnit
	 */
	public void updatePropertyUnit(PropertyUnit propertyUnit) throws RuntimeException;

	/**
	 * 查找一条PropertyUnit
	 * @return PropertyUnit
	 * @param id 主键id
	 */
	public PropertyUnit findPropertyUnitById(int id) throws RuntimeException;
	
	public PropertyUnit findPropertyUnitById2(int id) throws RuntimeException;

	/**
	 * 分页查找PropertyUnit
	 * @param cond 查询条件
	 * @return PropertyUnit列表
	 */
	public List<PropertyUnit> findPropertyUnitPage(PropertyUnitCond cond) throws RuntimeException;

    /**
     * 销售中心-列表-搜索
     * @param cond
     * @return
     * @throws RuntimeException
     */
    public List<PropertyUnit> searchPropertyUnitPage(PropertyUnitCond cond) throws RuntimeException;

	/**
	 * 查找全部PropertyUnit
	 * @param cond 查询条件
	 * @return PropertyUnit列表
	 */
	public List<PropertyUnit> findPropertyUnit(PropertyUnitCond cond) throws RuntimeException;
	
	/**
	 * 批量更新单元
	 * @param m  里面装载PropertyUnit   unit修改模板   ids 单元IDS 作为where条件
     * @throws RuntimeException
     */
 	public void updateByIds(Map m) throws RuntimeException;
	
	public int findPropertyUnitCount(PropertyUnitCond cond) throws RuntimeException;
	public int searchPropertyUnitCount(PropertyUnitCond cond) throws RuntimeException;

	/**
	 * 根据ids查找unitList   ??必须保证有IDS 不然会查找全部??
	 */
	@Deprecated
	public List<PropertyUnit> findUnitNameByIds (PropertyUnitCond cond) throws RuntimeException;
	
	/**
	 * 取得同一楼栋的所有单元
	 * @param buildId
	 * @return
	 * @throws RuntimeException
	 */
	public List<PropertyUnit> findUnitsByBuildId(int buildId) throws RuntimeException;
	
	/**
	 * 查找一个like unitNo的单元ID????   没有在使用的
	 * @param unitNo
	 * @return
	 * @throws RuntimeException
	 */
	@Deprecated
	public int findUnitIdByLikeUnitNo(String unitNo)throws RuntimeException;
	
	/**
	 * 根据主单元ID查找绑定的单元列表  已经过时 没有使用
	 * @param mainId
	 * @return
	 * @throws RuntimeException
	 */
	@Deprecated
	public List<PropertyUnit> findAddonPropertyUnitByMainId(int mainId) throws RuntimeException; //查询附属房产,主要用于增加认购的时候
	
	/**
	 * 修改单元状态
	 * @param map
	 * @throws RuntimeException
	 */
	public void updatePropertyUnitSaleState(Map<String, String> map) throws RuntimeException; //修改单元状态
	
	/**
	 * 根据buildId查找重复的单元号
	 * @param buildId
	 * @return
	 * @throws RuntimeException
	 */
	
	public List<Map> findStrListBuyBuildIdForRepeat(int buildId) throws RuntimeException;
	
	/**
	 * 根据groupId 查找真实的unit资料
	 * @param groupId 组团id
	 * */
	public List<PropertyUnit> findUnitListByGroupId(int groupId)  throws RuntimeException;
	
	/**
	 * 查找多个楼栋里层数最大的值
	 * @param cond buildIds 楼栋IDS
	 * */
	public int findMaxFloorByBuildIdList(PropertyUnitCond cond) throws RuntimeException;
	
	/**
	 * 查找多个楼栋里层数最小的值
	 * @param cond buildIds 楼栋IDS
	 * */
	public int findMinFloorByBuildIdList(PropertyUnitCond cond) throws RuntimeException;
	
	/**
	 * 根据楼栋id查找第一个单元,按id升序
	 * @param buildId 楼栋ID
	 * */
	public PropertyUnit findUnitOneByBuildId(int buildId) throws RuntimeException; //根据楼栋id查找第一个单元,按id升序
	
	/**
	 * 修改单元的意向数量
	 * @param unitId
	 * @param chipType 意向类型,(第几意向)
	 * @param chipCountNo 该意向总数
	 * @throws RuntimeException
	 */
	public void updatePropertyUnitChipByUnitIdAndChipTypeWithCountNo(int unitId, int chipType, int chipCountNo) throws RuntimeException; 
	
	/**
	 * 单项目 认筹情况反洗 
	 * @param cond
	 * */
	public List<Map> reportForRCFX(PropertyUnitCond cond) throws RuntimeException; //修改单元的意向数量
	
	/**
	 * 获取单元list,用于ajax table
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public List<PropertyUnit> findPropertyUnitForAjax(PropertyUnitCond cond) throws RuntimeException;
	
	/**
	 * 获取单元list总数,用于ajax table
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public int findPropertyUnitCountForAjax(PropertyUnitCond cond) throws RuntimeException;
	

	/**
	 * 报表用 连接CONFIRM查询 
	 * */
	public int findCountConfirm(PropertyUnitReportCond cond)throws RuntimeException;
	public BigDecimal findSumBuildAreaConfirm(PropertyUnitReportCond cond)throws RuntimeException;
	public BigDecimal findSumInsideAreaConfirm(PropertyUnitReportCond cond)throws RuntimeException;
	public BigDecimal findSumPriceConfirm(PropertyUnitReportCond cond)throws RuntimeException;
	
	/**
	 * 报表用 连接contract查询 
	 * */
	public int findCountContract(PropertyUnitReportCond cond)throws RuntimeException;
	public BigDecimal findSumBuildAreaContract(PropertyUnitReportCond cond)throws RuntimeException;
	public BigDecimal findSumInsideAreaContract(PropertyUnitReportCond cond)throws RuntimeException;
	public BigDecimal findSumPriceContract(PropertyUnitReportCond cond)throws RuntimeException;
	
	/**
	 * 报表用 连接  剩余 查询 
	 * */
	public int findCountShengYu(PropertyUnitReportCond cond)throws RuntimeException;
	public BigDecimal findSumBuildAreaShengYu(PropertyUnitReportCond cond)throws RuntimeException;
	public BigDecimal findSumInsideAreaShengYu(PropertyUnitReportCond cond)throws RuntimeException;
	public BigDecimal findSumPriceShengYu(PropertyUnitReportCond cond)throws RuntimeException;
	
	/**
	 * 报表用 连接  销售详细
	 * */
	public List<Map> findListForXSFXXXConfirm(PropertyUnitReportCond cond)throws RuntimeException;
	public int findListForXSFXXXConfirMcount(PropertyUnitReportCond cond)throws RuntimeException;
	
	public List<Map> findListForXSFXXXContract(PropertyUnitReportCond cond)throws RuntimeException;
	public int findListForXSFXXXContracTcount(PropertyUnitReportCond cond)throws RuntimeException;
	
	public List<Map> findListMapForReportByPidAndUserId(PropertyUnitReportCond cond)throws RuntimeException;
	public List<Map> findListMapForReportByPidAndUserIdContract(PropertyUnitReportCond cond)throws RuntimeException;
	
	public List<Map> findListMapForReportByPidAndUserIdXX(PropertyUnitReportCond cond)throws RuntimeException;
	public List<Map> findListMapForReportByPidAndUserIdContractXX(PropertyUnitReportCond cond)throws RuntimeException;
	
	public List<PropertyUnit> findOldDbLogAndUnit()throws RuntimeException;
	
	/**
	 * 查找认购单元,(成交数据交叉分析) 
	 * @param cond
	 * @return
	 */
	public List<PropertyUnit> findConfirmUnit(PropertyUnitCond cond) throws Exception;
	
	/**
	 * 成交数据交叉分析里面有个单元的相关查询
	 * @param cond
	 * @return
	 * @throws Exception
	 */
	public List<String> findForCjsjjc(CjsjjcUnitCond cond) throws RuntimeException;
	
	/**
	 * 获取单元对应的公司id
	 * @param unitId
	 * @return
	 * @throws RuntimeException
	 */
	public int findUnitCompanyId(int unitId) throws RuntimeException;
	
	/**
	 * 根据楼栋id获取最后一个修改的有效的单元,只要是在认筹的时候,能拿到一个有效的单元
	 * @param buildId
	 * @return
	 * @throws RuntimeException
	 */
	public PropertyUnit findLastModifyUnitByBuildId(int buildId) throws RuntimeException;
	
	/**
	 * 修改对应单元的对数日期及类型
	 * @param ids
	 * @param checkFeeDate
	 * @param checkfeeType
	 * @throws RuntimeException
	 */
	public void updateUnitCheckFeeByIdsAndDate(List<Integer> ids, Date checkFeeDate, int checkfeeType) throws RuntimeException;
	
	/**
	 * 根据楼栋id,楼层,房号获取对应的单元
	 * 主要用于数据导入ImportTemplate.java
	 * @param buildId
	 * @param floorNum
	 * @param roomNo
	 * @return
	 * @throws RuntimeException
	 */
	public List<PropertyUnit> findUnitByBuildIdAndFloorNumAndRoomNo(int buildId, String floorNum, String roomNo) throws RuntimeException;

	public PropertyUnit findLastModifyUnitByAreaId(int areaId);

	public PropertyUnit findLastModifyUnitByProjectId(int projectId);
	

}