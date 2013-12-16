package com.ihk.property.data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.ihk.property.data.pojo.CjsjjcUnitCond;
import com.ihk.property.data.pojo.PropertyBuild;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.pojo.PropertyUnitCheckFeeCond;
import com.ihk.property.data.pojo.PropertyUnitCond;
import com.ihk.property.data.pojo.PropertyUnitReportCond;
import com.ihk.utils.base.PojoDeleteCond;

/**
 * PropertyUnit数据访问接口Mapper
 * @author 
 *
 */ 
@SuppressWarnings("rawtypes")
public interface IPropertyUnitMapper {

	/**
	 * 新增PropertyUnit
	 * @param propertyUnit
	 */
	public void addPropertyUnit(PropertyUnit propertyUnit) ;

	/**
	 * 根据条件删除PropertyUnit
	 * @param cond 删除条件
	 */
	public void deletePropertyUnit(PojoDeleteCond cond) throws RuntimeException;


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

	/**
	 * 分页查找PropertyUnit
	 * @param cond 查询条件
	 * @return PropertyUnit列表
	 */
	public List<PropertyUnit> findPropertyUnitPage(PropertyUnitCond cond) ;

    /**
     * 查找符合条件的记录条数
     * @param cond
     * @return
     */
    public int searchPropertyUnitCount(PropertyUnitCond cond) ;
    /**
     * 销售中心-列表-搜索
     * @param cond
     * @return
     */
	public List<PropertyUnit> searchPropertyUnitPage(PropertyUnitCond cond) ;

	/**
	 * 查找全部PropertyUnit
	 * @param cond 查询条件
	 * @return PropertyUnit列表
	 */
	public List<PropertyUnit> findPropertyUnit(PropertyUnitCond cond) ;

	/**
	 * 查找符合条件的记录条数PropertyUnit
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findPropertyUnitCount(PropertyUnitCond cond) ;
	
	/**
	 * 批量更新单元
	 * @param m  里面装载PropertyUnit   unit修改模板   ids 单元IDS 作为where条件
	 *   m.unit 模板
	 *   m.ids where条件 修改哪些unit
	 * */
	public void updateByIds(Map m ) throws RuntimeException;
	//public void updateByIds(PropertyUnit updatePropertyUnit) throws RuntimeException;
	
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
	public List<PropertyUnit> findAddonPropertyUnitByMainId(int mainId) throws RuntimeException; 
	
	//啊创帮忙加 
	public void updatePropertyUnitSaleState(Map<String, Object> map) throws RuntimeException; //修改单元状态
	
	//啊创帮忙加 
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
	public int findMaxFloorByBuildIdList(PropertyUnitCond cond);
	
	/**
	 * 查找多个楼栋里层数最小的值
	 * @param cond buildIds 楼栋IDS
	 * */
	public int findMinFloorByBuildIdList(PropertyUnitCond cond);
	
	/**
	 * 根据楼栋id查找第一个单元,按id升序
	 * @param buildId 楼栋ID
	 * */

	public PropertyUnit findUnitOneByBuildId(int buildId) throws RuntimeException;
	
	/**
	 * 修改单元的意向数量
	 * @param unitId
	 * @param chipType 意向类型,(第几意向)
	 * @param chipCountNo 该意向总数
	 * @throws RuntimeException
	 */
	public void updatePropertyUnitChipByUnitIdAndChipTypeWithCountNo(Map<String, Integer> map) throws RuntimeException; //修改单元的意向数量
	
	public List<Map> reportForRCFX(PropertyUnitCond cond) throws RuntimeException; //修改单元的意向数量
	
	
	public int deletePropertyUnitByBuildId(int id)throws RuntimeException;
	
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
	public int findCountConfirm(PropertyUnitReportCond cond);
	public BigDecimal findSumBuildAreaConfirm(PropertyUnitReportCond cond);
	public BigDecimal findSumInsideAreaConfirm(PropertyUnitReportCond cond);
	public BigDecimal findSumPriceConfirm(PropertyUnitReportCond cond);
	
	/**
	 * 报表用 连接contract查询 
	 * */
	public int findCountContract(PropertyUnitReportCond cond);
	public BigDecimal findSumBuildAreaContract(PropertyUnitReportCond cond);
	public BigDecimal findSumInsideAreaContract(PropertyUnitReportCond cond);
	public BigDecimal findSumPriceContract(PropertyUnitReportCond cond);
	
	/**
	 * 报表用 连接  剩余 查询 
	 * */
	public int findCountShengYu(PropertyUnitReportCond cond);
	public BigDecimal findSumBuildAreaShengYu(PropertyUnitReportCond cond);
	public BigDecimal findSumInsideAreaShengYu(PropertyUnitReportCond cond);
	public BigDecimal findSumPriceShengYu(PropertyUnitReportCond cond);
	
	/**
	 * 报表用 连接  销售详细
	 * */
	public List<Map> findListForXSFXXXConfirm(PropertyUnitReportCond cond);
	public int findListForXSFXXXConfirMcount(PropertyUnitReportCond cond);
	
	
	public List<Map> findListForXSFXXXContract(PropertyUnitReportCond cond);
	public int findListForXSFXXXContracTcount(PropertyUnitReportCond cond);
	
	public List<Map> findListMapForReportByPidAndUserId(PropertyUnitReportCond cond);
	public List<Map> findListMapForReportByPidAndUserIdContract(PropertyUnitReportCond cond);
	
	public List<Map> findListMapForReportByPidAndUserIdXX(PropertyUnitReportCond cond);
	public List<Map> findListMapForReportByPidAndUserIdContractXX(PropertyUnitReportCond cond);
	
	/**
	 * 
	 * */
	public List<PropertyUnit> findOldDbLogAndUnit();
	
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
	public List<Map<String, Object>> findForCjsjjc(CjsjjcUnitCond cond) throws RuntimeException;
	
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
	 * @param cond
	 * @throws RuntimeException
	 */
	public void updateUnitCheckFeeByIdsAndDate(PropertyUnitCheckFeeCond cond) throws RuntimeException;
	
	/**
	 * 根据楼栋id,楼层,房号获取对应的单元
	 * 主要用于数据导入ImportTemplate.java
	 * @param unit
	 * @return
	 * @throws RuntimeException
	 */
	public List<PropertyUnit> findUnitByBuildIdAndFloorNumAndRoomNo(PropertyUnit unit) throws RuntimeException;

	public PropertyUnit findLastModifyUnitByAreaId(int areaId);

	public PropertyUnit findLastModifyUnitByProjectId(int projectId);
	
	
}
