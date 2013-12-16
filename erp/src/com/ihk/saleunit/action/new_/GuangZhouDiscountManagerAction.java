package com.ihk.saleunit.action.new_;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.ContUnitComputeWay;
import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.saleunit.data.pojo.UnitDiscount;
import com.ihk.saleunit.data.pojo.UnitDiscountCond;
import com.ihk.saleunit.data.pojo.UnitDiscountDetail;
import com.ihk.saleunit.data.services.IUnitDiscountDetailServices;
import com.ihk.saleunit.data.services.IUnitDiscountServices;
import com.ihk.utils.CommonPojoUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.MyTransationTemplate;
import com.ihk.utils.SupperAction;
import com.ihk.utils.saleunitnew.DiscountManagerUtils;

/**
 *  折扣管理
 */
@SuppressWarnings({"rawtypes","unchecked"})
public class GuangZhouDiscountManagerAction extends SupperAction{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	IPropertyUnitServices unitServices;
	@Autowired
	IUnitDiscountServices unitDiscountServices;
	@Autowired
	IUnitDiscountDetailServices discountDetailServices;
	
	/**
	 * 创建折扣弹出框,在认购签约的新增界面(没有mainId)
	 * @return
	 * @throws Exception
	 */
	public String createDiscountDialog() throws Exception{
		
		int unitId = Integer.parseInt(request.getParameter("unitId"));
		
		init(unitId);
		initHistroy();
		unitDiscountId = "";
		
		removeSuggestion();
		
		return "createDiscountDialog";
	}
	
	/**
	 * 新增折扣
	 * @return
	 * @throws Exception
	 */
	public String createDiscountManager() throws Exception{
		
		final String someDetail = request.getParameter("someDetail");
		
		try{
		
			new MyTransationTemplate() {
				
				@Override
				protected void doExecuteCallback() throws Exception {
					
					CommonPojoUtils.initPojoCommonFiled(unitDiscount);
					unitDiscount.setDiscountName(DiscountManagerUtils.getDiscountName(someDetail));
					unitDiscountServices.addUnitDiscount(unitDiscount);
					
					if(!CommonUtils.isStrEmpty(someDetail)){
						
						List<UnitDiscountDetail> tmpList = DiscountManagerUtils.initForAddDiscountDetail(someDetail, unitDiscount.getId());
						for(UnitDiscountDetail detail : tmpList){
							
							discountDetailServices.addUnitDiscountDetail(detail);
						}
						
					}
					
					unitDiscountId = unitDiscount.getId() + "";
					setSuggestion(CommonUtils.SUCCSUGG);
					
				}
			}.execute();
		
		}catch(Exception e){
			e.printStackTrace();
			
			unitDiscountId = "";
			setSuggestion(CommonUtils.FAILSUGG);
		}
		
		init(unitDiscount.getUnitId());
		initHistroy();
		
		return "createDiscountManager";
	}
	
	/**
	 * 跳到修改折扣的界面
	 * @return
	 * @throws Exception
	 */
	public String forUpdateDiscountDialog() throws Exception{
		
		unitDiscountId = request.getParameter("unitDiscountId");
		
		unitDiscount = unitDiscountServices.findUnitDiscountById(Integer.parseInt(unitDiscountId));
		
		url = "./saleunit_new/appoint/guangzhou/initHistoryDiscountDetail.action?histroyDiscountId=" + unitDiscountId;
		
		init(0);
		
		removeSuggestion();
		
		return "forUpdateDiscountDialog";
	}
	
	/**
	 * 修改折扣
	 * @return
	 * @throws Exception
	 */
	public String updateDiscountManager() throws Exception{
		
		try{
			
			new MyTransationTemplate() {
				
				@Override
				protected void doExecuteCallback() throws Exception {
					
					unitDiscountId = unitDiscount.getId() + "";
					UnitDiscount oldUnitDiscount = unitDiscountServices.findUnitDiscountById(unitDiscount.getId());
					CommonPojoUtils.initPojoForUpdate(oldUnitDiscount, unitDiscount);
					
					unitDiscountServices.updateUnitDiscount(unitDiscount);
					
					discountDetailServices.deleteUnitDiscountDetailByDiscountId(unitDiscount.getId());
					
					String someDetail = request.getParameter("someDetail");
					
					if(!CommonUtils.isStrEmpty(someDetail)){
						
						List<UnitDiscountDetail> tmpList = DiscountManagerUtils.initForAddDiscountDetail(someDetail, unitDiscount.getId());
						for(UnitDiscountDetail detail : tmpList){
							
							discountDetailServices.addUnitDiscountDetail(detail);
						}
						
					}
					
					setSuggestion(CommonUtils.SUCCSUGG);
					updateLoadClose = "true";
					
				}
			}.execute();
			
		}catch(Exception e){
			
			setSuggestion(CommonUtils.FAILSUGG);
			updateLoadClose = "false";
		}
		
		url = "./saleunit_new/appoint/guangzhou/initHistoryDiscountDetail.action?histroyDiscountId=" + unitDiscount.getId();
		
		init(0);
		
		return "updateDiscountManager";
	}
	
	/**
	 * 使用历史折扣
	 * @return
	 * @throws Exception
	 */
	public String applyHistoryDiscountManager() throws Exception{
		
		selectUnitDiscountId = request.getParameter("histroyDiscountId");
		int histroyDiscountId = Integer.parseInt(selectUnitDiscountId);
		int unitId = Integer.parseInt(request.getParameter("unitId")); //为要设定的单元id
		
		unitDiscount = unitDiscountServices.findUnitDiscountById(histroyDiscountId);
		
		url = "./saleunit_new/appoint/guangzhou/initHistoryDiscountDetail.action?histroyDiscountId=" + histroyDiscountId;
		
		init(unitId);
		initHistroy();
		
		return "applyHistoryDiscountManager";
	}
	
	/**
	 * 初始化历史折扣详细列表
	 * @return
	 * @throws Exception
	 */
	public String initHistoryDiscountDetail() throws Exception{
		
		int histroyDiscountId = Integer.parseInt(request.getParameter("histroyDiscountId"));

		detailList = discountDetailServices.findDetailByDiscountId(histroyDiscountId);
		
		String out = DiscountManagerUtils.discountDetailListJson(detailList);
		
		CustomerUtils.writeResponse(response, out);
		
		return null;
	}
	
	/**
	 * 根据折扣id获取其详细列表的百分比乘积格式,98.00*97.00
	 * @return
	 * @throws Exception
	 */
	public String getDiscountDetailShowByDiscountId() throws Exception{
		
		Map<String, String> map = DiscountManagerUtils.getDiscountDetailShowAndMultiplyByDiscountId(request);
		
		CustomerUtils.writeResponse(response, CommonUtils.getMapJson(map));
		
		return null;
	}
	
	////
	
	
	private void initMainIdAndConfirmType(){
		
		mainId = request.getParameter("mainId");
		confirmType = request.getParameter("confirmType");
		
		if(!CommonUtils.isIntString(mainId)){
			mainId = "0";
		}
		
		if(!CommonUtils.isIntString(confirmType)){
			confirmType = "0";
		}
	}
	
	private void init(int unitId){
		
		//查看修改的时候unitId为0,
		if(unitId > 0){
			unit = unitServices.findPropertyUnitById(unitId);
		}
		
		selTypes = DescUtils.getInitSelForGuangZhou(selTypes, EnumCodeTypeName.SALEUNIT_DISCOUNT_TYPE);
		types = CommonUtils.getMapJsonSetUpKeyAndValueName(selTypes, "typeId", "name");
		
		selComputeWay = ContUnitComputeWay.getWayMap();
		
		initMainIdAndConfirmType();
		
	}
	
	private void initHistroy(){
		
		List<UnitDiscount> list = unitDiscountServices.findUnitDiscount(new UnitDiscountCond());
		selHistroyDiscount = DiscountManagerUtils.getSelectMap(list);
		
	}
	
	////
	
	private String types; //类型
	private LinkedHashMap selTypes;
	
	private LinkedHashMap<String, String> selComputeWay;
	
	private UnitDiscount unitDiscount;
	private List<UnitDiscountDetail> detailList;
	
	private String confirmType; //认购或合同
	
	private String updateLoadClose; //用于update弹出框的关闭
	private String unitDiscountId; //主要用于关闭弹出框
	private String selectUnitDiscountId; //用于选中历史折扣下拉框
	
	private LinkedHashMap<Integer, String> selHistroyDiscount; //历史折扣下拉框
	private String url; //折扣历史表的url,用于加载折扣历史表的数据
	
	private PropertyUnit unit;
	
	private String mainId; //如果在查看认购或签约的时候,新建折扣,那该字段有用,默认为0
	
	public void setMainId(String mainId) {
		this.mainId = mainId;
	}
	
	public String getMainId() {
		return mainId;
	}
	
	public void setUpdateLoadClose(String updateLoadClose) {
		this.updateLoadClose = updateLoadClose;
	}
	
	public String getUpdateLoadClose() {
		return updateLoadClose;
	}
	
	public void setSelectUnitDiscountId(String selectUnitDiscountId) {
		this.selectUnitDiscountId = selectUnitDiscountId;
	}
	
	public String getSelectUnitDiscountId() {
		return selectUnitDiscountId;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setDetailList(List<UnitDiscountDetail> detailList) {
		this.detailList = detailList;
	}
	
	public List<UnitDiscountDetail> getDetailList() {
		return detailList;
	}
	
	public void setSelHistroyDiscount(
			LinkedHashMap<Integer, String> selHistroyDiscount) {
		this.selHistroyDiscount = selHistroyDiscount;
	}
	
	public LinkedHashMap<Integer, String> getSelHistroyDiscount() {
		return selHistroyDiscount;
	}
	
	public void setUnit(PropertyUnit unit) {
		this.unit = unit;
	}
	
	public PropertyUnit getUnit() {
		return unit;
	}
	
	public void setUnitDiscountId(String unitDiscountId) {
		this.unitDiscountId = unitDiscountId;
	}
	
	public String getUnitDiscountId() {
		return unitDiscountId;
	}
	
	public void setConfirmType(String confirmType) {
		this.confirmType = confirmType;
	}
	
	public String getConfirmType() {
		return confirmType;
	}
	
	public void setSelComputeWay(LinkedHashMap<String, String> selComputeWay) {
		this.selComputeWay = selComputeWay;
	}
	
	public LinkedHashMap<String, String> getSelComputeWay() {
		return selComputeWay;
	}
	
	public void setUnitDiscount(UnitDiscount unitDiscount) {
		this.unitDiscount = unitDiscount;
	}
	
	public UnitDiscount getUnitDiscount() {
		return unitDiscount;
	}
	
	public void setSelTypes(LinkedHashMap selTypes) {
		this.selTypes = selTypes;
	}
	
	public LinkedHashMap getSelTypes() {
		return selTypes;
	}
	
	public void setTypes(String types) {
		this.types = types;
	}
	
	public String getTypes() {
		return types;
	}
	
	
	

}
